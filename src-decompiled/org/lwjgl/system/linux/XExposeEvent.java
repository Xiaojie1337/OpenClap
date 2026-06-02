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

public class XExposeEvent
extends Struct<XExposeEvent>
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
    public static final int COUNT;

    protected XExposeEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XExposeEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XExposeEvent(param1, param3);
    }

    public XExposeEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XExposeEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XExposeEvent.nwindow(this.address());
    }

    public int x() {
        return XExposeEvent.nx(this.address());
    }

    public int y() {
        return XExposeEvent.ny(this.address());
    }

    public int width() {
        return XExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XExposeEvent.nheight(this.address());
    }

    public int count() {
        return XExposeEvent.ncount(this.address());
    }

    public XExposeEvent type(int param1) {
        XExposeEvent.ntype(this.address(), param1);
        return this;
    }

    public XExposeEvent serial(@NativeType(value="unsigned long") long param1) {
        XExposeEvent.nserial(this.address(), param1);
        return this;
    }

    public XExposeEvent send_event(@NativeType(value="Bool") boolean param1) {
        XExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XExposeEvent display(@NativeType(value="Display *") long param1) {
        XExposeEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XExposeEvent window(@NativeType(value="Window") long param1) {
        XExposeEvent.nwindow(this.address(), param1);
        return this;
    }

    public XExposeEvent x(int param1) {
        XExposeEvent.nx(this.address(), param1);
        return this;
    }

    public XExposeEvent y(int param1) {
        XExposeEvent.ny(this.address(), param1);
        return this;
    }

    public XExposeEvent width(int param1) {
        XExposeEvent.nwidth(this.address(), param1);
        return this;
    }

    public XExposeEvent height(int param1) {
        XExposeEvent.nheight(this.address(), param1);
        return this;
    }

    public XExposeEvent count(int param1) {
        XExposeEvent.ncount(this.address(), param1);
        return this;
    }

    public XExposeEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9, int param10, int param11, int param12, int param13) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.x(param9);
        this.y(param10);
        this.width(param11);
        this.height(param12);
        this.count(param13);
        return this;
    }

    public XExposeEvent set(XExposeEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XExposeEvent malloc() {
        return new XExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XExposeEvent calloc() {
        return new XExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XExposeEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XExposeEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XExposeEvent create(long param0) {
        return new XExposeEvent(param0, null);
    }

    @Nullable
    public static XExposeEvent createSafe(long param0) {
        return param0 == 0L ? null : new XExposeEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XExposeEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XExposeEvent.__create(param0, SIZEOF);
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
    public static XExposeEvent mallocStack() {
        return XExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent callocStack() {
        return XExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent mallocStack(MemoryStack param0) {
        return XExposeEvent.malloc(param0);
    }

    @Deprecated
    public static XExposeEvent callocStack(MemoryStack param0) {
        return XExposeEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XExposeEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XExposeEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XExposeEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XExposeEvent.calloc(param0, param1);
    }

    public static XExposeEvent malloc(MemoryStack param0) {
        return new XExposeEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XExposeEvent calloc(MemoryStack param0) {
        return new XExposeEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int ncount(long param0) {
        return UNSAFE.getInt(null, param0 + (long)COUNT);
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

    public static void ncount(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)COUNT, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XExposeEvent.__struct(XExposeEvent.__member(4), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(POINTER_SIZE), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4));
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
        COUNT = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XExposeEvent, Buffer>
    implements NativeResource {
        private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);

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
        protected XExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XExposeEvent.nwindow(this.address());
        }

        public int x() {
            return XExposeEvent.nx(this.address());
        }

        public int y() {
            return XExposeEvent.ny(this.address());
        }

        public int width() {
            return XExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XExposeEvent.nheight(this.address());
        }

        public int count() {
            return XExposeEvent.ncount(this.address());
        }

        public Buffer type(int param1) {
            XExposeEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XExposeEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XExposeEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XExposeEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XExposeEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XExposeEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer width(int param1) {
            XExposeEvent.nwidth(this.address(), param1);
            return this;
        }

        public Buffer height(int param1) {
            XExposeEvent.nheight(this.address(), param1);
            return this;
        }

        public Buffer count(int param1) {
            XExposeEvent.ncount(this.address(), param1);
            return this;
        }
    }
}

