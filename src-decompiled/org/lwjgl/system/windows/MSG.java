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

public class MSG
extends Struct<MSG>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HWND;
    public static final int MESSAGE;
    public static final int WPARAM;
    public static final int LPARAM;
    public static final int TIME;
    public static final int PT;

    protected MSG(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected MSG create(long param1, @Nullable ByteBuffer param3) {
        return new MSG(param1, param3);
    }

    public MSG(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), MSG.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="HWND")
    public long hwnd() {
        return MSG.nhwnd(this.address());
    }

    @NativeType(value="UINT")
    public int message() {
        return MSG.nmessage(this.address());
    }

    @NativeType(value="WPARAM")
    public long wParam() {
        return MSG.nwParam(this.address());
    }

    @NativeType(value="LPARAM")
    public long lParam() {
        return MSG.nlParam(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MSG.ntime(this.address());
    }

    public POINT pt() {
        return MSG.npt(this.address());
    }

    public MSG hwnd(@NativeType(value="HWND") long param1) {
        MSG.nhwnd(this.address(), param1);
        return this;
    }

    public MSG message(@NativeType(value="UINT") int param1) {
        MSG.nmessage(this.address(), param1);
        return this;
    }

    public MSG wParam(@NativeType(value="WPARAM") long param1) {
        MSG.nwParam(this.address(), param1);
        return this;
    }

    public MSG lParam(@NativeType(value="LPARAM") long param1) {
        MSG.nlParam(this.address(), param1);
        return this;
    }

    public MSG time(@NativeType(value="DWORD") int param1) {
        MSG.ntime(this.address(), param1);
        return this;
    }

    public MSG pt(POINT param1) {
        MSG.npt(this.address(), param1);
        return this;
    }

    public MSG pt(Consumer<POINT> param1) {
        param1.accept(this.pt());
        return this;
    }

    public MSG set(long param1, int param3, long param4, long param6, int param8, POINT param9) {
        this.hwnd(param1);
        this.message(param3);
        this.wParam(param4);
        this.lParam(param6);
        this.time(param8);
        this.pt(param9);
        return this;
    }

    public MSG set(MSG param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static MSG malloc() {
        return new MSG(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MSG calloc() {
        return new MSG(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MSG create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new MSG(MemoryUtil.memAddress(v0), v0);
    }

    public static MSG create(long param0) {
        return new MSG(param0, null);
    }

    @Nullable
    public static MSG createSafe(long param0) {
        return param0 == 0L ? null : new MSG(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MSG.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = MSG.__create(param0, SIZEOF);
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
    public static MSG mallocStack() {
        return MSG.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG callocStack() {
        return MSG.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG mallocStack(MemoryStack param0) {
        return MSG.malloc(param0);
    }

    @Deprecated
    public static MSG callocStack(MemoryStack param0) {
        return MSG.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return MSG.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return MSG.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return MSG.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return MSG.calloc(param0, param1);
    }

    public static MSG malloc(MemoryStack param0) {
        return new MSG(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MSG calloc(MemoryStack param0) {
        return new MSG(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nhwnd(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HWND);
    }

    public static int nmessage(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MESSAGE);
    }

    public static long nwParam(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)WPARAM);
    }

    public static long nlParam(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)LPARAM);
    }

    public static int ntime(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TIME);
    }

    public static POINT npt(long param0) {
        return POINT.create(param0 + (long)PT);
    }

    public static void nhwnd(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HWND, param2);
    }

    public static void nmessage(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MESSAGE, param2);
    }

    public static void nwParam(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)WPARAM, param2);
    }

    public static void nlParam(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)LPARAM, param2);
    }

    public static void ntime(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TIME, param2);
    }

    public static void npt(long param0, POINT param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)PT, POINT.SIZEOF);
    }

    static {
        Struct.Layout v0 = MSG.__struct(MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINTER_SIZE), MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINT.SIZEOF, POINT.ALIGNOF));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        HWND = v0.offsetof(0);
        MESSAGE = v0.offsetof(1);
        WPARAM = v0.offsetof(2);
        LPARAM = v0.offsetof(3);
        TIME = v0.offsetof(4);
        PT = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MSG, Buffer>
    implements NativeResource {
        private static final MSG ELEMENT_FACTORY = MSG.create(-1L);

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
        protected MSG getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="HWND")
        public long hwnd() {
            return MSG.nhwnd(this.address());
        }

        @NativeType(value="UINT")
        public int message() {
            return MSG.nmessage(this.address());
        }

        @NativeType(value="WPARAM")
        public long wParam() {
            return MSG.nwParam(this.address());
        }

        @NativeType(value="LPARAM")
        public long lParam() {
            return MSG.nlParam(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MSG.ntime(this.address());
        }

        public POINT pt() {
            return MSG.npt(this.address());
        }

        public Buffer hwnd(@NativeType(value="HWND") long param1) {
            MSG.nhwnd(this.address(), param1);
            return this;
        }

        public Buffer message(@NativeType(value="UINT") int param1) {
            MSG.nmessage(this.address(), param1);
            return this;
        }

        public Buffer wParam(@NativeType(value="WPARAM") long param1) {
            MSG.nwParam(this.address(), param1);
            return this;
        }

        public Buffer lParam(@NativeType(value="LPARAM") long param1) {
            MSG.nlParam(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int param1) {
            MSG.ntime(this.address(), param1);
            return this;
        }

        public Buffer pt(POINT param1) {
            MSG.npt(this.address(), param1);
            return this;
        }

        public Buffer pt(Consumer<POINT> param1) {
            param1.accept(this.pt());
            return this;
        }
    }
}

