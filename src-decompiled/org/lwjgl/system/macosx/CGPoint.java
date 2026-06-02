/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGPoint
extends Struct<CGPoint>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;

    protected CGPoint(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected CGPoint create(long param1, @Nullable ByteBuffer param3) {
        return new CGPoint(param1, param3);
    }

    public CGPoint(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), CGPoint.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="CGFloat")
    public double x() {
        return CGPoint.nx(this.address());
    }

    @NativeType(value="CGFloat")
    public double y() {
        return CGPoint.ny(this.address());
    }

    public CGPoint x(@NativeType(value="CGFloat") double param1) {
        CGPoint.nx(this.address(), param1);
        return this;
    }

    public CGPoint y(@NativeType(value="CGFloat") double param1) {
        CGPoint.ny(this.address(), param1);
        return this;
    }

    public CGPoint set(double param1, double param3) {
        this.x(param1);
        this.y(param3);
        return this;
    }

    public CGPoint set(CGPoint param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static CGPoint malloc() {
        return new CGPoint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CGPoint calloc() {
        return new CGPoint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CGPoint create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new CGPoint(MemoryUtil.memAddress(v0), v0);
    }

    public static CGPoint create(long param0) {
        return new CGPoint(param0, null);
    }

    @Nullable
    public static CGPoint createSafe(long param0) {
        return param0 == 0L ? null : new CGPoint(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CGPoint.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = CGPoint.__create(param0, SIZEOF);
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
    public static CGPoint mallocStack() {
        return CGPoint.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint callocStack() {
        return CGPoint.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGPoint mallocStack(MemoryStack param0) {
        return CGPoint.malloc(param0);
    }

    @Deprecated
    public static CGPoint callocStack(MemoryStack param0) {
        return CGPoint.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return CGPoint.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return CGPoint.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return CGPoint.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return CGPoint.calloc(param0, param1);
    }

    public static CGPoint malloc(MemoryStack param0) {
        return new CGPoint(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CGPoint calloc(MemoryStack param0) {
        return new CGPoint(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static double nx(long param0) {
        return UNSAFE.getDouble(null, param0 + (long)X);
    }

    public static double ny(long param0) {
        return UNSAFE.getDouble(null, param0 + (long)Y);
    }

    public static void nx(long param0, double param2) {
        UNSAFE.putDouble(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, double param2) {
        UNSAFE.putDouble(null, param0 + (long)Y, param2);
    }

    static {
        Struct.Layout v0 = CGPoint.__struct(CGPoint.__member(8), CGPoint.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        X = v0.offsetof(0);
        Y = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<CGPoint, Buffer>
    implements NativeResource {
        private static final CGPoint ELEMENT_FACTORY = CGPoint.create(-1L);

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
        protected CGPoint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="CGFloat")
        public double x() {
            return CGPoint.nx(this.address());
        }

        @NativeType(value="CGFloat")
        public double y() {
            return CGPoint.ny(this.address());
        }

        public Buffer x(@NativeType(value="CGFloat") double param1) {
            CGPoint.nx(this.address(), param1);
            return this;
        }

        public Buffer y(@NativeType(value="CGFloat") double param1) {
            CGPoint.ny(this.address(), param1);
            return this;
        }
    }
}

