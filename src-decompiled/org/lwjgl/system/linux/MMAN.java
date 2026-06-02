/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class MMAN {
    public static final long MAP_FAILED;
    public static final int PROT_EXEC;
    public static final int PROT_READ;
    public static final int PROT_WRITE;
    public static final int PROT_NONE;
    public static final int PROT_GROWSDOWN;
    public static final int PROT_GROWSUP;
    public static final int MAP_SHARED;
    public static final int MAP_SHARED_VALIDATE;
    public static final int MAP_PRIVATE;
    public static final int MAP_HUGE_SHIFT;
    public static final int MAP_HUGE_MASK;
    public static final int MAP_32BIT;
    public static final int MAP_ANONYMOUS;
    public static final int MAP_ANON;
    public static final int MAP_DENYWRITE;
    public static final int MAP_EXECUTABLE;
    public static final int MAP_FILE;
    public static final int MAP_FIXED;
    public static final int MAP_FIXED_NOREPLACE;
    public static final int MAP_GROWSDOWN;
    public static final int MAP_HUGETLB;
    public static final int MAP_HUGE_2MB;
    public static final int MAP_HUGE_1GB;
    public static final int MAP_LOCKED;
    public static final int MAP_NONBLOCK;
    public static final int MAP_NORESERVE;
    public static final int MAP_POPULATE;
    public static final int MAP_STACK;
    public static final int MAP_SYNC;
    public static final int MAP_UNINITIALIZED;

    protected MMAN() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="void *")
    public static native long mmap(@NativeType(value="void *") long var0, @NativeType(value="size_t") long var2, int var4, int var5, int var6, @NativeType(value="off_t") long var7);

    public static native int nmunmap(long var0, long var2);

    public static int munmap(@NativeType(value="void *") ByteBuffer param0) {
        return MMAN.nmunmap(MemoryUtil.memAddress(param0), param0.remaining());
    }

    static {
        MAP_UNINITIALIZED = 0x4000000;
        MAP_SYNC = 524288;
        MAP_STACK = 131072;
        MAP_POPULATE = 32768;
        MAP_NORESERVE = 16384;
        MAP_NONBLOCK = 65536;
        MAP_LOCKED = 8192;
        MAP_HUGE_1GB = 0x78000000;
        MAP_HUGE_2MB = 0x54000000;
        MAP_HUGETLB = 262144;
        MAP_GROWSDOWN = 256;
        MAP_FIXED_NOREPLACE = 0x100000;
        MAP_FIXED = 16;
        MAP_FILE = 0;
        MAP_EXECUTABLE = 4096;
        MAP_DENYWRITE = 2048;
        MAP_ANON = 32;
        MAP_ANONYMOUS = 32;
        MAP_32BIT = 64;
        MAP_HUGE_MASK = 63;
        MAP_HUGE_SHIFT = 26;
        MAP_PRIVATE = 2;
        MAP_SHARED_VALIDATE = 3;
        MAP_SHARED = 1;
        PROT_GROWSUP = 0x2000000;
        PROT_GROWSDOWN = 0x1000000;
        PROT_NONE = 0;
        PROT_WRITE = 2;
        PROT_READ = 1;
        PROT_EXEC = 4;
        MAP_FAILED = -1L;
        Library.initialize();
    }
}

