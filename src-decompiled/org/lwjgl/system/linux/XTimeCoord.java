/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XTimeCoord
extends Struct<XTimeCoord> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TIME;
    public static final int X;
    public static final int Y;

    protected XTimeCoord(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XTimeCoord create(long param1, @Nullable ByteBuffer param3) {
        return new XTimeCoord(param1, param3);
    }

    public XTimeCoord(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XTimeCoord.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Time")
    public long time() {
        return XTimeCoord.ntime(this.address());
    }

    public short x() {
        return XTimeCoord.nx(this.address());
    }

    public short y() {
        return XTimeCoord.ny(this.address());
    }

    public static XTimeCoord create(long param0) {
        return new XTimeCoord(param0, null);
    }

    @Nullable
    public static XTimeCoord createSafe(long param0) {
        return param0 == 0L ? null : new XTimeCoord(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static long ntime(long param0) {
        return MemoryUtil.memGetCLong(param0 + (long)TIME);
    }

    public static short nx(long param0) {
        return UNSAFE.getShort(null, param0 + (long)X);
    }

    public static short ny(long param0) {
        return UNSAFE.getShort(null, param0 + (long)Y);
    }

    static {
        Struct.Layout v0 = XTimeCoord.__struct(XTimeCoord.__member(CLONG_SIZE), XTimeCoord.__member(2), XTimeCoord.__member(2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TIME = v0.offsetof(0);
        X = v0.offsetof(1);
        Y = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<XTimeCoord, Buffer> {
        private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);

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
        protected XTimeCoord getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Time")
        public long time() {
            return XTimeCoord.ntime(this.address());
        }

        public short x() {
            return XTimeCoord.nx(this.address());
        }

        public short y() {
            return XTimeCoord.ny(this.address());
        }
    }
}

