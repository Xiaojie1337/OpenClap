/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.SharedLibraryUtil;
import org.lwjgl.system.macosx.DynamicLinkLoader;
import org.lwjgl.system.macosx.MacOSXLibrary;

public class MacOSXLibraryDL
extends MacOSXLibrary {
    public MacOSXLibraryDL(String param1) {
        this(param1, MacOSXLibraryDL.loadLibrary(param1));
    }

    public MacOSXLibraryDL(String param1, long param2) {
        super(param1, param2);
    }

    private static long loadLibrary(String param0) {
        long v3;
        MemoryStack v1 = MemoryStack.stackPush();
        Throwable v2 = null;
        try {
            v3 = DynamicLinkLoader.dlopen(v1.UTF8(param0), 5);
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
            throw new UnsatisfiedLinkError("Failed to dynamically load library: " + param0 + "(error = " + DynamicLinkLoader.dlerror() + ")");
        }
        return v3;
    }

    @Override
    @Nullable
    public String getPath() {
        return SharedLibraryUtil.getLibraryPath(this.address());
    }

    @Override
    public long getFunctionAddress(ByteBuffer param1) {
        return DynamicLinkLoader.dlsym(this.address(), param1);
    }

    @Override
    public void free() {
        DynamicLinkLoader.dlclose(this.address());
    }
}

