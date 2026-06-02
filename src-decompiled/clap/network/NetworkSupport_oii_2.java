/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ServerInfo
 *  net.minecraft.client.toast.SystemToast
 *  net.minecraft.client.toast.SystemToast$Type
 *  net.minecraft.client.toast.Toast
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Text
 */
package clap.network;

import java.security.Key;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

/*
 * Renamed from psx.Hyk.Oii
 */
public final class NetworkSupport_oii_2 {
    private static final Set PacketEvent;
    static Object HelpCommand;
    private static volatile /* synthetic */ long __k__gH4it;

    private NetworkSupport_oii_2() {
    }

    public static void PacketEvent() {
        ServerInfo v0 = MinecraftClient.getInstance().getCurrentServerEntry();
        if (v0 != null) {
            if (PacketEvent.contains(v0.address)) {
                return;
            }
            PacketEvent.add(v0.address);
        }
        SystemToast.Type v1 = new SystemToast.Type(10000L);
        MutableText v2 = Text.literal((String)"ClientSpoof");
        MutableText v3 = Text.literal((String)"Server attempted to read client-only mod data.");
        MinecraftClient.getInstance().getToastManager().add((Toast)SystemToast.create((MinecraftClient)MinecraftClient.getInstance(), (SystemToast.Type)v1, (Text)v2, (Text)v3));
    }

    static {
        __k__gH4it = NetworkSupport_oii_2.__k__gH4it((long)1661105263828004369L);
        __rP__gH4it0 = new String[]{"\uc873\uece4\u32eb\u6714\ue031\u2e38\udc4b\u3213", "\uc85d\uecfd\u32ee", "\uc848\uece8\u32ff\u67ad\ue0cc"};
        __rP__gH4it1 = new String[]{"\uc85d\uece4\u32ff\u67d0\ue0c5\u2e23\udcc3\u32dc\ucb43\uef8e"};
        __rP__gH4it2 = new String[]{"\uc85f\uece6\u32f9\u67d6\ue0c7\u2e21\udccd\u32d2\ucb41\uef8c", "\uc84b\uecef\u32fc\u67bd\ue0a5\u2e5c\udcb2\u32cf\ucb47\ueff9\u31f4\u64d9\ue3cb\u2d46\udf98\u338c\uca7b\ueed3\u30d1\u65e5", "\uc84d\uecf5\u32ff\u67ac\ue0c5\u2e24\udcf6"};
        __rP__gH4it3 = new String[]{"\uc856\uec9f\u3203\u67f8\ue042\u2ef4\udc7b\u320b\ucb80\uefca\u31c0\u648e\ue334\u2d04\udfa2\u33c8\ucaf0\uee4a\u3039\u658a\ue2a8\u2cc5\ude37\u34d2\ucd14\ue930\u377b\u6224\ue52c\u2b9a\ud9ba\u3587\ucc2b\ue839\u36dc\u634a\ue4eb\u2a5f\ud8cb\u35ac\ucf87\ueb6a\u352c\u6091\ue74f\u2938\udb04\u368c\ucef8\ueac0\u34f1\u61ed\ue64d\u28e9\udab6\u3777\uc10b\ue515\u3b2a\u6ea8\ue9b3\u2791\ud5af\u3810\uc00a\ue4c9\u3a37\u6f2b\ue87c\u2645\ud416\u39b4\uc091\ue731\u3979\u6cf6\ueb40\u2546\ud757\u3a9f\uc39a\ue689\u3804\u6da8\uea97\u244e\ud699\u3b34\uc243\ue12f\u3fa0\u6a72\ued6b\u234c\ud149\u3c08"};
        byte[] v0 = ")\u0005\\Z\u00d4\u00fa\u009a\u00fb\u0087hg\u0014\u00da\u0002K0\u00ff\u00e0\u0096\u0018N\u00db\u00c62\u0003\u0082\u00cc\u00ae\u00d2\u008cCo4\u0083c\u00c8\u001d1\n\u00bc\u00a0\u00a8\u00ab\u00eb\u0081^\u00cd\u0094\u00d7\n~\u009f\u008b\u0097gw<\u00c7\u00bd\u00c2m\u00e7v\u00185\u0013\u00a8I\u00aa\u000b\u00b7\u0084V\u00d3\u009e\u00acn\u0000\u00fe\u00a7Uc\u00eb\u00fa\u00b1\u0010(\u0014\u0094\u00ddW8U\u001a\u00f0 ".getBytes("ISO_8859_1");
        Object[] v1 = "fPZ\u009c\u00cd \u00bc\u00f9".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1973915919;
                case 1 -> 629725844;
                case 2 -> -1972908445;
                case 3 -> -189273937;
                case 4 -> 2063241871;
                case 5 -> 1852677192;
                case 6 -> -2007383580;
                case 7 -> -112097476;
                case 8 -> 1644521228;
                case 9 -> -991498358;
                case 10 -> 1249830082;
                case 11 -> -2064597358;
                case 12 -> -611104017;
                case 13 -> -150581675;
                case 14 -> -713783699;
                case 15 -> 1246233214;
                case 16 -> -173900863;
                case 17 -> 1477389113;
                case 18 -> 1633491859;
                case 19 -> -689165500;
                case 20 -> -535996848;
                case 21 -> -277510505;
                case 22 -> 1683245294;
                case 23 -> 1366169671;
                case 24 -> -1772454166;
                case 25 -> 864947431;
                case 26 -> -1102477569;
                case 27 -> 1241908148;
                case 28 -> 908166475;
                case 29 -> -1436218161;
                case 30 -> 840228832;
                case 31 -> -841058201;
                case 32 -> -1080840235;
                case 33 -> 849603831;
                case 34 -> 146712114;
                case 35 -> -781634658;
                case 36 -> 444583305;
                case 37 -> -87880194;
                case 38 -> 1378630123;
                case 39 -> 1812494613;
                case 40 -> 337863437;
                case 41 -> -1203752980;
                case 42 -> 1861293426;
                case 43 -> 1526439411;
                case 44 -> -1064660247;
                case 45 -> 1366281845;
                case 46 -> -1155207928;
                case 47 -> -349847020;
                case 48 -> 274951937;
                case 49 -> 1426195731;
                case 50 -> 1997830098;
                case 51 -> 489821223;
                case 52 -> 1228981643;
                case 53 -> -1598425892;
                case 54 -> -1582556669;
                case 55 -> 1980303862;
                case 56 -> 1569943638;
                case 57 -> -144656022;
                case 58 -> -287783390;
                case 59 -> 448683572;
                case 60 -> 1382075092;
                case 61 -> -622107681;
                case 62 -> 2064420940;
                case 63 -> 995614807;
                case 64 -> 372234768;
                case 65 -> 1297978522;
                case 66 -> 1239016166;
                case 67 -> 1464419886;
                case 68 -> 2114861112;
                case 69 -> -2023187171;
                case 70 -> 158422067;
                case 71 -> 25268241;
                case 72 -> -701964530;
                case 73 -> -916370317;
                case 74 -> 1559986082;
                case 75 -> -1398094259;
                case 76 -> 1384406619;
                case 77 -> 405062297;
                case 78 -> 92892321;
                case 79 -> -351992373;
                case 80 -> 623058096;
                case 81 -> -1910045492;
                case 82 -> 1777031045;
                case 83 -> -330156598;
                case 84 -> 2023727415;
                case 85 -> 1600919118;
                case 86 -> 308739867;
                case 87 -> -539505186;
                case 88 -> -1540612151;
                case 89 -> 1607917056;
                case 90 -> -616320745;
                case 91 -> -53440116;
                case 92 -> -1354258702;
                case 93 -> -1001973315;
                case 94 -> -1447837242;
                case 95 -> 419439349;
                case 96 -> 1804384973;
                case 97 -> -1699603933;
                case 98 -> -418892164;
                case 99 -> -273231808;
                case 100 -> -1056683477;
                case 101 -> -1711788495;
                case 102 -> -1751861667;
                case 103 -> 464783517;
                case 104 -> 815997865;
                case 105 -> 435341092;
                case 106 -> -1971905380;
                case 107 -> -1606793470;
                case 108 -> 1749512545;
                case 109 -> 1297471741;
                case 110 -> 1859598909;
                case 111 -> 160397689;
                case 112 -> 518973450;
                case 113 -> -339672002;
                case 114 -> -144139697;
                case 115 -> 1196498086;
                case 116 -> 1446354065;
                case 117 -> -251428817;
                case 118 -> 390161692;
                case 119 -> -1951162195;
                case 120 -> -893865531;
                case 121 -> -1453338136;
                case 122 -> -1732859112;
                case 123 -> -1774662484;
                case 124 -> 2130138953;
                case 125 -> 264948585;
                case 126 -> 958379807;
                case 127 -> -958322034;
                case 128 -> 1191170769;
                case 129 -> 1291021318;
                case 130 -> 1214721143;
                case 131 -> 1419297029;
                case 132 -> 1709010984;
                case 133 -> -1835563495;
                case 134 -> -764798969;
                case 135 -> -1226858990;
                case 136 -> 865579195;
                case 137 -> 1753434219;
                case 138 -> 798112708;
                case 139 -> 867365434;
                case 140 -> 1658979621;
                case 141 -> -170385435;
                case 142 -> -1290132442;
                case 143 -> 130271803;
                case 144 -> -1952517958;
                case 145 -> -1273395623;
                case 146 -> 222229274;
                case 147 -> -2074829639;
                case 148 -> -1034920951;
                case 149 -> 4499810;
                case 150 -> -141766928;
                case 151 -> 65487330;
                case 152 -> 398097477;
                case 153 -> 52562940;
                case 154 -> 1320185407;
                case 155 -> -1049033468;
                case 156 -> 782078079;
                case 157 -> -1420919964;
                case 158 -> -653703280;
                case 159 -> 1973610944;
                case 160 -> -1430366758;
                case 161 -> -747954575;
                case 162 -> 2027758049;
                case 163 -> 1842368438;
                case 164 -> 196872443;
                case 165 -> -205893510;
                case 166 -> 1439122905;
                case 167 -> 1813943130;
                case 168 -> -1162988133;
                case 169 -> -764831150;
                case 170 -> -536183520;
                case 171 -> -1768136989;
                case 172 -> 1249101184;
                case 173 -> -685307256;
                case 174 -> 1125026827;
                case 175 -> -1429754786;
                case 176 -> 2067792257;
                case 177 -> -408769453;
                case 178 -> -1882789472;
                case 179 -> 1788202529;
                case 180 -> -1047954860;
                case 181 -> -645730140;
                case 182 -> 1430900588;
                case 183 -> 725677471;
                case 184 -> 1514802871;
                case 185 -> -1923274737;
                case 186 -> -1833171624;
                case 187 -> -1211436163;
                case 188 -> 1237219462;
                case 189 -> 196185712;
                case 190 -> -1960387454;
                case 191 -> -2116201356;
                case 192 -> -1580781915;
                case 193 -> -2097388323;
                case 194 -> 2131970041;
                case 195 -> -810880050;
                case 196 -> -1326225224;
                case 197 -> -1293673658;
                case 198 -> 840834804;
                case 199 -> 620211903;
                case 200 -> 240819018;
                case 201 -> 782674789;
                case 202 -> 1231477438;
                case 203 -> 1152312854;
                case 204 -> 402117750;
                case 205 -> 1583771702;
                case 206 -> 1811638183;
                case 207 -> -1883646549;
                case 208 -> 1551737262;
                case 209 -> 1444495427;
                case 210 -> -445065084;
                case 211 -> 827526279;
                case 212 -> 1976599852;
                case 213 -> 1877120030;
                case 214 -> -1237183652;
                case 215 -> -115047787;
                case 216 -> 700524163;
                case 217 -> 818670506;
                case 218 -> 690672307;
                case 219 -> 1012011878;
                case 220 -> -897668467;
                case 221 -> -665006291;
                case 222 -> 1971746554;
                case 223 -> -529898711;
                case 224 -> 181205600;
                case 225 -> 935729623;
                case 226 -> -1150311627;
                case 227 -> 1515481795;
                case 228 -> 43111746;
                case 229 -> 308959583;
                case 230 -> -266955370;
                case 231 -> -1033807;
                case 232 -> 1644624449;
                case 233 -> -2117627704;
                case 234 -> -1775133789;
                case 235 -> 1636148947;
                case 236 -> -1408318250;
                case 237 -> 811896430;
                case 238 -> 1955347637;
                case 239 -> 1350828440;
                case 240 -> 1443628074;
                case 241 -> -324620868;
                case 242 -> -949555352;
                case 243 -> -540936837;
                case 244 -> 1685388525;
                case 245 -> 731560312;
                case 246 -> -1574807504;
                case 247 -> -1499646552;
                case 248 -> 1113897179;
                case 249 -> -821676040;
                case 250 -> -1429305392;
                case 251 -> 1213048175;
                case 252 -> 1458386136;
                case 253 -> 2143578823;
                case 254 -> -370694222;
                case 255 -> 465048401;
                default -> 538970362;
            });
        } while (v2 != 96);
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
            HelpCommand = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = new HashSet();
    }
}

