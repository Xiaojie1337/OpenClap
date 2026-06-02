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

@NativeType(value="struct cmsghdr")
public class CMsghdr
extends Struct<CMsghdr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CMSG_LEN;
    public static final int CMSG_LEVEL;
    public static final int CMSG_TYPE;
    public static final int CMSG_DATA;

    protected CMsghdr(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected CMsghdr create(long param1, @Nullable ByteBuffer param3) {
        return new CMsghdr(param1, param3);
    }

    public CMsghdr(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), CMsghdr.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="socklen_t")
    public int cmsg_len() {
        return CMsghdr.ncmsg_len(this.address());
    }

    public int cmsg_level() {
        return CMsghdr.ncmsg_level(this.address());
    }

    public int cmsg_type() {
        return CMsghdr.ncmsg_type(this.address());
    }

    @NativeType(value="char[0]")
    public ByteBuffer cmsg_data() {
        return CMsghdr.ncmsg_data(this.address());
    }

    @NativeType(value="char")
    public byte cmsg_data(int param1) {
        return CMsghdr.ncmsg_data(this.address(), param1);
    }

    public CMsghdr cmsg_len(@NativeType(value="socklen_t") int param1) {
        CMsghdr.ncmsg_len(this.address(), param1);
        return this;
    }

    public CMsghdr cmsg_level(int param1) {
        CMsghdr.ncmsg_level(this.address(), param1);
        return this;
    }

    public CMsghdr cmsg_type(int param1) {
        CMsghdr.ncmsg_type(this.address(), param1);
        return this;
    }

    public CMsghdr cmsg_data(@NativeType(value="char[0]") ByteBuffer param1) {
        CMsghdr.ncmsg_data(this.address(), param1);
        return this;
    }

    public CMsghdr cmsg_data(int param1, @NativeType(value="char") byte param2) {
        CMsghdr.ncmsg_data(this.address(), param1, param2);
        return this;
    }

    public CMsghdr set(int param1, int param2, int param3, ByteBuffer param4) {
        this.cmsg_len(param1);
        this.cmsg_level(param2);
        this.cmsg_type(param3);
        this.cmsg_data(param4);
        return this;
    }

    public CMsghdr set(CMsghdr param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static CMsghdr malloc() {
        return new CMsghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CMsghdr calloc() {
        return new CMsghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CMsghdr create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new CMsghdr(MemoryUtil.memAddress(v0), v0);
    }

    public static CMsghdr create(long param0) {
        return new CMsghdr(param0, null);
    }

    @Nullable
    public static CMsghdr createSafe(long param0) {
        return param0 == 0L ? null : new CMsghdr(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CMsghdr.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = CMsghdr.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static CMsghdr malloc(MemoryStack param0) {
        return new CMsghdr(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CMsghdr calloc(MemoryStack param0) {
        return new CMsghdr(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ncmsg_len(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CMSG_LEN);
    }

    public static int ncmsg_level(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CMSG_LEVEL);
    }

    public static int ncmsg_type(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CMSG_TYPE);
    }

    public static ByteBuffer ncmsg_data(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)CMSG_DATA, 0);
    }

    public static byte ncmsg_data(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)CMSG_DATA + Checks.check(param2, 0) * 1L);
    }

    public static void ncmsg_len(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CMSG_LEN, param2);
    }

    public static void ncmsg_level(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CMSG_LEVEL, param2);
    }

    public static void ncmsg_type(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CMSG_TYPE, param2);
    }

    public static void ncmsg_data(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)CMSG_DATA, param2.remaining() * 1);
    }

    public static void ncmsg_data(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)CMSG_DATA + Checks.check(param2, 0) * 1L, param3);
    }

    static {
        Struct.Layout v0 = CMsghdr.__struct(CMsghdr.__member(4), CMsghdr.__member(4), CMsghdr.__member(4), CMsghdr.__array(1, 0));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CMSG_LEN = v0.offsetof(0);
        CMSG_LEVEL = v0.offsetof(1);
        CMSG_TYPE = v0.offsetof(2);
        CMSG_DATA = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<CMsghdr, Buffer>
    implements NativeResource {
        private static final CMsghdr ELEMENT_FACTORY = CMsghdr.create(-1L);

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
        protected CMsghdr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="socklen_t")
        public int cmsg_len() {
            return CMsghdr.ncmsg_len(this.address());
        }

        public int cmsg_level() {
            return CMsghdr.ncmsg_level(this.address());
        }

        public int cmsg_type() {
            return CMsghdr.ncmsg_type(this.address());
        }

        @NativeType(value="char[0]")
        public ByteBuffer cmsg_data() {
            return CMsghdr.ncmsg_data(this.address());
        }

        @NativeType(value="char")
        public byte cmsg_data(int param1) {
            return CMsghdr.ncmsg_data(this.address(), param1);
        }

        public Buffer cmsg_len(@NativeType(value="socklen_t") int param1) {
            CMsghdr.ncmsg_len(this.address(), param1);
            return this;
        }

        public Buffer cmsg_level(int param1) {
            CMsghdr.ncmsg_level(this.address(), param1);
            return this;
        }

        public Buffer cmsg_type(int param1) {
            CMsghdr.ncmsg_type(this.address(), param1);
            return this;
        }

        public Buffer cmsg_data(@NativeType(value="char[0]") ByteBuffer param1) {
            CMsghdr.ncmsg_data(this.address(), param1);
            return this;
        }

        public Buffer cmsg_data(int param1, @NativeType(value="char") byte param2) {
            CMsghdr.ncmsg_data(this.address(), param1, param2);
            return this;
        }
    }
}

