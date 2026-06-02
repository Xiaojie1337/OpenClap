/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class LARGE_INTEGER
extends Struct<LARGE_INTEGER>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int U;
    public static final int U_LOWPART;
    public static final int U_HIGHPART;
    public static final int QUADPART;

    protected LARGE_INTEGER(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected LARGE_INTEGER create(long param1, @Nullable ByteBuffer param3) {
        return new LARGE_INTEGER(param1, param3);
    }

    public LARGE_INTEGER(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), LARGE_INTEGER.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int u_LowPart() {
        return LARGE_INTEGER.nu_LowPart(this.address());
    }

    @NativeType(value="LONG")
    public int u_HighPart() {
        return LARGE_INTEGER.nu_HighPart(this.address());
    }

    @NativeType(value="LONGLONG")
    public long QuadPart() {
        return LARGE_INTEGER.nQuadPart(this.address());
    }

    public LARGE_INTEGER u_LowPart(@NativeType(value="DWORD") int param1) {
        LARGE_INTEGER.nu_LowPart(this.address(), param1);
        return this;
    }

    public LARGE_INTEGER u_HighPart(@NativeType(value="LONG") int param1) {
        LARGE_INTEGER.nu_HighPart(this.address(), param1);
        return this;
    }

    public LARGE_INTEGER QuadPart(@NativeType(value="LONGLONG") long param1) {
        LARGE_INTEGER.nQuadPart(this.address(), param1);
        return this;
    }

    public LARGE_INTEGER set(LARGE_INTEGER param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static LARGE_INTEGER malloc() {
        return new LARGE_INTEGER(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static LARGE_INTEGER calloc() {
        return new LARGE_INTEGER(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static LARGE_INTEGER create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new LARGE_INTEGER(MemoryUtil.memAddress(v0), v0);
    }

    public static LARGE_INTEGER create(long param0) {
        return new LARGE_INTEGER(param0, null);
    }

    @Nullable
    public static LARGE_INTEGER createSafe(long param0) {
        return param0 == 0L ? null : new LARGE_INTEGER(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(LARGE_INTEGER.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = LARGE_INTEGER.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static LARGE_INTEGER malloc(MemoryStack param0) {
        return new LARGE_INTEGER(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static LARGE_INTEGER calloc(MemoryStack param0) {
        return new LARGE_INTEGER(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nu_LowPart(long param0) {
        return UNSAFE.getInt(null, param0 + (long)U_LOWPART);
    }

    public static int nu_HighPart(long param0) {
        return UNSAFE.getInt(null, param0 + (long)U_HIGHPART);
    }

    public static long nQuadPart(long param0) {
        return UNSAFE.getLong(null, param0 + (long)QUADPART);
    }

    public static void nu_LowPart(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)U_LOWPART, param2);
    }

    public static void nu_HighPart(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)U_HIGHPART, param2);
    }

    public static void nQuadPart(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)QUADPART, param2);
    }

    static {
        Struct.Layout v0 = LARGE_INTEGER.__union(LARGE_INTEGER.__struct(LARGE_INTEGER.__member(4), LARGE_INTEGER.__member(4)), LARGE_INTEGER.__member(8));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        U = v0.offsetof(0);
        U_LOWPART = v0.offsetof(1);
        U_HIGHPART = v0.offsetof(2);
        QUADPART = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<LARGE_INTEGER, Buffer>
    implements NativeResource {
        private static final LARGE_INTEGER ELEMENT_FACTORY = LARGE_INTEGER.create(-1L);

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
        protected LARGE_INTEGER getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int u_LowPart() {
            return LARGE_INTEGER.nu_LowPart(this.address());
        }

        @NativeType(value="LONG")
        public int u_HighPart() {
            return LARGE_INTEGER.nu_HighPart(this.address());
        }

        @NativeType(value="LONGLONG")
        public long QuadPart() {
            return LARGE_INTEGER.nQuadPart(this.address());
        }

        public Buffer u_LowPart(@NativeType(value="DWORD") int param1) {
            LARGE_INTEGER.nu_LowPart(this.address(), param1);
            return this;
        }

        public Buffer u_HighPart(@NativeType(value="LONG") int param1) {
            LARGE_INTEGER.nu_HighPart(this.address(), param1);
            return this;
        }

        public Buffer QuadPart(@NativeType(value="LONGLONG") long param1) {
            LARGE_INTEGER.nQuadPart(this.address(), param1);
            return this;
        }
    }
}

