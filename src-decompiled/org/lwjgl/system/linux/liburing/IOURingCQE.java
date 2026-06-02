/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_cqe")
public class IOURingCQE
extends Struct<IOURingCQE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int USER_DATA;
    public static final int RES;
    public static final int FLAGS;
    public static final int BIG_CQE;

    protected IOURingCQE(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingCQE create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingCQE(param1, param3);
    }

    public IOURingCQE(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingCQE.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingCQE.nuser_data(this.address());
    }

    @NativeType(value="__s32")
    public int res() {
        return IOURingCQE.nres(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingCQE.nflags(this.address());
    }

    @NativeType(value="__u64[0]")
    public LongBuffer big_cqe() {
        return IOURingCQE.nbig_cqe(this.address());
    }

    @NativeType(value="__u64")
    public long big_cqe(int param1) {
        return IOURingCQE.nbig_cqe(this.address(), param1);
    }

    public IOURingCQE user_data(@NativeType(value="__u64") long param1) {
        IOURingCQE.nuser_data(this.address(), param1);
        return this;
    }

    public IOURingCQE res(@NativeType(value="__s32") int param1) {
        IOURingCQE.nres(this.address(), param1);
        return this;
    }

    public IOURingCQE flags(@NativeType(value="__u32") int param1) {
        IOURingCQE.nflags(this.address(), param1);
        return this;
    }

    public IOURingCQE big_cqe(@NativeType(value="__u64[0]") LongBuffer param1) {
        IOURingCQE.nbig_cqe(this.address(), param1);
        return this;
    }

    public IOURingCQE big_cqe(int param1, @NativeType(value="__u64") long param2) {
        IOURingCQE.nbig_cqe(this.address(), param1, param2);
        return this;
    }

    public IOURingCQE set(long param1, int param3, int param4, LongBuffer param5) {
        this.user_data(param1);
        this.res(param3);
        this.flags(param4);
        this.big_cqe(param5);
        return this;
    }

    public IOURingCQE set(IOURingCQE param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQE malloc() {
        return new IOURingCQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingCQE calloc() {
        return new IOURingCQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingCQE create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingCQE(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingCQE create(long param0) {
        return new IOURingCQE(param0, null);
    }

    @Nullable
    public static IOURingCQE createSafe(long param0) {
        return param0 == 0L ? null : new IOURingCQE(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingCQE.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingCQE.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingCQE malloc(MemoryStack param0) {
        return new IOURingCQE(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingCQE calloc(MemoryStack param0) {
        return new IOURingCQE(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nuser_data(long param0) {
        return UNSAFE.getLong(null, param0 + (long)USER_DATA);
    }

    public static int nres(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RES);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static LongBuffer nbig_cqe(long param0) {
        return MemoryUtil.memLongBuffer(param0 + (long)BIG_CQE, 0);
    }

    public static long nbig_cqe(long param0, int param2) {
        return UNSAFE.getLong(null, param0 + (long)BIG_CQE + Checks.check(param2, 0) * 8L);
    }

    public static void nuser_data(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)USER_DATA, param2);
    }

    public static void nres(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RES, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nbig_cqe(long param0, LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)BIG_CQE, param2.remaining() * 8);
    }

    public static void nbig_cqe(long param0, int param2, long param3) {
        UNSAFE.putLong(null, param0 + (long)BIG_CQE + Checks.check(param2, 0) * 8L, param3);
    }

    static {
        Struct.Layout v0 = IOURingCQE.__struct(IOURingCQE.__member(8), IOURingCQE.__member(4), IOURingCQE.__member(4), IOURingCQE.__array(8, 0));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        USER_DATA = v0.offsetof(0);
        RES = v0.offsetof(1);
        FLAGS = v0.offsetof(2);
        BIG_CQE = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQE, Buffer>
    implements NativeResource {
        private static final IOURingCQE ELEMENT_FACTORY = IOURingCQE.create(-1L);

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
        protected IOURingCQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingCQE.nuser_data(this.address());
        }

        @NativeType(value="__s32")
        public int res() {
            return IOURingCQE.nres(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingCQE.nflags(this.address());
        }

        @NativeType(value="__u64[0]")
        public LongBuffer big_cqe() {
            return IOURingCQE.nbig_cqe(this.address());
        }

        @NativeType(value="__u64")
        public long big_cqe(int param1) {
            return IOURingCQE.nbig_cqe(this.address(), param1);
        }

        public Buffer user_data(@NativeType(value="__u64") long param1) {
            IOURingCQE.nuser_data(this.address(), param1);
            return this;
        }

        public Buffer res(@NativeType(value="__s32") int param1) {
            IOURingCQE.nres(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOURingCQE.nflags(this.address(), param1);
            return this;
        }

        public Buffer big_cqe(@NativeType(value="__u64[0]") LongBuffer param1) {
            IOURingCQE.nbig_cqe(this.address(), param1);
            return this;
        }

        public Buffer big_cqe(int param1, @NativeType(value="__u64") long param2) {
            IOURingCQE.nbig_cqe(this.address(), param1, param2);
            return this;
        }
    }
}

