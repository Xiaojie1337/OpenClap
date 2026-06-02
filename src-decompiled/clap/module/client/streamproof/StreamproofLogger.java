/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.sun.jna.Native
 *  com.sun.jna.ptr.PointerByReference
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.Window
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package clap.module.client.streamproof;

import com.mojang.blaze3d.systems.RenderSystem;
import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import clap.model.EnumType_OOO0;
import clap.network.NetworkSupport_0oio_1;
import clap.nativeapi.User32WindowApi;
import clap.render.RenderSupport_ooi_1;
import clap.config.ConfigSupport_ooi_6;
import clap.render.RenderSupport_ooo_0;
import clap.render.RenderSupport_oooo_2;

/*
 * Renamed from psx.Hyk.0o0i
 */
public final class StreamproofLogger {
    public static boolean OOi;
    public static User32WindowApi O0i;
    public static final ConfigSupport_ooi_6 OOo;
    public static RenderSupport_ooo_0 HelpCommand;
    public static boolean OoO;
    public static NetworkSupport_0oio_1 O0o;
    public static MinecraftClient HudElement;
    private static boolean Oo0;
    public static Window EventBusApi;
    public static final Set GuiSupport_OOI;
    public static PointerByReference ConfigSupport_O0I;
    public static final Logger PacketEvent;
    private static boolean Ooo;
    static Object OoI;
    private static volatile /* synthetic */ long __k__gH4it;

    public static void OOo() {
        if (O0o != null) {
            O0o.OOo();
        }
        OOo.OOi();
    }

    static {
        __k__gH4it = StreamproofLogger.__k__gH4it((long)-6096533012021776879L);
        __rP__gH4it0 = new String[]{"\u179c\u4b65\u9411\uc191\u469a\u5ad4\u214e\u97cb\u1686\u4460\u9b38\ucee6\u4985\u5508\u2edf\u98fd\u194d\u4441\u9a35\ucffb\u4823\u5419\u2ffb\u9918\u18de\u455e\u9991\ucca3\u4bcd\u572e\u2caf\u9aa3\u1be6\u468a\u981e\ucdaf\u4aaf\u561c\u2d42\u9bbf\u1a42\u47de\u9871\uca07\u4d89\u51ec\u2a3b\u9c10\u1d89\u4071\u9fa6\ucb65\u4c37\u50dc\u2bd0\u9d03\u1c2f\u4127\u9e93\uc8e4\u4fd2\u531a\u280a\u9e51\u1fd8\u42a7\u9d9b\uc983\u4e7e\u5266\u29eb\u9f08\u1eb8\u4397\u9c87\uc9d9\u7198\u6d60\u1623\ua07f\u213e\u7c3f\ua3fb\uf694\u70ff\u6c88\u174c\ua18b\u209f\u7d0a\ua2eb\uf7cb\u737e\u6f9d\u1477\ua2ce\u2385\u7e3c\ua17b\uf4f1\u727a\u6eac\u15b0\ua30f\u22e1\u7f05\ua055\uf541\u729d\u69e3\u1277\ua4a6\u2533\u7838\ua7bc\uf211\u759a\u68ad\u13ef\ua5bf\u24ab\u7918\ua6a6\uf358\u74aa\u6b64\u1018\ua69e\u2728\u7a6e\ua53d\uf04f\u7743\u6ab0\u11ef\ua71f\u267e\u7b85\ua4e9\uf1c2\u7666\u6a30\u1e7f\ua8a2\u2937\u74e3\uabd5\ufe0c\u795c\u6594\u1fd6\ua9b6\u28f6\u753a\uaa33\uff4c\u78e7\u64e4\u1cfc\uaac3\u2b4e\u7694\ua9e8\ufcda\u7b5b\u67a0\u1de9\uab9b\u2aa4\u773a\ua85a\ufde2\u7a0b\u668f\u1d27\uacc4\u2d74\u70ad\uaff3\ufadb\u7ddb\u61c1\u1aa5\uad28\u2cca\u7127\uaed6\ufb0f\u7cc8\u60ae\u1b77\uae8b\u2f9c\u722b\uadbf\uf89e\u7f0a\u6397\u18a6\uaf13\u2ed1\u7309\uacd6\uf9d8\u7ec5\u62bb\u195a\uaf2c\u3130\u6c87\ub3bd\ue694\u614d\u7dfc\u066b\ub0f9\u3073\u6da9\ub21e\ue769\u6053\u7cc0\u07e6\ub1bd\u33d3\u6e3b\ub18f\ue46d\u630e\u7f49\u04f4\ub215\u32e6\u6fc3\ub0c1\ue53e\u628a\u7ef3\u0523\ub322\u32f7\u6808\ub7be\ue248\u659c\u79ba\u02bc\ub4d6\u3541\u695b\ub6e7\ue3f0\u64d9\u78b6\u03fa\ub516\u349d\u6a6e\ub5f2\ue0b9\u67ff\u7bf6\u0003\ub6c7\u378f\u6b5f\ub4fd\ue1a4\u6642\u7aae\u0124\ub74e\u363f\u6b3f\ubb2d\uee4d\u6906\u75c0\u0e2e\ub85c\u3949\u644c\ubab3\uef4b\u686c\u74c5\u0fe0\ub982\u3833\u65ee\ub9a2\uec29\u6be7\u7756\u0ceb\uba4f\u3b5c\u66b0\ub95b\ued3a\u6a84\u7605\u0ddd\ubba4\u3ab1\u6796\ub8a0\uea8d\u6d77\u7151\u0a4f\ubc4f\u3d68\u60da\ubf6e\ueb5d\u6cc7\u707d\u0be3\ubd86\u3c5b\u61a4\ube7f\ue8e7\u6fd5\u7301\u08cb\ube06\u3fc5\u6217\ubd91\ue8d6\u6e34\u720c\u0903\ubfd3\u3ec0\u635e\ubcd2\ue9f2\u1138\u0d9a\u76c8\uc0a0\u4166\u1cd8\uc33d\u961c\u1023\u0ca2\u77bb\uc1f7\u40f7\u1dd9\uc285\u97a7\u1360\u0f61\u7419\uc286\u43be\u1e07\uc1a5\u94b1\u1321\u0e04\u75c8\uc387\u42a5\u1f42\uc096\u95d2\u127f\u0953\u7274\uc455\u450b\u18da\uc7a5\u9249\u155d\u08b8\u731a\uc509\u4479\u1926\uc624\u93f9\u143e\u0bdb\u70e1\uc650\u47c0\u1aac\uc585\u90ee\u1769\u0be1\u7104\uc74a\u4661\u1b3c\uc4bb\u916d\u16f9\u0a36\u7e53\uc822\u49bc\u14f2\ucb47\u9ee4\u197a\u05f8\u7f0c\uc987\u48d8\u15d6\ucad1\u9fba\u1827\u049b\u7ce0\ucabb\u4b18\u16fd\uc9a9\u9cea\u1bfb\u077d\u7cac\ucbeb\u4ad3\u17c8\uc8db\u9d54\u1ae0\u066e\u7da9\ucce1\u4d65\u10fc\ucfa4\u9a21\u1d49\u01ce\u7a41\ucd99\u4cce\u11f1\uce4b\u9ba8\u1c26\u009d\u7b28\ucef3\u4f94\u12ca\ucd52\u989d\u1ff3\u0371\u7814\uce00\u4ef0\u139a\uccfe\u9932\u1e7c\u026c\u7904\ucf88\u512f\u0c7b\ud317\u861e\u01d3\u1d97\u6633\ud0c4\u5028\u0dba\ud20a\u8794g\u1cbd\u67c3\ud118\u53a1\u0ec4\ud1cd\u841c\u0329\u1f64\u64c9\ud288\u5333\u0ff8\ud0d4\u8591\u0285\u1e5e\u6568\ud306\u521c\u0816\ud749\u82c0\u05aa\u1937\u6258\ud47f\u55b4\u091e\ud611\u832d\u047c\u18dd\u6376\ud555\u54c8\u0a57\ud5a9\u8048\u07a7\u1bf0\u6009\ud681\u5753\u0a53\ud4fe\u8147\u06b2\u1a2f\u61bf\ud77f\u562b\u0b16\udb15\u8e50\u09da\u15cf\u6ee3\ud863\u590f\u043c\uda12\u8fdb\u0866\u14d1\u6f6c\ud917\u58e4\u0546\uda52\u8c43\u0beb\u17be\u6c9f\udaa5\u5b8c\u060a\ud994\u8da2\u0a71\u161b\u6db9\udb16\u5ac3\u074e\ud87f\u8a08\u0d1e\u1168\u6aa1\udcc5\u5dcdq\udfb0\u8bda\u0c13\u10c2\u6b2c\udd5a\u5ccb\u013e\ude28\u8b1b\u0f75\u1361\u6847\udedf\u5fe4\u0221\uddd9\u887f\u0ec3\u1223\u6956\udfbc\u5e9d\u03c5\udce7\u89de\u3106\u2d00\u56af\ue060\u61a6\u3caf\ue316\ub6f1\u3052\u2cfe\u5747\ue189\u6035\u3d39\ue2d8\ub7c3\u30b5\u2f15\u549d\ue2cf\u63f8\u3e88\ue1a1\ub401\u333f\u2ea1\u551d\ue3f3\u6288\u3f70\ue08a\ub569\u32cc\u29f4\u5286\ue418\u65bf\u388c\ue7dc\ub211\u3549\u28bd\u53cc\ue5c4\u64e4\u39b6\ue669\ub31b\u3452\u28cd\u50a3\ue6a7\u67a5\u3a3d\ue5a0\ub07e\u37b4\u2baa\u51c9\ue75a\u6634\u3b3d\ue45a\ub1e2\u36d4\u2af8\u5e83\ue8fe\u6947\u34e9\ueb51\ube00\u392b\u2546\u5f9f\ue96c\u6837\u3577\ueabf\ubf6e\u3812\u2423\u5f16\uea2d\u6b7c\u3664\ue97b\ubc9a\u3ba8\u2751\u5c91\ueba0\u6aac\u377e\ue8a5\ubd5a\u3a2c\u26e0\u5d72\uecfb\u6d4d\u30cd\uefab\uba7e\u3d98\u21f3\u5a76\ued90\u6cf9\u314d\uee32\ubbac\u3c7a\u2044\u5bbb\uedcf\u6f25\u3238\ued1d\ub8ad\u3f6c\u2398\u58e1\uee3f\u6e33\u3327\uec71\ub9a3\u3edc\u222c\u59bf\uef17"};
        __rP__gH4it1 = new String[]{"\u15a1\u48cd\u97ad\uc201\u4512\u5972\u2242\u9456\u154f\u49a7", "\u15b5\u48fc\u97d8\uc25a\u4580\u5927\u225d\u946b\u14a9\u49fa\u96d0\uc33e\u44ee\u582d\u2367\u9538\u1785\u4ac0\u95f5\uc002", "\u15b6\u48ff\u97d3\uc246\u45e9"};
        __rP__gH4it2 = new String[]{"\u15a3\u48f3\u97d3\uc203\u4510\u5974\u2244\u9454\u154d\u49a9", "\u15a3\u48ea\u97c2", "\u15b3\u48ee\u97db\uc24b\u45e0\u5947\u2239"};
        __rP__gH4it3 = new String[]{"\u15c2\u484b\u97f5\uc2d8\u4532\u5973\u2251\u945a"};
        byte[] v0 = "\u009d\u00ec\u00ea\u00d4\u00a9\u0081 \u00bf\u008f\u00e1\u00fb\u00db\u008e\u00a5\u0089\u00f1|8\u00fe\u00ce \u00bc\u00a5\u001c\u00e7/B\u008e\u00d6\u0093\u00e9\u00bf\u00c7\u00e3\u00c5\u008a\u00bc\u00a9\f\u00abk\u00bfR\u001a\u00e2a\u008d<\u00d8(\u008dpTYn'vv\u00a0\u00e9\u00a9\u0087\u00acm\u0099\u00ee\u00a0\u0086\r\u00f3E<\u00f1\u00d6\u0084$\u00d3\u008d\u00b5\u00b3O\u0006\u00f0a\u00bcm\u00d2O\u00e6;\u00f8&%`\u00f1\u0012\u00e4\u0015`\u0014)Y>\u00db\u0088$6\u009c6.\u0081J\u00a2!\u00d7\u00c49h\u0011[2\t\u00d5\u0095\u0011\u00b9\u00feb\u00a9gF\u008a\u00f0e\u0001\u00eb\u00f7\u0084\u00aa\u007f\u00ed\u001d\u00a9.\u0086\u001a\u009e\u00b9\u00df\u00b1\b2O\u00cb`\u00e1|\u00d9:_\u00ef}\u00b3\u007f\u00c8\u0095'\u000f\r\u00db\u00f9\u007f\u00e0\u0082\u0011h\u00a5tXN8\u00c4\u009b\u008c\u0013\u00f6e\u00823\u00b3Q7]\u00e2\u0004\u001b\u00f9\u0082\u0088\u00a7\u0018\u00c8U\u00a5\u000e\u00d6L`\u00c1>6\u00e1\u008e\u0099u\u00bd\u008a\u0018\u008d\u0004\u0088\u00bd\u00e0\u00e12\u0092\u0014\b\u00dd<\u00faA\u000fb\"c\u00a1\u00beUN\u00e6\u0091U\u001d\u00bf\u00ff\u00c2\u00b2X\u00ca\u0014\u00bd\u00e2\u00eb\u009cj\u009c\u00e7\t\u00fc\u00cc\u00a3m\u00b3\u0086\u00de>\u0099I\u0003rB\u000eF\u00e6x\u0005epXp=`fwx\u00a6\u009e\u0012\u0087y\f\u00f4\u00e3\u00a5[u\u00d1x'\u00ef\u0088k\u0088\u00e0\u00cf\u008b\u0098\u0014\u00d4\u00f1k1\u008b]P\u00bc\u00e0E\u00ba\u001a\u00edD\u00e2\u00a6\u0094e2\u008cV\u0092+\u007f\u00e1\u0095\u001f\u00b1g\u00d9\u0007{\u007fVd\u001f\u00e9.\u00f1x_=+\u0096\u00f0\u009eB3\u0094\u0097R\u00d7&\u00c6l\u008a\u00c9>k4[\u00fd\u0007\u00dc\u0096\u008a\u00b1\u0092\u00cb\u00d6\u0084\u00e6e\u00fc\u00f5\u00f8/_<\u008d\u000e\u000f\u00a4I\u00ad\u00c6S\u00e2\u00cc\u00d2\u00c6\u00d0\u00c5\u00f0\u00d8z\u0013\u008d\u00a6\u0005\u0003\u0014I\u00e1\u00c5\u00ca\u001by?\u008a\u001f\u00b4\u00ae./\u00b1\u001c\nw\u0010p\u009aG\u0002\u0011p\u00c1\u0003k\u0097E\u00bc-\u0017\u00ac\u00b2\u00d3g%\u000f8\u00f0-\u00d5\u0088\u0006G]\u000b\u00d1\u00e08\u001c\u0002L\u0001#uG\u00bf\t\u001a\u00cc\u00d6\u00ca\u0084s\b\u00ea5\u0098\u00c9\u0013\u0091\u00f1\u00b4\u00c8\u00cdLHe.A\u0002)\u00bf\u00e4\"a?\u00c4\u00a6\u001b\u0016b\u0005\u0087\u00ba\u008d\u0091j>\u0003\u00b5\u0097\u00eahO\u0088\u0018!\u00c1\u00d6ju\u00ac]_\u008db*5r\u00b1\u008a\u00e1{\u0012g\u00c6}\u00c1r\u00a5\u007f.U\u00c9\u00feud\"\u0003\u00cd'q^\u00803)\u0089\u00ddS\u00bf\u00b7\u0012\u009e\u00072\u009a\u001fL\u0005e\u00f5\u0007\u00f9\u008c8\u008b\u00df`W\u0082n\u0082\u007f+\u00e6>\u008c\u00d1\u0013\u0095\u0018\u00d2\u008a\u0080\u00c6\u00c8x\u00e4\u00f4\u00f43]\u00fd)\u00bc\u00c7\u0086\r\u0014\u0001\u000b\u00c9]\\\u0018\u00bb\u001e\u001e\u00d8k#i\u0091\u00ca\u00d4\u009cd\u00e3\u0017\u0011a\u00f9\u00a4w)`\u00e4>\u0085\u00a7\u00d4\u00fah\"0m\u00b7*\u00a6\u00d9\u00e0u+\u0014\u00c4\u00eb\u00cb7\u008f\u0017\u00de\u008d\u00cc\tOO\u00c5Eb\u00e6\u0000\n\u00a5\u00b8sQ\u00f8\u009e\u0096\u001c\u00f3\u00f9. \u0081\u00ad\u00bd\u00d0\u000fKT\u00af\u0004u\u00af\u0016\u00d7\u00d7\u00fdTG\u008c\u0004\u0010\u00fbk\u00e6X$0\u008c\u00b1\u00d1\u00b1)\u00ad\u0083\u00d4\u0081\u0096\u00d8\u00af\u00fd\u00ff{\u00ca\u0096\u00e2\u00ce\u0007Q\u00b9K".getBytes("ISO_8859_1");
        Object[] v1 = ")\u00e8h\u00bb\u001b<!0".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 837680774;
                case 1 -> -1450240674;
                case 2 -> 1346571665;
                case 3 -> 1120617073;
                case 4 -> 1601979631;
                case 5 -> -1981182199;
                case 6 -> 1272111974;
                case 7 -> -151235258;
                case 8 -> 820876715;
                case 9 -> -586678591;
                case 10 -> -962506969;
                case 11 -> 1684159244;
                case 12 -> -65805302;
                case 13 -> -1568380609;
                case 14 -> 1933027870;
                case 15 -> 1295553753;
                case 16 -> -550995511;
                case 17 -> 1988051497;
                case 18 -> -173928116;
                case 19 -> 832173812;
                case 20 -> 1968957104;
                case 21 -> 325352576;
                case 22 -> -103720295;
                case 23 -> 1303517308;
                case 24 -> 1278323752;
                case 25 -> -1210221649;
                case 26 -> 1241012431;
                case 27 -> -2031035632;
                case 28 -> -541814137;
                case 29 -> -193370272;
                case 30 -> 587828590;
                case 31 -> 449661366;
                case 32 -> -1899097861;
                case 33 -> 1428793240;
                case 34 -> -1508254279;
                case 35 -> 1492513403;
                case 36 -> 316429247;
                case 37 -> 1481145022;
                case 38 -> 146789261;
                case 39 -> -1463922421;
                case 40 -> 1665646536;
                case 41 -> 2075919659;
                case 42 -> 63866894;
                case 43 -> 1416563754;
                case 44 -> 2022831255;
                case 45 -> -1456975686;
                case 46 -> 575034290;
                case 47 -> -15119016;
                case 48 -> 1466282666;
                case 49 -> -2008615693;
                case 50 -> -1723550089;
                case 51 -> -1863615744;
                case 52 -> -53464695;
                case 53 -> -761036208;
                case 54 -> -1872739758;
                case 55 -> -1123545340;
                case 56 -> -700336309;
                case 57 -> -1972901197;
                case 58 -> 2138332205;
                case 59 -> -523936822;
                case 60 -> 461148792;
                case 61 -> 1322540310;
                case 62 -> -22273011;
                case 63 -> -649630635;
                case 64 -> -1284065720;
                case 65 -> 414349554;
                case 66 -> 115009582;
                case 67 -> -405574693;
                case 68 -> -391930019;
                case 69 -> -1748258388;
                case 70 -> -836510832;
                case 71 -> -649191836;
                case 72 -> -1973335523;
                case 73 -> -1536730091;
                case 74 -> -1093008891;
                case 75 -> 1213035656;
                case 76 -> -1180936364;
                case 77 -> -1386958921;
                case 78 -> 1201442747;
                case 79 -> 88028364;
                case 80 -> 1668064823;
                case 81 -> 1883876167;
                case 82 -> -1287449126;
                case 83 -> -475708763;
                case 84 -> -961739492;
                case 85 -> 1470616295;
                case 86 -> -932160635;
                case 87 -> 1888096563;
                case 88 -> -1767519415;
                case 89 -> -1975254841;
                case 90 -> -1965447367;
                case 91 -> 1666592497;
                case 92 -> -1240769222;
                case 93 -> -1881219237;
                case 94 -> 918279422;
                case 95 -> 156893853;
                case 96 -> -804318907;
                case 97 -> -1412447486;
                case 98 -> 14059597;
                case 99 -> -68340077;
                case 100 -> -2108561901;
                case 101 -> -12849299;
                case 102 -> -1915135456;
                case 103 -> 1127700647;
                case 104 -> 1869478606;
                case 105 -> -1320124348;
                case 106 -> -1430927402;
                case 107 -> -1563712689;
                case 108 -> -1748713222;
                case 109 -> -694841775;
                case 110 -> -16500644;
                case 111 -> 1534859796;
                case 112 -> 982343122;
                case 113 -> 1825915971;
                case 114 -> 450462312;
                case 115 -> -1117370975;
                case 116 -> 1426042289;
                case 117 -> 1467606453;
                case 118 -> -179463079;
                case 119 -> -1468118390;
                case 120 -> 2116933293;
                case 121 -> -185460121;
                case 122 -> 936082522;
                case 123 -> -1492960925;
                case 124 -> 1424453565;
                case 125 -> 1222309824;
                case 126 -> 1196249825;
                case 127 -> -560877516;
                case 128 -> 1193186327;
                case 129 -> 883133392;
                case 130 -> 254249836;
                case 131 -> 1211646488;
                case 132 -> 150502673;
                case 133 -> 961933413;
                case 134 -> 70803405;
                case 135 -> -1203553045;
                case 136 -> 1379428763;
                case 137 -> 1835938187;
                case 138 -> -2106011354;
                case 139 -> 1638642467;
                case 140 -> 877459506;
                case 141 -> -513311690;
                case 142 -> -1790484993;
                case 143 -> -110102198;
                case 144 -> -1355467024;
                case 145 -> -1859362089;
                case 146 -> -342637150;
                case 147 -> 433710572;
                case 148 -> -923532181;
                case 149 -> 807353316;
                case 150 -> 1603710957;
                case 151 -> 1461291662;
                case 152 -> -677536283;
                case 153 -> -717496840;
                case 154 -> 1027018963;
                case 155 -> -740211882;
                case 156 -> -2106303361;
                case 157 -> -1927006334;
                case 158 -> -1377138788;
                case 159 -> 1746550336;
                case 160 -> 675743970;
                case 161 -> -1526886028;
                case 162 -> 872232228;
                case 163 -> 1402396450;
                case 164 -> 1502890033;
                case 165 -> -1558416340;
                case 166 -> 1828762102;
                case 167 -> 1696246950;
                case 168 -> 1092355387;
                case 169 -> 635008984;
                case 170 -> -488042478;
                case 171 -> -1184523389;
                case 172 -> -1765745723;
                case 173 -> -1781953995;
                case 174 -> 811221213;
                case 175 -> 678095328;
                case 176 -> -869735167;
                case 177 -> -751276978;
                case 178 -> 1175919598;
                case 179 -> -289806852;
                case 180 -> -642876635;
                case 181 -> -546548092;
                case 182 -> 145159878;
                case 183 -> -1868479266;
                case 184 -> -1842956735;
                case 185 -> 1428565857;
                case 186 -> -1923249161;
                case 187 -> -1308886388;
                case 188 -> -435369976;
                case 189 -> 826388847;
                case 190 -> -264466955;
                case 191 -> 589339039;
                case 192 -> -1879143762;
                case 193 -> -1735565144;
                case 194 -> 2145729567;
                case 195 -> -1889877079;
                case 196 -> 1718076770;
                case 197 -> -1691729708;
                case 198 -> -180106887;
                case 199 -> -1914163373;
                case 200 -> -167833751;
                case 201 -> 1547671814;
                case 202 -> -1325045699;
                case 203 -> -1175896835;
                case 204 -> 529553433;
                case 205 -> -288403606;
                case 206 -> -729459082;
                case 207 -> 1917791294;
                case 208 -> -1765904712;
                case 209 -> -633631993;
                case 210 -> 1038890460;
                case 211 -> -422548326;
                case 212 -> 1076238384;
                case 213 -> -891896088;
                case 214 -> 1795195296;
                case 215 -> -1265790261;
                case 216 -> 1357024637;
                case 217 -> -253543211;
                case 218 -> 1927155070;
                case 219 -> 43511127;
                case 220 -> -1860407613;
                case 221 -> -84410833;
                case 222 -> 1068873380;
                case 223 -> 1714737986;
                case 224 -> 1816759011;
                case 225 -> 873743472;
                case 226 -> 102091535;
                case 227 -> -691599238;
                case 228 -> 1297416598;
                case 229 -> -503046724;
                case 230 -> 1783550869;
                case 231 -> 1140452867;
                case 232 -> -1202938940;
                case 233 -> -1705761419;
                case 234 -> -1919962737;
                case 235 -> 2086688607;
                case 236 -> 1336505236;
                case 237 -> 1932714946;
                case 238 -> 1183796201;
                case 239 -> -1452072225;
                case 240 -> 1981230619;
                case 241 -> 243445428;
                case 242 -> 1950955553;
                case 243 -> -973469959;
                case 244 -> 402551608;
                case 245 -> -666436494;
                case 246 -> -1212802414;
                case 247 -> -810865023;
                case 248 -> -1085513242;
                case 249 -> 180646771;
                case 250 -> -88102959;
                case 251 -> -1569418518;
                case 252 -> -516285282;
                case 253 -> 1113274787;
                case 254 -> 976979482;
                case 255 -> 632037436;
                default -> 645188944;
            });
        } while (v2 != 736);
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
            Object[] objectArray = new Object[38];
            v1 = objectArray;
            OoI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = LogManager.getLogger((String)"Streamproof");
        HelpCommand = new RenderSupport_ooi_1();
        OOo = new ConfigSupport_ooi_6();
        GuiSupport_OOI = new HashSet();
    }

    public static void OOi() {
        if (!OoO || !Ooo) {
            return;
        }
        RenderSupport_ooo_0 v0 = HelpCommand;
        if (v0 instanceof RenderSupport_ooi_1) {
            RenderSupport_ooi_1 v1 = (RenderSupport_ooi_1)v0;
            v1.OOi();
            if (v1.HelpCommand != null) {
                v1.HelpCommand.PacketEvent();
            }
        }
    }

    private static void HudElement() throws Exception {
        String v0 = System.getProperty("os.arch").toLowerCase();
        boolean v1 = v0.contains("64") || v0.equals("amd64") || v0.equals("x86_64");
        String v2 = v1 ? "/libs/MinHook.x64.dll" : "/libs/MinHook.x86.dll";
        try (InputStream v3 = StreamproofLogger.class.getResourceAsStream(v2);){
            if (v3 == null) {
                throw new IllegalStateException("Missing " + v2);
            }
            File v4 = new File(StreamproofLogger.HudElement.runDirectory, "native");
            v4.mkdirs();
            File v5 = new File(v4, "MinHook-" + ProcessHandle.current().pid() + ".dll");
            try (FileOutputStream v6 = new FileOutputStream(v5);){
                v3.transferTo(v6);
            }
            v5.deleteOnExit();
            O0i = (User32WindowApi)Native.load((String)v5.getAbsolutePath(), User32WindowApi.class);
        }
    }

    public static void GuiSupport_OOI() {
        if (!OoO || !Ooo) {
            return;
        }
        GuiSupport_OOI.clear();
        OOi = false;
        RenderSupport_ooo_0 v0 = HelpCommand;
        if (v0 instanceof RenderSupport_ooi_1) {
            RenderSupport_ooi_1 v1 = (RenderSupport_ooi_1)v0;
            if (v1.PacketEvent != null) {
                RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(v1.PacketEvent.method_30277(), 0, v1.PacketEvent.method_30278(), 1.0);
            }
            if (v1.HelpCommand != null && v1.HelpCommand.EventBusApi) {
                v1.HelpCommand.OOi();
            }
        }
    }

    public static void PacketEvent() {
        if (Oo0) {
            return;
        }
        Oo0 = true;
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            PacketEvent.warn("Streamproof disabled: Windows only");
            return;
        }
        try {
            HudElement = MinecraftClient.getInstance();
            EventBusApi = HudElement.getWindow();
            StreamproofLogger.HudElement();
            if (O0i.MH_Initialize() != 0) {
                PacketEvent.warn("Streamproof disabled: MinHook initialization failed");
                return;
            }
            StreamproofLogger.EventBusApi();
            O0o = new NetworkSupport_0oio_1();
            OoO = true;
            PacketEvent.info("Streamproof early init complete");
        }
        catch (Throwable v0) {
            PacketEvent.error("Streamproof initialization failed; continuing without streamproof", v0);
        }
    }

    private StreamproofLogger() {
    }

    private static void EventBusApi() {
        RenderSupport_oooo_2.add("CHAT_MESSAGES_OVERLAY", "Chat Messages", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("CHAT_INPUT_OVERLAY", "Chat Input", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("F3_OVERLAY", "F3", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("SCOREBOARD", "Scoreboard", EnumType_OOO0.Gui, false);
        RenderSupport_oooo_2.add("PLAYERLIST", "Player List", EnumType_OOO0.Gui, false);
        RenderSupport_oooo_2.add("SUBTITLES", "Subtitles", EnumType_OOO0.Gui, false);
        RenderSupport_oooo_2.add("CLAP_HUD", "Clap HUD", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("CLAP_CLICKGUI", "Clap ClickGUI", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("CLAP_HUD_EDITOR", "Clap HUD Editor", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("CLAP_RENDER_2D", "Clap Render 2D", EnumType_OOO0.Gui, true);
        RenderSupport_oooo_2.add("CLAP_RENDER_3D", "Clap Render 3D", EnumType_OOO0.World, true);
    }

    public static void HelpCommand() {
        if (Ooo || !OoO) {
            return;
        }
        Ooo = true;
        try {
            HudElement = MinecraftClient.getInstance();
            EventBusApi = HudElement.getWindow();
            RenderSupport_ooo_0 v0 = HelpCommand;
            if (v0 instanceof RenderSupport_ooi_1) {
                RenderSupport_ooi_1 v1 = (RenderSupport_ooi_1)v0;
                v1.PacketEvent();
            }
            PacketEvent.info("Streamproof late init complete");
        }
        catch (Throwable v1) {
            OoO = false;
            PacketEvent.error("Streamproof late initialization failed; disabling streamproof", v1);
        }
    }
}

