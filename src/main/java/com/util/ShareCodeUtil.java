package com.util;

import java.util.Random;

/**
 * 邀请码生成器，算法原理：<br/>
 * 1) 获取id: 1127738 <br/>
 * 2) 使用自定义进制转为：gpm6 <br/>
 * 3) 转为字符串，并在后面加'o'字符：gpm6o <br/>
 * 4）在后面随机产生若干个随机数字字符：gpm6o7 <br/>
 * 转为自定义进制后就不会出现o这个字符，然后在后面加个'o'，这样就能确定唯一性。最后在后面产生一些随机字符进行补全。<br/>
 */
public class ShareCodeUtil {

    /**
     * 自定义进制(0,1没有加入,容易与o,l混淆)
     */
    private static final char[] r = new char[]{'e', 'q', 'w', '8', 'a', 's', '2', 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'i', 'k', '3', 'm', 'j', 'u', 'f', 'r', '4', 'v', 'y', 'l', 't', 'n', '6', 'b', 'g', 'h'};

    /**
     * (不能与自定义进制有重复)
     */
    private static final char b = 'o';

    /**
     * 进制长度
     */
    private static final int binLen = r.length;

    /**
     * 序列最小长度
     */
    private static final int s = 6;

    /**
     * 在id不大于999999999前，生成的随机码为六位
     *
     * @param id ID
     * @return 随机码
     */
    public static String toShareCode(long id) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / binLen) > 0) {
            int ind = (int) (id % binLen);
            // System.out.println(num + "-->" + ind);
            buf[--charPos] = r[ind];
            id /= binLen;
        }
        buf[--charPos] = r[(int) (id % binLen)];
        // System.out.println(num + "-->" + num % binLen);
        String code = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全,使用常量b中的值进行分隔，这样就能区分出属于id的部分和不属于id的部分
        if (code.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            Random rnd = new Random();
            for (int i = 1; i < s - code.length(); i++) {
                sb.append(r[rnd.nextInt(binLen)]);
            }
            code += sb.toString();
        }
        return code;
    }

    public static long toId(String code) {
        char chs[] = code.toCharArray();
        long id = 0L;
        for (int i = 0; i < chs.length; i++) {
            int ind = 0;
            for (int j = 0; j < binLen; j++) {
                if (chs[i] == r[j]) {
                    ind = j;
                    break;
                }
            }
            if (chs[i] == b) {//找到结束符，id的长度就确定了。没必要再往下循环了
                break;
            }
            if (i > 0) {
                id = id * binLen + ind;
            } else {
                id = ind;
            }
            // System.out.println(ind + "-->" + res);
        }
        return id;
    }
}