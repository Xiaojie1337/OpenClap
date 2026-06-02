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
import org.lwjgl.nanovg.BNDnodeTheme;
import org.lwjgl.nanovg.BNDwidgetTheme;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class BNDtheme
extends Struct<BNDtheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUNDCOLOR;
    public static final int REGULARTHEME;
    public static final int TOOLTHEME;
    public static final int RADIOTHEME;
    public static final int TEXTFIELDTHEME;
    public static final int OPTIONTHEME;
    public static final int CHOICETHEME;
    public static final int NUMBERFIELDTHEME;
    public static final int SLIDERTHEME;
    public static final int SCROLLBARTHEME;
    public static final int TOOLTIPTHEME;
    public static final int MENUTHEME;
    public static final int MENUITEMTHEME;
    public static final int NODETHEME;

    protected BNDtheme(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected BNDtheme create(long param1, @Nullable ByteBuffer param3) {
        return new BNDtheme(param1, param3);
    }

    public BNDtheme(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), BNDtheme.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor backgroundColor() {
        return BNDtheme.nbackgroundColor(this.address());
    }

    public BNDwidgetTheme regularTheme() {
        return BNDtheme.nregularTheme(this.address());
    }

    public BNDwidgetTheme toolTheme() {
        return BNDtheme.ntoolTheme(this.address());
    }

    public BNDwidgetTheme radioTheme() {
        return BNDtheme.nradioTheme(this.address());
    }

    public BNDwidgetTheme textFieldTheme() {
        return BNDtheme.ntextFieldTheme(this.address());
    }

    public BNDwidgetTheme optionTheme() {
        return BNDtheme.noptionTheme(this.address());
    }

    public BNDwidgetTheme choiceTheme() {
        return BNDtheme.nchoiceTheme(this.address());
    }

    public BNDwidgetTheme numberFieldTheme() {
        return BNDtheme.nnumberFieldTheme(this.address());
    }

    public BNDwidgetTheme sliderTheme() {
        return BNDtheme.nsliderTheme(this.address());
    }

    public BNDwidgetTheme scrollBarTheme() {
        return BNDtheme.nscrollBarTheme(this.address());
    }

    public BNDwidgetTheme tooltipTheme() {
        return BNDtheme.ntooltipTheme(this.address());
    }

    public BNDwidgetTheme menuTheme() {
        return BNDtheme.nmenuTheme(this.address());
    }

    public BNDwidgetTheme menuItemTheme() {
        return BNDtheme.nmenuItemTheme(this.address());
    }

    public BNDnodeTheme nodeTheme() {
        return BNDtheme.nnodeTheme(this.address());
    }

    public BNDtheme backgroundColor(@NativeType(value="NVGcolor") NVGColor param1) {
        BNDtheme.nbackgroundColor(this.address(), param1);
        return this;
    }

    public BNDtheme backgroundColor(Consumer<NVGColor> param1) {
        param1.accept(this.backgroundColor());
        return this;
    }

    public BNDtheme regularTheme(BNDwidgetTheme param1) {
        BNDtheme.nregularTheme(this.address(), param1);
        return this;
    }

    public BNDtheme regularTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.regularTheme());
        return this;
    }

    public BNDtheme toolTheme(BNDwidgetTheme param1) {
        BNDtheme.ntoolTheme(this.address(), param1);
        return this;
    }

    public BNDtheme toolTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.toolTheme());
        return this;
    }

    public BNDtheme radioTheme(BNDwidgetTheme param1) {
        BNDtheme.nradioTheme(this.address(), param1);
        return this;
    }

    public BNDtheme radioTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.radioTheme());
        return this;
    }

    public BNDtheme textFieldTheme(BNDwidgetTheme param1) {
        BNDtheme.ntextFieldTheme(this.address(), param1);
        return this;
    }

    public BNDtheme textFieldTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.textFieldTheme());
        return this;
    }

    public BNDtheme optionTheme(BNDwidgetTheme param1) {
        BNDtheme.noptionTheme(this.address(), param1);
        return this;
    }

    public BNDtheme optionTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.optionTheme());
        return this;
    }

    public BNDtheme choiceTheme(BNDwidgetTheme param1) {
        BNDtheme.nchoiceTheme(this.address(), param1);
        return this;
    }

    public BNDtheme choiceTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.choiceTheme());
        return this;
    }

    public BNDtheme numberFieldTheme(BNDwidgetTheme param1) {
        BNDtheme.nnumberFieldTheme(this.address(), param1);
        return this;
    }

    public BNDtheme numberFieldTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.numberFieldTheme());
        return this;
    }

    public BNDtheme sliderTheme(BNDwidgetTheme param1) {
        BNDtheme.nsliderTheme(this.address(), param1);
        return this;
    }

    public BNDtheme sliderTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.sliderTheme());
        return this;
    }

    public BNDtheme scrollBarTheme(BNDwidgetTheme param1) {
        BNDtheme.nscrollBarTheme(this.address(), param1);
        return this;
    }

    public BNDtheme scrollBarTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.scrollBarTheme());
        return this;
    }

    public BNDtheme tooltipTheme(BNDwidgetTheme param1) {
        BNDtheme.ntooltipTheme(this.address(), param1);
        return this;
    }

    public BNDtheme tooltipTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.tooltipTheme());
        return this;
    }

    public BNDtheme menuTheme(BNDwidgetTheme param1) {
        BNDtheme.nmenuTheme(this.address(), param1);
        return this;
    }

    public BNDtheme menuTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.menuTheme());
        return this;
    }

    public BNDtheme menuItemTheme(BNDwidgetTheme param1) {
        BNDtheme.nmenuItemTheme(this.address(), param1);
        return this;
    }

    public BNDtheme menuItemTheme(Consumer<BNDwidgetTheme> param1) {
        param1.accept(this.menuItemTheme());
        return this;
    }

    public BNDtheme nodeTheme(BNDnodeTheme param1) {
        BNDtheme.nnodeTheme(this.address(), param1);
        return this;
    }

    public BNDtheme nodeTheme(Consumer<BNDnodeTheme> param1) {
        param1.accept(this.nodeTheme());
        return this;
    }

    public BNDtheme set(NVGColor param1, BNDwidgetTheme param2, BNDwidgetTheme param3, BNDwidgetTheme param4, BNDwidgetTheme param5, BNDwidgetTheme param6, BNDwidgetTheme param7, BNDwidgetTheme param8, BNDwidgetTheme param9, BNDwidgetTheme param10, BNDwidgetTheme param11, BNDwidgetTheme param12, BNDwidgetTheme param13, BNDnodeTheme param14) {
        this.backgroundColor(param1);
        this.regularTheme(param2);
        this.toolTheme(param3);
        this.radioTheme(param4);
        this.textFieldTheme(param5);
        this.optionTheme(param6);
        this.choiceTheme(param7);
        this.numberFieldTheme(param8);
        this.sliderTheme(param9);
        this.scrollBarTheme(param10);
        this.tooltipTheme(param11);
        this.menuTheme(param12);
        this.menuItemTheme(param13);
        this.nodeTheme(param14);
        return this;
    }

    public BNDtheme set(BNDtheme param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDtheme malloc() {
        return new BNDtheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDtheme calloc() {
        return new BNDtheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDtheme create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDtheme(MemoryUtil.memAddress(v0), v0);
    }

    public static BNDtheme create(long param0) {
        return new BNDtheme(param0, null);
    }

    @Nullable
    public static BNDtheme createSafe(long param0) {
        return param0 == 0L ? null : new BNDtheme(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDtheme.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = BNDtheme.__create(param0, SIZEOF);
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
    public static BNDtheme mallocStack() {
        return BNDtheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDtheme callocStack() {
        return BNDtheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDtheme mallocStack(MemoryStack param0) {
        return BNDtheme.malloc(param0);
    }

    @Deprecated
    public static BNDtheme callocStack(MemoryStack param0) {
        return BNDtheme.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return BNDtheme.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return BNDtheme.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return BNDtheme.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return BNDtheme.calloc(param0, param1);
    }

    public static BNDtheme malloc(MemoryStack param0) {
        return new BNDtheme(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDtheme calloc(MemoryStack param0) {
        return new BNDtheme(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static NVGColor nbackgroundColor(long param0) {
        return NVGColor.create(param0 + (long)BACKGROUNDCOLOR);
    }

    public static BNDwidgetTheme nregularTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)REGULARTHEME);
    }

    public static BNDwidgetTheme ntoolTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)TOOLTHEME);
    }

    public static BNDwidgetTheme nradioTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)RADIOTHEME);
    }

    public static BNDwidgetTheme ntextFieldTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)TEXTFIELDTHEME);
    }

    public static BNDwidgetTheme noptionTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)OPTIONTHEME);
    }

    public static BNDwidgetTheme nchoiceTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)CHOICETHEME);
    }

    public static BNDwidgetTheme nnumberFieldTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)NUMBERFIELDTHEME);
    }

    public static BNDwidgetTheme nsliderTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)SLIDERTHEME);
    }

    public static BNDwidgetTheme nscrollBarTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)SCROLLBARTHEME);
    }

    public static BNDwidgetTheme ntooltipTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)TOOLTIPTHEME);
    }

    public static BNDwidgetTheme nmenuTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)MENUTHEME);
    }

    public static BNDwidgetTheme nmenuItemTheme(long param0) {
        return BNDwidgetTheme.create(param0 + (long)MENUITEMTHEME);
    }

    public static BNDnodeTheme nnodeTheme(long param0) {
        return BNDnodeTheme.create(param0 + (long)NODETHEME);
    }

    public static void nbackgroundColor(long param0, NVGColor param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)BACKGROUNDCOLOR, NVGColor.SIZEOF);
    }

    public static void nregularTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)REGULARTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntoolTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TOOLTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nradioTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)RADIOTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntextFieldTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TEXTFIELDTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void noptionTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)OPTIONTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nchoiceTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)CHOICETHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nnumberFieldTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)NUMBERFIELDTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nsliderTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)SLIDERTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nscrollBarTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)SCROLLBARTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntooltipTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)TOOLTIPTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nmenuTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)MENUTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nmenuItemTheme(long param0, BNDwidgetTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)MENUITEMTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nnodeTheme(long param0, BNDnodeTheme param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)NODETHEME, BNDnodeTheme.SIZEOF);
    }

    static {
        Struct.Layout v0 = BNDtheme.__struct(BNDtheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDnodeTheme.SIZEOF, BNDnodeTheme.ALIGNOF));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        BACKGROUNDCOLOR = v0.offsetof(0);
        REGULARTHEME = v0.offsetof(1);
        TOOLTHEME = v0.offsetof(2);
        RADIOTHEME = v0.offsetof(3);
        TEXTFIELDTHEME = v0.offsetof(4);
        OPTIONTHEME = v0.offsetof(5);
        CHOICETHEME = v0.offsetof(6);
        NUMBERFIELDTHEME = v0.offsetof(7);
        SLIDERTHEME = v0.offsetof(8);
        SCROLLBARTHEME = v0.offsetof(9);
        TOOLTIPTHEME = v0.offsetof(10);
        MENUTHEME = v0.offsetof(11);
        MENUITEMTHEME = v0.offsetof(12);
        NODETHEME = v0.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<BNDtheme, Buffer>
    implements NativeResource {
        private static final BNDtheme ELEMENT_FACTORY = BNDtheme.create(-1L);

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
        protected BNDtheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor backgroundColor() {
            return BNDtheme.nbackgroundColor(this.address());
        }

        public BNDwidgetTheme regularTheme() {
            return BNDtheme.nregularTheme(this.address());
        }

        public BNDwidgetTheme toolTheme() {
            return BNDtheme.ntoolTheme(this.address());
        }

        public BNDwidgetTheme radioTheme() {
            return BNDtheme.nradioTheme(this.address());
        }

        public BNDwidgetTheme textFieldTheme() {
            return BNDtheme.ntextFieldTheme(this.address());
        }

        public BNDwidgetTheme optionTheme() {
            return BNDtheme.noptionTheme(this.address());
        }

        public BNDwidgetTheme choiceTheme() {
            return BNDtheme.nchoiceTheme(this.address());
        }

        public BNDwidgetTheme numberFieldTheme() {
            return BNDtheme.nnumberFieldTheme(this.address());
        }

        public BNDwidgetTheme sliderTheme() {
            return BNDtheme.nsliderTheme(this.address());
        }

        public BNDwidgetTheme scrollBarTheme() {
            return BNDtheme.nscrollBarTheme(this.address());
        }

        public BNDwidgetTheme tooltipTheme() {
            return BNDtheme.ntooltipTheme(this.address());
        }

        public BNDwidgetTheme menuTheme() {
            return BNDtheme.nmenuTheme(this.address());
        }

        public BNDwidgetTheme menuItemTheme() {
            return BNDtheme.nmenuItemTheme(this.address());
        }

        public BNDnodeTheme nodeTheme() {
            return BNDtheme.nnodeTheme(this.address());
        }

        public Buffer backgroundColor(@NativeType(value="NVGcolor") NVGColor param1) {
            BNDtheme.nbackgroundColor(this.address(), param1);
            return this;
        }

        public Buffer backgroundColor(Consumer<NVGColor> param1) {
            param1.accept(this.backgroundColor());
            return this;
        }

        public Buffer regularTheme(BNDwidgetTheme param1) {
            BNDtheme.nregularTheme(this.address(), param1);
            return this;
        }

        public Buffer regularTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.regularTheme());
            return this;
        }

        public Buffer toolTheme(BNDwidgetTheme param1) {
            BNDtheme.ntoolTheme(this.address(), param1);
            return this;
        }

        public Buffer toolTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.toolTheme());
            return this;
        }

        public Buffer radioTheme(BNDwidgetTheme param1) {
            BNDtheme.nradioTheme(this.address(), param1);
            return this;
        }

        public Buffer radioTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.radioTheme());
            return this;
        }

        public Buffer textFieldTheme(BNDwidgetTheme param1) {
            BNDtheme.ntextFieldTheme(this.address(), param1);
            return this;
        }

        public Buffer textFieldTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.textFieldTheme());
            return this;
        }

        public Buffer optionTheme(BNDwidgetTheme param1) {
            BNDtheme.noptionTheme(this.address(), param1);
            return this;
        }

        public Buffer optionTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.optionTheme());
            return this;
        }

        public Buffer choiceTheme(BNDwidgetTheme param1) {
            BNDtheme.nchoiceTheme(this.address(), param1);
            return this;
        }

        public Buffer choiceTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.choiceTheme());
            return this;
        }

        public Buffer numberFieldTheme(BNDwidgetTheme param1) {
            BNDtheme.nnumberFieldTheme(this.address(), param1);
            return this;
        }

        public Buffer numberFieldTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.numberFieldTheme());
            return this;
        }

        public Buffer sliderTheme(BNDwidgetTheme param1) {
            BNDtheme.nsliderTheme(this.address(), param1);
            return this;
        }

        public Buffer sliderTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.sliderTheme());
            return this;
        }

        public Buffer scrollBarTheme(BNDwidgetTheme param1) {
            BNDtheme.nscrollBarTheme(this.address(), param1);
            return this;
        }

        public Buffer scrollBarTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.scrollBarTheme());
            return this;
        }

        public Buffer tooltipTheme(BNDwidgetTheme param1) {
            BNDtheme.ntooltipTheme(this.address(), param1);
            return this;
        }

        public Buffer tooltipTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.tooltipTheme());
            return this;
        }

        public Buffer menuTheme(BNDwidgetTheme param1) {
            BNDtheme.nmenuTheme(this.address(), param1);
            return this;
        }

        public Buffer menuTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.menuTheme());
            return this;
        }

        public Buffer menuItemTheme(BNDwidgetTheme param1) {
            BNDtheme.nmenuItemTheme(this.address(), param1);
            return this;
        }

        public Buffer menuItemTheme(Consumer<BNDwidgetTheme> param1) {
            param1.accept(this.menuItemTheme());
            return this;
        }

        public Buffer nodeTheme(BNDnodeTheme param1) {
            BNDtheme.nnodeTheme(this.address(), param1);
            return this;
        }

        public Buffer nodeTheme(Consumer<BNDnodeTheme> param1) {
            param1.accept(this.nodeTheme());
            return this;
        }
    }
}

