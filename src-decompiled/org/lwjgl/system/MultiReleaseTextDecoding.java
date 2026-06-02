/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.charset.StandardCharsets;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;

final class MultiReleaseTextDecoding {
    private MultiReleaseTextDecoding() {
    }

    static String decodeUTF8(long param0, int param2) {
        if (param2 <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            byte[] v3 = param2 <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[param2];
            MemoryUtil.memByteBuffer(param0, param2).get(v3, 0, param2);
            return new String(v3, 0, param2, StandardCharsets.UTF_8);
        }
        char[] v3 = param2 <= MemoryUtil.ARRAY_TLC_SIZE ? MemoryUtil.ARRAY_TLC_CHAR.get() : new char[param2];
        int v4 = 0;
        int v5 = 0;
        while (v5 < param2) {
            char v7;
            int v6;
            if ((v6 = MemoryUtil.UNSAFE.getByte(null, param0 + (long)v5++) & 0xFF) < 128) {
                v7 = (char)v6;
            } else {
                int v8 = MemoryUtil.UNSAFE.getByte(null, param0 + (long)v5++) & 0x3F;
                if ((v6 & 0xE0) == 192) {
                    v7 = (char)((v6 & 0x1F) << 6 | v8);
                } else {
                    int v9 = MemoryUtil.UNSAFE.getByte(null, param0 + (long)v5++) & 0x3F;
                    if ((v6 & 0xF0) == 224) {
                        v7 = (char)((v6 & 0xF) << 12 | v8 << 6 | v9);
                    } else {
                        int v10 = MemoryUtil.UNSAFE.getByte(null, param0 + (long)v5++) & 0x3F;
                        int v11 = (v6 & 7) << 18 | v8 << 12 | v9 << 6 | v10;
                        if (v4 < param2) {
                            v3[v4++] = (char)((v11 >>> 10) + 55232);
                        }
                        v7 = (char)((v11 & 0x3FF) + 56320);
                    }
                }
            }
            if (v4 >= param2) continue;
            v3[v4++] = v7;
        }
        return new String(v3, 0, Math.min(v4, param2));
    }
}

