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

public class POINTL
extends Struct<POINTL>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected POINTL(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected POINTL create(long param1, @Nullable ByteBuffer param3) {
        return new POINTL(param1, param3);
    }

    public POINTL(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), POINTL.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return POINTL.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return POINTL.ny(this.address());
    }

    public POINTL x(@NativeType(value="LONG") int param1) {
        POINTL.nx(this.address(), param1);
        return this;
    }

    public POINTL y(@NativeType(value="LONG") int param1) {
        POINTL.ny(this.address(), param1);
        return this;
    }

    public POINTL set(int param1, int param2) {
        this.x(param1);
        this.y(param2);
        return this;
    }

    public POINTL set(POINTL param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static POINTL malloc() {
        return new POINTL(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static POINTL calloc() {
        return new POINTL(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static POINTL create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new POINTL(MemoryUtil.memAddress(v0), v0);
    }

    public static POINTL create(long param0) {
        return new POINTL(param0, null);
    }

    @Nullable
    public static POINTL createSafe(long param0) {
        return param0 == 0L ? null : new POINTL(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(POINTL.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = POINTL.__create(param0, SIZEOF);
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
    public static POINTL mallocStack() {
        return POINTL.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINTL callocStack() {
        return POINTL.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static POINTL mallocStack(MemoryStack param0) {
        return POINTL.malloc(param0);
    }

    @Deprecated
    public static POINTL callocStack(MemoryStack param0) {
        return POINTL.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return POINTL.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return POINTL.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return POINTL.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return POINTL.calloc(param0, param1);
    }

    public static POINTL malloc(MemoryStack param0) {
        return new POINTL(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static POINTL calloc(MemoryStack param0) {
        return new POINTL(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
        Struct.Layout v0 = POINTL.__struct(POINTL.__member(4), POINTL.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        X = v0.offsetof(0);
        Y = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<POINTL, Buffer>
    implements NativeResource {
        private static final POINTL ELEMENT_FACTORY = POINTL.create(-1L);

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
        protected POINTL getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return POINTL.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return POINTL.ny(this.address());
        }

        public Buffer x(@NativeType(value="LONG") int param1) {
            POINTL.nx(this.address(), param1);
            return this;
        }

        public Buffer y(@NativeType(value="LONG") int param1) {
            POINTL.ny(this.address(), param1);
            return this;
        }
    }
}

