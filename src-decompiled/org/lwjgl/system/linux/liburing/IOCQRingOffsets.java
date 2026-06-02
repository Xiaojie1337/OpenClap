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

@NativeType(value="struct io_cqring_offsets")
public class IOCQRingOffsets
extends Struct<IOCQRingOffsets>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int OVERFLOW;
    public static final int CQES;
    public static final int FLAGS;
    public static final int RESV1;
    public static final int RESV2;

    protected IOCQRingOffsets(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOCQRingOffsets create(long param1, @Nullable ByteBuffer param3) {
        return new IOCQRingOffsets(param1, param3);
    }

    public IOCQRingOffsets(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOCQRingOffsets.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOCQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOCQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOCQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOCQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int overflow() {
        return IOCQRingOffsets.noverflow(this.address());
    }

    @NativeType(value="__u32")
    public int cqes() {
        return IOCQRingOffsets.ncqes(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOCQRingOffsets.nflags(this.address());
    }

    public IOCQRingOffsets head(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.nhead(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets tail(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.ntail(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets ring_mask(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.nring_mask(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets ring_entries(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.nring_entries(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets overflow(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.noverflow(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets cqes(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.ncqes(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets flags(@NativeType(value="__u32") int param1) {
        IOCQRingOffsets.nflags(this.address(), param1);
        return this;
    }

    public IOCQRingOffsets set(int param1, int param2, int param3, int param4, int param5, int param6, int param7) {
        this.head(param1);
        this.tail(param2);
        this.ring_mask(param3);
        this.ring_entries(param4);
        this.overflow(param5);
        this.cqes(param6);
        this.flags(param7);
        return this;
    }

    public IOCQRingOffsets set(IOCQRingOffsets param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOCQRingOffsets malloc() {
        return new IOCQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOCQRingOffsets calloc() {
        return new IOCQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOCQRingOffsets create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOCQRingOffsets(MemoryUtil.memAddress(v0), v0);
    }

    public static IOCQRingOffsets create(long param0) {
        return new IOCQRingOffsets(param0, null);
    }

    @Nullable
    public static IOCQRingOffsets createSafe(long param0) {
        return param0 == 0L ? null : new IOCQRingOffsets(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOCQRingOffsets.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOCQRingOffsets.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOCQRingOffsets malloc(MemoryStack param0) {
        return new IOCQRingOffsets(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOCQRingOffsets calloc(MemoryStack param0) {
        return new IOCQRingOffsets(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nhead(long param0) {
        return UNSAFE.getInt(null, param0 + (long)HEAD);
    }

    public static int ntail(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TAIL);
    }

    public static int nring_mask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_MASK);
    }

    public static int nring_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_ENTRIES);
    }

    public static int noverflow(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OVERFLOW);
    }

    public static int ncqes(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CQES);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static int nresv1(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RESV1);
    }

    public static long nresv2(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RESV2);
    }

    public static void nhead(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)HEAD, param2);
    }

    public static void ntail(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TAIL, param2);
    }

    public static void nring_mask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_MASK, param2);
    }

    public static void nring_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_ENTRIES, param2);
    }

    public static void noverflow(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OVERFLOW, param2);
    }

    public static void ncqes(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CQES, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nresv1(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV1, param2);
    }

    public static void nresv2(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESV2, param2);
    }

    static {
        Struct.Layout v0 = IOCQRingOffsets.__struct(IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(4), IOCQRingOffsets.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        HEAD = v0.offsetof(0);
        TAIL = v0.offsetof(1);
        RING_MASK = v0.offsetof(2);
        RING_ENTRIES = v0.offsetof(3);
        OVERFLOW = v0.offsetof(4);
        CQES = v0.offsetof(5);
        FLAGS = v0.offsetof(6);
        RESV1 = v0.offsetof(7);
        RESV2 = v0.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOCQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOCQRingOffsets ELEMENT_FACTORY = IOCQRingOffsets.create(-1L);

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
        protected IOCQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOCQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOCQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOCQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOCQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int overflow() {
            return IOCQRingOffsets.noverflow(this.address());
        }

        @NativeType(value="__u32")
        public int cqes() {
            return IOCQRingOffsets.ncqes(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOCQRingOffsets.nflags(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.nhead(this.address(), param1);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.ntail(this.address(), param1);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.nring_mask(this.address(), param1);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.nring_entries(this.address(), param1);
            return this;
        }

        public Buffer overflow(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.noverflow(this.address(), param1);
            return this;
        }

        public Buffer cqes(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.ncqes(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOCQRingOffsets.nflags(this.address(), param1);
            return this;
        }
    }
}

