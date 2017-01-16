package com.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tang.cheng on 2017/1/16.
 */
public class ShareCodeUtilTest {

    @Test
    public void toShareCode() {
        Long id = Math.abs(ThreadLocalRandom.current().nextLong());
        System.out.println(id);
        Map<String, Long> codeToId = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String shareCode = ShareCodeUtil.toShareCode(id);
            Long times = codeToId.get(shareCode);
            if (times == null) {
                codeToId.put(shareCode, 1L);
            } else {
                codeToId.put(shareCode, ++times);
            }

        }
        System.out.println(codeToId);
        assertThat(1, is(codeToId.size()));
    }

    @Test
    public void toShareCode6() {
//        Long id = 1234567891L;
        Long id = 999999999L;
        System.out.println(id);
        String shareCode = ShareCodeUtil.toShareCode(id);
        System.out.println(shareCode);
        assertThat(6, is(shareCode.length()));
    }

    @Test
    public void toId() {
        Long id = Math.abs(ThreadLocalRandom.current().nextLong());

        String shareCode = ShareCodeUtil.toShareCode(id);
        System.out.println(shareCode);
        Map<Long, Long> idToCode = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            long id2 = ShareCodeUtil.toId(shareCode);
            Long times = idToCode.get(id2);
            if (times == null) {
                idToCode.put(id2, 1L);
            } else {
                idToCode.put(id2, ++times);
            }
        }
        System.out.println(idToCode);
        assertThat(idToCode.keySet().stream().findFirst().orElse(-1L), is(id));
        assertThat(1, is(idToCode.size()));
    }

}