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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XSetWindowAttributes
extends Struct<XSetWindowAttributes>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUND_PIXMAP;
    public static final int BACKGROUND_PIXEL;
    public static final int BORDER_PIXMAP;
    public static final int BORDER_PIXEL;
    public static final int BIT_GRAVITY;
    public static final int WIN_GRAVITY;
    public static final int BACKING_STORE;
    public static final int BACKING_PLANES;
    public static final int BACKING_PIXEL;
    public static final int SAVE_UNDER;
    public static final int EVENT_MASK;
    public static final int DO_NOT_PROPAGATE_MASK;
    public static final int OVERRIDE_REDIRECT;
    public static final int COLORMAP;
    public static final int CURSOR;

    protected XSetWindowAttributes(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XSetWindowAttributes create(long param1, @Nullable ByteBuffer param3) {
        return new XSetWindowAttributes(param1, param3);
    }

    public XSetWindowAttributes(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XSetWindowAttributes.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Pixmap")
    public long background_pixmap() {
        return XSetWindowAttributes.nbackground_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long background_pixel() {
        return XSetWindowAttributes.nbackground_pixel(this.address());
    }

    @NativeType(value="Pixmap")
    public long border_pixmap() {
        return XSetWindowAttributes.nborder_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long border_pixel() {
        return XSetWindowAttributes.nborder_pixel(this.address());
    }

    public int bit_gravity() {
        return XSetWindowAttributes.nbit_gravity(this.address());
    }

    public int win_gravity() {
        return XSetWindowAttributes.nwin_gravity(this.address());
    }

    public int backing_store() {
        return XSetWindowAttributes.nbacking_store(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_planes() {
        return XSetWindowAttributes.nbacking_planes(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_pixel() {
        return XSetWindowAttributes.nbacking_pixel(this.address());
    }

    @NativeType(value="Bool")
    public boolean save_under() {
        return XSetWindowAttributes.nsave_under(this.address()) != 0;
    }

    public long event_mask() {
        return XSetWindowAttributes.nevent_mask(this.address());
    }

    public long do_not_propagate_mask() {
        return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XSetWindowAttributes.ncolormap(this.address());
    }

    @NativeType(value="Cursor")
    public long cursor() {
        return XSetWindowAttributes.ncursor(this.address());
    }

    public XSetWindowAttributes background_pixmap(@NativeType(value="Pixmap") long param1) {
        XSetWindowAttributes.nbackground_pixmap(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes background_pixel(@NativeType(value="unsigned long") long param1) {
        XSetWindowAttributes.nbackground_pixel(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes border_pixmap(@NativeType(value="Pixmap") long param1) {
        XSetWindowAttributes.nborder_pixmap(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes border_pixel(@NativeType(value="unsigned long") long param1) {
        XSetWindowAttributes.nborder_pixel(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes bit_gravity(int param1) {
        XSetWindowAttributes.nbit_gravity(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes win_gravity(int param1) {
        XSetWindowAttributes.nwin_gravity(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes backing_store(int param1) {
        XSetWindowAttributes.nbacking_store(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes backing_planes(@NativeType(value="unsigned long") long param1) {
        XSetWindowAttributes.nbacking_planes(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes backing_pixel(@NativeType(value="unsigned long") long param1) {
        XSetWindowAttributes.nbacking_pixel(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes save_under(@NativeType(value="Bool") boolean param1) {
        XSetWindowAttributes.nsave_under(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes event_mask(long param1) {
        XSetWindowAttributes.nevent_mask(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes do_not_propagate_mask(long param1) {
        XSetWindowAttributes.ndo_not_propagate_mask(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes override_redirect(@NativeType(value="Bool") boolean param1) {
        XSetWindowAttributes.noverride_redirect(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes colormap(@NativeType(value="Colormap") long param1) {
        XSetWindowAttributes.ncolormap(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes cursor(@NativeType(value="Cursor") long param1) {
        XSetWindowAttributes.ncursor(this.address(), param1);
        return this;
    }

    public XSetWindowAttributes set(long param1, long param3, long param5, long param7, int param9, int param10, int param11, long param12, long param14, boolean param16, long param17, long param19, boolean param21, long param22, long param24) {
        this.background_pixmap(param1);
        this.background_pixel(param3);
        this.border_pixmap(param5);
        this.border_pixel(param7);
        this.bit_gravity(param9);
        this.win_gravity(param10);
        this.backing_store(param11);
        this.backing_planes(param12);
        this.backing_pixel(param14);
        this.save_under(param16);
        this.event_mask(param17);
        this.do_not_propagate_mask(param19);
        this.override_redirect(param21);
        this.colormap(param22);
        this.cursor(param24);
        return this;
    }

    public XSetWindowAttributes set(XSetWindowAttributes param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSetWindowAttributes malloc() {
        return new XSetWindowAttributes(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XSetWindowAttributes calloc() {
        return new XSetWindowAttributes(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XSetWindowAttributes create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XSetWindowAttributes(MemoryUtil.memAddress(v0), v0);
    }

    public static XSetWindowAttributes create(long param0) {
        return new XSetWindowAttributes(param0, null);
    }

    @Nullable
    public static XSetWindowAttributes createSafe(long param0) {
        return param0 == 0L ? null : new XSetWindowAttributes(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XSetWindowAttributes.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XSetWindowAttributes.__create(param0, SIZEOF);
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
    public static XSetWindowAttributes mallocStack() {
        return XSetWindowAttributes.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes callocStack() {
        return XSetWindowAttributes.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes mallocStack(MemoryStack param0) {
        return XSetWindowAttributes.malloc(param0);
    }

    @Deprecated
    public static XSetWindowAttributes callocStack(MemoryStack param0) {
        return XSetWindowAttributes.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XSetWindowAttributes.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XSetWindowAttributes.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XSetWindowAttributes.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XSetWindowAttributes.calloc(param0, param1);
    }

    public static XSetWindowAttributes malloc(MemoryStack param0) {
        return new XSetWindowAttributes(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XSetWindowAttributes calloc(MemoryStack param0) {
        return new XSetWindowAttributes(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nbackground_pixmap(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BACKGROUND_PIXMAP);
    }

    public static long nbackground_pixel(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BACKGROUND_PIXEL);
    }

    public static long nborder_pixmap(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BORDER_PIXMAP);
    }

    public static long nborder_pixel(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BORDER_PIXEL);
    }

    public static int nbit_gravity(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BIT_GRAVITY);
    }

    public static int nwin_gravity(long param0) {
        return UNSAFE.getInt(null, param0 + (long)WIN_GRAVITY);
    }

    public static int nbacking_store(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BACKING_STORE);
    }

    public static long nbacking_planes(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BACKING_PLANES);
    }

    public static long nbacking_pixel(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)BACKING_PIXEL);
    }

    public static int nsave_under(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SAVE_UNDER);
    }

    public static long nevent_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)EVENT_MASK);
    }

    public static long ndo_not_propagate_mask(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)DO_NOT_PROPAGATE_MASK);
    }

    public static int noverride_redirect(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OVERRIDE_REDIRECT);
    }

    public static long ncolormap(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)COLORMAP);
    }

    public static long ncursor(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)CURSOR);
    }

    public static void nbackground_pixmap(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BACKGROUND_PIXMAP, param2);
    }

    public static void nbackground_pixel(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BACKGROUND_PIXEL, param2);
    }

    public static void nborder_pixmap(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BORDER_PIXMAP, param2);
    }

    public static void nborder_pixel(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BORDER_PIXEL, param2);
    }

    public static void nbit_gravity(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BIT_GRAVITY, param2);
    }

    public static void nwin_gravity(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)WIN_GRAVITY, param2);
    }

    public static void nbacking_store(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BACKING_STORE, param2);
    }

    public static void nbacking_planes(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BACKING_PLANES, param2);
    }

    public static void nbacking_pixel(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)BACKING_PIXEL, param2);
    }

    public static void nsave_under(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SAVE_UNDER, param2);
    }

    public static void nevent_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)EVENT_MASK, param2);
    }

    public static void ndo_not_propagate_mask(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)DO_NOT_PROPAGATE_MASK, param2);
    }

    public static void noverride_redirect(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OVERRIDE_REDIRECT, param2);
    }

    public static void ncolormap(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)COLORMAP, param2);
    }

    public static void ncursor(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)CURSOR, param2);
    }

    static {
        Struct.Layout v0 = XSetWindowAttributes.__struct(XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        BACKGROUND_PIXMAP = v0.offsetof(0);
        BACKGROUND_PIXEL = v0.offsetof(1);
        BORDER_PIXMAP = v0.offsetof(2);
        BORDER_PIXEL = v0.offsetof(3);
        BIT_GRAVITY = v0.offsetof(4);
        WIN_GRAVITY = v0.offsetof(5);
        BACKING_STORE = v0.offsetof(6);
        BACKING_PLANES = v0.offsetof(7);
        BACKING_PIXEL = v0.offsetof(8);
        SAVE_UNDER = v0.offsetof(9);
        EVENT_MASK = v0.offsetof(10);
        DO_NOT_PROPAGATE_MASK = v0.offsetof(11);
        OVERRIDE_REDIRECT = v0.offsetof(12);
        COLORMAP = v0.offsetof(13);
        CURSOR = v0.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XSetWindowAttributes, Buffer>
    implements NativeResource {
        private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);

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
        protected XSetWindowAttributes getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Pixmap")
        public long background_pixmap() {
            return XSetWindowAttributes.nbackground_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long background_pixel() {
            return XSetWindowAttributes.nbackground_pixel(this.address());
        }

        @NativeType(value="Pixmap")
        public long border_pixmap() {
            return XSetWindowAttributes.nborder_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long border_pixel() {
            return XSetWindowAttributes.nborder_pixel(this.address());
        }

        public int bit_gravity() {
            return XSetWindowAttributes.nbit_gravity(this.address());
        }

        public int win_gravity() {
            return XSetWindowAttributes.nwin_gravity(this.address());
        }

        public int backing_store() {
            return XSetWindowAttributes.nbacking_store(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_planes() {
            return XSetWindowAttributes.nbacking_planes(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_pixel() {
            return XSetWindowAttributes.nbacking_pixel(this.address());
        }

        @NativeType(value="Bool")
        public boolean save_under() {
            return XSetWindowAttributes.nsave_under(this.address()) != 0;
        }

        public long event_mask() {
            return XSetWindowAttributes.nevent_mask(this.address());
        }

        public long do_not_propagate_mask() {
            return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XSetWindowAttributes.ncolormap(this.address());
        }

        @NativeType(value="Cursor")
        public long cursor() {
            return XSetWindowAttributes.ncursor(this.address());
        }

        public Buffer background_pixmap(@NativeType(value="Pixmap") long param1) {
            XSetWindowAttributes.nbackground_pixmap(this.address(), param1);
            return this;
        }

        public Buffer background_pixel(@NativeType(value="unsigned long") long param1) {
            XSetWindowAttributes.nbackground_pixel(this.address(), param1);
            return this;
        }

        public Buffer border_pixmap(@NativeType(value="Pixmap") long param1) {
            XSetWindowAttributes.nborder_pixmap(this.address(), param1);
            return this;
        }

        public Buffer border_pixel(@NativeType(value="unsigned long") long param1) {
            XSetWindowAttributes.nborder_pixel(this.address(), param1);
            return this;
        }

        public Buffer bit_gravity(int param1) {
            XSetWindowAttributes.nbit_gravity(this.address(), param1);
            return this;
        }

        public Buffer win_gravity(int param1) {
            XSetWindowAttributes.nwin_gravity(this.address(), param1);
            return this;
        }

        public Buffer backing_store(int param1) {
            XSetWindowAttributes.nbacking_store(this.address(), param1);
            return this;
        }

        public Buffer backing_planes(@NativeType(value="unsigned long") long param1) {
            XSetWindowAttributes.nbacking_planes(this.address(), param1);
            return this;
        }

        public Buffer backing_pixel(@NativeType(value="unsigned long") long param1) {
            XSetWindowAttributes.nbacking_pixel(this.address(), param1);
            return this;
        }

        public Buffer save_under(@NativeType(value="Bool") boolean param1) {
            XSetWindowAttributes.nsave_under(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer event_mask(long param1) {
            XSetWindowAttributes.nevent_mask(this.address(), param1);
            return this;
        }

        public Buffer do_not_propagate_mask(long param1) {
            XSetWindowAttributes.ndo_not_propagate_mask(this.address(), param1);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean param1) {
            XSetWindowAttributes.noverride_redirect(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long param1) {
            XSetWindowAttributes.ncolormap(this.address(), param1);
            return this;
        }

        public Buffer cursor(@NativeType(value="Cursor") long param1) {
            XSetWindowAttributes.ncursor(this.address(), param1);
            return this;
        }
    }
}

