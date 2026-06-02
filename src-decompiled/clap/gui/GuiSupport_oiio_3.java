/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.hud.ChatHud
 *  net.minecraft.client.gui.hud.ChatHudLine
 *  net.minecraft.client.gui.hud.ChatHudLine$Visible
 *  net.minecraft.nbt.NbtElement
 *  net.minecraft.nbt.NbtString
 *  net.minecraft.network.message.MessageSignatureData
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$Custom
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  net.minecraft.util.Identifier
 */
package clap.gui;

import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtString;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import clap.mixin.ChatHudAccessor;
import clap.event.EventBusApi;
import clap.model.DataRecord_OII0;
import clap.model.EnumType_o0o0_0;
import clap.model.DataRecord_oi0_0;
import clap.module.client.ChatTranslatorModule;
import clap.render.RenderSupport_ooi_0;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.OiIO
 */
public final class GuiSupport_oiio_3
implements EventBusApi {
    public static final Identifier IoOo;
    private static final Map IoOI;
    private static final Map IoOi;
    static Object Io0O;
    private static volatile /* synthetic */ long __k__gH4it;

    public static void OOiII(String param02) {
        ChatTranslatorModule v1 = (ChatTranslatorModule)0ooo.00o0().oo0i(ChatTranslatorModule.class);
        if (v1 == null || !v1.IoOo()) {
            GuiSupport_oiio_3.O0OOO("Translator module is disabled.");
            return;
        }
        if (v1.II0o()) {
            GuiSupport_oiio_3.O0OOO("API_KEY mode is only reserved in Translator.java right now. Current implementation uses GENERAL_APP_ID + GENERAL_SECRET.");
            return;
        }
        if (!v1.IIOo()) {
            GuiSupport_oiio_3.O0OOO("Please fill GENERAL_APP_ID and GENERAL_SECRET in Translator.java.");
            return;
        }
        if (!v1.IIOI()) {
            GuiSupport_oiio_3.O0OOO("Wrong credential type. Fill GENERAL_APP_ID + GENERAL_SECRET, not the API_KEY slot.");
            return;
        }
        ((CompletableFuture)v1.IIO0().PacketEvent(param02, ((EnumType_o0o0_0)((Object)v1.oOo0.HelpCommand())).KeystrokesHudElement(), ((EnumType_o0o0_0)((Object)v1.oOoo.HelpCommand())).KeystrokesHudElement()).thenAccept(param0 -> ConfigSupport_OI0.execute(() -> {
            if (GuiSupport_oiio_3.ConfigSupport_OI0.player == null || GuiSupport_oiio_3.ConfigSupport_OI0.player.networkHandler == null) {
                GuiSupport_oiio_3.O0OOO("Player connection is not available.");
                return;
            }
            GuiSupport_oiio_3.ConfigSupport_OI0.player.networkHandler.sendChatMessage(param0);
        }))).exceptionally(param0 -> {
            ConfigSupport_OI0.execute(() -> GuiSupport_oiio_3.O0OOO(GuiSupport_oiio_3.O0OO0(param0)));
            return null;
        });
    }

    static {
        __k__gH4it = GuiSupport_oiio_3.__k__gH4it((long)-5547922760400900591L);
        __rP__gH4it0 = new String[]{"\u591a\u3417\ueb5b\ube20\u3865\u60bd\u7b58\ue9c2\u589f\u3598\uea8c\ubf79\u3b3f\u631e\u78d7\ueac9\u5b5b\u360d\ue975\ubcbb\u3ae5\u6230\u797f\ueb48\u5a12\u370b\ue802\ubd6b\u3d93\u6506\u7e08\uec8c\u5d34\u30d1\uefaa\uba96\u3d95\u645b\u7fa1\ued57\u5cdf\u317d\ueea4\ubb29\u3c75\u67f6\u7cea\uee6a\u5fc0\u3228\ued26\ub858\u3f1b\u66fb\u7d1a\uef7c\u5e6c\u3393\ueceb\ub970\u3ee0\u799a\u622f\uf0c7\u4109\u2c8a\uf3bf\ua60a\u2131\u79a2\u6352\uf103\u40a5\u2d8a\uf27e\ua74e\u201e\u78c2\u601b\uf255\u433a\u2ef6\uf1fc\ua43a\u2367\u7b85\u6136\uf3b3\u42cb\u2f04\uf0b3\ua5de\u22b7\u7a8b\u66dd\uf42b\u457a\u289b\uf7cf\ua252\u25d0\u7dab\u667d\uf56a\u4410\u2918\uf6e6\ua3b3\u2401\u7c6d\u671c\uf69e\u47e1\u2a8e\uf51e\ua00a\u27d1\u7fe1\u6404\uf79e\u46d2\u2b8e\uf4a0\ua1d3\u26c9\u7eed\u658b\uf84f\u4946\u248b\ufb56\uaea6\u2930\u71f8\u6a9f\uf843\u488b\u2504\ufa7a\uafab\u2807\u7084\u6b26\uf94b\u4b50\u2620\uf9e4\uac75\u2b2a\u7343\u683d\ufa1c\u4a4c\u2713\uf82e\uad69\u2a76\u7273\u6964\ufb46\u4a9c\u204f\uff42\uaacd\u2dec\u7560\u6e7a\ufcb7\u4d8a\u21f1\ufe3d\uabdb\u2cc6\u7490\u6f48\ufd6c\u4c82\u2219\ufdd0\ua824\u2f65\u77a0\u6cab\ufe35\u4f71\u2334\ufc4b\ua994\u2e4c\u76f4\u6d68\uff9c\u4e71\u23ef\u037c\u5625\ud13b\u896e\u922a4\ub17c\udc2d\u0221\u576f\ud08b\u88d0\u9363\u0154\ub019\uddf8\u01e7\u54f7\ud30b\u8b95\u9025\u02c7\ub334\ude9e\u00af\u559f\ud21c\u8a26\u9110\u031c\ub2f3\udf74\u00b8\u5252\ud5d1\u8d23\u9694\u04d1\ub593\ud8bb\u07f0\u5339\ud4e7\u8cc2\u9788\u053f\ub46f\ud9c8\u0633\u5012\ud711\u8f00\u9421\u0671\ub7c3\udaae\u052a\u5191\ud69d\u8e5f\u9567\u07cb\ub6fb\udb94\u0468\u5103\ud9cc\u8151\u9a5b\u0814\ub9a2\ud428\u0b02\u5e5a\ud80b\u801f\u9bde\u09f5\ub862\ud584\u0ac4\u5f44\udb8f\u83ab\u9837\u0aa7\ubb3d\ud67b\u0972\u5c82\udaf4\u8222\u998a\u0b82\uba1f\ud709\u080b\u5d33\udabe\u8510\u9e07\u0cb6\ubd64\ud017\u0f02\u5ab5\uddf0\u848f\u9f58\u0d4f\ubcd9\ud125\u0ee5\u5b29\udcd8\u8778\u9cf5\u0e66\ubf7a\ud20c\u0ddd\u5893\udfd1\u864f\u9d87\u0f70\ubece\ud3c0\u0ce3\u59dc\ude41\u862c\u82a0\u1043\ua159\ucc0e\u1394\u463f\uc159\u99d9\u8367\u11ed\ua0ca\ucd9b\u12b9\u477e\uc095\u9867\u8026\u1214\ua3cc\uce9b\u1108\u44b0\uc3f9\u9bfd\u8143\u13fa\ua2cf\ucf40\u106f\u45c9\uc2d3\u9a31\u810f\u14cc\ua5d2\uc896\u177d\u4229\uc573\u9df6\u8648\u159d\ua459\uc924\u1659\u4309\uc4eb\u9cee\u8700\u1637\ua776\ucad8\u15a7\u4002\uc71d\u9f6a\u847e\u1769\ua667\ucbc5\u1425\u414c\uc67b\u9e46\u85f6\u172e\ua95b\uc46c\u1bc6\u4e87\uc953\u9113\u8ab2\u1850\ua8e4\uc5ce\u1a10\u4fba\uc852\u900c\u8bd7\u1982\uab90\uc610\u1903\u4cf2\ucbe4\u931a\u88a3\u1a8e\uab18\uc707\u1841\u4d19\uca79\u92ff\u8995\u1b38\uaa9d\uc030\u1f4d\u4a14\ucdcf\u95b4\u8ed6\u1c3d\uad57\uc145\u1ecd\u4bba\ucc21\u9449\u8fd0\u1d1e\uacc6\uc25a\u1d45\u481a\ucf23\u97fd\u8c5d\u1ee2\uaf6c\uc2e8\u1cd4\u49e9\uce0e\u9665\u8db4\u1f1e\uaeb8\uc395\u23d4\u7690\uf155\ua9f5\ub2b9\u2029\u9184\ufcab\u220d\u77c3\uf041\ua8e8\ub3e8\u2170\u90cf\ufd15\u2199\u74aa\uf3b6\uab85\ub084\u22f4\u934a\ufe9f\u2116\u758f\uf21e\uaa76\ub16c\u2345\u92d2\uffbc\u20e9\u723f\uf5de\uad7e\ub67e\u2480\u95c9\uf834\u27b8\u73e2\uf4d3\uacc8\ub74c\u2575\u94a3\uf93e\u26aa\u7011\uf71b\uaffc\ub438\u2696\u9723\ufae9\u25c2\u7078\uf694\uaed7\ub56f\u27f8\u965e\ufb18\u2461\u71e4\uf9ec\ua1d1\uba17\u28df\u9936\uf496\u2bdd\u7e13\uf820\ua0c1\ubb88\u29d8\u98bb\uf5c9\u2acf\u7f87\ufb09\ua30a\ub806\u2a11"};
        __rP__gH4it1 = new String[]{"\u5bca\u3639\ue961\ubd34\u3a57"};
        __rP__gH4it2 = new String[]{"\u5bdf\u3631\ue961\ubd4d\u3a5e\u62a6\u79d2\ueb26\u5ad1\u374b", "\u5bba\u36ee\ue97a\ubd02\u3a25\u6267\u79e1\ueb6a", "\u5bdd\u3637\ue967\ubd4f\u3a5c\u62b8\u79cc\ueb24\u5ad3\u374d", "\u5bdf\u362c\ue978", "\u5bcf\u3624\ue961\ubd35\u3a5e\u62bd\u79c7"};
        __rP__gH4it3 = new String[]{"\u5bc9\u363a\ue962\ubd20\u3a3e\u62d9\u79a3\ueb35\u5ad5\u373c\ue87a\uba54\u3d40\u65c3\u7e89\uec76\u5dd9\u3066\uef6f\uba98"};
        byte[] v0 = "\u00a7\u0018Z\u00df(V\u0088(*\u009f\u0085\u008ez\u00fd\u000f+\u00f6\u0012dT\u00b8\u00cb\u00bf\u00b2\u00b7\u001c\u001b\u008c\u00c6\u00f5\u00c0~i\u00fe\u00cbI8\u0090\u0011\u009d\u008aZ\u00cd\u00fe\u00d05R\u00a8\u008d\u0017W\u0097\u00a6 \u00ba\u00a6)\u00a4\u0092\u00b7UI\u0087\u0015tE\u00fe\u00b5\u00bc\u0089\u00c2\u00a9\u00d0M7\u00f9\u009b\u00e1\u0083\u00f7W)\u00ad\u0095\u00fa\u00be\u00b6\t\u00ae\u00d3\u00eay\"\u00b8U\u0099gtn\u00cd=\u00a0\r\u00e0\u0005\u00ffO$\u00e4nd\u001c\u00ecq\u00af\u0085,\u00fad\u0004\u00d7y\u0019T<\u00fe\u00e3\u00dd{\u0004\u00d7\u00d9\u00fd\u0093\u00cf)\u00be\u0083\u00f3\u00dc\u00c2\u00e7~)}\u00bfu\u001a\u00f78}fi\u0084\u00b7\u000e\u00a3\u0000,4A\u00e0\u00a3\u0092\u00c1+J\u00fd_V\u00d4\u008c\u00e3\u00d3p.O\u00a6!kX\u00fb\u008bo\u00b4\u0083\u00b2\u00d3y\u00a7@\u00ce\u008c\u00a0\u00bd\u001a6\u00c5:\u001e\u0089j\u00e8X\u008es{v\u00f4\u00a76\u00d8\u0016.%\u00fd\u00d1\u00c9v\u00b8\t\u0095\u0018.n\u001b\u0099M\u00bc\u00a8d\u00db\u0006\u00dc\u00d9.\u0082Ap=\u00e2\u00b7\u0002\u001dl\u009b\u00c1kF\u00d9\u0013\u0096\u00e8\u00cc\u008f\u00d9F\u009bi\u00fc\u0081\u00ba\u008b\u00fe\u0017/\u000b\u00adN\u00fc\u0006\u0017\u00cf\u009b\u00d5\u00ab\u00d2P\u00f7]\u0098lke\u00a1\u00d1BpB&j\u00ec\u0013\u00db\u00b7|10kbUL\u00e0\u008d\u0094\u001a\u0094\u00e6e\u00a3U\u00bc?;\u00a4Td\u009c/\u00a2\u00b3\u000f\u00a2c\u00cc\u00070\u00e9,\u00c9\u00dd\u0088\u00dc\u00fa\u00ffO\u00a7D\u00e8\u00d1\b\\\u00a6\u00ae\u00a9LQ\u0017l\u00ce\u00cbH\u00d2\u00af\u00ceV>:\u007fF\u00c7q\u00d4\u00be\u0096\u00f50\u001fT\u00db\u00e8\u0086\u0016\u00f5`\u00ads/\u001e\u0085\u00e8y\u0016\u00fbZJ\u00a43\u00b6-\u00a6Dn\u00ebO\u00f0\u0096p\u00ea2\u00c9Q\u0081\u00d5\u008fw\u0097\u00f8\u00b5\u0087\u009a\u00951i\u00eb\u00fc\u00c5\u00a8\u00a0FT\u00b4\u00a5rH\u0097\u00a4C\u00ea\u00f7\u00ee\u007f\u009a\u00fa<\u00f5\u001c\u0012\u00f0D\u0003\u00ed\u00bc]\u0016\u00aeu\u00b0\u0091\u00a7\u0015\u00d6\u0003\u00ce\u00a44M\u00d2\u001d\u00a7PV\u00a1\u000bi\u00f4\u00dc\u00ec\\S\u00e8J*B@\u008d\u00a36\u008c\u00c6\u00d7\u00f07\u0090s\u00fd\u009cOG\u00db\u00c0(\u00bb\u00fd\u0086\u0082DK\u0089\u00ed\u00aeS\u00aco&I\u0093\u0016no\u00d0\u0084\u009e\u00e6\u00c3\u0087\u00d9<\u00bf\u0012\u00eb\u001fh\u0013\u00a92\u00cf=\u009b\u0089\u00cc\u00fc}:H\"\u001e\u00de\u00d6`\\\u00f9\u00ce\u00e3".getBytes("ISO_8859_1");
        Object[] v1 = "-\u008bU\u0013B\u00e6\u0007v".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1880516968;
                case 1 -> -670728255;
                case 2 -> -1635431988;
                case 3 -> -1229800368;
                case 4 -> -739963283;
                case 5 -> -1907872036;
                case 6 -> -709198513;
                case 7 -> -654523668;
                case 8 -> -1296571237;
                case 9 -> 1212776447;
                case 10 -> 775300395;
                case 11 -> -1789878111;
                case 12 -> 712264322;
                case 13 -> 846273551;
                case 14 -> -140582825;
                case 15 -> 1372239142;
                case 16 -> -1471480416;
                case 17 -> 339456771;
                case 18 -> 204177886;
                case 19 -> -969867619;
                case 20 -> -1094629455;
                case 21 -> 1372458178;
                case 22 -> -2010642658;
                case 23 -> -1980159810;
                case 24 -> 1216967892;
                case 25 -> 1856326373;
                case 26 -> -522529062;
                case 27 -> -763141562;
                case 28 -> -1541139918;
                case 29 -> 1026429428;
                case 30 -> -171271894;
                case 31 -> -1192018291;
                case 32 -> 536976243;
                case 33 -> 862227612;
                case 34 -> -2106028472;
                case 35 -> 566388911;
                case 36 -> -1170126193;
                case 37 -> 775662084;
                case 38 -> -139844156;
                case 39 -> 1941892919;
                case 40 -> -1415363896;
                case 41 -> -727056849;
                case 42 -> 630729236;
                case 43 -> 1524722510;
                case 44 -> -804172958;
                case 45 -> 471802652;
                case 46 -> -1559695339;
                case 47 -> -343588838;
                case 48 -> 1904395475;
                case 49 -> -2096330264;
                case 50 -> -1816252279;
                case 51 -> 1313850669;
                case 52 -> -1456103557;
                case 53 -> 123275711;
                case 54 -> 1643547782;
                case 55 -> 1119424197;
                case 56 -> -260085809;
                case 57 -> -834226414;
                case 58 -> 1716384133;
                case 59 -> -135028253;
                case 60 -> 1662437772;
                case 61 -> -976833621;
                case 62 -> 105334493;
                case 63 -> 404644260;
                case 64 -> 31918186;
                case 65 -> 615450166;
                case 66 -> -411230784;
                case 67 -> 712924052;
                case 68 -> 746871165;
                case 69 -> -1006448724;
                case 70 -> -887201996;
                case 71 -> 1295276841;
                case 72 -> -781116407;
                case 73 -> -2017641950;
                case 74 -> 104276337;
                case 75 -> 2143055566;
                case 76 -> 533812792;
                case 77 -> -443281942;
                case 78 -> 1452611436;
                case 79 -> 2076421329;
                case 80 -> 19594560;
                case 81 -> -2077306173;
                case 82 -> -1122345795;
                case 83 -> 1002633650;
                case 84 -> 1420225993;
                case 85 -> -1449405831;
                case 86 -> -1270315900;
                case 87 -> -2070700882;
                case 88 -> -399537351;
                case 89 -> -56852148;
                case 90 -> 1744380328;
                case 91 -> -350434099;
                case 92 -> -335052587;
                case 93 -> -34145418;
                case 94 -> -791133648;
                case 95 -> 528982678;
                case 96 -> 474223891;
                case 97 -> -1651328185;
                case 98 -> -964130035;
                case 99 -> -1504114190;
                case 100 -> -298059400;
                case 101 -> -1224560067;
                case 102 -> 899672840;
                case 103 -> 1537708641;
                case 104 -> -1615552931;
                case 105 -> -494972370;
                case 106 -> -702079730;
                case 107 -> 261969769;
                case 108 -> 1336241607;
                case 109 -> 1987531388;
                case 110 -> -1556782625;
                case 111 -> -1949021045;
                case 112 -> 503933050;
                case 113 -> 1795563861;
                case 114 -> 1071985947;
                case 115 -> 1360895574;
                case 116 -> 1454184706;
                case 117 -> -401908110;
                case 118 -> -1334449973;
                case 119 -> 858459697;
                case 120 -> -1687170138;
                case 121 -> 9358006;
                case 122 -> -751218113;
                case 123 -> -1650762133;
                case 124 -> -364075688;
                case 125 -> -1630502071;
                case 126 -> -1020521337;
                case 127 -> 576276404;
                case 128 -> -604992265;
                case 129 -> 337478431;
                case 130 -> 1762271495;
                case 131 -> -162625756;
                case 132 -> 99137894;
                case 133 -> -1971540713;
                case 134 -> -1902609026;
                case 135 -> 493027417;
                case 136 -> -1865611021;
                case 137 -> -1396118006;
                case 138 -> -1778883691;
                case 139 -> 1138357061;
                case 140 -> -1401428036;
                case 141 -> -267310058;
                case 142 -> -1016639243;
                case 143 -> 262002662;
                case 144 -> 194927366;
                case 145 -> -1218507189;
                case 146 -> -971858116;
                case 147 -> 573398367;
                case 148 -> 976216130;
                case 149 -> 227665925;
                case 150 -> -1008949072;
                case 151 -> 165840336;
                case 152 -> -804303657;
                case 153 -> 1745566871;
                case 154 -> -1218665224;
                case 155 -> 427227519;
                case 156 -> -516753325;
                case 157 -> 348039023;
                case 158 -> -29248112;
                case 159 -> 87488731;
                case 160 -> -565458057;
                case 161 -> -418433948;
                case 162 -> -875242259;
                case 163 -> 1619431440;
                case 164 -> 1928856018;
                case 165 -> -184525478;
                case 166 -> 115129147;
                case 167 -> -1435305625;
                case 168 -> -109072857;
                case 169 -> -773769047;
                case 170 -> 1457614218;
                case 171 -> -1354484240;
                case 172 -> 1432776483;
                case 173 -> -2130929225;
                case 174 -> -1442981811;
                case 175 -> 765552961;
                case 176 -> 2130623994;
                case 177 -> 843133964;
                case 178 -> -582012797;
                case 179 -> 438075460;
                case 180 -> -1478438952;
                case 181 -> -662638613;
                case 182 -> -169171943;
                case 183 -> -1574959449;
                case 184 -> -1678765659;
                case 185 -> 1830223901;
                case 186 -> 978086870;
                case 187 -> 1770283331;
                case 188 -> 699894938;
                case 189 -> -1548188116;
                case 190 -> -1414359435;
                case 191 -> 180339695;
                case 192 -> -795424984;
                case 193 -> 1395371422;
                case 194 -> -1089901231;
                case 195 -> -487161262;
                case 196 -> 1757284682;
                case 197 -> -1730305007;
                case 198 -> -1657388460;
                case 199 -> -815287180;
                case 200 -> -1181616128;
                case 201 -> -300950355;
                case 202 -> -1377244365;
                case 203 -> 51131941;
                case 204 -> 469500440;
                case 205 -> -103195702;
                case 206 -> 1038836422;
                case 207 -> 805077600;
                case 208 -> 145624310;
                case 209 -> -608096120;
                case 210 -> -446024959;
                case 211 -> 982775841;
                case 212 -> 1404390073;
                case 213 -> 864237564;
                case 214 -> 321368814;
                case 215 -> -1030850251;
                case 216 -> 1881233147;
                case 217 -> 199280741;
                case 218 -> 708259801;
                case 219 -> 1523023966;
                case 220 -> 1430375314;
                case 221 -> -1938618966;
                case 222 -> -1073964803;
                case 223 -> 152050339;
                case 224 -> 72222462;
                case 225 -> 2039270803;
                case 226 -> 1124088424;
                case 227 -> -16556363;
                case 228 -> -1905271151;
                case 229 -> -577329246;
                case 230 -> 535667097;
                case 231 -> -1323873734;
                case 232 -> 1097032378;
                case 233 -> 221187297;
                case 234 -> 68140447;
                case 235 -> -324915650;
                case 236 -> 158004473;
                case 237 -> -1560413721;
                case 238 -> 1124846091;
                case 239 -> 510330224;
                case 240 -> 1937267035;
                case 241 -> 701671091;
                case 242 -> 2076158081;
                case 243 -> 333273572;
                case 244 -> 794856064;
                case 245 -> 1334757090;
                case 246 -> 624925728;
                case 247 -> 2002758328;
                case 248 -> -1191616015;
                case 249 -> -1982675101;
                case 250 -> -1405440658;
                case 251 -> -1764400416;
                case 252 -> 1969058281;
                case 253 -> -1299002181;
                case 254 -> -1446243698;
                case 255 -> -2008820900;
                default -> 948151001;
            });
        } while (v2 != 544);
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
            Object[] objectArray = new Object[19];
            v1 = objectArray;
            Io0O = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        IoOo = Identifier.of((String)"clap", (String)"translate_chat");
        IoOI = new ConcurrentHashMap();
        IoOi = new ConcurrentHashMap();
    }

    private static String O0OOi(String param0) {
        String v4;
        if (param0 == null) {
            return "";
        }
        String v1 = param0.trim();
        if (v1.isEmpty()) {
            return "";
        }
        int v2 = v1.indexOf("> ");
        if (v1.startsWith("<") && v2 > 1 && v2 + 2 < v1.length()) {
            return v1.substring(v2 + 2).trim();
        }
        int v3 = v1.indexOf(": ");
        if (v3 > 0 && v3 + 2 < v1.length() && GuiSupport_oiio_3.O0O0O(v4 = v1.substring(0, v3).trim())) {
            return v1.substring(v3 + 2).trim();
        }
        v3 = v1.indexOf(58);
        if (v3 > 0 && v3 + 1 < v1.length() && GuiSupport_oiio_3.O0O0O(v4 = v1.substring(0, v3).trim())) {
            return v1.substring(v3 + 1).trim();
        }
        return "";
    }

    private static boolean O0O0o(String param0) {
        if (param0.isEmpty() || param0.length() > 24) {
            return false;
        }
        for (int v1 = 0; v1 < param0.length(); ++v1) {
            char v2 = param0.charAt(v1);
            if (Character.isLetterOrDigit(v2) || v2 == '_') continue;
            return false;
        }
        return true;
    }

    private static void O0OOO(String param0) {
        RenderSupport_ooi_0.HelpCommand((Text)Text.literal((String)"[Translate]: ").formatted(Formatting.GRAY).append((Text)Text.literal((String)param0).formatted(Formatting.RED)), "translate");
    }

    private static DataRecord_oi0_0 O0OOI(ChatHudLine param0) {
        MessageSignatureData v1 = param0.signature();
        if (v1 == null) {
            return null;
        }
        return (DataRecord_oi0_0)IoOi.get(v1);
    }

    private static String O0OO0(Throwable param0) {
        Throwable v1 = param0;
        while (v1.getCause() != null) {
            v1 = v1.getCause();
        }
        return v1.getMessage() == null || v1.getMessage().isBlank() ? "Translation failed." : v1.getMessage();
    }

    private static String O0O00(String param0) {
        int v1;
        if (param0 == null || param0.isEmpty()) {
            return "";
        }
        int v2 = param0.length();
        for (v1 = 0; v1 < v2 && !Character.isLetterOrDigit(param0.charAt(v1)) && param0.charAt(v1) != '_'; ++v1) {
        }
        while (v2 > v1 && !Character.isLetterOrDigit(param0.charAt(v2 - 1)) && param0.charAt(v2 - 1) != '_') {
            --v2;
        }
        return v1 >= v2 ? "" : param0.substring(v1, v2);
    }

    private static MutableText OOiiO(String param0) {
        ClickEvent.Custom v1 = new ClickEvent.Custom(IoOo, Optional.of(NbtString.of((String)param0)));
        Style v2 = Style.EMPTY.withColor(Formatting.GOLD).withUnderline(Boolean.valueOf(true)).withClickEvent((ClickEvent)v1);
        return Text.literal((String)"[Translate]").setStyle(v2);
    }

    private static String O0OOo(ChatHudLine param0) {
        return param0.creationTick() + "\u0000" + param0.content().getString();
    }

    public static void OOiIO(MessageSignatureData param0, String param1, String param2) {
        if (param0 == null || param1 == null || param1.isBlank()) {
            return;
        }
        IoOi.put(param0, new DataRecord_oi0_0(param2, param1));
    }

    private static int OOiii(List param0, int param1) {
        int v2 = -1;
        for (int v3 = 0; v3 <= param1 && v3 < param0.size(); ++v3) {
            if (!((ChatHudLine.Visible)param0.get(v3)).endOfEntry()) continue;
            ++v2;
        }
        return v2;
    }

    private static ChatHudLine OOiio(ChatHud param0, int param1, ChatHudLine param2, String param3) {
        ChatHudAccessor v4 = (ChatHudAccessor)param0;
        List v5 = v4.clap$getAllMessages();
        MutableText v6 = param2.content().copy();
        v6.append((Text)Text.literal((String)" "));
        v6.append((Text)GuiSupport_oiio_3.OOiiO(param3));
        ChatHudLine v7 = new ChatHudLine(param2.creationTick(), (Text)v6, param2.signature(), param2.indicator());
        v5.set(param1, v7);
        v4.clap$refreshTrimmedMessages();
        return v7;
    }

    public static boolean OOiI0(double param0, double param2) {
        String v9;
        ChatTranslatorModule v4 = (ChatTranslatorModule)0ooo.00oo().oo0i(ChatTranslatorModule.class);
        if (v4 == null || !v4.IoOo()) {
            return false;
        }
        ChatHud v5 = GuiSupport_oiio_3.ConfigSupport_OI0.inGameHud.getChatHud();
        DataRecord_OII0 v6 = GuiSupport_oiio_3.OOiiI(v5, param0, param2, GuiSupport_oiio_3.ConfigSupport_OI0.textRenderer);
        if (v6 == null) {
            return false;
        }
        ChatHudLine v7 = v6.NetworkSupport_o0oi_2();
        DataRecord_oi0_0 v8 = GuiSupport_oiio_3.O0OOI(v7);
        if (v8 == null) {
            v9 = GuiSupport_oiio_3.O0OOi(v7.content().getString());
            if (v9.isBlank()) {
                return false;
            }
            v8 = new DataRecord_oi0_0("", v9);
        }
        if (v8.OIo().isBlank()) {
            return false;
        }
        if (GuiSupport_oiio_3.OOii0(v7.content())) {
            return true;
        }
        v9 = GuiSupport_oiio_3.OOiio(v5, v6.EnumType_o0o0_0(), v7, v8.OIo());
        IoOI.put(GuiSupport_oiio_3.O0OOo((ChatHudLine)v9), v7);
        return true;
    }

    private GuiSupport_oiio_3() {
    }

    public static void OOiIi(ChatHud param0) {
        if (param0 == null) {
            return;
        }
        ChatHudAccessor v1 = (ChatHudAccessor)param0;
        List v2 = v1.clap$getAllMessages();
        boolean v3 = false;
        for (int v4 = 0; v4 < v2.size(); ++v4) {
            ChatHudLine v5 = (ChatHudLine)v2.get(v4);
            ChatHudLine v6 = (ChatHudLine)IoOI.get(GuiSupport_oiio_3.O0OOo(v5));
            if (v6 == null) continue;
            v2.set(v4, v6);
            v3 = true;
        }
        IoOI.clear();
        if (v3) {
            v1.clap$refreshTrimmedMessages();
        }
    }

    private static DataRecord_OII0 OOiiI(ChatHud param0, double param1, double param3, TextRenderer param5) {
        ChatHudAccessor v6 = (ChatHudAccessor)param0;
        List v7 = v6.clap$getTrimmedMessages();
        if (v7.isEmpty()) {
            return null;
        }
        double v8 = v6.clap$getScale();
        if (v8 <= 0.0) {
            return null;
        }
        double v10 = Math.floor(param1 / v8 - 4.0);
        double v12 = Math.floor(((double)ConfigSupport_OI0.getWindow().getScaledHeight() - param3 - 40.0) / v8);
        if (v10 < 0.0 || v12 < 0.0) {
            return null;
        }
        int v14 = v6.clap$getLineHeight();
        if (v14 <= 0) {
            return null;
        }
        int v15 = (int)(v12 / (double)v14) + v6.clap$getChatScrollbarPos();
        if (v15 < 0 || v15 >= v7.size()) {
            return null;
        }
        ChatHudLine.Visible v16 = (ChatHudLine.Visible)v7.get(v15);
        int v17 = param5.getWidth(v16.content());
        if (v10 > (double)v17) {
            return null;
        }
        int v18 = GuiSupport_oiio_3.OOiii(v7, v15);
        List v19 = v6.clap$getAllMessages();
        if (v18 < 0 || v18 >= v19.size()) {
            return null;
        }
        return new DataRecord_OII0(v15, v18, v16, (ChatHudLine)v19.get(v18));
    }

    private static boolean OOii0(Text param02) {
        Stream<ClickEvent> stream = param02.withoutStyle().stream().map(Text::getStyle).map(Style::getClickEvent);
        Objects.requireNonNull(ClickEvent.Custom.class);
        Stream<ClickEvent> stream2 = stream.filter(ClickEvent.Custom.class::isInstance);
        Objects.requireNonNull(ClickEvent.Custom.class);
        return stream2.map(ClickEvent.Custom.class::cast).anyMatch(param0 -> IoOo.equals((Object)param0.id()));
    }

    private static boolean O0O0O(String param0) {
        String v3;
        if (param0.isEmpty()) {
            return false;
        }
        if (GuiSupport_oiio_3.O0O0o(param0)) {
            return true;
        }
        String[] v1 = param0.split("\\s+");
        if (v1.length == 0) {
            return false;
        }
        String v2 = GuiSupport_oiio_3.O0O00(v1[v1.length - 1]);
        if (GuiSupport_oiio_3.O0O0o(v2)) {
            return true;
        }
        return v1.length >= 2 && GuiSupport_oiio_3.O0O0o(v3 = GuiSupport_oiio_3.O0O00(v1[v1.length - 2] + v1[v1.length - 1]));
    }

    public static boolean OOiIo(ClickEvent.Custom param02) {
        if (!IoOo.equals((Object)param02.id())) {
            return false;
        }
        ChatTranslatorModule v1 = (ChatTranslatorModule)0ooo.IrcModule().oo0i(ChatTranslatorModule.class);
        if (v1 == null || !v1.IoOo()) {
            return true;
        }
        if (v1.II0o()) {
            GuiSupport_oiio_3.O0OOO("API_KEY mode is only reserved in Translator.java right now. Current implementation uses GENERAL_APP_ID + GENERAL_SECRET.");
            return true;
        }
        if (!v1.IIOo()) {
            GuiSupport_oiio_3.O0OOO("Please fill GENERAL_APP_ID and GENERAL_SECRET in Translator.java.");
            return true;
        }
        if (!v1.IIOI()) {
            GuiSupport_oiio_3.O0OOO("Wrong credential type. Fill GENERAL_APP_ID + GENERAL_SECRET, not the API_KEY slot.");
            return true;
        }
        Optional optional = param02.payload();
        Objects.requireNonNull(NbtString.class);
        Optional<NbtElement> optional2 = optional.filter(NbtString.class::isInstance);
        Objects.requireNonNull(NbtString.class);
        String v2 = optional2.map(NbtString.class::cast).map(NbtString::value).orElse("");
        if (v2.isBlank()) {
            GuiSupport_oiio_3.O0OOO("No translatable text was attached to this chat line.");
            return true;
        }
        ((CompletableFuture)v1.IIO0().PacketEvent(v2, "auto", ((EnumType_o0o0_0)((Object)v1.oOo0.HelpCommand())).KeystrokesHudElement()).thenAccept(param0 -> ConfigSupport_OI0.execute(() -> {
            GuiSupport_oiio_3.OOiIi(GuiSupport_oiio_3.ConfigSupport_OI0.inGameHud.getChatHud());
            RenderSupport_ooi_0.HelpCommand((Text)Text.literal((String)"[Translate]: ").formatted(Formatting.DARK_AQUA).append((Text)Text.literal((String)param0).formatted(Formatting.GRAY)), "translate");
        }))).exceptionally(param0 -> {
            ConfigSupport_OI0.execute(() -> {
                GuiSupport_oiio_3.OOiIi(GuiSupport_oiio_3.ConfigSupport_OI0.inGameHud.getChatHud());
                GuiSupport_oiio_3.O0OOO(GuiSupport_oiio_3.O0OO0(param0));
            });
            return null;
        });
        return true;
    }
}

