/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Library;
import org.lwjgl.system.SharedLibraryLoader;

public final class LibraryResource {
    private LibraryResource() {
    }

    public static Path load(String param0, String param1) {
        return LibraryResource.load(LibraryResource.class, param0, param1);
    }

    public static Path load(Class<?> param0, String param1, String param2) {
        return LibraryResource.load(param0, param1, param2, false, true);
    }

    public static Path load(Class<?> param0, String param1, String param2, boolean param3) {
        return LibraryResource.load(param0, param1, param2, param3, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Path load(Class<?> param0, String param1, String param2, boolean param3, boolean param4) {
        String v72222;
        Path v5;
        block20: {
            if (Checks.DEBUG) {
                APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library resource: " + param2 + "\n\tModule: " + param1 + "\n");
            }
            if ((v5 = Paths.get(param2, new String[0])).isAbsolute()) {
                if (!Files.exists(v5, new LinkOption[0])) {
                    if (!param4) throw new IllegalStateException("Failed to locate library resource: " + param2);
                    LibraryResource.printError();
                    throw new IllegalStateException("Failed to locate library resource: " + param2);
                }
                APIUtil.apiLogMore("Success");
                return v5;
            }
            URL v6 = Library.findResource(param0, param1, param2, param3);
            if (v6 == null) {
                v5 = LibraryResource.loadFromLibraryPath(param1, param2, param3);
                if (v5 != null) {
                    return v5;
                }
            } else {
                boolean v72222 = Configuration.DEBUG_LOADER.get(false);
                try {
                    FileChannel v9;
                    block19: {
                        String v8 = Library.getRegularFilePath(v6);
                        if (v8 != null) {
                            APIUtil.apiLogMore("Loaded from classpath: " + v8);
                            return Paths.get(v8, new String[0]);
                        }
                        if (v72222) {
                            APIUtil.apiLogMore("Using SharedLibraryLoader...");
                        }
                        v9 = SharedLibraryLoader.load(param2, param2, v6, null);
                        Throwable v10 = null;
                        try {
                            v5 = LibraryResource.loadFromLibraryPath(param1, param2, param3);
                            if (v5 == null) break block19;
                            Path v11 = v5;
                            if (v9 == null) return v11;
                        }
                        catch (Throwable v11) {
                            try {
                                v10 = v11;
                                throw v11;
                            }
                            catch (Throwable v13) {
                                if (v9 == null) throw v13;
                                if (v10 == null) {
                                    v9.close();
                                    throw v13;
                                }
                                try {
                                    v9.close();
                                    throw v13;
                                }
                                catch (Throwable v14) {
                                    v10.addSuppressed(v14);
                                    throw v13;
                                }
                            }
                        }
                        v9.close();
                        return v11;
                    }
                    if (v9 != null) {
                        v9.close();
                    }
                }
                catch (Exception v8) {
                    if (!v72222) break block20;
                    v8.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if ((v72222 = System.getProperty("java.library.path")) != null && (v5 = LibraryResource.load(param1, param2, param3, "java.library.path", v72222)) != null) {
            return v5;
        }
        if (!param4) throw new IllegalStateException("Failed to locate library resource: " + param2);
        LibraryResource.printError();
        throw new IllegalStateException("Failed to locate library resource: " + param2);
    }

    @Nullable
    private static Path loadFromLibraryPath(String param0, String param1, boolean param2) {
        String v3 = Configuration.LIBRARY_PATH.get();
        if (v3 == null) {
            return null;
        }
        return LibraryResource.load(param0, param1, param2, Configuration.LIBRARY_PATH.getProperty(), v3);
    }

    @Nullable
    private static Path load(String param0, String param1, boolean param2, String param3, String param4) {
        Path v5 = Library.findFile(param4, param0, param1, param2);
        if (v5 == null) {
            APIUtil.apiLogMore(param1 + " not found in " + param3 + "=" + param4);
            return null;
        }
        APIUtil.apiLogMore("Loaded from " + param3 + ": " + v5);
        return v5;
    }

    public static Path load(Class<?> param0, String param1, Configuration<String> param2, String ... param3) {
        return LibraryResource.load(param0, param1, param2, null, param3);
    }

    public static Path load(Class<?> param0, String param1, Configuration<String> param2, @Nullable Supplier<Path> param3, String ... param4) {
        if (param4.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        String v5 = param2.get();
        if (v5 != null) {
            return LibraryResource.load(param0, param1, v5);
        }
        if (param3 == null && param4.length <= 1) {
            return LibraryResource.load(param0, param1, param4[0]);
        }
        try {
            return LibraryResource.load(param0, param1, param4[0], false, false);
        }
        catch (Throwable v6) {
            for (int v7 = 1; v7 < param4.length; ++v7) {
                try {
                    return LibraryResource.load(param0, param1, param4[v7], false, param3 == null && v7 == param4.length - 1);
                }
                catch (Throwable throwable) {
                    continue;
                }
            }
            if (param3 != null) {
                return param3.get();
            }
            throw v6;
        }
    }

    private static void printError() {
        Library.printError("[LWJGL] Failed to load a library resource. Possible solutions:\n\ta) Add the directory that contains the resource to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the resource to the classpath.");
    }

    static {
        Library.initialize();
    }
}

