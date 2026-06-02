/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="UIhandler")
public interface UIHandlerI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_sint32, LibFFI.ffi_type_uint32);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long param1, long param3) {
        this.invoke(MemoryUtil.memGetInt(MemoryUtil.memGetAddress(param3)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(param3 + (long)POINTER_SIZE)));
    }

    public void invoke(int var1, @NativeType(value="UIevent") int var2);
}

