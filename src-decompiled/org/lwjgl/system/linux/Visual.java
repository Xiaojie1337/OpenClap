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

public class Visual
extends Struct<Visual>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EXT_DATA;
    public static final int VISUALID;
    public static final int CLASS;
    public static final int RED_MASK;
    public static final int GREEN_MASK;
    public static final int BLUE_MASK;
    public static final int BITS_PER_RGB;
    public static final int MAP_ENTRIES;

    protected Visual(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected Visual create(long param1, @Nullable ByteBuffer param3) {
        return new Visual(param1, param3);
    }

    public Visual(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), Visual.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ext_data() {
        return Visual.next_data(this.address());
    }

    @NativeType(value="VisualID")
    public long visualid() {
        return Visual.nvisualid(this.address());
    }

    public int class$() {
        return Visual.nclass$(this.address());
    }

    @NativeType(value="unsigned long")
    public long red_mask() {
        return Visual.nred_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long green_mask() {
        return Visual.ngreen_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long blue_mask() {
        return Visual.nblue_mask(this.address());
    }

    public int bits_per_rgb() {
        return Visual.nbits_per_rgb(this.address());
    }

    public int map_entries() {
        return Visual.nmap_entries(this.address());
    }

    public Visual ext_data(@NativeType(value="void *") long param1) {
        Visual.next_data(this.address(), param1);
        return this;
    }

    public Visual visualid(@NativeType(value="VisualID") long param1) {
        Visual.nvisualid(this.address(), param1);
        return this;
    }

    public Visual class$(int param1) {
        Visual.nclass$(this.address(), param1);
        return this;
    }

    public Visual red_mask(@NativeType(value="unsigned long") long param1) {
        Visual.nred_mask(this.address(), param1);
        return this;
    }

    public Visual green_mask(@NativeType(value="unsigned long") long param1) {
        Visual.ngreen_mask(this.address(), param1);
        return this;
    }

    public Visual blue_mask(@NativeType(value="unsigned long") long param1) {
        Visual.nblue_mask(this.address(), param1);
        return this;
    }

    public Visual bits_per_rgb(int param1) {
        Visual.nbits_per_rgb(this.address(), param1);
        return this;
    }

    public Visual map_entries(int param1) {
        Visual.nmap_entries(this.address(), param1);
        return this;
    }

    public Visual set(long param1, long param3, int param5, long param6, long param8, long param10, int param12, int param13) {
        this.ext_data(param1);
        this.visualid(param3);
        this.class$(param5);
        this.red_mask(param6);
        this.green_mask(param8);
        this.blue_mask(param10);
        this.bits_per_rgb(param12);
        this.map_entries(param13);
        return this;
    }

    public Visual set(Visual param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static Visual malloc() {
        return new Visual(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Visual calloc() {
        return new Visual(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Visual create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new Visual(MemoryUtil.memAddress(v0), v0);
    }

    public static Visual create(long param0) {
        return new Visual(param0, null);
    }

    @Nullable
    public static Visual createSafe(long param0) {
        return param0 == 0L ? null : new Visual(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Visual.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = Visual.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    @Deprecated
    public static Visual mallocStack() {
        return Visual.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual callocStack() {
        return Visual.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual mallocStack(MemoryStack param0) {
        return Visual.malloc(param0);
    }

    @Deprecated
    public static Visual callocStack(MemoryStack param0) {
        return Visual.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return Visual.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return Visual.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return Visual.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return Visual.calloc(param0, param1);
    }

    public static Visual malloc(MemoryStack param0) {
        return new Visual(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Visual calloc(MemoryStack param0) {
        return new Visual(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long next_data(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)EXT_DATA);
    }

    public static long nvisualid(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)VISUALID);
    }

    public static int nclass$(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CLASS);
    }

    public static long nred_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)RED_MASK);
    }

    public static long ngreen_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)GREEN_MASK);
    }

    public static long nblue_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BLUE_MASK);
    }

    public static int nbits_per_rgb(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BITS_PER_RGB);
    }

    public static int nmap_entries(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MAP_ENTRIES);
    }

    public static void next_data(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)EXT_DATA, param2);
    }

    public static void nvisualid(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)VISUALID, param2);
    }

    public static void nclass$(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CLASS, param2);
    }

    public static void nred_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)RED_MASK, param2);
    }

    public static void ngreen_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)GREEN_MASK, param2);
    }

    public static void nblue_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BLUE_MASK, param2);
    }

    public static void nbits_per_rgb(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BITS_PER_RGB, param2);
    }

    public static void nmap_entries(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MAP_ENTRIES, param2);
    }

    static {
        Struct.Layout v0 = Visual.__struct(Visual.__member(POINTER_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        EXT_DATA = v0.offsetof(0);
        VISUALID = v0.offsetof(1);
        CLASS = v0.offsetof(2);
        RED_MASK = v0.offsetof(3);
        GREEN_MASK = v0.offsetof(4);
        BLUE_MASK = v0.offsetof(5);
        BITS_PER_RGB = v0.offsetof(6);
        MAP_ENTRIES = v0.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<Visual, Buffer>
    implements NativeResource {
        private static final Visual ELEMENT_FACTORY = Visual.create(-1L);

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
        protected Visual getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ext_data() {
            return Visual.next_data(this.address());
        }

        @NativeType(value="VisualID")
        public long visualid() {
            return Visual.nvisualid(this.address());
        }

        public int class$() {
            return Visual.nclass$(this.address());
        }

        @NativeType(value="unsigned long")
        public long red_mask() {
            return Visual.nred_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long green_mask() {
            return Visual.ngreen_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long blue_mask() {
            return Visual.nblue_mask(this.address());
        }

        public int bits_per_rgb() {
            return Visual.nbits_per_rgb(this.address());
        }

        public int map_entries() {
            return Visual.nmap_entries(this.address());
        }

        public Buffer ext_data(@NativeType(value="void *") long param1) {
            Visual.next_data(this.address(), param1);
            return this;
        }

        public Buffer visualid(@NativeType(value="VisualID") long param1) {
            Visual.nvisualid(this.address(), param1);
            return this;
        }

        public Buffer class$(int param1) {
            Visual.nclass$(this.address(), param1);
            return this;
        }

        public Buffer red_mask(@NativeType(value="unsigned long") long param1) {
            Visual.nred_mask(this.address(), param1);
            return this;
        }

        public Buffer green_mask(@NativeType(value="unsigned long") long param1) {
            Visual.ngreen_mask(this.address(), param1);
            return this;
        }

        public Buffer blue_mask(@NativeType(value="unsigned long") long param1) {
            Visual.nblue_mask(this.address(), param1);
            return this;
        }

        public Buffer bits_per_rgb(int param1) {
            Visual.nbits_per_rgb(this.address(), param1);
            return this;
        }

        public Buffer map_entries(int param1) {
            Visual.nmap_entries(this.address(), param1);
            return this;
        }
    }
}

