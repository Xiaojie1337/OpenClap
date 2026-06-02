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

public class XPropertyEvent
extends Struct<XPropertyEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ATOM;
    public static final int TIME;
    public static final int STATE;

    protected XPropertyEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XPropertyEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XPropertyEvent(param1, param3);
    }

    public XPropertyEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XPropertyEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XPropertyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XPropertyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XPropertyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XPropertyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XPropertyEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long atom() {
        return XPropertyEvent.natom(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XPropertyEvent.ntime(this.address());
    }

    public int state() {
        return XPropertyEvent.nstate(this.address());
    }

    public XPropertyEvent type(int param1) {
        XPropertyEvent.ntype(this.address(), param1);
        return this;
    }

    public XPropertyEvent serial(@NativeType(value="unsigned long") long param1) {
        XPropertyEvent.nserial(this.address(), param1);
        return this;
    }

    public XPropertyEvent send_event(@NativeType(value="Bool") boolean param1) {
        XPropertyEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XPropertyEvent display(@NativeType(value="Display *") long param1) {
        XPropertyEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XPropertyEvent window(@NativeType(value="Window") long param1) {
        XPropertyEvent.nwindow(this.address(), param1);
        return this;
    }

    public XPropertyEvent atom(@NativeType(value="Atom") long param1) {
        XPropertyEvent.natom(this.address(), param1);
        return this;
    }

    public XPropertyEvent time(@NativeType(value="Time") long param1) {
        XPropertyEvent.ntime(this.address(), param1);
        return this;
    }

    public XPropertyEvent state(int param1) {
        XPropertyEvent.nstate(this.address(), param1);
        return this;
    }

    public XPropertyEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, long param11, int param13) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.atom(param9);
        this.time(param11);
        this.state(param13);
        return this;
    }

    public XPropertyEvent set(XPropertyEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XPropertyEvent malloc() {
        return new XPropertyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XPropertyEvent calloc() {
        return new XPropertyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XPropertyEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XPropertyEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XPropertyEvent create(long param0) {
        return new XPropertyEvent(param0, null);
    }

    @Nullable
    public static XPropertyEvent createSafe(long param0) {
        return param0 == 0L ? null : new XPropertyEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XPropertyEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XPropertyEvent.__create(param0, SIZEOF);
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
    public static XPropertyEvent mallocStack() {
        return XPropertyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent callocStack() {
        return XPropertyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent mallocStack(MemoryStack param0) {
        return XPropertyEvent.malloc(param0);
    }

    @Deprecated
    public static XPropertyEvent callocStack(MemoryStack param0) {
        return XPropertyEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XPropertyEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XPropertyEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XPropertyEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XPropertyEvent.calloc(param0, param1);
    }

    public static XPropertyEvent malloc(MemoryStack param0) {
        return new XPropertyEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XPropertyEvent calloc(MemoryStack param0) {
        return new XPropertyEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long natom(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)ATOM);
    }

    public static long ntime(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)TIME);
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

    public static void natom(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)ATOM, param2);
    }

    public static void ntime(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)TIME, param2);
    }

    public static void nstate(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XPropertyEvent.__struct(XPropertyEvent.__member(4), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4), XPropertyEvent.__member(POINTER_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        ATOM = v0.offsetof(5);
        TIME = v0.offsetof(6);
        STATE = v0.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XPropertyEvent, Buffer>
    implements NativeResource {
        private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);

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
        protected XPropertyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XPropertyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XPropertyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XPropertyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XPropertyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XPropertyEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long atom() {
            return XPropertyEvent.natom(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XPropertyEvent.ntime(this.address());
        }

        public int state() {
            return XPropertyEvent.nstate(this.address());
        }

        public Buffer type(int param1) {
            XPropertyEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XPropertyEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XPropertyEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XPropertyEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XPropertyEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer atom(@NativeType(value="Atom") long param1) {
            XPropertyEvent.natom(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long param1) {
            XPropertyEvent.ntime(this.address(), param1);
            return this;
        }

        public Buffer state(int param1) {
            XPropertyEvent.nstate(this.address(), param1);
            return this;
        }
    }
}

