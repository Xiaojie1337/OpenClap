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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class SECURITY_ATTRIBUTES
extends Struct<SECURITY_ATTRIBUTES>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NLENGTH;
    public static final int LPSECURITYDESCRIPTOR;
    public static final int BINHERITHANDLE;

    protected SECURITY_ATTRIBUTES(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected SECURITY_ATTRIBUTES create(long param1, @Nullable ByteBuffer param3) {
        return new SECURITY_ATTRIBUTES(param1, param3);
    }

    public SECURITY_ATTRIBUTES(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), SECURITY_ATTRIBUTES.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int nLength() {
        return SECURITY_ATTRIBUTES.nnLength(this.address());
    }

    @NativeType(value="LPVOID")
    public long lpSecurityDescriptor() {
        return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
    }

    @NativeType(value="BOOL")
    public boolean bInheritHandle() {
        return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
    }

    public SECURITY_ATTRIBUTES nLength(@NativeType(value="DWORD") int param1) {
        SECURITY_ATTRIBUTES.nnLength(this.address(), param1);
        return this;
    }

    public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType(value="LPVOID") long param1) {
        SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), param1);
        return this;
    }

    public SECURITY_ATTRIBUTES bInheritHandle(@NativeType(value="BOOL") boolean param1) {
        SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), param1 ? 1 : 0);
        return this;
    }

    public SECURITY_ATTRIBUTES set(int param1, long param2, boolean param4) {
        this.nLength(param1);
        this.lpSecurityDescriptor(param2);
        this.bInheritHandle(param4);
        return this;
    }

    public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static SECURITY_ATTRIBUTES malloc() {
        return new SECURITY_ATTRIBUTES(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES calloc() {
        return new SECURITY_ATTRIBUTES(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new SECURITY_ATTRIBUTES(MemoryUtil.memAddress(v0), v0);
    }

    public static SECURITY_ATTRIBUTES create(long param0) {
        return new SECURITY_ATTRIBUTES(param0, null);
    }

    @Nullable
    public static SECURITY_ATTRIBUTES createSafe(long param0) {
        return param0 == 0L ? null : new SECURITY_ATTRIBUTES(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(SECURITY_ATTRIBUTES.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = SECURITY_ATTRIBUTES.__create(param0, SIZEOF);
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
    public static SECURITY_ATTRIBUTES mallocStack() {
        return SECURITY_ATTRIBUTES.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack() {
        return SECURITY_ATTRIBUTES.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES mallocStack(MemoryStack param0) {
        return SECURITY_ATTRIBUTES.malloc(param0);
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack(MemoryStack param0) {
        return SECURITY_ATTRIBUTES.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return SECURITY_ATTRIBUTES.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return SECURITY_ATTRIBUTES.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return SECURITY_ATTRIBUTES.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return SECURITY_ATTRIBUTES.calloc(param0, param1);
    }

    public static SECURITY_ATTRIBUTES malloc(MemoryStack param0) {
        return new SECURITY_ATTRIBUTES(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES calloc(MemoryStack param0) {
        return new SECURITY_ATTRIBUTES(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nnLength(long param0) {
        return UNSAFE.getInt(null, param0 + (long)NLENGTH);
    }

    public static long nlpSecurityDescriptor(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)LPSECURITYDESCRIPTOR);
    }

    public static int nbInheritHandle(long param0) {
        return UNSAFE.getInt(null, param0 + (long)BINHERITHANDLE);
    }

    public static void nnLength(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)NLENGTH, param2);
    }

    public static void nlpSecurityDescriptor(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)LPSECURITYDESCRIPTOR, Checks.check(param2));
    }

    public static void nbInheritHandle(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)BINHERITHANDLE, param2);
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)LPSECURITYDESCRIPTOR));
    }

    static {
        Struct.Layout v0 = SECURITY_ATTRIBUTES.__struct(SECURITY_ATTRIBUTES.__member(4), SECURITY_ATTRIBUTES.__member(POINTER_SIZE), SECURITY_ATTRIBUTES.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NLENGTH = v0.offsetof(0);
        LPSECURITYDESCRIPTOR = v0.offsetof(1);
        BINHERITHANDLE = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
    implements NativeResource {
        private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);

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
        protected SECURITY_ATTRIBUTES getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int nLength() {
            return SECURITY_ATTRIBUTES.nnLength(this.address());
        }

        @NativeType(value="LPVOID")
        public long lpSecurityDescriptor() {
            return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
        }

        @NativeType(value="BOOL")
        public boolean bInheritHandle() {
            return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
        }

        public Buffer nLength(@NativeType(value="DWORD") int param1) {
            SECURITY_ATTRIBUTES.nnLength(this.address(), param1);
            return this;
        }

        public Buffer lpSecurityDescriptor(@NativeType(value="LPVOID") long param1) {
            SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), param1);
            return this;
        }

        public Buffer bInheritHandle(@NativeType(value="BOOL") boolean param1) {
            SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), param1 ? 1 : 0);
            return this;
        }
    }
}

