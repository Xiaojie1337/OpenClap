/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package clap.gui;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clap.module.render.StorageEspModule;
import clap.module.player.AutoMlgModule;
import clap.module.combat.KbDelayModule;
import clap.model.EnumType_0OI;
import clap.module.hud.CoordinatesHudElement;
import clap.module.render.ItemTagsModule;
import clap.module.movement.SprintModule;
import clap.module.hud.WatermarkHudElement;
import clap.event.EventBusApi;
import clap.module.combat.AntiBotModule;
import clap.module.combat.SprintResetModule;
import clap.module.render.RotationModule;
import clap.module.render.CameraClipModule;
import clap.module.hud.KeystrokesHudElement;
import clap.module.player.AutoCollectWaterModule;
import clap.module.render.PostProcessingModule;
import clap.core.module.Module;
import clap.module.render.StructureFinderModule;
import clap.module.client.IrcModule;
import clap.module.player.ChestStealerModule;
import clap.module.render.NameTagsModule;
import clap.module.combat.LegitAuraModule;
import clap.module.movement.NoJumpDelayModule;
import clap.module.hud.FpsHudElement;
import clap.module.render.SpawnerFinderModule;
import clap.render.RenderSupport_0ooi_1;
import clap.module.render.BlockHighlightModule;
import clap.module.client.HudEditorModule;
import clap.command.argument.ArgumentType_0ooo_5;
import clap.module.render.OreEspModule;
import clap.module.combat.KeyPearlModule;
import clap.module.render.WorldTimeModule;
import clap.module.hud.PotionEffectsHudElement;
import clap.module.player.FastCraftModule;
import clap.module.combat.TriggerbotModule;
import clap.module.player.FastPlaceModule;
import clap.module.render.NoHurtCamModule;
import clap.module.client.ClientSpoofModule;
import clap.module.render.TrapDetectorModule;
import clap.module.hud.TargetHudElement;
import clap.module.combat.MiddleClickFriendModule;
import clap.module.client.StreamproofModule;
import clap.setting.SettingContainer;
import clap.module.player.GhostHandModule;
import clap.module.render.XrayModule;
import clap.module.combat.CriticalsModule;
import clap.module.render.NoDebuffModule;
import clap.config.ConfigSupport_oii0_1;
import clap.module.client.ClickGuiModule;
import clap.module.render.FullBrightModule;
import clap.module.player.WaterBucketModule;
import clap.module.hud.ModuleListHudElement;
import clap.core.module.ModuleCategory;
import clap.module.client.NotificationsModule;
import clap.module.movement.FastWebModule;
import clap.module.client.ChatTranslatorModule;
import clap.render.ScaledDrawContext;
import clap.event.Listener;
import clap.module.player.ExtinguisherModule;
import clap.module.movement.MoveFixModule;
import clap.module.movement.InventoryMoveModule;
import clap.module.combat.KillAuraModule;
import clap.module.combat.AntiKnockbackModule;
import clap.module.client.AntiResourcePackModule;
import clap.module.hud.InventoryHudElement;
import clap.module.player.AutoToolModule;
import clap.module.combat.AimAssistModule;
import clap.module.hud.RadarHudElement;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.Iii
 */
public class GuiSupport_iii_2
implements SettingContainer,
EventBusApi {
    private final Map DataRecord_00OO = new HashMap();
    private final Set 00Oo;
    private static final Logger 0Oii;
    private final List ConfigSupport_00O0 = new ArrayList();
    static Object NetworkSupport_00OI;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public String OIoi() {
        return "modules.json";
    }

    public void oooi() {
        this.oo0o().forEach(Module::oooi);
    }

    private void ooII(Module param1, int param2) {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        if (param1.IooO() == EnumType_0OI.HelpCommand) {
            if (param2 == 1) {
                param1.I0iI();
            } else if (param2 == 0) {
                param1.I0ii();
            }
            return;
        }
        if (param2 == 1) {
            param1.Oo00O();
        }
    }

    public Module ooo0(String param12) {
        return this.oo0I().filter(param1 -> param1.IoOO().equalsIgnoreCase(param12)).findFirst().orElse(null);
    }

    public void ConfigSupport_II0(RenderSupport_0ooi_1 param12) {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        this.oo0I().filter(Listener::IoOo).forEach(param1 -> param1.ConfigSupport_II0(param12));
    }

    public void oo00(Module param1) {
        this.oo0o().add(param1);
        this.DataRecord_00OO.put(param1.getClass(), param1);
    }

    public void ooio() {
        for (Module v2 : this.ConfigSupport_00O0) {
            if (!v2.IoOo()) continue;
            this.ooiO(v2);
            v2.I0ii();
        }
    }

    public List oooI() {
        return Arrays.asList(ModuleCategory.values());
    }

    public Stream oo0I() {
        return this.oo0o().stream();
    }

    public GuiSupport_iii_2() {
        this.00Oo = new HashSet();
    }

    @Override
    public JsonElement OIoo() {
        JsonObject v1 = new JsonObject();
        for (Module v3 : this.oo0o()) {
            v1.add(v3.iooi(), v3.OIoo());
        }
        return v1;
    }

    public void ooIo(int param1, int param2) {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        if (GuiSupport_iii_2.ConfigSupport_OI0.currentScreen != null) {
            return;
        }
        int v3 = -param1 - 2;
        for (Module v5 : this.ConfigSupport_00O0) {
            if (v5.Io0I().iOIo() != v3) continue;
            this.ooII(v5, param2);
        }
    }

    public List oooo(ModuleCategory param12) {
        return this.oo0I().filter(param1 -> param1.Io00() == param12).toList();
    }

    public void ooiO(Module param1) {
        if (param1 != null) {
            this.00Oo.add(param1.iooi());
        }
    }

    private void ooIi() {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        for (Module v2 : this.ConfigSupport_00O0) {
            boolean v3;
            if (v2.IooO() != EnumType_0OI.HelpCommand || v2.Io0I().iOiI()) continue;
            boolean bl = v3 = GuiSupport_iii_2.ConfigSupport_OI0.currentScreen == null && v2.Io0I().i0O0();
            if (v3 && !v2.IoOo()) {
                v2.I0iI();
                continue;
            }
            if (v3 || !v2.IoOo()) continue;
            v2.I0ii();
        }
    }

    public void ooi0() {
        if (!ConfigSupport_oii0_1.OOi() || this.00Oo.isEmpty()) {
            return;
        }
        HashSet v1 = new HashSet(this.00Oo);
        this.00Oo.clear();
        for (Module v3 : this.ConfigSupport_00O0) {
            if (!v1.contains(v3.iooi()) || v3.IoOo()) continue;
            if (!v3.I0i0()) {
                this.ooiO(v3);
                continue;
            }
            v3.I0iI();
        }
    }

    public void RotationModule() {
        this.oo00(new AimAssistModule());
        this.oo00(new AntiBotModule());
        this.oo00(new AntiKnockbackModule());
        this.oo00(new CriticalsModule());
        this.oo00(new KeyPearlModule());
        this.oo00(new KillAuraModule());
        this.oo00(new KbDelayModule());
        this.oo00(new LegitAuraModule());
        this.oo00(new SprintResetModule());
        this.oo00(new TriggerbotModule());
        this.oo00(new AntiResourcePackModule());
        this.oo00(new MiddleClickFriendModule());
        this.oo00(new StructureFinderModule());
        this.oo00(new BlockHighlightModule());
        this.oo00(new CameraClipModule());
        this.oo00(new FullBrightModule());
        this.oo00(new ItemTagsModule());
        this.oo00(new NameTagsModule());
        this.oo00(new NoDebuffModule());
        this.oo00(new NoHurtCamModule());
        this.oo00(new OreEspModule());
        this.oo00(new PostProcessingModule());
        this.oo00(new RotationModule());
        this.oo00(new SpawnerFinderModule());
        this.oo00(new StorageEspModule());
        this.oo00(new TrapDetectorModule());
        this.oo00(new WorldTimeModule());
        this.oo00(new XrayModule());
        this.oo00(new FastWebModule());
        this.oo00(new InventoryMoveModule());
        this.oo00(new MoveFixModule());
        this.oo00(new NoJumpDelayModule());
        this.oo00(new SprintModule());
        this.oo00(new AutoCollectWaterModule());
        this.oo00(new AutoMlgModule());
        this.oo00(new AutoToolModule());
        this.oo00(new ChestStealerModule());
        this.oo00(new ExtinguisherModule());
        this.oo00(new FastCraftModule());
        this.oo00(new FastPlaceModule());
        this.oo00(new GhostHandModule());
        this.oo00(new WaterBucketModule());
        this.oo00(new ClickGuiModule());
        this.oo00(new ClientSpoofModule());
        this.oo00(new HudEditorModule());
        this.oo00(new IrcModule());
        this.oo00(new NotificationsModule());
        this.oo00(new StreamproofModule());
        this.oo00(new ChatTranslatorModule());
        this.oo00(new CoordinatesHudElement());
        this.oo00(new FpsHudElement());
        this.oo00(new InventoryHudElement());
        this.oo00(new ModuleListHudElement());
        this.oo00(new PotionEffectsHudElement());
        this.oo00(new RadarHudElement());
        this.oo00(new TargetHudElement());
        this.oo00(new WatermarkHudElement());
        this.oo00(new KeystrokesHudElement());
        0Oii.info("Registered {} modules", (Object)this.ConfigSupport_00O0.size());
        for (Module v2 : this.ConfigSupport_00O0) {
            0ooo.i0o().IiI0(new ArgumentType_0ooo_5(v2));
        }
        0ooo.i0I().PacketEvent(this);
    }

    @Override
    public void OIoI(JsonElement param1) {
        for (Module v3 : this.oo0o()) {
            v3.OIoI(param1.getAsJsonObject().get(v3.iooi()));
        }
    }

    public List oo0o() {
        return this.ConfigSupport_00O0;
    }

    public Module oooO(String param12) {
        return this.oo0I().filter(param1 -> param1.iooi().equalsIgnoreCase(param12)).findFirst().orElse(null);
    }

    public Module oo0i(Class param1) {
        return (Module)this.DataRecord_00OO.get(param1);
    }

    public void ooI0(int param1, int param2) {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        if (GuiSupport_iii_2.ConfigSupport_OI0.currentScreen != null || param1 <= 0) {
            return;
        }
        for (Module v4 : this.ConfigSupport_00O0) {
            if (v4.Io0I().iOIo() != param1) continue;
            this.ooII(v4, param2);
        }
    }

    static {
        __k__gH4it = GuiSupport_iii_2.__k__gH4it((long)3675547137283714577L);
        __rP__gH4it0 = new String[]{"\ua7d0\ucb53\u15d4\u4063\uc757\u9d4e\u734a\u179d\ua64f\ucace\u1467\u41d5\uc6e2\u9c78\u7cce\u18fb\ua999\uc5f9\u1b8c\u4e3f\uc9fc\u937a\u7dc4\u197f\ua8d5\uc492\u1a42\u4f1e\uc8d9\u92a1\u7d94\u1a81\uab6d\uc792\u19c5\u4c75\ucb35\u919d\u7e04\u1b38\uaad0\uc6e1\u18c7\u4d89\uca5f\u90bf\u7f01\u1ce5\uad8c\uc1b6\u1f58\u4a4e\ucd37\u9765\u78ce\u1d08\uacdd\uc02a\u1e26\u4b92\ucc88\u9645\u791f\u1db0\uafd4\uc372\u1d4a\u480a\ucfcf\u95fa\u7acd\u1e4f\uae33\uc2ef\u1cfd\u49a3\ucec8\u9432\u7b18\u1feb\u914a\ufd8f\u2371\u7640\uf1ff\uabb4\u4438\u20ec", "\ua767\ucbc8\u15db\u4034\uc7e9\u9d4f\u727b\u16b9\ua679\ucaa2"};
        __rP__gH4it1 = new String[]{"\ua7e3\ucbf8\u15cd\u409b\uc7f5\u9d97\u72ae\u16ec", "\ua775\ucbdb\u15dd\u404e\uc71b\u9d7a\u7200"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\ua765\ucbca\u15d5\u403a\uc7eb\u9d4d\u727d\u16bf\ua67b\ucaa0", "\ua773\ucbc5\u15de\u4043\uc79b\u9d3e\u7204\u16a0\ua67f\ucad3\u14d6\u4137\uc6e5\u9c24\u732e\u17e3\ua943\uc5f9\u1bf3\u4e3b", "\ua765\ucbd7\u15cc", "\ua770\ucbfa\u15a5\u4073\uc712"};
        byte[] v0 = "\u00af\u009b\u0091\u00d7\u00d7j\u00d5\u00ca8\u000e*yzDI\u00b4\u00f6!\u00d9\u009blNK8\u00b2B\u001f\u00821\u00ad\u00e3\u00ferz`\u00e1\u00d5\u0099{O\u00c7\u0001j\u0005\u00a7\u00a3f\u008a\u0083N\u00ed\u00ca\u00c7q\u00a1o\u00da\u00da\u009b\u00ee@)H/\u00eb\u00fa\u00cf~\u000f\u009e\u0092\u00d8\u0004op\u00cf\u0010N_de\u0017\u00e4$/\u00c0wk".getBytes("ISO_8859_1");
        Object[] v1 = "\u00cenV\u00fd'\u00e5\u00e7i".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1696985446;
                case 1 -> 1142558995;
                case 2 -> 1500669117;
                case 3 -> -1486887643;
                case 4 -> 1465286307;
                case 5 -> 434922638;
                case 6 -> -1040330990;
                case 7 -> -145106874;
                case 8 -> -599565527;
                case 9 -> -1547816549;
                case 10 -> -313368648;
                case 11 -> -377137227;
                case 12 -> 359035123;
                case 13 -> 1271049438;
                case 14 -> 1906277110;
                case 15 -> -705068529;
                case 16 -> 1688379167;
                case 17 -> 860654743;
                case 18 -> -421572545;
                case 19 -> -744577092;
                case 20 -> -395676389;
                case 21 -> 1072013562;
                case 22 -> 986601184;
                case 23 -> -1970269352;
                case 24 -> 1218744972;
                case 25 -> -886486069;
                case 26 -> 1953435210;
                case 27 -> 1555814514;
                case 28 -> 1461050815;
                case 29 -> -709763839;
                case 30 -> -886398839;
                case 31 -> -2040477428;
                case 32 -> 859810673;
                case 33 -> -908710431;
                case 34 -> 128126081;
                case 35 -> 1431963955;
                case 36 -> 803087734;
                case 37 -> 1492518829;
                case 38 -> -363598919;
                case 39 -> 1361769939;
                case 40 -> 1142270051;
                case 41 -> -756466966;
                case 42 -> -1972693652;
                case 43 -> -843754558;
                case 44 -> 304349636;
                case 45 -> -1676778210;
                case 46 -> -2045599673;
                case 47 -> -1028719646;
                case 48 -> 1532269931;
                case 49 -> -2001482260;
                case 50 -> 2029652506;
                case 51 -> 831222532;
                case 52 -> 1397028365;
                case 53 -> -446311876;
                case 54 -> -2038135068;
                case 55 -> -438229232;
                case 56 -> -1921420866;
                case 57 -> -1470896598;
                case 58 -> 652130644;
                case 59 -> -392608847;
                case 60 -> -32013181;
                case 61 -> -1716127271;
                case 62 -> -1583454894;
                case 63 -> -1078702928;
                case 64 -> -1550426059;
                case 65 -> 1831458434;
                case 66 -> 1236452643;
                case 67 -> 710739229;
                case 68 -> 965991139;
                case 69 -> -1650400189;
                case 70 -> 1033153909;
                case 71 -> -962184302;
                case 72 -> -1090623274;
                case 73 -> 99365660;
                case 74 -> 1152417;
                case 75 -> 988250501;
                case 76 -> 2041258365;
                case 77 -> 1652415819;
                case 78 -> 301806626;
                case 79 -> -1820851504;
                case 80 -> 1903740167;
                case 81 -> 852761445;
                case 82 -> -272016907;
                case 83 -> 1975904451;
                case 84 -> 2072991049;
                case 85 -> 1936955624;
                case 86 -> -1615067583;
                case 87 -> 918290580;
                case 88 -> -581057533;
                case 89 -> -644099428;
                case 90 -> -1032313663;
                case 91 -> 1666095026;
                case 92 -> 887991639;
                case 93 -> 557430408;
                case 94 -> -938656866;
                case 95 -> -1440495715;
                case 96 -> -1153483779;
                case 97 -> 2034869102;
                case 98 -> 1007094274;
                case 99 -> -1814389957;
                case 100 -> -1948412781;
                case 101 -> -1675914865;
                case 102 -> -1019352338;
                case 103 -> 129486433;
                case 104 -> 1962837154;
                case 105 -> -318696013;
                case 106 -> 1656052216;
                case 107 -> 599133752;
                case 108 -> -477745049;
                case 109 -> 1695964295;
                case 110 -> 2011569989;
                case 111 -> -1939671116;
                case 112 -> -529395907;
                case 113 -> -631998345;
                case 114 -> -1264198913;
                case 115 -> -1714338904;
                case 116 -> 1203534757;
                case 117 -> -2144563608;
                case 118 -> -1145704462;
                case 119 -> -293873000;
                case 120 -> -2047048491;
                case 121 -> 2094053070;
                case 122 -> 857745722;
                case 123 -> 1249689048;
                case 124 -> 1209789604;
                case 125 -> 994617274;
                case 126 -> 1462209913;
                case 127 -> 1010168363;
                case 128 -> -910725252;
                case 129 -> 1035828557;
                case 130 -> 536352970;
                case 131 -> -2034630945;
                case 132 -> 1633399065;
                case 133 -> -1370933553;
                case 134 -> -1113031343;
                case 135 -> 1227130169;
                case 136 -> -1072462059;
                case 137 -> -1404325463;
                case 138 -> -1513283508;
                case 139 -> -1477763929;
                case 140 -> 702706875;
                case 141 -> 1376796994;
                case 142 -> 1275841642;
                case 143 -> -1388745251;
                case 144 -> -250578201;
                case 145 -> -139708556;
                case 146 -> 1209265862;
                case 147 -> 1995124791;
                case 148 -> 1423619804;
                case 149 -> 766503596;
                case 150 -> -2024317602;
                case 151 -> 2062133346;
                case 152 -> -814854536;
                case 153 -> 29952917;
                case 154 -> -467931951;
                case 155 -> -2066116396;
                case 156 -> 88717168;
                case 157 -> 571372777;
                case 158 -> 1178487167;
                case 159 -> 492944649;
                case 160 -> 863654900;
                case 161 -> 2124063496;
                case 162 -> 1082323710;
                case 163 -> -886974550;
                case 164 -> -655692283;
                case 165 -> -845442784;
                case 166 -> -405125413;
                case 167 -> 1123281561;
                case 168 -> -1151753639;
                case 169 -> 1498655318;
                case 170 -> -1530335410;
                case 171 -> 1334493234;
                case 172 -> -1999498030;
                case 173 -> 1525742993;
                case 174 -> -1166660879;
                case 175 -> 1395272740;
                case 176 -> -1930219795;
                case 177 -> -975371754;
                case 178 -> -1225410678;
                case 179 -> -1739205592;
                case 180 -> -65685681;
                case 181 -> 1316516075;
                case 182 -> 2105242244;
                case 183 -> -1289351853;
                case 184 -> -1747229062;
                case 185 -> -94626075;
                case 186 -> -377302751;
                case 187 -> 1941561485;
                case 188 -> 788818000;
                case 189 -> 275831381;
                case 190 -> 2043994048;
                case 191 -> 104352218;
                case 192 -> 534995558;
                case 193 -> -1984059301;
                case 194 -> 402349820;
                case 195 -> -180207042;
                case 196 -> 1604743217;
                case 197 -> -2115177735;
                case 198 -> 72886368;
                case 199 -> -1411760620;
                case 200 -> 187541632;
                case 201 -> -1115785275;
                case 202 -> -1929114185;
                case 203 -> -1831009136;
                case 204 -> -2037506802;
                case 205 -> 1688541230;
                case 206 -> 1577627296;
                case 207 -> -143445436;
                case 208 -> 686454856;
                case 209 -> 439145390;
                case 210 -> -1866653657;
                case 211 -> -90061713;
                case 212 -> 1094227144;
                case 213 -> -1095336464;
                case 214 -> -834317954;
                case 215 -> 26436618;
                case 216 -> 1746776413;
                case 217 -> 1868304484;
                case 218 -> -894402042;
                case 219 -> -1852084224;
                case 220 -> -108970660;
                case 221 -> -1398167508;
                case 222 -> -2093791306;
                case 223 -> 2106518795;
                case 224 -> -1072677754;
                case 225 -> 1896117207;
                case 226 -> 918414971;
                case 227 -> -1960914233;
                case 228 -> 1139392273;
                case 229 -> 1163542319;
                case 230 -> 1022888075;
                case 231 -> -1314753545;
                case 232 -> 1582240361;
                case 233 -> -578198277;
                case 234 -> 683082591;
                case 235 -> 796387162;
                case 236 -> 616071191;
                case 237 -> 1285171764;
                case 238 -> 143937485;
                case 239 -> -1962168512;
                case 240 -> -2007381303;
                case 241 -> -1595933492;
                case 242 -> -560081805;
                case 243 -> 939003055;
                case 244 -> 707774061;
                case 245 -> 1923743647;
                case 246 -> 1467098406;
                case 247 -> -893404778;
                case 248 -> -2124236520;
                case 249 -> 982505643;
                case 250 -> 1840704310;
                case 251 -> 498006438;
                case 252 -> 274684646;
                case 253 -> -941571792;
                case 254 -> -1862797011;
                case 255 -> 1923691247;
                default -> -1362975972;
            });
        } while (v2 != 88);
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            NetworkSupport_00OI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0Oii = LoggerFactory.getLogger((String)"ModuleManager");
    }

    public void ooIO() {
        List list = this.oo0o();
        Objects.requireNonNull(OIo);
        list.forEach(OIo::HelpCommand);
        this.oo0o().forEach(Module::ooIO);
    }

    public void DataRecord_OO0O(ScaledDrawContext param12) {
        if (!ConfigSupport_oii0_1.OOi()) {
            return;
        }
        this.oo0I().filter(Listener::IoOo).forEach(param1 -> param1.DataRecord_OO0O(param12));
    }

    public void SpawnerFinderModule() {
        if (!ConfigSupport_oii0_1.OOi()) {
            this.ooio();
            return;
        }
        this.ooIi();
        this.oo0I().filter(Listener::IoOo).forEach(Module::SpawnerFinderModule);
    }
}

