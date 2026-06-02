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

@NativeType(value="struct UIrect")
public class UIRect
extends Struct<UIRect>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int V;
    public static final int X;
    public static final int Y;
    public static final int W;
    public static final int H;

    protected UIRect(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected UIRect create(long param1, @Nullable ByteBuffer param3) {
        return new UIRect(param1, param3);
    }

    public UIRect(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), UIRect.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int[4]")
    public IntBuffer v() {
        return UIRect.nv(this.address());
    }

    public int v(int param1) {
        return UIRect.nv(this.address(), param1);
    }

    public int x() {
        return UIRect.nx(this.address());
    }

    public int y() {
        return UIRect.ny(this.address());
    }

    public int w() {
        return UIRect.nw(this.address());
    }

    public int h() {
        return UIRect.nh(this.address());
    }

    public UIRect v(@NativeType(value="int[4]") IntBuffer param1) {
        UIRect.nv(this.address(), param1);
        return this;
    }

    public UIRect v(int param1, int param2) {
        UIRect.nv(this.address(), param1, param2);
        return this;
    }

    public UIRect x(int param1) {
        UIRect.nx(this.address(), param1);
        return this;
    }

    public UIRect y(int param1) {
        UIRect.ny(this.address(), param1);
        return this;
    }

    public UIRect w(int param1) {
        UIRect.nw(this.address(), param1);
        return this;
    }

    public UIRect h(int param1) {
        UIRect.nh(this.address(), param1);
        return this;
    }

    public UIRect set(UIRect param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static UIRect malloc() {
        return new UIRect(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static UIRect calloc() {
        return new UIRect(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static UIRect create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new UIRect(MemoryUtil.memAddress(v0), v0);
    }

    public static UIRect create(long param0) {
        return new UIRect(param0, null);
    }

    @Nullable
    public static UIRect createSafe(long param0) {
        return param0 == 0L ? null : new UIRect(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(UIRect.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = UIRect.__create(param0, SIZEOF);
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
    public static UIRect mallocStack() {
        return UIRect.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIRect callocStack() {
        return UIRect.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIRect mallocStack(MemoryStack param0) {
        return UIRect.malloc(param0);
    }

    @Deprecated
    public static UIRect callocStack(MemoryStack param0) {
        return UIRect.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return UIRect.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return UIRect.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return UIRect.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return UIRect.calloc(param0, param1);
    }

    public static UIRect malloc(MemoryStack param0) {
        return new UIRect(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static UIRect calloc(MemoryStack param0) {
        return new UIRect(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static IntBuffer nv(long param0) {
        return MemoryUtil.memIntBuffer(param0 + (long)V, 4);
    }

    public static int nv(long param0, int param2) {
        return UNSAFE.getInt(null, param0 + (long)V + Checks.check(param2, 4) * 4L);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static int nw(long param0) {
        return UNSAFE.getInt(null, param0 + (long)W);
    }

    public static int nh(long param0) {
        return UNSAFE.getInt(null, param0 + (long)H);
    }

    public static void nv(long param0, IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)V, param2.remaining() * 4);
    }

    public static void nv(long param0, int param2, int param3) {
        UNSAFE.putInt(null, param0 + (long)V + Checks.check(param2, 4) * 4L, param3);
    }

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    public static void nw(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)W, param2);
    }

    public static void nh(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)H, param2);
    }

    static {
        Struct.Layout v0 = UIRect.__struct(UIRect.__union(UIRect.__array(4, 4), UIRect.__struct(UIRect.__member(4), UIRect.__member(4), UIRect.__member(4), UIRect.__member(4))));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        V = v0.offsetof(1);
        X = v0.offsetof(3);
        Y = v0.offsetof(4);
        W = v0.offsetof(5);
        H = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<UIRect, Buffer>
    implements NativeResource {
        private static final UIRect ELEMENT_FACTORY = UIRect.create(-1L);

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
        protected UIRect getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int[4]")
        public IntBuffer v() {
            return UIRect.nv(this.address());
        }

        public int v(int param1) {
            return UIRect.nv(this.address(), param1);
        }

        public int x() {
            return UIRect.nx(this.address());
        }

        public int y() {
            return UIRect.ny(this.address());
        }

        public int w() {
            return UIRect.nw(this.address());
        }

        public int h() {
            return UIRect.nh(this.address());
        }

        public Buffer v(@NativeType(value="int[4]") IntBuffer param1) {
            UIRect.nv(this.address(), param1);
            return this;
        }

        public Buffer v(int param1, int param2) {
            UIRect.nv(this.address(), param1, param2);
            return this;
        }

        public Buffer x(int param1) {
            UIRect.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            UIRect.ny(this.address(), param1);
            return this;
        }

        public Buffer w(int param1) {
            UIRect.nw(this.address(), param1);
            return this;
        }

        public Buffer h(int param1) {
            UIRect.nh(this.address(), param1);
            return this;
        }
    }
}

