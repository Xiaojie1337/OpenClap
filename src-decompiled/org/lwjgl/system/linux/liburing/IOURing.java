/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
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
import org.lwjgl.system.linux.liburing.IOURingCQ;
import org.lwjgl.system.linux.liburing.IOURingSQ;

@NativeType(value="struct io_uring")
public class IOURing
extends Struct<IOURing>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ;
    public static final int CQ;
    public static final int FLAGS;
    public static final int RING_FD;
    public static final int FEATURES;
    public static final int ENTER_RING_FD;
    public static final int INT_FLAGS;
    public static final int PAD;
    public static final int PAD2;

    protected IOURing(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURing create(long param1, @Nullable ByteBuffer param3) {
        return new IOURing(param1, param3);
    }

    public IOURing(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURing.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="struct io_uring_sq")
    public IOURingSQ sq() {
        return IOURing.nsq(this.address());
    }

    @NativeType(value="struct io_uring_cq")
    public IOURingCQ cq() {
        return IOURing.ncq(this.address());
    }

    @NativeType(value="unsigned int")
    public int flags() {
        return IOURing.nflags(this.address());
    }

    public int ring_fd() {
        return IOURing.nring_fd(this.address());
    }

    @NativeType(value="unsigned int")
    public int features() {
        return IOURing.nfeatures(this.address());
    }

    public int enter_ring_fd() {
        return IOURing.nenter_ring_fd(this.address());
    }

    @NativeType(value="__u8")
    public byte int_flags() {
        return IOURing.nint_flags(this.address());
    }

    public IOURing sq(@NativeType(value="struct io_uring_sq") IOURingSQ param1) {
        IOURing.nsq(this.address(), param1);
        return this;
    }

    public IOURing sq(Consumer<IOURingSQ> param1) {
        param1.accept(this.sq());
        return this;
    }

    public IOURing cq(@NativeType(value="struct io_uring_cq") IOURingCQ param1) {
        IOURing.ncq(this.address(), param1);
        return this;
    }

    public IOURing cq(Consumer<IOURingCQ> param1) {
        param1.accept(this.cq());
        return this;
    }

    public IOURing flags(@NativeType(value="unsigned int") int param1) {
        IOURing.nflags(this.address(), param1);
        return this;
    }

    public IOURing ring_fd(int param1) {
        IOURing.nring_fd(this.address(), param1);
        return this;
    }

    public IOURing features(@NativeType(value="unsigned int") int param1) {
        IOURing.nfeatures(this.address(), param1);
        return this;
    }

    public IOURing enter_ring_fd(int param1) {
        IOURing.nenter_ring_fd(this.address(), param1);
        return this;
    }

    public IOURing int_flags(@NativeType(value="__u8") byte param1) {
        IOURing.nint_flags(this.address(), param1);
        return this;
    }

    public IOURing set(IOURingSQ param1, IOURingCQ param2, int param3, int param4, int param5, int param6, byte param7) {
        this.sq(param1);
        this.cq(param2);
        this.flags(param3);
        this.ring_fd(param4);
        this.features(param5);
        this.enter_ring_fd(param6);
        this.int_flags(param7);
        return this;
    }

    public IOURing set(IOURing param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURing malloc() {
        return new IOURing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURing calloc() {
        return new IOURing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURing create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURing(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURing create(long param0) {
        return new IOURing(param0, null);
    }

    @Nullable
    public static IOURing createSafe(long param0) {
        return param0 == 0L ? null : new IOURing(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURing.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURing.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURing malloc(MemoryStack param0) {
        return new IOURing(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURing calloc(MemoryStack param0) {
        return new IOURing(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static IOURingSQ nsq(long param0) {
        return IOURingSQ.create(param0 + (long)SQ);
    }

    public static IOURingCQ ncq(long param0) {
        return IOURingCQ.create(param0 + (long)CQ);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static int nring_fd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_FD);
    }

    public static int nfeatures(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FEATURES);
    }

    public static int nenter_ring_fd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)ENTER_RING_FD);
    }

    public static byte nint_flags(long param0) {
        return UNSAFE.getByte(null, param0 + (long)INT_FLAGS);
    }

    public static ByteBuffer npad(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)PAD, 3);
    }

    public static byte npad(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)PAD + Checks.check(param2, 3) * 1L);
    }

    public static int npad2(long param0) {
        return UNSAFE.getInt(null, param0 + (long)PAD2);
    }

    public static void nsq(long param0, IOURingSQ param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)SQ, IOURingSQ.SIZEOF);
    }

    public static void ncq(long param0, IOURingCQ param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)CQ, IOURingCQ.SIZEOF);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nring_fd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_FD, param2);
    }

    public static void nfeatures(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FEATURES, param2);
    }

    public static void nenter_ring_fd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)ENTER_RING_FD, param2);
    }

    public static void nint_flags(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)INT_FLAGS, param2);
    }

    public static void npad(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)PAD, param2.remaining() * 1);
    }

    public static void npad(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)PAD + Checks.check(param2, 3) * 1L, param3);
    }

    public static void npad2(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)PAD2, param2);
    }

    public static void validate(long param0) {
        IOURingSQ.validate(param0 + (long)SQ);
        IOURingCQ.validate(param0 + (long)CQ);
    }

    static {
        Struct.Layout v0 = IOURing.__struct(IOURing.__member(IOURingSQ.SIZEOF, IOURingSQ.ALIGNOF), IOURing.__member(IOURingCQ.SIZEOF, IOURingCQ.ALIGNOF), IOURing.__member(4), IOURing.__member(4), IOURing.__member(4), IOURing.__member(4), IOURing.__member(1), IOURing.__array(1, 3), IOURing.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        SQ = v0.offsetof(0);
        CQ = v0.offsetof(1);
        FLAGS = v0.offsetof(2);
        RING_FD = v0.offsetof(3);
        FEATURES = v0.offsetof(4);
        ENTER_RING_FD = v0.offsetof(5);
        INT_FLAGS = v0.offsetof(6);
        PAD = v0.offsetof(7);
        PAD2 = v0.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOURing, Buffer>
    implements NativeResource {
        private static final IOURing ELEMENT_FACTORY = IOURing.create(-1L);

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
        protected IOURing getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="struct io_uring_sq")
        public IOURingSQ sq() {
            return IOURing.nsq(this.address());
        }

        @NativeType(value="struct io_uring_cq")
        public IOURingCQ cq() {
            return IOURing.ncq(this.address());
        }

        @NativeType(value="unsigned int")
        public int flags() {
            return IOURing.nflags(this.address());
        }

        public int ring_fd() {
            return IOURing.nring_fd(this.address());
        }

        @NativeType(value="unsigned int")
        public int features() {
            return IOURing.nfeatures(this.address());
        }

        public int enter_ring_fd() {
            return IOURing.nenter_ring_fd(this.address());
        }

        @NativeType(value="__u8")
        public byte int_flags() {
            return IOURing.nint_flags(this.address());
        }

        public Buffer sq(@NativeType(value="struct io_uring_sq") IOURingSQ param1) {
            IOURing.nsq(this.address(), param1);
            return this;
        }

        public Buffer sq(Consumer<IOURingSQ> param1) {
            param1.accept(this.sq());
            return this;
        }

        public Buffer cq(@NativeType(value="struct io_uring_cq") IOURingCQ param1) {
            IOURing.ncq(this.address(), param1);
            return this;
        }

        public Buffer cq(Consumer<IOURingCQ> param1) {
            param1.accept(this.cq());
            return this;
        }

        public Buffer flags(@NativeType(value="unsigned int") int param1) {
            IOURing.nflags(this.address(), param1);
            return this;
        }

        public Buffer ring_fd(int param1) {
            IOURing.nring_fd(this.address(), param1);
            return this;
        }

        public Buffer features(@NativeType(value="unsigned int") int param1) {
            IOURing.nfeatures(this.address(), param1);
            return this;
        }

        public Buffer enter_ring_fd(int param1) {
            IOURing.nenter_ring_fd(this.address(), param1);
            return this;
        }

        public Buffer int_flags(@NativeType(value="__u8") byte param1) {
            IOURing.nint_flags(this.address(), param1);
            return this;
        }
    }
}

