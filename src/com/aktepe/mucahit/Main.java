package com.aktepe.mucahit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) { }

    //region SORU 1
    int roundNumber = 0;
    int initialChip = 1;

    int soru1(int N, int K) {
        while (N != initialChip) {
            if (N % 2 == 0 && K > 0) {
                N /= 2;
                K -= 1;
                roundNumber++;
            } else {
                N--;
                roundNumber++;
            }
        }

        return roundNumber;
    }
    //endregion

    //region SORU 2
    int fibonacci(int N) {
        if (N == 0)
            return 0;
        else if (N == 1)
            return 1;
        else
            return fibonacci(N - 1) + fibonacci(N - 2);
    }

    int soru2(int N) {
        int lastSixDigits = fibonacci(N) % 1000000;
        return lastSixDigits;
    }
    //endregion

    //region SORU 3
    int[] soru3(int[] A) {
        if (!(A.length > 0))
            return A;
        int decimal = toDecimal(A);
        return toBinary((decimal + 1) / 2);
    }

    int toDecimal(int[] B) {
        int sum = 0;
        for (int i = 0; i < B.length; i++) {
            sum += B[i] * Math.pow(-2, i);
        }
        return sum;
    }

    int[] toBinary(int X) {
        ArrayList temp = new ArrayList<>();
        while (X != 1) {
            if (X < 0 && X % -2 != 0) {
                temp.add(1);
                X += -1;
                X /= -2;
                continue;
            }
            int remain = X % -2;
            temp.add(remain);
            X /= -2;
        }

        temp.add(1);

        int[] binary = new int[temp.size()];
        Iterator<Integer> iterator = temp.iterator();
        for (int i = 0; i < binary.length; i++) {
            binary[i] = iterator.next();
        }

        return binary;
    }
    //endregion

    //region SORU 4
    String soru4(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
    //endregion
}
