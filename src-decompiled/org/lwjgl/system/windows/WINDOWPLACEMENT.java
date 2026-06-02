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
import org.lwjgl.system.windows.POINT;
import org.lwjgl.system.windows.RECT;

public class WINDOWPLACEMENT
extends Struct<WINDOWPLACEMENT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LENGTH;
    public static final int FLAGS;
    public static final int SHOWCMD;
    public static final int PTMINPOSITION;
    public static final int PTMAXPOSITION;
    public static final int RCNORMALPOSITION;

    protected WINDOWPLACEMENT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected WINDOWPLACEMENT create(long param1, @Nullable ByteBuffer param3) {
        return new WINDOWPLACEMENT(param1, param3);
    }

    public WINDOWPLACEMENT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), WINDOWPLACEMENT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int length() {
        return WINDOWPLACEMENT.nlength(this.address());
    }

    @NativeType(value="UINT")
    public int flags() {
        return WINDOWPLACEMENT.nflags(this.address());
    }

    @NativeType(value="UINT")
    public int showCmd() {
        return WINDOWPLACEMENT.nshowCmd(this.address());
    }

    public POINT ptMinPosition() {
        return WINDOWPLACEMENT.nptMinPosition(this.address());
    }

    public POINT ptMaxPosition() {
        return WINDOWPLACEMENT.nptMaxPosition(this.address());
    }

    public RECT rcNormalPosition() {
        return WINDOWPLACEMENT.nrcNormalPosition(this.address());
    }

    public WINDOWPLACEMENT length(@NativeType(value="UINT") int param1) {
        WINDOWPLACEMENT.nlength(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT flags(@NativeType(value="UINT") int param1) {
        WINDOWPLACEMENT.nflags(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT showCmd(@NativeType(value="UINT") int param1) {
        WINDOWPLACEMENT.nshowCmd(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(POINT param1) {
        WINDOWPLACEMENT.nptMinPosition(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(Consumer<POINT> param1) {
        param1.accept(this.ptMinPosition());
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(POINT param1) {
        WINDOWPLACEMENT.nptMaxPosition(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(Consumer<POINT> param1) {
        param1.accept(this.ptMaxPosition());
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(RECT param1) {
        WINDOWPLACEMENT.nrcNormalPosition(this.address(), param1);
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(Consumer<RECT> param1) {
        param1.accept(this.rcNormalPosition());
        return this;
    }

    public WINDOWPLACEMENT set(int param1, int param2, int param3, POINT param4, POINT param5, RECT param6) {
        this.length(param1);
        this.flags(param2);
        this.showCmd(param3);
        this.ptMinPosition(param4);
        this.ptMaxPosition(param5);
        this.rcNormalPosition(param6);
        return this;
    }

    public WINDOWPLACEMENT set(WINDOWPLACEMENT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static WINDOWPLACEMENT malloc() {
        return new WINDOWPLACEMENT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static WINDOWPLACEMENT calloc() {
        return new WINDOWPLACEMENT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static WINDOWPLACEMENT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new WINDOWPLACEMENT(MemoryUtil.memAddress(v0), v0);
    }

    public static WINDOWPLACEMENT create(long param0) {
        return new WINDOWPLACEMENT(param0, null);
    }

    @Nullable
    public static WINDOWPLACEMENT createSafe(long param0) {
        return param0 == 0L ? null : new WINDOWPLACEMENT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(WINDOWPLACEMENT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = WINDOWPLACEMENT.__create(param0, SIZEOF);
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
    public static WINDOWPLACEMENT mallocStack() {
        return WINDOWPLACEMENT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack() {
        return WINDOWPLACEMENT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT mallocStack(MemoryStack param0) {
        return WINDOWPLACEMENT.malloc(param0);
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack(MemoryStack param0) {
        return WINDOWPLACEMENT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return WINDOWPLACEMENT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return WINDOWPLACEMENT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return WINDOWPLACEMENT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return WINDOWPLACEMENT.calloc(param0, param1);
    }

    public static WINDOWPLACEMENT malloc(MemoryStack param0) {
        return new WINDOWPLACEMENT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static WINDOWPLACEMENT calloc(MemoryStack param0) {
        return new WINDOWPLACEMENT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nlength(long param0) {
        return UNSAFE.getInt(null, param0 + (long)LENGTH);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    public static int nshowCmd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SHOWCMD);
    }

    public static POINT nptMinPosition(long param0) {
        return POINT.create(param0 + (long)PTMINPOSITION);
    }

    public static POINT nptMaxPosition(long param0) {
        return POINT.create(param0 + (long)PTMAXPOSITION);
    }

    public static RECT nrcNormalPosition(long param0) {
        return RECT.create(param0 + (long)RCNORMALPOSITION);
    }

    public static void nlength(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)LENGTH, param2);
    }

    public static void nflags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FLAGS, param2);
    }

    public static void nshowCmd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SHOWCMD, param2);
    }

    public static void nptMinPosition(long param0, POINT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)PTMINPOSITION, POINT.SIZEOF);
    }

    public static void nptMaxPosition(long param0, POINT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)PTMAXPOSITION, POINT.SIZEOF);
    }

    public static void nrcNormalPosition(long param0, RECT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)RCNORMALPOSITION, RECT.SIZEOF);
    }

    static {
        Struct.Layout v0 = WINDOWPLACEMENT.__struct(WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(RECT.SIZEOF, RECT.ALIGNOF));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        LENGTH = v0.offsetof(0);
        FLAGS = v0.offsetof(1);
        SHOWCMD = v0.offsetof(2);
        PTMINPOSITION = v0.offsetof(3);
        PTMAXPOSITION = v0.offsetof(4);
        RCNORMALPOSITION = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<WINDOWPLACEMENT, Buffer>
    implements NativeResource {
        private static final WINDOWPLACEMENT ELEMENT_FACTORY = WINDOWPLACEMENT.create(-1L);

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
        protected WINDOWPLACEMENT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int length() {
            return WINDOWPLACEMENT.nlength(this.address());
        }

        @NativeType(value="UINT")
        public int flags() {
            return WINDOWPLACEMENT.nflags(this.address());
        }

        @NativeType(value="UINT")
        public int showCmd() {
            return WINDOWPLACEMENT.nshowCmd(this.address());
        }

        public POINT ptMinPosition() {
            return WINDOWPLACEMENT.nptMinPosition(this.address());
        }

        public POINT ptMaxPosition() {
            return WINDOWPLACEMENT.nptMaxPosition(this.address());
        }

        public RECT rcNormalPosition() {
            return WINDOWPLACEMENT.nrcNormalPosition(this.address());
        }

        public Buffer length(@NativeType(value="UINT") int param1) {
            WINDOWPLACEMENT.nlength(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="UINT") int param1) {
            WINDOWPLACEMENT.nflags(this.address(), param1);
            return this;
        }

        public Buffer showCmd(@NativeType(value="UINT") int param1) {
            WINDOWPLACEMENT.nshowCmd(this.address(), param1);
            return this;
        }

        public Buffer ptMinPosition(POINT param1) {
            WINDOWPLACEMENT.nptMinPosition(this.address(), param1);
            return this;
        }

        public Buffer ptMinPosition(Consumer<POINT> param1) {
            param1.accept(this.ptMinPosition());
            return this;
        }

        public Buffer ptMaxPosition(POINT param1) {
            WINDOWPLACEMENT.nptMaxPosition(this.address(), param1);
            return this;
        }

        public Buffer ptMaxPosition(Consumer<POINT> param1) {
            param1.accept(this.ptMaxPosition());
            return this;
        }

        public Buffer rcNormalPosition(RECT param1) {
            WINDOWPLACEMENT.nrcNormalPosition(this.address(), param1);
            return this;
        }

        public Buffer rcNormalPosition(Consumer<RECT> param1) {
            param1.accept(this.rcNormalPosition());
            return this;
        }
    }
}

