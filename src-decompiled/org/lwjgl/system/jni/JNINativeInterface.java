/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jni;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeMethod;

public class JNINativeInterface {
    public static final int JNI_VERSION_1_1;
    public static final int JNI_VERSION_1_2;
    public static final int JNI_VERSION_1_4;
    public static final int JNI_VERSION_1_6;
    public static final int JNI_VERSION_1_8;
    public static final int JNI_VERSION_9;
    public static final int JNI_VERSION_10;
    public static final int JNI_VERSION_19;
    public static final int JNI_VERSION_20;
    public static final int JNI_VERSION_21;
    public static final int JNIInvalidRefType;
    public static final int JNILocalRefType;
    public static final int JNIGlobalRefType;
    public static final int JNIWeakGlobalRefType;
    public static final int JNI_FALSE;
    public static final int JNI_TRUE;
    public static final int JNI_OK;
    public static final int JNI_ERR;
    public static final int JNI_EDETACHED;
    public static final int JNI_EVERSION;
    public static final int JNI_ENOMEM;
    public static final int JNI_EEXIST;
    public static final int JNI_EINVAL;
    public static final int JNI_COMMIT;
    public static final int JNI_ABORT;

    protected JNINativeInterface() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="jint")
    public static native int GetVersion();

    @NativeType(value="jmethodID")
    public static native long FromReflectedMethod(@NativeType(value="jobject") Method var0);

    @NativeType(value="jfieldID")
    public static native long FromReflectedField(@NativeType(value="jobject") Field var0);

    @Nullable
    public static native Method nToReflectedMethod(Class<?> var0, long var1, boolean var3);

    @Nullable
    @NativeType(value="jobject")
    public static Method ToReflectedMethod(@NativeType(value="jclass") Class<?> param0, @NativeType(value="jmethodID") long param1, @NativeType(value="jboolean") boolean param3) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        return JNINativeInterface.nToReflectedMethod(param0, param1, param3);
    }

    @Nullable
    public static native Field nToReflectedField(Class<?> var0, long var1, boolean var3);

    @Nullable
    @NativeType(value="jobject")
    public static Field ToReflectedField(@NativeType(value="jclass") Class<?> param0, @NativeType(value="jfieldID") long param1, @NativeType(value="jboolean") boolean param3) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        return JNINativeInterface.nToReflectedField(param0, param1, param3);
    }

    @NativeType(value="void *")
    public static native long NewGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteGlobalRef(long var0);

    public static void DeleteGlobalRef(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNINativeInterface.nDeleteGlobalRef(param0);
    }

    public static native long nGetBooleanArrayElements(byte[] var0, long var1);

    @Nullable
    @NativeType(value="jboolean *")
    public static ByteBuffer GetBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetBooleanArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memByteBufferSafe(v2, param0.length);
    }

    public static native void nReleaseBooleanArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] param0, @NativeType(value="jboolean *") ByteBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseBooleanArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetByteArrayElements(byte[] var0, long var1);

    @Nullable
    @NativeType(value="jbyte *")
    public static ByteBuffer GetByteArrayElements(@NativeType(value="jbyteArray") byte[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetByteArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memByteBufferSafe(v2, param0.length);
    }

    public static native void nReleaseByteArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseByteArrayElements(@NativeType(value="jbyteArray") byte[] param0, @NativeType(value="jbyte *") ByteBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseByteArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetCharArrayElements(char[] var0, long var1);

    @Nullable
    @NativeType(value="jchar *")
    public static ShortBuffer GetCharArrayElements(@NativeType(value="jcharArray") char[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetCharArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memShortBufferSafe(v2, param0.length);
    }

    public static native void nReleaseCharArrayElements(char[] var0, long var1, int var3);

    public static void ReleaseCharArrayElements(@NativeType(value="jcharArray") char[] param0, @NativeType(value="jchar *") ShortBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseCharArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetShortArrayElements(short[] var0, long var1);

    @Nullable
    @NativeType(value="jshort *")
    public static ShortBuffer GetShortArrayElements(@NativeType(value="jshortArray") short[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetShortArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memShortBufferSafe(v2, param0.length);
    }

    public static native void nReleaseShortArrayElements(short[] var0, long var1, int var3);

    public static void ReleaseShortArrayElements(@NativeType(value="jshortArray") short[] param0, @NativeType(value="jshort *") ShortBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseShortArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetIntArrayElements(int[] var0, long var1);

    @Nullable
    @NativeType(value="jint *")
    public static IntBuffer GetIntArrayElements(@NativeType(value="jintArray") int[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetIntArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memIntBufferSafe(v2, param0.length);
    }

    public static native void nReleaseIntArrayElements(int[] var0, long var1, int var3);

    public static void ReleaseIntArrayElements(@NativeType(value="jintArray") int[] param0, @NativeType(value="jint *") IntBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseIntArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetLongArrayElements(long[] var0, long var1);

    @Nullable
    @NativeType(value="jlong *")
    public static LongBuffer GetLongArrayElements(@NativeType(value="jlongArray") long[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetLongArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memLongBufferSafe(v2, param0.length);
    }

    public static native void nReleaseLongArrayElements(long[] var0, long var1, int var3);

    public static void ReleaseLongArrayElements(@NativeType(value="jlongArray") long[] param0, @NativeType(value="jlong *") LongBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseLongArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetFloatArrayElements(float[] var0, long var1);

    @Nullable
    @NativeType(value="jfloat *")
    public static FloatBuffer GetFloatArrayElements(@NativeType(value="jfloatArray") float[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetFloatArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memFloatBufferSafe(v2, param0.length);
    }

    public static native void nReleaseFloatArrayElements(float[] var0, long var1, int var3);

    public static void ReleaseFloatArrayElements(@NativeType(value="jfloatArray") float[] param0, @NativeType(value="jfloat *") FloatBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseFloatArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native long nGetDoubleArrayElements(double[] var0, long var1);

    @Nullable
    @NativeType(value="jdouble *")
    public static DoubleBuffer GetDoubleArrayElements(@NativeType(value="jdoubleArray") double[] param0, @Nullable @NativeType(value="jboolean *") ByteBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        long v2 = JNINativeInterface.nGetDoubleArrayElements(param0, MemoryUtil.memAddressSafe(param1));
        return MemoryUtil.memDoubleBufferSafe(v2, param0.length);
    }

    public static native void nReleaseDoubleArrayElements(double[] var0, long var1, int var3);

    public static void ReleaseDoubleArrayElements(@NativeType(value="jdoubleArray") double[] param0, @NativeType(value="jdouble *") DoubleBuffer param1, @NativeType(value="jint") int param2) {
        JNINativeInterface.nReleaseDoubleArrayElements(param0, MemoryUtil.memAddress(param1), param2);
    }

    public static native void nGetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jboolean *") ByteBuffer param2) {
        JNINativeInterface.nGetBooleanArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jboolean const *") ByteBuffer param2) {
        JNINativeInterface.nSetBooleanArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetByteArrayRegion(@NativeType(value="jbyteArray") byte[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jbyte *") ByteBuffer param2) {
        JNINativeInterface.nGetByteArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetByteArrayRegion(@NativeType(value="jbyteArray") byte[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jbyte const *") ByteBuffer param2) {
        JNINativeInterface.nSetByteArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void GetCharArrayRegion(@NativeType(value="jcharArray") char[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jchar *") ShortBuffer param2) {
        JNINativeInterface.nGetCharArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void SetCharArrayRegion(@NativeType(value="jcharArray") char[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jchar const *") ShortBuffer param2) {
        JNINativeInterface.nSetCharArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void GetShortArrayRegion(@NativeType(value="jshortArray") short[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jshort *") ShortBuffer param2) {
        JNINativeInterface.nGetShortArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void SetShortArrayRegion(@NativeType(value="jshortArray") short[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jshort const *") ShortBuffer param2) {
        JNINativeInterface.nSetShortArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void GetIntArrayRegion(@NativeType(value="jintArray") int[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jint *") IntBuffer param2) {
        JNINativeInterface.nGetIntArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void SetIntArrayRegion(@NativeType(value="jintArray") int[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jint const *") IntBuffer param2) {
        JNINativeInterface.nSetIntArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void GetLongArrayRegion(@NativeType(value="jlongArray") long[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jlong *") LongBuffer param2) {
        JNINativeInterface.nGetLongArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void SetLongArrayRegion(@NativeType(value="jlongArray") long[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jlong const *") LongBuffer param2) {
        JNINativeInterface.nSetLongArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void GetFloatArrayRegion(@NativeType(value="jfloatArray") float[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jfloat *") FloatBuffer param2) {
        JNINativeInterface.nGetFloatArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void SetFloatArrayRegion(@NativeType(value="jfloatArray") float[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jfloat const *") FloatBuffer param2) {
        JNINativeInterface.nSetFloatArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nGetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void GetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jdouble *") DoubleBuffer param2) {
        JNINativeInterface.nGetDoubleArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native void nSetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void SetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] param0, @NativeType(value="jsize") int param1, @NativeType(value="jdouble const *") DoubleBuffer param2) {
        JNINativeInterface.nSetDoubleArrayRegion(param0, param1, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    public static native int nRegisterNatives(Class<?> var0, long var1, int var3);

    @NativeType(value="jint")
    public static int RegisterNatives(@NativeType(value="jclass") Class<?> param0, @NativeType(value="JNINativeMethod const *") JNINativeMethod.Buffer param1) {
        if (Checks.CHECKS) {
            Struct.validate(param1.address(), param1.remaining(), JNINativeMethod.SIZEOF, JNINativeMethod::validate);
        }
        return JNINativeInterface.nRegisterNatives(param0, param1.address(), param1.remaining());
    }

    @NativeType(value="jint")
    public static native int UnregisterNatives(@NativeType(value="jclass") Class<?> var0);

    public static native int nGetJavaVM(long var0);

    @NativeType(value="jint")
    public static int GetJavaVM(@NativeType(value="JavaVM **") PointerBuffer param0) {
        if (Checks.CHECKS) {
            Checks.check(param0, 1);
        }
        return JNINativeInterface.nGetJavaVM(MemoryUtil.memAddress(param0));
    }

    public static native void nGetStringRegion(String var0, int var1, int var2, long var3);

    public static void GetStringRegion(@NativeType(value="jstring") String param0, @NativeType(value="jsize") int param1, @NativeType(value="jchar *") ByteBuffer param2) {
        JNINativeInterface.nGetStringRegion(param0, param1, param2.remaining() >> 1, MemoryUtil.memAddress(param2));
    }

    public static native void nGetStringUTFRegion(String var0, int var1, int var2, long var3);

    public static void GetStringUTFRegion(@NativeType(value="jstring") String param0, @NativeType(value="jsize") int param1, @NativeType(value="jsize") int param2, @NativeType(value="char *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, param2);
        }
        JNINativeInterface.nGetStringUTFRegion(param0, param1, param2, MemoryUtil.memAddress(param3));
    }

    @NativeType(value="void *")
    public static native long NewWeakGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteWeakGlobalRef(long var0);

    public static void DeleteWeakGlobalRef(@NativeType(value="void *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNINativeInterface.nDeleteWeakGlobalRef(param0);
    }

    @Nullable
    public static native ByteBuffer nNewDirectByteBuffer(long var0, long var2);

    @Nullable
    @NativeType(value="jobject")
    public static ByteBuffer NewDirectByteBuffer(@NativeType(value="void *") long param0, @NativeType(value="jlong") long param2) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNINativeInterface.nNewDirectByteBuffer(param0, param2);
    }

    @NativeType(value="void *")
    public static native long GetDirectBufferAddress(@NativeType(value="jobject") Buffer var0);

    @NativeType(value="jobjectRefType")
    public static native int GetObjectRefType(@NativeType(value="jobject") Object var0);

    public static native void noop();

    static {
        JNI_ABORT = 2;
        JNI_COMMIT = 1;
        JNI_EINVAL = -6;
        JNI_EEXIST = -5;
        JNI_ENOMEM = -4;
        JNI_EVERSION = -3;
        JNI_EDETACHED = -2;
        JNI_ERR = -1;
        JNI_OK = 0;
        JNI_TRUE = 1;
        JNI_FALSE = 0;
        JNIWeakGlobalRefType = 3;
        JNIGlobalRefType = 2;
        JNILocalRefType = 1;
        JNIInvalidRefType = 0;
        JNI_VERSION_21 = 0x150000;
        JNI_VERSION_20 = 0x140000;
        JNI_VERSION_19 = 0x130000;
        JNI_VERSION_10 = 655360;
        JNI_VERSION_9 = 589824;
        JNI_VERSION_1_8 = 65544;
        JNI_VERSION_1_6 = 65542;
        JNI_VERSION_1_4 = 65540;
        JNI_VERSION_1_2 = 65538;
        JNI_VERSION_1_1 = 65537;
        Library.initialize();
    }
}

