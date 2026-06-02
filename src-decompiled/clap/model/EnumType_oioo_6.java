/*
 * Decompiled with CFR 0.152.
 */
package clap.model;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.Oioo
 */
public final class EnumType_oioo_6
extends Enum {
    public static final /* enum */ EnumType_oioo_6 NetworkSupport_OO00;
    public static final /* enum */ EnumType_oioo_6 OO0o;
    private static final /* synthetic */ EnumType_oioo_6[] FontRenderer;
    static Object OO0i;

    public static EnumType_oioo_6[] values() {
        return (EnumType_oioo_6[])FontRenderer.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oioo_6() {
        void param2;
        void param1;
    }

    public static EnumType_oioo_6 valueOf(String param0) {
        return Enum.valueOf(EnumType_oioo_6.class, param0);
    }

    static {
        byte[] v0 = "\u00bc0+\u00ac\t\u00be\u0088\u0003\u00b6S\u001e\u0018\u00ca<a\u0003\u0000\u0092!\u0013X\u0086\u00c9$P\u0005\u00e7-+6c1\u0004\br#BR\u00c7l\u00bc\u00147\u00b6\u0010\u001a\u0002\"".getBytes("ISO_8859_1");
        Object[] v1 = "\u0083\u001b.~\u0018ju\u00ed".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -936590770;
                case 1 -> -2024646139;
                case 2 -> -1033653622;
                case 3 -> 2108993851;
                case 4 -> -1814876675;
                case 5 -> 1095079742;
                case 6 -> 979583137;
                case 7 -> 136602805;
                case 8 -> 1877280289;
                case 9 -> -659847471;
                case 10 -> -1067832995;
                case 11 -> 1040510569;
                case 12 -> 2063029691;
                case 13 -> -1638904602;
                case 14 -> -1031265282;
                case 15 -> 951687762;
                case 16 -> 284512580;
                case 17 -> -387954677;
                case 18 -> 871571481;
                case 19 -> 1708547726;
                case 20 -> -794426492;
                case 21 -> 1216081231;
                case 22 -> 2011465511;
                case 23 -> -283567798;
                case 24 -> -776145790;
                case 25 -> -1107196704;
                case 26 -> 488439168;
                case 27 -> -630518307;
                case 28 -> 1720565866;
                case 29 -> -1750467315;
                case 30 -> 869055320;
                case 31 -> -804035849;
                case 32 -> -1113347474;
                case 33 -> -1163499422;
                case 34 -> -674653540;
                case 35 -> -1267864038;
                case 36 -> -1845793291;
                case 37 -> -1337995752;
                case 38 -> 173757874;
                case 39 -> 570923271;
                case 40 -> 363791600;
                case 41 -> 215184697;
                case 42 -> 1871290836;
                case 43 -> 1932786587;
                case 44 -> 2009601274;
                case 45 -> 1143066639;
                case 46 -> 694103737;
                case 47 -> 1967534286;
                case 48 -> -68736549;
                case 49 -> -922313350;
                case 50 -> 1263510614;
                case 51 -> 1037100288;
                case 52 -> 247140852;
                case 53 -> 1125448581;
                case 54 -> 404630057;
                case 55 -> 2045780158;
                case 56 -> 639951789;
                case 57 -> -1963297817;
                case 58 -> 8722787;
                case 59 -> 585192424;
                case 60 -> 1956285534;
                case 61 -> 456671947;
                case 62 -> -1346971851;
                case 63 -> -531321673;
                case 64 -> 2116222355;
                case 65 -> 1441947920;
                case 66 -> 400233776;
                case 67 -> -1037257057;
                case 68 -> -1083950384;
                case 69 -> -829942732;
                case 70 -> -1825910306;
                case 71 -> -15744531;
                case 72 -> -1242762052;
                case 73 -> 379714448;
                case 74 -> -1316952939;
                case 75 -> 1300277053;
                case 76 -> 1768453419;
                case 77 -> 245233354;
                case 78 -> 89915668;
                case 79 -> 1617615272;
                case 80 -> -519769074;
                case 81 -> -1727965629;
                case 82 -> 1101686598;
                case 83 -> 1483200562;
                case 84 -> -733895057;
                case 85 -> -1004658057;
                case 86 -> -1165580203;
                case 87 -> 1187149802;
                case 88 -> 333129347;
                case 89 -> -56592282;
                case 90 -> 294669483;
                case 91 -> -2137090815;
                case 92 -> 602011596;
                case 93 -> -477805918;
                case 94 -> -1442695611;
                case 95 -> -1376638071;
                case 96 -> -462401747;
                case 97 -> -1303652996;
                case 98 -> -866907786;
                case 99 -> -1821977780;
                case 100 -> -533635944;
                case 101 -> 893923055;
                case 102 -> -195889069;
                case 103 -> 1309224784;
                case 104 -> 1748877052;
                case 105 -> -703342574;
                case 106 -> 577877987;
                case 107 -> 1981666294;
                case 108 -> 1626728486;
                case 109 -> -1015561401;
                case 110 -> -1462333922;
                case 111 -> -1446408115;
                case 112 -> -188969437;
                case 113 -> 1225359975;
                case 114 -> 2041162783;
                case 115 -> -1028304531;
                case 116 -> 83916027;
                case 117 -> -212153894;
                case 118 -> -1785381468;
                case 119 -> 1102307754;
                case 120 -> 2032545051;
                case 121 -> 1178736604;
                case 122 -> -1299450532;
                case 123 -> -1158527599;
                case 124 -> -1697146618;
                case 125 -> -307239366;
                case 126 -> 1392640637;
                case 127 -> -1700689441;
                case 128 -> -1052228524;
                case 129 -> 1324603606;
                case 130 -> 1208980577;
                case 131 -> -275566313;
                case 132 -> 777711423;
                case 133 -> -594959105;
                case 134 -> 1823703033;
                case 135 -> -449865382;
                case 136 -> 1384504811;
                case 137 -> 834523708;
                case 138 -> 1893700681;
                case 139 -> -1161820792;
                case 140 -> -1541886880;
                case 141 -> -1309244971;
                case 142 -> -547375015;
                case 143 -> -1183042687;
                case 144 -> -580917816;
                case 145 -> -1586710115;
                case 146 -> 1967647040;
                case 147 -> 2003144746;
                case 148 -> 676299497;
                case 149 -> -1629021736;
                case 150 -> 597990068;
                case 151 -> -1996978129;
                case 152 -> 1864302193;
                case 153 -> 1204737582;
                case 154 -> 535570828;
                case 155 -> 828275950;
                case 156 -> 2094456205;
                case 157 -> 503601535;
                case 158 -> -1536730961;
                case 159 -> 508647806;
                case 160 -> -1468491850;
                case 161 -> -2123824671;
                case 162 -> 179439113;
                case 163 -> 1686888808;
                case 164 -> -1637390878;
                case 165 -> 2053620315;
                case 166 -> -824929685;
                case 167 -> -1045424356;
                case 168 -> 1061772996;
                case 169 -> -148983341;
                case 170 -> -1937135755;
                case 171 -> 1128229059;
                case 172 -> 251516870;
                case 173 -> 107461932;
                case 174 -> -515156317;
                case 175 -> 1574339874;
                case 176 -> -88145848;
                case 177 -> 455021804;
                case 178 -> 939378700;
                case 179 -> -426182847;
                case 180 -> 1347561836;
                case 181 -> -890633779;
                case 182 -> 1035789210;
                case 183 -> 1356264759;
                case 184 -> 713765463;
                case 185 -> 648626178;
                case 186 -> 766880778;
                case 187 -> -1111886236;
                case 188 -> -1097006377;
                case 189 -> 1408109506;
                case 190 -> 0x4B4B494B;
                case 191 -> 1768623792;
                case 192 -> 1392121585;
                case 193 -> -1770426986;
                case 194 -> 22209193;
                case 195 -> -1963976205;
                case 196 -> 153452821;
                case 197 -> 1665243400;
                case 198 -> -500117275;
                case 199 -> -265607259;
                case 200 -> 1761994591;
                case 201 -> 1274102301;
                case 202 -> -1839934862;
                case 203 -> 1077528854;
                case 204 -> -78556206;
                case 205 -> -1097774965;
                case 206 -> -734383055;
                case 207 -> -2111296667;
                case 208 -> -2101218253;
                case 209 -> 1766666400;
                case 210 -> 99362802;
                case 211 -> 382078631;
                case 212 -> 640751670;
                case 213 -> 38220837;
                case 214 -> 1667084912;
                case 215 -> -257288111;
                case 216 -> 1370944959;
                case 217 -> -1216814044;
                case 218 -> 31980716;
                case 219 -> 1330778643;
                case 220 -> 1069751444;
                case 221 -> 1592372595;
                case 222 -> 1597561979;
                case 223 -> 1343553795;
                case 224 -> 369795974;
                case 225 -> -464209036;
                case 226 -> 1680269513;
                case 227 -> 595997363;
                case 228 -> -1167696738;
                case 229 -> 1793850561;
                case 230 -> 830425817;
                case 231 -> -566842760;
                case 232 -> -91444078;
                case 233 -> 813585861;
                case 234 -> -181032262;
                case 235 -> -1833657560;
                case 236 -> 741858488;
                case 237 -> -1088211026;
                case 238 -> 1487147537;
                case 239 -> 1853797112;
                case 240 -> -217911642;
                case 241 -> 871247928;
                case 242 -> 399549;
                case 243 -> -560234430;
                case 244 -> -1688972905;
                case 245 -> -397334780;
                case 246 -> -1354231175;
                case 247 -> -1729935695;
                case 248 -> 1196361607;
                case 249 -> 956060871;
                case 250 -> 1273448420;
                case 251 -> -1089677671;
                case 252 -> -1455942976;
                case 253 -> 1417099407;
                case 254 -> 1714883279;
                case 255 -> -25924064;
                default -> -280546402;
            });
        } while (v2 != 48);
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
            OO0i = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        NetworkSupport_OO00 = new EnumType_oioo_6("Snap", 0);
        OO0o = new EnumType_oioo_6("Smooth", 1);
        FontRenderer = EnumType_oioo_6.EnumType_0OI();
    }

    private static /* synthetic */ EnumType_oioo_6[] EnumType_0OI() {
        return new EnumType_oioo_6[]{NetworkSupport_OO00, OO0o};
    }
}

