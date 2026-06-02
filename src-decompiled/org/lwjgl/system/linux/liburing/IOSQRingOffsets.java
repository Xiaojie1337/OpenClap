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

@NativeType(value="struct io_sqring_offsets")
public class IOSQRingOffsets
extends Struct<IOSQRingOffsets>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HEAD;
    public static final int TAIL;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int FLAGS;
    public static final int DROPPED;
    public static final int ARRAY;
    public static final int RESV1;
    public static final int RESV2;

    protected IOSQRingOffsets(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOSQRingOffsets create(long param1, @Nullable ByteBuffer param3) {
        return new IOSQRingOffsets(param1, param3);
    }

    public IOSQRingOffsets(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOSQRingOffsets.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int head() {
        return IOSQRingOffsets.nhead(this.address());
    }

    @NativeType(value="__u32")
    public int tail() {
        return IOSQRingOffsets.ntail(this.address());
    }

    @NativeType(value="__u32")
    public int ring_mask() {
        return IOSQRingOffsets.nring_mask(this.address());
    }

    @NativeType(value="__u32")
    public int ring_entries() {
        return IOSQRingOffsets.nring_entries(this.address());
    }

    @NativeType(value="__u32")
    public int flags() {
        return IOSQRingOffsets.nflags(this.address());
    }

    @NativeType(value="__u32")
    public int dropped() {
        return IOSQRingOffsets.ndropped(this.address());
    }

    @NativeType(value="__u32")
    public int array() {
        return IOSQRingOffsets.narray(this.address());
    }

    public IOSQRingOffsets head(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.nhead(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets tail(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.ntail(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets ring_mask(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.nring_mask(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets ring_entries(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.nring_entries(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets flags(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.nflags(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets dropped(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.ndropped(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets array(@NativeType(value="__u32") int param1) {
        IOSQRingOffsets.narray(this.address(), param1);
        return this;
    }

    public IOSQRingOffsets set(int param1, int param2, int param3, int param4, int param5, int param6, int param7) {
        this.head(param1);
        this.tail(param2);
        this.ring_mask(param3);
        this.ring_entries(param4);
        this.flags(param5);
        this.dropped(param6);
        this.array(param7);
        return this;
    }

    public IOSQRingOffsets set(IOSQRingOffsets param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOSQRingOffsets malloc() {
        return new IOSQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOSQRingOffsets calloc() {
        return new IOSQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOSQRingOffsets create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOSQRingOffsets(MemoryUtil.memAddress(v0), v0);
    }

    public static IOSQRingOffsets create(long param0) {
        return new IOSQRingOffsets(param0, null);
    }

    @Nullable
    public static IOSQRingOffsets createSafe(long param0) {
        return param0 == 0L ? null : new IOSQRingOffsets(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOSQRingOffsets.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOSQRingOffsets.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOSQRingOffsets malloc(MemoryStack param0) {
        return new IOSQRingOffsets(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOSQRingOffsets calloc(MemoryStack param0) {
        return new IOSQRingOffsets(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static int ndropped(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DROPPED);
    }

    public static int narray(long param0) {
        return UNSAFE.getInt(null, param0 + (long)ARRAY);
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

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void ndropped(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DROPPED, param2);
    }

    public static void narray(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)ARRAY, param2);
    }

    public static void nresv1(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RESV1, param2);
    }

    public static void nresv2(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESV2, param2);
    }

    static {
        Struct.Layout v0 = IOSQRingOffsets.__struct(IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(4), IOSQRingOffsets.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        HEAD = v0.offsetof(0);
        TAIL = v0.offsetof(1);
        RING_MASK = v0.offsetof(2);
        RING_ENTRIES = v0.offsetof(3);
        FLAGS = v0.offsetof(4);
        DROPPED = v0.offsetof(5);
        ARRAY = v0.offsetof(6);
        RESV1 = v0.offsetof(7);
        RESV2 = v0.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<IOSQRingOffsets, Buffer>
    implements NativeResource {
        private static final IOSQRingOffsets ELEMENT_FACTORY = IOSQRingOffsets.create(-1L);

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
        protected IOSQRingOffsets getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int head() {
            return IOSQRingOffsets.nhead(this.address());
        }

        @NativeType(value="__u32")
        public int tail() {
            return IOSQRingOffsets.ntail(this.address());
        }

        @NativeType(value="__u32")
        public int ring_mask() {
            return IOSQRingOffsets.nring_mask(this.address());
        }

        @NativeType(value="__u32")
        public int ring_entries() {
            return IOSQRingOffsets.nring_entries(this.address());
        }

        @NativeType(value="__u32")
        public int flags() {
            return IOSQRingOffsets.nflags(this.address());
        }

        @NativeType(value="__u32")
        public int dropped() {
            return IOSQRingOffsets.ndropped(this.address());
        }

        @NativeType(value="__u32")
        public int array() {
            return IOSQRingOffsets.narray(this.address());
        }

        public Buffer head(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.nhead(this.address(), param1);
            return this;
        }

        public Buffer tail(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.ntail(this.address(), param1);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.nring_mask(this.address(), param1);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.nring_entries(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.nflags(this.address(), param1);
            return this;
        }

        public Buffer dropped(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.ndropped(this.address(), param1);
            return this;
        }

        public Buffer array(@NativeType(value="__u32") int param1) {
            IOSQRingOffsets.narray(this.address(), param1);
            return this;
        }
    }
}

