/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Function
 *  com.sun.jna.Native
 *  com.sun.jna.Pointer
 *  com.sun.jna.platform.win32.Tlhelp32
 *  com.sun.jna.platform.win32.Tlhelp32$MODULEENTRY32W
 *  com.sun.jna.platform.win32.WinBase
 *  com.sun.jna.platform.win32.WinDef$DWORD
 *  com.sun.jna.platform.win32.WinNT$HANDLE
 *  com.sun.jna.ptr.PointerByReference
 *  net.minecraft.client.toast.SystemToast
 *  net.minecraft.client.toast.SystemToast$Type
 *  net.minecraft.client.toast.ToastManager
 *  net.minecraft.text.Text
 */
package clap.network;

import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import java.security.Key;
import java.security.MessageDigest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.text.Text;
import clap.nativeapi.Kernel32SnapshotApi;
import clap.module.client.streamproof.StreamproofLogger;
import clap.nativeapi.DwmApi;
import clap.render.RenderSupport_ooi_1;
import clap.render.RenderSupport_ooo_0;
import clap.render.RenderSupport_oooo_2;

/*
 * Renamed from psx.Hyk.0OiO
 */
public class NetworkSupport_0oio_1 {
    public volatile boolean GuiSupport_OOI;
    private ScheduledExecutorService OOi;
    private final long HelpCommand = ProcessHandle.current().pid();
    private static final String PacketEvent;
    private DwmApi HudElement;
    public volatile boolean OOo = true;
    static Object EventBusApi;
    private static volatile /* synthetic */ long __k__gH4it;

    private void HelpCommand() {
        try {
            Pointer v1 = Kernel32SnapshotApi.INSTANCE.GetModuleHandleA("opengl32.dll");
            Pointer v2 = Kernel32SnapshotApi.INSTANCE.GetProcAddress(v1, "wglSwapBuffers");
            StreamproofLogger.ConfigSupport_O0I = new PointerByReference();
            this.HudElement = param0 -> {
                Function v1 = Function.getFunction((Pointer)StreamproofLogger.ConfigSupport_O0I.getValue(), (int)63);
                RenderSupport_ooo_0 v2 = RenderSupport_oooo_2.getImpl();
                if (v2 instanceof RenderSupport_ooi_1) {
                    RenderSupport_ooi_1 v3 = (RenderSupport_ooi_1)v2;
                    v3.GuiSupport_OOI();
                }
                return (Boolean)v1.invoke(Boolean.class, new Object[]{param0});
            };
            int v3 = StreamproofLogger.O0i.MH_CreateHook(v2, this.HudElement, StreamproofLogger.ConfigSupport_O0I);
            int v4 = StreamproofLogger.O0i.MH_EnableHook(v2);
            this.GuiSupport_OOI = v3 == 0 && v4 == 0;
            StreamproofLogger.PacketEvent.info("OBS wglSwapBuffers hook result create={} enable={}", (Object)v3, (Object)v4);
            if (StreamproofLogger.HudElement != null) {
                StreamproofLogger.HudElement.execute(() -> SystemToast.add((ToastManager)StreamproofLogger.HudElement.getToastManager(), (SystemToast.Type)SystemToast.Type.PERIODIC_NOTIFICATION, (Text)Text.literal((String)"Streamproof"), (Text)Text.literal((String)(this.GuiSupport_OOI ? "OBS hooked" : "OBS hook failed"))));
            }
        }
        catch (Throwable v1) {
            StreamproofLogger.PacketEvent.error("Failed to install OBS hook", v1);
        }
    }

    public void OOo() {
        this.OOo = false;
        if (this.OOi != null) {
            this.OOi.shutdownNow();
        }
        if (this.GuiSupport_OOI) {
            Pointer v1 = Kernel32SnapshotApi.INSTANCE.GetModuleHandleA("opengl32.dll");
            Pointer v2 = Kernel32SnapshotApi.INSTANCE.GetProcAddress(v1, "wglSwapBuffers");
            StreamproofLogger.O0i.MH_RemoveHook(v2);
            this.GuiSupport_OOI = false;
        }
    }

    static {
        __k__gH4it = NetworkSupport_0oio_1.__k__gH4it((long)8130996788241886737L);
        __rP__gH4it0 = new String[]{"\u0b56\ue041\u3ed4\u6b18\ueccd\u02b4\u3832\u3df9\u0b24\ue351\u3d8d\u6826\uef84\u0198\u3be2\u3e5d\u08ed\ue2a0\u3cd0\u69ef\uee92\u0017\u3a0d\u3ffb\u090e\u9dec\u43ef\u165c\u9145\u7fd4\u4537\u40e3\u7616\u9cf2\u42ef\u172a\u906c\u7e44\u447b\u4166\u77f9\u9cd9\u4102\u14c0\u93fb\u7d8a\u47eb\u42dd\u7428\u9f37\u409c\u1582\u924a\u7c94\u46ff\u4308\u757e\u9edb\u47ea\u1213\u95c8\u7b80\u4194\u442b\u7276\u993e\u46f4\u1338\u94f2\u7aa4\u40b5\u456f\u733a\u9863\u4678\u10c6\u976c\u7971\u4366\u4657\u700b\u9b2d\u45b6\u1104\u9684\u789e\u4255\u4710\u71fb\u9a3d\u44c2\u1efe\u99d8\u7722\u4df9\u480a\u7eac\u9576\u4b4b\u1fea\u987b\u76a6\u4cdd\u497a\u7fee\u9453\u4a22\u1f7f\u9bd5\u750c\u4fd3\u4a0c\u7c96\u97fe\u49aa\u1c2c\u9a32\u74a4\u4e61\u4bd4\u7dc2\u9655\u4806\u1d83\u9dcc\u7320\u499e\u4c7f\u7a67\u914c\u4f17\u1a8e\u9c31\u7250\u48e3\u4d61\u7b2c\u9060\u4e47\u1ba7\u9c54\u71b8\u4b9d\u4ead\u78e3\u930e\u4db6\u180e\u9f75\u70b5\u4a22\u4fbf\u7940\u92ea\u4c14\u1917\u9ede\u6f23\u55cd\u5061\u66b0\u8d58\u5330\u06df\u8123\u6f66\u5489\u5179\u6748\u8cb9\u5242\u07e8\u805c\u6e46\u576f\u522a\u64f3\u8f51\u5129\u04d5\u8327\u6dc8\u5616\u535d\u656e\u8e9f\u5051\u05b1\u827a\u6c85\u51be\u5439\u6281\u897e\u573f\u0224\u8549\u6b05\u5103\u55c7\u6330\u8850\u5679\u0383\u8472\u6a35\u50fd\u565d\u60c7\u8b6b\u5565\u00af\u8729\u6923\u536b\u5748\u6193\u8ae1\u54e9\u0198\u8662\u68a7\u52cf\u5858\u6e86\u8524\u5b90\u0e34\u8955\u67ac\u5df1\u58dc\u6f9a\u8491\u5af7\u0fc1\u88f1\u6680\u5cf1\u595d\u6ca4\u8710\u5973\u0cdc\u8b16\u6545\u5f2c\u5a88\u6d40\u8669\u5896\u0d46\u8a01\u6435\u5e78\u5baa\u6ad2\u81e3\u5f25\u0a52\u8d8d\u631e\u594c\u5cbb\u6a44\u80a4\u5ea9\u0bf5\u8c59\u62a8\u5860\u5dfb\u6be6\u8381\u5d5f\u08d9\u8f77\u61ed\u5b24\u5e28\u688a\u82d3\u5cac\u09c9\u8e3b\u60a1\u5aa6\u5fb7\u6985\ubd67\u63d0\u36d4\ub1f3\u5f33\u65f5\u60d5\u5623\ubdd4\u6246\u37f9\ub03f\u5e58\u6453\u618d"};
        __rP__gH4it1 = new String[]{"\u0af9\ue13b\u3fef\u6ac0\uedd5\u0333\u39f3\u3d24\u0be7\ue051", "\u0afb\ue139\u3fe9\u6ac6\uedd7\u0331\u39fd\u3d2a\u0be5\ue053", "\u0aec\ue137\u3fef\u6abd\ueddc"};
        __rP__gH4it2 = new String[]{"\u0a59\ue197\u3fd3\u6a75\uedfe\u038d\u3923\u3de3", "\u0aef\ue130\u3fec\u6aad\uedb5\u032c\u39a2\u3cd7\u0bc3\ue046\u3ec4\u6b29\uecfb\u0236\u3888\u3d94\u08ff\ue36c\u3de1\u6815"};
        __rP__gH4it3 = new String[]{"\u0af9\ue122\u3ffe", "\u0ae9\ue12a\u3fef\u6abc\uedd5\u0334\u39e6"};
        byte[] v0 = "\u00ddTKz\u001b\u00fa\u00b3!W|j|\u00aa\u00dek\u008d\u0096\u0085?\u00bd\u00b4I\u009c3m\u00d1\u0018\u0016{\u0082\u00ae#}\u00c7\u0010hZ\u00ea\u00da\u00de\u00aa\u0014\u00c5\u00fa\u00f5,Bms\u00f2S\u00b0L*N\u00a0=\u0006=9\u00d66-\u008b=\u00eb+\u001a\u00e4*\u00f4\u00f7\t\u008e_\u00dc\u0002\u00f7/\u00c70\u00c8\u0099\u0016\u00e2\u0000\u0004\u0098\u00d8\u00c0\u00f5\u00f4\u00a6\u00b4\u00a0\u008a\u0087\u0083t\u00e8\rH\u00bc\u0002\u00fd\u00de%\u0085\u009b\u00ea\u00ba|\u008d{\u00a5\u00detZ\u0010\u00bc\u00c1\u00c8\u0011i\u0092\u00d6\u00e7\u001fl\u00d9\blg\u009e\u00e29\u00df\u00cd }\u00fa~\u0094\u00fd\u0018\u00ab\u00d9\u00dc\u00d3k3\u00f7\u00a3Wc\u00dd`\u00f5\u00d4![\u00edO\u001d\u0095H\u00a8A\u009b\u00f4\u0005R\u00d2`F\u001a(\u0014fg\u00a1\u00f6'u\u00ad\u00c2\u0006\u001b\u00e4\u00b3\u0087\u0019J+`\u0086\u00df\u000b\u00c2\u00df\u0083=\u00de\u0019\u009c34M|\u000e\u00ca=\u00cf=\u00ba@0\u009c^\u0012\u009c\u00b1\u0016X-Q/\u00b6\u00a3\u00c2\u0010$\t\u009cp\u00bb?\u00e6\u0018\u00ad?\u0015\u00fc\u00ae\u00d0;\u00dd`\u00c3t\u0001,\u00dfC\u0081JY\u00f6\u00ba0[P\u00cdc7\u0089N\u00afw\u00ee\u00e9+\u009d\u00a4\u00b0\u008bQ\u00b3\u00b5\u00e0\u00e9\u00ee[\u0083\u0005\u00f7?w\u00eeR/\u0096\u00c5\u009dTmp\u0019\u0081\u00c31\u00fe\u00fa=".getBytes("ISO_8859_1");
        Object[] v1 = "\u00e8\u00fcr\u00ed\u0012\u0085\u00e4\u00f1".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1258008791;
                case 1 -> -298635573;
                case 2 -> 517861490;
                case 3 -> -28204380;
                case 4 -> 1333358235;
                case 5 -> -688626270;
                case 6 -> 504272562;
                case 7 -> 641546125;
                case 8 -> -1415892220;
                case 9 -> -1847515341;
                case 10 -> -978817173;
                case 11 -> 1254037579;
                case 12 -> -1677889891;
                case 13 -> 374922243;
                case 14 -> 1546810268;
                case 15 -> 983940041;
                case 16 -> -1855800531;
                case 17 -> 950610004;
                case 18 -> 1269100543;
                case 19 -> -1134583793;
                case 20 -> -1518661386;
                case 21 -> 39115581;
                case 22 -> -2001124652;
                case 23 -> -941808864;
                case 24 -> 560477763;
                case 25 -> 1299933895;
                case 26 -> -782006676;
                case 27 -> 103226820;
                case 28 -> -2603259;
                case 29 -> 1062748610;
                case 30 -> -801311971;
                case 31 -> -1201421823;
                case 32 -> 1424270208;
                case 33 -> 896698998;
                case 34 -> -2117208982;
                case 35 -> 94794175;
                case 36 -> -1880757541;
                case 37 -> 25900277;
                case 38 -> 1779645996;
                case 39 -> -75600094;
                case 40 -> 190053393;
                case 41 -> -1562353784;
                case 42 -> -1668718272;
                case 43 -> -1006388509;
                case 44 -> 1322451761;
                case 45 -> 356148243;
                case 46 -> 1941874144;
                case 47 -> -1537184766;
                case 48 -> 637340847;
                case 49 -> -257413155;
                case 50 -> 1059268279;
                case 51 -> -473405716;
                case 52 -> 1032434563;
                case 53 -> -451566639;
                case 54 -> -1832155067;
                case 55 -> 1538794968;
                case 56 -> 1047256308;
                case 57 -> 608185327;
                case 58 -> 895135381;
                case 59 -> -227600640;
                case 60 -> 1704434930;
                case 61 -> 1748683575;
                case 62 -> -1735700777;
                case 63 -> -550979574;
                case 64 -> -845110130;
                case 65 -> -436978334;
                case 66 -> 286940577;
                case 67 -> 1205556556;
                case 68 -> 394521189;
                case 69 -> 1732703954;
                case 70 -> -1621126628;
                case 71 -> 1903840960;
                case 72 -> -806003642;
                case 73 -> 1480861605;
                case 74 -> -1963880053;
                case 75 -> 2032472343;
                case 76 -> -256582599;
                case 77 -> 1961362398;
                case 78 -> -1652068218;
                case 79 -> -309638283;
                case 80 -> -1342452408;
                case 81 -> 947319184;
                case 82 -> -1272861146;
                case 83 -> -413010514;
                case 84 -> -1790514493;
                case 85 -> 1269328763;
                case 86 -> 899732200;
                case 87 -> -1521729220;
                case 88 -> -1999224999;
                case 89 -> 465414426;
                case 90 -> -745522857;
                case 91 -> -1638495798;
                case 92 -> 1953985066;
                case 93 -> -1086485;
                case 94 -> -1588602230;
                case 95 -> 1431356347;
                case 96 -> -1630752664;
                case 97 -> -310415030;
                case 98 -> -550501355;
                case 99 -> -1975966429;
                case 100 -> 1619327248;
                case 101 -> -1703970264;
                case 102 -> -289516589;
                case 103 -> 1019147800;
                case 104 -> 1126209673;
                case 105 -> 212393139;
                case 106 -> 1672702855;
                case 107 -> 116437667;
                case 108 -> 1025965334;
                case 109 -> 1014828220;
                case 110 -> 1843738130;
                case 111 -> -660077443;
                case 112 -> 912346097;
                case 113 -> -2028429317;
                case 114 -> 1419355232;
                case 115 -> -294043462;
                case 116 -> -1979755110;
                case 117 -> -452482061;
                case 118 -> 382877977;
                case 119 -> -653044934;
                case 120 -> 46323687;
                case 121 -> -75265180;
                case 122 -> -1360456127;
                case 123 -> -1755815063;
                case 124 -> 413605902;
                case 125 -> 1244618527;
                case 126 -> -430204199;
                case 127 -> -1522103042;
                case 128 -> -1237744628;
                case 129 -> -1687559507;
                case 130 -> 287885414;
                case 131 -> -1488229286;
                case 132 -> -801552388;
                case 133 -> 11559548;
                case 134 -> -1426881811;
                case 135 -> 739539975;
                case 136 -> -631514630;
                case 137 -> -1611140385;
                case 138 -> 1802166126;
                case 139 -> 966354404;
                case 140 -> -92500044;
                case 141 -> 1470048113;
                case 142 -> 2140019319;
                case 143 -> -868434784;
                case 144 -> -2041759753;
                case 145 -> 1173094600;
                case 146 -> -1300617048;
                case 147 -> -1682773419;
                case 148 -> 957297703;
                case 149 -> -466701922;
                case 150 -> 1053506533;
                case 151 -> -668587546;
                case 152 -> -315425652;
                case 153 -> 232492308;
                case 154 -> 293385782;
                case 155 -> -838220240;
                case 156 -> -348773924;
                case 157 -> -1233438199;
                case 158 -> -1932110579;
                case 159 -> -1753337759;
                case 160 -> -638171858;
                case 161 -> -1888361947;
                case 162 -> 1839041924;
                case 163 -> 172648543;
                case 164 -> 2133960971;
                case 165 -> -1785518191;
                case 166 -> -1297193135;
                case 167 -> -1333335145;
                case 168 -> 525609953;
                case 169 -> -1484657317;
                case 170 -> 797925524;
                case 171 -> -882825692;
                case 172 -> -465969325;
                case 173 -> 1849184965;
                case 174 -> 1774716219;
                case 175 -> -1843525256;
                case 176 -> 561948327;
                case 177 -> 704999374;
                case 178 -> 788160422;
                case 179 -> 922046044;
                case 180 -> 344223535;
                case 181 -> 1427349466;
                case 182 -> -482646064;
                case 183 -> -825850104;
                case 184 -> 1154477877;
                case 185 -> -1973190590;
                case 186 -> 1277628086;
                case 187 -> 1396967887;
                case 188 -> 2029393048;
                case 189 -> 441770643;
                case 190 -> -906980575;
                case 191 -> 1480540118;
                case 192 -> 995261117;
                case 193 -> 496522626;
                case 194 -> -1132971953;
                case 195 -> 663031374;
                case 196 -> -1168009295;
                case 197 -> 1912149151;
                case 198 -> -1149530513;
                case 199 -> 846217081;
                case 200 -> -518029475;
                case 201 -> -1290246216;
                case 202 -> 1317398388;
                case 203 -> -1069341369;
                case 204 -> 1853251321;
                case 205 -> 556850505;
                case 206 -> -1214602263;
                case 207 -> -2085030674;
                case 208 -> -1781132462;
                case 209 -> 1116265522;
                case 210 -> -219450737;
                case 211 -> 340949190;
                case 212 -> -255816016;
                case 213 -> 1990290049;
                case 214 -> 1384691134;
                case 215 -> -538368319;
                case 216 -> -944975447;
                case 217 -> 1437025860;
                case 218 -> -1491428801;
                case 219 -> -229722594;
                case 220 -> -1570980368;
                case 221 -> -1871081173;
                case 222 -> 177579498;
                case 223 -> 1248772053;
                case 224 -> -1293939173;
                case 225 -> -1493519266;
                case 226 -> 2009445802;
                case 227 -> 1909130548;
                case 228 -> -1119802312;
                case 229 -> -1735047291;
                case 230 -> -38353075;
                case 231 -> -1283298554;
                case 232 -> 780052851;
                case 233 -> 656936908;
                case 234 -> -1330450507;
                case 235 -> -560085168;
                case 236 -> -499211626;
                case 237 -> 740912250;
                case 238 -> 1610704300;
                case 239 -> -1554186653;
                case 240 -> -1109959783;
                case 241 -> 1006881127;
                case 242 -> 2013957438;
                case 243 -> -1208866051;
                case 244 -> -1961180702;
                case 245 -> -1716396910;
                case 246 -> -2143202133;
                case 247 -> 1572843647;
                case 248 -> 67676601;
                case 249 -> -1782917011;
                case 250 -> 57825016;
                case 251 -> 671713918;
                case 252 -> -1805254314;
                case 253 -> 2098976344;
                case 254 -> -602039347;
                case 255 -> 123283568;
                default -> 628445871;
            });
        } while (v2 != 304);
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
            Object[] objectArray = new Object[10];
            v1 = objectArray;
            EventBusApi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = "(?i)^graphics-hook(32|64)\\.dll$";
    }

    private boolean GuiSupport_OOI() {
        WinNT.HANDLE v1 = Kernel32SnapshotApi.INSTANCE.CreateToolhelp32Snapshot(new WinDef.DWORD((long)(Tlhelp32.TH32CS_SNAPMODULE.intValue() | Tlhelp32.TH32CS_SNAPMODULE32.intValue())), new WinDef.DWORD(this.HelpCommand));
        if (v1 == WinBase.INVALID_HANDLE_VALUE) {
            return false;
        }
        Tlhelp32.MODULEENTRY32W v2 = new Tlhelp32.MODULEENTRY32W();
        if (!Kernel32SnapshotApi.INSTANCE.Module32FirstW(v1, v2)) {
            Kernel32SnapshotApi.INSTANCE.CloseHandle(v1);
            return false;
        }
        do {
            if (!Native.toString((char[])v2.szModule).matches("(?i)^graphics-hook(32|64)\\.dll$")) continue;
            Kernel32SnapshotApi.INSTANCE.CloseHandle(v1);
            return true;
        } while (Kernel32SnapshotApi.INSTANCE.Module32NextW(v1, v2));
        Kernel32SnapshotApi.INSTANCE.CloseHandle(v1);
        return false;
    }

    private void PacketEvent() {
        this.OOi = Executors.newSingleThreadScheduledExecutor(param0 -> {
            Thread v1 = new Thread(param0, "Clap Streamproof OBS Detector");
            v1.setDaemon(true);
            return v1;
        });
        this.OOi.scheduleWithFixedDelay(() -> {
            if (!this.OOo) {
                this.OOi.shutdown();
                return;
            }
            if (this.GuiSupport_OOI()) {
                StreamproofLogger.PacketEvent.info("OBS hook detected, installing streamproof hook in 3s");
                this.OOi.schedule(this::HelpCommand, 3L, TimeUnit.SECONDS);
                this.OOo = false;
            }
        }, 0L, 3L, TimeUnit.SECONDS);
    }

    public NetworkSupport_0oio_1() {
        this.PacketEvent();
    }
}

