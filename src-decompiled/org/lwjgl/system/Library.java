/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryLoader;

public final class Library {
    public static final String JNI_LIBRARY_NAME;
    static final String JAVA_LIBRARY_PATH;
    private static final Pattern PATH_SEPARATOR;
    private static final Pattern NATIVES_JAR;

    private Library() {
    }

    public static void initialize() {
    }

    public static void loadSystem(String param0, String param1) throws UnsatisfiedLinkError {
        Library.loadSystem(System::load, System::loadLibrary, Library.class, param0, param1);
    }

    public static void loadSystem(Consumer<String> param0, Consumer<String> param1, Class<?> param2, String param3, String param4) throws UnsatisfiedLinkError {
        Object v92;
        boolean v6;
        String v5;
        block27: {
            if (Checks.DEBUG) {
                APIUtil.DEBUG_STREAM.print("[LWJGL] Loading JNI library: " + param4 + "\n\tModule: " + param3 + "\n");
            }
            if (Paths.get(param4, new String[0]).isAbsolute()) {
                param0.accept(param4);
                APIUtil.apiLogMore("Success");
                return;
            }
            v5 = Platform.get().mapLibraryName(param4);
            URL v7 = Library.findResource(param2, param3, v5, v6 = param4.contains("lwjgl"));
            if (v7 == null) {
                if (Library.loadSystemFromLibraryPath(param0, param2, param3, v5, v6)) {
                    return;
                }
            } else {
                boolean v8 = Configuration.DEBUG_LOADER.get(false);
                try {
                    block25: {
                        block26: {
                            if (!Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(false).booleanValue() && (v92 = Library.getRegularFilePath(v7)) != null) {
                                param0.accept((String)v92);
                                APIUtil.apiLogMore("Loaded from classpath: " + (String)v92);
                                return;
                            }
                            if (v8) {
                                APIUtil.apiLogMore("Using SharedLibraryLoader...");
                            }
                            v92 = SharedLibraryLoader.load(param4, v5, v7, param0);
                            Throwable v10 = null;
                            try {
                                if (!Library.loadSystemFromLibraryPath(param0, param2, param3, v5, v6)) break block25;
                                if (v92 == null) break block26;
                            }
                            catch (Throwable v11) {
                                try {
                                    v10 = v11;
                                    throw v11;
                                }
                                catch (Throwable v12) {
                                    if (v92 != null) {
                                        if (v10 != null) {
                                            try {
                                                ((AbstractInterruptibleChannel)v92).close();
                                            }
                                            catch (Throwable v13) {
                                                v10.addSuppressed(v13);
                                            }
                                        } else {
                                            ((AbstractInterruptibleChannel)v92).close();
                                        }
                                    }
                                    throw v12;
                                }
                            }
                            ((AbstractInterruptibleChannel)v92).close();
                        }
                        return;
                    }
                    if (v92 != null) {
                        ((AbstractInterruptibleChannel)v92).close();
                    }
                }
                catch (Exception v92) {
                    if (!v8) break block27;
                    v92.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        String v8 = System.getProperty("java.library.path");
        if (v6 && v8 != null && Library.loadSystem(param0, param2, param3, Library.getBundledPath(param3, v5), false, "java.library.path", v8)) {
            return;
        }
        try {
            param1.accept(param4);
            Object object = v92 = v8 == null ? null : Library.findFile(v8, param3, v5, v6);
            if (v92 != null) {
                APIUtil.apiLogMore(String.format("Loaded from %s: %s", "java.library.path", v92));
                if (v6) {
                    Library.checkHash(param2, (Path)v92, param3, v5);
                }
            } else {
                APIUtil.apiLogMore("Loaded from a ClassLoader provided path.");
            }
            return;
        }
        catch (Throwable throwable) {
            APIUtil.apiLogMore(v5 + " not found in " + "java.library.path");
            Library.detectPlatformMismatch(param2, param3);
            Library.printError(true);
            throw new UnsatisfiedLinkError("Failed to locate library: " + v5);
        }
    }

    private static boolean loadSystemFromLibraryPath(Consumer<String> param0, Class<?> param1, String param2, String param3, boolean param4) {
        String v5 = Configuration.LIBRARY_PATH.get();
        return v5 != null && Library.loadSystem(param0, param1, param2, param3, param4, Configuration.LIBRARY_PATH.getProperty(), v5);
    }

    private static boolean loadSystem(Consumer<String> param0, Class<?> param1, String param2, String param3, boolean param4, String param5, String param6) {
        Path v7 = Library.findFile(param6, param2, param3, param4);
        if (v7 == null) {
            APIUtil.apiLogMore(param3 + " not found in " + param5 + "=" + param6);
            return false;
        }
        param0.accept(v7.toAbsolutePath().toString());
        APIUtil.apiLogMore("Loaded from " + param5 + ": " + v7);
        if (param4) {
            Library.checkHash(param1, v7, param2, param3);
        }
        return true;
    }

    public static SharedLibrary loadNative(String param0, String param1) {
        return Library.loadNative(Library.class, param0, param1);
    }

    public static SharedLibrary loadNative(Class<?> param0, String param1, String param2) {
        return Library.loadNative(param0, param1, param2, false);
    }

    public static SharedLibrary loadNative(Class<?> param0, String param1, String param2, boolean param3) {
        return Library.loadNative(param0, param1, param2, param3, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SharedLibrary loadNative(Class<?> param0, String param1, String param2, boolean param3, boolean param4) {
        String v82222;
        Object v92222;
        SharedLibrary v72222;
        String v52222;
        block25: {
            if (Checks.DEBUG) {
                APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library: " + param2 + "\n\tModule: " + param1 + "\n");
            }
            if (Paths.get(param2, new String[0]).isAbsolute()) {
                SharedLibrary v52222 = APIUtil.apiCreateLibrary(param2);
                APIUtil.apiLogMore("Success");
                return v52222;
            }
            v52222 = Platform.get().mapLibraryName(param2);
            URL v6 = Library.findResource(param0, param1, v52222, param3);
            if (v6 == null) {
                v72222 = Library.loadNativeFromLibraryPath(param0, param1, v52222, param3);
                if (v72222 != null) {
                    return v72222;
                }
            } else {
                boolean v82222 = Configuration.DEBUG_LOADER.get(false);
                try {
                    block24: {
                        if (!Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(false).booleanValue() && (v92222 = Library.getRegularFilePath(v6)) != null) {
                            SharedLibrary v72222 = APIUtil.apiCreateLibrary((String)v92222);
                            APIUtil.apiLogMore("Loaded from classpath: " + (String)v92222);
                            return v72222;
                        }
                        if (v82222) {
                            APIUtil.apiLogMore("Using SharedLibraryLoader...");
                        }
                        v92222 = SharedLibraryLoader.load(param2, v52222, v6, null);
                        Throwable v10 = null;
                        try {
                            v72222 = Library.loadNativeFromLibraryPath(param0, param1, v52222, param3);
                            if (v72222 == null) break block24;
                            SharedLibrary v11 = v72222;
                            if (v92222 == null) return v11;
                        }
                        catch (Throwable v11) {
                            try {
                                v10 = v11;
                                throw v11;
                            }
                            catch (Throwable v13) {
                                if (v92222 == null) throw v13;
                                if (v10 == null) {
                                    ((AbstractInterruptibleChannel)v92222).close();
                                    throw v13;
                                }
                                try {
                                    ((AbstractInterruptibleChannel)v92222).close();
                                    throw v13;
                                }
                                catch (Throwable v14) {
                                    v10.addSuppressed(v14);
                                    throw v13;
                                }
                            }
                        }
                        ((AbstractInterruptibleChannel)v92222).close();
                        return v11;
                    }
                    if (v92222 != null) {
                        ((AbstractInterruptibleChannel)v92222).close();
                    }
                }
                catch (Exception v92222) {
                    if (!v82222) break block25;
                    v92222.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if (!param3 && (v72222 = Library.loadNativeFromSystem(v52222)) != null) {
            return v72222;
        }
        if (Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(false).booleanValue()) {
            try {
                Method v82222 = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                v82222.setAccessible(true);
                v92222 = (String)v82222.invoke((Object)param0.getClassLoader(), param2);
                if (v92222 != null) {
                    v72222 = APIUtil.apiCreateLibrary((String)v92222);
                    APIUtil.apiLogMore("Loaded from ClassLoader provided path: " + (String)v92222);
                    return v72222;
                }
            }
            catch (Exception exception) {}
        }
        if ((v82222 = System.getProperty("java.library.path")) != null && (v72222 = Library.loadNative(param0, param1, v52222, param3, "java.library.path", v82222)) != null) {
            return v72222;
        }
        if (param3 && (v72222 = Library.loadNativeFromSystem(v52222)) != null) {
            return v72222;
        }
        if (!param4) throw new UnsatisfiedLinkError("Failed to locate library: " + v52222);
        Library.detectPlatformMismatch(param0, param1);
        Library.printError(param3);
        throw new UnsatisfiedLinkError("Failed to locate library: " + v52222);
    }

    @Nullable
    private static SharedLibrary loadNativeFromSystem(String param0) {
        SharedLibrary v1;
        try {
            v1 = APIUtil.apiCreateLibrary(param0);
            String v2 = v1.getPath();
            APIUtil.apiLogMore(v2 == null ? "Loaded from system paths" : "Loaded from system paths: " + v2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            v1 = null;
            APIUtil.apiLogMore(param0 + " not found in system paths");
        }
        return v1;
    }

    @Nullable
    private static SharedLibrary loadNativeFromLibraryPath(Class<?> param0, String param1, String param2, boolean param3) {
        String v4 = Configuration.LIBRARY_PATH.get();
        if (v4 == null) {
            return null;
        }
        return Library.loadNative(param0, param1, param2, param3, Configuration.LIBRARY_PATH.getProperty(), v4);
    }

    @Nullable
    private static SharedLibrary loadNative(Class<?> param0, String param1, String param2, boolean param3, String param4, String param5) {
        Path v6 = Library.findFile(param5, param1, param2, param3);
        if (v6 == null) {
            APIUtil.apiLogMore(param2 + " not found in " + param4 + "=" + param5);
            return null;
        }
        SharedLibrary v7 = APIUtil.apiCreateLibrary(v6.toAbsolutePath().toString());
        APIUtil.apiLogMore("Loaded from " + param4 + ": " + v6);
        if (param3) {
            Library.checkHash(param0, v6, param1, param2);
        }
        return v7;
    }

    public static SharedLibrary loadNative(Class<?> param0, String param1, @Nullable Configuration<String> param2, String ... param3) {
        return Library.loadNative(param0, param1, param2, null, param3);
    }

    public static SharedLibrary loadNative(Class<?> param0, String param1, @Nullable Configuration<String> param2, @Nullable Supplier<SharedLibrary> param3, String ... param4) {
        String v72;
        if (param4.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        if (param2 != null && (v72 = param2.get()) != null) {
            return Library.loadNative(param0, param1, v72);
        }
        if (param3 == null && param4.length <= 1) {
            return Library.loadNative(param0, param1, param4[0]);
        }
        try {
            return Library.loadNative(param0, param1, param4[0], false, false);
        }
        catch (Throwable v72) {
            for (int v6 = 1; v6 < param4.length; ++v6) {
                try {
                    return Library.loadNative(param0, param1, param4[v6], false, param3 == null && v6 == param4.length - 1);
                }
                catch (Throwable throwable) {
                    continue;
                }
            }
            if (param3 != null) {
                return param3.get();
            }
            throw v72;
        }
    }

    private static String getBundledPath(String param0, String param1) {
        return Platform.mapLibraryPathBundled(param0.replace('.', '/') + "/" + param1);
    }

    @Nullable
    static URL findResource(Class<?> param0, String param1, String param2, boolean param3) {
        String v5;
        URL v4 = null;
        if (param3 && !(v5 = Library.getBundledPath(param1, param2)).equals(param2)) {
            v4 = param0.getClassLoader().getResource(v5);
        }
        return v4 == null ? param0.getClassLoader().getResource(param2) : v4;
    }

    @Nullable
    static String getRegularFilePath(URL param0) {
        if (param0.getProtocol().equals("file")) {
            try {
                Path v1 = Paths.get(param0.toURI());
                if (v1.isAbsolute() && Files.isReadable(v1)) {
                    return v1.toString();
                }
            }
            catch (URISyntaxException uRISyntaxException) {}
        }
        return null;
    }

    @Nullable
    static Path findFile(String param0, String param1, String param2, boolean param3) {
        Path v5;
        String v4;
        if (param3 && !(v4 = Library.getBundledPath(param1, param2)).equals(param2) && (v5 = Library.findFile(param0, v4)) != null) {
            return v5;
        }
        return Library.findFile(param0, param2);
    }

    @Nullable
    private static Path findFile(String param0, String param1) {
        for (String v5 : PATH_SEPARATOR.split(param0)) {
            Path v6 = Paths.get(v5, param1);
            if (!Files.isReadable(v6)) continue;
            return v6;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void detectPlatformMismatch(Class<?> param0, String param1) {
        if (!param1.startsWith("org.lwjgl")) {
            return;
        }
        String v2 = param1.equals("org.lwjgl") ? "lwjgl" : "lwjgl-" + param1.substring(10);
        ArrayList<String> v3 = new ArrayList<String>(8);
        try {
            Enumeration<URL> v4 = param0.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (v4.hasMoreElements()) {
                InputStream v5 = v4.nextElement().openStream();
                Throwable v6 = null;
                try {
                    String v9;
                    Manifest v7 = new Manifest(v5);
                    Attributes v8 = v7.getMainAttributes();
                    if (v2.equals(v8.getValue("Implementation-Title")) && (v9 = v8.getValue("LWJGL-Platform")) != null) {
                        v3.add(v9);
                    }
                    if (v5 == null) continue;
                }
                catch (Throwable v7) {
                    try {
                        v6 = v7;
                        throw v7;
                    }
                    catch (Throwable v10) {
                        if (v5 == null) throw v10;
                        if (v6 == null) {
                            v5.close();
                            throw v10;
                        }
                        try {
                            v5.close();
                            throw v10;
                        }
                        catch (Throwable v11) {
                            v6.addSuppressed(v11);
                            throw v10;
                        }
                    }
                }
                v5.close();
            }
        }
        catch (IOException iOException) {}
        if (v3.isEmpty()) return;
        APIUtil.DEBUG_STREAM.print("[LWJGL] Platform/architecture mismatch detected for module: " + param1 + "\n\tJVM platform:\t\t" + Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\t\t" + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n\tPlatform" + (v3.size() == 1 ? "" : "s") + " available on classpath:\n\t\t" + String.join((CharSequence)"\n\t\t", v3) + "\n");
    }

    private static void printError(boolean param0) {
        Library.printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (param0 ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
    }

    static void printError(String param0) {
        StringBuilder v1 = new StringBuilder(param0);
        v1.append("\n");
        if (!Checks.DEBUG) {
            v1.append("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.\n");
            if (!Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                v1.append("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.\n");
            }
        }
        APIUtil.DEBUG_STREAM.print(v1);
    }

    private static void checkHash(Class<?> param0, Path param1, String param2, String param3) {
        block7: {
            if (!Checks.CHECKS) {
                return;
            }
            try {
                byte[] v8;
                Object v7;
                Object v4 = null;
                Object v5 = null;
                Enumeration<URL> v6 = param0.getClassLoader().getResources("META-INF/" + Library.getBundledPath(param2, param3) + ".sha1");
                while (v6.hasMoreElements()) {
                    v7 = v6.nextElement();
                    if (NATIVES_JAR.matcher(((URL)v7).toExternalForm()).find()) {
                        v5 = v7;
                        continue;
                    }
                    v4 = v7;
                }
                if (v4 == null) {
                    return;
                }
                v7 = Library.getSHA1(v4);
                byte[] byArray = v8 = Checks.DEBUG || v5 == null ? Library.getSHA1(param1) : Library.getSHA1(v5);
                if (!Arrays.equals((byte[])v7, v8)) {
                    APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
                }
            }
            catch (Throwable v4) {
                if (!Checks.DEBUG) break block7;
                APIUtil.apiLog("Failed to verify native library.");
                v4.printStackTrace();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static byte[] getSHA1(URL param0) throws IOException {
        byte[] v1 = new byte[20];
        InputStream v2 = param0.openStream();
        Throwable v3 = null;
        try {
            for (int v4 = 0; v4 < 20; ++v4) {
                v1[v4] = (byte)(Character.digit(v2.read(), 16) << 4 | Character.digit(v2.read(), 16));
            }
            if (v2 == null) return v1;
        }
        catch (Throwable v4) {
            try {
                v3 = v4;
                throw v4;
            }
            catch (Throwable v5) {
                if (v2 == null) throw v5;
                if (v3 != null) {
                    try {
                        v2.close();
                        throw v5;
                    }
                    catch (Throwable v6) {
                        v3.addSuppressed(v6);
                    }
                    throw v5;
                } else {
                    v2.close();
                }
                throw v5;
            }
        }
        v2.close();
        return v1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static byte[] getSHA1(Path param0) throws NoSuchAlgorithmException, IOException {
        MessageDigest v1 = MessageDigest.getInstance("SHA-1");
        InputStream v2 = Files.newInputStream(param0, new OpenOption[0]);
        Throwable v3 = null;
        try {
            int v5;
            byte[] v4 = new byte[8192];
            while ((v5 = v2.read(v4)) != -1) {
                v1.update(v4, 0, v5);
            }
            if (v2 == null) return v1.digest();
        }
        catch (Throwable v4) {
            try {
                v3 = v4;
                throw v4;
            }
            catch (Throwable v6) {
                if (v2 == null) throw v6;
                if (v3 != null) {
                    try {
                        v2.close();
                        throw v6;
                    }
                    catch (Throwable v7) {
                        v3.addSuppressed(v7);
                    }
                    throw v6;
                } else {
                    v2.close();
                }
                throw v6;
            }
        }
        v2.close();
        return v1.digest();
    }

    static {
        JAVA_LIBRARY_PATH = "java.library.path";
        JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
        PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
        NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");
        if (Checks.DEBUG) {
            APIUtil.DEBUG_STREAM.print("[LWJGL] Version: " + Version.getVersion() + "\n\t OS: " + System.getProperty("os.name") + " v" + System.getProperty("os.version") + "\n\tJRE: " + Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\tJVM: " + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n");
        }
        Library.loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
    }
}

