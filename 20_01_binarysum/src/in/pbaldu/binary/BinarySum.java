package in.pbaldu.binary;

import java.util.ArrayList;
import java.util.List;

public class BinarySum {

    public List<Integer> toBinary(int number) {
        List<Integer> l = new ArrayList<>();

        for (int p = 0; number >= Math.pow(2, p); p++) {
            l.add((number & (int) Math.pow(2, p)) >> p);
        }

        return l;
    }

    public int toDec(List<Integer> list) {
        int result = 0;

        for (int p = 0; p < list.size(); p++) {
            result += list.get(p).intValue() * (int) Math.pow(2, p);
        }

        return result;
    }

    public int sum(int a, int b) {
        List<Integer> ba = toBinary(a);
        List<Integer> bb = toBinary(b);
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        int sz = Integer.max(ba.size(), bb.size());

        for(int p = 0; p < sz; p++) {
            int bitA = p < ba.size() ? ba.get(p).intValue() : 0;
            int bitB = p < bb.size() ? bb.get(p).intValue() : 0;
            int bitR = 0;

            if(bitA == 0 && bitB == 0) {
                bitR = carry;
                carry = 0;
            } else if(bitA == 1 && bitB == 1) {
                bitR = carry;
                carry = 1;
            } else if(carry == 1) {
                bitR = 0;
                carry = 1;
            } else {
                bitR = 1;
                carry = 0;
            }
            result.add(bitR);
        }

        if(carry == 1) {
            result.add(1);
        }

        return toDec(result);
    }

    public static void main(String... args) {
        BinarySum bs = new BinarySum();

//        System.out.println(bs.sum(21, 35));
//        System.out.println(bs.sum(15, 22));
        System.out.println(bs.sum(50, 42));
    }
}
