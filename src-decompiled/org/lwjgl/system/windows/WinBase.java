/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WinBase {
    public static final int FALSE;
    public static final int TRUE;

    protected WinBase() {
        throw new UnsupportedOperationException();
    }

    public static native long nLocalFree(long var0);

    @NativeType(value="HLOCAL")
    public static long LocalFree(@NativeType(value="HLOCAL") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return WinBase.nLocalFree(param0);
    }

    @NativeType(value="DWORD")
    public static native int GetLastError();

    @NativeType(value="DWORD")
    public static native int getLastError();

    public static native long nGetModuleHandle(long var0);

    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param0);
        }
        return WinBase.nGetModuleHandle(MemoryUtil.memAddressSafe(param0));
    }

    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@Nullable @NativeType(value="LPCTSTR") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF16Safe(param0, true);
            long v3 = param0 == null ? 0L : v1.getPointerAddress();
            long v5 = WinBase.nGetModuleHandle(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static native int nGetModuleFileName(long var0, long var2, int var4);

    @NativeType(value="DWORD")
    public static int GetModuleFileName(@NativeType(value="HMODULE") long param0, @NativeType(value="LPTSTR") ByteBuffer param2) {
        return WinBase.nGetModuleFileName(param0, MemoryUtil.memAddress(param2), param2.remaining() >> 1);
    }

    @NativeType(value="DWORD")
    public static String GetModuleFileName(@NativeType(value="HMODULE") long param0, @NativeType(value="DWORD") int param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            ByteBuffer v5 = v3.malloc(param2);
            int v6 = WinBase.nGetModuleFileName(param0, MemoryUtil.memAddress(v5), param2);
            String v7 = MemoryUtil.memUTF16(v5, v6);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native long nLoadLibrary(long var0);

    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param0);
        }
        return WinBase.nLoadLibrary(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="LPCTSTR") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF16(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = WinBase.nLoadLibrary(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static native long nGetProcAddress(long var0, long var2);

    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long param0, @NativeType(value="LPCSTR") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return WinBase.nGetProcAddress(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="HMODULE") long param0, @NativeType(value="LPCSTR") CharSequence param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = WinBase.nGetProcAddress(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int nFreeLibrary(long var0);

    @NativeType(value="BOOL")
    public static boolean FreeLibrary(@NativeType(value="HMODULE") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return WinBase.nFreeLibrary(param0) != 0;
    }

    static {
        TRUE = 1;
        FALSE = 0;
        Library.initialize();
    }
}

