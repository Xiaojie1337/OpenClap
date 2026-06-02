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

public class XKeyEvent
extends Struct<XKeyEvent>
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
    public static final int KEYCODE;
    public static final int SAME_SCREEN;

    protected XKeyEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XKeyEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XKeyEvent(param1, param3);
    }

    public XKeyEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XKeyEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeyEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XKeyEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XKeyEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XKeyEvent.ntime(this.address());
    }

    public int x() {
        return XKeyEvent.nx(this.address());
    }

    public int y() {
        return XKeyEvent.ny(this.address());
    }

    public int x_root() {
        return XKeyEvent.nx_root(this.address());
    }

    public int y_root() {
        return XKeyEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XKeyEvent.nstate(this.address());
    }

    @NativeType(value="unsigned int")
    public int keycode() {
        return XKeyEvent.nkeycode(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XKeyEvent.nsame_screen(this.address()) != 0;
    }

    public XKeyEvent type(int param1) {
        XKeyEvent.ntype(this.address(), param1);
        return this;
    }

    public XKeyEvent serial(@NativeType(value="unsigned long") long param1) {
        XKeyEvent.nserial(this.address(), param1);
        return this;
    }

    public XKeyEvent send_event(@NativeType(value="Bool") boolean param1) {
        XKeyEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XKeyEvent display(@NativeType(value="Display *") long param1) {
        XKeyEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XKeyEvent window(@NativeType(value="Window") long param1) {
        XKeyEvent.nwindow(this.address(), param1);
        return this;
    }

    public XKeyEvent root(@NativeType(value="Window") long param1) {
        XKeyEvent.nroot(this.address(), param1);
        return this;
    }

    public XKeyEvent subwindow(@NativeType(value="Window") long param1) {
        XKeyEvent.nsubwindow(this.address(), param1);
        return this;
    }

    public XKeyEvent time(@NativeType(value="Time") long param1) {
        XKeyEvent.ntime(this.address(), param1);
        return this;
    }

    public XKeyEvent x(int param1) {
        XKeyEvent.nx(this.address(), param1);
        return this;
    }

    public XKeyEvent y(int param1) {
        XKeyEvent.ny(this.address(), param1);
        return this;
    }

    public XKeyEvent x_root(int param1) {
        XKeyEvent.nx_root(this.address(), param1);
        return this;
    }

    public XKeyEvent y_root(int param1) {
        XKeyEvent.ny_root(this.address(), param1);
        return this;
    }

    public XKeyEvent state(@NativeType(value="unsigned int") int param1) {
        XKeyEvent.nstate(this.address(), param1);
        return this;
    }

    public XKeyEvent keycode(@NativeType(value="unsigned int") int param1) {
        XKeyEvent.nkeycode(this.address(), param1);
        return this;
    }

    public XKeyEvent same_screen(@NativeType(value="Bool") boolean param1) {
        XKeyEvent.nsame_screen(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XKeyEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, long param11, long param13, int param15, int param16, int param17, int param18, int param19, int param20, boolean param21) {
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
        this.keycode(param20);
        this.same_screen(param21);
        return this;
    }

    public XKeyEvent set(XKeyEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeyEvent malloc() {
        return new XKeyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XKeyEvent calloc() {
        return new XKeyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XKeyEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XKeyEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XKeyEvent create(long param0) {
        return new XKeyEvent(param0, null);
    }

    @Nullable
    public static XKeyEvent createSafe(long param0) {
        return param0 == 0L ? null : new XKeyEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XKeyEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XKeyEvent.__create(param0, SIZEOF);
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
    public static XKeyEvent mallocStack() {
        return XKeyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent callocStack() {
        return XKeyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent mallocStack(MemoryStack param0) {
        return XKeyEvent.malloc(param0);
    }

    @Deprecated
    public static XKeyEvent callocStack(MemoryStack param0) {
        return XKeyEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XKeyEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XKeyEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XKeyEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XKeyEvent.calloc(param0, param1);
    }

    public static XKeyEvent malloc(MemoryStack param0) {
        return new XKeyEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XKeyEvent calloc(MemoryStack param0) {
        return new XKeyEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nkeycode(long param0) {
        return UNSAFE.getInt(null, param0 + (long)KEYCODE);
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

    public static void nkeycode(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)KEYCODE, param2);
    }

    public static void nsame_screen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SAME_SCREEN, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XKeyEvent.__struct(XKeyEvent.__member(4), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(POINTER_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4));
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
        KEYCODE = v0.offsetof(13);
        SAME_SCREEN = v0.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XKeyEvent, Buffer>
    implements NativeResource {
        private static final XKeyEvent ELEMENT_FACTORY = XKeyEvent.create(-1L);

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
        protected XKeyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeyEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XKeyEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XKeyEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XKeyEvent.ntime(this.address());
        }

        public int x() {
            return XKeyEvent.nx(this.address());
        }

        public int y() {
            return XKeyEvent.ny(this.address());
        }

        public int x_root() {
            return XKeyEvent.nx_root(this.address());
        }

        public int y_root() {
            return XKeyEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XKeyEvent.nstate(this.address());
        }

        @NativeType(value="unsigned int")
        public int keycode() {
            return XKeyEvent.nkeycode(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XKeyEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int param1) {
            XKeyEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XKeyEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XKeyEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XKeyEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XKeyEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long param1) {
            XKeyEvent.nroot(this.address(), param1);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long param1) {
            XKeyEvent.nsubwindow(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long param1) {
            XKeyEvent.ntime(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XKeyEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XKeyEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer x_root(int param1) {
            XKeyEvent.nx_root(this.address(), param1);
            return this;
        }

        public Buffer y_root(int param1) {
            XKeyEvent.ny_root(this.address(), param1);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int param1) {
            XKeyEvent.nstate(this.address(), param1);
            return this;
        }

        public Buffer keycode(@NativeType(value="unsigned int") int param1) {
            XKeyEvent.nkeycode(this.address(), param1);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean param1) {
            XKeyEvent.nsame_screen(this.address(), param1 ? 1 : 0);
            return this;
        }
    }
}

