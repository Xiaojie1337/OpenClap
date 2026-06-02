/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct iovec")
public class IOVec
extends Struct<IOVec>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int IOV_BASE;
    public static final int IOV_LEN;

    protected IOVec(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOVec create(long param1, @Nullable ByteBuffer param3) {
        return new IOVec(param1, param3);
    }

    public IOVec(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOVec.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @Nullable
    @NativeType(value="void *")
    public ByteBuffer iov_base() {
        return IOVec.niov_base(this.address());
    }

    @NativeType(value="size_t")
    public long iov_len() {
        return IOVec.niov_len(this.address());
    }

    public IOVec iov_base(@Nullable @NativeType(value="void *") ByteBuffer param1) {
        IOVec.niov_base(this.address(), param1);
        return this;
    }

    public IOVec iov_len(@NativeType(value="size_t") long param1) {
        IOVec.niov_len(this.address(), param1);
        return this;
    }

    public IOVec set(@Nullable ByteBuffer param1, long param2) {
        this.iov_base(param1);
        this.iov_len(param2);
        return this;
    }

    public IOVec set(IOVec param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOVec malloc() {
        return new IOVec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOVec calloc() {
        return new IOVec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOVec create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOVec(MemoryUtil.memAddress(v0), v0);
    }

    public static IOVec create(long param0) {
        return new IOVec(param0, null);
    }

    @Nullable
    public static IOVec createSafe(long param0) {
        return param0 == 0L ? null : new IOVec(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOVec.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOVec.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOVec malloc(MemoryStack param0) {
        return new IOVec(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOVec calloc(MemoryStack param0) {
        return new IOVec(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    @Nullable
    public static ByteBuffer niov_base(long param0) {
        return MemoryUtil.memByteBufferSafe(MemoryUtil.memGetAddress(param0 + (long)IOV_BASE), (int)IOVec.niov_len(param0));
    }

    public static long niov_len(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)IOV_LEN);
    }

    public static void niov_base(long param0, @Nullable ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)IOV_BASE, MemoryUtil.memAddressSafe(param2));
    }

    public static void niov_len(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)IOV_LEN, param2);
    }

    static {
        Struct.Layout v0 = IOVec.__struct(IOVec.__member(POINTER_SIZE), IOVec.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        IOV_BASE = v0.offsetof(0);
        IOV_LEN = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<IOVec, Buffer>
    implements NativeResource {
        private static final IOVec ELEMENT_FACTORY = IOVec.create(-1L);

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
        protected IOVec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @Nullable
        @NativeType(value="void *")
        public ByteBuffer iov_base() {
            return IOVec.niov_base(this.address());
        }

        @NativeType(value="size_t")
        public long iov_len() {
            return IOVec.niov_len(this.address());
        }

        public Buffer iov_base(@Nullable @NativeType(value="void *") ByteBuffer param1) {
            IOVec.niov_base(this.address(), param1);
            return this;
        }

        public Buffer iov_len(@NativeType(value="size_t") long param1) {
            IOVec.niov_len(this.address(), param1);
            return this;
        }
    }
}

