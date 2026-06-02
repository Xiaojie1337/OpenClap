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

@NativeType(value="union epoll_data_t")
public class EpollData
extends Struct<EpollData>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int PTR;
    public static final int FD;
    public static final int U32;
    public static final int U64;

    protected EpollData(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected EpollData create(long param1, @Nullable ByteBuffer param3) {
        return new EpollData(param1, param3);
    }

    public EpollData(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), EpollData.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ptr() {
        return EpollData.nptr(this.address());
    }

    public int fd() {
        return EpollData.nfd(this.address());
    }

    @NativeType(value="uint32_t")
    public int u32() {
        return EpollData.nu32(this.address());
    }

    @NativeType(value="uint64_t")
    public long u64() {
        return EpollData.nu64(this.address());
    }

    public EpollData ptr(@NativeType(value="void *") long param1) {
        EpollData.nptr(this.address(), param1);
        return this;
    }

    public EpollData fd(int param1) {
        EpollData.nfd(this.address(), param1);
        return this;
    }

    public EpollData u32(@NativeType(value="uint32_t") int param1) {
        EpollData.nu32(this.address(), param1);
        return this;
    }

    public EpollData u64(@NativeType(value="uint64_t") long param1) {
        EpollData.nu64(this.address(), param1);
        return this;
    }

    public EpollData set(EpollData param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollData malloc() {
        return new EpollData(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static EpollData calloc() {
        return new EpollData(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static EpollData create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new EpollData(MemoryUtil.memAddress(v0), v0);
    }

    public static EpollData create(long param0) {
        return new EpollData(param0, null);
    }

    @Nullable
    public static EpollData createSafe(long param0) {
        return param0 == 0L ? null : new EpollData(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(EpollData.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = EpollData.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static EpollData malloc(MemoryStack param0) {
        return new EpollData(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static EpollData calloc(MemoryStack param0) {
        return new EpollData(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nptr(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)PTR);
    }

    public static int nfd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FD);
    }

    public static int nu32(long param0) {
        return UNSAFE.getInt(null, param0 + (long)U32);
    }

    public static long nu64(long param0) {
        return UNSAFE.getLong(null, param0 + (long)U64);
    }

    public static void nptr(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)PTR, Checks.check(param2));
    }

    public static void nfd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FD, param2);
    }

    public static void nu32(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)U32, param2);
    }

    public static void nu64(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)U64, param2);
    }

    static {
        Struct.Layout v0 = EpollData.__union(EpollData.__member(POINTER_SIZE), EpollData.__member(4), EpollData.__member(4), EpollData.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        PTR = v0.offsetof(0);
        FD = v0.offsetof(1);
        U32 = v0.offsetof(2);
        U64 = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<EpollData, Buffer>
    implements NativeResource {
        private static final EpollData ELEMENT_FACTORY = EpollData.create(-1L);

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
        protected EpollData getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ptr() {
            return EpollData.nptr(this.address());
        }

        public int fd() {
            return EpollData.nfd(this.address());
        }

        @NativeType(value="uint32_t")
        public int u32() {
            return EpollData.nu32(this.address());
        }

        @NativeType(value="uint64_t")
        public long u64() {
            return EpollData.nu64(this.address());
        }

        public Buffer ptr(@NativeType(value="void *") long param1) {
            EpollData.nptr(this.address(), param1);
            return this;
        }

        public Buffer fd(int param1) {
            EpollData.nfd(this.address(), param1);
            return this;
        }

        public Buffer u32(@NativeType(value="uint32_t") int param1) {
            EpollData.nu32(this.address(), param1);
            return this;
        }

        public Buffer u64(@NativeType(value="uint64_t") long param1) {
            EpollData.nu64(this.address(), param1);
            return this;
        }
    }
}

