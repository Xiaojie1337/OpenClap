/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3i
 */
package clap.module.render;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import clap.core.module.Module;
import clap.config.ConfigSupport_0o0o_1;
import clap.setting.Setting;
import clap.config.ConfigSupport_o0o_2;
import clap.core.module.ModuleCategory;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.O0ii
 */
public class XrayModule
extends Module {
    private final Setting oI0i;
    private volatile int oIoi = 0xFFFFFF;
    private volatile boolean oIo0;
    private volatile boolean oIoo;
    private volatile boolean oIoO;
    private static final Set oI0o;
    private static final double ChestStealerModule;
    private volatile float oIoI;
    private final Setting oI0I = this.OOi0o("Opacity", 0, 0, 99).ConfigSupport_00o_0("%");
    static Object oIIO;

    @Override
    public void 0oI() {
        this.io0I(false);
        ConfigSupport_0o0o_1.HelpCommand();
        this.io0o();
    }

    public float ioOI() {
        return this.oIoI;
    }

    private void io0I(boolean param1) {
        this.oIoO = param1;
        this.oIo0 = (Boolean)this.oI0i.HelpCommand();
        int v2 = (Integer)this.oI0I.HelpCommand();
        this.oIoo = param1 && v2 > 0;
        this.oIoI = (float)v2 / 100.0f;
        this.oIoi = (int)(this.oIoI * 255.0f) << 24 | 0xFFFFFF;
    }

    public boolean ioO0(Block param1, BlockPos param2) {
        boolean v3 = oI0o.contains(param1);
        if (v3 && this.oIo0 && param2 != null) {
            return this.io00(param2);
        }
        return v3;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.io0I(true);
        ConfigSupport_0o0o_1.PacketEvent();
        ConfigSupport_0o0o_1.OOo(16.0);
        this.io0o();
    }

    public boolean ioOO(BlockState param1, BlockPos param2) {
        return this.oIoO && param1 != null && !this.ioO0(param1.method_26204(), param2);
    }

    public boolean ioOo() {
        return this.oIoo;
    }

    @EventHandler
    public void oIo(ConfigSupport_o0o_2 param1) {
        ConfigSupport_0o0o_1.OOo(16.0);
    }

    @Override
    public void oOII(Setting param1) {
        this.io0I(this.IoOo());
        if (this.IoOo()) {
            this.io0o();
        }
    }

    static {
        byte[] v0 = "I_\u0000\u00e6\u0015\u00fc\u0095b\u00b4\u00df^\u001d\u0013\u00c2[ \u00db\b?\u00fb=\u00ceb\fw&\u0006\u00f9!a0v\u009dP\u000e\u0015\u00cd\u00bc\u00c3o\u00bdG\u009a\u00ed\u00e0\u00e9JV\u00df?\u000f\u00ba\u00c5Gn\u00ddk\u00ban\u00a9lt\u001fb\u00ea\u00f2!\u0005k6\u00d4\u0090\u00be\u00ed\u00c8}\u00d2\u00872\u00c9\u00fd5\u00f9\u00cb\u000f\u0080c\u00ba\u00c9\u00ca2\u00b6\u00ab\u00d7\u001a\nYn\u00db\u00b1B\u00ed=\u0097d\u00c6sm\u00b6\u00f2\u00efo\u00d0\u00ff\u00df\u00f9\u00e9^\u00fc\u00a6\u00b3m\u008eQ\u008d\u00c2<\u008a".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f6&\u0000\u0016U%\u00c4\u0090".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -2056289448;
                case 1 -> -848345727;
                case 2 -> -1653917633;
                case 3 -> 2112536459;
                case 4 -> -93825364;
                case 5 -> 1113120033;
                case 6 -> -1940814111;
                case 7 -> -205015280;
                case 8 -> -568178510;
                case 9 -> 1351445298;
                case 10 -> 1441587411;
                case 11 -> 1862882628;
                case 12 -> 2043558692;
                case 13 -> 391630047;
                case 14 -> -833146198;
                case 15 -> 1627447534;
                case 16 -> -1416596225;
                case 17 -> -1403274161;
                case 18 -> -1341556585;
                case 19 -> -2044488259;
                case 20 -> 2045931587;
                case 21 -> 323126612;
                case 22 -> 2108363558;
                case 23 -> -1037039965;
                case 24 -> 2087430072;
                case 25 -> -1838447267;
                case 26 -> -2028315273;
                case 27 -> 1094351257;
                case 28 -> -1956310536;
                case 29 -> 134255992;
                case 30 -> 1670322094;
                case 31 -> 550528775;
                case 32 -> -1846177375;
                case 33 -> 809220384;
                case 34 -> 1371234811;
                case 35 -> -357390103;
                case 36 -> 1054062899;
                case 37 -> 2091686311;
                case 38 -> -1848093346;
                case 39 -> -22485963;
                case 40 -> -2099547149;
                case 41 -> 841065669;
                case 42 -> -1328056670;
                case 43 -> 1374180798;
                case 44 -> 5016647;
                case 45 -> 415360853;
                case 46 -> 532842467;
                case 47 -> -2085420392;
                case 48 -> -1596903170;
                case 49 -> -1927154107;
                case 50 -> 1525119497;
                case 51 -> 2138301776;
                case 52 -> -1213608241;
                case 53 -> 854553868;
                case 54 -> 1510381470;
                case 55 -> -1074807577;
                case 56 -> 1129181396;
                case 57 -> -1082911386;
                case 58 -> 1368720763;
                case 59 -> -1133942044;
                case 60 -> -727184618;
                case 61 -> 887757772;
                case 62 -> -981057488;
                case 63 -> 1125394378;
                case 64 -> 1141656460;
                case 65 -> -1263942309;
                case 66 -> 607343201;
                case 67 -> 589099042;
                case 68 -> -77016099;
                case 69 -> -1764220802;
                case 70 -> 740209852;
                case 71 -> -549984875;
                case 72 -> 741347180;
                case 73 -> 1605705911;
                case 74 -> 499135888;
                case 75 -> 2000000464;
                case 76 -> -1671168996;
                case 77 -> 774904218;
                case 78 -> -1955308176;
                case 79 -> 653222465;
                case 80 -> -885814198;
                case 81 -> 1783028653;
                case 82 -> -1587603143;
                case 83 -> 840529392;
                case 84 -> 1628013091;
                case 85 -> 1831147691;
                case 86 -> 633972539;
                case 87 -> 444330007;
                case 88 -> 855538155;
                case 89 -> 239000690;
                case 90 -> -1535108863;
                case 91 -> -2013502710;
                case 92 -> 2090199651;
                case 93 -> -117822901;
                case 94 -> 624090746;
                case 95 -> -2097438456;
                case 96 -> 1590190484;
                case 97 -> 1260986898;
                case 98 -> 707077652;
                case 99 -> -1457817764;
                case 100 -> -1629799399;
                case 101 -> -1361631654;
                case 102 -> 968432410;
                case 103 -> -1379730411;
                case 104 -> 480814011;
                case 105 -> 788593657;
                case 106 -> -554223729;
                case 107 -> -1443929466;
                case 108 -> 2097188394;
                case 109 -> -939996318;
                case 110 -> 1530805723;
                case 111 -> -1790278852;
                case 112 -> 737544232;
                case 113 -> -692811237;
                case 114 -> 2048758260;
                case 115 -> 1281335362;
                case 116 -> -1569056790;
                case 117 -> 1331047684;
                case 118 -> 1614019437;
                case 119 -> 140116465;
                case 120 -> -455615241;
                case 121 -> 539139787;
                case 122 -> 1393105328;
                case 123 -> 1530948982;
                case 124 -> -2101616667;
                case 125 -> -2078968184;
                case 126 -> 1786248032;
                case 127 -> 190557803;
                case 128 -> 665494738;
                case 129 -> -997402524;
                case 130 -> -1331315944;
                case 131 -> 1755681299;
                case 132 -> -1838616431;
                case 133 -> 359265879;
                case 134 -> 1139213187;
                case 135 -> -2097077536;
                case 136 -> -988127951;
                case 137 -> -1212669178;
                case 138 -> -1297884035;
                case 139 -> -2032927075;
                case 140 -> -2063522660;
                case 141 -> 1572174774;
                case 142 -> -1535561066;
                case 143 -> 849615078;
                case 144 -> 169102038;
                case 145 -> 892696337;
                case 146 -> 1506534074;
                case 147 -> 47986119;
                case 148 -> -1437631742;
                case 149 -> -469301659;
                case 150 -> 66670664;
                case 151 -> 1007484557;
                case 152 -> -1661839167;
                case 153 -> -628296375;
                case 154 -> 546161906;
                case 155 -> 1059553896;
                case 156 -> -853868123;
                case 157 -> 1951451044;
                case 158 -> 162080142;
                case 159 -> -1719051223;
                case 160 -> 1669467795;
                case 161 -> -1975171082;
                case 162 -> -918638026;
                case 163 -> -1954412274;
                case 164 -> -488878099;
                case 165 -> 267348915;
                case 166 -> -463147955;
                case 167 -> 2122055949;
                case 168 -> -1144452102;
                case 169 -> -1727963943;
                case 170 -> -2085173043;
                case 171 -> 1064017949;
                case 172 -> 1383696849;
                case 173 -> -782451770;
                case 174 -> -703083209;
                case 175 -> 634456147;
                case 176 -> -341239420;
                case 177 -> -215061345;
                case 178 -> 1346425529;
                case 179 -> 1790539397;
                case 180 -> -1773470211;
                case 181 -> -1624798327;
                case 182 -> 93546197;
                case 183 -> 1493151277;
                case 184 -> 1304809166;
                case 185 -> 2130464342;
                case 186 -> -1844567397;
                case 187 -> 668111141;
                case 188 -> -2081797124;
                case 189 -> 864745536;
                case 190 -> 974941501;
                case 191 -> -444338607;
                case 192 -> 1817032644;
                case 193 -> -73785026;
                case 194 -> 396391250;
                case 195 -> -99542740;
                case 196 -> -1836180619;
                case 197 -> -1891699087;
                case 198 -> 2084460858;
                case 199 -> 1241118920;
                case 200 -> -326557018;
                case 201 -> 66141914;
                case 202 -> 2078007647;
                case 203 -> -1441632276;
                case 204 -> 250898633;
                case 205 -> 1734095219;
                case 206 -> -1212669732;
                case 207 -> 524644802;
                case 208 -> -397384370;
                case 209 -> -1470593879;
                case 210 -> -1498224736;
                case 211 -> -1056957949;
                case 212 -> 1243436391;
                case 213 -> 2137863875;
                case 214 -> 1653867008;
                case 215 -> 628001285;
                case 216 -> 348898450;
                case 217 -> 1207561087;
                case 218 -> 1620998510;
                case 219 -> 454787128;
                case 220 -> 1985518551;
                case 221 -> 705100156;
                case 222 -> -574854842;
                case 223 -> 1730075375;
                case 224 -> -534847111;
                case 225 -> -270242594;
                case 226 -> 1616128043;
                case 227 -> 152466462;
                case 228 -> 342326634;
                case 229 -> 1535286703;
                case 230 -> -1147154553;
                case 231 -> -1712841758;
                case 232 -> -2115913035;
                case 233 -> -1962658711;
                case 234 -> -160672894;
                case 235 -> 520260584;
                case 236 -> -2001383116;
                case 237 -> -743270823;
                case 238 -> 1505084405;
                case 239 -> -1128356992;
                case 240 -> -729203697;
                case 241 -> -1686425297;
                case 242 -> 2129293067;
                case 243 -> 518081418;
                case 244 -> -1360487308;
                case 245 -> -458418241;
                case 246 -> 1106701855;
                case 247 -> -112083666;
                case 248 -> -1339988824;
                case 249 -> 185852527;
                case 250 -> 215570865;
                case 251 -> 1679762727;
                case 252 -> 139375796;
                case 253 -> 1174786008;
                case 254 -> -1717947456;
                case 255 -> -131347892;
                default -> 1761275058;
            });
        } while (v2 != 128);
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
            oIIO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        ChestStealerModule = 16.0;
        oI0o = Set.of(Blocks.AMETHYST_CLUSTER, Blocks.ANCIENT_DEBRIS, Blocks.BEACON, Blocks.BONE_BLOCK, Blocks.BOOKSHELF, Blocks.BREWING_STAND, Blocks.BUDDING_AMETHYST, Blocks.CHEST, Blocks.COAL_BLOCK, Blocks.COAL_ORE, Blocks.COMMAND_BLOCK, Blocks.COPPER_ORE, Blocks.CRAFTING_TABLE, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DISPENSER, Blocks.DROPPER, Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE, Blocks.ENCHANTING_TABLE, Blocks.END_PORTAL, Blocks.END_PORTAL_FRAME, Blocks.ENDER_CHEST, Blocks.FURNACE, Blocks.GLOWSTONE, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.HOPPER, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LADDER, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LAVA, Blocks.LODESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_PORTAL, Blocks.NETHER_QUARTZ_ORE, Blocks.RAW_COPPER_BLOCK, Blocks.RAW_GOLD_BLOCK, Blocks.RAW_IRON_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_ORE, Blocks.REPEATING_COMMAND_BLOCK, Blocks.SCULK_CATALYST, Blocks.SCULK_SENSOR, Blocks.SCULK_SHRIEKER, Blocks.SPAWNER, Blocks.SUSPICIOUS_GRAVEL, Blocks.SUSPICIOUS_SAND, Blocks.TNT, Blocks.TORCH, Blocks.TRAPPED_CHEST, Blocks.TRIAL_SPAWNER, Blocks.VAULT, Blocks.WALL_TORCH, Blocks.WATER);
    }

    public Boolean i0ii(BlockState param1, BlockPos param2) {
        if (!this.oIoO || param1 == null) {
            return null;
        }
        boolean v3 = this.ioO0(param1.method_26204(), param2);
        if (!v3 && this.oIoo) {
            return null;
        }
        return v3;
    }

    private void io0o() {
        if (XrayModule.ConfigSupport_OI0.worldRenderer != null) {
            XrayModule.ConfigSupport_OI0.worldRenderer.reload();
        }
    }

    public int ioOi() {
        return this.oIoi;
    }

    public XrayModule() {
        super("Xray", "Makes selected valuable blocks visible through terrain.", ModuleCategory.ioO);
        this.oI0i = this.OOi00("OnlyExposed", false);
        this.io0I(false);
    }

    private boolean io00(BlockPos param1) {
        if (XrayModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        BlockPos.Mutable v2 = new BlockPos.Mutable();
        for (Direction v6 : Direction.values()) {
            BlockState v7 = XrayModule.ConfigSupport_OI0.world.method_8320((BlockPos)v2.set((Vec3i)param1, v6));
            if (v7.method_26216()) continue;
            return true;
        }
        return false;
    }

    public static XrayModule io0O() {
        return 0ooo.Ooio() == null ? null : (XrayModule)0ooo.OoiI().oo0i(XrayModule.class);
    }
}

