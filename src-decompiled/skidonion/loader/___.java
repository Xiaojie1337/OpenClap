/*
 * Decompiled with CFR 0.152.
 */
package skidonion.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ___ {
    public static native void ___(int var0, Class<?> var1);

    static {
        File v6;
        System.out.println("[skidonion] loading native library...");
        String v0 = System.getProperty("os.name").toLowerCase();
        String v1 = System.getProperty("os.arch").toLowerCase();
        StringBuilder v2 = new StringBuilder("PhantomShieldX");
        if (v1.contains("x86_64") || v1.contains("amd64")) {
            v2.append("64");
        } else if (v1.contains("aarch64")) {
            v2.append("ARM64");
        } else if (v1.contains("x86")) {
            v2.append("32");
        }
        if (v0.contains("nix") || v0.contains("nux") || v0.contains("aix")) {
            v2.insert(0, "lib");
            v2.append(".so");
        } else if (v0.contains("win")) {
            v2.append(".diy");
        } else if (v0.contains("mac")) {
            v2.insert(0, "lib");
            v2.append(".dylib");
        } else {
            v2.insert(0, "lib");
            v2.append(".so");
        }
        int v3 = ___.class.getName().lastIndexOf(".");
        String v4 = ___.class.getName().substring(0, v3).replace(".", "/");
        String v5 = String.format("/%s/%s", v4, v2);
        try {
            v6 = File.createTempFile("lib", ".zip");
            v6.deleteOnExit();
            if (!v6.exists()) {
                throw new IOException();
            }
        }
        catch (IOException iOException) {
            throw new UnsatisfiedLinkError("Failed to create temp file");
        }
        byte[] cfr_ignored_0 = new byte[2048];
        try {
            InputStream v8 = ___.class.getResourceAsStream(v5);
            if (v8 == null) {
                throw new UnsatisfiedLinkError(String.format("Failed to open lib file: %s", v5));
            }
            try (FileOutputStream v92 = new FileOutputStream(v6);){
                int v162;
                int v11;
                boolean v10 = v2.toString().endsWith(".diy");
                ByteArrayOutputStream v12 = new ByteArrayOutputStream();
                byte[] v13 = new byte[1024];
                while ((v11 = v8.read(v13)) != -1) {
                    v12.write(v13, 0, v11);
                }
                byte[] v14 = v12.toByteArray();
                if (v10) {
                    int v15 = Math.min(1024, v14.length);
                    for (v162 = 0; v162 < v15; ++v162) {
                        v14[v162] = (byte)(v14[v162] ^ 1);
                    }
                }
                v92.write(v14);
                if (v10) {
                    Random v15 = new Random();
                    for (v162 = 0; v162 < 100; ++v162) {
                        v92.write(("TXT" + v15.nextInt(100) + "\n").getBytes(StandardCharsets.UTF_8));
                    }
                    ZipOutputStream v162 = new ZipOutputStream(v92);
                    v162.putNextEntry(new ZipEntry("data.txt"));
                    for (int v17 = 0; v17 < 100; ++v17) {
                        v162.write(("DIY" + v15.nextInt(100) + "\n").getBytes(StandardCharsets.UTF_8));
                    }
                    v162.closeEntry();
                    v162.close();
                }
                v92.close();
            }
            catch (Throwable v92) {
                try {
                    v8.close();
                }
                catch (Throwable v10) {
                    v92.addSuppressed(v10);
                }
                throw v92;
            }
        }
        catch (IOException v8) {
            throw new UnsatisfiedLinkError(String.format("Failed to copy file: %s", v8.getMessage()));
        }
        System.load(v6.getAbsolutePath());
    }
}

