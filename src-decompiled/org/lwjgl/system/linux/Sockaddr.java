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

@NativeType(value="struct sockaddr")
public class Sockaddr
extends Struct<Sockaddr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SA_FAMILY;
    public static final int SA_DATA;

    protected Sockaddr(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected Sockaddr create(long param1, @Nullable ByteBuffer param3) {
        return new Sockaddr(param1, param3);
    }

    public Sockaddr(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), Sockaddr.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="sa_family_t")
    public short sa_family() {
        return Sockaddr.nsa_family(this.address());
    }

    @NativeType(value="char[14]")
    public ByteBuffer sa_data() {
        return Sockaddr.nsa_data(this.address());
    }

    @NativeType(value="char")
    public byte sa_data(int param1) {
        return Sockaddr.nsa_data(this.address(), param1);
    }

    public Sockaddr sa_family(@NativeType(value="sa_family_t") short param1) {
        Sockaddr.nsa_family(this.address(), param1);
        return this;
    }

    public Sockaddr sa_data(@NativeType(value="char[14]") ByteBuffer param1) {
        Sockaddr.nsa_data(this.address(), param1);
        return this;
    }

    public Sockaddr sa_data(int param1, @NativeType(value="char") byte param2) {
        Sockaddr.nsa_data(this.address(), param1, param2);
        return this;
    }

    public Sockaddr set(short param1, ByteBuffer param2) {
        this.sa_family(param1);
        this.sa_data(param2);
        return this;
    }

    public Sockaddr set(Sockaddr param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static Sockaddr malloc() {
        return new Sockaddr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Sockaddr calloc() {
        return new Sockaddr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Sockaddr create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new Sockaddr(MemoryUtil.memAddress(v0), v0);
    }

    public static Sockaddr create(long param0) {
        return new Sockaddr(param0, null);
    }

    @Nullable
    public static Sockaddr createSafe(long param0) {
        return param0 == 0L ? null : new Sockaddr(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Sockaddr.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = Sockaddr.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static Sockaddr malloc(MemoryStack param0) {
        return new Sockaddr(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Sockaddr calloc(MemoryStack param0) {
        return new Sockaddr(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static short nsa_family(long param0) {
        return UNSAFE.getShort(null, param0 + (long)SA_FAMILY);
    }

    public static ByteBuffer nsa_data(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)SA_DATA, 14);
    }

    public static byte nsa_data(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)SA_DATA + Checks.check(param2, 14) * 1L);
    }

    public static void nsa_family(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)SA_FAMILY, param2);
    }

    public static void nsa_data(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 14);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)SA_DATA, param2.remaining() * 1);
    }

    public static void nsa_data(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)SA_DATA + Checks.check(param2, 14) * 1L, param3);
    }

    static {
        Struct.Layout v0 = Sockaddr.__struct(Sockaddr.__member(2), Sockaddr.__array(1, 14));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        SA_FAMILY = v0.offsetof(0);
        SA_DATA = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<Sockaddr, Buffer>
    implements NativeResource {
        private static final Sockaddr ELEMENT_FACTORY = Sockaddr.create(-1L);

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
        protected Sockaddr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="sa_family_t")
        public short sa_family() {
            return Sockaddr.nsa_family(this.address());
        }

        @NativeType(value="char[14]")
        public ByteBuffer sa_data() {
            return Sockaddr.nsa_data(this.address());
        }

        @NativeType(value="char")
        public byte sa_data(int param1) {
            return Sockaddr.nsa_data(this.address(), param1);
        }

        public Buffer sa_family(@NativeType(value="sa_family_t") short param1) {
            Sockaddr.nsa_family(this.address(), param1);
            return this;
        }

        public Buffer sa_data(@NativeType(value="char[14]") ByteBuffer param1) {
            Sockaddr.nsa_data(this.address(), param1);
            return this;
        }

        public Buffer sa_data(int param1, @NativeType(value="char") byte param2) {
            Sockaddr.nsa_data(this.address(), param1, param2);
            return this;
        }
    }
}

