/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class HARDWAREINPUT
extends Struct<HARDWAREINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int UMSG;
    public static final int WPARAML;
    public static final int WPARAMH;

    protected HARDWAREINPUT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected HARDWAREINPUT create(long param1, @Nullable ByteBuffer param3) {
        return new HARDWAREINPUT(param1, param3);
    }

    public HARDWAREINPUT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), HARDWAREINPUT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int uMsg() {
        return HARDWAREINPUT.nuMsg(this.address());
    }

    @NativeType(value="WORD")
    public short wParamL() {
        return HARDWAREINPUT.nwParamL(this.address());
    }

    @NativeType(value="WORD")
    public short wParamH() {
        return HARDWAREINPUT.nwParamH(this.address());
    }

    public HARDWAREINPUT uMsg(@NativeType(value="DWORD") int param1) {
        HARDWAREINPUT.nuMsg(this.address(), param1);
        return this;
    }

    public HARDWAREINPUT wParamL(@NativeType(value="WORD") short param1) {
        HARDWAREINPUT.nwParamL(this.address(), param1);
        return this;
    }

    public HARDWAREINPUT wParamH(@NativeType(value="WORD") short param1) {
        HARDWAREINPUT.nwParamH(this.address(), param1);
        return this;
    }

    public HARDWAREINPUT set(int param1, short param2, short param3) {
        this.uMsg(param1);
        this.wParamL(param2);
        this.wParamH(param3);
        return this;
    }

    public HARDWAREINPUT set(HARDWAREINPUT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static HARDWAREINPUT malloc() {
        return new HARDWAREINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static HARDWAREINPUT calloc() {
        return new HARDWAREINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static HARDWAREINPUT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new HARDWAREINPUT(MemoryUtil.memAddress(v0), v0);
    }

    public static HARDWAREINPUT create(long param0) {
        return new HARDWAREINPUT(param0, null);
    }

    @Nullable
    public static HARDWAREINPUT createSafe(long param0) {
        return param0 == 0L ? null : new HARDWAREINPUT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(HARDWAREINPUT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = HARDWAREINPUT.__create(param0, SIZEOF);
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
    public static HARDWAREINPUT mallocStack() {
        return HARDWAREINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT callocStack() {
        return HARDWAREINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT mallocStack(MemoryStack param0) {
        return HARDWAREINPUT.malloc(param0);
    }

    @Deprecated
    public static HARDWAREINPUT callocStack(MemoryStack param0) {
        return HARDWAREINPUT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return HARDWAREINPUT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return HARDWAREINPUT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return HARDWAREINPUT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return HARDWAREINPUT.calloc(param0, param1);
    }

    public static HARDWAREINPUT malloc(MemoryStack param0) {
        return new HARDWAREINPUT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static HARDWAREINPUT calloc(MemoryStack param0) {
        return new HARDWAREINPUT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nuMsg(long param0) {
        return UNSAFE.getInt(null, param0 + (long)UMSG);
    }

    public static short nwParamL(long param0) {
        return UNSAFE.getShort(null, param0 + (long)WPARAML);
    }

    public static short nwParamH(long param0) {
        return UNSAFE.getShort(null, param0 + (long)WPARAMH);
    }

    public static void nuMsg(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)UMSG, param2);
    }

    public static void nwParamL(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)WPARAML, param2);
    }

    public static void nwParamH(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)WPARAMH, param2);
    }

    static {
        Struct.Layout v0 = HARDWAREINPUT.__struct(HARDWAREINPUT.__member(4), HARDWAREINPUT.__member(2), HARDWAREINPUT.__member(2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        UMSG = v0.offsetof(0);
        WPARAML = v0.offsetof(1);
        WPARAMH = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<HARDWAREINPUT, Buffer>
    implements NativeResource {
        private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);

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
        protected HARDWAREINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int uMsg() {
            return HARDWAREINPUT.nuMsg(this.address());
        }

        @NativeType(value="WORD")
        public short wParamL() {
            return HARDWAREINPUT.nwParamL(this.address());
        }

        @NativeType(value="WORD")
        public short wParamH() {
            return HARDWAREINPUT.nwParamH(this.address());
        }

        public Buffer uMsg(@NativeType(value="DWORD") int param1) {
            HARDWAREINPUT.nuMsg(this.address(), param1);
            return this;
        }

        public Buffer wParamL(@NativeType(value="WORD") short param1) {
            HARDWAREINPUT.nwParamL(this.address(), param1);
            return this;
        }

        public Buffer wParamH(@NativeType(value="WORD") short param1) {
            HARDWAREINPUT.nwParamH(this.address(), param1);
            return this;
        }
    }
}

