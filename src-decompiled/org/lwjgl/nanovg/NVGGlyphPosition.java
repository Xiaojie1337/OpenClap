/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGglyphPosition")
public class NVGGlyphPosition
extends Struct<NVGGlyphPosition>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int STR;
    public static final int X;
    public static final int MINX;
    public static final int MAXX;

    protected NVGGlyphPosition(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGGlyphPosition create(long param1, @Nullable ByteBuffer param3) {
        return new NVGGlyphPosition(param1, param3);
    }

    public NVGGlyphPosition(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGGlyphPosition.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public long str() {
        return NVGGlyphPosition.nstr(this.address());
    }

    public float x() {
        return NVGGlyphPosition.nx(this.address());
    }

    public float minx() {
        return NVGGlyphPosition.nminx(this.address());
    }

    public float maxx() {
        return NVGGlyphPosition.nmaxx(this.address());
    }

    public static NVGGlyphPosition malloc() {
        return new NVGGlyphPosition(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGGlyphPosition calloc() {
        return new NVGGlyphPosition(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGGlyphPosition create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGGlyphPosition(MemoryUtil.memAddress(v0), v0);
    }

    public static NVGGlyphPosition create(long param0) {
        return new NVGGlyphPosition(param0, null);
    }

    @Nullable
    public static NVGGlyphPosition createSafe(long param0) {
        return param0 == 0L ? null : new NVGGlyphPosition(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGGlyphPosition.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = NVGGlyphPosition.__create(param0, SIZEOF);
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
    public static NVGGlyphPosition mallocStack() {
        return NVGGlyphPosition.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGGlyphPosition callocStack() {
        return NVGGlyphPosition.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGGlyphPosition mallocStack(MemoryStack param0) {
        return NVGGlyphPosition.malloc(param0);
    }

    @Deprecated
    public static NVGGlyphPosition callocStack(MemoryStack param0) {
        return NVGGlyphPosition.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return NVGGlyphPosition.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return NVGGlyphPosition.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return NVGGlyphPosition.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return NVGGlyphPosition.calloc(param0, param1);
    }

    public static NVGGlyphPosition malloc(MemoryStack param0) {
        return new NVGGlyphPosition(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGGlyphPosition calloc(MemoryStack param0) {
        return new NVGGlyphPosition(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nstr(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)STR);
    }

    public static float nx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)X);
    }

    public static float nminx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MINX);
    }

    public static float nmaxx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MAXX);
    }

    static {
        Struct.Layout v0 = NVGGlyphPosition.__struct(NVGGlyphPosition.__member(POINTER_SIZE), NVGGlyphPosition.__member(4), NVGGlyphPosition.__member(4), NVGGlyphPosition.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        STR = v0.offsetof(0);
        X = v0.offsetof(1);
        MINX = v0.offsetof(2);
        MAXX = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGGlyphPosition, Buffer>
    implements NativeResource {
        private static final NVGGlyphPosition ELEMENT_FACTORY = NVGGlyphPosition.create(-1L);

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
        protected NVGGlyphPosition getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public long str() {
            return NVGGlyphPosition.nstr(this.address());
        }

        public float x() {
            return NVGGlyphPosition.nx(this.address());
        }

        public float minx() {
            return NVGGlyphPosition.nminx(this.address());
        }

        public float maxx() {
            return NVGGlyphPosition.nmaxx(this.address());
        }
    }
}

