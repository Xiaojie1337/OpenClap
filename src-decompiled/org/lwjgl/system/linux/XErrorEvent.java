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

public class XErrorEvent
extends Struct<XErrorEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DISPLAY;
    public static final int RESOURCEID;
    public static final int SERIAL;
    public static final int ERROR_CODE;
    public static final int REQUEST_CODE;
    public static final int MINOR_CODE;

    protected XErrorEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XErrorEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XErrorEvent(param1, param3);
    }

    public XErrorEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XErrorEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XErrorEvent.ntype(this.address());
    }

    @NativeType(value="Display *")
    public long display() {
        return XErrorEvent.ndisplay(this.address());
    }

    @NativeType(value="XID")
    public long resourceid() {
        return XErrorEvent.nresourceid(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XErrorEvent.nserial(this.address());
    }

    @NativeType(value="unsigned char")
    public byte error_code() {
        return XErrorEvent.nerror_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte request_code() {
        return XErrorEvent.nrequest_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte minor_code() {
        return XErrorEvent.nminor_code(this.address());
    }

    public XErrorEvent type(int param1) {
        XErrorEvent.ntype(this.address(), param1);
        return this;
    }

    public XErrorEvent display(@NativeType(value="Display *") long param1) {
        XErrorEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XErrorEvent resourceid(@NativeType(value="XID") long param1) {
        XErrorEvent.nresourceid(this.address(), param1);
        return this;
    }

    public XErrorEvent serial(@NativeType(value="unsigned long") long param1) {
        XErrorEvent.nserial(this.address(), param1);
        return this;
    }

    public XErrorEvent error_code(@NativeType(value="unsigned char") byte param1) {
        XErrorEvent.nerror_code(this.address(), param1);
        return this;
    }

    public XErrorEvent request_code(@NativeType(value="unsigned char") byte param1) {
        XErrorEvent.nrequest_code(this.address(), param1);
        return this;
    }

    public XErrorEvent minor_code(@NativeType(value="unsigned char") byte param1) {
        XErrorEvent.nminor_code(this.address(), param1);
        return this;
    }

    public XErrorEvent set(int param1, long param2, long param4, long param6, byte param8, byte param9, byte param10) {
        this.type(param1);
        this.display(param2);
        this.resourceid(param4);
        this.serial(param6);
        this.error_code(param8);
        this.request_code(param9);
        this.minor_code(param10);
        return this;
    }

    public XErrorEvent set(XErrorEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XErrorEvent malloc() {
        return new XErrorEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XErrorEvent calloc() {
        return new XErrorEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XErrorEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XErrorEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XErrorEvent create(long param0) {
        return new XErrorEvent(param0, null);
    }

    @Nullable
    public static XErrorEvent createSafe(long param0) {
        return param0 == 0L ? null : new XErrorEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XErrorEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XErrorEvent.__create(param0, SIZEOF);
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
    public static XErrorEvent mallocStack() {
        return XErrorEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent callocStack() {
        return XErrorEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent mallocStack(MemoryStack param0) {
        return XErrorEvent.malloc(param0);
    }

    @Deprecated
    public static XErrorEvent callocStack(MemoryStack param0) {
        return XErrorEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XErrorEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XErrorEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XErrorEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XErrorEvent.calloc(param0, param1);
    }

    public static XErrorEvent malloc(MemoryStack param0) {
        return new XErrorEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XErrorEvent calloc(MemoryStack param0) {
        return new XErrorEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long ndisplay(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)DISPLAY);
    }

    public static long nresourceid(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)RESOURCEID);
    }

    public static long nserial(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)SERIAL);
    }

    public static byte nerror_code(long param0) {
        return UNSAFE.getByte(null, param0 + (long)ERROR_CODE);
    }

    public static byte nrequest_code(long param0) {
        return UNSAFE.getByte(null, param0 + (long)REQUEST_CODE);
    }

    public static byte nminor_code(long param0) {
        return UNSAFE.getByte(null, param0 + (long)MINOR_CODE);
    }

    public static void ntype(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TYPE, param2);
    }

    public static void ndisplay(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)DISPLAY, Checks.check(param2));
    }

    public static void nresourceid(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)RESOURCEID, param2);
    }

    public static void nserial(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)SERIAL, param2);
    }

    public static void nerror_code(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)ERROR_CODE, param2);
    }

    public static void nrequest_code(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)REQUEST_CODE, param2);
    }

    public static void nminor_code(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)MINOR_CODE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XErrorEvent.__struct(XErrorEvent.__member(4), XErrorEvent.__member(POINTER_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(1), XErrorEvent.__member(1), XErrorEvent.__member(1));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        DISPLAY = v0.offsetof(1);
        RESOURCEID = v0.offsetof(2);
        SERIAL = v0.offsetof(3);
        ERROR_CODE = v0.offsetof(4);
        REQUEST_CODE = v0.offsetof(5);
        MINOR_CODE = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XErrorEvent, Buffer>
    implements NativeResource {
        private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);

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
        protected XErrorEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XErrorEvent.ntype(this.address());
        }

        @NativeType(value="Display *")
        public long display() {
            return XErrorEvent.ndisplay(this.address());
        }

        @NativeType(value="XID")
        public long resourceid() {
            return XErrorEvent.nresourceid(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XErrorEvent.nserial(this.address());
        }

        @NativeType(value="unsigned char")
        public byte error_code() {
            return XErrorEvent.nerror_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte request_code() {
            return XErrorEvent.nrequest_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte minor_code() {
            return XErrorEvent.nminor_code(this.address());
        }

        public Buffer type(int param1) {
            XErrorEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XErrorEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer resourceid(@NativeType(value="XID") long param1) {
            XErrorEvent.nresourceid(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XErrorEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer error_code(@NativeType(value="unsigned char") byte param1) {
            XErrorEvent.nerror_code(this.address(), param1);
            return this;
        }

        public Buffer request_code(@NativeType(value="unsigned char") byte param1) {
            XErrorEvent.nrequest_code(this.address(), param1);
            return this;
        }

        public Buffer minor_code(@NativeType(value="unsigned char") byte param1) {
            XErrorEvent.nminor_code(this.address(), param1);
            return this;
        }
    }
}

