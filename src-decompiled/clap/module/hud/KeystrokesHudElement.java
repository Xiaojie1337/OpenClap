/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.KeyBinding
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.option.KeyBinding;
import clap.network.NetworkSupport_00OI;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.model.DataRecord_0io_0;
import clap.gui.GuiSupport_0oo_2;
import clap.setting.Setting;
import clap.render.ScaledDrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class KeystrokesHudElement
extends HudElement {
    public Setting 0o0;
    public Setting RenderSupport_0I0;
    public Setting AutoMlgModule;
    public Setting 0oi;
    public Setting SpawnerFinderModule;
    public Setting ConfigSupport_0II;
    public Setting 0oI;
    public Setting 0oO = this.OOi0o("KeySize", 22, 16, 36);
    private static final float 00i;
    public Setting 0Io;
    static Object ChestStealerModule;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        FontRenderer v2 = NetworkSupport_00OI.GuiSupport_OOI(20);
        DataRecord_0io_0 v3 = this.ooi();
        float v4 = this.GuiSupport_OOI();
        float v5 = this.OOi();
        PostProcessingModule.IoiO(v4, v5, v3.RenderSupport_ooi_1(), v3.oOi(), this.ConfigSupport_OII((float)((Integer)this.0oI.HelpCommand()).intValue() + 2.0f), ((Color)this.0oi.HelpCommand()).getRGB());
        float v6 = v5 + v3.o0O();
        float v7 = v6 + v3.NetworkSupport_o0o_0() + v3.o00();
        float v8 = v4 + v3.o0O();
        float v9 = v8 + v3.NetworkSupport_o0o_0() + v3.o00();
        float v10 = v9 + v3.NetworkSupport_o0o_0() + v3.o00();
        this.ooo(param1, v2, "W", v9, v6, v3.NetworkSupport_o0o_0(), KeystrokesHudElement.ConfigSupport_OI0.options.forwardKey);
        this.ooo(param1, v2, "A", v8, v7, v3.NetworkSupport_o0o_0(), KeystrokesHudElement.ConfigSupport_OI0.options.leftKey);
        this.ooo(param1, v2, "S", v9, v7, v3.NetworkSupport_o0o_0(), KeystrokesHudElement.ConfigSupport_OI0.options.backKey);
        this.ooo(param1, v2, "D", v10, v7, v3.NetworkSupport_o0o_0(), KeystrokesHudElement.ConfigSupport_OI0.options.rightKey);
        this.Oii(v4, v5, v3.RenderSupport_ooi_1(), v3.oOi());
    }

    public KeystrokesHudElement() {
        super("Keystrokes", "Display movement keys", 76.0f, 52.0f);
        this.0o0 = this.OOi0o("Gap", 3, 0, 10);
        this.SpawnerFinderModule = this.OOi0o("Padding", 5, 0, 14);
        this.0oI = this.OOi0o("Radius", 5, 0, 12);
        this.0oi = this.OOioo("BackgroundColor", 18, 18, 24, 128);
        this.AutoMlgModule = this.OOioo("KeyColor", 255, 255, 255, 24);
        this.RenderSupport_0I0 = this.OOioo("PressedColor", 255, 145, 92, 210);
        this.0Io = this.OOioo("TextColor", 235, 241, 248, 255);
        this.ConfigSupport_0II = this.OOioo("PressedTextColor", 18, 18, 24, 255);
    }

    static {
        __k__gH4it = KeystrokesHudElement.__k__gH4it(3966894920957947409L);
        __rP__gH4it0 = new String[]{"\u1702\u7398\uad45\uf89a\u7f4a\ubd16\ue4e1\uae13", "\u1757\u73bb\uade8"};
        __rP__gH4it1 = new String[]{"\u1757\u73ae\uadf1\uf8de\u7fcf\ubd29\ue4f9\uae8d\u1679\u72b4"};
        __rP__gH4it2 = new String[]{"\u1755\u73ac\uadf7\uf8d8\u7fcd\ubd2b\ue4c7\uaf73\u167b\u72b6", "\u1741\u73a1\uadf2\uf8b7\u7faf\ubd4a\ue4a8\uaf72\u165d\u72a7\uacea\uf9c3\u7ed1\ubc50\ue582\ub021\u0971\u6d9d\ub3df\ue6ef", "\u1742\u73a6\uadf1\uf8a7\u7fc6"};
        __rP__gH4it3 = new String[]{"\u178d\u7314\uadea\uf8e2\u7e33\ubc36\ue58c\uaf21\u16c3\u720a\uac6e\uf93d\u61a0\ua3f2\ufa32\ub015\u09fb\u6df5\ub324\ue620\u6024\ua234\ufb27\ub1af\u08d0\u6c0b\ub2f2\ue7c7\u60fb\ua1c1\uf840\ub2d3\u0b62\u6f35\ub1c7\ue479\u63d4\ua088\uf941\ub386\u0a7e\u6eed\ub0db\ue547\u62da\ua7da\ufe51\ub405\u0d95\u699f\ub7ec\ue2cb\u6510\ua623\uff63\ub51d\u0c1f\u68cd\ub6f5\ue343\u6413\ua604\ufc73\ub6d5\u0f35\u6bce\ub508\ue0ee\u67de\ua55d\ufdb1\ub785\u0e56\u6aad\ub479\ue180\u662b\ua489\uf251\ub839\u0199\u6517\ubb3a\uee74\u697c\uabd6\uf36f\ub90d\u0091\u6485\uba73\uefd8\u68e2\uaac1\uf36c\uba05\u03f6\u67de\ub923\uec5a\u6bc3\ua9a8\uf0f0\ubb2a\u02dd\u66e4\ub89e\ueda8\u6a67\ua83d\uf1f8\ubc55\u05cb\u61ca\ubff4\uea61\u6d94\uafda\uf601\ubcbe\u04b9\u6046\ubea0\uebc9\u6c04\uaea7\uf706\ubde7\u07ce\u630b\ubd38\ue827\u6f34\uad55\uf4f6\ube8a\u0612\u620d\ubc2b\ue95b\u6e9b\uac8c\uf588\ubf19\u79d3\u1d9f\uc3f1\u9647\u1156\ud3f9\u8a6f\uc061\u79ef\u1cd2\uc2a5\u97f2\u10c6\ud242\u8b47\uc174\u78ff\u1fe8\uc125\u94ed\u13d9\ud1d4\u8891\uc22b\u7bd0\u1e52\uc0ef\u9595\u1237\ud099\u89ef\uc302\u7aa5\u1985\uc7c7\u925c\u1512\ud792\u8e1b\uc478", "\u1747\u73bf\uadf1\uf8a2\u7fcf\ubd2e\ue4cc"};
        byte[] v0 = " \u0018\u00e3\u0012w\u00d6\u00cf\u0004v\u001e\u007f\u00d5\u00fc\ni8F\u00e9=\u00c0p\u00c4t\u00ba\u0095/\u0093\u001fW\tk\u00ce/\u0019\u00ae\u00a9pHb\u0083+\u00d9\u00aa\u008ff\u0002j\b\u00c8\u00a3\u0095\u000b\u00a4\u00f3Phz\t\u00b4\u00fb\u009f,x\u00a8X\u0002A^Z}\u00b2\u00e0#y((\u00b7\u00b1JT\u00e4\u00cbc\u00d4\u00e8\u00e6|X\u0094a\u00d2@\u000e\u00c9\u0087X\u00fb2\u008a\u00ca'\u00a8\u0013o\u00c8\u0010/ \u009b%\u0003\u0018\u00d66M\u00e1`\u00ca\u00f2\u000b\u009c\u00c2!\u00b1\u00c8\u00cf\u00cdZ\u00e3\u0087\u00b1W\u00f055/'\u0099\u00ba3G\u00f4S\u00b4\u00ee\u0003h'\u0082\u0089\u00bc\u00f4*vD\u00aa\u00ea\n\u00ec\u00e92D\u00cc\u00bd\u00fd\u00942\u00ae\u0005\u00e6\u001e\u00dd\u000b\u00c1T\u008fx9>\u001c&\u00c2\u00a8\u008d".getBytes("ISO_8859_1");
        Object[] v1 = "\u001db\u00fa\u0018\u00bcx,\u00a4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -796486850;
                case 1 -> 364000806;
                case 2 -> -1026371330;
                case 3 -> 520387765;
                case 4 -> 1354064643;
                case 5 -> 1747245249;
                case 6 -> -1831954727;
                case 7 -> -2036983733;
                case 8 -> -1614719308;
                case 9 -> -1391954658;
                case 10 -> -164403872;
                case 11 -> 1852709747;
                case 12 -> -1327547173;
                case 13 -> 1327579714;
                case 14 -> 606250738;
                case 15 -> 1208697322;
                case 16 -> -2140286894;
                case 17 -> 48248557;
                case 18 -> -1635498383;
                case 19 -> 4799219;
                case 20 -> 1168532166;
                case 21 -> -715976039;
                case 22 -> 1505616556;
                case 23 -> -1444598189;
                case 24 -> -1880424449;
                case 25 -> 1326486026;
                case 26 -> 649932849;
                case 27 -> 1269693373;
                case 28 -> 277373570;
                case 29 -> -975536120;
                case 30 -> 1451626118;
                case 31 -> -1975938876;
                case 32 -> -665629438;
                case 33 -> 1124576786;
                case 34 -> -326630810;
                case 35 -> 1051395180;
                case 36 -> 653135417;
                case 37 -> 627318542;
                case 38 -> 419825152;
                case 39 -> 648765429;
                case 40 -> 956061137;
                case 41 -> 1800788573;
                case 42 -> 169271995;
                case 43 -> 1601250977;
                case 44 -> -933715431;
                case 45 -> -1309066098;
                case 46 -> -948728678;
                case 47 -> 1557205347;
                case 48 -> -1094718920;
                case 49 -> -942687765;
                case 50 -> -693359014;
                case 51 -> 940876332;
                case 52 -> 1436367837;
                case 53 -> -775398706;
                case 54 -> -642522632;
                case 55 -> 519659998;
                case 56 -> -35095520;
                case 57 -> -1877376018;
                case 58 -> 1950235434;
                case 59 -> 335936519;
                case 60 -> -1096246000;
                case 61 -> 836219597;
                case 62 -> 879308629;
                case 63 -> 881895378;
                case 64 -> -1596276215;
                case 65 -> 1118654259;
                case 66 -> 1675685847;
                case 67 -> 413423162;
                case 68 -> 1904560773;
                case 69 -> -1043085660;
                case 70 -> -548223886;
                case 71 -> 1135133943;
                case 72 -> -405357879;
                case 73 -> 212758068;
                case 74 -> -438363308;
                case 75 -> -863280298;
                case 76 -> -1298273849;
                case 77 -> 1852574327;
                case 78 -> 1082793703;
                case 79 -> -1889167414;
                case 80 -> 1198127518;
                case 81 -> 1360780223;
                case 82 -> -575818506;
                case 83 -> 863955292;
                case 84 -> -1955202487;
                case 85 -> -135293281;
                case 86 -> -1385774939;
                case 87 -> -850392819;
                case 88 -> -1402124856;
                case 89 -> -1774996456;
                case 90 -> 0xD22D5D5;
                case 91 -> -1089089102;
                case 92 -> 710074437;
                case 93 -> -2028213696;
                case 94 -> -1324161851;
                case 95 -> -237919999;
                case 96 -> 765954594;
                case 97 -> 1746520107;
                case 98 -> -1113945094;
                case 99 -> 1988543244;
                case 100 -> -1567673000;
                case 101 -> 776979536;
                case 102 -> -1608846837;
                case 103 -> -631590876;
                case 104 -> 477107104;
                case 105 -> -804047825;
                case 106 -> 1492353089;
                case 107 -> -499622055;
                case 108 -> 2056418268;
                case 109 -> 1502872398;
                case 110 -> -276707124;
                case 111 -> 1240794930;
                case 112 -> 1995054180;
                case 113 -> -672591845;
                case 114 -> 126707994;
                case 115 -> 2046227237;
                case 116 -> 1504110175;
                case 117 -> 1277992139;
                case 118 -> 1294194747;
                case 119 -> -1018870738;
                case 120 -> -1212961325;
                case 121 -> 826550303;
                case 122 -> 598951921;
                case 123 -> -1896753369;
                case 124 -> 1965553602;
                case 125 -> 782475753;
                case 126 -> -1502407604;
                case 127 -> 1765581940;
                case 128 -> -534655313;
                case 129 -> -2129408330;
                case 130 -> 907772067;
                case 131 -> -320715864;
                case 132 -> 297975936;
                case 133 -> -595570360;
                case 134 -> 567648616;
                case 135 -> 905802350;
                case 136 -> 1667497487;
                case 137 -> -11423363;
                case 138 -> 979876032;
                case 139 -> -1208104775;
                case 140 -> -1966934487;
                case 141 -> -1793310902;
                case 142 -> -1909363738;
                case 143 -> -2051802723;
                case 144 -> 1244203362;
                case 145 -> 330616456;
                case 146 -> 500076163;
                case 147 -> 1603684423;
                case 148 -> -693757261;
                case 149 -> -280459143;
                case 150 -> -210864027;
                case 151 -> 694555376;
                case 152 -> 2141135055;
                case 153 -> 1478846519;
                case 154 -> -984017859;
                case 155 -> -678850532;
                case 156 -> 1835991770;
                case 157 -> -206236696;
                case 158 -> -1107683176;
                case 159 -> -201639354;
                case 160 -> -1175892393;
                case 161 -> -234612079;
                case 162 -> 1818110866;
                case 163 -> -1394446283;
                case 164 -> -898387603;
                case 165 -> 239856635;
                case 166 -> 1989466659;
                case 167 -> -100713343;
                case 168 -> -647745424;
                case 169 -> -2087325797;
                case 170 -> -685400531;
                case 171 -> -196251184;
                case 172 -> -2137031062;
                case 173 -> -1695375562;
                case 174 -> 385178765;
                case 175 -> -1964939281;
                case 176 -> -346814359;
                case 177 -> 254251174;
                case 178 -> -1461904489;
                case 179 -> -2092755972;
                case 180 -> -43809360;
                case 181 -> 778287486;
                case 182 -> -754326813;
                case 183 -> 1085429748;
                case 184 -> 903224203;
                case 185 -> 96042819;
                case 186 -> 659091332;
                case 187 -> 1594466222;
                case 188 -> -1546685001;
                case 189 -> 1611809115;
                case 190 -> -1646084017;
                case 191 -> 1638027391;
                case 192 -> -735093279;
                case 193 -> 1665624468;
                case 194 -> -639984363;
                case 195 -> -823097709;
                case 196 -> -561208902;
                case 197 -> -968272680;
                case 198 -> -930113212;
                case 199 -> 885139168;
                case 200 -> 1943171300;
                case 201 -> 721189743;
                case 202 -> -1122549756;
                case 203 -> 157766184;
                case 204 -> 615868604;
                case 205 -> 167363589;
                case 206 -> -663133028;
                case 207 -> -641158775;
                case 208 -> -1279854472;
                case 209 -> -840510445;
                case 210 -> 913816556;
                case 211 -> 97658617;
                case 212 -> -1295848234;
                case 213 -> 1944572589;
                case 214 -> 436423231;
                case 215 -> -1445012565;
                case 216 -> -2133053291;
                case 217 -> 117177974;
                case 218 -> -1876115233;
                case 219 -> -1757556713;
                case 220 -> -435480058;
                case 221 -> 422244246;
                case 222 -> -2089005539;
                case 223 -> 632567868;
                case 224 -> -1945050703;
                case 225 -> 2139126996;
                case 226 -> -2022663301;
                case 227 -> -1772787230;
                case 228 -> -1098318468;
                case 229 -> -651063382;
                case 230 -> 866897319;
                case 231 -> -77715016;
                case 232 -> -1638229079;
                case 233 -> 522479719;
                case 234 -> 1666244433;
                case 235 -> -1959033371;
                case 236 -> 132736930;
                case 237 -> -1279585142;
                case 238 -> 914538262;
                case 239 -> -1128031394;
                case 240 -> 580274224;
                case 241 -> 1130831555;
                case 242 -> 488230417;
                case 243 -> -97979508;
                case 244 -> 269870845;
                case 245 -> -1720075413;
                case 246 -> 1102830197;
                case 247 -> 1972849940;
                case 248 -> -1272183408;
                case 249 -> 974386878;
                case 250 -> 1590535055;
                case 251 -> 804458061;
                case 252 -> -1632105094;
                case 253 -> -1102142367;
                case 254 -> -898336121;
                case 255 -> 1847764513;
                default -> -470788531;
            });
        } while (v2 != 184);
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
            Object[] objectArray = new Object[15];
            v1 = objectArray;
            ChestStealerModule = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        00i = 0.5f;
    }

    private void ooo(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5, float param6, KeyBinding param7) {
        boolean v8 = param7.isPressed();
        int v9 = v8 ? ((Color)this.RenderSupport_0I0.HelpCommand()).getRGB() : ((Color)this.AutoMlgModule.HelpCommand()).getRGB();
        int v10 = v8 ? ((Color)this.ConfigSupport_0II.HelpCommand()).getRGB() : ((Color)this.0Io.HelpCommand()).getRGB();
        RenderSupport_00oi_0.O0o(param4, param5, param6, param6, this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()), v9);
        RenderSupport_00oi_0.HudElement(() -> this.ooI(param1, param2, param3, param4, param5, param6, v10));
    }

    private void ooI(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5, float param6, int param7) {
        float v8 = 0.5f * this.OIo();
        float v9 = (float)param2.GuiSupport_OOI(param3) * v8;
        float v10 = (float)param2.OOi() * v8;
        float v11 = param4 + (param6 - v9) / 2.0f;
        float v12 = param5 + (param6 - v10) / 2.0f - this.ConfigSupport_OII(1.0f);
        param1.ConfigSupport_O0I().getMatrices().pushMatrix();
        param1.ConfigSupport_O0I().getMatrices().scale(v8, v8);
        param2.PacketEvent(param1.ConfigSupport_O0I(), param3, v11 / v8, v12 / v8, param7);
        param1.ConfigSupport_O0I().getMatrices().popMatrix();
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        DataRecord_0io_0 v2 = this.ooi();
        PostProcessingModule.Ioio(this.GuiSupport_OOI(), this.OOi(), v2.RenderSupport_ooi_1(), v2.oOi(), this.ConfigSupport_OII((float)((Integer)this.0oI.HelpCommand()).intValue() + 2.0f));
    }

    private DataRecord_0io_0 ooi() {
        float v1 = this.RenderSupport_oii_4((Integer)this.0oO.HelpCommand());
        float v2 = this.RenderSupport_oii_4((Integer)this.0o0.HelpCommand());
        float v3 = this.RenderSupport_oii_4((Integer)this.SpawnerFinderModule.HelpCommand());
        float v4 = v3 * 2.0f + v1 * 3.0f + v2 * 2.0f;
        float v5 = v3 * 2.0f + v1 * 2.0f + v2;
        return new DataRecord_0io_0(v4, v5, v3, v2, v1);
    }
}

