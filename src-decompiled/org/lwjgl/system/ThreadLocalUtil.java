/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;

public final class ThreadLocalUtil {
    private static final long JNI_NATIVE_INTERFACE;
    private static final int JNI_NATIVE_INTERFACE_FUNCTION_COUNT;
    private static final long FUNCTION_MISSING_ABORT;
    private static long FUNCTION_MISSING_ABORT_TABLE;
    private static final int CAPABILITIES_OFFSET;

    private ThreadLocalUtil() {
    }

    private static native long getThreadJNIEnv();

    private static native long getFunctionMissingAbort();

    private static native long nsetupEnvData(int var0);

    public static long setupEnvData() {
        return ThreadLocalUtil.nsetupEnvData(JNI_NATIVE_INTERFACE_FUNCTION_COUNT);
    }

    public static void setCapabilities(long param0) {
        long v2 = ThreadLocalUtil.getThreadJNIEnv();
        long v4 = MemoryUtil.memGetAddress(v2);
        if (param0 == 0L) {
            if (v4 != JNI_NATIVE_INTERFACE) {
                MemoryUtil.memPutAddress(v4 + (long)CAPABILITIES_OFFSET, FUNCTION_MISSING_ABORT_TABLE);
            }
        } else {
            if (v4 == JNI_NATIVE_INTERFACE) {
                v4 = MemoryUtil.memGetAddress(v2);
            }
            MemoryUtil.memPutAddress(v4 + (long)CAPABILITIES_OFFSET, param0);
        }
    }

    public static void setFunctionMissingAddresses(int param0) {
        long v1 = MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE);
        long v3 = JNI_NATIVE_INTERFACE + (long)CAPABILITIES_OFFSET;
        long v5 = MemoryUtil.memGetAddress(v3);
        if (param0 == 0) {
            if (v5 != v1) {
                FUNCTION_MISSING_ABORT_TABLE = 0L;
                MemoryUtil.getAllocator().free(v5);
                MemoryUtil.memPutAddress(v3, 0L);
            }
        } else {
            if (v5 != v1) {
                throw new IllegalStateException("setFunctionMissingAddresses has been called already");
            }
            if (v5 != 0L) {
                return;
            }
            FUNCTION_MISSING_ABORT_TABLE = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(param0) * (long)Pointer.POINTER_SIZE);
            for (int v7 = 0; v7 < param0; ++v7) {
                MemoryUtil.memPutAddress(FUNCTION_MISSING_ABORT_TABLE + Integer.toUnsignedLong(v7) * (long)Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
            }
            MemoryUtil.memPutAddress(v3, FUNCTION_MISSING_ABORT_TABLE);
        }
    }

    public static PointerBuffer setupAddressBuffer(PointerBuffer param0) {
        for (int v1 = param0.position(); v1 < param0.limit(); ++v1) {
            if (param0.get(v1) != 0L) continue;
            param0.put(v1, FUNCTION_MISSING_ABORT);
        }
        return param0;
    }

    public static boolean areCapabilitiesDifferent(PointerBuffer param0, PointerBuffer param1) {
        for (int v2 = 0; v2 < param0.remaining(); ++v2) {
            if (param0.get(v2) == param1.get(v2) || param1.get(v2) == 0L) continue;
            return true;
        }
        return false;
    }

    static {
        int v2;
        int v1;
        JNI_NATIVE_INTERFACE = MemoryUtil.memGetAddress(ThreadLocalUtil.getThreadJNIEnv());
        FUNCTION_MISSING_ABORT = ThreadLocalUtil.getFunctionMissingAbort();
        FUNCTION_MISSING_ABORT_TABLE = 0L;
        CAPABILITIES_OFFSET = 3 * Pointer.POINTER_SIZE;
        int v0 = JNINativeInterface.GetVersion();
        switch (v0) {
            case 65537: {
                v1 = 12;
                break;
            }
            default: {
                v1 = 4;
            }
        }
        switch (v0) {
            case 65537: {
                v2 = 208;
                break;
            }
            case 65538: {
                v2 = 225;
                break;
            }
            case 65540: {
                v2 = 228;
                break;
            }
            case 65542: 
            case 65544: {
                v2 = 229;
                break;
            }
            case 589824: 
            case 655360: {
                v2 = 230;
                break;
            }
            case 0x130000: 
            case 0x140000: {
                v2 = 231;
                break;
            }
            case 0x150000: {
                v2 = 232;
                break;
            }
            default: {
                v2 = 232;
                APIUtil.DEBUG_STREAM.println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers.");
            }
        }
        JNI_NATIVE_INTERFACE_FUNCTION_COUNT = v1 + Configuration.JNI_NATIVE_INTERFACE_FUNCTION_COUNT.get(v2);
    }
}

