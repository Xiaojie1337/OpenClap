/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Vector2f
 */
package clap.setting;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.function.Predicate;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.joml.Vector2f;
import clap.event.EventBusApi;
import clap.gui.GuiSupport_O000;
import clap.config.ConfigSupport_00o_0;
import clap.config.ConfigSupport_oioo_3;
import clap.event.Listener;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.IoO
 */
public class Setting {
    private Listener OoO;
    private Object OOi;
    private Object GuiSupport_OOI;
    private String O0i = "";
    private final String PacketEvent;
    private boolean EventBusApi;
    private String ConfigSupport_O0I;
    private Object HudElement;
    private Predicate O0o;
    private Object OOo;
    private final Object HelpCommand;
    static Object Oo0;
    private static volatile /* synthetic */ long __k__gH4it;

    public boolean DataRecord_0O0() {
        return this.OOo instanceof Color;
    }

    public void OoO(Object param1) {
        this.HudElement(param1);
        if (this.EventBusApi) {
            if (((Number)this.OOi).floatValue() > ((Number)param1).floatValue()) {
                this.HudElement(this.OOi);
            }
            if (((Number)this.HudElement).floatValue() < ((Number)param1).floatValue()) {
                this.HudElement(this.HudElement);
            }
        }
        if (this.OoO != null) {
            this.OoO.oOII(this);
        }
        this.OOo = this.GuiSupport_OOI;
    }

    public void O0i(Object param1) {
        this.HudElement = param1;
    }

    public void GuiSupport_OOI() {
        this.OOo(this.EnumType_0OI());
    }

    public String 0Oi() {
        return this.OOo.toString();
    }

    public Setting(String param1, Object param2, Object param3, Object param4, Predicate param5) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.OOi = param3;
        this.HudElement = param4;
        this.GuiSupport_OOI = param2;
        this.O0o = param5;
        this.ConfigSupport_O0I = "";
        this.EventBusApi = true;
    }

    public Object HelpCommand() {
        return this.OOo;
    }

    public boolean ConfigSupport_0OO() {
        return this.OOo instanceof GuiSupport_O000;
    }

    public String OiO(Object param1) {
        return param1.getClass().getSimpleName();
    }

    public Setting(String param1, Object param2, String param3) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.GuiSupport_OOI = param2;
        this.ConfigSupport_O0I = param3;
    }

    public boolean OiI() {
        return this.OOo instanceof Enum;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void Ooi(String param1) {
        Enum[] v2 = (Enum[])((Enum)this.OOo).getClass().getEnumConstants();
        int v3 = v2.length;
        int v4 = 0;
        while (v4 < v3) {
            Enum v5 = v2[v4];
            if (v5.name().equalsIgnoreCase(param1)) {
                this.OOo = v5;
            }
            ++v4;
        }
        return;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void OIo() {
        this.GuiSupport_OOI = ConfigSupport_oioo_3.GuiSupport_OOI((Enum)this.OOo);
        ConfigSupport_00o_0 v1 = new ConfigSupport_00o_0(this);
        clap.event.EventBusApi.OIo.OOo(v1);
        if (!v1.ConfigSupport_0OO()) {
            this.OOo = this.GuiSupport_OOI;
            return;
        }
        this.GuiSupport_OOI = this.OOo;
    }

    public Object OOi() {
        return this.GuiSupport_OOI;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String RenderSupport_oii_4() {
        if (this.OiI()) {
            return "Enum";
        }
        if (this.ConfigSupport_0OO()) {
            return "Bind";
        }
        if (this.DataRecord_0O0()) {
            return "Color";
        }
        if (this.0Oo()) {
            return "Pos";
        }
        return this.OiO(this.HelpCommand);
    }

    public boolean Oio() {
        return this.OOo instanceof Number;
    }

    public Setting(String param1, Object param2, Object param3, Object param4) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.OOi = param3;
        this.HudElement = param4;
        this.GuiSupport_OOI = param2;
        this.ConfigSupport_O0I = "";
        this.EventBusApi = true;
    }

    public boolean 0oO() {
        return this.O0o == null || this.O0o.test(this.HelpCommand());
    }

    public Listener Oo0() {
        return this.OoO;
    }

    public String PacketEvent() {
        return this.PacketEvent;
    }

    public boolean 0Oo() {
        return this.OOo instanceof Vector2f;
    }

    public void 00i(Predicate param1) {
        this.O0o = param1;
    }

    public String KeystrokesHudElement() {
        return ConfigSupport_oioo_3.OOi((Enum)this.OOo);
    }

    public Setting(String param1, Object param2) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.GuiSupport_OOI = param2;
        this.ConfigSupport_O0I = "";
    }

    public int ConfigSupport_OI0() {
        return ConfigSupport_oioo_3.OOo((Enum)this.OOo);
    }

    public Object EventBusApi() {
        return this.OOi;
    }

    public void Ooo(Listener param1) {
        this.OoO = param1;
    }

    public boolean DataRecord_00I() {
        return this.EventBusApi;
    }

    public Setting ConfigSupport_00o_0(String param1) {
        this.O0i = Objects.requireNonNullElse(param1, "");
        return this;
    }

    public Setting(String param1, Object param2, Predicate param3) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.O0o = param3;
        this.GuiSupport_OOI = param2;
    }

    public void O0o(Object param1) {
        this.OOi = param1;
    }

    public Object ConfigSupport_O0I() {
        return this.HudElement;
    }

    public boolean Oii() {
        return this.OOo instanceof String;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void OOo(Object param1) {
        this.HudElement(param1);
        if (this.EventBusApi) {
            if (((Number)this.OOi).floatValue() > ((Number)param1).floatValue()) {
                this.HudElement(this.OOi);
            }
            if (((Number)this.HudElement).floatValue() < ((Number)param1).floatValue()) {
                this.HudElement(this.HudElement);
            }
        }
        ConfigSupport_00o_0 v2 = new ConfigSupport_00o_0(this);
        clap.event.EventBusApi.OIo.OOo(v2);
        if (!v2.ConfigSupport_0OO() && this.OoO != null) {
            this.OoO.oOII(this);
        }
        if (v2.ConfigSupport_0OO()) {
            this.GuiSupport_OOI = this.OOo;
            return;
        }
        this.OOo = this.GuiSupport_OOI;
    }

    public void ConfigSupport_OII() {
        this.OOo = ConfigSupport_oioo_3.GuiSupport_OOI((Enum)this.OOo);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int OoI(String param1) {
        int v2 = 0;
        while (v2 < this.OOo.getClass().getEnumConstants().length) {
            Enum v3 = (Enum)this.OOo.getClass().getEnumConstants()[v2];
            if (v3.name().equalsIgnoreCase(param1)) {
                return v2;
            }
            ++v2;
        }
        return -1;
    }

    public String StorageEspModule() {
        return this.O0i;
    }

    static {
        __k__gH4it = Setting.__k__gH4it((long)3531431124574137873L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\u32ed\u5a58\u84db\ud125\u5623\u8306\uea55\u88b1\u3d16\u55f3\u8b7f\udee2\u59e3\u8243\ueb1a\u8901\u3caf\u547f\u8a7e\udfe9\u5883\u813c\ue802\u8ac0\u3f66\u574e\u89e6\udc88\u5bf5\u8039\ue96b\u8b7a\u3e6d\u56df\u8897\uddca\u5a06\u8053\uee59\u8c90\u3975\u5133\u8fbd\uda5f\u5d84\u87c7\uefb7\u8d27\u38d8\u5093\u8e74\udbc9\u5ca3\u864e\uec7c\u8e33\u3bca\u5316\u8d7e\ud8df\u5f6b\u85a4\ued5d\u8f3b", "\u32b3\u5a01\u8b9e\ude03\u595b\u83fe\ueac4\u88e6\u3dbf\u5517\u8a96\udf77\u5825\u82e4\uebee\u89a5\u3c83\u543d\u89b3\udc7b", "\u32a5\u5a13\u8b8c"};
        __rP__gH4it2 = new String[]{"\u32a7\u5a0c\u8b9b\ude74\u5929\u838f\ueabb\u88ff\u3db9\u5566", "\u32b5\u5a1f\u8b9d\ude0e\u595b\u83ba\uea40"};
        __rP__gH4it3 = new String[]{"\u32a5\u5a0e\u8b95\ude7a\u592b\u838d\ueabd\u88f9\u3dbb\u5564", "\u322a\u5aae\u8b36\ude75\u59d0\u83dc\uea0d\u880e", "\u32b0\u5a3e\u8465\ude33\u5952"};
        byte[] v0 = "JL\u00c6\u00f9\u008b\u00cab\u0088I\u00df\u001a6C\u0087%0\u00f8[\u0013%;\u00e0%\u00e9)r\u0093LE\u00edD[*\u00eb\u00eav\u008e\u007fN\u00c9\n\u00ff\u00f8\u00eb\u0004\u00e3\u00a8v\u00afW9e;r{z\u00a5\u00ca+{\u00fb\u0090Rz".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c7\u00fc\u00edS\u00c2n\u0084\u00cd".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1572304749;
                case 1 -> 399317364;
                case 2 -> -196617611;
                case 3 -> -1362786320;
                case 4 -> 1530780268;
                case 5 -> -693736998;
                case 6 -> -906504035;
                case 7 -> -154026282;
                case 8 -> -183201130;
                case 9 -> 1187751840;
                case 10 -> -1199833122;
                case 11 -> -5033474;
                case 12 -> -1391570868;
                case 13 -> -1452647142;
                case 14 -> 531606481;
                case 15 -> -1869412348;
                case 16 -> 434282824;
                case 17 -> 2079239577;
                case 18 -> -745602889;
                case 19 -> -1592420831;
                case 20 -> 1562612921;
                case 21 -> 1272318310;
                case 22 -> 1549464398;
                case 23 -> 228739935;
                case 24 -> 1543769803;
                case 25 -> -1695997807;
                case 26 -> 475210359;
                case 27 -> 96578703;
                case 28 -> -1808397312;
                case 29 -> -1424325737;
                case 30 -> -1019909885;
                case 31 -> 1687884871;
                case 32 -> -1464168081;
                case 33 -> -955454050;
                case 34 -> 2083489634;
                case 35 -> -1375524527;
                case 36 -> 1945310277;
                case 37 -> 1763517840;
                case 38 -> -1427155993;
                case 39 -> -332972830;
                case 40 -> 383688253;
                case 41 -> -604445167;
                case 42 -> 205670480;
                case 43 -> -504296062;
                case 44 -> 258666967;
                case 45 -> -2037557192;
                case 46 -> -562207003;
                case 47 -> 1744935667;
                case 48 -> 1801742123;
                case 49 -> -827527218;
                case 50 -> -772624261;
                case 51 -> -1126629642;
                case 52 -> 689266275;
                case 53 -> 863353308;
                case 54 -> -364262861;
                case 55 -> -1347648255;
                case 56 -> 1548774229;
                case 57 -> 528386840;
                case 58 -> -219840932;
                case 59 -> -406097523;
                case 60 -> -1129405959;
                case 61 -> -1134395357;
                case 62 -> 2060985771;
                case 63 -> -477747789;
                case 64 -> 2055051981;
                case 65 -> 1520939813;
                case 66 -> -2071642417;
                case 67 -> 1486005449;
                case 68 -> 560936020;
                case 69 -> 1937196225;
                case 70 -> -1037126280;
                case 71 -> 1344576429;
                case 72 -> -1797848450;
                case 73 -> -496371806;
                case 74 -> -1349475350;
                case 75 -> 161377124;
                case 76 -> -547356283;
                case 77 -> 1175324637;
                case 78 -> 1905688170;
                case 79 -> 1931733882;
                case 80 -> 1508315014;
                case 81 -> -486540533;
                case 82 -> -1134491319;
                case 83 -> -424753084;
                case 84 -> 684533245;
                case 85 -> 1756993066;
                case 86 -> 897877834;
                case 87 -> 265275219;
                case 88 -> -153198404;
                case 89 -> 1574385478;
                case 90 -> -1059393550;
                case 91 -> 424105558;
                case 92 -> 1192841000;
                case 93 -> 616903712;
                case 94 -> -910285177;
                case 95 -> -447538000;
                case 96 -> 1970545384;
                case 97 -> -1362357479;
                case 98 -> 356159250;
                case 99 -> 1999996340;
                case 100 -> 812883980;
                case 101 -> 1535877112;
                case 102 -> -1408606956;
                case 103 -> 1666676677;
                case 104 -> -1539177017;
                case 105 -> -882750707;
                case 106 -> 1764656412;
                case 107 -> 347317255;
                case 108 -> -365810113;
                case 109 -> -985704449;
                case 110 -> 738346200;
                case 111 -> -1388431895;
                case 112 -> 1736293094;
                case 113 -> -1053579970;
                case 114 -> 1324515387;
                case 115 -> -487409480;
                case 116 -> 1372783349;
                case 117 -> 1241399922;
                case 118 -> 382896859;
                case 119 -> 1465747912;
                case 120 -> 1781662849;
                case 121 -> -1508967900;
                case 122 -> 1448871707;
                case 123 -> -753586897;
                case 124 -> 1692776616;
                case 125 -> 357210281;
                case 126 -> -2046820768;
                case 127 -> -1930736324;
                case 128 -> 1247369480;
                case 129 -> 1099008527;
                case 130 -> 1577799844;
                case 131 -> 753158933;
                case 132 -> 643802150;
                case 133 -> 759374159;
                case 134 -> 1753295693;
                case 135 -> -1199594664;
                case 136 -> -2072243502;
                case 137 -> 885301916;
                case 138 -> -1791876477;
                case 139 -> -1479900164;
                case 140 -> -836989851;
                case 141 -> 1748289567;
                case 142 -> 901712579;
                case 143 -> 1549363041;
                case 144 -> -1783354164;
                case 145 -> 1263113481;
                case 146 -> -995964199;
                case 147 -> 1541179872;
                case 148 -> 93188268;
                case 149 -> -1805683916;
                case 150 -> -632375696;
                case 151 -> -2100397938;
                case 152 -> 87594643;
                case 153 -> -346160274;
                case 154 -> -635887600;
                case 155 -> -805617935;
                case 156 -> -1831148998;
                case 157 -> -2029505396;
                case 158 -> 1450590398;
                case 159 -> 311542327;
                case 160 -> 1221728048;
                case 161 -> 1403153059;
                case 162 -> 1559206685;
                case 163 -> 1096313639;
                case 164 -> -101552638;
                case 165 -> -1858942154;
                case 166 -> -1227978821;
                case 167 -> 1572414699;
                case 168 -> -1042564678;
                case 169 -> 1867322418;
                case 170 -> 1739748968;
                case 171 -> -1075295431;
                case 172 -> 1230148711;
                case 173 -> -1986236193;
                case 174 -> 127149877;
                case 175 -> 1974281965;
                case 176 -> 1655753536;
                case 177 -> -1871493202;
                case 178 -> -29170204;
                case 179 -> -494278507;
                case 180 -> 2122699197;
                case 181 -> 886174676;
                case 182 -> -1552321687;
                case 183 -> 694973586;
                case 184 -> -425036247;
                case 185 -> 1288884234;
                case 186 -> 477910698;
                case 187 -> -1527758158;
                case 188 -> -1399245061;
                case 189 -> 1434135133;
                case 190 -> -955545885;
                case 191 -> 382547871;
                case 192 -> -384903956;
                case 193 -> 248895620;
                case 194 -> -1517433476;
                case 195 -> 2023115446;
                case 196 -> 1426919182;
                case 197 -> 406172151;
                case 198 -> -1577297598;
                case 199 -> -492423442;
                case 200 -> -1852593247;
                case 201 -> -1446311359;
                case 202 -> 1886994303;
                case 203 -> -1320702203;
                case 204 -> 839000303;
                case 205 -> -543622993;
                case 206 -> 937686317;
                case 207 -> 2131347275;
                case 208 -> -11098602;
                case 209 -> 1703676373;
                case 210 -> 174788233;
                case 211 -> 1023965046;
                case 212 -> 111503916;
                case 213 -> -1371692969;
                case 214 -> 1112190513;
                case 215 -> 1643942026;
                case 216 -> 359475611;
                case 217 -> -2096351321;
                case 218 -> 1809549918;
                case 219 -> 107309145;
                case 220 -> -384007613;
                case 221 -> -1914557690;
                case 222 -> -301044588;
                case 223 -> -1303240878;
                case 224 -> -831672076;
                case 225 -> 814337957;
                case 226 -> -911440173;
                case 227 -> 2004305515;
                case 228 -> -546013138;
                case 229 -> 1543961107;
                case 230 -> -1099624613;
                case 231 -> -1147582518;
                case 232 -> -963329611;
                case 233 -> 1096500314;
                case 234 -> -541786499;
                case 235 -> 1394792895;
                case 236 -> -1756008026;
                case 237 -> 1436261491;
                case 238 -> 410899652;
                case 239 -> 1833063878;
                case 240 -> 1046965131;
                case 241 -> -1030553826;
                case 242 -> -1905473088;
                case 243 -> -2124428038;
                case 244 -> 1987862912;
                case 245 -> -1802015977;
                case 246 -> -112994895;
                case 247 -> 1147737538;
                case 248 -> 1911904481;
                case 249 -> -1292672903;
                case 250 -> 1772773233;
                case 251 -> 2056279248;
                case 252 -> 1077803144;
                case 253 -> 1939308066;
                case 254 -> 579048602;
                case 255 -> -1024680552;
                default -> -1021547649;
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
            Object[] objectArray = new Object[5];
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
    }

    public Setting(String param1, Object param2, Object param3, Object param4, String param5) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.OOi = param3;
        this.HudElement = param4;
        this.GuiSupport_OOI = param2;
        this.ConfigSupport_O0I = param5;
        this.EventBusApi = true;
    }

    public Setting(String param1, Object param2, Object param3, Object param4, Predicate param5, String param6) {
        this.PacketEvent = param1;
        this.HelpCommand = param2;
        this.OOo = param2;
        this.OOi = param3;
        this.HudElement = param4;
        this.GuiSupport_OOI = param2;
        this.O0o = param5;
        this.ConfigSupport_O0I = param6;
        this.EventBusApi = true;
    }

    public Object EnumType_0OI() {
        return this.HelpCommand;
    }

    public String Oi0() {
        return Objects.requireNonNullElse(this.ConfigSupport_O0I, "");
    }

    public String Kernel32SnapshotApi() {
        return this.0Oi() + this.StorageEspModule();
    }

    public void HudElement(Object param1) {
        this.GuiSupport_OOI = param1;
    }
}

