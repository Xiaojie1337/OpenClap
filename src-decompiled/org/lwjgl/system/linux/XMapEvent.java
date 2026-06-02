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

public class XMapEvent
extends Struct<XMapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int OVERRIDE_REDIRECT;

    protected XMapEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XMapEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XMapEvent(param1, param3);
    }

    public XMapEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XMapEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XMapEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapEvent.nwindow(this.address());
    }

    public int override_redirect() {
        return XMapEvent.noverride_redirect(this.address());
    }

    public XMapEvent type(int param1) {
        XMapEvent.ntype(this.address(), param1);
        return this;
    }

    public XMapEvent serial(@NativeType(value="unsigned long") long param1) {
        XMapEvent.nserial(this.address(), param1);
        return this;
    }

    public XMapEvent send_event(@NativeType(value="Bool") boolean param1) {
        XMapEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XMapEvent display(@NativeType(value="Display *") long param1) {
        XMapEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XMapEvent event(@NativeType(value="Window") long param1) {
        XMapEvent.nevent(this.address(), param1);
        return this;
    }

    public XMapEvent window(@NativeType(value="Window") long param1) {
        XMapEvent.nwindow(this.address(), param1);
        return this;
    }

    public XMapEvent override_redirect(int param1) {
        XMapEvent.noverride_redirect(this.address(), param1);
        return this;
    }

    public XMapEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.event(param7);
        this.window(param9);
        this.override_redirect(param11);
        return this;
    }

    public XMapEvent set(XMapEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapEvent malloc() {
        return new XMapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMapEvent calloc() {
        return new XMapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMapEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XMapEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XMapEvent create(long param0) {
        return new XMapEvent(param0, null);
    }

    @Nullable
    public static XMapEvent createSafe(long param0) {
        return param0 == 0L ? null : new XMapEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMapEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XMapEvent.__create(param0, SIZEOF);
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
    public static XMapEvent mallocStack() {
        return XMapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent callocStack() {
        return XMapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent mallocStack(MemoryStack param0) {
        return XMapEvent.malloc(param0);
    }

    @Deprecated
    public static XMapEvent callocStack(MemoryStack param0) {
        return XMapEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XMapEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XMapEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XMapEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XMapEvent.calloc(param0, param1);
    }

    public static XMapEvent malloc(MemoryStack param0) {
        return new XMapEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMapEvent calloc(MemoryStack param0) {
        return new XMapEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void nevent(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)EVENT, param2);
    }

    public static void nwindow(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)WINDOW, param2);
    }

    public static void noverride_redirect(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OVERRIDE_REDIRECT, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XMapEvent.__struct(XMapEvent.__member(4), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4), XMapEvent.__member(POINTER_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        EVENT = v0.offsetof(4);
        WINDOW = v0.offsetof(5);
        OVERRIDE_REDIRECT = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XMapEvent, Buffer>
    implements NativeResource {
        private static final XMapEvent ELEMENT_FACTORY = XMapEvent.create(-1L);

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
        protected XMapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XMapEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapEvent.nwindow(this.address());
        }

        public int override_redirect() {
            return XMapEvent.noverride_redirect(this.address());
        }

        public Buffer type(int param1) {
            XMapEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XMapEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XMapEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XMapEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long param1) {
            XMapEvent.nevent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XMapEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer override_redirect(int param1) {
            XMapEvent.noverride_redirect(this.address(), param1);
            return this;
        }
    }
}

