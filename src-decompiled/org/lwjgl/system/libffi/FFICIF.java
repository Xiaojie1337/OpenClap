/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFIType;

@NativeType(value="struct ffi_cif")
public class FFICIF
extends Struct<FFICIF>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ABI;
    public static final int NARGS;
    public static final int ARG_TYPES;
    public static final int RTYPE;
    public static final int BYTES;
    public static final int FLAGS;

    private static native int offsets(long var0);

    protected FFICIF(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected FFICIF create(long param1, @Nullable ByteBuffer param3) {
        return new FFICIF(param1, param3);
    }

    public FFICIF(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), FFICIF.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_abi")
    public int abi() {
        return FFICIF.nabi(this.address());
    }

    @NativeType(value="unsigned")
    public int nargs() {
        return FFICIF.nnargs(this.address());
    }

    @NativeType(value="ffi_type **")
    public PointerBuffer arg_types(int param1) {
        return FFICIF.narg_types(this.address(), param1);
    }

    @NativeType(value="ffi_type *")
    public FFIType rtype() {
        return FFICIF.nrtype(this.address());
    }

    @NativeType(value="unsigned")
    public int bytes() {
        return FFICIF.nbytes(this.address());
    }

    @NativeType(value="unsigned")
    public int flags() {
        return FFICIF.nflags(this.address());
    }

    public static FFICIF malloc() {
        return new FFICIF(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFICIF calloc() {
        return new FFICIF(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFICIF create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new FFICIF(MemoryUtil.memAddress(v0), v0);
    }

    public static FFICIF create(long param0) {
        return new FFICIF(param0, null);
    }

    @Nullable
    public static FFICIF createSafe(long param0) {
        return param0 == 0L ? null : new FFICIF(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFICIF.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = FFICIF.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FFICIF malloc(MemoryStack param0) {
        return new FFICIF(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFICIF calloc(MemoryStack param0) {
        return new FFICIF(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nabi(long param0) {
        return UNSAFE.getInt(null, param0 + (long)ABI);
    }

    public static int nnargs(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NARGS);
    }

    public static PointerBuffer narg_types(long param0, int param2) {
        return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(param0 + (long)ARG_TYPES), param2);
    }

    public static FFIType nrtype(long param0) {
        return FFIType.create(MemoryUtil.memGetAddress(param0 + (long)RTYPE));
    }

    public static int nbytes(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BYTES);
    }

    public static int nflags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FLAGS);
    }

    static {
        MemoryStack v0 = MemoryStack.stackPush();
        Throwable v1 = null;
        try {
            IntBuffer v2 = v0.mallocInt(7);
            SIZEOF = FFICIF.offsets(MemoryUtil.memAddress(v2));
            ABI = v2.get(0);
            NARGS = v2.get(1);
            ARG_TYPES = v2.get(2);
            RTYPE = v2.get(3);
            BYTES = v2.get(4);
            FLAGS = v2.get(5);
            ALIGNOF = v2.get(6);
            if (v0 != null) {
                v0.close();
            }
        }
        catch (Throwable v2) {
            try {
                v1 = v2;
                throw v2;
            }
            catch (Throwable v3) {
                if (v0 != null) {
                    if (v1 != null) {
                        try {
                            v0.close();
                        }
                        catch (Throwable v4) {
                            v1.addSuppressed(v4);
                        }
                    } else {
                        v0.close();
                    }
                }
                throw v3;
            }
        }
    }

    public static class Buffer
    extends StructBuffer<FFICIF, Buffer>
    implements NativeResource {
        private static final FFICIF ELEMENT_FACTORY = FFICIF.create(-1L);

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
        protected FFICIF getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_abi")
        public int abi() {
            return FFICIF.nabi(this.address());
        }

        @NativeType(value="unsigned")
        public int nargs() {
            return FFICIF.nnargs(this.address());
        }

        @NativeType(value="ffi_type **")
        public PointerBuffer arg_types(int param1) {
            return FFICIF.narg_types(this.address(), param1);
        }

        @NativeType(value="ffi_type *")
        public FFIType rtype() {
            return FFICIF.nrtype(this.address());
        }

        @NativeType(value="unsigned")
        public int bytes() {
            return FFICIF.nbytes(this.address());
        }

        @NativeType(value="unsigned")
        public int flags() {
            return FFICIF.nflags(this.address());
        }
    }
}

