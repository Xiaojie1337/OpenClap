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

public class XCrossingEvent
extends Struct<XCrossingEvent>
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
    public static final int MODE;
    public static final int DETAIL;
    public static final int SAME_SCREEN;
    public static final int FOCUS;
    public static final int STATE;

    protected XCrossingEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XCrossingEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XCrossingEvent(param1, param3);
    }

    public XCrossingEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XCrossingEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCrossingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCrossingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCrossingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCrossingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCrossingEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XCrossingEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XCrossingEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XCrossingEvent.ntime(this.address());
    }

    public int x() {
        return XCrossingEvent.nx(this.address());
    }

    public int y() {
        return XCrossingEvent.ny(this.address());
    }

    public int x_root() {
        return XCrossingEvent.nx_root(this.address());
    }

    public int y_root() {
        return XCrossingEvent.ny_root(this.address());
    }

    public int mode() {
        return XCrossingEvent.nmode(this.address());
    }

    public int detail() {
        return XCrossingEvent.ndetail(this.address());
    }

    public int same_screen() {
        return XCrossingEvent.nsame_screen(this.address());
    }

    public int focus() {
        return XCrossingEvent.nfocus(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XCrossingEvent.nstate(this.address());
    }

    public XCrossingEvent type(int param1) {
        XCrossingEvent.ntype(this.address(), param1);
        return this;
    }

    public XCrossingEvent serial(@NativeType(value="unsigned long") long param1) {
        XCrossingEvent.nserial(this.address(), param1);
        return this;
    }

    public XCrossingEvent send_event(@NativeType(value="Bool") boolean param1) {
        XCrossingEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XCrossingEvent display(@NativeType(value="Display *") long param1) {
        XCrossingEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XCrossingEvent window(@NativeType(value="Window") long param1) {
        XCrossingEvent.nwindow(this.address(), param1);
        return this;
    }

    public XCrossingEvent root(@NativeType(value="Window") long param1) {
        XCrossingEvent.nroot(this.address(), param1);
        return this;
    }

    public XCrossingEvent subwindow(@NativeType(value="Window") long param1) {
        XCrossingEvent.nsubwindow(this.address(), param1);
        return this;
    }

    public XCrossingEvent time(@NativeType(value="Time") long param1) {
        XCrossingEvent.ntime(this.address(), param1);
        return this;
    }

    public XCrossingEvent x(int param1) {
        XCrossingEvent.nx(this.address(), param1);
        return this;
    }

    public XCrossingEvent y(int param1) {
        XCrossingEvent.ny(this.address(), param1);
        return this;
    }

    public XCrossingEvent x_root(int param1) {
        XCrossingEvent.nx_root(this.address(), param1);
        return this;
    }

    public XCrossingEvent y_root(int param1) {
        XCrossingEvent.ny_root(this.address(), param1);
        return this;
    }

    public XCrossingEvent mode(int param1) {
        XCrossingEvent.nmode(this.address(), param1);
        return this;
    }

    public XCrossingEvent detail(int param1) {
        XCrossingEvent.ndetail(this.address(), param1);
        return this;
    }

    public XCrossingEvent same_screen(int param1) {
        XCrossingEvent.nsame_screen(this.address(), param1);
        return this;
    }

    public XCrossingEvent focus(int param1) {
        XCrossingEvent.nfocus(this.address(), param1);
        return this;
    }

    public XCrossingEvent state(@NativeType(value="unsigned int") int param1) {
        XCrossingEvent.nstate(this.address(), param1);
        return this;
    }

    public XCrossingEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, long param11, long param13, int param15, int param16, int param17, int param18, int param19, int param20, int param21, int param22, int param23) {
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
        this.mode(param19);
        this.detail(param20);
        this.same_screen(param21);
        this.focus(param22);
        this.state(param23);
        return this;
    }

    public XCrossingEvent set(XCrossingEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCrossingEvent malloc() {
        return new XCrossingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XCrossingEvent calloc() {
        return new XCrossingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XCrossingEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XCrossingEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XCrossingEvent create(long param0) {
        return new XCrossingEvent(param0, null);
    }

    @Nullable
    public static XCrossingEvent createSafe(long param0) {
        return param0 == 0L ? null : new XCrossingEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XCrossingEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XCrossingEvent.__create(param0, SIZEOF);
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
    public static XCrossingEvent mallocStack() {
        return XCrossingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent callocStack() {
        return XCrossingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent mallocStack(MemoryStack param0) {
        return XCrossingEvent.malloc(param0);
    }

    @Deprecated
    public static XCrossingEvent callocStack(MemoryStack param0) {
        return XCrossingEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XCrossingEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XCrossingEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XCrossingEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XCrossingEvent.calloc(param0, param1);
    }

    public static XCrossingEvent malloc(MemoryStack param0) {
        return new XCrossingEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XCrossingEvent calloc(MemoryStack param0) {
        return new XCrossingEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nmode(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MODE);
    }

    public static int ndetail(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DETAIL);
    }

    public static int nsame_screen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SAME_SCREEN);
    }

    public static int nfocus(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FOCUS);
    }

    public static int nstate(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STATE);
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

    public static void nmode(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MODE, param2);
    }

    public static void ndetail(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DETAIL, param2);
    }

    public static void nsame_screen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SAME_SCREEN, param2);
    }

    public static void nfocus(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FOCUS, param2);
    }

    public static void nstate(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XCrossingEvent.__struct(XCrossingEvent.__member(4), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(POINTER_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4));
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
        MODE = v0.offsetof(12);
        DETAIL = v0.offsetof(13);
        SAME_SCREEN = v0.offsetof(14);
        FOCUS = v0.offsetof(15);
        STATE = v0.offsetof(16);
    }

    public static class Buffer
    extends StructBuffer<XCrossingEvent, Buffer>
    implements NativeResource {
        private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);

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
        protected XCrossingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCrossingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCrossingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCrossingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCrossingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCrossingEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XCrossingEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XCrossingEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XCrossingEvent.ntime(this.address());
        }

        public int x() {
            return XCrossingEvent.nx(this.address());
        }

        public int y() {
            return XCrossingEvent.ny(this.address());
        }

        public int x_root() {
            return XCrossingEvent.nx_root(this.address());
        }

        public int y_root() {
            return XCrossingEvent.ny_root(this.address());
        }

        public int mode() {
            return XCrossingEvent.nmode(this.address());
        }

        public int detail() {
            return XCrossingEvent.ndetail(this.address());
        }

        public int same_screen() {
            return XCrossingEvent.nsame_screen(this.address());
        }

        public int focus() {
            return XCrossingEvent.nfocus(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XCrossingEvent.nstate(this.address());
        }

        public Buffer type(int param1) {
            XCrossingEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XCrossingEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XCrossingEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XCrossingEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long param1) {
            XCrossingEvent.nwindow(this.address(), param1);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long param1) {
            XCrossingEvent.nroot(this.address(), param1);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long param1) {
            XCrossingEvent.nsubwindow(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long param1) {
            XCrossingEvent.ntime(this.address(), param1);
            return this;
        }

        public Buffer x(int param1) {
            XCrossingEvent.nx(this.address(), param1);
            return this;
        }

        public Buffer y(int param1) {
            XCrossingEvent.ny(this.address(), param1);
            return this;
        }

        public Buffer x_root(int param1) {
            XCrossingEvent.nx_root(this.address(), param1);
            return this;
        }

        public Buffer y_root(int param1) {
            XCrossingEvent.ny_root(this.address(), param1);
            return this;
        }

        public Buffer mode(int param1) {
            XCrossingEvent.nmode(this.address(), param1);
            return this;
        }

        public Buffer detail(int param1) {
            XCrossingEvent.ndetail(this.address(), param1);
            return this;
        }

        public Buffer same_screen(int param1) {
            XCrossingEvent.nsame_screen(this.address(), param1);
            return this;
        }

        public Buffer focus(int param1) {
            XCrossingEvent.nfocus(this.address(), param1);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int param1) {
            XCrossingEvent.nstate(this.address(), param1);
            return this;
        }
    }
}

