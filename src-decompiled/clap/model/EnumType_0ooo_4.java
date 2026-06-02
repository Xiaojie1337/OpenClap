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
 * Renamed from psx.Hyk.0oOo
 */
public final class EnumType_0ooo_4
extends Enum {
    public static final /* enum */ EnumType_0ooo_4 O0Ii;
    private static final /* synthetic */ EnumType_0ooo_4[] O0i0;
    public static final /* enum */ EnumType_0ooo_4 EnumType_O0II;
    public static final /* enum */ EnumType_0ooo_4 O0iO;
    static Object CriticalsModule;

    public static EnumType_0ooo_4[] values() {
        return (EnumType_0ooo_4[])O0i0.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0ooo_4() {
        void param2;
        void param1;
    }

    public static EnumType_0ooo_4 valueOf(String param0) {
        return Enum.valueOf(EnumType_0ooo_4.class, param0);
    }

    static {
        byte[] v0 = "\u00a0\u00bb\u0094\u00c6\u0011\u00fd&\u00a7Y\u00c08L\u008aX\u0010\u008e\u000b_\u0087c\u0016\u001d\u00dbk{6\u00bc\u009aF\u00e5lz\u00be\u00dd\u0093zd>c\u00d1\u009f\u0090\u001b4\u00a3:w1\u00c03\u00a2\u00acQ\u000b\u00e1\u00ee".getBytes("ISO_8859_1");
        Object[] v1 = "s\u00db{\u00c1\u0013\u00af\u001a\u00c4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1450302633;
                case 1 -> 2141889706;
                case 2 -> -975665713;
                case 3 -> -1002257583;
                case 4 -> 533142486;
                case 5 -> -756242092;
                case 6 -> -1089802849;
                case 7 -> -1343667289;
                case 8 -> -1236148382;
                case 9 -> -1807500882;
                case 10 -> 50000211;
                case 11 -> -1670513818;
                case 12 -> -1785110680;
                case 13 -> 949870143;
                case 14 -> 1682498212;
                case 15 -> -1194212435;
                case 16 -> -1486775913;
                case 17 -> -1132417736;
                case 18 -> -748680948;
                case 19 -> -771715557;
                case 20 -> 1414915932;
                case 21 -> -187722741;
                case 22 -> 936520836;
                case 23 -> 1317277231;
                case 24 -> -218119662;
                case 25 -> 220775880;
                case 26 -> 142739666;
                case 27 -> -144713994;
                case 28 -> 1740368480;
                case 29 -> -1026049743;
                case 30 -> -2073903864;
                case 31 -> -1439630195;
                case 32 -> -893353223;
                case 33 -> 1742176035;
                case 34 -> 697056327;
                case 35 -> -273111430;
                case 36 -> -915742716;
                case 37 -> -1169273024;
                case 38 -> 1640180174;
                case 39 -> 748287714;
                case 40 -> -835446968;
                case 41 -> 1972307286;
                case 42 -> 1150601315;
                case 43 -> 1569278642;
                case 44 -> -1558742835;
                case 45 -> 2034536128;
                case 46 -> -1643254649;
                case 47 -> -978071172;
                case 48 -> -1658414778;
                case 49 -> -180982467;
                case 50 -> 404615699;
                case 51 -> -1291597810;
                case 52 -> -1850041475;
                case 53 -> 592759588;
                case 54 -> -769309425;
                case 55 -> 559349904;
                case 56 -> 107659457;
                case 57 -> 1638781285;
                case 58 -> -532610201;
                case 59 -> 151156358;
                case 60 -> -1460894740;
                case 61 -> -1982516415;
                case 62 -> 14393750;
                case 63 -> 257364513;
                case 64 -> 327272435;
                case 65 -> -27120572;
                case 66 -> 1562689269;
                case 67 -> -24582679;
                case 68 -> -371336404;
                case 69 -> 1354192225;
                case 70 -> -829388040;
                case 71 -> 1318813143;
                case 72 -> 699552235;
                case 73 -> -1937043387;
                case 74 -> -90089805;
                case 75 -> 1745556521;
                case 76 -> 497088736;
                case 77 -> 182353034;
                case 78 -> -1790690028;
                case 79 -> 2081670021;
                case 80 -> 962620750;
                case 81 -> 1182541061;
                case 82 -> 1530136849;
                case 83 -> -2097874916;
                case 84 -> -2034951311;
                case 85 -> 402054466;
                case 86 -> 1466152482;
                case 87 -> 1738594334;
                case 88 -> 2092473832;
                case 89 -> 1102348765;
                case 90 -> -358336393;
                case 91 -> -1221833215;
                case 92 -> -1442461392;
                case 93 -> -2062053641;
                case 94 -> -640720442;
                case 95 -> 2051926061;
                case 96 -> -1761610334;
                case 97 -> 60147059;
                case 98 -> -2030298072;
                case 99 -> -1383674942;
                case 100 -> -2083510056;
                case 101 -> 1354321846;
                case 102 -> -69316903;
                case 103 -> 712139487;
                case 104 -> -31766676;
                case 105 -> -403894014;
                case 106 -> -1061746600;
                case 107 -> -1485927984;
                case 108 -> -652182100;
                case 109 -> 969681536;
                case 110 -> -1168115120;
                case 111 -> -1281927225;
                case 112 -> 2015322543;
                case 113 -> -206058966;
                case 114 -> -1387842528;
                case 115 -> -1859202297;
                case 116 -> -86398994;
                case 117 -> -1326064956;
                case 118 -> 685681794;
                case 119 -> 1765419448;
                case 120 -> 519853374;
                case 121 -> -775018659;
                case 122 -> -917167255;
                case 123 -> 1034106953;
                case 124 -> 997768689;
                case 125 -> -1706884053;
                case 126 -> 312759628;
                case 127 -> 80119753;
                case 128 -> -862594404;
                case 129 -> 39687995;
                case 130 -> -228946150;
                case 131 -> -1757219216;
                case 132 -> -1928942738;
                case 133 -> 1289045665;
                case 134 -> -482078287;
                case 135 -> 1080148245;
                case 136 -> 165329227;
                case 137 -> -1185090505;
                case 138 -> 293268865;
                case 139 -> 1472375830;
                case 140 -> 954853997;
                case 141 -> -1520955979;
                case 142 -> -324391694;
                case 143 -> -379494361;
                case 144 -> -1683143671;
                case 145 -> -2090564773;
                case 146 -> -1413776221;
                case 147 -> 80110147;
                case 148 -> 1737114602;
                case 149 -> 256263035;
                case 150 -> 519354212;
                case 151 -> 1451694723;
                case 152 -> -1867585286;
                case 153 -> -1953249476;
                case 154 -> 771548897;
                case 155 -> -2057445107;
                case 156 -> 972596881;
                case 157 -> 541771492;
                case 158 -> -862537836;
                case 159 -> -681833275;
                case 160 -> 1128319216;
                case 161 -> 1215243934;
                case 162 -> 1968730122;
                case 163 -> -1589290822;
                case 164 -> -1945302198;
                case 165 -> -1069172797;
                case 166 -> 596105759;
                case 167 -> 1128614885;
                case 168 -> 457926680;
                case 169 -> 1759467543;
                case 170 -> -960317024;
                case 171 -> 539251570;
                case 172 -> 296511635;
                case 173 -> -541028562;
                case 174 -> -1702707524;
                case 175 -> 1210827792;
                case 176 -> -73438549;
                case 177 -> 364686687;
                case 178 -> 588648149;
                case 179 -> 205848978;
                case 180 -> 1713944692;
                case 181 -> 1843072922;
                case 182 -> -1349267891;
                case 183 -> 2043766378;
                case 184 -> 788618735;
                case 185 -> -7332642;
                case 186 -> -1494857306;
                case 187 -> -780285351;
                case 188 -> -789771111;
                case 189 -> -1778714723;
                case 190 -> -75847965;
                case 191 -> 1814930746;
                case 192 -> 1496487171;
                case 193 -> 997468040;
                case 194 -> 1874870184;
                case 195 -> -1907935045;
                case 196 -> -152588161;
                case 197 -> 1288213182;
                case 198 -> -878703052;
                case 199 -> 1416316345;
                case 200 -> 1753816175;
                case 201 -> -1522560585;
                case 202 -> 1387709927;
                case 203 -> -231199943;
                case 204 -> 1818517845;
                case 205 -> -616427914;
                case 206 -> 715293271;
                case 207 -> -983466970;
                case 208 -> -991384367;
                case 209 -> 1482938588;
                case 210 -> -1973470183;
                case 211 -> 1919049781;
                case 212 -> 524849819;
                case 213 -> 1710205644;
                case 214 -> 2109426230;
                case 215 -> 497179785;
                case 216 -> 19839988;
                case 217 -> -735473329;
                case 218 -> 1688188267;
                case 219 -> 1900628413;
                case 220 -> -572277723;
                case 221 -> 1703063672;
                case 222 -> -1552014134;
                case 223 -> 645437403;
                case 224 -> 610507416;
                case 225 -> -1959492213;
                case 226 -> -487546882;
                case 227 -> 896348372;
                case 228 -> -758789380;
                case 229 -> -1519829763;
                case 230 -> -826967682;
                case 231 -> 879659129;
                case 232 -> 943890432;
                case 233 -> -243686318;
                case 234 -> 838077490;
                case 235 -> 782545844;
                case 236 -> -1437760139;
                case 237 -> -1541350772;
                case 238 -> 777857935;
                case 239 -> -751266128;
                case 240 -> 720069850;
                case 241 -> -1760507810;
                case 242 -> -679183937;
                case 243 -> 398361885;
                case 244 -> 987832571;
                case 245 -> 542241030;
                case 246 -> -771888806;
                case 247 -> -1474502763;
                case 248 -> 969805989;
                case 249 -> -2121512449;
                case 250 -> 2023569382;
                case 251 -> -148535349;
                case 252 -> -184366867;
                case 253 -> 889059891;
                case 254 -> 535500755;
                case 255 -> -1087227250;
                default -> 203732595;
            });
        } while (v2 != 56);
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            CriticalsModule = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        EnumType_O0II = new EnumType_0ooo_4("None", 0);
        O0Ii = new EnumType_0ooo_4("CritOnly", 1);
        O0iO = new EnumType_0ooo_4("Smart", 2);
        O0i0 = EnumType_0ooo_4.0o0();
    }

    private static /* synthetic */ EnumType_0ooo_4[] 0o0() {
        return new EnumType_0ooo_4[]{EnumType_O0II, O0Ii, O0iO};
    }
}

