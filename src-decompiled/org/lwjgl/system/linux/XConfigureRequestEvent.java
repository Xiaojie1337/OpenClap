/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

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

public class XConfigureRequestEvent
extends Struct<XConfigureRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int DETAIL;
    public static final int VALUE_MASK;

    protected XConfigureRequestEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XConfigureRequestEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XConfigureRequestEvent(param1, param3);
    }

    public XConfigureRequestEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XConfigureRequestEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XConfigureRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureRequestEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureRequestEvent.nx(this.address());
    }

    public int y() {
        return XConfigureRequestEvent.ny(this.address());
    }

    public int width() {
        return XConfigureRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureRequestEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureRequestEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureRequestEvent.nabove(this.address());
    }

    public int detail() {
        return XConfigureRequestEvent.ndetail(this.address());
    }

    @NativeType(value="unsigned long")
    public long value_mask() {
        return XConfigureRequestEvent.nvalue_mask(this.address());
    }

    public XConfigureRequestEvent type(int param1) {
        XConfigureRequestEvent.ntype(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent serial(@NativeType(value="unsigned long") long param1) {
        XConfigureRequestEvent.nserial(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent send_event(@NativeType(value="Bool") boolean param1) {
        XConfigureRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XConfigureRequestEvent display(@NativeType(value="Display *") long param1) {
        XConfigureRequestEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent parent(@NativeType(value="Window") long param1) {
        XConfigureRequestEvent.nparent(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent window(@NativeType(value="Window") long param1) {
        XConfigureRequestEvent.nwindow(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent x(int param1) {
        XConfigureRequestEvent.nx(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent y(int param1) {
        XConfigureRequestEvent.ny(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent width(int param1) {
        XConfigureRequestEvent.nwidth(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent height(int param1) {
        XConfigureRequestEvent.nheight(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent border_width(int param1) {
        XConfigureRequestEvent.nborder_width(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent above(@NativeType(value="Window") long param1) {
        XConfigureRequestEvent.nabove(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent detail(int param1) {
        XConfigureRequestEvent.ndetail(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent value_mask(@NativeType(value="unsigned long") long param1) {
        XConfigureRequestEvent.nvalue_mask(this.address(), param1);
        return this;
    }

    public XConfigureRequestEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11, int param12, int param13, int param14, int param15, long param16, int param18, long param19) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.parent(param7);
        this.window(param9);
        this.x(param11);
        this.y(param12);
        this.width(param13);
        this.height(param14);
        this.border_width(param15);
        this.above(param16);
        this.detail(param18);
        this.value_mask(param19);
        return this;
    }

    public XConfigureRequestEvent set(XConfigureRequestEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureRequestEvent malloc() {
        return new XConfigureRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XConfigureRequestEvent calloc() {
        return new XConfigureRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XConfigureRequestEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XConfigureRequestEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XConfigureRequestEvent create(long param0) {
        return new XConfigureRequestEvent(param0, null);
    }

    @Nullable
    public static XConfigureRequestEvent createSafe(long param0) {
        return param0 == 0L ? null : new XConfigureRequestEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XConfigureRequestEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XConfigureRequestEvent.__create(param0, SIZEOF);
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
    public static XConfigureRequestEvent mallocStack() {
        return XConfigureRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack() {
        return XConfigureRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent mallocStack(MemoryStack param0) {
        return XConfigureRequestEvent.malloc(param0);
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack(MemoryStack param0) {
        return XConfigureRequestEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XConfigureRequestEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XConfigureRequestEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XConfigureRequestEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XConfigureRequestEvent.calloc(param0, param1);
    }

    public static XConfigureRequestEvent malloc(MemoryStack param0) {
        return new XConfigureRequestEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XConfigureRequestEvent calloc(MemoryStack param0) {
        return new XConfigureRequestEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nserial(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)SERIAL);
    }

    public static int nsend_event(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SEND_EVENT);
    }

    public static long ndisplay(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)DISPLAY);
    }

    public static long nparent(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)PARENT);
    }

    public static long nwindow(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)WINDOW);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static int nwidth(long param0) {
        return UNSAFE.getInt(null, param0 + (long)WIDTH);
    }

    public static int nheight(long param0) {
        return UNSAFE.getInt(null, param0 + (long)HEIGHT);
    }

    public static int nborder_width(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BORDER_WIDTH);
    }

    public static long nabove(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)ABOVE);
    }

    public static int ndetail(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DETAIL);
    }

    public static long nvalue_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)VALUE_MASK);
    }

    public static void ntype(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TYPE, param2);
    }

    public static void nserial(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)SERIAL, param2);
    }

    public static void nsend_event(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SEND_EVENT, param2);
    }

    public static void ndisplay(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)DISPLAY, Checks.check(param2));
    }

    public static void nparent(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)PARENT, param2);
    }

    public static void nwindow(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)WINDOW, param2);
    }

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    public static void nwidth(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)WIDTH, param2);
    }

    public static void nheight(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)HEIGHT, param2);
    }

    public static void nborder_width(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BORDER_WIDTH, param2);
    }

    public static void nabove(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)ABOVE, param2);
    }

    public static void ndetail(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DETAIL, param2);
    }

    public static void nvalue_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)VALUE_MASK, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XConfigureRequestEvent.__struct(XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(POINTER_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        PARENT = v0.offsetof(4);
        WINDOW = v0.offsetof(5);
        X = v0.offsetof(6);
        Y = v0.offsetof(7);
        WIDTH = v0.offsetof(8);
        HEIGHT = v0.offsetof(9);
        BORDER_WIDTH = v0.offsetof(10);
        ABOVE = v0.offsetof(11);
        DETAIL = v0.offsetof(12);
        VALUE_MASK = v0.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<XConfigureRequestEvent, Buffer>
    implements NativeResource {
        private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);

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
        protected XConfigureRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XConfigureRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureRequestEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureRequestEvent.nx(this.address());
        }

        public int y() {
            return XConfigureRequestEvent.ny(this.address());
        }

        public int width() {
            return XConfigureRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureRequestEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureRequestEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureRequestEvent.nabove(this.address());
        }

        public int detail() {
            return XConfigureRequestEvent.ndetail(this.address());
        }

        @NativeType(value="unsigned long")
        public long value_mask() {
            return XConfigureRequestEvent.nvalue_mask(this.address());
        }

        public Buffer type(int param1) {
            XConfigureRequestEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XConfigureRequestEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XConfigureRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XConfigureRequestEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long param1) {
            XConfigureRequestEvent.nparent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XConfigureRequestEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XConfigureRequestEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XConfigureRequestEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer width(int param1) {
            XConfigureRequestEvent.nwidth(this.address(), param1);
            return this;
        }

        public Buffer height(int param1) {
            XConfigureRequestEvent.nheight(this.address(), param1);
            return this;
        }

        public Buffer border_width(int param1) {
            XConfigureRequestEvent.nborder_width(this.address(), param1);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long param1) {
            XConfigureRequestEvent.nabove(this.address(), param1);
            return this;
        }

        public Buffer detail(int param1) {
            XConfigureRequestEvent.ndetail(this.address(), param1);
            return this;
        }

        public Buffer value_mask(@NativeType(value="unsigned long") long param1) {
            XConfigureRequestEvent.nvalue_mask(this.address(), param1);
            return this;
        }
    }
}

