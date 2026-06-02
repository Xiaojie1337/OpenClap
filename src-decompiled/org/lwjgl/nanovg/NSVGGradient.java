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
import org.lwjgl.nanovg.NSVGGradientStop;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGgradient")
public class NSVGGradient
extends Struct<NSVGGradient> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int XFORM;
    public static final int SPREAD;
    public static final int FX;
    public static final int FY;
    public static final int NSTOPS;
    public static final int PSTOPS;

    protected NSVGGradient(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGGradient create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGGradient(param1, param3);
    }

    public NSVGGradient(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGGradient.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NSVGGradient.nxform(this.address());
    }

    public float xform(int param1) {
        return NSVGGradient.nxform(this.address(), param1);
    }

    @NativeType(value="char")
    public byte spread() {
        return NSVGGradient.nspread(this.address());
    }

    public float fx() {
        return NSVGGradient.nfx(this.address());
    }

    public float fy() {
        return NSVGGradient.nfy(this.address());
    }

    public int nstops() {
        return NSVGGradient.nnstops(this.address());
    }

    @NativeType(value="NSVGgradientStop[1]")
    public NSVGGradientStop.Buffer pstops() {
        return NSVGGradient.npstops(this.address());
    }

    @NativeType(value="NSVGgradientStop")
    public NSVGGradientStop pstops(int param1) {
        return NSVGGradient.npstops(this.address(), param1);
    }

    public static NSVGGradient create(long param0) {
        return new NSVGGradient(param0, null);
    }

    @Nullable
    public static NSVGGradient createSafe(long param0) {
        return param0 == 0L ? null : new NSVGGradient(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FloatBuffer nxform(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)XFORM, 6);
    }

    public static float nxform(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)XFORM + Checks.check(param2, 6) * 4L);
    }

    public static byte nspread(long param0) {
        return UNSAFE.getByte(null, param0 + (long)SPREAD);
    }

    public static float nfx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)FX);
    }

    public static float nfy(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)FY);
    }

    public static int nnstops(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NSTOPS);
    }

    public static NSVGGradientStop.Buffer npstops(long param0) {
        return NSVGGradientStop.create(param0 + (long)PSTOPS, NSVGGradient.nnstops(param0));
    }

    public static NSVGGradientStop npstops(long param0, int param2) {
        return NSVGGradientStop.create(param0 + (long)PSTOPS + Checks.check(param2, NSVGGradient.nnstops(param0)) * (long)NSVGGradientStop.SIZEOF);
    }

    static {
        Struct.Layout v0 = NSVGGradient.__struct(NSVGGradient.__array(4, 6), NSVGGradient.__member(1), NSVGGradient.__member(4), NSVGGradient.__member(4), NSVGGradient.__member(4), NSVGGradient.__array(NSVGGradientStop.SIZEOF, NSVGGradientStop.ALIGNOF, 1));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        XFORM = v0.offsetof(0);
        SPREAD = v0.offsetof(1);
        FX = v0.offsetof(2);
        FY = v0.offsetof(3);
        NSTOPS = v0.offsetof(4);
        PSTOPS = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<NSVGGradient, Buffer> {
        private static final NSVGGradient ELEMENT_FACTORY = NSVGGradient.create(-1L);

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
        protected NSVGGradient getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NSVGGradient.nxform(this.address());
        }

        public float xform(int param1) {
            return NSVGGradient.nxform(this.address(), param1);
        }

        @NativeType(value="char")
        public byte spread() {
            return NSVGGradient.nspread(this.address());
        }

        public float fx() {
            return NSVGGradient.nfx(this.address());
        }

        public float fy() {
            return NSVGGradient.nfy(this.address());
        }

        public int nstops() {
            return NSVGGradient.nnstops(this.address());
        }

        @NativeType(value="NSVGgradientStop[1]")
        public NSVGGradientStop.Buffer pstops() {
            return NSVGGradient.npstops(this.address());
        }

        @NativeType(value="NSVGgradientStop")
        public NSVGGradientStop pstops(int param1) {
            return NSVGGradient.npstops(this.address(), param1);
        }
    }
}

