/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.block.Block
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 *  org.joml.Matrix3x2fStack
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package clap.module.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.joml.Matrix3x2fStack;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import clap.network.NetworkSupport_00OI;
import clap.render.RenderSupport_O0I0;
import clap.render.FontRenderer;
import clap.core.module.Module;
import clap.render.RenderSupport_0ooi_1;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.render.RenderSupport_oiii_5;
import clap.render.RenderSupport_oiio_4;
import clap.core.module.ModuleCategory;
import clap.render.ScaledDrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.module.render.StructureFinderModule
 */
public class StructureFinderModule
extends Module {
    private final Setting 0oOI;
    private final Set iO0I;
    private static final int[][] iOoI;
    private static final float iOOI;
    private final Setting ioO = this.OOi0o("Range", 256, 32, 512);
    private final Map iOoO;
    private static final int IiIi;
    private static final int Iiio;
    private long PotionEffectsHudElement;
    private final Setting iO0O;
    private final Setting ioi;
    private RegistryKey iOoo;
    private static final int IiII;
    private final Setting NoHurtCamModule;
    private static final int IiIo;
    private static final int Iii0;
    private static final int iOOO;
    private final Setting iOOi;
    private static final int iOO0;
    private static final int IiI0;
    private static final int Iiii;
    private static final int IiiI;
    private final Map iOo0;
    private volatile boolean iiO;
    private static final int Iioi;
    private final Setting io0 = this.OOi0o("ScanDelay", 5, 1, 15).ConfigSupport_00o_0("s");
    private final Setting iO00;
    private static final int IiIO;
    private final Map iO0i;
    private static final float iOOo;
    private static final int IiiO;
    private Thread iIi;
    private final CopyOnWriteArrayList iO0o;
    static Object iOoi;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    @Override
    public void SpawnerFinderModule() {
        if (StructureFinderModule.iooI()) {
            this.0oI();
            return;
        }
        if (this.iOoo == null || !this.iOoo.equals(StructureFinderModule.ConfigSupport_OI0.world.method_27983())) {
            this.iOoo = StructureFinderModule.ConfigSupport_OI0.world.method_27983();
            this.FontRenderer();
            this.iO0o.clear();
            this.iO0I.clear();
            this.iO0i.clear();
            this.iOoO.clear();
            this.iOo0.clear();
            this.PotionEffectsHudElement = 0L;
        }
        long v1 = System.currentTimeMillis();
        if (!(this.iiO || this.PotionEffectsHudElement != 0L && v1 - this.PotionEffectsHudElement < (long)((Integer)this.io0.HelpCommand()).intValue() * 1000L)) {
            this.PotionEffectsHudElement = v1;
            this.O0iii();
        }
        this.OoOoi();
        this.OoOOi();
    }

    private void OoOOO(World param1, WorldChunk param2, BlockPos param3, int param4) {
        int v5 = param2.method_12004().getStartX();
        int v6 = param2.method_12004().getStartZ();
        BlockPos.Mutable v7 = new BlockPos.Mutable();
        HashSet v8 = new HashSet();
        for (int v9 = v5; v9 < v5 + 16; ++v9) {
            for (int v10 = v6; v10 < v6 + 16; ++v10) {
                Block v15;
                BlockPos v14;
                int v13;
                int v12;
                int v11 = v9 - param3.method_10263();
                if (v11 * v11 + (v12 = v10 - param3.method_10260()) * v12 > param4) continue;
                if (((Boolean)this.iO00.HelpCommand()).booleanValue()) {
                    for (v13 = -40; v13 <= 40; ++v13) {
                        v7.set(v9, v13, v10);
                        v14 = v7.method_10062();
                        if (v8.contains(v14.asLong()) || param2.method_8320((BlockPos)v7).method_26204() != Blocks.END_PORTAL_FRAME) continue;
                        v15 = this.OoOO0(param1, v14, v8);
                        this.OoOOI(3, (Box)v15, new Color(120, 255, 120));
                    }
                }
                if (((Boolean)this.iO0O.HelpCommand()).booleanValue()) {
                    for (v13 = -32; v13 <= 24; ++v13) {
                        v7.set(v9, v13, v10);
                        v14 = v7.method_10062();
                        v15 = param2.method_8320((BlockPos)v7).method_26204();
                        if (!this.OoO0o(v15) || !this.OoOoO(param1, v14) || !this.OoO0i(param1, v14)) continue;
                        this.OoOOo(2, v14, new Color(255, 120, 50));
                    }
                }
                if (!((Boolean)this.iOOi.HelpCommand()).booleanValue()) continue;
                for (v13 = -52; v13 <= -8; ++v13) {
                    v7.set(v9, v13, v10);
                    v14 = v7.method_10062();
                    v15 = param2.method_8320((BlockPos)v7).method_26204();
                    if (!this.OoO0I(v15) || !this.OoOo0(param1, v14)) continue;
                    this.OoOOo(1, v14, new Color(0, 150, 255));
                }
            }
        }
    }

    private void OoOoi() {
        Vec3d v1 = StructureFinderModule.ConfigSupport_OI0.player.method_73189();
        for (RenderSupport_O0I0 v3 : this.iO0o) {
            if (v3.HudElement || !v3.HelpCommand.contains(v1)) continue;
            v3.HudElement = true;
        }
    }

    private boolean OoOoo(int param1) {
        return param1 == 1 && (Boolean)this.iOOi.HelpCommand() != false || param1 == 2 && (Boolean)this.iO0O.HelpCommand() != false || param1 == 3 && (Boolean)this.iO00.HelpCommand() != false;
    }

    private boolean oiII(BufferBuilder param1, MatrixStack.Entry param2, Vec3d param3, Vec3d param4, int param5, float param6) {
        Vec3d v7 = param4.subtract(param3);
        if (v7.lengthSquared() < 1.0E-6) {
            return false;
        }
        Vec3d v8 = v7.crossProduct(new Vec3d(0.0, 1.0, 0.0));
        if (v8.lengthSquared() < 1.0E-6) {
            v8 = v7.crossProduct(new Vec3d(1.0, 0.0, 0.0));
        }
        v8 = v8.normalize().multiply((double)param6);
        this.iIi(param1, param2, (float)(param3.x - v8.x), (float)(param3.y - v8.y), (float)(param3.z - v8.z), (float)(param3.x + v8.x), (float)(param3.y + v8.y), (float)(param3.z + v8.z), (float)(param4.x + v8.x), (float)(param4.y + v8.y), (float)(param4.z + v8.z), (float)(param4.x - v8.x), (float)(param4.y - v8.y), (float)(param4.z - v8.z), param5);
        return true;
    }

    private String OoOoI(int param1, boolean param2) {
        if (param2) {
            if (param1 == 1) {
                return "\u8fdc\u53e4\u57ce\u5e02";
            }
            if (param1 == 2) {
                return "\u8bd5\u70bc\u4e4b\u5730";
            }
            if (param1 == 3) {
                return "\u672b\u5730\u4f20\u9001\u95e8";
            }
            return "\u7ed3\u6784";
        }
        if (param1 == 1) {
            return "Ancient City";
        }
        if (param1 == 2) {
            return "Trial Chamber";
        }
        if (param1 == 3) {
            return "End Portal";
        }
        return "Structure";
    }

    private boolean OoO0i(World param1, BlockPos param2) {
        int v8;
        long v3 = param2.asLong();
        Boolean v5 = (Boolean)this.iOoO.get(v3);
        if (v5 != null) {
            return v5;
        }
        int v6 = 0;
        int v7 = 0;
        for (v8 = -4; v8 <= 4; v8 += 1) {
            for (int v9 = -3; v9 <= 3; ++v9) {
                for (int v10 = -4; v10 <= 4; ++v10) {
                    Block v11 = param1.method_8320(param2.add(v8, v9, v10)).method_26204();
                    if (v11 == Blocks.COPPER_BULB || v11 == Blocks.OXIDIZED_COPPER_BULB) {
                        ++v6;
                    }
                    if (v11 != Blocks.CHISELED_TUFF && v11 != Blocks.CHISELED_TUFF_BRICKS && v11 != Blocks.TUFF_BRICKS && v11 != Blocks.POLISHED_TUFF) continue;
                    ++v7;
                }
            }
        }
        v8 = v6 >= 2 || v7 >= 10 ? 1 : 0;
        this.iOoO.put(v3, v8 != 0);
        return v8 != 0;
    }

    private float oiI0() {
        return 0.0035f;
    }

    @Override
    public void 0oI() {
        this.FontRenderer();
        this.iO0o.clear();
        this.iO0I.clear();
        this.iO0i.clear();
        this.iOoO.clear();
        this.iOo0.clear();
        this.PotionEffectsHudElement = 0L;
        this.iOoo = null;
    }

    private void FontRenderer() {
        this.iiO = false;
        if (this.iIi != null && this.iIi.isAlive()) {
            this.iIi.interrupt();
        }
        this.iIi = null;
    }

    private void O0iii() {
        this.FontRenderer();
        this.iiO = true;
        this.iIi = new Thread(() -> {
            try {
                ClientWorld v1 = StructureFinderModule.ConfigSupport_OI0.world;
                if (v1 == null || StructureFinderModule.ConfigSupport_OI0.player == null) {
                    return;
                }
                BlockPos v2 = StructureFinderModule.ConfigSupport_OI0.player.method_24515();
                int v3 = (Integer)this.ioO.HelpCommand();
                int v4 = v2.method_10263() >> 4;
                int v5 = v2.method_10260() >> 4;
                int v6 = v3 + 15 >> 4;
                for (int v7 = v4 - v6; v7 <= v4 + v6; ++v7) {
                    for (int v8 = v5 - v6; v8 <= v5 + v6; ++v8) {
                        if (Thread.currentThread().isInterrupted() || !this.iiO || StructureFinderModule.ConfigSupport_OI0.world != v1) {
                            return;
                        }
                        WorldChunk v9 = v1.method_8398().getWorldChunk(v7, v8, false);
                        if (v9 == null) continue;
                        ChunkPos v10 = new ChunkPos(v7, v8);
                        Set v11 = this.iO0I;
                        synchronized (v11) {
                            if (!this.iO0I.add(v10)) {
                                continue;
                            }
                        }
                        this.OoOOO((World)v1, v9, v2, v3 * v3);
                        Thread.sleep(1L);
                    }
                }
            }
            catch (InterruptedException v1) {
            }
            finally {
                this.iiO = false;
            }
        }, "StructureFinder-Scanner");
        this.iIi.setDaemon(true);
        this.iIi.start();
    }

    private Vec3d oiIo(Camera param1) {
        Vector3fc v2 = param1.getHorizontalPlane();
        return new Vec3d((double)v2.x(), (double)v2.y(), (double)v2.z()).multiply(0.35);
    }

    private boolean OoO0I(Block param1) {
        return param1 == Blocks.REINFORCED_DEEPSLATE || param1 == Blocks.DEEPSLATE_BRICKS || param1 == Blocks.CRACKED_DEEPSLATE_BRICKS || param1 == Blocks.DEEPSLATE_TILES || param1 == Blocks.CRACKED_DEEPSLATE_TILES || param1 == Blocks.CHISELED_DEEPSLATE || param1 == Blocks.POLISHED_DEEPSLATE || param1 == Blocks.SCULK || param1 == Blocks.SCULK_SENSOR || param1 == Blocks.SCULK_SHRIEKER || param1 == Blocks.SCULK_CATALYST;
    }

    private void OoOOi() {
        boolean v1;
        if (this.iO0o.size() < 2) {
            return;
        }
        block0: do {
            v1 = false;
            ArrayList v2 = new ArrayList(this.iO0o);
            for (int v3 = 0; v3 < v2.size(); ++v3) {
                RenderSupport_O0I0 v4 = (RenderSupport_O0I0)v2.get(v3);
                for (int v5 = v3 + 1; v5 < v2.size(); ++v5) {
                    RenderSupport_O0I0 v6 = (RenderSupport_O0I0)v2.get(v5);
                    if (v4.PacketEvent != v6.PacketEvent || !v4.HelpCommand.expand(12.0).intersects(v6.HelpCommand) && !v6.HelpCommand.expand(12.0).intersects(v4.HelpCommand) && !(this.OoOIO(v4.PacketEvent(), v6.PacketEvent()) <= this.OoO0O(v4.PacketEvent) * this.OoO0O(v4.PacketEvent))) continue;
                    v4.HelpCommand = v4.HelpCommand.union(v6.HelpCommand);
                    v4.GuiSupport_OOI += v6.GuiSupport_OOI;
                    v4.OOi = Math.max(v4.OOi, v6.OOi);
                    v4.HudElement = v4.HudElement || v6.HudElement;
                    this.iO0o.remove(v6);
                    v1 = true;
                    continue block0;
                }
            }
        } while (v1);
    }

    private void OoOOI(int param1, Box param2, Color param3) {
        RenderSupport_O0I0 v4 = null;
        double v5 = switch (param1) {
            case 1 -> 96.0;
            case 2 -> 72.0;
            case 3 -> 80.0;
            default -> 64.0;
        };
        Vec3d v7 = param2.getCenter();
        for (RenderSupport_O0I0 v9 : this.iO0o) {
            if (v9.PacketEvent != param1) continue;
            if (v9.HelpCommand.expand(12.0).intersects(param2)) {
                v4 = v9;
                break;
            }
            if (!(this.OoOIO(v9.PacketEvent(), v7) <= v5 * v5)) continue;
            v4 = v9;
            break;
        }
        if (v4 == null) {
            this.iO0o.add(new RenderSupport_O0I0(param1, param2, param3));
            return;
        }
        v4.HelpCommand = v4.HelpCommand.union(param2);
        ++v4.GuiSupport_OOI;
        v4.OOi = System.currentTimeMillis();
    }

    private void OoOOo(int param1, BlockPos param2, Color param3) {
        Box v4 = new Box(param2);
        this.OoOOI(param1, v4, param3);
    }

    private boolean OoOo0(World param1, BlockPos param2) {
        int v10;
        long v3 = param2.asLong();
        Boolean v5 = (Boolean)this.iO0i.get(v3);
        if (v5 != null) {
            return v5;
        }
        if (param2.method_10264() > -8) {
            this.iO0i.put(v3, false);
            return false;
        }
        if (this.OoOoO(param1, param2)) {
            this.iO0i.put(v3, false);
            return false;
        }
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        for (v10 = -5; v10 <= 5; v10 += 1) {
            for (int v11 = -3; v11 <= 3; ++v11) {
                for (int v12 = -5; v12 <= 5; ++v12) {
                    Block v13 = param1.method_8320(param2.add(v10, v11, v12)).method_26204();
                    if (v13 == Blocks.REINFORCED_DEEPSLATE) {
                        ++v6;
                    } else if (v13 == Blocks.DEEPSLATE_BRICKS || v13 == Blocks.CRACKED_DEEPSLATE_BRICKS || v13 == Blocks.DEEPSLATE_TILES || v13 == Blocks.CRACKED_DEEPSLATE_TILES) {
                        ++v7;
                    } else if (v13 == Blocks.CHISELED_DEEPSLATE || v13 == Blocks.POLISHED_DEEPSLATE) {
                        ++v8;
                    }
                    if (v13 != Blocks.COPPER_BULB && v13 != Blocks.OXIDIZED_COPPER_BULB && v13 != Blocks.CHISELED_TUFF && v13 != Blocks.CHISELED_TUFF_BRICKS && v13 != Blocks.TUFF_BRICKS && v13 != Blocks.POLISHED_TUFF) continue;
                    ++v9;
                }
            }
        }
        if (v9 >= 8) {
            this.iO0i.put(v3, false);
            return false;
        }
        v10 = v6 >= 1 && v7 >= 10 || v6 >= 2 || v7 >= 22 && v8 >= 6 ? 1 : 0;
        this.iO0i.put(v3, v10 != 0);
        return v10 != 0;
    }

    private void iIi(BufferBuilder param1, MatrixStack.Entry param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, float param11, float param12, float param13, float param14, int param15) {
        param1.method_56824(param2, param3, param4, param5).color(param15);
        param1.method_56824(param2, param6, param7, param8).color(param15);
        param1.method_56824(param2, param9, param10, param11).color(param15);
        param1.method_56824(param2, param12, param13, param14).color(param15);
    }

    static {
        __k__gH4it = StructureFinderModule.__k__gH4it(8180775218684358161L);
        __rP__gH4it0 = new String[]{"\u6568\u8c16\u52d8\u07fa\u80f3\ufe4c\u870d\u5121", "\u6570\u8c50\u52d7\u0744\u80ed\ufe4c\u875e", "\u6575\u8c4d\u52d7\u0745\u80e4"};
        __rP__gH4it1 = new String[]{"\u6560\u8c58\u52c6"};
        __rP__gH4it2 = new String[]{"\u640b\u8dba\u5325\u06e2\u814c\uffa4\u877b\u517a\u65f0\u8ca9\u5240\u074b\u80ac\ufeee\u8485\u5240\u66f6\u8f24\u5194\u0407\u836a\ufd58\u85af\u53d7\u6776\u8ed2\u500b\u05c1\u828c\ufca3\u8231\u54c3\u60e2\u8967\u57c2\u02e5\u8572\ufb00\u820c\u55c6\u613f\u8831\u5629\u03c9\u8459\ufa8a\u83cc\u5631\u62d0\u8bce\u557ef\u87a7\uf9d0\u8077\u5748\u63ef\u8a67\u54cd\u0189\u867a\uf8d8\u81d8\u58f5\u6c29\u853c\u5ba9\u0ea7\u89ee\uf7aa\u8eb1\u5897\u6da2\u8494\u5abe\u0fa7\u886a\uf664\u8fee\u598d\u6eb3\u87d4\u5958\u0c90\u8b71\uf5d5\u8cab\u5aaf\u6f38\u869f\u586c\u0d13\u8a0b\uf419\u8d5c\u5b41\u681c\u81a1\u5f49\u0a03\u8d2d\uf380\u8ae0\u5c14\u6859\u800c\u5e23\u0b50\u8c74\uf2fb\u8bff\u5d68\u69fa\u83fb\u5d12\u08b0\u8fd2\uf1e1\u884b\u5e8f\u6a94\u82d5\u5c4f\u0901\u8e57\uf03a\u89e9\u5fb7\u6bc0\ubd73\u630c\u36af\ub119\ucf0a\ub605\u6033\u5495\ubd0e\u6268\u375e\ub059\ucee2\ub7bc\u6157\u55d4\ubc6c\u6141\u346e\ub3cc\ucd52\ub437\u624b\u5699\ubffc\u6075\u35fd\ub24f\ucc00\ub5ee\u6387\u57e9\ubedd\u6777\u3211\ub52a\ucb2b\ub250\u6424\u5052\ub932\u676b\u3342\ub47b\ucaa5\ub35b\u6512\u51fc\ub803\u6637\u3031\ub71f\uc9c0\ub0bc\u66f6\u5294\ubb49\u652f\u315a\ub68e\uc8a1\ub1fa\u67f8\u53da\uba93\u64a2\u3ec9\ub96d\uc739\ube71\u680f\u5ca3\ub5e1\u6b1c\u3e40\ub85a\uc608\ubf1d\u6908\u5d76\ub446\u6a9b\u3f37\ubbf9\uc53c\ubc45\u6abd\u5ed8\ub7f2\u69bf\u3c10\uba87\uc432\ubd3e\u6b04\u5fd5\ub681\u688f\u3dd2\ubd86\uc33e\uba4d\u6c22\u58af\ub1ef\u6fd0\u3a34\ubd57\uc2ba\ubb7d\u6de7\u5928\ub0f9\u6ecf\u3b8e\ubc3b\uc1ce\ub890\u6e8c\u5a68\ub305\u6df4\u3874\ubf75\uc046\ub9c4\u6f2d\u5b9e\ub230\u6cb5\u393d\ube50\uc021\ua674\u70b3\u4480\uad42\u73be\u26b5\ua198\udf57\ua7b4\u7152\u458a\uacf1\u72fb\u27fb\ua07d\ude05\ua4dd\u723d\u4688\uaf0e\u716d\u24aa\ua39e\uddf7\ua5b1\u73f2\u47e6\uae63\u7063\u2518\ua261\udc0f\ua508\u7448\u403a\ua9e3\u77b5\u22b6\ua5b6\udbf2\ua258\u7531\u41df\ua8d5\u7621\u2307\ua47c\uda1b\ua3ca\u76dc\u4265\uab24\u7566\u2084\ua77f\ud9b4\ua013\u7747\u43f4\uaa55\u74c3\u21a7\ua6b1\ud866\ua16c\u7736\u4cbb\ua5b4\u7b54\u2e61\ua94c\ud7aa\uae37\u7869\u4dab\ua46a\u7a32\u2f5e\ua8c1\ud678\uaf68\u7943\u4e4b\ua794\u7959\u2c5c\uab41\ud510\uacf8\u7a76\u4ff5\ua653\u7818\u2dfd\uaaab\ud4e0\uad91\u7b9a", "\u6562\u8c43\u52d1\u073e\u80ef\ufe49\u8725\u5131\u658c\u8f19", "\u6576\u8c4a\u52d4\u0755\u808d\ufe24\u873a\u510c\u666a\u8f4c\u51cc\u0421\u83f3\ufd2e\u8400\u525f\u6746\u8e76\u50f9\u050d"};
        __rP__gH4it3 = new String[]{"\u6560\u8c41\u52d7\u0738\u80ed\ufe4b\u875b\u510f\u658e\u8f1b"};
        __p__gH4it = new String[]{"\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114", "\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f", "\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075", "\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1", "\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766", "\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73", "\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3", "\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd", "\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506", "\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913", "\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5", "\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd", "\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584", "\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e", "\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444", "\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3", "\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438", "\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f", "\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31", "\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5", "\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2", "\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c", "\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18", "\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030\uf055", "\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d", "\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa", "\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d", "\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d", "\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8", "\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b", "\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191", "\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb", "\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf", "\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a", "\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad", "\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", "\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032", "\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1", "\ue6ac\ue6d1\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921", "\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76", "\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30", "\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462", "\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673\uf698\uf6bd", "\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d", "\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c", "\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c", "\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee", "\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128", "\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26", "\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211", "\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491", "\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99", "\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356", "\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066", "\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f", "\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6", "\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b", "\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065", "\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd", "\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141", "\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208", "\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615", "\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b", "\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678", "\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251", "\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10", "\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121", "\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695", "\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012", "\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3", "\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4", "\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae", "\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246", "\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78", "\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d", "\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69", "\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec", "\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e", "\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581", "\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308", "\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4", "\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260", "\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd", "\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5", "\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c\ue491\ue4b6", "\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8", "\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9", "\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe", "\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd", "\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137", "\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4", "\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d", "\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c", "\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f", "\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a", "\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855"};
        __c__J7Um6 = new Object[][]{{"\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7", 877868829518674771L, "\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59", 795520345, "\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be", false, "\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504", false, "\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e", false, "\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6", false}, {"\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783", 877868829518740308L, "\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb", 1628269566, "\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678", true, "\ue3b5\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a", true, "\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20", true, "\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441", true}, {"\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d", 877868829518805845L, "\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2", -1281023977, "\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8", false, "\ue4b6\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672", false, "\uebd4\uebf9\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda", false, "\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567", false}, {"\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf", 877868829518871382L, "\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c", -1000472916, "\uf699\uf6be\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e", true, "\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704", true, "\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25", true, "\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a\uf5af", true}, {"\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86", 877868829518936919L, "\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc", 385202117, "\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156", false, "\ue6b8\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be", false, "\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b", false, "\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641", false}, {"\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40", 877868829519002456L, "\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2", -1486074854, "\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8", true, "\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09", true, "\ueed7\ueefc\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093", true, "\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d", true}, {"\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0", 877868829519067993L, "\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a", -117175629, "\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2", false, "\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f", false, "\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125", false, "\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043", false}, {"\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6", 877868829519133530L, "\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc", 196920264, "\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed", true, "\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77", true, "\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201", true, "\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f", true}, {"\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e", 877868829519199067L, "\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686", 1549047905, "\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613", false, "\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09", false, "\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327", false, "\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9", false}, {"\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0", 877868829519264604L, "\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1", -288401786, "\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b", true, "\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5", true, "\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403", true, "\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b", true}, {"\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a", 877868829519330141L, "\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7", 1063743455, "\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed", false, "\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b", false, "\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573\uf598\uf5bd", false, "\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422", false}, {"\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5", 877868829519395678L, "\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f", 1897866356, "\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9", true, "\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7", true, "\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f", true, "\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc", true}, {"\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db", 877868829519461215L, "\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1", -2085100915, "\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef", false, "\ueec0\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1", false, "\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706", false, "\ue4fc\ue521\ue546\ue56b\ue590\ue5b5\ue5da\ue5ff\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727\ue74c", false}, {"\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423", 877868829519526752L, "\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad", -735069406, "\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb", true, "\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133", true, "\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0", true, "\ue5fd\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872", true}, {"\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5", 877868829519592289L, "\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3", 1724280955, "\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85", false, "\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea", false, "\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230", false, "\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba", false}, {"\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591", 877868829519657826L, "\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af", -1216475504, "\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17", true, "\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4", true, "\ue0e1\ue106\ue12b\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356", true, "\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c", true}, {"\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7", 877868829519723363L, "\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669", -921254103, "\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce", false, "\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514", false, "\ue1e2\ue207\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e", false, "\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06", false}, {"\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793", 877868829519788900L, "\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb", 462330958, "\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88", true, "\uf3c5\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a", true, "\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430", true, "\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51", true}, {"\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d", 877868829519854437L, "\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2", -1407100185, "\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8", false, "\uf4c6\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682", false, "\ue3e4\ue409\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea", false, "\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77", false}, {"\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df", 877868829519919974L, "\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c", -19328196, "\ueea9\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e", true, "\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714", true, "\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735", true, "\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a\uedbf", true}, {"\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296", 877868829519985511L, "\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc", 259074133, "\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166", false, "\uf6c8\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce", false, "\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b", false, "\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51", false}, {"\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450", 877868829520051048L, "\ue98d\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02", 1105848042, "\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8", true, "\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219", true, "\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3", true, "\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d", true}, {"\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0", 877868829520116585L, "\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a", -1820213501, "\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2", false, "\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f", false, "\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935", false, "\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053", false}, {"\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6", 877868829520182122L, "\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc", 607679576, "\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd", true, "\ue1cb\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387", true, "\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11", true, "\uf007\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f", true}, {"\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e", 877868829520247659L, "\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96", 1993356017, "\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623", false, "\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419", false, "\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37", false, "\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9", false}, {"\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0", 877868829520313196L, "\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1", -2025272554, "\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b", true, "\ue3cd\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5", true, "\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13", true, "\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b", true}, {"\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a", 877868829520378733L, "\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107", -639598161, "\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd", false, "\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b", false, "\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83\ueda8\uedcd", false, "\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432", false}, {"\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0\ueac5", 877868829520444270L, "\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f", 1805344452, "\uf6b1\uf6d6\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9", true, "\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7", true, "\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f", true, "\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec", true}, {"\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb", 877868829520509807L, "\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1", -1137502435, "\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff", false, "\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1", false, "\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16", false, "\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737\uf75c", false}, {"\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33", 877868829520575344L, "\uf195\uf1ba\uf1df\uf204\uf229\uf24e\uf273\uf298\uf2bd", -827642446, "\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db", true, "\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943", true, "\ueeef\uef14\uef39\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0", true, "\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082", true}, {"\ueb78\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5", 877868829520640881L, "\uf296\uf2bb\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3", 524544715, "\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395", false, "\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa", false, "\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240", false, "\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca", false}, {"\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1", 877868829520706418L, "\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf", 1375445856, "\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427", true, "\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4", true, "\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366", true, "\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c", true}, {"\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7", 877868829520771955L, "\uf498\uf4bd\uf4e2\uf507\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679", -476939847, "\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de", false, "\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24", false, "\uf1f2\uf217\uf23c\uf261\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae", false, "\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316", false}, {"\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3", 877868829520837492L, "\uf599\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b", 873084638, "\ue4b7\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698", true, "\uebd5\uebfa\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a", true, "\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440", true, "\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461", true}, {"\uef7c\uefa1\uefc6\uefeb\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d", 877868829520903029L, "\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2", 1185075063, "\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808", false, "\uecd6\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92", false, "\uf3f4\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa", false, "\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587", false}, {"\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef", 877868829520968566L, "\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c", -1755675252, "\ue6b9\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e", true, "\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24", true, "\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745", true, "\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf", true}, {"\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6", 877868829521034103L, "\ue09c\ue0c1\ue0e6\ue10b\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec", 704463397, "\ue7ba\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976", false, "\ueed8\ueefd\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de", false, "\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b", false, "\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661", false}, {"\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460", 877868829521099640L, "\ue19d\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412", 2073369466, "\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08", true, "\uefd9\ueffe\uf023\uf048\uf06d\uf092\uf0b7\uf0dc\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df\uf204\uf229", true, "\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3", true, "\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d", true}, {"\uf380\uf3a5\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0", 877868829521165177L, "\ue29e\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a", -1945251437, "\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2", false, "\uf0da\uf0ff\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0\uf305\uf32a\uf34f", false, "\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145", false, "\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863", false}, {"\uf481\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6", 877868829521230714L, "\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec", -559550936, "\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d", true, "\uf1db\uf200\uf225\uf24a\uf26f\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397", true, "\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221", true, "\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f", true}, {"\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e", 877868829521296251L, "\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6", 1868408641, "\uebbe\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33", false, "\uf2dc\uf301\uf326\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429", false, "\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347", false, "\ue918\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9", false}, {"\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0", 877868829521361788L, "\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1", -1577812506, "\uecbf\uece4\ued09\ued2e\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b", true, "\uf3dd\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505", true, "\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423", true, "\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b", true}, {"\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a", 877868829521427325L, "\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917", -227788225, "\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d", false, "\uf4de\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b", false, "\ue3fc\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8\ue5dd", false, "\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42", false}, {"\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5", 877868829521492862L, "\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f", 67433300, "\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9", true, "\uf5df\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707", true, "\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f", true, "\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc", true}, {"\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb", 877868829521558399L, "\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1", 1455196653, "\uefc2\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f", false, "\uf6e0\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1", false, "\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726", false, "\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47\uef6c", false}, {"\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443", 877868829521623936L, "\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd", -413710846, "\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb", true, "\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153", true, "\ue6ff\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0", true, "\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092", true}, {"\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5", 877868829521689473L, "\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3", 969875291, "\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5", false, "\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a", false, "\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50", false, "\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da", false}, {"\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1", 877868829521755010L, "\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf", 1248318960, "\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437", true, "\ue1e3\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4", true, "\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76", true, "\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c", true}, {"\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7", 877868829521820547L, "\ueca8\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89", -1675652599, "\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee", false, "\ue2e4\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534", false, "\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe", false, "\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7\uf2dc\uf301\uf326", false}, {"\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3", 877868829521886084L, "\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b", 783788206, "\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8", true, "\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a", true, "\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50", true, "\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427\uf44c\uf471", true}, {"\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d", 877868829521951621L, "\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2", 2133746119, "\uf5c8\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018", false, "\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2", false, "\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a", false, "\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597", false}, {"\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff", 877868829522017158L, "\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c", -1312408036, "\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e", true, "\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734", true, "\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30\uef55", true, "\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df", true}, {"\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6", 877868829522082695L, "\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc", -1031867211, "\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186", false, "\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee", false, "\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b", false, "\uf524\uf549\uf56e\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671", false}, {"\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70", 877868829522148232L, "\uf1ad\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422", 337022410, "\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218", true, "\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39", true, "\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3", true, "\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d", true}, {"\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0", 877868829522213769L, "\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a", -1500951965, "\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2", false, "\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f", false, "\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155", false, "\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073", false}, {"\uec91\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06", 877868829522279306L, "\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc", -148832072, "\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d", true, "\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7", true, "\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231", true, "\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", true}, {"\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e", 877868829522344843L, "\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6", 0x9D9D9D1, "\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643", false, "\ueaec\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca\uebef\uec14\uec39", false, "\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357", false, "\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4\ue309", false}, {"\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0", 877868829522410380L, "\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001", 1517393526, "\ue4cf\ue4f4\ue519\ue53e\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b", true, "\uebed\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15", true, "\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", true, "\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b", true}, {"\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a", 877868829522475917L, "\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127", -320230257, "\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d", false, "\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b", false, "\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed", false, "\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452", false}, {"\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5", 877868829522541454L, "\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f", 1048601892, "\ue6d1\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9", true, "\uedef\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17", true, "\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f", true, "\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c", true}, {"\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b", 877868829522606991L, "\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201", 1329078909, "\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f", false, "\ueef0\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1", false, "\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736", false, "\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757\ue77c", false}, {"\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453", 877868829522672528L, "\ue1b5\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd", -2117011310, "\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb", true, "\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163", true, "\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0", true, "\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2", true}, {"\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5", 877868829522738065L, "\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403", -766987989, "\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5", false, "\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a", false, "\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260", false, "\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea", false}, {"\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1", 877868829522803602L, "\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df", 1692618304, "\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47", true, "\uf1f3\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4", true, "\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386", true, "\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c", true}, {"\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7", 877868829522869139L, "\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699", -1231354727, "\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe", false, "\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544", false, "\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce", false, "\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36", false}, {"\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3", 877868829522934676L, "\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b", -952902338, "\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8", true, "\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a", true, "\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460", true, "\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c\uec81", true}, {"\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d", 877868829523000213L, "\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2", 430676567, "\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028", false, "\uf4f6\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2", false, "\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a", false, "\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7", false}, {"\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f", 877868829523065750L, "\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c", -1438494484, "\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e", true, "\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744", true, "\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740\ue765", true, "\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca\uedef", true}, {"\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6", 877868829523131287L, "\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c", -50697979, "\uefda\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196", false, "\uf6f8\uf71d\uf742\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe", false, "\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b", false, "\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12\uee37\uee5c\uee81", false}, {"\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480", 877868829523196824L, "\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32", 244459098, "\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228", true, "\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224\ue249", true, "\ue717\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3", true, "\uee35\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d", true}, {"\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0", 877868829523262361L, "\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a", 1594555635, "\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2", false, "\ue0fa\ue11f\ue144\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f", false, "\ue818\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965", false, "\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083", false}, {"\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716", 877868829523327898L, "\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c", -1851607800, "\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d", true, "\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7", true, "\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41", true, "\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f", true}, {"\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e", 877868829523393435L, "\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6", 574976929, "\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653", false, "\ue2fc\ue321\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424\ue449", false, "\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67", false, "\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319", false}, {"\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0", 877868829523458972L, "\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011", 1962739910, "\uf4df\uf504\uf529\uf54e\uf573\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b", true, "\ue3fd\ue422\ue447\ue46c\ue491\ue4b6\ue4db\ue500\ue525", true, "\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43", true, "\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab", true}, {"\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa", 877868829523524509L, "\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137", -2037006049, "\uf5e0\uf605\uf62a\uf64f\uf674\uf699\uf6be\uf6e3\uf708\uf72d", false, "\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b", false, "\uec1c\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd", false, "\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462", false}, {"\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5", 877868829523590046L, "\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f", -686973004, "\uf6e1\uf706\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009", true, "\ue5ff\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727", true, "\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f", true, "\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c", true}, {"\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b", 877868829523655583L, "\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211", 1772377293, "\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f", false, "\ue700\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1", false, "\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46", false, "\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767\uf78c", false}, {"\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63", 877868829523721120L, "\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed", -1168347806, "\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b", true, "\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973", true, "\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100", true, "\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2", true}, {"\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5", 877868829523786657L, "\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413", -856413253, "\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5", false, "\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a", false, "\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270", false, "\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa", false}, {"\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1", 877868829523852194L, "\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef", 493674704, "\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457", true, "\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4", true, "\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396", true, "\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c", true}, {"\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7", 877868829523917731L, "\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9", -1358644887, "\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e", false, "\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54", false, "\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de", false, "\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346", false}, {"\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3", 877868829523983268L, "\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b", -507545714, "\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8", true, "\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a", true, "\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470", true, "\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c\ue491", true}, {"\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d", 877868829524048805L, "\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2", 844565543, "\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838", false, "\ued06\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2", false, "\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb\uf5e0\uf605\uf62a", false, "\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7", false}, {"\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f", 877868829524114342L, "\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac", 1154467196, "\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e", true, "\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f\uef54", true, "\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750\uf775", true, "\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b\ue590\ue5b5\ue5da\ue5ff", true}, {"\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6", 877868829524179879L, "\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c", -1788378219, "\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6", false, "\uef08\uef2d\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e", false, "\uf626\uf64b\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b", false, "\ue544\ue569\ue58e\ue5b3\ue5d8\ue5fd\ue622\ue647\ue66c\ue691", false}, {"\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490", 877868829524245416L, "\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442", 656300074, "\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38", true, "\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259", true, "\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3", true, "\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d", true}, {"\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600", 877868829524310953L, "\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a", 2041975107, "\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2", false, "\uf10a\uf12f\uf154\uf179\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f", false, "\ue028\ue04d\ue072\ue097\ue0bc\ue0e1\ue106\ue12b\ue150\ue175", false, "\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893", false}, {"\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726", 877868829524376490L, "\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c", -1976684648, "\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d", true, "\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7", true, "\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251", true, "\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f", true}, {"\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e", 877868829524442027L, "\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6", -590945231, "\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63", false, "\uf30c\uf331\uf356\uf37b\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459", false, "\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377", false, "\ue948\ue96d\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29", false}, {"\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000", 877868829524507564L, "\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821", 1837022550, "\uecef\ued14\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab", true, "\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535", true, "\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453", true, "\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb", true}, {"\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba", 877868829524573101L, "\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947", -1089373201, "\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3\uef18\uef3d", false, "\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b", false, "\ue42c\ue451\ue476\ue49b\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d", false, "\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72", false}, {"\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305", 877868829524638638L, "\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f", -242667516, "\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019", true, "\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737", true, "\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f", true, "\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c", true}, {"\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b", 877868829524704175L, "\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21", 35768669, "\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f", false, "\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1", false, "\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756", false, "\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77\uef9c", false}, {"\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473", 877868829524769712L, "\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd", 1423542258, "\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b", true, "\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183", true, "\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910", true, "\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2", true}, {"\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505", 877868829524835249L, "\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23", -445621237, "\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5", false, "\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a", false, "\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80", false, "\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a", false}, {"\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1", 877868829524900786L, "\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff", 937958048, "\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467", true, "\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4", true, "\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6", true, "\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c", true}};
        byte[] v0 = "A\rZ \u00fa\u008a\u00ca\u0091\u0082\u00e6\u0007\u00f1\"\u00c8<\u00a3\u008cc\u00db\u00b5\u00ecf\u000e,\u0014\u008d\\k\u0012\u0095\u00980\u00880\u009dG\u00e4\u000e]\r-^\u008eS\u00b7\u008c\u0095\u00f2\u00ca\u00a9\u00d1\u00f4A\u00ce6\u0093\u00ed\u0018z\u0003\u0084\u00ce\u0091&#K\u0016%\u0018\u00c4\u00c0\u00bc\u0090\u009b9\u00dd\u00a4\u0002\u0097\u00ae\u0089\u00d3\u00d7\u00e2\u00b7\u00ab\u00ca\u0094\u001a\u0080\u00fby\u00d5o5r6\u00b6\u00d6a\u00fb\u00ce\u00f1\u001f\u008b#\u00c4\nZ\u00bd\u00e6k \u00dc\u00fd\u00e2\u00f4\u00bfJ\u0094V\u00ea\u00b8Kil\u00e0\u00a4\nD\u00f3\u00ed/\u00a44Xg\u00c1\u00afdWD\u00854.\u00ab\u008e\\\u00ca\u00ec\u00160{#\u00a2\u00d7Q\u00b6\u00c7\u00f4\u0003\n\u00a83<\u00a5\u0081o\u00c0\u00ddLX\u0015#\u0082Qf\u00e4\u0018#y^}\u00ad\u0016\u00b6\u0018P\u00f073\u00abPd\u009d\u00cb\u001b\u00d7\u0080\u00a4\u0011n\u001b\u00ba\u0014\u00ee\u00e4\u00ab\u00cc\u00c1\u0094\u00c5\u00bf\u00c2\u00a4\u0006zm\u00a8\u00fa\u00d9\u00c4\u00d7\u00b7\u007f\u0016\u00900\u00d0\u00f0\u00dc\u00a9\u00fd@\u00b7\u00ee\u00f9|\u00e4dr^\u00a0\\\u009d\u0010\u0011\u0017*\u00ba\u0083\u00be\u00cb\u0090M\u00be\u00d4\u0087\u00ca\u00ff\u00e6\u000f\u00c5X\u00f2\r\u00f9\u000f\u0016q\r\u00b1\u00f0\u00b6\u00b4I\u00fb;|\u00c6\u00eaQ:\u0000\u0000\u00c1\u0018\u0001\u008c4<\u00ba\u00f7\u0001Y\u0083(\u008c\u0012,X\u00f4\u0001\u00f2\u00c5\u00b2\u008e\u0095\u009a\u0005\u008b\u0007g[\u00d1\u000e\u0081\u00a2Z\u0094\u00fe\"|%G\b\u001d\u001d\u0089\u00bb\u00d3\u001b\u0082\u00ccNJ\u0091m\u00bd,\u0007\u0006\txi\u008b\u00ce6\u009ff\u0091E\u00dfD\u0087\u009f}\u00ae\u0080\u0091".getBytes("ISO_8859_1");
        Object[] v1 = "@\u0007A\u009a'<b(".getBytes("ISO_8859_1");
        int v2 = 0;
        int v3 = v0.length;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 785996890;
                case 1 -> 318330914;
                case 2 -> 1022398043;
                case 3 -> 1613812465;
                case 4 -> 1745831761;
                case 5 -> 2028451432;
                case 6 -> 1483214563;
                case 7 -> 278298323;
                case 8 -> -306680687;
                case 9 -> -1000954281;
                case 10 -> 1638608913;
                case 11 -> -103164864;
                case 12 -> 1064907182;
                case 13 -> -1037937119;
                case 14 -> -1733650679;
                case 15 -> 936859807;
                case 16 -> 551375828;
                case 17 -> 665318455;
                case 18 -> 27278480;
                case 19 -> -422548025;
                case 20 -> -1429436041;
                case 21 -> -1280324763;
                case 22 -> 866511049;
                case 23 -> -902311831;
                case 24 -> -1960801129;
                case 25 -> 851076870;
                case 26 -> 1497754198;
                case 27 -> -1387964031;
                case 28 -> 1123953746;
                case 29 -> -696990284;
                case 30 -> -988552290;
                case 31 -> 2094963139;
                case 32 -> -1533530321;
                case 33 -> -1177301765;
                case 34 -> -1560119275;
                case 35 -> -753386054;
                case 36 -> 874258480;
                case 37 -> 1285002037;
                case 38 -> -251249811;
                case 39 -> -1838261191;
                case 40 -> 49699524;
                case 41 -> 771441506;
                case 42 -> 98906391;
                case 43 -> 1880103257;
                case 44 -> 1369170394;
                case 45 -> 794724769;
                case 46 -> 924165245;
                case 47 -> -1149423403;
                case 48 -> -1075976899;
                case 49 -> -1996362476;
                case 50 -> 1300645912;
                case 51 -> 75127402;
                case 52 -> 800324683;
                case 53 -> -54558624;
                case 54 -> 1213519090;
                case 55 -> 1363914968;
                case 56 -> 665283077;
                case 57 -> -1187137595;
                case 58 -> -1156085596;
                case 59 -> -1536005506;
                case 60 -> 2044396941;
                case 61 -> 1404200150;
                case 62 -> -424584045;
                case 63 -> 2099092114;
                case 64 -> 273717667;
                case 65 -> 1797793846;
                case 66 -> 1995424865;
                case 67 -> -1907106623;
                case 68 -> -406467504;
                case 69 -> 1318636333;
                case 70 -> -1079229717;
                case 71 -> 148241962;
                case 72 -> -1248861215;
                case 73 -> -481080411;
                case 74 -> 152775962;
                case 75 -> -786881022;
                case 76 -> 1132393971;
                case 77 -> -1555257211;
                case 78 -> 1200913083;
                case 79 -> -944177021;
                case 80 -> -599364744;
                case 81 -> -1218010566;
                case 82 -> -960863659;
                case 83 -> -1113004131;
                case 84 -> -328085426;
                case 85 -> 1353188305;
                case 86 -> 1437410827;
                case 87 -> -1066063754;
                case 88 -> 1288327954;
                case 89 -> -1726601447;
                case 90 -> 1362781099;
                case 91 -> 2085863934;
                case 92 -> 612534908;
                case 93 -> 160942346;
                case 94 -> 619292722;
                case 95 -> -2083110085;
                case 96 -> 1757628979;
                case 97 -> 306537870;
                case 98 -> 464471781;
                case 99 -> 1174716216;
                case 100 -> 1032694407;
                case 101 -> -1106533449;
                case 102 -> 1747552069;
                case 103 -> 1707332356;
                case 104 -> -1097630499;
                case 105 -> 97032827;
                case 106 -> 1776010685;
                case 107 -> 1860588033;
                case 108 -> 1860756430;
                case 109 -> -1705711116;
                case 110 -> 1411259611;
                case 111 -> -1603464999;
                case 112 -> 25608547;
                case 113 -> 74837511;
                case 114 -> 1672451750;
                case 115 -> -1501702928;
                case 116 -> -1279316643;
                case 117 -> -1782146263;
                case 118 -> -599515804;
                case 119 -> -1010534640;
                case 120 -> -1153292376;
                case 121 -> 175682339;
                case 122 -> -1488546221;
                case 123 -> -1887459403;
                case 124 -> -1805501747;
                case 125 -> 833121738;
                case 126 -> -476387687;
                case 127 -> 900525816;
                case 128 -> 1613613385;
                case 129 -> 85508343;
                case 130 -> 984794662;
                case 131 -> 400414940;
                case 132 -> 636169757;
                case 133 -> 1506731437;
                case 134 -> -855399094;
                case 135 -> -243634581;
                case 136 -> 768799138;
                case 137 -> -1788359209;
                case 138 -> -568651832;
                case 139 -> -942450865;
                case 140 -> -591089092;
                case 141 -> 1886030069;
                case 142 -> -1435352506;
                case 143 -> 665341132;
                case 144 -> 1600689992;
                case 145 -> -528027618;
                case 146 -> -2047285482;
                case 147 -> -1796356594;
                case 148 -> 133714545;
                case 149 -> 1860178696;
                case 150 -> 1163537726;
                case 151 -> -655948734;
                case 152 -> -771220196;
                case 153 -> -495575653;
                case 154 -> 880718335;
                case 155 -> -1537749984;
                case 156 -> -329701126;
                case 157 -> -1380200849;
                case 158 -> 1577117455;
                case 159 -> 165910688;
                case 160 -> 658796263;
                case 161 -> -1533035878;
                case 162 -> -2140078455;
                case 163 -> -840565326;
                case 164 -> 2145771604;
                case 165 -> 1444012068;
                case 166 -> -895456629;
                case 167 -> -1217755445;
                case 168 -> -769826376;
                case 169 -> -309180596;
                case 170 -> -688090218;
                case 171 -> -1616357380;
                case 172 -> -1224998617;
                case 173 -> -1226980465;
                case 174 -> -1836886170;
                case 175 -> 1153975775;
                case 176 -> 1065971524;
                case 177 -> 2073693678;
                case 178 -> -313308551;
                case 179 -> 402802352;
                case 180 -> 775327919;
                case 181 -> -1187857184;
                case 182 -> -1132134616;
                case 183 -> -1198958922;
                case 184 -> 2031074029;
                case 185 -> -1607669646;
                case 186 -> -434522371;
                case 187 -> 1250639708;
                case 188 -> -1122894720;
                case 189 -> 1984916716;
                case 190 -> 1268723743;
                case 191 -> -1107565360;
                case 192 -> 892102452;
                case 193 -> 509221508;
                case 194 -> 1710202480;
                case 195 -> -1439045025;
                case 196 -> 649026806;
                case 197 -> -2098830167;
                case 198 -> -814753676;
                case 199 -> 202700331;
                case 200 -> 1182350564;
                case 201 -> -2102383238;
                case 202 -> 832392834;
                case 203 -> -1046752139;
                case 204 -> -1353645858;
                case 205 -> -617751098;
                case 206 -> 31488660;
                case 207 -> -2070204925;
                case 208 -> -1076584002;
                case 209 -> -951391667;
                case 210 -> -139482624;
                case 211 -> -1206141140;
                case 212 -> -697676217;
                case 213 -> 2072537612;
                case 214 -> 643395516;
                case 215 -> 414784302;
                case 216 -> -251601454;
                case 217 -> -84189758;
                case 218 -> -1769137256;
                case 219 -> 563640383;
                case 220 -> -698552135;
                case 221 -> -1713845370;
                case 222 -> 1110112648;
                case 223 -> 1113135117;
                case 224 -> -1804225243;
                case 225 -> -826546109;
                case 226 -> -2024977457;
                case 227 -> 1003371697;
                case 228 -> -734178789;
                case 229 -> 601016447;
                case 230 -> -787077639;
                case 231 -> -1410548461;
                case 232 -> 610159295;
                case 233 -> 1625451431;
                case 234 -> 350073065;
                case 235 -> -346770088;
                case 236 -> -617057110;
                case 237 -> -1629807444;
                case 238 -> 1277132396;
                case 239 -> 1921114088;
                case 240 -> 1375557735;
                case 241 -> 1505916053;
                case 242 -> -1371741647;
                case 243 -> -2144107638;
                case 244 -> -663419508;
                case 245 -> -968330257;
                case 246 -> -1273655949;
                case 247 -> 1212622016;
                case 248 -> 133281506;
                case 249 -> 1907459934;
                case 250 -> -237581458;
                case 251 -> -2008068429;
                case 252 -> -846605594;
                case 253 -> 1293383068;
                case 254 -> 1416966634;
                case 255 -> -1612571327;
                default -> 890580521;
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
            Object[] objectArray = new Object[22];
            v1 = objectArray;
            iOoi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iOOI = 0.0035f;
        iOOo = 30.0f;
        iOO0 = 12;
        iOOO = 4;
        Iiii = 2;
        IiiI = 3;
        Iiio = 40;
        Iii0 = -40;
        IiiO = 24;
        IiIi = -32;
        IiII = -8;
        IiIo = -52;
        IiI0 = 3;
        IiIO = 2;
        Iioi = 1;
        iOoI = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    }

    private Color IoI(Color param1, int param2) {
        return new Color(param1.getRed(), param1.getGreen(), param1.getBlue(), Math.max(0, Math.min(255, param2)));
    }

    private boolean OoO00(RenderSupport_O0I0 param1) {
        return switch (param1.PacketEvent) {
            case 1 -> {
                if (param1.GuiSupport_OOI >= 4) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (param1.GuiSupport_OOI >= 3) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (param1.GuiSupport_OOI >= 2) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        RenderSupport_O0I0 v132;
        RenderSupport_O0I0 v112;
        if (StructureFinderModule.iooI() || this.iO0o.isEmpty()) {
            return;
        }
        MatrixStack.Entry v2 = param1.0ii().peek();
        Camera v3 = StructureFinderModule.ConfigSupport_OI0.gameRenderer.getCamera();
        Vec3d v4 = v3.method_71156();
        Vec3d v5 = this.oiIo(v3);
        Vec3d v6 = StructureFinderModule.ConfigSupport_OI0.player.method_73189();
        double v7 = (double)((Integer)this.ioO.HelpCommand()).intValue() * (double)((Integer)this.ioO.HelpCommand()).intValue();
        ArrayList<RenderSupport_O0I0> v9 = new ArrayList<RenderSupport_O0I0>();
        for (RenderSupport_O0I0 v112 : this.iO0o) {
            if (v112.HudElement || !this.OoOoo(v112.PacketEvent) || !this.OoO00(v112) || this.OoOIO(v112.PacketEvent(), v6) > v7) continue;
            v9.add(v112);
        }
        v9.sort(Comparator.comparingDouble(param2 -> this.OoOIO(param2.PacketEvent(), v6)));
        boolean v10 = false;
        v112 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        for (RenderSupport_O0I0 v132 : v9) {
            Color v14 = this.IoI(v132.OOo, (Integer)this.ioi.HelpCommand());
            GuiSupport_oi0o_0.OOIi0((BufferBuilder)v112, v2, v132.HelpCommand, v14.getRGB(), 30.0f);
            v10 = true;
        }
        if (v10) {
            try {
                RenderSupport_oiii_5.PacketEvent().draw(v112.end());
            }
            catch (IllegalStateException v12) {
                // empty catch block
            }
        }
        if (!((Boolean)this.0oOI.HelpCommand()).booleanValue()) {
            return;
        }
        boolean v12 = false;
        v132 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        for (RenderSupport_O0I0 v15 : v9) {
            Color v16 = this.IoI(v15.OOo, (Integer)this.ioi.HelpCommand());
            Vec3d v17 = v15.PacketEvent();
            Vec3d v18 = v17.subtract(v4);
            if (v18.subtract(v5).lengthSquared() < 1.0E-6) continue;
            v12 |= this.oiII((BufferBuilder)v132, v2, v5, v18, v16.getRGB(), this.oiI0());
        }
        if (v12) {
            try {
                RenderSupport_oiii_5.PacketEvent().draw(v132.end());
            }
            catch (IllegalStateException v14) {
                // empty catch block
            }
        }
    }

    private Box OoOO0(World param1, BlockPos param2, Set param3) {
        ArrayDeque<BlockPos> v4 = new ArrayDeque<BlockPos>();
        v4.add(param2);
        param3.add(param2.asLong());
        int v5 = param2.method_10263();
        int v6 = param2.method_10264();
        int v7 = param2.method_10260();
        int v8 = param2.method_10263();
        int v9 = param2.method_10264();
        int v10 = param2.method_10260();
        while (!v4.isEmpty()) {
            BlockPos v11 = (BlockPos)v4.poll();
            v5 = Math.min(v5, v11.method_10263());
            v6 = Math.min(v6, v11.method_10264());
            v7 = Math.min(v7, v11.method_10260());
            v8 = Math.max(v8, v11.method_10263());
            v9 = Math.max(v9, v11.method_10264());
            v10 = Math.max(v10, v11.method_10260());
            for (int[] v15 : iOoI) {
                BlockPos v16 = v11.add(v15[0], 0, v15[1]);
                long v17 = v16.asLong();
                if (param3.contains(v17) || param1.method_8320(v16).method_26204() != Blocks.END_PORTAL_FRAME) continue;
                param3.add(v17);
                v4.add(v16);
            }
        }
        return new Box((double)v5, (double)v6, (double)v7, (double)v8 + 1.0, (double)v9 + 1.0, (double)v10 + 1.0).expand(0.1);
    }

    private boolean OoO0o(Block param1) {
        return param1 == Blocks.COPPER_BULB || param1 == Blocks.OXIDIZED_COPPER_BULB || param1 == Blocks.CHISELED_TUFF || param1 == Blocks.CHISELED_TUFF_BRICKS || param1 == Blocks.TUFF_BRICKS || param1 == Blocks.POLISHED_TUFF || param1 == Blocks.TRIAL_SPAWNER || param1 == Blocks.VAULT;
    }

    public StructureFinderModule() {
        super("StructureFinder", "Highlights Ancient City / Trial Chamber / End Portal as whole structure boxes.", ModuleCategory.i0i);
        this.0oOI = this.OOi00("Tracers", true);
        this.ioi = this.OOi0o("Alpha", 210, 40, 255);
        this.NoHurtCamModule = this.OOi0o("TagScale", 1.0, 0.5, 3.0);
        this.iOOi = this.OOi00("AncientCity", true);
        this.iO0O = this.OOi00("TrialChamber", true);
        this.iO00 = this.OOi00("EndPortal", true);
        this.iO0o = new CopyOnWriteArrayList();
        this.iO0I = new HashSet();
        this.iO0i = new HashMap();
        this.iOoO = new HashMap();
        this.iOo0 = new HashMap();
    }

    private boolean OoOoO(World param1, BlockPos param2) {
        ChunkPos v3 = new ChunkPos(param2);
        long v4 = (long)v3.x << 32 ^ (long)v3.z & 0xFFFFFFFFL;
        Boolean v6 = (Boolean)this.iOo0.get(v4);
        if (v6 != null) {
            return v6;
        }
        int v7 = 40;
        int v8 = v7 + 15 >> 4;
        int v9 = v7 * v7;
        for (int v10 = v3.x - v8; v10 <= v3.x + v8; ++v10) {
            for (int v11 = v3.z - v8; v11 <= v3.z + v8; ++v11) {
                WorldChunk v12 = param1.method_8398().getWorldChunk(v10, v11, false);
                if (v12 == null) continue;
                for (BlockPos v14 : v12.method_12021()) {
                    double v20;
                    double v18;
                    double v16;
                    Block v15 = param1.method_8320(v14).method_26204();
                    if (v15 != Blocks.TRIAL_SPAWNER && v15 != Blocks.VAULT || !((v16 = (double)(v14.method_10263() - param2.method_10263())) * v16 + (v18 = (double)(v14.method_10264() - param2.method_10264())) * v18 + (v20 = (double)(v14.method_10260() - param2.method_10260())) * v20 <= (double)v9)) continue;
                    this.iOo0.put(v4, true);
                    return true;
                }
            }
        }
        this.iOo0.put(v4, false);
        return false;
    }

    private double OoO0O(int param1) {
        return switch (param1) {
            case 1 -> 110.0;
            case 2 -> 90.0;
            case 3 -> 90.0;
            default -> 80.0;
        };
    }

    private boolean NetworkSupport_OO00() {
        if (ConfigSupport_OI0.getLanguageManager() == null) {
            return false;
        }
        String v1 = ConfigSupport_OI0.getLanguageManager().getLanguage();
        return v1 != null && v1.toLowerCase().startsWith("zh");
    }

    @Override
    public void DataRecord_OO0O(ScaledDrawContext param1) {
        if (StructureFinderModule.iooI() || this.iO0o.isEmpty()) {
            return;
        }
        FontRenderer v2 = NetworkSupport_00OI.HudElement(18);
        int v3 = Math.max(1, v2.OOi());
        float v4 = ((Double)this.NoHurtCamModule.HelpCommand()).floatValue() * 0.5f;
        boolean v5 = this.NetworkSupport_OO00();
        Vec3d v6 = StructureFinderModule.ConfigSupport_OI0.player.method_33571();
        double v7 = (double)((Integer)this.ioO.HelpCommand()).intValue() * (double)((Integer)this.ioO.HelpCommand()).intValue();
        for (RenderSupport_O0I0 v10 : this.iO0o) {
            float v21;
            int v18;
            Vec3d v11;
            Vector3f v12;
            if (v10.HudElement || !this.OoOoo(v10.PacketEvent) || !this.OoO00(v10) || this.OoOIO(v10.PacketEvent(), StructureFinderModule.ConfigSupport_OI0.player.method_73189()) > v7 || (v12 = RenderSupport_oiio_4.O0OII(v11 = new Vec3d(v10.PacketEvent().x, v10.HelpCommand.maxY + 0.3, v10.PacketEvent().z))) == null) continue;
            double v13 = v6.distanceTo(v10.PacketEvent());
            String v15 = this.OoOoI(v10.PacketEvent, v5);
            String v16 = String.format(" [%.0fm]", v13);
            int v17 = v2.GuiSupport_OOI(v15);
            float v19 = v17 + (v18 = v2.GuiSupport_OOI(v16));
            float v20 = v19 * v4;
            if (ClickGuiScreen.EventBusApi(v12.x - v20 / 2.0f, v12.y - (v21 = (float)v3 * v4) / 2.0f, v20, v21)) continue;
            Matrix3x2fStack v22 = param1.ConfigSupport_O0I().getMatrices();
            v22.pushMatrix();
            v22.translate(v12.x, v12.y);
            v22.scale(v4, v4);
            float v23 = -v19 / 2.0f;
            float v24 = (float)(-v3) / 2.0f;
            v2.PacketEvent(param1.ConfigSupport_O0I(), v15, v23, v24, v10.OOo.getRGB());
            v2.PacketEvent(param1.ConfigSupport_O0I(), v16, v23 + (float)v17, v24, -1);
            v22.popMatrix();
        }
    }

    private double OoOIO(Vec3d param1, Vec3d param2) {
        double v3 = param1.x - param2.x;
        double v5 = param1.y - param2.y;
        double v7 = param1.z - param2.z;
        return v3 * v3 + v5 * v5 + v7 * v7;
    }
}

