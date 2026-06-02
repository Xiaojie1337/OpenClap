/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.FireBlock
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package clap.module.player;

import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import clap.mixin.KeyBindingAccessor;
import clap.config.ConfigSupport_O0IO;
import clap.core.module.Module;
import clap.model.DataRecord_0oo0_0;
import clap.config.ConfigSupport_0ooo_3;
import clap.model.EnumType_iii_0;
import clap.setting.Setting;
import clap.config.ConfigSupport_oiio_2;
import clap.core.module.ModuleCategory;
import clap.model.EnumType_ooio_0;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.ooI
 */
public class ExtinguisherModule
extends Module {
    private final Setting O0Ii;
    private float DataRecord_OOI0;
    private float Manager;
    private float EventHandler;
    private boolean O0ii;
    private EnumType_ooio_0 RenderSupport_oooo_2;
    private float OOoi;
    private int NetworkSupport_OO00;
    private boolean XrayModule;
    private Vec3d OoOo;
    private float OOoo;
    private int O0i0;
    private BlockPos OOOi;
    private int ConfigSupport_oooi_3 = -1;
    private final Setting ioO;
    private int CriticalsModule;
    private boolean OOoO;
    private static final int RenderSupport_O0I0;
    private BlockHitResult OoO0;
    private int DataRecord_OO0O;
    private int NetworkSupport_o0o_0 = -1;
    private final Setting O0Io = this.OOi00("BlockLava", true);
    private static final double ConfigSupport_O0IO;
    private final Setting KeepSprintModule;
    private float OOoI;
    private int O0iO;
    private final Setting iii;
    private boolean FontRenderer;
    private final Setting EnumType_O0II = this.OOi00("BreakFire", true);
    static Object OoOi;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    @Override
    public void 0oI() {
        0ooo.oII().0Oo(this);
        this.SettingContainer();
    }

    private BlockHitResult Oo0O(Vec3d param1, RaycastContext.FluidHandling param2) {
        float[] v3 = this.ScaledDrawContext(param1);
        return this.PacketSendEvent(v3[0], v3[1], (Double)this.ioO.HelpCommand(), param2);
    }

    private int HudEditorScreen() {
        Vec3d v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_18798();
        return Math.max(1, (int)Math.ceil(Math.max(Math.abs(v1.x), Math.abs(v1.z))));
    }

    private BlockPos 0OoI() {
        int v1 = (int)Math.ceil((Double)this.ioO.HelpCommand());
        BlockPos v2 = ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        return BlockPos.stream((BlockPos)v2.add(-v1, -v1, -v1), (BlockPos)v2.add(v1, v1, v1)).map(BlockPos::toImmutable).filter(param0 -> ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param0).method_26204() instanceof FireBlock).filter(param1 -> ExtinguisherModule.ConfigSupport_OI0.player.method_33571().distanceTo(Vec3d.ofBottomCenter((Vec3i)param1)) <= (Double)this.ioO.HelpCommand()).filter(param1 -> this.Oo0O(Vec3d.ofBottomCenter((Vec3i)param1), RaycastContext.FluidHandling.NONE).getBlockPos().equals(param1)).min(Comparator.comparingDouble(param0 -> ExtinguisherModule.ConfigSupport_OI0.player.method_5707(Vec3d.ofCenter((Vec3i)param0)))).orElse(null);
    }

    private int Ooo0(Item param1) {
        for (int v2 = 0; v2 < 9; ++v2) {
            if (!ExtinguisherModule.ConfigSupport_OI0.player.method_31548().method_5438(v2).isOf(param1)) continue;
            return v2;
        }
        return -1;
    }

    private boolean ConfigSupport_0O0O() {
        BlockPos v1 = this.0OoI();
        if (v1 == null) {
            return false;
        }
        Vec3d v2 = Vec3d.ofBottomCenter((Vec3i)v1);
        this.0OIi(EnumType_ooio_0.FastWebModule, new BlockHitResult(v2, Direction.UP, v1, false), v2, -1);
        return true;
    }

    private void 0OIi(EnumType_ooio_0 param1, BlockHitResult param2, Vec3d param3, int param4) {
        this.RenderSupport_oooo_2 = param1;
        this.OoO0 = param2;
        this.OoOo = param3;
        this.ConfigSupport_oooi_3 = param4;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        this.OoO0(param3);
    }

    private boolean O0Ii(BlockPos param1) {
        FluidState v2 = ExtinguisherModule.ConfigSupport_OI0.world.method_8316(param1);
        return v2.isIn(FluidTags.WATER) && v2.isStill();
    }

    private boolean TranslateCommand() {
        return this.RenderSupport_oooo_2 == EnumType_ooio_0.0iI || this.RenderSupport_oooo_2 == EnumType_ooio_0.0ii;
    }

    private void DataRecord_00OO() {
        if (this.OoO0 == null || !ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.WATER_BUCKET)) {
            this.ConfigSupport_00I0();
            return;
        }
        if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8320(this.OoO0.getBlockPos()).method_26206((BlockView)ExtinguisherModule.ConfigSupport_OI0.world, this.OoO0.getBlockPos(), this.OoO0.getSide())) {
            this.ConfigSupport_00I0();
            return;
        }
        ActionResult v1 = this.NetworkSupport_000O(this.OoO0);
        if (v1.isAccepted()) {
            ExtinguisherModule.ConfigSupport_OI0.player.method_6104(Hand.MAIN_HAND);
            this.XrayModule = true;
            this.OOOi = this.OoO0.getBlockPos().offset(this.OoO0.getSide());
            this.O0iO = 0;
            this.00Io(false);
            this.FontRenderer = true;
            return;
        }
        this.ConfigSupport_00I0();
    }

    private void 00oo() {
        if (!this.O0ii) {
            return;
        }
        if (this.O0i0 > 0) {
            --this.O0i0;
            return;
        }
        this.DataRecord_I0O();
    }

    private ActionResult NetworkSupport_000O(BlockHitResult param1) {
        return this.EnumType_0000(param1, Hand.MAIN_HAND);
    }

    private BlockPos 0Ooo() {
        int v1 = (int)Math.ceil((Double)this.ioO.HelpCommand());
        BlockPos v2 = ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        return BlockPos.stream((BlockPos)v2.add(-v1, -v1, -v1), (BlockPos)v2.add(v1, v1, v1)).map(BlockPos::toImmutable).filter(param1 -> ExtinguisherModule.ConfigSupport_OI0.player.method_33571().distanceTo(Vec3d.ofCenter((Vec3i)param1)) <= (Double)this.ioO.HelpCommand()).filter(param1 -> !this.0OIo((BlockPos)param1)).min(Comparator.comparingDouble(param0 -> ExtinguisherModule.ConfigSupport_OI0.player.method_5707(Vec3d.ofCenter((Vec3i)param0)))).orElse(null);
    }

    @Override
    public void SpawnerFinderModule() {
    }

    private void 0OiI() {
        if (ExtinguisherModule.iooI() || ExtinguisherModule.ConfigSupport_OI0.interactionManager == null || ExtinguisherModule.ConfigSupport_OI0.currentScreen != null || ExtinguisherModule.ConfigSupport_OI0.player.method_68878()) {
            return;
        }
        if (this.RenderSupport_oooo_2 != EnumType_ooio_0.0iI && this.RenderSupport_oooo_2 != EnumType_ooio_0.0ii) {
            return;
        }
        if (this.OoOo == null) {
            this.ConfigSupport_00I0();
            return;
        }
        if (this.DataRecord_OO0O < 2) {
            return;
        }
        if (this.CriticalsModule > 0) {
            return;
        }
        if (this.RenderSupport_oooo_2 == EnumType_ooio_0.0iI && !ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.WATER_BUCKET)) {
            this.ConfigSupport_00I0();
            return;
        }
        if (this.RenderSupport_oooo_2 == EnumType_ooio_0.0ii && !ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.BUCKET)) {
            this.ConfigSupport_00I0();
            return;
        }
        this.Oo0i();
        this.OooO();
        ExtinguisherModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        KeyBindingAccessor v1 = (KeyBindingAccessor)ExtinguisherModule.ConfigSupport_OI0.options.useKey;
        v1.clap$setClickCount(v1.clap$getClickCount() + 1);
        this.CriticalsModule = 1;
    }

    private void OoO0(Vec3d param1) {
        float[] v2 = this.ScaledDrawContext(param1);
        this.Manager = v2[0];
        this.DataRecord_OOI0 = v2[1];
        0ooo.oIi().HelpCommand(this, this.Manager, this.DataRecord_OOI0, ((Integer)this.iii.HelpCommand()).intValue());
    }

    private void ClickGuiScreenV2() {
        if (this.RenderSupport_oooo_2 == null || this.OoOo == null) {
            return;
        }
        if ((this.RenderSupport_oooo_2 == EnumType_ooio_0.oOO || this.RenderSupport_oooo_2 == EnumType_ooio_0.FastWebModule) && this.NetworkSupport_OO00 < 1) {
            return;
        }
        if (this.ConfigSupport_oooi_3 != -1) {
            this.Oooo(this.ConfigSupport_oooi_3);
        }
        switch (this.RenderSupport_oooo_2.ordinal()) {
            case 0: {
                this.DataRecord_00OO();
                break;
            }
            case 1: {
                this.ConfigSupport_00O0();
                break;
            }
            case 2: {
                this.00Oo();
                break;
            }
            case 3: {
                this.00Oi();
            }
        }
    }

    private DataRecord_0oo0_0 0OoO(BlockPos param1) {
        boolean v5;
        if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1).method_26206((BlockView)ExtinguisherModule.ConfigSupport_OI0.world, param1, Direction.UP)) {
            return null;
        }
        Vec3d v2 = new Vec3d((double)param1.method_10263() + 0.5, (double)param1.method_10264() + 1.0, (double)param1.method_10260() + 0.5);
        BlockHitResult v3 = this.Oo0O(v2, RaycastContext.FluidHandling.NONE);
        boolean v4 = v3.method_17783() == HitResult.Type.BLOCK && v3.getBlockPos().equals((Object)param1) && v3.getSide() == Direction.UP;
        boolean bl = v5 = v3.method_17783() == HitResult.Type.BLOCK && v3.getBlockPos().equals((Object)param1.up()) && ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1.up()).method_26204() instanceof FireBlock;
        if (!v4 && !v5) {
            return null;
        }
        BlockHitResult v6 = new BlockHitResult(v2, Direction.UP, param1, false);
        return new DataRecord_0oo0_0(v6, v2);
    }

    private Hand BindCommand() {
        if (this.ConfigSupport_oooi_3 == -2) {
            return ExtinguisherModule.ConfigSupport_OI0.player.method_6079().getItem() instanceof BlockItem ? Hand.OFF_HAND : null;
        }
        return ExtinguisherModule.ConfigSupport_OI0.player.method_6047().getItem() instanceof BlockItem ? Hand.MAIN_HAND : null;
    }

    public ExtinguisherModule() {
        super("Extinguisher", "Puts out fire and covers lava around you.", ModuleCategory.ioo);
        this.O0Ii = this.OOi00("AntiBurn", true);
        this.KeepSprintModule = this.OOi00("SwapBack", true);
        this.ioO = this.OOi0o("Range", 4.5, 2.0, 6.0);
        this.iii = this.OOi0o("RotateSpeed", 180, 20, 180);
    }

    private BlockHitResult NetworkSupport_00OI() {
        if (this.OoO0 == null || this.OoOo == null || 0ooo.RenderSupport_oio_2() == null || !0ooo.oi0().ConfigSupport_0OO(this)) {
            return null;
        }
        BlockPos v1 = this.OoO0.getBlockPos();
        Direction v2 = this.OoO0.getSide();
        if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8316(v1).isEmpty()) {
            return null;
        }
        if (ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v1).method_26215()) {
            return null;
        }
        if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v1).method_26206((BlockView)ExtinguisherModule.ConfigSupport_OI0.world, v1, v2)) {
            return null;
        }
        if (ExtinguisherModule.ConfigSupport_OI0.player.method_33571().distanceTo(this.OoOo) > ExtinguisherModule.ConfigSupport_OI0.player.method_55754()) {
            return null;
        }
        BlockHitResult v3 = this.PacketSendEvent(0ooo.oio().ConfigSupport_OI0(), 0ooo.oiI().OIo(), ExtinguisherModule.ConfigSupport_OI0.player.method_55754(), RaycastContext.FluidHandling.NONE);
        if (v3.method_17783() != HitResult.Type.BLOCK) {
            return null;
        }
        if (!v3.getBlockPos().equals((Object)v1) || v3.getSide() != v2) {
            return null;
        }
        return v3;
    }

    private BlockPos ConfigSupport_O0IO() {
        if (this.OOOi != null && this.O0Ii(this.OOOi) && this.IrcManager(Vec3d.ofCenter((Vec3i)this.OOOi))) {
            return this.OOOi;
        }
        int v1 = (int)Math.ceil((Double)this.ioO.HelpCommand());
        BlockPos v2 = this.OOOi != null ? this.OOOi : ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        return BlockPos.stream((BlockPos)v2.add(-v1, -v1, -v1), (BlockPos)v2.add(v1, v1, v1)).map(BlockPos::toImmutable).filter(this::O0Ii).filter(param1 -> ExtinguisherModule.ConfigSupport_OI0.player.method_33571().distanceTo(Vec3d.ofCenter((Vec3i)param1)) <= (Double)this.ioO.HelpCommand()).filter(param1 -> {
            BlockHitResult v2 = this.Oo0O(Vec3d.ofCenter((Vec3i)param1), RaycastContext.FluidHandling.SOURCE_ONLY);
            return v2.method_17783() == HitResult.Type.BLOCK && v2.getBlockPos().equals(param1);
        }).min(Comparator.comparingDouble(param0 -> ExtinguisherModule.ConfigSupport_OI0.player.method_5707(Vec3d.ofCenter((Vec3i)param0)))).orElse(null);
    }

    private void 00Oi() {
        if (this.OoO0 == null) {
            this.ConfigSupport_00I0();
            return;
        }
        BlockHitResult v1 = this.PacketSendEvent(0ooo.oii().ConfigSupport_OI0(), 0ooo.WatermarkHudElement().OIo(), (Double)this.ioO.HelpCommand(), RaycastContext.FluidHandling.NONE);
        if (v1.method_17783() == HitResult.Type.BLOCK && v1.getBlockPos().equals((Object)this.OoO0.getBlockPos()) && ExtinguisherModule.ConfigSupport_OI0.interactionManager.attackBlock(this.OoO0.getBlockPos(), Direction.UP)) {
            ExtinguisherModule.ConfigSupport_OI0.player.method_6104(Hand.MAIN_HAND);
        }
        this.00Io(true);
    }

    private void 0OiO() {
        if (this.OoOo == null) {
            this.ConfigSupport_00I0();
            return;
        }
        this.OoO0(this.OoOo);
        int n = this.NetworkSupport_OO00 = this.OoOi() ? this.NetworkSupport_OO00 + 1 : 0;
        if (this.TranslateCommand() && this.ConfigSupport_oooi_3 != -1) {
            this.Oooo(this.ConfigSupport_oooi_3);
        }
        ++this.DataRecord_OO0O;
        if (this.DataRecord_OO0O > 8) {
            this.ConfigSupport_00I0();
        }
    }

    private int 00oi() {
        double v1 = Math.max(0.0, ExtinguisherModule.ConfigSupport_OI0.player.field_6017);
        double v3 = Math.abs(ExtinguisherModule.ConfigSupport_OI0.player.method_18798().y);
        return MathHelper.clamp((int)((int)Math.ceil(v1 + v3 * 2.0 + 1.0)), (int)2, (int)((int)Math.ceil((Double)this.ioO.HelpCommand())));
    }

    private int IrcModule() {
        double v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_18798().y;
        return Math.max(1, (int)Math.ceil(v1 * v1));
    }

    private void ConfigSupport_00I0() {
        ExtinguisherModule.ConfigSupport_OI0.options.useKey.setPressed(false);
        this.CriticalsModule = 0;
        this.OOoO = false;
        this.DataRecord_I0O();
        this.XrayModule = false;
        this.FontRenderer = false;
        this.OOOi = null;
        this.O0iO = 0;
        this.00Io(true);
        0ooo.ConfigSupport_IO0().0Oo(this);
    }

    private boolean IrcManager(Vec3d param1) {
        return ExtinguisherModule.ConfigSupport_OI0.player.method_33571().distanceTo(param1) <= (Double)this.ioO.HelpCommand();
    }

    private void SettingContainer() {
        this.NetworkSupport_o0o_0 = -1;
        this.XrayModule = false;
        this.O0ii = false;
        this.FontRenderer = false;
        this.OOOi = null;
        this.O0iO = 0;
        this.CriticalsModule = 0;
        this.O0i0 = 0;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        this.OOoO = false;
        this.00Io(false);
        this.Manager = 0.0f;
        this.DataRecord_OOI0 = 0.0f;
        this.OOoI = 0.0f;
        this.OOoi = 0.0f;
    }

    private int 000i() {
        if (ExtinguisherModule.ConfigSupport_OI0.player.method_6079().getItem() instanceof BlockItem) {
            return -2;
        }
        int v1 = -1;
        for (int v2 = 0; v2 < 9; ++v2) {
            ItemStack v3 = ExtinguisherModule.ConfigSupport_OI0.player.method_31548().method_5438(v2);
            if (v3.isEmpty() || !(v3.getItem() instanceof BlockItem)) continue;
            v1 = v2;
        }
        return v1;
    }

    static {
        __k__gH4it = ExtinguisherModule.__k__gH4it(1260399701467852305L);
        __rP__gH4it0 = new String[]{"\uc5c6\uedd2\u3301\u66ee\ue1bf\u4319\uad49\u318b\uc4c8\ueca8", "\uc5d6\uedc3\u3301\u6692\ue1bf\u431e\uad5c"};
        __rP__gH4it1 = new String[]{"\uc5d0\ueddd\u3302\u6687\ue1df\u437a\uad38\u3194\uc4cc\uecdb\u321a\u67f3\ue0a1\u4260\uae12\u32e7\uc780\uefc1\u31cf\u64ff", "\uc5d3\uedda\u3301\u6697\ue1b6"};
        __rP__gH4it2 = new String[]{"\uc5aa\uedf2\u33fb\u66b5\ue16a\u430e\uada0\u317b"};
        __rP__gH4it3 = new String[]{"\uc5a9\uede8\u32da\u6706\ue036\u42b4\uad99\u31b8\uc4f5\uec8d\u32e6\u6483\ue320\u41f0\uae6f\u3253\uc7d8\uef83\u31bf\u65b8\ue25e\u40a8\uaf2b\u339a\uc6ef\uee5a\u30f9\u6277\ue5a4\u476e\ua8c6\u34d8\uc17a\ue972\u377a\u6331\ue455\u46e4\ua9c0\u353a\uc040\ue803\u36d7\u6318\ue759\u45f4\uaa09\u3662\uc3fc\uebbc\u3537\u60c8\ue6bc\u4417\uab33\u37c7\uc24d\uea20\u348e\u6134\ue908\u4ba5\ua43d\u386d\ucdfd\ue544\u3b78\u6ebc\ue8b0\u4a01\ua55b\u39f0\uccdb\ue4af\u3a51\u6f40\ue85f\u4906\ua690\u3a2d\ucfbe\ue74d\u3993\u6c2d\ueb78\u48ce\ua76a\u3b24\ucea8\ue69b\u386e\u6d43\uea1f\u4f83\ua0bf\u3c9f\uc96f\ue18b\u3ff3\u6abd\uede1\u4eb7\ua1ad\u3d54\uc844\ue045\u3e5c\u6b08\uecb5\u4e12\ua225\u3ed9\ucbe7\ue3c8\u3da3\u687b\uefb4\u4d4c\ua312\u3fb1\ucab0\ue2c8\u3c10\u69c0\uee1b\u4c80\udc6e\u4062\ub552\u9d1b\u4349\u16ba\u915d\u3339\udd54\u4100\ub4d1\u9c18\u426f\u177e\u908a\u3226\udd7b\u42c9\ub7bb\u9f99\u4135\u141d\u93aa\u3183\ude54\u4349", "\uc5c4\uedd0\u3307\u66e8\ue1bd\u431b\uad57\u3195\uc4ca\uecaa", "\uc5c6\uedc7\u3318"};
        __p__gH4it = new String[]{"\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335", "\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f", "\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263", "\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39", "\uf0cc\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341", "\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf", "\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192", "\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2", "\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923", "\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7", "\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b", "\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d", "\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f", "\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2", "\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd", "\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90", "\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785", "\uf223\uf248\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370\uf395\uf3ba\uf3df", "\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733", "\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1", "\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9", "\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348", "\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac\ue6d1", "\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392", "\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740", "\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52", "\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693", "\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119", "\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7", "\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef", "\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c", "\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960", "\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a", "\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a", "\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403", "\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9", "\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9", "\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d", "\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c", "\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729", "\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d", "\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e", "\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363", "\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9", "\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b", "\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4", "\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7", "\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b", "\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db", "\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9", "\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3", "\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15", "\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009", "\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2", "\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816", "\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9", "\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782", "\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d", "\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033", "\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1", "\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657", "\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45", "\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762", "\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f", "\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0", "\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4", "\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b", "\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9", "\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d", "\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913", "\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555", "\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9", "\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b", "\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8", "\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503", "\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1", "\ue224\ue249\ue26e\ue293\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f", "\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726", "\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4", "\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b", "\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45", "\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4", "\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287", "\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9", "\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d", "\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c", "\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c", "\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99", "\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c", "\uf37b\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3", "\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e", "\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501", "\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f", "\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387", "\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f", "\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342"};
        __c__J7Um6 = new Object[][]{{"\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937", 1473051730131408421L, "\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2", 1334872119, "\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a", false, "\ue58e\ue5b3\ue5d8\ue5fd\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f\ue794\ue7b9", false, "\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7", false, "\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517", false}, {"\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16", 1473051730131473958L, "\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8", 32984720, "\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d", true, "\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801\ue826", true, "\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44", true, "\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3", true}, {"\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86", 1473051730131539495L, "\uf154\uf179\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee", -748747399, "\ue072\ue097\ue0bc\ue0e1\ue106\ue12b\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d", false, "\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb", false, "\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb", false, "\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf", false}, {"\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac", 1473051730131605032L, "\uf255\uf27a\uf29f\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411", -1532503102, "\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a", true, "\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28", true, "\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7", true, "\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0", true}, {"\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2", 1473051730131670569L, "\uf356\uf37b\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581", 1980732075, "\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f", false, "\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf", false, "\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3", false, "\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af", false}, {"\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5", 1473051730131736106L, "\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee", -946443916, "\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c", true, "\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb", true, "\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4", true, "\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f", true}, {"\uee3a\uee5f\uee84\ueea9\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065", 1473051730131801643L, "\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783", -1711394851, "\ue476\ue49b\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3", false, "\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97", false, "\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493", false, "\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3", false}, {"\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2", 1473051730131867180L, "\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0", 1799808678, "\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f", true, "\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98", true, "\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603", true, "\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2", true}, {"\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267", 1473051730131932717L, "\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7", 1018084623, "\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b", false, "\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77", false, "\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7", false, "\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8\ue5fd\ue622", false}, {"\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4", 1473051730131998254L, "\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183", -1909099544, "\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c", true, "\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7", true, "\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796", true, "\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748", true}, {"\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b", 1473051730132063791L, "\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f", 1604143793, "\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b", false, "\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b", false, "\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc\ue0e1\ue106", false, "\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e", false}, {"\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467", 1473051730132129328L, "\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360", 300220698, "\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb", true, "\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a", true, "\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c", true, "\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891", true}, {"\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543", 1473051730132194865L, "\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f", -481441821, "\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f", false, "\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0\uf3c5\uf3ea", false, "\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352", false, "\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc\uea01", false}, {"\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644", 1473051730132260402L, "\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af", -1261068724, "\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e", true, "\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510", true, "\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375", true, "\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e", true}, {"\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023", 1473051730132325939L, "\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663", 104617237, "\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece", false, "\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636", false, "\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0\ue4e5", false, "\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03", false}, {"\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193", 1473051730132391476L, "\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842", -679203842, "\ued7f\ueda4\uedc9\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4", true, "\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659", true, "\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552", true, "\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70", true}, {"\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147", 1473051730132457013L, "\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2", -1444093369, "\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a", false, "\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9", false, "\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7", false, "\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27", false}, {"\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326", 1473051730132522550L, "\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8", 2071247136, "\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d", true, "\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036", true, "\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754", true, "\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03", true}, {"\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496", 1473051730132588087L, "\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe", -858030199, "\uf082\uf0a7\uf0cc\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad", false, "\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb", false, "\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b", false, "\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf", false}, {"\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc", 1473051730132653624L, "\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21", -1641859502, "\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286\uf2ab\uf2d0\uf2f5\uf31a", true, "\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238", true, "\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7", true, "\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0", true}, {"\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2", 1473051730132719161L, "\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91", 1871383867, "\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af", false, "\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef", false, "\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3", false, "\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf", false}, {"\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705", 1473051730132784698L, "\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe", 554943364, "\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c", true, "\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb", true, "\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4", true, "\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f", true}, {"\ue64a\ue66f\ue694\ue6b9\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875", 1473051730132850235L, "\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93", -210003347, "\uf486\uf4ab\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3", false, "\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7", false, "\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3", false, "\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3", false}, {"\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2", 1473051730132915772L, "\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000", 1153585462, "\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af", true, "\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8", true, "\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13", true, "\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2", true}, {"\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77", 1473051730132981309L, "\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092\uf0b7", 371857311, "\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b", false, "\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787", false, "\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7", false, "\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632", false}, {"\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4", 1473051730133046846L, "\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149\uf16e\uf193", -407703944, "\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c", true, "\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7", true, "\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6", true, "\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758", true}, {"\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b", 1473051730133112383L, "\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f", -1189436223, "\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b", false, "\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab", false, "\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc\uf0f1\uf116", false, "\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e", false}, {"\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52\uec77", 1473051730133177920L, "\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370", 190938026, "\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db", true, "\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a", true, "\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c", true, "\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1", true}, {"\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53", 1473051730133243457L, "\uf36e\uf393\uf3b8\uf3dd\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f", -590794125, "\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f", false, "\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa", false, "\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362", false, "\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211", false}, {"\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54", 1473051730133308994L, "\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf", -1370421028, "\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e", true, "\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20", true, "\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385", true, "\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e", true}, {"\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033", 1473051730133374531L, "\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673", 2142883749, "\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694\ue6b9\ue6de", false, "\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46", false, "\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5", false, "\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413", false}, {"\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3", 1473051730133440068L, "\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052", 822183438, "\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804", true, "\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69", true, "\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562", true, "\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480", true}, {"\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157", 1473051730133505605L, "\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2", -2090312489, "\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a", false, "\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9", false, "\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7", false, "\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537", false}, {"\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336", 1473051730133571142L, "\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8", 1425019824, "\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d", true, "\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046", true, "\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764", true, "\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613", true}, {"\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6", 1473051730133636679L, "\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e", 643361305, "\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd", false, "\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db", false, "\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b", false, "\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef", false}, {"\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc", 1473051730133702216L, "\ue275\ue29a\ue2bf\ue2e4\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431", -140467998, "\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a", true, "\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248", true, "\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7", true, "\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0", true}, {"\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2", 1473051730133767753L, "\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1", 1225221963, "\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf", false, "\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff", false, "\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3", false, "\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf", false}, {"\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715", 1473051730133833290L, "\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e", 460275220, "\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c", true, "\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db", true, "\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4", true, "\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f", true}, {"\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085", 1473051730133898827L, "\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3", -319294211, "\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3", false, "\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7", false, "\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3", false, "\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3", false}, {"\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2", 1473051730133964364L, "\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810", -1101018298, "\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf", true, "\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8", true, "\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623", true, "\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2", true}, {"\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287", 1473051730134029901L, "\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7", 262636079, "\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b", false, "\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797", false, "\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7", false, "\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42", false}, {"\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4", 1473051730134095438L, "\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3", -1056024440, "\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c", true, "\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107", true, "\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6", true, "\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68", true}, {"\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab", 1473051730134160975L, "\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f", -1835655343, "\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b", false, "\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb", false, "\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926", false, "\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e", false}, {"\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487", 1473051730134226512L, "\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80", 1694422586, "\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb", true, "\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a", true, "\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c", true, "\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1", true}, {"\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563", 1473051730134292049L, "\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f", 910601347, "\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f", false, "\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a", false, "\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72", false, "\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221", false}, {"\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664", 1473051730134357586L, "\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf", -2018679956, "\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e", true, "\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530", true, "\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95", true, "\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e", true}, {"\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843", 1473051730134423123L, "\ued80\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83", 1496660533, "\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee", false, "\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656", false, "\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05", false, "\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423", false}, {"\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3", 1473051730134488660L, "\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062", 714993822, "\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014", true, "\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679", true, "\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72", true, "\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490", true}, {"\ue864\ue889\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967", 1473051730134554197L, "\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2", -52054169, "\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a", false, "\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9", false, "\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07", false, "\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547", false}, {"\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46", 1473051730134619734L, "\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8", 1313705408, "\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d", true, "\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856", true, "\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74", true, "\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623", true}, {"\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6", 1473051730134685271L, "\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e", 534004905, "\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd", false, "\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb", false, "\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b", false, "\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff", false}, {"\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc", 1473051730134750808L, "\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441", -784589966, "\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a", true, "\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58", true, "\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107", true, "\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000", true}, {"\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02", 1473051730134816345L, "\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1", -1568353829, "\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf", false, "\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f", false, "\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3", false, "\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df", false}, {"\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25", 1473051730134881882L, "\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e", 1961666724, "\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c", true, "\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb", true, "\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4", true, "\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f", true}, {"\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095", 1473051730134947419L, "\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3", -965513459, "\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3", false, "\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7", false, "\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3", false, "\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303", false}, {"\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102", 1473051730135012956L, "\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020", -1747245610, "\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf", true, "\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8", true, "\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633", true, "\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2", true}, {"\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297", 1473051730135078493L, "\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7", 1763966143, "\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab", false, "\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d\uef82\uefa7", false, "\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7", false, "\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652", false}, {"\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304", 1473051730135144030L, "\ue08b\ue0b0\ue0d5\ue0fa\ue11f\ue144\ue169\ue18e\ue1b3", 982233880, "\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac", true, "\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117", true, "\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6", true, "\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778", true}, {"\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb", 1473051730135209567L, "\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f", -1944876575, "\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b", false, "\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb", false, "\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136", false, "\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e", false}, {"\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497", 1473051730135275104L, "\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b\ue390", 1585070154, "\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb", true, "\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa", true, "\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c", true, "\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1", true}, {"\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573", 1473051730135340641L, "\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c\ue491\ue4b6\ue4db\ue500\ue525\ue54a\ue56f", 801244947, "\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf", false, "\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a", false, "\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382", false, "\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31", false}, {"\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f\uf674", 1473051730135406178L, "\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df", -517284356, "\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e", true, "\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540", true, "\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5", true, "\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e", true}, {"\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053", 1473051730135471715L, "\ue590\ue5b5\ue5da\ue5ff\ue624\ue649\ue66e\ue693", -1296919483, "\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe", false, "\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666", false, "\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515", false, "\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33", false}, {"\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3", 1473051730135537252L, "\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872", 68774702, "\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024", true, "\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689", true, "\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582", true, "\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0", true}, {"\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177", 1473051730135602789L, "\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2", -698277385, "\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a", false, "\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9", false, "\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717", false, "\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57", false}, {"\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356", 1473051730135668326L, "\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08", -1479935920, "\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d", true, "\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066", true, "\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784", true, "\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33", true}, {"\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6", 1473051730135733863L, "\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e", 2035400505, "\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd", false, "\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb", false, "\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b", false, "\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f", false}, {"\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec", 1473051730135799400L, "\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51", -893880958, "\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a", true, "\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268", true, "\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917", true, "\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010", true}, {"\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712", 1473051730135864937L, "\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1", -1677702037, "\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df", false, "\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f", false, "\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3", false, "\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef", false}, {"\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735", 1473051730135930474L, "\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09\uee2e", 1852310324, "\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c", true, "\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb", true, "\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4", true, "\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f", true}, {"\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5", 1473051730135996011L, "\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3", 1072748957, "\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603", false, "\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7", false, "\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3", false, "\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313", false}, {"\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912", 1473051730136061548L, "\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030", -245854106, "\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba\uf6df", true, "\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8", true, "\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43", true, "\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2", true}, {"\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7", 1473051730136127085L, "\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7", 1119835855, "\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb", false, "\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7", false, "\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7", false, "\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662", false}, {"\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14", 1473051730136192622L, "\uf09b\uf0c0\uf0e5\uf10a\uf12f\uf154\uf179\uf19e\uf1c3", 336014760, "\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc", true, "\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927", true, "\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6", true, "\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788", true}, {"\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb", 1473051730136258159L, "\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f", -428874639, "\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251\ue276\ue29b", false, "\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db", false, "\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146", false, "\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae", false}, {"\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7", 1473051730136323696L, "\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0", -1208501542, "\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b", true, "\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba", true, "\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c", true, "\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1", true}, {"\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83", 1473051730136389233L, "\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a\uf57f", 157184419, "\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf", false, "\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a", false, "\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392", false, "\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241", false}, {"\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84", 1473051730136454770L, "\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef", -626636788, "\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e", true, "\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50", true, "\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5", true, "\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae", true}, {"\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063", 1473051730136520307L, "\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3", -1408364843, "\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e", false, "\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76", false, "\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525", false, "\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443", false}, {"\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3", 1473051730136585844L, "\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082", 2107033022, "\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834", true, "\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99", true, "\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592", true, "\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0", true}, {"\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187", 1473051730136651381L, "\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2", -805397497, "\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a", false, "\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009", false, "\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727", false, "\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567", false}, {"\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366", 1473051730136716918L, "\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318", -2126163232, "\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d", true, "\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076", true, "\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794", true, "\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643", true}, {"\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6", 1473051730136782455L, "\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e", 1387080009, "\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed", false, "\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b", false, "\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001\ue026\ue04b", false, "\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f", false}, {"\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc", 1473051730136847992L, "\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461", 607510546, "\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a", true, "\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278", true, "\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127", true, "\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820", true}, {"\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722", 1473051730136913529L, "\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1", -174217477, "\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef", false, "\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f", false, "\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203", false, "\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff", false}, {"\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745", 1473051730136979066L, "\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e", 1206156612, "\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c", true, "\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b", true, "\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304", true, "\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f", true}, {"\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5", 1473051730137044603L, "\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3", 424424493, "\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13", false, "\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7", false, "\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3", false, "\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23", false}, {"\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122", 1473051730137110140L, "\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840", -355202314, "\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef", true, "\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8", true, "\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653", true, "\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02", true}, {"\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7", 1473051730137175677L, "\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7", -1136869025, "\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb", false, "\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7", false, "\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607", false, "\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72", false}, {"\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324", 1473051730137241214L, "\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3", 226793528, "\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc", true, "\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137", true, "\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6", true, "\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98", true}, {"\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db", 1473051730137306751L, "\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf", -538222975, "\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286\uf2ab", false, "\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb", false, "\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956", false, "\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be", false}, {"\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7", 1473051730137372288L, "\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0", -1854728854, "\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b", true, "\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca", true, "\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c", true, "\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1", true}, {"\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593", 1473051730137437825L, "\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45\ued6a\ued8f", 1658580019, "\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf", false, "\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a", false, "\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2", false, "\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251", false}, {"\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694", 1473051730137503362L, "\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff", 874750620, "\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae", true, "\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560", true, "\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5", true, "\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be", true}, {"\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e\ue873", 1473051730137568899L, "\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3", -2054522523, "\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e", false, "\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686", false, "\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35", false, "\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453", false}, {"\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3", 1473051730137634436L, "\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092", 1460813774, "\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044", true, "\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9", true, "\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2", true, "\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0", true}};
        byte[] v0 = "\u00b5\u00f8\u0003&\"\u0004j\u00bb\u0091\u00a5\u00c7\u009bLxdX\u00b4\u00a3\u0096\u00a8:((\u0089\u009bb\u00c8\u007f\u00d8\u00f6\u00dd\u00c3\u0006BC1!t\u00d3\u00d9\u0004K\u00d6\u00e0\u0015\u001c\"\u0089\u00b0\u00fc>8\u00f8\u00f7\u00104\u0019x\u009f\u00dcT]\u0006\u0096\u00a1\u0014a\\\u00e4\u00f1h3\u007f\u00c70\u0098\u00f3\u00ce\u00db\u00e6\u0012-\u00fa\u00fd\u00dc\u000e)\u00f7\u001c\u00e3\u001f\u008b\u00a3[\u00e4D\u00d3\u00fb\u008a}Ug\u00fe\u00f7\u00c0\u00cd\u001d\u00b09:NrkH\u00ea\u00cb0lq\u0002$PAh\u0087\u00b8\u0015\u00d9\u00ce\u008b\u0010\u001a\u00c9\t'\u00835\u00b0\u00ce\u00e6f.\u00f0BW9\u009c\u008dN\u0083\u00d7\u00da".getBytes("ISO_8859_1");
        Object[] v1 = "$t\u00b4\u0007\u00ec0\u00dd\u00ca".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1763766389;
                case 1 -> 2115925281;
                case 2 -> 1320519335;
                case 3 -> -864322717;
                case 4 -> 719776077;
                case 5 -> 1474162227;
                case 6 -> -64351290;
                case 7 -> 96348989;
                case 8 -> 904358586;
                case 9 -> -16485770;
                case 10 -> 1572967331;
                case 11 -> -2040037027;
                case 12 -> -243373555;
                case 13 -> -2104287127;
                case 14 -> -1454021886;
                case 15 -> -1993747516;
                case 16 -> 428877356;
                case 17 -> -2093776025;
                case 18 -> 1161019757;
                case 19 -> -470323238;
                case 20 -> -1131957781;
                case 21 -> 1813098167;
                case 22 -> 749191842;
                case 23 -> 1980818054;
                case 24 -> 1205083778;
                case 25 -> 1228112434;
                case 26 -> 276102471;
                case 27 -> 170874794;
                case 28 -> -921983122;
                case 29 -> 233488398;
                case 30 -> -480836550;
                case 31 -> -1221283090;
                case 32 -> -1167165371;
                case 33 -> 834969619;
                case 34 -> 621866369;
                case 35 -> -1707972269;
                case 36 -> 821625643;
                case 37 -> 0xD33232D;
                case 38 -> 614032474;
                case 39 -> -332184197;
                case 40 -> -1697646649;
                case 41 -> -1369878482;
                case 42 -> -810281978;
                case 43 -> -1270644212;
                case 44 -> 1557023978;
                case 45 -> -349891354;
                case 46 -> -1273926136;
                case 47 -> 502660893;
                case 48 -> 396360896;
                case 49 -> 91650742;
                case 50 -> 270140267;
                case 51 -> 895254566;
                case 52 -> -1504028277;
                case 53 -> 566059536;
                case 54 -> 941294584;
                case 55 -> 240394431;
                case 56 -> -1674766831;
                case 57 -> 1165231129;
                case 58 -> -337796832;
                case 59 -> 1030125299;
                case 60 -> 584413823;
                case 61 -> 1382930591;
                case 62 -> 1225481679;
                case 63 -> -946660078;
                case 64 -> 1110385663;
                case 65 -> 324512507;
                case 66 -> -597852477;
                case 67 -> 56400842;
                case 68 -> 1356131926;
                case 69 -> -1774255868;
                case 70 -> 2125869859;
                case 71 -> 1001308632;
                case 72 -> 1081933892;
                case 73 -> -1060888697;
                case 74 -> -2144979113;
                case 75 -> -1679548846;
                case 76 -> -1260685489;
                case 77 -> -805621349;
                case 78 -> 2043273280;
                case 79 -> 378739550;
                case 80 -> 194496753;
                case 81 -> -1187608200;
                case 82 -> -1802178893;
                case 83 -> -1641890506;
                case 84 -> 1166527054;
                case 85 -> -1707284231;
                case 86 -> 1188340117;
                case 87 -> 1639074002;
                case 88 -> -684873366;
                case 89 -> 1678525652;
                case 90 -> 1621346330;
                case 91 -> -2116145568;
                case 92 -> -425454968;
                case 93 -> 209354329;
                case 94 -> -1593515071;
                case 95 -> 983564426;
                case 96 -> 704004328;
                case 97 -> 235600837;
                case 98 -> 638748880;
                case 99 -> 690903832;
                case 100 -> 412603083;
                case 101 -> 459874556;
                case 102 -> -1963548688;
                case 103 -> -1449329720;
                case 104 -> 1066044405;
                case 105 -> 1248136549;
                case 106 -> -497209119;
                case 107 -> 1196191677;
                case 108 -> 1878940881;
                case 109 -> -900651618;
                case 110 -> 1814021647;
                case 111 -> -1740889846;
                case 112 -> 102394591;
                case 113 -> -2139864168;
                case 114 -> -1523403479;
                case 115 -> 1028172410;
                case 116 -> 1600379824;
                case 117 -> -1137859472;
                case 118 -> 1638776055;
                case 119 -> 59478300;
                case 120 -> -1608405067;
                case 121 -> 145021344;
                case 122 -> 106809294;
                case 123 -> -1800334661;
                case 124 -> 1533733204;
                case 125 -> -189699895;
                case 126 -> -1176115354;
                case 127 -> -932483159;
                case 128 -> 1954463934;
                case 129 -> 1347080556;
                case 130 -> -783179107;
                case 131 -> 2004020101;
                case 132 -> 1742518311;
                case 133 -> -1031066135;
                case 134 -> -1587852569;
                case 135 -> -738425304;
                case 136 -> 26002404;
                case 137 -> -111436632;
                case 138 -> -791874382;
                case 139 -> 1669398565;
                case 140 -> -1436168484;
                case 141 -> -578604913;
                case 142 -> -510970626;
                case 143 -> 357614156;
                case 144 -> -635214530;
                case 145 -> -800714350;
                case 146 -> -1052454788;
                case 147 -> -536297391;
                case 148 -> -1241429481;
                case 149 -> -1135867463;
                case 150 -> 817035481;
                case 151 -> 1221028260;
                case 152 -> 1839080980;
                case 153 -> -1084051158;
                case 154 -> -720783465;
                case 155 -> 692070511;
                case 156 -> -531317538;
                case 157 -> 119595390;
                case 158 -> -84886111;
                case 159 -> -1732300138;
                case 160 -> 2118990322;
                case 161 -> -1665778146;
                case 162 -> -514284113;
                case 163 -> -1625916187;
                case 164 -> 410947731;
                case 165 -> -712316996;
                case 166 -> -1123985064;
                case 167 -> 445131355;
                case 168 -> 1945237576;
                case 169 -> -872373095;
                case 170 -> 1070218877;
                case 171 -> 1112658502;
                case 172 -> 1696138650;
                case 173 -> 384313293;
                case 174 -> 19742747;
                case 175 -> 1639931953;
                case 176 -> 170451923;
                case 177 -> 877801101;
                case 178 -> -1412302049;
                case 179 -> -1293717663;
                case 180 -> 1702082478;
                case 181 -> 512599062;
                case 182 -> -818512692;
                case 183 -> -1082233344;
                case 184 -> 887303811;
                case 185 -> -173995169;
                case 186 -> -398494803;
                case 187 -> -243471359;
                case 188 -> -263867036;
                case 189 -> -845232015;
                case 190 -> -396771695;
                case 191 -> 1174980729;
                case 192 -> 2001856011;
                case 193 -> -1608964574;
                case 194 -> -990663053;
                case 195 -> -1649395584;
                case 196 -> 811215843;
                case 197 -> 1039409634;
                case 198 -> 2025092613;
                case 199 -> 1424023087;
                case 200 -> 1407491549;
                case 201 -> 1814056632;
                case 202 -> 826051587;
                case 203 -> -1994106038;
                case 204 -> 1845074992;
                case 205 -> 581661513;
                case 206 -> -6158910;
                case 207 -> 1148130031;
                case 208 -> -297947300;
                case 209 -> 390637624;
                case 210 -> 1669870455;
                case 211 -> 1068046245;
                case 212 -> 168928825;
                case 213 -> 1278939211;
                case 214 -> 283243920;
                case 215 -> -1012631887;
                case 216 -> 1916669205;
                case 217 -> -1750369200;
                case 218 -> -1016947901;
                case 219 -> -1825354604;
                case 220 -> 241000917;
                case 221 -> -551383031;
                case 222 -> 949569460;
                case 223 -> -1656528585;
                case 224 -> 1435149527;
                case 225 -> -865713020;
                case 226 -> 787422983;
                case 227 -> 1376532873;
                case 228 -> 470827362;
                case 229 -> -711801632;
                case 230 -> -1132409023;
                case 231 -> -440937665;
                case 232 -> 321735028;
                case 233 -> -1355540366;
                case 234 -> 1766858924;
                case 235 -> 213746646;
                case 236 -> 1891996300;
                case 237 -> 1437012028;
                case 238 -> 752002038;
                case 239 -> 95003752;
                case 240 -> -1825359730;
                case 241 -> 1348297981;
                case 242 -> -72434266;
                case 243 -> 948178261;
                case 244 -> 800489899;
                case 245 -> 1057620468;
                case 246 -> -1211591877;
                case 247 -> -1330476820;
                case 248 -> 174795812;
                case 249 -> 326626370;
                case 250 -> -1764452964;
                case 251 -> 173255387;
                case 252 -> 460894773;
                case 253 -> 337592372;
                case 254 -> -88229395;
                case 255 -> -1696472070;
                default -> -1062930702;
            });
        } while (v2 != 152);
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
            Object[] objectArray = new Object[8];
            v1 = objectArray;
            OoOi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        RenderSupport_O0I0 = -2;
        ConfigSupport_O0IO = 4.5;
    }

    private void 0Oii() {
        if (this.RenderSupport_oooo_2 != EnumType_ooio_0.0iI && this.RenderSupport_oooo_2 != EnumType_ooio_0.0ii) {
            return;
        }
        if (this.CriticalsModule == 0 || ExtinguisherModule.iooI()) {
            return;
        }
        if (this.RenderSupport_oooo_2 == EnumType_ooio_0.0iI) {
            BlockPos v1;
            BlockPos blockPos = v1 = this.OoO0 != null ? this.OoO0.getBlockPos().offset(this.OoO0.getSide()) : null;
            if (ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.BUCKET) || v1 != null && ExtinguisherModule.ConfigSupport_OI0.world.method_8316(v1).isIn(FluidTags.WATER)) {
                this.XrayModule = true;
                this.OOOi = v1;
                this.O0iO = 0;
                this.CriticalsModule = 0;
                this.00Io(false);
                this.FontRenderer = true;
                return;
            }
        } else if (this.RenderSupport_oooo_2 == EnumType_ooio_0.0ii && ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.WATER_BUCKET)) {
            this.XrayModule = false;
            this.OOOi = null;
            this.O0iO = 0;
            this.CriticalsModule = 0;
            this.00Io(false);
            this.FontRenderer = true;
            this.00o0();
            return;
        }
        ++this.CriticalsModule;
        if (this.CriticalsModule > 2) {
            this.ConfigSupport_00I0();
        }
    }

    private DataRecord_0oo0_0 KbDelayModule() {
        BlockPos v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        FluidState v2 = ExtinguisherModule.ConfigSupport_OI0.world.method_8316(v1);
        if (!v2.isIn(FluidTags.LAVA) || !v2.isStill()) {
            return null;
        }
        if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v1.up()).method_26215()) {
            return null;
        }
        BlockPos v3 = v1.down();
        if (!this.O0iO(v3)) {
            return null;
        }
        return this.0OoO(v3);
    }

    private boolean O0iO(BlockPos param1) {
        return ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1).method_26206((BlockView)ExtinguisherModule.ConfigSupport_OI0.world, param1, Direction.UP);
    }

    private void OooO() {
        if (!this.OOoO) {
            this.EventHandler = ExtinguisherModule.ConfigSupport_OI0.player.method_36454();
            this.OOoo = ExtinguisherModule.ConfigSupport_OI0.player.method_36455();
        }
        this.OOoO = true;
        ExtinguisherModule.ConfigSupport_OI0.player.method_36456(this.OOoI);
        ExtinguisherModule.ConfigSupport_OI0.player.method_36457(this.OOoi);
    }

    private void NetworkSupport_0oio_1() {
        if (this.RenderSupport_oooo_2 == null || this.OoOo == null) {
            ExtinguisherModule.ConfigSupport_OI0.options.useKey.setPressed(false);
            this.CriticalsModule = 0;
            return;
        }
        if (this.RenderSupport_oooo_2 == EnumType_ooio_0.0iI || this.RenderSupport_oooo_2 == EnumType_ooio_0.0ii) {
            this.0OiI();
            return;
        }
        this.ClickGuiScreenV2();
    }

    private boolean O0i0(BlockPos param1) {
        return ExtinguisherModule.ConfigSupport_OI0.world.method_8316(param1).isEmpty() && (ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1).method_26215() || ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1).method_45474() || ExtinguisherModule.ConfigSupport_OI0.world.method_8320(param1).method_26204() instanceof FireBlock);
    }

    private boolean ArgumentType_0OIO() {
        Box v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_5829();
        BlockPos v2 = BlockPos.ofFloored((double)v1.minX, (double)v1.minY, (double)v1.minZ);
        BlockPos v3 = BlockPos.ofFloored((double)v1.maxX, (double)v1.maxY, (double)v1.maxZ);
        for (BlockPos v5 : BlockPos.iterate((BlockPos)v2, (BlockPos)v3)) {
            if (!(ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v5).method_26204() instanceof FireBlock)) continue;
            return true;
        }
        return false;
    }

    private void ConfigSupport_00O0() {
        if (this.OoO0 == null || !ExtinguisherModule.ConfigSupport_OI0.player.method_6047().isOf(Items.BUCKET)) {
            this.ConfigSupport_00I0();
            return;
        }
        FluidState v1 = ExtinguisherModule.ConfigSupport_OI0.world.method_8316(this.OoO0.getBlockPos());
        if (!v1.isIn(FluidTags.WATER) || !v1.isStill()) {
            this.00Io(false);
            return;
        }
        ActionResult v2 = this.000o(this.OoOo);
        if (v2.isAccepted()) {
            ExtinguisherModule.ConfigSupport_OI0.player.method_6104(Hand.MAIN_HAND);
            this.XrayModule = false;
            this.OOOi = null;
            this.O0iO = 0;
            this.00Io(false);
            this.FontRenderer = true;
            this.00o0();
            return;
        }
        if (this.O0iO > 20) {
            this.ConfigSupport_00I0();
        } else {
            this.00Io(false);
        }
    }

    public void MoveFixModule() {
        if (ExtinguisherModule.iooI() || ExtinguisherModule.ConfigSupport_OI0.interactionManager == null || ExtinguisherModule.ConfigSupport_OI0.currentScreen != null || ExtinguisherModule.ConfigSupport_OI0.player.method_68878()) {
            this.ConfigSupport_00I0();
            return;
        }
        if (this.RenderSupport_oooo_2 != null) {
            this.NetworkSupport_0oio_1();
        }
    }

    private void 00Io(boolean param1) {
        this.RenderSupport_oooo_2 = null;
        this.OoO0 = null;
        this.OoOo = null;
        this.ConfigSupport_oooi_3 = -1;
        this.CriticalsModule = 0;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        if (param1) {
            0ooo.IOo().0Oo(this);
        }
    }

    private void Oo0i() {
        if (0ooo.SprintModule() != null && 0ooo.IOi().ConfigSupport_0OO(this)) {
            this.OOoI = 0ooo.DataRecord_I0O().ConfigSupport_OI0();
            this.OOoi = 0ooo.EnumType_I00().OIo();
            return;
        }
        float[] v1 = this.ScaledDrawContext(this.OoOo != null ? this.OoOo : ExtinguisherModule.ConfigSupport_OI0.player.method_33571().add(ExtinguisherModule.ConfigSupport_OI0.player.method_5828(1.0f)));
        this.OOoI = v1[0];
        this.OOoi = v1[1];
    }

    @EventHandler
    public void 0oi(ConfigSupport_O0IO param1) {
        if (param1.0Oi() != EnumType_iii_0.OiO) {
            return;
        }
        if (ExtinguisherModule.iooI() || ExtinguisherModule.ConfigSupport_OI0.interactionManager == null || ExtinguisherModule.ConfigSupport_OI0.currentScreen != null || ExtinguisherModule.ConfigSupport_OI0.player.method_68878()) {
            this.ConfigSupport_00I0();
            return;
        }
        this.00oo();
        if (this.FontRenderer) {
            if (0ooo.I0o() != null) {
                0ooo.IrcCommand().HelpCommand(this, this.OOoI, this.OOoi, 180.0f);
            }
            return;
        }
        if (this.RenderSupport_oooo_2 != null) {
            this.0OiO();
            return;
        }
        if (((Boolean)this.O0Ii.HelpCommand()).booleanValue() && this.0OOo()) {
            return;
        }
        if (((Boolean)this.O0Io.HelpCommand()).booleanValue() && this.DataRecord_0OOI()) {
            return;
        }
        if (((Boolean)this.EnumType_O0II.HelpCommand()).booleanValue()) {
            this.ConfigSupport_0O0O();
        }
    }

    private void DataRecord_I0O() {
        if (((Boolean)this.KeepSprintModule.HelpCommand()).booleanValue() && this.NetworkSupport_o0o_0 >= 0 && this.NetworkSupport_o0o_0 < 9) {
            ExtinguisherModule.ConfigSupport_OI0.player.method_31548().setSelectedSlot(this.NetworkSupport_o0o_0);
            ExtinguisherModule.ConfigSupport_OI0.interactionManager.syncSelectedSlot();
        }
        this.NetworkSupport_o0o_0 = -1;
        this.O0ii = false;
        this.O0i0 = 0;
    }

    private boolean 0OIo(BlockPos param1) {
        FluidState v2 = ExtinguisherModule.ConfigSupport_OI0.world.method_8316(param1);
        return !v2.isIn(FluidTags.LAVA) || !v2.isStill();
    }

    private boolean EnumType_0O00() {
        return (Boolean)this.O0Ii.HelpCommand() != false && ExtinguisherModule.ConfigSupport_OI0.player.method_5809() && !ExtinguisherModule.ConfigSupport_OI0.player.method_6059(StatusEffects.FIRE_RESISTANCE) && !ExtinguisherModule.ConfigSupport_OI0.player.method_5799() && this.Ooo0(Items.WATER_BUCKET) != -1 && (ExtinguisherModule.ConfigSupport_OI0.player.method_24828() || this.ArgumentType_0OIO() || this.KbDelayModule() != null || this.RenderSupport_0ooi_1() != null);
    }

    private DataRecord_0oo0_0 0Oo0(BlockPos param1) {
        for (Direction v5 : Direction.values()) {
            Vec3d v7;
            BlockPos v6 = param1.offset(v5);
            if (!ExtinguisherModule.ConfigSupport_OI0.world.method_8316(v6).isEmpty() || ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v6).method_26215() || !ExtinguisherModule.ConfigSupport_OI0.world.method_8320(v6).method_26206((BlockView)ExtinguisherModule.ConfigSupport_OI0.world, v6, v5.getOpposite()) || !this.IrcManager(v7 = Vec3d.ofCenter((Vec3i)v6).add(v5.getOpposite().getDoubleVector().multiply(0.5)))) continue;
            BlockHitResult v8 = new BlockHitResult(v7, v5.getOpposite(), v6, false);
            BlockHitResult v9 = this.Oo0O(v7, RaycastContext.FluidHandling.NONE);
            if (v9.method_17783() != HitResult.Type.BLOCK || !v9.getBlockPos().equals((Object)v6) || v9.getSide() != v5.getOpposite()) continue;
            return new DataRecord_0oo0_0(v8, v7);
        }
        return null;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.SettingContainer();
    }

    private Vec3d 0O0i() {
        Vec3d v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_18798();
        Vec3d v2 = new Vec3d(v1.x, 0.0, v1.z);
        double v3 = v2.length();
        Vec3d v5 = ExtinguisherModule.ConfigSupport_OI0.player.method_73189().add(0.0, v1.y, 0.0);
        if (v3 < 0.03) {
            return v5.add(v1.x, 0.0, v1.z);
        }
        double v6 = ExtinguisherModule.ConfigSupport_OI0.player.method_5624() ? 3.0 : 2.0;
        double v8 = MathHelper.clamp((double)(v3 * v6), (double)0.35, (double)(ExtinguisherModule.ConfigSupport_OI0.player.method_5624() ? 1.05 : 0.75));
        Vec3d v10 = v2.normalize().multiply(v8);
        return v5.add(v10);
    }

    private DataRecord_0oo0_0 0O0o() {
        DataRecord_0oo0_0 v1 = this.KbDelayModule();
        if (v1 != null) {
            return v1;
        }
        int v2 = Math.max(1, this.HudEditorScreen());
        int v3 = Math.max(2, this.00oi());
        ArrayList<BlockPos> v4 = new ArrayList<BlockPos>();
        BlockPos v5 = ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        Vec3d v6 = this.0O0i();
        for (int v7 = -v2; v7 <= v2; ++v7) {
            for (int v8 = -v2; v8 <= v2; ++v8) {
                for (int v9 = 0; v9 <= v3; ++v9) {
                    BlockPos v11;
                    BlockPos v10 = v5.add(v7, -v9, v8);
                    if (!this.O0iO(v10) || !this.O0i0(v11 = v10.up())) continue;
                    v4.add(v10.toImmutable());
                }
            }
        }
        return v4.stream().sorted(Comparator.comparingDouble(param1 -> Vec3d.ofCenter((Vec3i)param1.up()).squaredDistanceTo(v6)).thenComparingDouble(param0 -> -param0.method_10264())).map(this::0OoO).filter(param1 -> param1 != null && this.IrcManager(param1.0Io())).findFirst().orElse(null);
    }

    private void Oooo(int param1) {
        if (param1 < 0 || param1 > 8) {
            return;
        }
        if (this.NetworkSupport_o0o_0 == -1) {
            this.NetworkSupport_o0o_0 = ExtinguisherModule.ConfigSupport_OI0.player.method_31548().getSelectedSlot();
        }
        if (ExtinguisherModule.ConfigSupport_OI0.player.method_31548().getSelectedSlot() != param1) {
            ExtinguisherModule.ConfigSupport_OI0.options.useKey.setPressed(false);
            ExtinguisherModule.ConfigSupport_OI0.player.method_31548().setSelectedSlot(param1);
            ExtinguisherModule.ConfigSupport_OI0.interactionManager.syncSelectedSlot();
        }
    }

    private boolean 0OOo() {
        if (this.XrayModule) {
            ++this.O0iO;
            if (this.O0iO < 2) {
                return true;
            }
            int v1 = this.Ooo0(Items.BUCKET);
            if (v1 == -1) {
                this.ConfigSupport_00I0();
                return false;
            }
            BlockPos v2 = this.ConfigSupport_O0IO();
            if (v2 == null) {
                if (this.O0iO > 20) {
                    this.ConfigSupport_00I0();
                }
                return false;
            }
            Vec3d v3 = Vec3d.ofCenter((Vec3i)v2);
            this.0OIi(EnumType_ooio_0.0ii, new BlockHitResult(v3, Direction.UP, v2, false), v3, v1);
            return true;
        }
        if (this.EnumType_0O00()) {
            int v1 = this.Ooo0(Items.WATER_BUCKET);
            if (v1 == -1) {
                return false;
            }
            DataRecord_0oo0_0 v2 = this.0O0o();
            if (v2 == null) {
                return false;
            }
            this.0OIi(EnumType_ooio_0.0iI, v2.RenderSupport_0I0(), v2.0Io(), v1);
            return true;
        }
        return false;
    }

    private void 00o0() {
        if (!((Boolean)this.KeepSprintModule.HelpCommand()).booleanValue() || this.NetworkSupport_o0o_0 < 0 || this.NetworkSupport_o0o_0 > 8) {
            this.NetworkSupport_o0o_0 = -1;
            this.O0ii = false;
            this.O0i0 = 0;
            return;
        }
        this.O0ii = true;
        this.O0i0 = 2;
    }

    private BlockPos RenderSupport_0ooi_1() {
        int v1 = Math.max(1, this.HudEditorScreen());
        int v2 = Math.max(2, this.00oi());
        BlockPos v3 = ExtinguisherModule.ConfigSupport_OI0.player.method_24515();
        Vec3d v4 = this.0O0i();
        BlockPos v5 = null;
        double v6 = Double.MAX_VALUE;
        for (int v8 = -v1; v8 <= v1; ++v8) {
            for (int v9 = -v1; v9 <= v1; ++v9) {
                for (int v10 = 0; v10 <= v2; ++v10) {
                    double v12;
                    BlockPos v11 = v3.add(v8, -v10, v9);
                    if (!this.O0iO(v11) || !this.O0i0(v11.up()) || !((v12 = Vec3d.ofCenter((Vec3i)v11.up()).squaredDistanceTo(v4)) < v6)) continue;
                    v6 = v12;
                    v5 = v11.toImmutable();
                }
            }
        }
        return v5;
    }

    private boolean 0OOi(BlockPos param1) {
        for (Direction v3 : Direction.Type.HORIZONTAL) {
            FluidState v4 = ExtinguisherModule.ConfigSupport_OI0.world.method_8316(param1.offset(v3));
            if (!v4.isIn(FluidTags.LAVA) || !v4.isStill()) continue;
            return true;
        }
        return false;
    }

    private void 00Oo() {
        Hand v1 = this.BindCommand();
        if (this.OoO0 == null || v1 == null) {
            this.ConfigSupport_00I0();
            return;
        }
        BlockHitResult v2 = this.NetworkSupport_00OI();
        if (v2 == null) {
            this.ConfigSupport_00I0();
            return;
        }
        ActionResult v3 = this.EnumType_0000(v2, v1);
        if (v3.isAccepted()) {
            ExtinguisherModule.ConfigSupport_OI0.player.method_6104(v1);
        }
        this.00Io(false);
        this.FontRenderer = true;
        this.00o0();
    }

    private BlockHitResult PacketSendEvent(float param1, float param2, double param3, RaycastContext.FluidHandling param5) {
        Vec3d v6 = ExtinguisherModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v7 = Vec3d.fromPolar((float)param2, (float)param1);
        return ExtinguisherModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(v6, v6.add(v7.multiply(param3)), RaycastContext.ShapeType.OUTLINE, param5, (Entity)ExtinguisherModule.ConfigSupport_OI0.player));
    }

    public void OOii() {
        this.0Oii();
        if (!this.OOoO || ExtinguisherModule.iooI()) {
            this.OOoO = false;
            return;
        }
        ExtinguisherModule.ConfigSupport_OI0.player.method_36456(this.EventHandler);
        ExtinguisherModule.ConfigSupport_OI0.player.method_36457(this.OOoo);
        ExtinguisherModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        this.OOoO = false;
    }

    private float[] ScaledDrawContext(Vec3d param1) {
        Vec3d v2 = param1.subtract(ExtinguisherModule.ConfigSupport_OI0.player.method_33571());
        double v3 = Math.sqrt(v2.x * v2.x + v2.z * v2.z);
        float v5 = (float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(v2.z, v2.x)) - 90.0));
        float v6 = (float)MathHelper.clamp((double)(-Math.toDegrees(Math.atan2(v2.y, v3))), (double)-90.0, (double)90.0);
        return new float[]{v5, v6};
    }

    private boolean ConfigPanel() {
        Box v1 = ExtinguisherModule.ConfigSupport_OI0.player.method_5829();
        BlockPos v2 = BlockPos.ofFloored((double)v1.minX, (double)v1.minY, (double)v1.minZ);
        BlockPos v3 = BlockPos.ofFloored((double)v1.maxX, (double)v1.maxY, (double)v1.maxZ);
        for (BlockPos v5 : BlockPos.iterate((BlockPos)v2, (BlockPos)v3)) {
            if (this.0OIo(v5)) continue;
            return false;
        }
        return true;
    }

    private boolean OoOi() {
        return Math.abs(MathHelper.wrapDegrees((float)(this.Manager - 0ooo.NetworkSupport_i0i_2().ConfigSupport_OI0()))) <= 8.0f && Math.abs(this.DataRecord_OOI0 - 0ooo.IoO().OIo()) <= 8.0f;
    }

    private ActionResult EnumType_0000(BlockHitResult param1, Hand param2) {
        this.Oo0i();
        return this.RenderSupport_000I(() -> ExtinguisherModule.ConfigSupport_OI0.interactionManager.interactBlock(ExtinguisherModule.ConfigSupport_OI0.player, param2, param1));
    }

    private boolean DataRecord_0OOI() {
        if (this.KbDelayModule() != null) {
            return false;
        }
        if (!this.ConfigPanel()) {
            return false;
        }
        int v1 = this.000i();
        if (v1 == -1) {
            return false;
        }
        BlockPos v2 = this.0Ooo();
        if (v2 == null || this.CoordinatesHudElement(v2)) {
            return false;
        }
        if (this.0OOi(v2)) {
            return false;
        }
        DataRecord_0oo0_0 v3 = this.0Oo0(v2);
        if (v3 == null) {
            return false;
        }
        this.0OIi(EnumType_ooio_0.oOO, v3.RenderSupport_0I0(), v3.0Io(), v1);
        return true;
    }

    private ActionResult RenderSupport_000I(ConfigSupport_0ooo_3 param1) {
        float v2 = ExtinguisherModule.ConfigSupport_OI0.player.method_36454();
        float v3 = ExtinguisherModule.ConfigSupport_OI0.player.method_36455();
        ExtinguisherModule.ConfigSupport_OI0.player.method_36456(this.OOoI);
        ExtinguisherModule.ConfigSupport_OI0.player.method_36457(this.OOoi);
        ExtinguisherModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        ActionResult v4 = param1.PacketEvent();
        ExtinguisherModule.ConfigSupport_OI0.player.method_36456(v2);
        ExtinguisherModule.ConfigSupport_OI0.player.method_36457(v3);
        ExtinguisherModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        return v4;
    }

    @EventHandler
    public void SprintResetModule(ConfigSupport_oiio_2 param1) {
        if (ExtinguisherModule.iooI()) {
            return;
        }
        if (this.RenderSupport_oooo_2 == null || this.OoOo == null || 0ooo.Io0() == null || !0ooo.Ioo().ConfigSupport_0OO(this)) {
            if (this.FontRenderer && 0ooo.IoI() != null && 0ooo.Ioi().ConfigSupport_0OO(this)) {
                param1.RenderSupport_0I0(this.OOoI);
                param1.ConfigSupport_0II(this.OOoi);
                this.FontRenderer = false;
                0ooo.ItemTagsModule().0Oo(this);
            }
            return;
        }
        param1.RenderSupport_0I0(0ooo.ConfigSupport_II0().ConfigSupport_OI0());
        param1.ConfigSupport_0II(0ooo.RenderSupport_iio_5().OIo());
        if (this.FontRenderer) {
            param1.RenderSupport_0I0(this.OOoI);
            param1.ConfigSupport_0II(this.OOoi);
            this.FontRenderer = false;
            0ooo.GuiSupport_III().0Oo(this);
        }
    }

    private ActionResult 000o(Vec3d param1) {
        this.Oo0i();
        return this.RenderSupport_000I(() -> ExtinguisherModule.ConfigSupport_OI0.interactionManager.interactItem((PlayerEntity)ExtinguisherModule.ConfigSupport_OI0.player, Hand.MAIN_HAND));
    }

    private boolean CoordinatesHudElement(BlockPos param1) {
        Box v2 = new Box(param1);
        return !ExtinguisherModule.ConfigSupport_OI0.world.method_8333((Entity)null, v2, param0 -> param0 != null && param0.isAlive() && !param0.isSpectator()).isEmpty();
    }
}

