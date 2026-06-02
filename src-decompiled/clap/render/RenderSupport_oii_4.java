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
 *  net.minecraft.client.util.InputUtil
 *  org.joml.Vector2f
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package clap.render;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.security.Key;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.util.InputUtil;
import org.joml.Vector2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clap.model.EnumType_0OI;
import clap.gui.GuiSupport_O000;
import clap.setting.Setting;
import clap.setting.SettingContainer;
import clap.config.ConfigSupport_oioo_3;
import clap.model.DataRecord_oo0_0;
import clap.event.Listener;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.oIi
 */
public class RenderSupport_oii_4 {
    private static final Path HudElement;
    private String OoI = "default";
    private static final Path EventBusApi;
    private static final DateTimeFormatter OoO;
    private static final Gson O0i;
    private static final Logger PacketEvent;
    private static final Path HelpCommand;
    private long Ooi;
    private static final String OOi;
    private SettingContainer Ooo;
    private final List Oo0 = new LinkedList();
    private static final long O0o;
    private static final String GuiSupport_OOI;
    private static final Path OOo;
    private static final Pattern ConfigSupport_O0I;
    static Object KeystrokesHudElement;
    private static volatile /* synthetic */ long __k__gH4it;

    private void Ooi() {
        this.DataRecord_0O0(HelpCommand);
        this.DataRecord_0O0(OOo);
    }

    private void Oio(SettingContainer param1, Path param2) {
        try {
            Path v3 = param2.getParent();
            if (v3 != null) {
                this.DataRecord_0O0(v3);
            }
            Files.writeString(param2, (CharSequence)O0i.toJson(param1.OIoo()), new OpenOption[0]);
        }
        catch (Throwable v3) {
            PacketEvent.error("Failed to write {}", (Object)param2, (Object)v3);
        }
    }

    public Path Oo0() {
        this.Ooi();
        return OOo;
    }

    private Path 0Oo(String param1) {
        return OOo.resolve(param1 + ".json");
    }

    private void Oii(Path param1) {
        Path v2 = param1.resolve("modules.json");
        if (!Files.isRegularFile(v2, new LinkOption[0])) {
            return;
        }
        String v3 = param1.getFileName().toString();
        Path v4 = this.0Oo(v3);
        try {
            if (!Files.exists(v4, new LinkOption[0])) {
                Files.copy(v2, v4, new CopyOption[0]);
            }
            this.ConfigSupport_0OO(param1);
        }
        catch (IOException v5) {
            PacketEvent.error("Failed to migrate legacy config '{}'", (Object)v3, (Object)v5);
        }
    }

    private boolean OIo() {
        if (this.Ooo == null) {
            return true;
        }
        this.Oi0(this.Ooo, HudElement);
        return true;
    }

    private void StorageEspModule() {
        if (0ooo.IIi() != null) {
            0ooo.IiO().oooi();
        }
    }

    private void OiO() {
        if (this.Ooo != null) {
            this.Oio(this.Ooo, HudElement);
        }
    }

    private boolean Kernel32SnapshotApi(String param1) {
        return param1 != null && ConfigSupport_O0I.matcher(param1).matches();
    }

    private Path EnumType_0OI(String param1) {
        return OOo.resolve(param1);
    }

    public void EventBusApi() {
        if (System.currentTimeMillis() < this.Ooi) {
            return;
        }
        this.HudElement();
    }

    public List O0o() {
        return this.ConfigSupport_O0I().stream().map(DataRecord_oo0_0::HelpCommand).toList();
    }

    private void ConfigSupport_0OO(Path param1) throws IOException {
        try {
            try (Stream<Path> v2 = Files.walk(param1, new FileVisitOption[0]);){
                v2.sorted(Comparator.reverseOrder()).forEach(param0 -> {
                    try {
                        Files.deleteIfExists(param0);
                        return;
                    }
                    catch (IOException v1) {
                        throw new RuntimeException(v1);
                    }
                });
            }
            return;
        }
        catch (RuntimeException v2) {
            Throwable v4 = v2.getCause();
            if (v4 instanceof IOException) {
                IOException v3 = (IOException)v4;
                throw v3;
            }
            throw v2;
        }
    }

    public boolean OOo(String param1) {
        String v2 = this.0Oi(param1);
        this.Ooi();
        this.OiI();
        this.KeystrokesHudElement();
        boolean v3 = "default".equals(v2) ? this.OIo() : this.ConfigSupport_OII(v2);
        if (!v3) {
            return false;
        }
        this.OoI = v2;
        this.ConfigSupport_00o_0();
        this.StorageEspModule();
        return true;
    }

    private boolean ConfigSupport_OII(String param1) {
        if (this.Ooo == null) {
            return true;
        }
        Path v2 = this.0Oo(param1);
        if (Files.isRegularFile(v2, new LinkOption[0])) {
            this.Oi0(this.Ooo, v2);
            return true;
        }
        Path v3 = this.EnumType_0OI(param1).resolve("modules.json");
        if (Files.isRegularFile(v3, new LinkOption[0])) {
            this.Oi0(this.Ooo, v3);
            return true;
        }
        PacketEvent.warn("Config '{}' does not exist", (Object)param1);
        return false;
    }

    public String OoO() {
        return this.OoI;
    }

    public boolean HelpCommand() {
        return this.OOo("default");
    }

    private void DataRecord_0O0(Path param1) {
        if (!param1.toFile().exists()) {
            try {
                Files.createDirectories(param1, new FileAttribute[0]);
            }
            catch (IOException v2) {
                throw new RuntimeException("Failed to create needed directories!", v2);
            }
        }
    }

    private void ConfigSupport_OI0() {
        for (SettingContainer v2 : this.Oo0) {
            this.Oio(v2, HelpCommand.resolve(v2.OIoi()));
        }
    }

    private void ConfigSupport_00o_0() {
        this.Ooi = System.currentTimeMillis() + 600000L;
    }

    private DataRecord_oo0_0 Ooo(Path param1) {
        String v2 = param1.getFileName().toString();
        String v3 = v2.substring(0, v2.length() - 5);
        FileTime v4 = FileTime.from(Instant.EPOCH);
        try {
            v4 = Files.getLastModifiedTime(param1, new LinkOption[0]);
        }
        catch (IOException v5) {
            PacketEvent.error("Failed to read config modified time for {}", (Object)param1, (Object)v5);
        }
        return new DataRecord_oo0_0(v3, v4.toMillis(), OoO.format(v4.toInstant()));
    }

    public List ConfigSupport_O0I() {
        this.Ooi();
        this.OiI();
        ArrayList v1 = new ArrayList();
        if (Files.isDirectory(OOo, new LinkOption[0])) {
            try (Stream<Path> v22 = Files.list(OOo);){
                Stream<DataRecord_oo0_0> stream = v22.filter(param0 -> Files.isRegularFile(param0, new LinkOption[0])).filter(param0 -> param0.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".json")).map(this::Ooo).filter(param1 -> param1 != null && this.Kernel32SnapshotApi(param1.HelpCommand())).sorted(this::OoI);
                Objects.requireNonNull(v1);
                stream.forEach(v1::add);
            }
            catch (IOException v22) {
                PacketEvent.error("Failed to list configs", (Throwable)v22);
            }
        }
        return v1.stream().distinct().sorted(this::OoI).toList();
    }

    public RenderSupport_oii_4() {
        this.Ooi = System.currentTimeMillis() + 600000L;
    }

    private int OoI(DataRecord_oo0_0 param1, DataRecord_oo0_0 param2) {
        boolean v4;
        boolean v3 = param1.HelpCommand().equals(this.OoI);
        if (v3 != (v4 = param2.HelpCommand().equals(this.OoI))) {
            return v3 ? -1 : 1;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(param1.HelpCommand(), param2.HelpCommand());
    }

    private void KeystrokesHudElement() {
        for (SettingContainer v2 : this.Oo0) {
            this.Oi0(v2, HelpCommand.resolve(v2.OIoi()));
        }
    }

    public boolean OOi(String param1) {
        String v2 = this.0Oi(param1);
        this.Ooi();
        this.ConfigSupport_OI0();
        this.RenderSupport_oii_4(v2);
        this.OoI = v2;
        this.ConfigSupport_00o_0();
        return true;
    }

    public static void DataRecord_00I(Listener param0, Setting param1, JsonElement param2) {
        if (param2 == null || param2.isJsonNull()) {
            return;
        }
        switch (param1.RenderSupport_oii_4()) {
            case "Boolean": {
                param1.OOo(param2.getAsBoolean());
                break;
            }
            case "Double": {
                param1.OOo(param2.getAsDouble());
                break;
            }
            case "Float": {
                param1.OOo(Float.valueOf(param2.getAsFloat()));
                break;
            }
            case "Integer": {
                param1.OOo(param2.getAsInt());
                break;
            }
            case "String": {
                param1.OOo(param2.getAsString());
                break;
            }
            case "Bind": {
                try {
                    if (param2.isJsonObject()) {
                        JsonObject v5 = param2.getAsJsonObject();
                        GuiSupport_O000 v6 = new GuiSupport_O000(v5.has("key") ? v5.get("key").getAsInt() : -1);
                        if (v5.has("mode")) {
                            try {
                                v6.iOiO(EnumType_0OI.valueOf(v5.get("mode").getAsString().toUpperCase(Locale.ROOT)));
                            }
                            catch (Exception exception) {
                                v6.iOiO(EnumType_0OI.PacketEvent);
                            }
                        }
                        param1.OOo(v6);
                        break;
                    }
                    if (param2.isJsonPrimitive() && param2.getAsJsonPrimitive().isNumber()) {
                        param1.OOo(new GuiSupport_O000(param2.getAsInt()));
                        break;
                    }
                    String v5 = param2.getAsString();
                    if (v5.equalsIgnoreCase("None")) {
                        param1.OOo(GuiSupport_O000.iOIO());
                        break;
                    }
                    if (v5.toLowerCase(Locale.ROOT).startsWith("mouse ")) {
                        param1.OOo(GuiSupport_O000.iOI0(Integer.parseInt(v5.substring(6))));
                        break;
                    }
                    int v6 = -1;
                    try {
                        v6 = InputUtil.fromTranslationKey((String)v5.toUpperCase(Locale.ROOT)).getCode();
                    }
                    catch (Exception exception) {}
                    param1.OOo(new GuiSupport_O000(v6 == 0 ? -1 : v6));
                }
                catch (Exception v5) {
                    PacketEvent.error("Error parsing bind for: {} : {}", new Object[]{param0.iooi(), param1.PacketEvent(), v5});
                }
                break;
            }
            case "Mode": {
                try {
                    param1.OOo((Object)EnumType_0OI.valueOf(param2.getAsString().toUpperCase(Locale.ROOT)));
                }
                catch (Exception v5) {
                    PacketEvent.error("Error parsing bind mode for: {} : {}", new Object[]{param0.iooi(), param1.PacketEvent(), v5});
                }
                break;
            }
            case "Color": {
                try {
                    String v5 = param2.getAsString();
                    String[] v6 = v5.split(",");
                    if (v6.length != 4) break;
                    int v7 = Integer.parseInt(v6[0]);
                    int v8 = Integer.parseInt(v6[1]);
                    int v9 = Integer.parseInt(v6[2]);
                    int v10 = Integer.parseInt(v6[3]);
                    param1.OOo(new Color(v7, v8, v9, v10));
                }
                catch (Exception exception) {
                    PacketEvent.error("Error parsing color for: {} : {}", (Object)param0.iooi(), (Object)param1.PacketEvent());
                }
                break;
            }
            case "Pos": {
                try {
                    String v5 = param2.getAsString();
                    String[] v6 = v5.split(",");
                    if (v6.length != 2) break;
                    float v7 = Float.parseFloat(v6[0]);
                    float v8 = Float.parseFloat(v6[1]);
                    param1.OOo(new Vector2f(v7, v8));
                }
                catch (Exception exception) {
                    PacketEvent.error("Error parsing position for: {} : {}", (Object)param0.iooi(), (Object)param1.PacketEvent());
                }
                break;
            }
            case "Enum": {
                try {
                    ConfigSupport_oioo_3 v5 = new ConfigSupport_oioo_3(param1.HelpCommand().getClass());
                    Enum v6 = v5.EventBusApi(param2);
                    if (v6 == null) {
                        PacketEvent.warn("Skipping invalid enum value '{}' for {}.{}", new Object[]{param2.getAsString(), param0.iooi(), param1.PacketEvent()});
                        break;
                    }
                    param1.OOo(v6);
                }
                catch (Exception v5) {
                    PacketEvent.error("Error parsing enum for {}.{}: {}", new Object[]{param0.iooi(), param1.PacketEvent(), v5});
                }
                break;
            }
            default: {
                PacketEvent.error("Unknown Setting type for: {} : {}", (Object)param0.iooi(), (Object)param1.PacketEvent());
            }
        }
    }

    static {
        __k__gH4it = RenderSupport_oii_4.__k__gH4it((long)8610058058913017361L);
        __rP__gH4it0 = new String[]{"\u954e\u71ec\uaf71\ufa84\u7d3d\u32c9\ub890\uad21", "\u95eb\u71ef\uaf3c\ufafd\u7de5\u329c\ub8f2\uad77\u94e7\u70f9\uae34\ufb99\u7c8b\u3186\ubbd8\uae34\u97db\u73d3\uad11\uf8a5", "\u95fd\u71fd\uaf2e"};
        __rP__gH4it1 = new String[]{"\u95fd\u71e4\uaf3f\ufa90\u7d85\u32e3\ub883\uad64\u94e3\u708e", "\u95e8\u71e8\uaf3f\ufaed\u7d8c"};
        __rP__gH4it2 = new String[]{"\u95ed\u71f5\uaf3f\ufaec\u7d85\u32e4\ub8b6"};
        __rP__gH4it3 = new String[]{"\u9624\u72ea\uacd5\uf94d\u7e49\u3030\ubaed\uaf00\u898e\u6d25\ub30d\ue631\u61df\u2f49\ua5bb\ub003\u88eb\u6c02\ub24b\ue7fd\u60d7\u2ec9\ua477\ub1a7\u8b3c\u6fa4\ub135\ue4f4\u63c8\u2d9b\ua704\ub2f8\u8be1\u6e7d\ub09e\ue59e\u62fd\u2c7a\ua676\ub35d\u8aca\u69bd\ub73c\ue2e7\u6590\u2be7\ua136\ub43a\u8d31\u68ae\ub688\ue343\u64fe\u2a77\ua00a\ub5f4\u8c72\u6bc5\ub5c6\ue0fd\u6761\u290b\ua3fa\ub64c\u8f1e\u6bc6\ub443\ue1a7\u66a3\u28c7\ua27a\ub791\u8e5b\u6a60\ubbec\uee4c\u6979\u27cd\uad3e\ub831\u810e\u655e\ubaff\uef08\u6887\u2696\uaca2\ub96e\u803f\u64d6\ub9af\uec99\u6bd6\u25b3\uaf17\ubaa9\u83e7\u67f4\ub9fd\ued27\u6a24\u246b\uae2c\ubbbe\u82c9\u66b4\ub836\ueaff\u6d49\u234a\ua92e\ubce8\u8572\u61ce\ubf34\ueb58\u6c82\u22b4\ua837\ubd47\u8444\u6084\ube62\ue8b4\u6fcc\u2174\uab4b\ube56\u8726\u6336\ubd91\ue890\u6e60\u2065\uaaf1\ubf69\u862f\u621b\ubc8c\ue969\u11af\u5fa3\ud589\uc0f0\uf9f5\u1d84\uc33e\u9679\u1022\u5ebc\ud4c9\uc102\uf8d8\u1c8a\uc26c\u977c\u13d0\u5d65\ud726\uc271\ufba6\u1f68\uc187\u942a\u134d\u5c82\ud6f3\uc363\ufaea\u1eac\uc05f\u951d\u126b\u5b96\ud12b\uc4c7\ufd21\u1942\uc737\u9232\u1522\u5a43\ud0e5\uc5d2\ufc70\u1839\uc66d\u9359\u1418\u5ae6\ud3b6\uc653\uffd0\u1b22\uc5c5\u906e\u177f\u59e3\ud2b9\uc77f\ufebe\u1a50\uc48d\u9112\u165f\u58e5\uddfa\uc8fe\uf113\u1583\ucb8a\u9e66\u19cb\u571f\udcf6\uc996\uf0d0\u143c\uca49\u9fa1\u1821\u56e4\udcf3\uca70\uf3b0\u17b8\uc985\u9c56\u1b6b\u559f\udfe3\ucb4d\uf28c\u160e\uc893\u9de8\u1ab5\u54d5\ude81\uccf5\uf5c7\u11b3\ucfe0\u9a26\u1db6\u5323\ud9a8\ucdaf\uf4ce\u10a7\uce70\u9b8d\u1cbc\u52b4\ud85c\ucd09\uf721\u13ef\ucd04\u98ca\u1f0f\u5182\udb35\uceeb\uf611\u12da\uccaf\u9927\u1e32\u5071\udad8\ucf7b\ue9df\u0de5\ud37b\u8656\u0181\u4f12\uc5a0\ud09e\ue87f\u0ccd\ud277\u8751V\u4ee2\uc43c\ud178\ue8d9\u0fb6\ud11e\u84be\u03cb\u4de7\uc711\ud217\uebc0\u0e02\ud0e4\u85c1\u027e\u4c39\uc6a8\ud3e1\ueaf2\u0929\ud776\u824e\u05e5\u4bb2\uc16c\ud47f\ued27\u0805\ud664\u83b6\u0454\u4ad5\uc031\ud5d5\uec53\u087f\ud5a8\u8056\u0798\u4948\uc382\ud612\ueff2\u0b1c\ud469\u812e\u0670\u4897\uc26f\ud771\uee04\u0aab\udba5\u8ed5\u090f\u4710\ucd59\ud862\ue1f5\u05c5\udabf\u8fd5\u0819\u46d0\ucce2\ud922\ue0a5\u0480\uda0b\u8c07\u0b7e\u45e7\ucfe6\uda70\ue37b\u07e8\ud95c\u8dba\u0a2f\u4431\uceef\udb4a\ue299\u0633\ud853\u8a08\u0d56\u43c2\uc9c9\udc5d\ue5fb\u0174\udf55\u8ba1\u0c62\u42f7\uc8f6\udd24\ue4c8t\ude09\u8b01\u0fa6\u419e\ucb27\udecb\ue723\u03dc\uddd2\u888f\u0ea1\u407e\ucac9\udf92\ue6b1\u02cc\udcb6\u89bb\u31e1\u7f0f\uf515\ue078\ud95e\u3db9\ue332\ub632\u30f9\u7ebe\uf4ae\ue179\ud831\u3c79\ue291\ub719\u3083\u7dcb\uf7ce\ue2db\udb1d\u3f39\ue1a0\ub401\u33a1\u7c0e\uf671\ue3ee\udab8\u3ef9\ue04a\ub5f0\u32a4\u7b8c\uf107\ue4b1\uddb6\u398c\ue79f\ub2c5\u358b\u7b02\uf0b2\ue505\udc6c\u3829\ue656\ub375\u349a\u7a3e\uf375\ue664\udfee\u3b64\ue580\ub03f\u375b\u7900\uf2f3\ue740\ude21\u3a83\ue4a0\ub197\u3664\u78c8\ufd79\ue80f\ud1c6\u356a\ueba5\ube07\u3904\u77a4\ufd2c\ue947\ud0e5\u3440\uea76\ubfbe\u38f9\u762a\ufc1b\ueaa0\ud3a8\u3718\ue960\ubcbb\u3b2a\u75c0\uffae\ueb8b\ud265\u363a\ue824\ubdb9\u3abd\u742f\ufe00\uec7c\ud5a5\u3183\uef6b\uba68\u3d6d\u735f\uf970\uec58\ud459\u30a0\uee22\ubb64\u3c24\u729a\uf891\ued58\ud7fd\u33c6\ued3f\ub8db\u3f20\u7116\ufb95\ueeed\ud6a3\u3249\uec16\ub9ae\u3e30\u70fa\ufa2a\uef83\uc9be\u2dc6\uf3ba\ua6dd\u213e\u6f5a\ue59c\uf0b1\uc959\u2c5a\uf213\ua73d\u2044\u6e5c\ue481\uf161\uc896\u2f93\uf1d5\ua4bf\u2379\u6d04\ue7e1\uf2e5\ucb35\u2e62\uf06d\ua580\u22a1\u6caa\ue6d4\uf34c\uca4d\u29c2\uf762\ua24c\u2593\u6be2\ue10c\uf430\ucd70\u293e\uf6a2\ua398\u2434\u6aa7\ue0b4\uf568\ucc0c\u2876\uf5cb\ua060\u27b7\u69a8\ue38f\uf67f\ucf4a\u2b68\uf494\ua179\u2682\u68b9\ue21a\uf74e\uce4a\u2a2a\ufb5f\uae4d\u2914\u674d\uedc5\uf890\uc1bc\u2539\ufb73\uaf0d\u28cf\u6600\uecc4\uf935\uc015\u24d7\ufaf8\uacfb\u2be1\u659b\uef78\ufabe\uc30f\u27f4\uf912\uad81\u2a16\u64b3\uee52\ufb60\uc2c9\u26fd\uf8a5\uaa60\u2d7f\u6391\ue932\ufc6c\uc5d1\u217c\ufffe\uaa86\u2cc0\u6236\ue8a7\ufdd6\uc453\u20b4\ufe93\uab48\u2fe8\u6185\ueb98\ufef0\uc736\u23c5\ufdf1\ua8c6\u2ebe\u60c8\uea88\uff77\uc6ec\u228c\ufc68\ua955\ud134\u9fce\u159f\u00f5\u3950\udd0f\u034f\u561d\ud1d2\u9e47\u141a\u010c\u3829\udc78\u0270\u57d5\ud0aa\u9dff\u17e1\u0256\u3bcf\udfdf\u015c\u5416\ud31d\u9ce9\u16cb\u034a\u3a01\udeb3\f\u55eb\ud2fb\u9c68\u11c5\u04d2\u3dd2\ud9de\u073d\u52b1\ud541\u9bea\u10c7\u05f8\u3cf0\ud82f\u06c0\u535c\ud46c\u9ae2\u138e\u067d\u3fb3\udb5d\u0586\u5040\ud725\u99fc\u1275\u0764\u3e40\udae7\u0409\u515f\ud66c\u9842\u121b\u087c\u31aa\ud5af\u0b7f\u5e45\ud975\u9779\u1db5\u09a4\u3014\ud412\u0a48\u5ff1\ud859\u9679\u1c04\u0a71\u3329\ud716\u09c8\u5cfc\udb2e\u9527\u1f23\u0b77\u3218\ud646\u0802\u5d5d\uda6a\u94c8\u1e5d\u0bd4\u35f8\ud101\u0f0b\u5ae7\udda2\u93ed\u19f1\u0c35\u3486\ud0da\u0e79\u5b86\udc01\u9234\u1878\u0dfb\u3700\ud374\u0d4d\u58ce\udfba\u915f\u1b0d\u0e5e\u369d\ud2c8\u0c2b\u5944\ude30\u9033\u1a9a\u0f28\u36af\ucdd2\u13f1\u4671\uc146\u8f3c\u05d0\u103a\u294b\ucc3e\u1215\u473b\uc0f1\u8eda\u0436\u112d\u28eb\ucfb8\u1100\u44a6\uc398\u8d7d\u073e\u1251\u2bf9\uce9f\u1056\u4575\uc28c\u8c00\u066f\u1359\u2a99\uce3f\u1702\u4225\uc5e9\u8b84\u0181\u14c8\u2d82\uc99d\u16cc\u432c\uc4a5\u8afdU\u1595\u2cd0\uc876\u156c\u40df\uc7ec\u89aa\u0310\u1655\u2fe7\ucb57\u149d\u41d8\uc6f1\u8817\u02b5\u174a\u2e00\uca96\u146d\u4e1d\uc9a9\u8767\u0dfb\u18c0\u2132\uc564\u1b15\u4f57\uc8bc\u8682\u0c01\u19cd\u202e\uc4df\u1a23\u4c89\ucb06\u8541\u0fac\u1a10", "\u95ff\u71e6\uaf39\ufa96\u7d87\u32e1\ub88d\uad6a\u94e1\u708c"};
        byte[] v0 = "\u00e3\u00e8R7\u0087V\u00a4\u00e0A/\u0082C\u00197\u00ea\u00fb<\u0010\u00dc\u0097\t\u00bf.W\u00e3\u00be\u00aa\u0096\u001e\u00d5%0\u00c6_y\u00c4\u00d3<_\u009d\u00e5\u0097\u00d3\u00b5\u00b6\u00b9\u0007\u00e2\u0006\u009c\u007f\t\u00c0!3$M\u00ff9\u00bfW\u00a5\u00fb\u00e4\u0019\u0004\u0084\u009d\u00adas1T\u00aa#~\u007fs/\u0089\u0019\u008c(\"\u0099 \u00bb\u00de \fp\u00bb\u00c0=\u00f6!\u0080\u0016\u00da=J\u00ed\u00c5>\u00a6^\u0019\u00ed/\u00d4\u00dfp\u0005<\u0003R\u00fc\"\u00ce\u00d7;~]\u00b6\u00ba\u009a\u008a>a\u00b4\u0096j.\u00838\t`\u0091\u0083\u009b\u00e9]X\u0088\u00a2\u0016)\u0093|J\u0010r\u0087\u0010s\u009e\u0086\u00ab\u00879\u0001\u00ca\u00e0\u00f0\u00e3DZ#E\u00060\u00cf\u00cdH\u009a\u009f\u0096\u00f0@\u00f8\u009c\u0095\\\u0082\u00cf\u0083\u0012\u009b\u00ae\u00c87{W`\u0082\u00d4\u00f1\u00c50_1\u001a\u00c2\u00a0\u00d9\u00dbk\u00c6\u0084\u00d1\u00dd\u00ccU)o\u00a6Of\u0016\u0003\u00b7\u00ea\u0092xW\u00da\"\u00cc\u0085\u0099\u008aMcd<zS\u00cb\u00f0\u00ed0\u00c1W\u00acH5\u00d1\u00bf1\u00dd\u00cf\u000fJ\u00da\u001d\u00e1\u00e6\u00ed\u0083\u00b0\u00c1\u00e4|\u000b\u00de\u00d0 U\u00f4\u000f\u0089\u0083\b\u00f7\u00ec<_d\u00f9n\u00a0\u00d7\u00e83\u0080\u00ac\u001d\u00b0\u00fe\u0094\u00f9\u00e4\u00e5\u00a18\u00d7\u00ef(\u000b\u0093Xg\u00999\u00c5\u001b\u0081\u0004\u00db\u00e4U\u00af\u0018?\u009b\u00f4b{0}T\u00bdol\u0096\u00ee\u008b\u00b2\u00fd\u00d6\u00a6\u001cv)~\u00c9\u0013yr\u00ff\u0011\u00a6@\u00d2\u00ea\u001f`\u00f7\u000f^\u0003\u00aa\u00c2b,\u001d\u0010a\u000f\u00f0\u0014\u0002s\u00a8I\u00af\u001e\u00d2\u00ee\u00c1d\u0002(T0\u00cd\u0084\u008ej\u00a3\u0014\u00197L\u008f\u00f6\u000e\u00fb\u00e8x\u00ee\u00ablV\u00dd}\u00e7\u0080\u0018\u00ea\u00e6^\u00a1Q\u00bf\u00f9\u00cc\b\u0001#-\u00d0\u00afp\u000f1\u0096\u00db\u00f6\u00c3-\rg\u009b\u00b2\u0093\u00cf\u00d3\u0007\u00d0\u00c0\u00b6\u000fK=:\u001aZ\u00be\u00e1\t6\u00e0\u0007=,3-\u00ebk\u0011\u00cf\u0014\u0018\u00fcDa.\u00cf\u008d\u00dd>bx\u00b6\u00d1\u00f7=\u00fa\u00fe\u00e0?Y0\u00fa\u00a5\u0092\u00aaMO\u0002\"\u00d1$\u0017,r\u00a0Gr\u00cf)\u00cc\u00de\u00df\u0093\u0092H\u00933C9ylZ\u00f9\u00d4\u00ea\u009b11\u00b0\u009e\u00a2\u00a5\u001e\u00ea\u00fc\u00d8\u00b82\u00cc\u00b0\u00a9\u00e6h\u00c4\u0015t[\u0081\u00c4\u00ee\u008cssa\u00dc%\u00bf\u00e8\u0014\u00bdy~x\u00f4gj\u001a\u00a8\u00a1\u00b9\u00b9:\u00ed_Z\u00d0=\u0002P\u009a\u00ca\u009f\u00fc\u00ed\u009cr\u00f8\u009d\u000e\u00a5L\r\u0098w\u00fce\u00a2:\u0001\u00bd\u00c8\u0003\u00bc\u0004R\u00b1\u0016\u009e\u00c7]\u00baCS\u009c\u000f\u0003\u00feU\u00f0\u0080o\u0002\u00c3$\u0018\u00db\u00dbT\u0017\u00a1\u0086-\u00b5z=\u00d7\u00e9\u0087\u0005\u0089&x\u0006%\u008bh%\u00ab\u00f0\u00b6\u0007\u009ab\t\u007f\u00f3\u0004\u0096\u00fe\u00f9|\u008e\u00d0n\u00b6\u001c>\u009c\u00ba\u00ae{I\u0088aW\u00e6,\u00e0>Q\u0007\u00b3\u0016w\u00b7b\u0000>\u00bd\u00f7\u00ad(\u00c7|\u0081\u00b3L\u0086\u00d2\u001f\u0007\f!P\u000exm+\u00dc\u00a3?r\u001a\u00be\ts)MFD\u00faU\u009cz\u000b\u00cf\u00ccN\u00d8\u007fe\u008f\u00ee\u00ea\u00dc\u001fE$\u000f\u00d1\u00ea\u00bb\u00ca\u00ecT\u00df\u00bdV\u00fd\u00faLztM\u00cd\u00d8\u00df\u009b\u007f\u00dc\u00a4\u00fbx\u00e7c\u00bfgui\u00ded\u007fv\u00d01Zg\u00e7<\u00bd\u00df\u009c\u00a6\u001c<?\u0003\u008c\u009dl\u008b\u00b8\u00d5I\u00d0\u00f6\u00f4\u00c7J)\u0003\u00d7f\u00da\u00a4d)T\u00aeB\u00d2\u00b4&\u00e6}\u00bb\u00e0\u0088\u00f0\u0016+hz\u00f9\u00fad\u0014\u00fai\u00d7\u0084\u0007\u00f5\u00dc\u008a\u00f7\u00ec\u00a6+\u0007\u0081\u00c6\u00a5\u00a97\u00ba\u00aen\u00f1\u009e\u00fd\u00c5\u001f\u00e7\"\u0088h\u008dW\u0003\u001e\u00a3CD-\u00c7\u00a4\u00bb\u00f5\u00f2\u001c\t\u00e5\u00f8\u008dB\u00fa\u00e7\u0099T\u00c2gtJ\u0007\u00c7\u00e1\u0012@]\u008e:E\u00da\u001c\u00f0UY-\u0014\u0083x\u00d7U\u0080".getBytes("ISO_8859_1");
        Object[] v1 = "\u00fbX\u0000L\u0081\u0011's".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1662448324;
                case 1 -> 1653824885;
                case 2 -> -1764306800;
                case 3 -> 700218667;
                case 4 -> -1180951243;
                case 5 -> -1877535677;
                case 6 -> -1727731381;
                case 7 -> 1117993054;
                case 8 -> 1719520025;
                case 9 -> 150816520;
                case 10 -> 424411983;
                case 11 -> -764820332;
                case 12 -> -2094616285;
                case 13 -> -1122074638;
                case 14 -> -1867087490;
                case 15 -> 1413859218;
                case 16 -> -1969832481;
                case 17 -> 1239970956;
                case 18 -> -472860879;
                case 19 -> -1146491986;
                case 20 -> -484556348;
                case 21 -> 1445285417;
                case 22 -> -685155409;
                case 23 -> -1354480397;
                case 24 -> 717254847;
                case 25 -> -39963211;
                case 26 -> -2008261993;
                case 27 -> 766180390;
                case 28 -> -1712877222;
                case 29 -> 2086619097;
                case 30 -> 1995269500;
                case 31 -> 1902386957;
                case 32 -> 1595033406;
                case 33 -> -48144774;
                case 34 -> 528013902;
                case 35 -> 293434080;
                case 36 -> 346338141;
                case 37 -> -138393567;
                case 38 -> -325661843;
                case 39 -> -1951026295;
                case 40 -> 1300191352;
                case 41 -> 569005523;
                case 42 -> -241876948;
                case 43 -> 1569239797;
                case 44 -> 145293649;
                case 45 -> -274702888;
                case 46 -> 1634469727;
                case 47 -> 377753244;
                case 48 -> 2004357688;
                case 49 -> -1058297568;
                case 50 -> -1906466330;
                case 51 -> -396190228;
                case 52 -> 1736112380;
                case 53 -> -2136909151;
                case 54 -> -1034015001;
                case 55 -> -188169923;
                case 56 -> 1227275085;
                case 57 -> -345949799;
                case 58 -> -643671961;
                case 59 -> 1163667485;
                case 60 -> -514993267;
                case 61 -> 1618480930;
                case 62 -> -196763493;
                case 63 -> 227920039;
                case 64 -> 1422965592;
                case 65 -> -835982165;
                case 66 -> 588815322;
                case 67 -> -1504376053;
                case 68 -> 1058865448;
                case 69 -> 1920665217;
                case 70 -> -878905635;
                case 71 -> -30966420;
                case 72 -> -1406749848;
                case 73 -> 515636878;
                case 74 -> -650226657;
                case 75 -> -559383892;
                case 76 -> 416508625;
                case 77 -> -367470721;
                case 78 -> 993284349;
                case 79 -> 194026746;
                case 80 -> 2022533386;
                case 81 -> -1563700245;
                case 82 -> -932490883;
                case 83 -> -1958414843;
                case 84 -> -819430758;
                case 85 -> 1519912904;
                case 86 -> 1654056325;
                case 87 -> 1194482030;
                case 88 -> 1252623865;
                case 89 -> -2039651547;
                case 90 -> 543803298;
                case 91 -> 339814876;
                case 92 -> 1008537227;
                case 93 -> -574458299;
                case 94 -> -1038291895;
                case 95 -> 1299350806;
                case 96 -> -1732765526;
                case 97 -> 1647063088;
                case 98 -> -1406134274;
                case 99 -> -1266692800;
                case 100 -> 1078074359;
                case 101 -> 1298031632;
                case 102 -> -538716508;
                case 103 -> -1033781465;
                case 104 -> -1971455517;
                case 105 -> -1991912719;
                case 106 -> -1063913615;
                case 107 -> -197873210;
                case 108 -> 775109192;
                case 109 -> 1704394169;
                case 110 -> 371642025;
                case 111 -> -1270629229;
                case 112 -> -2133332287;
                case 113 -> 1983581300;
                case 114 -> 1746851985;
                case 115 -> 190627355;
                case 116 -> 418313858;
                case 117 -> -2001306155;
                case 118 -> 414291076;
                case 119 -> 1479252462;
                case 120 -> -1103780508;
                case 121 -> -230984156;
                case 122 -> 993241792;
                case 123 -> 1903892242;
                case 124 -> 888597761;
                case 125 -> -959193071;
                case 126 -> -60316644;
                case 127 -> 689849581;
                case 128 -> 881427527;
                case 129 -> -500321012;
                case 130 -> 627435571;
                case 131 -> 2016232725;
                case 132 -> -815675366;
                case 133 -> -1101652137;
                case 134 -> 823765088;
                case 135 -> 1315760519;
                case 136 -> -998818101;
                case 137 -> 2052474454;
                case 138 -> 295040772;
                case 139 -> 778597733;
                case 140 -> -649529225;
                case 141 -> -462486039;
                case 142 -> -350010192;
                case 143 -> 1379499775;
                case 144 -> 684408658;
                case 145 -> -136392428;
                case 146 -> 404149926;
                case 147 -> -227425685;
                case 148 -> -1455666274;
                case 149 -> -957379192;
                case 150 -> -276093056;
                case 151 -> -1655221316;
                case 152 -> 1619322880;
                case 153 -> -440395594;
                case 154 -> 1395202511;
                case 155 -> 149131679;
                case 156 -> 1604669013;
                case 157 -> -484977747;
                case 158 -> -1835043160;
                case 159 -> -503728295;
                case 160 -> -1459775510;
                case 161 -> 1624271639;
                case 162 -> -278447473;
                case 163 -> 1196556547;
                case 164 -> 1313112741;
                case 165 -> -1086023884;
                case 166 -> -28802442;
                case 167 -> -1696419856;
                case 168 -> 16156252;
                case 169 -> -990334589;
                case 170 -> 1727871090;
                case 171 -> 1633707522;
                case 172 -> -567125393;
                case 173 -> 261900231;
                case 174 -> -2104767756;
                case 175 -> 151238502;
                case 176 -> -1130926239;
                case 177 -> -1412299702;
                case 178 -> 398820443;
                case 179 -> -1353067875;
                case 180 -> -1290924343;
                case 181 -> -803363145;
                case 182 -> -939959849;
                case 183 -> -1513972912;
                case 184 -> -374862839;
                case 185 -> 724423686;
                case 186 -> -1918549901;
                case 187 -> 1436465356;
                case 188 -> 893666490;
                case 189 -> 1756494658;
                case 190 -> 956130757;
                case 191 -> -732670621;
                case 192 -> 579755728;
                case 193 -> -800414644;
                case 194 -> -339620310;
                case 195 -> -1938189207;
                case 196 -> 1083669062;
                case 197 -> 572837871;
                case 198 -> -598718189;
                case 199 -> -1193277628;
                case 200 -> -170144941;
                case 201 -> -357084790;
                case 202 -> -664162809;
                case 203 -> 1747756728;
                case 204 -> 1867795636;
                case 205 -> 1831026893;
                case 206 -> 671010536;
                case 207 -> -2141454184;
                case 208 -> 930284665;
                case 209 -> 1478945494;
                case 210 -> 818588702;
                case 211 -> -380976065;
                case 212 -> 1574668858;
                case 213 -> -1096490798;
                case 214 -> 163888596;
                case 215 -> 274123746;
                case 216 -> 1737541041;
                case 217 -> 683088061;
                case 218 -> -1831903382;
                case 219 -> 1303196528;
                case 220 -> 1298928774;
                case 221 -> 257959874;
                case 222 -> 2125710971;
                case 223 -> 169760526;
                case 224 -> -616474219;
                case 225 -> 560666935;
                case 226 -> 2092825022;
                case 227 -> -1835494496;
                case 228 -> -1068068558;
                case 229 -> 1579970914;
                case 230 -> -1721713701;
                case 231 -> 1224158785;
                case 232 -> 2030894003;
                case 233 -> 1490896579;
                case 234 -> 1534223329;
                case 235 -> -656220625;
                case 236 -> 84209827;
                case 237 -> -277638178;
                case 238 -> -1022291818;
                case 239 -> -2024426268;
                case 240 -> -1411056906;
                case 241 -> -395760462;
                case 242 -> 1632480699;
                case 243 -> -466849777;
                case 244 -> 679459608;
                case 245 -> 1712649518;
                case 246 -> 1503836110;
                case 247 -> -1555333292;
                case 248 -> -1516520456;
                case 249 -> -229624010;
                case 250 -> 1765067323;
                case 251 -> 1048456187;
                case 252 -> 1952135653;
                case 253 -> 1012681005;
                case 254 -> -1993849398;
                case 255 -> 245022009;
                default -> 695303648;
            });
        } while (v2 != 888);
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
            Object[] objectArray = new Object[42];
            v1 = objectArray;
            KeystrokesHudElement = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        O0o = 600000L;
        OOi = "modules.json";
        GuiSupport_OOI = "default";
        PacketEvent = LoggerFactory.getLogger((String)"ConfigManager");
        HelpCommand = FabricLoader.getInstance().getGameDir().resolve("clap");
        OOo = HelpCommand.resolve("configs");
        HudElement = HelpCommand.resolve("modules.json");
        EventBusApi = HelpCommand.resolve("default.json");
        ConfigSupport_O0I = Pattern.compile("[A-Za-z0-9._-]+");
        O0i = new GsonBuilder().setPrettyPrinting().create();
        OoO = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm").withZone(ZoneId.systemDefault());
    }

    public boolean O0i(String param1) {
        String v2 = this.0Oi(param1);
        if ("default".equals(v2)) {
            return false;
        }
        this.Ooi();
        Path v3 = this.0Oo(v2).normalize();
        Path v4 = this.EnumType_0OI(v2).normalize();
        boolean v5 = false;
        try {
            if (Files.isRegularFile(v3, new LinkOption[0])) {
                v5 = Files.deleteIfExists(v3);
            } else if (Files.isDirectory(v4, new LinkOption[0])) {
                this.ConfigSupport_0OO(v4);
                v5 = true;
            }
            if (!v5) {
                return false;
            }
        }
        catch (IOException | RuntimeException v6) {
            PacketEvent.error("Failed to delete config '{}'", (Object)v2, (Object)v6);
            return false;
        }
        if (this.OoI.equals(v2)) {
            this.OoI = "default";
            this.OOo("default");
        }
        return true;
    }

    public void HudElement() {
        this.Ooi();
        this.ConfigSupport_OI0();
        this.OiO();
        this.ConfigSupport_00o_0();
    }

    private String 0Oi(String param1) {
        if (param1 == null || param1.isBlank()) {
            return this.OoI;
        }
        String v2 = param1.trim();
        if ("default".equalsIgnoreCase(v2)) {
            return "default";
        }
        if (!this.Kernel32SnapshotApi(v2)) {
            throw new IllegalArgumentException("Config names may only contain letters, numbers, dots, underscores and dashes");
        }
        return v2;
    }

    public void GuiSupport_OOI() {
        this.OOi(this.OoI);
    }

    private void Oi0(SettingContainer param1, Path param2) {
        try {
            if (!Files.exists(param2, new LinkOption[0])) {
                return;
            }
            String v3 = Files.readString(param2);
            param1.OIoI(JsonParser.parseString((String)v3));
        }
        catch (Throwable v3) {
            PacketEvent.error("Failed to load {}", (Object)param2, (Object)v3);
        }
    }

    private void OiI() {
        if (this.Ooo == null) {
            return;
        }
        if (!Files.exists(HudElement, new LinkOption[0]) && Files.isRegularFile(EventBusApi, new LinkOption[0])) {
            try {
                Files.copy(EventBusApi, HudElement, new CopyOption[0]);
            }
            catch (IOException v12) {
                PacketEvent.error("Failed to migrate legacy default config", (Throwable)v12);
            }
        }
        if (!Files.isDirectory(OOo, new LinkOption[0])) {
            return;
        }
        try (Stream<Path> v12 = Files.list(OOo);){
            v12.filter(param0 -> Files.isDirectory(param0, new LinkOption[0])).filter(param1 -> this.Kernel32SnapshotApi(param1.getFileName().toString())).forEach(this::Oii);
        }
        catch (IOException v12) {
            PacketEvent.error("Failed to migrate legacy configs", (Throwable)v12);
        }
    }

    public void PacketEvent(SettingContainer param1) {
        if ("modules.json".equals(param1.OIoi())) {
            this.Ooo = param1;
            return;
        }
        this.Oo0.add(param1);
    }

    private void RenderSupport_oii_4(String param1) {
        if ("default".equals(param1)) {
            this.OiO();
            return;
        }
        if (this.Ooo != null) {
            this.Oio(this.Ooo, this.0Oo(param1));
        }
    }
}

