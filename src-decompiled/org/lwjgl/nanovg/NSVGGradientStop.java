/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGgradientStop")
public class NSVGGradientStop
extends Struct<NSVGGradientStop> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int COLOR;
    public static final int OFFSET;

    protected NSVGGradientStop(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGGradientStop create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGGradientStop(param1, param3);
    }

    public NSVGGradientStop(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGGradientStop.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned int")
    public int color() {
        return NSVGGradientStop.ncolor(this.address());
    }

    public float offset() {
        return NSVGGradientStop.noffset(this.address());
    }

    public static NSVGGradientStop create(long param0) {
        return new NSVGGradientStop(param0, null);
    }

    @Nullable
    public static NSVGGradientStop createSafe(long param0) {
        return param0 == 0L ? null : new NSVGGradientStop(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static int ncolor(long param0) {
        return UNSAFE.getInt(null, param0 + (long)COLOR);
    }

    public static float noffset(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)OFFSET);
    }

    static {
        Struct.Layout v0 = NSVGGradientStop.__struct(NSVGGradientStop.__member(4), NSVGGradientStop.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        COLOR = v0.offsetof(0);
        OFFSET = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<NSVGGradientStop, Buffer> {
        private static final NSVGGradientStop ELEMENT_FACTORY = NSVGGradientStop.create(-1L);

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
        protected NSVGGradientStop getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned int")
        public int color() {
            return NSVGGradientStop.ncolor(this.address());
        }

        public float offset() {
            return NSVGGradientStop.noffset(this.address());
        }
    }
}

