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

public class XMapRequestEvent
extends Struct<XMapRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;

    protected XMapRequestEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XMapRequestEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XMapRequestEvent(param1, param3);
    }

    public XMapRequestEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XMapRequestEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XMapRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapRequestEvent.nwindow(this.address());
    }

    public XMapRequestEvent type(int param1) {
        XMapRequestEvent.ntype(this.address(), param1);
        return this;
    }

    public XMapRequestEvent serial(@NativeType(value="unsigned long") long param1) {
        XMapRequestEvent.nserial(this.address(), param1);
        return this;
    }

    public XMapRequestEvent send_event(@NativeType(value="Bool") boolean param1) {
        XMapRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XMapRequestEvent display(@NativeType(value="Display *") long param1) {
        XMapRequestEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XMapRequestEvent parent(@NativeType(value="Window") long param1) {
        XMapRequestEvent.nparent(this.address(), param1);
        return this;
    }

    public XMapRequestEvent window(@NativeType(value="Window") long param1) {
        XMapRequestEvent.nwindow(this.address(), param1);
        return this;
    }

    public XMapRequestEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.parent(param7);
        this.window(param9);
        return this;
    }

    public XMapRequestEvent set(XMapRequestEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapRequestEvent malloc() {
        return new XMapRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMapRequestEvent calloc() {
        return new XMapRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMapRequestEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XMapRequestEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XMapRequestEvent create(long param0) {
        return new XMapRequestEvent(param0, null);
    }

    @Nullable
    public static XMapRequestEvent createSafe(long param0) {
        return param0 == 0L ? null : new XMapRequestEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMapRequestEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XMapRequestEvent.__create(param0, SIZEOF);
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
    public static XMapRequestEvent mallocStack() {
        return XMapRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent callocStack() {
        return XMapRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent mallocStack(MemoryStack param0) {
        return XMapRequestEvent.malloc(param0);
    }

    @Deprecated
    public static XMapRequestEvent callocStack(MemoryStack param0) {
        return XMapRequestEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XMapRequestEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XMapRequestEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XMapRequestEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XMapRequestEvent.calloc(param0, param1);
    }

    public static XMapRequestEvent malloc(MemoryStack param0) {
        return new XMapRequestEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMapRequestEvent calloc(MemoryStack param0) {
        return new XMapRequestEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XMapRequestEvent.__struct(XMapRequestEvent.__member(4), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(4), XMapRequestEvent.__member(POINTER_SIZE), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(CLONG_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        PARENT = v0.offsetof(4);
        WINDOW = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XMapRequestEvent, Buffer>
    implements NativeResource {
        private static final XMapRequestEvent ELEMENT_FACTORY = XMapRequestEvent.create(-1L);

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
        protected XMapRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XMapRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapRequestEvent.nwindow(this.address());
        }

        public Buffer type(int param1) {
            XMapRequestEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XMapRequestEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XMapRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XMapRequestEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long param1) {
            XMapRequestEvent.nparent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XMapRequestEvent.nwindow(this.address(), param1);
            return this;
        }
    }
}

