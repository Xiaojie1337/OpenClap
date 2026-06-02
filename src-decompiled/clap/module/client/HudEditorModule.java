/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.Screen
 */
package clap.module.client;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.screen.Screen;
import clap.gui.screen.HudEditorScreen;
import clap.core.module.Module;
import clap.module.client.ClickGuiModule;
import clap.core.module.ModuleCategory;
import clap.model.EnumType_oioi_4;
import clap.gui.screen.HudEditorScreenV2;

/*
 * Renamed from clap.config.ConfigSupport_0OOo
 */
public class HudEditorModule
extends Module {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public HudEditorModule() {
        super("HudEditor", "Edit HUD element positions", ModuleCategory.NoHurtCamModule);
    }

    @Override
    public void ConfigSupport_oi0_2() {
        if (HudEditorModule.iooI()) {
            this.I0ii();
            return;
        }
        ClickGuiModule v1 = ClickGuiModule.OOi0O();
        if (v1 != null && v1.BindCommand.HelpCommand() == EnumType_oioi_4.iiO) {
            ConfigSupport_OI0.setScreen((Screen)HudEditorScreenV2.iI0());
        } else {
            ConfigSupport_OI0.setScreen((Screen)HudEditorScreen.ConfigSupport_O0IO());
        }
        this.I0ii();
    }

    static {
        __k__gH4it = HudEditorModule.__k__gH4it(1645840580690832913L);
        __rP__gH4it0 = new String[]{"\u4b03\u6c4d\ub191\ue47e\u632f\ue189\ue519\ub2f0\u486d\u6f17", "\u4b15\u6c42\ub192\ue417\u634f\ue1ea\ue588\ub2cf\u4809\u6f44\ub08a\ue563\u6231\ue0f0\ue4a2\ub39c\u4925\u6e7e\ub7bf\ue24f", "\u4b03\u6c58\ub188", "\u4b16\u6c45\ub191\ue407\u6326"};
        __rP__gH4it1 = new String[]{"\u4bc7\u6c83\ub2be\ue7df\u63bc\ue11c\ue5ee\ub250\u48fd\u6fc0\ub1a8\ue403\u637a\ue0e4\ue40a\ub346\u493a\u6e8a\ub08c\ue522\u6247\ue79c\ue390\ub476\u4e3d\u696e\ub72a\ue279\u65fa\ue6ac\ue249\ub5d5\u4f31\u6838\ub6cf\ue3fb\u64ee\ue5c5\ue132\ub61d\u4c95\u6b35\ub545\ue08c\u675b\ue5c5\ue0f1\ub78f\u4d13\u6a22\ub489\ue187\u665d\ue43b\uefd5\ub8cf\u42ed\u651d\ubb93\uee3f\u690e\uebbf\uee24\ub9f6\u4321\u64e9\ubae2\uef3a\u683e\uea6a\uedfd\uba25", "\u4b01\u6c4f\ub197\ue478\u632d\ue18b\ue5e7\ub2ce\u486f\u6f15"};
        __rP__gH4it2 = new String[]{"\u4b13\u6c5c\ub191\ue402\u632f\ue18e\ue5ec"};
        __rP__gH4it3 = new String[]{"\u4b24\u6c44\ub1e6\ue473\u6349\ue12f\ue57f\ub2f4"};
        byte[] v0 = "\u00ce\u00dc\u00a7?\u00e8\u00ec\u00fdX\f\u00a7\u00c9\u00db\u00d6,aF\u00c3\u00e5\u00e5\u00f2\u00e3\\\u00f3n\u00dc\u0019[\u00b1Ft2\u00c5\u00d8G\u00b6;Z\u0015AuD\u00b2\u00044\u00d7\u00ed\u00ba\u00ef\u00ca\u00ad\u00c07\u00d9\u001b\u0096\u00b7,\u008a\u00c2\u0097\u0092\u0087\u007f\u0086\u00e8v\u00bb\u009a\u00aaZ\u00aem".getBytes("ISO_8859_1");
        Object[] v1 = "o]9Q_\u00a1R>".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1735118386;
                case 1 -> -1283471185;
                case 2 -> 100576956;
                case 3 -> 1680258183;
                case 4 -> -2030802884;
                case 5 -> -1497323023;
                case 6 -> 258272430;
                case 7 -> -231250829;
                case 8 -> -282905631;
                case 9 -> 91175199;
                case 10 -> -1353855258;
                case 11 -> 1144817759;
                case 12 -> 1063809284;
                case 13 -> 1290865645;
                case 14 -> -915049008;
                case 15 -> -1608109761;
                case 16 -> 1451801908;
                case 17 -> 1114036861;
                case 18 -> 135117710;
                case 19 -> -143692936;
                case 20 -> -584912940;
                case 21 -> -561885583;
                case 22 -> -2027016603;
                case 23 -> -456344279;
                case 24 -> 1638735188;
                case 25 -> -255788338;
                case 26 -> 1226431639;
                case 27 -> -287012450;
                case 28 -> 1723402057;
                case 29 -> 1312318692;
                case 30 -> -871009204;
                case 31 -> 1269607111;
                case 32 -> -1870558579;
                case 33 -> -1869148993;
                case 34 -> -952407728;
                case 35 -> -203755605;
                case 36 -> -188227935;
                case 37 -> 1102760871;
                case 38 -> 274925612;
                case 39 -> -1400085739;
                case 40 -> -1189034394;
                case 41 -> 2138897026;
                case 42 -> -2062891752;
                case 43 -> -1860076967;
                case 44 -> 1161755664;
                case 45 -> 509161852;
                case 46 -> -2105206691;
                case 47 -> -963931752;
                case 48 -> -1983289513;
                case 49 -> -1868850627;
                case 50 -> -1179993934;
                case 51 -> 774527881;
                case 52 -> 1042351198;
                case 53 -> 386934295;
                case 54 -> -1622402551;
                case 55 -> -551672171;
                case 56 -> -1721534587;
                case 57 -> 1073488475;
                case 58 -> 1070034031;
                case 59 -> -1143070005;
                case 60 -> 1513404957;
                case 61 -> 2109728293;
                case 62 -> 549944295;
                case 63 -> -449842021;
                case 64 -> -290758088;
                case 65 -> -1340686992;
                case 66 -> 595805192;
                case 67 -> -175086722;
                case 68 -> 257973035;
                case 69 -> 633809402;
                case 70 -> -81980350;
                case 71 -> -1628252429;
                case 72 -> 257701202;
                case 73 -> -1326046515;
                case 74 -> -247760136;
                case 75 -> 1656219795;
                case 76 -> -1146535419;
                case 77 -> 2054424084;
                case 78 -> -35294136;
                case 79 -> -149329772;
                case 80 -> -1175245049;
                case 81 -> -394116826;
                case 82 -> -95513582;
                case 83 -> 2018273802;
                case 84 -> -1961763118;
                case 85 -> 134016938;
                case 86 -> 936837814;
                case 87 -> -1803530464;
                case 88 -> 1709611755;
                case 89 -> -742128903;
                case 90 -> -2142329003;
                case 91 -> 1928063141;
                case 92 -> 365951515;
                case 93 -> -1712083497;
                case 94 -> 1774837444;
                case 95 -> -2054679045;
                case 96 -> -2023096374;
                case 97 -> -1053552388;
                case 98 -> -1706464982;
                case 99 -> -987134157;
                case 100 -> 731206342;
                case 101 -> -1100711061;
                case 102 -> -1386306903;
                case 103 -> -291402590;
                case 104 -> 1561960496;
                case 105 -> 342275511;
                case 106 -> -1290792216;
                case 107 -> 1067974730;
                case 108 -> 1575254884;
                case 109 -> 1897080075;
                case 110 -> -221123762;
                case 111 -> 1506724947;
                case 112 -> -1087944178;
                case 113 -> 463914707;
                case 114 -> -1297542795;
                case 115 -> 1793171560;
                case 116 -> 1621891761;
                case 117 -> -293059854;
                case 118 -> 549892666;
                case 119 -> 2065348427;
                case 120 -> 14840221;
                case 121 -> -2142133345;
                case 122 -> 1079348630;
                case 123 -> -457187613;
                case 124 -> 1168271194;
                case 125 -> 853570670;
                case 126 -> 1880192732;
                case 127 -> -62319301;
                case 128 -> 1991614851;
                case 129 -> -486129797;
                case 130 -> 232043977;
                case 131 -> -161188824;
                case 132 -> -333772940;
                case 133 -> 1955577411;
                case 134 -> 349060113;
                case 135 -> 675362904;
                case 136 -> -1678558641;
                case 137 -> -2064040227;
                case 138 -> -942740878;
                case 139 -> 12981711;
                case 140 -> -1135529309;
                case 141 -> -7672618;
                case 142 -> 1699434879;
                case 143 -> 485833661;
                case 144 -> 621510668;
                case 145 -> -134208241;
                case 146 -> 445819014;
                case 147 -> -788354279;
                case 148 -> -362797191;
                case 149 -> 831061831;
                case 150 -> 1989340149;
                case 151 -> -2134391686;
                case 152 -> -2079983224;
                case 153 -> -1356492546;
                case 154 -> 898453916;
                case 155 -> 1737041982;
                case 156 -> 174323219;
                case 157 -> -61949131;
                case 158 -> -1784835144;
                case 159 -> -1766694335;
                case 160 -> -2041046227;
                case 161 -> -237468346;
                case 162 -> 1529461098;
                case 163 -> 1065150608;
                case 164 -> -1266904063;
                case 165 -> 1060517598;
                case 166 -> 460807072;
                case 167 -> -223448924;
                case 168 -> -1133294439;
                case 169 -> 604556213;
                case 170 -> 1442745728;
                case 171 -> -1376477383;
                case 172 -> 1420641037;
                case 173 -> 2103737531;
                case 174 -> -639504849;
                case 175 -> -31288457;
                case 176 -> 1285828842;
                case 177 -> -1916642320;
                case 178 -> 527860534;
                case 179 -> -2097751635;
                case 180 -> 131221609;
                case 181 -> -228636394;
                case 182 -> -985831988;
                case 183 -> -229196064;
                case 184 -> -1407368024;
                case 185 -> -853943961;
                case 186 -> -1621336642;
                case 187 -> -1336537019;
                case 188 -> -1809387596;
                case 189 -> -889927910;
                case 190 -> -1883113700;
                case 191 -> -315568797;
                case 192 -> 2051462252;
                case 193 -> -444849192;
                case 194 -> 787790721;
                case 195 -> 1557022353;
                case 196 -> 555083588;
                case 197 -> 1420256758;
                case 198 -> -1588301430;
                case 199 -> 1253813796;
                case 200 -> 1672360692;
                case 201 -> 1873997137;
                case 202 -> 1972355078;
                case 203 -> 1946564726;
                case 204 -> 1330504478;
                case 205 -> 1242545762;
                case 206 -> 914325445;
                case 207 -> 2084247462;
                case 208 -> -2094118657;
                case 209 -> -969905406;
                case 210 -> 1203536323;
                case 211 -> 1985356015;
                case 212 -> -1219193801;
                case 213 -> -18446290;
                case 214 -> 2019281005;
                case 215 -> 734908672;
                case 216 -> 824932491;
                case 217 -> 695472780;
                case 218 -> 1837649089;
                case 219 -> 91620034;
                case 220 -> -1575882862;
                case 221 -> 313040929;
                case 222 -> 242276903;
                case 223 -> -1713336909;
                case 224 -> -1845705182;
                case 225 -> -1063624743;
                case 226 -> -1754025152;
                case 227 -> 1836422064;
                case 228 -> 68010220;
                case 229 -> 2097616597;
                case 230 -> 47768027;
                case 231 -> -940354825;
                case 232 -> 2111593434;
                case 233 -> 174701242;
                case 234 -> 1426552672;
                case 235 -> 866098947;
                case 236 -> 1633261444;
                case 237 -> 999643645;
                case 238 -> -802081439;
                case 239 -> 846426189;
                case 240 -> -1913040724;
                case 241 -> -881959457;
                case 242 -> -1825360158;
                case 243 -> -2027219370;
                case 244 -> 1163983081;
                case 245 -> -1536727142;
                case 246 -> 404861475;
                case 247 -> -1850995227;
                case 248 -> 864341852;
                case 249 -> -973647160;
                case 250 -> 65007247;
                case 251 -> 1239126208;
                case 252 -> 1729750321;
                case 253 -> 1704071865;
                case 254 -> -796596754;
                case 255 -> 1477393105;
                default -> -1093369561;
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
            PacketEvent = objectArray;
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

