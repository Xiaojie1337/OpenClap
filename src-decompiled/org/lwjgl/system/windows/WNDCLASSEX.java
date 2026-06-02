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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.WindowProc;
import org.lwjgl.system.windows.WindowProcI;

public class WNDCLASSEX
extends Struct<WNDCLASSEX>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int STYLE;
    public static final int LPFNWNDPROC;
    public static final int CBCLSEXTRA;
    public static final int CBWNDEXTRA;
    public static final int HINSTANCE;
    public static final int HICON;
    public static final int HCURSOR;
    public static final int HBRBACKGROUND;
    public static final int LPSZMENUNAME;
    public static final int LPSZCLASSNAME;
    public static final int HICONSM;

    protected WNDCLASSEX(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected WNDCLASSEX create(long param1, @Nullable ByteBuffer param3) {
        return new WNDCLASSEX(param1, param3);
    }

    public WNDCLASSEX(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), WNDCLASSEX.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int cbSize() {
        return WNDCLASSEX.ncbSize(this.address());
    }

    @NativeType(value="UINT")
    public int style() {
        return WNDCLASSEX.nstyle(this.address());
    }

    @NativeType(value="WNDPROC")
    public WindowProc lpfnWndProc() {
        return WNDCLASSEX.nlpfnWndProc(this.address());
    }

    public int cbClsExtra() {
        return WNDCLASSEX.ncbClsExtra(this.address());
    }

    public int cbWndExtra() {
        return WNDCLASSEX.ncbWndExtra(this.address());
    }

    @NativeType(value="HINSTANCE")
    public long hInstance() {
        return WNDCLASSEX.nhInstance(this.address());
    }

    @NativeType(value="HICON")
    public long hIcon() {
        return WNDCLASSEX.nhIcon(this.address());
    }

    @NativeType(value="HCURSOR")
    public long hCursor() {
        return WNDCLASSEX.nhCursor(this.address());
    }

    @NativeType(value="HBRUSH")
    public long hbrBackground() {
        return WNDCLASSEX.nhbrBackground(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszMenuName() {
        return WNDCLASSEX.nlpszMenuName(this.address());
    }

    @Nullable
    @NativeType(value="LPCTSTR")
    public String lpszMenuNameString() {
        return WNDCLASSEX.nlpszMenuNameString(this.address());
    }

    @NativeType(value="LPCTSTR")
    public ByteBuffer lpszClassName() {
        return WNDCLASSEX.nlpszClassName(this.address());
    }

    @NativeType(value="LPCTSTR")
    public String lpszClassNameString() {
        return WNDCLASSEX.nlpszClassNameString(this.address());
    }

    @NativeType(value="HICON")
    public long hIconSm() {
        return WNDCLASSEX.nhIconSm(this.address());
    }

    public WNDCLASSEX cbSize(@NativeType(value="UINT") int param1) {
        WNDCLASSEX.ncbSize(this.address(), param1);
        return this;
    }

    public WNDCLASSEX style(@NativeType(value="UINT") int param1) {
        WNDCLASSEX.nstyle(this.address(), param1);
        return this;
    }

    public WNDCLASSEX lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI param1) {
        WNDCLASSEX.nlpfnWndProc(this.address(), param1);
        return this;
    }

    public WNDCLASSEX cbClsExtra(int param1) {
        WNDCLASSEX.ncbClsExtra(this.address(), param1);
        return this;
    }

    public WNDCLASSEX cbWndExtra(int param1) {
        WNDCLASSEX.ncbWndExtra(this.address(), param1);
        return this;
    }

    public WNDCLASSEX hInstance(@NativeType(value="HINSTANCE") long param1) {
        WNDCLASSEX.nhInstance(this.address(), param1);
        return this;
    }

    public WNDCLASSEX hIcon(@NativeType(value="HICON") long param1) {
        WNDCLASSEX.nhIcon(this.address(), param1);
        return this;
    }

    public WNDCLASSEX hCursor(@NativeType(value="HCURSOR") long param1) {
        WNDCLASSEX.nhCursor(this.address(), param1);
        return this;
    }

    public WNDCLASSEX hbrBackground(@NativeType(value="HBRUSH") long param1) {
        WNDCLASSEX.nhbrBackground(this.address(), param1);
        return this;
    }

    public WNDCLASSEX lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param1) {
        WNDCLASSEX.nlpszMenuName(this.address(), param1);
        return this;
    }

    public WNDCLASSEX lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer param1) {
        WNDCLASSEX.nlpszClassName(this.address(), param1);
        return this;
    }

    public WNDCLASSEX hIconSm(@NativeType(value="HICON") long param1) {
        WNDCLASSEX.nhIconSm(this.address(), param1);
        return this;
    }

    public WNDCLASSEX set(int param1, int param2, WindowProcI param3, int param4, int param5, long param6, long param8, long param10, long param12, @Nullable ByteBuffer param14, ByteBuffer param15, long param16) {
        this.cbSize(param1);
        this.style(param2);
        this.lpfnWndProc(param3);
        this.cbClsExtra(param4);
        this.cbWndExtra(param5);
        this.hInstance(param6);
        this.hIcon(param8);
        this.hCursor(param10);
        this.hbrBackground(param12);
        this.lpszMenuName(param14);
        this.lpszClassName(param15);
        this.hIconSm(param16);
        return this;
    }

    public WNDCLASSEX set(WNDCLASSEX param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static WNDCLASSEX malloc() {
        return new WNDCLASSEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static WNDCLASSEX calloc() {
        return new WNDCLASSEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static WNDCLASSEX create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new WNDCLASSEX(MemoryUtil.memAddress(v0), v0);
    }

    public static WNDCLASSEX create(long param0) {
        return new WNDCLASSEX(param0, null);
    }

    @Nullable
    public static WNDCLASSEX createSafe(long param0) {
        return param0 == 0L ? null : new WNDCLASSEX(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(WNDCLASSEX.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = WNDCLASSEX.__create(param0, SIZEOF);
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
    public static WNDCLASSEX mallocStack() {
        return WNDCLASSEX.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WNDCLASSEX callocStack() {
        return WNDCLASSEX.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WNDCLASSEX mallocStack(MemoryStack param0) {
        return WNDCLASSEX.malloc(param0);
    }

    @Deprecated
    public static WNDCLASSEX callocStack(MemoryStack param0) {
        return WNDCLASSEX.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return WNDCLASSEX.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return WNDCLASSEX.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return WNDCLASSEX.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return WNDCLASSEX.calloc(param0, param1);
    }

    public static WNDCLASSEX malloc(MemoryStack param0) {
        return new WNDCLASSEX(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static WNDCLASSEX calloc(MemoryStack param0) {
        return new WNDCLASSEX(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nstyle(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STYLE);
    }

    public static WindowProc nlpfnWndProc(long param0) {
        return WindowProc.create(MemoryUtil.memGetAddress(param0 + (long)LPFNWNDPROC));
    }

    public static int ncbClsExtra(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CBCLSEXTRA);
    }

    public static int ncbWndExtra(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CBWNDEXTRA);
    }

    public static long nhInstance(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HINSTANCE);
    }

    public static long nhIcon(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HICON);
    }

    public static long nhCursor(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HCURSOR);
    }

    public static long nhbrBackground(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HBRBACKGROUND);
    }

    @Nullable
    public static ByteBuffer nlpszMenuName(long param0) {
        return MemoryUtil.memByteBufferNT2Safe(MemoryUtil.memGetAddress(param0 + (long)LPSZMENUNAME));
    }

    @Nullable
    public static String nlpszMenuNameString(long param0) {
        return MemoryUtil.memUTF16Safe(MemoryUtil.memGetAddress(param0 + (long)LPSZMENUNAME));
    }

    public static ByteBuffer nlpszClassName(long param0) {
        return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(param0 + (long)LPSZCLASSNAME));
    }

    public static String nlpszClassNameString(long param0) {
        return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(param0 + (long)LPSZCLASSNAME));
    }

    public static long nhIconSm(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HICONSM);
    }

    public static void ncbSize(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBSIZE, param2);
    }

    public static void nstyle(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STYLE, param2);
    }

    public static void nlpfnWndProc(long param0, WindowProcI param2) {
        MemoryUtil.memPutAddress(param0 + (long)LPFNWNDPROC, param2.address());
    }

    public static void ncbClsExtra(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBCLSEXTRA, param2);
    }

    public static void ncbWndExtra(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBWNDEXTRA, param2);
    }

    public static void nhInstance(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HINSTANCE, param2);
    }

    public static void nhIcon(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HICON, param2);
    }

    public static void nhCursor(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HCURSOR, param2);
    }

    public static void nhbrBackground(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HBRBACKGROUND, param2);
    }

    public static void nlpszMenuName(long param0, @Nullable ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)LPSZMENUNAME, MemoryUtil.memAddressSafe(param2));
    }

    public static void nlpszClassName(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)LPSZCLASSNAME, MemoryUtil.memAddress(param2));
    }

    public static void nhIconSm(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HICONSM, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)LPFNWNDPROC));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)LPSZCLASSNAME));
    }

    static {
        Struct.Layout v0 = WNDCLASSEX.__struct(WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(4), WNDCLASSEX.__member(4), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE), WNDCLASSEX.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CBSIZE = v0.offsetof(0);
        STYLE = v0.offsetof(1);
        LPFNWNDPROC = v0.offsetof(2);
        CBCLSEXTRA = v0.offsetof(3);
        CBWNDEXTRA = v0.offsetof(4);
        HINSTANCE = v0.offsetof(5);
        HICON = v0.offsetof(6);
        HCURSOR = v0.offsetof(7);
        HBRBACKGROUND = v0.offsetof(8);
        LPSZMENUNAME = v0.offsetof(9);
        LPSZCLASSNAME = v0.offsetof(10);
        HICONSM = v0.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<WNDCLASSEX, Buffer>
    implements NativeResource {
        private static final WNDCLASSEX ELEMENT_FACTORY = WNDCLASSEX.create(-1L);

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
        protected WNDCLASSEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int cbSize() {
            return WNDCLASSEX.ncbSize(this.address());
        }

        @NativeType(value="UINT")
        public int style() {
            return WNDCLASSEX.nstyle(this.address());
        }

        @NativeType(value="WNDPROC")
        public WindowProc lpfnWndProc() {
            return WNDCLASSEX.nlpfnWndProc(this.address());
        }

        public int cbClsExtra() {
            return WNDCLASSEX.ncbClsExtra(this.address());
        }

        public int cbWndExtra() {
            return WNDCLASSEX.ncbWndExtra(this.address());
        }

        @NativeType(value="HINSTANCE")
        public long hInstance() {
            return WNDCLASSEX.nhInstance(this.address());
        }

        @NativeType(value="HICON")
        public long hIcon() {
            return WNDCLASSEX.nhIcon(this.address());
        }

        @NativeType(value="HCURSOR")
        public long hCursor() {
            return WNDCLASSEX.nhCursor(this.address());
        }

        @NativeType(value="HBRUSH")
        public long hbrBackground() {
            return WNDCLASSEX.nhbrBackground(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszMenuName() {
            return WNDCLASSEX.nlpszMenuName(this.address());
        }

        @Nullable
        @NativeType(value="LPCTSTR")
        public String lpszMenuNameString() {
            return WNDCLASSEX.nlpszMenuNameString(this.address());
        }

        @NativeType(value="LPCTSTR")
        public ByteBuffer lpszClassName() {
            return WNDCLASSEX.nlpszClassName(this.address());
        }

        @NativeType(value="LPCTSTR")
        public String lpszClassNameString() {
            return WNDCLASSEX.nlpszClassNameString(this.address());
        }

        @NativeType(value="HICON")
        public long hIconSm() {
            return WNDCLASSEX.nhIconSm(this.address());
        }

        public Buffer cbSize(@NativeType(value="UINT") int param1) {
            WNDCLASSEX.ncbSize(this.address(), param1);
            return this;
        }

        public Buffer style(@NativeType(value="UINT") int param1) {
            WNDCLASSEX.nstyle(this.address(), param1);
            return this;
        }

        public Buffer lpfnWndProc(@NativeType(value="WNDPROC") WindowProcI param1) {
            WNDCLASSEX.nlpfnWndProc(this.address(), param1);
            return this;
        }

        public Buffer cbClsExtra(int param1) {
            WNDCLASSEX.ncbClsExtra(this.address(), param1);
            return this;
        }

        public Buffer cbWndExtra(int param1) {
            WNDCLASSEX.ncbWndExtra(this.address(), param1);
            return this;
        }

        public Buffer hInstance(@NativeType(value="HINSTANCE") long param1) {
            WNDCLASSEX.nhInstance(this.address(), param1);
            return this;
        }

        public Buffer hIcon(@NativeType(value="HICON") long param1) {
            WNDCLASSEX.nhIcon(this.address(), param1);
            return this;
        }

        public Buffer hCursor(@NativeType(value="HCURSOR") long param1) {
            WNDCLASSEX.nhCursor(this.address(), param1);
            return this;
        }

        public Buffer hbrBackground(@NativeType(value="HBRUSH") long param1) {
            WNDCLASSEX.nhbrBackground(this.address(), param1);
            return this;
        }

        public Buffer lpszMenuName(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param1) {
            WNDCLASSEX.nlpszMenuName(this.address(), param1);
            return this;
        }

        public Buffer lpszClassName(@NativeType(value="LPCTSTR") ByteBuffer param1) {
            WNDCLASSEX.nlpszClassName(this.address(), param1);
            return this;
        }

        public Buffer hIconSm(@NativeType(value="HICON") long param1) {
            WNDCLASSEX.nhIconSm(this.address(), param1);
            return this;
        }
    }
}

