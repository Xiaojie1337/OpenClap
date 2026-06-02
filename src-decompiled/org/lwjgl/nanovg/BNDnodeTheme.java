/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class BNDnodeTheme
extends Struct<BNDnodeTheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NODESELECTEDCOLOR;
    public static final int WIRESCOLOR;
    public static final int TEXTSELECTEDCOLOR;
    public static final int ACTIVENODECOLOR;
    public static final int WIRESELECTCOLOR;
    public static final int NODEBACKDROPCOLOR;
    public static final int NOODLECURVING;

    protected BNDnodeTheme(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected BNDnodeTheme create(long param1, @Nullable ByteBuffer param3) {
        return new BNDnodeTheme(param1, param3);
    }

    public BNDnodeTheme(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), BNDnodeTheme.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor nodeSelectedColor() {
        return BNDnodeTheme.nnodeSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor wiresColor() {
        return BNDnodeTheme.nwiresColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textSelectedColor() {
        return BNDnodeTheme.ntextSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor activeNodeColor() {
        return BNDnodeTheme.nactiveNodeColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor wireSelectColor() {
        return BNDnodeTheme.nwireSelectColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor nodeBackdropColor() {
        return BNDnodeTheme.nnodeBackdropColor(this.address());
    }

    public int noodleCurving() {
        return BNDnodeTheme.nnoodleCurving(this.address());
    }

    public BNDnodeTheme nodeSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.nnodeSelectedColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme nodeSelectedColor(Consumer<NVGColor> param1) {
        param1.accept(this.nodeSelectedColor());
        return this;
    }

    public BNDnodeTheme wiresColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.nwiresColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme wiresColor(Consumer<NVGColor> param1) {
        param1.accept(this.wiresColor());
        return this;
    }

    public BNDnodeTheme textSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.ntextSelectedColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme textSelectedColor(Consumer<NVGColor> param1) {
        param1.accept(this.textSelectedColor());
        return this;
    }

    public BNDnodeTheme activeNodeColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.nactiveNodeColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme activeNodeColor(Consumer<NVGColor> param1) {
        param1.accept(this.activeNodeColor());
        return this;
    }

    public BNDnodeTheme wireSelectColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.nwireSelectColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme wireSelectColor(Consumer<NVGColor> param1) {
        param1.accept(this.wireSelectColor());
        return this;
    }

    public BNDnodeTheme nodeBackdropColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDnodeTheme.nnodeBackdropColor(this.address(), param1);
        return this;
    }

    public BNDnodeTheme nodeBackdropColor(Consumer<NVGColor> param1) {
        param1.accept(this.nodeBackdropColor());
        return this;
    }

    public BNDnodeTheme noodleCurving(int param1) {
        BNDnodeTheme.nnoodleCurving(this.address(), param1);
        return this;
    }

    public BNDnodeTheme set(NVGColor param1, NVGColor param2, NVGColor param3, NVGColor param4, NVGColor param5, NVGColor param6, int param7) {
        this.nodeSelectedColor(param1);
        this.wiresColor(param2);
        this.textSelectedColor(param3);
        this.activeNodeColor(param4);
        this.wireSelectColor(param5);
        this.nodeBackdropColor(param6);
        this.noodleCurving(param7);
        return this;
    }

    public BNDnodeTheme set(BNDnodeTheme param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDnodeTheme malloc() {
        return new BNDnodeTheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDnodeTheme calloc() {
        return new BNDnodeTheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDnodeTheme create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDnodeTheme(MemoryUtil.memAddress(v0), v0);
    }

    public static BNDnodeTheme create(long param0) {
        return new BNDnodeTheme(param0, null);
    }

    @Nullable
    public static BNDnodeTheme createSafe(long param0) {
        return param0 == 0L ? null : new BNDnodeTheme(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDnodeTheme.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = BNDnodeTheme.__create(param0, SIZEOF);
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
    public static BNDnodeTheme mallocStack() {
        return BNDnodeTheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDnodeTheme callocStack() {
        return BNDnodeTheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDnodeTheme mallocStack(MemoryStack param0) {
        return BNDnodeTheme.malloc(param0);
    }

    @Deprecated
    public static BNDnodeTheme callocStack(MemoryStack param0) {
        return BNDnodeTheme.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return BNDnodeTheme.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return BNDnodeTheme.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return BNDnodeTheme.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return BNDnodeTheme.calloc(param0, param1);
    }

    public static BNDnodeTheme malloc(MemoryStack param0) {
        return new BNDnodeTheme(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDnodeTheme calloc(MemoryStack param0) {
        return new BNDnodeTheme(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static NVGColor nnodeSelectedColor(long param0) {
        return NVGColor.create(param0 + (long)NODESELECTEDCOLOR);
    }

    public static NVGColor nwiresColor(long param0) {
        return NVGColor.create(param0 + (long)WIRESCOLOR);
    }

    public static NVGColor ntextSelectedColor(long param0) {
        return NVGColor.create(param0 + (long)TEXTSELECTEDCOLOR);
    }

    public static NVGColor nactiveNodeColor(long param0) {
        return NVGColor.create(param0 + (long)ACTIVENODECOLOR);
    }

    public static NVGColor nwireSelectColor(long param0) {
        return NVGColor.create(param0 + (long)WIRESELECTCOLOR);
    }

    public static NVGColor nnodeBackdropColor(long param0) {
        return NVGColor.create(param0 + (long)NODEBACKDROPCOLOR);
    }

    public static int nnoodleCurving(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NOODLECURVING);
    }

    public static void nnodeSelectedColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)NODESELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nwiresColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)WIRESCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextSelectedColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TEXTSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nactiveNodeColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)ACTIVENODECOLOR, NVGColor.SIZEOF);
    }

    public static void nwireSelectColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)WIRESELECTCOLOR, NVGColor.SIZEOF);
    }

    public static void nnodeBackdropColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)NODEBACKDROPCOLOR, NVGColor.SIZEOF);
    }

    public static void nnoodleCurving(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NOODLECURVING, param2);
    }

    static {
        Struct.Layout v0 = BNDnodeTheme.__struct(BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NODESELECTEDCOLOR = v0.offsetof(0);
        WIRESCOLOR = v0.offsetof(1);
        TEXTSELECTEDCOLOR = v0.offsetof(2);
        ACTIVENODECOLOR = v0.offsetof(3);
        WIRESELECTCOLOR = v0.offsetof(4);
        NODEBACKDROPCOLOR = v0.offsetof(5);
        NOODLECURVING = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<BNDnodeTheme, Buffer>
    implements NativeResource {
        private static final BNDnodeTheme ELEMENT_FACTORY = BNDnodeTheme.create(-1L);

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
        protected BNDnodeTheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor nodeSelectedColor() {
            return BNDnodeTheme.nnodeSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor wiresColor() {
            return BNDnodeTheme.nwiresColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textSelectedColor() {
            return BNDnodeTheme.ntextSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor activeNodeColor() {
            return BNDnodeTheme.nactiveNodeColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor wireSelectColor() {
            return BNDnodeTheme.nwireSelectColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor nodeBackdropColor() {
            return BNDnodeTheme.nnodeBackdropColor(this.address());
        }

        public int noodleCurving() {
            return BNDnodeTheme.nnoodleCurving(this.address());
        }

        public Buffer nodeSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.nnodeSelectedColor(this.address(), param1);
            return this;
        }

        public Buffer nodeSelectedColor(Consumer<NVGColor> param1) {
            param1.accept(this.nodeSelectedColor());
            return this;
        }

        public Buffer wiresColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.nwiresColor(this.address(), param1);
            return this;
        }

        public Buffer wiresColor(Consumer<NVGColor> param1) {
            param1.accept(this.wiresColor());
            return this;
        }

        public Buffer textSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.ntextSelectedColor(this.address(), param1);
            return this;
        }

        public Buffer textSelectedColor(Consumer<NVGColor> param1) {
            param1.accept(this.textSelectedColor());
            return this;
        }

        public Buffer activeNodeColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.nactiveNodeColor(this.address(), param1);
            return this;
        }

        public Buffer activeNodeColor(Consumer<NVGColor> param1) {
            param1.accept(this.activeNodeColor());
            return this;
        }

        public Buffer wireSelectColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.nwireSelectColor(this.address(), param1);
            return this;
        }

        public Buffer wireSelectColor(Consumer<NVGColor> param1) {
            param1.accept(this.wireSelectColor());
            return this;
        }

        public Buffer nodeBackdropColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDnodeTheme.nnodeBackdropColor(this.address(), param1);
            return this;
        }

        public Buffer nodeBackdropColor(Consumer<NVGColor> param1) {
            param1.accept(this.nodeBackdropColor());
            return this;
        }

        public Buffer noodleCurving(int param1) {
            BNDnodeTheme.nnoodleCurving(this.address(), param1);
            return this;
        }
    }
}

