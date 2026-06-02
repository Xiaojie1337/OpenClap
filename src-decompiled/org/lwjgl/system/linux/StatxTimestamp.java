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

@NativeType(value="struct statx_timestamp")
public class StatxTimestamp
extends Struct<StatxTimestamp>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TV_SEC;
    public static final int TV_NSEC;
    public static final int __RESERVED;

    protected StatxTimestamp(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected StatxTimestamp create(long param1, @Nullable ByteBuffer param3) {
        return new StatxTimestamp(param1, param3);
    }

    public StatxTimestamp(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), StatxTimestamp.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__s64")
    public long tv_sec() {
        return StatxTimestamp.ntv_sec(this.address());
    }

    @NativeType(value="__u32")
    public int tv_nsec() {
        return StatxTimestamp.ntv_nsec(this.address());
    }

    public StatxTimestamp tv_sec(@NativeType(value="__s64") long param1) {
        StatxTimestamp.ntv_sec(this.address(), param1);
        return this;
    }

    public StatxTimestamp tv_nsec(@NativeType(value="__u32") int param1) {
        StatxTimestamp.ntv_nsec(this.address(), param1);
        return this;
    }

    public StatxTimestamp set(long param1, int param3) {
        this.tv_sec(param1);
        this.tv_nsec(param3);
        return this;
    }

    public StatxTimestamp set(StatxTimestamp param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static StatxTimestamp malloc() {
        return new StatxTimestamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static StatxTimestamp calloc() {
        return new StatxTimestamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static StatxTimestamp create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new StatxTimestamp(MemoryUtil.memAddress(v0), v0);
    }

    public static StatxTimestamp create(long param0) {
        return new StatxTimestamp(param0, null);
    }

    @Nullable
    public static StatxTimestamp createSafe(long param0) {
        return param0 == 0L ? null : new StatxTimestamp(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(StatxTimestamp.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = StatxTimestamp.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static StatxTimestamp malloc(MemoryStack param0) {
        return new StatxTimestamp(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static StatxTimestamp calloc(MemoryStack param0) {
        return new StatxTimestamp(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int ntv_nsec(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TV_NSEC);
    }

    public static int n__reserved(long param0) {
        return UNSAFE.getInt(null, param0 + (long)__RESERVED);
    }

    public static void ntv_sec(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)TV_SEC, param2);
    }

    public static void ntv_nsec(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TV_NSEC, param2);
    }

    public static void n__reserved(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)__RESERVED, param2);
    }

    static {
        Struct.Layout v0 = StatxTimestamp.__struct(StatxTimestamp.__member(8), StatxTimestamp.__member(4), StatxTimestamp.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TV_SEC = v0.offsetof(0);
        TV_NSEC = v0.offsetof(1);
        __RESERVED = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<StatxTimestamp, Buffer>
    implements NativeResource {
        private static final StatxTimestamp ELEMENT_FACTORY = StatxTimestamp.create(-1L);

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
        protected StatxTimestamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__s64")
        public long tv_sec() {
            return StatxTimestamp.ntv_sec(this.address());
        }

        @NativeType(value="__u32")
        public int tv_nsec() {
            return StatxTimestamp.ntv_nsec(this.address());
        }

        public Buffer tv_sec(@NativeType(value="__s64") long param1) {
            StatxTimestamp.ntv_sec(this.address(), param1);
            return this;
        }

        public Buffer tv_nsec(@NativeType(value="__u32") int param1) {
            StatxTimestamp.ntv_nsec(this.address(), param1);
            return this;
        }
    }
}

