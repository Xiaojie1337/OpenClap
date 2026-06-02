/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGpaint")
public class NVGPaint
extends Struct<NVGPaint>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int XFORM;
    public static final int EXTENT;
    public static final int RADIUS;
    public static final int FEATHER;
    public static final int INNERCOLOR;
    public static final int OUTERCOLOR;
    public static final int IMAGE;

    protected NVGPaint(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGPaint create(long param1, @Nullable ByteBuffer param3) {
        return new NVGPaint(param1, param3);
    }

    public NVGPaint(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGPaint.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NVGPaint.nxform(this.address());
    }

    public float xform(int param1) {
        return NVGPaint.nxform(this.address(), param1);
    }

    @NativeType(value="float[2]")
    public FloatBuffer extent() {
        return NVGPaint.nextent(this.address());
    }

    public float extent(int param1) {
        return NVGPaint.nextent(this.address(), param1);
    }

    public float radius() {
        return NVGPaint.nradius(this.address());
    }

    public float feather() {
        return NVGPaint.nfeather(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerColor() {
        return NVGPaint.ninnerColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor outerColor() {
        return NVGPaint.nouterColor(this.address());
    }

    public int image() {
        return NVGPaint.nimage(this.address());
    }

    public NVGPaint xform(@NativeType(value="float[6]") FloatBuffer param1) {
        NVGPaint.nxform(this.address(), param1);
        return this;
    }

    public NVGPaint xform(int param1, float param2) {
        NVGPaint.nxform(this.address(), param1, param2);
        return this;
    }

    public NVGPaint extent(@NativeType(value="float[2]") FloatBuffer param1) {
        NVGPaint.nextent(this.address(), param1);
        return this;
    }

    public NVGPaint extent(int param1, float param2) {
        NVGPaint.nextent(this.address(), param1, param2);
        return this;
    }

    public NVGPaint radius(float param1) {
        NVGPaint.nradius(this.address(), param1);
        return this;
    }

    public NVGPaint feather(float param1) {
        NVGPaint.nfeather(this.address(), param1);
        return this;
    }

    public NVGPaint innerColor(@NativeType(value="NVGcolor") NVGColor param1) {
        NVGPaint.ninnerColor(this.address(), param1);
        return this;
    }

    public NVGPaint innerColor(Consumer<NVGColor> param1) {
        param1.accept(this.innerColor());
        return this;
    }

    public NVGPaint outerColor(@NativeType(value="NVGcolor") NVGColor param1) {
        NVGPaint.nouterColor(this.address(), param1);
        return this;
    }

    public NVGPaint outerColor(Consumer<NVGColor> param1) {
        param1.accept(this.outerColor());
        return this;
    }

    public NVGPaint image(int param1) {
        NVGPaint.nimage(this.address(), param1);
        return this;
    }

    public NVGPaint set(FloatBuffer param1, FloatBuffer param2, float param3, float param4, NVGColor param5, NVGColor param6, int param7) {
        this.xform(param1);
        this.extent(param2);
        this.radius(param3);
        this.feather(param4);
        this.innerColor(param5);
        this.outerColor(param6);
        this.image(param7);
        return this;
    }

    public NVGPaint set(NVGPaint param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static NVGPaint malloc() {
        return new NVGPaint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGPaint calloc() {
        return new NVGPaint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGPaint create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGPaint(MemoryUtil.memAddress(v0), v0);
    }

    public static NVGPaint create(long param0) {
        return new NVGPaint(param0, null);
    }

    @Nullable
    public static NVGPaint createSafe(long param0) {
        return param0 == 0L ? null : new NVGPaint(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGPaint.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = NVGPaint.__create(param0, SIZEOF);
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
    public static NVGPaint mallocStack() {
        return NVGPaint.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGPaint callocStack() {
        return NVGPaint.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGPaint mallocStack(MemoryStack param0) {
        return NVGPaint.malloc(param0);
    }

    @Deprecated
    public static NVGPaint callocStack(MemoryStack param0) {
        return NVGPaint.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return NVGPaint.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return NVGPaint.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return NVGPaint.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return NVGPaint.calloc(param0, param1);
    }

    public static NVGPaint malloc(MemoryStack param0) {
        return new NVGPaint(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGPaint calloc(MemoryStack param0) {
        return new NVGPaint(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static FloatBuffer nxform(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)XFORM, 6);
    }

    public static float nxform(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)XFORM + Checks.check(param2, 6) * 4L);
    }

    public static FloatBuffer nextent(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)EXTENT, 2);
    }

    public static float nextent(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)EXTENT + Checks.check(param2, 2) * 4L);
    }

    public static float nradius(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)RADIUS);
    }

    public static float nfeather(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)FEATHER);
    }

    public static NVGColor ninnerColor(long param0) {
        return NVGColor.create(param0 + (long)INNERCOLOR);
    }

    public static NVGColor nouterColor(long param0) {
        return NVGColor.create(param0 + (long)OUTERCOLOR);
    }

    public static int nimage(long param0) {
        return UNSAFE.getInt(null, param0 + (long)IMAGE);
    }

    public static void nxform(long param0, FloatBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 6);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)XFORM, param2.remaining() * 4);
    }

    public static void nxform(long param0, int param2, float param3) {
        UNSAFE.putFloat(null, param0 + (long)XFORM + Checks.check(param2, 6) * 4L, param3);
    }

    public static void nextent(long param0, FloatBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)EXTENT, param2.remaining() * 4);
    }

    public static void nextent(long param0, int param2, float param3) {
        UNSAFE.putFloat(null, param0 + (long)EXTENT + Checks.check(param2, 2) * 4L, param3);
    }

    public static void nradius(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)RADIUS, param2);
    }

    public static void nfeather(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)FEATHER, param2);
    }

    public static void ninnerColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)INNERCOLOR, NVGColor.SIZEOF);
    }

    public static void nouterColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)OUTERCOLOR, NVGColor.SIZEOF);
    }

    public static void nimage(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)IMAGE, param2);
    }

    static {
        Struct.Layout v0 = NVGPaint.__struct(NVGPaint.__array(4, 6), NVGPaint.__array(4, 2), NVGPaint.__member(4), NVGPaint.__member(4), NVGPaint.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), NVGPaint.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), NVGPaint.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        XFORM = v0.offsetof(0);
        EXTENT = v0.offsetof(1);
        RADIUS = v0.offsetof(2);
        FEATHER = v0.offsetof(3);
        INNERCOLOR = v0.offsetof(4);
        OUTERCOLOR = v0.offsetof(5);
        IMAGE = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<NVGPaint, Buffer>
    implements NativeResource {
        private static final NVGPaint ELEMENT_FACTORY = NVGPaint.create(-1L);

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
        protected NVGPaint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NVGPaint.nxform(this.address());
        }

        public float xform(int param1) {
            return NVGPaint.nxform(this.address(), param1);
        }

        @NativeType(value="float[2]")
        public FloatBuffer extent() {
            return NVGPaint.nextent(this.address());
        }

        public float extent(int param1) {
            return NVGPaint.nextent(this.address(), param1);
        }

        public float radius() {
            return NVGPaint.nradius(this.address());
        }

        public float feather() {
            return NVGPaint.nfeather(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerColor() {
            return NVGPaint.ninnerColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor outerColor() {
            return NVGPaint.nouterColor(this.address());
        }

        public int image() {
            return NVGPaint.nimage(this.address());
        }

        public Buffer xform(@NativeType(value="float[6]") FloatBuffer param1) {
            NVGPaint.nxform(this.address(), param1);
            return this;
        }

        public Buffer xform(int param1, float param2) {
            NVGPaint.nxform(this.address(), param1, param2);
            return this;
        }

        public Buffer extent(@NativeType(value="float[2]") FloatBuffer param1) {
            NVGPaint.nextent(this.address(), param1);
            return this;
        }

        public Buffer extent(int param1, float param2) {
            NVGPaint.nextent(this.address(), param1, param2);
            return this;
        }

        public Buffer radius(float param1) {
            NVGPaint.nradius(this.address(), param1);
            return this;
        }

        public Buffer feather(float param1) {
            NVGPaint.nfeather(this.address(), param1);
            return this;
        }

        public Buffer innerColor(@NativeType(value="NVGcolor") NVGColor param1) {
            NVGPaint.ninnerColor(this.address(), param1);
            return this;
        }

        public Buffer innerColor(Consumer<NVGColor> param1) {
            param1.accept(this.innerColor());
            return this;
        }

        public Buffer outerColor(@NativeType(value="NVGcolor") NVGColor param1) {
            NVGPaint.nouterColor(this.address(), param1);
            return this;
        }

        public Buffer outerColor(Consumer<NVGColor> param1) {
            param1.accept(this.outerColor());
            return this;
        }

        public Buffer image(int param1) {
            NVGPaint.nimage(this.address(), param1);
            return this;
        }
    }
}

