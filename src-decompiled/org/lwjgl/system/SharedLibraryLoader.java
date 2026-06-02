/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;

final class SharedLibraryLoader {
    private static final Lock EXTRACT_PATH_LOCK = new ReentrantLock();
    @Nullable
    @GuardedBy(value="EXTRACT_PATH_LOCK")
    private static Path extractPath;
    private static HashSet<Path> extractPaths;
    private static boolean checkedJDK8195129;

    private SharedLibraryLoader() {
    }

    static FileChannel load(String param0, String param1, URL param2, @Nullable Consumer<String> param3) {
        try {
            Path v4;
            EXTRACT_PATH_LOCK.lock();
            try {
                if (extractPath != null) {
                    v4 = extractPath.resolve(param1);
                } else {
                    v4 = SharedLibraryLoader.getExtractPath(param1, param2, param3);
                    Path v5 = v4.getParent();
                    if (Platform.get() != Platform.WINDOWS || checkedJDK8195129) {
                        extractPath = v5;
                    }
                    SharedLibraryLoader.initExtractPath(v5);
                }
            }
            finally {
                EXTRACT_PATH_LOCK.unlock();
            }
            return SharedLibraryLoader.extract(v4, param2);
        }
        catch (Exception v4) {
            throw new RuntimeException("\tFailed to extract " + param0 + " library", v4);
        }
    }

    private static void initExtractPath(Path param0) {
        if (extractPaths.contains(param0)) {
            return;
        }
        extractPaths.add(param0);
        String v1 = param0.toAbsolutePath().toString();
        String v2 = Configuration.LIBRARY_PATH.get();
        if (v2 != null && !v2.isEmpty()) {
            v1 = v1 + File.pathSeparator + v2;
        }
        System.setProperty(Configuration.LIBRARY_PATH.getProperty(), v1);
        Configuration.LIBRARY_PATH.set(v1);
    }

    private static Path getExtractPath(String param0, URL param1, @Nullable Consumer<String> param2) {
        Path v5;
        Path v4;
        String v3 = Configuration.SHARED_LIBRARY_EXTRACT_PATH.get();
        if (v3 != null) {
            v4 = Paths.get(v3, new String[0]);
            if (SharedLibraryLoader.canWrite(v4, v5 = v4.resolve(param0), param1, param2)) {
                return v5;
            }
            APIUtil.apiLogMore("The path " + v3 + " is not accessible. Trying other paths.");
        }
        String v6 = Version.getVersion().replace(' ', '-');
        String v7 = Platform.getArchitecture().name().toLowerCase();
        v4 = Paths.get(System.getProperty("java.io.tmpdir"), new String[0]);
        if (SharedLibraryLoader.canWrite(v4, v5 = v4.resolve(Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl_" + System.getProperty("user.name").trim()), v6, v7, param0)), param1, param2)) {
            return v5;
        }
        Path v8 = Paths.get("." + Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl"), v6, v7, param0);
        v4 = Paths.get("", new String[0]).toAbsolutePath();
        if (SharedLibraryLoader.canWrite(v4, v5 = v4.resolve(v8), param1, param2)) {
            return v5;
        }
        v4 = Paths.get(System.getProperty("user.home"), new String[0]);
        if (SharedLibraryLoader.canWrite(v4, v5 = v4.resolve(v8), param1, param2)) {
            return v5;
        }
        if (Platform.get() == Platform.WINDOWS) {
            String v9 = System.getenv("SystemRoot");
            if (v9 != null && SharedLibraryLoader.canWrite(v4 = Paths.get(v9, "Temp"), v5 = v4.resolve(v8), param1, param2)) {
                return v5;
            }
            v9 = System.getenv("SystemDrive");
            if (v9 != null && SharedLibraryLoader.canWrite(v4 = Paths.get(v9 + "/", new String[0]), v5 = v4.resolve(Paths.get("Temp", new String[0]).resolve(v8)), param1, param2)) {
                return v5;
            }
        }
        try {
            v5 = Files.createTempDirectory("lwjgl", new FileAttribute[0]);
            v4 = v5.getParent();
            v5 = v5.resolve(param0);
            if (SharedLibraryLoader.canWrite(v4, v5, param1, param2)) {
                return v5;
            }
        }
        catch (IOException iOException) {}
        throw new RuntimeException("Failed to find an appropriate directory to extract the native library");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static FileChannel extract(Path param0, URL param1) throws IOException {
        Throwable v3;
        InputStream v2;
        if (Files.exists(param0, new LinkOption[0])) {
            InputStream v42;
            block27: {
                FileChannel v62;
                v2 = param1.openStream();
                v3 = null;
                try {
                    block28: {
                        v42 = Files.newInputStream(param0, new OpenOption[0]);
                        Throwable v5 = null;
                        try {
                            if (SharedLibraryLoader.crc(v2) != SharedLibraryLoader.crc(v42)) break block27;
                            if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                                APIUtil.apiLogMore("Found at: " + param0);
                            }
                            v62 = SharedLibraryLoader.lock(param0);
                            if (v42 == null) break block28;
                        }
                        catch (Throwable v62) {
                            try {
                                v5 = v62;
                                throw v62;
                            }
                            catch (Throwable v8) {
                                if (v42 == null) throw v8;
                                if (v5 == null) {
                                    v42.close();
                                    throw v8;
                                }
                                try {
                                    v42.close();
                                    throw v8;
                                }
                                catch (Throwable v9) {
                                    v5.addSuppressed(v9);
                                    throw v8;
                                }
                            }
                        }
                        v42.close();
                    }
                    if (v2 == null) return v62;
                }
                catch (Throwable v42) {
                    try {
                        v3 = v42;
                        throw v42;
                    }
                    catch (Throwable v10) {
                        if (v2 == null) throw v10;
                        if (v3 == null) {
                            v2.close();
                            throw v10;
                        }
                        try {
                            v2.close();
                            throw v10;
                        }
                        catch (Throwable v11) {
                            v3.addSuppressed(v11);
                            throw v10;
                        }
                    }
                }
                v2.close();
                return v62;
            }
            if (v42 != null) {
                v42.close();
            }
            if (v2 != null) {
                v2.close();
            }
        }
        APIUtil.apiLogMore("Extracting: " + param1.getPath());
        if (extractPath == null) {
            APIUtil.apiLogMore("        to: " + param0);
        }
        Files.createDirectories(param0.getParent(), new FileAttribute[0]);
        v2 = param1.openStream();
        v3 = null;
        try {
            Files.copy(v2, param0, StandardCopyOption.REPLACE_EXISTING);
            if (v2 == null) return SharedLibraryLoader.lock(param0);
        }
        catch (Throwable v42) {
            try {
                v3 = v42;
                throw v42;
            }
            catch (Throwable v12) {
                if (v2 == null) throw v12;
                if (v3 == null) {
                    v2.close();
                    throw v12;
                }
                try {
                    v2.close();
                    throw v12;
                }
                catch (Throwable v13) {
                    v3.addSuppressed(v13);
                    throw v12;
                }
            }
        }
        v2.close();
        return SharedLibraryLoader.lock(param0);
    }

    private static FileChannel lock(Path param0) {
        try {
            FileChannel v1 = FileChannel.open(param0, new OpenOption[0]);
            if (v1.tryLock(0L, Long.MAX_VALUE, true) == null) {
                if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                    APIUtil.apiLogMore("File is locked by another process, waiting...");
                }
                v1.lock(0L, Long.MAX_VALUE, true);
            }
            return v1;
        }
        catch (Exception v1) {
            throw new RuntimeException("Failed to lock file.", v1);
        }
    }

    private static long crc(InputStream param0) throws IOException {
        int v3;
        CRC32 v1 = new CRC32();
        byte[] v2 = new byte[8192];
        while ((v3 = param0.read(v2)) != -1) {
            v1.update(v2, 0, v3);
        }
        return v1.getValue();
    }

    private static boolean canWrite(Path param0, Path param1, URL param2, @Nullable Consumer<String> param3) {
        Path v4;
        if (Files.exists(param1, new LinkOption[0])) {
            if (!Files.isWritable(param1)) {
                return false;
            }
            v4 = param1.getParent().resolve(".lwjgl.test");
        } else {
            try {
                Files.createDirectories(param1.getParent(), new FileAttribute[0]);
            }
            catch (IOException iOException) {
                return false;
            }
            v4 = param1;
        }
        try {
            Files.write(v4, new byte[0], new OpenOption[0]);
            Files.delete(v4);
            if (param3 != null && Platform.get() == Platform.WINDOWS) {
                SharedLibraryLoader.workaroundJDK8195129(param1, param2, param3);
            }
            return true;
        }
        catch (Throwable throwable) {
            if (param1 == v4) {
                SharedLibraryLoader.canWriteCleanup(param0, param1);
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void canWriteCleanup(Path param0, Path param1) {
        try {
            Files.deleteIfExists(param1);
            Path v2 = param1.getParent();
            while (!Files.isSameFile(v2, param0)) {
                Stream<Path> v3;
                block12: {
                    v3 = Files.list(v2);
                    Throwable v4 = null;
                    try {
                        if (!v3.findAny().isPresent()) break block12;
                        if (v3 == null) return;
                    }
                    catch (Throwable v5) {
                        try {
                            v4 = v5;
                            throw v5;
                        }
                        catch (Throwable v6) {
                            if (v3 == null) throw v6;
                            if (v4 != null) {
                                try {
                                    v3.close();
                                    throw v6;
                                }
                                catch (Throwable v7) {
                                    v4.addSuppressed(v7);
                                }
                                throw v6;
                            } else {
                                v3.close();
                            }
                            throw v6;
                        }
                    }
                    v3.close();
                    return;
                }
                if (v3 != null) {
                    v3.close();
                }
                Files.delete(v2);
                v2 = v2.getParent();
            }
            return;
        }
        catch (IOException iOException) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void workaroundJDK8195129(Path param0, URL param1, @Nonnull Consumer<String> param2) throws Throwable {
        block9: {
            String v3 = param0.toAbsolutePath().toString();
            if (!v3.endsWith(".dll")) return;
            boolean v4 = false;
            for (int v5 = 0; v5 < v3.length(); ++v5) {
                if ('\u0080' > v3.charAt(v5)) continue;
                v4 = true;
            }
            if (v4) {
                FileChannel v5 = SharedLibraryLoader.extract(param0, param1);
                Throwable v6 = null;
                try {
                    param2.accept(param0.toAbsolutePath().toString());
                    if (v5 == null) break block9;
                }
                catch (Throwable v7) {
                    try {
                        v6 = v7;
                        throw v7;
                    }
                    catch (Throwable v8) {
                        if (v5 == null) throw v8;
                        if (v6 == null) {
                            v5.close();
                            throw v8;
                        }
                        try {
                            v5.close();
                            throw v8;
                        }
                        catch (Throwable v9) {
                            v6.addSuppressed(v9);
                            throw v8;
                        }
                    }
                }
                v5.close();
            }
        }
        checkedJDK8195129 = true;
    }

    static {
        extractPaths = new HashSet(4);
    }
}

