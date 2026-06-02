/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class RECT
extends Struct<RECT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LEFT;
    public static final int TOP;
    public static final int RIGHT;
    public static final int BOTTOM;

    protected RECT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected RECT create(long param1, @Nullable ByteBuffer param3) {
        return new RECT(param1, param3);
    }

    public RECT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), RECT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int left() {
        return RECT.nleft(this.address());
    }

    @NativeType(value="LONG")
    public int top() {
        return RECT.ntop(this.address());
    }

    @NativeType(value="LONG")
    public int right() {
        return RECT.nright(this.address());
    }

    @NativeType(value="LONG")
    public int bottom() {
        return RECT.nbottom(this.address());
    }

    public RECT left(@NativeType(value="LONG") int param1) {
        RECT.nleft(this.address(), param1);
        return this;
    }

    public RECT top(@NativeType(value="LONG") int param1) {
        RECT.ntop(this.address(), param1);
        return this;
    }

    public RECT right(@NativeType(value="LONG") int param1) {
        RECT.nright(this.address(), param1);
        return this;
    }

    public RECT bottom(@NativeType(value="LONG") int param1) {
        RECT.nbottom(this.address(), param1);
        return this;
    }

    public RECT set(int param1, int param2, int param3, int param4) {
        this.left(param1);
        this.top(param2);
        this.right(param3);
        this.bottom(param4);
        return this;
    }

    public RECT set(RECT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static RECT malloc() {
        return new RECT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static RECT calloc() {
        return new RECT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static RECT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new RECT(MemoryUtil.memAddress(v0), v0);
    }

    public static RECT create(long param0) {
        return new RECT(param0, null);
    }

    @Nullable
    public static RECT createSafe(long param0) {
        return param0 == 0L ? null : new RECT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(RECT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = RECT.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    @Deprecated
    public static RECT mallocStack() {
        return RECT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT callocStack() {
        return RECT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static RECT mallocStack(MemoryStack param0) {
        return RECT.malloc(param0);
    }

    @Deprecated
    public static RECT callocStack(MemoryStack param0) {
        return RECT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return RECT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return RECT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return RECT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return RECT.calloc(param0, param1);
    }

    public static RECT malloc(MemoryStack param0) {
        return new RECT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static RECT calloc(MemoryStack param0) {
        return new RECT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nleft(long param0) {
        return UNSAFE.getInt(null, param0 + (long)LEFT);
    }

    public static int ntop(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TOP);
    }

    public static int nright(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RIGHT);
    }

    public static int nbottom(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BOTTOM);
    }

    public static void nleft(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)LEFT, param2);
    }

    public static void ntop(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TOP, param2);
    }

    public static void nright(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RIGHT, param2);
    }

    public static void nbottom(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BOTTOM, param2);
    }

    static {
        Struct.Layout v0 = RECT.__struct(RECT.__member(4), RECT.__member(4), RECT.__member(4), RECT.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        LEFT = v0.offsetof(0);
        TOP = v0.offsetof(1);
        RIGHT = v0.offsetof(2);
        BOTTOM = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<RECT, Buffer>
    implements NativeResource {
        private static final RECT ELEMENT_FACTORY = RECT.create(-1L);

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
        protected RECT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int left() {
            return RECT.nleft(this.address());
        }

        @NativeType(value="LONG")
        public int top() {
            return RECT.ntop(this.address());
        }

        @NativeType(value="LONG")
        public int right() {
            return RECT.nright(this.address());
        }

        @NativeType(value="LONG")
        public int bottom() {
            return RECT.nbottom(this.address());
        }

        public Buffer left(@NativeType(value="LONG") int param1) {
            RECT.nleft(this.address(), param1);
            return this;
        }

        public Buffer top(@NativeType(value="LONG") int param1) {
            RECT.ntop(this.address(), param1);
            return this;
        }

        public Buffer right(@NativeType(value="LONG") int param1) {
            RECT.nright(this.address(), param1);
            return this;
        }

        public Buffer bottom(@NativeType(value="LONG") int param1) {
            RECT.nbottom(this.address(), param1);
            return this;
        }
    }
}

