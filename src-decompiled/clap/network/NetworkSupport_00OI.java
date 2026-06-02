/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 */
package clap.network;

import java.security.Key;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.util.Identifier;
import clap.render.FontRenderer;

public final class NetworkSupport_00OI {
    private static boolean OoO;
    private static final Map OOi;
    private static final Map GuiSupport_OOI;
    private static final Map O0i;
    private static final Map PacketEvent;
    private static final Map EventBusApi;
    private static final Map ConfigSupport_O0I;
    private static final Map HudElement;
    private static final Map O0o;
    private static final Map OOo;
    private static final Map HelpCommand;
    static Object Oo0;
    private static volatile /* synthetic */ long __k__gH4it;

    public static void HelpCommand() {
        if (OoO) {
            return;
        }
        OoO = true;
        PacketEvent.values().forEach(FontRenderer::OOo);
        HelpCommand.values().forEach(FontRenderer::OOo);
        OOo.values().forEach(FontRenderer::OOo);
        GuiSupport_OOI.values().forEach(FontRenderer::OOo);
        OOi.values().forEach(FontRenderer::OOo);
        HudElement.values().forEach(FontRenderer::OOo);
        EventBusApi.values().forEach(FontRenderer::OOo);
        O0o.values().forEach(FontRenderer::OOo);
        ConfigSupport_O0I.values().forEach(FontRenderer::OOo);
        O0i.values().forEach(FontRenderer::OOo);
    }

    public static FontRenderer OOi(int param02) {
        return OOo.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/font2.ttf"), (int)param0));
    }

    public static FontRenderer OOo(int param02) {
        return PacketEvent.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/font1.ttf"), (int)param0));
    }

    public static FontRenderer Oo0(int param02) {
        return O0i.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/welcomefont.ttf"), (int)param0));
    }

    public static void PacketEvent() {
        NetworkSupport_00OI.OOo(16);
        NetworkSupport_00OI.OOo(18);
        NetworkSupport_00OI.OOo(20);
        NetworkSupport_00OI.OOo(22);
        NetworkSupport_00OI.OOo(24);
        NetworkSupport_00OI.GuiSupport_OOI(16);
        NetworkSupport_00OI.GuiSupport_OOI(18);
        NetworkSupport_00OI.GuiSupport_OOI(20);
        NetworkSupport_00OI.GuiSupport_OOI(22);
        NetworkSupport_00OI.GuiSupport_OOI(24);
        NetworkSupport_00OI.GuiSupport_OOI(28);
        NetworkSupport_00OI.OOi(16);
        NetworkSupport_00OI.OOi(18);
        NetworkSupport_00OI.OOi(20);
        NetworkSupport_00OI.OOi(22);
        NetworkSupport_00OI.OOi(24);
        NetworkSupport_00OI.HudElement(16);
        NetworkSupport_00OI.HudElement(18);
        NetworkSupport_00OI.HudElement(20);
        NetworkSupport_00OI.HudElement(22);
        NetworkSupport_00OI.HudElement(24);
        NetworkSupport_00OI.EventBusApi(16);
        NetworkSupport_00OI.EventBusApi(18);
        NetworkSupport_00OI.EventBusApi(20);
        NetworkSupport_00OI.EventBusApi(22);
        NetworkSupport_00OI.EventBusApi(24);
        NetworkSupport_00OI.O0o(10);
        NetworkSupport_00OI.O0o(18);
        NetworkSupport_00OI.O0o(20);
        NetworkSupport_00OI.O0o(22);
        NetworkSupport_00OI.O0o(24);
        NetworkSupport_00OI.ConfigSupport_O0I(24);
        NetworkSupport_00OI.ConfigSupport_O0I(32);
        NetworkSupport_00OI.O0i(24);
        NetworkSupport_00OI.O0i(30);
        NetworkSupport_00OI.OoO(24);
        NetworkSupport_00OI.OoO(28);
        NetworkSupport_00OI.OoO(32);
        NetworkSupport_00OI.OoO(40);
        NetworkSupport_00OI.OoO(48);
        NetworkSupport_00OI.Oo0(64);
        NetworkSupport_00OI.Oo0(80);
        NetworkSupport_00OI.Oo0(96);
    }

    public static FontRenderer O0i(int param02) {
        return O0o.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/icon1.ttf"), (int)param0));
    }

    public static FontRenderer HudElement(int param02) {
        return GuiSupport_OOI.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/font3.ttf"), (int)param0));
    }

    private NetworkSupport_00OI() {
    }

    public static FontRenderer ConfigSupport_O0I(int param02) {
        return EventBusApi.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/icon.ttf"), (int)param0));
    }

    public static FontRenderer EventBusApi(int param02) {
        return OOi.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/minecraft.ttf"), (int)param0));
    }

    static {
        __k__gH4it = NetworkSupport_00OI.__k__gH4it((long)6307061741138210321L);
        __rP__gH4it0 = new String[]{"\u699a\ucf30\u11a8\u4405\uc316\uab7e\u7d3a\u1283\u6a84\uce5a", "\u6998\ucf36\u11ae\u4407\uc314\uab70\u7d34\u1281\u6a86\uce5c"};
        __rP__gH4it1 = new String[]{"\u68be\ucc18\u1286\u4789\uc0ee\ua889\u7edc\u1166\u6967\ucf49\u11f5\u444f\uc3f8\uab2e\u7d9f\u1273\u6a19\uce22\u100d\u458b\uc24d\uaad6\u7c38\u13f2\u6bb0\uc913\u170d\u4243\uc504\uadae\u7b72\u14cb\u6c82\uc9d5\u162c\u43ee\uc46d\uacc5\u7a55\u156a\u6d00\uc877\u151e\u402a\uc795\uaf86\u7921\u1681\u6ef6\ucb86\u144a\u41b6\uc6a7\uae78\u783d\u1759\u6fc3\ucaf0\u1b3e\u4e1f\uc9bc\ua1c5\u77b0\u187e\u6042\uc5c8\u1bc4\u4f10\uc8a2\ua038\u76a2\u19ed\u61b9\uc4da\u1a22\u4c43\ucb8a\ua3dc\u75fd\u1a3a\u627b\uc750\u1913\u4d62\uca75\ua224\u7400\u1bf6\u634e\uc6ab\u1870\u4a98\ucda5\ua53b\u7372\u1c53\u6440\uc1ec\u1f47\u4a85\ucc66\ua400\u728c\u1d14\u65c0\uc0a2\u1ebf\u4bcc\ucf68\ua772\u71cb\u1eba\u669a\uc370\u1dfa\u484e\uce3f\ua662\u70ad\u1fc5\u67ef\uc25a\u1c7e\u4970\uf142\u9986\u4f67\u2077\u58b3\ufdbf\u23b1\u767a\uf1cb\u98f2\u4e9e\u2189\u5921\ufc54\u22a5\u77c4\uf02e\u9bc8\u4d6e\u22ec\u5a9b\uffd2\u2100\u74f8\uf3e1\u9aad\u4c4a\u2368\u5b24\ufe13\u20a5\u75f1\uf225\u9dea\u4b6c\u24b5\u5c63\uf916\u2742\u726e\uf53d\u9d9b\u4a9f\u25c0\u5dbc\uf8a3\u2676\u73ba\uf413\u9c3c\u49bd\u26a2\u5e70\ufb71\u256e\u7044\uf74d\u9fa5\u4826\u274f\u5f77\ufab2\u244a\u7104\uf61c\u9e89\u4713\u289d\u50bc\uf5bb\u2be8\u7e09\uf975\u9175\u47e0\u290b\u51c5\uf421\u2ad1\u7fa6\uf8e3\u905a\u4647\u2a49\u52ab\uf769\u2936\u7c75\ufb26\u9326\u45b5\u2b90\u530e\uf68e\u2833\u7d2c\ufa73\u9296\u44e1\u2c40\u54bc\uf1af\u2f35\u7ae4\ufda2\u9554\u433d\u2cc8\u5542\uf062\u2e8c\u7bd0\ufc26\u94ba\u4227\u2d9b\u567b\uf3c4\u2d18\u78ac\uff57\u970b\u41c7\u2eeb\u575b\uf24e\u2cce\u7925\ufeee\u9638\u40c1\u2ff0\u57b5\ued4d\u3363\u6661\ue18d\u8950\u5f2b\u3065"};
        __rP__gH4it2 = new String[]{"\u699a\ucf2d\u11a1", "\u698f\ucf38\u11a8\u447c\uc31f"};
        __rP__gH4it3 = new String[]{"\u6958\ucf06\u1195\u449e\uc308\uabe8\u7db3\u1213", "\u698c\ucf3b\u11ab\u4468\uc376\uab11\u7d5b\u1280\u6aa0\ucfcd\u1083\u456c\uc238\uaafb\u7c41\u13b3\u6b9c\ucee7\u17a6\u4250", "\u698a\ucf25\u11a8\u447d\uc316\uab75\u7d3f"};
        byte[] v0 = "n~f\u00d6\u00c3\u00c2\u00dc\u00d1\u00bf'\u001d\u0018\u00ddm\u0097\u00cc\u00d9T\u00fd\u00c4p\u008d(Uxm\u00f5\u00041\u00fdjdrS\u00ec\u00d1`nu\u00bd\u00f8\u00f9\u00d6\u001d\u0090%\t^\u0016\u0010\u009a\u0099\u00ba\u00c3\r\u009e+n\u00e68\u00a9v\u0088\u00b1\u00d2n\u00e4\u000f\u00cf\u00b3b\u001a!t\nT\u00ef_5\u00c5\u00fb\u00e6#m\b\u00bf\u00d0\u0011\u00c6\u0015H\u009f\u00d0\u00a8\u00aa\u00bc\u00f0*Gz+\u00ebl\u0003xl\u00b7;-\u0091#\u00a5:\u00a6\u00ea\u00a1b\u0099]\u00c2G\u0084f\u0097\u0017u\u009fx\u00e3Y\u00d1\u00a5f9\u001e\u00bey\u00ba\u00cd\u0013\u008b\u000b\u00e6\u00d3\u00db$p7\\v\u00daOl\u00ed\u00dd6\u00909\u00f4\u009a\u0013\u0010\u0002\u00d1\u00b0\u00b0?\u0097\u00c4\u00ad>\r\u0096\u001f\u0015\u00fd\u0010g>\u00eb\u00d0\u009e\u0096\b\u001f\u00ac\u0012\u00a3\u0089\u00ba\u00ab\u00d2\u00ac\u009dH\u0096\u0098~\u00a0|\u00dd\u000fy1\u0006Y\u000f6\u00ab_\u0086\u00fa\u00db=\u00e5\u00f7\u0006\u00b0\u008b\u00ab\u0086\u0085\u00b9/\u008c\u00e9\u00b5\u009bo?]_z,\u0004\u00a7\u00e3\u00d9O\u0004[\u0092\u0088\u00c3\u008ap\u00b7ls\u0010VB;K\u00b9\u007fe+\u0083>\u00a0\u001b+\u00d2".getBytes("ISO_8859_1");
        Object[] v1 = "\u008abs\u00c7'\u00a1\u00bd\u00aa".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1622533974;
                case 1 -> 1675659962;
                case 2 -> 128136097;
                case 3 -> 574141569;
                case 4 -> 388074395;
                case 5 -> -337988653;
                case 6 -> -424702887;
                case 7 -> 415973362;
                case 8 -> 1188281970;
                case 9 -> -1181445092;
                case 10 -> -1022459886;
                case 11 -> -1457671328;
                case 12 -> -1771915011;
                case 13 -> 1261789062;
                case 14 -> 1853032046;
                case 15 -> 1584207845;
                case 16 -> -1043853938;
                case 17 -> -2077307849;
                case 18 -> 492924357;
                case 19 -> -1469055355;
                case 20 -> 464966743;
                case 21 -> -1078578168;
                case 22 -> -222665991;
                case 23 -> 1841060767;
                case 24 -> -181761789;
                case 25 -> -2041317549;
                case 26 -> -946709491;
                case 27 -> 415614118;
                case 28 -> 345875900;
                case 29 -> -127547866;
                case 30 -> 67509672;
                case 31 -> -1845362036;
                case 32 -> -540856373;
                case 33 -> -200810304;
                case 34 -> 1705192320;
                case 35 -> -733285943;
                case 36 -> 378459582;
                case 37 -> 1537501086;
                case 38 -> -2012912793;
                case 39 -> -1703800296;
                case 40 -> 554386249;
                case 41 -> -1700315157;
                case 42 -> 1253640866;
                case 43 -> -1351917572;
                case 44 -> 590791441;
                case 45 -> 986200390;
                case 46 -> -964494700;
                case 47 -> 582627666;
                case 48 -> -1223004985;
                case 49 -> -1522240846;
                case 50 -> 1378280637;
                case 51 -> -1843113279;
                case 52 -> 1171283209;
                case 53 -> -746908438;
                case 54 -> 635283839;
                case 55 -> -1118008242;
                case 56 -> 812765665;
                case 57 -> -118420991;
                case 58 -> -349415769;
                case 59 -> 563562523;
                case 60 -> 170789789;
                case 61 -> 151139165;
                case 62 -> 116277123;
                case 63 -> -1357835670;
                case 64 -> 156718546;
                case 65 -> 1270753476;
                case 66 -> -1553253051;
                case 67 -> 582490211;
                case 68 -> 239316853;
                case 69 -> 450476598;
                case 70 -> -1971511290;
                case 71 -> -676924080;
                case 72 -> 1890768160;
                case 73 -> -394420086;
                case 74 -> 978699487;
                case 75 -> 1076911807;
                case 76 -> 2000925308;
                case 77 -> 558761823;
                case 78 -> 1823041044;
                case 79 -> -1172274154;
                case 80 -> 2090828207;
                case 81 -> -2003961054;
                case 82 -> -1911088886;
                case 83 -> 1188183145;
                case 84 -> 1671502786;
                case 85 -> -1006839847;
                case 86 -> -1931242248;
                case 87 -> 1392725619;
                case 88 -> -350012125;
                case 89 -> -868532885;
                case 90 -> -2135384656;
                case 91 -> 1026844484;
                case 92 -> -1953971750;
                case 93 -> 1902655149;
                case 94 -> 727569240;
                case 95 -> -1860788703;
                case 96 -> -406972117;
                case 97 -> -1585544466;
                case 98 -> 1250274396;
                case 99 -> -195983567;
                case 100 -> 564365055;
                case 101 -> 1510294005;
                case 102 -> 1595131575;
                case 103 -> -771080752;
                case 104 -> -222047397;
                case 105 -> 1478911951;
                case 106 -> -1930428772;
                case 107 -> -800791541;
                case 108 -> -1372348236;
                case 109 -> -1804551603;
                case 110 -> -909383715;
                case 111 -> -1178629873;
                case 112 -> -206475828;
                case 113 -> 967984374;
                case 114 -> -545880610;
                case 115 -> -1853987459;
                case 116 -> 249495011;
                case 117 -> 464743440;
                case 118 -> 431257621;
                case 119 -> 405724757;
                case 120 -> -1276064175;
                case 121 -> 980039880;
                case 122 -> 2119233195;
                case 123 -> -670572884;
                case 124 -> -38230112;
                case 125 -> -876586436;
                case 126 -> 2055080313;
                case 127 -> 1461930266;
                case 128 -> 2075950653;
                case 129 -> -1065482788;
                case 130 -> 954311500;
                case 131 -> -206196493;
                case 132 -> -2107947094;
                case 133 -> 462865205;
                case 134 -> -1307213799;
                case 135 -> 373723802;
                case 136 -> 1326801590;
                case 137 -> -1925925574;
                case 138 -> -1137678192;
                case 139 -> 1432139604;
                case 140 -> 2015801294;
                case 141 -> 397539274;
                case 142 -> 1197456968;
                case 143 -> 825724751;
                case 144 -> 1425839482;
                case 145 -> -1955128465;
                case 146 -> -605060799;
                case 147 -> -1637382277;
                case 148 -> -453872408;
                case 149 -> 179369129;
                case 150 -> -1147612643;
                case 151 -> 1755631109;
                case 152 -> 1197690106;
                case 153 -> -1505814398;
                case 154 -> -1966248656;
                case 155 -> -580583948;
                case 156 -> 868720474;
                case 157 -> 1432346154;
                case 158 -> -1858554761;
                case 159 -> 1285917196;
                case 160 -> 1719847736;
                case 161 -> -793396690;
                case 162 -> -921359208;
                case 163 -> -9823850;
                case 164 -> -2022479507;
                case 165 -> 848117348;
                case 166 -> -1786799635;
                case 167 -> -741674777;
                case 168 -> 1317956056;
                case 169 -> 420094760;
                case 170 -> -287369340;
                case 171 -> -547278061;
                case 172 -> 1090847246;
                case 173 -> -2041243853;
                case 174 -> -1542728730;
                case 175 -> 1067693662;
                case 176 -> 988914292;
                case 177 -> -162839229;
                case 178 -> 1565805713;
                case 179 -> -1516211088;
                case 180 -> -2037877351;
                case 181 -> 1674298690;
                case 182 -> -434421513;
                case 183 -> -1934883326;
                case 184 -> -1232322486;
                case 185 -> 13528651;
                case 186 -> -792288299;
                case 187 -> 1533127096;
                case 188 -> 244355109;
                case 189 -> -1489848903;
                case 190 -> 1633308137;
                case 191 -> -1327256066;
                case 192 -> 1956547647;
                case 193 -> -336814284;
                case 194 -> 1134508434;
                case 195 -> -1359651976;
                case 196 -> -1251876558;
                case 197 -> -568270397;
                case 198 -> -2073918300;
                case 199 -> 1501865952;
                case 200 -> 307729709;
                case 201 -> -417285831;
                case 202 -> -1872394639;
                case 203 -> -422885824;
                case 204 -> 1758511943;
                case 205 -> -1169610910;
                case 206 -> 1095413719;
                case 207 -> -1382812412;
                case 208 -> -852000225;
                case 209 -> -2083489439;
                case 210 -> -949942137;
                case 211 -> -357953615;
                case 212 -> -937132919;
                case 213 -> 1992846285;
                case 214 -> 820675899;
                case 215 -> -666452088;
                case 216 -> -826803729;
                case 217 -> -599114395;
                case 218 -> 2056747806;
                case 219 -> 464542638;
                case 220 -> 1838245334;
                case 221 -> -349862108;
                case 222 -> 733212657;
                case 223 -> -1015688898;
                case 224 -> -1980985297;
                case 225 -> -4086402;
                case 226 -> 422157863;
                case 227 -> 1828267411;
                case 228 -> 924593627;
                case 229 -> -2106781557;
                case 230 -> -1086073577;
                case 231 -> 2006539760;
                case 232 -> -871540794;
                case 233 -> -1772816276;
                case 234 -> -783248794;
                case 235 -> -805473580;
                case 236 -> 217587635;
                case 237 -> -267196019;
                case 238 -> -368279301;
                case 239 -> 201790215;
                case 240 -> -1927452779;
                case 241 -> 1197826959;
                case 242 -> 1451081141;
                case 243 -> -1861398341;
                case 244 -> -1817017088;
                case 245 -> 1199809250;
                case 246 -> -1866757844;
                case 247 -> -278099817;
                case 248 -> 1109362806;
                case 249 -> -1412693975;
                case 250 -> 1465861283;
                case 251 -> -1317396244;
                case 252 -> -256045596;
                case 253 -> 244297425;
                case 254 -> 859659429;
                case 255 -> -1782584728;
                default -> 1854597798;
            });
        } while (v2 != 264);
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
            Object[] objectArray = new Object[10];
            v1 = objectArray;
            Oo0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = new HashMap();
        HelpCommand = new HashMap();
        OOo = new HashMap();
        GuiSupport_OOI = new HashMap();
        OOi = new HashMap();
        HudElement = new HashMap();
        EventBusApi = new HashMap();
        O0o = new HashMap();
        ConfigSupport_O0I = new HashMap();
        O0i = new HashMap();
    }

    public static FontRenderer GuiSupport_OOI(int param02) {
        return HelpCommand.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/font1-bold.ttf"), (int)param0));
    }

    public static FontRenderer O0o(int param02) {
        return HudElement.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/iconsnur.ttf"), (int)param0));
    }

    public static FontRenderer OoO(int param02) {
        return ConfigSupport_O0I.computeIfAbsent(param02, param0 -> new FontRenderer(Identifier.of((String)"clap:font/harmony.ttf"), (int)param0));
    }
}

