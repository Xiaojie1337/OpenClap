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

@NativeType(value="struct f_owner_ex")
public class FOwnerEx
extends Struct<FOwnerEx>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int PID;

    protected FOwnerEx(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected FOwnerEx create(long param1, @Nullable ByteBuffer param3) {
        return new FOwnerEx(param1, param3);
    }

    public FOwnerEx(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), FOwnerEx.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return FOwnerEx.ntype(this.address());
    }

    @NativeType(value="pid_t")
    public int pid() {
        return FOwnerEx.npid(this.address());
    }

    public FOwnerEx type(int param1) {
        FOwnerEx.ntype(this.address(), param1);
        return this;
    }

    public FOwnerEx pid(@NativeType(value="pid_t") int param1) {
        FOwnerEx.npid(this.address(), param1);
        return this;
    }

    public FOwnerEx set(int param1, int param2) {
        this.type(param1);
        this.pid(param2);
        return this;
    }

    public FOwnerEx set(FOwnerEx param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static FOwnerEx malloc() {
        return new FOwnerEx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FOwnerEx calloc() {
        return new FOwnerEx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FOwnerEx create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new FOwnerEx(MemoryUtil.memAddress(v0), v0);
    }

    public static FOwnerEx create(long param0) {
        return new FOwnerEx(param0, null);
    }

    @Nullable
    public static FOwnerEx createSafe(long param0) {
        return param0 == 0L ? null : new FOwnerEx(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FOwnerEx.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = FOwnerEx.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FOwnerEx malloc(MemoryStack param0) {
        return new FOwnerEx(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FOwnerEx calloc(MemoryStack param0) {
        return new FOwnerEx(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int npid(long param0) {
        return UNSAFE.getInt(null, param0 + (long)PID);
    }

    public static void ntype(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TYPE, param2);
    }

    public static void npid(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)PID, param2);
    }

    static {
        Struct.Layout v0 = FOwnerEx.__struct(FOwnerEx.__member(4), FOwnerEx.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        PID = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<FOwnerEx, Buffer>
    implements NativeResource {
        private static final FOwnerEx ELEMENT_FACTORY = FOwnerEx.create(-1L);

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
        protected FOwnerEx getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return FOwnerEx.ntype(this.address());
        }

        @NativeType(value="pid_t")
        public int pid() {
            return FOwnerEx.npid(this.address());
        }

        public Buffer type(int param1) {
            FOwnerEx.ntype(this.address(), param1);
            return this;
        }

        public Buffer pid(@NativeType(value="pid_t") int param1) {
            FOwnerEx.npid(this.address(), param1);
            return this;
        }
    }
}

