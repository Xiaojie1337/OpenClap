/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NSVGImage;
import org.lwjgl.nanovg.NSVGPath;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NanoSVG {
    public static final int NSVG_PAINT_UNDEF;
    public static final int NSVG_PAINT_NONE;
    public static final int NSVG_PAINT_COLOR;
    public static final int NSVG_PAINT_LINEAR_GRADIENT;
    public static final int NSVG_PAINT_RADIAL_GRADIENT;
    public static final int NSVG_SPREAD_PAD;
    public static final int NSVG_SPREAD_REFLECT;
    public static final int NSVG_SPREAD_REPEAT;
    public static final int NSVG_JOIN_MITER;
    public static final int NSVG_JOIN_ROUND;
    public static final int NSVG_JOIN_BEVEL;
    public static final int NSVG_CAP_BUTT;
    public static final int NSVG_CAP_ROUND;
    public static final int NSVG_CAP_SQUARE;
    public static final int NSVG_FILLRULE_NONZERO;
    public static final int NSVG_FILLRULE_EVENODD;
    public static final int NSVG_FLAGS_VISIBLE;

    protected NanoSVG() {
        throw new UnsupportedOperationException();
    }

    public static native long nnsvgParseFromFile(long var0, long var2, float var4);

    @Nullable
    @NativeType(value="NSVGimage *")
    public static NSVGImage nsvgParseFromFile(@NativeType(value="char const *") ByteBuffer param0, @NativeType(value="char const *") ByteBuffer param1, float param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
            Checks.checkNT1(param1);
        }
        long v3 = NanoSVG.nnsvgParseFromFile(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), param2);
        return NSVGImage.createSafe(v3);
    }

    @Nullable
    @NativeType(value="NSVGimage *")
    public static NSVGImage nsvgParseFromFile(@NativeType(value="char const *") CharSequence param0, @NativeType(value="char const *") CharSequence param1, float param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param0, true);
            long v5 = v3.getPointerAddress();
            v3.nASCII(param1, true);
            long v7 = v3.getPointerAddress();
            long v9 = NanoSVG.nnsvgParseFromFile(v5, v7, param2);
            NSVGImage v11 = NSVGImage.createSafe(v9);
            return v11;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native long nnsvgParse(long var0, long var2, float var4);

    @Nullable
    @NativeType(value="NSVGimage *")
    public static NSVGImage nsvgParse(@NativeType(value="char *") ByteBuffer param0, @NativeType(value="char const *") ByteBuffer param1, float param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
            Checks.checkNT1(param1);
        }
        long v3 = NanoSVG.nnsvgParse(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), param2);
        return NSVGImage.createSafe(v3);
    }

    @Nullable
    @NativeType(value="NSVGimage *")
    public static NSVGImage nsvgParse(@NativeType(value="char *") CharSequence param0, @NativeType(value="char const *") CharSequence param1, float param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param0, true);
            long v5 = v3.getPointerAddress();
            v3.nASCII(param1, true);
            long v7 = v3.getPointerAddress();
            long v9 = NanoSVG.nnsvgParse(v5, v7, param2);
            NSVGImage v11 = NSVGImage.createSafe(v9);
            return v11;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native long nnsvgDuplicatePath(long var0);

    @Nullable
    @NativeType(value="NSVGpath *")
    public static NSVGPath nsvgDuplicatePath(@NativeType(value="NSVGpath *") NSVGPath param0) {
        long v1 = NanoSVG.nnsvgDuplicatePath(param0.address());
        return NSVGPath.createSafe(v1);
    }

    public static native void nnsvgDelete(long var0);

    public static void nsvgDelete(@NativeType(value="NSVGimage *") NSVGImage param0) {
        NanoSVG.nnsvgDelete(param0.address());
    }

    @NativeType(value="NSVGrasterizer *")
    public static native long nsvgCreateRasterizer();

    public static native void nnsvgRasterize(long var0, long var2, float var4, float var5, float var6, long var7, int var9, int var10, int var11);

    public static void nsvgRasterize(@NativeType(value="NSVGrasterizer *") long param0, @NativeType(value="NSVGimage *") NSVGImage param2, float param3, float param4, float param5, @NativeType(value="unsigned char *") ByteBuffer param6, int param7, int param8, int param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check((Buffer)param6, param8 * param9);
        }
        NanoSVG.nnsvgRasterize(param0, param2.address(), param3, param4, param5, MemoryUtil.memAddress(param6), param7, param8, param9);
    }

    public static native void nnsvgDeleteRasterizer(long var0);

    public static void nsvgDeleteRasterizer(@NativeType(value="NSVGrasterizer *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        NanoSVG.nnsvgDeleteRasterizer(param0);
    }

    static {
        NSVG_FLAGS_VISIBLE = 1;
        NSVG_FILLRULE_EVENODD = 1;
        NSVG_FILLRULE_NONZERO = 0;
        NSVG_CAP_SQUARE = 2;
        NSVG_CAP_ROUND = 1;
        NSVG_CAP_BUTT = 0;
        NSVG_JOIN_BEVEL = 2;
        NSVG_JOIN_ROUND = 1;
        NSVG_JOIN_MITER = 0;
        NSVG_SPREAD_REPEAT = 2;
        NSVG_SPREAD_REFLECT = 1;
        NSVG_SPREAD_PAD = 0;
        NSVG_PAINT_RADIAL_GRADIENT = 3;
        NSVG_PAINT_LINEAR_GRADIENT = 2;
        NSVG_PAINT_COLOR = 1;
        NSVG_PAINT_NONE = 0;
        NSVG_PAINT_UNDEF = -1;
        LibNanoVG.initialize();
    }
}

