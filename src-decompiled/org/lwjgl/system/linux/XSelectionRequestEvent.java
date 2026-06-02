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

public class XSelectionRequestEvent
extends Struct<XSelectionRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int OWNER;
    public static final int REQUESTOR;
    public static final int SELECTION;
    public static final int TARGET;
    public static final int PROPERTY;
    public static final int TIME;

    protected XSelectionRequestEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XSelectionRequestEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XSelectionRequestEvent(param1, param3);
    }

    public XSelectionRequestEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XSelectionRequestEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long owner() {
        return XSelectionRequestEvent.nowner(this.address());
    }

    @NativeType(value="Window")
    public long requestor() {
        return XSelectionRequestEvent.nrequestor(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionRequestEvent.nselection(this.address());
    }

    @NativeType(value="Atom")
    public long target() {
        return XSelectionRequestEvent.ntarget(this.address());
    }

    @NativeType(value="Atom")
    public long property() {
        return XSelectionRequestEvent.nproperty(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionRequestEvent.ntime(this.address());
    }

    public XSelectionRequestEvent type(int param1) {
        XSelectionRequestEvent.ntype(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent serial(@NativeType(value="unsigned long") long param1) {
        XSelectionRequestEvent.nserial(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent send_event(@NativeType(value="Bool") boolean param1) {
        XSelectionRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
        return this;
    }

    public XSelectionRequestEvent display(@NativeType(value="Display *") long param1) {
        XSelectionRequestEvent.ndisplay(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent owner(@NativeType(value="Window") long param1) {
        XSelectionRequestEvent.nowner(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent requestor(@NativeType(value="Window") long param1) {
        XSelectionRequestEvent.nrequestor(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent selection(@NativeType(value="Atom") long param1) {
        XSelectionRequestEvent.nselection(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent target(@NativeType(value="Atom") long param1) {
        XSelectionRequestEvent.ntarget(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent property(@NativeType(value="Atom") long param1) {
        XSelectionRequestEvent.nproperty(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent time(@NativeType(value="Time") long param1) {
        XSelectionRequestEvent.ntime(this.address(), param1);
        return this;
    }

    public XSelectionRequestEvent set(int param1, long param2, boolean param4, long param5, long param7, long param9, long param11, long param13, long param15, long param17) {
        this.type(param1);
        this.serial(param2);
        this.send_event(param4);
        this.display(param5);
        this.owner(param7);
        this.requestor(param9);
        this.selection(param11);
        this.target(param13);
        this.property(param15);
        this.time(param17);
        return this;
    }

    public XSelectionRequestEvent set(XSelectionRequestEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionRequestEvent malloc() {
        return new XSelectionRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XSelectionRequestEvent calloc() {
        return new XSelectionRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XSelectionRequestEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XSelectionRequestEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XSelectionRequestEvent create(long param0) {
        return new XSelectionRequestEvent(param0, null);
    }

    @Nullable
    public static XSelectionRequestEvent createSafe(long param0) {
        return param0 == 0L ? null : new XSelectionRequestEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XSelectionRequestEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XSelectionRequestEvent.__create(param0, SIZEOF);
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
    public static XSelectionRequestEvent mallocStack() {
        return XSelectionRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionRequestEvent callocStack() {
        return XSelectionRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionRequestEvent mallocStack(MemoryStack param0) {
        return XSelectionRequestEvent.malloc(param0);
    }

    @Deprecated
    public static XSelectionRequestEvent callocStack(MemoryStack param0) {
        return XSelectionRequestEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XSelectionRequestEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XSelectionRequestEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XSelectionRequestEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XSelectionRequestEvent.calloc(param0, param1);
    }

    public static XSelectionRequestEvent malloc(MemoryStack param0) {
        return new XSelectionRequestEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XSelectionRequestEvent calloc(MemoryStack param0) {
        return new XSelectionRequestEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nowner(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)OWNER);
    }

    public static long nrequestor(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)REQUESTOR);
    }

    public static long nselection(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)SELECTION);
    }

    public static long ntarget(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)TARGET);
    }

    public static long nproperty(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)PROPERTY);
    }

    public static long ntime(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)TIME);
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

    public static void nowner(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)OWNER, param2);
    }

    public static void nrequestor(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)REQUESTOR, param2);
    }

    public static void nselection(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)SELECTION, param2);
    }

    public static void ntarget(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)TARGET, param2);
    }

    public static void nproperty(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)PROPERTY, param2);
    }

    public static void ntime(long param0, long param2) {
        MemoryUtil.memPutCLong(param0 + (long)TIME, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)DISPLAY));
    }

    static {
        Struct.Layout v0 = XSelectionRequestEvent.__struct(XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(POINTER_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        SERIAL = v0.offsetof(1);
        SEND_EVENT = v0.offsetof(2);
        DISPLAY = v0.offsetof(3);
        OWNER = v0.offsetof(4);
        REQUESTOR = v0.offsetof(5);
        SELECTION = v0.offsetof(6);
        TARGET = v0.offsetof(7);
        PROPERTY = v0.offsetof(8);
        TIME = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XSelectionRequestEvent, Buffer>
    implements NativeResource {
        private static final XSelectionRequestEvent ELEMENT_FACTORY = XSelectionRequestEvent.create(-1L);

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
        protected XSelectionRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long owner() {
            return XSelectionRequestEvent.nowner(this.address());
        }

        @NativeType(value="Window")
        public long requestor() {
            return XSelectionRequestEvent.nrequestor(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionRequestEvent.nselection(this.address());
        }

        @NativeType(value="Atom")
        public long target() {
            return XSelectionRequestEvent.ntarget(this.address());
        }

        @NativeType(value="Atom")
        public long property() {
            return XSelectionRequestEvent.nproperty(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionRequestEvent.ntime(this.address());
        }

        public Buffer type(int param1) {
            XSelectionRequestEvent.ntype(this.address(), param1);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long param1) {
            XSelectionRequestEvent.nserial(this.address(), param1);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean param1) {
            XSelectionRequestEvent.nsend_event(this.address(), param1 ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long param1) {
            XSelectionRequestEvent.ndisplay(this.address(), param1);
            return this;
        }

        public Buffer owner(@NativeType(value="Window") long param1) {
            XSelectionRequestEvent.nowner(this.address(), param1);
            return this;
        }

        public Buffer requestor(@NativeType(value="Window") long param1) {
            XSelectionRequestEvent.nrequestor(this.address(), param1);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long param1) {
            XSelectionRequestEvent.nselection(this.address(), param1);
            return this;
        }

        public Buffer target(@NativeType(value="Atom") long param1) {
            XSelectionRequestEvent.ntarget(this.address(), param1);
            return this;
        }

        public Buffer property(@NativeType(value="Atom") long param1) {
            XSelectionRequestEvent.nproperty(this.address(), param1);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long param1) {
            XSelectionRequestEvent.ntime(this.address(), param1);
            return this;
        }
    }
}

