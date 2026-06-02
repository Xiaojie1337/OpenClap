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

public class XGraphicsExposeEvent
extends Struct<XGraphicsExposeEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int COUNT;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    protected XGraphicsExposeEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XGraphicsExposeEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XGraphicsExposeEvent(param1, param3);
    }

    public XGraphicsExposeEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XGraphicsExposeEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGraphicsExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGraphicsExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGraphicsExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XGraphicsExposeEvent.ndrawable(this.address());
    }

    public int x() {
        return XGraphicsExposeEvent.nx(this.address());
    }

    public int y() {
        return XGraphicsExposeEvent.ny(this.address());
    }

    public int width() {
        return XGraphicsExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XGraphicsExposeEvent.nheight(this.address());
    }

    public int count() {
        return XGraphicsExposeEvent.ncount(this.address());
    }

    public int major_code() {
        return XGraphicsExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XGraphicsExposeEvent.nminor_code(this.address());
    }

    public XGraphicsExposeEvent type(int param1) {
        XGraphicsExposeEvent.ntype(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent serial(@NativeType(value="unsigned long") long param1) {
        XGraphicsExposeEvent.nserial(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent send_event(@NativeType(value="Bool") boolean param1) {
        XGraphicsExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XGraphicsExposeEvent display(@NativeType(value="Display *") long param1) {
        XGraphicsExposeEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent drawable(@NativeType(value="Drawable") long param1) {
        XGraphicsExposeEvent.ndrawable(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent x(int param1) {
        XGraphicsExposeEvent.nx(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent y(int param1) {
        XGraphicsExposeEvent.ny(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent width(int param1) {
        XGraphicsExposeEvent.nwidth(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent height(int param1) {
        XGraphicsExposeEvent.nheight(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent count(int param1) {
        XGraphicsExposeEvent.ncount(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent major_code(int param1) {
        XGraphicsExposeEvent.nmajor_code(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent minor_code(int param1) {
        XGraphicsExposeEvent.nminor_code(this.address(), param1);
        return this;
    }

    public XGraphicsExposeEvent set(int param1, long param2, boolean param4, long param5, long param7, int param9, int param10, int param11, int param12, int param13, int param14, int param15) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.drawable(param7);
        this.x(param9);
        this.y(param10);
        this.width(param11);
        this.height(param12);
        this.count(param13);
        this.major_code(param14);
        this.minor_code(param15);
        return this;
    }

    public XGraphicsExposeEvent set(XGraphicsExposeEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGraphicsExposeEvent malloc() {
        return new XGraphicsExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XGraphicsExposeEvent calloc() {
        return new XGraphicsExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XGraphicsExposeEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XGraphicsExposeEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XGraphicsExposeEvent create(long param0) {
        return new XGraphicsExposeEvent(param0, null);
    }

    @Nullable
    public static XGraphicsExposeEvent createSafe(long param0) {
        return param0 == 0L ? null : new XGraphicsExposeEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XGraphicsExposeEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XGraphicsExposeEvent.__create(param0, SIZEOF);
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
    public static XGraphicsExposeEvent mallocStack() {
        return XGraphicsExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack() {
        return XGraphicsExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent mallocStack(MemoryStack param0) {
        return XGraphicsExposeEvent.malloc(param0);
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack(MemoryStack param0) {
        return XGraphicsExposeEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XGraphicsExposeEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XGraphicsExposeEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XGraphicsExposeEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XGraphicsExposeEvent.calloc(param0, param1);
    }

    public static XGraphicsExposeEvent malloc(MemoryStack param0) {
        return new XGraphicsExposeEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XGraphicsExposeEvent calloc(MemoryStack param0) {
        return new XGraphicsExposeEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static int nwidth(long param0) {
        return UNSAFE.getInt(null, param0 + (long)WIDTH);
    }

    public static int nheight(long param0) {
        return UNSAFE.getInt(null, param0 + (long)HEIGHT);
    }

    public static int ncount(long param0) {
        return UNSAFE.getInt(null, param0 + (long)COUNT);
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

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    public static void nwidth(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)WIDTH, param2);
    }

    public static void nheight(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)HEIGHT, param2);
    }

    public static void ncount(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)COUNT, param2);
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
        Struct.Layout v0 = XGraphicsExposeEvent.__struct(XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(POINTER_SIZE), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        DRAWABLE = v0.offsetof(4);
        X = v0.offsetof(5);
        Y = v0.offsetof(6);
        WIDTH = v0.offsetof(7);
        HEIGHT = v0.offsetof(8);
        COUNT = v0.offsetof(9);
        MAJOR_CODE = v0.offsetof(10);
        MINOR_CODE = v0.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XGraphicsExposeEvent, Buffer>
    implements NativeResource {
        private static final XGraphicsExposeEvent ELEMENT_FACTORY = XGraphicsExposeEvent.create(-1L);

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
        protected XGraphicsExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGraphicsExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGraphicsExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGraphicsExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XGraphicsExposeEvent.ndrawable(this.address());
        }

        public int x() {
            return XGraphicsExposeEvent.nx(this.address());
        }

        public int y() {
            return XGraphicsExposeEvent.ny(this.address());
        }

        public int width() {
            return XGraphicsExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XGraphicsExposeEvent.nheight(this.address());
        }

        public int count() {
            return XGraphicsExposeEvent.ncount(this.address());
        }

        public int major_code() {
            return XGraphicsExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XGraphicsExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int param1) {
            XGraphicsExposeEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XGraphicsExposeEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XGraphicsExposeEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XGraphicsExposeEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long param1) {
            XGraphicsExposeEvent.ndrawable(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XGraphicsExposeEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XGraphicsExposeEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer width(int param1) {
            XGraphicsExposeEvent.nwidth(this.address(), param1);
            return this;
        }

        public Buffer height(int param1) {
            XGraphicsExposeEvent.nheight(this.address(), param1);
            return this;
        }

        public Buffer count(int param1) {
            XGraphicsExposeEvent.ncount(this.address(), param1);
            return this;
        }

        public Buffer major_code(int param1) {
            XGraphicsExposeEvent.nmajor_code(this.address(), param1);
            return this;
        }

        public Buffer minor_code(int param1) {
            XGraphicsExposeEvent.nminor_code(this.address(), param1);
            return this;
        }
    }
}

