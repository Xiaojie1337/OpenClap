/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.KernelTimespec;

@NativeType(value="struct io_uring_sync_cancel_reg")
public class IOURingSyncCancelReg
extends Struct<IOURingSyncCancelReg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ADDR;
    public static final int FD;
    public static final int FLAGS;
    public static final int TIMEOUT;
    public static final int PAD;

    protected IOURingSyncCancelReg(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingSyncCancelReg create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingSyncCancelReg(param1, param3);
    }

    public IOURingSyncCancelReg(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingSyncCancelReg.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingSyncCancelReg.naddr(this.address());
    }

    @NativeType(value="__s32")
    public int fd() {
        return IOURingSyncCancelReg.nfd(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingSyncCancelReg.nflags(this.address());
    }

    @NativeType(value="struct __kernel_timespec")
    public KernelTimespec timeout() {
        return IOURingSyncCancelReg.ntimeout(this.address());
    }

    public IOURingSyncCancelReg addr(@NativeType(value="__u64") long param1) {
        IOURingSyncCancelReg.naddr(this.address(), param1);
        return this;
    }

    public IOURingSyncCancelReg fd(@NativeType(value="__s32") int param1) {
        IOURingSyncCancelReg.nfd(this.address(), param1);
        return this;
    }

    public IOURingSyncCancelReg flags(@NativeType(value="__u32") int param1) {
        IOURingSyncCancelReg.nflags(this.address(), param1);
        return this;
    }

    public IOURingSyncCancelReg timeout(@NativeType(value="struct __kernel_timespec") KernelTimespec param1) {
        IOURingSyncCancelReg.ntimeout(this.address(), param1);
        return this;
    }

    public IOURingSyncCancelReg timeout(Consumer<KernelTimespec> param1) {
        param1.accept(this.timeout());
        return this;
    }

    public IOURingSyncCancelReg set(long param1, int param3, int param4, KernelTimespec param5) {
        this.addr(param1);
        this.fd(param3);
        this.flags(param4);
        this.timeout(param5);
        return this;
    }

    public IOURingSyncCancelReg set(IOURingSyncCancelReg param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSyncCancelReg malloc() {
        return new IOURingSyncCancelReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSyncCancelReg calloc() {
        return new IOURingSyncCancelReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSyncCancelReg create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSyncCancelReg(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingSyncCancelReg create(long param0) {
        return new IOURingSyncCancelReg(param0, null);
    }

    @Nullable
    public static IOURingSyncCancelReg createSafe(long param0) {
        return param0 == 0L ? null : new IOURingSyncCancelReg(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSyncCancelReg.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingSyncCancelReg.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingSyncCancelReg malloc(MemoryStack param0) {
        return new IOURingSyncCancelReg(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSyncCancelReg calloc(MemoryStack param0) {
        return new IOURingSyncCancelReg(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long naddr(long param0) {
        return UNSAFE.getLong(null, param0 + (long)ADDR);
    }

    public static int nfd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FD);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static KernelTimespec ntimeout(long param0) {
        return KernelTimespec.create(param0 + (long)TIMEOUT);
    }

    public static LongBuffer npad(long param0) {
        return MemoryUtil.memLongBuffer(param0 + (long)PAD, 4);
    }

    public static long npad(long param0, int param2) {
        return UNSAFE.getLong(null, param0 + (long)PAD + Checks.check(param2, 4) * 8L);
    }

    public static void naddr(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)ADDR, param2);
    }

    public static void nfd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FD, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void ntimeout(long param0, KernelTimespec param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TIMEOUT, KernelTimespec.SIZEOF);
    }

    public static void npad(long param0, LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)PAD, param2.remaining() * 8);
    }

    public static void npad(long param0, int param2, long param3) {
        UNSAFE.putLong(null, param0 + (long)PAD + Checks.check(param2, 4) * 8L, param3);
    }

    static {
        Struct.Layout v0 = IOURingSyncCancelReg.__struct(IOURingSyncCancelReg.__member(8), IOURingSyncCancelReg.__member(4), IOURingSyncCancelReg.__member(4), IOURingSyncCancelReg.__member(KernelTimespec.SIZEOF, KernelTimespec.ALIGNOF), IOURingSyncCancelReg.__array(8, 4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        ADDR = v0.offsetof(0);
        FD = v0.offsetof(1);
        FLAGS = v0.offsetof(2);
        TIMEOUT = v0.offsetof(3);
        PAD = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingSyncCancelReg, Buffer>
    implements NativeResource {
        private static final IOURingSyncCancelReg ELEMENT_FACTORY = IOURingSyncCancelReg.create(-1L);

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
        protected IOURingSyncCancelReg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingSyncCancelReg.naddr(this.address());
        }

        @NativeType(value="__s32")
        public int fd() {
            return IOURingSyncCancelReg.nfd(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingSyncCancelReg.nflags(this.address());
        }

        @NativeType(value="struct __kernel_timespec")
        public KernelTimespec timeout() {
            return IOURingSyncCancelReg.ntimeout(this.address());
        }

        public Buffer addr(@NativeType(value="__u64") long param1) {
            IOURingSyncCancelReg.naddr(this.address(), param1);
            return this;
        }

        public Buffer fd(@NativeType(value="__s32") int param1) {
            IOURingSyncCancelReg.nfd(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOURingSyncCancelReg.nflags(this.address(), param1);
            return this;
        }

        public Buffer timeout(@NativeType(value="struct __kernel_timespec") KernelTimespec param1) {
            IOURingSyncCancelReg.ntimeout(this.address(), param1);
            return this;
        }

        public Buffer timeout(Consumer<KernelTimespec> param1) {
            param1.accept(this.timeout());
            return this;
        }
    }
}

