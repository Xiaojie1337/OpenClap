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

@NativeType(value="struct NVGtextRow")
public class NVGTextRow
extends Struct<NVGTextRow>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int START;
    public static final int END;
    public static final int NEXT;
    public static final int WIDTH;
    public static final int MINX;
    public static final int MAXX;

    protected NVGTextRow(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGTextRow create(long param1, @Nullable ByteBuffer param3) {
        return new NVGTextRow(param1, param3);
    }

    public NVGTextRow(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGTextRow.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public long start() {
        return NVGTextRow.nstart(this.address());
    }

    @NativeType(value="char *")
    public long end() {
        return NVGTextRow.nend(this.address());
    }

    @NativeType(value="char *")
    public long next() {
        return NVGTextRow.nnext(this.address());
    }

    public float width() {
        return NVGTextRow.nwidth(this.address());
    }

    public float minx() {
        return NVGTextRow.nminx(this.address());
    }

    public float maxx() {
        return NVGTextRow.nmaxx(this.address());
    }

    public static NVGTextRow malloc() {
        return new NVGTextRow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGTextRow calloc() {
        return new NVGTextRow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGTextRow create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGTextRow(MemoryUtil.memAddress(v0), v0);
    }

    public static NVGTextRow create(long param0) {
        return new NVGTextRow(param0, null);
    }

    @Nullable
    public static NVGTextRow createSafe(long param0) {
        return param0 == 0L ? null : new NVGTextRow(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGTextRow.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = NVGTextRow.__create(param0, SIZEOF);
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
    public static NVGTextRow mallocStack() {
        return NVGTextRow.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGTextRow callocStack() {
        return NVGTextRow.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGTextRow mallocStack(MemoryStack param0) {
        return NVGTextRow.malloc(param0);
    }

    @Deprecated
    public static NVGTextRow callocStack(MemoryStack param0) {
        return NVGTextRow.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return NVGTextRow.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return NVGTextRow.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return NVGTextRow.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return NVGTextRow.calloc(param0, param1);
    }

    public static NVGTextRow malloc(MemoryStack param0) {
        return new NVGTextRow(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGTextRow calloc(MemoryStack param0) {
        return new NVGTextRow(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nstart(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)START);
    }

    public static long nend(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)END);
    }

    public static long nnext(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)NEXT);
    }

    public static float nwidth(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)WIDTH);
    }

    public static float nminx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MINX);
    }

    public static float nmaxx(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MAXX);
    }

    static {
        Struct.Layout v0 = NVGTextRow.__struct(NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(POINTER_SIZE), NVGTextRow.__member(4), NVGTextRow.__member(4), NVGTextRow.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        START = v0.offsetof(0);
        END = v0.offsetof(1);
        NEXT = v0.offsetof(2);
        WIDTH = v0.offsetof(3);
        MINX = v0.offsetof(4);
        MAXX = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<NVGTextRow, Buffer>
    implements NativeResource {
        private static final NVGTextRow ELEMENT_FACTORY = NVGTextRow.create(-1L);

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
        protected NVGTextRow getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public long start() {
            return NVGTextRow.nstart(this.address());
        }

        @NativeType(value="char *")
        public long end() {
            return NVGTextRow.nend(this.address());
        }

        @NativeType(value="char *")
        public long next() {
            return NVGTextRow.nnext(this.address());
        }

        public float width() {
            return NVGTextRow.nwidth(this.address());
        }

        public float minx() {
            return NVGTextRow.nminx(this.address());
        }

        public float maxx() {
            return NVGTextRow.nmaxx(this.address());
        }
    }
}

