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
import org.lwjgl.system.linux.liburing.IOURingSQE;

@NativeType(value="struct io_uring_sq")
public class IOURingSQ
extends Struct<IOURingSQ>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KDROPPED;
    public static final int ARRAY;
    public static final int SQES;
    public static final int SQE_HEAD;
    public static final int SQE_TAIL;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int PAD;

    protected IOURingSQ(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingSQ create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingSQ(param1, param3);
    }

    public IOURingSQ(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingSQ.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int param1) {
        return IOURingSQ.nkhead(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int param1) {
        return IOURingSQ.nktail(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int param1) {
        return IOURingSQ.nkring_mask(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int param1) {
        return IOURingSQ.nkring_entries(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int param1) {
        return IOURingSQ.nkflags(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kdropped(int param1) {
        return IOURingSQ.nkdropped(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer array(int param1) {
        return IOURingSQ.narray(this.address(), param1);
    }

    @NativeType(value="struct io_uring_sqe *")
    public IOURingSQE sqes() {
        return IOURingSQ.nsqes(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_head() {
        return IOURingSQ.nsqe_head(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_tail() {
        return IOURingSQ.nsqe_tail(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingSQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingSQ.nring_ptr(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_mask() {
        return IOURingSQ.nring_mask(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_entries() {
        return IOURingSQ.nring_entries(this.address());
    }

    public IOURingSQ khead(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nkhead(this.address(), param1);
        return this;
    }

    public IOURingSQ ktail(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nktail(this.address(), param1);
        return this;
    }

    public IOURingSQ kring_mask(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nkring_mask(this.address(), param1);
        return this;
    }

    public IOURingSQ kring_entries(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nkring_entries(this.address(), param1);
        return this;
    }

    public IOURingSQ kflags(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nkflags(this.address(), param1);
        return this;
    }

    public IOURingSQ kdropped(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.nkdropped(this.address(), param1);
        return this;
    }

    public IOURingSQ array(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingSQ.narray(this.address(), param1);
        return this;
    }

    public IOURingSQ sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE param1) {
        IOURingSQ.nsqes(this.address(), param1);
        return this;
    }

    public IOURingSQ sqe_head(@NativeType(value="unsigned") int param1) {
        IOURingSQ.nsqe_head(this.address(), param1);
        return this;
    }

    public IOURingSQ sqe_tail(@NativeType(value="unsigned") int param1) {
        IOURingSQ.nsqe_tail(this.address(), param1);
        return this;
    }

    public IOURingSQ ring_ptr(@NativeType(value="void *") ByteBuffer param1) {
        IOURingSQ.nring_ptr(this.address(), param1);
        return this;
    }

    public IOURingSQ ring_mask(@NativeType(value="unsigned") int param1) {
        IOURingSQ.nring_mask(this.address(), param1);
        return this;
    }

    public IOURingSQ ring_entries(@NativeType(value="unsigned") int param1) {
        IOURingSQ.nring_entries(this.address(), param1);
        return this;
    }

    public IOURingSQ set(IntBuffer param1, IntBuffer param2, IntBuffer param3, IntBuffer param4, IntBuffer param5, IntBuffer param6, IntBuffer param7, IOURingSQE param8, int param9, int param10, ByteBuffer param11, int param12, int param13) {
        this.khead(param1);
        this.ktail(param2);
        this.kring_mask(param3);
        this.kring_entries(param4);
        this.kflags(param5);
        this.kdropped(param6);
        this.array(param7);
        this.sqes(param8);
        this.sqe_head(param9);
        this.sqe_tail(param10);
        this.ring_ptr(param11);
        this.ring_mask(param12);
        this.ring_entries(param13);
        return this;
    }

    public IOURingSQ set(IOURingSQ param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQ malloc() {
        return new IOURingSQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSQ calloc() {
        return new IOURingSQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSQ create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSQ(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingSQ create(long param0) {
        return new IOURingSQ(param0, null);
    }

    @Nullable
    public static IOURingSQ createSafe(long param0) {
        return param0 == 0L ? null : new IOURingSQ(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSQ.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingSQ.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingSQ malloc(MemoryStack param0) {
        return new IOURingSQ(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSQ calloc(MemoryStack param0) {
        return new IOURingSQ(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static IntBuffer nkhead(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KHEAD), param2);
    }

    public static IntBuffer nktail(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KTAIL), param2);
    }

    public static IntBuffer nkring_mask(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KRING_MASK), param2);
    }

    public static IntBuffer nkring_entries(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KRING_ENTRIES), param2);
    }

    public static IntBuffer nkflags(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KFLAGS), param2);
    }

    public static IntBuffer nkdropped(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KDROPPED), param2);
    }

    public static IntBuffer narray(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)ARRAY), param2);
    }

    public static IOURingSQE nsqes(long param0) {
        return IOURingSQE.create(MemoryUtil.memGetAddress(param0 + (long)SQES));
    }

    public static int nsqe_head(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SQE_HEAD);
    }

    public static int nsqe_tail(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SQE_TAIL);
    }

    public static long nring_sz(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long param0) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(param0 + (long)RING_PTR), (int)IOURingSQ.nring_sz(param0));
    }

    public static int nring_mask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_MASK);
    }

    public static int nring_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RING_ENTRIES);
    }

    public static IntBuffer npad(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)PAD, 2);
    }

    public static int npad(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)PAD + Checks.check(param2, 2) * 4L);
    }

    public static void nkhead(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KHEAD, MemoryUtil.memAddress(param2));
    }

    public static void nktail(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KTAIL, MemoryUtil.memAddress(param2));
    }

    public static void nkring_mask(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KRING_MASK, MemoryUtil.memAddress(param2));
    }

    public static void nkring_entries(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KRING_ENTRIES, MemoryUtil.memAddress(param2));
    }

    public static void nkflags(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KFLAGS, MemoryUtil.memAddress(param2));
    }

    public static void nkdropped(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KDROPPED, MemoryUtil.memAddress(param2));
    }

    public static void narray(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)ARRAY, MemoryUtil.memAddress(param2));
    }

    public static void nsqes(long param0, IOURingSQE param2) {
        MemoryUtil.memPutAddress(param0 + (long)SQES, param2.address());
    }

    public static void nsqe_head(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SQE_HEAD, param2);
    }

    public static void nsqe_tail(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SQE_TAIL, param2);
    }

    public static void nring_sz(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)RING_SZ, param2);
    }

    public static void nring_ptr(long param0, ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)RING_PTR, MemoryUtil.memAddress(param2));
        IOURingSQ.nring_sz(param0, param2.remaining());
    }

    public static void nring_mask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_MASK, param2);
    }

    public static void nring_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RING_ENTRIES, param2);
    }

    public static void npad(long param0, IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)PAD, param2.remaining() * 4);
    }

    public static void npad(long param0, int param2, int param3) {
        UNSAFE.putInt(null, param0 + (long)PAD + Checks.check(param2, 2) * 4L, param3);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KHEAD));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KTAIL));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KRING_MASK));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KRING_ENTRIES));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KFLAGS));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KDROPPED));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)ARRAY));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)SQES));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)RING_PTR));
    }

    static {
        Struct.Layout v0 = IOURingSQ.__struct(IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(4), IOURingSQ.__member(4), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(4), IOURingSQ.__member(4), IOURingSQ.__array(4, 2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        KHEAD = v0.offsetof(0);
        KTAIL = v0.offsetof(1);
        KRING_MASK = v0.offsetof(2);
        KRING_ENTRIES = v0.offsetof(3);
        KFLAGS = v0.offsetof(4);
        KDROPPED = v0.offsetof(5);
        ARRAY = v0.offsetof(6);
        SQES = v0.offsetof(7);
        SQE_HEAD = v0.offsetof(8);
        SQE_TAIL = v0.offsetof(9);
        RING_SZ = v0.offsetof(10);
        RING_PTR = v0.offsetof(11);
        RING_MASK = v0.offsetof(12);
        RING_ENTRIES = v0.offsetof(13);
        PAD = v0.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQ, Buffer>
    implements NativeResource {
        private static final IOURingSQ ELEMENT_FACTORY = IOURingSQ.create(-1L);

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
        protected IOURingSQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int param1) {
            return IOURingSQ.nkhead(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int param1) {
            return IOURingSQ.nktail(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int param1) {
            return IOURingSQ.nkring_mask(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int param1) {
            return IOURingSQ.nkring_entries(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int param1) {
            return IOURingSQ.nkflags(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kdropped(int param1) {
            return IOURingSQ.nkdropped(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer array(int param1) {
            return IOURingSQ.narray(this.address(), param1);
        }

        @NativeType(value="struct io_uring_sqe *")
        public IOURingSQE sqes() {
            return IOURingSQ.nsqes(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_head() {
            return IOURingSQ.nsqe_head(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_tail() {
            return IOURingSQ.nsqe_tail(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingSQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingSQ.nring_ptr(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_mask() {
            return IOURingSQ.nring_mask(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_entries() {
            return IOURingSQ.nring_entries(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nkhead(this.address(), param1);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nktail(this.address(), param1);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nkring_mask(this.address(), param1);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nkring_entries(this.address(), param1);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nkflags(this.address(), param1);
            return this;
        }

        public Buffer kdropped(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.nkdropped(this.address(), param1);
            return this;
        }

        public Buffer array(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingSQ.narray(this.address(), param1);
            return this;
        }

        public Buffer sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE param1) {
            IOURingSQ.nsqes(this.address(), param1);
            return this;
        }

        public Buffer sqe_head(@NativeType(value="unsigned") int param1) {
            IOURingSQ.nsqe_head(this.address(), param1);
            return this;
        }

        public Buffer sqe_tail(@NativeType(value="unsigned") int param1) {
            IOURingSQ.nsqe_tail(this.address(), param1);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer param1) {
            IOURingSQ.nring_ptr(this.address(), param1);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="unsigned") int param1) {
            IOURingSQ.nring_mask(this.address(), param1);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="unsigned") int param1) {
            IOURingSQ.nring_entries(this.address(), param1);
            return this;
        }
    }
}

