package chapter03basical_program_structure;

import utils.MyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2018/3/20 01:45
 * Project:CoreJava
 */
public class ZhihuTest {
    public static void main(String[] args) {
        HashMap<Integer, List<Match>> vMapSun = new HashMap<>();
        HashMap<Integer, List<Match>> vMapPang = new HashMap<>();

        for (int vI = 2; vI < 100; vI++) {
            for (int vJ = 2; vI != vJ && vJ < 100; vJ++) {
                Match vMatch = new Match(vI, vJ);
                insertMatch(vMapSun, vMatch, true);
                insertMatch(vMapPang, vMatch, false);
            }
        }
        ArrayList<Integer> vIntegers = new ArrayList<>();
        for (Integer vInteger : vMapPang.keySet()) {
            List<Match> vMatches = vMapPang.get(vInteger);
            if (vMatches.size() > 1) {
                boolean flag = true;
                for (Match vMatch : vMatches) {
                    if (vMapSun.get(vMatch.getPro()).size() < 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    vIntegers.add(vInteger);
                    System.out.println(vMatches);
                }
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(MyUtils.getCurrentTime() + "vIntegers = " + vIntegers);

        for (Integer vInteger : vMapSun.keySet()) {
            List<Match> vMatches = vMapSun.get(vInteger);
            if (vMatches.size() == 2 ) {
                for (Match vMatch : vMatches) {
                    int vSum = vMatch.getSum();
                    if (vIntegers.contains(vSum)) {
                        System.out.println(MyUtils.getCurrentTime() + "vMatch = " + vMatch);
                    }
                }
            }
        }
        System.out.println(MyUtils.getCurrentTime() +"========================================");
    }

    private static void insertMatch(HashMap<Integer, List<Match>> pMap, Match pMatch, boolean isSun) {
        int vKey = isSun ? pMatch.getPro() : pMatch.getSum();
        if (!pMap.containsKey(vKey)) {
            pMap.put(vKey, new ArrayList<>());
        }
        pMap.get(vKey).add(pMatch);
    }
}

class Match {
    private final int mIntI;
    private final int mIntJ;
    private final int mPro;
    private final int mSum;

    Match(int pIntI, int pIntJ) {
        mIntI = pIntI;
        mIntJ = pIntJ;
        mPro = mIntI * mIntJ;
        mSum = mIntI + mIntJ;
    }

    @Override
    public String toString() {
        return "Match{" +
                "mIntI=" + mIntI +
                ", mIntJ=" + mIntJ +
                ", mPro=" + mPro +
                ", mSum=" + mSum +
                '}';
    }

    int getPro() {
        return mPro;
    }

    int getSum() {
        return mSum;
    }
}
