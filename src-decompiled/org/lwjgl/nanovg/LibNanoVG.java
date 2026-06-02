/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.lwjgl.system.Configuration;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;

final class LibNanoVG {
    private LibNanoVG() {
    }

    static void initialize() {
    }

    private static native void setupMalloc(long var0, long var2, long var4, long var6, long var8, long var10);

    static {
        String v0 = Platform.mapLibraryNameBundled("lwjgl_nanovg");
        Library.loadSystem(System::load, System::loadLibrary, LibNanoVG.class, "org.lwjgl.nanovg", v0);
        MemoryUtil.MemoryAllocator v1 = MemoryUtil.getAllocator(Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(true));
        LibNanoVG.setupMalloc(v1.getMalloc(), v1.getCalloc(), v1.getRealloc(), v1.getFree(), v1.getAlignedAlloc(), v1.getAlignedFree());
    }
}

