/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.function.Function;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;

public enum Platform {
    LINUX("Linux", "linux"){
        private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");

        @Override
        String mapLibraryName(String param1) {
            if (this.SO.matcher(param1).find()) {
                return param1;
            }
            return System.mapLibraryName(param1);
        }
    }
    ,
    MACOSX("macOS", "macos"){
        private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");

        @Override
        String mapLibraryName(String param1) {
            if (this.DYLIB.matcher(param1).find()) {
                return param1;
            }
            return System.mapLibraryName(param1);
        }
    }
    ,
    WINDOWS("Windows", "windows"){

        @Override
        String mapLibraryName(String param1) {
            if (param1.endsWith(".dll")) {
                return param1;
            }
            return System.mapLibraryName(param1);
        }
    };

    private static final Platform current;
    private static final Function<String, String> bundledLibraryNameMapper;
    private static final Function<String, String> bundledLibraryPathMapper;
    private final String name;
    private final String nativePath;

    private Platform(String param3, String param4) {
        this.name = param3;
        this.nativePath = param4;
    }

    public String getName() {
        return this.name;
    }

    abstract String mapLibraryName(String var1);

    public static Platform get() {
        return current;
    }

    public static Architecture getArchitecture() {
        return Architecture.current;
    }

    public static String mapLibraryNameBundled(String param0) {
        return bundledLibraryNameMapper.apply(param0);
    }

    static String mapLibraryPathBundled(String param0) {
        return bundledLibraryPathMapper.apply(param0);
    }

    private static Function<String, String> getMapper(@Nullable Object param0, Function<String, String> param1, Function<String, String> param2) {
        if (param0 == null || "default".equals(param0)) {
            return param1;
        }
        if ("legacy".equals(param0)) {
            return param2;
        }
        if (param0 instanceof Function) {
            return (Function)param0;
        }
        String v3 = param0.toString();
        try {
            return (Function)Class.forName(v3).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Throwable v4) {
            if (Checks.DEBUG) {
                v4.printStackTrace(APIUtil.DEBUG_STREAM);
            }
            APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", v3));
            return param1;
        }
    }

    static {
        String v0 = System.getProperty("os.name");
        if (v0.startsWith("Windows")) {
            current = WINDOWS;
        } else if (v0.startsWith("Linux") || v0.startsWith("FreeBSD") || v0.startsWith("SunOS") || v0.startsWith("Unix")) {
            current = LINUX;
        } else if (v0.startsWith("Mac OS X") || v0.startsWith("Darwin")) {
            current = MACOSX;
        } else {
            throw new LinkageError("Unknown platform: " + v0);
        }
        bundledLibraryNameMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER.get("default"), param0 -> param0, param0 -> Architecture.current.is64Bit ? param0 : param0 + "32");
        bundledLibraryPathMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER.get("default"), param0 -> Platform.current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + param0, param0 -> param0.substring(param0.lastIndexOf(47)));
    }

    public static final class Architecture
    extends Enum<Architecture> {
        public static final /* enum */ Architecture X64;
        public static final /* enum */ Architecture X86;
        public static final /* enum */ Architecture ARM64;
        public static final /* enum */ Architecture ARM32;
        static final Architecture current;
        final boolean is64Bit;
        private static final /* synthetic */ Architecture[] $VALUES;

        public static Architecture[] values() {
            return (Architecture[])$VALUES.clone();
        }

        public static Architecture valueOf(String param0) {
            return Enum.valueOf(Architecture.class, param0);
        }

        private Architecture(boolean param3) {
            this.is64Bit = param3;
        }

        static {
            boolean v1;
            X64 = new Architecture(true);
            X86 = new Architecture(false);
            ARM64 = new Architecture(true);
            ARM32 = new Architecture(false);
            $VALUES = new Architecture[]{X64, X86, ARM64, ARM32};
            String v0 = System.getProperty("os.arch");
            boolean bl = v1 = v0.contains("64") || v0.startsWith("armv8");
            current = v0.startsWith("arm") || v0.startsWith("aarch64") ? (v1 ? ARM64 : ARM32) : (v1 ? X64 : X86);
        }
    }
}

