/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.Struct;
import org.lwjgl.system.libc.LibCStdlib;
import org.lwjgl.system.macosx.EnumerationMutationHandlerI;
import org.lwjgl.system.macosx.ObjCMethodDescription;
import org.lwjgl.system.macosx.ObjCPropertyAttribute;

public class ObjCRuntime {
    private static final SharedLibrary OBJC;
    public static final long nil;
    public static final byte YES;
    public static final byte NO;
    public static final char _C_ID;
    public static final char _C_CLASS;
    public static final char _C_SEL;
    public static final char _C_CHR;
    public static final char _C_UCHR;
    public static final char _C_SHT;
    public static final char _C_USHT;
    public static final char _C_INT;
    public static final char _C_UINT;
    public static final char _C_LNG;
    public static final char _C_ULNG;
    public static final char _C_LNG_LNG;
    public static final char _C_ULNG_LNG;
    public static final char _C_FLT;
    public static final char _C_DBL;
    public static final char _C_BFLD;
    public static final char _C_BOOL;
    public static final char _C_VOID;
    public static final char _C_UNDEF;
    public static final char _C_PTR;
    public static final char _C_CHARPTR;
    public static final char _C_ATOM;
    public static final char _C_ARY_B;
    public static final char _C_ARY_E;
    public static final char _C_UNION_B;
    public static final char _C_UNION_E;
    public static final char _C_STRUCT_B;
    public static final char _C_STRUCT_E;
    public static final char _C_VECTOR;
    public static final char _C_CONST;
    public static final int OBJC_ASSOCIATION_ASSIGN;
    public static final int OBJC_ASSOCIATION_RETAIN_NONATOMIC;
    public static final int OBJC_ASSOCIATION_COPY_NONATOMIC;
    public static final int OBJC_ASSOCIATION_RETAIN;
    public static final int OBJC_ASSOCIATION_COPY;

    public static SharedLibrary getLibrary() {
        return OBJC;
    }

    protected ObjCRuntime() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="id")
    public static long object_copy(@NativeType(value="id") long param0, @NativeType(value="size_t") long param2) {
        long v4 = Functions.object_copy;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="id")
    public static long object_dispose(@NativeType(value="id") long param0) {
        long v2 = Functions.object_dispose;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long object_getClass(@NativeType(value="id") long param0) {
        long v2 = Functions.object_getClass;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long object_setClass(@NativeType(value="id") long param0, @NativeType(value="Class") long param2) {
        long v4 = Functions.object_setClass;
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    public static long nobject_getClassName(long param0) {
        long v2 = Functions.object_getClassName;
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String object_getClassName(@NativeType(value="id") long param0) {
        long v2 = ObjCRuntime.nobject_getClassName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    @NativeType(value="void *")
    public static long object_getIndexedIvars(@NativeType(value="id") long param0) {
        long v2 = Functions.object_getIndexedIvars;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="id")
    public static long object_getIvar(@NativeType(value="id") long param0, @NativeType(value="Ivar") long param2) {
        long v4 = Functions.object_getIvar;
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    public static void object_setIvar(@NativeType(value="id") long param0, @NativeType(value="Ivar") long param2, @NativeType(value="id") long param4) {
        long v6 = Functions.object_setIvar;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
            Checks.check(param4);
        }
        JNI.invokePPPV(param0, param2, param4, v6);
    }

    public static long nobject_setInstanceVariable(long param0, long param2, long param4) {
        long v6 = Functions.object_setInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPPP(param0, param2, param4, v6);
    }

    @NativeType(value="Ivar")
    public static long object_setInstanceVariable(@NativeType(value="id") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="void *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nobject_setInstanceVariable(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3));
    }

    @NativeType(value="Ivar")
    public static long object_setInstanceVariable(@NativeType(value="id") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="void *") ByteBuffer param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            long v8 = ObjCRuntime.nobject_setInstanceVariable(param0, v6, MemoryUtil.memAddress(param3));
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static long nobject_getInstanceVariable(long param0, long param2, long param4) {
        long v6 = Functions.object_getInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPPP(param0, param2, param4, v6);
    }

    @NativeType(value="Ivar")
    public static long object_getInstanceVariable(@NativeType(value="id") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="void **") PointerBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
            Checks.check(param3, 1);
        }
        return ObjCRuntime.nobject_getInstanceVariable(param0, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3));
    }

    @NativeType(value="Ivar")
    public static long object_getInstanceVariable(@NativeType(value="id") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="void **") PointerBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param3, 1);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            long v8 = ObjCRuntime.nobject_getInstanceVariable(param0, v6, MemoryUtil.memAddress(param3));
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static long nobjc_getClass(long param0) {
        long v2 = Functions.objc_getClass;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long objc_getClass(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_getClass(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Class")
    public static long objc_getClass(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_getClass(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nobjc_getMetaClass(long param0) {
        long v2 = Functions.objc_getMetaClass;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long objc_getMetaClass(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_getMetaClass(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Class")
    public static long objc_getMetaClass(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_getMetaClass(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nobjc_lookUpClass(long param0) {
        long v2 = Functions.objc_lookUpClass;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long objc_lookUpClass(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_lookUpClass(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Class")
    public static long objc_lookUpClass(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_lookUpClass(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nobjc_getRequiredClass(long param0) {
        long v2 = Functions.objc_getRequiredClass;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Class")
    public static long objc_getRequiredClass(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_getRequiredClass(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Class")
    public static long objc_getRequiredClass(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_getRequiredClass(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static int nobjc_getClassList(long param0, int param2) {
        long v3 = Functions.objc_getClassList;
        return JNI.invokePI(param0, param2, v3);
    }

    public static int objc_getClassList(@Nullable @NativeType(value="Class *") PointerBuffer param0) {
        return ObjCRuntime.nobjc_getClassList(MemoryUtil.memAddressSafe(param0), Checks.remainingSafe(param0));
    }

    public static long nobjc_copyClassList(long param0) {
        long v2 = Functions.objc_copyClassList;
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="Class *")
    public static PointerBuffer objc_copyClassList() {
        MemoryStack v0 = MemoryStack.stackGet();
        int v1 = v0.getPointer();
        IntBuffer v2 = v0.callocInt(1);
        try {
            long v3 = ObjCRuntime.nobjc_copyClassList(MemoryUtil.memAddress(v2));
            PointerBuffer v5 = MemoryUtil.memPointerBufferSafe(v3, v2.get(0));
            return v5;
        }
        finally {
            v0.setPointer(v1);
        }
    }

    public static long nclass_getName(long param0) {
        long v2 = Functions.class_getName;
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String class_getName(@NativeType(value="Class") long param0) {
        long v2 = ObjCRuntime.nclass_getName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    @NativeType(value="BOOL")
    public static boolean class_isMetaClass(@NativeType(value="Class") long param0) {
        long v2 = Functions.class_isMetaClass;
        return JNI.invokePZ(param0, v2);
    }

    @NativeType(value="Class")
    public static long class_getSuperclass(@NativeType(value="Class") long param0) {
        long v2 = Functions.class_getSuperclass;
        return JNI.invokePP(param0, v2);
    }

    public static int class_getVersion(@NativeType(value="Class") long param0) {
        long v2 = Functions.class_getVersion;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePI(param0, v2);
    }

    public static void class_setVersion(@NativeType(value="Class") long param0, int param2) {
        long v3 = Functions.class_setVersion;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, param2, v3);
    }

    @NativeType(value="size_t")
    public static long class_getInstanceSize(@NativeType(value="Class") long param0) {
        long v2 = Functions.class_getInstanceSize;
        return JNI.invokePP(param0, v2);
    }

    public static long nclass_getInstanceVariable(long param0, long param2) {
        long v4 = Functions.class_getInstanceVariable;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="Ivar")
    public static long class_getInstanceVariable(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nclass_getInstanceVariable(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="Ivar")
    public static long class_getInstanceVariable(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = ObjCRuntime.nclass_getInstanceVariable(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static long nclass_getClassVariable(long param0, long param2) {
        long v4 = Functions.class_getClassVariable;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="Ivar")
    public static long class_getClassVariable(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nclass_getClassVariable(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="Ivar")
    public static long class_getClassVariable(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = ObjCRuntime.nclass_getClassVariable(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static long nclass_copyIvarList(long param0, long param2) {
        long v4 = Functions.class_copyIvarList;
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="Ivar *")
    public static PointerBuffer class_copyIvarList(@NativeType(value="Class") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nclass_copyIvarList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    @NativeType(value="Method")
    public static long class_getInstanceMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2) {
        long v4 = Functions.class_getInstanceMethod;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="Method")
    public static long class_getClassMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2) {
        long v4 = Functions.class_getClassMethod;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="IMP")
    public static long class_getMethodImplementation(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2) {
        long v4 = Functions.class_getMethodImplementation;
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean class_respondsToSelector(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2) {
        long v4 = Functions.class_respondsToSelector;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    public static long nclass_copyMethodList(long param0, long param2) {
        long v4 = Functions.class_copyMethodList;
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="Method *")
    public static PointerBuffer class_copyMethodList(@NativeType(value="Class") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nclass_copyMethodList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    @NativeType(value="BOOL")
    public static boolean class_conformsToProtocol(@NativeType(value="Class") long param0, @NativeType(value="Protocol *") long param2) {
        long v4 = Functions.class_conformsToProtocol;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    public static long nclass_copyProtocolList(long param0, long param2) {
        long v4 = Functions.class_copyProtocolList;
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer class_copyProtocolList(@NativeType(value="Class") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nclass_copyProtocolList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static long nclass_getProperty(long param0, long param2) {
        long v4 = Functions.class_getProperty;
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="objc_property_t")
    public static long class_getProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nclass_getProperty(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="objc_property_t")
    public static long class_getProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = ObjCRuntime.nclass_getProperty(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static long nclass_copyPropertyList(long param0, long param2) {
        long v4 = Functions.class_copyPropertyList;
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="objc_property_t *")
    public static PointerBuffer class_copyPropertyList(@NativeType(value="Class") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nclass_copyPropertyList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static long nclass_getIvarLayout(long param0) {
        long v2 = Functions.class_getIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="uint8_t const *")
    public static String class_getIvarLayout(@NativeType(value="Class") long param0) {
        long v2 = ObjCRuntime.nclass_getIvarLayout(param0);
        return MemoryUtil.memASCIISafe(v2);
    }

    public static long nclass_getWeakIvarLayout(long param0) {
        long v2 = Functions.class_getWeakIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="uint8_t const *")
    public static String class_getWeakIvarLayout(@NativeType(value="Class") long param0) {
        long v2 = ObjCRuntime.nclass_getWeakIvarLayout(param0);
        return MemoryUtil.memASCIISafe(v2);
    }

    public static boolean nclass_addMethod(long param0, long param2, long param4, long param6) {
        long v8 = Functions.class_addMethod;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
            Checks.check(param4);
        }
        return JNI.invokePPPPZ(param0, param2, param4, param6, v8);
    }

    @NativeType(value="BOOL")
    public static boolean class_addMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2, @NativeType(value="IMP") long param4, @NativeType(value="char const *") ByteBuffer param6) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param6);
        }
        return ObjCRuntime.nclass_addMethod(param0, param2, param4, MemoryUtil.memAddress(param6));
    }

    @NativeType(value="BOOL")
    public static boolean class_addMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2, @NativeType(value="IMP") long param4, @NativeType(value="char const *") CharSequence param6) {
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            v7.nUTF8(param6, true);
            long v9 = v7.getPointerAddress();
            boolean v11 = ObjCRuntime.nclass_addMethod(param0, param2, param4, v9);
            return v11;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static long nclass_replaceMethod(long param0, long param2, long param4, long param6) {
        long v8 = Functions.class_replaceMethod;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
            Checks.check(param4);
        }
        return JNI.invokePPPPP(param0, param2, param4, param6, v8);
    }

    @NativeType(value="IMP")
    public static long class_replaceMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2, @NativeType(value="IMP") long param4, @NativeType(value="char const *") ByteBuffer param6) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param6);
        }
        return ObjCRuntime.nclass_replaceMethod(param0, param2, param4, MemoryUtil.memAddress(param6));
    }

    @NativeType(value="IMP")
    public static long class_replaceMethod(@NativeType(value="Class") long param0, @NativeType(value="SEL") long param2, @NativeType(value="IMP") long param4, @NativeType(value="char const *") CharSequence param6) {
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            v7.nUTF8(param6, true);
            long v9 = v7.getPointerAddress();
            long v11 = ObjCRuntime.nclass_replaceMethod(param0, param2, param4, v9);
            return v11;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static boolean nclass_addIvar(long param0, long param2, long param4, byte param6, long param7) {
        long v9 = Functions.class_addIvar;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPPUPZ(param0, param2, param4, param6, param7, v9);
    }

    @NativeType(value="BOOL")
    public static boolean class_addIvar(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="size_t") long param3, @NativeType(value="uint8_t") byte param5, @NativeType(value="char const *") ByteBuffer param6) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
            Checks.checkNT1(param6);
        }
        return ObjCRuntime.nclass_addIvar(param0, MemoryUtil.memAddress(param2), param3, param5, MemoryUtil.memAddress(param6));
    }

    @NativeType(value="BOOL")
    public static boolean class_addIvar(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="size_t") long param3, @NativeType(value="uint8_t") byte param5, @NativeType(value="char const *") CharSequence param6) {
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            v7.nUTF8(param2, true);
            long v9 = v7.getPointerAddress();
            v7.nUTF8(param6, true);
            long v11 = v7.getPointerAddress();
            boolean v13 = ObjCRuntime.nclass_addIvar(param0, v9, param3, param5, v11);
            return v13;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    @NativeType(value="BOOL")
    public static boolean class_addProtocol(@NativeType(value="Class") long param0, @NativeType(value="Protocol *") long param2) {
        long v4 = Functions.class_addProtocol;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    public static boolean nclass_addProperty(long param0, long param2, long param4, int param6) {
        long v7 = Functions.class_addProperty;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Struct.validate(param4, param6, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
        }
        return JNI.invokePPPZ(param0, param2, param4, param6, v7);
    }

    @NativeType(value="BOOL")
    public static boolean class_addProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nclass_addProperty(param0, MemoryUtil.memAddress(param2), param3.address(), param3.remaining());
    }

    @NativeType(value="BOOL")
    public static boolean class_addProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            boolean v8 = ObjCRuntime.nclass_addProperty(param0, v6, param3.address(), param3.remaining());
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static void nclass_replaceProperty(long param0, long param2, long param4, int param6) {
        long v7 = Functions.class_replaceProperty;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Struct.validate(param4, param6, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
        }
        JNI.invokePPPV(param0, param2, param4, param6, v7);
    }

    public static void class_replaceProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        ObjCRuntime.nclass_replaceProperty(param0, MemoryUtil.memAddress(param2), param3.address(), param3.remaining());
    }

    public static void class_replaceProperty(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            ObjCRuntime.nclass_replaceProperty(param0, v6, param3.address(), param3.remaining());
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static void nclass_setIvarLayout(long param0, long param2) {
        long v4 = Functions.class_setIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePPV(param0, param2, v4);
    }

    public static void class_setIvarLayout(@NativeType(value="Class") long param0, @NativeType(value="uint8_t const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        ObjCRuntime.nclass_setIvarLayout(param0, MemoryUtil.memAddress(param2));
    }

    public static void class_setIvarLayout(@NativeType(value="Class") long param0, @NativeType(value="uint8_t const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            ObjCRuntime.nclass_setIvarLayout(param0, v5);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static void nclass_setWeakIvarLayout(long param0, long param2) {
        long v4 = Functions.class_setWeakIvarLayout;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePPV(param0, param2, v4);
    }

    public static void class_setWeakIvarLayout(@NativeType(value="Class") long param0, @NativeType(value="uint8_t const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        ObjCRuntime.nclass_setWeakIvarLayout(param0, MemoryUtil.memAddress(param2));
    }

    public static void class_setWeakIvarLayout(@NativeType(value="Class") long param0, @NativeType(value="uint8_t const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nASCII(param2, true);
            long v5 = v3.getPointerAddress();
            ObjCRuntime.nclass_setWeakIvarLayout(param0, v5);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    @NativeType(value="id")
    public static long class_createInstance(@NativeType(value="Class") long param0, @NativeType(value="size_t") long param2) {
        long v4 = Functions.class_createInstance;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    public static long nobjc_constructInstance(long param0, long param2) {
        long v4 = Functions.objc_constructInstance;
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="id")
    public static long objc_constructInstance(@NativeType(value="Class") long param0, @Nullable @NativeType(value="void *") ByteBuffer param2) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.checkSafe((Buffer)param2, ObjCRuntime.class_getInstanceSize(param0));
        }
        return ObjCRuntime.nobjc_constructInstance(param0, MemoryUtil.memAddressSafe(param2));
    }

    @NativeType(value="void *")
    public static long objc_destructInstance(@NativeType(value="id") long param0) {
        long v2 = Functions.objc_destructInstance;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    public static long nobjc_allocateClassPair(long param0, long param2, long param4) {
        long v6 = Functions.objc_allocateClassPair;
        return JNI.invokePPPP(param0, param2, param4, v6);
    }

    @NativeType(value="Class")
    public static long objc_allocateClassPair(@NativeType(value="Class") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="size_t") long param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nobjc_allocateClassPair(param0, MemoryUtil.memAddress(param2), param3);
    }

    @NativeType(value="Class")
    public static long objc_allocateClassPair(@NativeType(value="Class") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="size_t") long param3) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param2, true);
            long v7 = v5.getPointerAddress();
            long v9 = ObjCRuntime.nobjc_allocateClassPair(param0, v7, param3);
            return v9;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static void objc_registerClassPair(@NativeType(value="Class") long param0) {
        long v2 = Functions.objc_registerClassPair;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    public static void objc_disposeClassPair(@NativeType(value="Class") long param0) {
        long v2 = Functions.objc_disposeClassPair;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    @NativeType(value="SEL")
    public static long method_getName(@NativeType(value="Method") long param0) {
        long v2 = Functions.method_getName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="IMP")
    public static long method_getImplementation(@NativeType(value="Method") long param0) {
        long v2 = Functions.method_getImplementation;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    public static long nmethod_getTypeEncoding(long param0) {
        long v2 = Functions.method_getTypeEncoding;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String method_getTypeEncoding(@NativeType(value="Method") long param0) {
        long v2 = ObjCRuntime.nmethod_getTypeEncoding(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    @NativeType(value="unsigned int")
    public static int method_getNumberOfArguments(@NativeType(value="Method") long param0) {
        long v2 = Functions.method_getNumberOfArguments;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePI(param0, v2);
    }

    public static long nmethod_copyReturnType(long param0) {
        long v2 = Functions.method_copyReturnType;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char *")
    public static String method_copyReturnType(@NativeType(value="Method") long param0) {
        long v2 = ObjCRuntime.nmethod_copyReturnType(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nmethod_copyArgumentType(long param0, int param2) {
        long v3 = Functions.method_copyArgumentType;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, param2, v3);
    }

    @Nullable
    @NativeType(value="char *")
    public static String method_copyArgumentType(@NativeType(value="Method") long param0, @NativeType(value="unsigned int") int param2) {
        long v3 = 0L;
        try {
            v3 = ObjCRuntime.nmethod_copyArgumentType(param0, param2);
            String v5 = MemoryUtil.memUTF8Safe(v3);
            return v5;
        }
        finally {
            if (v3 != 0L) {
                LibCStdlib.nfree(v3);
            }
        }
    }

    public static void nmethod_getReturnType(long param0, long param2, long param4) {
        long v6 = Functions.method_getReturnType;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePPPV(param0, param2, param4, v6);
    }

    public static void method_getReturnType(@NativeType(value="Method") long param0, @NativeType(value="char *") ByteBuffer param2) {
        ObjCRuntime.nmethod_getReturnType(param0, MemoryUtil.memAddress(param2), param2.remaining());
    }

    @NativeType(value="void")
    public static String method_getReturnType(@NativeType(value="Method") long param0, @NativeType(value="size_t") long param2) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            ByteBuffer v6 = v4.malloc((int)param2);
            ObjCRuntime.nmethod_getReturnType(param0, MemoryUtil.memAddress(v6), param2);
            String v7 = MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(v6), (int)param2));
            return v7;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static void nmethod_getArgumentType(long param0, int param2, long param3, long param5) {
        long v7 = Functions.method_getArgumentType;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePPPV(param0, param2, param3, param5, v7);
    }

    public static void method_getArgumentType(@NativeType(value="Method") long param0, @NativeType(value="unsigned int") int param2, @NativeType(value="char *") ByteBuffer param3) {
        ObjCRuntime.nmethod_getArgumentType(param0, param2, MemoryUtil.memAddress(param3), param3.remaining());
    }

    @NativeType(value="void")
    public static String method_getArgumentType(@NativeType(value="Method") long param0, @NativeType(value="unsigned int") int param2, @NativeType(value="size_t") long param3) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            ByteBuffer v7 = v5.malloc((int)param3);
            ObjCRuntime.nmethod_getArgumentType(param0, param2, MemoryUtil.memAddress(v7), param3);
            String v8 = MemoryUtil.memUTF8(MemoryUtil.memByteBufferNT1(MemoryUtil.memAddress(v7), (int)param3));
            return v8;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    @NativeType(value="IMP")
    public static long method_setImplementation(@NativeType(value="Method") long param0, @NativeType(value="IMP") long param2) {
        long v4 = Functions.method_setImplementation;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    public static void method_exchangeImplementations(@NativeType(value="Method") long param0, @NativeType(value="Method") long param2) {
        long v4 = Functions.method_exchangeImplementations;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        JNI.invokePPV(param0, param2, v4);
    }

    public static long nivar_getName(long param0) {
        long v2 = Functions.ivar_getName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String ivar_getName(@NativeType(value="Ivar") long param0) {
        long v2 = ObjCRuntime.nivar_getName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nivar_getTypeEncoding(long param0) {
        long v2 = Functions.ivar_getTypeEncoding;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String ivar_getTypeEncoding(@NativeType(value="Ivar") long param0) {
        long v2 = ObjCRuntime.nivar_getTypeEncoding(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    @NativeType(value="ptrdiff_t")
    public static long ivar_getOffset(@NativeType(value="Ivar") long param0) {
        long v2 = Functions.ivar_getOffset;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    public static long nproperty_getName(long param0) {
        long v2 = Functions.property_getName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String property_getName(@NativeType(value="objc_property_t") long param0) {
        long v2 = ObjCRuntime.nproperty_getName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nproperty_getAttributes(long param0) {
        long v2 = Functions.property_getAttributes;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String property_getAttributes(@NativeType(value="objc_property_t") long param0) {
        long v2 = ObjCRuntime.nproperty_getAttributes(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nproperty_copyAttributeList(long param0, long param2) {
        long v4 = Functions.property_copyAttributeList;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="objc_property_attribute_t *")
    public static ObjCPropertyAttribute.Buffer property_copyAttributeList(@NativeType(value="objc_property_t") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nproperty_copyAttributeList(param0, MemoryUtil.memAddress(v4));
            ObjCPropertyAttribute.Buffer v7 = ObjCPropertyAttribute.createSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static long nproperty_copyAttributeValue(long param0, long param2) {
        long v4 = Functions.property_copyAttributeValue;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="char *")
    public static String property_copyAttributeValue(@NativeType(value="objc_property_t") long param0, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        long v3 = 0L;
        try {
            v3 = ObjCRuntime.nproperty_copyAttributeValue(param0, MemoryUtil.memAddress(param2));
            String v5 = MemoryUtil.memUTF8Safe(v3);
            return v5;
        }
        finally {
            if (v3 != 0L) {
                LibCStdlib.nfree(v3);
            }
        }
    }

    @Nullable
    @NativeType(value="char *")
    public static String property_copyAttributeValue(@NativeType(value="objc_property_t") long param0, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        long v5 = 0L;
        try {
            v3.nUTF8(param2, true);
            long v7 = v3.getPointerAddress();
            v5 = ObjCRuntime.nproperty_copyAttributeValue(param0, v7);
            String v9 = MemoryUtil.memUTF8Safe(v5);
            return v9;
        }
        finally {
            if (v5 != 0L) {
                LibCStdlib.nfree(v5);
            }
            v3.setPointer(v4);
        }
    }

    public static long nobjc_getProtocol(long param0) {
        long v2 = Functions.objc_getProtocol;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Protocol *")
    public static long objc_getProtocol(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_getProtocol(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Protocol *")
    public static long objc_getProtocol(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_getProtocol(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nobjc_copyProtocolList(long param0) {
        long v2 = Functions.objc_copyProtocolList;
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer objc_copyProtocolList() {
        MemoryStack v0 = MemoryStack.stackGet();
        int v1 = v0.getPointer();
        IntBuffer v2 = v0.callocInt(1);
        try {
            long v3 = ObjCRuntime.nobjc_copyProtocolList(MemoryUtil.memAddress(v2));
            PointerBuffer v5 = MemoryUtil.memPointerBufferSafe(v3, v2.get(0));
            return v5;
        }
        finally {
            v0.setPointer(v1);
        }
    }

    @NativeType(value="BOOL")
    public static boolean protocol_conformsToProtocol(@NativeType(value="Protocol *") long param0, @NativeType(value="Protocol *") long param2) {
        long v4 = Functions.protocol_conformsToProtocol;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean protocol_isEqual(@NativeType(value="Protocol *") long param0, @NativeType(value="Protocol *") long param2) {
        long v4 = Functions.protocol_isEqual;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    public static long nprotocol_getName(long param0) {
        long v2 = Functions.protocol_getName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String protocol_getName(@NativeType(value="Protocol *") long param0) {
        long v2 = ObjCRuntime.nprotocol_getName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static native void nprotocol_getMethodDescription(long var0, long var2, boolean var4, boolean var5, long var6, long var8);

    public static void nprotocol_getMethodDescription(long param0, long param2, boolean param4, boolean param5, long param6) {
        long v8 = Functions.protocol_getMethodDescription;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        ObjCRuntime.nprotocol_getMethodDescription(param0, param2, param4, param5, v8, param6);
    }

    @NativeType(value="struct objc_method_description")
    public static ObjCMethodDescription protocol_getMethodDescription(@NativeType(value="Protocol *") long param0, @NativeType(value="SEL") long param2, @NativeType(value="BOOL") boolean param4, @NativeType(value="BOOL") boolean param5, @NativeType(value="struct objc_method_description") ObjCMethodDescription param6) {
        ObjCRuntime.nprotocol_getMethodDescription(param0, param2, param4, param5, param6.address());
        return param6;
    }

    public static long nprotocol_copyMethodDescriptionList(long param0, boolean param2, boolean param3, long param4) {
        long v6 = Functions.protocol_copyMethodDescriptionList;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, param3, param4, v6);
    }

    @Nullable
    @NativeType(value="struct objc_method_description *")
    public static ObjCMethodDescription.Buffer protocol_copyMethodDescriptionList(@NativeType(value="Protocol *") long param0, @NativeType(value="BOOL") boolean param2, @NativeType(value="BOOL") boolean param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        IntBuffer v6 = v4.callocInt(1);
        try {
            long v7 = ObjCRuntime.nprotocol_copyMethodDescriptionList(param0, param2, param3, MemoryUtil.memAddress(v6));
            ObjCMethodDescription.Buffer v9 = ObjCMethodDescription.createSafe(v7, v6.get(0));
            return v9;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static long nprotocol_getProperty(long param0, long param2, boolean param4, boolean param5) {
        long v6 = Functions.protocol_getProperty;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, param4, param5, v6);
    }

    @NativeType(value="objc_property_t")
    public static long protocol_getProperty(@NativeType(value="Protocol *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="BOOL") boolean param3, @NativeType(value="BOOL") boolean param4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        return ObjCRuntime.nprotocol_getProperty(param0, MemoryUtil.memAddress(param2), param3, param4);
    }

    @NativeType(value="objc_property_t")
    public static long protocol_getProperty(@NativeType(value="Protocol *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="BOOL") boolean param3, @NativeType(value="BOOL") boolean param4) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param2, true);
            long v7 = v5.getPointerAddress();
            long v9 = ObjCRuntime.nprotocol_getProperty(param0, v7, param3, param4);
            return v9;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static long nprotocol_copyPropertyList(long param0, long param2) {
        long v4 = Functions.protocol_copyPropertyList;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="objc_property_t *")
    public static PointerBuffer protocol_copyPropertyList(@NativeType(value="Protocol *") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nprotocol_copyPropertyList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static long nprotocol_copyProtocolList(long param0, long param2) {
        long v4 = Functions.protocol_copyProtocolList;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="Protocol **")
    public static PointerBuffer protocol_copyProtocolList(@NativeType(value="Protocol *") long param0) {
        MemoryStack v2 = MemoryStack.stackGet();
        int v3 = v2.getPointer();
        IntBuffer v4 = v2.callocInt(1);
        try {
            long v5 = ObjCRuntime.nprotocol_copyProtocolList(param0, MemoryUtil.memAddress(v4));
            PointerBuffer v7 = MemoryUtil.memPointerBufferSafe(v5, v4.get(0));
            return v7;
        }
        finally {
            v2.setPointer(v3);
        }
    }

    public static long nobjc_allocateProtocol(long param0) {
        long v2 = Functions.objc_allocateProtocol;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Protocol *")
    public static long objc_allocateProtocol(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nobjc_allocateProtocol(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="Protocol *")
    public static long objc_allocateProtocol(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nobjc_allocateProtocol(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static void objc_registerProtocol(@NativeType(value="Protocol *") long param0) {
        long v2 = Functions.objc_registerProtocol;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    public static void nprotocol_addMethodDescription(long param0, long param2, long param4, boolean param6, boolean param7) {
        long v8 = Functions.protocol_addMethodDescription;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        JNI.invokePPPV(param0, param2, param4, param6, param7, v8);
    }

    public static void protocol_addMethodDescription(@NativeType(value="Protocol *") long param0, @NativeType(value="SEL") long param2, @NativeType(value="char const *") ByteBuffer param4, @NativeType(value="BOOL") boolean param5, @NativeType(value="BOOL") boolean param6) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param4);
        }
        ObjCRuntime.nprotocol_addMethodDescription(param0, param2, MemoryUtil.memAddress(param4), param5, param6);
    }

    public static void protocol_addMethodDescription(@NativeType(value="Protocol *") long param0, @NativeType(value="SEL") long param2, @NativeType(value="char const *") CharSequence param4, @NativeType(value="BOOL") boolean param5, @NativeType(value="BOOL") boolean param6) {
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            v7.nUTF8(param4, true);
            long v9 = v7.getPointerAddress();
            ObjCRuntime.nprotocol_addMethodDescription(param0, param2, v9, param5, param6);
            return;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static void protocol_addProtocol(@NativeType(value="Protocol *") long param0, @NativeType(value="Protocol *") long param2) {
        long v4 = Functions.protocol_addProtocol;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        JNI.invokePPV(param0, param2, v4);
    }

    public static void nprotocol_addProperty(long param0, long param2, long param4, int param6, boolean param7, boolean param8) {
        long v9 = Functions.protocol_addProperty;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Struct.validate(param4, param6, ObjCPropertyAttribute.SIZEOF, ObjCPropertyAttribute::validate);
        }
        JNI.invokePPPV(param0, param2, param4, param6, param7, param8, v9);
    }

    public static void protocol_addProperty(@NativeType(value="Protocol *") long param0, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3, @NativeType(value="BOOL") boolean param4, @NativeType(value="BOOL") boolean param5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        ObjCRuntime.nprotocol_addProperty(param0, MemoryUtil.memAddress(param2), param3.address(), param3.remaining(), param4, param5);
    }

    public static void protocol_addProperty(@NativeType(value="Protocol *") long param0, @NativeType(value="char const *") CharSequence param2, @NativeType(value="objc_property_attribute_t const *") ObjCPropertyAttribute.Buffer param3, @NativeType(value="BOOL") boolean param4, @NativeType(value="BOOL") boolean param5) {
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nUTF8(param2, true);
            long v8 = v6.getPointerAddress();
            ObjCRuntime.nprotocol_addProperty(param0, v8, param3.address(), param3.remaining(), param4, param5);
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static long nobjc_copyImageNames(long param0) {
        long v2 = Functions.objc_copyImageNames;
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyImageNames() {
        MemoryStack v0 = MemoryStack.stackGet();
        int v1 = v0.getPointer();
        IntBuffer v2 = v0.callocInt(1);
        try {
            long v3 = ObjCRuntime.nobjc_copyImageNames(MemoryUtil.memAddress(v2));
            PointerBuffer v5 = MemoryUtil.memPointerBufferSafe(v3, v2.get(0));
            return v5;
        }
        finally {
            v0.setPointer(v1);
        }
    }

    public static long nclass_getImageName(long param0) {
        long v2 = Functions.class_getImageName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String class_getImageName(@NativeType(value="Class") long param0) {
        long v2 = ObjCRuntime.nclass_getImageName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nobjc_copyClassNamesForImage(long param0, long param2) {
        long v4 = Functions.objc_copyClassNamesForImage;
        return JNI.invokePPP(param0, param2, v4);
    }

    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyClassNamesForImage(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        IntBuffer v3 = v1.callocInt(1);
        try {
            long v4 = ObjCRuntime.nobjc_copyClassNamesForImage(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(v3));
            PointerBuffer v6 = MemoryUtil.memPointerBufferSafe(v4, v3.get(0));
            return v6;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer objc_copyClassNamesForImage(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            IntBuffer v3 = v1.callocInt(1);
            v1.nUTF8(param0, true);
            long v4 = v1.getPointerAddress();
            long v6 = ObjCRuntime.nobjc_copyClassNamesForImage(v4, MemoryUtil.memAddress(v3));
            PointerBuffer v8 = MemoryUtil.memPointerBufferSafe(v6, v3.get(0));
            return v8;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nsel_getName(long param0) {
        long v2 = Functions.sel_getName;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String sel_getName(@NativeType(value="SEL") long param0) {
        long v2 = ObjCRuntime.nsel_getName(param0);
        return MemoryUtil.memUTF8Safe(v2);
    }

    public static long nsel_getUid(long param0) {
        long v2 = Functions.sel_getUid;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="SEL")
    public static long sel_getUid(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nsel_getUid(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="SEL")
    public static long sel_getUid(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nsel_getUid(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static long nsel_registerName(long param0) {
        long v2 = Functions.sel_registerName;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="SEL")
    public static long sel_registerName(@NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param0);
        }
        return ObjCRuntime.nsel_registerName(MemoryUtil.memAddress(param0));
    }

    @NativeType(value="SEL")
    public static long sel_registerName(@NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nUTF8(param0, true);
            long v3 = v1.getPointerAddress();
            long v5 = ObjCRuntime.nsel_registerName(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    @NativeType(value="BOOL")
    public static boolean sel_isEqual(@NativeType(value="SEL") long param0, @NativeType(value="SEL") long param2) {
        long v4 = Functions.sel_isEqual;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPZ(param0, param2, v4);
    }

    public static void objc_enumerationMutation(@NativeType(value="id") long param0) {
        long v2 = Functions.objc_enumerationMutation;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    public static void nobjc_setEnumerationMutationHandler(long param0) {
        long v2 = Functions.objc_setEnumerationMutationHandler;
        JNI.invokePV(param0, v2);
    }

    public static void objc_setEnumerationMutationHandler(@NativeType(value="EnumerationMutationHandler") EnumerationMutationHandlerI param0) {
        ObjCRuntime.nobjc_setEnumerationMutationHandler(param0.address());
    }

    @NativeType(value="IMP")
    public static long imp_implementationWithBlock(@NativeType(value="id") long param0) {
        long v2 = Functions.imp_implementationWithBlock;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="id")
    public static long imp_getBlock(@NativeType(value="IMP") long param0) {
        long v2 = Functions.imp_getBlock;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean imp_removeBlock(@NativeType(value="IMP") long param0) {
        long v2 = Functions.imp_removeBlock;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePZ(param0, v2);
    }

    public static long nobjc_loadWeak(long param0) {
        long v2 = Functions.objc_loadWeak;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="id")
    public static long objc_loadWeak(@Nullable @NativeType(value="id *") PointerBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkSafe(param0, 1);
        }
        return ObjCRuntime.nobjc_loadWeak(MemoryUtil.memAddressSafe(param0));
    }

    public static long nobjc_storeWeak(long param0, long param2) {
        long v4 = Functions.objc_storeWeak;
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="id")
    public static long objc_storeWeak(@NativeType(value="id *") PointerBuffer param0, @NativeType(value="id") long param1) {
        if (Checks.CHECKS) {
            Checks.check(param0, 1);
        }
        return ObjCRuntime.nobjc_storeWeak(MemoryUtil.memAddress(param0), param1);
    }

    public static void objc_setAssociatedObject(@NativeType(value="id") long param0, @NativeType(value="void const *") long param2, @NativeType(value="id") long param4, @NativeType(value="objc_AssociationPolicy") long param6) {
        long v8 = Functions.objc_setAssociatedObject;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
            Checks.check(param4);
        }
        JNI.invokePPPPV(param0, param2, param4, param6, v8);
    }

    @NativeType(value="id")
    public static long objc_getAssociatedObject(@NativeType(value="id") long param0, @NativeType(value="void const *") long param2) {
        long v4 = Functions.objc_getAssociatedObject;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.invokePPP(param0, param2, v4);
    }

    public static void objc_removeAssociatedObjects(@NativeType(value="id") long param0) {
        long v2 = Functions.objc_removeAssociatedObjects;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return OBJC;
    }

    static {
        OBJC_ASSOCIATION_COPY = 1403;
        OBJC_ASSOCIATION_RETAIN = 1401;
        OBJC_ASSOCIATION_COPY_NONATOMIC = 3;
        OBJC_ASSOCIATION_RETAIN_NONATOMIC = 1;
        OBJC_ASSOCIATION_ASSIGN = 0;
        _C_CONST = (char)114;
        _C_VECTOR = (char)33;
        _C_STRUCT_E = (char)125;
        _C_STRUCT_B = (char)123;
        _C_UNION_E = (char)41;
        _C_UNION_B = (char)40;
        _C_ARY_E = (char)93;
        _C_ARY_B = (char)91;
        _C_ATOM = (char)37;
        _C_CHARPTR = (char)42;
        _C_PTR = (char)94;
        _C_UNDEF = (char)63;
        _C_VOID = (char)118;
        _C_BOOL = (char)66;
        _C_BFLD = (char)98;
        _C_DBL = (char)100;
        _C_FLT = (char)102;
        _C_ULNG_LNG = (char)81;
        _C_LNG_LNG = (char)113;
        _C_ULNG = (char)76;
        _C_LNG = (char)108;
        _C_UINT = (char)73;
        _C_INT = (char)105;
        _C_USHT = (char)83;
        _C_SHT = (char)115;
        _C_UCHR = (char)67;
        _C_CHR = (char)99;
        _C_SEL = (char)58;
        _C_CLASS = (char)35;
        _C_ID = (char)64;
        NO = 0;
        YES = 1;
        nil = 0L;
        OBJC = Library.loadNative(ObjCRuntime.class, "org.lwjgl", "objc");
    }

    public static final class Functions {
        public static final long object_copy = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_copy");
        public static final long object_dispose = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_dispose");
        public static final long object_getClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getClass");
        public static final long object_setClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setClass");
        public static final long object_getClassName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getClassName");
        public static final long object_getIndexedIvars = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getIndexedIvars");
        public static final long object_getIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getIvar");
        public static final long object_setIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setIvar");
        public static final long object_setInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_setInstanceVariable");
        public static final long object_getInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "object_getInstanceVariable");
        public static final long objc_getClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getClass");
        public static final long objc_getMetaClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getMetaClass");
        public static final long objc_lookUpClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_lookUpClass");
        public static final long objc_getRequiredClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getRequiredClass");
        public static final long objc_getClassList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getClassList");
        public static final long objc_copyClassList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyClassList");
        public static final long class_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getName");
        public static final long class_isMetaClass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_isMetaClass");
        public static final long class_getSuperclass = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getSuperclass");
        public static final long class_getVersion = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getVersion");
        public static final long class_setVersion = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setVersion");
        public static final long class_getInstanceSize = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceSize");
        public static final long class_getInstanceVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceVariable");
        public static final long class_getClassVariable = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getClassVariable");
        public static final long class_copyIvarList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyIvarList");
        public static final long class_getInstanceMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getInstanceMethod");
        public static final long class_getClassMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getClassMethod");
        public static final long class_getMethodImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getMethodImplementation");
        public static final long class_respondsToSelector = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_respondsToSelector");
        public static final long class_copyMethodList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyMethodList");
        public static final long class_conformsToProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_conformsToProtocol");
        public static final long class_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyProtocolList");
        public static final long class_getProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getProperty");
        public static final long class_copyPropertyList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_copyPropertyList");
        public static final long class_getIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getIvarLayout");
        public static final long class_getWeakIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getWeakIvarLayout");
        public static final long class_addMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addMethod");
        public static final long class_replaceMethod = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_replaceMethod");
        public static final long class_addIvar = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addIvar");
        public static final long class_addProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addProtocol");
        public static final long class_addProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_addProperty");
        public static final long class_replaceProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_replaceProperty");
        public static final long class_setIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setIvarLayout");
        public static final long class_setWeakIvarLayout = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_setWeakIvarLayout");
        public static final long class_createInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_createInstance");
        public static final long objc_constructInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_constructInstance");
        public static final long objc_destructInstance = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_destructInstance");
        public static final long objc_allocateClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_allocateClassPair");
        public static final long objc_registerClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_registerClassPair");
        public static final long objc_disposeClassPair = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_disposeClassPair");
        public static final long method_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getName");
        public static final long method_getImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getImplementation");
        public static final long method_getTypeEncoding = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getTypeEncoding");
        public static final long method_getNumberOfArguments = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getNumberOfArguments");
        public static final long method_copyReturnType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_copyReturnType");
        public static final long method_copyArgumentType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_copyArgumentType");
        public static final long method_getReturnType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getReturnType");
        public static final long method_getArgumentType = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_getArgumentType");
        public static final long method_setImplementation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_setImplementation");
        public static final long method_exchangeImplementations = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "method_exchangeImplementations");
        public static final long ivar_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getName");
        public static final long ivar_getTypeEncoding = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getTypeEncoding");
        public static final long ivar_getOffset = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "ivar_getOffset");
        public static final long property_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_getName");
        public static final long property_getAttributes = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_getAttributes");
        public static final long property_copyAttributeList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_copyAttributeList");
        public static final long property_copyAttributeValue = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "property_copyAttributeValue");
        public static final long objc_getProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getProtocol");
        public static final long objc_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyProtocolList");
        public static final long protocol_conformsToProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_conformsToProtocol");
        public static final long protocol_isEqual = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_isEqual");
        public static final long protocol_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getName");
        public static final long protocol_getMethodDescription = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getMethodDescription");
        public static final long protocol_copyMethodDescriptionList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyMethodDescriptionList");
        public static final long protocol_getProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_getProperty");
        public static final long protocol_copyPropertyList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyPropertyList");
        public static final long protocol_copyProtocolList = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_copyProtocolList");
        public static final long objc_allocateProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_allocateProtocol");
        public static final long objc_registerProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_registerProtocol");
        public static final long protocol_addMethodDescription = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addMethodDescription");
        public static final long protocol_addProtocol = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addProtocol");
        public static final long protocol_addProperty = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "protocol_addProperty");
        public static final long objc_copyImageNames = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyImageNames");
        public static final long class_getImageName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "class_getImageName");
        public static final long objc_copyClassNamesForImage = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_copyClassNamesForImage");
        public static final long sel_getName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_getName");
        public static final long sel_getUid = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_getUid");
        public static final long sel_registerName = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_registerName");
        public static final long sel_isEqual = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "sel_isEqual");
        public static final long objc_enumerationMutation = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_enumerationMutation");
        public static final long objc_setEnumerationMutationHandler = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_setEnumerationMutationHandler");
        public static final long imp_implementationWithBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_implementationWithBlock");
        public static final long imp_getBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_getBlock");
        public static final long imp_removeBlock = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "imp_removeBlock");
        public static final long objc_loadWeak = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_loadWeak");
        public static final long objc_storeWeak = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_storeWeak");
        public static final long objc_setAssociatedObject = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_setAssociatedObject");
        public static final long objc_getAssociatedObject = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_getAssociatedObject");
        public static final long objc_removeAssociatedObjects = APIUtil.apiGetFunctionAddress(ObjCRuntime.access$000(), "objc_removeAssociatedObjects");

        private Functions() {
        }
    }
}

