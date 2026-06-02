/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

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

@NativeType(value="struct UIvec2")
public class UIVec2
extends Struct<UIVec2>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int V;
    public static final int X;
    public static final int Y;

    protected UIVec2(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected UIVec2 create(long param1, @Nullable ByteBuffer param3) {
        return new UIVec2(param1, param3);
    }

    public UIVec2(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), UIVec2.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int[2]")
    public IntBuffer v() {
        return UIVec2.nv(this.address());
    }

    public int v(int param1) {
        return UIVec2.nv(this.address(), param1);
    }

    public int x() {
        return UIVec2.nx(this.address());
    }

    public int y() {
        return UIVec2.ny(this.address());
    }

    public UIVec2 v(@NativeType(value="int[2]") IntBuffer param1) {
        UIVec2.nv(this.address(), param1);
        return this;
    }

    public UIVec2 v(int param1, int param2) {
        UIVec2.nv(this.address(), param1, param2);
        return this;
    }

    public UIVec2 x(int param1) {
        UIVec2.nx(this.address(), param1);
        return this;
    }

    public UIVec2 y(int param1) {
        UIVec2.ny(this.address(), param1);
        return this;
    }

    public UIVec2 set(UIVec2 param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static UIVec2 malloc() {
        return new UIVec2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static UIVec2 calloc() {
        return new UIVec2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static UIVec2 create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new UIVec2(MemoryUtil.memAddress(v0), v0);
    }

    public static UIVec2 create(long param0) {
        return new UIVec2(param0, null);
    }

    @Nullable
    public static UIVec2 createSafe(long param0) {
        return param0 == 0L ? null : new UIVec2(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(UIVec2.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = UIVec2.__create(param0, SIZEOF);
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
    public static UIVec2 mallocStack() {
        return UIVec2.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIVec2 callocStack() {
        return UIVec2.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIVec2 mallocStack(MemoryStack param0) {
        return UIVec2.malloc(param0);
    }

    @Deprecated
    public static UIVec2 callocStack(MemoryStack param0) {
        return UIVec2.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return UIVec2.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return UIVec2.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return UIVec2.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return UIVec2.calloc(param0, param1);
    }

    public static UIVec2 malloc(MemoryStack param0) {
        return new UIVec2(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static UIVec2 calloc(MemoryStack param0) {
        return new UIVec2(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static IntBuffer nv(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)V, 2);
    }

    public static int nv(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)V + Checks.check(param2, 2) * 4L);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static void nv(long param0, IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)V, param2.remaining() * 4);
    }

    public static void nv(long param0, int param2, int param3) {
        UNSAFE.putInt(null, param0 + (long)V + Checks.check(param2, 2) * 4L, param3);
    }

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    static {
        Struct.Layout v0 = UIVec2.__struct(UIVec2.__union(UIVec2.__array(4, 2), UIVec2.__struct(UIVec2.__member(4), UIVec2.__member(4))));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        V = v0.offsetof(1);
        X = v0.offsetof(3);
        Y = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<UIVec2, Buffer>
    implements NativeResource {
        private static final UIVec2 ELEMENT_FACTORY = UIVec2.create(-1L);

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
        protected UIVec2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int[2]")
        public IntBuffer v() {
            return UIVec2.nv(this.address());
        }

        public int v(int param1) {
            return UIVec2.nv(this.address(), param1);
        }

        public int x() {
            return UIVec2.nx(this.address());
        }

        public int y() {
            return UIVec2.ny(this.address());
        }

        public Buffer v(@NativeType(value="int[2]") IntBuffer param1) {
            UIVec2.nv(this.address(), param1);
            return this;
        }

        public Buffer v(int param1, int param2) {
            UIVec2.nv(this.address(), param1, param2);
            return this;
        }

        public Buffer x(int param1) {
            UIVec2.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            UIVec2.ny(this.address(), param1);
            return this;
        }
    }
}

