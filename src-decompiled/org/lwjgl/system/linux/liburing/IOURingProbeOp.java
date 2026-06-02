/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_probe_op")
public class IOURingProbeOp
extends Struct<IOURingProbeOp>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OP;
    public static final int RESV;
    public static final int FLAGS;
    public static final int RESV2;

    protected IOURingProbeOp(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingProbeOp create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingProbeOp(param1, param3);
    }

    public IOURingProbeOp(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingProbeOp.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte op() {
        return IOURingProbeOp.nop(this.address());
    }

    @NativeType(value="__u8")
    public byte resv() {
        return IOURingProbeOp.nresv(this.address());
    }

    @NativeType(value="__u16")
    public short flags() {
        return IOURingProbeOp.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int resv2() {
        return IOURingProbeOp.nresv2(this.address());
    }

    public IOURingProbeOp op(@NativeType(value="__u8") byte param1) {
        IOURingProbeOp.nop(this.address(), param1);
        return this;
    }

    public IOURingProbeOp resv(@NativeType(value="__u8") byte param1) {
        IOURingProbeOp.nresv(this.address(), param1);
        return this;
    }

    public IOURingProbeOp flags(@NativeType(value="__u16") short param1) {
        IOURingProbeOp.nflags(this.address(), param1);
        return this;
    }

    public IOURingProbeOp resv2(@NativeType(value="__u32") int param1) {
        IOURingProbeOp.nresv2(this.address(), param1);
        return this;
    }

    public IOURingProbeOp set(byte param1, byte param2, short param3, int param4) {
        this.op(param1);
        this.resv(param2);
        this.flags(param3);
        this.resv2(param4);
        return this;
    }

    public IOURingProbeOp set(IOURingProbeOp param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingProbeOp malloc() {
        return new IOURingProbeOp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingProbeOp calloc() {
        return new IOURingProbeOp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingProbeOp create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingProbeOp(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingProbeOp create(long param0) {
        return new IOURingProbeOp(param0, null);
    }

    @Nullable
    public static IOURingProbeOp createSafe(long param0) {
        return param0 == 0L ? null : new IOURingProbeOp(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingProbeOp.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingProbeOp.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingProbeOp malloc(MemoryStack param0) {
        return new IOURingProbeOp(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingProbeOp calloc(MemoryStack param0) {
        return new IOURingProbeOp(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static byte nop(long param0) {
        return UNSAFE.getByte(null, param0 + (long)OP);
    }

    public static byte nresv(long param0) {
        return UNSAFE.getByte(null, param0 + (long)RESV);
    }

    public static short nflags(long param0) {
        return UNSAFE.getShort(null, param0 + (long)FLAGS);
    }

    public static int nresv2(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RESV2);
    }

    public static void nop(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)OP, param2);
    }

    public static void nresv(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)RESV, param2);
    }

    public static void nflags(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)FLAGS, param2);
    }

    public static void nresv2(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV2, param2);
    }

    static {
        Struct.Layout v0 = IOURingProbeOp.__struct(IOURingProbeOp.__member(1), IOURingProbeOp.__member(1), IOURingProbeOp.__member(2), IOURingProbeOp.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OP = v0.offsetof(0);
        RESV = v0.offsetof(1);
        FLAGS = v0.offsetof(2);
        RESV2 = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingProbeOp, Buffer>
    implements NativeResource {
        private static final IOURingProbeOp ELEMENT_FACTORY = IOURingProbeOp.create(-1L);

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
        protected IOURingProbeOp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte op() {
            return IOURingProbeOp.nop(this.address());
        }

        @NativeType(value="__u8")
        public byte resv() {
            return IOURingProbeOp.nresv(this.address());
        }

        @NativeType(value="__u16")
        public short flags() {
            return IOURingProbeOp.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int resv2() {
            return IOURingProbeOp.nresv2(this.address());
        }

        public Buffer op(@NativeType(value="__u8") byte param1) {
            IOURingProbeOp.nop(this.address(), param1);
            return this;
        }

        public Buffer resv(@NativeType(value="__u8") byte param1) {
            IOURingProbeOp.nresv(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u16") short param1) {
            IOURingProbeOp.nflags(this.address(), param1);
            return this;
        }

        public Buffer resv2(@NativeType(value="__u32") int param1) {
            IOURingProbeOp.nresv2(this.address(), param1);
            return this;
        }
    }
}

