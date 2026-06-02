/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.NSVGPaint;
import org.lwjgl.nanovg.NSVGPath;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGshape")
public class NSVGShape
extends Struct<NSVGShape> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ID;
    public static final int FILL;
    public static final int STROKE;
    public static final int OPACITY;
    public static final int STROKEWIDTH;
    public static final int STROKEDASHOFFSET;
    public static final int STROKEDASHARRAY;
    public static final int STROKEDASHCOUNT;
    public static final int STROKELINEJOIN;
    public static final int STROKELINECAP;
    public static final int MITERLIMIT;
    public static final int FILLRULE;
    public static final int FLAGS;
    public static final int BOUNDS;
    public static final int FILLGRADIENT;
    public static final int STROKEGRADIENT;
    public static final int XFORM;
    public static final int PATHS;
    public static final int NEXT;

    protected NSVGShape(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGShape create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGShape(param1, param3);
    }

    public NSVGShape(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGShape.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char[64]")
    public ByteBuffer id() {
        return NSVGShape.nid(this.address());
    }

    @NativeType(value="char[64]")
    public String idString() {
        return NSVGShape.nidString(this.address());
    }

    @NativeType(value="NSVGpaint")
    public NSVGPaint fill() {
        return NSVGShape.nfill(this.address());
    }

    @NativeType(value="NSVGpaint")
    public NSVGPaint stroke() {
        return NSVGShape.nstroke(this.address());
    }

    public float opacity() {
        return NSVGShape.nopacity(this.address());
    }

    public float strokeWidth() {
        return NSVGShape.nstrokeWidth(this.address());
    }

    public float strokeDashOffset() {
        return NSVGShape.nstrokeDashOffset(this.address());
    }

    @NativeType(value="float[8]")
    public FloatBuffer strokeDashArray() {
        return NSVGShape.nstrokeDashArray(this.address());
    }

    public float strokeDashArray(int param1) {
        return NSVGShape.nstrokeDashArray(this.address(), param1);
    }

    @NativeType(value="char")
    public byte strokeDashCount() {
        return NSVGShape.nstrokeDashCount(this.address());
    }

    @NativeType(value="char")
    public byte strokeLineJoin() {
        return NSVGShape.nstrokeLineJoin(this.address());
    }

    @NativeType(value="char")
    public byte strokeLineCap() {
        return NSVGShape.nstrokeLineCap(this.address());
    }

    public float miterLimit() {
        return NSVGShape.nmiterLimit(this.address());
    }

    @NativeType(value="char")
    public byte fillRule() {
        return NSVGShape.nfillRule(this.address());
    }

    @NativeType(value="unsigned char")
    public byte flags() {
        return NSVGShape.nflags(this.address());
    }

    @NativeType(value="float[4]")
    public FloatBuffer bounds() {
        return NSVGShape.nbounds(this.address());
    }

    public float bounds(int param1) {
        return NSVGShape.nbounds(this.address(), param1);
    }

    @NativeType(value="char[64]")
    public ByteBuffer fillGradient() {
        return NSVGShape.nfillGradient(this.address());
    }

    @NativeType(value="char[64]")
    public String fillGradientString() {
        return NSVGShape.nfillGradientString(this.address());
    }

    @NativeType(value="char[64]")
    public ByteBuffer strokeGradient() {
        return NSVGShape.nstrokeGradient(this.address());
    }

    @NativeType(value="char[64]")
    public String strokeGradientString() {
        return NSVGShape.nstrokeGradientString(this.address());
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NSVGShape.nxform(this.address());
    }

    public float xform(int param1) {
        return NSVGShape.nxform(this.address(), param1);
    }

    @NativeType(value="NSVGpath *")
    public NSVGPath paths() {
        return NSVGShape.npaths(this.address());
    }

    @NativeType(value="NSVGshape *")
    public NSVGShape next() {
        return NSVGShape.nnext(this.address());
    }

    public static NSVGShape create(long param0) {
        return new NSVGShape(param0, null);
    }

    @Nullable
    public static NSVGShape createSafe(long param0) {
        return param0 == 0L ? null : new NSVGShape(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static ByteBuffer nid(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)ID, 64);
    }

    public static String nidString(long param0) {
        return MemoryUtil.memASCII(param0 + (long)ID);
    }

    public static NSVGPaint nfill(long param0) {
        return NSVGPaint.create(param0 + (long)FILL);
    }

    public static NSVGPaint nstroke(long param0) {
        return NSVGPaint.create(param0 + (long)STROKE);
    }

    public static float nopacity(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)OPACITY);
    }

    public static float nstrokeWidth(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)STROKEWIDTH);
    }

    public static float nstrokeDashOffset(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)STROKEDASHOFFSET);
    }

    public static FloatBuffer nstrokeDashArray(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)STROKEDASHARRAY, 8);
    }

    public static float nstrokeDashArray(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)STROKEDASHARRAY + Checks.check(param2, 8) * 4L);
    }

    public static byte nstrokeDashCount(long param0) {
        return UNSAFE.getByte(null, param0 + (long)STROKEDASHCOUNT);
    }

    public static byte nstrokeLineJoin(long param0) {
        return UNSAFE.getByte(null, param0 + (long)STROKELINEJOIN);
    }

    public static byte nstrokeLineCap(long param0) {
        return UNSAFE.getByte(null, param0 + (long)STROKELINECAP);
    }

    public static float nmiterLimit(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MITERLIMIT);
    }

    public static byte nfillRule(long param0) {
        return UNSAFE.getByte(null, param0 + (long)FILLRULE);
    }

    public static byte nflags(long param0) {
        return UNSAFE.getByte(null, param0 + (long)FLAGS);
    }

    public static FloatBuffer nbounds(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)BOUNDS, 4);
    }

    public static float nbounds(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)BOUNDS + Checks.check(param2, 4) * 4L);
    }

    public static ByteBuffer nfillGradient(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)FILLGRADIENT, 64);
    }

    public static String nfillGradientString(long param0) {
        return MemoryUtil.memASCII(param0 + (long)FILLGRADIENT);
    }

    public static ByteBuffer nstrokeGradient(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)STROKEGRADIENT, 64);
    }

    public static String nstrokeGradientString(long param0) {
        return MemoryUtil.memASCII(param0 + (long)STROKEGRADIENT);
    }

    public static FloatBuffer nxform(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)XFORM, 6);
    }

    public static float nxform(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)XFORM + Checks.check(param2, 6) * 4L);
    }

    public static NSVGPath npaths(long param0) {
        return NSVGPath.create(MemoryUtil.memGetAddress(param0 + (long)PATHS));
    }

    public static NSVGShape nnext(long param0) {
        return NSVGShape.create(MemoryUtil.memGetAddress(param0 + (long)NEXT));
    }

    static {
        Struct.Layout v0 = NSVGShape.__struct(NSVGShape.__array(1, 64), NSVGShape.__member(NSVGPaint.SIZEOF, NSVGPaint.ALIGNOF), NSVGShape.__member(NSVGPaint.SIZEOF, NSVGPaint.ALIGNOF), NSVGShape.__member(4), NSVGShape.__member(4), NSVGShape.__member(4), NSVGShape.__array(4, 8), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__member(4), NSVGShape.__member(1), NSVGShape.__member(1), NSVGShape.__array(4, 4), NSVGShape.__array(1, 64), NSVGShape.__array(1, 64), NSVGShape.__array(4, 6), NSVGShape.__member(POINTER_SIZE), NSVGShape.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        ID = v0.offsetof(0);
        FILL = v0.offsetof(1);
        STROKE = v0.offsetof(2);
        OPACITY = v0.offsetof(3);
        STROKEWIDTH = v0.offsetof(4);
        STROKEDASHOFFSET = v0.offsetof(5);
        STROKEDASHARRAY = v0.offsetof(6);
        STROKEDASHCOUNT = v0.offsetof(7);
        STROKELINEJOIN = v0.offsetof(8);
        STROKELINECAP = v0.offsetof(9);
        MITERLIMIT = v0.offsetof(10);
        FILLRULE = v0.offsetof(11);
        FLAGS = v0.offsetof(12);
        BOUNDS = v0.offsetof(13);
        FILLGRADIENT = v0.offsetof(14);
        STROKEGRADIENT = v0.offsetof(15);
        XFORM = v0.offsetof(16);
        PATHS = v0.offsetof(17);
        NEXT = v0.offsetof(18);
    }

    public static class Buffer
    extends StructBuffer<NSVGShape, Buffer> {
        private static final NSVGShape ELEMENT_FACTORY = NSVGShape.create(-1L);

        public Buffer(ByteBuffer param1) {
            super(param1, param1.remaining() / SIZEOF);
        }

        public Buffer(long param1, int param3) {
            super(param1, null, -1, 0, param3, param3);
        }

        Buffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
            super(param1, param3, param4, param5, param6, param7);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected NSVGShape getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char[64]")
        public ByteBuffer id() {
            return NSVGShape.nid(this.address());
        }

        @NativeType(value="char[64]")
        public String idString() {
            return NSVGShape.nidString(this.address());
        }

        @NativeType(value="NSVGpaint")
        public NSVGPaint fill() {
            return NSVGShape.nfill(this.address());
        }

        @NativeType(value="NSVGpaint")
        public NSVGPaint stroke() {
            return NSVGShape.nstroke(this.address());
        }

        public float opacity() {
            return NSVGShape.nopacity(this.address());
        }

        public float strokeWidth() {
            return NSVGShape.nstrokeWidth(this.address());
        }

        public float strokeDashOffset() {
            return NSVGShape.nstrokeDashOffset(this.address());
        }

        @NativeType(value="float[8]")
        public FloatBuffer strokeDashArray() {
            return NSVGShape.nstrokeDashArray(this.address());
        }

        public float strokeDashArray(int param1) {
            return NSVGShape.nstrokeDashArray(this.address(), param1);
        }

        @NativeType(value="char")
        public byte strokeDashCount() {
            return NSVGShape.nstrokeDashCount(this.address());
        }

        @NativeType(value="char")
        public byte strokeLineJoin() {
            return NSVGShape.nstrokeLineJoin(this.address());
        }

        @NativeType(value="char")
        public byte strokeLineCap() {
            return NSVGShape.nstrokeLineCap(this.address());
        }

        public float miterLimit() {
            return NSVGShape.nmiterLimit(this.address());
        }

        @NativeType(value="char")
        public byte fillRule() {
            return NSVGShape.nfillRule(this.address());
        }

        @NativeType(value="unsigned char")
        public byte flags() {
            return NSVGShape.nflags(this.address());
        }

        @NativeType(value="float[4]")
        public FloatBuffer bounds() {
            return NSVGShape.nbounds(this.address());
        }

        public float bounds(int param1) {
            return NSVGShape.nbounds(this.address(), param1);
        }

        @NativeType(value="char[64]")
        public ByteBuffer fillGradient() {
            return NSVGShape.nfillGradient(this.address());
        }

        @NativeType(value="char[64]")
        public String fillGradientString() {
            return NSVGShape.nfillGradientString(this.address());
        }

        @NativeType(value="char[64]")
        public ByteBuffer strokeGradient() {
            return NSVGShape.nstrokeGradient(this.address());
        }

        @NativeType(value="char[64]")
        public String strokeGradientString() {
            return NSVGShape.nstrokeGradientString(this.address());
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NSVGShape.nxform(this.address());
        }

        public float xform(int param1) {
            return NSVGShape.nxform(this.address(), param1);
        }

        @NativeType(value="NSVGpath *")
        public NSVGPath paths() {
            return NSVGShape.npaths(this.address());
        }

        @NativeType(value="NSVGshape *")
        public NSVGShape next() {
            return NSVGShape.nnext(this.address());
        }
    }
}

