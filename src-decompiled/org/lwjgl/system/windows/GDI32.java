/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.PIXELFORMATDESCRIPTOR;

public class GDI32 {
    private static final SharedLibrary GDI32;
    public static final int DISPLAY_DEVICE_ATTACHED_TO_DESKTOP;
    public static final int DISPLAY_DEVICE_MULTI_DRIVER;
    public static final int DISPLAY_DEVICE_PRIMARY_DEVICE;
    public static final int DISPLAY_DEVICE_MIRRORING_DRIVER;
    public static final int DISPLAY_DEVICE_VGA_COMPATIBLE;
    public static final int DISPLAY_DEVICE_REMOVABLE;
    public static final int DISPLAY_DEVICE_MODESPRUNED;
    public static final int DISPLAY_DEVICE_REMOTE;
    public static final int DISPLAY_DEVICE_DISCONNECT;
    public static final int DISPLAY_DEVICE_TS_COMPATIBLE;
    public static final int DISPLAY_DEVICE_UNSAFE_MODES_ON;
    public static final int DISPLAY_DEVICE_ACTIVE;
    public static final int DISPLAY_DEVICE_ATTACHED;
    public static final int DM_SPECVERSION;
    public static final int DM_ORIENTATION;
    public static final int DM_PAPERSIZE;
    public static final int DM_PAPERLENGTH;
    public static final int DM_PAPERWIDTH;
    public static final int DM_SCALE;
    public static final int DM_POSITION;
    public static final int DM_NUP;
    public static final int DM_DISPLAYORIENTATION;
    public static final int DM_COPIES;
    public static final int DM_DEFAULTSOURCE;
    public static final int DM_PRINTQUALITY;
    public static final int DM_COLOR;
    public static final int DM_DUPLEX;
    public static final int DM_YRESOLUTION;
    public static final int DM_TTOPTION;
    public static final int DM_COLLATE;
    public static final int DM_FORMNAME;
    public static final int DM_LOGPIXELS;
    public static final int DM_BITSPERPEL;
    public static final int DM_PELSWIDTH;
    public static final int DM_PELSHEIGHT;
    public static final int DM_DISPLAYFLAGS;
    public static final int DM_DISPLAYFREQUENCY;
    public static final int DM_ICMMETHOD;
    public static final int DM_ICMINTENT;
    public static final int DM_MEDIATYPE;
    public static final int DM_DITHERTYPE;
    public static final int DM_PANNINGWIDTH;
    public static final int DM_PANNINGHEIGHT;
    public static final int DM_DISPLAYFIXEDOUTPUT;
    public static final int DMDO_DEFAULT;
    public static final int DMDO_90;
    public static final int DMDO_180;
    public static final int DMDO_270;
    public static final int DMDFO_DEFAULT;
    public static final int DMDFO_STRETCH;
    public static final int DMDFO_CENTER;
    public static final int DM_INTERLACED;
    public static final int DMDISPLAYFLAGS_TEXTMODE;
    public static final int PFD_DOUBLEBUFFER;
    public static final int PFD_STEREO;
    public static final int PFD_DRAW_TO_WINDOW;
    public static final int PFD_DRAW_TO_BITMAP;
    public static final int PFD_SUPPORT_GDI;
    public static final int PFD_SUPPORT_OPENGL;
    public static final int PFD_GENERIC_FORMAT;
    public static final int PFD_NEED_PALETTE;
    public static final int PFD_NEED_SYSTEM_PALETTE;
    public static final int PFD_SWAP_EXCHANGE;
    public static final int PFD_SWAP_COPY;
    public static final int PFD_SWAP_LAYER_BUFFERS;
    public static final int PFD_GENERIC_ACCELERATED;
    public static final int PFD_SUPPORT_DIRECTDRAW;
    public static final int PFD_DIRECT3D_ACCELERATED;
    public static final int PFD_SUPPORT_COMPOSITION;
    public static final int PFD_DEPTH_DONTCARE;
    public static final int PFD_DOUBLEBUFFER_DONTCARE;
    public static final int PFD_STEREO_DONTCARE;
    public static final byte PFD_TYPE_RGBA;
    public static final byte PFD_TYPE_COLORINDEX;
    public static final byte PFD_MAIN_PLANE;
    public static final byte PFD_OVERLAY_PLANE;
    public static final byte PFD_UNDERLAY_PLANE;

    public static SharedLibrary getLibrary() {
        return GDI32;
    }

    protected GDI32() {
        throw new UnsupportedOperationException();
    }

    public static native int nChoosePixelFormat(long var0, long var2, long var4);

    public static int nChoosePixelFormat(long param0, long param2) {
        long v4 = Functions.ChoosePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return org.lwjgl.system.windows.GDI32.nChoosePixelFormat(param0, param2, v4);
    }

    public static int ChoosePixelFormat(@NativeType(value="HDC") long param0, @NativeType(value="PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR param2) {
        return org.lwjgl.system.windows.GDI32.nChoosePixelFormat(param0, param2.address());
    }

    public static native int nDescribePixelFormat(long var0, int var2, int var3, long var4, long var6);

    public static int nDescribePixelFormat(long param0, int param2, int param3, long param4) {
        long v6 = Functions.DescribePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return org.lwjgl.system.windows.GDI32.nDescribePixelFormat(param0, param2, param3, param4, v6);
    }

    public static int DescribePixelFormat(@NativeType(value="HDC") long param0, int param2, @NativeType(value="UINT") int param3, @Nullable @NativeType(value="LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR param4) {
        return org.lwjgl.system.windows.GDI32.nDescribePixelFormat(param0, param2, param3, MemoryUtil.memAddressSafe(param4));
    }

    public static int DescribePixelFormat(@NativeType(value="HDC") long param0, int param2, @Nullable @NativeType(value="LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR param3) {
        return org.lwjgl.system.windows.GDI32.nDescribePixelFormat(param0, param2, PIXELFORMATDESCRIPTOR.SIZEOF, MemoryUtil.memAddressSafe(param3));
    }

    public static native int nGetPixelFormat(long var0, long var2);

    public static int GetPixelFormat(@NativeType(value="HDC") long param0) {
        long v2 = Functions.GetPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return org.lwjgl.system.windows.GDI32.nGetPixelFormat(param0, v2);
    }

    public static native int nSetPixelFormat(long var0, int var2, long var3, long var5);

    public static int nSetPixelFormat(long param0, int param2, long param3) {
        long v5 = Functions.SetPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return org.lwjgl.system.windows.GDI32.nSetPixelFormat(param0, param2, param3, v5);
    }

    @NativeType(value="BOOL")
    public static boolean SetPixelFormat(@NativeType(value="HDC") long param0, int param2, @Nullable @NativeType(value="PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR param3) {
        return org.lwjgl.system.windows.GDI32.nSetPixelFormat(param0, param2, MemoryUtil.memAddressSafe(param3)) != 0;
    }

    public static native int nSwapBuffers(long var0, long var2);

    @NativeType(value="BOOL")
    public static boolean SwapBuffers(@NativeType(value="HDC") long param0) {
        long v2 = Functions.SwapBuffers;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return org.lwjgl.system.windows.GDI32.nSwapBuffers(param0, v2) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return GDI32;
    }

    static {
        PFD_UNDERLAY_PLANE = (byte)-1;
        PFD_OVERLAY_PLANE = 1;
        PFD_MAIN_PLANE = 0;
        PFD_TYPE_COLORINDEX = 1;
        PFD_TYPE_RGBA = 0;
        PFD_STEREO_DONTCARE = Integer.MIN_VALUE;
        PFD_DOUBLEBUFFER_DONTCARE = 0x40000000;
        PFD_DEPTH_DONTCARE = 0x20000000;
        PFD_SUPPORT_COMPOSITION = 32768;
        PFD_DIRECT3D_ACCELERATED = 16384;
        PFD_SUPPORT_DIRECTDRAW = 8192;
        PFD_GENERIC_ACCELERATED = 4096;
        PFD_SWAP_LAYER_BUFFERS = 2048;
        PFD_SWAP_COPY = 1024;
        PFD_SWAP_EXCHANGE = 512;
        PFD_NEED_SYSTEM_PALETTE = 256;
        PFD_NEED_PALETTE = 128;
        PFD_GENERIC_FORMAT = 64;
        PFD_SUPPORT_OPENGL = 32;
        PFD_SUPPORT_GDI = 16;
        PFD_DRAW_TO_BITMAP = 8;
        PFD_DRAW_TO_WINDOW = 4;
        PFD_STEREO = 2;
        PFD_DOUBLEBUFFER = 1;
        DMDISPLAYFLAGS_TEXTMODE = 4;
        DM_INTERLACED = 2;
        DMDFO_CENTER = 2;
        DMDFO_STRETCH = 1;
        DMDFO_DEFAULT = 0;
        DMDO_270 = 3;
        DMDO_180 = 2;
        DMDO_90 = 1;
        DMDO_DEFAULT = 0;
        DM_DISPLAYFIXEDOUTPUT = 0x20000000;
        DM_PANNINGHEIGHT = 0x10000000;
        DM_PANNINGWIDTH = 0x8000000;
        DM_DITHERTYPE = 0x4000000;
        DM_MEDIATYPE = 0x2000000;
        DM_ICMINTENT = 0x1000000;
        DM_ICMMETHOD = 0x800000;
        DM_DISPLAYFREQUENCY = 0x400000;
        DM_DISPLAYFLAGS = 0x200000;
        DM_PELSHEIGHT = 0x100000;
        DM_PELSWIDTH = 524288;
        DM_BITSPERPEL = 262144;
        DM_LOGPIXELS = 131072;
        DM_FORMNAME = 65536;
        DM_COLLATE = 32768;
        DM_TTOPTION = 16384;
        DM_YRESOLUTION = 8192;
        DM_DUPLEX = 4096;
        DM_COLOR = 2048;
        DM_PRINTQUALITY = 1024;
        DM_DEFAULTSOURCE = 512;
        DM_COPIES = 256;
        DM_DISPLAYORIENTATION = 128;
        DM_NUP = 64;
        DM_POSITION = 32;
        DM_SCALE = 16;
        DM_PAPERWIDTH = 8;
        DM_PAPERLENGTH = 4;
        DM_PAPERSIZE = 2;
        DM_ORIENTATION = 1;
        DM_SPECVERSION = 1025;
        DISPLAY_DEVICE_ATTACHED = 2;
        DISPLAY_DEVICE_ACTIVE = 1;
        DISPLAY_DEVICE_UNSAFE_MODES_ON = 524288;
        DISPLAY_DEVICE_TS_COMPATIBLE = 0x200000;
        DISPLAY_DEVICE_DISCONNECT = 0x2000000;
        DISPLAY_DEVICE_REMOTE = 0x4000000;
        DISPLAY_DEVICE_MODESPRUNED = 0x8000000;
        DISPLAY_DEVICE_REMOVABLE = 32;
        DISPLAY_DEVICE_VGA_COMPATIBLE = 16;
        DISPLAY_DEVICE_MIRRORING_DRIVER = 8;
        DISPLAY_DEVICE_PRIMARY_DEVICE = 4;
        DISPLAY_DEVICE_MULTI_DRIVER = 2;
        DISPLAY_DEVICE_ATTACHED_TO_DESKTOP = 1;
        GDI32 = Library.loadNative(GDI32.class, "org.lwjgl", "gdi32");
    }

    public static final class Functions {
        public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress(org.lwjgl.system.windows.GDI32.access$000(), "ChoosePixelFormat");
        public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress(org.lwjgl.system.windows.GDI32.access$000(), "DescribePixelFormat");
        public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress(org.lwjgl.system.windows.GDI32.access$000(), "GetPixelFormat");
        public static final long SetPixelFormat = APIUtil.apiGetFunctionAddress(org.lwjgl.system.windows.GDI32.access$000(), "SetPixelFormat");
        public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(org.lwjgl.system.windows.GDI32.access$000(), "SwapBuffers");

        private Functions() {
        }
    }
}

