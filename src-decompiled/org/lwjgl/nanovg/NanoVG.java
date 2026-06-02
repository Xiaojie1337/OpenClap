/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NVGGlyphPosition;
import org.lwjgl.nanovg.NVGPaint;
import org.lwjgl.nanovg.NVGTextRow;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoVG {
    public static final float NVG_PI;
    public static final int NVG_CCW;
    public static final int NVG_CW;
    public static final int NVG_SOLID;
    public static final int NVG_HOLE;
    public static final int NVG_BUTT;
    public static final int NVG_ROUND;
    public static final int NVG_SQUARE;
    public static final int NVG_BEVEL;
    public static final int NVG_MITER;
    public static final int NVG_ALIGN_LEFT;
    public static final int NVG_ALIGN_CENTER;
    public static final int NVG_ALIGN_RIGHT;
    public static final int NVG_ALIGN_TOP;
    public static final int NVG_ALIGN_MIDDLE;
    public static final int NVG_ALIGN_BOTTOM;
    public static final int NVG_ALIGN_BASELINE;
    public static final int NVG_ZERO;
    public static final int NVG_ONE;
    public static final int NVG_SRC_COLOR;
    public static final int NVG_ONE_MINUS_SRC_COLOR;
    public static final int NVG_DST_COLOR;
    public static final int NVG_ONE_MINUS_DST_COLOR;
    public static final int NVG_SRC_ALPHA;
    public static final int NVG_ONE_MINUS_SRC_ALPHA;
    public static final int NVG_DST_ALPHA;
    public static final int NVG_ONE_MINUS_DST_ALPHA;
    public static final int NVG_SRC_ALPHA_SATURATE;
    public static final int NVG_SOURCE_OVER;
    public static final int NVG_SOURCE_IN;
    public static final int NVG_SOURCE_OUT;
    public static final int NVG_ATOP;
    public static final int NVG_DESTINATION_OVER;
    public static final int NVG_DESTINATION_IN;
    public static final int NVG_DESTINATION_OUT;
    public static final int NVG_DESTINATION_ATOP;
    public static final int NVG_LIGHTER;
    public static final int NVG_COPY;
    public static final int NVG_XOR;
    public static final int NVG_IMAGE_GENERATE_MIPMAPS;
    public static final int NVG_IMAGE_REPEATX;
    public static final int NVG_IMAGE_REPEATY;
    public static final int NVG_IMAGE_FLIPY;
    public static final int NVG_IMAGE_PREMULTIPLIED;
    public static final int NVG_IMAGE_NEAREST;
    static final long nvgCreateInternal;
    static final long nvgInternalParams;
    static final long nvgDeleteInternal;

    protected NanoVG() {
        throw new UnsupportedOperationException();
    }

    public static native void nnvgBeginFrame(long var0, float var2, float var3, float var4);

    public static void nvgBeginFrame(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgBeginFrame(param0, param2, param3, param4);
    }

    public static native void nnvgCancelFrame(long var0);

    public static void nvgCancelFrame(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgCancelFrame(param0);
    }

    public static native void nnvgEndFrame(long var0);

    public static void nvgEndFrame(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgEndFrame(param0);
    }

    public static native void nnvgGlobalCompositeOperation(long var0, int var2);

    public static void nvgGlobalCompositeOperation(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgGlobalCompositeOperation(param0, param2);
    }

    public static native void nnvgGlobalCompositeBlendFunc(long var0, int var2, int var3);

    public static void nvgGlobalCompositeBlendFunc(@NativeType(value="NVGcontext *") long param0, int param2, int param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgGlobalCompositeBlendFunc(param0, param2, param3);
    }

    public static native void nnvgGlobalCompositeBlendFuncSeparate(long var0, int var2, int var3, int var4, int var5);

    public static void nvgGlobalCompositeBlendFuncSeparate(@NativeType(value="NVGcontext *") long param0, int param2, int param3, int param4, int param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgGlobalCompositeBlendFuncSeparate(param0, param2, param3, param4, param5);
    }

    public static native void nnvgRGB(byte var0, byte var1, byte var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGB(@NativeType(value="unsigned char") byte param0, @NativeType(value="unsigned char") byte param1, @NativeType(value="unsigned char") byte param2, @NativeType(value="NVGcolor") NVGColor param3) {
        NanoVG.nnvgRGB(param0, param1, param2, param3.address());
        return param3;
    }

    public static native void nnvgRGBf(float var0, float var1, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBf(float param0, float param1, float param2, @NativeType(value="NVGcolor") NVGColor param3) {
        NanoVG.nnvgRGBf(param0, param1, param2, param3.address());
        return param3;
    }

    public static native void nnvgRGBA(byte var0, byte var1, byte var2, byte var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBA(@NativeType(value="unsigned char") byte param0, @NativeType(value="unsigned char") byte param1, @NativeType(value="unsigned char") byte param2, @NativeType(value="unsigned char") byte param3, @NativeType(value="NVGcolor") NVGColor param4) {
        NanoVG.nnvgRGBA(param0, param1, param2, param3, param4.address());
        return param4;
    }

    public static native void nnvgRGBAf(float var0, float var1, float var2, float var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgRGBAf(float param0, float param1, float param2, float param3, @NativeType(value="NVGcolor") NVGColor param4) {
        NanoVG.nnvgRGBAf(param0, param1, param2, param3, param4.address());
        return param4;
    }

    public static native void nnvgLerpRGBA(long var0, long var2, float var4, long var5);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgLerpRGBA(@NativeType(value="NVGcolor") NVGColor param0, @NativeType(value="NVGcolor") NVGColor param1, float param2, @NativeType(value="NVGcolor") NVGColor param3) {
        NanoVG.nnvgLerpRGBA(param0.address(), param1.address(), param2, param3.address());
        return param3;
    }

    public static native void nnvgTransRGBA(long var0, byte var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgTransRGBA(@NativeType(value="NVGcolor") NVGColor param0, @NativeType(value="unsigned char") byte param1, @NativeType(value="NVGcolor") NVGColor param2) {
        NanoVG.nnvgTransRGBA(param0.address(), param1, param2.address());
        return param2;
    }

    public static native void nnvgTransRGBAf(long var0, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgTransRGBAf(@NativeType(value="NVGcolor") NVGColor param0, float param1, @NativeType(value="NVGcolor") NVGColor param2) {
        NanoVG.nnvgTransRGBAf(param0.address(), param1, param2.address());
        return param2;
    }

    public static native void nnvgHSL(float var0, float var1, float var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgHSL(float param0, float param1, float param2, @NativeType(value="NVGcolor") NVGColor param3) {
        NanoVG.nnvgHSL(param0, param1, param2, param3.address());
        return param3;
    }

    public static native void nnvgHSLA(float var0, float var1, float var2, byte var3, long var4);

    @NativeType(value="NVGcolor")
    public static NVGColor nvgHSLA(float param0, float param1, float param2, @NativeType(value="unsigned char") byte param3, @NativeType(value="NVGcolor") NVGColor param4) {
        NanoVG.nnvgHSLA(param0, param1, param2, param3, param4.address());
        return param4;
    }

    public static native void nnvgSave(long var0);

    public static void nvgSave(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgSave(param0);
    }

    public static native void nnvgRestore(long var0);

    public static void nvgRestore(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRestore(param0);
    }

    public static native void nnvgReset(long var0);

    public static void nvgReset(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgReset(param0);
    }

    public static native void nnvgShapeAntiAlias(long var0, int var2);

    public static void nvgShapeAntiAlias(@NativeType(value="NVGcontext *") long param0, @NativeType(value="int") boolean param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgShapeAntiAlias(param0, param2 ? 1 : 0);
    }

    public static native void nnvgStrokeColor(long var0, long var2);

    public static void nvgStrokeColor(@NativeType(value="NVGcontext *") long param0, @NativeType(value="NVGcolor") NVGColor param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgStrokeColor(param0, param2.address());
    }

    public static native void nnvgStrokePaint(long var0, long var2);

    public static void nvgStrokePaint(@NativeType(value="NVGcontext *") long param0, @NativeType(value="NVGpaint") NVGPaint param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgStrokePaint(param0, param2.address());
    }

    public static native void nnvgFillColor(long var0, long var2);

    public static void nvgFillColor(@NativeType(value="NVGcontext *") long param0, @NativeType(value="NVGcolor") NVGColor param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFillColor(param0, param2.address());
    }

    public static native void nnvgFillPaint(long var0, long var2);

    public static void nvgFillPaint(@NativeType(value="NVGcontext *") long param0, @NativeType(value="NVGpaint") NVGPaint param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFillPaint(param0, param2.address());
    }

    public static native void nnvgMiterLimit(long var0, float var2);

    public static void nvgMiterLimit(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgMiterLimit(param0, param2);
    }

    public static native void nnvgStrokeWidth(long var0, float var2);

    public static void nvgStrokeWidth(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgStrokeWidth(param0, param2);
    }

    public static native void nnvgLineCap(long var0, int var2);

    public static void nvgLineCap(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgLineCap(param0, param2);
    }

    public static native void nnvgLineJoin(long var0, int var2);

    public static void nvgLineJoin(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgLineJoin(param0, param2);
    }

    public static native void nnvgGlobalAlpha(long var0, float var2);

    public static void nvgGlobalAlpha(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgGlobalAlpha(param0, param2);
    }

    public static native void nnvgResetTransform(long var0);

    public static void nvgResetTransform(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgResetTransform(param0);
    }

    public static native void nnvgTransform(long var0, float var2, float var3, float var4, float var5, float var6, float var7);

    public static void nvgTransform(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTransform(param0, param2, param3, param4, param5, param6, param7);
    }

    public static native void nnvgTranslate(long var0, float var2, float var3);

    public static void nvgTranslate(@NativeType(value="NVGcontext *") long param0, float param2, float param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTranslate(param0, param2, param3);
    }

    public static native void nnvgRotate(long var0, float var2);

    public static void nvgRotate(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRotate(param0, param2);
    }

    public static native void nnvgSkewX(long var0, float var2);

    public static void nvgSkewX(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgSkewX(param0, param2);
    }

    public static native void nnvgSkewY(long var0, float var2);

    public static void nvgSkewY(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgSkewY(param0, param2);
    }

    public static native void nnvgScale(long var0, float var2, float var3);

    public static void nvgScale(@NativeType(value="NVGcontext *") long param0, float param2, float param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgScale(param0, param2, param3);
    }

    public static native void nnvgCurrentTransform(long var0, long var2);

    public static void nvgCurrentTransform(@NativeType(value="NVGcontext *") long param0, @NativeType(value="float *") FloatBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check((Buffer)param2, 6);
        }
        NanoVG.nnvgCurrentTransform(param0, MemoryUtil.memAddress(param2));
    }

    public static native void nnvgTransformIdentity(long var0);

    public static void nvgTransformIdentity(@NativeType(value="float *") FloatBuffer param0) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformIdentity(MemoryUtil.memAddress(param0));
    }

    public static native void nnvgTransformTranslate(long var0, float var2, float var3);

    public static void nvgTransformTranslate(@NativeType(value="float *") FloatBuffer param0, float param1, float param2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformTranslate(MemoryUtil.memAddress(param0), param1, param2);
    }

    public static native void nnvgTransformScale(long var0, float var2, float var3);

    public static void nvgTransformScale(@NativeType(value="float *") FloatBuffer param0, float param1, float param2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformScale(MemoryUtil.memAddress(param0), param1, param2);
    }

    public static native void nnvgTransformRotate(long var0, float var2);

    public static void nvgTransformRotate(@NativeType(value="float *") FloatBuffer param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformRotate(MemoryUtil.memAddress(param0), param1);
    }

    public static native void nnvgTransformSkewX(long var0, float var2);

    public static void nvgTransformSkewX(@NativeType(value="float *") FloatBuffer param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformSkewX(MemoryUtil.memAddress(param0), param1);
    }

    public static native void nnvgTransformSkewY(long var0, float var2);

    public static void nvgTransformSkewY(@NativeType(value="float *") FloatBuffer param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
        }
        NanoVG.nnvgTransformSkewY(MemoryUtil.memAddress(param0), param1);
    }

    public static native void nnvgTransformMultiply(long var0, long var2);

    public static void nvgTransformMultiply(@NativeType(value="float *") FloatBuffer param0, @NativeType(value="float const *") FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
            Checks.check((Buffer)param1, 6);
        }
        NanoVG.nnvgTransformMultiply(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1));
    }

    public static native void nnvgTransformPremultiply(long var0, long var2);

    public static void nvgTransformPremultiply(@NativeType(value="float *") FloatBuffer param0, @NativeType(value="float const *") FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
            Checks.check((Buffer)param1, 6);
        }
        NanoVG.nnvgTransformPremultiply(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1));
    }

    public static native int nnvgTransformInverse(long var0, long var2);

    @NativeType(value="int")
    public static boolean nvgTransformInverse(@NativeType(value="float *") FloatBuffer param0, @NativeType(value="float const *") FloatBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 6);
            Checks.check((Buffer)param1, 6);
        }
        return NanoVG.nnvgTransformInverse(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1)) != 0;
    }

    public static native void nnvgTransformPoint(long var0, long var2, long var4, float var6, float var7);

    public static void nvgTransformPoint(@NativeType(value="float *") FloatBuffer param0, @NativeType(value="float *") FloatBuffer param1, @NativeType(value="float const *") FloatBuffer param2, float param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 1);
            Checks.check((Buffer)param1, 1);
            Checks.check((Buffer)param2, 6);
        }
        NanoVG.nnvgTransformPoint(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), param3, param4);
    }

    public static native float nvgDegToRad(float var0);

    public static native float nvgRadToDeg(float var0);

    public static native int nnvgCreateImage(long var0, long var2, int var4);

    public static int nvgCreateImage(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, int param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return NanoVG.nnvgCreateImage(param0, MemoryUtil.memAddress(param2), param3);
    }

    public static int nvgCreateImage(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, int param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nASCII(param2, true);
            long v6 = v4.getPointerAddress();
            int v8 = NanoVG.nnvgCreateImage(param0, v6, param3);
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native int nnvgCreateImageMem(long var0, int var2, long var3, int var5);

    public static int nvgCreateImageMem(@NativeType(value="NVGcontext *") long param0, int param2, @NativeType(value="unsigned char *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVG.nnvgCreateImageMem(param0, param2, MemoryUtil.memAddress(param3), param3.remaining());
    }

    public static native int nnvgCreateImageRGBA(long var0, int var2, int var3, int var4, long var5);

    public static int nvgCreateImageRGBA(@NativeType(value="NVGcontext *") long param0, int param2, int param3, int param4, @NativeType(value="unsigned char const *") ByteBuffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check((Buffer)param5, param2 * param3 * 4);
        }
        return NanoVG.nnvgCreateImageRGBA(param0, param2, param3, param4, MemoryUtil.memAddress(param5));
    }

    public static native void nnvgUpdateImage(long var0, int var2, long var3);

    public static void nvgUpdateImage(@NativeType(value="NVGcontext *") long param0, int param2, @NativeType(value="unsigned char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgUpdateImage(param0, param2, MemoryUtil.memAddress(param3));
    }

    public static native void nnvgImageSize(long var0, int var2, long var3, long var5);

    public static void nvgImageSize(@NativeType(value="NVGcontext *") long param0, int param2, @NativeType(value="int *") IntBuffer param3, @NativeType(value="int *") IntBuffer param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check((Buffer)param3, 1);
            Checks.check((Buffer)param4, 1);
        }
        NanoVG.nnvgImageSize(param0, param2, MemoryUtil.memAddress(param3), MemoryUtil.memAddress(param4));
    }

    public static native void nnvgDeleteImage(long var0, int var2);

    public static void nvgDeleteImage(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgDeleteImage(param0, param2);
    }

    public static native void nnvgLinearGradient(long var0, float var2, float var3, float var4, float var5, long var6, long var8, long var10);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgLinearGradient(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="NVGcolor") NVGColor param6, @NativeType(value="NVGcolor") NVGColor param7, @NativeType(value="NVGpaint") NVGPaint param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgLinearGradient(param0, param2, param3, param4, param5, param6.address(), param7.address(), param8.address());
        return param8;
    }

    public static native void nnvgBoxGradient(long var0, float var2, float var3, float var4, float var5, float var6, float var7, long var8, long var10, long var12);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgBoxGradient(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, @NativeType(value="NVGcolor") NVGColor param8, @NativeType(value="NVGcolor") NVGColor param9, @NativeType(value="NVGpaint") NVGPaint param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgBoxGradient(param0, param2, param3, param4, param5, param6, param7, param8.address(), param9.address(), param10.address());
        return param10;
    }

    public static native void nnvgRadialGradient(long var0, float var2, float var3, float var4, float var5, long var6, long var8, long var10);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgRadialGradient(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="NVGcolor") NVGColor param6, @NativeType(value="NVGcolor") NVGColor param7, @NativeType(value="NVGpaint") NVGPaint param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRadialGradient(param0, param2, param3, param4, param5, param6.address(), param7.address(), param8.address());
        return param8;
    }

    public static native void nnvgImagePattern(long var0, float var2, float var3, float var4, float var5, float var6, int var7, float var8, long var9);

    @NativeType(value="NVGpaint")
    public static NVGPaint nvgImagePattern(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, int param7, float param8, @NativeType(value="NVGpaint") NVGPaint param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgImagePattern(param0, param2, param3, param4, param5, param6, param7, param8, param9.address());
        return param9;
    }

    public static native void nnvgScissor(long var0, float var2, float var3, float var4, float var5);

    public static void nvgScissor(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgScissor(param0, param2, param3, param4, param5);
    }

    public static native void nnvgIntersectScissor(long var0, float var2, float var3, float var4, float var5);

    public static void nvgIntersectScissor(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgIntersectScissor(param0, param2, param3, param4, param5);
    }

    public static native void nnvgResetScissor(long var0);

    public static void nvgResetScissor(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgResetScissor(param0);
    }

    public static native void nnvgBeginPath(long var0);

    public static void nvgBeginPath(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgBeginPath(param0);
    }

    public static native void nnvgMoveTo(long var0, float var2, float var3);

    public static void nvgMoveTo(@NativeType(value="NVGcontext *") long param0, float param2, float param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgMoveTo(param0, param2, param3);
    }

    public static native void nnvgLineTo(long var0, float var2, float var3);

    public static void nvgLineTo(@NativeType(value="NVGcontext *") long param0, float param2, float param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgLineTo(param0, param2, param3);
    }

    public static native void nnvgBezierTo(long var0, float var2, float var3, float var4, float var5, float var6, float var7);

    public static void nvgBezierTo(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgBezierTo(param0, param2, param3, param4, param5, param6, param7);
    }

    public static native void nnvgQuadTo(long var0, float var2, float var3, float var4, float var5);

    public static void nvgQuadTo(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgQuadTo(param0, param2, param3, param4, param5);
    }

    public static native void nnvgArcTo(long var0, float var2, float var3, float var4, float var5, float var6);

    public static void nvgArcTo(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgArcTo(param0, param2, param3, param4, param5, param6);
    }

    public static native void nnvgClosePath(long var0);

    public static void nvgClosePath(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgClosePath(param0);
    }

    public static native void nnvgPathWinding(long var0, int var2);

    public static void nvgPathWinding(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgPathWinding(param0, param2);
    }

    public static native void nnvgArc(long var0, float var2, float var3, float var4, float var5, float var6, int var7);

    public static void nvgArc(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, int param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgArc(param0, param2, param3, param4, param5, param6, param7);
    }

    public static native void nnvgRect(long var0, float var2, float var3, float var4, float var5);

    public static void nvgRect(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRect(param0, param2, param3, param4, param5);
    }

    public static native void nnvgRoundedRect(long var0, float var2, float var3, float var4, float var5, float var6);

    public static void nvgRoundedRect(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRoundedRect(param0, param2, param3, param4, param5, param6);
    }

    public static native void nnvgRoundedRectVarying(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);

    public static void nvgRoundedRectVarying(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgRoundedRectVarying(param0, param2, param3, param4, param5, param6, param7, param8, param9);
    }

    public static native void nnvgEllipse(long var0, float var2, float var3, float var4, float var5);

    public static void nvgEllipse(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgEllipse(param0, param2, param3, param4, param5);
    }

    public static native void nnvgCircle(long var0, float var2, float var3, float var4);

    public static void nvgCircle(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgCircle(param0, param2, param3, param4);
    }

    public static native void nnvgFill(long var0);

    public static void nvgFill(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFill(param0);
    }

    public static native void nnvgStroke(long var0);

    public static void nvgStroke(@NativeType(value="NVGcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgStroke(param0);
    }

    public static native int nnvgCreateFont(long var0, long var2, long var4);

    public static int nvgCreateFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
            Checks.checkNT1(param3);
        }
        return NanoVG.nnvgCreateFont(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3));
    }

    public static int nvgCreateFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="char const *") CharSequence param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nASCII(param2, true);
            long v6 = v4.getPointerAddress();
            v4.nASCII(param3, true);
            long v8 = v4.getPointerAddress();
            int v10 = NanoVG.nnvgCreateFont(param0, v6, v8);
            return v10;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native int nnvgCreateFontAtIndex(long var0, long var2, long var4, int var6);

    public static int nvgCreateFontAtIndex(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
            Checks.checkNT1(param3);
        }
        return NanoVG.nnvgCreateFontAtIndex(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param4);
    }

    public static int nvgCreateFontAtIndex(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="char const *") CharSequence param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nASCII(param2, true);
            long v7 = v5.getPointerAddress();
            v5.nASCII(param3, true);
            long v9 = v5.getPointerAddress();
            int v11 = NanoVG.nnvgCreateFontAtIndex(param0, v7, v9, param4);
            return v11;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native int nnvgCreateFontMem(long var0, long var2, long var4, int var6, int var7);

    public static int nvgCreateFontMem(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="unsigned char *") ByteBuffer param3, @NativeType(value="int") boolean param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return NanoVG.nnvgCreateFontMem(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param3.remaining(), param4 ? 1 : 0);
    }

    public static int nvgCreateFontMem(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="unsigned char *") ByteBuffer param3, @NativeType(value="int") boolean param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nASCII(param2, true);
            long v7 = v5.getPointerAddress();
            int v9 = NanoVG.nnvgCreateFontMem(param0, v7, MemoryUtil.memAddress(param3), param3.remaining(), param4 ? 1 : 0);
            return v9;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native int nnvgCreateFontMemAtIndex(long var0, long var2, long var4, int var6, int var7, int var8);

    public static int nvgCreateFontMemAtIndex(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="unsigned char *") ByteBuffer param3, @NativeType(value="int") boolean param4, int param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return NanoVG.nnvgCreateFontMemAtIndex(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param3.remaining(), param4 ? 1 : 0, param5);
    }

    public static int nvgCreateFontMemAtIndex(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="unsigned char *") ByteBuffer param3, @NativeType(value="int") boolean param4, int param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nASCII(param2, true);
            long v8 = v6.getPointerAddress();
            int v10 = NanoVG.nnvgCreateFontMemAtIndex(param0, v8, MemoryUtil.memAddress(param3), param3.remaining(), param4 ? 1 : 0, param5);
            return v10;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native int nnvgFindFont(long var0, long var2);

    public static int nvgFindFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        return NanoVG.nnvgFindFont(param0, MemoryUtil.memAddress(param2));
    }

    public static int nvgFindFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            int v7 = NanoVG.nnvgFindFont(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int nnvgAddFallbackFontId(long var0, int var2, int var3);

    public static int nvgAddFallbackFontId(@NativeType(value="NVGcontext *") long param0, int param2, int param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVG.nnvgAddFallbackFontId(param0, param2, param3);
    }

    public static native int nnvgAddFallbackFont(long var0, long var2, long var4);

    public static int nvgAddFallbackFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
            Checks.checkNT1(param3);
        }
        return NanoVG.nnvgAddFallbackFont(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3));
    }

    public static int nvgAddFallbackFont(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="char const *") CharSequence param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nASCII(param2, true);
            long v6 = v4.getPointerAddress();
            v4.nASCII(param3, true);
            long v8 = v4.getPointerAddress();
            int v10 = NanoVG.nnvgAddFallbackFont(param0, v6, v8);
            return v10;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nnvgResetFallbackFontsId(long var0, int var2);

    public static void nvgResetFallbackFontsId(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgResetFallbackFontsId(param0, param2);
    }

    public static native void nnvgResetFallbackFonts(long var0, long var2);

    public static void nvgResetFallbackFonts(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        NanoVG.nnvgResetFallbackFonts(param0, MemoryUtil.memAddress(param2));
    }

    public static void nvgResetFallbackFonts(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            NanoVG.nnvgResetFallbackFonts(param0, v5);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native void nnvgFontSize(long var0, float var2);

    public static void nvgFontSize(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFontSize(param0, param2);
    }

    public static native void nnvgFontBlur(long var0, float var2);

    public static void nvgFontBlur(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFontBlur(param0, param2);
    }

    public static native void nnvgTextLetterSpacing(long var0, float var2);

    public static void nvgTextLetterSpacing(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTextLetterSpacing(param0, param2);
    }

    public static native void nnvgTextLineHeight(long var0, float var2);

    public static void nvgTextLineHeight(@NativeType(value="NVGcontext *") long param0, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTextLineHeight(param0, param2);
    }

    public static native void nnvgTextAlign(long var0, int var2);

    public static void nvgTextAlign(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTextAlign(param0, param2);
    }

    public static native void nnvgFontFaceId(long var0, int var2);

    public static void nvgFontFaceId(@NativeType(value="NVGcontext *") long param0, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgFontFaceId(param0, param2);
    }

    public static native void nnvgFontFace(long var0, long var2);

    public static void nvgFontFace(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1(param2);
        }
        NanoVG.nnvgFontFace(param0, MemoryUtil.memAddress(param2));
    }

    public static void nvgFontFace(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            NanoVG.nnvgFontFace(param0, v5);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native float nnvgText(long var0, float var2, float var3, long var4, long var6);

    public static float nvgText(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") ByteBuffer param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVG.nnvgText(param0, param2, param3, MemoryUtil.memAddress(param4), MemoryUtil.memAddress(param4) + (long)param4.remaining());
    }

    public static float nvgText(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") CharSequence param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            int v7 = v5.nUTF8(param4, false);
            long v8 = v5.getPointerAddress();
            float v10 = NanoVG.nnvgText(param0, param2, param3, v8, v8 + (long)v7);
            return v10;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nnvgTextBox(long var0, float var2, float var3, float var4, long var5, long var7);

    public static void nvgTextBox(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") ByteBuffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoVG.nnvgTextBox(param0, param2, param3, param4, MemoryUtil.memAddress(param5), MemoryUtil.memAddress(param5) + (long)param5.remaining());
    }

    public static void nvgTextBox(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") CharSequence param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            int v8 = v6.nUTF8(param5, false);
            long v9 = v6.getPointerAddress();
            NanoVG.nnvgTextBox(param0, param2, param3, param4, v9, v9 + (long)v8);
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native float nnvgTextBounds(long var0, float var2, float var3, long var4, long var6, long var8);

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") ByteBuffer param4, @Nullable @NativeType(value="float *") FloatBuffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe((Buffer)param5, 4);
        }
        return NanoVG.nnvgTextBounds(param0, param2, param3, MemoryUtil.memAddress(param4), MemoryUtil.memAddress(param4) + (long)param4.remaining(), MemoryUtil.memAddressSafe(param5));
    }

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") CharSequence param4, @Nullable @NativeType(value="float *") FloatBuffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe((Buffer)param5, 4);
        }
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            int v8 = v6.nUTF8(param4, false);
            long v9 = v6.getPointerAddress();
            float v11 = NanoVG.nnvgTextBounds(param0, param2, param3, v9, v9 + (long)v8, MemoryUtil.memAddressSafe(param5));
            return v11;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nnvgTextBoxBounds(long var0, float var2, float var3, float var4, long var5, long var7, long var9);

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") ByteBuffer param5, @Nullable @NativeType(value="float *") FloatBuffer param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe((Buffer)param6, 4);
        }
        NanoVG.nnvgTextBoxBounds(param0, param2, param3, param4, MemoryUtil.memAddress(param5), MemoryUtil.memAddress(param5) + (long)param5.remaining(), MemoryUtil.memAddressSafe(param6));
    }

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") CharSequence param5, @Nullable @NativeType(value="float *") FloatBuffer param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe((Buffer)param6, 4);
        }
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            int v9 = v7.nUTF8(param5, false);
            long v10 = v7.getPointerAddress();
            NanoVG.nnvgTextBoxBounds(param0, param2, param3, param4, v10, v10 + (long)v9, MemoryUtil.memAddressSafe(param6));
            return;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static native int nnvgTextGlyphPositions(long var0, float var2, float var3, long var4, long var6, long var8, int var10);

    public static int nvgTextGlyphPositions(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") ByteBuffer param4, @NativeType(value="NVGglyphPosition *") NVGGlyphPosition.Buffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVG.nnvgTextGlyphPositions(param0, param2, param3, MemoryUtil.memAddress(param4), MemoryUtil.memAddress(param4) + (long)param4.remaining(), param5.address(), param5.remaining());
    }

    public static int nvgTextGlyphPositions(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") CharSequence param4, @NativeType(value="NVGglyphPosition *") NVGGlyphPosition.Buffer param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            int v8 = v6.nUTF8(param4, false);
            long v9 = v6.getPointerAddress();
            int v11 = NanoVG.nnvgTextGlyphPositions(param0, param2, param3, v9, v9 + (long)v8, param5.address(), param5.remaining());
            return v11;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nnvgTextMetrics(long var0, long var2, long var4, long var6);

    public static void nvgTextMetrics(@NativeType(value="NVGcontext *") long param0, @Nullable @NativeType(value="float *") FloatBuffer param2, @Nullable @NativeType(value="float *") FloatBuffer param3, @Nullable @NativeType(value="float *") FloatBuffer param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe((Buffer)param2, 1);
            Checks.checkSafe((Buffer)param3, 1);
            Checks.checkSafe((Buffer)param4, 1);
        }
        NanoVG.nnvgTextMetrics(param0, MemoryUtil.memAddressSafe(param2), MemoryUtil.memAddressSafe(param3), MemoryUtil.memAddressSafe(param4));
    }

    public static native int nnvgTextBreakLines(long var0, long var2, long var4, float var6, long var7, int var9);

    public static int nvgTextBreakLines(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") ByteBuffer param2, float param3, @NativeType(value="NVGtextRow *") NVGTextRow.Buffer param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return NanoVG.nnvgTextBreakLines(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param2) + (long)param2.remaining(), param3, param4.address(), param4.remaining());
    }

    public static int nvgTextBreakLines(@NativeType(value="NVGcontext *") long param0, @NativeType(value="char const *") CharSequence param2, float param3, @NativeType(value="NVGtextRow *") NVGTextRow.Buffer param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            int v7 = v5.nUTF8(param2, false);
            long v8 = v5.getPointerAddress();
            int v10 = NanoVG.nnvgTextBreakLines(param0, v8, v8 + (long)v7, param3, param4.address(), param4.remaining());
            return v10;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    @NativeType(value="void *")
    private static native long nvgCreateInternal();

    @NativeType(value="void *")
    private static native long nvgInternalParams();

    @NativeType(value="void *")
    private static native long nvgDeleteInternal();

    public static native void nnvgCurrentTransform(long var0, float[] var2);

    public static void nvgCurrentTransform(@NativeType(value="NVGcontext *") long param0, @NativeType(value="float *") float[] param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2, 6);
        }
        NanoVG.nnvgCurrentTransform(param0, param2);
    }

    public static native void nnvgTransformIdentity(float[] var0);

    public static void nvgTransformIdentity(@NativeType(value="float *") float[] param0) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformIdentity(param0);
    }

    public static native void nnvgTransformTranslate(float[] var0, float var1, float var2);

    public static void nvgTransformTranslate(@NativeType(value="float *") float[] param0, float param1, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformTranslate(param0, param1, param2);
    }

    public static native void nnvgTransformScale(float[] var0, float var1, float var2);

    public static void nvgTransformScale(@NativeType(value="float *") float[] param0, float param1, float param2) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformScale(param0, param1, param2);
    }

    public static native void nnvgTransformRotate(float[] var0, float var1);

    public static void nvgTransformRotate(@NativeType(value="float *") float[] param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformRotate(param0, param1);
    }

    public static native void nnvgTransformSkewX(float[] var0, float var1);

    public static void nvgTransformSkewX(@NativeType(value="float *") float[] param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformSkewX(param0, param1);
    }

    public static native void nnvgTransformSkewY(float[] var0, float var1);

    public static void nvgTransformSkewY(@NativeType(value="float *") float[] param0, float param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
        }
        NanoVG.nnvgTransformSkewY(param0, param1);
    }

    public static native void nnvgTransformMultiply(float[] var0, float[] var1);

    public static void nvgTransformMultiply(@NativeType(value="float *") float[] param0, @NativeType(value="float const *") float[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
            Checks.check(param1, 6);
        }
        NanoVG.nnvgTransformMultiply(param0, param1);
    }

    public static native void nnvgTransformPremultiply(float[] var0, float[] var1);

    public static void nvgTransformPremultiply(@NativeType(value="float *") float[] param0, @NativeType(value="float const *") float[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
            Checks.check(param1, 6);
        }
        NanoVG.nnvgTransformPremultiply(param0, param1);
    }

    public static native int nnvgTransformInverse(float[] var0, float[] var1);

    @NativeType(value="int")
    public static boolean nvgTransformInverse(@NativeType(value="float *") float[] param0, @NativeType(value="float const *") float[] param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 6);
            Checks.check(param1, 6);
        }
        return NanoVG.nnvgTransformInverse(param0, param1) != 0;
    }

    public static native void nnvgTransformPoint(float[] var0, float[] var1, float[] var2, float var3, float var4);

    public static void nvgTransformPoint(@NativeType(value="float *") float[] param0, @NativeType(value="float *") float[] param1, @NativeType(value="float const *") float[] param2, float param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check(param0, 1);
            Checks.check(param1, 1);
            Checks.check(param2, 6);
        }
        NanoVG.nnvgTransformPoint(param0, param1, param2, param3, param4);
    }

    public static native void nnvgImageSize(long var0, int var2, int[] var3, int[] var4);

    public static void nvgImageSize(@NativeType(value="NVGcontext *") long param0, int param2, @NativeType(value="int *") int[] param3, @NativeType(value="int *") int[] param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param3, 1);
            Checks.check(param4, 1);
        }
        NanoVG.nnvgImageSize(param0, param2, param3, param4);
    }

    public static native float nnvgTextBounds(long var0, float var2, float var3, long var4, long var6, float[] var8);

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") ByteBuffer param4, @Nullable @NativeType(value="float *") float[] param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe(param5, 4);
        }
        return NanoVG.nnvgTextBounds(param0, param2, param3, MemoryUtil.memAddress(param4), MemoryUtil.memAddress(param4) + (long)param4.remaining(), param5);
    }

    public static float nvgTextBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="char const *") CharSequence param4, @Nullable @NativeType(value="float *") float[] param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe(param5, 4);
        }
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            int v8 = v6.nUTF8(param4, false);
            long v9 = v6.getPointerAddress();
            float v11 = NanoVG.nnvgTextBounds(param0, param2, param3, v9, v9 + (long)v8, param5);
            return v11;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nnvgTextBoxBounds(long var0, float var2, float var3, float var4, long var5, long var7, float[] var9);

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") ByteBuffer param5, @Nullable @NativeType(value="float *") float[] param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe(param6, 4);
        }
        NanoVG.nnvgTextBoxBounds(param0, param2, param3, param4, MemoryUtil.memAddress(param5), MemoryUtil.memAddress(param5) + (long)param5.remaining(), param6);
    }

    public static void nvgTextBoxBounds(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="char const *") CharSequence param5, @Nullable @NativeType(value="float *") float[] param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe(param6, 4);
        }
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            int v9 = v7.nUTF8(param5, false);
            long v10 = v7.getPointerAddress();
            NanoVG.nnvgTextBoxBounds(param0, param2, param3, param4, v10, v10 + (long)v9, param6);
            return;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static native void nnvgTextMetrics(long var0, float[] var2, float[] var3, float[] var4);

    public static void nvgTextMetrics(@NativeType(value="NVGcontext *") long param0, @Nullable @NativeType(value="float *") float[] param2, @Nullable @NativeType(value="float *") float[] param3, @Nullable @NativeType(value="float *") float[] param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkSafe(param2, 1);
            Checks.checkSafe(param3, 1);
            Checks.checkSafe(param4, 1);
        }
        NanoVG.nnvgTextMetrics(param0, param2, param3, param4);
    }

    static {
        NVG_IMAGE_NEAREST = 32;
        NVG_IMAGE_PREMULTIPLIED = 16;
        NVG_IMAGE_FLIPY = 8;
        NVG_IMAGE_REPEATY = 4;
        NVG_IMAGE_REPEATX = 2;
        NVG_IMAGE_GENERATE_MIPMAPS = 1;
        NVG_XOR = 10;
        NVG_COPY = 9;
        NVG_LIGHTER = 8;
        NVG_DESTINATION_ATOP = 7;
        NVG_DESTINATION_OUT = 6;
        NVG_DESTINATION_IN = 5;
        NVG_DESTINATION_OVER = 4;
        NVG_ATOP = 3;
        NVG_SOURCE_OUT = 2;
        NVG_SOURCE_IN = 1;
        NVG_SOURCE_OVER = 0;
        NVG_SRC_ALPHA_SATURATE = 1024;
        NVG_ONE_MINUS_DST_ALPHA = 512;
        NVG_DST_ALPHA = 256;
        NVG_ONE_MINUS_SRC_ALPHA = 128;
        NVG_SRC_ALPHA = 64;
        NVG_ONE_MINUS_DST_COLOR = 32;
        NVG_DST_COLOR = 16;
        NVG_ONE_MINUS_SRC_COLOR = 8;
        NVG_SRC_COLOR = 4;
        NVG_ONE = 2;
        NVG_ZERO = 1;
        NVG_ALIGN_BASELINE = 64;
        NVG_ALIGN_BOTTOM = 32;
        NVG_ALIGN_MIDDLE = 16;
        NVG_ALIGN_TOP = 8;
        NVG_ALIGN_RIGHT = 4;
        NVG_ALIGN_CENTER = 2;
        NVG_ALIGN_LEFT = 1;
        NVG_MITER = 4;
        NVG_BEVEL = 3;
        NVG_SQUARE = 2;
        NVG_ROUND = 1;
        NVG_BUTT = 0;
        NVG_HOLE = 2;
        NVG_SOLID = 1;
        NVG_CW = 2;
        NVG_CCW = 1;
        NVG_PI = (float)Math.PI;
        LibNanoVG.initialize();
        nvgCreateInternal = NanoVG.nvgCreateInternal();
        nvgInternalParams = NanoVG.nvgInternalParams();
        nvgDeleteInternal = NanoVG.nvgDeleteInternal();
    }
}

