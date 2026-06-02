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

public class TOUCHINPUT
extends Struct<TOUCHINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X;
    public static final int Y;
    public static final int HSOURCE;
    public static final int DWID;
    public static final int DWFLAGS;
    public static final int DWMASK;
    public static final int DWTIME;
    public static final int DWEXTRAINFO;
    public static final int CXCONTACT;
    public static final int CYCONTACT;

    protected TOUCHINPUT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected TOUCHINPUT create(long param1, @Nullable ByteBuffer param3) {
        return new TOUCHINPUT(param1, param3);
    }

    public TOUCHINPUT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), TOUCHINPUT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int x() {
        return TOUCHINPUT.nx(this.address());
    }

    @NativeType(value="LONG")
    public int y() {
        return TOUCHINPUT.ny(this.address());
    }

    @NativeType(value="HANDLE")
    public long hSource() {
        return TOUCHINPUT.nhSource(this.address());
    }

    @NativeType(value="DWORD")
    public int dwID() {
        return TOUCHINPUT.ndwID(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return TOUCHINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int dwMask() {
        return TOUCHINPUT.ndwMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwTime() {
        return TOUCHINPUT.ndwTime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return TOUCHINPUT.ndwExtraInfo(this.address());
    }

    @NativeType(value="DWORD")
    public int cxContact() {
        return TOUCHINPUT.ncxContact(this.address());
    }

    @NativeType(value="DWORD")
    public int cyContact() {
        return TOUCHINPUT.ncyContact(this.address());
    }

    public static TOUCHINPUT malloc() {
        return new TOUCHINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static TOUCHINPUT calloc() {
        return new TOUCHINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static TOUCHINPUT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new TOUCHINPUT(MemoryUtil.memAddress(v0), v0);
    }

    public static TOUCHINPUT create(long param0) {
        return new TOUCHINPUT(param0, null);
    }

    @Nullable
    public static TOUCHINPUT createSafe(long param0) {
        return param0 == 0L ? null : new TOUCHINPUT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(TOUCHINPUT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = TOUCHINPUT.__create(param0, SIZEOF);
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
    public static TOUCHINPUT mallocStack() {
        return TOUCHINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static TOUCHINPUT callocStack() {
        return TOUCHINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static TOUCHINPUT mallocStack(MemoryStack param0) {
        return TOUCHINPUT.malloc(param0);
    }

    @Deprecated
    public static TOUCHINPUT callocStack(MemoryStack param0) {
        return TOUCHINPUT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return TOUCHINPUT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return TOUCHINPUT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return TOUCHINPUT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return TOUCHINPUT.calloc(param0, param1);
    }

    public static TOUCHINPUT malloc(MemoryStack param0) {
        return new TOUCHINPUT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static TOUCHINPUT calloc(MemoryStack param0) {
        return new TOUCHINPUT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static long nhSource(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HSOURCE);
    }

    public static int ndwID(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWID);
    }

    public static int ndwFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWFLAGS);
    }

    public static int ndwMask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWMASK);
    }

    public static int ndwTime(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWTIME);
    }

    public static long ndwExtraInfo(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)DWEXTRAINFO);
    }

    public static int ncxContact(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CXCONTACT);
    }

    public static int ncyContact(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CYCONTACT);
    }

    static {
        Struct.Layout v0 = TOUCHINPUT.__struct(TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(POINTER_SIZE), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4), TOUCHINPUT.__member(POINTER_SIZE), TOUCHINPUT.__member(4), TOUCHINPUT.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        X = v0.offsetof(0);
        Y = v0.offsetof(1);
        HSOURCE = v0.offsetof(2);
        DWID = v0.offsetof(3);
        DWFLAGS = v0.offsetof(4);
        DWMASK = v0.offsetof(5);
        DWTIME = v0.offsetof(6);
        DWEXTRAINFO = v0.offsetof(7);
        CXCONTACT = v0.offsetof(8);
        CYCONTACT = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<TOUCHINPUT, Buffer>
    implements NativeResource {
        private static final TOUCHINPUT ELEMENT_FACTORY = TOUCHINPUT.create(-1L);

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
        protected TOUCHINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int x() {
            return TOUCHINPUT.nx(this.address());
        }

        @NativeType(value="LONG")
        public int y() {
            return TOUCHINPUT.ny(this.address());
        }

        @NativeType(value="HANDLE")
        public long hSource() {
            return TOUCHINPUT.nhSource(this.address());
        }

        @NativeType(value="DWORD")
        public int dwID() {
            return TOUCHINPUT.ndwID(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return TOUCHINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int dwMask() {
            return TOUCHINPUT.ndwMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwTime() {
            return TOUCHINPUT.ndwTime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return TOUCHINPUT.ndwExtraInfo(this.address());
        }

        @NativeType(value="DWORD")
        public int cxContact() {
            return TOUCHINPUT.ncxContact(this.address());
        }

        @NativeType(value="DWORD")
        public int cyContact() {
            return TOUCHINPUT.ncyContact(this.address());
        }
    }
}

