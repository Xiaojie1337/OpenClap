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

public class POINT
extends Struct<POINT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected POINT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected POINT create(long param1, @Nullable ByteBuffer param3) {
        return new POINT(param1, param3);
    }

    public POINT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), POINT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return POINT.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return POINT.ny(this.address());
    }

    public POINT x(@NativeType(value="LONG") int param1) {
        POINT.nx(this.address(), param1);
        return this;
    }

    public POINT y(@NativeType(value="LONG") int param1) {
        POINT.ny(this.address(), param1);
        return this;
    }

    public POINT set(int param1, int param2) {
        this.x(param1);
        this.y(param2);
        return this;
    }

    public POINT set(POINT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static POINT malloc() {
        return new POINT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static POINT calloc() {
        return new POINT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static POINT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new POINT(MemoryUtil.memAddress(v0), v0);
    }

    public static POINT create(long param0) {
        return new POINT(param0, null);
    }

    @Nullable
    public static POINT createSafe(long param0) {
        return param0 == 0L ? null : new POINT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(POINT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = POINT.__create(param0, SIZEOF);
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
    public static POINT mallocStack() {
        return POINT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT callocStack() {
        return POINT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINT mallocStack(MemoryStack param0) {
        return POINT.malloc(param0);
    }

    @Deprecated
    public static POINT callocStack(MemoryStack param0) {
        return POINT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return POINT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return POINT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return POINT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return POINT.calloc(param0, param1);
    }

    public static POINT malloc(MemoryStack param0) {
        return new POINT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static POINT calloc(MemoryStack param0) {
        return new POINT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    static {
        Struct.Layout v0 = POINT.__struct(POINT.__member(4), POINT.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        X = v0.offsetof(0);
        Y = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<POINT, Buffer>
    implements NativeResource {
        private static final POINT ELEMENT_FACTORY = POINT.create(-1L);

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
        protected POINT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return POINT.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return POINT.ny(this.address());
        }

        public Buffer x(@NativeType(value="LONG") int param1) {
            POINT.nx(this.address(), param1);
            return this;
        }

        public Buffer y(@NativeType(value="LONG") int param1) {
            POINT.ny(this.address(), param1);
            return this;
        }
    }
}

