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

public class KEYBDINPUT
extends Struct<KEYBDINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WVK;
    public static final int WSCAN;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    protected KEYBDINPUT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected KEYBDINPUT create(long param1, @Nullable ByteBuffer param3) {
        return new KEYBDINPUT(param1, param3);
    }

    public KEYBDINPUT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), KEYBDINPUT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short wVk() {
        return KEYBDINPUT.nwVk(this.address());
    }

    @NativeType(value="WORD")
    public short wScan() {
        return KEYBDINPUT.nwScan(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return KEYBDINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return KEYBDINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return KEYBDINPUT.ndwExtraInfo(this.address());
    }

    public KEYBDINPUT wVk(@NativeType(value="WORD") short param1) {
        KEYBDINPUT.nwVk(this.address(), param1);
        return this;
    }

    public KEYBDINPUT wScan(@NativeType(value="WORD") short param1) {
        KEYBDINPUT.nwScan(this.address(), param1);
        return this;
    }

    public KEYBDINPUT dwFlags(@NativeType(value="DWORD") int param1) {
        KEYBDINPUT.ndwFlags(this.address(), param1);
        return this;
    }

    public KEYBDINPUT time(@NativeType(value="DWORD") int param1) {
        KEYBDINPUT.ntime(this.address(), param1);
        return this;
    }

    public KEYBDINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long param1) {
        KEYBDINPUT.ndwExtraInfo(this.address(), param1);
        return this;
    }

    public KEYBDINPUT set(short param1, short param2, int param3, int param4, long param5) {
        this.wVk(param1);
        this.wScan(param2);
        this.dwFlags(param3);
        this.time(param4);
        this.dwExtraInfo(param5);
        return this;
    }

    public KEYBDINPUT set(KEYBDINPUT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static KEYBDINPUT malloc() {
        return new KEYBDINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static KEYBDINPUT calloc() {
        return new KEYBDINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static KEYBDINPUT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new KEYBDINPUT(MemoryUtil.memAddress(v0), v0);
    }

    public static KEYBDINPUT create(long param0) {
        return new KEYBDINPUT(param0, null);
    }

    @Nullable
    public static KEYBDINPUT createSafe(long param0) {
        return param0 == 0L ? null : new KEYBDINPUT(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(KEYBDINPUT.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = KEYBDINPUT.__create(param0, SIZEOF);
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
    public static KEYBDINPUT mallocStack() {
        return KEYBDINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT callocStack() {
        return KEYBDINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT mallocStack(MemoryStack param0) {
        return KEYBDINPUT.malloc(param0);
    }

    @Deprecated
    public static KEYBDINPUT callocStack(MemoryStack param0) {
        return KEYBDINPUT.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return KEYBDINPUT.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return KEYBDINPUT.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return KEYBDINPUT.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return KEYBDINPUT.calloc(param0, param1);
    }

    public static KEYBDINPUT malloc(MemoryStack param0) {
        return new KEYBDINPUT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static KEYBDINPUT calloc(MemoryStack param0) {
        return new KEYBDINPUT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static short nwVk(long param0) {
        return UNSAFE.getShort(null, param0 + (long)WVK);
    }

    public static short nwScan(long param0) {
        return UNSAFE.getShort(null, param0 + (long)WSCAN);
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

    public static void nwVk(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)WVK, param2);
    }

    public static void nwScan(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)WSCAN, param2);
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
        Struct.Layout v0 = KEYBDINPUT.__struct(KEYBDINPUT.__member(2), KEYBDINPUT.__member(2), KEYBDINPUT.__member(4), KEYBDINPUT.__member(4), KEYBDINPUT.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        WVK = v0.offsetof(0);
        WSCAN = v0.offsetof(1);
        DWFLAGS = v0.offsetof(2);
        TIME = v0.offsetof(3);
        DWEXTRAINFO = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<KEYBDINPUT, Buffer>
    implements NativeResource {
        private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);

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
        protected KEYBDINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short wVk() {
            return KEYBDINPUT.nwVk(this.address());
        }

        @NativeType(value="WORD")
        public short wScan() {
            return KEYBDINPUT.nwScan(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return KEYBDINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return KEYBDINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return KEYBDINPUT.ndwExtraInfo(this.address());
        }

        public Buffer wVk(@NativeType(value="WORD") short param1) {
            KEYBDINPUT.nwVk(this.address(), param1);
            return this;
        }

        public Buffer wScan(@NativeType(value="WORD") short param1) {
            KEYBDINPUT.nwScan(this.address(), param1);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int param1) {
            KEYBDINPUT.ndwFlags(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int param1) {
            KEYBDINPUT.ntime(this.address(), param1);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long param1) {
            KEYBDINPUT.ndwExtraInfo(this.address(), param1);
            return this;
        }
    }
}

