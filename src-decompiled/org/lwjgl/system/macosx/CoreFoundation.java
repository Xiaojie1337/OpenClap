/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class CoreFoundation {
    public static final byte TRUE;
    public static final byte FALSE;
    public static final int kCFStringEncodingMacRoman;
    public static final int kCFStringEncodingWindowsLatin1;
    public static final int kCFStringEncodingISOLatin1;
    public static final int kCFStringEncodingNextStepLatin;
    public static final int kCFStringEncodingASCII;
    public static final int kCFStringEncodingUnicode;
    public static final int kCFStringEncodingUTF8;
    public static final int kCFStringEncodingNonLossyASCII;
    public static final int kCFStringEncodingUTF16;
    public static final int kCFStringEncodingUTF16BE;
    public static final int kCFStringEncodingUTF16LE;
    public static final int kCFStringEncodingUTF32;
    public static final int kCFStringEncodingUTF32BE;
    public static final int kCFStringEncodingUTF32LE;
    public static final int kCFURLPOSIXPathStyle;
    public static final int kCFURLHFSPathStyle;
    public static final int kCFURLWindowsPathStyle;
    public static final long kCFAllocatorDefault;
    public static final long kCFAllocatorSystemDefault;
    public static final long kCFAllocatorMalloc;
    public static final long kCFAllocatorMallocZone;
    public static final long kCFAllocatorNull;
    public static final long kCFAllocatorUseContext;

    protected CoreFoundation() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorDefault();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorSystemDefault();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorMalloc();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorMallocZone();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorNull();

    @NativeType(value="CFAllocatorRef")
    private static native long kCFAllocatorUseContext();

    public static native long nCFRetain(long var0);

    @NativeType(value="CFTypeRef")
    public static long CFRetain(@NativeType(value="CFTypeRef") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return CoreFoundation.nCFRetain(param0);
    }

    public static native void nCFRelease(long var0);

    public static void CFRelease(@NativeType(value="CFTypeRef") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        CoreFoundation.nCFRelease(param0);
    }

    public static native long nCFBundleCreate(long var0, long var2);

    @NativeType(value="CFBundleRef")
    public static long CFBundleCreate(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="CFURLRef") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return CoreFoundation.nCFBundleCreate(param0, param2);
    }

    public static native long nCFBundleGetBundleWithIdentifier(long var0);

    @NativeType(value="CFBundleRef")
    public static long CFBundleGetBundleWithIdentifier(@NativeType(value="CFStringRef") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return CoreFoundation.nCFBundleGetBundleWithIdentifier(param0);
    }

    public static native long nCFBundleGetFunctionPointerForName(long var0, long var2);

    @NativeType(value="void *")
    public static long CFBundleGetFunctionPointerForName(@NativeType(value="CFBundleRef") long param0, @NativeType(value="CFStringRef") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return CoreFoundation.nCFBundleGetFunctionPointerForName(param0, param2);
    }

    public static native long nCFStringCreateWithCString(long var0, long var2, int var4);

    @NativeType(value="CFStringRef")
    public static long CFStringCreateWithCString(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="CFStringEncoding") int param3) {
        return CoreFoundation.nCFStringCreateWithCString(param0, MemoryUtil.memAddress(param2), param3);
    }

    public static native long nCFStringCreateWithCStringNoCopy(long var0, long var2, int var4, long var5);

    @NativeType(value="CFStringRef")
    public static long CFStringCreateWithCStringNoCopy(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="CFStringEncoding") int param3, @NativeType(value="CFAllocatorRef") long param4) {
        return CoreFoundation.nCFStringCreateWithCStringNoCopy(param0, MemoryUtil.memAddress(param2), param3, param4);
    }

    public static native long nCFURLCreateWithFileSystemPath(long var0, long var2, long var4, boolean var6);

    @NativeType(value="CFURLRef")
    public static long CFURLCreateWithFileSystemPath(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="CFStringRef") long param2, @NativeType(value="CFURLPathStyle") long param4, @NativeType(value="Boolean") boolean param6) {
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return CoreFoundation.nCFURLCreateWithFileSystemPath(param0, param2, param4, param6);
    }

    static {
        kCFURLWindowsPathStyle = 2;
        kCFURLHFSPathStyle = 1;
        kCFURLPOSIXPathStyle = 0;
        kCFStringEncodingUTF32LE = 0x1C000100;
        kCFStringEncodingUTF32BE = 0x18000100;
        kCFStringEncodingUTF32 = 0xC000100;
        kCFStringEncodingUTF16LE = 0x14000100;
        kCFStringEncodingUTF16BE = 0x10000100;
        kCFStringEncodingUTF16 = 256;
        kCFStringEncodingNonLossyASCII = 3071;
        kCFStringEncodingUTF8 = 0x8000100;
        kCFStringEncodingUnicode = 256;
        kCFStringEncodingASCII = 1536;
        kCFStringEncodingNextStepLatin = 2817;
        kCFStringEncodingISOLatin1 = 513;
        kCFStringEncodingWindowsLatin1 = 1280;
        kCFStringEncodingMacRoman = 0;
        FALSE = 0;
        TRUE = 1;
        Library.initialize();
        kCFAllocatorDefault = CoreFoundation.kCFAllocatorDefault();
        kCFAllocatorSystemDefault = CoreFoundation.kCFAllocatorSystemDefault();
        kCFAllocatorMalloc = CoreFoundation.kCFAllocatorMalloc();
        kCFAllocatorMallocZone = CoreFoundation.kCFAllocatorMallocZone();
        kCFAllocatorNull = CoreFoundation.kCFAllocatorNull();
        kCFAllocatorUseContext = CoreFoundation.kCFAllocatorUseContext();
    }
}

