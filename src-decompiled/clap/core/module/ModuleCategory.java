/*
 * Decompiled with CFR 0.152.
 */
package clap.core.module;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/*
 * Renamed from psx.Hyk.OIoi
 */
public final class ModuleCategory
extends Enum {
    public static final /* enum */ ModuleCategory io0;
    private static final /* synthetic */ ModuleCategory[] iIO;
    public static final /* enum */ ModuleCategory NoHurtCamModule;
    public static final /* enum */ ModuleCategory ioi;
    public static final /* enum */ ModuleCategory ioo;
    public static final /* enum */ ModuleCategory i0i;
    public static final /* enum */ ModuleCategory i0I;
    private final String name;
    public static final /* enum */ ModuleCategory ioO;
    static Object iI0;

    public String getName() {
        return this.name;
    }

    private static /* synthetic */ ModuleCategory[] OiI() {
        return new ModuleCategory[]{i0I, i0i, ioO, io0, ioo, NoHurtCamModule, ioi};
    }

    public static ModuleCategory valueOf(String param0) {
        return Enum.valueOf(ModuleCategory.class, param0);
    }

    public static ModuleCategory[] values() {
        return (ModuleCategory[])iIO.clone();
    }

    static {
        byte[] v0 = "\u00eb\u008d1\u00ccN,\te\u0080\u00b9\u00b6\u00af,k\u0090\u00ea\u00e5\u00fc\u00c3I\u0005\u009b\u0018 \u00f9N\u000e\u0014\u00b9D\u0002\u0016\u000f[\u001b\u00d8\u00bf\u008c\u00d1\u00d7\u0080\u001a\u00822C\u00ab\u00d0|Y\u00c8`\u00fe@\u00faJ\u008f\u00c7\u00a9cL\u00a4\u00a1\u00ddC\u00fc\u00ec\u001f\u00bd\u00dd\u00b6\u00ac\u00df}u\u001e\u00a5\u00c4\f\u00d0\u00bb\u001f\u00b1\u009c}\u001b\u001a\n\u0087\u0096\u00c7\u00f1\u00f4\u000fo|\u00b7}{\u00a2\u00c5\u0097\u00c4\u00db\u0005N\u00c9\u0011\u00e58\u00c7qC\u00db\u00a7\u0016Y0\u00d7\u00dc\u00c1\u008b\u0018\u00d4\u00aa\u00ad@\r\u0080Z\u000fD\u00d5\u00f4\u009c\u00fb\u00c5\u009bsmi\u00a9\u00d5\u00f6S".getBytes("ISO_8859_1");
        Object[] v1 = "\u001a4\u00b5\u00f6\u008b\u00dbL\u00fd".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1877515142;
                case 1 -> -1247694459;
                case 2 -> -1760045963;
                case 3 -> -467809460;
                case 4 -> -776633814;
                case 5 -> -477737096;
                case 6 -> 488167402;
                case 7 -> 1834638797;
                case 8 -> -1082099523;
                case 9 -> 584937362;
                case 10 -> -1237690932;
                case 11 -> 1023796848;
                case 12 -> 492615979;
                case 13 -> -1643530040;
                case 14 -> 1948500497;
                case 15 -> -1790911744;
                case 16 -> -1795990422;
                case 17 -> 2082377199;
                case 18 -> -2089435976;
                case 19 -> 325957619;
                case 20 -> -1887528452;
                case 21 -> -71221524;
                case 22 -> 1963728947;
                case 23 -> -464472682;
                case 24 -> 1513652457;
                case 25 -> 254139803;
                case 26 -> 1915731978;
                case 27 -> -1739988523;
                case 28 -> -1152743473;
                case 29 -> 31760408;
                case 30 -> 365586950;
                case 31 -> -1890051672;
                case 32 -> -2081309661;
                case 33 -> 296822089;
                case 34 -> 648492505;
                case 35 -> 1851383410;
                case 36 -> -1552634396;
                case 37 -> -1815276417;
                case 38 -> -789295473;
                case 39 -> -1226102415;
                case 40 -> 851795341;
                case 41 -> 1185146331;
                case 42 -> -1898270604;
                case 43 -> -1349674963;
                case 44 -> -478485396;
                case 45 -> -778711168;
                case 46 -> -1269596127;
                case 47 -> 750427239;
                case 48 -> 57898206;
                case 49 -> -2133579944;
                case 50 -> -2136341531;
                case 51 -> 1129681741;
                case 52 -> -903284269;
                case 53 -> -795760987;
                case 54 -> -611033810;
                case 55 -> 1676535842;
                case 56 -> 584024901;
                case 57 -> -303207282;
                case 58 -> 465341535;
                case 59 -> 580887289;
                case 60 -> 1878407109;
                case 61 -> -1926777184;
                case 62 -> -1271505187;
                case 63 -> -211613350;
                case 64 -> 2144890985;
                case 65 -> 807114169;
                case 66 -> -1258928007;
                case 67 -> 1015166561;
                case 68 -> -854177509;
                case 69 -> -1779883368;
                case 70 -> 589847483;
                case 71 -> 1257623106;
                case 72 -> 1130941821;
                case 73 -> -1318063185;
                case 74 -> 1082508627;
                case 75 -> 1289235984;
                case 76 -> -1269340515;
                case 77 -> 1475469692;
                case 78 -> -2017813545;
                case 79 -> 2133900653;
                case 80 -> 1782147895;
                case 81 -> 1211257631;
                case 82 -> 114611735;
                case 83 -> 474957653;
                case 84 -> 1629998508;
                case 85 -> 619092800;
                case 86 -> -1563379133;
                case 87 -> 1493794741;
                case 88 -> 2066761723;
                case 89 -> 932194415;
                case 90 -> -270130897;
                case 91 -> 1336611039;
                case 92 -> -128148573;
                case 93 -> 52531852;
                case 94 -> -1669506985;
                case 95 -> 696968167;
                case 96 -> -650790141;
                case 97 -> -732185544;
                case 98 -> -672564418;
                case 99 -> 574518333;
                case 100 -> -191634679;
                case 101 -> 417374377;
                case 102 -> -1116627384;
                case 103 -> 999189916;
                case 104 -> 487196479;
                case 105 -> -1714588123;
                case 106 -> 789647109;
                case 107 -> 635294543;
                case 108 -> -129229253;
                case 109 -> 193349373;
                case 110 -> -185954285;
                case 111 -> 535264254;
                case 112 -> 953492740;
                case 113 -> 1182346733;
                case 114 -> -1645127161;
                case 115 -> 1758177403;
                case 116 -> -385160420;
                case 117 -> -62929396;
                case 118 -> -284807098;
                case 119 -> 2057432641;
                case 120 -> -462752464;
                case 121 -> -1377201829;
                case 122 -> -2030701067;
                case 123 -> 811714150;
                case 124 -> -2010309390;
                case 125 -> -475902064;
                case 126 -> 1386900916;
                case 127 -> 1781953463;
                case 128 -> -159536034;
                case 129 -> 1200855434;
                case 130 -> 78983228;
                case 131 -> -847700548;
                case 132 -> -147187897;
                case 133 -> -300860664;
                case 134 -> -1184371820;
                case 135 -> 467028952;
                case 136 -> -600268574;
                case 137 -> 672402862;
                case 138 -> 1949072982;
                case 139 -> -304999730;
                case 140 -> -1227587825;
                case 141 -> 587160561;
                case 142 -> 386044333;
                case 143 -> -1573866879;
                case 144 -> 1442667958;
                case 145 -> -35055671;
                case 146 -> -1322275772;
                case 147 -> 872377206;
                case 148 -> -1197328102;
                case 149 -> 291329500;
                case 150 -> -1853231421;
                case 151 -> -1370239947;
                case 152 -> -46330889;
                case 153 -> -551950256;
                case 154 -> -359338136;
                case 155 -> -845822962;
                case 156 -> 231061447;
                case 157 -> 1942424654;
                case 158 -> 1043032615;
                case 159 -> 1552623991;
                case 160 -> -592959908;
                case 161 -> 830369928;
                case 162 -> 1525136177;
                case 163 -> 899783083;
                case 164 -> -1799186440;
                case 165 -> -1086184949;
                case 166 -> -769111276;
                case 167 -> -513945424;
                case 168 -> -1859223386;
                case 169 -> -1147593280;
                case 170 -> 1101820802;
                case 171 -> 1336270538;
                case 172 -> -890793930;
                case 173 -> 1470071069;
                case 174 -> 446268043;
                case 175 -> -2062687202;
                case 176 -> -7757918;
                case 177 -> -130763308;
                case 178 -> 813620075;
                case 179 -> -1918555351;
                case 180 -> -1902660534;
                case 181 -> -1261307402;
                case 182 -> -118794534;
                case 183 -> 104584224;
                case 184 -> -1488233123;
                case 185 -> 456668182;
                case 186 -> 513109183;
                case 187 -> -503878560;
                case 188 -> 822934883;
                case 189 -> 483126439;
                case 190 -> -1254437152;
                case 191 -> 781130002;
                case 192 -> 27976018;
                case 193 -> -765278170;
                case 194 -> -1133287490;
                case 195 -> -739363725;
                case 196 -> -1351734988;
                case 197 -> -1246361158;
                case 198 -> -1291912815;
                case 199 -> 512133579;
                case 200 -> 663348690;
                case 201 -> -1327378529;
                case 202 -> 819185043;
                case 203 -> 747212246;
                case 204 -> 1280437348;
                case 205 -> -1668211292;
                case 206 -> -139985456;
                case 207 -> -1747830683;
                case 208 -> 795627066;
                case 209 -> 1626534340;
                case 210 -> -1089017087;
                case 211 -> 1455384222;
                case 212 -> 201944242;
                case 213 -> 1553262884;
                case 214 -> 2115894916;
                case 215 -> 1473832180;
                case 216 -> 1364987948;
                case 217 -> 721698562;
                case 218 -> -692240982;
                case 219 -> -1122531390;
                case 220 -> -951315759;
                case 221 -> -1679944299;
                case 222 -> 88722667;
                case 223 -> 1716190113;
                case 224 -> -470587241;
                case 225 -> 503606073;
                case 226 -> -1296534959;
                case 227 -> 614342526;
                case 228 -> -1591826461;
                case 229 -> 305998003;
                case 230 -> -485398815;
                case 231 -> 367339953;
                case 232 -> -1291362834;
                case 233 -> 685051490;
                case 234 -> -23216274;
                case 235 -> 1131337882;
                case 236 -> -1374699239;
                case 237 -> -415721496;
                case 238 -> 1752321813;
                case 239 -> 1472493362;
                case 240 -> 95198539;
                case 241 -> -1055852410;
                case 242 -> -285027239;
                case 243 -> -1755676915;
                case 244 -> -2078047002;
                case 245 -> 1687412479;
                case 246 -> -1901874746;
                case 247 -> -336723833;
                case 248 -> -426729597;
                case 249 -> 1201182458;
                case 250 -> -644896528;
                case 251 -> -815185624;
                case 252 -> 1007202697;
                case 253 -> -2098351207;
                case 254 -> -127251775;
                case 255 -> -336843948;
                default -> -421455077;
            });
        } while (v2 != 144);
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
            Object[] objectArray = new Object[14];
            v1 = objectArray;
            iI0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        i0I = new ModuleCategory("COMBAT", 0, "Combat");
        i0i = new ModuleCategory("MISC", 1, "Misc");
        ioO = new ModuleCategory("RENDER", 2, "Render");
        io0 = new ModuleCategory("MOVEMENT", 3, "Movement");
        ioo = new ModuleCategory("PLAYER", 4, "Player");
        NoHurtCamModule = new ModuleCategory("CLIENT", 5, "Client");
        ioi = new ModuleCategory("HUD", 6, "Hud");
        iIO = ModuleCategory.OiI();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ModuleCategory() {
        void param3;
        void param2;
        this.name = param3;
    }
}

