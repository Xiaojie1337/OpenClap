/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.FFIType;
import org.lwjgl.system.libffi.LibFFI;
import org.lwjgl.system.linux.LinuxLibrary;
import org.lwjgl.system.macosx.MacOSXLibrary;
import org.lwjgl.system.windows.WindowsLibrary;

public final class APIUtil {
    public static final PrintStream DEBUG_STREAM = APIUtil.getDebugStream();
    private static final Pattern API_VERSION_PATTERN = Pattern.compile("^" + "[^\\d\\n\\r]*" + "(\\d+)[.](\\d+)(?:[.](\\S+))?" + "(?:\\s+(.+?))?\\s*" + "$", 32);

    private static PrintStream getDebugStream() {
        PrintStream v0 = System.err;
        Object v1 = Configuration.DEBUG_STREAM.get();
        if (v1 instanceof String) {
            try {
                Supplier v2 = (Supplier)Class.forName((String)v1).getConstructor(new Class[0]).newInstance(new Object[0]);
                v0 = (PrintStream)v2.get();
            }
            catch (Exception v2) {
                v2.printStackTrace();
            }
        } else if (v1 instanceof Supplier) {
            v0 = (PrintStream)((Supplier)v1).get();
        } else if (v1 instanceof PrintStream) {
            v0 = (PrintStream)v1;
        }
        return v0;
    }

    private APIUtil() {
    }

    public static void apiLog(CharSequence param0) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("[LWJGL] " + param0 + "\n");
        }
    }

    public static void apiLogMore(CharSequence param0) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("\t" + param0 + "\n");
        }
    }

    public static void apiLogMissing(String param0, ByteBuffer param1) {
        if (Checks.DEBUG) {
            String v2 = MemoryUtil.memASCII(param1, param1.remaining() - 1);
            DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + param0 + " function " + v2 + "\n");
        }
    }

    public static String apiFindLibrary(String param0, String param12) {
        String v52;
        block12: {
            String v2 = Platform.get().mapLibraryName(param12);
            Stream<Path> v3 = Files.find(Paths.get(param0, new String[0]).toAbsolutePath(), Integer.MAX_VALUE, (param1, param2) -> param2.isRegularFile() && param1.getFileName().toString().equals(v2), new FileVisitOption[0]);
            Throwable v4 = null;
            try {
                v52 = v3.findFirst().map(Path::toString).orElse(param12);
                if (v3 == null) break block12;
            }
            catch (Throwable v52) {
                try {
                    try {
                        v4 = v52;
                        throw v52;
                    }
                    catch (Throwable v7) {
                        if (v3 != null) {
                            if (v4 != null) {
                                try {
                                    v3.close();
                                }
                                catch (Throwable v8) {
                                    v4.addSuppressed(v8);
                                }
                            } else {
                                v3.close();
                            }
                        }
                        throw v7;
                    }
                }
                catch (IOException iOException) {
                    return param12;
                }
            }
            v3.close();
        }
        return v52;
    }

    public static SharedLibrary apiCreateLibrary(String param0) {
        switch (Platform.get()) {
            case WINDOWS: {
                return new WindowsLibrary(param0);
            }
            case LINUX: {
                return new LinuxLibrary(param0);
            }
            case MACOSX: {
                return MacOSXLibrary.create(param0);
            }
        }
        throw new IllegalStateException();
    }

    public static long apiGetFunctionAddress(FunctionProvider param0, String param1) {
        long v2 = param0.getFunctionAddress(param1);
        if (v2 == 0L) {
            APIUtil.requiredFunctionMissing(param1);
        }
        return v2;
    }

    private static void requiredFunctionMissing(String param0) {
        if (!Configuration.DISABLE_FUNCTION_CHECKS.get(false).booleanValue()) {
            throw new NullPointerException("A required function is missing: " + param0);
        }
    }

    public static long apiGetFunctionAddressOptional(SharedLibrary param0, String param1) {
        long v2 = param0.getFunctionAddress(param1);
        if (Checks.DEBUG_FUNCTIONS && v2 == 0L) {
            APIUtil.optionalFunctionMissing(param0, param1);
        }
        return v2;
    }

    private static void optionalFunctionMissing(SharedLibrary param0, String param1) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + param0.getName() + " function " + param1 + "\n");
        }
    }

    @Nullable
    public static ByteBuffer apiGetMappedBuffer(@Nullable ByteBuffer param0, long param1, int param3) {
        if (param0 != null && MemoryUtil.memAddress(param0) == param1 && param0.capacity() == param3) {
            return param0;
        }
        return param1 == 0L ? null : MemoryUtil.wrap(MemoryUtil.BUFFER_BYTE, param1, param3).order(MemoryUtil.NATIVE_ORDER);
    }

    public static long apiGetBytes(int param0, int param1) {
        return ((long)param0 & 0xFFFFFFFFL) << param1;
    }

    public static long apiCheckAllocation(int param0, long param1, long param3) {
        if (Checks.DEBUG) {
            if (param0 < 0) {
                throw new IllegalArgumentException("Invalid number of elements");
            }
            if (param3 + Long.MIN_VALUE < param1 + Long.MIN_VALUE) {
                throw new IllegalArgumentException("The request allocation is too large");
            }
        }
        return param1;
    }

    @Nullable
    public static APIVersion apiParseVersion(Configuration<?> param0) {
        Object v1 = param0.get();
        APIVersion v2 = v1 instanceof String ? APIUtil.apiParseVersion((String)v1) : (v1 instanceof APIVersion ? (APIVersion)v1 : null);
        return v2;
    }

    public static APIVersion apiParseVersion(String param0) {
        Matcher v1 = API_VERSION_PATTERN.matcher(param0);
        if (!v1.matches()) {
            throw new IllegalArgumentException(String.format("Malformed API version string [%s]", param0));
        }
        return new APIVersion(Integer.parseInt(v1.group(1)), Integer.parseInt(v1.group(2)), v1.group(3), v1.group(4));
    }

    public static void apiFilterExtensions(Set<String> param0, Configuration<Object> param1) {
        Object v2 = param1.get();
        if (v2 == null) {
            return;
        }
        if (v2 instanceof String) {
            String v3 = (String)v2;
            if (v3.indexOf(46) != -1) {
                try {
                    Predicate v4 = (Predicate)Class.forName(v3).newInstance();
                    param0.removeIf(v4);
                }
                catch (Exception v4) {
                    throw new RuntimeException(v4);
                }
            } else {
                for (String v7 : v3.split(",")) {
                    param0.remove(v7);
                }
            }
        } else if (v2 instanceof List) {
            List v3 = (List)v2;
            param0.removeAll(v3);
        } else if (v2 instanceof Predicate) {
            Predicate v3 = (Predicate)v2;
            param0.removeIf(v3);
        } else {
            throw new IllegalStateException("Unsupported " + param1.getProperty() + " value specified.");
        }
    }

    public static String apiUnknownToken(int param0) {
        return APIUtil.apiUnknownToken("Unknown", param0);
    }

    public static String apiUnknownToken(String param0, int param1) {
        return String.format("%s [0x%X]", param0, param1);
    }

    public static Map<Integer, String> apiClassTokens(@Nullable BiPredicate<Field, Integer> param0, @Nullable Map<Integer, String> param1, Class<?> ... param2) {
        if (param1 == null) {
            param1 = new HashMap<Integer, String>(64);
        }
        for (Class<?> v7 : param2) {
            if (v7 == null) continue;
            for (Field v11 : v7.getDeclaredFields()) {
                if ((v11.getModifiers() & 0x19) != 25 || v11.getType() != Integer.TYPE) continue;
                try {
                    Integer v12 = v11.getInt(null);
                    if (param0 != null && !param0.test(v11, v12)) continue;
                    String v13 = param1.get(v12);
                    param1.put(v12, v13 == null ? v11.getName() : v13 + "|" + v11.getName());
                }
                catch (IllegalAccessException illegalAccessException) {}
            }
        }
        return param1;
    }

    public static long apiArray(MemoryStack param0, long ... param1) {
        PointerBuffer v2 = MemoryUtil.memPointerBuffer(param0.nmalloc(MemoryStack.POINTER_SIZE, param1.length << MemoryStack.POINTER_SHIFT), param1.length);
        for (long v6 : param1) {
            v2.put(v6);
        }
        return v2.address;
    }

    public static long apiArray(MemoryStack param0, ByteBuffer ... param1) {
        PointerBuffer v2 = MemoryUtil.memPointerBuffer(param0.nmalloc(MemoryStack.POINTER_SIZE, param1.length << MemoryStack.POINTER_SHIFT), param1.length);
        for (ByteBuffer v6 : param1) {
            v2.put(v6);
        }
        return v2.address;
    }

    public static long apiArrayp(MemoryStack param0, ByteBuffer ... param1) {
        long v2 = APIUtil.apiArray(param0, param1);
        PointerBuffer v4 = param0.mallocPointer(param1.length);
        for (ByteBuffer v8 : param1) {
            v4.put(v8.remaining());
        }
        return v2;
    }

    public static long apiArray(MemoryStack param0, Encoder param1, CharSequence ... param2) {
        PointerBuffer v3 = param0.mallocPointer(param2.length);
        for (CharSequence v7 : param2) {
            v3.put(param1.encode(v7, true));
        }
        return v3.address;
    }

    public static long apiArrayi(MemoryStack param0, Encoder param1, CharSequence ... param2) {
        PointerBuffer v3 = param0.mallocPointer(param2.length);
        IntBuffer v4 = param0.mallocInt(param2.length);
        for (CharSequence v8 : param2) {
            ByteBuffer v9 = param1.encode(v8, false);
            v3.put(v9);
            v4.put(v9.capacity());
        }
        return v3.address;
    }

    public static long apiArrayp(MemoryStack param0, Encoder param1, CharSequence ... param2) {
        PointerBuffer v3 = param0.mallocPointer(param2.length);
        PointerBuffer v4 = param0.mallocPointer(param2.length);
        for (CharSequence v8 : param2) {
            ByteBuffer v9 = param1.encode(v8, false);
            v3.put(v9);
            v4.put(v9.capacity());
        }
        return v3.address;
    }

    public static void apiArrayFree(long param0, int param2) {
        int v3 = param2;
        while (--v3 >= 0) {
            MemoryUtil.nmemFree(MemoryUtil.memGetAddress(param0 + Integer.toUnsignedLong(v3) * (long)MemoryStack.POINTER_SIZE));
        }
    }

    public static FFIType apiCreateStruct(FFIType ... param0) {
        MemoryUtil.MemoryAllocator v1 = MemoryUtil.getAllocator();
        PointerBuffer v2 = PointerBuffer.create(v1.malloc((param0.length + 1) * MemoryStack.POINTER_SIZE), param0.length + 1);
        for (int v3 = 0; v3 < param0.length; ++v3) {
            v2.put(v3, param0[v3]);
        }
        v2.put(param0.length, 0L);
        return FFIType.create(v1.calloc(1L, FFIType.SIZEOF)).type((short)13).elements(v2);
    }

    private static FFIType prep(FFIType param0) {
        MemoryStack v1 = MemoryStack.stackPush();
        Throwable v2 = null;
        try {
            FFICIF v3 = FFICIF.calloc(v1);
            if (LibFFI.ffi_prep_cif(v3, LibFFI.FFI_DEFAULT_ABI, param0, null) != 0) {
                throw new IllegalStateException("Failed to prepare LibFFI type.");
            }
            if (v1 != null) {
                v1.close();
            }
        }
        catch (Throwable v3) {
            try {
                v2 = v3;
                throw v3;
            }
            catch (Throwable v4) {
                if (v1 != null) {
                    if (v2 != null) {
                        try {
                            v1.close();
                        }
                        catch (Throwable v5) {
                            v2.addSuppressed(v5);
                        }
                    } else {
                        v1.close();
                    }
                }
                throw v4;
            }
        }
        return param0;
    }

    public static FFIType apiCreateUnion(FFIType ... param0) {
        MemoryUtil.MemoryAllocator v1 = MemoryUtil.getAllocator();
        FFIType v2 = APIUtil.prep(param0[0]);
        short v3 = param0[0].alignment();
        for (int v4 = 1; v4 < param0.length; ++v4) {
            FFIType v5 = APIUtil.prep(param0[v4]);
            if (v2.size() < v5.size()) {
                v2 = v5;
            }
            if (v3 >= v5.alignment()) continue;
            v3 = v5.alignment();
        }
        return FFIType.create(v1.malloc(FFIType.SIZEOF)).size(v2.size()).alignment(v3).type((short)13).elements(PointerBuffer.create(v1.malloc(2 * MemoryStack.POINTER_SIZE), 2).put(0, v2).put(1, 0L));
    }

    public static FFIType apiCreateArray(FFIType param0, int param1) {
        MemoryUtil.MemoryAllocator v2 = MemoryUtil.getAllocator();
        PointerBuffer v3 = PointerBuffer.create(v2.malloc((param1 + 1) * MemoryStack.POINTER_SIZE), param1 + 1);
        for (int v4 = 0; v4 < param1; ++v4) {
            v3.put(v4, param0);
        }
        v3.put(param1, 0L);
        return FFIType.create(v2.calloc(1L, FFIType.SIZEOF)).type((short)13).elements(v3);
    }

    public static FFICIF apiCreateCIF(int param0, FFIType param1, FFIType ... param2) {
        MemoryUtil.MemoryAllocator v3 = MemoryUtil.getAllocator();
        PointerBuffer v4 = PointerBuffer.create(v3.malloc(param2.length * MemoryStack.POINTER_SIZE), param2.length);
        for (int v5 = 0; v5 < param2.length; ++v5) {
            v4.put(v5, param2[v5]);
        }
        FFICIF v5 = FFICIF.create(v3.malloc(FFICIF.SIZEOF));
        int v6 = LibFFI.ffi_prep_cif(v5, param0, param1, v4);
        if (v6 != 0) {
            throw new IllegalStateException("Failed to prepare libffi CIF: " + v6);
        }
        return v5;
    }

    public static FFICIF apiCreateCIFVar(int param0, int param1, FFIType param2, FFIType ... param3) {
        MemoryUtil.MemoryAllocator v4 = MemoryUtil.getAllocator();
        PointerBuffer v5 = PointerBuffer.create(v4.malloc(param3.length * MemoryStack.POINTER_SIZE), param3.length);
        for (int v6 = 0; v6 < param3.length; ++v6) {
            v5.put(v6, param3[v6]);
        }
        FFICIF v6 = FFICIF.create(v4.malloc(FFICIF.SIZEOF));
        int v7 = LibFFI.ffi_prep_cif_var(v6, param0, param1, param2, v5);
        if (v7 != 0) {
            throw new IllegalStateException("Failed to prepare libffi var CIF: " + v7);
        }
        return v6;
    }

    public static int apiStdcall() {
        return Platform.get() == Platform.WINDOWS && Pointer.BITS32 ? LibFFI.FFI_STDCALL : LibFFI.FFI_DEFAULT_ABI;
    }

    public static void apiClosureRet(long param0, boolean param2) {
        MemoryUtil.memPutAddress(param0, param2 ? 1L : 0L);
    }

    public static void apiClosureRet(long param0, byte param2) {
        MemoryUtil.memPutAddress(param0, (long)param2 & 0xFFL);
    }

    public static void apiClosureRet(long param0, short param2) {
        MemoryUtil.memPutAddress(param0, (long)param2 & 0xFFFFL);
    }

    public static void apiClosureRet(long param0, int param2) {
        MemoryUtil.memPutAddress(param0, (long)param2 & 0xFFFFFFFFL);
    }

    public static void apiClosureRetL(long param0, long param2) {
        MemoryUtil.memPutLong(param0, param2);
    }

    public static void apiClosureRetP(long param0, long param2) {
        MemoryUtil.memPutAddress(param0, param2);
    }

    public static void apiClosureRet(long param0, float param2) {
        MemoryUtil.memPutFloat(param0, param2);
    }

    public static void apiClosureRet(long param0, double param2) {
        MemoryUtil.memPutDouble(param0, param2);
    }

    public static interface Encoder {
        public ByteBuffer encode(CharSequence var1, boolean var2);
    }

    public static class APIVersion
    implements Comparable<APIVersion> {
        public final int major;
        public final int minor;
        @Nullable
        public final String revision;
        @Nullable
        public final String implementation;

        public APIVersion(int param1, int param2) {
            this(param1, param2, null, null);
        }

        public APIVersion(int param1, int param2, @Nullable String param3, @Nullable String param4) {
            this.major = param1;
            this.minor = param2;
            this.revision = param3;
            this.implementation = param4;
        }

        public String toString() {
            StringBuilder v1 = new StringBuilder(16);
            v1.append(this.major).append('.').append(this.minor);
            if (this.revision != null) {
                v1.append('.').append(this.revision);
            }
            if (this.implementation != null) {
                v1.append(" (").append(this.implementation).append(')');
            }
            return v1.toString();
        }

        public boolean equals(Object param1) {
            if (this == param1) {
                return true;
            }
            if (!(param1 instanceof APIVersion)) {
                return false;
            }
            APIVersion v2 = (APIVersion)param1;
            return this.major == v2.major && this.minor == v2.major && Objects.equals(this.revision, v2.revision) && Objects.equals(this.implementation, v2.implementation);
        }

        public int hashCode() {
            int v1 = this.major;
            v1 = 31 * v1 + this.minor;
            v1 = 31 * v1 + (this.revision != null ? this.revision.hashCode() : 0);
            v1 = 31 * v1 + (this.implementation != null ? this.implementation.hashCode() : 0);
            return v1;
        }

        @Override
        public int compareTo(APIVersion param1) {
            if (this.major != param1.major) {
                return Integer.compare(this.major, param1.major);
            }
            if (this.minor != param1.minor) {
                return Integer.compare(this.minor, param1.minor);
            }
            return 0;
        }
    }
}

