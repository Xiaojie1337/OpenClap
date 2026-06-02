/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jni;

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

public class JNINativeMethod
extends Struct<JNINativeMethod>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int SIGNATURE;
    public static final int FNPTR;

    protected JNINativeMethod(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected JNINativeMethod create(long param1, @Nullable ByteBuffer param3) {
        return new JNINativeMethod(param1, param3);
    }

    public JNINativeMethod(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), JNINativeMethod.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return JNINativeMethod.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return JNINativeMethod.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer signature() {
        return JNINativeMethod.nsignature(this.address());
    }

    @NativeType(value="char *")
    public String signatureString() {
        return JNINativeMethod.nsignatureString(this.address());
    }

    @NativeType(value="void *")
    public long fnPtr() {
        return JNINativeMethod.nfnPtr(this.address());
    }

    public JNINativeMethod name(@NativeType(value="char *") ByteBuffer param1) {
        JNINativeMethod.nname(this.address(), param1);
        return this;
    }

    public JNINativeMethod signature(@NativeType(value="char *") ByteBuffer param1) {
        JNINativeMethod.nsignature(this.address(), param1);
        return this;
    }

    public JNINativeMethod fnPtr(@NativeType(value="void *") long param1) {
        JNINativeMethod.nfnPtr(this.address(), param1);
        return this;
    }

    public JNINativeMethod set(ByteBuffer param1, ByteBuffer param2, long param3) {
        this.name(param1);
        this.signature(param2);
        this.fnPtr(param3);
        return this;
    }

    public JNINativeMethod set(JNINativeMethod param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static JNINativeMethod malloc() {
        return new JNINativeMethod(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static JNINativeMethod calloc() {
        return new JNINativeMethod(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static JNINativeMethod create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new JNINativeMethod(MemoryUtil.memAddress(v0), v0);
    }

    public static JNINativeMethod create(long param0) {
        return new JNINativeMethod(param0, null);
    }

    @Nullable
    public static JNINativeMethod createSafe(long param0) {
        return param0 == 0L ? null : new JNINativeMethod(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(JNINativeMethod.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = JNINativeMethod.__create(param0, SIZEOF);
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
    public static JNINativeMethod mallocStack() {
        return JNINativeMethod.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod callocStack() {
        return JNINativeMethod.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod mallocStack(MemoryStack param0) {
        return JNINativeMethod.malloc(param0);
    }

    @Deprecated
    public static JNINativeMethod callocStack(MemoryStack param0) {
        return JNINativeMethod.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return JNINativeMethod.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return JNINativeMethod.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return JNINativeMethod.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return JNINativeMethod.calloc(param0, param1);
    }

    public static JNINativeMethod malloc(MemoryStack param0) {
        return new JNINativeMethod(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static JNINativeMethod calloc(MemoryStack param0) {
        return new JNINativeMethod(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static ByteBuffer nname(long param0) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(param0 + (long)NAME));
    }

    public static String nnameString(long param0) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(param0 + (long)NAME));
    }

    public static ByteBuffer nsignature(long param0) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(param0 + (long)SIGNATURE));
    }

    public static String nsignatureString(long param0) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(param0 + (long)SIGNATURE));
    }

    public static long nfnPtr(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)FNPTR);
    }

    public static void nname(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)NAME, MemoryUtil.memAddress(param2));
    }

    public static void nsignature(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)SIGNATURE, MemoryUtil.memAddress(param2));
    }

    public static void nfnPtr(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)FNPTR, Checks.check(param2));
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)SIGNATURE));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)FNPTR));
    }

    static {
        Struct.Layout v0 = JNINativeMethod.__struct(JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NAME = v0.offsetof(0);
        SIGNATURE = v0.offsetof(1);
        FNPTR = v0.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<JNINativeMethod, Buffer>
    implements NativeResource {
        private static final JNINativeMethod ELEMENT_FACTORY = JNINativeMethod.create(-1L);

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
        protected JNINativeMethod getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return JNINativeMethod.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return JNINativeMethod.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer signature() {
            return JNINativeMethod.nsignature(this.address());
        }

        @NativeType(value="char *")
        public String signatureString() {
            return JNINativeMethod.nsignatureString(this.address());
        }

        @NativeType(value="void *")
        public long fnPtr() {
            return JNINativeMethod.nfnPtr(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer param1) {
            JNINativeMethod.nname(this.address(), param1);
            return this;
        }

        public Buffer signature(@NativeType(value="char *") ByteBuffer param1) {
            JNINativeMethod.nsignature(this.address(), param1);
            return this;
        }

        public Buffer fnPtr(@NativeType(value="void *") long param1) {
            JNINativeMethod.nfnPtr(this.address(), param1);
            return this;
        }
    }
}

