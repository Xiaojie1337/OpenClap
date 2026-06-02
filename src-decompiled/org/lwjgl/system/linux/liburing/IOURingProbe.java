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
import org.lwjgl.system.linux.liburing.IOURingProbeOp;

@NativeType(value="struct io_uring_probe")
public class IOURingProbe
extends Struct<IOURingProbe>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LAST_OP;
    public static final int OPS_LEN;
    public static final int RESV;
    public static final int RESV2;
    public static final int OPS;

    protected IOURingProbe(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingProbe create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingProbe(param1, param3);
    }

    public IOURingProbe(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingProbe.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte last_op() {
        return IOURingProbe.nlast_op(this.address());
    }

    @NativeType(value="__u8")
    public byte ops_len() {
        return IOURingProbe.nops_len(this.address());
    }

    @NativeType(value="__u16")
    public short resv() {
        return IOURingProbe.nresv(this.address());
    }

    @NativeType(value="struct io_uring_probe_op[0]")
    public IOURingProbeOp.Buffer ops() {
        return IOURingProbe.nops(this.address());
    }

    @NativeType(value="struct io_uring_probe_op")
    public IOURingProbeOp ops(int param1) {
        return IOURingProbe.nops(this.address(), param1);
    }

    public IOURingProbe last_op(@NativeType(value="__u8") byte param1) {
        IOURingProbe.nlast_op(this.address(), param1);
        return this;
    }

    public IOURingProbe ops_len(@NativeType(value="__u8") byte param1) {
        IOURingProbe.nops_len(this.address(), param1);
        return this;
    }

    public IOURingProbe resv(@NativeType(value="__u16") short param1) {
        IOURingProbe.nresv(this.address(), param1);
        return this;
    }

    public IOURingProbe ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer param1) {
        IOURingProbe.nops(this.address(), param1);
        return this;
    }

    public IOURingProbe ops(int param1, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp param2) {
        IOURingProbe.nops(this.address(), param1, param2);
        return this;
    }

    public IOURingProbe ops(Consumer<IOURingProbeOp.Buffer> param1) {
        param1.accept(this.ops());
        return this;
    }

    public IOURingProbe ops(int param1, Consumer<IOURingProbeOp> param2) {
        param2.accept(this.ops(param1));
        return this;
    }

    public IOURingProbe set(byte param1, byte param2, short param3, IOURingProbeOp.Buffer param4) {
        this.last_op(param1);
        this.ops_len(param2);
        this.resv(param3);
        this.ops(param4);
        return this;
    }

    public IOURingProbe set(IOURingProbe param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbe malloc() {
        return new IOURingProbe(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingProbe calloc() {
        return new IOURingProbe(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingProbe create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingProbe(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingProbe create(long param0) {
        return new IOURingProbe(param0, null);
    }

    @Nullable
    public static IOURingProbe createSafe(long param0) {
        return param0 == 0L ? null : new IOURingProbe(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingProbe.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingProbe.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingProbe malloc(MemoryStack param0) {
        return new IOURingProbe(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingProbe calloc(MemoryStack param0) {
        return new IOURingProbe(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static byte nlast_op(long param0) {
        return UNSAFE.getByte(null, param0 + (long)LAST_OP);
    }

    public static byte nops_len(long param0) {
        return UNSAFE.getByte(null, param0 + (long)OPS_LEN);
    }

    public static short nresv(long param0) {
        return UNSAFE.getShort(null, param0 + (long)RESV);
    }

    public static IntBuffer nresv2(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)RESV2, 3);
    }

    public static int nresv2(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)RESV2 + Checks.check(param2, 3) * 4L);
    }

    public static IOURingProbeOp.Buffer nops(long param0) {
        return IOURingProbeOp.create(param0 + (long)OPS, 0);
    }

    public static IOURingProbeOp nops(long param0, int param2) {
        return IOURingProbeOp.create(param0 + (long)OPS + Checks.check(param2, 0) * (long)IOURingProbeOp.SIZEOF);
    }

    public static void nlast_op(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)LAST_OP, param2);
    }

    public static void nops_len(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)OPS_LEN, param2);
    }

    public static void nresv(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)RESV, param2);
    }

    public static void nresv2(long param0, IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 3);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)RESV2, param2.remaining() * 4);
    }

    public static void nresv2(long param0, int param2, int param3) {
        UNSAFE.putInt(null, param0 + (long)RESV2 + Checks.check(param2, 3) * 4L, param3);
    }

    public static void nops(long param0, IOURingProbeOp.Buffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 0);
        }
        MemoryUtil.memCopy(param2.address(), param0 + (long)OPS, param2.remaining() * IOURingProbeOp.SIZEOF);
    }

    public static void nops(long param0, int param2, IOURingProbeOp param3) {
        MemoryUtil.memCopy(param3.address(), param0 + (long)OPS + Checks.check(param2, 0) * (long)IOURingProbeOp.SIZEOF, IOURingProbeOp.SIZEOF);
    }

    static {
        Struct.Layout v0 = IOURingProbe.__struct(IOURingProbe.__member(1), IOURingProbe.__member(1), IOURingProbe.__member(2), IOURingProbe.__array(4, 3), IOURingProbe.__array(IOURingProbeOp.SIZEOF, IOURingProbeOp.ALIGNOF, 0));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        LAST_OP = v0.offsetof(0);
        OPS_LEN = v0.offsetof(1);
        RESV = v0.offsetof(2);
        RESV2 = v0.offsetof(3);
        OPS = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbe, Buffer>
    implements NativeResource {
        private static final IOURingProbe ELEMENT_FACTORY = IOURingProbe.create(-1L);

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
        protected IOURingProbe getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte last_op() {
            return IOURingProbe.nlast_op(this.address());
        }

        @NativeType(value="__u8")
        public byte ops_len() {
            return IOURingProbe.nops_len(this.address());
        }

        @NativeType(value="__u16")
        public short resv() {
            return IOURingProbe.nresv(this.address());
        }

        @NativeType(value="struct io_uring_probe_op[0]")
        public IOURingProbeOp.Buffer ops() {
            return IOURingProbe.nops(this.address());
        }

        @NativeType(value="struct io_uring_probe_op")
        public IOURingProbeOp ops(int param1) {
            return IOURingProbe.nops(this.address(), param1);
        }

        public Buffer last_op(@NativeType(value="__u8") byte param1) {
            IOURingProbe.nlast_op(this.address(), param1);
            return this;
        }

        public Buffer ops_len(@NativeType(value="__u8") byte param1) {
            IOURingProbe.nops_len(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u16") short param1) {
            IOURingProbe.nresv(this.address(), param1);
            return this;
        }

        public Buffer ops(@NativeType(value="struct io_uring_probe_op[0]") IOURingProbeOp.Buffer param1) {
            IOURingProbe.nops(this.address(), param1);
            return this;
        }

        public Buffer ops(int param1, @NativeType(value="struct io_uring_probe_op") IOURingProbeOp param2) {
            IOURingProbe.nops(this.address(), param1, param2);
            return this;
        }

        public Buffer ops(Consumer<IOURingProbeOp.Buffer> param1) {
            param1.accept(this.ops());
            return this;
        }

        public Buffer ops(int param1, Consumer<IOURingProbeOp> param2) {
            param2.accept(this.ops(param1));
            return this;
        }
    }
}

