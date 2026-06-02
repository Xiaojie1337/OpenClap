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
import org.lwjgl.system.windows.RECT;

public class MONITORINFOEX
extends Struct<MONITORINFOEX>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int RCMONITOR;
    public static final int RCWORK;
    public static final int DWFLAGS;
    public static final int SZDEVICE;

    protected MONITORINFOEX(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected MONITORINFOEX create(long param1, @Nullable ByteBuffer param3) {
        return new MONITORINFOEX(param1, param3);
    }

    public MONITORINFOEX(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), MONITORINFOEX.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbSize() {
        return MONITORINFOEX.ncbSize(this.address());
    }

    public RECT rcMonitor() {
        return MONITORINFOEX.nrcMonitor(this.address());
    }

    public RECT rcWork() {
        return MONITORINFOEX.nrcWork(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MONITORINFOEX.ndwFlags(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer szDevice() {
        return MONITORINFOEX.nszDevice(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String szDeviceString() {
        return MONITORINFOEX.nszDeviceString(this.address());
    }

    public MONITORINFOEX cbSize(@NativeType(value="DWORD") int param1) {
        MONITORINFOEX.ncbSize(this.address(), param1);
        return this;
    }

    public MONITORINFOEX set(MONITORINFOEX param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static MONITORINFOEX malloc() {
        return new MONITORINFOEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MONITORINFOEX calloc() {
        return new MONITORINFOEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MONITORINFOEX create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new MONITORINFOEX(MemoryUtil.memAddress(v0), v0);
    }

    public static MONITORINFOEX create(long param0) {
        return new MONITORINFOEX(param0, null);
    }

    @Nullable
    public static MONITORINFOEX createSafe(long param0) {
        return param0 == 0L ? null : new MONITORINFOEX(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MONITORINFOEX.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = MONITORINFOEX.__create(param0, SIZEOF);
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
    public static MONITORINFOEX mallocStack() {
        return MONITORINFOEX.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX callocStack() {
        return MONITORINFOEX.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX mallocStack(MemoryStack param0) {
        return MONITORINFOEX.malloc(param0);
    }

    @Deprecated
    public static MONITORINFOEX callocStack(MemoryStack param0) {
        return MONITORINFOEX.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return MONITORINFOEX.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return MONITORINFOEX.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return MONITORINFOEX.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return MONITORINFOEX.calloc(param0, param1);
    }

    public static MONITORINFOEX malloc(MemoryStack param0) {
        return new MONITORINFOEX(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MONITORINFOEX calloc(MemoryStack param0) {
        return new MONITORINFOEX(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ncbSize(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CBSIZE);
    }

    public static RECT nrcMonitor(long param0) {
        return RECT.create(param0 + (long)RCMONITOR);
    }

    public static RECT nrcWork(long param0) {
        return RECT.create(param0 + (long)RCWORK);
    }

    public static int ndwFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWFLAGS);
    }

    public static ByteBuffer nszDevice(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)SZDEVICE, 64);
    }

    public static String nszDeviceString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)SZDEVICE);
    }

    public static void ncbSize(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBSIZE, param2);
    }

    static {
        Struct.Layout v0 = MONITORINFOEX.__struct(MONITORINFOEX.__member(4), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(4), MONITORINFOEX.__array(2, 32));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CBSIZE = v0.offsetof(0);
        RCMONITOR = v0.offsetof(1);
        RCWORK = v0.offsetof(2);
        DWFLAGS = v0.offsetof(3);
        SZDEVICE = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<MONITORINFOEX, Buffer>
    implements NativeResource {
        private static final MONITORINFOEX ELEMENT_FACTORY = MONITORINFOEX.create(-1L);

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
        protected MONITORINFOEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cbSize() {
            return MONITORINFOEX.ncbSize(this.address());
        }

        public RECT rcMonitor() {
            return MONITORINFOEX.nrcMonitor(this.address());
        }

        public RECT rcWork() {
            return MONITORINFOEX.nrcWork(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MONITORINFOEX.ndwFlags(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer szDevice() {
            return MONITORINFOEX.nszDevice(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String szDeviceString() {
            return MONITORINFOEX.nszDeviceString(this.address());
        }

        public Buffer cbSize(@NativeType(value="DWORD") int param1) {
            MONITORINFOEX.ncbSize(this.address(), param1);
            return this;
        }
    }
}

