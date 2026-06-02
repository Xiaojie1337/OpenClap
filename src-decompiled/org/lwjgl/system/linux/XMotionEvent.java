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

public class XMotionEvent
extends Struct<XMotionEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ROOT;
    public static final int SUBWINDOW;
    public static final int TIME;
    public static final int X;
    public static final int Y;
    public static final int X_ROOT;
    public static final int Y_ROOT;
    public static final int STATE;
    public static final int IS_HINT;
    public static final int SAME_SCREEN;

    protected XMotionEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XMotionEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XMotionEvent(param1, param3);
    }

    public XMotionEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XMotionEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMotionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMotionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMotionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMotionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMotionEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XMotionEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XMotionEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XMotionEvent.ntime(this.address());
    }

    public int x() {
        return XMotionEvent.nx(this.address());
    }

    public int y() {
        return XMotionEvent.ny(this.address());
    }

    public int x_root() {
        return XMotionEvent.nx_root(this.address());
    }

    public int y_root() {
        return XMotionEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XMotionEvent.nstate(this.address());
    }

    @NativeType(value="char")
    public byte is_hint() {
        return XMotionEvent.nis_hint(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XMotionEvent.nsame_screen(this.address()) != 0;
    }

    public XMotionEvent type(int param1) {
        XMotionEvent.ntype(this.address(), param1);
        return this;
    }

    public XMotionEvent serial(@NativeType(value="unsigned long") long param1) {
        XMotionEvent.nserial(this.address(), param1);
        return this;
    }

    public XMotionEvent send_event(@NativeType(value="Bool") boolean param1) {
        XMotionEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XMotionEvent display(@NativeType(value="Display *") long param1) {
        XMotionEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XMotionEvent window(@NativeType(value="Window") long param1) {
        XMotionEvent.nwindow(this.address(), param1);
        return this;
    }

    public XMotionEvent root(@NativeType(value="Window") long param1) {
        XMotionEvent.nroot(this.address(), param1);
        return this;
    }

    public XMotionEvent subwindow(@NativeType(value="Window") long param1) {
        XMotionEvent.nsubwindow(this.address(), param1);
        return this;
    }

    public XMotionEvent time(@NativeType(value="Time") long param1) {
        XMotionEvent.ntime(this.address(), param1);
        return this;
    }

    public XMotionEvent x(int param1) {
        XMotionEvent.nx(this.address(), param1);
        return this;
    }

    public XMotionEvent y(int param1) {
        XMotionEvent.ny(this.address(), param1);
        return this;
    }

    public XMotionEvent x_root(int param1) {
        XMotionEvent.nx_root(this.address(), param1);
        return this;
    }

    public XMotionEvent y_root(int param1) {
        XMotionEvent.ny_root(this.address(), param1);
        return this;
    }

    public XMotionEvent state(@NativeType(value="unsigned int") int param1) {
        XMotionEvent.nstate(this.address(), param1);
        return this;
    }

    public XMotionEvent is_hint(@NativeType(value="char") byte param1) {
        XMotionEvent.nis_hint(this.address(), param1);
        return this;
    }

    public XMotionEvent same_screen(@NativeType(value="Bool") boolean param1) {
        XMotionEvent.nsame_screen(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XMotionEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, long param11, long param13, int param15, int param16, int param17, int param18, int param19, byte param20, boolean param21) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.window(param7);
        this.root(param9);
        this.subwindow(param11);
        this.time(param13);
        this.x(param15);
        this.y(param16);
        this.x_root(param17);
        this.y_root(param18);
        this.state(param19);
        this.is_hint(param20);
        this.same_screen(param21);
        return this;
    }

    public XMotionEvent set(XMotionEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMotionEvent malloc() {
        return new XMotionEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMotionEvent calloc() {
        return new XMotionEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMotionEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XMotionEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XMotionEvent create(long param0) {
        return new XMotionEvent(param0, null);
    }

    @Nullable
    public static XMotionEvent createSafe(long param0) {
        return param0 == 0L ? null : new XMotionEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMotionEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XMotionEvent.__create(param0, SIZEOF);
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
    public static XMotionEvent mallocStack() {
        return XMotionEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent callocStack() {
        return XMotionEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent mallocStack(MemoryStack param0) {
        return XMotionEvent.malloc(param0);
    }

    @Deprecated
    public static XMotionEvent callocStack(MemoryStack param0) {
        return XMotionEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XMotionEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XMotionEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XMotionEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XMotionEvent.calloc(param0, param1);
    }

    public static XMotionEvent malloc(MemoryStack param0) {
        return new XMotionEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMotionEvent calloc(MemoryStack param0) {
        return new XMotionEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nroot(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)ROOT);
    }

    public static long nsubwindow(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)SUBWINDOW);
    }

    public static long ntime(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)TIME);
    }

    public static int nx(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X);
    }

    public static int ny(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y);
    }

    public static int nx_root(long param0) {
        return UNSAFE.getInt(null, param0 + (long)X_ROOT);
    }

    public static int ny_root(long param0) {
        return UNSAFE.getInt(null, param0 + (long)Y_ROOT);
    }

    public static int nstate(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STATE);
    }

    public static byte nis_hint(long param0) {
        return UNSAFE.getByte(null, param0 + (long)IS_HINT);
    }

    public static int nsame_screen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SAME_SCREEN);
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

    public static void nroot(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)ROOT, param2);
    }

    public static void nsubwindow(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)SUBWINDOW, param2);
    }

    public static void ntime(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)TIME, param2);
    }

    public static void nx(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X, param2);
    }

    public static void ny(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y, param2);
    }

    public static void nx_root(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)X_ROOT, param2);
    }

    public static void ny_root(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)Y_ROOT, param2);
    }

    public static void nstate(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATE, param2);
    }

    public static void nis_hint(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)IS_HINT, param2);
    }

    public static void nsame_screen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SAME_SCREEN, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XMotionEvent.__struct(XMotionEvent.__member(4), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(POINTER_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(1), XMotionEvent.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        WINDOW = v0.offsetof(4);
        ROOT = v0.offsetof(5);
        SUBWINDOW = v0.offsetof(6);
        TIME = v0.offsetof(7);
        X = v0.offsetof(8);
        Y = v0.offsetof(9);
        X_ROOT = v0.offsetof(10);
        Y_ROOT = v0.offsetof(11);
        STATE = v0.offsetof(12);
        IS_HINT = v0.offsetof(13);
        SAME_SCREEN = v0.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XMotionEvent, Buffer>
    implements NativeResource {
        private static final XMotionEvent ELEMENT_FACTORY = XMotionEvent.create(-1L);

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
        protected XMotionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMotionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMotionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMotionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMotionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMotionEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XMotionEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XMotionEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XMotionEvent.ntime(this.address());
        }

        public int x() {
            return XMotionEvent.nx(this.address());
        }

        public int y() {
            return XMotionEvent.ny(this.address());
        }

        public int x_root() {
            return XMotionEvent.nx_root(this.address());
        }

        public int y_root() {
            return XMotionEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XMotionEvent.nstate(this.address());
        }

        @NativeType(value="char")
        public byte is_hint() {
            return XMotionEvent.nis_hint(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XMotionEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int param1) {
            XMotionEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XMotionEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XMotionEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XMotionEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XMotionEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long param1) {
            XMotionEvent.nroot(this.address(), param1);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long param1) {
            XMotionEvent.nsubwindow(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long param1) {
            XMotionEvent.ntime(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XMotionEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XMotionEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer x_root(int param1) {
            XMotionEvent.nx_root(this.address(), param1);
            return this;
        }

        public Buffer y_root(int param1) {
            XMotionEvent.ny_root(this.address(), param1);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int param1) {
            XMotionEvent.nstate(this.address(), param1);
            return this;
        }

        public Buffer is_hint(@NativeType(value="char") byte param1) {
            XMotionEvent.nis_hint(this.address(), param1);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean param1) {
            XMotionEvent.nsame_screen(this.address(), param1 ? 1 : 0);
            return this;
        }
    }
}

