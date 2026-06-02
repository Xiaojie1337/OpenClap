/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.linux.Visual;
import org.lwjgl.system.linux.XEvent;
import org.lwjgl.system.linux.XSetWindowAttributes;
import org.lwjgl.system.linux.XTimeCoord;

public class X11 {
    private static final SharedLibrary X11;
    public static final int True;
    public static final int False;
    public static final int None;
    public static final int ParentRelative;
    public static final int CopyFromParent;
    public static final int PointerWindow;
    public static final int InputFocus;
    public static final int PointerRoot;
    public static final int AnyPropertyType;
    public static final int AnyKey;
    public static final int AnyButton;
    public static final int AllTemporary;
    public static final int CurrentTime;
    public static final int NoSymbol;
    public static final int Success;
    public static final int BadRequest;
    public static final int BadValue;
    public static final int BadWindow;
    public static final int BadPixmap;
    public static final int BadAtom;
    public static final int BadCursor;
    public static final int BadFont;
    public static final int BadMatch;
    public static final int BadDrawable;
    public static final int BadAccess;
    public static final int BadAlloc;
    public static final int BadColor;
    public static final int BadGC;
    public static final int BadIDChoice;
    public static final int BadName;
    public static final int BadLength;
    public static final int BadImplementation;
    public static final int FirstExtensionError;
    public static final int LastExtensionError;
    public static final int CWBackPixmap;
    public static final int CWBackPixel;
    public static final int CWBorderPixmap;
    public static final int CWBorderPixel;
    public static final int CWBitGravity;
    public static final int CWWinGravity;
    public static final int CWBackingStore;
    public static final int CWBackingPlanes;
    public static final int CWBackingPixel;
    public static final int CWOverrideRedirect;
    public static final int CWSaveUnder;
    public static final int CWEventMask;
    public static final int CWDontPropagate;
    public static final int CWColormap;
    public static final int CWCursor;
    public static final int NoEventMask;
    public static final int KeyPressMask;
    public static final int KeyReleaseMask;
    public static final int ButtonPressMask;
    public static final int ButtonReleaseMask;
    public static final int EnterWindowMask;
    public static final int LeaveWindowMask;
    public static final int PointerMotionMask;
    public static final int PointerMotionHintMask;
    public static final int Button1MotionMask;
    public static final int Button2MotionMask;
    public static final int Button3MotionMask;
    public static final int Button4MotionMask;
    public static final int Button5MotionMask;
    public static final int ButtonMotionMask;
    public static final int KeymapStateMask;
    public static final int ExposureMask;
    public static final int VisibilityChangeMask;
    public static final int StructureNotifyMask;
    public static final int ResizeRedirectMask;
    public static final int SubstructureNotifyMask;
    public static final int SubstructureRedirectMask;
    public static final int FocusChangeMask;
    public static final int PropertyChangeMask;
    public static final int ColormapChangeMask;
    public static final int OwnerGrabButtonMask;
    public static final int KeyPress;
    public static final int KeyRelease;
    public static final int ButtonPress;
    public static final int ButtonRelease;
    public static final int MotionNotify;
    public static final int EnterNotify;
    public static final int LeaveNotify;
    public static final int FocusIn;
    public static final int FocusOut;
    public static final int KeymapNotify;
    public static final int Expose;
    public static final int GraphicsExpose;
    public static final int NoExpose;
    public static final int VisibilityNotify;
    public static final int CreateNotify;
    public static final int DestroyNotify;
    public static final int UnmapNotify;
    public static final int MapNotify;
    public static final int MapRequest;
    public static final int ReparentNotify;
    public static final int ConfigureNotify;
    public static final int ConfigureRequest;
    public static final int GravityNotify;
    public static final int ResizeRequest;
    public static final int CirculateNotify;
    public static final int CirculateRequest;
    public static final int PropertyNotify;
    public static final int SelectionClear;
    public static final int SelectionRequest;
    public static final int SelectionNotify;
    public static final int ColormapNotify;
    public static final int ClientMessage;
    public static final int MappingNotify;
    public static final int GenericEvent;
    public static final int LASTEvent;
    public static final int ShiftMask;
    public static final int LockMask;
    public static final int ControlMask;
    public static final int Mod1Mask;
    public static final int Mod2Mask;
    public static final int Mod3Mask;
    public static final int Mod4Mask;
    public static final int Mod5Mask;
    public static final int ShiftMapIndex;
    public static final int LockMapIndex;
    public static final int ControlMapIndex;
    public static final int Mod1MapIndex;
    public static final int Mod2MapIndex;
    public static final int Mod3MapIndex;
    public static final int Mod4MapIndex;
    public static final int Mod5MapIndex;
    public static final int Button1Mask;
    public static final int Button2Mask;
    public static final int Button3Mask;
    public static final int Button4Mask;
    public static final int Button5Mask;
    public static final int AnyModifier;
    public static final int Button1;
    public static final int Button2;
    public static final int Button3;
    public static final int Button4;
    public static final int Button5;
    public static final int NotifyNormal;
    public static final int NotifyGrab;
    public static final int NotifyUngrab;
    public static final int NotifyWhileGrabbed;
    public static final int NotifyHint;
    public static final int NotifyAncestor;
    public static final int NotifyVirtual;
    public static final int NotifyInferior;
    public static final int NotifyNonlinear;
    public static final int NotifyNonlinearVirtual;
    public static final int NotifyPointer;
    public static final int NotifyPointerRoot;
    public static final int NotifyDetailNone;
    public static final int VisibilityUnobscured;
    public static final int VisibilityPartiallyObscured;
    public static final int VisibilityFullyObscured;
    public static final int PlaceOnTop;
    public static final int PlaceOnBottom;
    public static final int PropertyNewValue;
    public static final int PropertyDelete;
    public static final int ColormapUninstalled;
    public static final int ColormapInstalled;
    public static final int GrabModeSync;
    public static final int GrabModeAsync;
    public static final int GrabSuccess;
    public static final int AlreadyGrabbed;
    public static final int GrabInvalidTime;
    public static final int GrabNotViewable;
    public static final int GrabFrozen;
    public static final int AsyncPointer;
    public static final int SyncPointer;
    public static final int ReplayPointer;
    public static final int AsyncKeyboard;
    public static final int SyncKeyboard;
    public static final int ReplayKeyboard;
    public static final int AsyncBoth;
    public static final int SyncBoth;
    public static final int AllocNone;
    public static final int AllocAll;
    public static final int RevertToNone;
    public static final int RevertToPointerRoot;
    public static final int RevertToParent;
    public static final int InputOutput;
    public static final int InputOnly;
    public static final int DontPreferBlanking;
    public static final int PreferBlanking;
    public static final int DefaultBlanking;
    public static final int DisableScreenSaver;
    public static final int DisableScreenInterval;
    public static final int DontAllowExposures;
    public static final int AllowExposures;
    public static final int DefaultExposures;
    public static final int ScreenSaverReset;
    public static final int ScreenSaverActive;
    public static final int PropModeReplace;
    public static final int PropModePrepend;
    public static final int PropModeAppend;
    public static final int GXclear;
    public static final int GXand;
    public static final int GXandReverse;
    public static final int GXcopy;
    public static final int GXandInverted;
    public static final int GXnoop;
    public static final int GXxor;
    public static final int GXor;
    public static final int GXnor;
    public static final int GXequiv;
    public static final int GXinvert;
    public static final int GXorReverse;
    public static final int GXcopyInverted;
    public static final int GXorInverted;
    public static final int GXnand;
    public static final int GXset;
    public static final int LineSolid;
    public static final int LineOnOffDash;
    public static final int LineDoubleDash;
    public static final int CapNotLast;
    public static final int CapButt;
    public static final int CapRound;
    public static final int CapProjecting;
    public static final int JoinMiter;
    public static final int JoinRound;
    public static final int JoinBevel;
    public static final int FillSolid;
    public static final int FillTiled;
    public static final int FillStippled;
    public static final int FillOpaqueStippled;
    public static final int EvenOddRule;
    public static final int WindingRule;
    public static final int ClipByChildren;
    public static final int IncludeInferiors;
    public static final int Unsorted;
    public static final int YSorted;
    public static final int YXSorted;
    public static final int YXBanded;
    public static final int CoordModeOrigin;
    public static final int CoordModePrevious;
    public static final int Complex;
    public static final int Nonconvex;
    public static final int Convex;
    public static final int ArcChord;
    public static final int ArcPieSlice;
    public static final int GCFunction;
    public static final int GCPlaneMask;
    public static final int GCForeground;
    public static final int GCBackground;
    public static final int GCLineWidth;
    public static final int GCLineStyle;
    public static final int GCCapStyle;
    public static final int GCJoinStyle;
    public static final int GCFillStyle;
    public static final int GCFillRule;
    public static final int GCTile;
    public static final int GCStipple;
    public static final int GCTileStipXOrigin;
    public static final int GCTileStipYOrigin;
    public static final int GCFont;
    public static final int GCSubwindowMode;
    public static final int GCGraphicsExposures;
    public static final int GCClipXOrigin;
    public static final int GCClipYOrigin;
    public static final int GCClipMask;
    public static final int GCDashOffset;
    public static final int GCDashList;
    public static final int GCArcMode;
    public static final int GCLastBit;
    public static final int Above;
    public static final int Below;
    public static final int TopIf;
    public static final int BottomIf;
    public static final int Opposite;
    public static final int MappingModifier;
    public static final int MappingKeyboard;
    public static final int MappingPointer;

    public static SharedLibrary getLibrary() {
        return X11;
    }

    protected X11() {
        throw new UnsupportedOperationException();
    }

    public static long nXOpenDisplay(long param0) {
        long v2 = Functions.XOpenDisplay;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="Display *")
    public static long XOpenDisplay(@Nullable @NativeType(value="char const *") ByteBuffer param0) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(param0);
        }
        return org.lwjgl.system.linux.X11.nXOpenDisplay(MemoryUtil.memAddressSafe(param0));
    }

    @NativeType(value="Display *")
    public static long XOpenDisplay(@Nullable @NativeType(value="char const *") CharSequence param0) {
        MemoryStack v1 = MemoryStack.stackGet();
        int v2 = v1.getPointer();
        try {
            v1.nASCIISafe(param0, true);
            long v3 = param0 == null ? 0L : v1.getPointerAddress();
            long v5 = org.lwjgl.system.linux.X11.nXOpenDisplay(v3);
            return v5;
        }
        finally {
            v1.setPointer(v2);
        }
    }

    public static void XCloseDisplay(@NativeType(value="Display *") long param0) {
        long v2 = Functions.XCloseDisplay;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    public static int XDefaultScreen(@NativeType(value="Display *") long param0) {
        long v2 = Functions.XDefaultScreen;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePI(param0, v2);
    }

    @NativeType(value="Window")
    public static long XRootWindow(@NativeType(value="Display *") long param0, int param2) {
        long v3 = Functions.XRootWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePN(param0, param2, v3);
    }

    public static long nXCreateColormap(long param0, long param2, long param4, int param6) {
        long v7 = Functions.XCreateColormap;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNPN(param0, param2, param4, param6, v7);
    }

    @NativeType(value="Colormap")
    public static long XCreateColormap(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, @NativeType(value="Visual *") Visual param4, int param5) {
        return org.lwjgl.system.linux.X11.nXCreateColormap(param0, param2, param4.address(), param5);
    }

    public static int XFreeColormap(@NativeType(value="Display *") long param0, @NativeType(value="Colormap") long param2) {
        long v4 = Functions.XFreeColormap;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNI(param0, param2, v4);
    }

    public static long nXCreateWindow(long param0, long param2, int param4, int param5, int param6, int param7, int param8, int param9, int param10, long param11, long param13, long param15) {
        long v17 = Functions.XCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNPNPN(param0, param2, param4, param5, param6, param7, param8, param9, param10, param11, param13, param15, v17);
    }

    @NativeType(value="Window")
    public static long XCreateWindow(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, int param4, int param5, @NativeType(value="unsigned int") int param6, @NativeType(value="unsigned int") int param7, @NativeType(value="unsigned int") int param8, int param9, @NativeType(value="unsigned int") int param10, @NativeType(value="Visual *") Visual param11, @NativeType(value="unsigned long") long param12, @NativeType(value="XSetWindowAttributes *") XSetWindowAttributes param14) {
        return org.lwjgl.system.linux.X11.nXCreateWindow(param0, param2, param4, param5, param6, param7, param8, param9, param10, param11.address(), param12, param14.address());
    }

    public static int XDestroyWindow(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2) {
        long v4 = Functions.XDestroyWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNI(param0, param2, v4);
    }

    public static int nXFree(long param0) {
        long v2 = Functions.XFree;
        return JNI.invokePI(param0, v2);
    }

    public static int XFree(@NativeType(value="void *") ByteBuffer param0) {
        return org.lwjgl.system.linux.X11.nXFree(MemoryUtil.memAddress(param0));
    }

    public static int XFree(@NativeType(value="void *") PointerBuffer param0) {
        return org.lwjgl.system.linux.X11.nXFree(MemoryUtil.memAddress(param0));
    }

    public static int nXSendEvent(long param0, long param2, int param4, long param5, long param7) {
        long v9 = Functions.XSendEvent;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNNPI(param0, param2, param4, param5, param7, v9);
    }

    @NativeType(value="Status")
    public static int XSendEvent(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, @NativeType(value="Bool") boolean param4, long param5, @NativeType(value="XEvent *") XEvent param7) {
        return org.lwjgl.system.linux.X11.nXSendEvent(param0, param2, param4 ? 1 : 0, param5, param7.address());
    }

    @NativeType(value="unsigned long")
    public static long XDisplayMotionBufferSize(@NativeType(value="Display *") long param0) {
        long v2 = Functions.XDisplayMotionBufferSize;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePN(param0, v2);
    }

    public static long nXGetMotionEvents(long param0, long param2, long param4, long param6, long param8) {
        long v10 = Functions.XGetMotionEvents;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNNNPP(param0, param2, param4, param6, param8, v10);
    }

    @Nullable
    @NativeType(value="XTimeCoord *")
    public static XTimeCoord.Buffer XGetMotionEvents(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, @NativeType(value="Time") long param4, @NativeType(value="Time") long param6) {
        MemoryStack v8 = MemoryStack.stackGet();
        int v9 = v8.getPointer();
        IntBuffer v10 = v8.callocInt(1);
        try {
            long v11 = org.lwjgl.system.linux.X11.nXGetMotionEvents(param0, param2, param4, param6, MemoryUtil.memAddress(v10));
            XTimeCoord.Buffer v13 = XTimeCoord.createSafe(v11, v10.get(0));
            return v13;
        }
        finally {
            v8.setPointer(v9);
        }
    }

    public static int nXTranslateCoordinates(long param0, long param2, long param4, int param6, int param7, long param8, long param10, long param12) {
        long v14 = Functions.XTranslateCoordinates;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePNNPPPI(param0, param2, param4, param6, param7, param8, param10, param12, v14);
    }

    @NativeType(value="Bool")
    public static boolean XTranslateCoordinates(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, @NativeType(value="Window") long param4, int param6, int param7, @NativeType(value="int *") IntBuffer param8, @NativeType(value="int *") IntBuffer param9, @NativeType(value="Window *") CLongBuffer param10) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param8, 1);
            Checks.check((Buffer)param9, 1);
            Checks.check(param10, 1);
        }
        return org.lwjgl.system.linux.X11.nXTranslateCoordinates(param0, param2, param4, param6, param7, MemoryUtil.memAddress(param8), MemoryUtil.memAddress(param9), MemoryUtil.memAddress(param10)) != 0;
    }

    @NativeType(value="Bool")
    public static boolean XTranslateCoordinates(@NativeType(value="Display *") long param0, @NativeType(value="Window") long param2, @NativeType(value="Window") long param4, int param6, int param7, @NativeType(value="int *") int[] param8, @NativeType(value="int *") int[] param9, @NativeType(value="Window *") CLongBuffer param10) {
        long v11 = Functions.XTranslateCoordinates;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param8, 1);
            Checks.check(param9, 1);
            Checks.check(param10, 1);
        }
        return JNI.invokePNNPPPI(param0, param2, param4, param6, param7, param8, param9, MemoryUtil.memAddress(param10), v11) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return X11;
    }

    static {
        MappingPointer = 2;
        MappingKeyboard = 1;
        MappingModifier = 0;
        Opposite = 4;
        BottomIf = 3;
        TopIf = 2;
        Below = 1;
        Above = 0;
        GCLastBit = 22;
        GCArcMode = 0x400000;
        GCDashList = 0x200000;
        GCDashOffset = 0x100000;
        GCClipMask = 524288;
        GCClipYOrigin = 262144;
        GCClipXOrigin = 131072;
        GCGraphicsExposures = 65536;
        GCSubwindowMode = 32768;
        GCFont = 16384;
        GCTileStipYOrigin = 8192;
        GCTileStipXOrigin = 4096;
        GCStipple = 2048;
        GCTile = 1024;
        GCFillRule = 512;
        GCFillStyle = 256;
        GCJoinStyle = 128;
        GCCapStyle = 64;
        GCLineStyle = 32;
        GCLineWidth = 16;
        GCBackground = 8;
        GCForeground = 4;
        GCPlaneMask = 2;
        GCFunction = 1;
        ArcPieSlice = 1;
        ArcChord = 0;
        Convex = 2;
        Nonconvex = 1;
        Complex = 0;
        CoordModePrevious = 1;
        CoordModeOrigin = 0;
        YXBanded = 3;
        YXSorted = 2;
        YSorted = 1;
        Unsorted = 0;
        IncludeInferiors = 1;
        ClipByChildren = 0;
        WindingRule = 1;
        EvenOddRule = 0;
        FillOpaqueStippled = 3;
        FillStippled = 2;
        FillTiled = 1;
        FillSolid = 0;
        JoinBevel = 2;
        JoinRound = 1;
        JoinMiter = 0;
        CapProjecting = 3;
        CapRound = 2;
        CapButt = 1;
        CapNotLast = 0;
        LineDoubleDash = 2;
        LineOnOffDash = 1;
        LineSolid = 0;
        GXset = 15;
        GXnand = 14;
        GXorInverted = 13;
        GXcopyInverted = 12;
        GXorReverse = 11;
        GXinvert = 10;
        GXequiv = 9;
        GXnor = 8;
        GXor = 7;
        GXxor = 6;
        GXnoop = 5;
        GXandInverted = 4;
        GXcopy = 3;
        GXandReverse = 2;
        GXand = 1;
        GXclear = 0;
        PropModeAppend = 2;
        PropModePrepend = 1;
        PropModeReplace = 0;
        ScreenSaverActive = 1;
        ScreenSaverReset = 0;
        DefaultExposures = 2;
        AllowExposures = 1;
        DontAllowExposures = 0;
        DisableScreenInterval = 0;
        DisableScreenSaver = 0;
        DefaultBlanking = 2;
        PreferBlanking = 1;
        DontPreferBlanking = 0;
        InputOnly = 2;
        InputOutput = 1;
        RevertToParent = 2;
        RevertToPointerRoot = 1;
        RevertToNone = 0;
        AllocAll = 1;
        AllocNone = 0;
        SyncBoth = 7;
        AsyncBoth = 6;
        ReplayKeyboard = 5;
        SyncKeyboard = 4;
        AsyncKeyboard = 3;
        ReplayPointer = 2;
        SyncPointer = 1;
        AsyncPointer = 0;
        GrabFrozen = 4;
        GrabNotViewable = 3;
        GrabInvalidTime = 2;
        AlreadyGrabbed = 1;
        GrabSuccess = 0;
        GrabModeAsync = 1;
        GrabModeSync = 0;
        ColormapInstalled = 1;
        ColormapUninstalled = 0;
        PropertyDelete = 1;
        PropertyNewValue = 0;
        PlaceOnBottom = 1;
        PlaceOnTop = 0;
        VisibilityFullyObscured = 2;
        VisibilityPartiallyObscured = 1;
        VisibilityUnobscured = 0;
        NotifyDetailNone = 7;
        NotifyPointerRoot = 6;
        NotifyPointer = 5;
        NotifyNonlinearVirtual = 4;
        NotifyNonlinear = 3;
        NotifyInferior = 2;
        NotifyVirtual = 1;
        NotifyAncestor = 0;
        NotifyHint = 1;
        NotifyWhileGrabbed = 3;
        NotifyUngrab = 2;
        NotifyGrab = 1;
        NotifyNormal = 0;
        Button5 = 5;
        Button4 = 4;
        Button3 = 3;
        Button2 = 2;
        Button1 = 1;
        AnyModifier = 32768;
        Button5Mask = 4096;
        Button4Mask = 2048;
        Button3Mask = 1024;
        Button2Mask = 512;
        Button1Mask = 256;
        Mod5MapIndex = 7;
        Mod4MapIndex = 6;
        Mod3MapIndex = 5;
        Mod2MapIndex = 4;
        Mod1MapIndex = 3;
        ControlMapIndex = 2;
        LockMapIndex = 1;
        ShiftMapIndex = 0;
        Mod5Mask = 128;
        Mod4Mask = 64;
        Mod3Mask = 32;
        Mod2Mask = 16;
        Mod1Mask = 8;
        ControlMask = 4;
        LockMask = 2;
        ShiftMask = 1;
        LASTEvent = 36;
        GenericEvent = 35;
        MappingNotify = 34;
        ClientMessage = 33;
        ColormapNotify = 32;
        SelectionNotify = 31;
        SelectionRequest = 30;
        SelectionClear = 29;
        PropertyNotify = 28;
        CirculateRequest = 27;
        CirculateNotify = 26;
        ResizeRequest = 25;
        GravityNotify = 24;
        ConfigureRequest = 23;
        ConfigureNotify = 22;
        ReparentNotify = 21;
        MapRequest = 20;
        MapNotify = 19;
        UnmapNotify = 18;
        DestroyNotify = 17;
        CreateNotify = 16;
        VisibilityNotify = 15;
        NoExpose = 14;
        GraphicsExpose = 13;
        Expose = 12;
        KeymapNotify = 11;
        FocusOut = 10;
        FocusIn = 9;
        LeaveNotify = 8;
        EnterNotify = 7;
        MotionNotify = 6;
        ButtonRelease = 5;
        ButtonPress = 4;
        KeyRelease = 3;
        KeyPress = 2;
        OwnerGrabButtonMask = 0x1000000;
        ColormapChangeMask = 0x800000;
        PropertyChangeMask = 0x400000;
        FocusChangeMask = 0x200000;
        SubstructureRedirectMask = 0x100000;
        SubstructureNotifyMask = 524288;
        ResizeRedirectMask = 262144;
        StructureNotifyMask = 131072;
        VisibilityChangeMask = 65536;
        ExposureMask = 32768;
        KeymapStateMask = 16384;
        ButtonMotionMask = 8192;
        Button5MotionMask = 4096;
        Button4MotionMask = 2048;
        Button3MotionMask = 1024;
        Button2MotionMask = 512;
        Button1MotionMask = 256;
        PointerMotionHintMask = 128;
        PointerMotionMask = 64;
        LeaveWindowMask = 32;
        EnterWindowMask = 16;
        ButtonReleaseMask = 8;
        ButtonPressMask = 4;
        KeyReleaseMask = 2;
        KeyPressMask = 1;
        NoEventMask = 0;
        CWCursor = 16384;
        CWColormap = 8192;
        CWDontPropagate = 4096;
        CWEventMask = 2048;
        CWSaveUnder = 1024;
        CWOverrideRedirect = 512;
        CWBackingPixel = 256;
        CWBackingPlanes = 128;
        CWBackingStore = 64;
        CWWinGravity = 32;
        CWBitGravity = 16;
        CWBorderPixel = 8;
        CWBorderPixmap = 4;
        CWBackPixel = 2;
        CWBackPixmap = 1;
        LastExtensionError = 255;
        FirstExtensionError = 128;
        BadImplementation = 17;
        BadLength = 16;
        BadName = 15;
        BadIDChoice = 14;
        BadGC = 13;
        BadColor = 12;
        BadAlloc = 11;
        BadAccess = 10;
        BadDrawable = 9;
        BadMatch = 8;
        BadFont = 7;
        BadCursor = 6;
        BadAtom = 5;
        BadPixmap = 4;
        BadWindow = 3;
        BadValue = 2;
        BadRequest = 1;
        Success = 0;
        NoSymbol = 0;
        CurrentTime = 0;
        AllTemporary = 0;
        AnyButton = 0;
        AnyKey = 0;
        AnyPropertyType = 0;
        PointerRoot = 1;
        InputFocus = 1;
        PointerWindow = 0;
        CopyFromParent = 0;
        ParentRelative = 1;
        None = 0;
        False = 0;
        True = 1;
        X11 = Library.loadNative(X11.class, "org.lwjgl", null, "libX11.so.6", "libX11.so");
    }

    public static final class Functions {
        public static final long XOpenDisplay = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XOpenDisplay");
        public static final long XCloseDisplay = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCloseDisplay");
        public static final long XDefaultScreen = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDefaultScreen");
        public static final long XRootWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XRootWindow");
        public static final long XCreateColormap = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCreateColormap");
        public static final long XFreeColormap = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XFreeColormap");
        public static final long XCreateWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XCreateWindow");
        public static final long XDestroyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDestroyWindow");
        public static final long XFree = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XFree");
        public static final long XSendEvent = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XSendEvent");
        public static final long XDisplayMotionBufferSize = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XDisplayMotionBufferSize");
        public static final long XGetMotionEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XGetMotionEvents");
        public static final long XTranslateCoordinates = APIUtil.apiGetFunctionAddress(org.lwjgl.system.linux.X11.access$000(), "XTranslateCoordinates");

        private Functions() {
        }
    }
}

