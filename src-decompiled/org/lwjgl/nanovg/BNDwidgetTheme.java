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

public class BNDwidgetTheme
extends Struct<BNDwidgetTheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OUTLINECOLOR;
    public static final int ITEMCOLOR;
    public static final int INNERCOLOR;
    public static final int INNERSELECTEDCOLOR;
    public static final int TEXTCOLOR;
    public static final int TEXTSELECTEDCOLOR;
    public static final int SHADETOP;
    public static final int SHADEDOWN;

    protected BNDwidgetTheme(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected BNDwidgetTheme create(long param1, @Nullable ByteBuffer param3) {
        return new BNDwidgetTheme(param1, param3);
    }

    public BNDwidgetTheme(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), BNDwidgetTheme.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor outlineColor() {
        return BNDwidgetTheme.noutlineColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor itemColor() {
        return BNDwidgetTheme.nitemColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerColor() {
        return BNDwidgetTheme.ninnerColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerSelectedColor() {
        return BNDwidgetTheme.ninnerSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textColor() {
        return BNDwidgetTheme.ntextColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textSelectedColor() {
        return BNDwidgetTheme.ntextSelectedColor(this.address());
    }

    public int shadeTop() {
        return BNDwidgetTheme.nshadeTop(this.address());
    }

    public int shadeDown() {
        return BNDwidgetTheme.nshadeDown(this.address());
    }

    public BNDwidgetTheme outlineColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.noutlineColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme outlineColor(Consumer<NVGColor> param1) {
        param1.accept(this.outlineColor());
        return this;
    }

    public BNDwidgetTheme itemColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.nitemColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme itemColor(Consumer<NVGColor> param1) {
        param1.accept(this.itemColor());
        return this;
    }

    public BNDwidgetTheme innerColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.ninnerColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme innerColor(Consumer<NVGColor> param1) {
        param1.accept(this.innerColor());
        return this;
    }

    public BNDwidgetTheme innerSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.ninnerSelectedColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme innerSelectedColor(Consumer<NVGColor> param1) {
        param1.accept(this.innerSelectedColor());
        return this;
    }

    public BNDwidgetTheme textColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.ntextColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme textColor(Consumer<NVGColor> param1) {
        param1.accept(this.textColor());
        return this;
    }

    public BNDwidgetTheme textSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDwidgetTheme.ntextSelectedColor(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme textSelectedColor(Consumer<NVGColor> param1) {
        param1.accept(this.textSelectedColor());
        return this;
    }

    public BNDwidgetTheme shadeTop(int param1) {
        BNDwidgetTheme.nshadeTop(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme shadeDown(int param1) {
        BNDwidgetTheme.nshadeDown(this.address(), param1);
        return this;
    }

    public BNDwidgetTheme set(NVGColor param1, NVGColor param2, NVGColor param3, NVGColor param4, NVGColor param5, NVGColor param6, int param7, int param8) {
        this.outlineColor(param1);
        this.itemColor(param2);
        this.innerColor(param3);
        this.innerSelectedColor(param4);
        this.textColor(param5);
        this.textSelectedColor(param6);
        this.shadeTop(param7);
        this.shadeDown(param8);
        return this;
    }

    public BNDwidgetTheme set(BNDwidgetTheme param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDwidgetTheme malloc() {
        return new BNDwidgetTheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDwidgetTheme calloc() {
        return new BNDwidgetTheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDwidgetTheme create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDwidgetTheme(MemoryUtil.memAddress(v0), v0);
    }

    public static BNDwidgetTheme create(long param0) {
        return new BNDwidgetTheme(param0, null);
    }

    @Nullable
    public static BNDwidgetTheme createSafe(long param0) {
        return param0 == 0L ? null : new BNDwidgetTheme(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDwidgetTheme.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = BNDwidgetTheme.__create(param0, SIZEOF);
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
    public static BNDwidgetTheme mallocStack() {
        return BNDwidgetTheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDwidgetTheme callocStack() {
        return BNDwidgetTheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDwidgetTheme mallocStack(MemoryStack param0) {
        return BNDwidgetTheme.malloc(param0);
    }

    @Deprecated
    public static BNDwidgetTheme callocStack(MemoryStack param0) {
        return BNDwidgetTheme.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return BNDwidgetTheme.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return BNDwidgetTheme.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return BNDwidgetTheme.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return BNDwidgetTheme.calloc(param0, param1);
    }

    public static BNDwidgetTheme malloc(MemoryStack param0) {
        return new BNDwidgetTheme(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDwidgetTheme calloc(MemoryStack param0) {
        return new BNDwidgetTheme(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static NVGColor noutlineColor(long param0) {
        return NVGColor.create(param0 + (long)OUTLINECOLOR);
    }

    public static NVGColor nitemColor(long param0) {
        return NVGColor.create(param0 + (long)ITEMCOLOR);
    }

    public static NVGColor ninnerColor(long param0) {
        return NVGColor.create(param0 + (long)INNERCOLOR);
    }

    public static NVGColor ninnerSelectedColor(long param0) {
        return NVGColor.create(param0 + (long)INNERSELECTEDCOLOR);
    }

    public static NVGColor ntextColor(long param0) {
        return NVGColor.create(param0 + (long)TEXTCOLOR);
    }

    public static NVGColor ntextSelectedColor(long param0) {
        return NVGColor.create(param0 + (long)TEXTSELECTEDCOLOR);
    }

    public static int nshadeTop(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SHADETOP);
    }

    public static int nshadeDown(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SHADEDOWN);
    }

    public static void noutlineColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)OUTLINECOLOR, NVGColor.SIZEOF);
    }

    public static void nitemColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)ITEMCOLOR, NVGColor.SIZEOF);
    }

    public static void ninnerColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)INNERCOLOR, NVGColor.SIZEOF);
    }

    public static void ninnerSelectedColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)INNERSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TEXTCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextSelectedColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TEXTSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nshadeTop(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SHADETOP, param2);
    }

    public static void nshadeDown(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SHADEDOWN, param2);
    }

    static {
        Struct.Layout v0 = BNDwidgetTheme.__struct(BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(4), BNDwidgetTheme.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OUTLINECOLOR = v0.offsetof(0);
        ITEMCOLOR = v0.offsetof(1);
        INNERCOLOR = v0.offsetof(2);
        INNERSELECTEDCOLOR = v0.offsetof(3);
        TEXTCOLOR = v0.offsetof(4);
        TEXTSELECTEDCOLOR = v0.offsetof(5);
        SHADETOP = v0.offsetof(6);
        SHADEDOWN = v0.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<BNDwidgetTheme, Buffer>
    implements NativeResource {
        private static final BNDwidgetTheme ELEMENT_FACTORY = BNDwidgetTheme.create(-1L);

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
        protected BNDwidgetTheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor outlineColor() {
            return BNDwidgetTheme.noutlineColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor itemColor() {
            return BNDwidgetTheme.nitemColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerColor() {
            return BNDwidgetTheme.ninnerColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerSelectedColor() {
            return BNDwidgetTheme.ninnerSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textColor() {
            return BNDwidgetTheme.ntextColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textSelectedColor() {
            return BNDwidgetTheme.ntextSelectedColor(this.address());
        }

        public int shadeTop() {
            return BNDwidgetTheme.nshadeTop(this.address());
        }

        public int shadeDown() {
            return BNDwidgetTheme.nshadeDown(this.address());
        }

        public Buffer outlineColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.noutlineColor(this.address(), param1);
            return this;
        }

        public Buffer outlineColor(Consumer<NVGColor> param1) {
            param1.accept(this.outlineColor());
            return this;
        }

        public Buffer itemColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.nitemColor(this.address(), param1);
            return this;
        }

        public Buffer itemColor(Consumer<NVGColor> param1) {
            param1.accept(this.itemColor());
            return this;
        }

        public Buffer innerColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.ninnerColor(this.address(), param1);
            return this;
        }

        public Buffer innerColor(Consumer<NVGColor> param1) {
            param1.accept(this.innerColor());
            return this;
        }

        public Buffer innerSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.ninnerSelectedColor(this.address(), param1);
            return this;
        }

        public Buffer innerSelectedColor(Consumer<NVGColor> param1) {
            param1.accept(this.innerSelectedColor());
            return this;
        }

        public Buffer textColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.ntextColor(this.address(), param1);
            return this;
        }

        public Buffer textColor(Consumer<NVGColor> param1) {
            param1.accept(this.textColor());
            return this;
        }

        public Buffer textSelectedColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDwidgetTheme.ntextSelectedColor(this.address(), param1);
            return this;
        }

        public Buffer textSelectedColor(Consumer<NVGColor> param1) {
            param1.accept(this.textSelectedColor());
            return this;
        }

        public Buffer shadeTop(int param1) {
            BNDwidgetTheme.nshadeTop(this.address(), param1);
            return this;
        }

        public Buffer shadeDown(int param1) {
            BNDwidgetTheme.nshadeDown(this.address(), param1);
            return this;
        }
    }
}

