/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.StackWalkUtil;
import org.lwjgl.system.libc.LibCStdlib;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

final class MemoryManage {
    private MemoryManage() {
    }

    static MemoryUtil.MemoryAllocator getInstance() {
        Object v0 = Configuration.MEMORY_ALLOCATOR.get();
        if (v0 instanceof MemoryUtil.MemoryAllocator) {
            return (MemoryUtil.MemoryAllocator)v0;
        }
        if (!"system".equals(v0)) {
            String v1 = v0 == null || "jemalloc".equals(v0) ? "org.lwjgl.system.jemalloc.JEmallocAllocator" : ("rpmalloc".equals(v0) ? "org.lwjgl.system.rpmalloc.RPmallocAllocator" : v0.toString());
            try {
                Class<?> v2 = Class.forName(v1);
                return (MemoryUtil.MemoryAllocator)v2.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (Throwable v2) {
                if (Checks.DEBUG && v0 != null) {
                    v2.printStackTrace(APIUtil.DEBUG_STREAM);
                }
                APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", v1));
            }
        }
        return new StdlibAllocator();
    }

    static class DebugAllocator
    implements MemoryUtil.MemoryAllocator {
        private static final ConcurrentMap<Allocation, Allocation> ALLOCATIONS = new ConcurrentHashMap<Allocation, Allocation>();
        private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<Long, String>();
        private final MemoryUtil.MemoryAllocator allocator;
        private final long[] callbacks;

        DebugAllocator(MemoryUtil.MemoryAllocator param1) {
            this.allocator = param1;
            this.callbacks = new long[]{new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    MemoryUtil.memPutAddress(param1, this.malloc(v5));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    long v7 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(param1, this.calloc(v5, v7));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    long v7 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(param1, this.realloc(v5, v7));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    this.free(v5);
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    long v7 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(param1, this.aligned_alloc(v5, v7));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long param1, long param3) {
                    long v5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(param3));
                    this.aligned_free(v5);
                }
            }.address()};
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                for (long v4 : this.callbacks) {
                    Callback.free(v4);
                }
                if (ALLOCATIONS.isEmpty()) {
                    return;
                }
                boolean v1 = false;
                for (Allocation v3 : ALLOCATIONS.keySet()) {
                    StringBuilder v6 = new StringBuilder(512);
                    v6.append("[LWJGL] ").append(v3.size).append(" bytes leaked, thread ").append(v3.threadId).append(" (").append((String)THREADS.get(v3.threadId)).append("), address: 0x").append(Long.toHexString(v3.address).toUpperCase()).append("\n");
                    StackTraceElement[] v7 = v3.getElements();
                    if (v7 != null) {
                        for (StackTraceElement v11 : v7) {
                            v6.append("\tat ").append(((Object)v11).toString()).append("\n");
                        }
                    } else {
                        v1 = true;
                    }
                    APIUtil.DEBUG_STREAM.print(v6);
                }
                if (v1) {
                    APIUtil.DEBUG_STREAM.print("[LWJGL] Reminder: disable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST to get stacktraces of leaking allocations.\n");
                }
            }));
        }

        @Override
        public long getMalloc() {
            return this.callbacks[0];
        }

        @Override
        public long getCalloc() {
            return this.callbacks[1];
        }

        @Override
        public long getRealloc() {
            return this.callbacks[2];
        }

        @Override
        public long getFree() {
            return this.callbacks[3];
        }

        @Override
        public long getAlignedAlloc() {
            return this.callbacks[4];
        }

        @Override
        public long getAlignedFree() {
            return this.callbacks[5];
        }

        @Override
        public long malloc(long param1) {
            return DebugAllocator.track(this.allocator.malloc(param1), param1);
        }

        @Override
        public long calloc(long param1, long param3) {
            return DebugAllocator.track(this.allocator.calloc(param1, param3), param1 * param3);
        }

        @Override
        public long realloc(long param1, long param3) {
            long v5 = DebugAllocator.untrack(param1);
            long v7 = this.allocator.realloc(param1, param3);
            if (v7 != 0L) {
                DebugAllocator.track(v7, param3);
            } else if (param3 != 0L) {
                DebugAllocator.track(param1, v5);
            }
            return v7;
        }

        @Override
        public void free(long param1) {
            DebugAllocator.untrack(param1);
            this.allocator.free(param1);
        }

        @Override
        public long aligned_alloc(long param1, long param3) {
            return DebugAllocator.track(this.allocator.aligned_alloc(param1, param3), param3);
        }

        @Override
        public void aligned_free(long param1) {
            DebugAllocator.untrack(param1);
            this.allocator.aligned_free(param1);
        }

        static long track(long param0, long param2) {
            if (param0 != 0L) {
                Thread v4 = Thread.currentThread();
                THREADS.putIfAbsent(v4.getId(), v4.getName());
                Allocation v5 = new Allocation(param0, param2, v4.getId(), Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(false) != false ? null : StackWalkUtil.stackWalkGetTrace());
                Allocation v6 = ALLOCATIONS.put(v5, v5);
                if (v6 != null) {
                    DebugAllocator.trackAbort(param0, v6, v5);
                }
            }
            return param0;
        }

        private static void trackAbort(long param0, Allocation param2, Allocation param3) {
            String v4 = Long.toHexString(param0).toUpperCase();
            DebugAllocator.trackAbortPrint(param2, "Old", v4);
            DebugAllocator.trackAbortPrint(param3, "New", v4);
            throw new IllegalStateException("The memory address specified is already being tracked: 0x" + v4);
        }

        private static void trackAbortPrint(Allocation param0, String param1, String param2) {
            StringBuilder v3 = new StringBuilder(512);
            v3.append("[LWJGL] ").append(param1).append(" allocation with size ").append(param0.size).append(", thread ").append(param0.threadId).append(" (").append((String)THREADS.get(param0.threadId)).append("), address: 0x").append(param2).append("\n");
            StackTraceElement[] v4 = param0.getElements();
            if (v4 != null) {
                for (StackTraceElement v8 : v4) {
                    v3.append("\tat ").append(((Object)v8).toString()).append("\n");
                }
            }
            APIUtil.DEBUG_STREAM.print(v3);
        }

        static long untrack(long param0) {
            if (param0 == 0L) {
                return 0L;
            }
            Allocation v2 = (Allocation)ALLOCATIONS.remove(new Allocation(param0, 0L, 0L, null));
            if (v2 == null) {
                DebugAllocator.untrackAbort(param0);
            }
            return v2.size;
        }

        private static void untrackAbort(long param0) {
            String v2 = Long.toHexString(param0).toUpperCase();
            throw new IllegalStateException("The memory address specified is not being tracked: 0x" + v2);
        }

        static void report(MemoryUtil.MemoryAllocationReport param0) {
            for (Allocation v2 : ALLOCATIONS.keySet()) {
                param0.invoke(v2.address, v2.size, v2.threadId, (String)THREADS.get(v2.threadId), v2.getElements());
            }
        }

        private static <T> void aggregate(T param02, long param1, Map<T, AtomicLong> param3) {
            AtomicLong v4 = param3.computeIfAbsent(param02, param0 -> new AtomicLong());
            v4.set(v4.get() + param1);
        }

        static void report(MemoryUtil.MemoryAllocationReport param0, MemoryUtil.MemoryAllocationReport.Aggregate param1, boolean param2) {
            switch (param1) {
                case ALL: {
                    DebugAllocator.reportAll(param0, param2);
                    break;
                }
                case GROUP_BY_METHOD: {
                    DebugAllocator.reportByMethod(param0, param2);
                    break;
                }
                case GROUP_BY_STACKTRACE: {
                    DebugAllocator.reportByStacktrace(param0, param2);
                }
            }
        }

        private static void reportAll(MemoryUtil.MemoryAllocationReport param0, boolean param1) {
            if (param1) {
                HashMap v2 = new HashMap();
                for (Allocation allocation : ALLOCATIONS.values()) {
                    DebugAllocator.aggregate(allocation.threadId, allocation.size, v2);
                }
                for (Map.Entry entry : v2.entrySet()) {
                    param0.invoke(0L, ((AtomicLong)entry.getValue()).get(), (Long)entry.getKey(), (String)THREADS.get(entry.getKey()), null);
                }
            } else {
                long v5 = 0L;
                for (Allocation v7 : ALLOCATIONS.values()) {
                    v5 += v7.size;
                }
                param0.invoke(0L, v5, 0L, null, null);
            }
        }

        private static void reportByMethod(MemoryUtil.MemoryAllocationReport param02, boolean param1) {
            if (param1) {
                HashMap<Long, Map> v2 = new HashMap<Long, Map>();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] v5 = allocation.getElements();
                    if (v5 == null) continue;
                    Map v6 = v2.computeIfAbsent(allocation.threadId, param0 -> new HashMap());
                    DebugAllocator.aggregate(v5[0], allocation.size, v6);
                }
                for (Map.Entry entry : v2.entrySet()) {
                    long v7 = (Long)entry.getKey();
                    String v9 = (String)THREADS.get(v7);
                    for (Map.Entry v11 : ((Map)entry.getValue()).entrySet()) {
                        param02.invoke(0L, ((AtomicLong)v11.getValue()).get(), v7, v9, (StackTraceElement)v11.getKey());
                    }
                }
            } else {
                HashMap v2 = new HashMap();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] v5 = allocation.getElements();
                    if (v5 == null) continue;
                    DebugAllocator.aggregate(v5[0], allocation.size, v2);
                }
                for (Map.Entry entry : v2.entrySet()) {
                    param02.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, (StackTraceElement)entry.getKey());
                }
            }
        }

        private static void reportByStacktrace(MemoryUtil.MemoryAllocationReport param02, boolean param1) {
            if (param1) {
                HashMap<Long, Map> v2 = new HashMap<Long, Map>();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] v5 = allocation.getElements();
                    if (v5 == null) continue;
                    Map v6 = v2.computeIfAbsent(allocation.threadId, param0 -> new HashMap());
                    DebugAllocator.aggregate(new AllocationKey(v5), allocation.size, v6);
                }
                for (Map.Entry entry : v2.entrySet()) {
                    long v7 = (Long)entry.getKey();
                    for (Map.Entry v10 : ((Map)entry.getValue()).entrySet()) {
                        param02.invoke(0L, ((AtomicLong)v10.getValue()).get(), v7, (String)THREADS.get(v7), ((AllocationKey)v10.getKey()).elements);
                    }
                }
            } else {
                HashMap v2 = new HashMap();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] v5 = allocation.getElements();
                    if (v5 == null) continue;
                    DebugAllocator.aggregate(new AllocationKey(v5), allocation.size, v2);
                }
                for (Map.Entry entry : v2.entrySet()) {
                    param02.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, ((AllocationKey)entry.getKey()).elements);
                }
            }
        }

        private static class AllocationKey {
            final StackTraceElement[] elements;

            AllocationKey(StackTraceElement[] param1) {
                this.elements = param1;
            }

            public boolean equals(Object param1) {
                return this == param1 || Arrays.equals(this.elements, ((AllocationKey)param1).elements);
            }

            public int hashCode() {
                return Arrays.hashCode(this.elements);
            }
        }

        private static class Allocation {
            final long address;
            final long size;
            final long threadId;
            @Nullable
            private final Object[] stacktrace;

            Allocation(long param1, long param3, long param5, @Nullable Object[] param7) {
                this.address = param1;
                this.size = param3;
                this.threadId = param5;
                this.stacktrace = param7;
            }

            @Nullable
            private StackTraceElement[] getElements() {
                return this.stacktrace == null ? null : StackWalkUtil.stackWalkArray(this.stacktrace);
            }

            public boolean equals(Object param1) {
                return this.address == ((Allocation)param1).address;
            }

            public int hashCode() {
                return Long.hashCode(this.address);
            }
        }
    }

    private static class StdlibAllocator
    implements MemoryUtil.MemoryAllocator {
        private StdlibAllocator() {
        }

        @Override
        public long getMalloc() {
            return MemoryAccessJNI.malloc;
        }

        @Override
        public long getCalloc() {
            return MemoryAccessJNI.calloc;
        }

        @Override
        public long getRealloc() {
            return MemoryAccessJNI.realloc;
        }

        @Override
        public long getFree() {
            return MemoryAccessJNI.free;
        }

        @Override
        public long getAlignedAlloc() {
            return MemoryAccessJNI.aligned_alloc;
        }

        @Override
        public long getAlignedFree() {
            return MemoryAccessJNI.aligned_free;
        }

        @Override
        public long malloc(long param1) {
            return LibCStdlib.nmalloc(param1);
        }

        @Override
        public long calloc(long param1, long param3) {
            return LibCStdlib.ncalloc(param1, param3);
        }

        @Override
        public long realloc(long param1, long param3) {
            return LibCStdlib.nrealloc(param1, param3);
        }

        @Override
        public void free(long param1) {
            LibCStdlib.nfree(param1);
        }

        @Override
        public long aligned_alloc(long param1, long param3) {
            return LibCStdlib.naligned_alloc(param1, param3);
        }

        @Override
        public void aligned_free(long param1) {
            LibCStdlib.naligned_free(param1);
        }
    }
}

