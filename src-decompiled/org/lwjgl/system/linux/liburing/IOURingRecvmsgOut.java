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

@NativeType(value="struct io_uring_recvmsg_out")
public class IOURingRecvmsgOut
extends Struct<IOURingRecvmsgOut>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAMELEN;
    public static final int CONTROLLEN;
    public static final int PAYLOADLEN;
    public static final int FLAGS;

    protected IOURingRecvmsgOut(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingRecvmsgOut create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingRecvmsgOut(param1, param3);
    }

    public IOURingRecvmsgOut(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingRecvmsgOut.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int namelen() {
        return IOURingRecvmsgOut.nnamelen(this.address());
    }

    @NativeType(value="__u32")
    public int controllen() {
        return IOURingRecvmsgOut.ncontrollen(this.address());
    }

    @NativeType(value="__u32")
    public int payloadlen() {
        return IOURingRecvmsgOut.npayloadlen(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOURingRecvmsgOut.nflags(this.address());
    }

    public IOURingRecvmsgOut namelen(@NativeType(value="__u32") int param1) {
        IOURingRecvmsgOut.nnamelen(this.address(), param1);
        return this;
    }

    public IOURingRecvmsgOut controllen(@NativeType(value="__u32") int param1) {
        IOURingRecvmsgOut.ncontrollen(this.address(), param1);
        return this;
    }

    public IOURingRecvmsgOut payloadlen(@NativeType(value="__u32") int param1) {
        IOURingRecvmsgOut.npayloadlen(this.address(), param1);
        return this;
    }

    public IOURingRecvmsgOut flags(@NativeType(value="__u32") int param1) {
        IOURingRecvmsgOut.nflags(this.address(), param1);
        return this;
    }

    public IOURingRecvmsgOut set(int param1, int param2, int param3, int param4) {
        this.namelen(param1);
        this.controllen(param2);
        this.payloadlen(param3);
        this.flags(param4);
        return this;
    }

    public IOURingRecvmsgOut set(IOURingRecvmsgOut param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRecvmsgOut malloc() {
        return new IOURingRecvmsgOut(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRecvmsgOut calloc() {
        return new IOURingRecvmsgOut(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRecvmsgOut create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRecvmsgOut(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingRecvmsgOut create(long param0) {
        return new IOURingRecvmsgOut(param0, null);
    }

    @Nullable
    public static IOURingRecvmsgOut createSafe(long param0) {
        return param0 == 0L ? null : new IOURingRecvmsgOut(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRecvmsgOut.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingRecvmsgOut.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingRecvmsgOut malloc(MemoryStack param0) {
        return new IOURingRecvmsgOut(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRecvmsgOut calloc(MemoryStack param0) {
        return new IOURingRecvmsgOut(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nnamelen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NAMELEN);
    }

    public static int ncontrollen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CONTROLLEN);
    }

    public static int npayloadlen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)PAYLOADLEN);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static void nnamelen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NAMELEN, param2);
    }

    public static void ncontrollen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CONTROLLEN, param2);
    }

    public static void npayloadlen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)PAYLOADLEN, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    static {
        Struct.Layout v0 = IOURingRecvmsgOut.__struct(IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4), IOURingRecvmsgOut.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NAMELEN = v0.offsetof(0);
        CONTROLLEN = v0.offsetof(1);
        PAYLOADLEN = v0.offsetof(2);
        FLAGS = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingRecvmsgOut, Buffer>
    implements NativeResource {
        private static final IOURingRecvmsgOut ELEMENT_FACTORY = IOURingRecvmsgOut.create(-1L);

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
        protected IOURingRecvmsgOut getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int namelen() {
            return IOURingRecvmsgOut.nnamelen(this.address());
        }

        @NativeType(value="__u32")
        public int controllen() {
            return IOURingRecvmsgOut.ncontrollen(this.address());
        }

        @NativeType(value="__u32")
        public int payloadlen() {
            return IOURingRecvmsgOut.npayloadlen(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOURingRecvmsgOut.nflags(this.address());
        }

        public Buffer namelen(@NativeType(value="__u32") int param1) {
            IOURingRecvmsgOut.nnamelen(this.address(), param1);
            return this;
        }

        public Buffer controllen(@NativeType(value="__u32") int param1) {
            IOURingRecvmsgOut.ncontrollen(this.address(), param1);
            return this;
        }

        public Buffer payloadlen(@NativeType(value="__u32") int param1) {
            IOURingRecvmsgOut.npayloadlen(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOURingRecvmsgOut.nflags(this.address(), param1);
            return this;
        }
    }
}

