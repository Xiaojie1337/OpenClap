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
 * Renamed from clap.render.RenderSupport_0ooi_1
 */
public final class EnumType_0ooi_2
extends Enum {
    public static final /* enum */ EnumType_0ooi_2 SprintResetModule;
    public static final /* enum */ EnumType_0ooi_2 O0Oo;
    private static final /* synthetic */ EnumType_0ooi_2[] GuiComponent;
    static Object O0Oi;

    public static EnumType_0ooi_2[] values() {
        return (EnumType_0ooi_2[])GuiComponent.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0ooi_2() {
        void param2;
        void param1;
    }

    public static EnumType_0ooi_2 valueOf(String param0) {
        return Enum.valueOf(EnumType_0ooi_2.class, param0);
    }

    static {
        byte[] v0 = "\u0081'\u008c\u00e6s\u00d1\u0092\u00bes\u0018\u00b4\u00d6\u0091=\u00e0qX\u00e2\u009aS\u0089<\u001fn\u00eb\u0015\u00dbp,\u00db\u00ab3\u00cf\u0087q\u000b\u00fe\u009a9\u0019\u0087\b\u00a3\u00c6\u00cd\u0003\u0088r".getBytes("ISO_8859_1");
        Object[] v1 = "F\u00fb\u0012\u00ea\u009e\u00ec\u00b46".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -161132642;
                case 1 -> 1780042973;
                case 2 -> 296804941;
                case 3 -> 1706751600;
                case 4 -> 360509575;
                case 5 -> 414204085;
                case 6 -> -1395955428;
                case 7 -> -477851595;
                case 8 -> 1850718357;
                case 9 -> 627039629;
                case 10 -> 987456034;
                case 11 -> -566947319;
                case 12 -> 1788952104;
                case 13 -> -186431482;
                case 14 -> -828003720;
                case 15 -> 1129874130;
                case 16 -> -1835354869;
                case 17 -> 1397331949;
                case 18 -> -307814269;
                case 19 -> -1126670341;
                case 20 -> -1820191233;
                case 21 -> -283697508;
                case 22 -> -1335618907;
                case 23 -> 541091784;
                case 24 -> 1582327590;
                case 25 -> -374492834;
                case 26 -> 1549742678;
                case 27 -> -173536244;
                case 28 -> 1861466760;
                case 29 -> -519116931;
                case 30 -> -647447253;
                case 31 -> 1614100453;
                case 32 -> -1262573705;
                case 33 -> -692614895;
                case 34 -> 30262424;
                case 35 -> 1246971870;
                case 36 -> -1169136632;
                case 37 -> 1032049853;
                case 38 -> 687528108;
                case 39 -> 67331516;
                case 40 -> -597832151;
                case 41 -> -1451217163;
                case 42 -> 2107933058;
                case 43 -> 542742740;
                case 44 -> 2088037516;
                case 45 -> -2138935413;
                case 46 -> 112932734;
                case 47 -> -1836303180;
                case 48 -> -598095038;
                case 49 -> 1302589929;
                case 50 -> -1130900429;
                case 51 -> -114179952;
                case 52 -> 2033502145;
                case 53 -> 745861686;
                case 54 -> -1255623907;
                case 55 -> -106770921;
                case 56 -> 1891076377;
                case 57 -> 390466172;
                case 58 -> 28764931;
                case 59 -> 875904121;
                case 60 -> 1725914290;
                case 61 -> -1234388665;
                case 62 -> -362913858;
                case 63 -> 107379382;
                case 64 -> 240166470;
                case 65 -> -650882964;
                case 66 -> -842361157;
                case 67 -> 944916730;
                case 68 -> 2024839937;
                case 69 -> -998458254;
                case 70 -> 1853197248;
                case 71 -> 826078836;
                case 72 -> -1658881712;
                case 73 -> -2095253260;
                case 74 -> -1329270449;
                case 75 -> 566654417;
                case 76 -> -1840845093;
                case 77 -> -382264034;
                case 78 -> 1110808292;
                case 79 -> 466482286;
                case 80 -> 613771864;
                case 81 -> -771199337;
                case 82 -> -930357669;
                case 83 -> -1771841014;
                case 84 -> 561544218;
                case 85 -> -1751137491;
                case 86 -> -1141141534;
                case 87 -> -912108685;
                case 88 -> -1560963996;
                case 89 -> -242665615;
                case 90 -> 262688803;
                case 91 -> 1898103961;
                case 92 -> 757182267;
                case 93 -> 1663436259;
                case 94 -> 470002174;
                case 95 -> 1313397468;
                case 96 -> -1376926513;
                case 97 -> -2007767366;
                case 98 -> -1515953625;
                case 99 -> -1946025161;
                case 100 -> -1597564505;
                case 101 -> -1082692429;
                case 102 -> 1417576177;
                case 103 -> 1713540807;
                case 104 -> 1206367975;
                case 105 -> -1892605329;
                case 106 -> -366851843;
                case 107 -> 225952047;
                case 108 -> 1042588236;
                case 109 -> 1547532633;
                case 110 -> 622600295;
                case 111 -> 825791012;
                case 112 -> -1966296659;
                case 113 -> 2105260426;
                case 114 -> -1695153166;
                case 115 -> 1156901800;
                case 116 -> -419167661;
                case 117 -> -384268443;
                case 118 -> 888601642;
                case 119 -> 297636613;
                case 120 -> 1714777709;
                case 121 -> -895696326;
                case 122 -> 617345719;
                case 123 -> 1346185749;
                case 124 -> 586454764;
                case 125 -> -2039893047;
                case 126 -> -1995927816;
                case 127 -> -2112040976;
                case 128 -> -1270854778;
                case 129 -> -2143823555;
                case 130 -> -47831344;
                case 131 -> 2039835167;
                case 132 -> -574719501;
                case 133 -> 1740495773;
                case 134 -> -1869487800;
                case 135 -> -1866948480;
                case 136 -> 1434965061;
                case 137 -> -1661380015;
                case 138 -> 733646688;
                case 139 -> 2097869930;
                case 140 -> 1554707456;
                case 141 -> 887860091;
                case 142 -> 69329410;
                case 143 -> -1850040619;
                case 144 -> -638347212;
                case 145 -> 1413004849;
                case 146 -> 544996301;
                case 147 -> -1454041645;
                case 148 -> 1375485720;
                case 149 -> -2026456945;
                case 150 -> -14448937;
                case 151 -> -2120789226;
                case 152 -> 2036159078;
                case 153 -> -891225538;
                case 154 -> -1831348430;
                case 155 -> 521361710;
                case 156 -> -953250569;
                case 157 -> 2013899905;
                case 158 -> 253605441;
                case 159 -> -2061011281;
                case 160 -> -1002152765;
                case 161 -> -833554802;
                case 162 -> 1844630370;
                case 163 -> 1198149936;
                case 164 -> 1339844635;
                case 165 -> -1759935061;
                case 166 -> 1863260306;
                case 167 -> -294076232;
                case 168 -> -2113308567;
                case 169 -> 640028639;
                case 170 -> -1125234698;
                case 171 -> -113185863;
                case 172 -> -1738512347;
                case 173 -> -972824735;
                case 174 -> 1217371842;
                case 175 -> 800606367;
                case 176 -> -1486035045;
                case 177 -> -1910329174;
                case 178 -> 562065369;
                case 179 -> -1432330440;
                case 180 -> -326227605;
                case 181 -> 1740264314;
                case 182 -> -1616778944;
                case 183 -> 802716178;
                case 184 -> 759745942;
                case 185 -> 430109023;
                case 186 -> -1637255676;
                case 187 -> 2046337742;
                case 188 -> -1004757542;
                case 189 -> 172810088;
                case 190 -> -2124514325;
                case 191 -> -2032889975;
                case 192 -> -725489183;
                case 193 -> -1101966959;
                case 194 -> 1720668326;
                case 195 -> -783585048;
                case 196 -> -1147426473;
                case 197 -> 837118618;
                case 198 -> 685947972;
                case 199 -> 1102292940;
                case 200 -> -1821861107;
                case 201 -> 135099988;
                case 202 -> -255171922;
                case 203 -> -478156231;
                case 204 -> -1576069430;
                case 205 -> 872826854;
                case 206 -> 288213464;
                case 207 -> -257072662;
                case 208 -> 1996766227;
                case 209 -> -2076769367;
                case 210 -> -944962881;
                case 211 -> 1247851598;
                case 212 -> 1820904724;
                case 213 -> 576576161;
                case 214 -> 1440028757;
                case 215 -> -334360096;
                case 216 -> 1308804003;
                case 217 -> 1187937788;
                case 218 -> 1808776748;
                case 219 -> -1710835821;
                case 220 -> -228824714;
                case 221 -> -1665056380;
                case 222 -> 1471868337;
                case 223 -> -287801659;
                case 224 -> 1187429078;
                case 225 -> 136200864;
                case 226 -> 644642175;
                case 227 -> -726506092;
                case 228 -> 1304826127;
                case 229 -> 35655011;
                case 230 -> 1446025333;
                case 231 -> 1609774020;
                case 232 -> 88967456;
                case 233 -> -1109555652;
                case 234 -> -648919470;
                case 235 -> 1213568007;
                case 236 -> -1642158138;
                case 237 -> -528279794;
                case 238 -> -1875997776;
                case 239 -> -439394241;
                case 240 -> 1676151243;
                case 241 -> 1056927993;
                case 242 -> -1334033079;
                case 243 -> -2058362534;
                case 244 -> -1309193149;
                case 245 -> -1268231004;
                case 246 -> -1936967006;
                case 247 -> 698304842;
                case 248 -> 822045003;
                case 249 -> 1973434757;
                case 250 -> 416615713;
                case 251 -> -870338321;
                case 252 -> -793368739;
                case 253 -> 902672;
                case 254 -> 1533136732;
                case 255 -> 38947566;
                default -> -1054839979;
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
            O0Oi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        SprintResetModule = new EnumType_0ooi_2("Old", 0);
        O0Oo = new EnumType_0ooi_2("New", 1);
        GuiComponent = EnumType_0ooi_2.ConfigSupport_00o_0();
    }

    private static /* synthetic */ EnumType_0ooi_2[] ConfigSupport_00o_0() {
        return new EnumType_0ooi_2[]{SprintResetModule, O0Oo};
    }
}

