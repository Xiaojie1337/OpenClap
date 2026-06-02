/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGcolor")
public class NVGColor
extends Struct<NVGColor>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RGBA;
    public static final int R;
    public static final int G;
    public static final int B;
    public static final int A;

    protected NVGColor(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGColor create(long param1, @Nullable ByteBuffer param3) {
        return new NVGColor(param1, param3);
    }

    public NVGColor(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGColor.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[4]")
    public FloatBuffer rgba() {
        return NVGColor.nrgba(this.address());
    }

    public float rgba(int param1) {
        return NVGColor.nrgba(this.address(), param1);
    }

    public float r() {
        return NVGColor.nr(this.address());
    }

    public float g() {
        return NVGColor.ng(this.address());
    }

    public float b() {
        return NVGColor.nb(this.address());
    }

    public float a() {
        return NVGColor.na(this.address());
    }

    public NVGColor rgba(@NativeType(value="float[4]") FloatBuffer param1) {
        NVGColor.nrgba(this.address(), param1);
        return this;
    }

    public NVGColor rgba(int param1, float param2) {
        NVGColor.nrgba(this.address(), param1, param2);
        return this;
    }

    public NVGColor r(float param1) {
        NVGColor.nr(this.address(), param1);
        return this;
    }

    public NVGColor g(float param1) {
        NVGColor.ng(this.address(), param1);
        return this;
    }

    public NVGColor b(float param1) {
        NVGColor.nb(this.address(), param1);
        return this;
    }

    public NVGColor a(float param1) {
        NVGColor.na(this.address(), param1);
        return this;
    }

    public NVGColor set(NVGColor param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static NVGColor malloc() {
        return new NVGColor(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGColor calloc() {
        return new NVGColor(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGColor create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGColor(MemoryUtil.memAddress(v0), v0);
    }

    public static NVGColor create(long param0) {
        return new NVGColor(param0, null);
    }

    @Nullable
    public static NVGColor createSafe(long param0) {
        return param0 == 0L ? null : new NVGColor(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGColor.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = NVGColor.__create(param0, SIZEOF);
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
    public static NVGColor mallocStack() {
        return NVGColor.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGColor callocStack() {
        return NVGColor.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGColor mallocStack(MemoryStack param0) {
        return NVGColor.malloc(param0);
    }

    @Deprecated
    public static NVGColor callocStack(MemoryStack param0) {
        return NVGColor.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return NVGColor.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return NVGColor.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return NVGColor.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return NVGColor.calloc(param0, param1);
    }

    public static NVGColor malloc(MemoryStack param0) {
        return new NVGColor(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGColor calloc(MemoryStack param0) {
        return new NVGColor(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static FloatBuffer nrgba(long param0) {
        return MemoryUtil.memFloatBuffer(param0 + (long)RGBA, 4);
    }

    public static float nrgba(long param0, int param2) {
        return UNSAFE.getFloat(null, param0 + (long)RGBA + Checks.check(param2, 4) * 4L);
    }

    public static float nr(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)R);
    }

    public static float ng(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)G);
    }

    public static float nb(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)B);
    }

    public static float na(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)A);
    }

    public static void nrgba(long param0, FloatBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)RGBA, param2.remaining() * 4);
    }

    public static void nrgba(long param0, int param2, float param3) {
        UNSAFE.putFloat(null, param0 + (long)RGBA + Checks.check(param2, 4) * 4L, param3);
    }

    public static void nr(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)R, param2);
    }

    public static void ng(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)G, param2);
    }

    public static void nb(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)B, param2);
    }

    public static void na(long param0, float param2) {
        UNSAFE.putFloat(null, param0 + (long)A, param2);
    }

    static {
        Struct.Layout v0 = NVGColor.__struct(NVGColor.__union(NVGColor.__array(4, 4), NVGColor.__struct(NVGColor.__member(4), NVGColor.__member(4), NVGColor.__member(4), NVGColor.__member(4))));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        RGBA = v0.offsetof(1);
        R = v0.offsetof(3);
        G = v0.offsetof(4);
        B = v0.offsetof(5);
        A = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<NVGColor, Buffer>
    implements NativeResource {
        private static final NVGColor ELEMENT_FACTORY = NVGColor.create(-1L);

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
        protected NVGColor getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[4]")
        public FloatBuffer rgba() {
            return NVGColor.nrgba(this.address());
        }

        public float rgba(int param1) {
            return NVGColor.nrgba(this.address(), param1);
        }

        public float r() {
            return NVGColor.nr(this.address());
        }

        public float g() {
            return NVGColor.ng(this.address());
        }

        public float b() {
            return NVGColor.nb(this.address());
        }

        public float a() {
            return NVGColor.na(this.address());
        }

        public Buffer rgba(@NativeType(value="float[4]") FloatBuffer param1) {
            NVGColor.nrgba(this.address(), param1);
            return this;
        }

        public Buffer rgba(int param1, float param2) {
            NVGColor.nrgba(this.address(), param1, param2);
            return this;
        }

        public Buffer r(float param1) {
            NVGColor.nr(this.address(), param1);
            return this;
        }

        public Buffer g(float param1) {
            NVGColor.ng(this.address(), param1);
            return this;
        }

        public Buffer b(float param1) {
            NVGColor.nb(this.address(), param1);
            return this;
        }

        public Buffer a(float param1) {
            NVGColor.na(this.address(), param1);
            return this;
        }
    }
}

