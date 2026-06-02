/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.FFIClosure;
import org.lwjgl.system.libffi.LibFFI;

public abstract class Callback
implements Pointer,
NativeResource {
    private static final boolean DEBUG_ALLOCATOR = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false);
    private static final ClosureRegistry CLOSURE_REGISTRY;
    private static final long CALLBACK_HANDLER;
    private long address;

    protected Callback(FFICIF param1) {
        this.address = Callback.create(param1, this);
    }

    protected Callback(long param1) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        this.address = param1;
    }

    @Override
    public long address() {
        return this.address;
    }

    @Override
    public void free() {
        Callback.free(this.address());
    }

    private static native long getCallbackHandler(Method var0);

    static long create(FFICIF param0, Object param1) {
        long v6;
        FFIClosure v5;
        MemoryStack v2 = MemoryStack.stackPush();
        Throwable v3 = null;
        try {
            PointerBuffer v4 = v2.mallocPointer(1);
            v5 = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, v4);
            if (v5 == null) {
                throw new OutOfMemoryError();
            }
            v6 = v4.get(0);
            if (DEBUG_ALLOCATOR) {
                MemoryManage.DebugAllocator.track(v6, FFIClosure.SIZEOF);
            }
            if (v2 != null) {
                v2.close();
            }
        }
        catch (Throwable v4) {
            try {
                v3 = v4;
                throw v4;
            }
            catch (Throwable v8) {
                if (v2 != null) {
                    if (v3 != null) {
                        try {
                            v2.close();
                        }
                        catch (Throwable v9) {
                            v3.addSuppressed(v9);
                        }
                    } else {
                        v2.close();
                    }
                }
                throw v8;
            }
        }
        long v10 = JNINativeInterface.NewGlobalRef(param1);
        int v4 = LibFFI.ffi_prep_closure_loc(v5, param0, CALLBACK_HANDLER, v10, v6);
        if (v4 != 0) {
            JNINativeInterface.DeleteGlobalRef(v10);
            LibFFI.ffi_closure_free(v5);
            throw new RuntimeException("Failed to prepare the libffi closure");
        }
        CLOSURE_REGISTRY.put(v6, v5);
        return v6;
    }

    public static <T extends CallbackI> T get(long param0) {
        return (T)((CallbackI)MemoryUtil.memGlobalRefToObject(CLOSURE_REGISTRY.get(param0).user_data()));
    }

    @Nullable
    public static <T extends CallbackI> T getSafe(long param0) {
        return param0 == 0L ? null : (T)Callback.get(param0);
    }

    public static void free(long param0) {
        if (DEBUG_ALLOCATOR) {
            MemoryManage.DebugAllocator.untrack(param0);
        }
        FFIClosure v2 = CLOSURE_REGISTRY.get(param0);
        JNINativeInterface.DeleteGlobalRef(v2.user_data());
        LibFFI.ffi_closure_free(v2);
    }

    public boolean equals(Object param1) {
        if (this == param1) {
            return true;
        }
        if (!(param1 instanceof Callback)) {
            return false;
        }
        Callback v2 = (Callback)param1;
        return this.address == v2.address();
    }

    public int hashCode() {
        return (int)(this.address ^ this.address >>> 32);
    }

    public String toString() {
        return String.format("%s pointer [0x%X]", this.getClass().getSimpleName(), this.address);
    }

    static {
        MemoryStack v62 = MemoryStack.stackPush();
        Throwable v1 = null;
        try {
            PointerBuffer v2 = v62.mallocPointer(1);
            FFIClosure v3 = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, v2);
            if (v3 == null) {
                throw new OutOfMemoryError();
            }
            if (v2.get(0) == v3.address()) {
                APIUtil.apiLog("Closure Registry: simple");
                CLOSURE_REGISTRY = new ClosureRegistry(){

                    @Override
                    public void put(long param1, FFIClosure param3) {
                    }

                    @Override
                    public FFIClosure get(long param1) {
                        return FFIClosure.create(param1);
                    }

                    @Override
                    public FFIClosure remove(long param1) {
                        return this.get(param1);
                    }
                };
            } else {
                APIUtil.apiLog("Closure Registry: ConcurrentHashMap");
                CLOSURE_REGISTRY = new ClosureRegistry(){
                    private final ConcurrentHashMap<Long, FFIClosure> map = new ConcurrentHashMap();

                    @Override
                    public void put(long param1, FFIClosure param3) {
                        this.map.put(param1, param3);
                    }

                    @Override
                    public FFIClosure get(long param1) {
                        return this.map.get(param1);
                    }

                    @Override
                    public FFIClosure remove(long param1) {
                        return this.map.remove(param1);
                    }
                };
            }
            LibFFI.ffi_closure_free(v3);
            if (v62 != null) {
                v62.close();
            }
        }
        catch (Throwable v2) {
            try {
                v1 = v2;
                throw v2;
            }
            catch (Throwable v4) {
                if (v62 != null) {
                    if (v1 != null) {
                        try {
                            v62.close();
                        }
                        catch (Throwable v5) {
                            v1.addSuppressed(v5);
                        }
                    } else {
                        v62.close();
                    }
                }
                throw v4;
            }
        }
        try {
            CALLBACK_HANDLER = Callback.getCallbackHandler(CallbackI.class.getDeclaredMethod("callback", Long.TYPE, Long.TYPE));
            return;
        }
        catch (Exception v62) {
            throw new IllegalStateException("Failed to initialize the native callback handler.", v62);
        }
    }

    private static interface ClosureRegistry {
        public void put(long var1, FFIClosure var3);

        public FFIClosure get(long var1);

        public FFIClosure remove(long var1);
    }
}

