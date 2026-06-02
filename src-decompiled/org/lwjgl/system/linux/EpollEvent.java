/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.EpollData;

@NativeType(value="struct epoll_event")
public class EpollEvent
extends Struct<EpollEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTS;
    public static final int DATA;

    protected EpollEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected EpollEvent create(long param1, @Nullable ByteBuffer param3) {
        return new EpollEvent(param1, param3);
    }

    public EpollEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), EpollEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int events() {
        return EpollEvent.nevents(this.address());
    }

    @NativeType(value="epoll_data_t")
    public EpollData data() {
        return EpollEvent.ndata(this.address());
    }

    public EpollEvent events(@NativeType(value="uint32_t") int param1) {
        EpollEvent.nevents(this.address(), param1);
        return this;
    }

    public EpollEvent data(@NativeType(value="epoll_data_t") EpollData param1) {
        EpollEvent.ndata(this.address(), param1);
        return this;
    }

    public EpollEvent data(Consumer<EpollData> param1) {
        param1.accept(this.data());
        return this;
    }

    public EpollEvent set(int param1, EpollData param2) {
        this.events(param1);
        this.data(param2);
        return this;
    }

    public EpollEvent set(EpollEvent param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollEvent malloc() {
        return new EpollEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static EpollEvent calloc() {
        return new EpollEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static EpollEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new EpollEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static EpollEvent create(long param0) {
        return new EpollEvent(param0, null);
    }

    @Nullable
    public static EpollEvent createSafe(long param0) {
        return param0 == 0L ? null : new EpollEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(EpollEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = EpollEvent.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static EpollEvent malloc(MemoryStack param0) {
        return new EpollEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static EpollEvent calloc(MemoryStack param0) {
        return new EpollEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nevents(long param0) {
        return UNSAFE.getInt(null, param0 + (long)EVENTS);
    }

    public static EpollData ndata(long param0) {
        return EpollData.create(param0 + (long)DATA);
    }

    public static void nevents(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)EVENTS, param2);
    }

    public static void ndata(long param0, EpollData param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)DATA, EpollData.SIZEOF);
    }

    static {
        Struct.Layout v0 = EpollEvent.__struct(EpollEvent.__member(4), EpollEvent.__member(EpollData.SIZEOF, EpollData.ALIGNOF));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        EVENTS = v0.offsetof(0);
        DATA = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<EpollEvent, Buffer>
    implements NativeResource {
        private static final EpollEvent ELEMENT_FACTORY = EpollEvent.create(-1L);

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
        protected EpollEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int events() {
            return EpollEvent.nevents(this.address());
        }

        @NativeType(value="epoll_data_t")
        public EpollData data() {
            return EpollEvent.ndata(this.address());
        }

        public Buffer events(@NativeType(value="uint32_t") int param1) {
            EpollEvent.nevents(this.address(), param1);
            return this;
        }

        public Buffer data(@NativeType(value="epoll_data_t") EpollData param1) {
            EpollEvent.ndata(this.address(), param1);
            return this;
        }

        public Buffer data(Consumer<EpollData> param1) {
            param1.accept(this.data());
            return this;
        }
    }
}

