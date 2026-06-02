/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package clap.network.irc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.security.Key;
import java.security.MessageDigest;
import java.time.Duration;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clap.module.client.IrcModule;
import clap.network.NetworkSupport_io0_0;
import clap.setting.SettingContainer;
import clap.config.ConfigSupport_oii0_1;
import clap.render.RenderSupport_ooi_0;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.Oo0i
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class IrcManager
implements SettingContainer,
WebSocket.Listener {
    private final ExecutorService oIi0 = Executors.newSingleThreadExecutor(param0 -> {
        Thread v1 = new Thread(param0, "Clap IRC Connect");
        v1.setDaemon(true);
        return v1;
    });
    private volatile boolean oiOI;
    private boolean oi0i;
    private final Map oiOO;
    private String oi0I = "";
    private volatile String oi00 = "Disconnected";
    private static final Path oIiO;
    private volatile boolean oiOi;
    private boolean oioO = true;
    private boolean oioi = true;
    private ScheduledFuture oi0o;
    private final HttpClient oIiI;
    private String oio0 = "ws://206.119.172.188:8080";
    private final Set oiO0;
    private int oioI = 5;
    private static final Logger 0Oii;
    private static final Gson oIIi;
    private final StringBuilder oIii;
    private boolean oioo = true;
    private final ScheduledExecutorService oIio = Executors.newSingleThreadScheduledExecutor(param0 -> {
        Thread v1 = new Thread(param0, "Clap IRC Reconnect");
        v1.setDaemon(true);
        return v1;
    });
    private volatile WebSocket oiOo;
    private volatile boolean oi0O;
    static Object oiIO;
    private static volatile /* synthetic */ long __k__gH4it;

    private void iIiO() {
        try {
            Files.createDirectories(oIiO, new FileAttribute[0]);
            Files.writeString(oIiO.resolve(this.OIoi()), (CharSequence)oIIi.toJson(this.OIoo()), new OpenOption[0]);
        }
        catch (Throwable v1) {
            0Oii.warn("Failed to write IRC config", v1);
        }
    }

    public String iIOo() {
        return this.oio0;
    }

    public String iIOO() {
        return this.oi00;
    }

    private boolean iiO0(JsonObject param1, String param2) {
        JsonElement v3 = param1.get(param2);
        if (v3 == null || v3.isJsonNull()) {
            return false;
        }
        try {
            return v3.getAsBoolean();
        }
        catch (Throwable v4) {
            return false;
        }
    }

    private void iIoI() {
        WebSocket v1 = this.oiOo;
        if (v1 == null) {
            return;
        }
        JsonObject v2 = new JsonObject();
        v2.addProperty("type", "ping");
        v2.addProperty("time", (Number)System.currentTimeMillis());
        v1.sendText(oIIi.toJson((JsonElement)v2), true);
    }

    @Override
    public void onOpen(WebSocket param1) {
        this.oiOo = param1;
        this.oiOI = true;
        this.oi00 = "Authenticating";
        this.iIOI(param1);
        WebSocket.Listener.super.onOpen(param1);
    }

    private boolean iIio() {
        IrcModule v1 = IrcModule.O0iiI();
        return v1 != null && v1.IoOo() && v1.iIio();
    }

    private String iIII() {
        MinecraftClient v1 = MinecraftClient.getInstance();
        if (v1.player == null) {
            return "";
        }
        return v1.player.method_7334().name();
    }

    private void iI0o(JsonObject param1) {
        JsonElement v2 = param1.get("messages");
        if (v2 == null || !v2.isJsonArray()) {
            return;
        }
        for (JsonElement v4 : v2.getAsJsonArray()) {
            if (!v4.isJsonObject() || !"chat".equals(this.iIii(v4.getAsJsonObject(), "type"))) continue;
            this.iIoo(v4.getAsJsonObject());
        }
    }

    private String iIii(JsonObject param1, String param2) {
        return this.iiOO(param1, param2, "");
    }

    private void iIoo(JsonObject param1) {
        String v2 = this.iiOO(param1, "prefix", "[IRC]");
        String v3 = this.iIii(param1, "username");
        String v4 = this.iIii(param1, "message");
        if (v3.isBlank() || v4.isBlank()) {
            return;
        }
        if (!this.iIiI()) {
            return;
        }
        boolean v5 = "admin".equalsIgnoreCase(this.iIii(param1, "role"));
        MutableText v6 = Text.literal((String)(v2 + " ")).formatted(Formatting.DARK_AQUA);
        if (v5) {
            v6.append((Text)Text.literal((String)v3).formatted(Formatting.RED)).append((Text)Text.literal((String)": ").formatted(Formatting.GRAY)).append((Text)Text.literal((String)v4).formatted(Formatting.WHITE));
        } else {
            v6.append((Text)Text.literal((String)v3).formatted(Formatting.AQUA)).append((Text)Text.literal((String)": ").formatted(Formatting.GRAY)).append((Text)Text.literal((String)v4).formatted(Formatting.WHITE));
        }
        this.iIIo((Text)v6);
    }

    @Override
    public String OIoi() {
        return "irc.json";
    }

    public CompletionStage onText(WebSocket param1, CharSequence param2, boolean param3) {
        this.oIii.append(param2);
        if (param3) {
            String v4 = this.oIii.toString();
            this.oIii.setLength(0);
            this.iI00(v4);
        }
        param1.request(1L);
        return null;
    }

    public void iI0O(boolean param1) {
        if (!this.oiOi || this.oiOo == null) {
            return;
        }
        String v2 = this.iIII();
        boolean v3 = this.iIio();
        if (v2.isBlank() || !param1 && v2.equals(this.oi0I) && v3 == this.oi0i) {
            return;
        }
        JsonObject v4 = new JsonObject();
        v4.addProperty("type", "identity");
        v4.addProperty("minecraftName", v2);
        v4.addProperty("god", Boolean.valueOf(v3));
        this.oiOo.sendText(oIIi.toJson((JsonElement)v4), true);
        this.oi0I = v2;
        this.oi0i = v3;
        this.iIo0(v2);
    }

    public synchronized void ioiI() {
        if (!this.iIi0()) {
            this.iII0("{red}Enable the IRC module first.", new Object[0]);
            return;
        }
        this.ioi0();
        this.oi0O = false;
        this.ioiO();
    }

    static {
        __k__gH4it = IrcManager.__k__gH4it((long)8365057061171490321L);
        __rP__gH4it0 = new String[]{"\uf54e\u1747\uc9d3\u9c40\u1be9\u2d48\ub51a"};
        __rP__gH4it1 = new String[]{"\uf5ce\u17b5\uc99d\u9cbc\u1bfd\u2d1f\ub5e7\uca5b", "\uf55c\u1754\uc9c5\u9c2a\u1bfb\u2d5d\ub501\ucab4\uf442\u163e", "\uf548\u1765\uc9b0\u9c71\u1b69\u2d08\ub51e\uca89\uf5a4\u1663\uc8a8\u9d05\u1a17\u2c12\ub434\ucbca\uf498\u1159\ucf9d\u9a29", "\uf54b\u175a\uc9cb\u9c41\u1be0"};
        __rP__gH4it2 = new String[]{"\uf644\u14b1\uca69\u9f8b\u1b9b\u2dc4\ub5d9\ucae6\uf562\u1739\uc956\u9c0a\u1a85\u2cb3\ub4d3\ucb21\uf47d\u16d0\uc8cc\u9d8a\u1d32\u2be1\ub3d6\ucc12\uf30a\u110c\ucfec\u9ad8\u1db5\u2af2\ub2f6\ucdc4\uf2a3\u1011\uce2e\u9b96\u1c0a\u293b\ub1ff\uce3c\uf17f\u133b\ucd6d\u989d\u1fbf\u2830\ub09e\ucf1d\uf0fb\u1254\ucc08\u99b1\u1ecf\u37b9\uaf51\ud05c\uef5b\u0db7\ud390\u868a\u0104\u371e\uaef7\ud1e0\uee1a\u0cb8\ud2e7\u8701X\u368a\uad0d\ud290\uedb6\u0fc4\ud14b\u84d2\u03e4\u3527\uac06\ud33f\uec5a\u0e99\ud0dd\u8507\u0212\u345c\uabd5\ud42b\ueb41\u099e\ud768\u82c3\u0533\u33fb\uab4b\ud55f\uea0b\u0862\ud625\u83d2\u04e6\u3296\uaa1b\ud6bf\ue920\u0b4f\ud501\u802e\u07e4\u31fe\ua9e9\ud7f9\ue87e\u0a26\ud481\u819b\u069b\u3074\ua87d\ud8ea\ue7ab\u056f\udb5b\u8eee\u099d\u3f78\ua749\ud85e\ue676\u0416\uda54\u8f32\u08ca\u3e98\ua660\ud926\ue565\u078a\ud9fd\u8ce6\u0b40\u3dab\ua54d\uda3c\ue4d1\u069f\ud8e0\u8d31\u0a33\u3cac\ua4e4\udb6f\ue3bc\u01e0\udfff\u8aa3\u0d48\u3bb6\ua3c8\udc26\ue3fb\u00b6\udef5\u8be9\u0c48\u3acd\ua24e\uddd3\ue252\u03b0\udd3f\u881f\u0f78\u3958\ua149\udef1\ue15c\u02b6\udc99\u8960\u0efc\u38b9\ua032\udf39\ue047\u02c6\ue34e\ub6c1\u3101\u0783\u9fed\ue0c2\udfc7\u3d4b\ue251\ub761\u3078\u067d\u9e52\ue1ce\ude46\u3c3f\ue120\ub41e\u33f9\u051b\u9d96\ue29c\udd91\u3f05\ue0d0\ub58d\u32a9\u04cb\u9c15\ue391\udc76\u3e5f\ue00c\ub2bd\u359b\u03bb\u9b55\ue44f\udb16\u397a\ue795\ub33a\u3454\u02e1\u9a2d\ue535\udaae\u3866\ue6be\ub0a1\u37b2\u0142\u9978\ue6fb\ud93b\u3b3f\ue596\ub13b\u36e6\u00be\u98eb\ue724\ud8e1\u3a9a\ue499\ub1cb\u39ef\u0fb2\u97d0\ue8d7\ud7e4\u35e7\ueb15\ubeba\u3813\u0e67\u9651\ue901\ud6f8\u342f\uea0c\ubfbe\u3b53\u0d8f\u95e1\uea54\ud55d\u378a\ue9d5\ubce0\u3a09\u0c02\u9432\uebcd\ud44a\u36f0\ue89d\ubd3a\u3a8d\u0b86\u93d7\ueccb\ud3d9\u317a\uef8f\ubab1\u3d5c\u0a72\u9210\uedb6\ud2d2\u3061\ueed4\ubb21\u3cb6\u0901\u917b\uee91\ud1b7\u33c0\uedc4\ub87f\u3f81\u0883\u906e\uef58\ud0ca\u3201\uec6e\ub91f\u3ecc\u085a\u8f1e\uf04f\ucfc1\u2dc4\uf374\ua617\u21b1\u1733\u8ec0\uf12a\uce0e\u2c76\uf2ad\ua707\u2064\u16ad\u8daa\uf289\ucda0\u2fce\uf1d5\ua4ee\u2363\u15af\u8c58\uf3ac\ucca7\u2e89\uf048\ua540\u22ca\u14d5\u8c69\uf4e6\ucb46\u29c8\uf772\ua242\u25a2\u1321\u8b0a\uf5ce\uca6c\u28d8\uf60c\ua304\u24f8\u125b\u8a20\uf674\uc9e9\u2baa\uf5c2\ua046\u270c\u11ab\u89f1\uf742\uc860\u2af8\uf4e5\ua1e2\u26ee\u1062\u8892\uf7ec\uc7a9\u25a1\ufbe8\uaee8\u299c\u1fe0\u8729\uf85d\uc617\u245e\ufaec\uaf2d\u289a\u1e22\u86ae\uf98b\uc5ac\u27c1\uf9e9\uacbb\u2b55\u1db4\u8539\ufa21\uc4ec\u2618\uf8cc\uad68\u2a24\u1cfe\u847d\ufba7\uc496\u214e\uffcd\uaa18\u2d42\u1bf6\u8356\ufc3a\uc3f6\u209b\ufec5\uab95\u2c5b\u1a33\u82dc\ufd52\uc2fb\u23b3\ufd6e\ua88d\u2fa1\u19f8\u817f\ufe38\uc1c5\u234a\ufc43\ua9cd\u2ee2\u181f\u80d3\uff8e\uc0c0\u228d\u0331\u567d\ud136\ue7e6\u7ff5\u00b0\u3f1f\udd4a\u0234\u575d\ud05e\ue6a6\u7e6b\u0132\u3e52\udcfc\u018d\u5443\ud336\ue5d5\u7d66\u021d\u3d96\udf58\u0180\u5568\ud2a3\ue44a\u7cf9\u0360\u3cd6\ude40m\u52dc\ud583\ue383\u7b66\u0499\u3b1e\ud9a1\u0707\u5300\ud46d\ue22d\u7a74\u05ec\u3a4d\ud89f\u061e\u505d\ud739\ue167\u7972\u063a\u398e\udbb8\u05f9\u505f\ud6a0\ue03b\u786a\u0712\u38c4\uda88\u04c1\u5154\ud955\uefac\u771e\u0874\u37b2\ud577\u0ba1\u5e27\ud833\uee2b\u7673\u09ab\u3661\ud47b\u0aa6\u5f44\udba2\ued1c\u75a7\u0aa1\u35c6\ud794\u09c3\u5ce2\udb52\uec10\u7479\u0b1a\u3461\ud668\u08d6\u5dbe\udab2\ueb57\u732e\u0cf1\u33de\ud1b2\u0fbc\u5a5e\uddf0\uea69\u7280\u0daf\u32cf\ud06c\u0e53\u5b31\udc0e\ue910\u71e8\u0ea1\u3107\ud397\u0de9\u58a3\udf6c\ue918\u7032\u0fc6\u305d\ud2eb\u0c18\u5971\ude06\ue85d\u6f46\u1000\u2f5d\ucd78\u13d6\u460a\uc168\uf764\u6ecd\u1155\u2eee\ucc5b\u12cc\u4707\uc077\uf67e\u6d9b\u12e7\u2d4f\ucf38\u113f\u448a\uc393\uf51f\u6dc4\u133e\u2cd0\uce55\u10cb\u45fa\uc21d\uf44f\u6c6f\u14c2\u2b7b\uc973\u17f7\u4214\uc55b\uf33a\u6b80\u15c1\u2afc\uc8f2\u16d2\u4349\uc43e\uf298\u6ab9\u1680\u297c\ucb3f\u156a\u40bd\uc7b4\uf1b9\u6906\u1646\u2875\uca9c\u14ea\u418c\uc6b3\uf047\u68a2\u1734\u27ce\uc558\u1b0b\u4e13\uc9a8\uff3a\u67e3\u182f\u26a4\uc4f3\u1a7e\u4f6b\uc83a\ufe13\u6604\u19f8\u25d8\uc7f0\u19e9\u4c5a\ucb2e\ufdf3\u652a\u1a96\u25cd\uc603\u1822\u4d99\uca81\ufc20\u644b\u1bcf\u249d\uc11b\u1f6a\u4a81\ucd5b\ufb70\u632b\u1c40\u23d8\uc0b5\u1e48\u4b76\uccbe\ufa1e\u62fa\u1d0a\u2216\uc006\u1d82\u48bb\ucf82\uf92b\u6184\u1ebd\u2127\uc377\u1ccd\u4924\uce3c\uf896\u60dd\u1f53\u2056\uc217\u23e5\u7640\uf177\uc7fe\u5fe6\u2081\u1fca\ufd5e\u220c\u7701\uf0e7\uc61c\u5e66\u2108\u1ed2\ufcfd\u2224\u74ae\uf349\uc543\u5d9d\u221e\u1d70\uff28\u2158\u7543\uf2c2\uc417\u5c56\u2364\u1cab\ufe12\u2043\u7262\uf50b\uc3d2\u5b47\u2477\u1be0\uf911\u274d\u7375\uf402\uc2f5\u5ad8\u2599\u1ac4\uf89a\u2618\u73c8\uf70c\uc142\u5937\u2669\u19fe\ufb5a\u2521\u7010\uf6ae\uc0a3\u58f7\u27a4\u1871\ufa86\u2474\u717d\uf99e\ucf36\u5789\u283b\u1772\uf546\u2b89\u7ec7\uf875\uce6d\u566c\u297a\u160a\uf4df\u2af7\u7f29\uf8d6\ucdbe\u558e\u2a89\u1519\uf742\u2918\u7c8e\ufba5\uccba\u54a0\u2bc3\u1442\uf619\u28c6\u7dc1\ufad1\ucb0d\u5309\u2ca8\u1386\uf13e\u2fe5\u7a4c\ufdfb\uca21\u52e8\u2db9\u1255\uf0e5\u2e43\u7bc3\ufce7\uca60\u513b\u2e7c\u1190\uf346\u2d0f\u78f7\uff53\uc922\u502d\u2f92\u1062\uf2d0\u2c13\u7915\ufe4c\uc853\u4f3b\u3085\u0f3e\uedcb\u3399\u6684\ue1a0\ud717\u4e79\u31b3\u0e90\uec31\u3237\u672f\ue050\ud605\u4e6b\u3202\u0d52\uefe8\u31f4\u6477\ue39d\ud507\u4d93\u3352\u0cc7\uee58\u3008\u65f2\ue2bf\ud4d7\u4c54\u3445\u0b37\ue937\u3745\u6207\ue545\ud389\u4bda\u355f\u0afe\ue870\u3642\u630f\ue499\ud29d\u4ae1\u35cc\u096f\ueb4c\u3587\u60e6\ue707\ud10d\u4907\u36f0"};
        __rP__gH4it3 = new String[]{"\uf55e\u1756\uc9cb\u9c24\u1bf9\u2d5f\ub507\ucab2\uf440\u163c", "\uf55e\u174f\uc9da"};
        byte[] v0 = "\u00d09b}\u00d9&l\u00e8\u00fe\u00a9E\u00e4\u00dfI~7\u00f9H\u00d7l`\u0013s\f\u0086\u00ac\u008f\u0006\u001f8+\u00e2\u00d7\u00b9E@\u00a8\u00f9*\u0012\u0003\u008b\u001eS\u0005\u00eaS+\u009f\u00ecsw}k\u0094b7\u00f7\u00d34\u008e4\n\u00a6N\u00f0\u00ac\u00b7\u00da\u00a8\u00f8\u00de\u00ea\u0094\u0018|~\u001d\u00ebi\u001e\u00c1\u0086\u00a1\u0080n0u\r\u00fe\u00cb]\u00d9\u00f1V9?\n\u008eD\u0004\u0094\u000e\u00d1\u001c?\u00b2\u00a0\u001e\u00e4\u00e4\u008fZ^:\u001difx\u0094\u0087o\u00d8\u0090W\u0012t\u00d8b\u001e\u00dfD\b\u00faU\u00a8y\u009an\u0088\u009a\u00d1`\u00aa\u00d5\u0087{W\u00e1\u00de\u00c1\u00f1\u00b0\u00c0\u001c\u00fdb\u00fc\u0095\u0080\u000f\u009e\u001e\u00bfj\u008f\u001b}\u00ae\u0080\u00ccQB\u0002\u0004G\u00b8\u008eb&\u00ce\u00ebw\u0087\u00ab\u0006\u008d\u00ff\u000b)\u0090\u0004\u0013\u0083\u009aWz\u00df'\u0000\u009a\u00ef\u00f30\u00e3\u00a1\u00fbJU\u00dd\u000b\u00ab\u00bbypO\u00ba\u00bf/\u00a3\u00f11\u00c8\u00a9\u00a2\u0092\u00be,6c\u00b8\u00db\u0012\u0096\u008d\u00af\u00c8\u00d8\u00f5\r\u009f\u00c7\u00ad=\u0094,n\u00daM\u001a\u009a5\u00a5Xm\u00d1po\u001eLQ\u0085\u00e4\u000fd\u00bf\u001fP\tuLB\u00d9\u0012\u00ce\u0006[\u00f0\u0097\u00d3\u00c6P\u00fe\u00e4'L\n\u00ed\u00ad\u00d2\u00e4g\u00fe\u00b0\u00c5\u0098\u00ae\u00d1\u00a7\u00ef\f\u00db\u00b6\u00a7\u00d3x\u00bf\u00b93Q\u00abf\u00a6A-\u00a1Fp\u00e3\t\u0095\u008c?\u00a13\u00115dR&\u00fe\u00a9\u00fe\u0097G\u00df\u00e4\u0096\u008eH\u00f1\u009d\u00bd\u00f2\u00eb\u00e9\u00eb\u00de \u00dft\u0080r\u00a0\u00d9\u00d4@#\u001f\u00a0P\u00a8\u00bf\u008a\u0002A-\u0002\u00cd\u00d2y\u00c0\u00fe\u00b9\u00f4<L\u00f8f\u009c$\b\u00afj\u00bd\u00a9c\u009e^\u0082\u001c\u00d3\u000bN\u007fC@X\u0083\u001d\u00a8\u00d9r\u00dd\u0087\u00c6\u001c\u00bf\u00e08/6\u000e\u00b4 \u0001bf&N`\u00b4\u0003\u0094\n\u00ab6\u00dbai\u0091\u00e4\u001f\u008b\u0095\u00cb\u0093\u00aa:\u0086)\u008a\u0080\u00f3\u00e8\u00b5\u00aeH\u0014E\u00faK4D\u0080~\u00c3\u009a\u00e7sD\u001c\u0006\u00e4\u0096$Ve$g\u0003\u00c3Z\u00b8\u00a3v\u00c9\u00c0d\u0086b\u00a8F\u00ca\u00e1\u0001\u00f3w\u00a2Q4\u000e\u0017\u00b7\u00f9\u001a\u00e9g%[K\u00f5\u00f7\u00c4\"8\u00fa\u00a1\u00ea\u00d1\u00d7\u0014P\u0000\u00ca\u00a2\u0017N\u00abz.\u00e7\u00b2\u00c9i\u00d1\u00de\u00bd\u00e5\u00e3\u00bd\u00a2\u00f0\u00ee\u0002\u00bfJ4\u00a0<\u00f8\u00da\u00a4<\u0015\u00c0\u00bdh\u0010\u0095\u00fb\u00df\u00a2\u0002\u00cf\u0090J\u00b3M\u0099\u00ab\u00d4(\u00f7\u00bc\u00c2-\u009fk\u00d7\u00aa\u001d\u00e62\u00cf\u0080\t\u00a3S\u00c7\u0084\u007f\u00b3N\u0001(\u0085\u00a4\u00f2^ \u0003\u00aa\u0003\u0097\u00a1\u00e5L~\u00b9\u0003X\u009c\u0014y\u0015\u00d9X\u00e4=`l\u00ffMz\u00acG\u0003D\u009a\u00a1 \u008d\u00b7\u00d8\u008ai\u00cf\u00cc\u008a\u00bc\u00feP?\u00e9\u00c3~\u00d3;\u00c0a\u0094a\u00faq%\u0097\u00ba\u00d2H\u0098}r@\u00ce\u00b9\u00a0\u00eb\u00e5\r\u00e8a!f\u00d4\u00d0\n\u0004\u0004\u00b9w09+\u00c9\u00cf\u00a3b\u001eaa+\u0099\u00cfa*f\u00f6<\u008d\u00b30\u008cL\u00bf\u00b4\u00fa\u00c6A\u0085\u0088\u0081\u00f9{\u00f3\u00bf\u0006\u0012>4\u00a8\u009d\u008a\u00c76nmD\u008bW\u000e\u0086\u00d7'\u00f5\u00ae\u0003\u00d6\u001e\u001d\u0007\u00b0#\u00c9\u0000\u00f8\u00c4\u00c0sU\u00a0\u0095\u00c3\u008a\u0017\u00e2plqH\u00ca\u0081D\u00e9vspg]gh\u001a\u001b6F\u00a8\u008aoj\u00d2*\u00e6\u00ecAB\u00aa\u00ed\u0016g\u0093\u00c4\u00cc$-\u00f6\u00de\u0092!'\u009f\u00c9d\u0086\u007f\u0094\u00f7|tS\u00afm\u00easX\u0007xu\u00ed>\u00a9\u00b5\u000fk\u00d7\u00c4\u009e\u00e2\u0086\u009e\u008aI\u00f3-\u00879\u00a5\u0000}mJ\u00c6:\u00c4\u000eDA\u00d1\u0000\u00d8\u00dc>\u0080@\u00bb\u00d6i\u00d6\u00d3z\u0093\u00c2\"2%\u009c\u00ed\u00dcQ\u0094\u00b1\u00ba\u000fvdf\u0080_\u00e1\u007f\u0005\u0086<\u00fb(\u00bb|E\u00cdY3\u0013O\u00fe\u0081\u00b7\u009b\u00df!\u00d2p\u00c1qS\u00f7\u00dcJ{D\f\u0090\u00c5o2~".getBytes("ISO_8859_1");
        Object[] v1 = "\u00d8\u00b3\u0018\u00c8={\u00d4\u00d7".getBytes("ISO_8859_1");
        int v2 = 0;
        int v3 = v0.length;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1028375063;
                case 1 -> -1679461762;
                case 2 -> 14962362;
                case 3 -> -198987179;
                case 4 -> -958103678;
                case 5 -> 1474072912;
                case 6 -> 1092830809;
                case 7 -> -1270885145;
                case 8 -> -39587221;
                case 9 -> 1656736795;
                case 10 -> 424726609;
                case 11 -> 1897786314;
                case 12 -> 470710614;
                case 13 -> -1332309223;
                case 14 -> -1318955936;
                case 15 -> 2024194607;
                case 16 -> 1536598764;
                case 17 -> 425355070;
                case 18 -> 1160909347;
                case 19 -> -1852689541;
                case 20 -> 1315652300;
                case 21 -> 552560798;
                case 22 -> 1000331963;
                case 23 -> 1495862417;
                case 24 -> 1082101250;
                case 25 -> 237020946;
                case 26 -> -578518249;
                case 27 -> -407932340;
                case 28 -> -1183726553;
                case 29 -> 163973035;
                case 30 -> 1363000719;
                case 31 -> -1527340774;
                case 32 -> -322397453;
                case 33 -> 2137033629;
                case 34 -> 1406022309;
                case 35 -> 1328418452;
                case 36 -> 247463799;
                case 37 -> 198529976;
                case 38 -> 1642597349;
                case 39 -> -1225176328;
                case 40 -> -1872629248;
                case 41 -> 1824438915;
                case 42 -> 1341539980;
                case 43 -> 1313946057;
                case 44 -> 774926611;
                case 45 -> 1313752564;
                case 46 -> 43744615;
                case 47 -> -519281310;
                case 48 -> -1116618907;
                case 49 -> -1372497379;
                case 50 -> 1197671898;
                case 51 -> 1062442314;
                case 52 -> 2105578946;
                case 53 -> 714470497;
                case 54 -> 298550636;
                case 55 -> 956622923;
                case 56 -> -392828401;
                case 57 -> -863256560;
                case 58 -> 1503686389;
                case 59 -> -2040980686;
                case 60 -> 446328753;
                case 61 -> 802252259;
                case 62 -> -418778701;
                case 63 -> 1933818321;
                case 64 -> -1326845586;
                case 65 -> -823860490;
                case 66 -> -988716884;
                case 67 -> -1052745954;
                case 68 -> -741136049;
                case 69 -> 1546203170;
                case 70 -> 1188173610;
                case 71 -> -204712814;
                case 72 -> -29176580;
                case 73 -> -1889359037;
                case 74 -> 1416451137;
                case 75 -> 1877810278;
                case 76 -> 699449593;
                case 77 -> 2096033478;
                case 78 -> -2057724671;
                case 79 -> -1541815389;
                case 80 -> -1605180900;
                case 81 -> 825495487;
                case 82 -> -1140021819;
                case 83 -> 216404516;
                case 84 -> -1106723830;
                case 85 -> -502366386;
                case 86 -> -41368989;
                case 87 -> -383000033;
                case 88 -> -39318288;
                case 89 -> 12842735;
                case 90 -> -62560118;
                case 91 -> -278906733;
                case 92 -> 2089419871;
                case 93 -> -193651116;
                case 94 -> -1015266451;
                case 95 -> 1250359214;
                case 96 -> -1917474142;
                case 97 -> 1584331542;
                case 98 -> -2074421749;
                case 99 -> -1726925295;
                case 100 -> 2030285973;
                case 101 -> -900186583;
                case 102 -> 1144178977;
                case 103 -> -132146931;
                case 104 -> 1297926500;
                case 105 -> 1397093003;
                case 106 -> -4112075;
                case 107 -> 1130575693;
                case 108 -> -134541964;
                case 109 -> -2021244355;
                case 110 -> 1447554212;
                case 111 -> 1651303979;
                case 112 -> 430200128;
                case 113 -> 380060637;
                case 114 -> 1840816762;
                case 115 -> -1729887119;
                case 116 -> 1449292076;
                case 117 -> 858454877;
                case 118 -> 434029309;
                case 119 -> -2061825822;
                case 120 -> -527212457;
                case 121 -> 448337533;
                case 122 -> 1635757171;
                case 123 -> -1995868201;
                case 124 -> -1920766672;
                case 125 -> -1347289131;
                case 126 -> -400687399;
                case 127 -> 1511526332;
                case 128 -> -463506242;
                case 129 -> 755912447;
                case 130 -> 262240024;
                case 131 -> 228931509;
                case 132 -> -529671456;
                case 133 -> -1397700504;
                case 134 -> 2095031362;
                case 135 -> 670372525;
                case 136 -> -513738367;
                case 137 -> -671067527;
                case 138 -> 455064068;
                case 139 -> -1969110140;
                case 140 -> -662829838;
                case 141 -> -1107122387;
                case 142 -> 2004240255;
                case 143 -> 64335142;
                case 144 -> -1015043707;
                case 145 -> 2022156286;
                case 146 -> -344223485;
                case 147 -> 702732613;
                case 148 -> 382463560;
                case 149 -> 1048611480;
                case 150 -> 1235867913;
                case 151 -> -328744713;
                case 152 -> -1140254919;
                case 153 -> 1805475277;
                case 154 -> -1294018954;
                case 155 -> 912465056;
                case 156 -> -1466591624;
                case 157 -> 1207863438;
                case 158 -> -1370616059;
                case 159 -> 1486719897;
                case 160 -> -182239377;
                case 161 -> 1299138243;
                case 162 -> 837290637;
                case 163 -> 48830825;
                case 164 -> 2096519142;
                case 165 -> -713471162;
                case 166 -> -887861689;
                case 167 -> -232517800;
                case 168 -> -733139588;
                case 169 -> -2081356307;
                case 170 -> -1260729032;
                case 171 -> 1508740654;
                case 172 -> 1383945138;
                case 173 -> 396180174;
                case 174 -> 863710291;
                case 175 -> 2026884593;
                case 176 -> -1180716792;
                case 177 -> 898884534;
                case 178 -> -1137251772;
                case 179 -> -846392384;
                case 180 -> -210438933;
                case 181 -> 521242052;
                case 182 -> 486375930;
                case 183 -> 2038022932;
                case 184 -> 1841309407;
                case 185 -> 1546616352;
                case 186 -> 1089988564;
                case 187 -> 2141126295;
                case 188 -> -538087403;
                case 189 -> 1127280768;
                case 190 -> 920849115;
                case 191 -> -1744385832;
                case 192 -> -55099087;
                case 193 -> -614120312;
                case 194 -> -1962985250;
                case 195 -> 592160905;
                case 196 -> -1797493343;
                case 197 -> 387610887;
                case 198 -> -1034644685;
                case 199 -> -1449971088;
                case 200 -> -1877082956;
                case 201 -> 1627961320;
                case 202 -> 510324636;
                case 203 -> 180091188;
                case 204 -> 2011409915;
                case 205 -> 1380174318;
                case 206 -> -1181368027;
                case 207 -> -1057174411;
                case 208 -> -145587011;
                case 209 -> 1565954003;
                case 210 -> 1524304272;
                case 211 -> 213666000;
                case 212 -> 261145911;
                case 213 -> -856196654;
                case 214 -> 260462556;
                case 215 -> -1656415329;
                case 216 -> -257473336;
                case 217 -> -1878744665;
                case 218 -> 99043186;
                case 219 -> -278100055;
                case 220 -> -1742213370;
                case 221 -> -1805049913;
                case 222 -> 1389175643;
                case 223 -> -1635387542;
                case 224 -> -222432453;
                case 225 -> 2121570745;
                case 226 -> 541561146;
                case 227 -> -833108646;
                case 228 -> 894166199;
                case 229 -> 625555785;
                case 230 -> 1246651150;
                case 231 -> -2089651802;
                case 232 -> 696303574;
                case 233 -> -1500280738;
                case 234 -> 326170267;
                case 235 -> -1551042506;
                case 236 -> -116078273;
                case 237 -> 251844776;
                case 238 -> 1926220976;
                case 239 -> -1231157590;
                case 240 -> -1771340409;
                case 241 -> 1764767826;
                case 242 -> 2074685615;
                case 243 -> -1265425969;
                case 244 -> -1184355381;
                case 245 -> -1660083108;
                case 246 -> -1611916138;
                case 247 -> -536597526;
                case 248 -> -938021498;
                case 249 -> 1976721050;
                case 250 -> -1865237236;
                case 251 -> 626177596;
                case 252 -> 883166657;
                case 253 -> -1493519388;
                case 254 -> 1689793761;
                case 255 -> -997581016;
                default -> 1765282615;
            });
        } while (v2 != v3);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        v3 = v0.length;
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
            Object[] objectArray = new Object[65];
            v1 = objectArray;
            oiIO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0Oii = LoggerFactory.getLogger((String)"IrcManager");
        oIIi = new GsonBuilder().setPrettyPrinting().create();
        oIiO = FabricLoader.getInstance().getGameDir().resolve("clap");
    }

    @Override
    public JsonElement OIoo() {
        JsonObject v1 = new JsonObject();
        v1.addProperty("enabled", Boolean.valueOf(this.oioO));
        v1.addProperty("url", this.oio0);
        v1.addProperty("autoReconnect", Boolean.valueOf(this.oioo));
        v1.addProperty("reconnectDelaySeconds", (Number)this.oioI);
        v1.addProperty("showSystemMessages", Boolean.valueOf(this.oioi));
        return v1;
    }

    public synchronized void ioiO() {
        if (!this.oioO) {
            this.oi00 = "Disabled";
            return;
        }
        if (!ConfigSupport_oii0_1.OOi()) {
            this.oi00 = "Waiting for login";
            return;
        }
        if (this.oiOI || this.oiOo != null && !this.oiOo.isOutputClosed()) {
            return;
        }
        this.oi0O = false;
        this.oi00 = "Connecting";
        this.oIiI.newWebSocketBuilder().connectTimeout(Duration.ofSeconds(8L)).buildAsync(URI.create(this.oio0), this).exceptionally(param1 -> {
            this.oi00 = "Connect failed";
            0Oii.warn("Failed to connect IRC", param1);
            this.iIoi();
            return null;
        });
    }

    private void iIIo(Text param1) {
        MinecraftClient v2 = MinecraftClient.getInstance();
        v2.execute(() -> RenderSupport_ooi_0.HelpCommand(param1, "irc"));
    }

    public void RotationModule() {
        0ooo.Ooii().PacketEvent(this);
        this.iIIi();
    }

    public boolean iIoO(PlayerEntity param1) {
        if (param1 == null) {
            return false;
        }
        String v2 = param1.getGameProfile().name();
        return v2 != null && this.oiO0.contains(v2.toLowerCase(Locale.ROOT));
    }

    private void iI0I(JsonObject param1) {
        JsonElement v2 = param1.get("users");
        if (v2 == null || !v2.isJsonArray()) {
            return;
        }
        this.oiOO.clear();
        this.oiO0.clear();
        for (JsonElement v4 : v2.getAsJsonArray()) {
            if (!v4.isJsonObject()) continue;
            JsonObject v5 = v4.getAsJsonObject();
            String v6 = this.iIii(v5, "minecraftName");
            String v7 = this.iIii(v5, "username");
            if (v6.isBlank() || v7.isBlank()) continue;
            this.oiOO.put(v6.toLowerCase(Locale.ROOT), v7);
            if (!this.iiO0(v5, "god")) continue;
            this.oiO0.add(v6.toLowerCase(Locale.ROOT));
        }
    }

    @Override
    public void onError(WebSocket param1, Throwable param2) {
        this.oiOI = false;
        this.oiOi = false;
        this.oi00 = "Error";
        0Oii.warn("IRC socket error", param2);
        if (!this.oi0O) {
            this.iIoi();
        }
    }

    private synchronized void iIIO() {
        if (this.oi0o != null) {
            this.oi0o.cancel(false);
            this.oi0o = null;
        }
    }

    public synchronized void ioio() {
        this.oi00 = this.oiOi ? "Connected" : (this.oiOI ? "Authenticating" : "Disconnected");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void iIoi() {
        if (!this.oioO || !ConfigSupport_oii0_1.OOi() || !this.oioo || this.oi0O) {
            return;
        }
        IrcManager v1 = this;
        synchronized (v1) {
            if (this.oi0o != null && !this.oi0o.isDone()) {
                return;
            }
            this.oi0o = this.oIio.schedule(this::ioiO, (long)Math.max(1, this.oioI), TimeUnit.SECONDS);
            return;
        }
    }

    public void iIOi() {
        this.iI0O(false);
    }

    private void iIo0(String param1) {
        if (param1 == null || param1.isBlank() || ConfigSupport_oii0_1.HudElement().isBlank()) {
            return;
        }
        this.oiOO.put(param1.toLowerCase(Locale.ROOT), ConfigSupport_oii0_1.HudElement());
    }

    public boolean iIiI() {
        return this.iIi0();
    }

    private String iiOO(JsonObject param1, String param2, String param3) {
        JsonElement v4 = param1.get(param2);
        if (v4 == null || v4.isJsonNull()) {
            return param3;
        }
        try {
            return v4.getAsString();
        }
        catch (Throwable v5) {
            return param3;
        }
    }

    @Override
    public void OIoI(JsonElement param1) {
        if (param1 == null || !param1.isJsonObject()) {
            return;
        }
        JsonObject v2 = param1.getAsJsonObject();
        if (v2.has("enabled")) {
            this.oioO = v2.get("enabled").getAsBoolean();
        }
        if (v2.has("url")) {
            this.oio0 = v2.get("url").getAsString();
        }
        if (v2.has("autoReconnect")) {
            this.oioo = v2.get("autoReconnect").getAsBoolean();
        }
        if (v2.has("reconnectDelaySeconds")) {
            this.oioI = Math.max(1, v2.get("reconnectDelaySeconds").getAsInt());
        }
        if (v2.has("showSystemMessages")) {
            this.oioi = v2.get("showSystemMessages").getAsBoolean();
        }
    }

    private void iI00(String param1) {
        try {
            String v3;
            JsonObject v2 = JsonParser.parseString((String)param1).getAsJsonObject();
            switch (v3 = this.iIii(v2, "type")) {
                case "auth_ok": {
                    this.oiOi = true;
                    this.oi00 = "Connected";
                    this.iIIO();
                    this.iI0I(v2);
                    this.iI0O(true);
                    if (!this.iIiI() || !this.oioi) break;
                    this.iII0("{gray}IRC connected", new Object[0]);
                    break;
                }
                case "auth_fail": {
                    this.oiOi = false;
                    this.oi00 = "Auth failed";
                    if (!this.iIiI()) break;
                    this.iII0("{red}IRC auth failed: %s", this.iIii(v2, "message"));
                    break;
                }
                case "chat": {
                    this.iIoo(v2);
                    break;
                }
                case "system": {
                    if (!this.iIiI() || !this.oioi) break;
                    boolean v6 = "announcement".equalsIgnoreCase(this.iIii(v2, "level"));
                    Formatting v7 = v6 ? Formatting.GOLD : Formatting.GRAY;
                    this.iIIo((Text)Text.literal((String)(this.iiOO(v2, "prefix", "[IRC]") + " ")).formatted(Formatting.DARK_AQUA).append((Text)Text.literal((String)this.iIii(v2, "message")).formatted(v7)));
                    break;
                }
                case "history": {
                    this.iI0o(v2);
                    break;
                }
                case "users": {
                    this.iI0I(v2);
                    break;
                }
                case "identity_request": {
                    this.iI0O(true);
                    break;
                }
                case "error": {
                    String v6 = this.iIii(v2, "message");
                    if (this.iIiI() && !v6.toLowerCase(Locale.ROOT).contains("unknown packet type")) {
                        this.iII0("{red}IRC: %s", v6);
                    }
                    break;
                }
                case "ping": {
                    this.iIoI();
                    break;
                }
            }
        }
        catch (Throwable v2) {
            0Oii.warn("Failed to handle IRC packet: {}", (Object)param1, (Object)v2);
        }
    }

    public boolean ioii(String param1) {
        if (param1 == null || param1.isBlank()) {
            this.iII0("{red}IRC message is empty", new Object[0]);
            return false;
        }
        if (!this.iIi0()) {
            this.iII0("{red}Enable the IRC module first.", new Object[0]);
            return false;
        }
        if (!this.oiOi || this.oiOo == null) {
            this.iII0("{red}IRC is not connected. Use .i reconnect", new Object[0]);
            return false;
        }
        JsonObject v2 = new JsonObject();
        v2.addProperty("type", "chat");
        v2.addProperty("message", param1.trim());
        this.oiOo.sendText(oIIi.toJson((JsonElement)v2), true);
        return true;
    }

    private void iIIi() {
        Path v1 = oIiO.resolve(this.OIoi());
        if (!Files.isRegularFile(v1, new LinkOption[0])) {
            this.iIiO();
            return;
        }
        try {
            this.OIoI(JsonParser.parseString((String)Files.readString(v1)));
        }
        catch (Throwable v2) {
            0Oii.warn("Failed to load IRC config", v2);
        }
    }

    public synchronized void ioi0() {
        this.oi0O = true;
        this.oiOi = false;
        this.oiOI = false;
        this.iIIO();
        WebSocket v1 = this.oiOo;
        this.oiOo = null;
        this.oi00 = "Disconnected";
        this.oiOO.clear();
        this.oiO0.clear();
        if (v1 != null) {
            v1.sendClose(1000, "disconnect");
        }
    }

    public IrcManager() {
        this.oIiI = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(8L)).executor(this.oIi0).build();
        this.oIii = new StringBuilder();
        this.oiOO = new ConcurrentHashMap();
        this.oiO0 = ConcurrentHashMap.newKeySet();
    }

    private boolean iIi0() {
        IrcModule v1 = IrcModule.O0iiI();
        return v1 != null && v1.IoOo();
    }

    public CompletionStage onClose(WebSocket param1, int param2, String param3) {
        this.oiOI = false;
        this.oiOi = false;
        this.oi00 = "Disconnected";
        this.oiOo = null;
        this.oiOO.clear();
        this.oiO0.clear();
        if (!this.oi0O) {
            this.iIoi();
        }
        return WebSocket.Listener.super.onClose(param1, param2, param3);
    }

    private void iIOI(WebSocket param1) {
        JsonObject v2 = new JsonObject();
        v2.addProperty("type", "auth");
        v2.addProperty("username", ConfigSupport_oii0_1.HudElement());
        v2.addProperty("token", ConfigSupport_oii0_1.ConfigSupport_O0I());
        v2.addProperty("minecraftName", this.iIII());
        v2.addProperty("god", Boolean.valueOf(this.iIio()));
        v2.addProperty("client", "Clap");
        v2.addProperty("version", "1");
        param1.sendText(oIIi.toJson((JsonElement)v2), true);
        this.oi0I = this.iIII();
        this.oi0i = this.iIio();
        this.iIo0(this.oi0I);
    }

    public boolean iIO0() {
        return this.oiOi;
    }

    private void iII0(String param1, Object ... param2) {
        this.iIIo((Text)NetworkSupport_io0_0.HelpCommand(param1, param2));
    }

    public String iI0i(String param1) {
        if (param1 == null || param1.isBlank()) {
            return "";
        }
        return this.oiOO.getOrDefault(param1.toLowerCase(Locale.ROOT), "");
    }
}

