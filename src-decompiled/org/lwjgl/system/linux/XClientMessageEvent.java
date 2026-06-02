/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XClientMessageEvent
extends Struct<XClientMessageEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int MESSAGE_TYPE;
    public static final int FORMAT;
    public static final int DATA;
    public static final int DATA_B;
    public static final int DATA_S;
    public static final int DATA_L;

    protected XClientMessageEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XClientMessageEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XClientMessageEvent(param1, param3);
    }

    public XClientMessageEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XClientMessageEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XClientMessageEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XClientMessageEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XClientMessageEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XClientMessageEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XClientMessageEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long message_type() {
        return XClientMessageEvent.nmessage_type(this.address());
    }

    public int format() {
        return XClientMessageEvent.nformat(this.address());
    }

    @NativeType(value="char[20]")
    public ByteBuffer data_b() {
        return XClientMessageEvent.ndata_b(this.address());
    }

    @NativeType(value="char")
    public byte data_b(int param1) {
        return XClientMessageEvent.ndata_b(this.address(), param1);
    }

    @NativeType(value="short[10]")
    public ShortBuffer data_s() {
        return XClientMessageEvent.ndata_s(this.address());
    }

    public short data_s(int param1) {
        return XClientMessageEvent.ndata_s(this.address(), param1);
    }

    @NativeType(value="long[5]")
    public CLongBuffer data_l() {
        return XClientMessageEvent.ndata_l(this.address());
    }

    public long data_l(int param1) {
        return XClientMessageEvent.ndata_l(this.address(), param1);
    }

    public XClientMessageEvent type(int param1) {
        XClientMessageEvent.ntype(this.address(), param1);
        return this;
    }

    public XClientMessageEvent serial(@NativeType(value="unsigned long") long param1) {
        XClientMessageEvent.nserial(this.address(), param1);
        return this;
    }

    public XClientMessageEvent send_event(@NativeType(value="Bool") boolean param1) {
        XClientMessageEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XClientMessageEvent display(@NativeType(value="Display *") long param1) {
        XClientMessageEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XClientMessageEvent window(@NativeType(value="Window") long param1) {
        XClientMessageEvent.nwindow(this.address(), param1);
        return this;
    }

    public XClientMessageEvent message_type(@NativeType(value="Atom") long param1) {
        XClientMessageEvent.nmessage_type(this.address(), param1);
        return this;
    }

    public XClientMessageEvent format(int param1) {
        XClientMessageEvent.nformat(this.address(), param1);
        return this;
    }

    public XClientMessageEvent data_b(@NativeType(value="char[20]") ByteBuffer param1) {
        XClientMessageEvent.ndata_b(this.address(), param1);
        return this;
    }

    public XClientMessageEvent data_b(int param1, @NativeType(value="char") byte param2) {
        XClientMessageEvent.ndata_b(this.address(), param1, param2);
        return this;
    }

    public XClientMessageEvent data_s(@NativeType(value="short[10]") ShortBuffer param1) {
        XClientMessageEvent.ndata_s(this.address(), param1);
        return this;
    }

    public XClientMessageEvent data_s(int param1, short param2) {
        XClientMessageEvent.ndata_s(this.address(), param1, param2);
        return this;
    }

    public XClientMessageEvent data_l(@NativeType(value="long[5]") CLongBuffer param1) {
        XClientMessageEvent.ndata_l(this.address(), param1);
        return this;
    }

    public XClientMessageEvent data_l(int param1, long param2) {
        XClientMessageEvent.ndata_l(this.address(), param1, param2);
        return this;
    }

    public XClientMessageEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, int param11, ByteBuffer param12, ShortBuffer param13, CLongBuffer param14) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.message_type(param9);
        this.format(param11);
        this.data_b(param12);
        this.data_s(param13);
        this.data_l(param14);
        return this;
    }

    public XClientMessageEvent set(XClientMessageEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XClientMessageEvent malloc() {
        return new XClientMessageEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XClientMessageEvent calloc() {
        return new XClientMessageEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XClientMessageEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XClientMessageEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XClientMessageEvent create(long param0) {
        return new XClientMessageEvent(param0, null);
    }

    @Nullable
    public static XClientMessageEvent createSafe(long param0) {
        return param0 == 0L ? null : new XClientMessageEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XClientMessageEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XClientMessageEvent.__create(param0, SIZEOF);
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
    public static XClientMessageEvent mallocStack() {
        return XClientMessageEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent callocStack() {
        return XClientMessageEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent mallocStack(MemoryStack param0) {
        return XClientMessageEvent.malloc(param0);
    }

    @Deprecated
    public static XClientMessageEvent callocStack(MemoryStack param0) {
        return XClientMessageEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XClientMessageEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XClientMessageEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XClientMessageEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XClientMessageEvent.calloc(param0, param1);
    }

    public static XClientMessageEvent malloc(MemoryStack param0) {
        return new XClientMessageEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XClientMessageEvent calloc(MemoryStack param0) {
        return new XClientMessageEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nmessage_type(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)MESSAGE_TYPE);
    }

    public static int nformat(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FORMAT);
    }

    public static ByteBuffer ndata_b(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DATA_B, 20);
    }

    public static byte ndata_b(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)DATA_B + Checks.check(param2, 20) * 1L);
    }

    public static ShortBuffer ndata_s(long param0) {
        return MemoryUtil.memShortBuffer(param0 + (long)DATA_S, 10);
    }

    public static short ndata_s(long param0, int param2) {
        return UNSAFE.getShort(null, param0 + (long)DATA_S + Checks.check(param2, 10) * 2L);
    }

    public static CLongBuffer ndata_l(long param0) {
        return MemoryUtil.memCLongBuffer(param0 + (long)DATA_L, 5);
    }

    public static long ndata_l(long param0, int param2) {
        return MemoryUtil.memGetCLong(param0 + (long)DATA_L + Checks.check(param2, 5) * (long)CLONG_SIZE);
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

    public static void nmessage_type(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)MESSAGE_TYPE, param2);
    }

    public static void nformat(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FORMAT, param2);
    }

    public static void ndata_b(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 20);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)DATA_B, param2.remaining() * 1);
    }

    public static void ndata_b(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)DATA_B + Checks.check(param2, 20) * 1L, param3);
    }

    public static void ndata_s(long param0, ShortBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 10);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)DATA_S, param2.remaining() * 2);
    }

    public static void ndata_s(long param0, int param2, short param3) {
        UNSAFE.putShort(null, param0 + (long)DATA_S + Checks.check(param2, 10) * 2L, param3);
    }

    public static void ndata_l(long param0, CLongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 5);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)DATA_L, param2.remaining() * CLONG_SIZE);
    }

    public static void ndata_l(long param0, int param2, long param3) {
        MemoryUtil.memPutCLong(param0 + (long)DATA_L + Checks.check(param2, 5) * (long)CLONG_SIZE, param3);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XClientMessageEvent.__struct(XClientMessageEvent.__member(4), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__member(POINTER_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__struct(XClientMessageEvent.__array(1, 20), XClientMessageEvent.__array(2, 10), XClientMessageEvent.__array(CLONG_SIZE, 5)));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        MESSAGE_TYPE = v0.offsetof(5);
        FORMAT = v0.offsetof(6);
        DATA = v0.offsetof(7);
        DATA_B = v0.offsetof(8);
        DATA_S = v0.offsetof(9);
        DATA_L = v0.offsetof(10);
    }

    public static class Buffer
    extends StructBuffer<XClientMessageEvent, Buffer>
    implements NativeResource {
        private static final XClientMessageEvent ELEMENT_FACTORY = XClientMessageEvent.create(-1L);

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
        protected XClientMessageEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XClientMessageEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XClientMessageEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XClientMessageEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XClientMessageEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XClientMessageEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long message_type() {
            return XClientMessageEvent.nmessage_type(this.address());
        }

        public int format() {
            return XClientMessageEvent.nformat(this.address());
        }

        @NativeType(value="char[20]")
        public ByteBuffer data_b() {
            return XClientMessageEvent.ndata_b(this.address());
        }

        @NativeType(value="char")
        public byte data_b(int param1) {
            return XClientMessageEvent.ndata_b(this.address(), param1);
        }

        @NativeType(value="short[10]")
        public ShortBuffer data_s() {
            return XClientMessageEvent.ndata_s(this.address());
        }

        public short data_s(int param1) {
            return XClientMessageEvent.ndata_s(this.address(), param1);
        }

        @NativeType(value="long[5]")
        public CLongBuffer data_l() {
            return XClientMessageEvent.ndata_l(this.address());
        }

        public long data_l(int param1) {
            return XClientMessageEvent.ndata_l(this.address(), param1);
        }

        public Buffer type(int param1) {
            XClientMessageEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XClientMessageEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XClientMessageEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XClientMessageEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XClientMessageEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer message_type(@NativeType(value="Atom") long param1) {
            XClientMessageEvent.nmessage_type(this.address(), param1);
            return this;
        }

        public Buffer format(int param1) {
            XClientMessageEvent.nformat(this.address(), param1);
            return this;
        }

        public Buffer data_b(@NativeType(value="char[20]") ByteBuffer param1) {
            XClientMessageEvent.ndata_b(this.address(), param1);
            return this;
        }

        public Buffer data_b(int param1, @NativeType(value="char") byte param2) {
            XClientMessageEvent.ndata_b(this.address(), param1, param2);
            return this;
        }

        public Buffer data_s(@NativeType(value="short[10]") ShortBuffer param1) {
            XClientMessageEvent.ndata_s(this.address(), param1);
            return this;
        }

        public Buffer data_s(int param1, short param2) {
            XClientMessageEvent.ndata_s(this.address(), param1, param2);
            return this;
        }

        public Buffer data_l(@NativeType(value="long[5]") CLongBuffer param1) {
            XClientMessageEvent.ndata_l(this.address(), param1);
            return this;
        }

        public Buffer data_l(int param1, long param2) {
            XClientMessageEvent.ndata_l(this.address(), param1, param2);
            return this;
        }
    }
}

