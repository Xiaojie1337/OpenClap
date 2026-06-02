/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;
import org.lwjgl.nanovg.BNDnodeTheme;
import org.lwjgl.nanovg.BNDtheme;
import org.lwjgl.nanovg.BNDwidgetTheme;
import org.lwjgl.nanovg.LibNanoVG;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class Blendish {
    public static final float BND_DISABLED_ALPHA;
    public static final int BND_LEFT;
    public static final int BND_CENTER;
    public static final int BND_DEFAULT;
    public static final int BND_HOVER;
    public static final int BND_ACTIVE;
    public static final int BND_CORNER_NONE;
    public static final int BND_CORNER_TOP_LEFT;
    public static final int BND_CORNER_TOP_RIGHT;
    public static final int BND_CORNER_DOWN_RIGHT;
    public static final int BND_CORNER_DOWN_LEFT;
    public static final int BND_CORNER_ALL;
    public static final int BND_CORNER_TOP;
    public static final int BND_CORNER_DOWN;
    public static final int BND_CORNER_LEFT;
    public static final int BND_CORNER_RIGHT;
    public static final int BND_WIDGET_HEIGHT;
    public static final int BND_TOOL_WIDTH;
    public static final int BND_NODE_PORT_RADIUS;
    public static final int BND_NODE_MARGIN_TOP;
    public static final int BND_NODE_MARGIN_DOWN;
    public static final int BND_NODE_MARGIN_SIDE;
    public static final int BND_NODE_TITLE_HEIGHT;
    public static final int BND_NODE_ARROW_AREA_WIDTH;
    public static final int BND_SPLITTER_AREA_SIZE;
    public static final int BND_SCROLLBAR_WIDTH;
    public static final int BND_SCROLLBAR_HEIGHT;
    public static final int BND_VSPACING;
    public static final int BND_VSPACING_GROUP;
    public static final int BND_HSPACING;
    public static final int BND_ICON_NONE;
    public static final int BND_ICON_QUESTION;
    public static final int BND_ICON_ERROR;
    public static final int BND_ICON_CANCEL;
    public static final int BND_ICON_TRIA_RIGHT;
    public static final int BND_ICON_TRIA_DOWN;
    public static final int BND_ICON_TRIA_LEFT;
    public static final int BND_ICON_TRIA_UP;
    public static final int BND_ICON_ARROW_LEFTRIGHT;
    public static final int BND_ICON_PLUS;
    public static final int BND_ICON_DISCLOSURE_TRI_DOWN;
    public static final int BND_ICON_DISCLOSURE_TRI_RIGHT;
    public static final int BND_ICON_RADIOBUT_OFF;
    public static final int BND_ICON_RADIOBUT_ON;
    public static final int BND_ICON_MENU_PANEL;
    public static final int BND_ICON_BLENDER;
    public static final int BND_ICON_GRIP;
    public static final int BND_ICON_DOT;
    public static final int BND_ICON_COLLAPSEMENU;
    public static final int BND_ICON_X;
    public static final int BND_ICON_GO_LEFT;
    public static final int BND_ICON_PLUG;
    public static final int BND_ICON_UI;
    public static final int BND_ICON_NODE;
    public static final int BND_ICON_NODE_SEL;
    public static final int BND_ICON_FULLSCREEN;
    public static final int BND_ICON_SPLITSCREEN;
    public static final int BND_ICON_RIGHTARROW_THIN;
    public static final int BND_ICON_BORDERMOVE;
    public static final int BND_ICON_VIEWZOOM;
    public static final int BND_ICON_ZOOMIN;
    public static final int BND_ICON_ZOOMOUT;
    public static final int BND_ICON_PANEL_CLOSE;
    public static final int BND_ICON_COPY_ID;
    public static final int BND_ICON_EYEDROPPER;
    public static final int BND_ICON_LINK_AREA;
    public static final int BND_ICON_AUTO;
    public static final int BND_ICON_CHECKBOX_DEHLT;
    public static final int BND_ICON_CHECKBOX_HLT;
    public static final int BND_ICON_UNLOCKED;
    public static final int BND_ICON_LOCKED;
    public static final int BND_ICON_UNPINNED;
    public static final int BND_ICON_PINNED;
    public static final int BND_ICON_SCREEN_BACK;
    public static final int BND_ICON_RIGHTARROW;
    public static final int BND_ICON_DOWNARROW_HLT;
    public static final int BND_ICON_DOTSUP;
    public static final int BND_ICON_DOTSDOWN;
    public static final int BND_ICON_LINK;
    public static final int BND_ICON_INLINK;
    public static final int BND_ICON_PLUGIN;
    public static final int BND_ICON_HELP;
    public static final int BND_ICON_GHOST_ENABLED;
    public static final int BND_ICON_COLOR;
    public static final int BND_ICON_LINKED;
    public static final int BND_ICON_UNLINKED;
    public static final int BND_ICON_HAND;
    public static final int BND_ICON_ZOOM_ALL;
    public static final int BND_ICON_ZOOM_SELECTED;
    public static final int BND_ICON_ZOOM_PREVIOUS;
    public static final int BND_ICON_ZOOM_IN;
    public static final int BND_ICON_ZOOM_OUT;
    public static final int BND_ICON_RENDER_REGION;
    public static final int BND_ICON_BORDER_RECT;
    public static final int BND_ICON_BORDER_LASSO;
    public static final int BND_ICON_FREEZE;
    public static final int BND_ICON_STYLUS_PRESSURE;
    public static final int BND_ICON_GHOST_DISABLED;
    public static final int BND_ICON_NEW;
    public static final int BND_ICON_FILE_TICK;
    public static final int BND_ICON_QUIT;
    public static final int BND_ICON_URL;
    public static final int BND_ICON_RECOVER_LAST;
    public static final int BND_ICON_FULLSCREEN_ENTER;
    public static final int BND_ICON_FULLSCREEN_EXIT;
    public static final int BND_ICON_BLANK1;
    public static final int BND_ICON_LAMP;
    public static final int BND_ICON_MATERIAL;
    public static final int BND_ICON_TEXTURE;
    public static final int BND_ICON_ANIM;
    public static final int BND_ICON_WORLD;
    public static final int BND_ICON_SCENE;
    public static final int BND_ICON_EDIT;
    public static final int BND_ICON_GAME;
    public static final int BND_ICON_RADIO;
    public static final int BND_ICON_SCRIPT;
    public static final int BND_ICON_PARTICLES;
    public static final int BND_ICON_PHYSICS;
    public static final int BND_ICON_SPEAKER;
    public static final int BND_ICON_TEXTURE_SHADED;
    public static final int BND_ICON_VIEW3D;
    public static final int BND_ICON_IPO;
    public static final int BND_ICON_OOPS;
    public static final int BND_ICON_BUTS;
    public static final int BND_ICON_FILESEL;
    public static final int BND_ICON_IMAGE_COL;
    public static final int BND_ICON_INFO;
    public static final int BND_ICON_SEQUENCE;
    public static final int BND_ICON_TEXT;
    public static final int BND_ICON_IMASEL;
    public static final int BND_ICON_SOUND;
    public static final int BND_ICON_ACTION;
    public static final int BND_ICON_NLA;
    public static final int BND_ICON_SCRIPTWIN;
    public static final int BND_ICON_TIME;
    public static final int BND_ICON_NODETREE;
    public static final int BND_ICON_LOGIC;
    public static final int BND_ICON_CONSOLE;
    public static final int BND_ICON_PREFERENCES;
    public static final int BND_ICON_CLIP;
    public static final int BND_ICON_ASSET_MANAGER;
    public static final int BND_ICON_OBJECT_DATAMODE;
    public static final int BND_ICON_EDITMODE_HLT;
    public static final int BND_ICON_FACESEL_HLT;
    public static final int BND_ICON_VPAINT_HLT;
    public static final int BND_ICON_TPAINT_HLT;
    public static final int BND_ICON_WPAINT_HLT;
    public static final int BND_ICON_SCULPTMODE_HLT;
    public static final int BND_ICON_POSE_HLT;
    public static final int BND_ICON_PARTICLEMODE;
    public static final int BND_ICON_LIGHTPAINT;
    public static final int BND_ICON_SCENE_DATA;
    public static final int BND_ICON_RENDERLAYERS;
    public static final int BND_ICON_WORLD_DATA;
    public static final int BND_ICON_OBJECT_DATA;
    public static final int BND_ICON_MESH_DATA;
    public static final int BND_ICON_CURVE_DATA;
    public static final int BND_ICON_META_DATA;
    public static final int BND_ICON_LATTICE_DATA;
    public static final int BND_ICON_LAMP_DATA;
    public static final int BND_ICON_MATERIAL_DATA;
    public static final int BND_ICON_TEXTURE_DATA;
    public static final int BND_ICON_ANIM_DATA;
    public static final int BND_ICON_CAMERA_DATA;
    public static final int BND_ICON_PARTICLE_DATA;
    public static final int BND_ICON_LIBRARY_DATA_DIRECT;
    public static final int BND_ICON_GROUP;
    public static final int BND_ICON_ARMATURE_DATA;
    public static final int BND_ICON_POSE_DATA;
    public static final int BND_ICON_BONE_DATA;
    public static final int BND_ICON_CONSTRAINT;
    public static final int BND_ICON_SHAPEKEY_DATA;
    public static final int BND_ICON_CONSTRAINT_BONE;
    public static final int BND_ICON_CAMERA_STEREO;
    public static final int BND_ICON_PACKAGE;
    public static final int BND_ICON_UGLYPACKAGE;
    public static final int BND_ICON_BRUSH_DATA;
    public static final int BND_ICON_IMAGE_DATA;
    public static final int BND_ICON_FILE;
    public static final int BND_ICON_FCURVE;
    public static final int BND_ICON_FONT_DATA;
    public static final int BND_ICON_RENDER_RESULT;
    public static final int BND_ICON_SURFACE_DATA;
    public static final int BND_ICON_EMPTY_DATA;
    public static final int BND_ICON_SETTINGS;
    public static final int BND_ICON_RENDER_ANIMATION;
    public static final int BND_ICON_RENDER_STILL;
    public static final int BND_ICON_BOIDS;
    public static final int BND_ICON_STRANDS;
    public static final int BND_ICON_LIBRARY_DATA_INDIRECT;
    public static final int BND_ICON_GREASEPENCIL;
    public static final int BND_ICON_LINE_DATA;
    public static final int BND_ICON_GROUP_BONE;
    public static final int BND_ICON_GROUP_VERTEX;
    public static final int BND_ICON_GROUP_VCOL;
    public static final int BND_ICON_GROUP_UVS;
    public static final int BND_ICON_RNA;
    public static final int BND_ICON_RNA_ADD;
    public static final int BND_ICON_OUTLINER_OB_EMPTY;
    public static final int BND_ICON_OUTLINER_OB_MESH;
    public static final int BND_ICON_OUTLINER_OB_CURVE;
    public static final int BND_ICON_OUTLINER_OB_LATTICE;
    public static final int BND_ICON_OUTLINER_OB_META;
    public static final int BND_ICON_OUTLINER_OB_LAMP;
    public static final int BND_ICON_OUTLINER_OB_CAMERA;
    public static final int BND_ICON_OUTLINER_OB_ARMATURE;
    public static final int BND_ICON_OUTLINER_OB_FONT;
    public static final int BND_ICON_OUTLINER_OB_SURFACE;
    public static final int BND_ICON_OUTLINER_OB_SPEAKER;
    public static final int BND_ICON_RESTRICT_VIEW_OFF;
    public static final int BND_ICON_RESTRICT_VIEW_ON;
    public static final int BND_ICON_RESTRICT_SELECT_OFF;
    public static final int BND_ICON_RESTRICT_SELECT_ON;
    public static final int BND_ICON_RESTRICT_RENDER_OFF;
    public static final int BND_ICON_RESTRICT_RENDER_ON;
    public static final int BND_ICON_OUTLINER_DATA_EMPTY;
    public static final int BND_ICON_OUTLINER_DATA_MESH;
    public static final int BND_ICON_OUTLINER_DATA_CURVE;
    public static final int BND_ICON_OUTLINER_DATA_LATTICE;
    public static final int BND_ICON_OUTLINER_DATA_META;
    public static final int BND_ICON_OUTLINER_DATA_LAMP;
    public static final int BND_ICON_OUTLINER_DATA_CAMERA;
    public static final int BND_ICON_OUTLINER_DATA_ARMATURE;
    public static final int BND_ICON_OUTLINER_DATA_FONT;
    public static final int BND_ICON_OUTLINER_DATA_SURFACE;
    public static final int BND_ICON_OUTLINER_DATA_SPEAKER;
    public static final int BND_ICON_OUTLINER_DATA_POSE;
    public static final int BND_ICON_MESH_PLANE;
    public static final int BND_ICON_MESH_CUBE;
    public static final int BND_ICON_MESH_CIRCLE;
    public static final int BND_ICON_MESH_UVSPHERE;
    public static final int BND_ICON_MESH_ICOSPHERE;
    public static final int BND_ICON_MESH_GRID;
    public static final int BND_ICON_MESH_MONKEY;
    public static final int BND_ICON_MESH_CYLINDER;
    public static final int BND_ICON_MESH_TORUS;
    public static final int BND_ICON_MESH_CONE;
    public static final int BND_ICON_LAMP_POINT;
    public static final int BND_ICON_LAMP_SUN;
    public static final int BND_ICON_LAMP_SPOT;
    public static final int BND_ICON_LAMP_HEMI;
    public static final int BND_ICON_LAMP_AREA;
    public static final int BND_ICON_META_EMPTY;
    public static final int BND_ICON_META_PLANE;
    public static final int BND_ICON_META_CUBE;
    public static final int BND_ICON_META_BALL;
    public static final int BND_ICON_META_ELLIPSOID;
    public static final int BND_ICON_META_CAPSULE;
    public static final int BND_ICON_SURFACE_NCURVE;
    public static final int BND_ICON_SURFACE_NCIRCLE;
    public static final int BND_ICON_SURFACE_NSURFACE;
    public static final int BND_ICON_SURFACE_NCYLINDER;
    public static final int BND_ICON_SURFACE_NSPHERE;
    public static final int BND_ICON_SURFACE_NTORUS;
    public static final int BND_ICON_CURVE_BEZCURVE;
    public static final int BND_ICON_CURVE_BEZCIRCLE;
    public static final int BND_ICON_CURVE_NCURVE;
    public static final int BND_ICON_CURVE_NCIRCLE;
    public static final int BND_ICON_CURVE_PATH;
    public static final int BND_ICON_COLOR_RED;
    public static final int BND_ICON_COLOR_GREEN;
    public static final int BND_ICON_COLOR_BLUE;
    public static final int BND_ICON_FORCE_FORCE;
    public static final int BND_ICON_FORCE_WIND;
    public static final int BND_ICON_FORCE_VORTEX;
    public static final int BND_ICON_FORCE_MAGNETIC;
    public static final int BND_ICON_FORCE_HARMONIC;
    public static final int BND_ICON_FORCE_CHARGE;
    public static final int BND_ICON_FORCE_LENNARDJONES;
    public static final int BND_ICON_FORCE_TEXTURE;
    public static final int BND_ICON_FORCE_CURVE;
    public static final int BND_ICON_FORCE_BOID;
    public static final int BND_ICON_FORCE_TURBULENCE;
    public static final int BND_ICON_FORCE_DRAG;
    public static final int BND_ICON_FORCE_SMOKEFLOW;
    public static final int BND_ICON_MODIFIER;
    public static final int BND_ICON_MOD_WAVE;
    public static final int BND_ICON_MOD_BUILD;
    public static final int BND_ICON_MOD_DECIM;
    public static final int BND_ICON_MOD_MIRROR;
    public static final int BND_ICON_MOD_SOFT;
    public static final int BND_ICON_MOD_SUBSURF;
    public static final int BND_ICON_HOOK;
    public static final int BND_ICON_MOD_PHYSICS;
    public static final int BND_ICON_MOD_PARTICLES;
    public static final int BND_ICON_MOD_BOOLEAN;
    public static final int BND_ICON_MOD_EDGESPLIT;
    public static final int BND_ICON_MOD_ARRAY;
    public static final int BND_ICON_MOD_UVPROJECT;
    public static final int BND_ICON_MOD_DISPLACE;
    public static final int BND_ICON_MOD_CURVE;
    public static final int BND_ICON_MOD_LATTICE;
    public static final int BND_ICON_CONSTRAINT_DATA;
    public static final int BND_ICON_MOD_ARMATURE;
    public static final int BND_ICON_MOD_SHRINKWRAP;
    public static final int BND_ICON_MOD_CAST;
    public static final int BND_ICON_MOD_MESHDEFORM;
    public static final int BND_ICON_MOD_BEVEL;
    public static final int BND_ICON_MOD_SMOOTH;
    public static final int BND_ICON_MOD_SIMPLEDEFORM;
    public static final int BND_ICON_MOD_MASK;
    public static final int BND_ICON_MOD_CLOTH;
    public static final int BND_ICON_MOD_EXPLODE;
    public static final int BND_ICON_MOD_FLUIDSIM;
    public static final int BND_ICON_MOD_MULTIRES;
    public static final int BND_ICON_MOD_SMOKE;
    public static final int BND_ICON_MOD_SOLIDIFY;
    public static final int BND_ICON_MOD_SCREW;
    public static final int BND_ICON_MOD_VERTEX_WEIGHT;
    public static final int BND_ICON_MOD_DYNAMICPAINT;
    public static final int BND_ICON_MOD_REMESH;
    public static final int BND_ICON_MOD_OCEAN;
    public static final int BND_ICON_MOD_WARP;
    public static final int BND_ICON_MOD_SKIN;
    public static final int BND_ICON_MOD_TRIANGULATE;
    public static final int BND_ICON_MOD_WIREFRAME;
    public static final int BND_ICON_REC;
    public static final int BND_ICON_PLAY;
    public static final int BND_ICON_FF;
    public static final int BND_ICON_REW;
    public static final int BND_ICON_PAUSE;
    public static final int BND_ICON_PREV_KEYFRAME;
    public static final int BND_ICON_NEXT_KEYFRAME;
    public static final int BND_ICON_PLAY_AUDIO;
    public static final int BND_ICON_PLAY_REVERSE;
    public static final int BND_ICON_PREVIEW_RANGE;
    public static final int BND_ICON_ACTION_TWEAK;
    public static final int BND_ICON_PMARKER_ACT;
    public static final int BND_ICON_PMARKER_SEL;
    public static final int BND_ICON_PMARKER;
    public static final int BND_ICON_MARKER_HLT;
    public static final int BND_ICON_MARKER;
    public static final int BND_ICON_SPACE2;
    public static final int BND_ICON_SPACE3;
    public static final int BND_ICON_KEYINGSET;
    public static final int BND_ICON_KEY_DEHLT;
    public static final int BND_ICON_KEY_HLT;
    public static final int BND_ICON_MUTE_IPO_OFF;
    public static final int BND_ICON_MUTE_IPO_ON;
    public static final int BND_ICON_VISIBLE_IPO_OFF;
    public static final int BND_ICON_VISIBLE_IPO_ON;
    public static final int BND_ICON_DRIVER;
    public static final int BND_ICON_SOLO_OFF;
    public static final int BND_ICON_SOLO_ON;
    public static final int BND_ICON_FRAME_PREV;
    public static final int BND_ICON_FRAME_NEXT;
    public static final int BND_ICON_NLA_PUSHDOWN;
    public static final int BND_ICON_IPO_CONSTANT;
    public static final int BND_ICON_IPO_LINEAR;
    public static final int BND_ICON_IPO_BEZIER;
    public static final int BND_ICON_IPO_SINE;
    public static final int BND_ICON_IPO_QUAD;
    public static final int BND_ICON_IPO_CUBIC;
    public static final int BND_ICON_IPO_QUART;
    public static final int BND_ICON_IPO_QUINT;
    public static final int BND_ICON_IPO_EXPO;
    public static final int BND_ICON_IPO_CIRC;
    public static final int BND_ICON_IPO_BOUNCE;
    public static final int BND_ICON_IPO_ELASTIC;
    public static final int BND_ICON_IPO_BACK;
    public static final int BND_ICON_IPO_EASE_IN;
    public static final int BND_ICON_IPO_EASE_OUT;
    public static final int BND_ICON_IPO_EASE_IN_OUT;
    public static final int BND_ICON_VERTEXSEL;
    public static final int BND_ICON_EDGESEL;
    public static final int BND_ICON_FACESEL;
    public static final int BND_ICON_LOOPSEL;
    public static final int BND_ICON_ROTATE;
    public static final int BND_ICON_CURSOR;
    public static final int BND_ICON_ROTATECOLLECTION;
    public static final int BND_ICON_ROTATECENTER;
    public static final int BND_ICON_ROTACTIVE;
    public static final int BND_ICON_ALIGN;
    public static final int BND_ICON_SMOOTHCURVE;
    public static final int BND_ICON_SPHERECURVE;
    public static final int BND_ICON_ROOTCURVE;
    public static final int BND_ICON_SHARPCURVE;
    public static final int BND_ICON_LINCURVE;
    public static final int BND_ICON_NOCURVE;
    public static final int BND_ICON_RNDCURVE;
    public static final int BND_ICON_PROP_OFF;
    public static final int BND_ICON_PROP_ON;
    public static final int BND_ICON_PROP_CON;
    public static final int BND_ICON_SCULPT_DYNTOPO;
    public static final int BND_ICON_PARTICLE_POINT;
    public static final int BND_ICON_PARTICLE_TIP;
    public static final int BND_ICON_PARTICLE_PATH;
    public static final int BND_ICON_MAN_TRANS;
    public static final int BND_ICON_MAN_ROT;
    public static final int BND_ICON_MAN_SCALE;
    public static final int BND_ICON_MANIPUL;
    public static final int BND_ICON_SNAP_OFF;
    public static final int BND_ICON_SNAP_ON;
    public static final int BND_ICON_SNAP_NORMAL;
    public static final int BND_ICON_SNAP_INCREMENT;
    public static final int BND_ICON_SNAP_VERTEX;
    public static final int BND_ICON_SNAP_EDGE;
    public static final int BND_ICON_SNAP_FACE;
    public static final int BND_ICON_SNAP_VOLUME;
    public static final int BND_ICON_STICKY_UVS_LOC;
    public static final int BND_ICON_STICKY_UVS_DISABLE;
    public static final int BND_ICON_STICKY_UVS_VERT;
    public static final int BND_ICON_CLIPUV_DEHLT;
    public static final int BND_ICON_CLIPUV_HLT;
    public static final int BND_ICON_SNAP_PEEL_OBJECT;
    public static final int BND_ICON_GRID;
    public static final int BND_ICON_PASTEDOWN;
    public static final int BND_ICON_COPYDOWN;
    public static final int BND_ICON_PASTEFLIPUP;
    public static final int BND_ICON_PASTEFLIPDOWN;
    public static final int BND_ICON_SNAP_SURFACE;
    public static final int BND_ICON_AUTOMERGE_ON;
    public static final int BND_ICON_AUTOMERGE_OFF;
    public static final int BND_ICON_RETOPO;
    public static final int BND_ICON_UV_VERTEXSEL;
    public static final int BND_ICON_UV_EDGESEL;
    public static final int BND_ICON_UV_FACESEL;
    public static final int BND_ICON_UV_ISLANDSEL;
    public static final int BND_ICON_UV_SYNC_SELECT;
    public static final int BND_ICON_BBOX;
    public static final int BND_ICON_WIRE;
    public static final int BND_ICON_SOLID;
    public static final int BND_ICON_SMOOTH;
    public static final int BND_ICON_POTATO;
    public static final int BND_ICON_ORTHO;
    public static final int BND_ICON_LOCKVIEW_OFF;
    public static final int BND_ICON_LOCKVIEW_ON;
    public static final int BND_ICON_AXIS_SIDE;
    public static final int BND_ICON_AXIS_FRONT;
    public static final int BND_ICON_AXIS_TOP;
    public static final int BND_ICON_NDOF_DOM;
    public static final int BND_ICON_NDOF_TURN;
    public static final int BND_ICON_NDOF_FLY;
    public static final int BND_ICON_NDOF_TRANS;
    public static final int BND_ICON_LAYER_USED;
    public static final int BND_ICON_LAYER_ACTIVE;
    public static final int BND_ICON_SORTALPHA;
    public static final int BND_ICON_SORTBYEXT;
    public static final int BND_ICON_SORTTIME;
    public static final int BND_ICON_SORTSIZE;
    public static final int BND_ICON_LONGDISPLAY;
    public static final int BND_ICON_SHORTDISPLAY;
    public static final int BND_ICON_GHOST;
    public static final int BND_ICON_IMGDISPLAY;
    public static final int BND_ICON_SAVE_AS;
    public static final int BND_ICON_SAVE_COPY;
    public static final int BND_ICON_BOOKMARKS;
    public static final int BND_ICON_FONTPREVIEW;
    public static final int BND_ICON_FILTER;
    public static final int BND_ICON_NEWFOLDER;
    public static final int BND_ICON_OPEN_RECENT;
    public static final int BND_ICON_FILE_PARENT;
    public static final int BND_ICON_FILE_REFRESH;
    public static final int BND_ICON_FILE_FOLDER;
    public static final int BND_ICON_FILE_BLANK;
    public static final int BND_ICON_FILE_BLEND;
    public static final int BND_ICON_FILE_IMAGE;
    public static final int BND_ICON_FILE_MOVIE;
    public static final int BND_ICON_FILE_SCRIPT;
    public static final int BND_ICON_FILE_SOUND;
    public static final int BND_ICON_FILE_FONT;
    public static final int BND_ICON_FILE_TEXT;
    public static final int BND_ICON_RECOVER_AUTO;
    public static final int BND_ICON_SAVE_PREFS;
    public static final int BND_ICON_LINK_BLEND;
    public static final int BND_ICON_APPEND_BLEND;
    public static final int BND_ICON_IMPORT;
    public static final int BND_ICON_EXPORT;
    public static final int BND_ICON_EXTERNAL_DATA;
    public static final int BND_ICON_LOAD_FACTORY;
    public static final int BND_ICON_LOOP_BACK;
    public static final int BND_ICON_LOOP_FORWARDS;
    public static final int BND_ICON_BACK;
    public static final int BND_ICON_FORWARD;
    public static final int BND_ICON_FILE_BACKUP;
    public static final int BND_ICON_DISK_DRIVE;
    public static final int BND_ICON_MATPLANE;
    public static final int BND_ICON_MATSPHERE;
    public static final int BND_ICON_MATCUBE;
    public static final int BND_ICON_MONKEY;
    public static final int BND_ICON_HAIR;
    public static final int BND_ICON_ALIASED;
    public static final int BND_ICON_ANTIALIASED;
    public static final int BND_ICON_MAT_SPHERE_SKY;
    public static final int BND_ICON_WORDWRAP_OFF;
    public static final int BND_ICON_WORDWRAP_ON;
    public static final int BND_ICON_SYNTAX_OFF;
    public static final int BND_ICON_SYNTAX_ON;
    public static final int BND_ICON_LINENUMBERS_OFF;
    public static final int BND_ICON_LINENUMBERS_ON;
    public static final int BND_ICON_SCRIPTPLUGINS;
    public static final int BND_ICON_SEQ_SEQUENCER;
    public static final int BND_ICON_SEQ_PREVIEW;
    public static final int BND_ICON_SEQ_LUMA_WAVEFORM;
    public static final int BND_ICON_SEQ_CHROMA_SCOPE;
    public static final int BND_ICON_SEQ_HISTOGRAM;
    public static final int BND_ICON_SEQ_SPLITVIEW;
    public static final int BND_ICON_IMAGE_RGB;
    public static final int BND_ICON_IMAGE_RGB_ALPHA;
    public static final int BND_ICON_IMAGE_ALPHA;
    public static final int BND_ICON_IMAGE_ZDEPTH;
    public static final int BND_ICON_IMAGEFILE;

    protected Blendish() {
        throw new UnsupportedOperationException();
    }

    public static native void nbndSetTheme(long var0);

    public static void bndSetTheme(BNDtheme param0) {
        Blendish.nbndSetTheme(param0.address());
    }

    public static native long nbndGetTheme();

    @Nullable
    @NativeType(value="BNDtheme const *")
    public static BNDtheme bndGetTheme() {
        long v0 = Blendish.nbndGetTheme();
        return BNDtheme.createSafe(v0);
    }

    public static native void bndSetIconImage(int var0);

    public static native void bndSetFont(int var0);

    public static native void nbndLabel(long var0, float var2, float var3, float var4, float var5, int var6, long var7);

    public static void bndLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") ByteBuffer param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param7);
        }
        Blendish.nbndLabel(param0, param2, param3, param4, param5, param6, MemoryUtil.memAddressSafe(param7));
    }

    public static void bndLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") CharSequence param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v8 = MemoryStack.stackGet();
        int v9 = v8.getPointer();
        try {
            v8.nUTF8Safe(param7, true);
            long v10 = param7 == null ? 0L : v8.getPointerAddress();
            Blendish.nbndLabel(param0, param2, param3, param4, param5, param6, v10);
            return;
        }
        finally {
            v8.setPointer(v9);
        }
    }

    public static native void nbndToolButton(long var0, float var2, float var3, float var4, float var5, int var6, int var7, int var8, long var9);

    public static void bndToolButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") ByteBuffer param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndToolButton(param0, param2, param3, param4, param5, param6, param7, param8, MemoryUtil.memAddressSafe(param9));
    }

    public static void bndToolButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") CharSequence param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param9, true);
            long v12 = param9 == null ? 0L : v10.getPointerAddress();
            Blendish.nbndToolButton(param0, param2, param3, param4, param5, param6, param7, param8, v12);
            return;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native void nbndRadioButton(long var0, float var2, float var3, float var4, float var5, int var6, int var7, int var8, long var9);

    public static void bndRadioButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") ByteBuffer param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndRadioButton(param0, param2, param3, param4, param5, param6, param7, param8, MemoryUtil.memAddressSafe(param9));
    }

    public static void bndRadioButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") CharSequence param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param9, true);
            long v12 = param9 == null ? 0L : v10.getPointerAddress();
            Blendish.nbndRadioButton(param0, param2, param3, param4, param5, param6, param7, param8, v12);
            return;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native int nbndTextFieldTextPosition(long var0, float var2, float var3, float var4, float var5, int var6, long var7, int var9, int var10);

    public static int bndTextFieldTextPosition(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") ByteBuffer param7, int param8, int param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param7);
        }
        return Blendish.nbndTextFieldTextPosition(param0, param2, param3, param4, param5, param6, MemoryUtil.memAddressSafe(param7), param8, param9);
    }

    public static int bndTextFieldTextPosition(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") CharSequence param7, int param8, int param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param7, true);
            long v12 = param7 == null ? 0L : v10.getPointerAddress();
            int v14 = Blendish.nbndTextFieldTextPosition(param0, param2, param3, param4, param5, param6, v12, param8, param9);
            return v14;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native void nbndTextField(long var0, float var2, float var3, float var4, float var5, int var6, int var7, int var8, long var9, int var11, int var12);

    public static void bndTextField(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") ByteBuffer param9, int param10, int param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndTextField(param0, param2, param3, param4, param5, param6, param7, param8, MemoryUtil.memAddressSafe(param9), param10, param11);
    }

    public static void bndTextField(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") CharSequence param9, int param10, int param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v12 = MemoryStack.stackGet();
        int v13 = v12.getPointer();
        try {
            v12.nUTF8Safe(param9, true);
            long v14 = param9 == null ? 0L : v12.getPointerAddress();
            Blendish.nbndTextField(param0, param2, param3, param4, param5, param6, param7, param8, v14, param10, param11);
            return;
        }
        finally {
            v12.setPointer(v13);
        }
    }

    public static native void nbndOptionButton(long var0, float var2, float var3, float var4, float var5, int var6, long var7);

    public static void bndOptionButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, @Nullable @NativeType(value="char const *") ByteBuffer param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param7);
        }
        Blendish.nbndOptionButton(param0, param2, param3, param4, param5, param6, MemoryUtil.memAddressSafe(param7));
    }

    public static void bndOptionButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, @Nullable @NativeType(value="char const *") CharSequence param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v8 = MemoryStack.stackGet();
        int v9 = v8.getPointer();
        try {
            v8.nUTF8Safe(param7, true);
            long v10 = param7 == null ? 0L : v8.getPointerAddress();
            Blendish.nbndOptionButton(param0, param2, param3, param4, param5, param6, v10);
            return;
        }
        finally {
            v8.setPointer(v9);
        }
    }

    public static native void nbndChoiceButton(long var0, float var2, float var3, float var4, float var5, int var6, int var7, int var8, long var9);

    public static void bndChoiceButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") ByteBuffer param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndChoiceButton(param0, param2, param3, param4, param5, param6, param7, param8, MemoryUtil.memAddressSafe(param9));
    }

    public static void bndChoiceButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, int param8, @Nullable @NativeType(value="char const *") CharSequence param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param9, true);
            long v12 = param9 == null ? 0L : v10.getPointerAddress();
            Blendish.nbndChoiceButton(param0, param2, param3, param4, param5, param6, param7, param8, v12);
            return;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native void nbndColorButton(long var0, float var2, float var3, float var4, float var5, int var6, long var7);

    public static void bndColorButton(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndColorButton(param0, param2, param3, param4, param5, param6, param7.address());
    }

    public static native void nbndNumberField(long var0, float var2, float var3, float var4, float var5, int var6, int var7, long var8, long var10);

    public static void bndNumberField(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, @Nullable @NativeType(value="char const *") ByteBuffer param8, @Nullable @NativeType(value="char const *") ByteBuffer param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param8);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndNumberField(param0, param2, param3, param4, param5, param6, param7, MemoryUtil.memAddressSafe(param8), MemoryUtil.memAddressSafe(param9));
    }

    public static void bndNumberField(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, @Nullable @NativeType(value="char const *") CharSequence param8, @Nullable @NativeType(value="char const *") CharSequence param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param8, true);
            long v12 = param8 == null ? 0L : v10.getPointerAddress();
            v10.nUTF8Safe(param9, true);
            long v14 = param9 == null ? 0L : v10.getPointerAddress();
            Blendish.nbndNumberField(param0, param2, param3, param4, param5, param6, param7, v12, v14);
            return;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native void nbndSlider(long var0, float var2, float var3, float var4, float var5, int var6, int var7, float var8, long var9, long var11);

    public static void bndSlider(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, float param8, @Nullable @NativeType(value="char const *") ByteBuffer param9, @Nullable @NativeType(value="char const *") ByteBuffer param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
            Checks.checkNT1Safe(param10);
        }
        Blendish.nbndSlider(param0, param2, param3, param4, param5, param6, param7, param8, MemoryUtil.memAddressSafe(param9), MemoryUtil.memAddressSafe(param10));
    }

    public static void bndSlider(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="BNDwidgetState") int param7, float param8, @Nullable @NativeType(value="char const *") CharSequence param9, @Nullable @NativeType(value="char const *") CharSequence param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v11 = MemoryStack.stackGet();
        int v12 = v11.getPointer();
        try {
            v11.nUTF8Safe(param9, true);
            long v13 = param9 == null ? 0L : v11.getPointerAddress();
            v11.nUTF8Safe(param10, true);
            long v15 = param10 == null ? 0L : v11.getPointerAddress();
            Blendish.nbndSlider(param0, param2, param3, param4, param5, param6, param7, param8, v13, v15);
            return;
        }
        finally {
            v11.setPointer(v12);
        }
    }

    public static native void nbndScrollBar(long var0, float var2, float var3, float var4, float var5, int var6, float var7, float var8);

    public static void bndScrollBar(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, float param7, float param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndScrollBar(param0, param2, param3, param4, param5, param6, param7, param8);
    }

    public static native void nbndMenuBackground(long var0, float var2, float var3, float var4, float var5, int var6);

    public static void bndMenuBackground(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndMenuBackground(param0, param2, param3, param4, param5, param6);
    }

    public static native void nbndMenuLabel(long var0, float var2, float var3, float var4, float var5, int var6, long var7);

    public static void bndMenuLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") ByteBuffer param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param7);
        }
        Blendish.nbndMenuLabel(param0, param2, param3, param4, param5, param6, MemoryUtil.memAddressSafe(param7));
    }

    public static void bndMenuLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @Nullable @NativeType(value="char const *") CharSequence param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v8 = MemoryStack.stackGet();
        int v9 = v8.getPointer();
        try {
            v8.nUTF8Safe(param7, true);
            long v10 = param7 == null ? 0L : v8.getPointerAddress();
            Blendish.nbndMenuLabel(param0, param2, param3, param4, param5, param6, v10);
            return;
        }
        finally {
            v8.setPointer(v9);
        }
    }

    public static native void nbndMenuItem(long var0, float var2, float var3, float var4, float var5, int var6, int var7, long var8);

    public static void bndMenuItem(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, int param7, @Nullable @NativeType(value="char const *") ByteBuffer param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param8);
        }
        Blendish.nbndMenuItem(param0, param2, param3, param4, param5, param6, param7, MemoryUtil.memAddressSafe(param8));
    }

    public static void bndMenuItem(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, int param7, @Nullable @NativeType(value="char const *") CharSequence param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v9 = MemoryStack.stackGet();
        int v10 = v9.getPointer();
        try {
            v9.nUTF8Safe(param8, true);
            long v11 = param8 == null ? 0L : v9.getPointerAddress();
            Blendish.nbndMenuItem(param0, param2, param3, param4, param5, param6, param7, v11);
            return;
        }
        finally {
            v9.setPointer(v10);
        }
    }

    public static native void nbndTooltipBackground(long var0, float var2, float var3, float var4, float var5);

    public static void bndTooltipBackground(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndTooltipBackground(param0, param2, param3, param4, param5);
    }

    public static native void nbndNodePort(long var0, float var2, float var3, int var4, long var5);

    public static void bndNodePort(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="BNDwidgetState") int param4, @NativeType(value="NVGcolor") NVGColor param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndNodePort(param0, param2, param3, param4, param5.address());
    }

    public static native void nbndNodeWire(long var0, float var2, float var3, float var4, float var5, int var6, int var7);

    public static void bndNodeWire(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, @NativeType(value="BNDwidgetState") int param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndNodeWire(param0, param2, param3, param4, param5, param6, param7);
    }

    public static native void nbndColoredNodeWire(long var0, float var2, float var3, float var4, float var5, long var6, long var8);

    public static void bndColoredNodeWire(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="NVGcolor") NVGColor param6, @NativeType(value="NVGcolor") NVGColor param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndColoredNodeWire(param0, param2, param3, param4, param5, param6.address(), param7.address());
    }

    public static native void nbndNodeBackground(long var0, float var2, float var3, float var4, float var5, int var6, int var7, long var8, long var10);

    public static void bndNodeBackground(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, int param7, @Nullable @NativeType(value="char const *") ByteBuffer param8, @NativeType(value="NVGcolor") NVGColor param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param8);
        }
        Blendish.nbndNodeBackground(param0, param2, param3, param4, param5, param6, param7, MemoryUtil.memAddressSafe(param8), param9.address());
    }

    public static void bndNodeBackground(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="BNDwidgetState") int param6, int param7, @Nullable @NativeType(value="char const *") CharSequence param8, @NativeType(value="NVGcolor") NVGColor param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v10 = MemoryStack.stackGet();
        int v11 = v10.getPointer();
        try {
            v10.nUTF8Safe(param8, true);
            long v12 = param8 == null ? 0L : v10.getPointerAddress();
            Blendish.nbndNodeBackground(param0, param2, param3, param4, param5, param6, param7, v12, param9.address());
            return;
        }
        finally {
            v10.setPointer(v11);
        }
    }

    public static native void nbndSplitterWidgets(long var0, float var2, float var3, float var4, float var5);

    public static void bndSplitterWidgets(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndSplitterWidgets(param0, param2, param3, param4, param5);
    }

    public static native void nbndJoinAreaOverlay(long var0, float var2, float var3, float var4, float var5, int var6, int var7);

    public static void bndJoinAreaOverlay(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, @NativeType(value="int") boolean param6, @NativeType(value="int") boolean param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndJoinAreaOverlay(param0, param2, param3, param4, param5, param6 ? 1 : 0, param7 ? 1 : 0);
    }

    public static native float nbndLabelWidth(long var0, int var2, long var3);

    public static float bndLabelWidth(@NativeType(value="NVGcontext *") long param0, int param2, @Nullable @NativeType(value="char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param3);
        }
        return Blendish.nbndLabelWidth(param0, param2, MemoryUtil.memAddressSafe(param3));
    }

    public static float bndLabelWidth(@NativeType(value="NVGcontext *") long param0, int param2, @Nullable @NativeType(value="char const *") CharSequence param3) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8Safe(param3, true);
            long v6 = param3 == null ? 0L : v4.getPointerAddress();
            float v8 = Blendish.nbndLabelWidth(param0, param2, v6);
            return v8;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native float nbndLabelHeight(long var0, int var2, long var3, float var5);

    public static float bndLabelHeight(@NativeType(value="NVGcontext *") long param0, int param2, @Nullable @NativeType(value="char const *") ByteBuffer param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param3);
        }
        return Blendish.nbndLabelHeight(param0, param2, MemoryUtil.memAddressSafe(param3), param4);
    }

    public static float bndLabelHeight(@NativeType(value="NVGcontext *") long param0, int param2, @Nullable @NativeType(value="char const *") CharSequence param3, float param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8Safe(param3, true);
            long v7 = param3 == null ? 0L : v5.getPointerAddress();
            float v9 = Blendish.nbndLabelHeight(param0, param2, v7, param4);
            return v9;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nbndTransparent(long var0, long var2);

    @NativeType(value="NVGcolor")
    public static NVGColor bndTransparent(@NativeType(value="NVGcolor") NVGColor param0, @NativeType(value="NVGcolor") NVGColor param1) {
        Blendish.nbndTransparent(param0.address(), param1.address());
        return param1;
    }

    public static native void nbndOffsetColor(long var0, int var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor bndOffsetColor(@NativeType(value="NVGcolor") NVGColor param0, int param1, @NativeType(value="NVGcolor") NVGColor param2) {
        Blendish.nbndOffsetColor(param0.address(), param1, param2.address());
        return param2;
    }

    public static native void nbndSelectCorners(long var0, float var2, int var3);

    public static void bndSelectCorners(@NativeType(value="float *") FloatBuffer param0, float param1, int param2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 4);
        }
        Blendish.nbndSelectCorners(MemoryUtil.memAddress(param0), param1, param2);
    }

    public static native void nbndInnerColors(long var0, long var2, long var4, int var6, int var7);

    public static void bndInnerColors(@NativeType(value="NVGcolor *") NVGColor param0, @NativeType(value="NVGcolor *") NVGColor param1, @NativeType(value="BNDwidgetTheme const *") BNDwidgetTheme param2, @NativeType(value="BNDwidgetState") int param3, @NativeType(value="int") boolean param4) {
        Blendish.nbndInnerColors(param0.address(), param1.address(), param2.address(), param3, param4 ? 1 : 0);
    }

    public static native void nbndTextColor(long var0, int var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor bndTextColor(@NativeType(value="BNDwidgetTheme const *") BNDwidgetTheme param0, @NativeType(value="BNDwidgetState") int param1, @NativeType(value="NVGcolor") NVGColor param2) {
        Blendish.nbndTextColor(param0.address(), param1, param2.address());
        return param2;
    }

    public static native void nbndScrollHandleRect(long var0, long var2, long var4, long var6, float var8, float var9);

    public static void bndScrollHandleRect(@NativeType(value="float *") FloatBuffer param0, @NativeType(value="float *") FloatBuffer param1, @NativeType(value="float *") FloatBuffer param2, @NativeType(value="float *") FloatBuffer param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, 1);
            Checks.check((Buffer)param1, 1);
            Checks.check((Buffer)param2, 1);
            Checks.check((Buffer)param3, 1);
        }
        Blendish.nbndScrollHandleRect(MemoryUtil.memAddress(param0), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param4, param5);
    }

    public static native void nbndRoundedBox(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);

    public static void bndRoundedBox(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndRoundedBox(param0, param2, param3, param4, param5, param6, param7, param8, param9);
    }

    public static native void nbndBackground(long var0, float var2, float var3, float var4, float var5);

    public static void bndBackground(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndBackground(param0, param2, param3, param4, param5);
    }

    public static native void nbndBevel(long var0, float var2, float var3, float var4, float var5);

    public static void bndBevel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndBevel(param0, param2, param3, param4, param5);
    }

    public static native void nbndBevelInset(long var0, float var2, float var3, float var4, float var5, float var6, float var7);

    public static void bndBevelInset(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndBevelInset(param0, param2, param3, param4, param5, param6, param7);
    }

    public static native void nbndIcon(long var0, float var2, float var3, int var4);

    public static void bndIcon(@NativeType(value="NVGcontext *") long param0, float param2, float param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndIcon(param0, param2, param3, param4);
    }

    public static native void nbndDropShadow(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

    public static void bndDropShadow(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, float param8) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndDropShadow(param0, param2, param3, param4, param5, param6, param7, param8);
    }

    public static native void nbndInnerBox(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, long var10, long var12);

    public static void bndInnerBox(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, @NativeType(value="NVGcolor") NVGColor param10, @NativeType(value="NVGcolor") NVGColor param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndInnerBox(param0, param2, param3, param4, param5, param6, param7, param8, param9, param10.address(), param11.address());
    }

    public static native void nbndOutlineBox(long var0, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, long var10);

    public static void bndOutlineBox(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, @NativeType(value="NVGcolor") NVGColor param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndOutlineBox(param0, param2, param3, param4, param5, param6, param7, param8, param9, param10.address());
    }

    public static native void nbndIconLabelValue(long var0, float var2, float var3, float var4, float var5, int var6, long var7, int var9, float var10, long var11, long var13);

    public static void bndIconLabelValue(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, int param8, float param9, @Nullable @NativeType(value="char const *") ByteBuffer param10, @Nullable @NativeType(value="char const *") ByteBuffer param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param10);
            Checks.checkNT1Safe(param11);
        }
        Blendish.nbndIconLabelValue(param0, param2, param3, param4, param5, param6, param7.address(), param8, param9, MemoryUtil.memAddressSafe(param10), MemoryUtil.memAddressSafe(param11));
    }

    public static void bndIconLabelValue(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, int param8, float param9, @Nullable @NativeType(value="char const *") CharSequence param10, @Nullable @NativeType(value="char const *") CharSequence param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v12 = MemoryStack.stackGet();
        int v13 = v12.getPointer();
        try {
            v12.nUTF8Safe(param10, true);
            long v14 = param10 == null ? 0L : v12.getPointerAddress();
            v12.nUTF8Safe(param11, true);
            long v16 = param11 == null ? 0L : v12.getPointerAddress();
            Blendish.nbndIconLabelValue(param0, param2, param3, param4, param5, param6, param7.address(), param8, param9, v14, v16);
            return;
        }
        finally {
            v12.setPointer(v13);
        }
    }

    public static native void nbndNodeIconLabel(long var0, float var2, float var3, float var4, float var5, int var6, long var7, long var9, int var11, float var12, long var13);

    public static void bndNodeIconLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, @NativeType(value="NVGcolor") NVGColor param8, int param9, float param10, @Nullable @NativeType(value="char const *") ByteBuffer param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param11);
        }
        Blendish.nbndNodeIconLabel(param0, param2, param3, param4, param5, param6, param7.address(), param8.address(), param9, param10, MemoryUtil.memAddressSafe(param11));
    }

    public static void bndNodeIconLabel(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, @NativeType(value="NVGcolor") NVGColor param8, int param9, float param10, @Nullable @NativeType(value="char const *") CharSequence param11) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v12 = MemoryStack.stackGet();
        int v13 = v12.getPointer();
        try {
            v12.nUTF8Safe(param11, true);
            long v14 = param11 == null ? 0L : v12.getPointerAddress();
            Blendish.nbndNodeIconLabel(param0, param2, param3, param4, param5, param6, param7.address(), param8.address(), param9, param10, v14);
            return;
        }
        finally {
            v12.setPointer(v13);
        }
    }

    public static native int nbndIconLabelTextPosition(long var0, float var2, float var3, float var4, float var5, int var6, float var7, long var8, int var10, int var11);

    public static int bndIconLabelTextPosition(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, float param7, @Nullable @NativeType(value="char const *") ByteBuffer param8, int param9, int param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param8);
        }
        return Blendish.nbndIconLabelTextPosition(param0, param2, param3, param4, param5, param6, param7, MemoryUtil.memAddressSafe(param8), param9, param10);
    }

    public static int bndIconLabelTextPosition(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, float param7, @Nullable @NativeType(value="char const *") CharSequence param8, int param9, int param10) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v11 = MemoryStack.stackGet();
        int v12 = v11.getPointer();
        try {
            v11.nUTF8Safe(param8, true);
            long v13 = param8 == null ? 0L : v11.getPointerAddress();
            int v15 = Blendish.nbndIconLabelTextPosition(param0, param2, param3, param4, param5, param6, param7, v13, param9, param10);
            return v15;
        }
        finally {
            v11.setPointer(v12);
        }
    }

    public static native void nbndIconLabelCaret(long var0, float var2, float var3, float var4, float var5, int var6, long var7, float var9, long var10, long var12, int var14, int var15);

    public static void bndIconLabelCaret(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, float param8, @Nullable @NativeType(value="char const *") ByteBuffer param9, @NativeType(value="NVGcolor") NVGColor param10, int param11, int param12) {
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.checkNT1Safe(param9);
        }
        Blendish.nbndIconLabelCaret(param0, param2, param3, param4, param5, param6, param7.address(), param8, MemoryUtil.memAddressSafe(param9), param10.address(), param11, param12);
    }

    public static void bndIconLabelCaret(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, float param5, int param6, @NativeType(value="NVGcolor") NVGColor param7, float param8, @Nullable @NativeType(value="char const *") CharSequence param9, @NativeType(value="NVGcolor") NVGColor param10, int param11, int param12) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        MemoryStack v13 = MemoryStack.stackGet();
        int v14 = v13.getPointer();
        try {
            v13.nUTF8Safe(param9, true);
            long v15 = param9 == null ? 0L : v13.getPointerAddress();
            Blendish.nbndIconLabelCaret(param0, param2, param3, param4, param5, param6, param7.address(), param8, v15, param10.address(), param11, param12);
            return;
        }
        finally {
            v13.setPointer(v14);
        }
    }

    public static native void nbndCheck(long var0, float var2, float var3, long var4);

    public static void bndCheck(@NativeType(value="NVGcontext *") long param0, float param2, float param3, @NativeType(value="NVGcolor") NVGColor param4) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndCheck(param0, param2, param3, param4.address());
    }

    public static native void nbndArrow(long var0, float var2, float var3, float var4, long var5);

    public static void bndArrow(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="NVGcolor") NVGColor param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndArrow(param0, param2, param3, param4, param5.address());
    }

    public static native void nbndUpDownArrow(long var0, float var2, float var3, float var4, long var5);

    public static void bndUpDownArrow(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="NVGcolor") NVGColor param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndUpDownArrow(param0, param2, param3, param4, param5.address());
    }

    public static native void nbndNodeArrowDown(long var0, float var2, float var3, float var4, long var5);

    public static void bndNodeArrowDown(@NativeType(value="NVGcontext *") long param0, float param2, float param3, float param4, @NativeType(value="NVGcolor") NVGColor param5) {
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        Blendish.nbndNodeArrowDown(param0, param2, param3, param4, param5.address());
    }

    public static native void nbndNodeWireColor(long var0, int var2, long var3);

    @NativeType(value="NVGcolor")
    public static NVGColor bndNodeWireColor(@NativeType(value="BNDnodeTheme const *") BNDnodeTheme param0, @NativeType(value="BNDwidgetState") int param1, @NativeType(value="NVGcolor") NVGColor param2) {
        Blendish.nbndNodeWireColor(param0.address(), param1, param2.address());
        return param2;
    }

    public static native void nbndSelectCorners(float[] var0, float var1, int var2);

    public static void bndSelectCorners(@NativeType(value="float *") float[] param0, float param1, int param2) {
        if (Checks.CHECKS) {
            Checks.check(param0, 4);
        }
        Blendish.nbndSelectCorners(param0, param1, param2);
    }

    public static native void nbndScrollHandleRect(float[] var0, float[] var1, float[] var2, float[] var3, float var4, float var5);

    public static void bndScrollHandleRect(@NativeType(value="float *") float[] param0, @NativeType(value="float *") float[] param1, @NativeType(value="float *") float[] param2, @NativeType(value="float *") float[] param3, float param4, float param5) {
        if (Checks.CHECKS) {
            Checks.check(param0, 1);
            Checks.check(param1, 1);
            Checks.check(param2, 1);
            Checks.check(param3, 1);
        }
        Blendish.nbndScrollHandleRect(param0, param1, param2, param3, param4, param5);
    }

    public static int BND_ICONID(int param0, int param1) {
        return param0 | param1 << 8;
    }

    static {
        BND_HSPACING = 8;
        BND_VSPACING_GROUP = 8;
        BND_VSPACING = 1;
        BND_SCROLLBAR_HEIGHT = 14;
        BND_SCROLLBAR_WIDTH = 13;
        BND_SPLITTER_AREA_SIZE = 12;
        BND_NODE_ARROW_AREA_WIDTH = 20;
        BND_NODE_TITLE_HEIGHT = 20;
        BND_NODE_MARGIN_SIDE = 10;
        BND_NODE_MARGIN_DOWN = 5;
        BND_NODE_MARGIN_TOP = 25;
        BND_NODE_PORT_RADIUS = 5;
        BND_TOOL_WIDTH = 20;
        BND_WIDGET_HEIGHT = 21;
        BND_CORNER_RIGHT = 6;
        BND_CORNER_LEFT = 9;
        BND_CORNER_DOWN = 12;
        BND_CORNER_TOP = 3;
        BND_CORNER_ALL = 15;
        BND_CORNER_DOWN_LEFT = 8;
        BND_CORNER_DOWN_RIGHT = 4;
        BND_CORNER_TOP_RIGHT = 2;
        BND_CORNER_TOP_LEFT = 1;
        BND_CORNER_NONE = 0;
        BND_ACTIVE = 2;
        BND_HOVER = 1;
        BND_DEFAULT = 0;
        BND_CENTER = 1;
        BND_LEFT = 0;
        BND_DISABLED_ALPHA = 0.5f;
        LibNanoVG.initialize();
        BND_ICON_NONE = 7424;
        BND_ICON_QUESTION = 7425;
        BND_ICON_ERROR = 7426;
        BND_ICON_CANCEL = 7427;
        BND_ICON_TRIA_RIGHT = 7428;
        BND_ICON_TRIA_DOWN = 7429;
        BND_ICON_TRIA_LEFT = 7430;
        BND_ICON_TRIA_UP = 7431;
        BND_ICON_ARROW_LEFTRIGHT = 7432;
        BND_ICON_PLUS = 7433;
        BND_ICON_DISCLOSURE_TRI_DOWN = 7434;
        BND_ICON_DISCLOSURE_TRI_RIGHT = 7435;
        BND_ICON_RADIOBUT_OFF = 7436;
        BND_ICON_RADIOBUT_ON = 7437;
        BND_ICON_MENU_PANEL = 7438;
        BND_ICON_BLENDER = 7439;
        BND_ICON_GRIP = 7440;
        BND_ICON_DOT = 7441;
        BND_ICON_COLLAPSEMENU = 7442;
        BND_ICON_X = 7443;
        BND_ICON_GO_LEFT = 7445;
        BND_ICON_PLUG = 7446;
        BND_ICON_UI = 7447;
        BND_ICON_NODE = 7448;
        BND_ICON_NODE_SEL = 7449;
        BND_ICON_FULLSCREEN = 7168;
        BND_ICON_SPLITSCREEN = 7169;
        BND_ICON_RIGHTARROW_THIN = 7170;
        BND_ICON_BORDERMOVE = 7171;
        BND_ICON_VIEWZOOM = 7172;
        BND_ICON_ZOOMIN = 7173;
        BND_ICON_ZOOMOUT = 7174;
        BND_ICON_PANEL_CLOSE = 7175;
        BND_ICON_COPY_ID = 7176;
        BND_ICON_EYEDROPPER = 7177;
        BND_ICON_LINK_AREA = 7178;
        BND_ICON_AUTO = 7179;
        BND_ICON_CHECKBOX_DEHLT = 7180;
        BND_ICON_CHECKBOX_HLT = 7181;
        BND_ICON_UNLOCKED = 7182;
        BND_ICON_LOCKED = 7183;
        BND_ICON_UNPINNED = 7184;
        BND_ICON_PINNED = 7185;
        BND_ICON_SCREEN_BACK = 7186;
        BND_ICON_RIGHTARROW = 7187;
        BND_ICON_DOWNARROW_HLT = 7188;
        BND_ICON_DOTSUP = 7189;
        BND_ICON_DOTSDOWN = 7190;
        BND_ICON_LINK = 7191;
        BND_ICON_INLINK = 7192;
        BND_ICON_PLUGIN = 7193;
        BND_ICON_HELP = 6912;
        BND_ICON_GHOST_ENABLED = 6913;
        BND_ICON_COLOR = 6914;
        BND_ICON_LINKED = 6915;
        BND_ICON_UNLINKED = 6916;
        BND_ICON_HAND = 6917;
        BND_ICON_ZOOM_ALL = 6918;
        BND_ICON_ZOOM_SELECTED = 6919;
        BND_ICON_ZOOM_PREVIOUS = 6920;
        BND_ICON_ZOOM_IN = 6921;
        BND_ICON_ZOOM_OUT = 6922;
        BND_ICON_RENDER_REGION = 6923;
        BND_ICON_BORDER_RECT = 6924;
        BND_ICON_BORDER_LASSO = 6925;
        BND_ICON_FREEZE = 6926;
        BND_ICON_STYLUS_PRESSURE = 6927;
        BND_ICON_GHOST_DISABLED = 6928;
        BND_ICON_NEW = 6929;
        BND_ICON_FILE_TICK = 6930;
        BND_ICON_QUIT = 6931;
        BND_ICON_URL = 6932;
        BND_ICON_RECOVER_LAST = 6933;
        BND_ICON_FULLSCREEN_ENTER = 6935;
        BND_ICON_FULLSCREEN_EXIT = 6936;
        BND_ICON_BLANK1 = 6937;
        BND_ICON_LAMP = 6656;
        BND_ICON_MATERIAL = 6657;
        BND_ICON_TEXTURE = 6658;
        BND_ICON_ANIM = 6659;
        BND_ICON_WORLD = 6660;
        BND_ICON_SCENE = 6661;
        BND_ICON_EDIT = 6662;
        BND_ICON_GAME = 6663;
        BND_ICON_RADIO = 6664;
        BND_ICON_SCRIPT = 6665;
        BND_ICON_PARTICLES = 6666;
        BND_ICON_PHYSICS = 6667;
        BND_ICON_SPEAKER = 6668;
        BND_ICON_TEXTURE_SHADED = 6669;
        BND_ICON_VIEW3D = 6400;
        BND_ICON_IPO = 6401;
        BND_ICON_OOPS = 6402;
        BND_ICON_BUTS = 6403;
        BND_ICON_FILESEL = 6404;
        BND_ICON_IMAGE_COL = 6405;
        BND_ICON_INFO = 6406;
        BND_ICON_SEQUENCE = 6407;
        BND_ICON_TEXT = 6408;
        BND_ICON_IMASEL = 6409;
        BND_ICON_SOUND = 6410;
        BND_ICON_ACTION = 6411;
        BND_ICON_NLA = 6412;
        BND_ICON_SCRIPTWIN = 6413;
        BND_ICON_TIME = 6414;
        BND_ICON_NODETREE = 6415;
        BND_ICON_LOGIC = 6416;
        BND_ICON_CONSOLE = 6417;
        BND_ICON_PREFERENCES = 6418;
        BND_ICON_CLIP = 6419;
        BND_ICON_ASSET_MANAGER = 6420;
        BND_ICON_OBJECT_DATAMODE = 6144;
        BND_ICON_EDITMODE_HLT = 6145;
        BND_ICON_FACESEL_HLT = 6146;
        BND_ICON_VPAINT_HLT = 6147;
        BND_ICON_TPAINT_HLT = 6148;
        BND_ICON_WPAINT_HLT = 6149;
        BND_ICON_SCULPTMODE_HLT = 6150;
        BND_ICON_POSE_HLT = 6151;
        BND_ICON_PARTICLEMODE = 6152;
        BND_ICON_LIGHTPAINT = 6153;
        BND_ICON_SCENE_DATA = 5888;
        BND_ICON_RENDERLAYERS = 5889;
        BND_ICON_WORLD_DATA = 5890;
        BND_ICON_OBJECT_DATA = 5891;
        BND_ICON_MESH_DATA = 5892;
        BND_ICON_CURVE_DATA = 5893;
        BND_ICON_META_DATA = 5894;
        BND_ICON_LATTICE_DATA = 5895;
        BND_ICON_LAMP_DATA = 5896;
        BND_ICON_MATERIAL_DATA = 5897;
        BND_ICON_TEXTURE_DATA = 5898;
        BND_ICON_ANIM_DATA = 5899;
        BND_ICON_CAMERA_DATA = 5900;
        BND_ICON_PARTICLE_DATA = 5901;
        BND_ICON_LIBRARY_DATA_DIRECT = 5902;
        BND_ICON_GROUP = 5903;
        BND_ICON_ARMATURE_DATA = 5904;
        BND_ICON_POSE_DATA = 5905;
        BND_ICON_BONE_DATA = 5906;
        BND_ICON_CONSTRAINT = 5907;
        BND_ICON_SHAPEKEY_DATA = 5908;
        BND_ICON_CONSTRAINT_BONE = 5909;
        BND_ICON_CAMERA_STEREO = 5910;
        BND_ICON_PACKAGE = 5911;
        BND_ICON_UGLYPACKAGE = 5912;
        BND_ICON_BRUSH_DATA = 5632;
        BND_ICON_IMAGE_DATA = 5633;
        BND_ICON_FILE = 5634;
        BND_ICON_FCURVE = 5635;
        BND_ICON_FONT_DATA = 5636;
        BND_ICON_RENDER_RESULT = 5637;
        BND_ICON_SURFACE_DATA = 5638;
        BND_ICON_EMPTY_DATA = 5639;
        BND_ICON_SETTINGS = 5640;
        BND_ICON_RENDER_ANIMATION = 5641;
        BND_ICON_RENDER_STILL = 5642;
        BND_ICON_BOIDS = 5644;
        BND_ICON_STRANDS = 5645;
        BND_ICON_LIBRARY_DATA_INDIRECT = 5646;
        BND_ICON_GREASEPENCIL = 5647;
        BND_ICON_LINE_DATA = 5648;
        BND_ICON_GROUP_BONE = 5650;
        BND_ICON_GROUP_VERTEX = 5651;
        BND_ICON_GROUP_VCOL = 5652;
        BND_ICON_GROUP_UVS = 5653;
        BND_ICON_RNA = 5656;
        BND_ICON_RNA_ADD = 5657;
        BND_ICON_OUTLINER_OB_EMPTY = 5120;
        BND_ICON_OUTLINER_OB_MESH = 5121;
        BND_ICON_OUTLINER_OB_CURVE = 5122;
        BND_ICON_OUTLINER_OB_LATTICE = 5123;
        BND_ICON_OUTLINER_OB_META = 5124;
        BND_ICON_OUTLINER_OB_LAMP = 5125;
        BND_ICON_OUTLINER_OB_CAMERA = 5126;
        BND_ICON_OUTLINER_OB_ARMATURE = 5127;
        BND_ICON_OUTLINER_OB_FONT = 5128;
        BND_ICON_OUTLINER_OB_SURFACE = 5129;
        BND_ICON_OUTLINER_OB_SPEAKER = 5130;
        BND_ICON_RESTRICT_VIEW_OFF = 5139;
        BND_ICON_RESTRICT_VIEW_ON = 5140;
        BND_ICON_RESTRICT_SELECT_OFF = 5141;
        BND_ICON_RESTRICT_SELECT_ON = 5142;
        BND_ICON_RESTRICT_RENDER_OFF = 5143;
        BND_ICON_RESTRICT_RENDER_ON = 5144;
        BND_ICON_OUTLINER_DATA_EMPTY = 4864;
        BND_ICON_OUTLINER_DATA_MESH = 4865;
        BND_ICON_OUTLINER_DATA_CURVE = 4866;
        BND_ICON_OUTLINER_DATA_LATTICE = 4867;
        BND_ICON_OUTLINER_DATA_META = 4868;
        BND_ICON_OUTLINER_DATA_LAMP = 4869;
        BND_ICON_OUTLINER_DATA_CAMERA = 4870;
        BND_ICON_OUTLINER_DATA_ARMATURE = 4871;
        BND_ICON_OUTLINER_DATA_FONT = 4872;
        BND_ICON_OUTLINER_DATA_SURFACE = 4873;
        BND_ICON_OUTLINER_DATA_SPEAKER = 4874;
        BND_ICON_OUTLINER_DATA_POSE = 4875;
        BND_ICON_MESH_PLANE = 4608;
        BND_ICON_MESH_CUBE = 4609;
        BND_ICON_MESH_CIRCLE = 4610;
        BND_ICON_MESH_UVSPHERE = 4611;
        BND_ICON_MESH_ICOSPHERE = 4612;
        BND_ICON_MESH_GRID = 4613;
        BND_ICON_MESH_MONKEY = 4614;
        BND_ICON_MESH_CYLINDER = 4615;
        BND_ICON_MESH_TORUS = 4616;
        BND_ICON_MESH_CONE = 4617;
        BND_ICON_LAMP_POINT = 4620;
        BND_ICON_LAMP_SUN = 4621;
        BND_ICON_LAMP_SPOT = 4622;
        BND_ICON_LAMP_HEMI = 4623;
        BND_ICON_LAMP_AREA = 4624;
        BND_ICON_META_EMPTY = 4627;
        BND_ICON_META_PLANE = 4628;
        BND_ICON_META_CUBE = 4629;
        BND_ICON_META_BALL = 4630;
        BND_ICON_META_ELLIPSOID = 4631;
        BND_ICON_META_CAPSULE = 4632;
        BND_ICON_SURFACE_NCURVE = 4352;
        BND_ICON_SURFACE_NCIRCLE = 4353;
        BND_ICON_SURFACE_NSURFACE = 4354;
        BND_ICON_SURFACE_NCYLINDER = 4355;
        BND_ICON_SURFACE_NSPHERE = 4356;
        BND_ICON_SURFACE_NTORUS = 4357;
        BND_ICON_CURVE_BEZCURVE = 4361;
        BND_ICON_CURVE_BEZCIRCLE = 4362;
        BND_ICON_CURVE_NCURVE = 4363;
        BND_ICON_CURVE_NCIRCLE = 4364;
        BND_ICON_CURVE_PATH = 4365;
        BND_ICON_COLOR_RED = 4371;
        BND_ICON_COLOR_GREEN = 4372;
        BND_ICON_COLOR_BLUE = 4373;
        BND_ICON_FORCE_FORCE = 4096;
        BND_ICON_FORCE_WIND = 4097;
        BND_ICON_FORCE_VORTEX = 4098;
        BND_ICON_FORCE_MAGNETIC = 4099;
        BND_ICON_FORCE_HARMONIC = 4100;
        BND_ICON_FORCE_CHARGE = 4101;
        BND_ICON_FORCE_LENNARDJONES = 4102;
        BND_ICON_FORCE_TEXTURE = 4103;
        BND_ICON_FORCE_CURVE = 4104;
        BND_ICON_FORCE_BOID = 4105;
        BND_ICON_FORCE_TURBULENCE = 4106;
        BND_ICON_FORCE_DRAG = 4107;
        BND_ICON_FORCE_SMOKEFLOW = 4108;
        BND_ICON_MODIFIER = 3072;
        BND_ICON_MOD_WAVE = 3073;
        BND_ICON_MOD_BUILD = 3074;
        BND_ICON_MOD_DECIM = 3075;
        BND_ICON_MOD_MIRROR = 3076;
        BND_ICON_MOD_SOFT = 3077;
        BND_ICON_MOD_SUBSURF = 3078;
        BND_ICON_HOOK = 3079;
        BND_ICON_MOD_PHYSICS = 3080;
        BND_ICON_MOD_PARTICLES = 3081;
        BND_ICON_MOD_BOOLEAN = 3082;
        BND_ICON_MOD_EDGESPLIT = 3083;
        BND_ICON_MOD_ARRAY = 3084;
        BND_ICON_MOD_UVPROJECT = 3085;
        BND_ICON_MOD_DISPLACE = 3086;
        BND_ICON_MOD_CURVE = 3087;
        BND_ICON_MOD_LATTICE = 3088;
        BND_ICON_CONSTRAINT_DATA = 3089;
        BND_ICON_MOD_ARMATURE = 3090;
        BND_ICON_MOD_SHRINKWRAP = 3091;
        BND_ICON_MOD_CAST = 3092;
        BND_ICON_MOD_MESHDEFORM = 3093;
        BND_ICON_MOD_BEVEL = 3094;
        BND_ICON_MOD_SMOOTH = 3095;
        BND_ICON_MOD_SIMPLEDEFORM = 3096;
        BND_ICON_MOD_MASK = 3097;
        BND_ICON_MOD_CLOTH = 2816;
        BND_ICON_MOD_EXPLODE = 2817;
        BND_ICON_MOD_FLUIDSIM = 2818;
        BND_ICON_MOD_MULTIRES = 2819;
        BND_ICON_MOD_SMOKE = 2820;
        BND_ICON_MOD_SOLIDIFY = 2821;
        BND_ICON_MOD_SCREW = 2822;
        BND_ICON_MOD_VERTEX_WEIGHT = 2823;
        BND_ICON_MOD_DYNAMICPAINT = 2824;
        BND_ICON_MOD_REMESH = 2825;
        BND_ICON_MOD_OCEAN = 2826;
        BND_ICON_MOD_WARP = 2827;
        BND_ICON_MOD_SKIN = 2828;
        BND_ICON_MOD_TRIANGULATE = 2829;
        BND_ICON_MOD_WIREFRAME = 2830;
        BND_ICON_REC = 2560;
        BND_ICON_PLAY = 2561;
        BND_ICON_FF = 2562;
        BND_ICON_REW = 2563;
        BND_ICON_PAUSE = 2564;
        BND_ICON_PREV_KEYFRAME = 2565;
        BND_ICON_NEXT_KEYFRAME = 2566;
        BND_ICON_PLAY_AUDIO = 2567;
        BND_ICON_PLAY_REVERSE = 2568;
        BND_ICON_PREVIEW_RANGE = 2569;
        BND_ICON_ACTION_TWEAK = 2570;
        BND_ICON_PMARKER_ACT = 2571;
        BND_ICON_PMARKER_SEL = 2572;
        BND_ICON_PMARKER = 2573;
        BND_ICON_MARKER_HLT = 2574;
        BND_ICON_MARKER = 2575;
        BND_ICON_SPACE2 = 2576;
        BND_ICON_SPACE3 = 2577;
        BND_ICON_KEYINGSET = 2578;
        BND_ICON_KEY_DEHLT = 2579;
        BND_ICON_KEY_HLT = 2580;
        BND_ICON_MUTE_IPO_OFF = 2581;
        BND_ICON_MUTE_IPO_ON = 2582;
        BND_ICON_VISIBLE_IPO_OFF = 2583;
        BND_ICON_VISIBLE_IPO_ON = 2584;
        BND_ICON_DRIVER = 2585;
        BND_ICON_SOLO_OFF = 2304;
        BND_ICON_SOLO_ON = 2305;
        BND_ICON_FRAME_PREV = 2306;
        BND_ICON_FRAME_NEXT = 2307;
        BND_ICON_NLA_PUSHDOWN = 2308;
        BND_ICON_IPO_CONSTANT = 2309;
        BND_ICON_IPO_LINEAR = 2310;
        BND_ICON_IPO_BEZIER = 2311;
        BND_ICON_IPO_SINE = 2312;
        BND_ICON_IPO_QUAD = 2313;
        BND_ICON_IPO_CUBIC = 2314;
        BND_ICON_IPO_QUART = 2315;
        BND_ICON_IPO_QUINT = 2316;
        BND_ICON_IPO_EXPO = 2317;
        BND_ICON_IPO_CIRC = 2318;
        BND_ICON_IPO_BOUNCE = 2319;
        BND_ICON_IPO_ELASTIC = 2320;
        BND_ICON_IPO_BACK = 2321;
        BND_ICON_IPO_EASE_IN = 2322;
        BND_ICON_IPO_EASE_OUT = 2323;
        BND_ICON_IPO_EASE_IN_OUT = 2324;
        BND_ICON_VERTEXSEL = 2048;
        BND_ICON_EDGESEL = 2049;
        BND_ICON_FACESEL = 2050;
        BND_ICON_LOOPSEL = 2051;
        BND_ICON_ROTATE = 2053;
        BND_ICON_CURSOR = 2054;
        BND_ICON_ROTATECOLLECTION = 2055;
        BND_ICON_ROTATECENTER = 2056;
        BND_ICON_ROTACTIVE = 2057;
        BND_ICON_ALIGN = 2058;
        BND_ICON_SMOOTHCURVE = 2060;
        BND_ICON_SPHERECURVE = 2061;
        BND_ICON_ROOTCURVE = 2062;
        BND_ICON_SHARPCURVE = 2063;
        BND_ICON_LINCURVE = 2064;
        BND_ICON_NOCURVE = 2065;
        BND_ICON_RNDCURVE = 2066;
        BND_ICON_PROP_OFF = 2067;
        BND_ICON_PROP_ON = 2068;
        BND_ICON_PROP_CON = 2069;
        BND_ICON_SCULPT_DYNTOPO = 2070;
        BND_ICON_PARTICLE_POINT = 2071;
        BND_ICON_PARTICLE_TIP = 2072;
        BND_ICON_PARTICLE_PATH = 2073;
        BND_ICON_MAN_TRANS = 1792;
        BND_ICON_MAN_ROT = 1793;
        BND_ICON_MAN_SCALE = 1794;
        BND_ICON_MANIPUL = 1795;
        BND_ICON_SNAP_OFF = 1796;
        BND_ICON_SNAP_ON = 1797;
        BND_ICON_SNAP_NORMAL = 1798;
        BND_ICON_SNAP_INCREMENT = 1799;
        BND_ICON_SNAP_VERTEX = 1800;
        BND_ICON_SNAP_EDGE = 1801;
        BND_ICON_SNAP_FACE = 1802;
        BND_ICON_SNAP_VOLUME = 1803;
        BND_ICON_STICKY_UVS_LOC = 1805;
        BND_ICON_STICKY_UVS_DISABLE = 1806;
        BND_ICON_STICKY_UVS_VERT = 1807;
        BND_ICON_CLIPUV_DEHLT = 1808;
        BND_ICON_CLIPUV_HLT = 1809;
        BND_ICON_SNAP_PEEL_OBJECT = 1810;
        BND_ICON_GRID = 1811;
        BND_ICON_PASTEDOWN = 1536;
        BND_ICON_COPYDOWN = 1537;
        BND_ICON_PASTEFLIPUP = 1538;
        BND_ICON_PASTEFLIPDOWN = 1539;
        BND_ICON_SNAP_SURFACE = 1544;
        BND_ICON_AUTOMERGE_ON = 1545;
        BND_ICON_AUTOMERGE_OFF = 1546;
        BND_ICON_RETOPO = 1547;
        BND_ICON_UV_VERTEXSEL = 1548;
        BND_ICON_UV_EDGESEL = 1549;
        BND_ICON_UV_FACESEL = 1550;
        BND_ICON_UV_ISLANDSEL = 1551;
        BND_ICON_UV_SYNC_SELECT = 1552;
        BND_ICON_BBOX = 1280;
        BND_ICON_WIRE = 1281;
        BND_ICON_SOLID = 1282;
        BND_ICON_SMOOTH = 1283;
        BND_ICON_POTATO = 1284;
        BND_ICON_ORTHO = 1286;
        BND_ICON_LOCKVIEW_OFF = 1289;
        BND_ICON_LOCKVIEW_ON = 1290;
        BND_ICON_AXIS_SIDE = 1292;
        BND_ICON_AXIS_FRONT = 1293;
        BND_ICON_AXIS_TOP = 1294;
        BND_ICON_NDOF_DOM = 1295;
        BND_ICON_NDOF_TURN = 1296;
        BND_ICON_NDOF_FLY = 1297;
        BND_ICON_NDOF_TRANS = 1298;
        BND_ICON_LAYER_USED = 1299;
        BND_ICON_LAYER_ACTIVE = 1300;
        BND_ICON_SORTALPHA = 768;
        BND_ICON_SORTBYEXT = 769;
        BND_ICON_SORTTIME = 770;
        BND_ICON_SORTSIZE = 771;
        BND_ICON_LONGDISPLAY = 772;
        BND_ICON_SHORTDISPLAY = 773;
        BND_ICON_GHOST = 774;
        BND_ICON_IMGDISPLAY = 775;
        BND_ICON_SAVE_AS = 776;
        BND_ICON_SAVE_COPY = 777;
        BND_ICON_BOOKMARKS = 778;
        BND_ICON_FONTPREVIEW = 779;
        BND_ICON_FILTER = 780;
        BND_ICON_NEWFOLDER = 781;
        BND_ICON_OPEN_RECENT = 782;
        BND_ICON_FILE_PARENT = 783;
        BND_ICON_FILE_REFRESH = 784;
        BND_ICON_FILE_FOLDER = 785;
        BND_ICON_FILE_BLANK = 786;
        BND_ICON_FILE_BLEND = 787;
        BND_ICON_FILE_IMAGE = 788;
        BND_ICON_FILE_MOVIE = 789;
        BND_ICON_FILE_SCRIPT = 790;
        BND_ICON_FILE_SOUND = 791;
        BND_ICON_FILE_FONT = 792;
        BND_ICON_FILE_TEXT = 793;
        BND_ICON_RECOVER_AUTO = 512;
        BND_ICON_SAVE_PREFS = 513;
        BND_ICON_LINK_BLEND = 514;
        BND_ICON_APPEND_BLEND = 515;
        BND_ICON_IMPORT = 516;
        BND_ICON_EXPORT = 517;
        BND_ICON_EXTERNAL_DATA = 518;
        BND_ICON_LOAD_FACTORY = 519;
        BND_ICON_LOOP_BACK = 525;
        BND_ICON_LOOP_FORWARDS = 526;
        BND_ICON_BACK = 527;
        BND_ICON_FORWARD = 528;
        BND_ICON_FILE_BACKUP = 536;
        BND_ICON_DISK_DRIVE = 537;
        BND_ICON_MATPLANE = 256;
        BND_ICON_MATSPHERE = 257;
        BND_ICON_MATCUBE = 258;
        BND_ICON_MONKEY = 259;
        BND_ICON_HAIR = 260;
        BND_ICON_ALIASED = 261;
        BND_ICON_ANTIALIASED = 262;
        BND_ICON_MAT_SPHERE_SKY = 263;
        BND_ICON_WORDWRAP_OFF = 268;
        BND_ICON_WORDWRAP_ON = 269;
        BND_ICON_SYNTAX_OFF = 270;
        BND_ICON_SYNTAX_ON = 271;
        BND_ICON_LINENUMBERS_OFF = 272;
        BND_ICON_LINENUMBERS_ON = 273;
        BND_ICON_SCRIPTPLUGINS = 274;
        BND_ICON_SEQ_SEQUENCER = 0;
        BND_ICON_SEQ_PREVIEW = 1;
        BND_ICON_SEQ_LUMA_WAVEFORM = 2;
        BND_ICON_SEQ_CHROMA_SCOPE = 3;
        BND_ICON_SEQ_HISTOGRAM = 4;
        BND_ICON_SEQ_SPLITVIEW = 5;
        BND_ICON_IMAGE_RGB = 9;
        BND_ICON_IMAGE_RGB_ALPHA = 10;
        BND_ICON_IMAGE_ALPHA = 11;
        BND_ICON_IMAGE_ZDEPTH = 12;
        BND_ICON_IMAGEFILE = 13;
    }
}

