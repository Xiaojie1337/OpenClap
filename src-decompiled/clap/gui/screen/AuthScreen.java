/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.Text
 */
package clap.gui.screen;

import java.security.Key;
import java.security.MessageDigest;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import clap.network.NetworkSupport_00OI;
import clap.model.DataRecord_0O0;
import clap.model.EnumType_O0II;
import clap.render.FontRenderer;
import clap.model.DataRecord_00io_0;
import clap.model.DataRecord_0oii_2;
import clap.gui.GuiSupport_oi0o_0;
import clap.config.ConfigSupport_oii0_1;
import clap.gui.GuiSupport_oo0_2;
import clap.gui.screen.AuthWelcomeScreen;
import clap.config.ConfigSupport_oooi_4;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.gui.screen.AuthScreen
 */
public class AuthScreen
extends Screen {
    private static final int OOoI;
    private static final int SprintModule;
    private static final int DataRecord_OOI0;
    private static final int OOoO;
    private boolean GuiSupport_O000 = true;
    private static final int OOoo;
    private long O0oo;
    private GuiSupport_oo0_2 O0Oi;
    private EnumType_O0II GuiComponent;
    private static final int OOiO;
    private static final int Manager;
    private final GuiSupport_oo0_2 OOi0 = new GuiSupport_oo0_2(this, "\u8d26\u53f7");
    private static final int GuiSupport_OOII;
    private final GuiSupport_oo0_2 SprintResetModule;
    private CompletableFuture RenderSupport_o0oo_1;
    private boolean EnumType_o0o0_0;
    private String AntiBotModule = "\u6b22\u8fce\u4f7f\u7528 Clap \u6388\u6743\u7cfb\u7edf";
    private static final long FontRenderer;
    private static final int OOIi;
    private static final int ConfigSupport_IO0;
    private static final int OOoi;
    private static final int EventHandler;
    private static final int IOi;
    private String NetworkSupport_o0oi_2 = "";
    private boolean O00o;
    private static final int OO0i;
    private float O00i = -1.0f;
    private final GuiSupport_oo0_2 OOio = new GuiSupport_oo0_2(this, "\u5bc6\u7801", true);
    private boolean EnumType_O00I;
    private final String O0Oo;
    private final GuiSupport_oo0_2 OOii;
    private final GuiSupport_oo0_2 EnumType_O0OO;
    private final GuiSupport_oo0_2 MoveFixModule = new GuiSupport_oo0_2(this, "\u8d85\u7ea7\u5bc6\u7801", true);
    private static final float HelpCommand;
    private static final int OOIo;
    static Object O0oi;
    private static volatile /* synthetic */ long __k__gH4it;

    private void OoIi(DrawContext param1, int param2, int param3, DataRecord_0oii_2 param4) {
        boolean v5 = this.Ooio(param2, param3, param4.O00o, param4.EnumType_O00I, param4.O00i, param4.RenderSupport_o0oo_1);
        int v6 = this.EnumType_O00I ? -12746006 : (v5 && !this.O00o ? 1379762922 : -669442260);
        param1.fill(Math.round(param4.O00o), Math.round(param4.EnumType_O00I), Math.round(param4.O00o + 13.0f), Math.round(param4.EnumType_O00I + 13.0f), v6);
        param1.drawStrokedRectangle(Math.round(param4.O00o), Math.round(param4.EnumType_O00I), 13, 13, this.EnumType_O00I ? -1426063361 : 945515394);
        if (this.EnumType_O00I) {
            this.oIO(param1, NetworkSupport_00OI.OoO(22), "\u221a", param4.O00o + 2.0f, param4.EnumType_O00I + 1.0f, -1);
        }
        this.oIO(param1, NetworkSupport_00OI.OoO(22), "\u8bb0\u4f4f\u5bc6\u7801", param4.O00o + 19.0f, param4.EnumType_O00I - 1.0f, v5 ? -722949 : -5194292);
    }

    private float Ooii(EnumType_O0II param1) {
        return param1 == EnumType_O0II.oi0 ? 274.0f : (param1.IOi == 4 ? 326.0f : (param1.IOi == 3 ? 286.0f : 252.0f));
    }

    private void oIO(DrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6) {
        param1.getMatrices().pushMatrix();
        param1.getMatrices().scale(0.5f, 0.5f);
        param2.PacketEvent(param1, param3, param4 / 0.5f, param5 / 0.5f, param6);
        param1.getMatrices().popMatrix();
    }

    private void IrcManager(EnumType_O0II param1) {
        this.GuiComponent = param1;
        this.O0Oi = null;
        this.Oo0i(param1);
        this.AntiBotModule = this.O0Oo.isBlank() ? "\u6b22\u8fce\u4f7f\u7528 Clap \u6388\u6743\u7cfb\u7edf" : this.O0Oo;
        this.GuiSupport_O000 = this.O0Oo.isBlank();
    }

    private GuiSupport_oo0_2[] PacketReceiveEvent() {
        GuiSupport_oo0_2[] oo0_2Array;
        switch (this.GuiComponent.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                GuiSupport_oo0_2[] oo0_2Array2 = new GuiSupport_oo0_2[2];
                oo0_2Array2[0] = this.OOi0;
                oo0_2Array = oo0_2Array2;
                oo0_2Array2[1] = this.OOio;
                break;
            }
            case 1: {
                GuiSupport_oo0_2[] oo0_2Array3 = new GuiSupport_oo0_2[4];
                oo0_2Array3[0] = this.OOi0;
                oo0_2Array3[1] = this.OOio;
                oo0_2Array3[2] = this.MoveFixModule;
                oo0_2Array = oo0_2Array3;
                oo0_2Array3[3] = this.OOii;
                break;
            }
            case 2: {
                GuiSupport_oo0_2[] oo0_2Array4 = new GuiSupport_oo0_2[2];
                oo0_2Array4[0] = this.OOi0;
                oo0_2Array = oo0_2Array4;
                oo0_2Array4[1] = this.SprintResetModule;
                break;
            }
            case 3: {
                GuiSupport_oo0_2[] oo0_2Array5 = new GuiSupport_oo0_2[3];
                oo0_2Array5[0] = this.OOi0;
                oo0_2Array5[1] = this.MoveFixModule;
                oo0_2Array = oo0_2Array5;
                oo0_2Array5[2] = this.EnumType_O0OO;
            }
        }
        return oo0_2Array;
    }

    private void OoIO(String param1) {
        this.GuiSupport_O000 = false;
        this.AntiBotModule = param1;
    }

    private float Module(float param1) {
        return Math.max(0.0f, Math.min(1.0f, param1));
    }

    public boolean method_25404(KeyInput param1) {
        if (this.EnumType_o0o0_0) {
            return true;
        }
        int v2 = param1.method_74228();
        if (v2 == 256) {
            return true;
        }
        if (v2 == 258) {
            this.KillAuraModule();
            return true;
        }
        if (v2 == 257) {
            this.Ooo0();
            return true;
        }
        if (this.O0Oi != null) {
            this.O0Oi.OOo(v2);
            return true;
        }
        return true;
    }

    private void Oooo(String param1, DataRecord_0O0 param22) {
        this.O00o = false;
        this.GuiSupport_O000 = param22.OiO();
        this.AntiBotModule = param22.Oi0();
        if (param22.OiO() && this.GuiComponent == EnumType_O0II.oio) {
            ConfigSupport_oooi_4.HelpCommand(param1, this.OOio.OOo, this.OOii.OOo.trim(), true);
            this.EnumType_O00I = true;
        }
        if (param22.OiO() && this.GuiComponent == EnumType_O0II.oi0) {
            ConfigSupport_oooi_4.HelpCommand(param1, this.OOio.OOo, this.OOii.OOo.trim(), this.EnumType_O00I);
            this.O00o = true;
            this.AntiBotModule = "\u6b63\u5728\u6821\u9a8c\u767b\u5f55\u72b6\u6001...";
            ConfigSupport_oii0_1.Ooo(param1, param22.Oio()).thenAccept(param2 -> this.field_22787.execute(() -> this.OooI(param1, (DataRecord_0O0)param2)));
        }
    }

    static {
        __k__gH4it = AuthScreen.__k__gH4it((long)8180775317468605969L);
        __rP__gH4it0 = new String[]{"\ue755\u0e80\ud0fb\u85f8\u055a\u8989\u02c6\ud4eb\ue017\u099d\ud7fd\u828b\u04f2\u88c0\u03bd\ud5a8\ue112\u08c0\ud6bd\u83ba\u0780\u8b3d?\ud669\ue2a1\u0b3b\ud524\u80b1\u06b9\u8aca\u0165\ud70a\ue340\u0a94\ud445\u8103\u0673\u85a2\u0e0a\ud824\uec8d\u056f\udb8b\u8ed6\u0921\u8431\u0f0d\ud94c\ued9f\u0430\udaa1\u8f9e\u0804\u878e\u0cc5\udad6\ueec5\u07e9\ud93a\u8c31\u0bbe\u86b5\u0d36\udb62\uef3e\u0694\ud8c0\u8d2e\u0aed\u86e6\u0a60\udcc4\ue8af\u0141\udf7c\u8ad7\u0d81\u8192\u0bc7\udd14\ue916\u0089\udecb\u8bda\u0c15\u80fb\u08b2\udec9\uea34\u032b\udd45\u88fd\u0f01\u83b9\u09ad\udf76\ueb9b\u0206\udca4\u89f4\u0e1b\u82be\u0996\ue018\ud4ca\u3df5\ue371\ub6b2\u310d\ubd8a\u3661\ue1a5\ud520\u3c46\ue23e\ub7b6\u30a1\ubc2a\u3767\ue2c3\ud6c3\u3fde\ue136\ub418\u330d\ubfc0\u340f\ue3e2\ud703\u3ecf\ue0c8\ub572\u329b\ubed9\u35d3\ue321\ud02b\u396a\ue7b6\ub2cd\u3597\ub9a2\u3241\ue4e8\ud1bf\u38a4\ue613\ub363\u342f\ub826\u3399\ue5d7\ud299\u3b29\ue53c\ub049\u37f5\ubb7d\u30c5\ue6c0\ud368\u3a40\ue4b9\ub193\u36b9\ubac4\u3140\ue78d\ud38a\u35cd\uebe5\ube90\u395a\ub594\u3e99\ue862\udc4f\u34b8\uea2a\ubfcd\u38f0\ub4e4\u3f8d\ue9e4\uddc6\u37e8\ue914\ubc1d\u3bbd\ub7e8\u3c42\ueaca\udea1\u36f2\ue852\ubdc6\u3a64\ub64b\u3d5c\ueb7b\udf3d\u3674\uef28\uba75\u3d2b\ub1d2\u3a3f\uec74\ud817\u316b\uee0d\ubb04\u3c98\ub01f\u3b78\uedfb\ud961\u3082\ued33\ub88c\u3fa1\ub3d5\u38f5\uee71\uda64\u33e3\ued37\ub991\u3ec9\ub211\u391c\uef50\udb66\u32f4\uecd7\ua688\u211e\uad6f\u264a\uf001\uc4c7\u2d37\uf322\ua78d\u20f1\uac24\u2743\uf1fb\uc5a5\u2c92\uf284\ua40d\u2374\uaf11\u24e8\uf267\uc6db\u2f97\uf1e3\ua41a\u22c5\uaef9\u25e8\uf331\uc7de\u2e3a\uf0f4\ua5b3\u257c\ua96c\u223c\uf421\uc0f8\u29de\uf79d\ua252\u2418\ua867\u23cb\uf540\uc10a\u2886\uf61b\ua317\u27d0\uabc4\u200a\uf686\uc2be\u2b5a\uf517\ua06b\u27dc\uaa89\u2190\uf74a\uc33c\u2a76\uf4e9\ua10a\u262b\ua54b\u2ec4\uf8b0\ucc04\u25ab\ufba1\uae26\u2939\ua48f\u2f90\uf97d\ucd0f\u24d3\ufa3d\uaf84\u28fe\ua7b0\u2c53\ufad6\uce23\u2779\uf93b\uacdb\u2b61\ua7ef\u2de5\ufbdb\ucfd9\u269c\uf816\uadf0\u2ab7\ua634\u2ae0\ufcb5\uc829\u217c\uff4c\uaa5d\u2d6b\ua195\u2b45\ufd40\uc96d\u2097\ufe8c\uab87\u2c87\ua0eb\u2874\ufee6\uca6b\u2319\ufda8\ua83d\u2f51\ua359\u2808\ufff9\ucb26\u22c7\ufc4c\ua93d\u2e1c\ua2c6\u299f\u00f1", "\ue6bf\u0f90\ud084\u8569\u023a\u8e9a\u05fa\ud35e\ue7a1\u0eea", "\ue6ad\u0f93\ud092\u8503\u0228\u8e8f\u05e1", "\ue6a8\u0f92\ud08a\u851e\u0221"};
        __rP__gH4it1 = new String[]{"\ue6bd\u0f87\ud09b"};
        __rP__gH4it2 = new String[]{"\ue6bd\u0f9e\ud08a\u856b\u0238\u8e9c\u05fc\ud35c\ue7a3\u0ef4", "\ue6ab\u0f91\ud171\u8532\u0228\u8ecf\u0565\ud363\ue7c7\u0ea7\ud069\u8246\u0556\u89d5\u024f\ud420\ue0fb\u098d\ud75c\u836a"};
        __rP__gH4it3 = new String[]{"\ue63c\u0f1a\ud0f5\u85f1\u022d\u8e47\u057c\ud31c"};
        byte[] v0 = "\u00dat\u00f9\u0005\u0011d\u00c0G\u00a0\u0011\u00f7~\u00b1%\u00b3\f\u00adD\u00afW\u00db\u00c0)\u00d5\u0006\u00a7>T\u00ea?{\u00be\u00ef\u0000'\u00de\u00d8ol\u00a8\u00da\u00c3\u00e1\u0003\u0082\u00f4c\u00c8\u00c0\u0094\u00d3S\u00bfS\u00b3J\u0082U@\u00f4\r`H\u00f6q \u0082\u0093f\u00cb&(\u00d8\r6b\u0002\u00b7\u0089\u00f0i\u00cd\u0099w\u008e\u00c6\u00e45Sw\u001fX\u0092\u008c\u00f3\u0082\u00f4R\u0006i\u00f0\u00b30\u00d4\u00dd\u0099\u00db'\u00ee\u008f\u00cfa?\"\u008c;Z7\u00d1\u001f\u00c4\u00a2\u008c\u009d\u00fe\u00d5\u00b16\f\u00bbJ\u000fP\u00b4U\r\u001cf<\u00b8T\u00c7\u00cf\u00cc\u0080\u00a0\u0081\u000e\u00f4[\u000f\u00eb\u00be5\u00a6,&\b[\u00f4GT[\u00ce\u0092\u0089\u00a6\u0081]\u00e1\u000f\u00c5y\u00d1wf\u0090\u009c\u00d8\u0080\u00cb\u00b9{\u00f8\u0001\u00d4\u00eeX\u008e\u00bd\u00bc\u00den\u00c6\u0090\u00fbo\u00e6\u009a\u0017\u00ca\u00b8\u00e2@(w\u00f1\u0010\u00e8\u00af\u00df)\u0083\u00a2\u00ae\u0087\u0086^\u00e9\u00a9\u00b2`+\u0005\u008b7\u0015\u008c\u00a2\u009c:\u001c\u00f1\u0018\u00fd\u009d}\u00eadEX\u00d3\u0010\u0080\u008a\u00b9u\u00a7\"n\u00be\b\u0007\u0084\u00d63Tc\u00e1\u00e7\u008e\u0014\u00ee\u009di\u00b6\u00feF?\u00892\u0085GZ\u008f\u00bfC\u009a\u00dd\u00fc\u00ad\u001a\u0001\u00f2\u00831\u00142\u0011\u00ceu\u00b6wD\u00f6\u00c6k\u00da\u0083\u00df\u0088\u008e\u00aa4[\u000f\u00d3\u00eb\u0082R\u00e6\u00e1HoGAMe-Bl\u00cdyf\u00ea\u00c2\u00a37\u00ae\u00d0\\E4\u0011\u00aeQV8\u001e\u00f0\u00f0\u00a8\u0013\u00bc\n\u00cb\u00d6\"\u0014\u00de*\u0012\u0004M\n\u00a0\u00baT\u00ae51\u00ab\u00e6\u00a8\u00ff\u00c315".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c9\u00d41\u00ca,\u00e0\u00b4~".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1161992586;
                case 1 -> 336668630;
                case 2 -> -1943104294;
                case 3 -> 1503495069;
                case 4 -> -27189462;
                case 5 -> 1553422625;
                case 6 -> 637875505;
                case 7 -> 334323832;
                case 8 -> 1601990246;
                case 9 -> -106686062;
                case 10 -> 1870770940;
                case 11 -> -1501751073;
                case 12 -> 1150998739;
                case 13 -> 1805867162;
                case 14 -> -1633937784;
                case 15 -> 1087204587;
                case 16 -> 37755269;
                case 17 -> -437107639;
                case 18 -> 852293979;
                case 19 -> 369616084;
                case 20 -> -902563067;
                case 21 -> 2095824867;
                case 22 -> 1992612050;
                case 23 -> -1476219878;
                case 24 -> 1313933686;
                case 25 -> -1466538390;
                case 26 -> -613549879;
                case 27 -> 1352506921;
                case 28 -> 1156774978;
                case 29 -> -844452212;
                case 30 -> -1289726314;
                case 31 -> -1915352744;
                case 32 -> -1378552086;
                case 33 -> 1058719073;
                case 34 -> 1350642610;
                case 35 -> 78910911;
                case 36 -> -2069117016;
                case 37 -> -1230166856;
                case 38 -> 402522387;
                case 39 -> -837956420;
                case 40 -> 1623769399;
                case 41 -> -422177867;
                case 42 -> 929917955;
                case 43 -> -884401231;
                case 44 -> -1965693722;
                case 45 -> 1108052480;
                case 46 -> 1667093517;
                case 47 -> 1778872358;
                case 48 -> -1954259452;
                case 49 -> -678289383;
                case 50 -> -1086525430;
                case 51 -> 691713529;
                case 52 -> -1676497977;
                case 53 -> -1703342516;
                case 54 -> 1795742752;
                case 55 -> 969720755;
                case 56 -> -1272982957;
                case 57 -> 677796914;
                case 58 -> -1327112483;
                case 59 -> -436230010;
                case 60 -> -208303962;
                case 61 -> 1110691525;
                case 62 -> 1963087503;
                case 63 -> -968995512;
                case 64 -> -1546961216;
                case 65 -> 1668294723;
                case 66 -> -52139531;
                case 67 -> -981840578;
                case 68 -> 211833630;
                case 69 -> -153103618;
                case 70 -> -422358178;
                case 71 -> 1001199716;
                case 72 -> 1902903276;
                case 73 -> 2018704750;
                case 74 -> -389512113;
                case 75 -> -270551807;
                case 76 -> 176533015;
                case 77 -> -958998984;
                case 78 -> -1233981746;
                case 79 -> 897430903;
                case 80 -> 319870010;
                case 81 -> 279600114;
                case 82 -> -241622873;
                case 83 -> -135453418;
                case 84 -> -1545371773;
                case 85 -> 599188910;
                case 86 -> -573760437;
                case 87 -> -592534995;
                case 88 -> 873407247;
                case 89 -> -992507231;
                case 90 -> 1915683414;
                case 91 -> 2095437605;
                case 92 -> 436696176;
                case 93 -> -1388722875;
                case 94 -> 1881800694;
                case 95 -> 1952183907;
                case 96 -> 903560848;
                case 97 -> 1389703652;
                case 98 -> 518593404;
                case 99 -> -619506920;
                case 100 -> 833590527;
                case 101 -> 111095157;
                case 102 -> -688402679;
                case 103 -> -124101479;
                case 104 -> 837665876;
                case 105 -> -1006979395;
                case 106 -> 1918664981;
                case 107 -> 985700084;
                case 108 -> -694622262;
                case 109 -> 1211356423;
                case 110 -> 700011970;
                case 111 -> -448567359;
                case 112 -> -1958212962;
                case 113 -> 1641639904;
                case 114 -> 954329549;
                case 115 -> -1829812212;
                case 116 -> 260975175;
                case 117 -> -2051060318;
                case 118 -> -1961168720;
                case 119 -> -1819464037;
                case 120 -> 510238150;
                case 121 -> 1973266851;
                case 122 -> -2094875597;
                case 123 -> -499629532;
                case 124 -> 753439275;
                case 125 -> 1910679535;
                case 126 -> -210751155;
                case 127 -> -561563027;
                case 128 -> 1724434279;
                case 129 -> 278754630;
                case 130 -> 1778889793;
                case 131 -> -174447301;
                case 132 -> -1481334599;
                case 133 -> 1571944210;
                case 134 -> -686030339;
                case 135 -> -405355269;
                case 136 -> 18887269;
                case 137 -> -2013311356;
                case 138 -> 950734775;
                case 139 -> -1842692229;
                case 140 -> -68351820;
                case 141 -> -1290628067;
                case 142 -> -1515889772;
                case 143 -> -414431328;
                case 144 -> -903638220;
                case 145 -> -526218032;
                case 146 -> -1020244146;
                case 147 -> -1142487595;
                case 148 -> -461527608;
                case 149 -> -1884799574;
                case 150 -> 880448649;
                case 151 -> -382968966;
                case 152 -> 2037211659;
                case 153 -> 598975710;
                case 154 -> -341603735;
                case 155 -> 555439929;
                case 156 -> -1006601299;
                case 157 -> 1432025995;
                case 158 -> -962252084;
                case 159 -> 1078322363;
                case 160 -> 12037480;
                case 161 -> 2006334639;
                case 162 -> -1740486352;
                case 163 -> 1730024495;
                case 164 -> -1318662346;
                case 165 -> -591404653;
                case 166 -> -1997514509;
                case 167 -> 976195791;
                case 168 -> 665972984;
                case 169 -> -468775539;
                case 170 -> -1462764059;
                case 171 -> 844531572;
                case 172 -> -1811920402;
                case 173 -> 1961792605;
                case 174 -> 138656352;
                case 175 -> 1430694716;
                case 176 -> -721025596;
                case 177 -> -606628306;
                case 178 -> -891815360;
                case 179 -> 1221204021;
                case 180 -> -158193192;
                case 181 -> 59614373;
                case 182 -> 1580542427;
                case 183 -> -783731625;
                case 184 -> 895359871;
                case 185 -> 17145244;
                case 186 -> 1727990913;
                case 187 -> 464115176;
                case 188 -> -1116697566;
                case 189 -> 1730133032;
                case 190 -> -1911378883;
                case 191 -> -190491776;
                case 192 -> 2038286743;
                case 193 -> 485524961;
                case 194 -> 1137087527;
                case 195 -> 1503282715;
                case 196 -> -1211383687;
                case 197 -> -1260677886;
                case 198 -> -756603407;
                case 199 -> -908585564;
                case 200 -> 885008277;
                case 201 -> -276927215;
                case 202 -> -463258238;
                case 203 -> -391145365;
                case 204 -> 413378942;
                case 205 -> 177784913;
                case 206 -> 1832618947;
                case 207 -> 1769306638;
                case 208 -> 2106391388;
                case 209 -> 1292051372;
                case 210 -> 478754463;
                case 211 -> -866643765;
                case 212 -> 1075000921;
                case 213 -> 1956340515;
                case 214 -> -711543697;
                case 215 -> 515102276;
                case 216 -> -778636513;
                case 217 -> -48568350;
                case 218 -> -867170162;
                case 219 -> 145674667;
                case 220 -> -505027504;
                case 221 -> -699902110;
                case 222 -> 385723654;
                case 223 -> -711689684;
                case 224 -> 1744107996;
                case 225 -> -265616912;
                case 226 -> 965735671;
                case 227 -> -1980697270;
                case 228 -> -2102832364;
                case 229 -> -603148737;
                case 230 -> 2062983263;
                case 231 -> 1258535303;
                case 232 -> 191399184;
                case 233 -> -1401807897;
                case 234 -> 106620887;
                case 235 -> 1947136681;
                case 236 -> 2024598386;
                case 237 -> -1140745347;
                case 238 -> -1630515274;
                case 239 -> 1753887640;
                case 240 -> -815590163;
                case 241 -> 1188200145;
                case 242 -> 1450373640;
                case 243 -> 60051646;
                case 244 -> 446795962;
                case 245 -> -233352727;
                case 246 -> -2144330388;
                case 247 -> 241791857;
                case 248 -> -224617583;
                case 249 -> -692057259;
                case 250 -> 1340106490;
                case 251 -> 1449112348;
                case 252 -> -1983158055;
                case 253 -> 869314419;
                case 254 -> 220767578;
                case 255 -> 1346232402;
                default -> 172825704;
            });
        } while (v2 != 368);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        int v3 = v0.length;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        v2 = v3 - 32;
        messageDigest.update(v0, 0, v2);
        v1 = messageDigest.digest();
        int v4 = 0;
        int v52 = 0;
        int v6 = 0;
        do {
            v52 |= v0[v2 + v4] ^ v1[v4];
        } while (++v4 != 32);
        if (v52 == 0) {
            Object[] objectArray = new Object[22];
            v1 = objectArray;
            O0oi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OOiO = -33402;
        OOIi = -10035552;
        GuiSupport_OOII = -8615269;
        OOIo = -5194292;
        ConfigSupport_IO0 = -722949;
        DataRecord_OOI0 = -12746006;
        Manager = -11890704;
        OOoi = -13273132;
        OOoI = -283105224;
        OOoo = -669442260;
        EventHandler = -1518553089;
        OOoO = 945515394;
        OO0i = -1206115280;
        IOi = -250209240;
        SprintModule = -250538464;
        FontRenderer = 420L;
        HelpCommand = 0.5f;
    }

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        int v7;
        if (this.Oooi()) {
            GuiSupport_oi0o_0.OOI0O(param1, 0, 0, param1.getScaledWindowWidth(), param1.getScaledWindowHeight(), -250538464, -250209240, -250209240, -250538464);
            return;
        }
        this.OoiO();
        DataRecord_0oii_2 v5 = this.OoiI(param1.getScaledWindowWidth(), param1.getScaledWindowHeight());
        GuiSupport_oi0o_0.OOI0O(param1, 0, 0, param1.getScaledWindowWidth(), param1.getScaledWindowHeight(), -250538464, -250209240, -250209240, -250538464);
        param1.fill(Math.round(v5.0oO), Math.round(v5.0o0), Math.round(v5.0oO + v5.SpawnerFinderModule), Math.round(v5.0o0 + v5.0oI), -1206115280);
        param1.drawStrokedRectangle(Math.round(v5.0oO), Math.round(v5.0o0), Math.round(v5.SpawnerFinderModule), Math.round(v5.0oI), 945515394);
        this.Ooi0(param1, NetworkSupport_00OI.OoO(48), "AUTH", v5.0oO, v5.0o0 + 18.0f, v5.SpawnerFinderModule, -722949);
        this.oIO(param1, NetworkSupport_00OI.OoO(22), "\u7248\u672c 1", v5.0oO + 18.0f, v5.0o0 + v5.0oI - 22.0f, -8615269);
        this.OoII(param1, param2, param3, v5);
        GuiSupport_oo0_2[] v6 = this.PacketReceiveEvent();
        for (v7 = 0; v7 < v6.length; ++v7) {
            v6[v7].PacketEvent(param1, v5.Ooo0(), v5.SprintResetModule + (float)v7 * v5.O0Oo, v5.Oooo(), this.O0Oi == v6[v7]);
        }
        if (this.GuiComponent == EnumType_O0II.oi0) {
            this.OoIi(param1, param2, param3, v5);
        }
        v7 = this.Ooio(param2, param3, v5.GuiComponent, v5.O0Oi, v5.AntiBotModule, v5.GuiSupport_O000) ? 1 : 0;
        param1.fill(Math.round(v5.GuiComponent), Math.round(v5.O0Oi), Math.round(v5.GuiComponent + v5.AntiBotModule), Math.round(v5.O0Oi + v5.GuiSupport_O000), this.O00o ? -11378575 : (v7 != 0 ? -11890704 : -13273132));
        param1.drawStrokedRectangle(Math.round(v5.GuiComponent), Math.round(v5.O0Oi), Math.round(v5.AntiBotModule), Math.round(v5.GuiSupport_O000), v7 != 0 && !this.O00o ? -1426063361 : 0x38FFFFFF);
        this.Ooi0(param1, NetworkSupport_00OI.OoO(28), this.O00o ? "\u8bf7\u7a0d\u5019..." : this.GuiComponent.ConfigSupport_IO0, v5.GuiComponent, v5.O0Oi + 8.0f, v5.AntiBotModule, -1);
        if (!this.AntiBotModule.isBlank()) {
            this.Ooi0(param1, NetworkSupport_00OI.OoO(24), this.AntiBotModule, v5.0oO, v5.0o0 + v5.0oI - 31.0f, v5.SpawnerFinderModule, this.GuiSupport_O000 ? -10035552 : -33402);
        }
        if (this.EnumType_o0o0_0) {
            float v8 = this.Module((float)(System.currentTimeMillis() - this.O0oo) / 420.0f);
            int v9 = this.EnumType_OOO0(-250538464, Math.round(255.0f * this.iii(v8)));
            param1.fill(0, 0, param1.getScaledWindowWidth(), param1.getScaledWindowHeight(), v9);
        }
    }

    private boolean 0ii() {
        return System.currentTimeMillis() / 450L % 2L == 0L;
    }

    static /* synthetic */ MinecraftClient EnumType_OI0O(AuthScreen param0) {
        return param0.field_22787;
    }

    private void OooI(String param1, DataRecord_0O0 param2) {
        this.O00o = false;
        this.GuiSupport_O000 = param2.OiO();
        this.AntiBotModule = param2.Oi0();
        if (!param2.OiO()) {
            return;
        }
        this.EnumType_o0o0_0 = true;
        this.O0oo = System.currentTimeMillis();
        this.NetworkSupport_o0oi_2 = param1;
    }

    public boolean method_25402(Click param1, boolean param2) {
        if (this.EnumType_o0o0_0) {
            return true;
        }
        double v3 = param1.x();
        double v5 = param1.y();
        if (param1.button() != 0) {
            return true;
        }
        DataRecord_0oii_2 v7 = this.OoiI(this.field_22787.getWindow().getScaledWidth(), this.field_22787.getWindow().getScaledHeight());
        EnumType_O0II[] v8 = EnumType_O0II.values();
        for (int v9 = 0; v9 < v8.length; ++v9) {
            float v10 = v7.OOIi + (float)v9 * v7.MoveFixModule;
            if (!this.Ooio(v3, v5, v10, v7.OOiO, v7.OOi0, v7.OOio)) continue;
            if (!this.O00o) {
                this.IrcManager(v8[v9]);
            }
            return true;
        }
        if (this.GuiComponent == EnumType_O0II.oi0 && this.Ooio(v3, v5, v7.O00o, v7.EnumType_O00I, v7.O00i, v7.RenderSupport_o0oo_1)) {
            this.EnumType_O00I = !this.EnumType_O00I;
            return true;
        }
        this.O0Oi = null;
        for (GuiSupport_oo0_2 v12 : this.PacketReceiveEvent()) {
            if (!v12.HelpCommand(v3, v5)) continue;
            this.O0Oi = v12;
            break;
        }
        if (this.Ooio(v3, v5, v7.GuiComponent, v7.O0Oi, v7.AntiBotModule, v7.GuiSupport_O000)) {
            this.Ooo0();
        }
        return true;
    }

    public AuthScreen(String param1) {
        super((Text)Text.literal((String)"clap-auth"));
        this.OOii = new GuiSupport_oo0_2(this, "QQ");
        this.EnumType_O0OO = new GuiSupport_oo0_2(this, "\u65b0\u5bc6\u7801", true);
        this.SprintResetModule = new GuiSupport_oo0_2(this, "\u5145\u503c\u5361\u5bc6");
        this.GuiComponent = EnumType_O0II.oi0;
        this.OooO();
        String string = this.O0Oo = param1 == null ? "" : param1;
        if (!this.O0Oo.isBlank()) {
            this.AntiBotModule = this.O0Oo;
            this.GuiSupport_O000 = false;
        }
    }

    public boolean method_25422() {
        return false;
    }

    private DataRecord_0oii_2 OoiI(int param1, int param2) {
        float v3 = Math.min(420.0f, (float)param1 - 34.0f);
        float v4 = this.O00i > 0.0f ? this.O00i : this.Ooii(this.GuiComponent);
        float v5 = ((float)param1 - v3) * 0.5f;
        float v6 = ((float)param2 - v4) * 0.5f;
        float v7 = Math.min(292.0f, v3 - 64.0f);
        float v8 = v5 + (v3 - v7) * 0.5f;
        float v12 = v5 + (v3 - 304.0f) * 0.5f;
        float v13 = v6 + 94.0f;
        float v16 = v13 + (float)this.GuiComponent.IOi * 38.0f + 1.0f;
        float v17 = this.GuiComponent == EnumType_O0II.oi0 ? 17.0f : 0.0f;
        float v18 = this.GuiComponent == EnumType_O0II.oi0 ? 25.0f : 5.0f;
        float v22 = v13 + (float)this.GuiComponent.IOi * 38.0f + v18;
        return new DataRecord_0oii_2(v5, v6, v3, v4, v5, 0.0f, v12, v6 + 59.0f, 70.0f, 24.0f, 78.0f, v8, v7, v13, 38.0f, v8, v22, v7, 29.0f, v8, v16, 92.0f, v17);
    }

    private void OoII(DrawContext param1, int param2, int param3, DataRecord_0oii_2 param4) {
        EnumType_O0II[] v5 = EnumType_O0II.values();
        for (int v6 = 0; v6 < v5.length; ++v6) {
            float v7 = param4.OOIi + (float)v6 * param4.MoveFixModule;
            boolean v8 = this.GuiComponent == v5[v6];
            boolean v9 = this.Ooio(param2, param3, v7, param4.OOiO, param4.OOi0, param4.OOio);
            int v10 = v8 ? -12746006 : (v9 && !this.O00o ? 1379762922 : 0);
            param1.fill(Math.round(v7), Math.round(param4.OOiO), Math.round(v7 + param4.OOi0), Math.round(param4.OOiO + param4.OOio), v10 != 0 ? v10 : -1977604040);
            param1.drawStrokedRectangle(Math.round(v7), Math.round(param4.OOiO), Math.round(param4.OOi0), Math.round(param4.OOio), v8 ? -1996488705 : 0x1FFFFFFF);
            this.Ooi0(param1, NetworkSupport_00OI.OoO(27), v5[v6].WatermarkHudElement, v7, param4.OOiO + 7.0f, param4.OOi0, v8 ? -1 : -5194292);
        }
    }

    private void Ooo0() {
        if (this.O00o) {
            return;
        }
        if (!ConfigSupport_oii0_1.OOo()) {
            this.OoIO(ConfigSupport_oii0_1.GuiSupport_OOI());
            return;
        }
        String v1 = this.OOi0.OOo.trim();
        String v2 = this.OOio.OOo;
        String v3 = this.MoveFixModule.OOo;
        String v4 = this.OOii.OOo.trim();
        String v5 = this.EnumType_O0OO.OOo;
        String v6 = this.SprintResetModule.OOo.trim();
        if (v1.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165\u8d26\u53f7");
            return;
        }
        if ((this.GuiComponent == EnumType_O0II.oi0 || this.GuiComponent == EnumType_O0II.oio) && v2.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165\u5bc6\u7801");
            return;
        }
        if ((this.GuiComponent == EnumType_O0II.oio || this.GuiComponent == EnumType_O0II.oii) && v3.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165\u8d85\u7ea7\u5bc6\u7801");
            return;
        }
        if (this.GuiComponent == EnumType_O0II.oio && v4.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165 QQ");
            return;
        }
        if (this.GuiComponent == EnumType_O0II.oiI && v6.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165\u5145\u503c\u5361\u5bc6");
            return;
        }
        if (this.GuiComponent == EnumType_O0II.oii && v5.isBlank()) {
            this.OoIO("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801");
            return;
        }
        this.O00o = true;
        this.GuiSupport_O000 = true;
        this.AntiBotModule = "\u6b63\u5728\u8fde\u63a5\u9a8c\u8bc1\u670d\u52a1\u5668...";
        this.RenderSupport_o0oo_1 = switch (this.GuiComponent.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> ConfigSupport_oii0_1.HelpCommand().PacketEvent(v1, v2);
            case 1 -> ConfigSupport_oii0_1.HelpCommand().HelpCommand(v1, v2, v3, v4);
            case 2 -> ConfigSupport_oii0_1.HelpCommand().OOo(v1, v6);
            case 3 -> ConfigSupport_oii0_1.HelpCommand().EventBusApi(v1, v3, v5);
        };
        this.RenderSupport_o0oo_1.thenAccept(param2 -> this.field_22787.execute(() -> this.Oooo(v1, (DataRecord_0O0)param2)));
    }

    private void Oo0i(EnumType_O0II param1) {
        if (param1 == EnumType_O0II.oi0) {
            this.OooO();
            return;
        }
        if (param1 == EnumType_O0II.oio) {
            this.OOi0.OOo = "";
            this.OOio.OOo = "";
            this.MoveFixModule.OOo = "";
            this.OOii.OOo = "";
            return;
        }
        DataRecord_00io_0 v2 = ConfigSupport_oooi_4.PacketEvent();
        if (this.OOi0.OOo.isBlank()) {
            this.OOi0.OOo = v2.OoO0();
        }
    }

    static /* synthetic */ MinecraftClient RotationModule(AuthScreen param0) {
        return param0.field_22787;
    }

    static /* synthetic */ MinecraftClient OIoO(AuthScreen param0) {
        return param0.field_22787;
    }

    static /* synthetic */ MinecraftClient CameraClipModule(AuthScreen param0) {
        return param0.field_22787;
    }

    private void KillAuraModule() {
        GuiSupport_oo0_2[] v1 = this.PacketReceiveEvent();
        if (v1.length == 0) {
            return;
        }
        int v2 = 0;
        for (int v3 = 0; v3 < v1.length; ++v3) {
            if (v1[v3] != this.O0Oi) continue;
            v2 = (v3 + 1) % v1.length;
            break;
        }
        this.O0Oi = v1[v2];
    }

    static /* synthetic */ MinecraftClient OIOi(AuthScreen param0) {
        return param0.field_22787;
    }

    private boolean Ooio(double param1, double param3, float param5, float param6, float param7, float param8) {
        return param1 >= (double)param5 && param1 <= (double)(param5 + param7) && param3 >= (double)param6 && param3 <= (double)(param6 + param8);
    }

    private float iii(float param1) {
        float v2 = this.Module(param1);
        return 1.0f - (1.0f - v2) * (1.0f - v2) * (1.0f - v2);
    }

    public boolean method_25400(CharInput param1) {
        if (this.EnumType_o0o0_0) {
            return true;
        }
        if (this.O0Oi != null) {
            this.O0Oi.GuiSupport_OOI(param1.codepoint());
            return true;
        }
        return true;
    }

    private void OoiO() {
        float v1 = this.Ooii(this.GuiComponent);
        if (this.O00i < 0.0f) {
            this.O00i = v1;
            return;
        }
        float v2 = v1 - this.O00i;
        this.O00i = Math.abs(v2) < 0.2f ? v1 : (this.O00i += v2 * 0.22f);
    }

    static /* synthetic */ MinecraftClient OI0o(AuthScreen param0) {
        return param0.field_22787;
    }

    private void OooO() {
        DataRecord_00io_0 v1 = ConfigSupport_oooi_4.PacketEvent();
        this.OOi0.OOo = v1.OoO0();
        this.OOio.OOo = v1.OIIi() ? v1.OOio() : "";
        this.EnumType_O00I = v1.OIIi();
    }

    private int EnumType_OOO0(int param1, int param2) {
        int v3 = Math.max(0, Math.min(255, param2));
        return v3 << 24 | param1 & 0xFFFFFF;
    }

    static /* synthetic */ MinecraftClient OI0i(AuthScreen param0) {
        return param0.field_22787;
    }

    private void Ooi0(DrawContext param1, FontRenderer param2, String param3, float param4, float param5, float param6, int param7) {
        float v8 = (float)param2.GuiSupport_OOI(param3) * 0.5f;
        this.oIO(param1, param2, param3, param4 + (param6 - v8) * 0.5f, param5, param7);
    }

    private boolean Oooi() {
        if (!this.EnumType_o0o0_0) {
            return false;
        }
        if (System.currentTimeMillis() - this.O0oo >= 420L) {
            this.EnumType_o0o0_0 = false;
            this.field_22787.setScreen((Screen)new AuthWelcomeScreen(this.NetworkSupport_o0oi_2));
            return true;
        }
        return false;
    }
}

