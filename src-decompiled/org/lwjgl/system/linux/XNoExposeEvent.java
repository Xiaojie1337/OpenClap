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

public class XNoExposeEvent
extends Struct<XNoExposeEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    protected XNoExposeEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XNoExposeEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XNoExposeEvent(param1, param3);
    }

    public XNoExposeEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XNoExposeEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XNoExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XNoExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XNoExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XNoExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XNoExposeEvent.ndrawable(this.address());
    }

    public int major_code() {
        return XNoExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XNoExposeEvent.nminor_code(this.address());
    }

    public XNoExposeEvent type(int param1) {
        XNoExposeEvent.ntype(this.address(), param1);
        return this;
    }

    public XNoExposeEvent serial(@NativeType(value="unsigned long") long param1) {
        XNoExposeEvent.nserial(this.address(), param1);
        return this;
    }

    public XNoExposeEvent send_event(@NativeType(value="Bool") boolean param1) {
        XNoExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XNoExposeEvent display(@NativeType(value="Display *") long param1) {
        XNoExposeEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XNoExposeEvent drawable(@NativeType(value="Drawable") long param1) {
        XNoExposeEvent.ndrawable(this.address(), param1);
        return this;
    }

    public XNoExposeEvent major_code(int param1) {
        XNoExposeEvent.nmajor_code(this.address(), param1);
        return this;
    }

    public XNoExposeEvent minor_code(int param1) {
        XNoExposeEvent.nminor_code(this.address(), param1);
        return this;
    }

    public XNoExposeEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9, int param10) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.drawable(param7);
        this.major_code(param9);
        this.minor_code(param10);
        return this;
    }

    public XNoExposeEvent set(XNoExposeEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XNoExposeEvent malloc() {
        return new XNoExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XNoExposeEvent calloc() {
        return new XNoExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XNoExposeEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XNoExposeEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XNoExposeEvent create(long param0) {
        return new XNoExposeEvent(param0, null);
    }

    @Nullable
    public static XNoExposeEvent createSafe(long param0) {
        return param0 == 0L ? null : new XNoExposeEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XNoExposeEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XNoExposeEvent.__create(param0, SIZEOF);
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
    public static XNoExposeEvent mallocStack() {
        return XNoExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent callocStack() {
        return XNoExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent mallocStack(MemoryStack param0) {
        return XNoExposeEvent.malloc(param0);
    }

    @Deprecated
    public static XNoExposeEvent callocStack(MemoryStack param0) {
        return XNoExposeEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XNoExposeEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XNoExposeEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XNoExposeEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XNoExposeEvent.calloc(param0, param1);
    }

    public static XNoExposeEvent malloc(MemoryStack param0) {
        return new XNoExposeEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XNoExposeEvent calloc(MemoryStack param0) {
        return new XNoExposeEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long ndrawable(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)DRAWABLE);
    }

    public static int nmajor_code(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MAJOR_CODE);
    }

    public static int nminor_code(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MINOR_CODE);
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

    public static void ndrawable(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)DRAWABLE, param2);
    }

    public static void nmajor_code(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MAJOR_CODE, param2);
    }

    public static void nminor_code(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MINOR_CODE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XNoExposeEvent.__struct(XNoExposeEvent.__member(4), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(POINTER_SIZE), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        DRAWABLE = v0.offsetof(4);
        MAJOR_CODE = v0.offsetof(5);
        MINOR_CODE = v0.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XNoExposeEvent, Buffer>
    implements NativeResource {
        private static final XNoExposeEvent ELEMENT_FACTORY = XNoExposeEvent.create(-1L);

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
        protected XNoExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XNoExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XNoExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XNoExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XNoExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XNoExposeEvent.ndrawable(this.address());
        }

        public int major_code() {
            return XNoExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XNoExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int param1) {
            XNoExposeEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XNoExposeEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XNoExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XNoExposeEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long param1) {
            XNoExposeEvent.ndrawable(this.address(), param1);
            return this;
        }

        public Buffer major_code(int param1) {
            XNoExposeEvent.nmajor_code(this.address(), param1);
            return this;
        }

        public Buffer minor_code(int param1) {
            XNoExposeEvent.nminor_code(this.address(), param1);
            return this;
        }
    }
}

