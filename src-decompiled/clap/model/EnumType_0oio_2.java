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
 * Renamed from clap.network.NetworkSupport_0oio_1
 */
public final class EnumType_0oio_2
extends Enum {
    public static final /* enum */ EnumType_0oio_2 O0Oi;
    public static final /* enum */ EnumType_0oio_2 AntiBotModule;
    private static final /* synthetic */ EnumType_0oio_2[] GuiSupport_O000;
    static Object O00o;

    public static EnumType_0oio_2[] values() {
        return (EnumType_0oio_2[])GuiSupport_O000.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0oio_2() {
        void param2;
        void param1;
    }

    public static EnumType_0oio_2 valueOf(String param0) {
        return Enum.valueOf(EnumType_0oio_2.class, param0);
    }

    static {
        byte[] v0 = "\u00fd\u00d1\n\u00fd,\u0085\u001c0\u00b9\nu\u00c0\u00ddT\u00ab\u001d\u00ba\u00a4\u0016\u0001\u00bd}L\u00a7\u0013R\u00c3O\u0011\u00e2\u0081\u00bc\u0014\u00d3\u000eV\u009caeB\u00f6\u0090\u00ac56\u00d3\u0088\u00e4\u00c3p\u00c9\u00d1\u00e0\u00cc\u0006\u00df\u0081\u0086\u00easM\u00ee\u0095\u00ce".getBytes("ISO_8859_1");
        Object[] v1 = "\u00a7pY\u00da\u009a\u00b3\u00c2$".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1187957594;
                case 1 -> 1832280489;
                case 2 -> -1056601225;
                case 3 -> -449908123;
                case 4 -> -835547979;
                case 5 -> -225026009;
                case 6 -> 1689989480;
                case 7 -> 1661911385;
                case 8 -> 415375512;
                case 9 -> -229732160;
                case 10 -> -1634121271;
                case 11 -> -962110648;
                case 12 -> 1122037383;
                case 13 -> -1878533219;
                case 14 -> -915292534;
                case 15 -> -2082157280;
                case 16 -> -827957585;
                case 17 -> 1257606859;
                case 18 -> -2000326393;
                case 19 -> -1067467965;
                case 20 -> 1671238902;
                case 21 -> 666219434;
                case 22 -> 600244517;
                case 23 -> 227033890;
                case 24 -> 175437763;
                case 25 -> 1585677449;
                case 26 -> 1827146094;
                case 27 -> -1256450986;
                case 28 -> -1381258877;
                case 29 -> -773544049;
                case 30 -> -1956367160;
                case 31 -> -1538780754;
                case 32 -> -301065140;
                case 33 -> -1522381859;
                case 34 -> 461433974;
                case 35 -> -1124589865;
                case 36 -> -854915788;
                case 37 -> 1651203457;
                case 38 -> 577735737;
                case 39 -> 2011042663;
                case 40 -> 905398044;
                case 41 -> -1190305514;
                case 42 -> 1596673574;
                case 43 -> 1726142375;
                case 44 -> -1209879190;
                case 45 -> 1208330647;
                case 46 -> 562784274;
                case 47 -> -851236598;
                case 48 -> 212642071;
                case 49 -> 1447361515;
                case 50 -> 1196756403;
                case 51 -> 1254859285;
                case 52 -> 1827493280;
                case 53 -> 1947983774;
                case 54 -> -2086647876;
                case 55 -> -2000822045;
                case 56 -> 1413604698;
                case 57 -> -1100603399;
                case 58 -> 312333673;
                case 59 -> 455277718;
                case 60 -> -1143557882;
                case 61 -> -1083164118;
                case 62 -> 1375442144;
                case 63 -> -286413836;
                case 64 -> 49030747;
                case 65 -> -2049322305;
                case 66 -> -133688973;
                case 67 -> -695158913;
                case 68 -> -1547158514;
                case 69 -> -1671147327;
                case 70 -> 1485653120;
                case 71 -> 701802815;
                case 72 -> 1750038369;
                case 73 -> -1228058004;
                case 74 -> 157658601;
                case 75 -> 889311207;
                case 76 -> 1637735903;
                case 77 -> -1949789396;
                case 78 -> 2035169616;
                case 79 -> -48102700;
                case 80 -> 1386836511;
                case 81 -> -618306312;
                case 82 -> -1934971403;
                case 83 -> -311441149;
                case 84 -> 1014824444;
                case 85 -> -1251481010;
                case 86 -> -317094577;
                case 87 -> 2067712709;
                case 88 -> 338903751;
                case 89 -> -270617976;
                case 90 -> 1963952495;
                case 91 -> -66871173;
                case 92 -> 2093478625;
                case 93 -> 968971566;
                case 94 -> 2139254598;
                case 95 -> 2061467393;
                case 96 -> 1515516080;
                case 97 -> 2087531827;
                case 98 -> 405628011;
                case 99 -> -1569305550;
                case 100 -> -1096304710;
                case 101 -> 1319214341;
                case 102 -> 980504045;
                case 103 -> 52170226;
                case 104 -> -1585184834;
                case 105 -> 149730259;
                case 106 -> -696381705;
                case 107 -> 1993395946;
                case 108 -> -22680098;
                case 109 -> -57729381;
                case 110 -> 93402204;
                case 111 -> -498046464;
                case 112 -> -773365727;
                case 113 -> -164345183;
                case 114 -> 837407798;
                case 115 -> 1995297264;
                case 116 -> 1410414648;
                case 117 -> 1597610628;
                case 118 -> 1960340878;
                case 119 -> 709344130;
                case 120 -> 974825752;
                case 121 -> 1260326709;
                case 122 -> -1202903588;
                case 123 -> -1050747666;
                case 124 -> 1243996229;
                case 125 -> -1621091557;
                case 126 -> 1622524057;
                case 127 -> 1517555767;
                case 128 -> -1364547078;
                case 129 -> 1654372397;
                case 130 -> 991954381;
                case 131 -> 1184305745;
                case 132 -> 775211947;
                case 133 -> 2027875244;
                case 134 -> -374566119;
                case 135 -> -1758155891;
                case 136 -> 237324433;
                case 137 -> -2041226801;
                case 138 -> 145312951;
                case 139 -> 2138931249;
                case 140 -> 1984086803;
                case 141 -> 64459536;
                case 142 -> 946458744;
                case 143 -> 1802294861;
                case 144 -> -891900252;
                case 145 -> 1778856532;
                case 146 -> 1046985837;
                case 147 -> -121044366;
                case 148 -> -1730541225;
                case 149 -> -1541080710;
                case 150 -> -1566859203;
                case 151 -> 938299944;
                case 152 -> 1687013731;
                case 153 -> 734890969;
                case 154 -> -677715648;
                case 155 -> 1288155096;
                case 156 -> 1275609357;
                case 157 -> 1988983308;
                case 158 -> -602539774;
                case 159 -> -1569569098;
                case 160 -> -301852643;
                case 161 -> -167403461;
                case 162 -> -837433392;
                case 163 -> -143401072;
                case 164 -> 650290605;
                case 165 -> 1332028760;
                case 166 -> -2096238005;
                case 167 -> 204985227;
                case 168 -> -759903900;
                case 169 -> -1618043924;
                case 170 -> 2126870576;
                case 171 -> 1257813252;
                case 172 -> 220892463;
                case 173 -> 1653735061;
                case 174 -> -1518995766;
                case 175 -> 1449599461;
                case 176 -> 325528529;
                case 177 -> -1350720221;
                case 178 -> -2037034414;
                case 179 -> -1391966993;
                case 180 -> -1519631319;
                case 181 -> -115059727;
                case 182 -> -725305219;
                case 183 -> 14553277;
                case 184 -> 411068370;
                case 185 -> -107544174;
                case 186 -> 2006656798;
                case 187 -> 799358434;
                case 188 -> 1345466208;
                case 189 -> 754261364;
                case 190 -> -55509580;
                case 191 -> -32281327;
                case 192 -> 184325288;
                case 193 -> -1591854945;
                case 194 -> 431305328;
                case 195 -> -1975373214;
                case 196 -> -991541822;
                case 197 -> 2130475900;
                case 198 -> 2024553868;
                case 199 -> 1830402654;
                case 200 -> 1572803268;
                case 201 -> -1345366797;
                case 202 -> 1694750694;
                case 203 -> 1918395403;
                case 204 -> 2134626824;
                case 205 -> 1095905107;
                case 206 -> -752482356;
                case 207 -> -922580918;
                case 208 -> -765314307;
                case 209 -> -1760350369;
                case 210 -> 132724627;
                case 211 -> 1423451899;
                case 212 -> -1598319384;
                case 213 -> 973748613;
                case 214 -> 820133396;
                case 215 -> 52715226;
                case 216 -> -841065719;
                case 217 -> -507457707;
                case 218 -> 360223870;
                case 219 -> 2081737727;
                case 220 -> -968091326;
                case 221 -> -1738573390;
                case 222 -> -1444141383;
                case 223 -> 1812280380;
                case 224 -> 1117916228;
                case 225 -> 352178297;
                case 226 -> 1820295025;
                case 227 -> -1072813963;
                case 228 -> -1762624476;
                case 229 -> 1373528090;
                case 230 -> -1192216322;
                case 231 -> 1156282530;
                case 232 -> -822754127;
                case 233 -> 1058006287;
                case 234 -> -2104303653;
                case 235 -> -113662627;
                case 236 -> 2117560732;
                case 237 -> 1099020948;
                case 238 -> 2030490808;
                case 239 -> 1381477163;
                case 240 -> -272313691;
                case 241 -> -80649778;
                case 242 -> -2117484226;
                case 243 -> -1876108586;
                case 244 -> 437548359;
                case 245 -> -286031302;
                case 246 -> -1590053419;
                case 247 -> -840399738;
                case 248 -> 1361416646;
                case 249 -> -1044720221;
                case 250 -> 319814465;
                case 251 -> -1362377399;
                case 252 -> 1629339750;
                case 253 -> -1201421637;
                case 254 -> 206454938;
                case 255 -> -1536446748;
                default -> 1463484146;
            });
        } while (v2 != 64);
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
            O00o = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        O0Oi = new EnumType_0oio_2("TOGGLE_MODULE", 0);
        AntiBotModule = new EnumType_0oio_2("SETTING_UPDATE", 1);
        GuiSupport_O000 = EnumType_0oio_2.DataRecord_00I();
    }

    private static /* synthetic */ EnumType_0oio_2[] DataRecord_00I() {
        return new EnumType_0oio_2[]{O0Oi, AntiBotModule};
    }
}

