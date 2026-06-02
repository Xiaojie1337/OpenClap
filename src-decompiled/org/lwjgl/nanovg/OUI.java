/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.UIHandler;
import org.lwjgl.nanovg.UIHandlerI;
import org.lwjgl.nanovg.UIRect;
import org.lwjgl.nanovg.UIVec2;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class OUI {
    public static final int UI_USERMASK;
    public static final int UI_ANY;
    public static final int UI_COLD;
    public static final int UI_HOT;
    public static final int UI_ACTIVE;
    public static final int UI_FROZEN;
    public static final int UI_ROW;
    public static final int UI_COLUMN;
    public static final int UI_LAYOUT;
    public static final int UI_FLEX;
    public static final int UI_NOWRAP;
    public static final int UI_WRAP;
    public static final int UI_START;
    public static final int UI_MIDDLE;
    public static final int UI_END;
    public static final int UI_JUSTIFY;
    public static final int UI_LEFT;
    public static final int UI_TOP;
    public static final int UI_RIGHT;
    public static final int UI_DOWN;
    public static final int UI_HFILL;
    public static final int UI_VFILL;
    public static final int UI_HCENTER;
    public static final int UI_VCENTER;
    public static final int UI_CENTER;
    public static final int UI_FILL;
    public static final int UI_BREAK;
    public static final int UI_BUTTON0_DOWN;
    public static final int UI_BUTTON0_UP;
    public static final int UI_BUTTON0_HOT_UP;
    public static final int UI_BUTTON0_CAPTURE;
    public static final int UI_BUTTON2_DOWN;
    public static final int UI_SCROLL;
    public static final int UI_KEY_DOWN;
    public static final int UI_KEY_UP;
    public static final int UI_CHAR;

    protected OUI() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="UIcontext *")
    public static native long uiCreateContext(@NativeType(value="unsigned int") int var0, @NativeType(value="unsigned int") int var1);

    public static native void uiMakeCurrent(@NativeType(value="UIcontext *") long var0);

    public static native void nuiDestroyContext(long var0);

    public static void uiDestroyContext(@NativeType(value="UIcontext *") long param0) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        OUI.nuiDestroyContext(param0);
    }

    @NativeType(value="UIcontext *")
    public static native long uiGetContext();

    public static native void uiSetCursor(int var0, int var1);

    public static native void nuiGetCursor(long var0);

    @NativeType(value="UIvec2")
    public static UIVec2 uiGetCursor(@NativeType(value="UIvec2") UIVec2 param0) {
        OUI.nuiGetCursor(param0.address());
        return param0;
    }

    public static native void nuiGetCursorDelta(long var0);

    @NativeType(value="UIvec2")
    public static UIVec2 uiGetCursorDelta(@NativeType(value="UIvec2") UIVec2 param0) {
        OUI.nuiGetCursorDelta(param0.address());
        return param0;
    }

    public static native void nuiGetCursorStart(long var0);

    @NativeType(value="UIvec2")
    public static UIVec2 uiGetCursorStart(@NativeType(value="UIvec2") UIVec2 param0) {
        OUI.nuiGetCursorStart(param0.address());
        return param0;
    }

    public static native void nuiGetCursorStartDelta(long var0);

    @NativeType(value="UIvec2")
    public static UIVec2 uiGetCursorStartDelta(@NativeType(value="UIvec2") UIVec2 param0) {
        OUI.nuiGetCursorStartDelta(param0.address());
        return param0;
    }

    public static native void nuiSetButton(int var0, int var1, int var2);

    public static void uiSetButton(@NativeType(value="unsigned int") int param0, @NativeType(value="unsigned int") int param1, @NativeType(value="int") boolean param2) {
        OUI.nuiSetButton(param0, param1, param2 ? 1 : 0);
    }

    public static native int nuiGetButton(int var0);

    @NativeType(value="int")
    public static boolean uiGetButton(@NativeType(value="unsigned int") int param0) {
        return OUI.nuiGetButton(param0) != 0;
    }

    public static native int uiGetClicks();

    public static native void nuiSetKey(int var0, int var1, int var2);

    public static void uiSetKey(@NativeType(value="unsigned int") int param0, @NativeType(value="unsigned int") int param1, @NativeType(value="int") boolean param2) {
        OUI.nuiSetKey(param0, param1, param2 ? 1 : 0);
    }

    public static native void uiSetChar(@NativeType(value="unsigned int") int var0);

    public static native void uiSetScroll(int var0, int var1);

    public static native void nuiGetScroll(long var0);

    @NativeType(value="UIvec2")
    public static UIVec2 uiGetScroll(@NativeType(value="UIvec2") UIVec2 param0) {
        OUI.nuiGetScroll(param0.address());
        return param0;
    }

    public static native void uiBeginLayout();

    public static native void uiEndLayout();

    public static native void uiUpdateHotItem();

    public static native void uiProcess(int var0);

    public static native void uiClearState();

    public static native int uiItem();

    public static native void nuiSetFrozen(int var0, int var1);

    public static void uiSetFrozen(int param0, @NativeType(value="int") boolean param1) {
        OUI.nuiSetFrozen(param0, param1 ? 1 : 0);
    }

    public static native void uiSetHandle(int var0, @NativeType(value="void *") long var1);

    public static native long nuiAllocHandle(int var0, int var1);

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer uiAllocHandle(int param0, @NativeType(value="unsigned int") int param1) {
        long v2 = OUI.nuiAllocHandle(param0, param1);
        return MemoryUtil.memByteBufferSafe(v2, param1);
    }

    public static native void nuiSetHandler(long var0);

    public static void uiSetHandler(@NativeType(value="UIhandler") UIHandlerI param0) {
        OUI.nuiSetHandler(param0.address());
    }

    public static native void uiSetEvents(int var0, @NativeType(value="unsigned int") int var1);

    public static native void uiSetFlags(int var0, @NativeType(value="unsigned int") int var1);

    public static native int uiInsert(int var0, int var1);

    public static native int uiAppend(int var0, int var1);

    public static native int uiInsertBack(int var0, int var1);

    public static native int uiInsertFront(int var0, int var1);

    public static native void uiSetSize(int var0, int var1, int var2);

    public static native void uiSetLayout(int var0, @NativeType(value="unsigned int") int var1);

    public static native void uiSetBox(int var0, @NativeType(value="unsigned int") int var1);

    public static native void nuiSetMargins(int var0, short var1, short var2, short var3, short var4);

    public static void uiSetMargins(int param0, @NativeType(value="short") int param1, @NativeType(value="short") int param2, @NativeType(value="short") int param3, @NativeType(value="short") int param4) {
        OUI.nuiSetMargins(param0, (short)param1, (short)param2, (short)param3, (short)param4);
    }

    public static native void uiFocus(int var0);

    public static native int uiFirstChild(int var0);

    public static native int uiNextSibling(int var0);

    public static native int uiGetItemCount();

    @NativeType(value="unsigned int")
    public static native int uiGetAllocSize();

    @NativeType(value="UIitemState")
    public static native int uiGetState(int var0);

    @NativeType(value="void *")
    public static native long uiGetHandle(int var0);

    public static native int uiGetHotItem();

    public static native int uiGetFocusedItem();

    public static native int uiFindItem(int var0, int var1, int var2, @NativeType(value="unsigned int") int var3, @NativeType(value="unsigned int") int var4);

    public static native long nuiGetHandler();

    @Nullable
    @NativeType(value="UIhandler")
    public static UIHandler uiGetHandler() {
        return UIHandler.createSafe(OUI.nuiGetHandler());
    }

    @NativeType(value="unsigned int")
    public static native int uiGetEvents(int var0);

    @NativeType(value="unsigned int")
    public static native int uiGetFlags(int var0);

    @NativeType(value="unsigned int")
    public static native int uiGetKey();

    @NativeType(value="unsigned int")
    public static native int uiGetModifier();

    public static native void nuiGetRect(int var0, long var1);

    @NativeType(value="UIrect")
    public static UIRect uiGetRect(int param0, @NativeType(value="UIrect") UIRect param1) {
        OUI.nuiGetRect(param0, param1.address());
        return param1;
    }

    public static native int nuiContains(int var0, int var1, int var2);

    @NativeType(value="int")
    public static boolean uiContains(int param0, int param1, int param2) {
        return OUI.nuiContains(param0, param1, param2) != 0;
    }

    public static native int uiGetWidth(int var0);

    public static native int uiGetHeight(int var0);

    @NativeType(value="unsigned int")
    public static native int uiGetLayout(int var0);

    @NativeType(value="unsigned int")
    public static native int uiGetBox(int var0);

    public static native short uiGetMarginLeft(int var0);

    public static native short uiGetMarginTop(int var0);

    public static native short uiGetMarginRight(int var0);

    public static native short uiGetMarginDown(int var0);

    public static native int uiRecoverItem(int var0);

    public static native void uiRemapItem(int var0, int var1);

    public static native int uiGetLastItemCount();

    static {
        UI_CHAR = 262144;
        UI_KEY_UP = 131072;
        UI_KEY_DOWN = 65536;
        UI_SCROLL = 32768;
        UI_BUTTON2_DOWN = 16384;
        UI_BUTTON0_CAPTURE = 8192;
        UI_BUTTON0_HOT_UP = 4096;
        UI_BUTTON0_UP = 2048;
        UI_BUTTON0_DOWN = 1024;
        UI_BREAK = 512;
        UI_FILL = 480;
        UI_CENTER = 0;
        UI_VCENTER = 0;
        UI_HCENTER = 0;
        UI_VFILL = 320;
        UI_HFILL = 160;
        UI_DOWN = 256;
        UI_RIGHT = 128;
        UI_TOP = 64;
        UI_LEFT = 32;
        UI_JUSTIFY = 24;
        UI_END = 16;
        UI_MIDDLE = 0;
        UI_START = 8;
        UI_WRAP = 4;
        UI_NOWRAP = 0;
        UI_FLEX = 2;
        UI_LAYOUT = 0;
        UI_COLUMN = 3;
        UI_ROW = 2;
        UI_FROZEN = 3;
        UI_ACTIVE = 2;
        UI_HOT = 1;
        UI_COLD = 0;
        UI_ANY = -1;
        UI_USERMASK = -16777216;
        LibNanoVG.initialize();
    }
}

