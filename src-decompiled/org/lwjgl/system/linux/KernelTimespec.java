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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct __kernel_timespec")
public class KernelTimespec
extends Struct<KernelTimespec>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;

    protected KernelTimespec(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected KernelTimespec create(long param1, @Nullable ByteBuffer param3) {
        return new KernelTimespec(param1, param3);
    }

    public KernelTimespec(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), KernelTimespec.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int64_t")
    public long tv_sec() {
        return KernelTimespec.ntv_sec(this.address());
    }

    @NativeType(value="long long")
    public long tv_nsec() {
        return KernelTimespec.ntv_nsec(this.address());
    }

    public KernelTimespec tv_sec(@NativeType(value="int64_t") long param1) {
        KernelTimespec.ntv_sec(this.address(), param1);
        return this;
    }

    public KernelTimespec tv_nsec(@NativeType(value="long long") long param1) {
        KernelTimespec.ntv_nsec(this.address(), param1);
        return this;
    }

    public KernelTimespec set(long param1, long param3) {
        this.tv_sec(param1);
        this.tv_nsec(param3);
        return this;
    }

    public KernelTimespec set(KernelTimespec param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static KernelTimespec malloc() {
        return new KernelTimespec(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static KernelTimespec calloc() {
        return new KernelTimespec(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static KernelTimespec create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new KernelTimespec(MemoryUtil.memAddress(v0), v0);
    }

    public static KernelTimespec create(long param0) {
        return new KernelTimespec(param0, null);
    }

    @Nullable
    public static KernelTimespec createSafe(long param0) {
        return param0 == 0L ? null : new KernelTimespec(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(KernelTimespec.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = KernelTimespec.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static KernelTimespec malloc(MemoryStack param0) {
        return new KernelTimespec(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static KernelTimespec calloc(MemoryStack param0) {
        return new KernelTimespec(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long ntv_sec(long param0) {
        return UNSAFE.getLong(null, param0 + (long)TV_SEC);
    }

    public static long ntv_nsec(long param0) {
        return UNSAFE.getLong(null, param0 + (long)TV_NSEC);
    }

    public static void ntv_sec(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TV_SEC, param2);
    }

    public static void ntv_nsec(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TV_NSEC, param2);
    }

    static {
        Struct.Layout v0 = KernelTimespec.__struct(KernelTimespec.__member(8), KernelTimespec.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TV_SEC = v0.offsetof(0);
        TV_NSEC = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<KernelTimespec, Buffer>
    implements NativeResource {
        private static final KernelTimespec ELEMENT_FACTORY = KernelTimespec.create(-1L);

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
        protected KernelTimespec getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int64_t")
        public long tv_sec() {
            return KernelTimespec.ntv_sec(this.address());
        }

        @NativeType(value="long long")
        public long tv_nsec() {
            return KernelTimespec.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="int64_t") long param1) {
            KernelTimespec.ntv_sec(this.address(), param1);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="long long") long param1) {
            KernelTimespec.ntv_nsec(this.address(), param1);
            return this;
        }
    }
}

