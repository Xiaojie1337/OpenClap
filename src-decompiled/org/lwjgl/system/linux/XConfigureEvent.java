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

public class XConfigureEvent
extends Struct<XConfigureEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int OVERRIDE_REDIRECT;

    protected XConfigureEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XConfigureEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XConfigureEvent(param1, param3);
    }

    public XConfigureEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XConfigureEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureEvent.nx(this.address());
    }

    public int y() {
        return XConfigureEvent.ny(this.address());
    }

    public int width() {
        return XConfigureEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureEvent.nabove(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XConfigureEvent.noverride_redirect(this.address()) != 0;
    }

    public XConfigureEvent type(int param1) {
        XConfigureEvent.ntype(this.address(), param1);
        return this;
    }

    public XConfigureEvent serial(@NativeType(value="unsigned long") long param1) {
        XConfigureEvent.nserial(this.address(), param1);
        return this;
    }

    public XConfigureEvent send_event(@NativeType(value="Bool") boolean param1) {
        XConfigureEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XConfigureEvent display(@NativeType(value="Display *") long param1) {
        XConfigureEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XConfigureEvent window(@NativeType(value="Window") long param1) {
        XConfigureEvent.nwindow(this.address(), param1);
        return this;
    }

    public XConfigureEvent x(int param1) {
        XConfigureEvent.nx(this.address(), param1);
        return this;
    }

    public XConfigureEvent y(int param1) {
        XConfigureEvent.ny(this.address(), param1);
        return this;
    }

    public XConfigureEvent width(int param1) {
        XConfigureEvent.nwidth(this.address(), param1);
        return this;
    }

    public XConfigureEvent height(int param1) {
        XConfigureEvent.nheight(this.address(), param1);
        return this;
    }

    public XConfigureEvent border_width(int param1) {
        XConfigureEvent.nborder_width(this.address(), param1);
        return this;
    }

    public XConfigureEvent above(@NativeType(value="Window") long param1) {
        XConfigureEvent.nabove(this.address(), param1);
        return this;
    }

    public XConfigureEvent override_redirect(@NativeType(value="Bool") boolean param1) {
        XConfigureEvent.noverride_redirect(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XConfigureEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9, int param10, int param11, int param12, int param13, long param14, boolean param16) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.x(param9);
        this.y(param10);
        this.width(param11);
        this.height(param12);
        this.border_width(param13);
        this.above(param14);
        this.override_redirect(param16);
        return this;
    }

    public XConfigureEvent set(XConfigureEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureEvent malloc() {
        return new XConfigureEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XConfigureEvent calloc() {
        return new XConfigureEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XConfigureEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XConfigureEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XConfigureEvent create(long param0) {
        return new XConfigureEvent(param0, null);
    }

    @Nullable
    public static XConfigureEvent createSafe(long param0) {
        return param0 == 0L ? null : new XConfigureEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XConfigureEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XConfigureEvent.__create(param0, SIZEOF);
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
    public static XConfigureEvent mallocStack() {
        return XConfigureEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent callocStack() {
        return XConfigureEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent mallocStack(MemoryStack param0) {
        return XConfigureEvent.malloc(param0);
    }

    @Deprecated
    public static XConfigureEvent callocStack(MemoryStack param0) {
        return XConfigureEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XConfigureEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XConfigureEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XConfigureEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XConfigureEvent.calloc(param0, param1);
    }

    public static XConfigureEvent malloc(MemoryStack param0) {
        return new XConfigureEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XConfigureEvent calloc(MemoryStack param0) {
        return new XConfigureEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void noverride_redirect(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OVERRIDE_REDIRECT, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XConfigureEvent.__struct(XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(POINTER_SIZE), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        X = v0.offsetof(5);
        Y = v0.offsetof(6);
        WIDTH = v0.offsetof(7);
        HEIGHT = v0.offsetof(8);
        BORDER_WIDTH = v0.offsetof(9);
        ABOVE = v0.offsetof(10);
        OVERRIDE_REDIRECT = v0.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XConfigureEvent, Buffer>
    implements NativeResource {
        private static final XConfigureEvent ELEMENT_FACTORY = XConfigureEvent.create(-1L);

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
        protected XConfigureEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureEvent.nx(this.address());
        }

        public int y() {
            return XConfigureEvent.ny(this.address());
        }

        public int width() {
            return XConfigureEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureEvent.nabove(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XConfigureEvent.noverride_redirect(this.address()) != 0;
        }

        public Buffer type(int param1) {
            XConfigureEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XConfigureEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XConfigureEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XConfigureEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XConfigureEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XConfigureEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XConfigureEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer width(int param1) {
            XConfigureEvent.nwidth(this.address(), param1);
            return this;
        }

        public Buffer height(int param1) {
            XConfigureEvent.nheight(this.address(), param1);
            return this;
        }

        public Buffer border_width(int param1) {
            XConfigureEvent.nborder_width(this.address(), param1);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long param1) {
            XConfigureEvent.nabove(this.address(), param1);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean param1) {
            XConfigureEvent.noverride_redirect(this.address(), param1 ? 1 : 0);
            return this;
        }
    }
}

