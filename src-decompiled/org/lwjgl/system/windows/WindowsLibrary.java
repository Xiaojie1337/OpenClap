/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.WinBase;
import org.lwjgl.system.windows.WindowsUtil;

public class WindowsLibrary
extends SharedLibrary.Default {
    public static final long HINSTANCE;

    public WindowsLibrary(String param1) {
        this(param1, WindowsLibrary.loadLibrary(param1));
    }

    public WindowsLibrary(String param1, long param2) {
        super(param1, param2);
    }

    private static long loadLibrary(String param0) {
        long v3;
        MemoryStack v1 = MemoryStack.stackPush();
        Throwable v2 = null;
        try {
            v3 = WinBase.LoadLibrary(v1.UTF16(param0));
            if (v1 != null) {
                v1.close();
            }
        }
        catch (Throwable v5) {
            try {
                v2 = v5;
                throw v5;
            }
            catch (Throwable v6) {
                if (v1 != null) {
                    if (v2 != null) {
                        try {
                            v1.close();
                        }
                        catch (Throwable v7) {
                            v2.addSuppressed(v7);
                        }
                    } else {
                        v1.close();
                    }
                }
                throw v6;
            }
        }
        if (v3 == 0L) {
            throw new UnsatisfiedLinkError("Failed to load library: " + param0 + " (error code = " + WinBase.getLastError() + ")");
        }
        return v3;
    }

    /*
     * Loose catch block
     */
    @Override
    @Nullable
    public String getPath() {
        String v52222222222;
        int v4;
        int v1 = 256;
        ByteBuffer v2 = MemoryUtil.memAlloc(256);
        while (true) {
            int v3 = WinBase.GetModuleFileName(this.address(), v2);
            v4 = WinBase.getLastError();
            if (v4 != 0) break block5;
            v52222222222 = v3 == 0 ? null : MemoryUtil.memUTF16(v2, v3);
            break;
        }
        catch (Throwable v6) {
            MemoryUtil.memFree(v2);
            throw v6;
        }
        {
            block5: {
                MemoryUtil.memFree(v2);
                return v52222222222;
            }
            if (v4 != 122) {
                String v52222222222 = null;
                MemoryUtil.memFree(v2);
                return v52222222222;
            }
            v1 = v1 * 3 / 2;
            v2 = MemoryUtil.memRealloc(v2, v1);
            continue;
        }
    }

    @Override
    public long getFunctionAddress(ByteBuffer param1) {
        return WinBase.GetProcAddress(this.address(), param1);
    }

    @Override
    public void free() {
        if (!WinBase.FreeLibrary(this.address())) {
            WindowsUtil.windowsThrowException("Failed to unload library: " + this.getName());
        }
    }

    static {
        MemoryStack v0 = MemoryStack.stackPush();
        Throwable v1 = null;
        try {
            HINSTANCE = WinBase.GetModuleHandle(v0.UTF16(Library.JNI_LIBRARY_NAME));
            if (HINSTANCE == 0L) {
                throw new RuntimeException("Failed to retrieve LWJGL module handle.");
            }
            if (v0 != null) {
                v0.close();
            }
        }
        catch (Throwable v2) {
            try {
                v1 = v2;
                throw v2;
            }
            catch (Throwable v3) {
                if (v0 != null) {
                    if (v1 != null) {
                        try {
                            v0.close();
                        }
                        catch (Throwable v4) {
                            v1.addSuppressed(v4);
                        }
                    } else {
                        v0.close();
                    }
                }
                throw v3;
            }
        }
    }
}

