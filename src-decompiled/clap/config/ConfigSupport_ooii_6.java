/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package clap.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.core.NativeEntrypointBridge;
import clap.module.client.ChatTranslatorModule;

/*
 * Renamed from psx.Hyk.Ooii
 */
public class ConfigSupport_ooii_6 {
    private static final URI PacketEvent;
    private final ChatTranslatorModule HelpCommand;
    private final HttpClient OOo;
    static Object GuiSupport_OOI;
    private static volatile /* synthetic */ long __k__gH4it;

    public CompletableFuture PacketEvent(String param1, String param2, String param3) {
        if (param1 == null || param1.isBlank()) {
            return CompletableFuture.failedFuture(new IllegalArgumentException("Text must not be blank."));
        }
        if (!this.HelpCommand.IIOo()) {
            return CompletableFuture.failedFuture(new IllegalStateException("Translator AppId/AppKey is not configured."));
        }
        String v4 = ConfigSupport_ooii_6.OOo(param2, "auto");
        String v5 = ConfigSupport_ooii_6.OOo(param3, "zh");
        String v6 = Long.toString(System.nanoTime());
        String v7 = ConfigSupport_ooii_6.OOi(this.HelpCommand.IIOi() + param1 + v6 + this.HelpCommand.II0O());
        String v8 = ConfigSupport_ooii_6.GuiSupport_OOI("q", param1) + "&" + ConfigSupport_ooii_6.GuiSupport_OOI("from", v4) + "&" + ConfigSupport_ooii_6.GuiSupport_OOI("to", v5) + "&" + ConfigSupport_ooii_6.GuiSupport_OOI("appid", this.HelpCommand.IIOi()) + "&" + ConfigSupport_ooii_6.GuiSupport_OOI("salt", v6) + "&" + ConfigSupport_ooii_6.GuiSupport_OOI("sign", v7);
        HttpRequest v9 = HttpRequest.newBuilder(PacketEvent).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString(v8, StandardCharsets.UTF_8)).build();
        return ((CompletableFuture)this.OOo.sendAsync(v9, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).thenApply(HttpResponse::body)).thenApply(this::HelpCommand);
    }

    private static String OOo(String param0, String param1) {
        if (param0 == null) {
            return param1;
        }
        String v2 = param0.trim().toLowerCase();
        return v2.isEmpty() ? param1 : v2;
    }

    private static String OOi(String param0) {
        try {
            MessageDigest v1 = MessageDigest.getInstance("MD5");
            byte[] v2 = v1.digest(param0.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(v2);
        }
        catch (NoSuchAlgorithmException v1) {
            NativeEntrypointBridge.OOo.error("Missing MD5 provider", (Throwable)v1);
            throw new IllegalStateException("MD5 is unavailable.", v1);
        }
    }

    private String HelpCommand(String param1) {
        JsonObject v2 = JsonParser.parseString((String)param1).getAsJsonObject();
        if (v2.has("error_code")) {
            String v3 = v2.get("error_code").getAsString();
            String v4 = v2.has("error_msg") ? v2.get("error_msg").getAsString() : "Unknown error";
            throw new IllegalStateException("Baidu API error " + v3 + ": " + v4);
        }
        JsonArray v3 = v2.getAsJsonArray("trans_result");
        if (v3 == null || v3.isEmpty()) {
            throw new IllegalStateException("Baidu API returned no translation results.");
        }
        StringBuilder v4 = new StringBuilder();
        for (int v5 = 0; v5 < v3.size(); ++v5) {
            JsonObject v6 = v3.get(v5).getAsJsonObject();
            if (v5 > 0) {
                v4.append('\n');
            }
            v4.append(v6.get("dst").getAsString());
        }
        return v4.toString();
    }

    private static String GuiSupport_OOI(String param0, String param1) {
        return param0 + "=" + URLEncoder.encode(param1, StandardCharsets.UTF_8);
    }

    public ConfigSupport_ooii_6(ChatTranslatorModule param1) {
        this.HelpCommand = param1;
        this.OOo = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
    }

    static {
        __k__gH4it = ConfigSupport_ooii_6.__k__gH4it((long)-5830260080645247471L);
        __rP__gH4it0 = new String[]{"\u17ff\u42a9\u9d18\uc86d\u4f5b\uef8e\u2cc8\u9f7b\u1632\u43fc\u9c8f\uc9de\u4e1a\ueec2\u13e8\ua0f2\u29fa\u7ce9\ua368\uf6c4\u711e\ud104\u1203\ua188\u2854\u7de5\ua268\uf71a\u700f\ud0e2\u125c\ua252\u2b34\u7ec8\ua118\uf4cd\u7339\ud3ad\u116f\ua37a\u2a17\u7fb6\ua068\uf5e7\u72c2\ud262\u10ac\ua438\u2d75\u784f\ua7b6\uf2ca\u7525\ud522\u1730\ua5cf\u2c3f\u7907\ua6fa\uf37c\u740e\ud482\u1646\ua5dc\u2fe4\u7ace\ua530\uf09e\u77fd\ud7c2\u151d\ua628\u2e3e\u7baa\ua471\uf14c\u7694\ud642\u1442\ua773\u21e9\u74e8\uab5c\ufe3a\u7910\ud9fe\u1b08\ua8bb\u200c\u754a\uaa58\uff60\u7862\ud8fe\u1a0f\ua9ac\u20bf\u763f\ua9be\ufcbe\u7b5b\udba6\u1957\uaac8\u23f0\u773b\ua870\ufda1\u7a09\uda17\u1839\uab5f\u2272\u7002\uaf4a\ufa51\u7d46\udd4a\u1fc9\uac93\u2521\u7151\uaeda\ufbae\u7c87\udc48\u1edf\uadff\u24dd\u7132\uad53\uf8a3\u7f58\udfbc\u1d99\uae8a\u2722\u7201\uacb9\uf913\u7eaa\ude91\u1c4d\uaf50\u2663\u73bf\ub32a\ue63e\u61e2\uc1ba\u036a\ub09f\u39db\u6c21\ub2d4\ue7ea\u6060\uc059\u02e3\ub187\u3800\u6d77\ub298\ue46f\u635e\uc34c\u0170\ub29d\u3bc0\u6e92\ub121\ue5ee\u6208\uc208$\ub30f\u3aa3\u6f0b\ub0e9\ue28d\u6577\uc574\u073a\ub4da\u3d4f\u682e\ub73d\ue37f\u6429\uc49c\u060e\ub516\u3c7b\u6912\ub6e4\ue3a3\u679d\uc7e5\u05b8\ub64b\u3fe3\u6a7d\ub51b\ue09b\u66fe\uc69d\u04f8\ub752\u3ee7\u6b07\ub4ee\ue18f\u69df\uc95e\u0bbc\ub88e\u3113\u64d3\ubb85\ueed7\u698f\uc876\u0aec\ub900\u3018\u65b4\uba70\uef1d\u68dc\ucb3c\u0910\uba0a\u33c4\u66df\ub952\uec7e\u6bc7\uca23\u08f5\ubb28\u3237\u672e\ub87d\ueddc\u6a8d\ucd57\u0f36\ubc12\u35da\u60c3\ubf12\uea42\u6d7d\ucdf1\u0e0a\ubd53\u3464\u6147\ube83\ueb23\u6c4e\ucc13\u0d2c\ube80\u37c5\u6224\ubd91\ue8c6\u6f51\ucf90\u0c81\ubfff\u36f5\u63a2\ubc70\ue98c\u6e74\uce1c\u7320\uc05d\u494f\u1c83\uc3f7\u96be\u11cf\ub1e0\u736d\uc119\u48dc\u1d4c\uc222\u9703\u1070\ub0f7\u728d\uc276\u4bd8\u1e53\uc12d\u94f7\u1300\ub3ca\u7182\uc37c\u4abf\u1f1c\uc01d\u950c\u12c5\ub23c\u7046\uc492\u4d16\u1817\uc786\u92af\u15a3\ub50d\u77f9\uc49d\u4cad\u19ff\uc677\u93b7\u1461\ub436\u766c\uc5f8\u4fb5\u1a6f\uc5c3\u9091\u17d6\ub7d8\u7579\uc601\u4ee2\u1bef\uc401\u91f1\u1641\ub61a\u742a\uc721\u4145\u14a0\ucbc1\u9e8b\u1984\ub9a8\u7bf7\uc8f7\u4105\u1520\uca4e\u9fcf\u18cd\ub8d4\u7a90\uc9d8\u40e3\u1635\uc900\u9cc7\u1bbd\ubb82\u793e\uca19\u437d\u17e3\uc8ff\u9d9d\u1ab6\ubae9\u782f\ucb73\u427d\u1048\ucf34\u9af1\u1d1c\ubd2d\u7f79\ucc52\u4522\u10ed\uce4c\u9b74\u1c20\ubcef\u7e9f\ucda4\u4494\u1165\ucd66\u9837\u1f10\ubfcb\u7dab\uce38", "\u1695\u4328\ua395\uf609\u7122\ud181\u13c3"};
        __rP__gH4it1 = new String[]{"\u1685\u4305\u9c6d\uf641\u7152\ud1b2\u133e\ua013\u29eb\u7c6f", "\u1687\u433b\ua393\uf643\u7150\ud1b4\u1338\ua011\u29e9\u7c61"};
        __rP__gH4it2 = new String[]{"\u16d1\u43db\u9c7f\uf63e\u71dd\ud10e\u13be\ua055", "\u1693\u4336\ua396\uf614\u7142\ud1e5\u13a7\ua028\u298f\u7c30\ua28e\uf760\u702c\ud0ef\u129d\ua17b\u28a3\u7d0a\ua1bb\uf44c", "\u1685\u4320\ua384", "\u1690\u4335\ua39d\uf608\u712b"};
        __rP__gH4it3 = new String[0];
        byte[] v0 = "\u00a8Z]\u00d6\u00da\u00a9\u00ac\u00fcm\u0007\u00c2m\u0083\u00fd\u0094m\u00bd\n=o\u008f3w\u001f\u001b\u000e5\u00b9\u00e6\u00ed\u00d0\u00fd\u0003\u001b\u00bdV\u00d8\u00aa\u00eb\u00dd(m\u00c5t;}0\u0087R\u008c\u0003A\u00d45\u00a4x\u0010\u00ccG\u00ff\u00c7\u00ed\u00ea\u0093\u00f3}\u00b5\u00e5<\u00a5\u00b9o!\u0011\u00fc?M=\u00fe,\u00eeK\u00c9Q\u00c1\u0089\u00bc\u00ec\u0003\u00e1\u00c5\u0003K\u00b1\u00c3\u00c3H\u00ac[\u00e5z\u00e1\u0093\u00af\u000f\u00a0\u009d\u00f20H\u00e5 \u0095\u0081\u00bf\u001aw\u001d\u001d\u00e4\u00ce\u00da'\u00ed\u008e\u00e73\u00f0\nA\u0096\u0098Y\u001b}\u008d\u00fdzt \u00b3.\u00b1O\u00a4\u00dc\u00ff\u0015\u00f3\r\u009e\u0088\u0014J\t\u00c9\t\u00d6\u00ef\u00a8\u00b7$\u00bdt?\u00cbt\u00ba\u007f\u00c9\f\u00fdq\u009780\u0004H\u00dc\u0086\u0006\u00e3.\u00ed\u00e0e\u0000|`s\"\u00d9\u00ec!\u00e1X\u00dc\u0002\u009c\u008c|F\u0016h\u00a7b\u00c4\u008d`$\u00fbd\u008e\u00a9\u0088Y\u009c\u00f8\u00984&\u00b9\u00a0\u00efo\u00a7\u0015\u00c6}\u00fbT\u00ed\u00bb\u00c4?\u00ad~\u00fc\u00a9\u00d7P-\b\u0017<\u0080b\u00e5\u00b5\u00c8o\u0081\u00f4\u00def\u00dc3\u00b4\u00c6\u0098\u00cf4H\u0007\u009a\u00df\u00dcu\u00c8\u00af\u00fd`\u00b2A%'\u00e5+T\u00ca\u0000h\u00aa\u001d&\u00ef\u00e1\u00b6\u00eb\u009f\u0087\u0098\u0091\u00f0\t\u00d1\u00e7\u0088\u0080d\u00f9\u00d5\u001e\u00c3\u0098\u00df\u00a8\u00874+\u00d2%9\u00dc;,jbU\u00d2\u00baL\u00f2\u00cc\u00a0Q\u00c8\u00bf\u00aa\u00d4N\u00e2\u000f\u00a7\u00c5^\u00e5L\u0094\u009a\u0090m\u009evJ\u000b\\\u00e8\u00ad\u00e7;\u0098\u00f2\u00b3\u00ab\u0094\u00ec\u0093T\u00bf\u001c\u00ae\u00ed\u0094\u0084\u00dd\u00e2f\u009a`\n\u00d6\u0087\u00be\u00fb\u0004\u0092\u00c3\u00c9\u00b2\u0015\u0082\u0095]\u00f5\u009e\u0089O!H{\u00a3K\u001e\u00ab\u0004\ttW'".getBytes("ISO_8859_1");
        Object[] v1 = "\u001c\u00b2\\#\u00b6\u0083\u00b4|".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -2003312217;
                case 1 -> 1054417394;
                case 2 -> -1068355889;
                case 3 -> 1221718436;
                case 4 -> -125059176;
                case 5 -> -1989723513;
                case 6 -> -611074931;
                case 7 -> 2133643157;
                case 8 -> 967252003;
                case 9 -> -415538972;
                case 10 -> 1400551155;
                case 11 -> -1740083825;
                case 12 -> -1128054976;
                case 13 -> -1043767402;
                case 14 -> -1927022866;
                case 15 -> -868261584;
                case 16 -> 798902608;
                case 17 -> 967470015;
                case 18 -> 1215265807;
                case 19 -> 1820487721;
                case 20 -> -1181140740;
                case 21 -> 509376482;
                case 22 -> -757102950;
                case 23 -> 1878291718;
                case 24 -> -1754244690;
                case 25 -> -1376018208;
                case 26 -> 767408086;
                case 27 -> -1577793163;
                case 28 -> 864479913;
                case 29 -> 307079500;
                case 30 -> -993368886;
                case 31 -> 72139754;
                case 32 -> 1685724961;
                case 33 -> -1282301775;
                case 34 -> -630757136;
                case 35 -> 1614351294;
                case 36 -> -432076149;
                case 37 -> -1945891781;
                case 38 -> 460390405;
                case 39 -> -2029010990;
                case 40 -> 1582439115;
                case 41 -> -1154853689;
                case 42 -> 621580233;
                case 43 -> 1536213367;
                case 44 -> 817240448;
                case 45 -> -1543621298;
                case 46 -> -2099355234;
                case 47 -> -369257035;
                case 48 -> 887877576;
                case 49 -> -12813671;
                case 50 -> 2039787767;
                case 51 -> -622152837;
                case 52 -> -2031383271;
                case 53 -> -106410878;
                case 54 -> 298292798;
                case 55 -> -1282132734;
                case 56 -> -2084978725;
                case 57 -> -683227207;
                case 58 -> 1595059150;
                case 59 -> 714881696;
                case 60 -> -1296182718;
                case 61 -> -1364412795;
                case 62 -> 407270377;
                case 63 -> 1773761062;
                case 64 -> 1471498711;
                case 65 -> -860710976;
                case 66 -> -1126374302;
                case 67 -> 943760961;
                case 68 -> -1940713771;
                case 69 -> -1082044760;
                case 70 -> -893542287;
                case 71 -> -1747177973;
                case 72 -> -1619338887;
                case 73 -> 439103221;
                case 74 -> -753683058;
                case 75 -> 1886433040;
                case 76 -> -1713324510;
                case 77 -> -835506675;
                case 78 -> -2034240237;
                case 79 -> 576623144;
                case 80 -> -404745839;
                case 81 -> -1198356661;
                case 82 -> 1745894106;
                case 83 -> -1690042872;
                case 84 -> 1977360890;
                case 85 -> 1387463845;
                case 86 -> -1860883018;
                case 87 -> 1096507814;
                case 88 -> -357534969;
                case 89 -> -1629439953;
                case 90 -> -1586142218;
                case 91 -> 1624162154;
                case 92 -> -237145437;
                case 93 -> -1977352592;
                case 94 -> 892723602;
                case 95 -> -317173044;
                case 96 -> -1065759449;
                case 97 -> 1689443629;
                case 98 -> 1558011643;
                case 99 -> 1393378100;
                case 100 -> -1413483719;
                case 101 -> 1827619143;
                case 102 -> 534304792;
                case 103 -> -1095272312;
                case 104 -> -107846903;
                case 105 -> 155754094;
                case 106 -> -1587721496;
                case 107 -> -688932027;
                case 108 -> 835241220;
                case 109 -> 1771959279;
                case 110 -> -1486117837;
                case 111 -> 1207552227;
                case 112 -> 2109929601;
                case 113 -> 992427444;
                case 114 -> -262586007;
                case 115 -> 175634231;
                case 116 -> -505506069;
                case 117 -> -1598303783;
                case 118 -> 1989186149;
                case 119 -> -1390109949;
                case 120 -> -717317285;
                case 121 -> 515716600;
                case 122 -> -782062509;
                case 123 -> -769966893;
                case 124 -> 1729894962;
                case 125 -> -465282134;
                case 126 -> -1241781676;
                case 127 -> -597929179;
                case 128 -> 1758613221;
                case 129 -> 1017736449;
                case 130 -> -233117097;
                case 131 -> -1948636591;
                case 132 -> 407328374;
                case 133 -> -883128383;
                case 134 -> 1682602342;
                case 135 -> 369492677;
                case 136 -> 1517713052;
                case 137 -> -225969902;
                case 138 -> -1739307252;
                case 139 -> -2101301796;
                case 140 -> -2131249286;
                case 141 -> -1050996511;
                case 142 -> 61567960;
                case 143 -> -1711134047;
                case 144 -> -760471475;
                case 145 -> 2070309085;
                case 146 -> -236240038;
                case 147 -> 566232644;
                case 148 -> 242549629;
                case 149 -> 358697716;
                case 150 -> 645374257;
                case 151 -> 902989752;
                case 152 -> 38800993;
                case 153 -> 1732355167;
                case 154 -> 51521777;
                case 155 -> 286580026;
                case 156 -> 815337004;
                case 157 -> -1241085141;
                case 158 -> -1391468564;
                case 159 -> 536669207;
                case 160 -> -1546804833;
                case 161 -> 590309187;
                case 162 -> -1861685548;
                case 163 -> -575970184;
                case 164 -> 1044268908;
                case 165 -> 1926768834;
                case 166 -> -1197676173;
                case 167 -> 87896703;
                case 168 -> 2044429935;
                case 169 -> 102053789;
                case 170 -> 1820030766;
                case 171 -> -2043441334;
                case 172 -> 335876635;
                case 173 -> 1404040508;
                case 174 -> 1871346976;
                case 175 -> 1817719227;
                case 176 -> 623655196;
                case 177 -> 806287725;
                case 178 -> -335540100;
                case 179 -> 1305958248;
                case 180 -> -1283853788;
                case 181 -> -735877456;
                case 182 -> -1311258490;
                case 183 -> -1650340412;
                case 184 -> -1380164770;
                case 185 -> 1827082087;
                case 186 -> 1013992397;
                case 187 -> -2134569629;
                case 188 -> 535201041;
                case 189 -> -1752353875;
                case 190 -> -996728137;
                case 191 -> 193468291;
                case 192 -> 1202245909;
                case 193 -> 876743967;
                case 194 -> 1779836349;
                case 195 -> 1795145817;
                case 196 -> 1431784504;
                case 197 -> 2020839485;
                case 198 -> -852025315;
                case 199 -> -776637617;
                case 200 -> 783726767;
                case 201 -> -731909122;
                case 202 -> -1427670699;
                case 203 -> -1641565487;
                case 204 -> 2107655990;
                case 205 -> -1404241690;
                case 206 -> -1368461298;
                case 207 -> 1083954974;
                case 208 -> -285792398;
                case 209 -> -829094401;
                case 210 -> 2135542866;
                case 211 -> -953361509;
                case 212 -> 1986683524;
                case 213 -> 317031929;
                case 214 -> 2045250196;
                case 215 -> -1820648226;
                case 216 -> 338739738;
                case 217 -> 1859921244;
                case 218 -> -1273470788;
                case 219 -> -1055031646;
                case 220 -> 1385409096;
                case 221 -> -1360603372;
                case 222 -> 855583870;
                case 223 -> -550219124;
                case 224 -> 83434727;
                case 225 -> -1306212757;
                case 226 -> 770088006;
                case 227 -> 1182978141;
                case 228 -> -1066640321;
                case 229 -> -1287352695;
                case 230 -> 272018354;
                case 231 -> 8139658;
                case 232 -> -1045960225;
                case 233 -> -1589744042;
                case 234 -> -1430732547;
                case 235 -> -1627543600;
                case 236 -> 630898157;
                case 237 -> -2020650920;
                case 238 -> -1036776170;
                case 239 -> -801202516;
                case 240 -> 1519256362;
                case 241 -> 1619248826;
                case 242 -> 1420619971;
                case 243 -> -350927772;
                case 244 -> -793786729;
                case 245 -> -1552914635;
                case 246 -> -2006778197;
                case 247 -> 759505606;
                case 248 -> 874133833;
                case 249 -> 1453798922;
                case 250 -> 357467315;
                case 251 -> 1013589651;
                case 252 -> -675897856;
                case 253 -> 667935584;
                case 254 -> 77040272;
                case 255 -> 2054331764;
                default -> -1697254242;
            });
        } while (v2 != 400);
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
            Object[] objectArray = new Object[22];
            v1 = objectArray;
            GuiSupport_OOI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = URI.create("https://fanyi-api.baidu.com/api/trans/vip/translate");
    }
}

