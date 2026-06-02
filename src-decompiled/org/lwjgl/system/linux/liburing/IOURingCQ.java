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
import org.lwjgl.system.linux.liburing.IOURingCQE;

@NativeType(value="struct io_uring_cq")
public class IOURingCQ
extends Struct<IOURingCQ>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KOVERFLOW;
    public static final int CQES;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int PAD;

    protected IOURingCQ(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingCQ create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingCQ(param1, param3);
    }

    public IOURingCQ(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingCQ.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int param1) {
        return IOURingCQ.nkhead(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int param1) {
        return IOURingCQ.nktail(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int param1) {
        return IOURingCQ.nkring_mask(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int param1) {
        return IOURingCQ.nkring_entries(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int param1) {
        return IOURingCQ.nkflags(this.address(), param1);
    }

    @NativeType(value="unsigned *")
    public IntBuffer koverflow(int param1) {
        return IOURingCQ.nkoverflow(this.address(), param1);
    }

    @NativeType(value="struct io_uring_cqe *")
    public IOURingCQE cqes() {
        return IOURingCQ.ncqes(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingCQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingCQ.nring_ptr(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_mask() {
        return IOURingCQ.nring_mask(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_entries() {
        return IOURingCQ.nring_entries(this.address());
    }

    public IOURingCQ khead(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nkhead(this.address(), param1);
        return this;
    }

    public IOURingCQ ktail(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nktail(this.address(), param1);
        return this;
    }

    public IOURingCQ kring_mask(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nkring_mask(this.address(), param1);
        return this;
    }

    public IOURingCQ kring_entries(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nkring_entries(this.address(), param1);
        return this;
    }

    public IOURingCQ kflags(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nkflags(this.address(), param1);
        return this;
    }

    public IOURingCQ koverflow(@NativeType(value="unsigned *") IntBuffer param1) {
        IOURingCQ.nkoverflow(this.address(), param1);
        return this;
    }

    public IOURingCQ cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE param1) {
        IOURingCQ.ncqes(this.address(), param1);
        return this;
    }

    public IOURingCQ ring_ptr(@NativeType(value="void *") ByteBuffer param1) {
        IOURingCQ.nring_ptr(this.address(), param1);
        return this;
    }

    public IOURingCQ ring_mask(@NativeType(value="unsigned") int param1) {
        IOURingCQ.nring_mask(this.address(), param1);
        return this;
    }

    public IOURingCQ ring_entries(@NativeType(value="unsigned") int param1) {
        IOURingCQ.nring_entries(this.address(), param1);
        return this;
    }

    public IOURingCQ set(IntBuffer param1, IntBuffer param2, IntBuffer param3, IntBuffer param4, IntBuffer param5, IntBuffer param6, IOURingCQE param7, ByteBuffer param8, int param9, int param10) {
        this.khead(param1);
        this.ktail(param2);
        this.kring_mask(param3);
        this.kring_entries(param4);
        this.kflags(param5);
        this.koverflow(param6);
        this.cqes(param7);
        this.ring_ptr(param8);
        this.ring_mask(param9);
        this.ring_entries(param10);
        return this;
    }

    public IOURingCQ set(IOURingCQ param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQ malloc() {
        return new IOURingCQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingCQ calloc() {
        return new IOURingCQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingCQ create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingCQ(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingCQ create(long param0) {
        return new IOURingCQ(param0, null);
    }

    @Nullable
    public static IOURingCQ createSafe(long param0) {
        return param0 == 0L ? null : new IOURingCQ(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingCQ.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingCQ.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingCQ malloc(MemoryStack param0) {
        return new IOURingCQ(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingCQ calloc(MemoryStack param0) {
        return new IOURingCQ(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static IntBuffer nkoverflow(long param0, int param2) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(param0 + (long)KOVERFLOW), param2);
    }

    public static IOURingCQE ncqes(long param0) {
        return IOURingCQE.create(MemoryUtil.memGetAddress(param0 + (long)CQES));
    }

    public static long nring_sz(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long param0) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(param0 + (long)RING_PTR), (int)IOURingCQ.nring_sz(param0));
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

    public static void nkoverflow(long param0, IntBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)KOVERFLOW, MemoryUtil.memAddress(param2));
    }

    public static void ncqes(long param0, IOURingCQE param2) {
        MemoryUtil.memPutAddress(param0 + (long)CQES, param2.address());
    }

    public static void nring_sz(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)RING_SZ, param2);
    }

    public static void nring_ptr(long param0, ByteBuffer param2) {
        MemoryUtil.memPutAddress(param0 + (long)RING_PTR, MemoryUtil.memAddress(param2));
        IOURingCQ.nring_sz(param0, param2.remaining());
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
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)KOVERFLOW));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)CQES));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)RING_PTR));
    }

    static {
        Struct.Layout v0 = IOURingCQ.__struct(IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(4), IOURingCQ.__member(4), IOURingCQ.__array(4, 2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        KHEAD = v0.offsetof(0);
        KTAIL = v0.offsetof(1);
        KRING_MASK = v0.offsetof(2);
        KRING_ENTRIES = v0.offsetof(3);
        KFLAGS = v0.offsetof(4);
        KOVERFLOW = v0.offsetof(5);
        CQES = v0.offsetof(6);
        RING_SZ = v0.offsetof(7);
        RING_PTR = v0.offsetof(8);
        RING_MASK = v0.offsetof(9);
        RING_ENTRIES = v0.offsetof(10);
        PAD = v0.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQ, Buffer>
    implements NativeResource {
        private static final IOURingCQ ELEMENT_FACTORY = IOURingCQ.create(-1L);

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
        protected IOURingCQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int param1) {
            return IOURingCQ.nkhead(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int param1) {
            return IOURingCQ.nktail(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int param1) {
            return IOURingCQ.nkring_mask(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int param1) {
            return IOURingCQ.nkring_entries(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int param1) {
            return IOURingCQ.nkflags(this.address(), param1);
        }

        @NativeType(value="unsigned *")
        public IntBuffer koverflow(int param1) {
            return IOURingCQ.nkoverflow(this.address(), param1);
        }

        @NativeType(value="struct io_uring_cqe *")
        public IOURingCQE cqes() {
            return IOURingCQ.ncqes(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingCQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingCQ.nring_ptr(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_mask() {
            return IOURingCQ.nring_mask(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_entries() {
            return IOURingCQ.nring_entries(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nkhead(this.address(), param1);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nktail(this.address(), param1);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nkring_mask(this.address(), param1);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nkring_entries(this.address(), param1);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nkflags(this.address(), param1);
            return this;
        }

        public Buffer koverflow(@NativeType(value="unsigned *") IntBuffer param1) {
            IOURingCQ.nkoverflow(this.address(), param1);
            return this;
        }

        public Buffer cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE param1) {
            IOURingCQ.ncqes(this.address(), param1);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer param1) {
            IOURingCQ.nring_ptr(this.address(), param1);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="unsigned") int param1) {
            IOURingCQ.nring_mask(this.address(), param1);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="unsigned") int param1) {
            IOURingCQ.nring_entries(this.address(), param1);
            return this;
        }
    }
}

