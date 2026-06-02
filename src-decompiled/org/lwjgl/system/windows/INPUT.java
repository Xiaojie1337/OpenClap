/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.HARDWAREINPUT;
import org.lwjgl.system.windows.KEYBDINPUT;
import org.lwjgl.system.windows.MOUSEINPUT;

public class INPUT
extends Struct<INPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DUMMYUNIONNAME;
    public static final int DUMMYUNIONNAME_MI;
    public static final int DUMMYUNIONNAME_KI;
    public static final int DUMMYUNIONNAME_HI;

    protected INPUT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected INPUT create(long param1, @Nullable ByteBuffer param3) {
        return new INPUT(param1, param3);
    }

    public INPUT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), INPUT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int type() {
        return INPUT.ntype(this.address());
    }

    public MOUSEINPUT DUMMYUNIONNAME_mi() {
        return INPUT.nDUMMYUNIONNAME_mi(this.address());
    }

    public KEYBDINPUT DUMMYUNIONNAME_ki() {
        return INPUT.nDUMMYUNIONNAME_ki(this.address());
    }

    public HARDWAREINPUT DUMMYUNIONNAME_hi() {
        return INPUT.nDUMMYUNIONNAME_hi(this.address());
    }

    public INPUT type(@NativeType(value="DWORD") int param1) {
        INPUT.ntype(this.address(), param1);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT param1) {
        INPUT.nDUMMYUNIONNAME_mi(this.address(), param1);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> param1) {
        param1.accept(this.DUMMYUNIONNAME_mi());
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT param1) {
        INPUT.nDUMMYUNIONNAME_ki(this.address(), param1);
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> param1) {
        param1.accept(this.DUMMYUNIONNAME_ki());
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT param1) {
        INPUT.nDUMMYUNIONNAME_hi(this.address(), param1);
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> param1) {
        param1.accept(this.DUMMYUNIONNAME_hi());
        return this;
    }

    public INPUT set(INPUT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static INPUT malloc() {
        return new INPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static INPUT calloc() {
        return new INPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static INPUT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new INPUT(MemoryUtil.memAddress(v0), v0);
    }

    public static INPUT create(long param0) {
        return new INPUT(param0, null);
    }

    @Nullable
    public static INPUT createSafe(long param0) {
        return param0 == 0L ? null : new INPUT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(INPUT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = INPUT.__create(param0, SIZEOF);
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
    public static INPUT mallocStack() {
        return INPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT callocStack() {
        return INPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT mallocStack(MemoryStack param0) {
        return INPUT.malloc(param0);
    }

    @Deprecated
    public static INPUT callocStack(MemoryStack param0) {
        return INPUT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return INPUT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return INPUT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return INPUT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return INPUT.calloc(param0, param1);
    }

    public static INPUT malloc(MemoryStack param0) {
        return new INPUT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static INPUT calloc(MemoryStack param0) {
        return new INPUT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ntype(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TYPE);
    }

    public static MOUSEINPUT nDUMMYUNIONNAME_mi(long param0) {
        return MOUSEINPUT.create(param0 + (long)DUMMYUNIONNAME_MI);
    }

    public static KEYBDINPUT nDUMMYUNIONNAME_ki(long param0) {
        return KEYBDINPUT.create(param0 + (long)DUMMYUNIONNAME_KI);
    }

    public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long param0) {
        return HARDWAREINPUT.create(param0 + (long)DUMMYUNIONNAME_HI);
    }

    public static void ntype(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TYPE, param2);
    }

    public static void nDUMMYUNIONNAME_mi(long param0, MOUSEINPUT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_ki(long param0, KEYBDINPUT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_hi(long param0, HARDWAREINPUT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
    }

    static {
        Struct.Layout v0 = INPUT.__struct(INPUT.__member(4), INPUT.__union(INPUT.__member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), INPUT.__member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), INPUT.__member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF)));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        DUMMYUNIONNAME = v0.offsetof(1);
        DUMMYUNIONNAME_MI = v0.offsetof(2);
        DUMMYUNIONNAME_KI = v0.offsetof(3);
        DUMMYUNIONNAME_HI = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<INPUT, Buffer>
    implements NativeResource {
        private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);

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
        protected INPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int type() {
            return INPUT.ntype(this.address());
        }

        public MOUSEINPUT DUMMYUNIONNAME_mi() {
            return INPUT.nDUMMYUNIONNAME_mi(this.address());
        }

        public KEYBDINPUT DUMMYUNIONNAME_ki() {
            return INPUT.nDUMMYUNIONNAME_ki(this.address());
        }

        public HARDWAREINPUT DUMMYUNIONNAME_hi() {
            return INPUT.nDUMMYUNIONNAME_hi(this.address());
        }

        public Buffer type(@NativeType(value="DWORD") int param1) {
            INPUT.ntype(this.address(), param1);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT param1) {
            INPUT.nDUMMYUNIONNAME_mi(this.address(), param1);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> param1) {
            param1.accept(this.DUMMYUNIONNAME_mi());
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT param1) {
            INPUT.nDUMMYUNIONNAME_ki(this.address(), param1);
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> param1) {
            param1.accept(this.DUMMYUNIONNAME_ki());
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT param1) {
            INPUT.nDUMMYUNIONNAME_hi(this.address(), param1);
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> param1) {
            param1.accept(this.DUMMYUNIONNAME_hi());
            return this;
        }
    }
}

