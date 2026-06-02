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

public class XKeymapEvent
extends Struct<XKeymapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int KEY_VECTOR;

    protected XKeymapEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XKeymapEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XKeymapEvent(param1, param3);
    }

    public XKeymapEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XKeymapEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeymapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeymapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeymapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeymapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeymapEvent.nwindow(this.address());
    }

    @NativeType(value="char[32]")
    public ByteBuffer key_vector() {
        return XKeymapEvent.nkey_vector(this.address());
    }

    @NativeType(value="char")
    public byte key_vector(int param1) {
        return XKeymapEvent.nkey_vector(this.address(), param1);
    }

    public XKeymapEvent type(int param1) {
        XKeymapEvent.ntype(this.address(), param1);
        return this;
    }

    public XKeymapEvent serial(@NativeType(value="unsigned long") long param1) {
        XKeymapEvent.nserial(this.address(), param1);
        return this;
    }

    public XKeymapEvent send_event(@NativeType(value="Bool") boolean param1) {
        XKeymapEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XKeymapEvent display(@NativeType(value="Display *") long param1) {
        XKeymapEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XKeymapEvent window(@NativeType(value="Window") long param1) {
        XKeymapEvent.nwindow(this.address(), param1);
        return this;
    }

    public XKeymapEvent key_vector(@NativeType(value="char[32]") ByteBuffer param1) {
        XKeymapEvent.nkey_vector(this.address(), param1);
        return this;
    }

    public XKeymapEvent key_vector(int param1, @NativeType(value="char") byte param2) {
        XKeymapEvent.nkey_vector(this.address(), param1, param2);
        return this;
    }

    public XKeymapEvent set(int param1, long param2, boolean param4, long param5, long param7, ByteBuffer param9) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.key_vector(param9);
        return this;
    }

    public XKeymapEvent set(XKeymapEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeymapEvent malloc() {
        return new XKeymapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XKeymapEvent calloc() {
        return new XKeymapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XKeymapEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XKeymapEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XKeymapEvent create(long param0) {
        return new XKeymapEvent(param0, null);
    }

    @Nullable
    public static XKeymapEvent createSafe(long param0) {
        return param0 == 0L ? null : new XKeymapEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XKeymapEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XKeymapEvent.__create(param0, SIZEOF);
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
    public static XKeymapEvent mallocStack() {
        return XKeymapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent callocStack() {
        return XKeymapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent mallocStack(MemoryStack param0) {
        return XKeymapEvent.malloc(param0);
    }

    @Deprecated
    public static XKeymapEvent callocStack(MemoryStack param0) {
        return XKeymapEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XKeymapEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XKeymapEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XKeymapEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XKeymapEvent.calloc(param0, param1);
    }

    public static XKeymapEvent malloc(MemoryStack param0) {
        return new XKeymapEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XKeymapEvent calloc(MemoryStack param0) {
        return new XKeymapEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static ByteBuffer nkey_vector(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)KEY_VECTOR, 32);
    }

    public static byte nkey_vector(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)KEY_VECTOR + Checks.check(param2, 32) * 1L);
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

    public static void nkey_vector(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 32);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)KEY_VECTOR, param2.remaining() * 1);
    }

    public static void nkey_vector(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)KEY_VECTOR + Checks.check(param2, 32) * 1L, param3);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XKeymapEvent.__struct(XKeymapEvent.__member(4), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__member(4), XKeymapEvent.__member(POINTER_SIZE), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__array(1, 32));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        KEY_VECTOR = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XKeymapEvent, Buffer>
    implements NativeResource {
        private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);

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
        protected XKeymapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeymapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeymapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeymapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeymapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeymapEvent.nwindow(this.address());
        }

        @NativeType(value="char[32]")
        public ByteBuffer key_vector() {
            return XKeymapEvent.nkey_vector(this.address());
        }

        @NativeType(value="char")
        public byte key_vector(int param1) {
            return XKeymapEvent.nkey_vector(this.address(), param1);
        }

        public Buffer type(int param1) {
            XKeymapEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XKeymapEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XKeymapEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XKeymapEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XKeymapEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer key_vector(@NativeType(value="char[32]") ByteBuffer param1) {
            XKeymapEvent.nkey_vector(this.address(), param1);
            return this;
        }

        public Buffer key_vector(int param1, @NativeType(value="char") byte param2) {
            XKeymapEvent.nkey_vector(this.address(), param1, param2);
            return this;
        }
    }
}

