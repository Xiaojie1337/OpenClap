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

public class XCreateWindowEvent
extends Struct<XCreateWindowEvent>
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
    public static final int OVERRIDE_REDIRECT;

    protected XCreateWindowEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XCreateWindowEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XCreateWindowEvent(param1, param3);
    }

    public XCreateWindowEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XCreateWindowEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCreateWindowEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCreateWindowEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCreateWindowEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCreateWindowEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XCreateWindowEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCreateWindowEvent.nwindow(this.address());
    }

    public int x() {
        return XCreateWindowEvent.nx(this.address());
    }

    public int y() {
        return XCreateWindowEvent.ny(this.address());
    }

    public int width() {
        return XCreateWindowEvent.nwidth(this.address());
    }

    public int height() {
        return XCreateWindowEvent.nheight(this.address());
    }

    public int border_width() {
        return XCreateWindowEvent.nborder_width(this.address());
    }

    public int override_redirect() {
        return XCreateWindowEvent.noverride_redirect(this.address());
    }

    public XCreateWindowEvent type(int param1) {
        XCreateWindowEvent.ntype(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent serial(@NativeType(value="unsigned long") long param1) {
        XCreateWindowEvent.nserial(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent send_event(@NativeType(value="Bool") boolean param1) {
        XCreateWindowEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XCreateWindowEvent display(@NativeType(value="Display *") long param1) {
        XCreateWindowEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent parent(@NativeType(value="Window") long param1) {
        XCreateWindowEvent.nparent(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent window(@NativeType(value="Window") long param1) {
        XCreateWindowEvent.nwindow(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent x(int param1) {
        XCreateWindowEvent.nx(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent y(int param1) {
        XCreateWindowEvent.ny(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent width(int param1) {
        XCreateWindowEvent.nwidth(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent height(int param1) {
        XCreateWindowEvent.nheight(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent border_width(int param1) {
        XCreateWindowEvent.nborder_width(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent override_redirect(int param1) {
        XCreateWindowEvent.noverride_redirect(this.address(), param1);
        return this;
    }

    public XCreateWindowEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11, int param12, int param13, int param14, int param15, int param16) {
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
        this.override_redirect(param16);
        return this;
    }

    public XCreateWindowEvent set(XCreateWindowEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCreateWindowEvent malloc() {
        return new XCreateWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XCreateWindowEvent calloc() {
        return new XCreateWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XCreateWindowEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XCreateWindowEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XCreateWindowEvent create(long param0) {
        return new XCreateWindowEvent(param0, null);
    }

    @Nullable
    public static XCreateWindowEvent createSafe(long param0) {
        return param0 == 0L ? null : new XCreateWindowEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XCreateWindowEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XCreateWindowEvent.__create(param0, SIZEOF);
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
    public static XCreateWindowEvent mallocStack() {
        return XCreateWindowEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent callocStack() {
        return XCreateWindowEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent mallocStack(MemoryStack param0) {
        return XCreateWindowEvent.malloc(param0);
    }

    @Deprecated
    public static XCreateWindowEvent callocStack(MemoryStack param0) {
        return XCreateWindowEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XCreateWindowEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XCreateWindowEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XCreateWindowEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XCreateWindowEvent.calloc(param0, param1);
    }

    public static XCreateWindowEvent malloc(MemoryStack param0) {
        return new XCreateWindowEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XCreateWindowEvent calloc(MemoryStack param0) {
        return new XCreateWindowEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int noverride_redirect(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OVERRIDE_REDIRECT);
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

    public static void noverride_redirect(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OVERRIDE_REDIRECT, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XCreateWindowEvent.__struct(XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(POINTER_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4));
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
        OVERRIDE_REDIRECT = v0.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XCreateWindowEvent, Buffer>
    implements NativeResource {
        private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);

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
        protected XCreateWindowEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCreateWindowEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCreateWindowEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCreateWindowEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCreateWindowEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XCreateWindowEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCreateWindowEvent.nwindow(this.address());
        }

        public int x() {
            return XCreateWindowEvent.nx(this.address());
        }

        public int y() {
            return XCreateWindowEvent.ny(this.address());
        }

        public int width() {
            return XCreateWindowEvent.nwidth(this.address());
        }

        public int height() {
            return XCreateWindowEvent.nheight(this.address());
        }

        public int border_width() {
            return XCreateWindowEvent.nborder_width(this.address());
        }

        public int override_redirect() {
            return XCreateWindowEvent.noverride_redirect(this.address());
        }

        public Buffer type(int param1) {
            XCreateWindowEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XCreateWindowEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XCreateWindowEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XCreateWindowEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long param1) {
            XCreateWindowEvent.nparent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XCreateWindowEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XCreateWindowEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XCreateWindowEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer width(int param1) {
            XCreateWindowEvent.nwidth(this.address(), param1);
            return this;
        }

        public Buffer height(int param1) {
            XCreateWindowEvent.nheight(this.address(), param1);
            return this;
        }

        public Buffer border_width(int param1) {
            XCreateWindowEvent.nborder_width(this.address(), param1);
            return this;
        }

        public Buffer override_redirect(int param1) {
            XCreateWindowEvent.noverride_redirect(this.address(), param1);
            return this;
        }
    }
}

