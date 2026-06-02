/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

public final class MathUtil {
    private MathUtil() {
    }

    public static boolean mathIsPoT(int param0) {
        return Integer.bitCount(param0) == 1;
    }

    public static int mathRoundPoT(int param0) {
        return 1 << 32 - Integer.numberOfLeadingZeros(param0 - 1);
    }

    public static boolean mathHasZeroByte(int param0) {
        return (param0 - 0x1010101 & ~param0 & 0x80808080) != 0;
    }

    public static boolean mathHasZeroByte(long param0) {
        return (param0 - 0x101010101010101L & (param0 ^ 0xFFFFFFFFFFFFFFFFL) & 0x8080808080808080L) != 0L;
    }

    public static boolean mathHasZeroShort(int param0) {
        return (param0 - 65537 & ~param0 & 0x80008000) != 0;
    }

    public static boolean mathHasZeroShort(long param0) {
        return (param0 - 0x1000100010001L & (param0 ^ 0xFFFFFFFFFFFFFFFFL) & 0x8000800080008000L) != 0L;
    }

    public static long mathMultiplyHighU64(long param0, long param2) {
        long v4 = param0 & 0xFFFFFFFFL;
        long v6 = param0 >>> 32;
        long v8 = param2 & 0xFFFFFFFFL;
        long v10 = param2 >>> 32;
        long v12 = v6 * v8 + (v4 * v8 >>> 32);
        return v6 * v10 + (v12 >>> 32) + ((v12 & 0xFFFFFFFFL) + v4 * v10 >>> 32);
    }

    public static long mathMultiplyHighS64(long param0, long param2) {
        long v4 = param0 & 0xFFFFFFFFL;
        long v6 = param0 >> 32;
        long v8 = param2 & 0xFFFFFFFFL;
        long v10 = param2 >> 32;
        long v12 = v6 * v8 + (v4 * v8 >>> 32);
        return v6 * v10 + (v12 >> 32) + ((v12 & 0xFFFFFFFFL) + v4 * v10 >> 32);
    }

    public static long mathDivideUnsigned(long param0, long param2) {
        if (0L <= param2) {
            return 0L <= param0 ? param0 / param2 : MathUtil.udivdi3(param0, param2);
        }
        return Long.compareUnsigned(param0, param2) < 0 ? 0L : 1L;
    }

    public static long mathRemainderUnsigned(long param0, long param2) {
        if (0L < param0 && 0L < param2) {
            return param0 % param2;
        }
        return Long.compareUnsigned(param0, param2) < 0 ? param0 : param0 - param2 * MathUtil.udivdi3(param0, param2);
    }

    private static long udivdi3(long param0, long param2) {
        if (param2 >>> 32 == 0L) {
            if (param0 >>> 32 < param2) {
                long v4 = (param0 >>> 1) / param2 << Long.numberOfLeadingZeros(param2) >>> 31;
                if (param0 - v4 * param2 >= param2) {
                    ++v4;
                }
                return v4;
            }
            long v4 = param0 >>> 32;
            long v6 = v4 / param2;
            long v8 = (v4 - v6 * param2 << 32 | param0 & 0xFFFFFFFFL) / param2;
            return v6 << 32 | v8;
        }
        int v10 = Long.numberOfLeadingZeros(param2);
        long v11 = (param0 >>> 1) / (param2 << v10 >>> 32) << v10 >>> 31;
        if (v11 != 0L) {
            --v11;
        }
        if (Long.compareUnsigned(param0 - v11 * param2, param2) >= 0) {
            ++v11;
        }
        return v11;
    }
}

