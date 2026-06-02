/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.OrderedText
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Text
 *  org.lwjgl.glfw.GLFW
 */
package clap.gui.screen;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.OrderedText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import clap.gui.hud.HudElement;
import clap.core.module.Module;
import clap.gui.screen.ClickGuiScreenV2;
import clap.gui.GuiSupport_o0ii_1;
import clap.core.module.ModuleCategory;
import clap.render.RenderSupport_oooo_2;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.OoIO
 */
public class HudEditorScreenV2
extends Screen {
    private static final int oII;
    private final List RenderSupport_oio_2 = new ArrayList();
    private static HudEditorScreenV2 oIi;
    public boolean oio;
    public HudElement oi0;
    static Object oiI;
    private static volatile /* synthetic */ long __k__gH4it;

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        RenderSupport_oooo_2.begin("CLAP_HUD_EDITOR");
        try {
            this.oio = false;
            param1.fill(0, 0, param1.getScaledWindowWidth(), param1.getScaledWindowHeight(), oII);
            for (GuiSupport_o0ii_1 v6 : this.RenderSupport_oio_2) {
                v6.PacketEvent(param1, param2, param3, param4);
            }
            this.PotionEffectsHudElement(param1, param2, param3);
            return;
        }
        finally {
            RenderSupport_oooo_2.end("CLAP_HUD_EDITOR");
        }
    }

    public boolean method_25421() {
        return false;
    }

    private void EnumType_ii0_2(DrawContext param1, String param2, int param3, int param4) {
        if (this.field_22787 == null || this.field_22787.textRenderer == null || param2 == null || param2.isEmpty()) {
            return;
        }
        List v5 = this.field_22787.textRenderer.wrapLines((StringVisitable)Text.literal((String)param2), 220);
        if (v5.isEmpty()) {
            return;
        }
        int v9 = 0;
        for (OrderedText v11 : v5) {
            v9 = Math.max(v9, this.field_22787.textRenderer.getWidth(v11));
        }
        Objects.requireNonNull(this.field_22787.textRenderer);
        int v11 = v9 + 6;
        int v12 = v5.size() * 9 + (v5.size() - 1) * 1 + 4;
        int v13 = param3 + 10;
        int v14 = param4 + 8;
        if (v13 + v11 > param1.getScaledWindowWidth() - 2) {
            v13 = param3 - v11 - 10;
        }
        if (v14 + v12 > param1.getScaledWindowHeight() - 2) {
            v14 = param4 - v12 - 6;
        }
        if (v13 < 2) {
            v13 = 2;
        }
        if (v14 < 2) {
            v14 = 2;
        }
        param1.fill(v13, v14, v13 + v11, v14 + v12, new Color(10, 10, 14, 160).getRGB());
        int v15 = v14 + 2;
        for (OrderedText v17 : v5) {
            param1.drawText(this.field_22787.textRenderer, v17, v13 + 3, v15, -921089, true);
            v15 += 10;
        }
    }

    public boolean method_25404(KeyInput param1) {
        int v2 = param1.key();
        if (v2 == 256 && this.field_22787 != null) {
            this.field_22787.setScreen((Screen)new ClickGuiScreenV2());
            return true;
        }
        for (GuiSupport_o0ii_1 v4 : this.RenderSupport_oio_2) {
            v4.EventBusApi(v2, param1.scancode(), param1.comp_4797());
        }
        return super.method_25404(param1);
    }

    public static HudEditorScreenV2 iI0() {
        if (oIi == null) {
            oIi = new HudEditorScreenV2();
        }
        return oIi;
    }

    public boolean method_25403(Click param1, double param2, double param4) {
        return super.method_25403(param1, param2, param4);
    }

    public boolean method_25400(CharInput param1) {
        return super.method_25400(param1);
    }

    private boolean iIo() {
        if (this.field_22787 == null) {
            return false;
        }
        return GLFW.glfwGetKey((long)this.field_22787.getWindow().getHandle(), (int)342) == 1;
    }

    public boolean method_25402(Click param1, boolean param2) {
        double v3 = param1.x();
        double v5 = param1.y();
        int v7 = param1.button();
        for (GuiSupport_o0ii_1 v9 : this.RenderSupport_oio_2) {
            v9.OOo(v3, v5, v7);
            if (!(v3 >= (double)v9.OoI()) || !(v3 <= (double)(v9.OoI() + v9.ConfigSupport_OI0())) || !(v5 >= (double)v9.Ooi()) || !(v5 <= (double)(v9.Ooi() + v9.Oi0()))) continue;
            return true;
        }
        return super.method_25402(param1, param2);
    }

    static {
        __k__gH4it = HudEditorScreenV2.__k__gH4it((long)-8136258644984467951L);
        __rP__gH4it0 = new String[]{"\u6978\u7cdc\ua3e0\uf6a2\u71b8\udd5f\uf6d5\ua173\u6874\u7dca\ua2f8\uf7d6\u70c6\udc45\uf7ff\ua230\u6b48\u7ee0\ua1ed\uf41a"};
        __rP__gH4it1 = new String[]{"\u69af\u7c59\ua3fc\uf668\u7130\udd55\uf667\ua14c", "\u697b\u7cdf\ua3fb\uf6ae\u71f1"};
        __rP__gH4it2 = new String[]{"\u696e\u7cd3\ua3fb\uf6db\u71c8\udd2c\uf6ac\ua16c\u6870\u7db9", "\u696c\u7cdd\ua3f5\uf6d9\u71ca\udd2a\uf6aa\ua16e\u6872\u7dc7"};
        __rP__gH4it3 = new String[]{"\u698e\u7c5b\ua3f7\uf6ef\u7121\udcbf\uf787\ua1c0\u688e\u7d5f\ua2d3\uf75f\u7064\udcc2\uf438\ua200\u6b4e\u7e0e\ua116\uf49a\u7320\udf02\uf591\ua3fe\u6abe\u7ffb\ua056\uf544\u72aa\ude1a\uf28a\ua4f2\u6d10\u78fd\ua748\uf257\u75c5\ud901\uf37f\ua5bb\u6c77\u79a4\ua61f\uf343\u74d2\ud847\uf312\ua61f\u6fa6\u7a5f\ua5a1\uf025\u77cc\udba4\uf0ce\ua7e8\u6eb8\u7b4e\ua4bb\uf154\u7634\uda83\uf164\ua836\u6130\u746e\uab3b\ufe9a\u799d\ud58b\ufe49\ua9a7", "\u696e\u7cca\ua3ea", "\u697e\u7cbe\ua3c3\uf653\u71f8\udd5f\uf691"};
        byte[] v0 = "\u00ea\u001a\u008c*\u0092j\u00d9\u00d4\u00e2\u0016\u0090\u00e2\u00ef\u00ef^l\u001a\u00bf]/\u00a3'\u00ff\u009a\u00e2B\u0005\u00e91'\u00fc\u008eT\\\u0013\u00f2V4\u0001\u00cf;\r\u00bc\u00de9J\u0094S\u0092\u00ce\n\u00b0/\u00a1@\u00ac\u0084\u00d7\b\u00d9\u00cf\u009e\u00f2j\u0014\u00ef\u0080\u001fn\u009e\u00d7\u00f3".getBytes("ISO_8859_1");
        Object[] v1 = "\u0089\u00daI\u00e3\u00c1B\u00ff\u001e".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1234157749;
                case 1 -> 375534578;
                case 2 -> -671939569;
                case 3 -> -1844980757;
                case 4 -> 1004109096;
                case 5 -> -2135189120;
                case 6 -> 1174058790;
                case 7 -> -1454073296;
                case 8 -> -539182408;
                case 9 -> -1264646218;
                case 10 -> 1742910404;
                case 11 -> -1237814595;
                case 12 -> -1513253188;
                case 13 -> 192436339;
                case 14 -> -136236923;
                case 15 -> 1704976239;
                case 16 -> -929416842;
                case 17 -> -447053238;
                case 18 -> -118510110;
                case 19 -> 1566658824;
                case 20 -> 1325104915;
                case 21 -> 860958953;
                case 22 -> 1507287903;
                case 23 -> 1660913605;
                case 24 -> -1118584467;
                case 25 -> 1557308820;
                case 26 -> -1362321689;
                case 27 -> 1575921841;
                case 28 -> 1973777018;
                case 29 -> 1077668690;
                case 30 -> -647104699;
                case 31 -> -1881602005;
                case 32 -> 484125133;
                case 33 -> -831749166;
                case 34 -> 619086544;
                case 35 -> -543292754;
                case 36 -> -668024482;
                case 37 -> -1858734583;
                case 38 -> -700424161;
                case 39 -> 1956015672;
                case 40 -> 1846913891;
                case 41 -> 1319573633;
                case 42 -> 1508330067;
                case 43 -> -196111992;
                case 44 -> -1745573374;
                case 45 -> -410920299;
                case 46 -> -718205810;
                case 47 -> 1722192721;
                case 48 -> -314737387;
                case 49 -> -1331304199;
                case 50 -> -541325428;
                case 51 -> 1346098255;
                case 52 -> 1505574659;
                case 53 -> 2099874513;
                case 54 -> -757982192;
                case 55 -> -891899571;
                case 56 -> -1609924694;
                case 57 -> -1401064519;
                case 58 -> 1728098800;
                case 59 -> -339242863;
                case 60 -> -630303147;
                case 61 -> 479165863;
                case 62 -> 402434436;
                case 63 -> 1524581293;
                case 64 -> -1600915149;
                case 65 -> 1454078188;
                case 66 -> -151817306;
                case 67 -> -1502603496;
                case 68 -> -1828809950;
                case 69 -> -1642556071;
                case 70 -> -1848074688;
                case 71 -> 1128148123;
                case 72 -> -1224907734;
                case 73 -> 1415906585;
                case 74 -> 1699843008;
                case 75 -> -1215702653;
                case 76 -> -1294830330;
                case 77 -> 137944776;
                case 78 -> -724097995;
                case 79 -> -1212662213;
                case 80 -> -1975497834;
                case 81 -> 1134845221;
                case 82 -> -339755086;
                case 83 -> -691318192;
                case 84 -> -1409842463;
                case 85 -> 225252795;
                case 86 -> -1604218098;
                case 87 -> 1310458745;
                case 88 -> -1465568756;
                case 89 -> 18917125;
                case 90 -> 178280502;
                case 91 -> -1948370046;
                case 92 -> -923830435;
                case 93 -> -890567169;
                case 94 -> -281083289;
                case 95 -> 136305959;
                case 96 -> 1757255471;
                case 97 -> -778472553;
                case 98 -> 1131984888;
                case 99 -> 24187427;
                case 100 -> -939684245;
                case 101 -> 2048045424;
                case 102 -> 1592941771;
                case 103 -> 1987409054;
                case 104 -> 737214295;
                case 105 -> -148894327;
                case 106 -> -1756859652;
                case 107 -> 226685593;
                case 108 -> 1143460838;
                case 109 -> 1038764923;
                case 110 -> -23918496;
                case 111 -> -932415600;
                case 112 -> -605090565;
                case 113 -> -431449321;
                case 114 -> 527697978;
                case 115 -> -572278801;
                case 116 -> -933329274;
                case 117 -> 1429145242;
                case 118 -> 1675764524;
                case 119 -> -323049734;
                case 120 -> -1801931980;
                case 121 -> 577574473;
                case 122 -> -1977278797;
                case 123 -> -584943850;
                case 124 -> -981757148;
                case 125 -> -1060853930;
                case 126 -> 1000229021;
                case 127 -> 559887730;
                case 128 -> 1278373861;
                case 129 -> -1016330101;
                case 130 -> -1119726883;
                case 131 -> -245086392;
                case 132 -> 1208751264;
                case 133 -> -577898251;
                case 134 -> 1750591425;
                case 135 -> 1902606718;
                case 136 -> -202271141;
                case 137 -> -896720972;
                case 138 -> 1700830169;
                case 139 -> 735925205;
                case 140 -> 924182132;
                case 141 -> -2013790552;
                case 142 -> 692597119;
                case 143 -> -1451564183;
                case 144 -> -80302286;
                case 145 -> -1217031903;
                case 146 -> -1068484287;
                case 147 -> 1558593400;
                case 148 -> 424365676;
                case 149 -> 516031652;
                case 150 -> -1326674456;
                case 151 -> 1010587337;
                case 152 -> 1476845962;
                case 153 -> 1096174958;
                case 154 -> -2061028228;
                case 155 -> -974657434;
                case 156 -> -631328956;
                case 157 -> 567048138;
                case 158 -> 157852375;
                case 159 -> 1773059369;
                case 160 -> 932606430;
                case 161 -> -1279393907;
                case 162 -> 1709928363;
                case 163 -> 1335320817;
                case 164 -> -832026526;
                case 165 -> 955813367;
                case 166 -> 586215450;
                case 167 -> -1113915360;
                case 168 -> 1106660398;
                case 169 -> 834199914;
                case 170 -> 1228819105;
                case 171 -> 1077692988;
                case 172 -> 1032852478;
                case 173 -> 644007428;
                case 174 -> 1858074848;
                case 175 -> -1571471174;
                case 176 -> -331963001;
                case 177 -> 220749634;
                case 178 -> 78368101;
                case 179 -> 1794867036;
                case 180 -> 376283496;
                case 181 -> -2038288643;
                case 182 -> 2002252696;
                case 183 -> 1450927347;
                case 184 -> -1399807929;
                case 185 -> 1937541493;
                case 186 -> 310340921;
                case 187 -> 912262684;
                case 188 -> 30412827;
                case 189 -> 1207336788;
                case 190 -> 2098404621;
                case 191 -> 226949976;
                case 192 -> 73994659;
                case 193 -> -331787301;
                case 194 -> 2017483727;
                case 195 -> -1516480343;
                case 196 -> -153087231;
                case 197 -> 1947142164;
                case 198 -> 1011125623;
                case 199 -> 1682728493;
                case 200 -> 1010714039;
                case 201 -> -1997427645;
                case 202 -> -717790130;
                case 203 -> -985794530;
                case 204 -> -1697774467;
                case 205 -> 945055293;
                case 206 -> -1469342738;
                case 207 -> -1681826369;
                case 208 -> 1574102262;
                case 209 -> 832724487;
                case 210 -> 1520460734;
                case 211 -> 2035112759;
                case 212 -> 729680095;
                case 213 -> 547296211;
                case 214 -> -1774461634;
                case 215 -> 1034204772;
                case 216 -> 1898436113;
                case 217 -> 731299778;
                case 218 -> 1097417372;
                case 219 -> -1340859558;
                case 220 -> 1894007711;
                case 221 -> 411352501;
                case 222 -> 75213361;
                case 223 -> -404649974;
                case 224 -> 1092044266;
                case 225 -> -733923697;
                case 226 -> 731940291;
                case 227 -> 1778614232;
                case 228 -> 889397823;
                case 229 -> 438727084;
                case 230 -> -235194462;
                case 231 -> -54027758;
                case 232 -> -190665996;
                case 233 -> -1934520656;
                case 234 -> -1040878630;
                case 235 -> -596290484;
                case 236 -> 247310052;
                case 237 -> 1739167438;
                case 238 -> 1965440512;
                case 239 -> -546103643;
                case 240 -> -1706695212;
                case 241 -> -40691987;
                case 242 -> -940851310;
                case 243 -> 843124678;
                case 244 -> -537931509;
                case 245 -> -874137396;
                case 246 -> 401749617;
                case 247 -> 889045789;
                case 248 -> 1524723158;
                case 249 -> 786208097;
                case 250 -> -744173853;
                case 251 -> 308234183;
                case 252 -> 1132402835;
                case 253 -> -1508826298;
                case 254 -> 1361780143;
                case 255 -> 1548948444;
                default -> 1779272647;
            });
        } while (v2 != 72);
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            oiI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        oII = new Color(0, 0, 0, 38).getRGB();
    }

    public boolean method_25406(Click param1) {
        double v2 = param1.x();
        double v4 = param1.y();
        int v6 = param1.button();
        for (GuiSupport_o0ii_1 v8 : this.RenderSupport_oio_2) {
            v8.GuiSupport_OOI(v2, v4, v6);
        }
        return super.method_25406(param1);
    }

    public boolean iiO(double param1, double param3) {
        for (GuiSupport_o0ii_1 v6 : this.RenderSupport_oio_2) {
            if (!(param1 >= (double)v6.OoI()) || !(param1 <= (double)(v6.OoI() + v6.ConfigSupport_OI0())) || !(param3 >= (double)v6.Ooi()) || !(param3 <= (double)(v6.Ooi() + v6.Oi0()))) continue;
            return true;
        }
        return false;
    }

    public void method_25420(DrawContext param1, int param2, int param3, float param4) {
    }

    private HudEditorScreenV2() {
        super((Text)Text.literal((String)"clap-hudeditor2"));
        GuiSupport_o0ii_1 v1 = new GuiSupport_o0ii_1(ModuleCategory.ioi, 100.0f, 50.0f, 110.0f, 16.0f);
        v1.Oio(true);
        this.RenderSupport_oio_2.add(v1);
    }

    private boolean iIi(HudElement param1, double param2, double param4) {
        return param2 >= (double)param1.GuiSupport_OOI() && param2 <= (double)(param1.GuiSupport_OOI() + param1.KeystrokesHudElement()) && param4 >= (double)param1.OOi() && param4 <= (double)(param1.OOi() + param1.ConfigSupport_OI0());
    }

    private void PotionEffectsHudElement(DrawContext param1, int param2, int param3) {
        Object v6;
        if (!this.iIo()) {
            return;
        }
        for (Object v5 : this.RenderSupport_oio_2) {
            v6 = ((GuiSupport_o0ii_1)v5).HelpCommand(param2, param3);
            if (v6 == null || ((String)v6).isEmpty()) continue;
            this.EnumType_ii0_2(param1, (String)v6, param2, param3);
            return;
        }
        for (Object v5 : 0ooo.OIo0().oo0o()) {
            String v7;
            if (!(v5 instanceof HudElement)) continue;
            v6 = (HudElement)v5;
            if (!((Module)v5).IoOo() || !this.iIi((HudElement)v6, param2, param3) || (v7 = ((Module)v6).Oii0()) == null || v7.isEmpty()) continue;
            this.EnumType_ii0_2(param1, v7, param2, param3);
            return;
        }
    }
}

