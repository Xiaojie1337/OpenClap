/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import javax.annotation.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NVGLUFramebuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoVGGL2 {
    public static final int NVG_ANTIALIAS;
    public static final int NVG_STENCIL_STROKES;
    public static final int NVG_DEBUG;
    public static final int NVG_IMAGE_NODELETE;

    protected NanoVGGL2() {
        throw new UnsupportedOperationException();
    }

    public static native int nnvglCreateImageFromHandle(long var0, int var2, int var3, int var4, int var5);

    public static int nvglCreateImageFromHandle(@NativeType(value="NVGcontext *") long param0, @NativeType(value="GLuint") int param2, int param3, int param4, int param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVGGL2.nnvglCreateImageFromHandle(param0, param2, param3, param4, param5);
    }

    public static native int nnvglImageHandle(long var0, int var2);

    @NativeType(value="GLuint")
    public static int nvglImageHandle(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVGGL2.nnvglImageHandle(param0, param2);
    }

    public static native long nnvgCreate(int var0);

    @NativeType(value="NVGcontext *")
    public static long nvgCreate(int param0) {
        return NanoVGGL2.nnvgCreate(param0);
    }

    public static native void nnvgDelete(long var0);

    public static void nvgDelete(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVGGL2.nnvgDelete(param0);
    }

    public static native long nnvgluCreateFramebuffer(long var0, int var2, int var3, int var4);

    @Nullable
    @NativeType(value="NVGLUframebuffer *")
    public static NVGLUFramebuffer nvgluCreateFramebuffer(@NativeType(value="NVGcontext *") long param0, int param2, int param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        long v5 = NanoVGGL2.nnvgluCreateFramebuffer(param0, param2, param3, param4);
        return NVGLUFramebuffer.createSafe(v5);
    }

    public static native void nnvgluBindFramebuffer(long var0, long var2);

    public static void nvgluBindFramebuffer(@NativeType(value="NVGcontext *") long param0, @Nullable @NativeType(value="NVGLUframebuffer *") NVGLUFramebuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVGGL2.nnvgluBindFramebuffer(param0, MemoryUtil.memAddressSafe(param2));
    }

    public static native void nnvgluDeleteFramebuffer(long var0, long var2);

    public static void nvgluDeleteFramebuffer(@NativeType(value="NVGcontext *") long param0, @NativeType(value="NVGLUframebuffer *") NVGLUFramebuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVGGL2.nnvgluDeleteFramebuffer(param0, param2.address());
    }

    static {
        NVG_IMAGE_NODELETE = 65536;
        NVG_DEBUG = 4;
        NVG_STENCIL_STROKES = 2;
        NVG_ANTIALIAS = 1;
        LibNanoVG.initialize();
    }
}

