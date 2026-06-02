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

public class XVisibilityEvent
extends Struct<XVisibilityEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int STATE;

    protected XVisibilityEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XVisibilityEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XVisibilityEvent(param1, param3);
    }

    public XVisibilityEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XVisibilityEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XVisibilityEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XVisibilityEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XVisibilityEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XVisibilityEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XVisibilityEvent.nwindow(this.address());
    }

    public int state() {
        return XVisibilityEvent.nstate(this.address());
    }

    public XVisibilityEvent type(int param1) {
        XVisibilityEvent.ntype(this.address(), param1);
        return this;
    }

    public XVisibilityEvent serial(@NativeType(value="unsigned long") long param1) {
        XVisibilityEvent.nserial(this.address(), param1);
        return this;
    }

    public XVisibilityEvent send_event(@NativeType(value="Bool") boolean param1) {
        XVisibilityEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XVisibilityEvent display(@NativeType(value="Display *") long param1) {
        XVisibilityEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XVisibilityEvent window(@NativeType(value="Window") long param1) {
        XVisibilityEvent.nwindow(this.address(), param1);
        return this;
    }

    public XVisibilityEvent state(int param1) {
        XVisibilityEvent.nstate(this.address(), param1);
        return this;
    }

    public XVisibilityEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.state(param9);
        return this;
    }

    public XVisibilityEvent set(XVisibilityEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XVisibilityEvent malloc() {
        return new XVisibilityEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XVisibilityEvent calloc() {
        return new XVisibilityEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XVisibilityEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XVisibilityEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XVisibilityEvent create(long param0) {
        return new XVisibilityEvent(param0, null);
    }

    @Nullable
    public static XVisibilityEvent createSafe(long param0) {
        return param0 == 0L ? null : new XVisibilityEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XVisibilityEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XVisibilityEvent.__create(param0, SIZEOF);
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
    public static XVisibilityEvent mallocStack() {
        return XVisibilityEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisibilityEvent callocStack() {
        return XVisibilityEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XVisibilityEvent mallocStack(MemoryStack param0) {
        return XVisibilityEvent.malloc(param0);
    }

    @Deprecated
    public static XVisibilityEvent callocStack(MemoryStack param0) {
        return XVisibilityEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XVisibilityEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XVisibilityEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XVisibilityEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XVisibilityEvent.calloc(param0, param1);
    }

    public static XVisibilityEvent malloc(MemoryStack param0) {
        return new XVisibilityEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XVisibilityEvent calloc(MemoryStack param0) {
        return new XVisibilityEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void nstate(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XVisibilityEvent.__struct(XVisibilityEvent.__member(4), XVisibilityEvent.__member(CLONG_SIZE), XVisibilityEvent.__member(4), XVisibilityEvent.__member(POINTER_SIZE), XVisibilityEvent.__member(CLONG_SIZE), XVisibilityEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        STATE = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XVisibilityEvent, Buffer>
    implements NativeResource {
        private static final XVisibilityEvent ELEMENT_FACTORY = XVisibilityEvent.create(-1L);

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
        protected XVisibilityEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XVisibilityEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XVisibilityEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XVisibilityEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XVisibilityEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XVisibilityEvent.nwindow(this.address());
        }

        public int state() {
            return XVisibilityEvent.nstate(this.address());
        }

        public Buffer type(int param1) {
            XVisibilityEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XVisibilityEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XVisibilityEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XVisibilityEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XVisibilityEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer state(int param1) {
            XVisibilityEvent.nstate(this.address(), param1);
            return this;
        }
    }
}

