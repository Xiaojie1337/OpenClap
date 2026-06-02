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

public class XDestroyWindowEvent
extends Struct<XDestroyWindowEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;

    protected XDestroyWindowEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XDestroyWindowEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XDestroyWindowEvent(param1, param3);
    }

    public XDestroyWindowEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XDestroyWindowEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XDestroyWindowEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XDestroyWindowEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XDestroyWindowEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XDestroyWindowEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XDestroyWindowEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XDestroyWindowEvent.nwindow(this.address());
    }

    public XDestroyWindowEvent type(int param1) {
        XDestroyWindowEvent.ntype(this.address(), param1);
        return this;
    }

    public XDestroyWindowEvent serial(@NativeType(value="unsigned long") long param1) {
        XDestroyWindowEvent.nserial(this.address(), param1);
        return this;
    }

    public XDestroyWindowEvent send_event(@NativeType(value="Bool") boolean param1) {
        XDestroyWindowEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XDestroyWindowEvent display(@NativeType(value="Display *") long param1) {
        XDestroyWindowEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XDestroyWindowEvent event(@NativeType(value="Window") long param1) {
        XDestroyWindowEvent.nevent(this.address(), param1);
        return this;
    }

    public XDestroyWindowEvent window(@NativeType(value="Window") long param1) {
        XDestroyWindowEvent.nwindow(this.address(), param1);
        return this;
    }

    public XDestroyWindowEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.event(param7);
        this.window(param9);
        return this;
    }

    public XDestroyWindowEvent set(XDestroyWindowEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XDestroyWindowEvent malloc() {
        return new XDestroyWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XDestroyWindowEvent calloc() {
        return new XDestroyWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XDestroyWindowEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XDestroyWindowEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XDestroyWindowEvent create(long param0) {
        return new XDestroyWindowEvent(param0, null);
    }

    @Nullable
    public static XDestroyWindowEvent createSafe(long param0) {
        return param0 == 0L ? null : new XDestroyWindowEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XDestroyWindowEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XDestroyWindowEvent.__create(param0, SIZEOF);
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
    public static XDestroyWindowEvent mallocStack() {
        return XDestroyWindowEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XDestroyWindowEvent callocStack() {
        return XDestroyWindowEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XDestroyWindowEvent mallocStack(MemoryStack param0) {
        return XDestroyWindowEvent.malloc(param0);
    }

    @Deprecated
    public static XDestroyWindowEvent callocStack(MemoryStack param0) {
        return XDestroyWindowEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XDestroyWindowEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XDestroyWindowEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XDestroyWindowEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XDestroyWindowEvent.calloc(param0, param1);
    }

    public static XDestroyWindowEvent malloc(MemoryStack param0) {
        return new XDestroyWindowEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XDestroyWindowEvent calloc(MemoryStack param0) {
        return new XDestroyWindowEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nevent(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)EVENT);
    }

    public static long nwindow(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)WINDOW);
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

    public static void nevent(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)EVENT, param2);
    }

    public static void nwindow(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)WINDOW, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XDestroyWindowEvent.__struct(XDestroyWindowEvent.__member(4), XDestroyWindowEvent.__member(CLONG_SIZE), XDestroyWindowEvent.__member(4), XDestroyWindowEvent.__member(POINTER_SIZE), XDestroyWindowEvent.__member(CLONG_SIZE), XDestroyWindowEvent.__member(CLONG_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        EVENT = v0.offsetof(4);
        WINDOW = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XDestroyWindowEvent, Buffer>
    implements NativeResource {
        private static final XDestroyWindowEvent ELEMENT_FACTORY = XDestroyWindowEvent.create(-1L);

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
        protected XDestroyWindowEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XDestroyWindowEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XDestroyWindowEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XDestroyWindowEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XDestroyWindowEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XDestroyWindowEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XDestroyWindowEvent.nwindow(this.address());
        }

        public Buffer type(int param1) {
            XDestroyWindowEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XDestroyWindowEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XDestroyWindowEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XDestroyWindowEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long param1) {
            XDestroyWindowEvent.nevent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XDestroyWindowEvent.nwindow(this.address(), param1);
            return this;
        }
    }
}

