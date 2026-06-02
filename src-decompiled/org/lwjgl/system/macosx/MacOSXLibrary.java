/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.MacOSXLibraryBundle;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

public abstract class MacOSXLibrary
extends SharedLibrary.Default {
    protected MacOSXLibrary(String param1, long param2) {
        super(param1, param2);
    }

    public static MacOSXLibrary getWithIdentifier(String param0) {
        APIUtil.apiLog("Loading library: " + param0);
        MacOSXLibraryBundle v1 = MacOSXLibraryBundle.getWithIdentifier(param0);
        APIUtil.apiLogMore("Success");
        return v1;
    }

    public static MacOSXLibrary create(String param0) {
        return param0.endsWith(".framework") ? MacOSXLibraryBundle.create(param0) : new MacOSXLibraryDL(param0);
    }
}

