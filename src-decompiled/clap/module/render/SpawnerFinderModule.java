/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.FenceBlock
 *  net.minecraft.block.SlabBlock
 *  net.minecraft.block.StairsBlock
 *  net.minecraft.block.WallBlock
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 *  org.joml.Matrix3x2fStack
 *  org.joml.Vector3f
 */
package clap.module.render;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.joml.Matrix3x2fStack;
import org.joml.Vector3f;
import clap.network.NetworkSupport_00OI;
import clap.render.FontRenderer;
import clap.core.module.Module;
import clap.render.RenderSupport_0ooi_1;
import clap.setting.Setting;
import clap.config.ConfigSupport_o0io_0;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.render.RenderSupport_oiio_4;
import clap.core.module.ModuleCategory;
import clap.render.ScaledDrawContext;
import clap.render.RenderSupport_ooio_6;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.0oO
 */
public class SpawnerFinderModule
extends Module {
    private final Setting ioo;
    private static final int i0o;
    private static final int WorldTimeModule;
    private static final int i0i;
    private final Setting io0;
    private static final float oi0;
    private final Setting ioO = this.OOi0o("Range", 80, 16, 256);
    private final Setting ioi;
    private final Setting NoHurtCamModule;
    private volatile Thread iIi;
    private RegistryKey iIo;
    private static final int i0I;
    private long PotionEffectsHudElement;
    private final Map iIO;
    private final Set iI0;
    private volatile boolean iiO;
    private static final int iOi;
    private static final int i00;
    static Object EnumType_ii0_2;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private static boolean OOiO(Block param0) {
        return param0 == Blocks.STONE || param0 == Blocks.DEEPSLATE || param0 == Blocks.COBBLESTONE;
    }

    private boolean Manager(int param1, int param2, int param3, int param4, int param5, int param6, float param7, World param8) {
        int v9 = 0;
        int v10 = 0;
        BlockPos.Mutable v11 = new BlockPos.Mutable();
        for (int v12 = param1 - 1; v12 <= param4 + 1; ++v12) {
            for (int v13 = param3 - 1; v13 <= param6 + 1; ++v13) {
                if (v12 > param1 && v12 < param4 && v13 > param3 && v13 < param6) continue;
                for (int v14 = param2; v14 <= param5; ++v14) {
                    v11.set(v12, v14, v13);
                    ++v10;
                    BlockState v15 = param8.method_8320((BlockPos)v11);
                    if (v15.method_26215() || !v15.method_26227().isEmpty()) continue;
                    ++v9;
                }
            }
        }
        return v10 > 0 && (float)v9 / (float)v10 >= param7;
    }

    private boolean i0i() {
        if (SpawnerFinderModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        RegistryKey v1 = SpawnerFinderModule.ConfigSupport_OI0.world.method_27983();
        if (this.iIo == null) {
            this.iIo = v1;
            return false;
        }
        if (!this.iIo.equals(v1)) {
            this.iIo = v1;
            return true;
        }
        return false;
    }

    @Override
    public void 0oI() {
        this.FontRenderer();
        this.SettingContainer();
    }

    private double OOIi(BlockPos param1) {
        double v2 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23317() - ((double)param1.method_10263() + 0.5);
        double v4 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23318() - ((double)param1.method_10264() + 0.5);
        double v6 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23321() - ((double)param1.method_10260() + 0.5);
        return v2 * v2 + v4 * v4 + v6 * v6;
    }

    private boolean OOoi(int param1, int param2, int param3, int param4, int param5, int param6, World param7) {
        BlockPos.Mutable v8 = new BlockPos.Mutable();
        for (int v9 = param1; v9 <= param4; ++v9) {
            for (int v10 = param2; v10 <= param5; ++v10) {
                for (int v11 = param3; v11 <= param6; ++v11) {
                    v8.set(v9, v10, v11);
                    if (!SpawnerFinderModule.OOi0(param7.method_8320((BlockPos)v8).method_26204())) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.SettingContainer();
        this.PotionEffectsHudElement = System.currentTimeMillis();
        this.OO0o();
    }

    private void OOoO(Map param1, World param2) {
        Block v11;
        int v3 = (Integer)this.ioO.HelpCommand();
        BlockPos v4 = SpawnerFinderModule.ConfigSupport_OI0.player.method_24515();
        BlockPos.Mutable v5 = new BlockPos.Mutable();
        ArrayList<BlockPos> v6 = new ArrayList<BlockPos>();
        for (int v7 = -v3; v7 <= v3; ++v7) {
            if (Thread.currentThread().isInterrupted() || !this.iiO) {
                return;
            }
            for (int v8 = -v3; v8 <= v3; ++v8) {
                WorldChunk v9;
                if (v7 * v7 + v8 * v8 > v3 * v3 || (v9 = param2.method_8398().getWorldChunk(v4.method_10263() + v7 >> 4, v4.method_10260() + v8 >> 4, false)) == null) continue;
                for (int v10 = -100; v10 <= 100; ++v10) {
                    v5.set(v4.method_10263() + v7, v4.method_10264() + v10, v4.method_10260() + v8);
                    if (v5.method_10264() < param2.method_31607() || v5.method_10264() >= param2.method_31600() || v5.method_10264() > 120 || (v11 = v9.method_8320((BlockPos)v5).method_26204()) != Blocks.COBBLESTONE && v11 != Blocks.MOSSY_COBBLESTONE) continue;
                    v6.add(v5.method_10062());
                }
            }
        }
        if (v6.isEmpty()) {
            return;
        }
        HashSet v7 = new HashSet();
        BlockPos.Mutable v8 = new BlockPos.Mutable();
        for (BlockPos v10 : v6) {
            int v212;
            int v20;
            int v19;
            int v182;
            int v16;
            Object v13;
            if (Thread.currentThread().isInterrupted() || !this.iiO) {
                return;
            }
            if (v7.contains(v10)) continue;
            v11 = new HashSet();
            ArrayDeque<BlockPos> v12 = new ArrayDeque<BlockPos>();
            v11.add(v10);
            v12.add(v10);
            while (!v12.isEmpty() && v11.size() <= 200) {
                v13 = (BlockPos)v12.poll();
                BlockPos[] v14 = new BlockPos[]{v13.up(), v13.down(), v13.north(), v13.south(), v13.east(), v13.west()};
                for (v16 = 0; v16 < 6; ++v16) {
                    Block v182;
                    BlockPos v17 = v14[v16];
                    if (v11.contains(v17) || (v182 = param2.method_8320(v17).method_26204()) != Blocks.COBBLESTONE && v182 != Blocks.MOSSY_COBBLESTONE) continue;
                    v11.add(v17);
                    v12.add(v17);
                }
            }
            v7.addAll(v11);
            if (v11.size() < 15) continue;
            v13 = this.EventHandler((Set)v11, (Set)v11, Set.of());
            int v14 = v13.GuiSupport_OOI - v13.PacketEvent + 1;
            int v15 = v13.OOi - v13.HelpCommand + 1;
            v16 = v13.HudElement - v13.OOo + 1;
            if (v14 < 5 || v14 > 13 || v16 < 5 || v16 > 13 || v15 < 3 || v15 > 7 || v14 * v15 * v16 > 800 || this.OOoi(v13.PacketEvent, v13.HelpCommand, v13.OOo, v13.GuiSupport_OOI, v13.OOi, v13.HudElement, param2) || !this.Manager(v13.PacketEvent, v13.HelpCommand, v13.OOo, v13.GuiSupport_OOI, v13.OOi, v13.HudElement, 0.5f, param2)) continue;
            boolean v17 = false;
            for (v182 = v13.PacketEvent; v182 <= v13.GuiSupport_OOI && !v17; ++v182) {
                block7: for (v19 = v13.OOo; v19 <= v13.HudElement && !v17; ++v19) {
                    for (v20 = v13.HelpCommand; v20 <= v13.OOi; ++v20) {
                        v8.set(v182, v20, v19);
                        Block v212 = param2.method_8320((BlockPos)v8).method_26204();
                        if (v212 != Blocks.SPAWNER && v212 != Blocks.CHEST && v212 != Blocks.MOSSY_COBBLESTONE) continue;
                        v17 = true;
                        continue block7;
                    }
                }
            }
            if (v17 || this.DataRecord_OOI0(v182 = (v13.PacketEvent + v13.GuiSupport_OOI) / 2, v13.OOi + 1, v19 = (v13.OOo + v13.HudElement) / 2, param2)) continue;
            v20 = 1;
            for (v212 = v13.PacketEvent + 1; v212 < v13.GuiSupport_OOI && v20 != 0; ++v212) {
                block10: for (int v22 = v13.OOo + 1; v22 < v13.HudElement && v20 != 0; ++v22) {
                    for (int v23 = v13.HelpCommand + 1; v23 < v13.OOi; ++v23) {
                        v8.set(v212, v23, v22);
                        BlockState v24 = param2.method_8320((BlockPos)v8);
                        if (v24.method_26215() || SpawnerFinderModule.OOiO(v24.method_26204()) || !v24.method_26227().isEmpty()) continue;
                        v20 = 0;
                        continue block10;
                    }
                }
            }
            if (v20 == 0 || (v212 = this.OOIo(v13.PacketEvent, v13.HelpCommand, v13.OOo, v13.GuiSupport_OOI, v13.OOi, v13.HudElement, (Set)v11, param2)) < 1) continue;
            RenderSupport_ooio_6 v22 = new RenderSupport_ooio_6(new Box((double)v13.PacketEvent, (double)v13.HelpCommand, (double)v13.OOo, (double)v13.GuiSupport_OOI + 1.0, (double)v13.OOi + 1.0, (double)v13.HudElement + 1.0), new BlockPos(v182, (v13.HelpCommand + v13.OOi) / 2, v19), v11.size(), 0, false, false, v212, true);
            if (param1.containsKey(v22.HelpCommand) || !(v22.OOi >= 0.3f)) continue;
            param1.put(v22.HelpCommand, v22);
        }
    }

    @Override
    public void SpawnerFinderModule() {
        if (SpawnerFinderModule.iooI()) {
            this.OOoI();
            return;
        }
        if (this.i0i()) {
            this.iIO.clear();
            this.iI0.clear();
            this.PotionEffectsHudElement = System.currentTimeMillis();
            this.OO0o();
            return;
        }
        this.OOoo();
        long v1 = System.currentTimeMillis();
        if (!this.iiO && v1 - this.PotionEffectsHudElement >= (long)((Integer)this.io0.HelpCommand()).intValue() * 1000L) {
            this.PotionEffectsHudElement = v1;
            this.OO0o();
        }
    }

    @Override
    public void DataRecord_OO0O(ScaledDrawContext param1) {
        if (SpawnerFinderModule.iooI() || this.iIO.isEmpty()) {
            return;
        }
        float v2 = ((Double)this.NoHurtCamModule.HelpCommand()).floatValue() * 0.5f;
        FontRenderer v3 = NetworkSupport_00OI.HudElement(18);
        int v4 = Math.max(1, v3.OOi());
        boolean v5 = this.NetworkSupport_OO00();
        for (RenderSupport_ooio_6 v7 : this.iIO.values()) {
            Vec3d v10;
            Vector3f v11;
            double v8;
            if (v7.O0i || (v8 = Math.sqrt(this.OOIi(v7.HelpCommand))) > (double)((Integer)this.ioO.HelpCommand()).intValue() || (v11 = RenderSupport_oiio_4.O0OII(v10 = new Vec3d((double)v7.HelpCommand.method_10263() + 0.5, v7.PacketEvent.maxY + 0.2, (double)v7.HelpCommand.method_10260() + 0.5))) == null) continue;
            String v12 = v5 ? (v7.ConfigSupport_O0I ? "\u5237\u602a\u7b3c?" : "\u5237\u602a\u7b3c") : (v7.ConfigSupport_O0I ? "Spawner?" : "Spawner");
            String v13 = String.format(" [%.0fm]", v8);
            int v14 = v3.GuiSupport_OOI(v12);
            int v15 = v3.GuiSupport_OOI(v13);
            float v16 = v14 + v15;
            float v17 = v16 * v2;
            float v18 = (float)v4 * v2;
            if (ClickGuiScreen.EventBusApi(v11.x - v17 / 2.0f, v11.y - v18 / 2.0f, v17, v18)) continue;
            Matrix3x2fStack v19 = param1.ConfigSupport_O0I().getMatrices();
            v19.pushMatrix();
            v19.translate(v11.x, v11.y);
            v19.scale(v2, v2);
            float v20 = -v16 / 2.0f;
            float v21 = (float)(-v4) / 2.0f;
            v3.PacketEvent(param1.ConfigSupport_O0I(), v12, v20, v21, v7.HelpCommand().getRGB());
            v3.PacketEvent(param1.ConfigSupport_O0I(), v13, v20 + (float)v14, v21, -1);
            v19.popMatrix();
        }
    }

    private boolean NetworkSupport_OO00() {
        if (ConfigSupport_OI0.getLanguageManager() == null) {
            return false;
        }
        String v1 = ConfigSupport_OI0.getLanguageManager().getLanguage();
        return v1 != null && v1.toLowerCase().startsWith("zh");
    }

    private boolean GuiSupport_OOII(Set param1, int param2, int param3, int param4, int param5, int param6, int param7) {
        for (BlockPos v9 : param1) {
            if (v9.method_10263() < param2 || v9.method_10263() > param5 || v9.method_10264() < param3 || v9.method_10264() > param6 || v9.method_10260() < param4 || v9.method_10260() > param7) continue;
            return true;
        }
        return false;
    }

    private void OO0o() {
        this.FontRenderer();
        if (SpawnerFinderModule.iooI()) {
            return;
        }
        this.iiO = true;
        this.iIi = new Thread(() -> {
            try {
                ClientWorld v1 = SpawnerFinderModule.ConfigSupport_OI0.world;
                if (v1 == null || SpawnerFinderModule.ConfigSupport_OI0.player == null) {
                    return;
                }
                RegistryKey v2 = v1.getRegistryKey();
                HashMap v3 = new HashMap();
                this.OO0i(v3, (World)v1);
                if (Thread.currentThread().isInterrupted() || !this.iiO) {
                    return;
                }
                this.OOoO(v3, (World)v1);
                if (!Thread.currentThread().isInterrupted() && this.iiO && SpawnerFinderModule.ConfigSupport_OI0.world == v1 && SpawnerFinderModule.ConfigSupport_OI0.world.method_27983() == v2) {
                    for (Map.Entry v5 : v3.entrySet()) {
                        if (!this.iI0.contains(v5.getKey())) continue;
                        ((RenderSupport_ooio_6)v5.getValue()).O0i = true;
                    }
                    this.iIO.clear();
                    this.iIO.putAll(v3);
                }
                return;
            }
            finally {
                this.iiO = false;
            }
        }, "SpawnerFinder-Scanner");
        this.iIi.setDaemon(true);
        this.iIi.start();
    }

    private void FontRenderer() {
        this.iiO = false;
        if (this.iIi != null && this.iIi.isAlive()) {
            this.iIi.interrupt();
        }
        this.iIi = null;
    }

    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        if (SpawnerFinderModule.iooI() || this.iIO.isEmpty()) {
            return;
        }
        MatrixStack v2 = param1.0ii();
        double v3 = (double)((Integer)this.ioO.HelpCommand()).intValue() * (double)((Integer)this.ioO.HelpCommand()).intValue();
        for (RenderSupport_ooio_6 v6 : this.iIO.values()) {
            if (v6.O0i || this.OOIi(v6.HelpCommand) > v3) continue;
            Color v7 = this.IoI(v6.HelpCommand(), (Integer)this.ioi.HelpCommand());
            GuiSupport_oi0o_0.OOIII(v2, v6.PacketEvent, v7, 5.0f);
        }
    }

    private Color IoI(Color param1, int param2) {
        return new Color(param1.getRed(), param1.getGreen(), param1.getBlue(), Math.max(0, Math.min(255, param2)));
    }

    public SpawnerFinderModule() {
        super("SpawnerFinder", "Finds likely dungeon spawners from world structure.", ModuleCategory.ioO);
        this.io0 = this.OOi0o("ScanDelay", 5, 1, 15).ConfigSupport_00o_0("s");
        this.ioo = this.OOi0o("ExploredDist", 10, 3, 30).ConfigSupport_00o_0("block");
        this.NoHurtCamModule = this.OOi0o("TagScale", 1.0, 0.5, 3.0);
        this.ioi = this.OOi0o("Alpha", 215, 40, 255);
        this.iIO = new ConcurrentHashMap();
        this.iI0 = ConcurrentHashMap.newKeySet();
    }

    static {
        __k__gH4it = SpawnerFinderModule.__k__gH4it(1284588729645657617L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\u3f30\u1613\uc8f9\u9aac\u1dc1\u4513\u70c1\ucc26", "\u3f79\u1672\uc866\u9a4f\u1d5c\u45b8\u70cc\ucc0a\u3877\u1108", "\u3f6d\u167f\uc863\u9a20\u1d3e\u45d9\u70a3\ucc1b\u3871\u1179\ucf7b\u9b54\u1c40\u44c3\u7189\ucd58\u397d\u1023\uce6e\u9b98", "\u3f6b\u1661\uc860\u9a35\u1d5e\u45bd\u70c7"};
        __rP__gH4it2 = new String[]{"\u3ff9\u16bb\uc83a\u9db3\u1a30\u4216\u70de\ucc45\u3807\u11a4\ucfdd\u9aff\u1dd0\u4521\u7196\ucdf9\u39ca\u1014\ucec4\u9b67\u1c11\u44ea\u7161\uced0\u3ac8\u136b\ucde0\u98ba\u1f17\u47ef\u727d\ucf53\u3b8b\u1246\ucc58\u99bf\u1e01\u46ef\u731b\ud037\u2497\u0df5\ud3ee\u8612\u01bb\u5901\u6c0f\ud149\u2591\u0cbc\ud288\u876d\u00f7\u5886\u6d8e\ud10c\u26b1\u0f9e\ud1f1\u84d4\u036e\u5b33\u6e99\ud29c\u27ee\u0eb5\ud0a4\u8510\u0291\u5ae0\u6f9f\ud3f4\u206b\u09ef\ud7bd\u8299\u05a0\u5dbc\u68bc\ud422\u2042\u0897\ud62d\u831a\u04d2\u5cb6\u6915\ud54e\u21c8\u0b59\ud5a5\u8040\u0755\u5f78\u6ab3\ud626\u22e3\u0a0e\ud4da\u81d3\u06c1\u5e9b\u6b00\ud703\u23b3\u0549\udb58\u8e53\u091d\u51c5\u6474\ud8c5\u2c4f\u05ab\uda7e\u8f29\u080e\u501b\u65bd\ud9a4\u2d49\u0464\ud940\u8cfe\u0ba3\u53cd\u6652\uda3f\u2e74\u07df\ud832\u8deb\u0af1\u52f7\u67d1\udb96\u2ffa\u062b\udfa9\u8a34\u0da3\u55fd\u60f8\udc5e\u28f6\u0169\udff0\u8be1\u0c20\u5449\u61be\udd90\u291e\n\ude65\u8813\u0fe1\u5777\u62a0\ude6b\u2a81\u03d8\uddf6\u8938\u0ec3\u5689\u6311\udf17\u2b7a\u0229\udc50\ub603\u3157\u69a5\u5cc8\ue0b4\u14d5\u3d68\ue37f\ub663\u304e\u689e\u5d83\ue1d3\u1530\u3ccc\ue27d\ub778\u3343\u6b2f\u5e55\ue2cf\u1661\u3f2a\ue197\ub477\u32fb\u6ac8\u5f12\ue302\u1770\u3ec1\ue00e\ub531\u3519\u6de3\u58a1\ue47a\u10d9\u393d\ue785\ub2d8\u3542\u6c8f\u59db\ue5c1\u11f8\u38b5\ue692\ub3b9\u3485\u6f86\u5a47\ue629\u125f\u3bc8\ue537\ub0b8\u3735\u6e9e\u5b04\ue724\u1396\u3a0b\ue4b8\ub1ee\u36b4\u61b9\u54c9\ue895", "\u3f6e\u167c\uc860\u9a34\u1d57"};
        __rP__gH4it3 = new String[]{"\u3f7b\u1674\uc860\u9a4d\u1d5e\u45a6\u70d2\ucc08\u3875\u110e", "\u3f7b\u1669\uc879"};
        __p__gH4it = new String[]{"\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a", "\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694\ue6b9", "\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260", "\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3", "\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9", "\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3", "\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142", "\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5", "\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c", "\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b\ue590\ue5b5", "\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c", "\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b", "\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073", "\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0", "\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157", "\uea60\uea85\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b", "\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e", "\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411", "\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024", "\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323", "\uedc9\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85", "\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72", "\uf56f\uf594\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750\uf775\uf79a\uf7bf", "\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5", "\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d", "\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976", "\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec", "\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb", "\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7", "\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f", "\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18", "\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb", "\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577", "\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e", "\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0", "\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853", "\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", "\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d", "\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380", "\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80", "\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2", "\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba", "\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c", "\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87", "\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7", "\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a", "\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9", "\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6", "\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238", "\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27", "\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184", "\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517", "\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065", "\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474", "\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6", "\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69\uec8e\uecb3\uecd8", "\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db", "\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3", "\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8", "\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7", "\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab", "\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75", "\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a", "\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62", "\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d", "\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290", "\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8", "\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f", "\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01", "\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f", "\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf", "\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074", "\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08", "\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064", "\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c", "\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7", "\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb", "\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c", "\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28", "\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a", "\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a", "\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98", "\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0", "\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf", "\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259", "\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2", "\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24", "\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510", "\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d", "\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c\ue491", "\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e\ue873", "\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf", "\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b", "\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f", "\uee77\uee9c\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9", "\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d"};
        __c__J7Um6 = new Object[][]{{"\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99", 1467126035345773846L, "\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4", 1329502282, "\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788", true, "\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3", true, "\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec", true, "\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507\uf52c", true}, {"\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1", 1467126035345839383L, "\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190", 22634221, "\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167", false, "\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b", false, "\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59", false, "\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6", false}, {"\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98", 1467126035345904920L, "\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c", -739175164, "\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7", true, "\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0", true, "\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010", true, "\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031", true}, {"\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74", 1467126035345970457L, "\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b", -1542861889, "\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f", false, "\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d", false, "\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca", false, "\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079", false}, {"\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50", 1467126035346035994L, "\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb", 1990296278, "\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4", true, "\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4", true, "\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315", true, "\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b\ue130", true}, {"\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f", 1467126035346101531L, "\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603", -952600311, "\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521", false, "\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89\uecae", false, "\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d", false, "\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c", false}, {"\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f", 1467126035346167068L, "\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798", -1722794080, "\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8", true, "\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9", true, "\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef\uf414", true, "\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435", true}, {"\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7", 1467126035346232605L, "\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005", 1810429659, "\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d\ue792", false, "\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41", false, "\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0", false, "\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d", false}, {"\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f\uf154\uf179\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c", 1467126035346298142L, "\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc", 1006677362, "\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd", true, "\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8", true, "\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719", true, "\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534", true}, {"\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9", 1467126035346363679L, "\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251\ue276", -1902419051, "\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925", false, "\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4", false, "\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761", false, "\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610", false}, {"\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0", 1467126035346429216L, "\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1", 1597201100, "\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc", true, "\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd", true, "\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018", true, "\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec", true}, {"\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a", 1467126035346494753L, "\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409", 290132327, "\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8", false, "\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245", false, "\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4", false, "\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb", false}, {"\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5", 1467126035346560290L, "\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0", -471607394, "\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1", true, "\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc", true, "\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0", true, "\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b", true}, {"\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed", 1467126035346625827L, "\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c", -1266971087, "\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29", false, "\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8", false, "\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af", false, "\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83", false}, {"\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4", 1467126035346691364L, "\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5", 110249320, "\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0", true, "\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4", true, "\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f", true, "\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18", true}, {"\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080", 1467126035346756901L, "\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d", -685098109, "\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc", false, "\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693", false, "\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567", false, "\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85", false}, {"\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9", 1467126035346822438L, "\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4", -1455230406, "\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98", true, "\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003", true, "\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc", true, "\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c", true}, {"\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1", 1467126035346887975L, "\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0", 2077927773, "\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177", false, "\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001\ue026\ue04b", false, "\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769", false, "\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6", false}, {"\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8", 1467126035346953512L, "\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c", -864718860, "\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7", true, "\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0", true, "\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820", true, "\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041", true}, {"\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484", 1467126035347019049L, "\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b", -1634916817, "\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f", false, "\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d", false, "\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da", false, "\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089", false}, {"\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560", 1467126035347084586L, "\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb", 1864703302, "\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a\uf49f\uf4c4", true, "\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304", true, "\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25", true, "\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140", true}, {"\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f", 1467126035347150123L, "\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13", 566088697, "\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531", false, "\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be", false, "\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d", false, "\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c", false}, {"\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a\ue8af", 1467126035347215660L, "\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e\uef83\uefa8", -204109296, "\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8", true, "\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609", true, "\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24", true, "\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445", true}, {"\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7", 1467126035347281197L, "\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0\uf015", 1147945291, "\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2", false, "\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651", false, "\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00", false, "\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d", false}, {"\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c", 1467126035347346734L, "\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc", 377751522, "\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed", true, "\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708", true, "\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29", true, "\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544", true}, {"\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9", 1467126035347412271L, "\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286", -417530363, "\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135", false, "\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4", false, "\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71", false, "\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620", false}, {"\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0", 1467126035347477808L, "\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1", -1179339588, "\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec", true, "\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d", true, "\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028", true, "\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc", true}, {"\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45\ued6a", 1467126035347543345L, "\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419", 198142935, "\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8", false, "\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55", false, "\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104", false, "\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db", false}, {"\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5", 1467126035347608882L, "\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0", -597220850, "\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1", true, "\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c", true, "\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0", true, "\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b", true}, {"\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd", 1467126035347674419L, "\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac", -1359013727, "\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539", false, "\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8", false, "\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf", false, "\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224\ue249\ue26e\ue293", false}, {"\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4", 1467126035347739956L, "\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5", 2132271064, "\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0", true, "\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4", true, "\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f", true, "\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428", true}, {"\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090", 1467126035347805493L, "\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d", 833590899, "\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc", false, "\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3", false, "\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577", false, "\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495", false}, {"\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f\uf294\uf2b9", 1467126035347871030L, "\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4", -2084156246, "\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8", true, "\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013", true, "\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c", true, "\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c", true}, {"\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7\uf2dc\uf301", 1467126035347936567L, "\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0", 1415447501, "\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987", false, "\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b", false, "\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779", false, "\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706", false}, {"\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8", 1467126035348002104L, "\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c", 653720164, "\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7", true, "\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0", true, "\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030", true, "\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851", true}, {"\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494", 1467126035348067641L, "\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b", -150032225, "\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f", false, "\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d", false, "\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea", false, "\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899", false}, {"\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570", 1467126035348133178L, "\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db", 1235842870, "\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4", true, "\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314", true, "\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335", true, "\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950", true}, {"\uf56e\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f", 1467126035348198715L, "\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623", 465645161, "\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41", false, "\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce", false, "\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d", false, "\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c", false}, {"\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf", 1467126035348264252L, "\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e\ue793\ue7b8", -329653120, "\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8", true, "\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619", true, "\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434", true, "\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55", true}, {"\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107", 1467126035348329789L, "\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825", -1091445957, "\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2", false, "\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661", false, "\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510", false, "\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d", false}, {"\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277\ue29c", 1467126035348395326L, "\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc", 252285522, "\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd", true, "\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718", true, "\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739", true, "\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54", true}, {"\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4\ue309", 1467126035348460863L, "\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96", -1046460171, "\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145", false, "\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4", false, "\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781", false, "\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30", false}, {"\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0", 1467126035348526400L, "\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1", -1841819860, "\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc", true, "\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d", true, "\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838", true, "\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c", true}, {"\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a", 1467126035348591937L, "\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29", 1683015239, "\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8", false, "\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265", false, "\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914", false, "\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb", false}, {"\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5", 1467126035348657474L, "\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0", 921222398, "\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501", true, "\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c", true, "\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0", true, "\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b", true}, {"\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d", 1467126035348723011L, "\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc", -2029817071, "\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549", false, "\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8", false, "\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf", false, "\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3", false}, {"\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4", 1467126035348788548L, "\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5", 1503341128, "\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600", true, "\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4", true, "\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f", true, "\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438", true}, {"\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0", 1467126035348854085L, "\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d", 708042979, "\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc", false, "\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3", false, "\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87", false, "\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5", false}, {"\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9", 1467126035348919622L, "\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4", -62150886, "\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8", true, "\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823", true, "\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c", true, "\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c", true}, {"\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11", 1467126035348985159L, "\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0", 1323539901, "\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197", false, "\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b", false, "\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89", false, "\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716", false}, {"\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8", 1467126035349050696L, "\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c", 528110804, "\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307", true, "\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00", true, "\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040", true, "\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061", true}, {"\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4", 1467126035349116233L, "\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b", -778958065, "\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f", false, "\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d", false, "\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa", false, "\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9", false}, {"\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80", 1467126035349181770L, "\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb", -1574256218, "\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4", true, "\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24", true, "\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345", true, "\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160", true}, {"\ued7e\ueda3\uedc8\ueded\uee12\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f", 1467126035349247307L, "\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633", 1950529753, "\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551", false, "\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde", false, "\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d", false, "\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c", false}, {"\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf", 1467126035349312844L, "\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8", -958562448, "\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608", true, "\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29", true, "\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444", true, "\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465", true}, {"\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117", 1467126035349378381L, "\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035", -1753926229, "\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2", false, "\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71", false, "\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520", false, "\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad", false}, {"\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287\uf2ac", 1467126035349443918L, "\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec", 1770908866, "\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d", true, "\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28", true, "\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749", true, "\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564", true}, {"\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319", 1467126035349509455L, "\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6", 975545189, "\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955", false, "\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004", false, "\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791", false, "\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640", false}, {"\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0", 1467126035349574992L, "\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1", -1933731428, "\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c", true, "\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208\uf22d", true, "\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048", true, "\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c", true}, {"\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a", 1467126035349640529L, "\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439", 1590972471, "\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8", false, "\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275", false, "\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124", false, "\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb", false}, {"\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5", 1467126035349706066L, "\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0", 795613038, "\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11", true, "\uf1df\uf204\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c", true, "\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200", true, "\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b", true}, {"\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d", 1467126035349771603L, "\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc", -511390335, "\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59", false, "\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408", false, "\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df", false, "\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3", false}, {"\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4", 1467126035349837140L, "\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5", -1306753992, "\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10", true, "\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4", true, "\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f", true, "\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48", true}, {"\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0", 1467126035349902677L, "\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d", 79133523, "\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec", false, "\uf4e2\uf507\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3", false, "\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597", false, "\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5", false}, {"\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9", 1467126035349968214L, "\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4", -691064438, "\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8", true, "\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033", true, "\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c", true, "\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c", true}, {"\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321", 1467126035350033751L, "\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0", -1486362579, "\uefc6\uefeb\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7", false, "\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b", false, "\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799", false, "\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26", false}, {"\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8", 1467126035350099288L, "\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac", 2046799684, "\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317", true, "\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210", true, "\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850", true, "\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071", true}, {"\ue38c\ue3b1\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4", 1467126035350164825L, "\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b", -904501761, "\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f", false, "\ue0e6\ue10b\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d", false, "\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a", false, "\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9", false}, {"\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b\ue590", 1467126035350230362L, "\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb", -1666294762, "\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4", true, "\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334", true, "\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55", true, "\uf023\uf048\uf06d\uf092\uf0b7\uf0dc\uf101\uf126\uf14b\uf170", true}, {"\ue58e\ue5b3\ue5d8\ue5fd\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f", 1467126035350295899L, "\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43", 1858474825, "\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561", false, "\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee", false, "\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d", false, "\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c", false}, {"\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df", 1467126035350361436L, "\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8", 1063176672, "\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618", true, "\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639", true, "\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54", true, "\uf225\uf24a\uf26f\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475", true}, {"\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927", 1467126035350426973L, "\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045", -235503589, "\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2", false, "\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681", false, "\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30", false, "\uf326\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd", false}, {"\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc", 1467126035350492510L, "\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc", 1108428466, "\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d", true, "\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738", true, "\ued09\ued2e\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59", true, "\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574", true}, {"\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29", 1467126035350558047L, "\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6", 346635733, "\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165", false, "\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814", false, "\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1", false, "\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650", false}, {"\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0", 1467126035350623584L, "\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401", -423496692, "\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c", true, "\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d", true, "\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058", true, "\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707\uf72c", true}, {"\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a", 1467126035350689121L, "\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", -1218860377, "\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8", false, "\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85", false, "\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134", false, "\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b", false}, {"\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5", 1467126035350754658L, "\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500", 166748638, "\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521", true, "\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c", true, "\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210", true, "\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b", true}, {"\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d", 1467126035350820195L, "\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc", -636987279, "\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569", false, "\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18", false, "\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef", false, "\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3", false}, {"\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4", 1467126035350885732L, "\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005", -1398792536, "\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620", true, "\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf\uecf4", true, "\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f", true, "\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458", true}, {"\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0", 1467126035350951269L, "\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d", 2100876739, "\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc", false, "\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3", false, "\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7", false, "\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5", false}, {"\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9", 1467126035351016806L, "\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104", -816804742, "\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8", true, "\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043", true, "\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c", true, "\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c", true}, {"\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331", 1467126035351082343L, "\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0", -2115288419, "\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7", false, "\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b", false, "\uf612\uf637\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9", false, "\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736", false}, {"\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8", 1467126035351147880L, "\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc", 1375942964, "\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27", true, "\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220", true, "\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060", true, "\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881", true}, {"\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a\uf49f\uf4c4", 1467126035351213417L, "\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b", 614199407, "\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f", false, "\uf0f6\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d", false, "\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a", false, "\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9", false}, {"\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0", 1467126035351278954L, "\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b", -181160314, "\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04", true, "\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344", true, "\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365", true, "\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b\ue980", true}, {"\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f", 1467126035351344491L, "\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653", 1196059961, "\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71", false, "\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe", false, "\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad", false, "\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c", false}, {"\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef", 1467126035351410028L, "\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8", 434250832, "\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28", true, "\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649", true, "\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464", true, "\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85", true}, {"\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137", 1467126035351475565L, "\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855", -361096565, "\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2", false, "\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691", false, "\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540", false, "\ueb36\ueb5b\ueb80\ueba5\uebca\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd", false}, {"\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc", 1467126035351541102L, "\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c", -1131228894, "\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d", true, "\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748", true, "\ue519\ue53e\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769", true, "\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84", true}, {"\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339", 1467126035351606639L, "\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6", 220891205, "\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175", false, "\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024", false, "\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1", false, "\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60", false}, {"\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0", 1467126035351672176L, "\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11", -549105924, "\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c", true, "\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d", true, "\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868", true, "\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c", true}, {"\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa", 1467126035351737713L, "\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59", -1847786217, "\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308", false, "\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295", false, "\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944", false, "\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b", false}, {"\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5", 1467126035351803250L, "\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10", 1651899470, "\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531", true, "\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd\ue302\ue327\ue34c", true, "\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20", true, "\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b", true}, {"\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d", 1467126035351868787L, "\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec", 881701601, "\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579", false, "\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428", false, "\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff", false, "\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3", false}, {"\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4", 1467126035351934324L, "\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0\uf015", -2061211368, "\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630", true, "\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504", true, "\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25\ued4a\ued6f", true, "\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468", true}, {"\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0", 1467126035351999861L, "\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d", 1471950771, "\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c", false, "\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3", false, "\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7", false, "\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5", false}};
        byte[] v0 = "0!j\u001c\u00ad-^\u00d1\u00c66\u0085XE\u0012\u001ees\u00bed\u00f8\u00fc\u00e1\u0011ty\u00c9H-\u00f2\u00ec\u0005\u00ff\"\u00fc\u00e80\u00fc\u00f4{\u00836GV\u0095N\u0012g\u00f5\bv\b\u0012:\u00ed\u00deH \\y\u00a3\u00abP\u00c1\u00d0go4\u007fL\u009b\u00df\u00a0\u00ea=%\u00feu\u00cf\u00f4~;}\u00cdE\u00ff\u00fd%*\u00b9\u00bbM\u0017p;\u008bJ\u008a\u00f4*\u009c\u00fc\u00c0 w\u00d2\u00bb\u00a0\u0014(\u0096\\\u00b9\u0016\u00a1\u00be\u0016\u0003\u00b0\u00ad\u00a0\u0018f\u0088\u00c9\u00a6nJ3=\u00c5\u00e2\u00c4\u00ecL\u00d1\u0082\u00bb9q\u0013\u00b6N\u00f0B\u00cfC\u00d0\u00feM\u00c2N\u00b4/(M\u0004\u0084\u00f4XG\u00a8\u00e2\u00c67\u00be\u0012\u00f1#[\u001bh\u0004\"6 \u0088\u00cc\"\u007f\u009c\u0003uS\u0017!\u008eu\u008f\u0006\u00cc\u008d\u0003hp\u0087\u0098\u00a63\u00d2\u00d6q\u0093\u0016\u00d6L\u0010i\u00a6 W\u00e5\u0007\u00efDk%\t\u00d7\u00fan E\u00ff\u00c5\u00b6\u00b2Gw\u0088E\u00a4\u00d0wy\u00c0)\u0001jai".getBytes("ISO_8859_1");
        Object[] v1 = "\u00033\u00d7\u00bd\u00a6\u0092'\u0014".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1408815016;
                case 1 -> 1104628135;
                case 2 -> 843707927;
                case 3 -> -477555675;
                case 4 -> 1787147968;
                case 5 -> 2058291841;
                case 6 -> 1542182784;
                case 7 -> 1251221126;
                case 8 -> 94777964;
                case 9 -> 1148735403;
                case 10 -> -862505216;
                case 11 -> -1166548444;
                case 12 -> 764681264;
                case 13 -> 1472423377;
                case 14 -> 1753913110;
                case 15 -> -569177617;
                case 16 -> -1395961297;
                case 17 -> 325890164;
                case 18 -> 1365325464;
                case 19 -> -103004985;
                case 20 -> -1439466296;
                case 21 -> -1974982179;
                case 22 -> -1567352826;
                case 23 -> 2040738632;
                case 24 -> 234770436;
                case 25 -> 1000761134;
                case 26 -> 1693057438;
                case 27 -> -1998122153;
                case 28 -> -605493840;
                case 29 -> 893026243;
                case 30 -> -571659790;
                case 31 -> -1534284807;
                case 32 -> 484339463;
                case 33 -> -309764565;
                case 34 -> -727343037;
                case 35 -> -1285541219;
                case 36 -> 687674904;
                case 37 -> -1753193591;
                case 38 -> 188985768;
                case 39 -> 1348932682;
                case 40 -> -1612465417;
                case 41 -> -1151708696;
                case 42 -> 1716899515;
                case 43 -> 164681054;
                case 44 -> 439998112;
                case 45 -> -1814630269;
                case 46 -> 702132407;
                case 47 -> 1486195722;
                case 48 -> -86973973;
                case 49 -> -1438977264;
                case 50 -> -2093953607;
                case 51 -> -1564241713;
                case 52 -> -1043279992;
                case 53 -> -455938348;
                case 54 -> -1325640193;
                case 55 -> 1281715350;
                case 56 -> -950559681;
                case 57 -> 1007515518;
                case 58 -> 1868905894;
                case 59 -> 2080651479;
                case 60 -> 1460534949;
                case 61 -> 1861075609;
                case 62 -> -1801903086;
                case 63 -> 123326021;
                case 64 -> 967944200;
                case 65 -> -908503459;
                case 66 -> -1232270810;
                case 67 -> -301360585;
                case 68 -> -558384864;
                case 69 -> -1478976215;
                case 70 -> 1151543732;
                case 71 -> -1032984290;
                case 72 -> -2060431627;
                case 73 -> 529233132;
                case 74 -> 903965017;
                case 75 -> 2129853112;
                case 76 -> 306068345;
                case 77 -> -141555987;
                case 78 -> -1959117798;
                case 79 -> 408435529;
                case 80 -> 855931458;
                case 81 -> -886338974;
                case 82 -> -1253973493;
                case 83 -> -440178201;
                case 84 -> 438093234;
                case 85 -> 1290383819;
                case 86 -> -104442070;
                case 87 -> -300382524;
                case 88 -> -1547605904;
                case 89 -> -85924370;
                case 90 -> 1348498006;
                case 91 -> -1178279359;
                case 92 -> 437145804;
                case 93 -> -594108022;
                case 94 -> -1451689390;
                case 95 -> 1348114139;
                case 96 -> -1034168898;
                case 97 -> 375421406;
                case 98 -> 161788333;
                case 99 -> 490553700;
                case 100 -> -537842;
                case 101 -> 651405282;
                case 102 -> 1877384906;
                case 103 -> 494395187;
                case 104 -> 1168625861;
                case 105 -> 2040412195;
                case 106 -> -1063775245;
                case 107 -> -1377893093;
                case 108 -> -2136346585;
                case 109 -> -314433889;
                case 110 -> 1286225065;
                case 111 -> -1021188211;
                case 112 -> -1147728837;
                case 113 -> -673462425;
                case 114 -> 1844261540;
                case 115 -> 681566704;
                case 116 -> -1344496058;
                case 117 -> -1214051776;
                case 118 -> -1052451015;
                case 119 -> 1845460707;
                case 120 -> -4601068;
                case 121 -> -680625524;
                case 122 -> -143381190;
                case 123 -> 2044665724;
                case 124 -> 721801517;
                case 125 -> -479298600;
                case 126 -> -122991190;
                case 127 -> -926495411;
                case 128 -> -1396418717;
                case 129 -> 1742119748;
                case 130 -> 646845139;
                case 131 -> 1711658217;
                case 132 -> 1626217550;
                case 133 -> -8305722;
                case 134 -> 540259121;
                case 135 -> -811717455;
                case 136 -> -1894053175;
                case 137 -> 0x2D022D0D;
                case 138 -> 1274109037;
                case 139 -> -1844781382;
                case 140 -> 438615520;
                case 141 -> 1650130614;
                case 142 -> 399864655;
                case 143 -> 1271779451;
                case 144 -> 480700165;
                case 145 -> 466915953;
                case 146 -> -472809887;
                case 147 -> 1988410909;
                case 148 -> 146095237;
                case 149 -> 2124834958;
                case 150 -> -1410534415;
                case 151 -> 1124877290;
                case 152 -> 2088026074;
                case 153 -> 223220430;
                case 154 -> 498827647;
                case 155 -> -1288490178;
                case 156 -> -809460305;
                case 157 -> 1996882523;
                case 158 -> -554335438;
                case 159 -> 82816822;
                case 160 -> -1226772337;
                case 161 -> -1628682897;
                case 162 -> -2084982299;
                case 163 -> 1277866321;
                case 164 -> -1512300767;
                case 165 -> -681636890;
                case 166 -> 1709920290;
                case 167 -> -2008155631;
                case 168 -> 1028762102;
                case 169 -> 807271239;
                case 170 -> 479221885;
                case 171 -> -1794399849;
                case 172 -> 1868009351;
                case 173 -> 656197036;
                case 174 -> 1581738972;
                case 175 -> 2039852922;
                case 176 -> 381796639;
                case 177 -> 769943229;
                case 178 -> 1294305836;
                case 179 -> -235964166;
                case 180 -> -271768718;
                case 181 -> 1025903720;
                case 182 -> 1892146308;
                case 183 -> -1301694404;
                case 184 -> -1533139774;
                case 185 -> 654023683;
                case 186 -> 1835402212;
                case 187 -> 552964661;
                case 188 -> 2090660600;
                case 189 -> -612418398;
                case 190 -> 141936180;
                case 191 -> -771101252;
                case 192 -> 565692816;
                case 193 -> 1411671697;
                case 194 -> 2100892755;
                case 195 -> 1922690006;
                case 196 -> 1815473744;
                case 197 -> 500328609;
                case 198 -> 26976015;
                case 199 -> 1431463169;
                case 200 -> -1286849373;
                case 201 -> 1500076749;
                case 202 -> -1504338430;
                case 203 -> 843030373;
                case 204 -> 1481537789;
                case 205 -> -1286086207;
                case 206 -> 949841448;
                case 207 -> -597971566;
                case 208 -> 577155896;
                case 209 -> 108614111;
                case 210 -> 1074405019;
                case 211 -> -2087109351;
                case 212 -> 728661855;
                case 213 -> -1311176171;
                case 214 -> -1394268421;
                case 215 -> 1124447772;
                case 216 -> 438025052;
                case 217 -> -982442902;
                case 218 -> -632697490;
                case 219 -> 618194763;
                case 220 -> -596822886;
                case 221 -> 214401888;
                case 222 -> -2141911300;
                case 223 -> -789075188;
                case 224 -> 358706579;
                case 225 -> 950967506;
                case 226 -> 1838204670;
                case 227 -> -657306987;
                case 228 -> -1396423875;
                case 229 -> 1621269350;
                case 230 -> -135130871;
                case 231 -> 215908787;
                case 232 -> -41535156;
                case 233 -> 1099373141;
                case 234 -> 762399701;
                case 235 -> -1216848996;
                case 236 -> -1193628552;
                case 237 -> -802875423;
                case 238 -> -960983277;
                case 239 -> -1376491083;
                case 240 -> -662160254;
                case 241 -> 1257961079;
                case 242 -> -1545860725;
                case 243 -> 1180757365;
                case 244 -> -1414979989;
                case 245 -> 636833364;
                case 246 -> 1473029238;
                case 247 -> -1105524236;
                case 248 -> -858837842;
                case 249 -> 1019259865;
                case 250 -> -1418363756;
                case 251 -> 104337855;
                case 252 -> 1901717968;
                case 253 -> 1255245658;
                case 254 -> -2122779533;
                case 255 -> 1041400425;
                default -> 772459509;
            });
        } while (v2 != 240);
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
            Object[] objectArray = new Object[16];
            v1 = objectArray;
            EnumType_ii0_2 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        oi0 = 5.0f;
        i0i = 8;
        i0I = 13;
        i0o = 120;
        i00 = 4;
        WorldTimeModule = 16;
        iOi = 100;
    }

    private void OOoI() {
        this.FontRenderer();
        this.iIo = null;
        this.iIO.clear();
        this.iI0.clear();
    }

    private static boolean OOi0(Block param0) {
        return param0 == Blocks.TORCH || param0 == Blocks.WALL_TORCH || param0 == Blocks.SOUL_TORCH || param0 == Blocks.SOUL_WALL_TORCH || param0 == Blocks.LANTERN || param0 == Blocks.SOUL_LANTERN || param0 == Blocks.IRON_BARS || param0 == Blocks.GLASS || param0 == Blocks.GLASS_PANE || param0 == Blocks.LADDER || param0 == Blocks.STONE_BRICKS || param0 == Blocks.CRACKED_STONE_BRICKS || param0 == Blocks.MOSSY_STONE_BRICKS || param0 == Blocks.CHISELED_STONE_BRICKS || param0 == Blocks.STONE_BRICK_STAIRS || param0 == Blocks.STONE_BRICK_SLAB || param0 == Blocks.POLISHED_ANDESITE || param0 == Blocks.POLISHED_DIORITE || param0 == Blocks.POLISHED_GRANITE || param0 == Blocks.SMOOTH_STONE || param0 == Blocks.BRICKS || param0 == Blocks.BOOKSHELF || param0 == Blocks.CRAFTING_TABLE || param0 == Blocks.FURNACE || param0 == Blocks.ANVIL || param0 == Blocks.ENCHANTING_TABLE || param0 == Blocks.BREWING_STAND || param0 == Blocks.JACK_O_LANTERN || param0 == Blocks.PUMPKIN || param0 == Blocks.CARVED_PUMPKIN || param0 instanceof StairsBlock || param0 instanceof SlabBlock || param0 instanceof FenceBlock || param0 instanceof WallBlock;
    }

    private void SettingContainer() {
        this.iIO.clear();
        this.iI0.clear();
        this.iIo = SpawnerFinderModule.ConfigSupport_OI0.world == null ? null : SpawnerFinderModule.ConfigSupport_OI0.world.method_27983();
        this.PotionEffectsHudElement = 0L;
    }

    private boolean DataRecord_OOI0(int param1, int param2, int param3, World param4) {
        int v5 = 0;
        int v6 = Math.min(param2 + 20, param4.method_31600() - 1);
        BlockPos.Mutable v7 = new BlockPos.Mutable();
        for (int v8 = param2; v8 <= v6; ++v8) {
            v7.set(param1, v8, param3);
            if (!param4.method_8320((BlockPos)v7).method_26216()) continue;
            ++v5;
        }
        return v5 < 5;
    }

    private int OOIo(int param1, int param2, int param3, int param4, int param5, int param6, Set param7, World param8) {
        int v9 = param1 + 1;
        int v10 = param2 + 1;
        int v11 = param3 + 1;
        int v12 = param4 - 1;
        int v13 = param5 - 1;
        int v14 = param6 - 1;
        if (v9 > v12 || v10 > v13 || v11 > v14) {
            return 0;
        }
        int v15 = 0;
        BlockPos.Mutable v16 = new BlockPos.Mutable();
        BlockPos.Mutable v17 = new BlockPos.Mutable();
        for (int v18 = v9; v18 <= v12; ++v18) {
            for (int v19 = v10; v19 <= v13; ++v19) {
                for (int v20 = v11; v20 <= v14; ++v20) {
                    int[][] v22;
                    v16.set(v18, v19, v20);
                    if (param7.contains(v16.method_10062()) || param8.method_8320((BlockPos)v16).method_26204() != Blocks.STONE) continue;
                    boolean v21 = false;
                    for (int[] v26 : v22 = new int[][]{{0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}}) {
                        v17.set(v18 + v26[0], v19 + v26[1], v20 + v26[2]);
                        if (param8.method_8320((BlockPos)v17).method_26216()) continue;
                        v21 = true;
                        break;
                    }
                    if (!v21 || ++v15 < 4) continue;
                    return v15;
                }
            }
        }
        return v15;
    }

    private void OO0i(Map param1, World param2) {
        Object v16;
        Block v15;
        BlockState v14;
        int v3 = (Integer)this.ioO.HelpCommand();
        BlockPos v4 = SpawnerFinderModule.ConfigSupport_OI0.player.method_24515();
        BlockPos.Mutable v5 = new BlockPos.Mutable();
        HashSet<BlockPos> v6 = new HashSet<BlockPos>();
        HashSet<BlockPos> v7 = new HashSet<BlockPos>();
        HashSet<BlockPos> v8 = new HashSet<BlockPos>();
        HashSet<BlockPos> v9 = new HashSet<BlockPos>();
        for (int v10 = -v3; v10 <= v3; ++v10) {
            if (Thread.currentThread().isInterrupted() || !this.iiO) {
                return;
            }
            for (int v11 = -v3; v11 <= v3; ++v11) {
                WorldChunk v12;
                if (v10 * v10 + v11 * v11 > v3 * v3 || (v12 = param2.method_8398().getWorldChunk(v4.method_10263() + v10 >> 4, v4.method_10260() + v11 >> 4, false)) == null) continue;
                for (int v13 = -100; v13 <= 100; ++v13) {
                    v5.set(v4.method_10263() + v10, v4.method_10264() + v13, v4.method_10260() + v11);
                    if (v5.method_10264() < param2.method_31607() || v5.method_10264() >= param2.method_31600() || v5.method_10264() > 120 || (v14 = v12.method_8320((BlockPos)v5)).method_26215()) continue;
                    v15 = v14.method_26204();
                    v16 = v5.method_10062();
                    if (v15 == Blocks.COBBLESTONE) {
                        v6.add((BlockPos)v16);
                        continue;
                    }
                    if (v15 == Blocks.MOSSY_COBBLESTONE) {
                        v7.add((BlockPos)v16);
                        continue;
                    }
                    if (v15 == Blocks.SPAWNER) {
                        v8.add((BlockPos)v16);
                        continue;
                    }
                    if (v15 != Blocks.CHEST) continue;
                    v9.add((BlockPos)v16);
                }
            }
        }
        if (v7.isEmpty()) {
            return;
        }
        HashSet<BlockPos> v10 = new HashSet<BlockPos>(v6);
        v10.addAll(v7);
        HashSet<BlockPos> v11 = new HashSet<BlockPos>();
        for (BlockPos v13 : v7) {
            int v21;
            int v202;
            int v19;
            int v18;
            int v17;
            if (Thread.currentThread().isInterrupted() || !this.iiO) {
                return;
            }
            if (v11.contains(v13)) continue;
            v14 = new ArrayDeque();
            v15 = new HashSet();
            v14.add(v13);
            v11.add(v13);
            v15.add(v13);
            while (!v14.isEmpty()) {
                v16 = (BlockPos)v14.poll();
                for (v17 = -4; v17 <= 4; ++v17) {
                    for (v18 = -4; v18 <= 4; ++v18) {
                        for (v19 = -4; v19 <= 4; ++v19) {
                            BlockPos v202;
                            if (v17 == 0 && v18 == 0 && v19 == 0 || v11.contains(v202 = v16.add(v17, v18, v19)) || !v10.contains(v202)) continue;
                            v11.add(v202);
                            v15.add(v202);
                            v14.add(v202);
                        }
                    }
                }
            }
            v16 = this.EventHandler((Set)v15, v6, v7);
            if (v16.ConfigSupport_O0I < 16 || v16.O0o < 2) continue;
            v17 = v16.GuiSupport_OOI - v16.PacketEvent + 1;
            v18 = v16.OOi - v16.HelpCommand + 1;
            v19 = v16.HudElement - v16.OOo + 1;
            if (v17 > 13 || v19 > 13 || v18 > 8 || v17 * v18 * v19 > 800 || this.DataRecord_OOI0(v202 = (v16.PacketEvent + v16.GuiSupport_OOI) / 2, v16.OOi + 1, v21 = (v16.OOo + v16.HudElement) / 2, param2) || this.OOoi(v16.PacketEvent, v16.HelpCommand, v16.OOo, v16.GuiSupport_OOI, v16.OOi, v16.HudElement, param2) || !this.Manager(v16.PacketEvent, v16.HelpCommand, v16.OOo, v16.GuiSupport_OOI, v16.OOi, v16.HudElement, 0.5f, param2)) continue;
            boolean v22 = this.GuiSupport_OOII(v8, v16.PacketEvent - 1, v16.HelpCommand - 1, v16.OOo - 1, v16.GuiSupport_OOI + 1, v16.OOi + 1, v16.HudElement + 1);
            boolean v23 = this.GuiSupport_OOII(v9, v16.PacketEvent - 1, v16.HelpCommand - 1, v16.OOo - 1, v16.GuiSupport_OOI + 1, v16.OOi + 1, v16.HudElement + 1);
            int v24 = this.OOIo(v16.PacketEvent, v16.HelpCommand, v16.OOo, v16.GuiSupport_OOI, v16.OOi, v16.HudElement, v10, param2);
            RenderSupport_ooio_6 v25 = new RenderSupport_ooio_6(new Box((double)v16.PacketEvent, (double)v16.HelpCommand, (double)v16.OOo, (double)v16.GuiSupport_OOI + 1.0, (double)v16.OOi + 1.0, (double)v16.HudElement + 1.0), new BlockPos((v16.PacketEvent + v16.GuiSupport_OOI) / 2, (v16.HelpCommand + v16.OOi) / 2, (v16.OOo + v16.HudElement) / 2), v16.EventBusApi, v16.O0o, v22, v23, v24, false);
            if (!(v25.OOi >= 0.3f)) continue;
            param1.put(v25.HelpCommand, v25);
        }
    }

    private void OOoo() {
        double v1 = ((Integer)this.ioo.HelpCommand()).intValue();
        for (RenderSupport_ooio_6 v4 : this.iIO.values()) {
            double v9;
            double v7;
            double v5;
            if (v4.O0i || !(Math.sqrt((v5 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23317() - ((double)v4.HelpCommand.method_10263() + 0.5)) * v5 + (v7 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23320() - ((double)v4.HelpCommand.method_10264() + 0.5)) * v7 + (v9 = SpawnerFinderModule.ConfigSupport_OI0.player.method_23321() - ((double)v4.HelpCommand.method_10260() + 0.5)) * v9) <= v1)) continue;
            v4.O0i = true;
            this.iI0.add(v4.HelpCommand);
        }
    }

    private ConfigSupport_o0io_0 EventHandler(Set param1, Set param2, Set param3) {
        int v4 = Integer.MAX_VALUE;
        int v5 = Integer.MAX_VALUE;
        int v6 = Integer.MAX_VALUE;
        int v7 = Integer.MIN_VALUE;
        int v8 = Integer.MIN_VALUE;
        int v9 = Integer.MIN_VALUE;
        int v10 = 0;
        int v11 = 0;
        for (BlockPos v13 : param1) {
            if (param2.contains(v13)) {
                ++v10;
            }
            if (param3.contains(v13)) {
                ++v11;
            }
            v4 = Math.min(v4, v13.method_10263());
            v5 = Math.min(v5, v13.method_10264());
            v6 = Math.min(v6, v13.method_10260());
            v7 = Math.max(v7, v13.method_10263());
            v8 = Math.max(v8, v13.method_10264());
            v9 = Math.max(v9, v13.method_10260());
        }
        return new ConfigSupport_o0io_0(v4, v5, v6, v7, v8, v9, v10, v11);
    }
}

