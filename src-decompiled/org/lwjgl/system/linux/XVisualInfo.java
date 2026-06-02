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
import org.lwjgl.system.linux.Visual;

public class XVisualInfo
extends Struct<XVisualInfo>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int VISUAL;
    public static final int VISUALID;
    public static final int SCREEN;
    public static final int DEPTH;
    public static final int CLASS;
    public static final int RED_MASK;
    public static final int GREEN_MASK;
    public static final int BLUE_MASK;
    public static final int COLORMAP_SIZE;
    public static final int BITS_PER_RGB;

    protected XVisualInfo(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XVisualInfo create(long param1, @Nullable ByteBuffer param3) {
        return new XVisualInfo(param1, param3);
    }

    public XVisualInfo(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XVisualInfo.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Visual *")
    public Visual visual() {
        return XVisualInfo.nvisual(this.address());
    }

    @NativeType(value="VisualID")
    public long visualid() {
        return XVisualInfo.nvisualid(this.address());
    }

    public int screen() {
        return XVisualInfo.nscreen(this.address());
    }

    public int depth() {
        return XVisualInfo.ndepth(this.address());
    }

    public int class$() {
        return XVisualInfo.nclass$(this.address());
    }

    @NativeType(value="unsigned long")
    public long red_mask() {
        return XVisualInfo.nred_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long green_mask() {
        return XVisualInfo.ngreen_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long blue_mask() {
        return XVisualInfo.nblue_mask(this.address());
    }

    public int colormap_size() {
        return XVisualInfo.ncolormap_size(this.address());
    }

    public int bits_per_rgb() {
        return XVisualInfo.nbits_per_rgb(this.address());
    }

    public XVisualInfo visual(@NativeType(value="Visual *") Visual param1) {
        XVisualInfo.nvisual(this.address(), param1);
        return this;
    }

    public XVisualInfo visualid(@NativeType(value="VisualID") long param1) {
        XVisualInfo.nvisualid(this.address(), param1);
        return this;
    }

    public XVisualInfo screen(int param1) {
        XVisualInfo.nscreen(this.address(), param1);
        return this;
    }

    public XVisualInfo depth(int param1) {
        XVisualInfo.ndepth(this.address(), param1);
        return this;
    }

    public XVisualInfo class$(int param1) {
        XVisualInfo.nclass$(this.address(), param1);
        return this;
    }

    public XVisualInfo red_mask(@NativeType(value="unsigned long") long param1) {
        XVisualInfo.nred_mask(this.address(), param1);
        return this;
    }

    public XVisualInfo green_mask(@NativeType(value="unsigned long") long param1) {
        XVisualInfo.ngreen_mask(this.address(), param1);
        return this;
    }

    public XVisualInfo blue_mask(@NativeType(value="unsigned long") long param1) {
        XVisualInfo.nblue_mask(this.address(), param1);
        return this;
    }

    public XVisualInfo colormap_size(int param1) {
        XVisualInfo.ncolormap_size(this.address(), param1);
        return this;
    }

    public XVisualInfo bits_per_rgb(int param1) {
        XVisualInfo.nbits_per_rgb(this.address(), param1);
        return this;
    }

    public XVisualInfo set(Visual param1, long param2, int param4, int param5, int param6, long param7, long param9, long param11, int param13, int param14) {
        this.visual(param1);
        this.visualid(param2);
        this.screen(param4);
        this.depth(param5);
        this.class$(param6);
        this.red_mask(param7);
        this.green_mask(param9);
        this.blue_mask(param11);
        this.colormap_size(param13);
        this.bits_per_rgb(param14);
        return this;
    }

    public XVisualInfo set(XVisualInfo param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XVisualInfo malloc() {
        return new XVisualInfo(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XVisualInfo calloc() {
        return new XVisualInfo(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XVisualInfo create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XVisualInfo(MemoryUtil.memAddress(v0), v0);
    }

    public static XVisualInfo create(long param0) {
        return new XVisualInfo(param0, null);
    }

    @Nullable
    public static XVisualInfo createSafe(long param0) {
        return param0 == 0L ? null : new XVisualInfo(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XVisualInfo.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XVisualInfo.__create(param0, SIZEOF);
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
    public static XVisualInfo mallocStack() {
        return XVisualInfo.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisualInfo callocStack() {
        return XVisualInfo.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisualInfo mallocStack(MemoryStack param0) {
        return XVisualInfo.malloc(param0);
    }

    @Deprecated
    public static XVisualInfo callocStack(MemoryStack param0) {
        return XVisualInfo.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XVisualInfo.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XVisualInfo.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XVisualInfo.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XVisualInfo.calloc(param0, param1);
    }

    public static XVisualInfo malloc(MemoryStack param0) {
        return new XVisualInfo(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XVisualInfo calloc(MemoryStack param0) {
        return new XVisualInfo(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static Visual nvisual(long param0) {
        return Visual.create(MemoryUtil.memGetAddress(param0 + (long)VISUAL));
    }

    public static long nvisualid(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)VISUALID);
    }

    public static int nscreen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SCREEN);
    }

    public static int ndepth(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DEPTH);
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

    public static int ncolormap_size(long param0) {
        return UNSAFE.getInt(null, param0 + (long)COLORMAP_SIZE);
    }

    public static int nbits_per_rgb(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BITS_PER_RGB);
    }

    public static void nvisual(long param0, Visual param2) {
        MemoryUtil.memPutAddress(param0 + (long)VISUAL, param2.address());
    }

    public static void nvisualid(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)VISUALID, param2);
    }

    public static void nscreen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SCREEN, param2);
    }

    public static void ndepth(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DEPTH, param2);
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

    public static void ncolormap_size(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)COLORMAP_SIZE, param2);
    }

    public static void nbits_per_rgb(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BITS_PER_RGB, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)VISUAL));
    }

    static {
        Struct.Layout v0 = XVisualInfo.__struct(XVisualInfo.__member(POINTER_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(4), XVisualInfo.__member(4), XVisualInfo.__member(4), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(CLONG_SIZE), XVisualInfo.__member(4), XVisualInfo.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        VISUAL = v0.offsetof(0);
        VISUALID = v0.offsetof(1);
        SCREEN = v0.offsetof(2);
        DEPTH = v0.offsetof(3);
        CLASS = v0.offsetof(4);
        RED_MASK = v0.offsetof(5);
        GREEN_MASK = v0.offsetof(6);
        BLUE_MASK = v0.offsetof(7);
        COLORMAP_SIZE = v0.offsetof(8);
        BITS_PER_RGB = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XVisualInfo, Buffer>
    implements NativeResource {
        private static final XVisualInfo ELEMENT_FACTORY = XVisualInfo.create(-1L);

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
        protected XVisualInfo getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Visual *")
        public Visual visual() {
            return XVisualInfo.nvisual(this.address());
        }

        @NativeType(value="VisualID")
        public long visualid() {
            return XVisualInfo.nvisualid(this.address());
        }

        public int screen() {
            return XVisualInfo.nscreen(this.address());
        }

        public int depth() {
            return XVisualInfo.ndepth(this.address());
        }

        public int class$() {
            return XVisualInfo.nclass$(this.address());
        }

        @NativeType(value="unsigned long")
        public long red_mask() {
            return XVisualInfo.nred_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long green_mask() {
            return XVisualInfo.ngreen_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long blue_mask() {
            return XVisualInfo.nblue_mask(this.address());
        }

        public int colormap_size() {
            return XVisualInfo.ncolormap_size(this.address());
        }

        public int bits_per_rgb() {
            return XVisualInfo.nbits_per_rgb(this.address());
        }

        public Buffer visual(@NativeType(value="Visual *") Visual param1) {
            XVisualInfo.nvisual(this.address(), param1);
            return this;
        }

        public Buffer visualid(@NativeType(value="VisualID") long param1) {
            XVisualInfo.nvisualid(this.address(), param1);
            return this;
        }

        public Buffer screen(int param1) {
            XVisualInfo.nscreen(this.address(), param1);
            return this;
        }

        public Buffer depth(int param1) {
            XVisualInfo.ndepth(this.address(), param1);
            return this;
        }

        public Buffer class$(int param1) {
            XVisualInfo.nclass$(this.address(), param1);
            return this;
        }

        public Buffer red_mask(@NativeType(value="unsigned long") long param1) {
            XVisualInfo.nred_mask(this.address(), param1);
            return this;
        }

        public Buffer green_mask(@NativeType(value="unsigned long") long param1) {
            XVisualInfo.ngreen_mask(this.address(), param1);
            return this;
        }

        public Buffer blue_mask(@NativeType(value="unsigned long") long param1) {
            XVisualInfo.nblue_mask(this.address(), param1);
            return this;
        }

        public Buffer colormap_size(int param1) {
            XVisualInfo.ncolormap_size(this.address(), param1);
            return this;
        }

        public Buffer bits_per_rgb(int param1) {
            XVisualInfo.nbits_per_rgb(this.address(), param1);
            return this;
        }
    }
}

