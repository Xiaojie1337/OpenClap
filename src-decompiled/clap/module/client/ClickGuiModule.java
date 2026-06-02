/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.Screen
 */
package clap.module.client;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.screen.Screen;
import clap.core.module.Module;
import clap.config.ConfigSupport_00o_0;
import clap.gui.screen.ClickGuiScreenV2;
import clap.model.EnumType_0oio_2;
import clap.setting.Setting;
import clap.gui.screen.ClickGuiScreen;
import clap.core.module.ModuleCategory;
import clap.model.EnumType_oioi_4;
import clap.event.EventHandler;
import clap.command.Command;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.config.ConfigSupport_OIIo
 */
public class ClickGuiModule
extends Module {
    public Setting I0ii;
    public Setting 0oi;
    public Setting IoO0;
    public Setting 0iIo;
    public Setting IoOO;
    public Setting I0iI = this.OOi0I("Prefix", ".");
    private static ClickGuiModule I0io;
    public Setting 0iIi;
    public Setting BindCommand = this.OOi0i("Mode", EnumType_oioi_4.iIi);
    static Object IoOo;
    private static volatile /* synthetic */ long __k__gH4it;

    @EventHandler
    public void OOiOi(ConfigSupport_00o_0 param1) {
        if (param1.HudElement() == EnumType_0oio_2.AntiBotModule && param1.O0o().Oo0().equals(this)) {
            if (param1.O0o().equals(this.I0iI)) {
                0ooo.ConfigPanel().IiIo((String)this.I0iI.OOi());
                Command.Oiii("Prefix set to {global} %s", "general", 0ooo.0OIo().IiII());
            }
            if (param1.O0o().equals(this.I0ii)) {
                0ooo.CoordinatesHudElement().OOo((Color)this.I0ii.OOi());
            }
        }
    }

    @Override
    public void oooi() {
        0ooo.0OIi().OOo((Color)this.I0ii.HelpCommand());
        0ooo.0OiO().IiIo((String)this.I0iI.HelpCommand());
    }

    public static ClickGuiModule OOi0O() {
        return I0io;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        if (ClickGuiModule.iooI()) {
            return;
        }
        if (this.BindCommand.HelpCommand() == EnumType_oioi_4.iiO) {
            ConfigSupport_OI0.setScreen((Screen)new ClickGuiScreenV2());
        } else {
            ConfigSupport_OI0.setScreen((Screen)ClickGuiScreen.PacketEvent());
        }
    }

    @Override
    public void SpawnerFinderModule() {
        if (!(ClickGuiModule.ConfigSupport_OI0.currentScreen instanceof ClickGuiScreen) && !(ClickGuiModule.ConfigSupport_OI0.currentScreen instanceof ClickGuiScreenV2)) {
            this.I0ii();
        }
    }

    public ClickGuiModule() {
        super("ClickGui", "Opens the ClickGui", ModuleCategory.NoHurtCamModule);
        this.I0ii = this.OOioo("Color", 0, 0, 255, 180);
        this.IoOO = this.OOioo("TopColor", 208, 120, 203, 155);
        this.IoO0 = this.OOioo("EnabledTextColor", 197, 112, 208, 255);
        this.0iIo = this.OOi00("Blur", true);
        this.0iIi = this.OOi0o("BlurRadius", 12, 1, 20);
        this.0oi = this.OOioo("BackgroundColor", 126, 164, 215, 92);
        this.Io0i(344);
        I0io = this;
    }

    static {
        __k__gH4it = ClickGuiModule.__k__gH4it(-1092542215466521071L);
        __rP__gH4it0 = new String[]{"\u5171\ubbab\u6478", "\u5164\ubbbe\u6461\u3e34\ub957"};
        __rP__gH4it1 = new String[]{"\u51a7\ubb3b\u640b\u31b1\ub62c\ue11c\u5c6c\u6889\u5e52\ub4e2\u6b5f\u3e8c\ub95f\ue009\u5d36\u69de\u5f65\ub5df\u6a85\u3f1b\ub813\ue396\u5edb\u6a59\u5c69\ub6b2\u69ef\u3c21\ubb66\ue294\u5ffb\u6b18\u5dea\ub725\u68c9\u3d6b\uba99\ue2dd\u5858\u6cad\u5a3e\ub03a\u6fe3\u3a0a\ubdd5\ue574\u599d\u6dee\u5b84\ub1ab\u6e1d\u3bcf\ubc77\ue4d8\u5a69\u6e60\u5893\ub261\u6da1\u3860\ubff4\ue777\u5bca\u6ff6\u5925\ub34b\u6cae\u3917\ube65\ue604\u5b47\u7010\u4675\uacfd\u738f\u26c9\ua136\uf916\u44d9\u7129\u47b1\uad1a\u7222\u2745\ua042\uf83e\u45b6\u727b\u44c8\uae33\u7196\u24c8\ua3ad\ufb79\u46ff\u73ab\u45d2\uaf2b\u7048\u2571\ua2d8\ufa6c\u47cb\u7339\u4200\ua88a\u777a\u2258\ua515\ufd5b\u4014\u74b1\u4320\ua9c8\u7623\u23c6\ua472\ufcd6\u41e4\u7566\u40d0\uaa96\u7524\u2056\ua796\uff15\u425f\u760b\u40fc\uabf2\u74b8\u2110\ua6ac\ufe85\u43ad\u776a\u4133\ua47d\u7b76\u2e76\ua991\uf189\u4ca4\u7877\u4e91\ua5e6\u7a1b\u2fc3\ua834\uf0a2\u4dee\u7916\u4ff1\ua604\u7942\u2c7d\uab07\uf300\u4ed3\u7a22\u4cd7\ua6c0\u785d\u2d76\uaa9c\uf246\u4f9b\u7b1b\u4db0\ua7f4\u7f72\u2adf\uad68\uf574\u4888\u7c68\u4ab4\ua0be\u7ef8\u2b01\uac0e\uf450\u4937\u7d22\u4bfa\ua1d1\u7d4b\u28f5\uaf23\uf7a6\u4a06\u7e55", "\u5161\ubba3\u6461\u3e35\ub95e\ue1bd\u5cc7"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\u5171\ubbb6\u6461\u3e4d\ub95e\ue1a6\u5cd2\u6880\u5e7f\ub4cc", "\u5123\ubbd4\u6465\u3e48\ub976\ue1bd\u5c0a\u68c0", "\u5173\ubbb0\u6467\u3e4f\ub95c\ue1b8\u5ccc\u6882\u5e7d\ub4ca", "\u5167\ubbbd\u6462\u3e20\ub93e\ue1d9\u5ca3\u6893\u5e7b\ub4bb\u6b7a\u3f54\ub840\ue0c3\u5d89\u69d0\u5f77\ub5e1\u6a6f\u3f98"};
        byte[] v0 = "T\u0093jn\u0081\u00d7\u00dc\u00e5\u00a9B6[\u00fa\u00ca\u008e\u00ba\u0086g\u00f4\u00d4\u00aeM{%\u0082\u0002\u0096\u00e6\u00d3GSl9m\u0088\u00d4\u0014\u00f6\u00c8\u00a1\u00e5z\u00aa\u00bdPW\u0005\u00eaG\u00f3L`\u00ea\u00e3\u00e9|X1\u00f8\u00c7aDB\u00e2\u0096#\u000f\u0088\u0088\u000f7<\u00ce\u009d&^\u00d3\u0015\u00a1\r\u0012b\u0093\u00ca\u00bf%\u00d6GcC/OXj\u0097\u009fA#\u00c9\u000e\u0015\u0007\u009b\u00f5\u009b\u008a\u00f3/\u00d08Lu\u00a3\u00d0\u00b2\u00a9\u00af\u00ad\u00a4\u00ba[\u0086\u00bd1Cf\u0017\u00df\u008f\u00daYO\u0081\u00ce\u009d\u0086H]\u009f!\u00b4\u00ca\u009c\u0093\u00f2\u00de\u00ea\u008c\t\u00f9\u00ce\u00ea\u009a4\u00bb:2S\u00fb\u00d6\u0084\b\u009cI\u0091\u00ed\u008b\u0097\u00eb4\u00bb\u00e8m\u00d7\u0090\u00ec\u00f7f).\u0013\u00eb7\u00be\u00b1\u0001\u0092\u00d26\u0015\u000e\u00c1".getBytes("ISO_8859_1");
        Object[] v1 = "\u001a6JY\u0011<\u00ecz".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 983108067;
                case 1 -> -1456502260;
                case 2 -> -847273211;
                case 3 -> -260760486;
                case 4 -> 1817781379;
                case 5 -> 667824216;
                case 6 -> -469455091;
                case 7 -> -236598635;
                case 8 -> -1061271003;
                case 9 -> 1692714304;
                case 10 -> 531532725;
                case 11 -> 1676051470;
                case 12 -> 1520095520;
                case 13 -> -157047363;
                case 14 -> -242393731;
                case 15 -> 1456104171;
                case 16 -> 1582906886;
                case 17 -> 1134740499;
                case 18 -> -1594164794;
                case 19 -> -191539071;
                case 20 -> -1272139343;
                case 21 -> -1231331277;
                case 22 -> -1890165281;
                case 23 -> -193639195;
                case 24 -> 946999716;
                case 25 -> -43410286;
                case 26 -> -1393736675;
                case 27 -> -1237421164;
                case 28 -> -1129501042;
                case 29 -> 1243222297;
                case 30 -> 767209570;
                case 31 -> 1674707445;
                case 32 -> -528652444;
                case 33 -> -1601016783;
                case 34 -> -1783920385;
                case 35 -> -2060219279;
                case 36 -> -442920929;
                case 37 -> -123492769;
                case 38 -> -1685537656;
                case 39 -> -1954368696;
                case 40 -> 1553672047;
                case 41 -> 0x6477767;
                case 42 -> 699958607;
                case 43 -> 1817431213;
                case 44 -> 1314721185;
                case 45 -> 1739720108;
                case 46 -> -755060761;
                case 47 -> 54251990;
                case 48 -> 1194481220;
                case 49 -> -1778646849;
                case 50 -> 1904086741;
                case 51 -> 1880142944;
                case 52 -> 444460179;
                case 53 -> -2135386374;
                case 54 -> -977568346;
                case 55 -> 2124469543;
                case 56 -> 243009479;
                case 57 -> 705561231;
                case 58 -> -595259315;
                case 59 -> -1783016444;
                case 60 -> 1570423346;
                case 61 -> -820077014;
                case 62 -> -1146723510;
                case 63 -> 276586355;
                case 64 -> 483349627;
                case 65 -> 1123790904;
                case 66 -> 1887247147;
                case 67 -> -343551960;
                case 68 -> -517362799;
                case 69 -> -1338349198;
                case 70 -> -1760622876;
                case 71 -> -1737644354;
                case 72 -> 985689346;
                case 73 -> 970376704;
                case 74 -> -294287815;
                case 75 -> -1424147887;
                case 76 -> -735336226;
                case 77 -> 647448142;
                case 78 -> -1769466454;
                case 79 -> 375731844;
                case 80 -> -865815656;
                case 81 -> -840978189;
                case 82 -> 1290411842;
                case 83 -> 1301263396;
                case 84 -> -1991901575;
                case 85 -> 1091588496;
                case 86 -> -79788574;
                case 87 -> -259325756;
                case 88 -> -1555176324;
                case 89 -> 1014134552;
                case 90 -> 1468362480;
                case 91 -> -1929450515;
                case 92 -> -1007440633;
                case 93 -> -846591264;
                case 94 -> 1355766222;
                case 95 -> 1902621975;
                case 96 -> -15836415;
                case 97 -> 229607477;
                case 98 -> -1078296538;
                case 99 -> -579937473;
                case 100 -> -1178536767;
                case 101 -> 2119485025;
                case 102 -> -237110371;
                case 103 -> -445941762;
                case 104 -> -27764379;
                case 105 -> -477477986;
                case 106 -> 1805143109;
                case 107 -> -612833800;
                case 108 -> -658315867;
                case 109 -> -1065229107;
                case 110 -> -890428314;
                case 111 -> -936650469;
                case 112 -> 856318061;
                case 113 -> -467181053;
                case 114 -> 1517855349;
                case 115 -> -1931790977;
                case 116 -> -1732442092;
                case 117 -> 1085659559;
                case 118 -> 1262244905;
                case 119 -> 1660103011;
                case 120 -> 1136306076;
                case 121 -> -877320658;
                case 122 -> 158117364;
                case 123 -> 337542417;
                case 124 -> 413602921;
                case 125 -> -2092888765;
                case 126 -> -374613678;
                case 127 -> 393941870;
                case 128 -> -2053927762;
                case 129 -> 1294425405;
                case 130 -> -611778381;
                case 131 -> -1513359486;
                case 132 -> 243576902;
                case 133 -> 59343187;
                case 134 -> -1578537655;
                case 135 -> 1391234538;
                case 136 -> 1100163875;
                case 137 -> 746665192;
                case 138 -> -1401734530;
                case 139 -> 586005264;
                case 140 -> -1681831690;
                case 141 -> 101666363;
                case 142 -> 1416059378;
                case 143 -> -830532145;
                case 144 -> -394268073;
                case 145 -> 1754716669;
                case 146 -> 1574122373;
                case 147 -> -1177327000;
                case 148 -> -327028561;
                case 149 -> -1483346889;
                case 150 -> 31469145;
                case 151 -> 1414611596;
                case 152 -> -786148789;
                case 153 -> -579801348;
                case 154 -> -494287931;
                case 155 -> 1398087964;
                case 156 -> 614424090;
                case 157 -> -1153675413;
                case 158 -> 1902711120;
                case 159 -> -1202413254;
                case 160 -> 1017346932;
                case 161 -> 62638863;
                case 162 -> 80677168;
                case 163 -> 1611579318;
                case 164 -> 20572106;
                case 165 -> -1198665772;
                case 166 -> -296447679;
                case 167 -> 375841464;
                case 168 -> 1157179785;
                case 169 -> -722693877;
                case 170 -> -426093380;
                case 171 -> -833782201;
                case 172 -> -1038509434;
                case 173 -> 1372972968;
                case 174 -> 1902645459;
                case 175 -> -1343071328;
                case 176 -> 167148650;
                case 177 -> 1728449499;
                case 178 -> 99979383;
                case 179 -> -1901471402;
                case 180 -> 1649172945;
                case 181 -> 1245755828;
                case 182 -> -1222264228;
                case 183 -> -189804359;
                case 184 -> -380769195;
                case 185 -> -2044238982;
                case 186 -> 1629374169;
                case 187 -> 310886747;
                case 188 -> -474729169;
                case 189 -> -896373365;
                case 190 -> 2066551062;
                case 191 -> 1533253529;
                case 192 -> -830455670;
                case 193 -> 1833870231;
                case 194 -> 815147970;
                case 195 -> -1661524874;
                case 196 -> 1970759020;
                case 197 -> -1031840565;
                case 198 -> 1324613950;
                case 199 -> -1330641175;
                case 200 -> -1346593870;
                case 201 -> -1023866900;
                case 202 -> -1887090723;
                case 203 -> 330220589;
                case 204 -> -1987777838;
                case 205 -> -605091699;
                case 206 -> 1213894126;
                case 207 -> 1800875308;
                case 208 -> 486906377;
                case 209 -> 696984074;
                case 210 -> 1427086796;
                case 211 -> 991649174;
                case 212 -> -2120300153;
                case 213 -> 615769728;
                case 214 -> 316343459;
                case 215 -> 1720052379;
                case 216 -> 1596817840;
                case 217 -> 111856841;
                case 218 -> 1400927130;
                case 219 -> -306373099;
                case 220 -> 2023524779;
                case 221 -> -629015578;
                case 222 -> -1000813278;
                case 223 -> 469910687;
                case 224 -> 75200220;
                case 225 -> -1611339408;
                case 226 -> 745348148;
                case 227 -> -330470743;
                case 228 -> -791168009;
                case 229 -> -1272035359;
                case 230 -> 886028962;
                case 231 -> 425139038;
                case 232 -> -519320200;
                case 233 -> 1320745249;
                case 234 -> -349086148;
                case 235 -> 1499919624;
                case 236 -> -1661695792;
                case 237 -> -1702822671;
                case 238 -> 2120611404;
                case 239 -> -195615302;
                case 240 -> 2034067486;
                case 241 -> 1470397679;
                case 242 -> -1587060518;
                case 243 -> -794155783;
                case 244 -> -1401398597;
                case 245 -> 35949271;
                case 246 -> -1180533577;
                case 247 -> 1955676360;
                case 248 -> -2067915246;
                case 249 -> -427285544;
                case 250 -> 1396517568;
                case 251 -> 1318570806;
                case 252 -> 31493883;
                case 253 -> -8684195;
                case 254 -> -3531069;
                case 255 -> 9439828;
                default -> -1190642371;
            });
        } while (v2 != 192);
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
            Object[] objectArray = new Object[13];
            v1 = objectArray;
            IoOo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
    }
}

