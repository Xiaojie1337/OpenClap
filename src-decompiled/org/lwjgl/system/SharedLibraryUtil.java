/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class SharedLibraryUtil {
    private static native int getLibraryPath(long var0, long var2, int var4);

    @Nullable
    public static String getLibraryPath(long param0) {
        int v2 = 256;
        ByteBuffer v3 = MemoryUtil.memAlloc(256);
        try {
            while (true) {
                int v4;
                if ((v4 = SharedLibraryUtil.getLibraryPath(param0, MemoryUtil.memAddress(v3), v2)) == 0) {
                    String v5 = null;
                    return v5;
                }
                if (v4 < v2) {
                    String v5 = MemoryUtil.memUTF8(v3, v4 - 1);
                    return v5;
                }
                v2 = v2 * 3 / 2;
                v3 = MemoryUtil.memRealloc(v3, v2);
            }
        }
        finally {
            MemoryUtil.memFree(v3);
        }
    }
}

