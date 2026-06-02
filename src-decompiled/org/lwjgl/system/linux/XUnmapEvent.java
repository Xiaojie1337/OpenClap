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

public class XUnmapEvent
extends Struct<XUnmapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int FROM_CONFIGURE;

    protected XUnmapEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XUnmapEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XUnmapEvent(param1, param3);
    }

    public XUnmapEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XUnmapEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XUnmapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XUnmapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XUnmapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XUnmapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XUnmapEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XUnmapEvent.nwindow(this.address());
    }

    public int from_configure() {
        return XUnmapEvent.nfrom_configure(this.address());
    }

    public XUnmapEvent type(int param1) {
        XUnmapEvent.ntype(this.address(), param1);
        return this;
    }

    public XUnmapEvent serial(@NativeType(value="unsigned long") long param1) {
        XUnmapEvent.nserial(this.address(), param1);
        return this;
    }

    public XUnmapEvent send_event(@NativeType(value="Bool") boolean param1) {
        XUnmapEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XUnmapEvent display(@NativeType(value="Display *") long param1) {
        XUnmapEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XUnmapEvent event(@NativeType(value="Window") long param1) {
        XUnmapEvent.nevent(this.address(), param1);
        return this;
    }

    public XUnmapEvent window(@NativeType(value="Window") long param1) {
        XUnmapEvent.nwindow(this.address(), param1);
        return this;
    }

    public XUnmapEvent from_configure(int param1) {
        XUnmapEvent.nfrom_configure(this.address(), param1);
        return this;
    }

    public XUnmapEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.event(param7);
        this.window(param9);
        this.from_configure(param11);
        return this;
    }

    public XUnmapEvent set(XUnmapEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XUnmapEvent malloc() {
        return new XUnmapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XUnmapEvent calloc() {
        return new XUnmapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XUnmapEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XUnmapEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XUnmapEvent create(long param0) {
        return new XUnmapEvent(param0, null);
    }

    @Nullable
    public static XUnmapEvent createSafe(long param0) {
        return param0 == 0L ? null : new XUnmapEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XUnmapEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XUnmapEvent.__create(param0, SIZEOF);
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
    public static XUnmapEvent mallocStack() {
        return XUnmapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XUnmapEvent callocStack() {
        return XUnmapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XUnmapEvent mallocStack(MemoryStack param0) {
        return XUnmapEvent.malloc(param0);
    }

    @Deprecated
    public static XUnmapEvent callocStack(MemoryStack param0) {
        return XUnmapEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XUnmapEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XUnmapEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XUnmapEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XUnmapEvent.calloc(param0, param1);
    }

    public static XUnmapEvent malloc(MemoryStack param0) {
        return new XUnmapEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XUnmapEvent calloc(MemoryStack param0) {
        return new XUnmapEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nfrom_configure(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FROM_CONFIGURE);
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

    public static void nfrom_configure(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FROM_CONFIGURE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XUnmapEvent.__struct(XUnmapEvent.__member(4), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(4), XUnmapEvent.__member(POINTER_SIZE), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(CLONG_SIZE), XUnmapEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        EVENT = v0.offsetof(4);
        WINDOW = v0.offsetof(5);
        FROM_CONFIGURE = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XUnmapEvent, Buffer>
    implements NativeResource {
        private static final XUnmapEvent ELEMENT_FACTORY = XUnmapEvent.create(-1L);

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
        protected XUnmapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XUnmapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XUnmapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XUnmapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XUnmapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XUnmapEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XUnmapEvent.nwindow(this.address());
        }

        public int from_configure() {
            return XUnmapEvent.nfrom_configure(this.address());
        }

        public Buffer type(int param1) {
            XUnmapEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XUnmapEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XUnmapEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XUnmapEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long param1) {
            XUnmapEvent.nevent(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XUnmapEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer from_configure(int param1) {
            XUnmapEvent.nfrom_configure(this.address(), param1);
            return this;
        }
    }
}

