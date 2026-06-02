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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class DATA_BLOB
extends Struct<DATA_BLOB>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBDATA;
    public static final int PBDATA;

    protected DATA_BLOB(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected DATA_BLOB create(long param1, @Nullable ByteBuffer param3) {
        return new DATA_BLOB(param1, param3);
    }

    public DATA_BLOB(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), DATA_BLOB.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbData() {
        return DATA_BLOB.ncbData(this.address());
    }

    @NativeType(value="BYTE *")
    public ByteBuffer pbData() {
        return DATA_BLOB.npbData(this.address());
    }

    public DATA_BLOB pbData(@NativeType(value="BYTE *") ByteBuffer param1) {
        DATA_BLOB.npbData(this.address(), param1);
        return this;
    }

    public DATA_BLOB set(DATA_BLOB param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static DATA_BLOB malloc() {
        return new DATA_BLOB(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DATA_BLOB calloc() {
        return new DATA_BLOB(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DATA_BLOB create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new DATA_BLOB(MemoryUtil.memAddress(v0), v0);
    }

    public static DATA_BLOB create(long param0) {
        return new DATA_BLOB(param0, null);
    }

    @Nullable
    public static DATA_BLOB createSafe(long param0) {
        return param0 == 0L ? null : new DATA_BLOB(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DATA_BLOB.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = DATA_BLOB.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static DATA_BLOB malloc(MemoryStack param0) {
        return new DATA_BLOB(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DATA_BLOB calloc(MemoryStack param0) {
        return new DATA_BLOB(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ncbData(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CBDATA);
    }

    public static ByteBuffer npbData(long param0) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(param0 + (long)PBDATA), DATA_BLOB.ncbData(param0));
    }

    public static void ncbData(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBDATA, param2);
    }

    public static void npbData(long param0, ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)PBDATA, MemoryUtil.memAddress(param2));
        DATA_BLOB.ncbData(param0, param2.remaining());
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)PBDATA));
    }

    static {
        Struct.Layout v0 = DATA_BLOB.__struct(DATA_BLOB.__member(4), DATA_BLOB.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CBDATA = v0.offsetof(0);
        PBDATA = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<DATA_BLOB, Buffer>
    implements NativeResource {
        private static final DATA_BLOB ELEMENT_FACTORY = DATA_BLOB.create(-1L);

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
        protected DATA_BLOB getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cbData() {
            return DATA_BLOB.ncbData(this.address());
        }

        @NativeType(value="BYTE *")
        public ByteBuffer pbData() {
            return DATA_BLOB.npbData(this.address());
        }

        public Buffer pbData(@NativeType(value="BYTE *") ByteBuffer param1) {
            DATA_BLOB.npbData(this.address(), param1);
            return this;
        }
    }
}

