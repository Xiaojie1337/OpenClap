/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.FunctionProviderLocal;

public final class Checks {
    public static final boolean CHECKS = Configuration.DISABLE_CHECKS.get(false) == false;
    public static final boolean DEBUG = Configuration.DEBUG.get(false);
    public static final boolean DEBUG_FUNCTIONS = Configuration.DEBUG_FUNCTIONS.get(false);

    private Checks() {
    }

    public static int lengthSafe(@Nullable short[] param0) {
        return param0 == null ? 0 : param0.length;
    }

    public static int lengthSafe(@Nullable int[] param0) {
        return param0 == null ? 0 : param0.length;
    }

    public static int lengthSafe(@Nullable long[] param0) {
        return param0 == null ? 0 : param0.length;
    }

    public static int lengthSafe(@Nullable float[] param0) {
        return param0 == null ? 0 : param0.length;
    }

    public static int lengthSafe(@Nullable double[] param0) {
        return param0 == null ? 0 : param0.length;
    }

    public static int remainingSafe(@Nullable Buffer param0) {
        return param0 == null ? 0 : param0.remaining();
    }

    public static int remainingSafe(@Nullable CustomBuffer<?> param0) {
        return param0 == null ? 0 : param0.remaining();
    }

    public static boolean checkFunctions(long ... param0) {
        for (long v4 : param0) {
            if (v4 != 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean checkFunctions(FunctionProvider param0, PointerBuffer param1, int[] param2, String ... param3) {
        boolean v4 = true;
        for (int v5 = 0; v5 < param2.length; ++v5) {
            int v6 = param2[v5];
            if (v6 < 0 || param1.get(v6) != 0L) continue;
            long v7 = param0.getFunctionAddress(param3[v5]);
            if (v7 == 0L) {
                v4 = false;
                continue;
            }
            param1.put(v6, v7);
        }
        return v4;
    }

    public static boolean checkFunctions(FunctionProviderLocal param0, long param1, PointerBuffer param3, int[] param4, String ... param5) {
        boolean v6 = true;
        for (int v7 = 0; v7 < param4.length; ++v7) {
            int v8 = param4[v7];
            if (v8 < 0 || param3.get(v8) != 0L) continue;
            long v9 = param0.getFunctionAddress(param1, param5[v7]);
            if (v9 != 0L) {
                param3.put(v8, v9);
                continue;
            }
            v6 = false;
        }
        return v6;
    }

    public static boolean checkFunctions(FunctionProvider param0, long[] param1, int[] param2, String ... param3) {
        boolean v4 = true;
        for (int v5 = 0; v5 < param2.length; ++v5) {
            int v6 = param2[v5];
            if (v6 < 0 || param1[v6] != 0L) continue;
            long v7 = param0.getFunctionAddress(param3[v5]);
            if (v7 == 0L) {
                v4 = false;
                continue;
            }
            param1[v6] = v7;
        }
        return v4;
    }

    public static boolean reportMissing(String param0, String param1) {
        APIUtil.apiLog("[" + param0 + "] " + param1 + " was reported as available but an entry point is missing.");
        return false;
    }

    public static long check(long param0) {
        if (param0 == 0L) {
            throw new NullPointerException();
        }
        return param0;
    }

    private static void assertNT(boolean param0) {
        if (!param0) {
            throw new IllegalArgumentException("Missing termination");
        }
    }

    public static void checkNT(int[] param0) {
        Checks.checkBuffer(param0.length, 1);
        Checks.assertNT(param0[param0.length - 1] == 0);
    }

    public static void checkNT(int[] param0, int param1) {
        Checks.checkBuffer(param0.length, 1);
        Checks.assertNT(param0[param0.length - 1] == param1);
    }

    public static void checkNT(long[] param0) {
        Checks.checkBuffer(param0.length, 1);
        Checks.assertNT(param0[param0.length - 1] == 0L);
    }

    public static void checkNT(float[] param0) {
        Checks.checkBuffer(param0.length, 1);
        Checks.assertNT(param0[param0.length - 1] == 0.0f);
    }

    public static void checkNT1(ByteBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == 0);
    }

    public static void checkNT2(ByteBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 2);
        Checks.assertNT(param0.get(param0.limit() - 2) == 0);
    }

    public static void checkNT(IntBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == 0);
    }

    public static void checkNT(IntBuffer param0, int param1) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == param1);
    }

    public static void checkNT(LongBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == 0L);
    }

    public static void checkNT(FloatBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == 0.0f);
    }

    public static void checkNT(PointerBuffer param0) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == 0L);
    }

    public static void checkNT(PointerBuffer param0, long param1) {
        Checks.checkBuffer(param0.remaining(), 1);
        Checks.assertNT(param0.get(param0.limit() - 1) == param1);
    }

    public static void checkNTSafe(@Nullable int[] param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, 1);
            Checks.assertNT(param0[param0.length - 1] == 0);
        }
    }

    public static void checkNTSafe(@Nullable int[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, 1);
            Checks.assertNT(param0[param0.length - 1] == param1);
        }
    }

    public static void checkNTSafe(@Nullable long[] param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, 1);
            Checks.assertNT(param0[param0.length - 1] == 0L);
        }
    }

    public static void checkNTSafe(@Nullable float[] param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, 1);
            Checks.assertNT(param0[param0.length - 1] == 0.0f);
        }
    }

    public static void checkNT1Safe(@Nullable ByteBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == 0);
        }
    }

    public static void checkNT2Safe(@Nullable ByteBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 2);
            Checks.assertNT(param0.get(param0.limit() - 2) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == param1);
        }
    }

    public static void checkNTSafe(@Nullable LongBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable FloatBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == 0.0f);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer param0) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer param0, long param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), 1);
            Checks.assertNT(param0.get(param0.limit() - 1) == param1);
        }
    }

    private static void checkBuffer(int param0, int param1) {
        if (param0 < param1) {
            Checks.throwIAE(param0, param1);
        }
    }

    public static void check(byte[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(short[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(int[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(long[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(float[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(double[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    public static void check(CharSequence param0, int param1) {
        Checks.checkBuffer(param0.length(), param1);
    }

    public static void check(Buffer param0, int param1) {
        Checks.checkBuffer(param0.remaining(), param1);
    }

    public static void check(Buffer param0, long param1) {
        Checks.checkBuffer(param0.remaining(), (int)param1);
    }

    public static void check(CustomBuffer<?> param0, int param1) {
        Checks.checkBuffer(param0.remaining(), param1);
    }

    public static void check(CustomBuffer<?> param0, long param1) {
        Checks.checkBuffer(param0.remaining(), (int)param1);
    }

    public static void checkSafe(@Nullable short[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, param1);
        }
    }

    public static void checkSafe(@Nullable int[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, param1);
        }
    }

    public static void checkSafe(@Nullable long[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, param1);
        }
    }

    public static void checkSafe(@Nullable float[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, param1);
        }
    }

    public static void checkSafe(@Nullable double[] param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.length, param1);
        }
    }

    public static void checkSafe(@Nullable Buffer param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), param1);
        }
    }

    public static void checkSafe(@Nullable Buffer param0, long param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), (int)param1);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> param0, int param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), param1);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> param0, long param1) {
        if (param0 != null) {
            Checks.checkBuffer(param0.remaining(), (int)param1);
        }
    }

    public static void check(Object[] param0, int param1) {
        Checks.checkBuffer(param0.length, param1);
    }

    private static void checkBufferGT(int param0, int param1) {
        if (param1 < param0) {
            Checks.throwIAEGT(param0, param1);
        }
    }

    public static void checkGT(Buffer param0, int param1) {
        Checks.checkBufferGT(param0.remaining(), param1);
    }

    public static void checkGT(CustomBuffer<?> param0, int param1) {
        Checks.checkBufferGT(param0.remaining(), param1);
    }

    public static long check(int param0, int param1) {
        if (CHECKS) {
            CheckIntrinsics.checkIndex(param0, param1);
        }
        return Integer.toUnsignedLong(param0);
    }

    private static void throwIAE(int param0, int param1) {
        throw new IllegalArgumentException("Number of remaining elements is " + param0 + ", must be at least " + param1);
    }

    private static void throwIAEGT(int param0, int param1) {
        throw new IllegalArgumentException("Number of remaining buffer elements is " + param0 + ", must be at most " + param1);
    }

    static {
        if (DEBUG_FUNCTIONS && !DEBUG) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] The DEBUG_FUNCTIONS option requires DEBUG to produce output.");
        }
    }
}

