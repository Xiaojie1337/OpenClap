/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Objects;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import javax.annotation.Nullable;
import org.lwjgl.VersionImpl;

public final class Version {
    public static final int VERSION_MAJOR;
    public static final int VERSION_MINOR;
    public static final int VERSION_REVISION;
    public static final BuildType BUILD_TYPE;
    private static final String versionPlain;
    private static final String version;

    private Version() {
    }

    public static void main(String[] param0) {
        System.out.println(version);
        System.err.println(versionPlain);
    }

    public static String getVersion() {
        return version;
    }

    static String createImplementation(String param0, String param1) {
        String v2 = "+" + (param1.startsWith("build ") && 6 < param1.length() ? param1.substring(6) : param1);
        if (param0.contains("SNAPSHOT") || param0.contains("snapshot")) {
            return "-snapshot" + v2;
        }
        return v2;
    }

    @Nullable
    static String findImplementationFromManifest() {
        ClassLoader v0 = Version.class.getClassLoader();
        URL v1 = v0.getResource("org/lwjgl/Version.class");
        if (v1 != null) {
            String v2 = v1.toString();
            try {
                if (v2.startsWith("jar:")) {
                    URL v3 = Version.class.getResource("/META-INF/MANIFEST.MF");
                    String v4 = Version.readImplementationFromManifest(Objects.requireNonNull(v3));
                    if (v4 != null) {
                        return v4;
                    }
                } else if (v2.startsWith("resource:")) {
                    Enumeration<URL> v3 = v0.getResources("META-INF/MANIFEST.MF");
                    while (v3.hasMoreElements()) {
                        String v4 = Version.readImplementationFromManifest(v3.nextElement());
                        if (v4 == null) continue;
                        return v4;
                    }
                }
            }
            catch (Exception exception) {}
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    private static String readImplementationFromManifest(URL param0) {
        try {
            String v62;
            String v5;
            String v42;
            Throwable v2;
            InputStream v1;
            block14: {
                Attributes v3;
                block13: {
                    block12: {
                        v1 = param0.openStream();
                        v2 = null;
                        v3 = new Manifest(v1).getMainAttributes();
                        if ("lwjgl".equals(v3.getValue(Attributes.Name.IMPLEMENTATION_TITLE))) break block12;
                        String v42 = null;
                        if (v1 == null) return v42;
                        v1.close();
                        return v42;
                    }
                    if ("lwjgl.org".equals(v3.getValue(Attributes.Name.IMPLEMENTATION_VENDOR))) break block13;
                    String v42 = null;
                    if (v1 == null) return v42;
                    v1.close();
                    return v42;
                }
                v42 = v3.getValue(Attributes.Name.SPECIFICATION_VERSION);
                v5 = v3.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
                if (v42 != null && v5 != null) break block14;
                String v62 = null;
                if (v1 == null) return v62;
                v1.close();
                return v62;
            }
            try {
                v62 = Version.createImplementation(v42, v5);
                if (v1 == null) return v62;
            }
            catch (Throwable v3) {
                try {
                    v2 = v3;
                    throw v3;
                }
                catch (Throwable v8) {
                    if (v1 == null) throw v8;
                    if (v2 == null) {
                        v1.close();
                        throw v8;
                    }
                    try {
                        v1.close();
                        throw v8;
                    }
                    catch (Throwable v9) {
                        v2.addSuppressed(v9);
                        throw v8;
                    }
                }
            }
            v1.close();
            return v62;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static {
        VERSION_REVISION = 3;
        VERSION_MINOR = 3;
        VERSION_MAJOR = 3;
        BUILD_TYPE = BuildType.STABLE;
        versionPlain = "3" + '.' + 3 + '.' + 3 + Version.BUILD_TYPE.postfix;
        version = versionPlain + VersionImpl.find();
    }

    public static enum BuildType {
        ALPHA("a"),
        BETA("b"),
        STABLE("");

        public final String postfix;

        private BuildType(String param3) {
            this.postfix = param3;
        }
    }
}

