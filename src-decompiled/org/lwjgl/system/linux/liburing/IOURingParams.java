/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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
import org.lwjgl.system.linux.liburing.IOCQRingOffsets;
import org.lwjgl.system.linux.liburing.IOSQRingOffsets;

@NativeType(value="struct io_uring_params")
public class IOURingParams
extends Struct<IOURingParams>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SQ_ENTRIES;
    public static final int CQ_ENTRIES;
    public static final int FLAGS;
    public static final int SQ_THREAD_CPU;
    public static final int SQ_THREAD_IDLE;
    public static final int FEATURES;
    public static final int WQ_FD;
    public static final int RESV;
    public static final int SQ_OFF;
    public static final int CQ_OFF;

    protected IOURingParams(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingParams create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingParams(param1, param3);
    }

    public IOURingParams(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingParams.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int sq_entries() {
        return IOURingParams.nsq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int cq_entries() {
        return IOURingParams.ncq_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingParams.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_cpu() {
        return IOURingParams.nsq_thread_cpu(this.address());
    }

    @NativeType(value="__u32")
    public int sq_thread_idle() {
        return IOURingParams.nsq_thread_idle(this.address());
    }

    @NativeType(value="__u32")
    public int features() {
        return IOURingParams.nfeatures(this.address());
    }

    @NativeType(value="__u32")
    public int wq_fd() {
        return IOURingParams.nwq_fd(this.address());
    }

    @NativeType(value="__u32[3]")
    public IntBuffer resv() {
        return IOURingParams.nresv(this.address());
    }

    @NativeType(value="__u32")
    public int resv(int param1) {
        return IOURingParams.nresv(this.address(), param1);
    }

    @NativeType(value="struct io_sqring_offsets")
    public IOSQRingOffsets sq_off() {
        return IOURingParams.nsq_off(this.address());
    }

    @NativeType(value="struct io_cqring_offsets")
    public IOCQRingOffsets cq_off() {
        return IOURingParams.ncq_off(this.address());
    }

    public IOURingParams sq_entries(@NativeType(value="__u32") int param1) {
        IOURingParams.nsq_entries(this.address(), param1);
        return this;
    }

    public IOURingParams cq_entries(@NativeType(value="__u32") int param1) {
        IOURingParams.ncq_entries(this.address(), param1);
        return this;
    }

    public IOURingParams flags(@NativeType(value="__u32") int param1) {
        IOURingParams.nflags(this.address(), param1);
        return this;
    }

    public IOURingParams sq_thread_cpu(@NativeType(value="__u32") int param1) {
        IOURingParams.nsq_thread_cpu(this.address(), param1);
        return this;
    }

    public IOURingParams sq_thread_idle(@NativeType(value="__u32") int param1) {
        IOURingParams.nsq_thread_idle(this.address(), param1);
        return this;
    }

    public IOURingParams features(@NativeType(value="__u32") int param1) {
        IOURingParams.nfeatures(this.address(), param1);
        return this;
    }

    public IOURingParams wq_fd(@NativeType(value="__u32") int param1) {
        IOURingParams.nwq_fd(this.address(), param1);
        return this;
    }

    public IOURingParams resv(@NativeType(value="__u32[3]") IntBuffer param1) {
        IOURingParams.nresv(this.address(), param1);
        return this;
    }

    public IOURingParams resv(int param1, @NativeType(value="__u32") int param2) {
        IOURingParams.nresv(this.address(), param1, param2);
        return this;
    }

    public IOURingParams sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets param1) {
        IOURingParams.nsq_off(this.address(), param1);
        return this;
    }

    public IOURingParams sq_off(Consumer<IOSQRingOffsets> param1) {
        param1.accept(this.sq_off());
        return this;
    }

    public IOURingParams cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets param1) {
        IOURingParams.ncq_off(this.address(), param1);
        return this;
    }

    public IOURingParams cq_off(Consumer<IOCQRingOffsets> param1) {
        param1.accept(this.cq_off());
        return this;
    }

    public IOURingParams set(int param1, int param2, int param3, int param4, int param5, int param6, int param7, IntBuffer param8, IOSQRingOffsets param9, IOCQRingOffsets param10) {
        this.sq_entries(param1);
        this.cq_entries(param2);
        this.flags(param3);
        this.sq_thread_cpu(param4);
        this.sq_thread_idle(param5);
        this.features(param6);
        this.wq_fd(param7);
        this.resv(param8);
        this.sq_off(param9);
        this.cq_off(param10);
        return this;
    }

    public IOURingParams set(IOURingParams param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingParams malloc() {
        return new IOURingParams(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingParams calloc() {
        return new IOURingParams(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingParams create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingParams(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingParams create(long param0) {
        return new IOURingParams(param0, null);
    }

    @Nullable
    public static IOURingParams createSafe(long param0) {
        return param0 == 0L ? null : new IOURingParams(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingParams.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingParams.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingParams malloc(MemoryStack param0) {
        return new IOURingParams(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingParams calloc(MemoryStack param0) {
        return new IOURingParams(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nsq_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SQ_ENTRIES);
    }

    public static int ncq_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CQ_ENTRIES);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static int nsq_thread_cpu(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SQ_THREAD_CPU);
    }

    public static int nsq_thread_idle(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SQ_THREAD_IDLE);
    }

    public static int nfeatures(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FEATURES);
    }

    public static int nwq_fd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)WQ_FD);
    }

    public static IntBuffer nresv(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)RESV, 3);
    }

    public static int nresv(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)RESV + Checks.check(param2, 3) * 4L);
    }

    public static IOSQRingOffsets nsq_off(long param0) {
        return IOSQRingOffsets.create(param0 + (long)SQ_OFF);
    }

    public static IOCQRingOffsets ncq_off(long param0) {
        return IOCQRingOffsets.create(param0 + (long)CQ_OFF);
    }

    public static void nsq_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SQ_ENTRIES, param2);
    }

    public static void ncq_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CQ_ENTRIES, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nsq_thread_cpu(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SQ_THREAD_CPU, param2);
    }

    public static void nsq_thread_idle(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SQ_THREAD_IDLE, param2);
    }

    public static void nfeatures(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FEATURES, param2);
    }

    public static void nwq_fd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)WQ_FD, param2);
    }

    public static void nresv(long param0, IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)RESV, param2.remaining() * 4);
    }

    public static void nresv(long param0, int param2, int param3) {
        UNSAFE.putInt(null, param0 + (long)RESV + Checks.check(param2, 3) * 4L, param3);
    }

    public static void nsq_off(long param0, IOSQRingOffsets param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)SQ_OFF, IOSQRingOffsets.SIZEOF);
    }

    public static void ncq_off(long param0, IOCQRingOffsets param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)CQ_OFF, IOCQRingOffsets.SIZEOF);
    }

    static {
        Struct.Layout v0 = IOURingParams.__struct(IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__member(4), IOURingParams.__array(4, 3), IOURingParams.__member(IOSQRingOffsets.SIZEOF, IOSQRingOffsets.ALIGNOF), IOURingParams.__member(IOCQRingOffsets.SIZEOF, IOCQRingOffsets.ALIGNOF));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        SQ_ENTRIES = v0.offsetof(0);
        CQ_ENTRIES = v0.offsetof(1);
        FLAGS = v0.offsetof(2);
        SQ_THREAD_CPU = v0.offsetof(3);
        SQ_THREAD_IDLE = v0.offsetof(4);
        FEATURES = v0.offsetof(5);
        WQ_FD = v0.offsetof(6);
        RESV = v0.offsetof(7);
        SQ_OFF = v0.offsetof(8);
        CQ_OFF = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<IOURingParams, Buffer>
    implements NativeResource {
        private static final IOURingParams ELEMENT_FACTORY = IOURingParams.create(-1L);

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
        protected IOURingParams getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int sq_entries() {
            return IOURingParams.nsq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int cq_entries() {
            return IOURingParams.ncq_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingParams.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_cpu() {
            return IOURingParams.nsq_thread_cpu(this.address());
        }

        @NativeType(value="__u32")
        public int sq_thread_idle() {
            return IOURingParams.nsq_thread_idle(this.address());
        }

        @NativeType(value="__u32")
        public int features() {
            return IOURingParams.nfeatures(this.address());
        }

        @NativeType(value="__u32")
        public int wq_fd() {
            return IOURingParams.nwq_fd(this.address());
        }

        @NativeType(value="__u32[3]")
        public IntBuffer resv() {
            return IOURingParams.nresv(this.address());
        }

        @NativeType(value="__u32")
        public int resv(int param1) {
            return IOURingParams.nresv(this.address(), param1);
        }

        @NativeType(value="struct io_sqring_offsets")
        public IOSQRingOffsets sq_off() {
            return IOURingParams.nsq_off(this.address());
        }

        @NativeType(value="struct io_cqring_offsets")
        public IOCQRingOffsets cq_off() {
            return IOURingParams.ncq_off(this.address());
        }

        public Buffer sq_entries(@NativeType(value="__u32") int param1) {
            IOURingParams.nsq_entries(this.address(), param1);
            return this;
        }

        public Buffer cq_entries(@NativeType(value="__u32") int param1) {
            IOURingParams.ncq_entries(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOURingParams.nflags(this.address(), param1);
            return this;
        }

        public Buffer sq_thread_cpu(@NativeType(value="__u32") int param1) {
            IOURingParams.nsq_thread_cpu(this.address(), param1);
            return this;
        }

        public Buffer sq_thread_idle(@NativeType(value="__u32") int param1) {
            IOURingParams.nsq_thread_idle(this.address(), param1);
            return this;
        }

        public Buffer features(@NativeType(value="__u32") int param1) {
            IOURingParams.nfeatures(this.address(), param1);
            return this;
        }

        public Buffer wq_fd(@NativeType(value="__u32") int param1) {
            IOURingParams.nwq_fd(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u32[3]") IntBuffer param1) {
            IOURingParams.nresv(this.address(), param1);
            return this;
        }

        public Buffer resv(int param1, @NativeType(value="__u32") int param2) {
            IOURingParams.nresv(this.address(), param1, param2);
            return this;
        }

        public Buffer sq_off(@NativeType(value="struct io_sqring_offsets") IOSQRingOffsets param1) {
            IOURingParams.nsq_off(this.address(), param1);
            return this;
        }

        public Buffer sq_off(Consumer<IOSQRingOffsets> param1) {
            param1.accept(this.sq_off());
            return this;
        }

        public Buffer cq_off(@NativeType(value="struct io_cqring_offsets") IOCQRingOffsets param1) {
            IOURingParams.ncq_off(this.address(), param1);
            return this;
        }

        public Buffer cq_off(Consumer<IOCQRingOffsets> param1) {
            param1.accept(this.cq_off());
            return this;
        }
    }
}

