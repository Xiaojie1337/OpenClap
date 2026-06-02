/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.XAnyEvent;
import org.lwjgl.system.linux.XButtonEvent;
import org.lwjgl.system.linux.XCirculateEvent;
import org.lwjgl.system.linux.XCirculateRequestEvent;
import org.lwjgl.system.linux.XClientMessageEvent;
import org.lwjgl.system.linux.XColormapEvent;
import org.lwjgl.system.linux.XConfigureEvent;
import org.lwjgl.system.linux.XConfigureRequestEvent;
import org.lwjgl.system.linux.XCreateWindowEvent;
import org.lwjgl.system.linux.XCrossingEvent;
import org.lwjgl.system.linux.XDestroyWindowEvent;
import org.lwjgl.system.linux.XErrorEvent;
import org.lwjgl.system.linux.XExposeEvent;
import org.lwjgl.system.linux.XFocusChangeEvent;
import org.lwjgl.system.linux.XGenericEvent;
import org.lwjgl.system.linux.XGenericEventCookie;
import org.lwjgl.system.linux.XGraphicsExposeEvent;
import org.lwjgl.system.linux.XGravityEvent;
import org.lwjgl.system.linux.XKeyEvent;
import org.lwjgl.system.linux.XKeymapEvent;
import org.lwjgl.system.linux.XMapEvent;
import org.lwjgl.system.linux.XMapRequestEvent;
import org.lwjgl.system.linux.XMappingEvent;
import org.lwjgl.system.linux.XMotionEvent;
import org.lwjgl.system.linux.XNoExposeEvent;
import org.lwjgl.system.linux.XPropertyEvent;
import org.lwjgl.system.linux.XReparentEvent;
import org.lwjgl.system.linux.XResizeRequestEvent;
import org.lwjgl.system.linux.XSelectionClearEvent;
import org.lwjgl.system.linux.XSelectionEvent;
import org.lwjgl.system.linux.XSelectionRequestEvent;
import org.lwjgl.system.linux.XUnmapEvent;
import org.lwjgl.system.linux.XVisibilityEvent;

public class XEvent
extends Struct<XEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int XANY;
    public static final int XKEY;
    public static final int XBUTTON;
    public static final int XMOTION;
    public static final int XCROSSING;
    public static final int XFOCUS;
    public static final int XEXPOSE;
    public static final int XGRAPHICSEXPOSE;
    public static final int XNOEXPOSE;
    public static final int XVISIBILITY;
    public static final int XCREATEWINDOW;
    public static final int XDESTROYWINDOW;
    public static final int XUNMAP;
    public static final int XMAP;
    public static final int XMAPREQUEST;
    public static final int XREPARENT;
    public static final int XCONFIGURE;
    public static final int XGRAVITY;
    public static final int XRESIZEREQUEST;
    public static final int XCONFIGUREREQUEST;
    public static final int XCIRCULATE;
    public static final int XCIRCULATEREQUEST;
    public static final int XPROPERTY;
    public static final int XSELECTIONCLEAR;
    public static final int XSELECTIONREQUEST;
    public static final int XSELECTION;
    public static final int XCOLORMAP;
    public static final int XCLIENT;
    public static final int XMAPPING;
    public static final int XERROR;
    public static final int XKEYMAP;
    public static final int XGENERIC;
    public static final int XCOOKIE;

    protected XEvent(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected XEvent create(long param1, @Nullable ByteBuffer param3) {
        return new XEvent(param1, param3);
    }

    public XEvent(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), XEvent.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XEvent.ntype(this.address());
    }

    public XAnyEvent xany() {
        return XEvent.nxany(this.address());
    }

    public XKeyEvent xkey() {
        return XEvent.nxkey(this.address());
    }

    public XButtonEvent xbutton() {
        return XEvent.nxbutton(this.address());
    }

    public XMotionEvent xmotion() {
        return XEvent.nxmotion(this.address());
    }

    public XCrossingEvent xcrossing() {
        return XEvent.nxcrossing(this.address());
    }

    public XFocusChangeEvent xfocus() {
        return XEvent.nxfocus(this.address());
    }

    public XExposeEvent xexpose() {
        return XEvent.nxexpose(this.address());
    }

    public XGraphicsExposeEvent xgraphicsexpose() {
        return XEvent.nxgraphicsexpose(this.address());
    }

    public XNoExposeEvent xnoexpose() {
        return XEvent.nxnoexpose(this.address());
    }

    public XVisibilityEvent xvisibility() {
        return XEvent.nxvisibility(this.address());
    }

    public XCreateWindowEvent xcreatewindow() {
        return XEvent.nxcreatewindow(this.address());
    }

    public XDestroyWindowEvent xdestroywindow() {
        return XEvent.nxdestroywindow(this.address());
    }

    public XUnmapEvent xunmap() {
        return XEvent.nxunmap(this.address());
    }

    public XMapEvent xmap() {
        return XEvent.nxmap(this.address());
    }

    public XMapRequestEvent xmaprequest() {
        return XEvent.nxmaprequest(this.address());
    }

    public XReparentEvent xreparent() {
        return XEvent.nxreparent(this.address());
    }

    public XConfigureEvent xconfigure() {
        return XEvent.nxconfigure(this.address());
    }

    public XGravityEvent xgravity() {
        return XEvent.nxgravity(this.address());
    }

    public XResizeRequestEvent xresizerequest() {
        return XEvent.nxresizerequest(this.address());
    }

    public XConfigureRequestEvent xconfigurerequest() {
        return XEvent.nxconfigurerequest(this.address());
    }

    public XCirculateEvent xcirculate() {
        return XEvent.nxcirculate(this.address());
    }

    public XCirculateRequestEvent xcirculaterequest() {
        return XEvent.nxcirculaterequest(this.address());
    }

    public XPropertyEvent xproperty() {
        return XEvent.nxproperty(this.address());
    }

    public XSelectionClearEvent xselectionclear() {
        return XEvent.nxselectionclear(this.address());
    }

    public XSelectionRequestEvent xselectionrequest() {
        return XEvent.nxselectionrequest(this.address());
    }

    public XSelectionEvent xselection() {
        return XEvent.nxselection(this.address());
    }

    public XColormapEvent xcolormap() {
        return XEvent.nxcolormap(this.address());
    }

    public XClientMessageEvent xclient() {
        return XEvent.nxclient(this.address());
    }

    public XMappingEvent xmapping() {
        return XEvent.nxmapping(this.address());
    }

    public XErrorEvent xerror() {
        return XEvent.nxerror(this.address());
    }

    public XKeymapEvent xkeymap() {
        return XEvent.nxkeymap(this.address());
    }

    public XGenericEvent xgeneric() {
        return XEvent.nxgeneric(this.address());
    }

    public XGenericEventCookie xcookie() {
        return XEvent.nxcookie(this.address());
    }

    public static XEvent malloc() {
        return new XEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XEvent calloc() {
        return new XEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XEvent create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new XEvent(MemoryUtil.memAddress(v0), v0);
    }

    public static XEvent create(long param0) {
        return new XEvent(param0, null);
    }

    @Nullable
    public static XEvent createSafe(long param0) {
        return param0 == 0L ? null : new XEvent(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XEvent.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = XEvent.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    @Deprecated
    public static XEvent mallocStack() {
        return XEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent callocStack() {
        return XEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent mallocStack(MemoryStack param0) {
        return XEvent.malloc(param0);
    }

    @Deprecated
    public static XEvent callocStack(MemoryStack param0) {
        return XEvent.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return XEvent.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return XEvent.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return XEvent.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return XEvent.calloc(param0, param1);
    }

    public static XEvent malloc(MemoryStack param0) {
        return new XEvent(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XEvent calloc(MemoryStack param0) {
        return new XEvent(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ntype(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TYPE);
    }

    public static XAnyEvent nxany(long param0) {
        return XAnyEvent.create(param0 + (long)XANY);
    }

    public static XKeyEvent nxkey(long param0) {
        return XKeyEvent.create(param0 + (long)XKEY);
    }

    public static XButtonEvent nxbutton(long param0) {
        return XButtonEvent.create(param0 + (long)XBUTTON);
    }

    public static XMotionEvent nxmotion(long param0) {
        return XMotionEvent.create(param0 + (long)XMOTION);
    }

    public static XCrossingEvent nxcrossing(long param0) {
        return XCrossingEvent.create(param0 + (long)XCROSSING);
    }

    public static XFocusChangeEvent nxfocus(long param0) {
        return XFocusChangeEvent.create(param0 + (long)XFOCUS);
    }

    public static XExposeEvent nxexpose(long param0) {
        return XExposeEvent.create(param0 + (long)XEXPOSE);
    }

    public static XGraphicsExposeEvent nxgraphicsexpose(long param0) {
        return XGraphicsExposeEvent.create(param0 + (long)XGRAPHICSEXPOSE);
    }

    public static XNoExposeEvent nxnoexpose(long param0) {
        return XNoExposeEvent.create(param0 + (long)XNOEXPOSE);
    }

    public static XVisibilityEvent nxvisibility(long param0) {
        return XVisibilityEvent.create(param0 + (long)XVISIBILITY);
    }

    public static XCreateWindowEvent nxcreatewindow(long param0) {
        return XCreateWindowEvent.create(param0 + (long)XCREATEWINDOW);
    }

    public static XDestroyWindowEvent nxdestroywindow(long param0) {
        return XDestroyWindowEvent.create(param0 + (long)XDESTROYWINDOW);
    }

    public static XUnmapEvent nxunmap(long param0) {
        return XUnmapEvent.create(param0 + (long)XUNMAP);
    }

    public static XMapEvent nxmap(long param0) {
        return XMapEvent.create(param0 + (long)XMAP);
    }

    public static XMapRequestEvent nxmaprequest(long param0) {
        return XMapRequestEvent.create(param0 + (long)XMAPREQUEST);
    }

    public static XReparentEvent nxreparent(long param0) {
        return XReparentEvent.create(param0 + (long)XREPARENT);
    }

    public static XConfigureEvent nxconfigure(long param0) {
        return XConfigureEvent.create(param0 + (long)XCONFIGURE);
    }

    public static XGravityEvent nxgravity(long param0) {
        return XGravityEvent.create(param0 + (long)XGRAVITY);
    }

    public static XResizeRequestEvent nxresizerequest(long param0) {
        return XResizeRequestEvent.create(param0 + (long)XRESIZEREQUEST);
    }

    public static XConfigureRequestEvent nxconfigurerequest(long param0) {
        return XConfigureRequestEvent.create(param0 + (long)XCONFIGUREREQUEST);
    }

    public static XCirculateEvent nxcirculate(long param0) {
        return XCirculateEvent.create(param0 + (long)XCIRCULATE);
    }

    public static XCirculateRequestEvent nxcirculaterequest(long param0) {
        return XCirculateRequestEvent.create(param0 + (long)XCIRCULATEREQUEST);
    }

    public static XPropertyEvent nxproperty(long param0) {
        return XPropertyEvent.create(param0 + (long)XPROPERTY);
    }

    public static XSelectionClearEvent nxselectionclear(long param0) {
        return XSelectionClearEvent.create(param0 + (long)XSELECTIONCLEAR);
    }

    public static XSelectionRequestEvent nxselectionrequest(long param0) {
        return XSelectionRequestEvent.create(param0 + (long)XSELECTIONREQUEST);
    }

    public static XSelectionEvent nxselection(long param0) {
        return XSelectionEvent.create(param0 + (long)XSELECTION);
    }

    public static XColormapEvent nxcolormap(long param0) {
        return XColormapEvent.create(param0 + (long)XCOLORMAP);
    }

    public static XClientMessageEvent nxclient(long param0) {
        return XClientMessageEvent.create(param0 + (long)XCLIENT);
    }

    public static XMappingEvent nxmapping(long param0) {
        return XMappingEvent.create(param0 + (long)XMAPPING);
    }

    public static XErrorEvent nxerror(long param0) {
        return XErrorEvent.create(param0 + (long)XERROR);
    }

    public static XKeymapEvent nxkeymap(long param0) {
        return XKeymapEvent.create(param0 + (long)XKEYMAP);
    }

    public static XGenericEvent nxgeneric(long param0) {
        return XGenericEvent.create(param0 + (long)XGENERIC);
    }

    public static XGenericEventCookie nxcookie(long param0) {
        return XGenericEventCookie.create(param0 + (long)XCOOKIE);
    }

    static {
        Struct.Layout v0 = XEvent.__union(XEvent.__member(4), XEvent.__member(XAnyEvent.SIZEOF, XAnyEvent.ALIGNOF), XEvent.__member(XKeyEvent.SIZEOF, XKeyEvent.ALIGNOF), XEvent.__member(XButtonEvent.SIZEOF, XButtonEvent.ALIGNOF), XEvent.__member(XMotionEvent.SIZEOF, XMotionEvent.ALIGNOF), XEvent.__member(XCrossingEvent.SIZEOF, XCrossingEvent.ALIGNOF), XEvent.__member(XFocusChangeEvent.SIZEOF, XFocusChangeEvent.ALIGNOF), XEvent.__member(XExposeEvent.SIZEOF, XExposeEvent.ALIGNOF), XEvent.__member(XGraphicsExposeEvent.SIZEOF, XGraphicsExposeEvent.ALIGNOF), XEvent.__member(XNoExposeEvent.SIZEOF, XNoExposeEvent.ALIGNOF), XEvent.__member(XVisibilityEvent.SIZEOF, XVisibilityEvent.ALIGNOF), XEvent.__member(XCreateWindowEvent.SIZEOF, XCreateWindowEvent.ALIGNOF), XEvent.__member(XDestroyWindowEvent.SIZEOF, XDestroyWindowEvent.ALIGNOF), XEvent.__member(XUnmapEvent.SIZEOF, XUnmapEvent.ALIGNOF), XEvent.__member(XMapEvent.SIZEOF, XMapEvent.ALIGNOF), XEvent.__member(XMapRequestEvent.SIZEOF, XMapRequestEvent.ALIGNOF), XEvent.__member(XReparentEvent.SIZEOF, XReparentEvent.ALIGNOF), XEvent.__member(XConfigureEvent.SIZEOF, XConfigureEvent.ALIGNOF), XEvent.__member(XGravityEvent.SIZEOF, XGravityEvent.ALIGNOF), XEvent.__member(XResizeRequestEvent.SIZEOF, XResizeRequestEvent.ALIGNOF), XEvent.__member(XConfigureRequestEvent.SIZEOF, XConfigureRequestEvent.ALIGNOF), XEvent.__member(XCirculateEvent.SIZEOF, XCirculateEvent.ALIGNOF), XEvent.__member(XCirculateRequestEvent.SIZEOF, XCirculateRequestEvent.ALIGNOF), XEvent.__member(XPropertyEvent.SIZEOF, XPropertyEvent.ALIGNOF), XEvent.__member(XSelectionClearEvent.SIZEOF, XSelectionClearEvent.ALIGNOF), XEvent.__member(XSelectionRequestEvent.SIZEOF, XSelectionRequestEvent.ALIGNOF), XEvent.__member(XSelectionEvent.SIZEOF, XSelectionEvent.ALIGNOF), XEvent.__member(XColormapEvent.SIZEOF, XColormapEvent.ALIGNOF), XEvent.__member(XClientMessageEvent.SIZEOF, XClientMessageEvent.ALIGNOF), XEvent.__member(XMappingEvent.SIZEOF, XMappingEvent.ALIGNOF), XEvent.__member(XErrorEvent.SIZEOF, XErrorEvent.ALIGNOF), XEvent.__member(XKeymapEvent.SIZEOF, XKeymapEvent.ALIGNOF), XEvent.__member(XGenericEvent.SIZEOF, XGenericEvent.ALIGNOF), XEvent.__member(XGenericEventCookie.SIZEOF, XGenericEventCookie.ALIGNOF), XEvent.__padding(24, CLONG_SIZE, true));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        TYPE = v0.offsetof(0);
        XANY = v0.offsetof(1);
        XKEY = v0.offsetof(2);
        XBUTTON = v0.offsetof(3);
        XMOTION = v0.offsetof(4);
        XCROSSING = v0.offsetof(5);
        XFOCUS = v0.offsetof(6);
        XEXPOSE = v0.offsetof(7);
        XGRAPHICSEXPOSE = v0.offsetof(8);
        XNOEXPOSE = v0.offsetof(9);
        XVISIBILITY = v0.offsetof(10);
        XCREATEWINDOW = v0.offsetof(11);
        XDESTROYWINDOW = v0.offsetof(12);
        XUNMAP = v0.offsetof(13);
        XMAP = v0.offsetof(14);
        XMAPREQUEST = v0.offsetof(15);
        XREPARENT = v0.offsetof(16);
        XCONFIGURE = v0.offsetof(17);
        XGRAVITY = v0.offsetof(18);
        XRESIZEREQUEST = v0.offsetof(19);
        XCONFIGUREREQUEST = v0.offsetof(20);
        XCIRCULATE = v0.offsetof(21);
        XCIRCULATEREQUEST = v0.offsetof(22);
        XPROPERTY = v0.offsetof(23);
        XSELECTIONCLEAR = v0.offsetof(24);
        XSELECTIONREQUEST = v0.offsetof(25);
        XSELECTION = v0.offsetof(26);
        XCOLORMAP = v0.offsetof(27);
        XCLIENT = v0.offsetof(28);
        XMAPPING = v0.offsetof(29);
        XERROR = v0.offsetof(30);
        XKEYMAP = v0.offsetof(31);
        XGENERIC = v0.offsetof(32);
        XCOOKIE = v0.offsetof(33);
    }

    public static class Buffer
    extends StructBuffer<XEvent, Buffer>
    implements NativeResource {
        private static final XEvent ELEMENT_FACTORY = XEvent.create(-1L);

        public Buffer(ByteBuffer param1) {
            super(param1, param1.remaining() / SIZEOF);
        }

        public Buffer(long param1, int param3) {
            super(param1, null, -1, 0, param3, param3);
        }

        Buffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
            super(param1, param3, param4, param5, param6, param7);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected XEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XEvent.ntype(this.address());
        }

        public XAnyEvent xany() {
            return XEvent.nxany(this.address());
        }

        public XKeyEvent xkey() {
            return XEvent.nxkey(this.address());
        }

        public XButtonEvent xbutton() {
            return XEvent.nxbutton(this.address());
        }

        public XMotionEvent xmotion() {
            return XEvent.nxmotion(this.address());
        }

        public XCrossingEvent xcrossing() {
            return XEvent.nxcrossing(this.address());
        }

        public XFocusChangeEvent xfocus() {
            return XEvent.nxfocus(this.address());
        }

        public XExposeEvent xexpose() {
            return XEvent.nxexpose(this.address());
        }

        public XGraphicsExposeEvent xgraphicsexpose() {
            return XEvent.nxgraphicsexpose(this.address());
        }

        public XNoExposeEvent xnoexpose() {
            return XEvent.nxnoexpose(this.address());
        }

        public XVisibilityEvent xvisibility() {
            return XEvent.nxvisibility(this.address());
        }

        public XCreateWindowEvent xcreatewindow() {
            return XEvent.nxcreatewindow(this.address());
        }

        public XDestroyWindowEvent xdestroywindow() {
            return XEvent.nxdestroywindow(this.address());
        }

        public XUnmapEvent xunmap() {
            return XEvent.nxunmap(this.address());
        }

        public XMapEvent xmap() {
            return XEvent.nxmap(this.address());
        }

        public XMapRequestEvent xmaprequest() {
            return XEvent.nxmaprequest(this.address());
        }

        public XReparentEvent xreparent() {
            return XEvent.nxreparent(this.address());
        }

        public XConfigureEvent xconfigure() {
            return XEvent.nxconfigure(this.address());
        }

        public XGravityEvent xgravity() {
            return XEvent.nxgravity(this.address());
        }

        public XResizeRequestEvent xresizerequest() {
            return XEvent.nxresizerequest(this.address());
        }

        public XConfigureRequestEvent xconfigurerequest() {
            return XEvent.nxconfigurerequest(this.address());
        }

        public XCirculateEvent xcirculate() {
            return XEvent.nxcirculate(this.address());
        }

        public XCirculateRequestEvent xcirculaterequest() {
            return XEvent.nxcirculaterequest(this.address());
        }

        public XPropertyEvent xproperty() {
            return XEvent.nxproperty(this.address());
        }

        public XSelectionClearEvent xselectionclear() {
            return XEvent.nxselectionclear(this.address());
        }

        public XSelectionRequestEvent xselectionrequest() {
            return XEvent.nxselectionrequest(this.address());
        }

        public XSelectionEvent xselection() {
            return XEvent.nxselection(this.address());
        }

        public XColormapEvent xcolormap() {
            return XEvent.nxcolormap(this.address());
        }

        public XClientMessageEvent xclient() {
            return XEvent.nxclient(this.address());
        }

        public XMappingEvent xmapping() {
            return XEvent.nxmapping(this.address());
        }

        public XErrorEvent xerror() {
            return XEvent.nxerror(this.address());
        }

        public XKeymapEvent xkeymap() {
            return XEvent.nxkeymap(this.address());
        }

        public XGenericEvent xgeneric() {
            return XEvent.nxgeneric(this.address());
        }

        public XGenericEventCookie xcookie() {
            return XEvent.nxcookie(this.address());
        }
    }
}

