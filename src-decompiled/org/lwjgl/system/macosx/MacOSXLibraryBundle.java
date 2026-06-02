/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.macosx.CoreFoundation;
import org.lwjgl.system.macosx.MacOSXLibrary;

public class MacOSXLibraryBundle
extends MacOSXLibrary {
    public MacOSXLibraryBundle(String param1, long param2) {
        super(param1, param2);
    }

    public static MacOSXLibraryBundle getWithIdentifier(String param0) {
        long v1 = 0L;
        try {
            MemoryStack v3 = MemoryStack.stackPush();
            Throwable v4 = null;
            try {
                v1 = MacOSXLibraryBundle.CString2CFString(v3.UTF8(param0), 0x8000100);
                long v5 = CoreFoundation.CFBundleGetBundleWithIdentifier(v1);
                if (v5 == 0L) {
                    throw new UnsatisfiedLinkError("Failed to retrieve bundle with identifier: " + param0);
                }
                CoreFoundation.CFRetain(v5);
                MacOSXLibraryBundle v7 = new MacOSXLibraryBundle(param0, v5);
                if (v3 != null) {
                    v3.close();
                }
                return v7;
            }
            catch (Throwable v9) {
                try {
                    v4 = v9;
                    throw v9;
                }
                catch (Throwable v10) {
                    if (v3 != null) {
                        if (v4 != null) {
                            try {
                                v3.close();
                            }
                            catch (Throwable v11) {
                                v4.addSuppressed(v11);
                            }
                        } else {
                            v3.close();
                        }
                    }
                    throw v10;
                }
            }
        }
        finally {
            if (v1 != 0L) {
                CoreFoundation.CFRelease(v1);
            }
        }
    }

    public static MacOSXLibraryBundle create(String param0) {
        long v1 = 0L;
        long v3 = 0L;
        try {
            MemoryStack v5 = MemoryStack.stackPush();
            Throwable v6 = null;
            try {
                v1 = MacOSXLibraryBundle.CString2CFString(v5.UTF8(param0), 0x8000100);
                v3 = Checks.check(CoreFoundation.CFURLCreateWithFileSystemPath(0L, v1, 0L, true));
                long v7 = CoreFoundation.CFBundleCreate(0L, v3);
                if (v7 == 0L) {
                    throw new UnsatisfiedLinkError("Failed to create bundle: " + param0);
                }
                MacOSXLibraryBundle v9 = new MacOSXLibraryBundle(param0, v7);
                if (v5 != null) {
                    v5.close();
                }
                return v9;
            }
            catch (Throwable v11) {
                try {
                    v6 = v11;
                    throw v11;
                }
                catch (Throwable v12) {
                    if (v5 != null) {
                        if (v6 != null) {
                            try {
                                v5.close();
                            }
                            catch (Throwable v13) {
                                v6.addSuppressed(v13);
                            }
                        } else {
                            v5.close();
                        }
                    }
                    throw v12;
                }
            }
        }
        finally {
            if (v3 != 0L) {
                CoreFoundation.CFRelease(v3);
            }
            if (v1 != 0L) {
                CoreFoundation.CFRelease(v1);
            }
        }
    }

    @Override
    @Nullable
    public String getPath() {
        return null;
    }

    @Override
    public long getFunctionAddress(ByteBuffer param1) {
        long v2 = MacOSXLibraryBundle.CString2CFString(param1, 1536);
        try {
            long v4 = CoreFoundation.CFBundleGetFunctionPointerForName(this.address(), v2);
            return v4;
        }
        finally {
            CoreFoundation.CFRelease(v2);
        }
    }

    private static long CString2CFString(ByteBuffer param0, int param1) {
        return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, param0, param1, CoreFoundation.kCFAllocatorNull));
    }

    @Override
    public void free() {
        CoreFoundation.CFRelease(this.address());
    }
}

