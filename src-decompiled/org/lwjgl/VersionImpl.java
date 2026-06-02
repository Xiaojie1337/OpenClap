/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import org.lwjgl.Version;

final class VersionImpl {
    VersionImpl() {
    }

    static String find() {
        Package v0 = Version.class.getPackage();
        String v1 = v0.getSpecificationVersion();
        String v2 = v0.getImplementationVersion();
        if (v1 != null && v2 != null) {
            return Version.createImplementation(v1, v2);
        }
        String v3 = Version.findImplementationFromManifest();
        if (v3 != null) {
            return v3;
        }
        return "-snapshot";
    }
}

