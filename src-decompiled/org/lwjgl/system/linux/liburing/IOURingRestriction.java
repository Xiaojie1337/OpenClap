/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_restriction")
public class IOURingRestriction
extends Struct<IOURingRestriction>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int REGISTER_OP;
    public static final int SQE_OP;
    public static final int SQE_FLAGS;
    public static final int RESV;
    public static final int RESV2;

    protected IOURingRestriction(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingRestriction create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingRestriction(param1, param3);
    }

    public IOURingRestriction(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingRestriction.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u16")
    public short opcode() {
        return IOURingRestriction.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte register_op() {
        return IOURingRestriction.nregister_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_op() {
        return IOURingRestriction.nsqe_op(this.address());
    }

    @NativeType(value="__u8")
    public byte sqe_flags() {
        return IOURingRestriction.nsqe_flags(this.address());
    }

    public IOURingRestriction opcode(@NativeType(value="__u16") short param1) {
        IOURingRestriction.nopcode(this.address(), param1);
        return this;
    }

    public IOURingRestriction register_op(@NativeType(value="__u8") byte param1) {
        IOURingRestriction.nregister_op(this.address(), param1);
        return this;
    }

    public IOURingRestriction sqe_op(@NativeType(value="__u8") byte param1) {
        IOURingRestriction.nsqe_op(this.address(), param1);
        return this;
    }

    public IOURingRestriction sqe_flags(@NativeType(value="__u8") byte param1) {
        IOURingRestriction.nsqe_flags(this.address(), param1);
        return this;
    }

    public IOURingRestriction set(IOURingRestriction param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRestriction malloc() {
        return new IOURingRestriction(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRestriction calloc() {
        return new IOURingRestriction(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRestriction create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRestriction(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingRestriction create(long param0) {
        return new IOURingRestriction(param0, null);
    }

    @Nullable
    public static IOURingRestriction createSafe(long param0) {
        return param0 == 0L ? null : new IOURingRestriction(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRestriction.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingRestriction.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingRestriction malloc(MemoryStack param0) {
        return new IOURingRestriction(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRestriction calloc(MemoryStack param0) {
        return new IOURingRestriction(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static short nopcode(long param0) {
        return UNSAFE.getShort(null, param0 + (long)OPCODE);
    }

    public static byte nregister_op(long param0) {
        return UNSAFE.getByte(null, param0 + (long)REGISTER_OP);
    }

    public static byte nsqe_op(long param0) {
        return UNSAFE.getByte(null, param0 + (long)SQE_OP);
    }

    public static byte nsqe_flags(long param0) {
        return UNSAFE.getByte(null, param0 + (long)SQE_FLAGS);
    }

    public static byte nresv(long param0) {
        return UNSAFE.getByte(null, param0 + (long)RESV);
    }

    public static IntBuffer nresv2(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)RESV2, 3);
    }

    public static int nresv2(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)RESV2 + Checks.check(param2, 3) * 4L);
    }

    public static void nopcode(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)OPCODE, param2);
    }

    public static void nregister_op(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)REGISTER_OP, param2);
    }

    public static void nsqe_op(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)SQE_OP, param2);
    }

    public static void nsqe_flags(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)SQE_FLAGS, param2);
    }

    public static void nresv(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)RESV, param2);
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

    static {
        Struct.Layout v0 = IOURingRestriction.__struct(IOURingRestriction.__member(2), IOURingRestriction.__union(IOURingRestriction.__member(1), IOURingRestriction.__member(1), IOURingRestriction.__member(1)), IOURingRestriction.__member(1), IOURingRestriction.__array(4, 3));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OPCODE = v0.offsetof(0);
        REGISTER_OP = v0.offsetof(2);
        SQE_OP = v0.offsetof(3);
        SQE_FLAGS = v0.offsetof(4);
        RESV = v0.offsetof(5);
        RESV2 = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<IOURingRestriction, Buffer>
    implements NativeResource {
        private static final IOURingRestriction ELEMENT_FACTORY = IOURingRestriction.create(-1L);

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
        protected IOURingRestriction getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u16")
        public short opcode() {
            return IOURingRestriction.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte register_op() {
            return IOURingRestriction.nregister_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_op() {
            return IOURingRestriction.nsqe_op(this.address());
        }

        @NativeType(value="__u8")
        public byte sqe_flags() {
            return IOURingRestriction.nsqe_flags(this.address());
        }

        public Buffer opcode(@NativeType(value="__u16") short param1) {
            IOURingRestriction.nopcode(this.address(), param1);
            return this;
        }

        public Buffer register_op(@NativeType(value="__u8") byte param1) {
            IOURingRestriction.nregister_op(this.address(), param1);
            return this;
        }

        public Buffer sqe_op(@NativeType(value="__u8") byte param1) {
            IOURingRestriction.nsqe_op(this.address(), param1);
            return this;
        }

        public Buffer sqe_flags(@NativeType(value="__u8") byte param1) {
            IOURingRestriction.nsqe_flags(this.address(), param1);
            return this;
        }
    }
}

