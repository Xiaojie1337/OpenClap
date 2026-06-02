/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 */
package clap.command.argument;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.config.ConfigSupport_O0I;

/*
 * Renamed from clap.module.hud.PotionEffectsHudElement
 */
public class ArgumentType_iii_3
implements ArgumentType {
    private static final List iOI;
    private static final String[] iOi;
    static Object WorldTimeModule;
    private static volatile /* synthetic */ long __k__gH4it;

    /*
     * Enabled aggressive block sorting
     */
    public Color NetworkSupport_OO00(StringReader param1) throws CommandSyntaxException {
        int[] cfr_ignored_0 = new int[0];
        String v2 = param1.getRemaining();
        param1.setCursor(param1.getTotalLength());
        if (v2.startsWith("#")) {
            return new Color(Integer.parseInt(v2.substring(1), 16));
        }
        if (v2.startsWith("hsb:")) {
            int[] v3 = this.OO0o(param1, v2.substring(4));
            int v4 = v3[0];
            if (v4 < 0) throw ConfigSupport_O0I.PacketEvent("Hue value must be between 0-360", new Object[0]).createWithContext((ImmutableStringReader)param1);
            if (v4 > 360) {
                throw ConfigSupport_O0I.PacketEvent("Hue value must be between 0-360", new Object[0]).createWithContext((ImmutableStringReader)param1);
            }
            int v5 = v3[1];
            if (v5 < 0) throw ConfigSupport_O0I.PacketEvent("Saturation value must be between 0-100", new Object[0]).createWithContext((ImmutableStringReader)param1);
            if (v5 <= 100) {
                int v6 = v3[2];
                if (v6 < 0) throw ConfigSupport_O0I.PacketEvent("Brightness value must be between 0-100", new Object[0]).createWithContext((ImmutableStringReader)param1);
                if (v6 <= 100) return Color.getHSBColor((float)v4 / 360.0f, (float)v5 / 100.0f, (float)v6 / 100.0f);
                throw ConfigSupport_O0I.PacketEvent("Brightness value must be between 0-100", new Object[0]).createWithContext((ImmutableStringReader)param1);
            }
            throw ConfigSupport_O0I.PacketEvent("Saturation value must be between 0-100", new Object[0]).createWithContext((ImmutableStringReader)param1);
        }
        int[] v3 = this.OO0o(param1, v2);
        int v4 = 0;
        while (true) {
            if (v4 >= v3.length) {
                int n;
                int n2 = v3[0];
                int n3 = v3[1];
                int n4 = v3[2];
                if (v3.length == 4) {
                    n = v3[3];
                    return new Color(n2, n3, n4, n);
                }
                n = 255;
                return new Color(n2, n3, n4, n);
            }
            int v5 = v3[v4];
            if (v5 < 0 || v5 > 255) {
                throw ConfigSupport_O0I.PacketEvent("%s value must be between 0-255", iOi[v4]).createWithContext((ImmutableStringReader)param1);
            }
            ++v4;
        }
    }

    static {
        __k__gH4it = ArgumentType_iii_3.__k__gH4it((long)-3210316642672185839L);
        __rP__gH4it0 = new String[]{"\u9c24\u31ea\uee74\ub85a\u3f4b\u25ad\u8b9d\ueede\u9f3a\u3280", "\u9c32\u31e5\uee7f\ub823\u3f3b\u25de\u8be4\ueec1\u9f3e\u32f3\ued77\ub957\u3e45\u24c4\u8ace\uef82\u9e02\u33d9\uec52\ub99b", "\u9c24\u31f7\uee6d"};
        __rP__gH4it1 = new String[]{"\u9d77\u3033\ueeda\ubbb0\u3cc3\u26c0\u8840\ueda0\u9c11\u318a\uee46\ub8d0\u3ff3\u2503\u8be0\ueeb0\u9f4a\u3211\ued7c\ub9f6\u3ebf\u2453\u8a2f\uef76\u9e84\u3303\uece0\ua6e1\u21c8\u3b32\u9564\uf023\u8185\u2cc1\uf320\ua665\u2008\u3a8a\u9411\uf17a\u8068\u2dec\uf281\ua7c4\u2338\u3983\u970c\uf2e1\u83d9\u2ecb\uf121\ua458\u2262\u38d2\u9695\uf3d6\u8296\u2f9d\uf01d\ua596\u2545\u3f79\u915a\uf4b4\u859f\u2851\uf75f\ua2cc\u25ff\u3e48\u909c\uf513\u84b2\u2943\uf661\ua358\u24f2\u3d14\u9303\uf68b\u87e3\u2a30\uf575\ua0d0\u2718\u3c64\u92e5\uf78e\u8640\u2b3b\uf43b\ua17c\u2624\u331b\u9dec\uf8b2\u89d9\u24bb\ufb86\uae0b\u297b\u33d0\u9c8f\uf981\u8878\u2562\ufa55\uaf6d\u28e0\u32db\u9fde\ufa32\u8bd9\u26ec\uf9a0\uacd5\u2b2e\u314b\u9ef4\ufb8a\u8aba\u27d8\uf8d5\uadf1\u2afd\u3046\u991c\ufcf3\u8d34\u209e\uff8c\uaa1c\u2d12\u37ff\u9993\ufda9\u8c45\u214d\ufe7c\uab3b\u2c5e\u3640\u980f\ufeb8\u8f80\u22fa\ufd36\ua8a4\u2f92\u3553\u9b5a\uff16\u8e4d\u2300\ufc30\ua979\u2e6a\u34c5\u9a0c\u00a0\u711b\udc55\u0378\u56ef\ud133\ucb8e\u659a\u0018\u70bc\udda8\u02f8\u5755\ud0a6\ucaa0\u64eb\u0191\u73b4\ude86\u013e\u5453\ud311\uc979\u67e3\u020f\u72aa\udf09\u00b4\u5570\ud203\uc8fb\u6646\u03f1\u7587\ud837\u070d\u52c2\ud504\ucfae\u6136\u040f\u7527\ud982\u06e8\u5336\ud4de\uce36\u60c8\u05bc\u74e8\uda68\u05da\u5080\ud70e\ucd27\u6351\u0621\u7723\udb94\u04eb\u5143\ud6ea\ucc91\u62a0\u07ab\u7682\ud4c6\u0b53\u5eb0\ud9df\uc34b\u6de3\u088e\u790e\ud459\u0aaf\u5fbf\ud8ab\uc280\u6cdb\u0962\u7885\ud5c5\u0922\u5c79\udb5b\uc1b1\u6fe1\u0a6f\u7b30\ud67d\u087e\u5d7d\udacd\uc099\u6e92\u0b5e\u7af4\ud785\u0fe6\u5a4c\uddce\uc701\u69aa\u0c12\u7d2d\ud03c\u0f1c\u5b1b\udc48\uc64f\u6814\u0d36\u7cfa\ud1f3\u0e1d\u5870\udf3e\uc53c\u6b15\u0e47\u7f6f\ud2d0\u0d20\u5941\ude00\uc479\u6a67\u0fb8\u7e2f\ud3d1\u0cb4\u5963\uc10d\udb76\u7563\u1008\u6149\ucc46\u13ec\u4690\uc09c\udaab\u74b5\u11b7\u60c5\ucd53\u1236\u4722\uc3aa\ud904\u77b6\u12dc\u6378\ucea0\u1173\u4415\uc21f\ud88e\u761c\u13a8\u6284\ucf16\u10aa\u45d5\uc2dd\udfe0\u713a\u14e8\u6562\uc863\u17f3\u42fa\uc541\ude75\u7019\u1548\u64a3\uc92f\u16a1\u43a4\uc418\uddc0\u7333\u164c\u67c9\uca24\u1568\u40b9\uc720\udc30\u72b5\u176d", "\u9c26\u31e8\uee7a\ub854\u3f49\u25af\u8b9b\ueed8\u9f38\u3282"};
        __rP__gH4it2 = new String[]{"\u9c31\u319a\uee44\ubbd3\u3f72"};
        __rP__gH4it3 = new String[]{"\u9c79\u3177\uee2c\ub8a1\u3f99\u2599\u8b90\uee49", "\u9c34\u31fb\uee7c\ub82e\u3f7b\u25da\u8ba0"};
        byte[] v0 = "q\u00a3\u0006\u00ac\u00abL\u00f7^o\"b\u00c4\u0093\u0087_F<\u00b1P\u00fa\u00c7\u00cf\u0088\u0098\u00ea\u00bb\u00d4\u00e5\u00b8\u00a6\u00cb\u00c5\u00e3q\u001c\u0099@f\u0086d6$\u00850xg\u0093\u00f7\u008f\u000b-\u00b4:.\u0012\u00d8\u00d8E\tr\u0015\u008d\u00d5\u00b2\u00d9\u0081C\u0010W\u0084k-\f\u00ab\u0005\u008cR\u00d0\u00fc\u00bdU\u00d0\u0019\u001c\u00a0\u00b8\u0002\u00a0\u00ee\u00c3O\u00b8\u0094\u00cf\u0003\u0094\u007fK\u00fa\u00b7\u00f3\u00fcX\u00df\u00e6j\u0011\u00d9`\u00ff\u0001dO\u00ec\u00ecy\u00b6w3\u00c44\u00c0\u0081Umr\u00d3\u00b5\u00b2\u008e\u00d0\u0080\u00fa\u00f3\u00a4\u00d7\u00bbe\u00d8\u00af\u00beD0\u00cev\u00da\u009a(jO}x\u00a38\u0084\u00fd\u009a\u00d1#\u00c6\u00fde\u00c4\u0093\u00fb\u00e2\u008d\u0086b\u00e0|!f\u00c4\u00f4\u0007b\u00c6\u00b2?\u00c9\u0005\u00e4\u0081dQ \u0014\u00d3\u008fIwAg\u0091\u009e,\u00e2A\u00b1\u0019\u00ea\fb\u00fer\u00b7\n\u00de\b6\u00cc6{6\u008f\r\u00ec\u001f\u0007\u00da\u00c5\u00cf\r\u00a4\u00b6\u00af\u008c\u00d7\u00e7\u00b4P\u0010\u00d1k\u008b\u00ab$\u0084\u00b4\u0093E\u00eeUC\r\u00a6\u00a1>\u00e5\u00aaY\u00dd-\u00dd\u0098\u00f2\u0015:P\u00a6\u008d\u001d\u00ecS\u00948\u000f(\u00cb\u00ab\u00c0\u008cS1|F\u00a0\u00b2\u00a9\u0001h\u0014Ep\u00ed\u00c8^Ia\u0088\u009fE\u009a\u00f4\u0016\u0017\u008e\u00e8d\u00dcO*\u00a1\u0093\u0093:\u00ce\u00f2\u00f81\u00d26xg\u00f1Oz\u0093\u00ae\u00c2\u00c6\u00b6\tu,\u00cd\u00d6\u00dc\u008b\u0097.\u00e1\u00b1\u00e6~\u0015\u00cf\u00cdh\u00a0\u001c\u00d4bg\u00dc\u001c}\u0090\u00e4ZK".getBytes("ISO_8859_1");
        Object[] v1 = "\u0015\u00c1\u0016\u00a7\u00eb\u000b9\u00ad".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -943561998;
                case 1 -> -1594450329;
                case 2 -> 28822719;
                case 3 -> 1826151773;
                case 4 -> 1712327131;
                case 5 -> 624041721;
                case 6 -> 1185080991;
                case 7 -> -143227950;
                case 8 -> 1873545704;
                case 9 -> -365262259;
                case 10 -> -189883307;
                case 11 -> -1423814279;
                case 12 -> 2086665466;
                case 13 -> -1770497065;
                case 14 -> -11109814;
                case 15 -> 955867424;
                case 16 -> -1076262840;
                case 17 -> -599915290;
                case 18 -> 1601694995;
                case 19 -> 401493232;
                case 20 -> 1659086446;
                case 21 -> 977960315;
                case 22 -> 943942845;
                case 23 -> 1832894445;
                case 24 -> -1315384585;
                case 25 -> 732116633;
                case 26 -> -2029088533;
                case 27 -> 568020022;
                case 28 -> 1085467028;
                case 29 -> -689195251;
                case 30 -> 1332344643;
                case 31 -> -1022989069;
                case 32 -> 1763105743;
                case 33 -> 855731900;
                case 34 -> -208062415;
                case 35 -> 1038203217;
                case 36 -> 67594773;
                case 37 -> 1309045787;
                case 38 -> -1866836805;
                case 39 -> -1476858589;
                case 40 -> 1028369809;
                case 41 -> -982628410;
                case 42 -> 1489855181;
                case 43 -> 1297358648;
                case 44 -> -2142566688;
                case 45 -> -1521761018;
                case 46 -> -1968942283;
                case 47 -> 1017464277;
                case 48 -> -219561103;
                case 49 -> 1934615609;
                case 50 -> -1949425330;
                case 51 -> -1099496018;
                case 52 -> -368141561;
                case 53 -> -2099450140;
                case 54 -> -99630142;
                case 55 -> 720391490;
                case 56 -> 694860154;
                case 57 -> 998917142;
                case 58 -> 741387017;
                case 59 -> -1391310593;
                case 60 -> 1201871492;
                case 61 -> 1722872593;
                case 62 -> 1678226266;
                case 63 -> -661873410;
                case 64 -> 43207919;
                case 65 -> 324637843;
                case 66 -> -250560576;
                case 67 -> -761392821;
                case 68 -> -900795291;
                case 69 -> 510149040;
                case 70 -> 849507800;
                case 71 -> -583662694;
                case 72 -> -32988529;
                case 73 -> -412375668;
                case 74 -> -27339798;
                case 75 -> -1477619416;
                case 76 -> -916862690;
                case 77 -> 1832936229;
                case 78 -> -1846509985;
                case 79 -> 447975744;
                case 80 -> -607063780;
                case 81 -> -1190501482;
                case 82 -> 1104288672;
                case 83 -> -1267215647;
                case 84 -> 1164473872;
                case 85 -> -1508261549;
                case 86 -> 1492913575;
                case 87 -> -756929257;
                case 88 -> 433678451;
                case 89 -> 1114203000;
                case 90 -> -1708631509;
                case 91 -> -1448747670;
                case 92 -> 1877173554;
                case 93 -> 29457564;
                case 94 -> 35891244;
                case 95 -> -1639333659;
                case 96 -> 1239118301;
                case 97 -> 493387841;
                case 98 -> 1990034210;
                case 99 -> -1832951767;
                case 100 -> -1352583165;
                case 101 -> -806269443;
                case 102 -> 358180342;
                case 103 -> 872344331;
                case 104 -> 238762273;
                case 105 -> -1067612336;
                case 106 -> -1346032009;
                case 107 -> 341883489;
                case 108 -> -11551693;
                case 109 -> 1035434767;
                case 110 -> 1846609298;
                case 111 -> -1982639203;
                case 112 -> 96049560;
                case 113 -> -994643175;
                case 114 -> -1775249594;
                case 115 -> 1888945089;
                case 116 -> 1448424572;
                case 117 -> 1345904779;
                case 118 -> 1978064819;
                case 119 -> -233409066;
                case 120 -> 1326660226;
                case 121 -> -745948469;
                case 122 -> -1769605449;
                case 123 -> -955912145;
                case 124 -> -198972436;
                case 125 -> -553714260;
                case 126 -> -1001809441;
                case 127 -> -2107042734;
                case 128 -> -1763239186;
                case 129 -> 1146890762;
                case 130 -> 1577245567;
                case 131 -> -759610036;
                case 132 -> 347741617;
                case 133 -> -851172976;
                case 134 -> -1833913122;
                case 135 -> 1030040076;
                case 136 -> -746694461;
                case 137 -> -222309051;
                case 138 -> 494495403;
                case 139 -> 964940466;
                case 140 -> -1941427328;
                case 141 -> 2112854087;
                case 142 -> 472507905;
                case 143 -> 790395450;
                case 144 -> -347122522;
                case 145 -> 260869236;
                case 146 -> 1682736415;
                case 147 -> 1527645785;
                case 148 -> 1010247621;
                case 149 -> -2110523954;
                case 150 -> 1313293532;
                case 151 -> -357589189;
                case 152 -> -2074731312;
                case 153 -> -1160875689;
                case 154 -> 268799207;
                case 155 -> 1878396298;
                case 156 -> 654942976;
                case 157 -> -821992616;
                case 158 -> 683163241;
                case 159 -> -1652573289;
                case 160 -> 597437292;
                case 161 -> 62458553;
                case 162 -> -126725870;
                case 163 -> -1281129448;
                case 164 -> 638639564;
                case 165 -> 1505627267;
                case 166 -> -937990304;
                case 167 -> 985443947;
                case 168 -> -1786152990;
                case 169 -> -2077132691;
                case 170 -> 1400185446;
                case 171 -> 1169209256;
                case 172 -> -382716630;
                case 173 -> -654931244;
                case 174 -> 1605833486;
                case 175 -> 408017763;
                case 176 -> 1356386633;
                case 177 -> 767666992;
                case 178 -> 1190169225;
                case 179 -> 1779135137;
                case 180 -> -165088926;
                case 181 -> -1980206467;
                case 182 -> 1433844894;
                case 183 -> -1267497116;
                case 184 -> 659133364;
                case 185 -> 101102792;
                case 186 -> -1032266007;
                case 187 -> -785424010;
                case 188 -> -769108857;
                case 189 -> 1216929678;
                case 190 -> 1240154940;
                case 191 -> 1095679434;
                case 192 -> 543726755;
                case 193 -> -2132009052;
                case 194 -> -2051693829;
                case 195 -> -1675885625;
                case 196 -> 1569851478;
                case 197 -> -97968166;
                case 198 -> 375650486;
                case 199 -> 43893805;
                case 200 -> -871718008;
                case 201 -> -549036220;
                case 202 -> 731692912;
                case 203 -> -504879268;
                case 204 -> -1354707448;
                case 205 -> 1251698069;
                case 206 -> -1315540775;
                case 207 -> 2133012399;
                case 208 -> -1286483342;
                case 209 -> 2023640680;
                case 210 -> 770801065;
                case 211 -> -1760231692;
                case 212 -> 1773636699;
                case 213 -> -73823543;
                case 214 -> 2063284410;
                case 215 -> 105738498;
                case 216 -> -799492859;
                case 217 -> 524269045;
                case 218 -> 397500442;
                case 219 -> -654131501;
                case 220 -> -1711497519;
                case 221 -> -1779439987;
                case 222 -> -1541060497;
                case 223 -> 277152302;
                case 224 -> 500988221;
                case 225 -> -572724546;
                case 226 -> -2007448861;
                case 227 -> -903295715;
                case 228 -> -1390838102;
                case 229 -> 510538292;
                case 230 -> 1318998405;
                case 231 -> -1897455276;
                case 232 -> 1635810812;
                case 233 -> 643399330;
                case 234 -> 1026116213;
                case 235 -> 1576241080;
                case 236 -> -294077029;
                case 237 -> -1923055810;
                case 238 -> 2081544574;
                case 239 -> 1433342756;
                case 240 -> 1283796216;
                case 241 -> 697170436;
                case 242 -> 282864580;
                case 243 -> -1385592155;
                case 244 -> 1318863951;
                case 245 -> 729953965;
                case 246 -> 0x1DD11FF1;
                case 247 -> 1758462081;
                case 248 -> -267637722;
                case 249 -> 2014750783;
                case 250 -> -982893529;
                case 251 -> -1342530938;
                case 252 -> -421138082;
                case 253 -> -1549979211;
                case 254 -> 1744429111;
                case 255 -> 528571156;
                default -> 1262740162;
            });
        } while (v2 != 352);
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
            WorldTimeModule = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iOI = List.of("hsb:55,100,100", "255,0,255", "0,255,255,80");
        iOi = new String[]{"Red", "Green", "Blue", "Alpha"};
    }

    public Collection getExamples() {
        return iOI;
    }

    public static Color FontRenderer(CommandContext param0, String param1) {
        return (Color)param0.getArgument(param1, Color.class);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int[] OO0o(StringReader param1, String param2) throws CommandSyntaxException {
        int[] cfr_ignored_0 = new int[0];
        String[] v3 = param2.split(",");
        if (v3.length < 3) {
            throw ConfigSupport_O0I.PacketEvent("Color element must have three values (with optional alpha value), either RGB(A) or hsb:HSB", new Object[0]).createWithContext((ImmutableStringReader)param1);
        }
        int[] v4 = new int[v3.length];
        int v5 = 0;
        while (v5 < v3.length) {
            v4[v5] = Integer.parseInt(v3[v5]);
            ++v5;
        }
        return v4;
    }

    public static ArgumentType_iii_3 OO0i() {
        return new ArgumentType_iii_3();
    }
}

