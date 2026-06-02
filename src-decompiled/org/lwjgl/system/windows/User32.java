/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.DEVMODE;
import org.lwjgl.system.windows.DISPLAY_DEVICE;
import org.lwjgl.system.windows.INPUT;
import org.lwjgl.system.windows.MONITORINFOEX;
import org.lwjgl.system.windows.MSG;
import org.lwjgl.system.windows.POINT;
import org.lwjgl.system.windows.RECT;
import org.lwjgl.system.windows.TOUCHINPUT;
import org.lwjgl.system.windows.WINDOWPLACEMENT;
import org.lwjgl.system.windows.WNDCLASSEX;
import org.lwjgl.system.windows.WindowProcI;

public class User32 {
    private static final SharedLibrary USER32;
    public static final int WS_OVERLAPPED;
    public static final int WS_POPUP;
    public static final int WS_CHILD;
    public static final int WS_MINIMIZE;
    public static final int WS_VISIBLE;
    public static final int WS_DISABLED;
    public static final int WS_CLIPSIBLINGS;
    public static final int WS_CLIPCHILDREN;
    public static final int WS_MAXIMIZE;
    public static final int WS_CAPTION;
    public static final int WS_BORDER;
    public static final int WS_DLGFRAME;
    public static final int WS_VSCROLL;
    public static final int WS_HSCROLL;
    public static final int WS_SYSMENU;
    public static final int WS_THICKFRAME;
    public static final int WS_GROUP;
    public static final int WS_TABSTOP;
    public static final int WS_MINIMIZEBOX;
    public static final int WS_MAXIMIZEBOX;
    public static final int WS_OVERLAPPEDWINDOW;
    public static final int WS_POPUPWINDOW;
    public static final int WS_CHILDWINDOW;
    public static final int WS_TILED;
    public static final int WS_ICONIC;
    public static final int WS_SIZEBOX;
    public static final int WS_TILEDWINDOW;
    public static final int WS_EX_DLGMODALFRAME;
    public static final int WS_EX_NOPARENTNOTIFY;
    public static final int WS_EX_TOPMOST;
    public static final int WS_EX_ACCEPTFILES;
    public static final int WS_EX_TRANSPARENT;
    public static final int WS_EX_MDICHILD;
    public static final int WS_EX_TOOLWINDOW;
    public static final int WS_EX_WINDOWEDGE;
    public static final int WS_EX_CLIENTEDGE;
    public static final int WS_EX_CONTEXTHELP;
    public static final int WS_EX_RIGHT;
    public static final int WS_EX_LEFT;
    public static final int WS_EX_RTLREADING;
    public static final int WS_EX_LTRREADING;
    public static final int WS_EX_LEFTSCROLLBAR;
    public static final int WS_EX_RIGHTSCROLLBAR;
    public static final int WS_EX_CONTROLPARENT;
    public static final int WS_EX_STATICEDGE;
    public static final int WS_EX_APPWINDOW;
    public static final int WS_EX_OVERLAPPEDWINDOW;
    public static final int WS_EX_PALETTEWINDOW;
    public static final int WS_EX_LAYERED;
    public static final int WS_EX_NOINHERITLAYOUT;
    public static final int WS_EX_LAYOUTRTL;
    public static final int WS_EX_COMPOSITED;
    public static final int WS_EX_NOACTIVATE;
    public static final int CW_USEDEFAULT;
    public static final int CS_VREDRAW;
    public static final int CS_HREDRAW;
    public static final int CS_DBLCLKS;
    public static final int CS_OWNDC;
    public static final int CS_CLASSDC;
    public static final int CS_PARENTDC;
    public static final int CS_NOCLOSE;
    public static final int CS_SAVEBITS;
    public static final int CS_BYTEALIGNCLIENT;
    public static final int CS_BYTEALIGNWINDOW;
    public static final int CS_GLOBALCLASS;
    public static final int CS_IME;
    public static final int CS_DROPSHADOW;
    public static final int WM_NULL;
    public static final int WM_CREATE;
    public static final int WM_DESTROY;
    public static final int WM_MOVE;
    public static final int WM_SIZE;
    public static final int WM_ACTIVATE;
    public static final int WM_SETFOCUS;
    public static final int WM_KILLFOCUS;
    public static final int WM_ENABLE;
    public static final int WM_SETREDRAW;
    public static final int WM_SETTEXT;
    public static final int WM_GETTEXT;
    public static final int WM_GETTEXTLENGTH;
    public static final int WM_PAINT;
    public static final int WM_CLOSE;
    public static final int WM_QUERYENDSESSION;
    public static final int WM_QUERYOPEN;
    public static final int WM_ENDSESSION;
    public static final int WM_QUIT;
    public static final int WM_ERASEBKGND;
    public static final int WM_SYSCOLORCHANGE;
    public static final int WM_SHOWWINDOW;
    public static final int WM_WININICHANGE;
    public static final int WM_SETTINGCHANGE;
    public static final int WM_DEVMODECHANGE;
    public static final int WM_ACTIVATEAPP;
    public static final int WM_FONTCHANGE;
    public static final int WM_TIMECHANGE;
    public static final int WM_CANCELMODE;
    public static final int WM_SETCURSOR;
    public static final int WM_MOUSEACTIVATE;
    public static final int WM_CHILDACTIVATE;
    public static final int WM_QUEUESYNC;
    public static final int WM_GETMINMAXINFO;
    public static final int WM_PAINTICON;
    public static final int WM_ICONERASEBKGND;
    public static final int WM_NEXTDLGCTL;
    public static final int WM_SPOOLERSTATUS;
    public static final int WM_DRAWITEM;
    public static final int WM_MEASUREITEM;
    public static final int WM_DELETEITEM;
    public static final int WM_VKEYTOITEM;
    public static final int WM_CHARTOITEM;
    public static final int WM_SETFONT;
    public static final int WM_GETFONT;
    public static final int WM_SETHOTKEY;
    public static final int WM_GETHOTKEY;
    public static final int WM_QUERYDRAGICON;
    public static final int WM_COMPAREITEM;
    public static final int WM_GETOBJECT;
    public static final int WM_COMPACTING;
    public static final int WM_COMMNOTIFY;
    public static final int WM_WINDOWPOSCHANGING;
    public static final int WM_WINDOWPOSCHANGED;
    public static final int WM_POWER;
    public static final int WM_COPYDATA;
    public static final int WM_CANCELJOURNAL;
    public static final int WM_NOTIFY;
    public static final int WM_INPUTLANGCHANGEREQUEST;
    public static final int WM_INPUTLANGCHANGE;
    public static final int WM_TCARD;
    public static final int WM_HELP;
    public static final int WM_USERCHANGED;
    public static final int WM_NOTIFYFORMAT;
    public static final int WM_CONTEXTMENU;
    public static final int WM_STYLECHANGING;
    public static final int WM_STYLECHANGED;
    public static final int WM_DISPLAYCHANGE;
    public static final int WM_GETICON;
    public static final int WM_SETICON;
    public static final int WM_NCCREATE;
    public static final int WM_NCDESTROY;
    public static final int WM_NCCALCSIZE;
    public static final int WM_NCHITTEST;
    public static final int WM_NCPAINT;
    public static final int WM_NCACTIVATE;
    public static final int WM_GETDLGCODE;
    public static final int WM_SYNCPAINT;
    public static final int WM_NCMOUSEMOVE;
    public static final int WM_NCLBUTTONDOWN;
    public static final int WM_NCLBUTTONUP;
    public static final int WM_NCLBUTTONDBLCLK;
    public static final int WM_NCRBUTTONDOWN;
    public static final int WM_NCRBUTTONUP;
    public static final int WM_NCRBUTTONDBLCLK;
    public static final int WM_NCMBUTTONDOWN;
    public static final int WM_NCMBUTTONUP;
    public static final int WM_NCMBUTTONDBLCLK;
    public static final int WM_NCXBUTTONDOWN;
    public static final int WM_NCXBUTTONUP;
    public static final int WM_NCXBUTTONDBLCLK;
    public static final int WM_INPUT_DEVICE_CHANGE;
    public static final int WM_INPUT;
    public static final int WM_KEYFIRST;
    public static final int WM_KEYDOWN;
    public static final int WM_KEYUP;
    public static final int WM_CHAR;
    public static final int WM_DEADCHAR;
    public static final int WM_SYSKEYDOWN;
    public static final int WM_SYSKEYUP;
    public static final int WM_SYSCHAR;
    public static final int WM_SYSDEADCHAR;
    public static final int WM_UNICHAR;
    public static final int UNICODE_NOCHAR;
    public static final int WM_IME_STARTCOMPOSITION;
    public static final int WM_IME_ENDCOMPOSITION;
    public static final int WM_IME_COMPOSITION;
    public static final int WM_IME_KEYLAST;
    public static final int WM_INITDIALOG;
    public static final int WM_COMMAND;
    public static final int WM_SYSCOMMAND;
    public static final int WM_TIMER;
    public static final int WM_HSCROLL;
    public static final int WM_VSCROLL;
    public static final int WM_INITMENU;
    public static final int WM_INITMENUPOPUP;
    public static final int WM_GESTURE;
    public static final int WM_GESTURENOTIFY;
    public static final int WM_MENUSELECT;
    public static final int WM_MENUCHAR;
    public static final int WM_ENTERIDLE;
    public static final int WM_MENURBUTTONUP;
    public static final int WM_MENUDRAG;
    public static final int WM_MENUGETOBJECT;
    public static final int WM_UNINITMENUPOPUP;
    public static final int WM_MENUCOMMAND;
    public static final int WM_CHANGEUISTATE;
    public static final int WM_UPDATEUISTATE;
    public static final int WM_QUERYUISTATE;
    public static final int WM_CTLCOLORMSGBOX;
    public static final int WM_CTLCOLOREDIT;
    public static final int WM_CTLCOLORLISTBOX;
    public static final int WM_CTLCOLORBTN;
    public static final int WM_CTLCOLORDLG;
    public static final int WM_CTLCOLORSCROLLBAR;
    public static final int WM_CTLCOLORSTATIC;
    public static final int MN_GETHMENU;
    public static final int WM_MOUSEFIRST;
    public static final int WM_MOUSEMOVE;
    public static final int WM_LBUTTONDOWN;
    public static final int WM_LBUTTONUP;
    public static final int WM_LBUTTONDBLCLK;
    public static final int WM_RBUTTONDOWN;
    public static final int WM_RBUTTONUP;
    public static final int WM_RBUTTONDBLCLK;
    public static final int WM_MBUTTONDOWN;
    public static final int WM_MBUTTONUP;
    public static final int WM_MBUTTONDBLCLK;
    public static final int WM_MOUSEWHEEL;
    public static final int WM_XBUTTONDOWN;
    public static final int WM_XBUTTONUP;
    public static final int WM_XBUTTONDBLCLK;
    public static final int WM_MOUSEHWHEEL;
    public static final int WM_PARENTNOTIFY;
    public static final int WM_ENTERMENULOOP;
    public static final int WM_EXITMENULOOP;
    public static final int WM_NEXTMENU;
    public static final int WM_SIZING;
    public static final int WM_CAPTURECHANGED;
    public static final int WM_MOVING;
    public static final int WM_POWERBROADCAST;
    public static final int WM_DEVICECHANGE;
    public static final int WM_MDICREATE;
    public static final int WM_MDIDESTROY;
    public static final int WM_MDIACTIVATE;
    public static final int WM_MDIRESTORE;
    public static final int WM_MDINEXT;
    public static final int WM_MDIMAXIMIZE;
    public static final int WM_MDITILE;
    public static final int WM_MDICASCADE;
    public static final int WM_MDIICONARRANGE;
    public static final int WM_MDIGETACTIVE;
    public static final int WM_MDISETMENU;
    public static final int WM_ENTERSIZEMOVE;
    public static final int WM_EXITSIZEMOVE;
    public static final int WM_DROPFILES;
    public static final int WM_MDIREFRESHMENU;
    public static final int WM_TOUCH;
    public static final int WM_IME_SETCONTEXT;
    public static final int WM_IME_NOTIFY;
    public static final int WM_IME_CONTROL;
    public static final int WM_IME_COMPOSITIONFULL;
    public static final int WM_IME_SELECT;
    public static final int WM_IME_CHAR;
    public static final int WM_IME_REQUEST;
    public static final int WM_IME_KEYDOWN;
    public static final int WM_IME_KEYUP;
    public static final int WM_MOUSEHOVER;
    public static final int WM_MOUSELEAVE;
    public static final int WM_NCMOUSEHOVER;
    public static final int WM_NCMOUSELEAVE;
    public static final int WM_WTSSESSION_CHANGE;
    public static final int WM_TABLET_FIRST;
    public static final int WM_TABLET_LAST;
    public static final int WM_CUT;
    public static final int WM_COPY;
    public static final int WM_PASTE;
    public static final int WM_CLEAR;
    public static final int WM_UNDO;
    public static final int WM_RENDERFORMAT;
    public static final int WM_RENDERALLFORMATS;
    public static final int WM_DESTROYCLIPBOARD;
    public static final int WM_DRAWCLIPBOARD;
    public static final int WM_PAINTCLIPBOARD;
    public static final int WM_VSCROLLCLIPBOARD;
    public static final int WM_SIZECLIPBOARD;
    public static final int WM_ASKCBFORMATNAME;
    public static final int WM_CHANGECBCHAIN;
    public static final int WM_HSCROLLCLIPBOARD;
    public static final int WM_QUERYNEWPALETTE;
    public static final int WM_PALETTEISCHANGING;
    public static final int WM_PALETTECHANGED;
    public static final int WM_HOTKEY;
    public static final int WM_PRINT;
    public static final int WM_PRINTCLIENT;
    public static final int WM_APPCOMMAND;
    public static final int WM_THEMECHANGED;
    public static final int WM_CLIPBOARDUPDATE;
    public static final int WM_DWMCOMPOSITIONCHANGED;
    public static final int WM_DWMNCRENDERINGCHANGED;
    public static final int WM_DWMCOLORIZATIONCOLORCHANGED;
    public static final int WM_DWMWINDOWMAXIMIZEDCHANGE;
    public static final int WM_DWMSENDICONICTHUMBNAIL;
    public static final int WM_DWMSENDICONICLIVEPREVIEWBITMAP;
    public static final int WM_GETTITLEBARINFOEX;
    public static final int WM_HANDHELDFIRST;
    public static final int WM_HANDHELDLAST;
    public static final int WM_AFXFIRST;
    public static final int WM_AFXLAST;
    public static final int WM_PENWINFIRST;
    public static final int WM_PENWINLAST;
    public static final int WM_APP;
    public static final int WM_USER;
    public static final int WA_ACTIVE;
    public static final int WA_CLICKACTIVE;
    public static final int WA_INACTIVE;
    public static final int SIZE_RESTORED;
    public static final int SIZE_MINIMIZED;
    public static final int SIZE_MAXIMIZED;
    public static final int SIZE_MAXSHOW;
    public static final int SIZE_MAXHIDE;
    public static final int DBT_APPYBEGIN;
    public static final int DBT_APPYEND;
    public static final int DBT_DEVNODES_CHANGED;
    public static final int DBT_QUERYCHANGECONFIG;
    public static final int DBT_CONFIGCHANGED;
    public static final int DBT_CONFIGCHANGECANCELED;
    public static final int DBT_MONITORCHANGE;
    public static final int SC_SIZE;
    public static final int SC_MOVE;
    public static final int SC_MINIMIZE;
    public static final int SC_MAXIMIZE;
    public static final int SC_NEXTWINDOW;
    public static final int SC_PREVWINDOW;
    public static final int SC_CLOSE;
    public static final int SC_VSCROLL;
    public static final int SC_HSCROLL;
    public static final int SC_MOUSEMENU;
    public static final int SC_KEYMENU;
    public static final int SC_ARRANGE;
    public static final int SC_RESTORE;
    public static final int SC_TASKLIST;
    public static final int SC_SCREENSAVE;
    public static final int SC_HOTKEY;
    public static final int SC_DEFAULT;
    public static final int SC_MONITORPOWER;
    public static final int SC_CONTEXTHELP;
    public static final int SC_SEPARATOR;
    public static final int MK_LBUTTON;
    public static final int MK_RBUTTON;
    public static final int MK_SHIFT;
    public static final int MK_CONTROL;
    public static final int MK_MBUTTON;
    public static final int MK_XBUTTON1;
    public static final int MK_XBUTTON2;
    public static final int HTERROR;
    public static final int HTTRANSPARENT;
    public static final int HTNOWHERE;
    public static final int HTCLIENT;
    public static final int HTCAPTION;
    public static final int HTSYSMENU;
    public static final int HTGROWBOX;
    public static final int HTSIZE;
    public static final int HTMENU;
    public static final int HTHSCROLL;
    public static final int HTVSCROLL;
    public static final int HTMINBUTTON;
    public static final int HTMAXBUTTON;
    public static final int HTLEFT;
    public static final int HTRIGHT;
    public static final int HTTOP;
    public static final int HTTOPLEFT;
    public static final int HTTOPRIGHT;
    public static final int HTBOTTOM;
    public static final int HTBOTTOMLEFT;
    public static final int HTBOTTOMRIGHT;
    public static final int HTBORDER;
    public static final int HTREDUCE;
    public static final int HTZOOM;
    public static final int HTSIZEFIRST;
    public static final int HTSIZELAST;
    public static final int HTOBJECT;
    public static final int HTCLOSE;
    public static final int HTHELP;
    public static final int GWL_WNDPROC;
    public static final int GWL_HINSTANCE;
    public static final int GWL_HWNDPARENT;
    public static final int GWL_STYLE;
    public static final int GWL_EXSTYLE;
    public static final int GWL_USERDATA;
    public static final int GWL_ID;
    public static final int SW_HIDE;
    public static final int SW_SHOWNORMAL;
    public static final int SW_NORMAL;
    public static final int SW_SHOWMINIMIZED;
    public static final int SW_SHOWMAXIMIZED;
    public static final int SW_MAXIMIZE;
    public static final int SW_SHOWNOACTIVATE;
    public static final int SW_SHOW;
    public static final int SW_MINIMIZE;
    public static final int SW_SHOWMINNOACTIVE;
    public static final int SW_SHOWNA;
    public static final int SW_RESTORE;
    public static final int SW_SHOWDEFAULT;
    public static final int SW_FORCEMINIMIZE;
    public static final int SW_MAX;
    public static final long HWND_TOP;
    public static final long HWND_BOTTOM;
    public static final long HWND_TOPMOST;
    public static final long HWND_NOTOPMOST;
    public static final long HWND_BROADCAST;
    public static final int SWP_NOSIZE;
    public static final int SWP_NOMOVE;
    public static final int SWP_NOZORDER;
    public static final int SWP_NOREDRAW;
    public static final int SWP_NOACTIVATE;
    public static final int SWP_FRAMECHANGED;
    public static final int SWP_SHOWWINDOW;
    public static final int SWP_HIDEWINDOW;
    public static final int SWP_NOCOPYBITS;
    public static final int SWP_NOOWNERZORDER;
    public static final int SWP_NOSENDCHANGING;
    public static final int SWP_DRAWFRAME;
    public static final int SWP_NOREPOSITION;
    public static final int SWP_DEFERERASE;
    public static final int SWP_ASYNCWINDOWPOS;
    public static final int IDI_APPLICATION;
    public static final int IDI_HAND;
    public static final int IDI_QUESTION;
    public static final int IDI_EXCLAMATION;
    public static final int IDI_ASTERISK;
    public static final int IDI_WINLOGO;
    public static final int IDI_SHIELD;
    public static final int IDI_WARNING;
    public static final int IDI_ERROR;
    public static final int IDI_INFORMATION;
    public static final int IDC_ARROW;
    public static final int IDC_IBEAM;
    public static final int IDC_WAIT;
    public static final int IDC_CROSS;
    public static final int IDC_UPARROW;
    public static final int IDC_SIZE;
    public static final int IDC_ICON;
    public static final int IDC_SIZENWSE;
    public static final int IDC_SIZENESW;
    public static final int IDC_SIZEWE;
    public static final int IDC_SIZENS;
    public static final int IDC_SIZEALL;
    public static final int IDC_NO;
    public static final int IDC_HAND;
    public static final int IDC_APPSTARTING;
    public static final int IDC_HELP;
    public static final int GCL_MENUNAME;
    public static final int GCL_HBRBACKGROUND;
    public static final int GCL_HCURSOR;
    public static final int GCL_HICON;
    public static final int GCL_HMODULE;
    public static final int GCL_CBWNDEXTRA;
    public static final int GCL_CBCLSEXTRA;
    public static final int GCL_WNDPROC;
    public static final int GCL_STYLE;
    public static final int GCW_ATOM;
    public static final int GCL_HICONSM;
    public static final int QS_KEY;
    public static final int QS_MOUSEMOVE;
    public static final int QS_MOUSEBUTTON;
    public static final int QS_POSTMESSAGE;
    public static final int QS_TIMER;
    public static final int QS_PAINT;
    public static final int QS_SENDMESSAGE;
    public static final int QS_HOTKEY;
    public static final int QS_ALLPOSTMESSAGE;
    public static final int QS_RAWINPUT;
    public static final int QS_MOUSE;
    public static final int QS_INPUT;
    public static final int QS_ALLEVENTS;
    public static final int QS_ALLINPUT;
    public static final int PM_NOREMOVE;
    public static final int PM_REMOVE;
    public static final int PM_NOYIELD;
    public static final int PM_QS_INPUT;
    public static final int PM_QS_POSTMESSAGE;
    public static final int PM_QS_PAINT;
    public static final int PM_QS_SENDMESSAGE;
    public static final int VK_LBUTTON;
    public static final int VK_RBUTTON;
    public static final int VK_CANCEL;
    public static final int VK_MBUTTON;
    public static final int VK_XBUTTON1;
    public static final int VK_XBUTTON2;
    public static final int VK_BACK;
    public static final int VK_TAB;
    public static final int VK_CLEAR;
    public static final int VK_RETURN;
    public static final int VK_SHIFT;
    public static final int VK_CONTROL;
    public static final int VK_MENU;
    public static final int VK_PAUSE;
    public static final int VK_CAPITAL;
    public static final int VK_KANA;
    public static final int VK_HANGEUL;
    public static final int VK_HANGUL;
    public static final int VK_JUNJA;
    public static final int VK_FINAL;
    public static final int VK_HANJA;
    public static final int VK_KANJI;
    public static final int VK_ESCAPE;
    public static final int VK_CONVERT;
    public static final int VK_NONCONVERT;
    public static final int VK_ACCEPT;
    public static final int VK_MODECHANGE;
    public static final int VK_SPACE;
    public static final int VK_PRIOR;
    public static final int VK_NEXT;
    public static final int VK_END;
    public static final int VK_HOME;
    public static final int VK_LEFT;
    public static final int VK_UP;
    public static final int VK_RIGHT;
    public static final int VK_DOWN;
    public static final int VK_SELECT;
    public static final int VK_PRINT;
    public static final int VK_EXECUTE;
    public static final int VK_SNAPSHOT;
    public static final int VK_INSERT;
    public static final int VK_DELETE;
    public static final int VK_HELP;
    public static final int VK_LWIN;
    public static final int VK_RWIN;
    public static final int VK_APPS;
    public static final int VK_SLEEP;
    public static final int VK_NUMPAD0;
    public static final int VK_NUMPAD1;
    public static final int VK_NUMPAD2;
    public static final int VK_NUMPAD3;
    public static final int VK_NUMPAD4;
    public static final int VK_NUMPAD5;
    public static final int VK_NUMPAD6;
    public static final int VK_NUMPAD7;
    public static final int VK_NUMPAD8;
    public static final int VK_NUMPAD9;
    public static final int VK_MULTIPLY;
    public static final int VK_ADD;
    public static final int VK_SEPARATOR;
    public static final int VK_SUBTRACT;
    public static final int VK_DECIMAL;
    public static final int VK_DIVIDE;
    public static final int VK_F1;
    public static final int VK_F2;
    public static final int VK_F3;
    public static final int VK_F4;
    public static final int VK_F5;
    public static final int VK_F6;
    public static final int VK_F7;
    public static final int VK_F8;
    public static final int VK_F9;
    public static final int VK_F10;
    public static final int VK_F11;
    public static final int VK_F12;
    public static final int VK_F13;
    public static final int VK_F14;
    public static final int VK_F15;
    public static final int VK_F16;
    public static final int VK_F17;
    public static final int VK_F18;
    public static final int VK_F19;
    public static final int VK_F20;
    public static final int VK_F21;
    public static final int VK_F22;
    public static final int VK_F23;
    public static final int VK_F24;
    public static final int VK_NUMLOCK;
    public static final int VK_SCROLL;
    public static final int VK_OEM_NEC_EQUAL;
    public static final int VK_OEM_FJ_JISHO;
    public static final int VK_OEM_FJ_MASSHOU;
    public static final int VK_OEM_FJ_TOUROKU;
    public static final int VK_OEM_FJ_LOYA;
    public static final int VK_OEM_FJ_ROYA;
    public static final int VK_LSHIFT;
    public static final int VK_RSHIFT;
    public static final int VK_LCONTROL;
    public static final int VK_RCONTROL;
    public static final int VK_LMENU;
    public static final int VK_RMENU;
    public static final int VK_BROWSER_BACK;
    public static final int VK_BROWSER_FORWARD;
    public static final int VK_BROWSER_REFRESH;
    public static final int VK_BROWSER_STOP;
    public static final int VK_BROWSER_SEARCH;
    public static final int VK_BROWSER_FAVORITES;
    public static final int VK_BROWSER_HOME;
    public static final int VK_VOLUME_MUTE;
    public static final int VK_VOLUME_DOWN;
    public static final int VK_VOLUME_UP;
    public static final int VK_MEDIA_NEXT_TRACK;
    public static final int VK_MEDIA_PREV_TRACK;
    public static final int VK_MEDIA_STOP;
    public static final int VK_MEDIA_PLAY_PAUSE;
    public static final int VK_LAUNCH_MAIL;
    public static final int VK_LAUNCH_MEDIA_SELECT;
    public static final int VK_LAUNCH_APP1;
    public static final int VK_LAUNCH_APP2;
    public static final int VK_OEM_1;
    public static final int VK_OEM_PLUS;
    public static final int VK_OEM_COMMA;
    public static final int VK_OEM_MINUS;
    public static final int VK_OEM_PERIOD;
    public static final int VK_OEM_2;
    public static final int VK_OEM_3;
    public static final int VK_OEM_4;
    public static final int VK_OEM_5;
    public static final int VK_OEM_6;
    public static final int VK_OEM_7;
    public static final int VK_OEM_8;
    public static final int VK_OEM_AX;
    public static final int VK_OEM_102;
    public static final int VK_ICO_HELP;
    public static final int VK_ICO_00;
    public static final int VK_PROCESSKEY;
    public static final int VK_ICO_CLEAR;
    public static final int VK_PACKET;
    public static final int VK_OEM_RESET;
    public static final int VK_OEM_JUMP;
    public static final int VK_OEM_PA1;
    public static final int VK_OEM_PA2;
    public static final int VK_OEM_PA3;
    public static final int VK_OEM_WSCTRL;
    public static final int VK_OEM_CUSEL;
    public static final int VK_OEM_ATTN;
    public static final int VK_OEM_FINISH;
    public static final int VK_OEM_COPY;
    public static final int VK_OEM_AUTO;
    public static final int VK_OEM_ENLW;
    public static final int VK_OEM_BACKTAB;
    public static final int VK_ATTN;
    public static final int VK_CRSEL;
    public static final int VK_EXSEL;
    public static final int VK_EREOF;
    public static final int VK_PLAY;
    public static final int VK_ZOOM;
    public static final int VK_NONAME;
    public static final int VK_PA1;
    public static final int VK_OEM_CLEAR;
    public static final int XBUTTON1;
    public static final int XBUTTON2;
    public static final int WHEEL_DELTA;
    public static final int DPI_AWARENESS_INVALID;
    public static final int DPI_AWARENESS_UNAWARE;
    public static final int DPI_AWARENESS_SYSTEM_AWARE;
    public static final int DPI_AWARENESS_PER_MONITOR_AWARE;
    public static final long DPI_AWARENESS_CONTEXT_UNAWARE;
    public static final long DPI_AWARENESS_CONTEXT_SYSTEM_AWARE;
    public static final long DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE;
    public static final long DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2;
    public static final int WPF_SETMINPOSITION;
    public static final int WPF_RESTORETOMAXIMIZED;
    public static final int WPF_ASYNCWINDOWPLACEMENT;
    public static final int LWA_COLORKEY;
    public static final int LWA_ALPHA;
    public static final int SM_CXSCREEN;
    public static final int SM_CYSCREEN;
    public static final int SM_CXVSCROLL;
    public static final int SM_CYHSCROLL;
    public static final int SM_CYCAPTION;
    public static final int SM_CXBORDER;
    public static final int SM_CYBORDER;
    public static final int SM_CXDLGFRAME;
    public static final int SM_CYDLGFRAME;
    public static final int SM_CYVTHUMB;
    public static final int SM_CXHTHUMB;
    public static final int SM_CXICON;
    public static final int SM_CYICON;
    public static final int SM_CXCURSOR;
    public static final int SM_CYCURSOR;
    public static final int SM_CYMENU;
    public static final int SM_CXFULLSCREEN;
    public static final int SM_CYFULLSCREEN;
    public static final int SM_CYKANJIWINDOW;
    public static final int SM_MOUSEPRESENT;
    public static final int SM_CYVSCROLL;
    public static final int SM_CXHSCROLL;
    public static final int SM_DEBUG;
    public static final int SM_SWAPBUTTON;
    public static final int SM_RESERVED1;
    public static final int SM_RESERVED2;
    public static final int SM_RESERVED3;
    public static final int SM_RESERVED4;
    public static final int SM_CXMIN;
    public static final int SM_CYMIN;
    public static final int SM_CXSIZE;
    public static final int SM_CYSIZE;
    public static final int SM_CXFRAME;
    public static final int SM_CYFRAME;
    public static final int SM_CXMINTRACK;
    public static final int SM_CYMINTRACK;
    public static final int SM_CXDOUBLECLK;
    public static final int SM_CYDOUBLECLK;
    public static final int SM_CXICONSPACING;
    public static final int SM_CYICONSPACING;
    public static final int SM_MENUDROPALIGNMENT;
    public static final int SM_PENWINDOWS;
    public static final int SM_DBCSENABLED;
    public static final int SM_CMOUSEBUTTONS;
    public static final int SM_CXFIXEDFRAME;
    public static final int SM_CYFIXEDFRAME;
    public static final int SM_CXSIZEFRAME;
    public static final int SM_CYSIZEFRAME;
    public static final int SM_SECURE;
    public static final int SM_CXEDGE;
    public static final int SM_CYEDGE;
    public static final int SM_CXMINSPACING;
    public static final int SM_CYMINSPACING;
    public static final int SM_CXSMICON;
    public static final int SM_CYSMICON;
    public static final int SM_CYSMCAPTION;
    public static final int SM_CXSMSIZE;
    public static final int SM_CYSMSIZE;
    public static final int SM_CXMENUSIZE;
    public static final int SM_CYMENUSIZE;
    public static final int SM_ARRANGE;
    public static final int SM_CXMINIMIZED;
    public static final int SM_CYMINIMIZED;
    public static final int SM_CXMAXTRACK;
    public static final int SM_CYMAXTRACK;
    public static final int SM_CXMAXIMIZED;
    public static final int SM_CYMAXIMIZED;
    public static final int SM_NETWORK;
    public static final int SM_CLEANBOOT;
    public static final int SM_CXDRAG;
    public static final int SM_CYDRAG;
    public static final int SM_SHOWSOUNDS;
    public static final int SM_CXMENUCHECK;
    public static final int SM_CYMENUCHECK;
    public static final int SM_SLOWMACHINE;
    public static final int SM_MIDEASTENABLED;
    public static final int SM_MOUSEWHEELPRESENT;
    public static final int SM_XVIRTUALSCREEN;
    public static final int SM_YVIRTUALSCREEN;
    public static final int SM_CXVIRTUALSCREEN;
    public static final int SM_CYVIRTUALSCREEN;
    public static final int SM_CMONITORS;
    public static final int SM_SAMEDISPLAYFORMAT;
    public static final int SM_IMMENABLED;
    public static final int SM_REMOTESESSION;
    public static final int SM_SHUTTINGDOWN;
    public static final int SM_REMOTECONTROL;
    public static final int SM_CARETBLINKINGENABLED;
    public static final int SM_CXFOCUSBORDER;
    public static final int SM_CYFOCUSBORDER;
    public static final int SM_TABLETPC;
    public static final int SM_MEDIACENTER;
    public static final int SM_STARTER;
    public static final int SM_SERVERR2;
    public static final int SM_MOUSEHORIZONTALWHEELPRESENT;
    public static final int SM_CXPADDEDBORDER;
    public static final int SM_DIGITIZER;
    public static final int SM_MAXIMUMTOUCHES;
    public static final int TWF_FINETOUCH;
    public static final int TWF_WANTPALM;
    public static final int TOUCHEVENTF_MOVE;
    public static final int TOUCHEVENTF_DOWN;
    public static final int TOUCHEVENTF_UP;
    public static final int TOUCHEVENTF_INRANGE;
    public static final int TOUCHEVENTF_PRIMARY;
    public static final int TOUCHEVENTF_NOCOALESCE;
    public static final int TOUCHEVENTF_PEN;
    public static final int TOUCHEVENTF_PALM;
    public static final int TOUCHINPUTMASKF_TIMEFROMSYSTEM;
    public static final int TOUCHINPUTMASKF_EXTRAINFO;
    public static final int TOUCHINPUTMASKF_CONTACTAREA;
    public static final int MONITOR_DEFAULTTONULL;
    public static final int MONITOR_DEFAULTTOPRIMARY;
    public static final int MONITOR_DEFAULTTONEAREST;
    public static final int MONITORINFOF_PRIMARY;
    public static final int EDD_GET_DEVICE_INTERFACE_NAME;
    public static final int ENUM_CURRENT_SETTINGS;
    public static final int ENUM_REGISTRY_SETTINGS;
    public static final int EDS_RAWMODE;
    public static final int EDS_ROTATEDMODE;
    public static final int CDS_UPDATEREGISTRY;
    public static final int CDS_TEST;
    public static final int CDS_FULLSCREEN;
    public static final int CDS_GLOBAL;
    public static final int CDS_SET_PRIMARY;
    public static final int CDS_VIDEOPARAMETERS;
    public static final int CDS_ENABLE_UNSAFE_MODES;
    public static final int CDS_DISABLE_UNSAFE_MODES;
    public static final int CDS_RESET;
    public static final int CDS_RESET_EX;
    public static final int CDS_NORESET;
    public static final int DISP_CHANGE_SUCCESSFUL;
    public static final int DISP_CHANGE_RESTART;
    public static final int DISP_CHANGE_FAILED;
    public static final int DISP_CHANGE_BADMODE;
    public static final int DISP_CHANGE_NOTUPDATED;
    public static final int DISP_CHANGE_BADFLAGS;
    public static final int DISP_CHANGE_BADPARAM;
    public static final int DISP_CHANGE_BADDUALVIEW;
    public static final int INPUT_MOUSE;
    public static final int INPUT_KEYBOARD;
    public static final int INPUT_HARDWARE;
    public static final int MOUSEEVENTF_ABSOLUTE;
    public static final int MOUSEEVENTF_HWHEEL;
    public static final int MOUSEEVENTF_MOVE;
    public static final int MOUSEEVENTF_MOVE_NOCOALESCE;
    public static final int MOUSEEVENTF_LEFTDOWN;
    public static final int MOUSEEVENTF_LEFTUP;
    public static final int MOUSEEVENTF_RIGHTDOWN;
    public static final int MOUSEEVENTF_RIGHTUP;
    public static final int MOUSEEVENTF_MIDDLEDOWN;
    public static final int MOUSEEVENTF_MIDDLEUP;
    public static final int MOUSEEVENTF_VIRTUALDESK;
    public static final int MOUSEEVENTF_WHEEL;
    public static final int MOUSEEVENTF_XDOWN;
    public static final int MOUSEEVENTF_XUP;
    public static final int KEYEVENTF_EXTENDEDKEY;
    public static final int KEYEVENTF_KEYUP;
    public static final int KEYEVENTF_SCANCODE;
    public static final int KEYEVENTF_UNICODE;

    public static SharedLibrary getLibrary() {
        return USER32;
    }

    protected User32() {
        throw new UnsupportedOperationException();
    }

    public static native short nRegisterClassEx(long var0, long var2);

    public static short nRegisterClassEx(long param0) {
        long v2 = Functions.RegisterClassEx;
        if (Checks.CHECKS) {
            WNDCLASSEX.validate(param0);
        }
        return User32.nRegisterClassEx(param0, v2);
    }

    @NativeType(value="ATOM")
    public static short RegisterClassEx(@NativeType(value="WNDCLASSEX const *") WNDCLASSEX param0) {
        return User32.nRegisterClassEx(param0.address());
    }

    public static native int nUnregisterClass(long var0, long var2, long var4);

    public static int nUnregisterClass(long param0, long param2) {
        long v4 = Functions.UnregisterClass;
        return User32.nUnregisterClass(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean UnregisterClass(@NativeType(value="LPCTSTR") ByteBuffer param0, @NativeType(value="HINSTANCE") long param1) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param0);
        }
        return User32.nUnregisterClass(MemoryUtil.memAddress(param0), param1) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean UnregisterClass(@NativeType(value="LPCTSTR") CharSequence param0, @NativeType(value="HINSTANCE") long param1) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF16(param0, true);
            long v5 = v3.getPointerAddress();
            boolean v7 = User32.nUnregisterClass(v5, param1) != 0;
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native long nCreateWindowEx(int var0, long var1, long var3, int var5, int var6, int var7, int var8, int var9, long var10, long var12, long var14, long var16, long var18);

    public static long nCreateWindowEx(int param0, long param1, long param3, int param5, int param6, int param7, int param8, int param9, long param10, long param12, long param14, long param16) {
        long v18 = Functions.CreateWindowEx;
        return User32.nCreateWindowEx(param0, param1, param3, param5, param6, param7, param8, param9, param10, param12, param14, param16, v18);
    }

    @NativeType(value="HWND")
    public static long CreateWindowEx(@NativeType(value="DWORD") int param0, @Nullable @NativeType(value="LPCTSTR") ByteBuffer param1, @Nullable @NativeType(value="LPCTSTR") ByteBuffer param2, @NativeType(value="DWORD") int param3, int param4, int param5, int param6, int param7, @NativeType(value="HWND") long param8, @NativeType(value="HMENU") long param10, @NativeType(value="HINSTANCE") long param12, @NativeType(value="LPVOID") long param14) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param1);
            Checks.checkNT2Safe(param2);
        }
        return User32.nCreateWindowEx(param0, MemoryUtil.memAddressSafe(param1), MemoryUtil.memAddressSafe(param2), param3, param4, param5, param6, param7, param8, param10, param12, param14);
    }

    @NativeType(value="HWND")
    public static long CreateWindowEx(@NativeType(value="DWORD") int param0, @Nullable @NativeType(value="LPCTSTR") CharSequence param1, @Nullable @NativeType(value="LPCTSTR") CharSequence param2, @NativeType(value="DWORD") int param3, int param4, int param5, int param6, int param7, @NativeType(value="HWND") long param8, @NativeType(value="HMENU") long param10, @NativeType(value="HINSTANCE") long param12, @NativeType(value="LPVOID") long param14) {
        MemoryStack v16 = MemoryStack.stackGet();
        int v17 = v16.getPointer();
        try {
            v16.nUTF16Safe(param1, true);
            long v18 = param1 == null ? 0L : v16.getPointerAddress();
            v16.nUTF16Safe(param2, true);
            long v20 = param2 == null ? 0L : v16.getPointerAddress();
            long v22 = User32.nCreateWindowEx(param0, v18, v20, param3, param4, param5, param6, param7, param8, param10, param12, param14);
            return v22;
        }
        finally {
            v16.setPointer(v17);
        }
    }

    public static native int nDestroyWindow(long var0, long var2);

    @NativeType(value="BOOL")
    public static boolean DestroyWindow(@NativeType(value="HWND") long param0) {
        long v2 = Functions.DestroyWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nDestroyWindow(param0, v2) != 0;
    }

    @NativeType(value="LRESULT")
    public static long DefWindowProc(@NativeType(value="HWND") long param0, @NativeType(value="UINT") int param2, @NativeType(value="WPARAM") long param3, @NativeType(value="LPARAM") long param5) {
        long v7 = Functions.DefWindowProc;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPPPP(param0, param2, param3, param5, v7);
    }

    public static long nCallWindowProc(long param0, long param2, int param4, long param5, long param7) {
        long v9 = Functions.CallWindowProc;
        if (Checks.CHECKS) {
            Checks.check(param2);
        }
        return JNI.callPPPPP(param0, param2, param4, param5, param7, v9);
    }

    @NativeType(value="LRESULT")
    public static long CallWindowProc(@NativeType(value="WNDPROC") WindowProcI param0, @NativeType(value="HWND") long param1, @NativeType(value="UINT") int param3, @NativeType(value="WPARAM") long param4, @NativeType(value="LPARAM") long param6) {
        return User32.nCallWindowProc(param0.address(), param1, param3, param4, param6);
    }

    @NativeType(value="BOOL")
    public static boolean ShowWindow(@NativeType(value="HWND") long param0, int param2) {
        long v3 = Functions.ShowWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, param2, v3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean UpdateWindow(@NativeType(value="HWND") long param0) {
        long v2 = Functions.UpdateWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    public static native int nSetWindowPos(long var0, long var2, int var4, int var5, int var6, int var7, int var8, long var9);

    @NativeType(value="BOOL")
    public static boolean SetWindowPos(@NativeType(value="HWND") long param0, @NativeType(value="HWND") long param2, int param4, int param5, int param6, int param7, @NativeType(value="UINT") int param8) {
        long v9 = Functions.SetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetWindowPos(param0, param2, param4, param5, param6, param7, param8, v9) != 0;
    }

    public static native int nSetWindowText(long var0, long var2, long var4);

    public static int nSetWindowText(long param0, long param2) {
        long v4 = Functions.SetWindowText;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetWindowText(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean SetWindowText(@NativeType(value="HWND") long param0, @NativeType(value="LPCTSTR") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param2);
        }
        return User32.nSetWindowText(param0, MemoryUtil.memAddress(param2)) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean SetWindowText(@NativeType(value="HWND") long param0, @NativeType(value="LPCTSTR") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF16(param2, true);
            long v5 = v3.getPointerAddress();
            boolean v7 = User32.nSetWindowText(param0, v5) != 0;
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native int nGetMessage(long var0, long var2, int var4, int var5, long var6);

    public static int nGetMessage(long param0, long param2, int param4, int param5) {
        long v6 = Functions.GetMessage;
        return User32.nGetMessage(param0, param2, param4, param5, v6);
    }

    @NativeType(value="BOOL")
    public static boolean GetMessage(@NativeType(value="LPMSG") MSG param0, @NativeType(value="HWND") long param1, @NativeType(value="UINT") int param3, @NativeType(value="UINT") int param4) {
        return User32.nGetMessage(param0.address(), param1, param3, param4) != 0;
    }

    public static int nPeekMessage(long param0, long param2, int param4, int param5, int param6) {
        long v7 = Functions.PeekMessage;
        return JNI.callPPI(param0, param2, param4, param5, param6, v7);
    }

    @NativeType(value="BOOL")
    public static boolean PeekMessage(@NativeType(value="LPMSG") MSG param0, @NativeType(value="HWND") long param1, @NativeType(value="UINT") int param3, @NativeType(value="UINT") int param4, @NativeType(value="UINT") int param5) {
        return User32.nPeekMessage(param0.address(), param1, param3, param4, param5) != 0;
    }

    public static int nTranslateMessage(long param0) {
        long v2 = Functions.TranslateMessage;
        return JNI.callPI(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean TranslateMessage(@NativeType(value="MSG const *") MSG param0) {
        return User32.nTranslateMessage(param0.address()) != 0;
    }

    public static native int nWaitMessage(long var0);

    @NativeType(value="BOOL")
    public static boolean WaitMessage() {
        long v0 = Functions.WaitMessage;
        return User32.nWaitMessage(v0) != 0;
    }

    public static long nDispatchMessage(long param0) {
        long v2 = Functions.DispatchMessage;
        return JNI.callPP(param0, v2);
    }

    @NativeType(value="LRESULT")
    public static long DispatchMessage(@NativeType(value="MSG const *") MSG param0) {
        return User32.nDispatchMessage(param0.address());
    }

    public static native int nPostMessage(long var0, int var2, long var3, long var5, long var7);

    @NativeType(value="BOOL")
    public static boolean PostMessage(@NativeType(value="HWND") long param0, @NativeType(value="UINT") int param2, @NativeType(value="WPARAM") long param3, @NativeType(value="LPARAM") long param5) {
        long v7 = Functions.PostMessage;
        return User32.nPostMessage(param0, param2, param3, param5, v7) != 0;
    }

    public static native int nSendMessage(long var0, int var2, long var3, long var5, long var7);

    @NativeType(value="BOOL")
    public static boolean SendMessage(@NativeType(value="HWND") long param0, @NativeType(value="UINT") int param2, @NativeType(value="WPARAM") long param3, @NativeType(value="LPARAM") long param5) {
        long v7 = Functions.SendMessage;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSendMessage(param0, param2, param3, param5, v7) != 0;
    }

    public static native int nAdjustWindowRectEx(long var0, int var2, int var3, int var4, long var5);

    public static int nAdjustWindowRectEx(long param0, int param2, int param3, int param4) {
        long v5 = Functions.AdjustWindowRectEx;
        return User32.nAdjustWindowRectEx(param0, param2, param3, param4, v5);
    }

    @NativeType(value="BOOL")
    public static boolean AdjustWindowRectEx(@NativeType(value="LPRECT") RECT param0, @NativeType(value="DWORD") int param1, @NativeType(value="BOOL") boolean param2, @NativeType(value="DWORD") int param3) {
        return User32.nAdjustWindowRectEx(param0.address(), param1, param2 ? 1 : 0, param3) != 0;
    }

    public static native int nGetWindowRect(long var0, long var2, long var4);

    public static int nGetWindowRect(long param0, long param2) {
        long v4 = Functions.GetWindowRect;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nGetWindowRect(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean GetWindowRect(@NativeType(value="HWND") long param0, @NativeType(value="LPRECT") RECT param2) {
        return User32.nGetWindowRect(param0, param2.address()) != 0;
    }

    public static native int nMoveWindow(long var0, int var2, int var3, int var4, int var5, int var6, long var7);

    @NativeType(value="BOOL")
    public static boolean MoveWindow(@NativeType(value="HWND") long param0, int param2, int param3, int param4, int param5, @NativeType(value="BOOL") boolean param6) {
        long v7 = Functions.MoveWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nMoveWindow(param0, param2, param3, param4, param5, param6 ? 1 : 0, v7) != 0;
    }

    public static native int nGetWindowPlacement(long var0, long var2, long var4);

    public static int nGetWindowPlacement(long param0, long param2) {
        long v4 = Functions.GetWindowPlacement;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nGetWindowPlacement(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean GetWindowPlacement(@NativeType(value="HWND") long param0, @NativeType(value="WINDOWPLACEMENT *") WINDOWPLACEMENT param2) {
        return User32.nGetWindowPlacement(param0, param2.address()) != 0;
    }

    public static native int nSetWindowPlacement(long var0, long var2, long var4);

    public static int nSetWindowPlacement(long param0, long param2) {
        long v4 = Functions.SetWindowPlacement;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetWindowPlacement(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean SetWindowPlacement(@NativeType(value="HWND") long param0, @NativeType(value="WINDOWPLACEMENT const *") WINDOWPLACEMENT param2) {
        return User32.nSetWindowPlacement(param0, param2.address()) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean IsWindowVisible(@NativeType(value="HWND") long param0) {
        long v2 = Functions.IsWindowVisible;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean IsIconic(@NativeType(value="HWND") long param0) {
        long v2 = Functions.IsIconic;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean IsZoomed(@NativeType(value="HWND") long param0) {
        long v2 = Functions.IsZoomed;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean BringWindowToTop(@NativeType(value="HWND") long param0) {
        long v2 = Functions.BringWindowToTop;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    public static native long nSetWindowLongPtr(long var0, int var2, long var3, long var5);

    @NativeType(value="LONG_PTR")
    public static long SetWindowLongPtr(@NativeType(value="HWND") long param0, int param2, @NativeType(value="LONG_PTR") long param3) {
        long v5 = Functions.SetWindowLongPtr;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetWindowLongPtr(param0, param2, param3, v5);
    }

    public static native long nGetWindowLongPtr(long var0, int var2, long var3);

    @NativeType(value="LONG_PTR")
    public static long GetWindowLongPtr(@NativeType(value="HWND") long param0, int param2) {
        long v3 = Functions.GetWindowLongPtr;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nGetWindowLongPtr(param0, param2, v3);
    }

    public static native long nSetClassLongPtr(long var0, int var2, long var3, long var5);

    @NativeType(value="LONG_PTR")
    public static long SetClassLongPtr(@NativeType(value="HWND") long param0, int param2, @NativeType(value="LONG_PTR") long param3) {
        long v5 = Functions.SetClassLongPtr;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetClassLongPtr(param0, param2, param3, v5);
    }

    public static native long nGetClassLongPtr(long var0, int var2, long var3);

    @NativeType(value="LONG_PTR")
    public static long GetClassLongPtr(@NativeType(value="HWND") long param0, int param2) {
        long v3 = Functions.GetClassLongPtr;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nGetClassLongPtr(param0, param2, v3);
    }

    public static native int nSetLayeredWindowAttributes(long var0, int var2, byte var3, int var4, long var5);

    @NativeType(value="BOOL")
    public static boolean SetLayeredWindowAttributes(@NativeType(value="HWND") long param0, @NativeType(value="COLORREF") int param2, @NativeType(value="BYTE") byte param3, @NativeType(value="DWORD") int param4) {
        long v5 = Functions.SetLayeredWindowAttributes;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return User32.nSetLayeredWindowAttributes(param0, param2, param3, param4, v5) != 0;
    }

    public static native long nLoadIcon(long var0, long var2, long var4);

    public static long nLoadIcon(long param0, long param2) {
        long v4 = Functions.LoadIcon;
        return User32.nLoadIcon(param0, param2, v4);
    }

    @NativeType(value="HICON")
    public static long LoadIcon(@NativeType(value="HINSTANCE") long param0, @NativeType(value="LPCTSTR") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param2);
        }
        return User32.nLoadIcon(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="HICON")
    public static long LoadIcon(@NativeType(value="HINSTANCE") long param0, @NativeType(value="LPCTSTR") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF16(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = User32.nLoadIcon(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native long nLoadCursor(long var0, long var2, long var4);

    public static long nLoadCursor(long param0, long param2) {
        long v4 = Functions.LoadCursor;
        return User32.nLoadCursor(param0, param2, v4);
    }

    @NativeType(value="HCURSOR")
    public static long LoadCursor(@NativeType(value="HINSTANCE") long param0, @NativeType(value="LPCTSTR") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT2(param2);
        }
        return User32.nLoadCursor(param0, MemoryUtil.memAddress(param2));
    }

    @NativeType(value="HCURSOR")
    public static long LoadCursor(@NativeType(value="HINSTANCE") long param0, @NativeType(value="LPCTSTR") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF16(param2, true);
            long v5 = v3.getPointerAddress();
            long v7 = User32.nLoadCursor(param0, v5);
            return v7;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    @NativeType(value="HDC")
    public static long GetDC(@NativeType(value="HWND") long param0) {
        long v2 = Functions.GetDC;
        return JNI.callPP(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean ReleaseDC(@NativeType(value="HWND") long param0, @NativeType(value="HDC") long param2) {
        long v4 = Functions.ReleaseDC;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
        }
        return JNI.callPPI(param0, param2, v4) != 0;
    }

    public static int GetSystemMetrics(int param0) {
        long v1 = Functions.GetSystemMetrics;
        return JNI.callI(param0, v1);
    }

    public static native int nRegisterTouchWindow(long var0, int var2, long var3);

    @NativeType(value="BOOL")
    public static boolean RegisterTouchWindow(@NativeType(value="HWND") long param0, @NativeType(value="ULONG") int param2) {
        long v3 = Functions.RegisterTouchWindow;
        if (Checks.CHECKS) {
            Checks.check(v3);
            Checks.check(param0);
        }
        return User32.nRegisterTouchWindow(param0, param2, v3) != 0;
    }

    public static native int nUnregisterTouchWindow(long var0, long var2);

    @NativeType(value="BOOL")
    public static boolean UnregisterTouchWindow(@NativeType(value="HWND") long param0) {
        long v2 = Functions.UnregisterTouchWindow;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return User32.nUnregisterTouchWindow(param0, v2) != 0;
    }

    public static int nIsTouchWindow(long param0, long param2) {
        long v4 = Functions.IsTouchWindow;
        if (Checks.CHECKS) {
            Checks.check(v4);
            Checks.check(param0);
        }
        return JNI.callPPI(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean IsTouchWindow(@NativeType(value="HWND") long param0, @Nullable @NativeType(value="PULONG") IntBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)param2, 1);
        }
        return User32.nIsTouchWindow(param0, MemoryUtil.memAddressSafe(param2)) != 0;
    }

    public static native int nGetTouchInputInfo(long var0, int var2, long var3, int var5, long var6);

    public static int nGetTouchInputInfo(long param0, int param2, long param3, int param5) {
        long v6 = Functions.GetTouchInputInfo;
        if (Checks.CHECKS) {
            Checks.check(v6);
            Checks.check(param0);
        }
        return User32.nGetTouchInputInfo(param0, param2, param3, param5, v6);
    }

    @NativeType(value="BOOL")
    public static boolean GetTouchInputInfo(@NativeType(value="HTOUCHINPUT") long param0, @NativeType(value="PTOUCHINPUT") TOUCHINPUT.Buffer param2, int param3) {
        return User32.nGetTouchInputInfo(param0, param2.remaining(), param2.address(), param3) != 0;
    }

    public static native int nCloseTouchInputHandle(long var0, long var2);

    @NativeType(value="BOOL")
    public static boolean CloseTouchInputHandle(@NativeType(value="HTOUCHINPUT") long param0) {
        long v2 = Functions.CloseTouchInputHandle;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return User32.nCloseTouchInputHandle(param0, v2) != 0;
    }

    @NativeType(value="HMONITOR")
    public static long MonitorFromWindow(@NativeType(value="HWND") long param0, @NativeType(value="DWORD") int param2) {
        long v3 = Functions.MonitorFromWindow;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPP(param0, param2, v3);
    }

    public static int nGetMonitorInfo(long param0, long param2) {
        long v4 = Functions.GetMonitorInfo;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPPI(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean GetMonitorInfo(@NativeType(value="HMONITOR") long param0, @NativeType(value="LPMONITORINFOEX") MONITORINFOEX param2) {
        return User32.nGetMonitorInfo(param0, param2.address()) != 0;
    }

    public static int nEnumDisplayDevices(long param0, int param2, long param3, int param5) {
        long v6 = Functions.EnumDisplayDevices;
        return JNI.callPPI(param0, param2, param3, param5, v6);
    }

    @NativeType(value="BOOL")
    public static boolean EnumDisplayDevices(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param0, @NativeType(value="DWORD") int param1, @NativeType(value="PDISPLAY_DEVICE") DISPLAY_DEVICE param2, @NativeType(value="DWORD") int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param0);
        }
        return User32.nEnumDisplayDevices(MemoryUtil.memAddressSafe(param0), param1, param2.address(), param3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean EnumDisplayDevices(@Nullable @NativeType(value="LPCTSTR") CharSequence param0, @NativeType(value="DWORD") int param1, @NativeType(value="PDISPLAY_DEVICE") DISPLAY_DEVICE param2, @NativeType(value="DWORD") int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF16Safe(param0, true);
            long v6 = param0 == null ? 0L : v4.getPointerAddress();
            boolean v8 = User32.nEnumDisplayDevices(v6, param1, param2.address(), param3) != 0;
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static int nEnumDisplaySettingsEx(long param0, int param2, long param3, int param5) {
        long v6 = Functions.EnumDisplaySettingsEx;
        return JNI.callPPI(param0, param2, param3, param5, v6);
    }

    @NativeType(value="BOOL")
    public static boolean EnumDisplaySettingsEx(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param0, @NativeType(value="DWORD") int param1, @NativeType(value="DEVMODE *") DEVMODE param2, @NativeType(value="DWORD") int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param0);
        }
        return User32.nEnumDisplaySettingsEx(MemoryUtil.memAddressSafe(param0), param1, param2.address(), param3) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean EnumDisplaySettingsEx(@Nullable @NativeType(value="LPCTSTR") CharSequence param0, @NativeType(value="DWORD") int param1, @NativeType(value="DEVMODE *") DEVMODE param2, @NativeType(value="DWORD") int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF16Safe(param0, true);
            long v6 = param0 == null ? 0L : v4.getPointerAddress();
            boolean v8 = User32.nEnumDisplaySettingsEx(v6, param1, param2.address(), param3) != 0;
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static int nChangeDisplaySettingsEx(long param0, long param2, long param4, int param6, long param7) {
        long v9 = Functions.ChangeDisplaySettingsEx;
        return JNI.callPPPPI(param0, param2, param4, param6, param7, v9);
    }

    @NativeType(value="LONG")
    public static int ChangeDisplaySettingsEx(@Nullable @NativeType(value="LPCTSTR") ByteBuffer param0, @Nullable @NativeType(value="DEVMODE *") DEVMODE param1, @NativeType(value="HWND") long param2, @NativeType(value="DWORD") int param4, @NativeType(value="LPVOID") long param5) {
        if (Checks.CHECKS) {
            Checks.checkNT2Safe(param0);
        }
        return User32.nChangeDisplaySettingsEx(MemoryUtil.memAddressSafe(param0), MemoryUtil.memAddressSafe(param1), param2, param4, param5);
    }

    @NativeType(value="LONG")
    public static int ChangeDisplaySettingsEx(@Nullable @NativeType(value="LPCTSTR") CharSequence param0, @Nullable @NativeType(value="DEVMODE *") DEVMODE param1, @NativeType(value="HWND") long param2, @NativeType(value="DWORD") int param4, @NativeType(value="LPVOID") long param5) {
        MemoryStack v7 = MemoryStack.stackGet();
        int v8 = v7.getPointer();
        try {
            v7.nUTF16Safe(param0, true);
            long v9 = param0 == null ? 0L : v7.getPointerAddress();
            int v11 = User32.nChangeDisplaySettingsEx(v9, MemoryUtil.memAddressSafe(param1), param2, param4, param5);
            return v11;
        }
        finally {
            v7.setPointer(v8);
        }
    }

    public static int nGetCursorPos(long param0) {
        long v2 = Functions.GetCursorPos;
        return JNI.callPI(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean GetCursorPos(@NativeType(value="LPPOINT") POINT param0) {
        return User32.nGetCursorPos(param0.address()) != 0;
    }

    @NativeType(value="BOOL")
    public static boolean SetCursorPos(int param0, int param1) {
        long v2 = Functions.SetCursorPos;
        return JNI.callI(param0, param1, v2) != 0;
    }

    public static int nClipCursor(long param0) {
        long v2 = Functions.ClipCursor;
        return JNI.callPI(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean ClipCursor(@Nullable @NativeType(value="RECT const *") RECT param0) {
        return User32.nClipCursor(MemoryUtil.memAddressSafe(param0)) != 0;
    }

    public static int ShowCursor(@NativeType(value="BOOL") boolean param0) {
        long v1 = Functions.ShowCursor;
        return JNI.callI(param0 ? 1 : 0, v1);
    }

    @NativeType(value="HCURSOR")
    public static long SetCursor(@NativeType(value="HCURSOR") long param0) {
        long v2 = Functions.SetCursor;
        return JNI.callPP(param0, v2);
    }

    public static int nClientToScreen(long param0, long param2) {
        long v4 = Functions.ClientToScreen;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.callPPI(param0, param2, v4);
    }

    @NativeType(value="BOOL")
    public static boolean ClientToScreen(@NativeType(value="HWND") long param0, @NativeType(value="LPPOINT") POINT param2) {
        return User32.nClientToScreen(param0, param2.address()) != 0;
    }

    @NativeType(value="SHORT")
    public static short GetAsyncKeyState(int param0) {
        long v1 = Functions.GetAsyncKeyState;
        return JNI.callS(param0, v1);
    }

    @NativeType(value="LPARAM")
    public static long GetMessageExtraInfo() {
        long v0 = Functions.GetMessageExtraInfo;
        return JNI.callP(v0);
    }

    public static int nSendInput(int param0, long param1, int param3) {
        long v4 = Functions.SendInput;
        return JNI.callPI(param0, param1, param3, v4);
    }

    @NativeType(value="UINT")
    public static int SendInput(@NativeType(value="PINPUT") INPUT.Buffer param0, int param1) {
        return User32.nSendInput(param0.remaining(), param0.address(), param1);
    }

    @NativeType(value="UINT")
    public static int GetDpiForSystem() {
        long v0 = Functions.GetDpiForSystem;
        if (Checks.CHECKS) {
            Checks.check(v0);
        }
        return JNI.callI(v0);
    }

    @NativeType(value="UINT")
    public static int GetDpiForWindow(@NativeType(value="HWND") long param0) {
        long v2 = Functions.GetDpiForWindow;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2);
    }

    @NativeType(value="DPI_AWARENESS")
    public static int GetAwarenessFromDpiAwarenessContext(@NativeType(value="DPI_AWARENESS_CONTEXT") long param0) {
        long v2 = Functions.GetAwarenessFromDpiAwarenessContext;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return JNI.callPI(param0, v2);
    }

    @NativeType(value="DPI_AWARENESS_CONTEXT")
    public static long GetThreadDpiAwarenessContext() {
        long v0 = Functions.GetThreadDpiAwarenessContext;
        if (Checks.CHECKS) {
            Checks.check(v0);
        }
        return JNI.callP(v0);
    }

    @NativeType(value="DPI_AWARENESS_CONTEXT")
    public static long GetWindowDpiAwarenessContext(@NativeType(value="HWND") long param0) {
        long v2 = Functions.GetWindowDpiAwarenessContext;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return JNI.callPP(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean IsValidDpiAwarenessContext(@NativeType(value="DPI_AWARENESS_CONTEXT") long param0) {
        long v2 = Functions.IsValidDpiAwarenessContext;
        if (Checks.CHECKS) {
            Checks.check(v2);
        }
        return JNI.callPI(param0, v2) != 0;
    }

    @NativeType(value="DPI_AWARENESS_CONTEXT")
    public static long SetThreadDpiAwarenessContext(@NativeType(value="DPI_AWARENESS_CONTEXT") long param0) {
        long v2 = Functions.SetThreadDpiAwarenessContext;
        if (Checks.CHECKS) {
            Checks.check(v2);
            Checks.check(param0);
        }
        return JNI.callPP(param0, v2);
    }

    @NativeType(value="BOOL")
    public static boolean IsTouchWindow(@NativeType(value="HWND") long param0, @Nullable @NativeType(value="PULONG") int[] param2) {
        long v3 = Functions.IsTouchWindow;
        if (Checks.CHECKS) {
            Checks.check(v3);
            Checks.check(param0);
            Checks.checkSafe(param2, 1);
        }
        return JNI.callPPI(param0, param2, v3) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return USER32;
    }

    static {
        KEYEVENTF_UNICODE = 4;
        KEYEVENTF_SCANCODE = 8;
        KEYEVENTF_KEYUP = 2;
        KEYEVENTF_EXTENDEDKEY = 1;
        MOUSEEVENTF_XUP = 256;
        MOUSEEVENTF_XDOWN = 128;
        MOUSEEVENTF_WHEEL = 2048;
        MOUSEEVENTF_VIRTUALDESK = 16384;
        MOUSEEVENTF_MIDDLEUP = 64;
        MOUSEEVENTF_MIDDLEDOWN = 32;
        MOUSEEVENTF_RIGHTUP = 16;
        MOUSEEVENTF_RIGHTDOWN = 8;
        MOUSEEVENTF_LEFTUP = 4;
        MOUSEEVENTF_LEFTDOWN = 2;
        MOUSEEVENTF_MOVE_NOCOALESCE = 8192;
        MOUSEEVENTF_MOVE = 1;
        MOUSEEVENTF_HWHEEL = 4096;
        MOUSEEVENTF_ABSOLUTE = 32768;
        INPUT_HARDWARE = 2;
        INPUT_KEYBOARD = 1;
        INPUT_MOUSE = 0;
        DISP_CHANGE_BADDUALVIEW = -6;
        DISP_CHANGE_BADPARAM = -5;
        DISP_CHANGE_BADFLAGS = -4;
        DISP_CHANGE_NOTUPDATED = -3;
        DISP_CHANGE_BADMODE = -2;
        DISP_CHANGE_FAILED = -1;
        DISP_CHANGE_RESTART = 1;
        DISP_CHANGE_SUCCESSFUL = 0;
        CDS_NORESET = 0x10000000;
        CDS_RESET_EX = 0x20000000;
        CDS_RESET = 0x40000000;
        CDS_DISABLE_UNSAFE_MODES = 512;
        CDS_ENABLE_UNSAFE_MODES = 256;
        CDS_VIDEOPARAMETERS = 32;
        CDS_SET_PRIMARY = 16;
        CDS_GLOBAL = 8;
        CDS_FULLSCREEN = 4;
        CDS_TEST = 2;
        CDS_UPDATEREGISTRY = 1;
        EDS_ROTATEDMODE = 4;
        EDS_RAWMODE = 2;
        ENUM_REGISTRY_SETTINGS = -2;
        ENUM_CURRENT_SETTINGS = -1;
        EDD_GET_DEVICE_INTERFACE_NAME = 1;
        MONITORINFOF_PRIMARY = 1;
        MONITOR_DEFAULTTONEAREST = 2;
        MONITOR_DEFAULTTOPRIMARY = 1;
        MONITOR_DEFAULTTONULL = 0;
        TOUCHINPUTMASKF_CONTACTAREA = 4;
        TOUCHINPUTMASKF_EXTRAINFO = 2;
        TOUCHINPUTMASKF_TIMEFROMSYSTEM = 1;
        TOUCHEVENTF_PALM = 128;
        TOUCHEVENTF_PEN = 64;
        TOUCHEVENTF_NOCOALESCE = 32;
        TOUCHEVENTF_PRIMARY = 16;
        TOUCHEVENTF_INRANGE = 8;
        TOUCHEVENTF_UP = 4;
        TOUCHEVENTF_DOWN = 2;
        TOUCHEVENTF_MOVE = 1;
        TWF_WANTPALM = 2;
        TWF_FINETOUCH = 1;
        SM_MAXIMUMTOUCHES = 95;
        SM_DIGITIZER = 94;
        SM_CXPADDEDBORDER = 92;
        SM_MOUSEHORIZONTALWHEELPRESENT = 91;
        SM_SERVERR2 = 89;
        SM_STARTER = 88;
        SM_MEDIACENTER = 87;
        SM_TABLETPC = 86;
        SM_CYFOCUSBORDER = 84;
        SM_CXFOCUSBORDER = 83;
        SM_CARETBLINKINGENABLED = 8194;
        SM_REMOTECONTROL = 8193;
        SM_SHUTTINGDOWN = 8192;
        SM_REMOTESESSION = 4096;
        SM_IMMENABLED = 82;
        SM_SAMEDISPLAYFORMAT = 81;
        SM_CMONITORS = 80;
        SM_CYVIRTUALSCREEN = 79;
        SM_CXVIRTUALSCREEN = 78;
        SM_YVIRTUALSCREEN = 77;
        SM_XVIRTUALSCREEN = 76;
        SM_MOUSEWHEELPRESENT = 75;
        SM_MIDEASTENABLED = 74;
        SM_SLOWMACHINE = 73;
        SM_CYMENUCHECK = 72;
        SM_CXMENUCHECK = 71;
        SM_SHOWSOUNDS = 70;
        SM_CYDRAG = 69;
        SM_CXDRAG = 68;
        SM_CLEANBOOT = 67;
        SM_NETWORK = 63;
        SM_CYMAXIMIZED = 62;
        SM_CXMAXIMIZED = 61;
        SM_CYMAXTRACK = 60;
        SM_CXMAXTRACK = 59;
        SM_CYMINIMIZED = 58;
        SM_CXMINIMIZED = 57;
        SM_ARRANGE = 56;
        SM_CYMENUSIZE = 55;
        SM_CXMENUSIZE = 54;
        SM_CYSMSIZE = 53;
        SM_CXSMSIZE = 52;
        SM_CYSMCAPTION = 51;
        SM_CYSMICON = 50;
        SM_CXSMICON = 49;
        SM_CYMINSPACING = 48;
        SM_CXMINSPACING = 47;
        SM_CYEDGE = 46;
        SM_CXEDGE = 45;
        SM_SECURE = 44;
        SM_CYSIZEFRAME = 33;
        SM_CXSIZEFRAME = 32;
        SM_CYFIXEDFRAME = 8;
        SM_CXFIXEDFRAME = 7;
        SM_CMOUSEBUTTONS = 43;
        SM_DBCSENABLED = 42;
        SM_PENWINDOWS = 41;
        SM_MENUDROPALIGNMENT = 40;
        SM_CYICONSPACING = 39;
        SM_CXICONSPACING = 38;
        SM_CYDOUBLECLK = 37;
        SM_CXDOUBLECLK = 36;
        SM_CYMINTRACK = 35;
        SM_CXMINTRACK = 34;
        SM_CYFRAME = 33;
        SM_CXFRAME = 32;
        SM_CYSIZE = 31;
        SM_CXSIZE = 30;
        SM_CYMIN = 29;
        SM_CXMIN = 28;
        SM_RESERVED4 = 27;
        SM_RESERVED3 = 26;
        SM_RESERVED2 = 25;
        SM_RESERVED1 = 24;
        SM_SWAPBUTTON = 23;
        SM_DEBUG = 22;
        SM_CXHSCROLL = 21;
        SM_CYVSCROLL = 20;
        SM_MOUSEPRESENT = 19;
        SM_CYKANJIWINDOW = 18;
        SM_CYFULLSCREEN = 17;
        SM_CXFULLSCREEN = 16;
        SM_CYMENU = 15;
        SM_CYCURSOR = 14;
        SM_CXCURSOR = 13;
        SM_CYICON = 12;
        SM_CXICON = 11;
        SM_CXHTHUMB = 10;
        SM_CYVTHUMB = 9;
        SM_CYDLGFRAME = 8;
        SM_CXDLGFRAME = 7;
        SM_CYBORDER = 6;
        SM_CXBORDER = 5;
        SM_CYCAPTION = 4;
        SM_CYHSCROLL = 3;
        SM_CXVSCROLL = 2;
        SM_CYSCREEN = 1;
        SM_CXSCREEN = 0;
        LWA_ALPHA = 2;
        LWA_COLORKEY = 1;
        WPF_ASYNCWINDOWPLACEMENT = 4;
        WPF_RESTORETOMAXIMIZED = 2;
        WPF_SETMINPOSITION = 1;
        DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE_V2 = -4L;
        DPI_AWARENESS_CONTEXT_PER_MONITOR_AWARE = -3L;
        DPI_AWARENESS_CONTEXT_SYSTEM_AWARE = -2L;
        DPI_AWARENESS_CONTEXT_UNAWARE = -1L;
        DPI_AWARENESS_PER_MONITOR_AWARE = 2;
        DPI_AWARENESS_SYSTEM_AWARE = 1;
        DPI_AWARENESS_UNAWARE = 0;
        DPI_AWARENESS_INVALID = -1;
        WHEEL_DELTA = 120;
        XBUTTON2 = 2;
        XBUTTON1 = 1;
        VK_OEM_CLEAR = 254;
        VK_PA1 = 253;
        VK_NONAME = 252;
        VK_ZOOM = 251;
        VK_PLAY = 250;
        VK_EREOF = 249;
        VK_EXSEL = 248;
        VK_CRSEL = 247;
        VK_ATTN = 246;
        VK_OEM_BACKTAB = 245;
        VK_OEM_ENLW = 244;
        VK_OEM_AUTO = 243;
        VK_OEM_COPY = 242;
        VK_OEM_FINISH = 241;
        VK_OEM_ATTN = 240;
        VK_OEM_CUSEL = 239;
        VK_OEM_WSCTRL = 238;
        VK_OEM_PA3 = 237;
        VK_OEM_PA2 = 236;
        VK_OEM_PA1 = 235;
        VK_OEM_JUMP = 234;
        VK_OEM_RESET = 233;
        VK_PACKET = 231;
        VK_ICO_CLEAR = 230;
        VK_PROCESSKEY = 229;
        VK_ICO_00 = 228;
        VK_ICO_HELP = 227;
        VK_OEM_102 = 226;
        VK_OEM_AX = 225;
        VK_OEM_8 = 223;
        VK_OEM_7 = 222;
        VK_OEM_6 = 221;
        VK_OEM_5 = 220;
        VK_OEM_4 = 219;
        VK_OEM_3 = 192;
        VK_OEM_2 = 191;
        VK_OEM_PERIOD = 190;
        VK_OEM_MINUS = 189;
        VK_OEM_COMMA = 188;
        VK_OEM_PLUS = 187;
        VK_OEM_1 = 186;
        VK_LAUNCH_APP2 = 183;
        VK_LAUNCH_APP1 = 182;
        VK_LAUNCH_MEDIA_SELECT = 181;
        VK_LAUNCH_MAIL = 180;
        VK_MEDIA_PLAY_PAUSE = 179;
        VK_MEDIA_STOP = 178;
        VK_MEDIA_PREV_TRACK = 177;
        VK_MEDIA_NEXT_TRACK = 176;
        VK_VOLUME_UP = 175;
        VK_VOLUME_DOWN = 174;
        VK_VOLUME_MUTE = 173;
        VK_BROWSER_HOME = 172;
        VK_BROWSER_FAVORITES = 171;
        VK_BROWSER_SEARCH = 170;
        VK_BROWSER_STOP = 169;
        VK_BROWSER_REFRESH = 168;
        VK_BROWSER_FORWARD = 167;
        VK_BROWSER_BACK = 166;
        VK_RMENU = 165;
        VK_LMENU = 164;
        VK_RCONTROL = 163;
        VK_LCONTROL = 162;
        VK_RSHIFT = 161;
        VK_LSHIFT = 160;
        VK_OEM_FJ_ROYA = 150;
        VK_OEM_FJ_LOYA = 149;
        VK_OEM_FJ_TOUROKU = 148;
        VK_OEM_FJ_MASSHOU = 147;
        VK_OEM_FJ_JISHO = 146;
        VK_OEM_NEC_EQUAL = 146;
        VK_SCROLL = 145;
        VK_NUMLOCK = 144;
        VK_F24 = 135;
        VK_F23 = 134;
        VK_F22 = 133;
        VK_F21 = 132;
        VK_F20 = 131;
        VK_F19 = 130;
        VK_F18 = 129;
        VK_F17 = 128;
        VK_F16 = 127;
        VK_F15 = 126;
        VK_F14 = 125;
        VK_F13 = 124;
        VK_F12 = 123;
        VK_F11 = 122;
        VK_F10 = 121;
        VK_F9 = 120;
        VK_F8 = 119;
        VK_F7 = 118;
        VK_F6 = 117;
        VK_F5 = 116;
        VK_F4 = 115;
        VK_F3 = 114;
        VK_F2 = 113;
        VK_F1 = 112;
        VK_DIVIDE = 111;
        VK_DECIMAL = 110;
        VK_SUBTRACT = 109;
        VK_SEPARATOR = 108;
        VK_ADD = 107;
        VK_MULTIPLY = 106;
        VK_NUMPAD9 = 105;
        VK_NUMPAD8 = 104;
        VK_NUMPAD7 = 103;
        VK_NUMPAD6 = 102;
        VK_NUMPAD5 = 101;
        VK_NUMPAD4 = 100;
        VK_NUMPAD3 = 99;
        VK_NUMPAD2 = 98;
        VK_NUMPAD1 = 97;
        VK_NUMPAD0 = 96;
        VK_SLEEP = 95;
        VK_APPS = 93;
        VK_RWIN = 92;
        VK_LWIN = 91;
        VK_HELP = 47;
        VK_DELETE = 46;
        VK_INSERT = 45;
        VK_SNAPSHOT = 44;
        VK_EXECUTE = 43;
        VK_PRINT = 42;
        VK_SELECT = 41;
        VK_DOWN = 40;
        VK_RIGHT = 39;
        VK_UP = 38;
        VK_LEFT = 37;
        VK_HOME = 36;
        VK_END = 35;
        VK_NEXT = 34;
        VK_PRIOR = 33;
        VK_SPACE = 32;
        VK_MODECHANGE = 31;
        VK_ACCEPT = 30;
        VK_NONCONVERT = 29;
        VK_CONVERT = 28;
        VK_ESCAPE = 27;
        VK_KANJI = 25;
        VK_HANJA = 25;
        VK_FINAL = 24;
        VK_JUNJA = 23;
        VK_HANGUL = 21;
        VK_HANGEUL = 21;
        VK_KANA = 21;
        VK_CAPITAL = 20;
        VK_PAUSE = 19;
        VK_MENU = 18;
        VK_CONTROL = 17;
        VK_SHIFT = 16;
        VK_RETURN = 13;
        VK_CLEAR = 12;
        VK_TAB = 9;
        VK_BACK = 8;
        VK_XBUTTON2 = 6;
        VK_XBUTTON1 = 5;
        VK_MBUTTON = 4;
        VK_CANCEL = 3;
        VK_RBUTTON = 2;
        VK_LBUTTON = 1;
        PM_QS_SENDMESSAGE = 0x400000;
        PM_QS_PAINT = 0x200000;
        PM_QS_POSTMESSAGE = 0x980000;
        PM_QS_INPUT = 458752;
        PM_NOYIELD = 2;
        PM_REMOVE = 1;
        PM_NOREMOVE = 0;
        QS_ALLINPUT = 255;
        QS_ALLEVENTS = 191;
        QS_INPUT = 7;
        QS_MOUSE = 6;
        QS_RAWINPUT = 1024;
        QS_ALLPOSTMESSAGE = 256;
        QS_HOTKEY = 128;
        QS_SENDMESSAGE = 64;
        QS_PAINT = 32;
        QS_TIMER = 16;
        QS_POSTMESSAGE = 8;
        QS_MOUSEBUTTON = 4;
        QS_MOUSEMOVE = 2;
        QS_KEY = 1;
        GCL_HICONSM = -34;
        GCW_ATOM = -32;
        GCL_STYLE = -26;
        GCL_WNDPROC = -24;
        GCL_CBCLSEXTRA = -20;
        GCL_CBWNDEXTRA = -18;
        GCL_HMODULE = -16;
        GCL_HICON = -14;
        GCL_HCURSOR = -12;
        GCL_HBRBACKGROUND = -10;
        GCL_MENUNAME = -8;
        IDC_HELP = 32651;
        IDC_APPSTARTING = 32650;
        IDC_HAND = 32649;
        IDC_NO = 32648;
        IDC_SIZEALL = 32646;
        IDC_SIZENS = 32645;
        IDC_SIZEWE = 32644;
        IDC_SIZENESW = 32643;
        IDC_SIZENWSE = 32642;
        IDC_ICON = 32641;
        IDC_SIZE = 32640;
        IDC_UPARROW = 32516;
        IDC_CROSS = 32515;
        IDC_WAIT = 32514;
        IDC_IBEAM = 32513;
        IDC_ARROW = 32512;
        IDI_INFORMATION = 32516;
        IDI_ERROR = 32513;
        IDI_WARNING = 32515;
        IDI_SHIELD = 32518;
        IDI_WINLOGO = 32517;
        IDI_ASTERISK = 32516;
        IDI_EXCLAMATION = 32515;
        IDI_QUESTION = 32514;
        IDI_HAND = 32513;
        IDI_APPLICATION = 32512;
        SWP_ASYNCWINDOWPOS = 16384;
        SWP_DEFERERASE = 8192;
        SWP_NOREPOSITION = 512;
        SWP_DRAWFRAME = 32;
        SWP_NOSENDCHANGING = 1024;
        SWP_NOOWNERZORDER = 512;
        SWP_NOCOPYBITS = 256;
        SWP_HIDEWINDOW = 128;
        SWP_SHOWWINDOW = 64;
        SWP_FRAMECHANGED = 32;
        SWP_NOACTIVATE = 16;
        SWP_NOREDRAW = 8;
        SWP_NOZORDER = 4;
        SWP_NOMOVE = 2;
        SWP_NOSIZE = 1;
        HWND_BROADCAST = 65535L;
        HWND_NOTOPMOST = -2L;
        HWND_TOPMOST = -1L;
        HWND_BOTTOM = 1L;
        HWND_TOP = 0L;
        SW_MAX = 11;
        SW_FORCEMINIMIZE = 11;
        SW_SHOWDEFAULT = 10;
        SW_RESTORE = 9;
        SW_SHOWNA = 8;
        SW_SHOWMINNOACTIVE = 7;
        SW_MINIMIZE = 6;
        SW_SHOW = 5;
        SW_SHOWNOACTIVATE = 4;
        SW_MAXIMIZE = 3;
        SW_SHOWMAXIMIZED = 3;
        SW_SHOWMINIMIZED = 2;
        SW_NORMAL = 1;
        SW_SHOWNORMAL = 1;
        SW_HIDE = 0;
        GWL_ID = -12;
        GWL_USERDATA = -21;
        GWL_EXSTYLE = -20;
        GWL_STYLE = -16;
        GWL_HWNDPARENT = -8;
        GWL_HINSTANCE = -6;
        GWL_WNDPROC = -4;
        HTHELP = 21;
        HTCLOSE = 20;
        HTOBJECT = 19;
        HTSIZELAST = 17;
        HTSIZEFIRST = 10;
        HTZOOM = 9;
        HTREDUCE = 8;
        HTBORDER = 18;
        HTBOTTOMRIGHT = 17;
        HTBOTTOMLEFT = 16;
        HTBOTTOM = 15;
        HTTOPRIGHT = 14;
        HTTOPLEFT = 13;
        HTTOP = 12;
        HTRIGHT = 11;
        HTLEFT = 10;
        HTMAXBUTTON = 9;
        HTMINBUTTON = 8;
        HTVSCROLL = 7;
        HTHSCROLL = 6;
        HTMENU = 5;
        HTSIZE = 4;
        HTGROWBOX = 4;
        HTSYSMENU = 3;
        HTCAPTION = 2;
        HTCLIENT = 1;
        HTNOWHERE = 0;
        HTTRANSPARENT = -1;
        HTERROR = -2;
        MK_XBUTTON2 = 64;
        MK_XBUTTON1 = 32;
        MK_MBUTTON = 16;
        MK_CONTROL = 8;
        MK_SHIFT = 4;
        MK_RBUTTON = 2;
        MK_LBUTTON = 1;
        SC_SEPARATOR = 61455;
        SC_CONTEXTHELP = 61824;
        SC_MONITORPOWER = 61808;
        SC_DEFAULT = 61792;
        SC_HOTKEY = 61776;
        SC_SCREENSAVE = 61760;
        SC_TASKLIST = 61744;
        SC_RESTORE = 61728;
        SC_ARRANGE = 61712;
        SC_KEYMENU = 61696;
        SC_MOUSEMENU = 61584;
        SC_HSCROLL = 61568;
        SC_VSCROLL = 61552;
        SC_CLOSE = 61536;
        SC_PREVWINDOW = 61520;
        SC_NEXTWINDOW = 61504;
        SC_MAXIMIZE = 61488;
        SC_MINIMIZE = 61472;
        SC_MOVE = 61456;
        SC_SIZE = 61440;
        DBT_MONITORCHANGE = 27;
        DBT_CONFIGCHANGECANCELED = 25;
        DBT_CONFIGCHANGED = 24;
        DBT_QUERYCHANGECONFIG = 23;
        DBT_DEVNODES_CHANGED = 7;
        DBT_APPYEND = 1;
        DBT_APPYBEGIN = 0;
        SIZE_MAXHIDE = 4;
        SIZE_MAXSHOW = 3;
        SIZE_MAXIMIZED = 2;
        SIZE_MINIMIZED = 1;
        SIZE_RESTORED = 0;
        WA_INACTIVE = 0;
        WA_CLICKACTIVE = 2;
        WA_ACTIVE = 1;
        WM_USER = 1024;
        WM_APP = 32768;
        WM_PENWINLAST = 911;
        WM_PENWINFIRST = 896;
        WM_AFXLAST = 895;
        WM_AFXFIRST = 864;
        WM_HANDHELDLAST = 863;
        WM_HANDHELDFIRST = 856;
        WM_GETTITLEBARINFOEX = 831;
        WM_DWMSENDICONICLIVEPREVIEWBITMAP = 806;
        WM_DWMSENDICONICTHUMBNAIL = 803;
        WM_DWMWINDOWMAXIMIZEDCHANGE = 801;
        WM_DWMCOLORIZATIONCOLORCHANGED = 800;
        WM_DWMNCRENDERINGCHANGED = 799;
        WM_DWMCOMPOSITIONCHANGED = 798;
        WM_CLIPBOARDUPDATE = 797;
        WM_THEMECHANGED = 794;
        WM_APPCOMMAND = 793;
        WM_PRINTCLIENT = 792;
        WM_PRINT = 791;
        WM_HOTKEY = 786;
        WM_PALETTECHANGED = 785;
        WM_PALETTEISCHANGING = 784;
        WM_QUERYNEWPALETTE = 783;
        WM_HSCROLLCLIPBOARD = 782;
        WM_CHANGECBCHAIN = 781;
        WM_ASKCBFORMATNAME = 780;
        WM_SIZECLIPBOARD = 779;
        WM_VSCROLLCLIPBOARD = 778;
        WM_PAINTCLIPBOARD = 777;
        WM_DRAWCLIPBOARD = 776;
        WM_DESTROYCLIPBOARD = 775;
        WM_RENDERALLFORMATS = 774;
        WM_RENDERFORMAT = 773;
        WM_UNDO = 772;
        WM_CLEAR = 771;
        WM_PASTE = 770;
        WM_COPY = 769;
        WM_CUT = 768;
        WM_TABLET_LAST = 735;
        WM_TABLET_FIRST = 704;
        WM_WTSSESSION_CHANGE = 689;
        WM_NCMOUSELEAVE = 674;
        WM_NCMOUSEHOVER = 672;
        WM_MOUSELEAVE = 675;
        WM_MOUSEHOVER = 673;
        WM_IME_KEYUP = 657;
        WM_IME_KEYDOWN = 656;
        WM_IME_REQUEST = 648;
        WM_IME_CHAR = 646;
        WM_IME_SELECT = 645;
        WM_IME_COMPOSITIONFULL = 644;
        WM_IME_CONTROL = 643;
        WM_IME_NOTIFY = 642;
        WM_IME_SETCONTEXT = 641;
        WM_TOUCH = 576;
        WM_MDIREFRESHMENU = 564;
        WM_DROPFILES = 563;
        WM_EXITSIZEMOVE = 562;
        WM_ENTERSIZEMOVE = 561;
        WM_MDISETMENU = 560;
        WM_MDIGETACTIVE = 553;
        WM_MDIICONARRANGE = 552;
        WM_MDICASCADE = 551;
        WM_MDITILE = 550;
        WM_MDIMAXIMIZE = 549;
        WM_MDINEXT = 548;
        WM_MDIRESTORE = 547;
        WM_MDIACTIVATE = 546;
        WM_MDIDESTROY = 545;
        WM_MDICREATE = 544;
        WM_DEVICECHANGE = 537;
        WM_POWERBROADCAST = 536;
        WM_MOVING = 534;
        WM_CAPTURECHANGED = 533;
        WM_SIZING = 532;
        WM_NEXTMENU = 531;
        WM_EXITMENULOOP = 530;
        WM_ENTERMENULOOP = 529;
        WM_PARENTNOTIFY = 528;
        WM_MOUSEHWHEEL = 526;
        WM_XBUTTONDBLCLK = 525;
        WM_XBUTTONUP = 524;
        WM_XBUTTONDOWN = 523;
        WM_MOUSEWHEEL = 522;
        WM_MBUTTONDBLCLK = 521;
        WM_MBUTTONUP = 520;
        WM_MBUTTONDOWN = 519;
        WM_RBUTTONDBLCLK = 518;
        WM_RBUTTONUP = 517;
        WM_RBUTTONDOWN = 516;
        WM_LBUTTONDBLCLK = 515;
        WM_LBUTTONUP = 514;
        WM_LBUTTONDOWN = 513;
        WM_MOUSEMOVE = 512;
        WM_MOUSEFIRST = 512;
        MN_GETHMENU = 481;
        WM_CTLCOLORSTATIC = 312;
        WM_CTLCOLORSCROLLBAR = 311;
        WM_CTLCOLORDLG = 310;
        WM_CTLCOLORBTN = 309;
        WM_CTLCOLORLISTBOX = 308;
        WM_CTLCOLOREDIT = 307;
        WM_CTLCOLORMSGBOX = 306;
        WM_QUERYUISTATE = 297;
        WM_UPDATEUISTATE = 296;
        WM_CHANGEUISTATE = 295;
        WM_MENUCOMMAND = 294;
        WM_UNINITMENUPOPUP = 293;
        WM_MENUGETOBJECT = 292;
        WM_MENUDRAG = 291;
        WM_MENURBUTTONUP = 290;
        WM_ENTERIDLE = 289;
        WM_MENUCHAR = 288;
        WM_MENUSELECT = 287;
        WM_GESTURENOTIFY = 282;
        WM_GESTURE = 281;
        WM_INITMENUPOPUP = 279;
        WM_INITMENU = 278;
        WM_VSCROLL = 277;
        WM_HSCROLL = 276;
        WM_TIMER = 275;
        WM_SYSCOMMAND = 274;
        WM_COMMAND = 273;
        WM_INITDIALOG = 272;
        WM_IME_KEYLAST = 271;
        WM_IME_COMPOSITION = 271;
        WM_IME_ENDCOMPOSITION = 270;
        WM_IME_STARTCOMPOSITION = 269;
        UNICODE_NOCHAR = 65535;
        WM_UNICHAR = 265;
        WM_SYSDEADCHAR = 263;
        WM_SYSCHAR = 262;
        WM_SYSKEYUP = 261;
        WM_SYSKEYDOWN = 260;
        WM_DEADCHAR = 259;
        WM_CHAR = 258;
        WM_KEYUP = 257;
        WM_KEYDOWN = 256;
        WM_KEYFIRST = 256;
        WM_INPUT = 255;
        WM_INPUT_DEVICE_CHANGE = 254;
        WM_NCXBUTTONDBLCLK = 173;
        WM_NCXBUTTONUP = 172;
        WM_NCXBUTTONDOWN = 171;
        WM_NCMBUTTONDBLCLK = 169;
        WM_NCMBUTTONUP = 168;
        WM_NCMBUTTONDOWN = 167;
        WM_NCRBUTTONDBLCLK = 166;
        WM_NCRBUTTONUP = 165;
        WM_NCRBUTTONDOWN = 164;
        WM_NCLBUTTONDBLCLK = 163;
        WM_NCLBUTTONUP = 162;
        WM_NCLBUTTONDOWN = 161;
        WM_NCMOUSEMOVE = 160;
        WM_SYNCPAINT = 136;
        WM_GETDLGCODE = 135;
        WM_NCACTIVATE = 134;
        WM_NCPAINT = 133;
        WM_NCHITTEST = 132;
        WM_NCCALCSIZE = 131;
        WM_NCDESTROY = 130;
        WM_NCCREATE = 129;
        WM_SETICON = 128;
        WM_GETICON = 127;
        WM_DISPLAYCHANGE = 126;
        WM_STYLECHANGED = 125;
        WM_STYLECHANGING = 124;
        WM_CONTEXTMENU = 123;
        WM_NOTIFYFORMAT = 85;
        WM_USERCHANGED = 84;
        WM_HELP = 83;
        WM_TCARD = 82;
        WM_INPUTLANGCHANGE = 81;
        WM_INPUTLANGCHANGEREQUEST = 80;
        WM_NOTIFY = 78;
        WM_CANCELJOURNAL = 75;
        WM_COPYDATA = 74;
        WM_POWER = 72;
        WM_WINDOWPOSCHANGED = 71;
        WM_WINDOWPOSCHANGING = 70;
        WM_COMMNOTIFY = 68;
        WM_COMPACTING = 65;
        WM_GETOBJECT = 61;
        WM_COMPAREITEM = 57;
        WM_QUERYDRAGICON = 55;
        WM_GETHOTKEY = 51;
        WM_SETHOTKEY = 50;
        WM_GETFONT = 49;
        WM_SETFONT = 48;
        WM_CHARTOITEM = 47;
        WM_VKEYTOITEM = 46;
        WM_DELETEITEM = 45;
        WM_MEASUREITEM = 44;
        WM_DRAWITEM = 43;
        WM_SPOOLERSTATUS = 42;
        WM_NEXTDLGCTL = 40;
        WM_ICONERASEBKGND = 39;
        WM_PAINTICON = 38;
        WM_GETMINMAXINFO = 36;
        WM_QUEUESYNC = 35;
        WM_CHILDACTIVATE = 34;
        WM_MOUSEACTIVATE = 33;
        WM_SETCURSOR = 32;
        WM_CANCELMODE = 31;
        WM_TIMECHANGE = 30;
        WM_FONTCHANGE = 29;
        WM_ACTIVATEAPP = 28;
        WM_DEVMODECHANGE = 27;
        WM_SETTINGCHANGE = 26;
        WM_WININICHANGE = 26;
        WM_SHOWWINDOW = 24;
        WM_SYSCOLORCHANGE = 21;
        WM_ERASEBKGND = 20;
        WM_QUIT = 18;
        WM_ENDSESSION = 22;
        WM_QUERYOPEN = 19;
        WM_QUERYENDSESSION = 17;
        WM_CLOSE = 16;
        WM_PAINT = 15;
        WM_GETTEXTLENGTH = 14;
        WM_GETTEXT = 13;
        WM_SETTEXT = 12;
        WM_SETREDRAW = 11;
        WM_ENABLE = 10;
        WM_KILLFOCUS = 8;
        WM_SETFOCUS = 7;
        WM_ACTIVATE = 6;
        WM_SIZE = 5;
        WM_MOVE = 3;
        WM_DESTROY = 2;
        WM_CREATE = 1;
        WM_NULL = 0;
        CS_DROPSHADOW = 131072;
        CS_IME = 65536;
        CS_GLOBALCLASS = 16384;
        CS_BYTEALIGNWINDOW = 8192;
        CS_BYTEALIGNCLIENT = 4096;
        CS_SAVEBITS = 2048;
        CS_NOCLOSE = 512;
        CS_PARENTDC = 128;
        CS_CLASSDC = 64;
        CS_OWNDC = 32;
        CS_DBLCLKS = 8;
        CS_HREDRAW = 2;
        CS_VREDRAW = 1;
        CW_USEDEFAULT = Integer.MIN_VALUE;
        WS_EX_NOACTIVATE = 0x8000000;
        WS_EX_COMPOSITED = 0x2000000;
        WS_EX_LAYOUTRTL = 0x400000;
        WS_EX_NOINHERITLAYOUT = 0x100000;
        WS_EX_LAYERED = 524288;
        WS_EX_PALETTEWINDOW = 392;
        WS_EX_OVERLAPPEDWINDOW = 768;
        WS_EX_APPWINDOW = 262144;
        WS_EX_STATICEDGE = 131072;
        WS_EX_CONTROLPARENT = 65536;
        WS_EX_RIGHTSCROLLBAR = 0;
        WS_EX_LEFTSCROLLBAR = 16384;
        WS_EX_LTRREADING = 0;
        WS_EX_RTLREADING = 8192;
        WS_EX_LEFT = 0;
        WS_EX_RIGHT = 4096;
        WS_EX_CONTEXTHELP = 1024;
        WS_EX_CLIENTEDGE = 512;
        WS_EX_WINDOWEDGE = 256;
        WS_EX_TOOLWINDOW = 128;
        WS_EX_MDICHILD = 64;
        WS_EX_TRANSPARENT = 32;
        WS_EX_ACCEPTFILES = 16;
        WS_EX_TOPMOST = 8;
        WS_EX_NOPARENTNOTIFY = 4;
        WS_EX_DLGMODALFRAME = 1;
        WS_TILEDWINDOW = 0xCF0000;
        WS_SIZEBOX = 262144;
        WS_ICONIC = 0x20000000;
        WS_TILED = 0;
        WS_CHILDWINDOW = 0x40000000;
        WS_POPUPWINDOW = -2138570752;
        WS_OVERLAPPEDWINDOW = 0xCF0000;
        WS_MAXIMIZEBOX = 65536;
        WS_MINIMIZEBOX = 131072;
        WS_TABSTOP = 65536;
        WS_GROUP = 131072;
        WS_THICKFRAME = 262144;
        WS_SYSMENU = 524288;
        WS_HSCROLL = 0x100000;
        WS_VSCROLL = 0x200000;
        WS_DLGFRAME = 0x400000;
        WS_BORDER = 0x800000;
        WS_CAPTION = 0xC00000;
        WS_MAXIMIZE = 0x1000000;
        WS_CLIPCHILDREN = 0x2000000;
        WS_CLIPSIBLINGS = 0x4000000;
        WS_DISABLED = 0x8000000;
        WS_VISIBLE = 0x10000000;
        WS_MINIMIZE = 0x20000000;
        WS_CHILD = 0x40000000;
        WS_POPUP = Integer.MIN_VALUE;
        WS_OVERLAPPED = 0;
        USER32 = Library.loadNative(User32.class, "org.lwjgl", "user32");
    }

    public static final class Functions {
        public static final long RegisterClassEx = APIUtil.apiGetFunctionAddress(User32.access$000(), "RegisterClassExW");
        public static final long UnregisterClass = APIUtil.apiGetFunctionAddress(User32.access$000(), "UnregisterClassW");
        public static final long CreateWindowEx = APIUtil.apiGetFunctionAddress(User32.access$000(), "CreateWindowExW");
        public static final long DestroyWindow = APIUtil.apiGetFunctionAddress(User32.access$000(), "DestroyWindow");
        public static final long DefWindowProc = APIUtil.apiGetFunctionAddress(User32.access$000(), "DefWindowProcW");
        public static final long CallWindowProc = APIUtil.apiGetFunctionAddress(User32.access$000(), "CallWindowProcW");
        public static final long ShowWindow = APIUtil.apiGetFunctionAddress(User32.access$000(), "ShowWindow");
        public static final long UpdateWindow = APIUtil.apiGetFunctionAddress(User32.access$000(), "UpdateWindow");
        public static final long SetWindowPos = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetWindowPos");
        public static final long SetWindowText = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetWindowTextW");
        public static final long GetMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetMessageW");
        public static final long PeekMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "PeekMessageW");
        public static final long TranslateMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "TranslateMessage");
        public static final long WaitMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "WaitMessage");
        public static final long DispatchMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "DispatchMessageW");
        public static final long PostMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "PostMessageW");
        public static final long SendMessage = APIUtil.apiGetFunctionAddress(User32.access$000(), "SendMessageW");
        public static final long AdjustWindowRectEx = APIUtil.apiGetFunctionAddress(User32.access$000(), "AdjustWindowRectEx");
        public static final long GetWindowRect = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetWindowRect");
        public static final long MoveWindow = APIUtil.apiGetFunctionAddress(User32.access$000(), "MoveWindow");
        public static final long GetWindowPlacement = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetWindowPlacement");
        public static final long SetWindowPlacement = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetWindowPlacement");
        public static final long IsWindowVisible = APIUtil.apiGetFunctionAddress(User32.access$000(), "IsWindowVisible");
        public static final long IsIconic = APIUtil.apiGetFunctionAddress(User32.access$000(), "IsIconic");
        public static final long IsZoomed = APIUtil.apiGetFunctionAddress(User32.access$000(), "IsZoomed");
        public static final long BringWindowToTop = APIUtil.apiGetFunctionAddress(User32.access$000(), "BringWindowToTop");
        public static final long SetWindowLongPtr = APIUtil.apiGetFunctionAddress(User32.access$000(), Pointer.BITS64 ? "SetWindowLongPtrW" : "SetWindowLongW");
        public static final long GetWindowLongPtr = APIUtil.apiGetFunctionAddress(User32.access$000(), Pointer.BITS64 ? "GetWindowLongPtrW" : "GetWindowLongW");
        public static final long SetClassLongPtr = APIUtil.apiGetFunctionAddress(User32.access$000(), Pointer.BITS64 ? "SetClassLongPtrW" : "SetClassLongW");
        public static final long GetClassLongPtr = APIUtil.apiGetFunctionAddress(User32.access$000(), Pointer.BITS64 ? "GetClassLongPtrW" : "GetClassLongW");
        public static final long SetLayeredWindowAttributes = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetLayeredWindowAttributes");
        public static final long LoadIcon = APIUtil.apiGetFunctionAddress(User32.access$000(), "LoadIconW");
        public static final long LoadCursor = APIUtil.apiGetFunctionAddress(User32.access$000(), "LoadCursorW");
        public static final long GetDC = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetDC");
        public static final long ReleaseDC = APIUtil.apiGetFunctionAddress(User32.access$000(), "ReleaseDC");
        public static final long GetSystemMetrics = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetSystemMetrics");
        public static final long RegisterTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "RegisterTouchWindow");
        public static final long UnregisterTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "UnregisterTouchWindow");
        public static final long IsTouchWindow = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "IsTouchWindow");
        public static final long GetTouchInputInfo = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetTouchInputInfo");
        public static final long CloseTouchInputHandle = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "CloseTouchInputHandle");
        public static final long MonitorFromWindow = APIUtil.apiGetFunctionAddress(User32.access$000(), "MonitorFromWindow");
        public static final long GetMonitorInfo = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetMonitorInfoW");
        public static final long EnumDisplayDevices = APIUtil.apiGetFunctionAddress(User32.access$000(), "EnumDisplayDevicesW");
        public static final long EnumDisplaySettingsEx = APIUtil.apiGetFunctionAddress(User32.access$000(), "EnumDisplaySettingsExW");
        public static final long ChangeDisplaySettingsEx = APIUtil.apiGetFunctionAddress(User32.access$000(), "ChangeDisplaySettingsExW");
        public static final long GetCursorPos = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetCursorPos");
        public static final long SetCursorPos = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetCursorPos");
        public static final long ClipCursor = APIUtil.apiGetFunctionAddress(User32.access$000(), "ClipCursor");
        public static final long ShowCursor = APIUtil.apiGetFunctionAddress(User32.access$000(), "ShowCursor");
        public static final long SetCursor = APIUtil.apiGetFunctionAddress(User32.access$000(), "SetCursor");
        public static final long ClientToScreen = APIUtil.apiGetFunctionAddress(User32.access$000(), "ClientToScreen");
        public static final long GetAsyncKeyState = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetAsyncKeyState");
        public static final long GetMessageExtraInfo = APIUtil.apiGetFunctionAddress(User32.access$000(), "GetMessageExtraInfo");
        public static final long SendInput = APIUtil.apiGetFunctionAddress(User32.access$000(), "SendInput");
        public static final long GetDpiForSystem = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetDpiForSystem");
        public static final long GetDpiForWindow = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetDpiForWindow");
        public static final long GetAwarenessFromDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetAwarenessFromDpiAwarenessContext");
        public static final long GetThreadDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetThreadDpiAwarenessContext");
        public static final long GetWindowDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "GetWindowDpiAwarenessContext");
        public static final long IsValidDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "IsValidDpiAwarenessContext");
        public static final long SetThreadDpiAwarenessContext = APIUtil.apiGetFunctionAddressOptional(User32.access$000(), "SetThreadDpiAwarenessContext");

        private Functions() {
        }
    }
}

