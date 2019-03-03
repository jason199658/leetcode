package cn.jason.DynmaicProgram;

import java.util.List;

import static java.lang.Math.*;
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Integer res = 0;
        Integer n = price.size();
        // System.out.println(n);
        // return n;

        for(int i = 0; i < n; i++) {
            res += price.get(i) * needs.get(i);
        }

        for(List<Integer> offer:special) {
            // System.out.println(offer);
            boolean flag = true;
            for(int i = 0; i < n;i++) {
                if(needs.get(i)<offer.get(i)) {
                    flag = false;
                }
                needs.set(i, needs.get(i)-offer.get(i));
            }
            if(flag) {
                res = min(res, shoppingOffers(price, special, needs) + offer.get(n));
            }

            for(int i = 0; i < n;i++) {
                needs.set(i, needs.get(i)+offer.get(i));
            }
        }
        return res;
    }
}