/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.NSVGGradient;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGpaint")
public class NSVGPaint
extends Struct<NSVGPaint> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int COLOR;
    public static final int GRADIENT;

    protected NSVGPaint(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGPaint create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGPaint(param1, param3);
    }

    public NSVGPaint(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGPaint.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="signed char")
    public byte type() {
        return NSVGPaint.ntype(this.address());
    }

    @NativeType(value="unsigned int")
    public int color() {
        return NSVGPaint.ncolor(this.address());
    }

    @NativeType(value="NSVGgradient *")
    public NSVGGradient gradient() {
        return NSVGPaint.ngradient(this.address());
    }

    public static NSVGPaint create(long param0) {
        return new NSVGPaint(param0, null);
    }

    @Nullable
    public static NSVGPaint createSafe(long param0) {
        return param0 == 0L ? null : new NSVGPaint(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static byte ntype(long param0) {
        return UNSAFE.getByte(null, param0 + (long)TYPE);
    }

    public static int ncolor(long param0) {
        return UNSAFE.getInt(null, param0 + (long)COLOR);
    }

    public static NSVGGradient ngradient(long param0) {
        return NSVGGradient.create(MemoryUtil.memGetAddress(param0 + (long)GRADIENT));
    }

    static {
        Struct.Layout v0 = NSVGPaint.__struct(NSVGPaint.__member(1), NSVGPaint.__union(NSVGPaint.__member(4), NSVGPaint.__member(POINTER_SIZE)));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        COLOR = v0.offsetof(2);
        GRADIENT = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NSVGPaint, Buffer> {
        private static final NSVGPaint ELEMENT_FACTORY = NSVGPaint.create(-1L);

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
        protected NSVGPaint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="signed char")
        public byte type() {
            return NSVGPaint.ntype(this.address());
        }

        @NativeType(value="unsigned int")
        public int color() {
            return NSVGPaint.ncolor(this.address());
        }

        @NativeType(value="NSVGgradient *")
        public NSVGGradient gradient() {
            return NSVGPaint.ngradient(this.address());
        }
    }
}

