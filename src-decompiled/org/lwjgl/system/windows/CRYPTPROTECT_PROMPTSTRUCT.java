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

public class CRYPTPROTECT_PROMPTSTRUCT
extends Struct<CRYPTPROTECT_PROMPTSTRUCT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int DWPROMPTFLAGS;
    public static final int HWNDAPP;
    public static final int SZPROMPT;

    protected CRYPTPROTECT_PROMPTSTRUCT(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected CRYPTPROTECT_PROMPTSTRUCT create(long param1, @Nullable ByteBuffer param3) {
        return new CRYPTPROTECT_PROMPTSTRUCT(param1, param3);
    }

    public CRYPTPROTECT_PROMPTSTRUCT(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), CRYPTPROTECT_PROMPTSTRUCT.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbSize() {
        return CRYPTPROTECT_PROMPTSTRUCT.ncbSize(this.address());
    }

    @NativeType(value="DWORD")
    public int dwPromptFlags() {
        return CRYPTPROTECT_PROMPTSTRUCT.ndwPromptFlags(this.address());
    }

    @NativeType(value="HWND")
    public long hwndApp() {
        return CRYPTPROTECT_PROMPTSTRUCT.nhwndApp(this.address());
    }

    @NativeType(value="LPCWSTR")
    public ByteBuffer szPrompt() {
        return CRYPTPROTECT_PROMPTSTRUCT.nszPrompt(this.address());
    }

    @NativeType(value="LPCWSTR")
    public String szPromptString() {
        return CRYPTPROTECT_PROMPTSTRUCT.nszPromptString(this.address());
    }

    public CRYPTPROTECT_PROMPTSTRUCT cbSize(@NativeType(value="DWORD") int param1) {
        CRYPTPROTECT_PROMPTSTRUCT.ncbSize(this.address(), param1);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT cbSize$Default() {
        return this.cbSize(SIZEOF);
    }

    public CRYPTPROTECT_PROMPTSTRUCT dwPromptFlags(@NativeType(value="DWORD") int param1) {
        CRYPTPROTECT_PROMPTSTRUCT.ndwPromptFlags(this.address(), param1);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT hwndApp(@NativeType(value="HWND") long param1) {
        CRYPTPROTECT_PROMPTSTRUCT.nhwndApp(this.address(), param1);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT szPrompt(@NativeType(value="LPCWSTR") ByteBuffer param1) {
        CRYPTPROTECT_PROMPTSTRUCT.nszPrompt(this.address(), param1);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT set(int param1, int param2, long param3, ByteBuffer param5) {
        this.cbSize(param1);
        this.dwPromptFlags(param2);
        this.hwndApp(param3);
        this.szPrompt(param5);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT set(CRYPTPROTECT_PROMPTSTRUCT param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static CRYPTPROTECT_PROMPTSTRUCT malloc() {
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT calloc() {
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.memAddress(v0), v0);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT create(long param0) {
        return new CRYPTPROTECT_PROMPTSTRUCT(param0, null);
    }

    @Nullable
    public static CRYPTPROTECT_PROMPTSTRUCT createSafe(long param0) {
        return param0 == 0L ? null : new CRYPTPROTECT_PROMPTSTRUCT(param0, null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT malloc(MemoryStack param0) {
        return new CRYPTPROTECT_PROMPTSTRUCT(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT calloc(MemoryStack param0) {
        return new CRYPTPROTECT_PROMPTSTRUCT(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static int ncbSize(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CBSIZE);
    }

    public static int ndwPromptFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWPROMPTFLAGS);
    }

    public static long nhwndApp(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)HWNDAPP);
    }

    public static ByteBuffer nszPrompt(long param0) {
        return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(param0 + (long)SZPROMPT));
    }

    public static String nszPromptString(long param0) {
        return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(param0 + (long)SZPROMPT));
    }

    public static void ncbSize(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CBSIZE, param2);
    }

    public static void ndwPromptFlags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWPROMPTFLAGS, param2);
    }

    public static void nhwndApp(long param0, long param2) {
        MemoryUtil.memPutAddress(param0 + (long)HWNDAPP, Checks.check(param2));
    }

    public static void nszPrompt(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)SZPROMPT, MemoryUtil.memAddress(param2));
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)HWNDAPP));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)SZPROMPT));
    }

    static {
        Struct.Layout v0 = CRYPTPROTECT_PROMPTSTRUCT.__struct(CRYPTPROTECT_PROMPTSTRUCT.__member(4), CRYPTPROTECT_PROMPTSTRUCT.__member(4), CRYPTPROTECT_PROMPTSTRUCT.__member(POINTER_SIZE), CRYPTPROTECT_PROMPTSTRUCT.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CBSIZE = v0.offsetof(0);
        DWPROMPTFLAGS = v0.offsetof(1);
        HWNDAPP = v0.offsetof(2);
        SZPROMPT = v0.offsetof(3);
    }
}

