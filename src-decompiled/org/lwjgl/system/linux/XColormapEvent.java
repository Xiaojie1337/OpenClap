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

public class XColormapEvent
extends Struct<XColormapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int COLORMAP;
    public static final int NEW;
    public static final int STATE;

    protected XColormapEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XColormapEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XColormapEvent(param1, param3);
    }

    public XColormapEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XColormapEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XColormapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XColormapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XColormapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XColormapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XColormapEvent.nwindow(this.address());
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XColormapEvent.ncolormap(this.address());
    }

    public int new$() {
        return XColormapEvent.nnew$(this.address());
    }

    public int state() {
        return XColormapEvent.nstate(this.address());
    }

    public XColormapEvent type(int param1) {
        XColormapEvent.ntype(this.address(), param1);
        return this;
    }

    public XColormapEvent serial(@NativeType(value="unsigned long") long param1) {
        XColormapEvent.nserial(this.address(), param1);
        return this;
    }

    public XColormapEvent send_event(@NativeType(value="Bool") boolean param1) {
        XColormapEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XColormapEvent display(@NativeType(value="Display *") long param1) {
        XColormapEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XColormapEvent window(@NativeType(value="Window") long param1) {
        XColormapEvent.nwindow(this.address(), param1);
        return this;
    }

    public XColormapEvent colormap(@NativeType(value="Colormap") long param1) {
        XColormapEvent.ncolormap(this.address(), param1);
        return this;
    }

    public XColormapEvent new$(int param1) {
        XColormapEvent.nnew$(this.address(), param1);
        return this;
    }

    public XColormapEvent state(int param1) {
        XColormapEvent.nstate(this.address(), param1);
        return this;
    }

    public XColormapEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11, int param12) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.colormap(param9);
        this.new$(param11);
        this.state(param12);
        return this;
    }

    public XColormapEvent set(XColormapEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XColormapEvent malloc() {
        return new XColormapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XColormapEvent calloc() {
        return new XColormapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XColormapEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XColormapEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XColormapEvent create(long param0) {
        return new XColormapEvent(param0, null);
    }

    @Nullable
    public static XColormapEvent createSafe(long param0) {
        return param0 == 0L ? null : new XColormapEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XColormapEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XColormapEvent.__create(param0, SIZEOF);
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
    public static XColormapEvent mallocStack() {
        return XColormapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent callocStack() {
        return XColormapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent mallocStack(MemoryStack param0) {
        return XColormapEvent.malloc(param0);
    }

    @Deprecated
    public static XColormapEvent callocStack(MemoryStack param0) {
        return XColormapEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XColormapEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XColormapEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XColormapEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XColormapEvent.calloc(param0, param1);
    }

    public static XColormapEvent malloc(MemoryStack param0) {
        return new XColormapEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XColormapEvent calloc(MemoryStack param0) {
        return new XColormapEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long ncolormap(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)COLORMAP);
    }

    public static int nnew$(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NEW);
    }

    public static int nstate(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STATE);
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

    public static void ncolormap(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)COLORMAP, param2);
    }

    public static void nnew$(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NEW, param2);
    }

    public static void nstate(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XColormapEvent.__struct(XColormapEvent.__member(4), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(POINTER_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        COLORMAP = v0.offsetof(5);
        NEW = v0.offsetof(6);
        STATE = v0.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XColormapEvent, Buffer>
    implements NativeResource {
        private static final XColormapEvent ELEMENT_FACTORY = XColormapEvent.create(-1L);

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
        protected XColormapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XColormapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XColormapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XColormapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XColormapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XColormapEvent.nwindow(this.address());
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XColormapEvent.ncolormap(this.address());
        }

        public int new$() {
            return XColormapEvent.nnew$(this.address());
        }

        public int state() {
            return XColormapEvent.nstate(this.address());
        }

        public Buffer type(int param1) {
            XColormapEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XColormapEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XColormapEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XColormapEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XColormapEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long param1) {
            XColormapEvent.ncolormap(this.address(), param1);
            return this;
        }

        public Buffer new$(int param1) {
            XColormapEvent.nnew$(this.address(), param1);
            return this;
        }

        public Buffer state(int param1) {
            XColormapEvent.nstate(this.address(), param1);
            return this;
        }
    }
}

