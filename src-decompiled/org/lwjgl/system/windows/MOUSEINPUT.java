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

public class MOUSEINPUT
extends Struct<MOUSEINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DX;
    public static final int DY;
    public static final int MOUSEDATA;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    protected MOUSEINPUT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected MOUSEINPUT create(long param1, @Nullable ByteBuffer param3) {
        return new MOUSEINPUT(param1, param3);
    }

    public MOUSEINPUT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), MOUSEINPUT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int dx() {
        return MOUSEINPUT.ndx(this.address());
    }

    @NativeType(value="LONG")
    public int dy() {
        return MOUSEINPUT.ndy(this.address());
    }

    @NativeType(value="DWORD")
    public int mouseData() {
        return MOUSEINPUT.nmouseData(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MOUSEINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MOUSEINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return MOUSEINPUT.ndwExtraInfo(this.address());
    }

    public MOUSEINPUT dx(@NativeType(value="LONG") int param1) {
        MOUSEINPUT.ndx(this.address(), param1);
        return this;
    }

    public MOUSEINPUT dy(@NativeType(value="LONG") int param1) {
        MOUSEINPUT.ndy(this.address(), param1);
        return this;
    }

    public MOUSEINPUT mouseData(@NativeType(value="DWORD") int param1) {
        MOUSEINPUT.nmouseData(this.address(), param1);
        return this;
    }

    public MOUSEINPUT dwFlags(@NativeType(value="DWORD") int param1) {
        MOUSEINPUT.ndwFlags(this.address(), param1);
        return this;
    }

    public MOUSEINPUT time(@NativeType(value="DWORD") int param1) {
        MOUSEINPUT.ntime(this.address(), param1);
        return this;
    }

    public MOUSEINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long param1) {
        MOUSEINPUT.ndwExtraInfo(this.address(), param1);
        return this;
    }

    public MOUSEINPUT set(int param1, int param2, int param3, int param4, int param5, long param6) {
        this.dx(param1);
        this.dy(param2);
        this.mouseData(param3);
        this.dwFlags(param4);
        this.time(param5);
        this.dwExtraInfo(param6);
        return this;
    }

    public MOUSEINPUT set(MOUSEINPUT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static MOUSEINPUT malloc() {
        return new MOUSEINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MOUSEINPUT calloc() {
        return new MOUSEINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MOUSEINPUT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new MOUSEINPUT(MemoryUtil.memAddress(v0), v0);
    }

    public static MOUSEINPUT create(long param0) {
        return new MOUSEINPUT(param0, null);
    }

    @Nullable
    public static MOUSEINPUT createSafe(long param0) {
        return param0 == 0L ? null : new MOUSEINPUT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MOUSEINPUT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = MOUSEINPUT.__create(param0, SIZEOF);
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
    public static MOUSEINPUT mallocStack() {
        return MOUSEINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT callocStack() {
        return MOUSEINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT mallocStack(MemoryStack param0) {
        return MOUSEINPUT.malloc(param0);
    }

    @Deprecated
    public static MOUSEINPUT callocStack(MemoryStack param0) {
        return MOUSEINPUT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return MOUSEINPUT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return MOUSEINPUT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return MOUSEINPUT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return MOUSEINPUT.calloc(param0, param1);
    }

    public static MOUSEINPUT malloc(MemoryStack param0) {
        return new MOUSEINPUT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MOUSEINPUT calloc(MemoryStack param0) {
        return new MOUSEINPUT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ndx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DX);
    }

    public static int ndy(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DY);
    }

    public static int nmouseData(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MOUSEDATA);
    }

    public static int ndwFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWFLAGS);
    }

    public static int ntime(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TIME);
    }

    public static long ndwExtraInfo(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)DWEXTRAINFO);
    }

    public static void ndx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DX, param2);
    }

    public static void ndy(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DY, param2);
    }

    public static void nmouseData(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MOUSEDATA, param2);
    }

    public static void ndwFlags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWFLAGS, param2);
    }

    public static void ntime(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TIME, param2);
    }

    public static void ndwExtraInfo(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)DWEXTRAINFO, param2);
    }

    static {
        Struct.Layout v0 = MOUSEINPUT.__struct(MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        DX = v0.offsetof(0);
        DY = v0.offsetof(1);
        MOUSEDATA = v0.offsetof(2);
        DWFLAGS = v0.offsetof(3);
        TIME = v0.offsetof(4);
        DWEXTRAINFO = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MOUSEINPUT, Buffer>
    implements NativeResource {
        private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);

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
        protected MOUSEINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int dx() {
            return MOUSEINPUT.ndx(this.address());
        }

        @NativeType(value="LONG")
        public int dy() {
            return MOUSEINPUT.ndy(this.address());
        }

        @NativeType(value="DWORD")
        public int mouseData() {
            return MOUSEINPUT.nmouseData(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MOUSEINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MOUSEINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return MOUSEINPUT.ndwExtraInfo(this.address());
        }

        public Buffer dx(@NativeType(value="LONG") int param1) {
            MOUSEINPUT.ndx(this.address(), param1);
            return this;
        }

        public Buffer dy(@NativeType(value="LONG") int param1) {
            MOUSEINPUT.ndy(this.address(), param1);
            return this;
        }

        public Buffer mouseData(@NativeType(value="DWORD") int param1) {
            MOUSEINPUT.nmouseData(this.address(), param1);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int param1) {
            MOUSEINPUT.ndwFlags(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int param1) {
            MOUSEINPUT.ntime(this.address(), param1);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long param1) {
            MOUSEINPUT.ndwExtraInfo(this.address(), param1);
            return this;
        }
    }
}

