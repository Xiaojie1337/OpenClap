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

@NativeType(value="struct io_uring_getevents_arg")
public class IOURingGeteventsArg
extends Struct<IOURingGeteventsArg>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIGMASK;
    public static final int SIGMASK_SZ;
    public static final int PAD;
    public static final int TS;

    protected IOURingGeteventsArg(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingGeteventsArg create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingGeteventsArg(param1, param3);
    }

    public IOURingGeteventsArg(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingGeteventsArg.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long sigmask() {
        return IOURingGeteventsArg.nsigmask(this.address());
    }

    @NativeType(value="__u32")
    public int sigmask_sz() {
        return IOURingGeteventsArg.nsigmask_sz(this.address());
    }

    @NativeType(value="__u32")
    public int pad() {
        return IOURingGeteventsArg.npad(this.address());
    }

    @NativeType(value="__u64")
    public long ts() {
        return IOURingGeteventsArg.nts(this.address());
    }

    public IOURingGeteventsArg sigmask(@NativeType(value="__u64") long param1) {
        IOURingGeteventsArg.nsigmask(this.address(), param1);
        return this;
    }

    public IOURingGeteventsArg sigmask_sz(@NativeType(value="__u32") int param1) {
        IOURingGeteventsArg.nsigmask_sz(this.address(), param1);
        return this;
    }

    public IOURingGeteventsArg pad(@NativeType(value="__u32") int param1) {
        IOURingGeteventsArg.npad(this.address(), param1);
        return this;
    }

    public IOURingGeteventsArg ts(@NativeType(value="__u64") long param1) {
        IOURingGeteventsArg.nts(this.address(), param1);
        return this;
    }

    public IOURingGeteventsArg set(long param1, int param3, int param4, long param5) {
        this.sigmask(param1);
        this.sigmask_sz(param3);
        this.pad(param4);
        this.ts(param5);
        return this;
    }

    public IOURingGeteventsArg set(IOURingGeteventsArg param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingGeteventsArg malloc() {
        return new IOURingGeteventsArg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingGeteventsArg calloc() {
        return new IOURingGeteventsArg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingGeteventsArg create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingGeteventsArg(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingGeteventsArg create(long param0) {
        return new IOURingGeteventsArg(param0, null);
    }

    @Nullable
    public static IOURingGeteventsArg createSafe(long param0) {
        return param0 == 0L ? null : new IOURingGeteventsArg(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingGeteventsArg.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingGeteventsArg.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingGeteventsArg malloc(MemoryStack param0) {
        return new IOURingGeteventsArg(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingGeteventsArg calloc(MemoryStack param0) {
        return new IOURingGeteventsArg(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nsigmask(long param0) {
        return UNSAFE.getLong(null, param0 + (long)SIGMASK);
    }

    public static int nsigmask_sz(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SIGMASK_SZ);
    }

    public static int npad(long param0) {
        return UNSAFE.getInt(null, param0 + (long)PAD);
    }

    public static long nts(long param0) {
        return UNSAFE.getLong(null, param0 + (long)TS);
    }

    public static void nsigmask(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)SIGMASK, param2);
    }

    public static void nsigmask_sz(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SIGMASK_SZ, param2);
    }

    public static void npad(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)PAD, param2);
    }

    public static void nts(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TS, param2);
    }

    static {
        Struct.Layout v0 = IOURingGeteventsArg.__struct(IOURingGeteventsArg.__member(8), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(4), IOURingGeteventsArg.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        SIGMASK = v0.offsetof(0);
        SIGMASK_SZ = v0.offsetof(1);
        PAD = v0.offsetof(2);
        TS = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<IOURingGeteventsArg, Buffer>
    implements NativeResource {
        private static final IOURingGeteventsArg ELEMENT_FACTORY = IOURingGeteventsArg.create(-1L);

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
        protected IOURingGeteventsArg getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long sigmask() {
            return IOURingGeteventsArg.nsigmask(this.address());
        }

        @NativeType(value="__u32")
        public int sigmask_sz() {
            return IOURingGeteventsArg.nsigmask_sz(this.address());
        }

        @NativeType(value="__u32")
        public int pad() {
            return IOURingGeteventsArg.npad(this.address());
        }

        @NativeType(value="__u64")
        public long ts() {
            return IOURingGeteventsArg.nts(this.address());
        }

        public Buffer sigmask(@NativeType(value="__u64") long param1) {
            IOURingGeteventsArg.nsigmask(this.address(), param1);
            return this;
        }

        public Buffer sigmask_sz(@NativeType(value="__u32") int param1) {
            IOURingGeteventsArg.nsigmask_sz(this.address(), param1);
            return this;
        }

        public Buffer pad(@NativeType(value="__u32") int param1) {
            IOURingGeteventsArg.npad(this.address(), param1);
            return this;
        }

        public Buffer ts(@NativeType(value="__u64") long param1) {
            IOURingGeteventsArg.nts(this.address(), param1);
            return this;
        }
    }
}

