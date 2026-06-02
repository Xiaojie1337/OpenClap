/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Nullable;

final class StackWalkUtil {
    private StackWalkUtil() {
    }

    static StackTraceElement[] stackWalkArray(Object[] param0) {
        return (StackTraceElement[])param0;
    }

    static Object stackWalkGetMethod(Class<?> param0) {
        StackTraceElement[] v1 = Thread.currentThread().getStackTrace();
        for (int v2 = 3; v2 < v1.length; ++v2) {
            if (v1[v2].getClassName().startsWith(param0.getName())) continue;
            return v1[v2];
        }
        throw new IllegalStateException();
    }

    private static boolean isSameMethod(StackTraceElement param0, StackTraceElement param1) {
        return StackWalkUtil.isSameMethod(param0, param1, param1.getMethodName());
    }

    private static boolean isSameMethod(StackTraceElement param0, StackTraceElement param1, String param2) {
        return param0.getMethodName().equals(param2) && param0.getClassName().equals(param1.getClassName()) && Objects.equals(param0.getFileName(), param1.getFileName());
    }

    private static boolean isAutoCloseable(StackTraceElement param0, StackTraceElement param1) {
        if (StackWalkUtil.isSameMethod(param0, param1, "$closeResource")) {
            return true;
        }
        return "closeFinally".equals(param0.getMethodName()) && "AutoCloseable.kt".equals(param0.getFileName());
    }

    @Nullable
    static Object stackWalkCheckPop(Class<?> param0, Object param1) {
        StackTraceElement[] v2 = Thread.currentThread().getStackTrace();
        for (int v3 = 3; v3 < v2.length; ++v3) {
            StackTraceElement v4 = v2[v3];
            if (v4.getClassName().startsWith(param0.getName())) {
                continue;
            }
            StackTraceElement v5 = (StackTraceElement)param1;
            if (StackWalkUtil.isSameMethod(v4, v5)) {
                return null;
            }
            if (StackWalkUtil.isAutoCloseable(v4, v5) && v3 + 1 < v2.length) {
                v4 = v2[v3 + 1];
                if (StackWalkUtil.isSameMethod(v5, v2[v3 + 1])) {
                    return null;
                }
            }
            return v4;
        }
        throw new IllegalStateException();
    }

    static Object[] stackWalkGetTrace() {
        int v1;
        StackTraceElement[] v0 = Thread.currentThread().getStackTrace();
        for (v1 = 3; v1 < v0.length && v0[v1].getClassName().startsWith("org.lwjgl.system.Memory"); ++v1) {
        }
        return Arrays.copyOfRange(v0, v1, v0.length);
    }
}

