/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.NSVGShape;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGimage")
public class NSVGImage
extends Struct<NSVGImage> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int SHAPES;

    protected NSVGImage(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGImage create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGImage(param1, param3);
    }

    public NSVGImage(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGImage.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public float width() {
        return NSVGImage.nwidth(this.address());
    }

    public float height() {
        return NSVGImage.nheight(this.address());
    }

    @NativeType(value="NSVGshape *")
    public NSVGShape shapes() {
        return NSVGImage.nshapes(this.address());
    }

    public static NSVGImage create(long param0) {
        return new NSVGImage(param0, null);
    }

    @Nullable
    public static NSVGImage createSafe(long param0) {
        return param0 == 0L ? null : new NSVGImage(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static float nwidth(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)WIDTH);
    }

    public static float nheight(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)HEIGHT);
    }

    public static NSVGShape nshapes(long param0) {
        return NSVGShape.create(MemoryUtil.memGetAddress(param0 + (long)SHAPES));
    }

    static {
        Struct.Layout v0 = NSVGImage.__struct(NSVGImage.__member(4), NSVGImage.__member(4), NSVGImage.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        WIDTH = v0.offsetof(0);
        HEIGHT = v0.offsetof(1);
        SHAPES = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<NSVGImage, Buffer> {
        private static final NSVGImage ELEMENT_FACTORY = NSVGImage.create(-1L);

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
        protected NSVGImage getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public float width() {
            return NSVGImage.nwidth(this.address());
        }

        public float height() {
            return NSVGImage.nheight(this.address());
        }

        @NativeType(value="NSVGshape *")
        public NSVGShape shapes() {
            return NSVGImage.nshapes(this.address());
        }
    }
}

