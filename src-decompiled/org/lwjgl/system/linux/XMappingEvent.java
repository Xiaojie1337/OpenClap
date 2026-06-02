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

public class XMappingEvent
extends Struct<XMappingEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int REQUEST;
    public static final int FIRST_KEYCODE;
    public static final int COUNT;

    protected XMappingEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XMappingEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XMappingEvent(param1, param3);
    }

    public XMappingEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XMappingEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMappingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMappingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMappingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMappingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMappingEvent.nwindow(this.address());
    }

    public int request() {
        return XMappingEvent.nrequest(this.address());
    }

    public int first_keycode() {
        return XMappingEvent.nfirst_keycode(this.address());
    }

    public int count() {
        return XMappingEvent.ncount(this.address());
    }

    public XMappingEvent type(int param1) {
        XMappingEvent.ntype(this.address(), param1);
        return this;
    }

    public XMappingEvent serial(@NativeType(value="unsigned long") long param1) {
        XMappingEvent.nserial(this.address(), param1);
        return this;
    }

    public XMappingEvent send_event(@NativeType(value="Bool") boolean param1) {
        XMappingEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XMappingEvent display(@NativeType(value="Display *") long param1) {
        XMappingEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XMappingEvent window(@NativeType(value="Window") long param1) {
        XMappingEvent.nwindow(this.address(), param1);
        return this;
    }

    public XMappingEvent request(int param1) {
        XMappingEvent.nrequest(this.address(), param1);
        return this;
    }

    public XMappingEvent first_keycode(int param1) {
        XMappingEvent.nfirst_keycode(this.address(), param1);
        return this;
    }

    public XMappingEvent count(int param1) {
        XMappingEvent.ncount(this.address(), param1);
        return this;
    }

    public XMappingEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9, int param10, int param11) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.request(param9);
        this.first_keycode(param10);
        this.count(param11);
        return this;
    }

    public XMappingEvent set(XMappingEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMappingEvent malloc() {
        return new XMappingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMappingEvent calloc() {
        return new XMappingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMappingEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XMappingEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XMappingEvent create(long param0) {
        return new XMappingEvent(param0, null);
    }

    @Nullable
    public static XMappingEvent createSafe(long param0) {
        return param0 == 0L ? null : new XMappingEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMappingEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XMappingEvent.__create(param0, SIZEOF);
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
    public static XMappingEvent mallocStack() {
        return XMappingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent callocStack() {
        return XMappingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent mallocStack(MemoryStack param0) {
        return XMappingEvent.malloc(param0);
    }

    @Deprecated
    public static XMappingEvent callocStack(MemoryStack param0) {
        return XMappingEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XMappingEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XMappingEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XMappingEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XMappingEvent.calloc(param0, param1);
    }

    public static XMappingEvent malloc(MemoryStack param0) {
        return new XMappingEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMappingEvent calloc(MemoryStack param0) {
        return new XMappingEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nrequest(long param0) {
        return UNSAFE.getInt(null, param0 + (long)REQUEST);
    }

    public static int nfirst_keycode(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FIRST_KEYCODE);
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

    public static void nrequest(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)REQUEST, param2);
    }

    public static void nfirst_keycode(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FIRST_KEYCODE, param2);
    }

    public static void ncount(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)COUNT, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XMappingEvent.__struct(XMappingEvent.__member(4), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(POINTER_SIZE), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(4), XMappingEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        REQUEST = v0.offsetof(5);
        FIRST_KEYCODE = v0.offsetof(6);
        COUNT = v0.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XMappingEvent, Buffer>
    implements NativeResource {
        private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);

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
        protected XMappingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMappingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMappingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMappingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMappingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMappingEvent.nwindow(this.address());
        }

        public int request() {
            return XMappingEvent.nrequest(this.address());
        }

        public int first_keycode() {
            return XMappingEvent.nfirst_keycode(this.address());
        }

        public int count() {
            return XMappingEvent.ncount(this.address());
        }

        public Buffer type(int param1) {
            XMappingEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XMappingEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XMappingEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XMappingEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XMappingEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer request(int param1) {
            XMappingEvent.nrequest(this.address(), param1);
            return this;
        }

        public Buffer first_keycode(int param1) {
            XMappingEvent.nfirst_keycode(this.address(), param1);
            return this;
        }

        public Buffer count(int param1) {
            XMappingEvent.ncount(this.address(), param1);
            return this;
        }
    }
}

