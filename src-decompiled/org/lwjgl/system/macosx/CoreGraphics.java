/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.CGEventTapCallBackI;
import org.lwjgl.system.macosx.CGEventTapInformation;
import org.lwjgl.system.macosx.CGPoint;

public class CoreGraphics {
    private static final SharedLibrary COREGRAPHICS;
    public static final int kCGErrorSuccess;
    public static final int kCGErrorFailure;
    public static final int kCGErrorIllegalArgument;
    public static final int kCGErrorInvalidConnection;
    public static final int kCGErrorInvalidContext;
    public static final int kCGErrorCannotComplete;
    public static final int kCGErrorNotImplemented;
    public static final int kCGErrorRangeCheck;
    public static final int kCGErrorTypeCheck;
    public static final int kCGErrorInvalidOperation;
    public static final int kCGErrorNoneAvailable;
    public static final int kCGEventNull;
    public static final int kCGEventLeftMouseDown;
    public static final int kCGEventLeftMouseUp;
    public static final int kCGEventRightMouseDown;
    public static final int kCGEventRightMouseUp;
    public static final int kCGEventMouseMoved;
    public static final int kCGEventLeftMouseDragged;
    public static final int kCGEventRightMouseDragged;
    public static final int kCGEventKeyDown;
    public static final int kCGEventKeyUp;
    public static final int kCGEventFlagsChanged;
    public static final int kCGEventScrollWheel;
    public static final int kCGEventTabletPointer;
    public static final int kCGEventTabletProximity;
    public static final int kCGEventOtherMouseDown;
    public static final int kCGEventOtherMouseUp;
    public static final int kCGEventOtherMouseDragged;
    public static final int kCGEventTapDisabledByTimeout;
    public static final int kCGEventTapDisabledByUserInput;
    public static final int kCGMouseButtonLeft;
    public static final int kCGMouseButtonRight;
    public static final int kCGMouseButtonCenter;
    public static final int kCGHIDEventTap;
    public static final int kCGSessionEventTap;
    public static final int kCGAnnotatedSessionEventTap;
    public static final int kCGScrollEventUnitPixel;
    public static final int kCGScrollEventUnitLine;
    public static final int kCGMouseEventNumber;
    public static final int kCGMouseEventClickState;
    public static final int kCGMouseEventPressure;
    public static final int kCGMouseEventButtonNumber;
    public static final int kCGMouseEventDeltaX;
    public static final int kCGMouseEventDeltaY;
    public static final int kCGMouseEventInstantMouser;
    public static final int kCGMouseEventSubtype;
    public static final int kCGKeyboardEventAutorepeat;
    public static final int kCGKeyboardEventKeycode;
    public static final int kCGKeyboardEventKeyboardType;
    public static final int kCGScrollWheelEventDeltaAxis1;
    public static final int kCGScrollWheelEventDeltaAxis2;
    public static final int kCGScrollWheelEventDeltaAxis3;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis1;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis2;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis3;
    public static final int kCGScrollWheelEventPointDeltaAxis1;
    public static final int kCGScrollWheelEventPointDeltaAxis2;
    public static final int kCGScrollWheelEventPointDeltaAxis3;
    public static final int kCGScrollWheelEventScrollPhase;
    public static final int kCGScrollWheelEventScrollCount;
    public static final int kCGScrollWheelEventMomentumPhase;
    public static final int kCGScrollWheelEventInstantMouser;
    public static final int kCGTabletEventPointX;
    public static final int kCGTabletEventPointY;
    public static final int kCGTabletEventPointZ;
    public static final int kCGTabletEventPointButtons;
    public static final int kCGTabletEventPointPressure;
    public static final int kCGTabletEventTiltX;
    public static final int kCGTabletEventTiltY;
    public static final int kCGTabletEventRotation;
    public static final int kCGTabletEventTangentialPressure;
    public static final int kCGTabletEventDeviceID;
    public static final int kCGTabletEventVendor1;
    public static final int kCGTabletEventVendor2;
    public static final int kCGTabletEventVendor3;
    public static final int kCGTabletProximityEventVendorID;
    public static final int kCGTabletProximityEventTabletID;
    public static final int kCGTabletProximityEventPointerID;
    public static final int kCGTabletProximityEventDeviceID;
    public static final int kCGTabletProximityEventSystemTabletID;
    public static final int kCGTabletProximityEventVendorPointerType;
    public static final int kCGTabletProximityEventVendorPointerSerialNumber;
    public static final int kCGTabletProximityEventVendorUniqueID;
    public static final int kCGTabletProximityEventCapabilityMask;
    public static final int kCGTabletProximityEventPointerType;
    public static final int kCGTabletProximityEventEnterProximity;
    public static final int kCGEventTargetProcessSerialNumber;
    public static final int kCGEventTargetUnixProcessID;
    public static final int kCGEventSourceUnixProcessID;
    public static final int kCGEventSourceUserData;
    public static final int kCGEventSourceUserID;
    public static final int kCGEventSourceGroupID;
    public static final int kCGEventSourceStateID;
    public static final int kCGScrollWheelEventIsContinuous;
    public static final int kCGMouseEventWindowUnderMousePointer;
    public static final int kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent;
    public static final int kCGEventMouseSubtypeDefault;
    public static final int kCGEventMouseSubtypeTabletPoint;
    public static final int kCGEventMouseSubtypeTabletProximity;

    public static SharedLibrary getLibrary() {
        return COREGRAPHICS;
    }

    protected CoreGraphics() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CFTypeID")
    public static long CGEventGetTypeID() {
        long v0 = Functions.EventGetTypeID;
        return JNI.invokeJ(v0);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreate(@NativeType(value="CGEventSourceRef") long param0) {
        long v2 = Functions.EventCreate;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="CFDataRef")
    public static long CGEventCreateData(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="CGEventRef") long param2) {
        long v4 = Functions.EventCreateData;
        return JNI.invokePPP(param0, param2, v4);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateFromData(@NativeType(value="CFAllocatorRef") long param0, @NativeType(value="CFDataRef") long param2) {
        long v4 = Functions.EventCreateFromData;
        return JNI.invokePPP(param0, param2, v4);
    }

    public static native long nCGEventCreateMouseEvent(long var0, int var2, long var3, int var5, long var6);

    public static long nCGEventCreateMouseEvent(long param0, int param2, long param3, int param5) {
        long v6 = Functions.EventCreateMouseEvent;
        return CoreGraphics.nCGEventCreateMouseEvent(param0, param2, param3, param5, v6);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateMouseEvent(@NativeType(value="CGEventSourceRef") long param0, @NativeType(value="CGEventType") int param2, CGPoint param3, @NativeType(value="CGMouseButton") int param4) {
        return CoreGraphics.nCGEventCreateMouseEvent(param0, param2, param3.address(), param4);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateKeyboardEvent(@NativeType(value="CGEventSourceRef") long param0, @NativeType(value="CGKeyCode") short param2, @NativeType(value="bool") boolean param3) {
        long v4 = Functions.EventCreateKeyboardEvent;
        return JNI.invokePCP(param0, param2, param3, v4);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long param0, @NativeType(value="CGScrollEventUnit") int param2, @NativeType(value="uint32_t") int param3, @NativeType(value="int32_t") int param4) {
        long v5 = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(param0, param2, param3, param4, v5);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long param0, @NativeType(value="CGScrollEventUnit") int param2, @NativeType(value="int32_t") int param3) {
        long v4 = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(param0, param2, 1, param3, v4);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent2(@NativeType(value="CGEventSourceRef") long param0, @NativeType(value="CGScrollEventUnit") int param2, @NativeType(value="uint32_t") int param3, @NativeType(value="int32_t") int param4, @NativeType(value="int32_t") int param5, @NativeType(value="int32_t") int param6) {
        long v7 = Functions.EventCreateScrollWheelEvent2;
        if (Checks.CHECKS) {
            Checks.check(v7);
        }
        return JNI.invokePP(param0, param2, param3, param4, param5, param6, v7);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateCopy(@NativeType(value="CGEventRef") long param0) {
        long v2 = Functions.EventCreateCopy;
        return JNI.invokePP(param0, v2);
    }

    @NativeType(value="CGEventSourceRef")
    public static long CGEventCreateSourceFromEvent(@NativeType(value="CGEventRef") long param0) {
        long v2 = Functions.EventCreateSourceFromEvent;
        return JNI.invokePP(param0, v2);
    }

    public static void CGEventSetSource(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventSourceRef") long param2) {
        long v4 = Functions.EventSetSource;
        JNI.invokePPV(param0, param2, v4);
    }

    @NativeType(value="CGEventType")
    public static int CGEventGetType(@NativeType(value="CGEventRef") long param0) {
        long v2 = Functions.EventGetType;
        return JNI.invokePI(param0, v2);
    }

    public static void CGEventSetType(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventType") int param2) {
        long v3 = Functions.EventSetType;
        JNI.invokePV(param0, param2, v3);
    }

    @NativeType(value="CGEventTimestamp")
    public static long CGEventGetTimestamp(@NativeType(value="CGEventRef") long param0) {
        long v2 = Functions.EventGetTimestamp;
        return JNI.invokePJ(param0, v2);
    }

    public static void CGEventSetTimestamp(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventTimestamp") long param2) {
        long v4 = Functions.EventSetTimestamp;
        JNI.invokePJV(param0, param2, v4);
    }

    public static native void nCGEventGetLocation(long var0, long var2, long var4);

    public static void nCGEventGetLocation(long param0, long param2) {
        long v4 = Functions.EventGetLocation;
        CoreGraphics.nCGEventGetLocation(param0, v4, param2);
    }

    public static CGPoint CGEventGetLocation(@NativeType(value="CGEventRef") long param0, CGPoint param2) {
        CoreGraphics.nCGEventGetLocation(param0, param2.address());
        return param2;
    }

    public static native void nCGEventGetUnflippedLocation(long var0, long var2, long var4);

    public static void nCGEventGetUnflippedLocation(long param0, long param2) {
        long v4 = Functions.EventGetUnflippedLocation;
        CoreGraphics.nCGEventGetUnflippedLocation(param0, v4, param2);
    }

    public static CGPoint CGEventGetUnflippedLocation(@NativeType(value="CGEventRef") long param0, CGPoint param2) {
        CoreGraphics.nCGEventGetUnflippedLocation(param0, param2.address());
        return param2;
    }

    public static native void nCGEventSetLocation(long var0, long var2, long var4);

    public static void nCGEventSetLocation(long param0, long param2) {
        long v4 = Functions.EventSetLocation;
        CoreGraphics.nCGEventSetLocation(param0, param2, v4);
    }

    public static void CGEventSetLocation(@NativeType(value="CGEventRef") long param0, CGPoint param2) {
        CoreGraphics.nCGEventSetLocation(param0, param2.address());
    }

    @NativeType(value="CGEventFlags")
    public static long CGEventGetFlags(@NativeType(value="CGEventRef") long param0) {
        long v2 = Functions.EventGetFlags;
        return JNI.invokePJ(param0, v2);
    }

    public static void CGEventSetFlags(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventFlags") long param2) {
        long v4 = Functions.EventSetFlags;
        JNI.invokePJV(param0, param2, v4);
    }

    public static void nCGEventKeyboardGetUnicodeString(long param0, long param2, long param4, long param6) {
        long v8 = Functions.EventKeyboardGetUnicodeString;
        JNI.invokePNPPV(param0, param2, param4, param6, v8);
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long param0, @Nullable @NativeType(value="UniCharCount *") CLongBuffer param2, @Nullable @NativeType(value="UniChar *") ShortBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkSafe(param2, 1);
        }
        CoreGraphics.nCGEventKeyboardGetUnicodeString(param0, Checks.remainingSafe(param3), MemoryUtil.memAddressSafe(param2), MemoryUtil.memAddressSafe(param3));
    }

    public static void nCGEventKeyboardSetUnicodeString(long param0, long param2, long param4) {
        long v6 = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(param0, param2, param4, v6);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long param0, @NativeType(value="UniChar const *") ShortBuffer param2) {
        CoreGraphics.nCGEventKeyboardSetUnicodeString(param0, param2.remaining(), MemoryUtil.memAddress(param2));
    }

    @NativeType(value="int64_t")
    public static long CGEventGetIntegerValueField(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventField") int param2) {
        long v3 = Functions.EventGetIntegerValueField;
        return JNI.invokePJ(param0, param2, v3);
    }

    public static void CGEventSetIntegerValueField(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventField") int param2, @NativeType(value="int64_t") long param3) {
        long v5 = Functions.EventSetIntegerValueField;
        JNI.invokePJV(param0, param2, param3, v5);
    }

    public static double CGEventGetDoubleValueField(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventField") int param2) {
        long v3 = Functions.EventGetDoubleValueField;
        return JNI.invokePD(param0, param2, v3);
    }

    public static void CGEventSetDoubleValueField(@NativeType(value="CGEventRef") long param0, @NativeType(value="CGEventField") int param2, double param3) {
        long v5 = Functions.EventSetDoubleValueField;
        JNI.invokePV(param0, param2, param3, v5);
    }

    public static long nCGEventTapCreate(int param0, int param1, int param2, long param3, long param5, long param7) {
        long v9 = Functions.EventTapCreate;
        return JNI.invokeJPPP(param0, param1, param2, param3, param5, param7, v9);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreate(@NativeType(value="CGEventTapLocation") int param0, @NativeType(value="CGEventTapPlacement") int param1, @NativeType(value="CGEventTapOptions") int param2, @NativeType(value="CGEventMask") long param3, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI param5, @NativeType(value="void *") long param6) {
        return CoreGraphics.nCGEventTapCreate(param0, param1, param2, param3, param5.address(), param6);
    }

    public static long nCGEventTapCreateForPid(long param0, int param2, int param3, long param4, long param6, long param8) {
        long v10 = Functions.EventTapCreateForPid;
        if (Checks.CHECKS) {
            Checks.check(v10);
            Checks.check(param0);
        }
        return JNI.invokePJPPP(param0, param2, param3, param4, param6, param8, v10);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreateForPid(@NativeType(value="pid_t") long param0, @NativeType(value="CGEventTapPlacement") int param2, @NativeType(value="CGEventTapOptions") int param3, @NativeType(value="CGEventMask") long param4, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI param6, @NativeType(value="void *") long param7) {
        return CoreGraphics.nCGEventTapCreateForPid(param0, param2, param3, param4, param6.address(), param7);
    }

    public static void CGEventTapEnable(@NativeType(value="CFMachPortRef") long param0, @NativeType(value="bool") boolean param2) {
        long v3 = Functions.EventTapEnable;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, param2, v3);
    }

    @NativeType(value="bool")
    public static boolean CGEventTapIsEnabled(@NativeType(value="CFMachPortRef") long param0) {
        long v2 = Functions.EventTapIsEnabled;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePZ(param0, v2);
    }

    public static void CGEventTapPostEvent(@NativeType(value="CGEventTapProxy") long param0, @NativeType(value="CGEventRef") long param2) {
        long v4 = Functions.EventTapPostEvent;
        JNI.invokePPV(param0, param2, v4);
    }

    public static void CGEventPost(@NativeType(value="CGEventTapLocation") int param0, @NativeType(value="CGEventRef") long param1) {
        long v3 = Functions.EventPost;
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        JNI.invokePV(param0, param1, v3);
    }

    public static void CGEventPostToPid(@NativeType(value="pid_t") long param0, @NativeType(value="CGEventRef") long param2) {
        long v4 = Functions.EventPostToPid;
        if (Checks.CHECKS) {
            Checks.check(v4);
            Checks.check(param0);
        }
        JNI.invokePPV(param0, param2, v4);
    }

    public static int nCGGetEventTapList(int param0, long param1, long param3) {
        long v5 = Functions.GetEventTapList;
        return JNI.invokePPI(param0, param1, param3, v5);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@Nullable @NativeType(value="CGEventTapInformation *") CGEventTapInformation.Buffer param0, @Nullable @NativeType(value="uint32_t *") IntBuffer param1) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param1, 1);
        }
        return CoreGraphics.nCGGetEventTapList(Checks.remainingSafe(param0), MemoryUtil.memAddressSafe(param0), MemoryUtil.memAddressSafe(param1));
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long param0, @Nullable @NativeType(value="UniCharCount *") CLongBuffer param2, @Nullable @NativeType(value="UniChar *") short[] param3) {
        long v4 = Functions.EventKeyboardGetUnicodeString;
        if (Checks.CHECKS) {
            Checks.checkSafe(param2, 1);
        }
        JNI.invokePNPPV(param0, (long)Checks.lengthSafe(param3), MemoryUtil.memAddressSafe(param2), param3, v4);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long param0, @NativeType(value="UniChar const *") short[] param2) {
        long v3 = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(param0, (long)param2.length, param2, v3);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@Nullable @NativeType(value="CGEventTapInformation *") CGEventTapInformation.Buffer param0, @Nullable @NativeType(value="uint32_t *") int[] param1) {
        long v2 = Functions.GetEventTapList;
        if (Checks.CHECKS) {
            Checks.checkSafe(param1, 1);
        }
        return JNI.invokePPI(Checks.remainingSafe(param0), MemoryUtil.memAddressSafe(param0), param1, v2);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return COREGRAPHICS;
    }

    static {
        kCGEventMouseSubtypeTabletProximity = 2;
        kCGEventMouseSubtypeTabletPoint = 1;
        kCGEventMouseSubtypeDefault = 0;
        kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent = 92;
        kCGMouseEventWindowUnderMousePointer = 91;
        kCGScrollWheelEventIsContinuous = 88;
        kCGEventSourceStateID = 45;
        kCGEventSourceGroupID = 44;
        kCGEventSourceUserID = 43;
        kCGEventSourceUserData = 42;
        kCGEventSourceUnixProcessID = 41;
        kCGEventTargetUnixProcessID = 40;
        kCGEventTargetProcessSerialNumber = 39;
        kCGTabletProximityEventEnterProximity = 38;
        kCGTabletProximityEventPointerType = 37;
        kCGTabletProximityEventCapabilityMask = 36;
        kCGTabletProximityEventVendorUniqueID = 35;
        kCGTabletProximityEventVendorPointerSerialNumber = 34;
        kCGTabletProximityEventVendorPointerType = 33;
        kCGTabletProximityEventSystemTabletID = 32;
        kCGTabletProximityEventDeviceID = 31;
        kCGTabletProximityEventPointerID = 30;
        kCGTabletProximityEventTabletID = 29;
        kCGTabletProximityEventVendorID = 28;
        kCGTabletEventVendor3 = 27;
        kCGTabletEventVendor2 = 26;
        kCGTabletEventVendor1 = 25;
        kCGTabletEventDeviceID = 24;
        kCGTabletEventTangentialPressure = 23;
        kCGTabletEventRotation = 22;
        kCGTabletEventTiltY = 21;
        kCGTabletEventTiltX = 20;
        kCGTabletEventPointPressure = 19;
        kCGTabletEventPointButtons = 18;
        kCGTabletEventPointZ = 17;
        kCGTabletEventPointY = 16;
        kCGTabletEventPointX = 15;
        kCGScrollWheelEventInstantMouser = 14;
        kCGScrollWheelEventMomentumPhase = 123;
        kCGScrollWheelEventScrollCount = 100;
        kCGScrollWheelEventScrollPhase = 99;
        kCGScrollWheelEventPointDeltaAxis3 = 98;
        kCGScrollWheelEventPointDeltaAxis2 = 97;
        kCGScrollWheelEventPointDeltaAxis1 = 96;
        kCGScrollWheelEventFixedPtDeltaAxis3 = 95;
        kCGScrollWheelEventFixedPtDeltaAxis2 = 94;
        kCGScrollWheelEventFixedPtDeltaAxis1 = 93;
        kCGScrollWheelEventDeltaAxis3 = 13;
        kCGScrollWheelEventDeltaAxis2 = 12;
        kCGScrollWheelEventDeltaAxis1 = 11;
        kCGKeyboardEventKeyboardType = 10;
        kCGKeyboardEventKeycode = 9;
        kCGKeyboardEventAutorepeat = 8;
        kCGMouseEventSubtype = 7;
        kCGMouseEventInstantMouser = 6;
        kCGMouseEventDeltaY = 5;
        kCGMouseEventDeltaX = 4;
        kCGMouseEventButtonNumber = 3;
        kCGMouseEventPressure = 2;
        kCGMouseEventClickState = 1;
        kCGMouseEventNumber = 0;
        kCGScrollEventUnitLine = 1;
        kCGScrollEventUnitPixel = 0;
        kCGAnnotatedSessionEventTap = 2;
        kCGSessionEventTap = 1;
        kCGHIDEventTap = 0;
        kCGMouseButtonCenter = 2;
        kCGMouseButtonRight = 1;
        kCGMouseButtonLeft = 0;
        kCGEventTapDisabledByUserInput = -1;
        kCGEventTapDisabledByTimeout = -2;
        kCGEventOtherMouseDragged = 27;
        kCGEventOtherMouseUp = 26;
        kCGEventOtherMouseDown = 25;
        kCGEventTabletProximity = 24;
        kCGEventTabletPointer = 23;
        kCGEventScrollWheel = 22;
        kCGEventFlagsChanged = 12;
        kCGEventKeyUp = 11;
        kCGEventKeyDown = 10;
        kCGEventRightMouseDragged = 7;
        kCGEventLeftMouseDragged = 6;
        kCGEventMouseMoved = 5;
        kCGEventRightMouseUp = 4;
        kCGEventRightMouseDown = 3;
        kCGEventLeftMouseUp = 2;
        kCGEventLeftMouseDown = 1;
        kCGEventNull = 0;
        kCGErrorNoneAvailable = 1011;
        kCGErrorInvalidOperation = 1010;
        kCGErrorTypeCheck = 1008;
        kCGErrorRangeCheck = 1007;
        kCGErrorNotImplemented = 1006;
        kCGErrorCannotComplete = 1004;
        kCGErrorInvalidContext = 1003;
        kCGErrorInvalidConnection = 1002;
        kCGErrorIllegalArgument = 1001;
        kCGErrorFailure = 1000;
        kCGErrorSuccess = 0;
        COREGRAPHICS = Library.loadNative(CoreGraphics.class, "org.lwjgl", "/System/Library/Frameworks/CoreGraphics.framework");
    }

    public static final class Functions {
        public static final long EventGetTypeID = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTypeID");
        public static final long EventCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreate");
        public static final long EventCreateData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateData");
        public static final long EventCreateFromData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateFromData");
        public static final long EventCreateMouseEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateMouseEvent");
        public static final long EventCreateKeyboardEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateKeyboardEvent");
        public static final long EventCreateScrollWheelEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateScrollWheelEvent");
        public static final long EventCreateScrollWheelEvent2 = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventCreateScrollWheelEvent2");
        public static final long EventCreateCopy = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateCopy");
        public static final long EventCreateSourceFromEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateSourceFromEvent");
        public static final long EventSetSource = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetSource");
        public static final long EventGetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetType");
        public static final long EventSetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetType");
        public static final long EventGetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTimestamp");
        public static final long EventSetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetTimestamp");
        public static final long EventGetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetLocation");
        public static final long EventGetUnflippedLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetUnflippedLocation");
        public static final long EventSetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetLocation");
        public static final long EventGetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetFlags");
        public static final long EventSetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetFlags");
        public static final long EventKeyboardGetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardGetUnicodeString");
        public static final long EventKeyboardSetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardSetUnicodeString");
        public static final long EventGetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetIntegerValueField");
        public static final long EventSetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetIntegerValueField");
        public static final long EventGetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetDoubleValueField");
        public static final long EventSetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetDoubleValueField");
        public static final long EventTapCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapCreate");
        public static final long EventTapCreateForPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventTapCreateForPid");
        public static final long EventTapEnable = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapEnable");
        public static final long EventTapIsEnabled = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapIsEnabled");
        public static final long EventTapPostEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapPostEvent");
        public static final long EventPost = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventPost");
        public static final long EventPostToPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventPostToPid");
        public static final long GetEventTapList = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGGetEventTapList");

        private Functions() {
        }
    }
}

