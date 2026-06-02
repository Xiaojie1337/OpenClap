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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGpath")
public class NSVGPath
extends Struct<NSVGPath> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int PTS;
    public static final int NPTS;
    public static final int CLOSED;
    public static final int BOUNDS;
    public static final int NEXT;

    protected NSVGPath(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NSVGPath create(long param1, @Nullable ByteBuffer param3) {
        return new NSVGPath(param1, param3);
    }

    public NSVGPath(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NSVGPath.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float *")
    public FloatBuffer pts() {
        return NSVGPath.npts(this.address());
    }

    public int npts() {
        return NSVGPath.nnpts(this.address());
    }

    @NativeType(value="char")
    public byte closed() {
        return NSVGPath.nclosed(this.address());
    }

    @NativeType(value="float[4]")
    public FloatBuffer bounds() {
        return NSVGPath.nbounds(this.address());
    }

    public float bounds(int param1) {
        return NSVGPath.nbounds(this.address(), param1);
    }

    @NativeType(value="NSVGpath *")
    public NSVGPath next() {
        return NSVGPath.nnext(this.address());
    }

    public static NSVGPath create(long param0) {
        return new NSVGPath(param0, null);
    }

    @Nullable
    public static NSVGPath createSafe(long param0) {
        return param0 == 0L ? null : new NSVGPath(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FloatBuffer npts(long param0) {
        return MemoryUtil.memFloatBuffer(MemoryUtil.memGetAddress(param0 + (long)PTS), NSVGPath.nnpts(param0) << 1);
    }

    public static int nnpts(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NPTS);
    }

    public static byte nclosed(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CLOSED);
    }

    public static FloatBuffer nbounds(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)BOUNDS, 4);
    }

    public static float nbounds(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)BOUNDS + Checks.check(param2, 4) * 4L);
    }

    public static NSVGPath nnext(long param0) {
        return NSVGPath.create(MemoryUtil.memGetAddress(param0 + (long)NEXT));
    }

    static {
        Struct.Layout v0 = NSVGPath.__struct(NSVGPath.__member(POINTER_SIZE), NSVGPath.__member(4), NSVGPath.__member(1), NSVGPath.__array(4, 4), NSVGPath.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        PTS = v0.offsetof(0);
        NPTS = v0.offsetof(1);
        CLOSED = v0.offsetof(2);
        BOUNDS = v0.offsetof(3);
        NEXT = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<NSVGPath, Buffer> {
        private static final NSVGPath ELEMENT_FACTORY = NSVGPath.create(-1L);

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
        protected NSVGPath getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float *")
        public FloatBuffer pts() {
            return NSVGPath.npts(this.address());
        }

        public int npts() {
            return NSVGPath.nnpts(this.address());
        }

        @NativeType(value="char")
        public byte closed() {
            return NSVGPath.nclosed(this.address());
        }

        @NativeType(value="float[4]")
        public FloatBuffer bounds() {
            return NSVGPath.nbounds(this.address());
        }

        public float bounds(int param1) {
            return NSVGPath.nbounds(this.address(), param1);
        }

        @NativeType(value="NSVGpath *")
        public NSVGPath next() {
            return NSVGPath.nnext(this.address());
        }
    }
}

