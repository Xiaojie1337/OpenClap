/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct ffi_type")
public class FFIType
extends Struct<FFIType>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIZE;
    public static final int ALIGNMENT;
    public static final int TYPE;
    public static final int ELEMENTS;

    protected FFIType(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected FFIType create(long param1, @Nullable ByteBuffer param3) {
        return new FFIType(param1, param3);
    }

    public FFIType(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), FFIType.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="size_t")
    public long size() {
        return FFIType.nsize(this.address());
    }

    @NativeType(value="unsigned short")
    public short alignment() {
        return FFIType.nalignment(this.address());
    }

    @NativeType(value="unsigned short")
    public short type() {
        return FFIType.ntype(this.address());
    }

    @Nullable
    @NativeType(value="ffi_type *")
    public PointerBuffer elements(int param1) {
        return FFIType.nelements(this.address(), param1);
    }

    public FFIType size(@NativeType(value="size_t") long param1) {
        FFIType.nsize(this.address(), param1);
        return this;
    }

    public FFIType alignment(@NativeType(value="unsigned short") short param1) {
        FFIType.nalignment(this.address(), param1);
        return this;
    }

    public FFIType type(@NativeType(value="unsigned short") short param1) {
        FFIType.ntype(this.address(), param1);
        return this;
    }

    public FFIType elements(@Nullable @NativeType(value="ffi_type *") PointerBuffer param1) {
        FFIType.nelements(this.address(), param1);
        return this;
    }

    public FFIType set(long param1, short param3, short param4, @Nullable PointerBuffer param5) {
        this.size(param1);
        this.alignment(param3);
        this.type(param4);
        this.elements(param5);
        return this;
    }

    public FFIType set(FFIType param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static FFIType malloc() {
        return new FFIType(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFIType calloc() {
        return new FFIType(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFIType create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new FFIType(MemoryUtil.memAddress(v0), v0);
    }

    public static FFIType create(long param0) {
        return new FFIType(param0, null);
    }

    @Nullable
    public static FFIType createSafe(long param0) {
        return param0 == 0L ? null : new FFIType(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFIType.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = FFIType.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FFIType malloc(MemoryStack param0) {
        return new FFIType(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFIType calloc(MemoryStack param0) {
        return new FFIType(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nsize(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)SIZE);
    }

    public static short nalignment(long param0) {
        return UNSAFE.getShort(null, param0 + (long)ALIGNMENT);
    }

    public static short ntype(long param0) {
        return UNSAFE.getShort(null, param0 + (long)TYPE);
    }

    @Nullable
    public static PointerBuffer nelements(long param0, int param2) {
        return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(param0 + (long)ELEMENTS), param2);
    }

    public static void nsize(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)SIZE, param2);
    }

    public static void nalignment(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)ALIGNMENT, param2);
    }

    public static void ntype(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)TYPE, param2);
    }

    public static void nelements(long param0, @Nullable PointerBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)ELEMENTS, MemoryUtil.memAddressSafe(param2));
    }

    static {
        Struct.Layout v0 = FFIType.__struct(FFIType.__member(POINTER_SIZE), FFIType.__member(2), FFIType.__member(2), FFIType.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        SIZE = v0.offsetof(0);
        ALIGNMENT = v0.offsetof(1);
        TYPE = v0.offsetof(2);
        ELEMENTS = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<FFIType, Buffer>
    implements NativeResource {
        private static final FFIType ELEMENT_FACTORY = FFIType.create(-1L);

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
        protected FFIType getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="size_t")
        public long size() {
            return FFIType.nsize(this.address());
        }

        @NativeType(value="unsigned short")
        public short alignment() {
            return FFIType.nalignment(this.address());
        }

        @NativeType(value="unsigned short")
        public short type() {
            return FFIType.ntype(this.address());
        }

        @Nullable
        @NativeType(value="ffi_type *")
        public PointerBuffer elements(int param1) {
            return FFIType.nelements(this.address(), param1);
        }

        public Buffer size(@NativeType(value="size_t") long param1) {
            FFIType.nsize(this.address(), param1);
            return this;
        }

        public Buffer alignment(@NativeType(value="unsigned short") short param1) {
            FFIType.nalignment(this.address(), param1);
            return this;
        }

        public Buffer type(@NativeType(value="unsigned short") short param1) {
            FFIType.ntype(this.address(), param1);
            return this;
        }

        public Buffer elements(@Nullable @NativeType(value="ffi_type *") PointerBuffer param1) {
            FFIType.nelements(this.address(), param1);
            return this;
        }
    }
}

