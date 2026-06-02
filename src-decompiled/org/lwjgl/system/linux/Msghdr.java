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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.IOVec;

@NativeType(value="struct msghdr")
public class Msghdr
extends Struct<Msghdr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int MSG_NAME;
    public static final int MSG_NAMELEN;
    public static final int MSG_IOV;
    public static final int MSG_IOVLEN;
    public static final int MSG_CONTROL;
    public static final int MSG_CONTROLLEN;
    public static final int MSG_FLAGS;

    protected Msghdr(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected Msghdr create(long param1, @Nullable ByteBuffer param3) {
        return new Msghdr(param1, param3);
    }

    public Msghdr(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), Msghdr.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public ByteBuffer msg_name() {
        return Msghdr.nmsg_name(this.address());
    }

    @NativeType(value="socklen_t")
    public int msg_namelen() {
        return Msghdr.nmsg_namelen(this.address());
    }

    @NativeType(value="struct iovec *")
    public IOVec.Buffer msg_iov() {
        return Msghdr.nmsg_iov(this.address());
    }

    @NativeType(value="size_t")
    public long msg_iovlen() {
        return Msghdr.nmsg_iovlen(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer msg_control() {
        return Msghdr.nmsg_control(this.address());
    }

    @NativeType(value="size_t")
    public long msg_controllen() {
        return Msghdr.nmsg_controllen(this.address());
    }

    public int msg_flags() {
        return Msghdr.nmsg_flags(this.address());
    }

    public Msghdr msg_name(@NativeType(value="void *") ByteBuffer param1) {
        Msghdr.nmsg_name(this.address(), param1);
        return this;
    }

    public Msghdr msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer param1) {
        Msghdr.nmsg_iov(this.address(), param1);
        return this;
    }

    public Msghdr msg_control(@NativeType(value="void *") ByteBuffer param1) {
        Msghdr.nmsg_control(this.address(), param1);
        return this;
    }

    public Msghdr msg_flags(int param1) {
        Msghdr.nmsg_flags(this.address(), param1);
        return this;
    }

    public Msghdr set(ByteBuffer param1, IOVec.Buffer param2, ByteBuffer param3, int param4) {
        this.msg_name(param1);
        this.msg_iov(param2);
        this.msg_control(param3);
        this.msg_flags(param4);
        return this;
    }

    public Msghdr set(Msghdr param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static Msghdr malloc() {
        return new Msghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Msghdr calloc() {
        return new Msghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Msghdr create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new Msghdr(MemoryUtil.memAddress(v0), v0);
    }

    public static Msghdr create(long param0) {
        return new Msghdr(param0, null);
    }

    @Nullable
    public static Msghdr createSafe(long param0) {
        return param0 == 0L ? null : new Msghdr(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Msghdr.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = Msghdr.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static Msghdr malloc(MemoryStack param0) {
        return new Msghdr(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Msghdr calloc(MemoryStack param0) {
        return new Msghdr(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static ByteBuffer nmsg_name(long param0) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(param0 + (long)MSG_NAME), Msghdr.nmsg_namelen(param0));
    }

    public static int nmsg_namelen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MSG_NAMELEN);
    }

    public static IOVec.Buffer nmsg_iov(long param0) {
        return IOVec.create(MemoryUtil.memGetAddress(param0 + (long)MSG_IOV), (int)Msghdr.nmsg_iovlen(param0));
    }

    public static long nmsg_iovlen(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)MSG_IOVLEN);
    }

    public static ByteBuffer nmsg_control(long param0) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(param0 + (long)MSG_CONTROL), (int)Msghdr.nmsg_controllen(param0));
    }

    public static long nmsg_controllen(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)MSG_CONTROLLEN);
    }

    public static int nmsg_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MSG_FLAGS);
    }

    public static void nmsg_name(long param0, ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)MSG_NAME, MemoryUtil.memAddress(param2));
        Msghdr.nmsg_namelen(param0, param2.remaining());
    }

    public static void nmsg_namelen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MSG_NAMELEN, param2);
    }

    public static void nmsg_iov(long param0, IOVec.Buffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)MSG_IOV, param2.address());
        Msghdr.nmsg_iovlen(param0, param2.remaining());
    }

    public static void nmsg_iovlen(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)MSG_IOVLEN, param2);
    }

    public static void nmsg_control(long param0, ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)MSG_CONTROL, MemoryUtil.memAddress(param2));
        Msghdr.nmsg_controllen(param0, param2.remaining());
    }

    public static void nmsg_controllen(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)MSG_CONTROLLEN, param2);
    }

    public static void nmsg_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MSG_FLAGS, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)MSG_NAME));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)MSG_IOV));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)MSG_CONTROL));
    }

    static {
        Struct.Layout v0 = Msghdr.__struct(Msghdr.__member(POINTER_SIZE), Msghdr.__member(4), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        MSG_NAME = v0.offsetof(0);
        MSG_NAMELEN = v0.offsetof(1);
        MSG_IOV = v0.offsetof(2);
        MSG_IOVLEN = v0.offsetof(3);
        MSG_CONTROL = v0.offsetof(4);
        MSG_CONTROLLEN = v0.offsetof(5);
        MSG_FLAGS = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<Msghdr, Buffer>
    implements NativeResource {
        private static final Msghdr ELEMENT_FACTORY = Msghdr.create(-1L);

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
        protected Msghdr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public ByteBuffer msg_name() {
            return Msghdr.nmsg_name(this.address());
        }

        @NativeType(value="socklen_t")
        public int msg_namelen() {
            return Msghdr.nmsg_namelen(this.address());
        }

        @NativeType(value="struct iovec *")
        public IOVec.Buffer msg_iov() {
            return Msghdr.nmsg_iov(this.address());
        }

        @NativeType(value="size_t")
        public long msg_iovlen() {
            return Msghdr.nmsg_iovlen(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer msg_control() {
            return Msghdr.nmsg_control(this.address());
        }

        @NativeType(value="size_t")
        public long msg_controllen() {
            return Msghdr.nmsg_controllen(this.address());
        }

        public int msg_flags() {
            return Msghdr.nmsg_flags(this.address());
        }

        public Buffer msg_name(@NativeType(value="void *") ByteBuffer param1) {
            Msghdr.nmsg_name(this.address(), param1);
            return this;
        }

        public Buffer msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer param1) {
            Msghdr.nmsg_iov(this.address(), param1);
            return this;
        }

        public Buffer msg_control(@NativeType(value="void *") ByteBuffer param1) {
            Msghdr.nmsg_control(this.address(), param1);
            return this;
        }

        public Buffer msg_flags(int param1) {
            Msghdr.nmsg_flags(this.address(), param1);
            return this;
        }
    }
}

