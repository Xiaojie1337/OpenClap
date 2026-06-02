/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.CRYPTPROTECT_PROMPTSTRUCT;
import org.lwjgl.system.windows.DATA_BLOB;

public class Crypt32 {
    private static final SharedLibrary CRYPT32;
    public static final int CRYPTPROTECT_UI_FORBIDDEN;
    public static final int CRYPTPROTECT_LOCAL_MACHINE;
    public static final int CRYPTPROTECT_AUDIT;
    public static final int CRYPTPROTECT_VERIFY_PROTECTION;
    public static final int CRYPTPROTECTMEMORY_SAME_PROCESS;
    public static final int CRYPTPROTECTMEMORY_CROSS_PROCESS;
    public static final int CRYPTPROTECTMEMORY_SAME_LOGON;
    public static final int CRYPTPROTECT_PROMPT_ON_UNPROTECT;
    public static final int CRYPTPROTECT_PROMPT_ON_PROTECT;
    public static final int CRYPTPROTECTMEMORY_BLOCK_SIZE;

    public static SharedLibrary getLibrary() {
        return CRYPT32;
    }

    protected Crypt32() {
        throw new UnsupportedOperationException();
    }

    public static native int nCryptProtectData(long var0, long var2, long var4, long var6, long var8, int var10, long var11, long var13);

    public static int nCryptProtectData(long param0, long param2, long param4, long param6, long param8, int param10, long param11) {
        long v13 = Functions.CryptProtectData;
        return Crypt32.nCryptProtectData(param0, param2, param4, param6, param8, param10, param11, v13);
    }

    @NativeType(value="BOOL")
    public static boolean CryptProtectData(@NativeType(value="DATA_BLOB *") DATA_BLOB param0, @Nullable @NativeType(value="LPCWSTR") ByteBuffer param1, @Nullable @NativeType(value="DATA_BLOB *") DATA_BLOB param2, @NativeType(value="PVOID") long param3, @Nullable @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT param5, @NativeType(value="DWORD") int param6, @NativeType(value="DATA_BLOB *") DATA_BLOB param7) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param1);
        }
        return Crypt32.nCryptProtectData(param0.address(), MemoryUtil.memAddressSafe(param1), MemoryUtil.memAddressSafe(param2), param3, MemoryUtil.memAddressSafe(param5), param6, param7.address()) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean CryptProtectData(@NativeType(value="DATA_BLOB *") DATA_BLOB param0, @Nullable @NativeType(value="LPCWSTR") CharSequence param1, @Nullable @NativeType(value="DATA_BLOB *") DATA_BLOB param2, @NativeType(value="PVOID") long param3, @Nullable @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT param5, @NativeType(value="DWORD") int param6, @NativeType(value="DATA_BLOB *") DATA_BLOB param7) {
        MemoryStack v8 = MemoryStack.stackGet();
        int v9 = v8.getPointer();
        try {
            v8.nUTF16Safe(param1, true);
            long v10 = param1 == null ? 0L : v8.getPointerAddress();
            boolean v12 = Crypt32.nCryptProtectData(param0.address(), v10, MemoryUtil.memAddressSafe(param2), param3, MemoryUtil.memAddressSafe(param5), param6, param7.address()) != 0;
            return v12;
        }
        finally {
            v8.setPointer(v9);
        }
    }

    public static native int nCryptProtectMemory(long var0, int var2, int var3, long var4);

    public static int nCryptProtectMemory(long param0, int param2, int param3) {
        long v4 = Functions.CryptProtectMemory;
        if (Checks.CHECKS) {
            Checks.check(v4);
        }
        return Crypt32.nCryptProtectMemory(param0, param2, param3, v4);
    }

    @NativeType(value="BOOL")
    public static boolean CryptProtectMemory(@NativeType(value="LPVOID") ByteBuffer param0, @NativeType(value="DWORD") int param1) {
        return Crypt32.nCryptProtectMemory(MemoryUtil.memAddress(param0), param0.remaining(), param1) != 0;
    }

    public static native int nCryptUnprotectData(long var0, long var2, long var4, long var6, long var8, int var10, long var11, long var13);

    public static int nCryptUnprotectData(long param0, long param2, long param4, long param6, long param8, int param10, long param11) {
        long v13 = Functions.CryptUnprotectData;
        return Crypt32.nCryptUnprotectData(param0, param2, param4, param6, param8, param10, param11, v13);
    }

    @NativeType(value="BOOL")
    public static boolean CryptUnprotectData(@NativeType(value="DATA_BLOB *") DATA_BLOB param0, @Nullable @NativeType(value="LPWSTR *") PointerBuffer param1, @Nullable @NativeType(value="DATA_BLOB *") DATA_BLOB param2, @NativeType(value="PVOID") long param3, @Nullable @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT param5, @NativeType(value="DWORD") int param6, @NativeType(value="DATA_BLOB *") DATA_BLOB param7) {
        if (Checks.CHECKS) {
            Checks.checkSafe(param1, 1);
        }
        return Crypt32.nCryptUnprotectData(param0.address(), MemoryUtil.memAddressSafe(param1), MemoryUtil.memAddressSafe(param2), param3, MemoryUtil.memAddressSafe(param5), param6, param7.address()) != 0;
    }

    public static native int nCryptUnprotectMemory(long var0, int var2, int var3, long var4);

    public static int nCryptUnprotectMemory(long param0, int param2, int param3) {
        long v4 = Functions.CryptUnprotectMemory;
        if (Checks.CHECKS) {
            Checks.check(v4);
        }
        return Crypt32.nCryptUnprotectMemory(param0, param2, param3, v4);
    }

    @NativeType(value="BOOL")
    public static boolean CryptUnprotectMemory(@NativeType(value="LPVOID") ByteBuffer param0, @NativeType(value="DWORD") int param1) {
        return Crypt32.nCryptUnprotectMemory(MemoryUtil.memAddress(param0), param0.remaining(), param1) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return CRYPT32;
    }

    static {
        CRYPTPROTECTMEMORY_BLOCK_SIZE = 16;
        CRYPTPROTECT_PROMPT_ON_PROTECT = 2;
        CRYPTPROTECT_PROMPT_ON_UNPROTECT = 1;
        CRYPTPROTECTMEMORY_SAME_LOGON = 2;
        CRYPTPROTECTMEMORY_CROSS_PROCESS = 1;
        CRYPTPROTECTMEMORY_SAME_PROCESS = 0;
        CRYPTPROTECT_VERIFY_PROTECTION = 64;
        CRYPTPROTECT_AUDIT = 16;
        CRYPTPROTECT_LOCAL_MACHINE = 4;
        CRYPTPROTECT_UI_FORBIDDEN = 1;
        CRYPT32 = Library.loadNative(Crypt32.class, "org.lwjgl", "crypt32");
    }

    public static final class Functions {
        public static final long CryptProtectData = APIUtil.apiGetFunctionAddress(Crypt32.access$000(), "CryptProtectData");
        public static final long CryptProtectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.access$000(), "CryptProtectMemory");
        public static final long CryptUnprotectData = APIUtil.apiGetFunctionAddress(Crypt32.access$000(), "CryptUnprotectData");
        public static final long CryptUnprotectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.access$000(), "CryptUnprotectMemory");

        private Functions() {
        }
    }
}

