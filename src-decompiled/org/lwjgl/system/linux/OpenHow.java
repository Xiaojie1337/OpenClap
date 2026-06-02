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

@NativeType(value="struct open_how")
public class OpenHow
extends Struct<OpenHow>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FLAGS;
    public static final int MODE;
    public static final int RESOLVE;

    protected OpenHow(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected OpenHow create(long param1, @Nullable ByteBuffer param3) {
        return new OpenHow(param1, param3);
    }

    public OpenHow(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), OpenHow.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u64")
    public long flags() {
        return OpenHow.nflags(this.address());
    }

    @NativeType(value="__u64")
    public long mode() {
        return OpenHow.nmode(this.address());
    }

    @NativeType(value="__u64")
    public long resolve() {
        return OpenHow.nresolve(this.address());
    }

    public OpenHow flags(@NativeType(value="__u64") long param1) {
        OpenHow.nflags(this.address(), param1);
        return this;
    }

    public OpenHow mode(@NativeType(value="__u64") long param1) {
        OpenHow.nmode(this.address(), param1);
        return this;
    }

    public OpenHow resolve(@NativeType(value="__u64") long param1) {
        OpenHow.nresolve(this.address(), param1);
        return this;
    }

    public OpenHow set(long param1, long param3, long param5) {
        this.flags(param1);
        this.mode(param3);
        this.resolve(param5);
        return this;
    }

    public OpenHow set(OpenHow param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static OpenHow malloc() {
        return new OpenHow(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static OpenHow calloc() {
        return new OpenHow(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static OpenHow create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new OpenHow(MemoryUtil.memAddress(v0), v0);
    }

    public static OpenHow create(long param0) {
        return new OpenHow(param0, null);
    }

    @Nullable
    public static OpenHow createSafe(long param0) {
        return param0 == 0L ? null : new OpenHow(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(OpenHow.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = OpenHow.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static OpenHow malloc(MemoryStack param0) {
        return new OpenHow(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static OpenHow calloc(MemoryStack param0) {
        return new OpenHow(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nflags(long param0) {
        return UNSAFE.getLong(null, param0 + (long)FLAGS);
    }

    public static long nmode(long param0) {
        return UNSAFE.getLong(null, param0 + (long)MODE);
    }

    public static long nresolve(long param0) {
        return UNSAFE.getLong(null, param0 + (long)RESOLVE);
    }

    public static void nflags(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)FLAGS, param2);
    }

    public static void nmode(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)MODE, param2);
    }

    public static void nresolve(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)RESOLVE, param2);
    }

    static {
        Struct.Layout v0 = OpenHow.__struct(OpenHow.__member(8), OpenHow.__member(8), OpenHow.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        FLAGS = v0.offsetof(0);
        MODE = v0.offsetof(1);
        RESOLVE = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<OpenHow, Buffer>
    implements NativeResource {
        private static final OpenHow ELEMENT_FACTORY = OpenHow.create(-1L);

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
        protected OpenHow getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u64")
        public long flags() {
            return OpenHow.nflags(this.address());
        }

        @NativeType(value="__u64")
        public long mode() {
            return OpenHow.nmode(this.address());
        }

        @NativeType(value="__u64")
        public long resolve() {
            return OpenHow.nresolve(this.address());
        }

        public Buffer flags(@NativeType(value="__u64") long param1) {
            OpenHow.nflags(this.address(), param1);
            return this;
        }

        public Buffer mode(@NativeType(value="__u64") long param1) {
            OpenHow.nmode(this.address(), param1);
            return this;
        }

        public Buffer resolve(@NativeType(value="__u64") long param1) {
            OpenHow.nresolve(this.address(), param1);
            return this;
        }
    }
}

