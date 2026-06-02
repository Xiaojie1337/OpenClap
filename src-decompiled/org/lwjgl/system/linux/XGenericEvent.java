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

public class XGenericEvent
extends Struct<XGenericEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;

    protected XGenericEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XGenericEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XGenericEvent(param1, param3);
    }

    public XGenericEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XGenericEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEvent.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEvent.nextension(this.address());
    }

    public int evtype() {
        return XGenericEvent.nevtype(this.address());
    }

    public XGenericEvent type(int param1) {
        XGenericEvent.ntype(this.address(), param1);
        return this;
    }

    public XGenericEvent serial(@NativeType(value="unsigned long") long param1) {
        XGenericEvent.nserial(this.address(), param1);
        return this;
    }

    public XGenericEvent send_event(@NativeType(value="Bool") boolean param1) {
        XGenericEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XGenericEvent display(@NativeType(value="Display *") long param1) {
        XGenericEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XGenericEvent extension(int param1) {
        XGenericEvent.nextension(this.address(), param1);
        return this;
    }

    public XGenericEvent evtype(int param1) {
        XGenericEvent.nevtype(this.address(), param1);
        return this;
    }

    public XGenericEvent set(int param1, long param2, boolean param4, long param5, int param7, int param8) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.extension(param7);
        this.evtype(param8);
        return this;
    }

    public XGenericEvent set(XGenericEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEvent malloc() {
        return new XGenericEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XGenericEvent calloc() {
        return new XGenericEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XGenericEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XGenericEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XGenericEvent create(long param0) {
        return new XGenericEvent(param0, null);
    }

    @Nullable
    public static XGenericEvent createSafe(long param0) {
        return param0 == 0L ? null : new XGenericEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XGenericEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XGenericEvent.__create(param0, SIZEOF);
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
    public static XGenericEvent mallocStack() {
        return XGenericEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent callocStack() {
        return XGenericEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent mallocStack(MemoryStack param0) {
        return XGenericEvent.malloc(param0);
    }

    @Deprecated
    public static XGenericEvent callocStack(MemoryStack param0) {
        return XGenericEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XGenericEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XGenericEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XGenericEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XGenericEvent.calloc(param0, param1);
    }

    public static XGenericEvent malloc(MemoryStack param0) {
        return new XGenericEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XGenericEvent calloc(MemoryStack param0) {
        return new XGenericEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nextension(long param0) {
        return UNSAFE.getInt(null, param0 + (long)EXTENSION);
    }

    public static int nevtype(long param0) {
        return UNSAFE.getInt(null, param0 + (long)EVTYPE);
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

    public static void nextension(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)EXTENSION, param2);
    }

    public static void nevtype(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)EVTYPE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XGenericEvent.__struct(XGenericEvent.__member(4), XGenericEvent.__member(CLONG_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(POINTER_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        EXTENSION = v0.offsetof(4);
        EVTYPE = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XGenericEvent, Buffer>
    implements NativeResource {
        private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);

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
        protected XGenericEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEvent.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEvent.nextension(this.address());
        }

        public int evtype() {
            return XGenericEvent.nevtype(this.address());
        }

        public Buffer type(int param1) {
            XGenericEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XGenericEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XGenericEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XGenericEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer extension(int param1) {
            XGenericEvent.nextension(this.address(), param1);
            return this;
        }

        public Buffer evtype(int param1) {
            XGenericEvent.nevtype(this.address(), param1);
            return this;
        }
    }
}

