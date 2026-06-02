/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ProjectileUtil
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.MaceItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package clap.module.combat;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import clap.render.RenderSupport_0I0;
import clap.module.combat.AntiBotModule;
import clap.config.ConfigSupport_O0IO;
import clap.model.EnumType_O0OO;
import clap.core.module.Module;
import clap.render.RenderSupport_0ooi_1;
import clap.model.EnumType_0ooo_4;
import clap.model.EnumType_iii_0;
import clap.setting.Setting;
import clap.model.EnumType_oiii_3;
import clap.render.RenderSupport_oio_2;
import clap.core.module.ModuleCategory;
import clap.model.EnumType_oioo_6;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.OOio
 */
public class KillAuraModule
extends Module {
    private final Setting oOIO;
    private final Setting oOII;
    private LivingEntity o00o;
    private final Setting o0Oi;
    private boolean o0o0;
    private final Setting o00O;
    private final Setting o0O0;
    private int o00i;
    private final Setting oOoi;
    private final Setting ioO;
    private final Setting iii;
    private boolean o0oO;
    private final Setting KbDelayModule;
    private final Setting oOio;
    private final Setting oOi0;
    private final Setting oOiO;
    private final Setting o0OI;
    private boolean o0oo;
    private long o0I0;
    private long o0IO;
    private boolean o0oI;
    private final Setting oOii;
    private final Setting oOI0;
    private final Setting oOIi;
    private final Setting o0OO;
    private final Setting BindCommand = this.OOi0i("Mode", EnumType_O0OO.oOi);
    private final Setting o0Oo;
    private final Setting oOiI;
    private final Setting o000;
    private final Setting oOIo;
    private long o0oi;
    private LivingEntity o00I;
    static Object o0Io;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private static boolean IIoo(ItemStack param0) {
        return param0 != null && !param0.isEmpty() && KillAuraModule.IIoI(param0.getItem());
    }

    private float IIio(float param1, float param2) {
        float v3 = (param1 + 0.5f) / param2;
        return Math.min(1.0f, 0.2f + v3 * v3 * 0.8f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean Ii0I(Vec3d param1) {
        BlockHitResult v2 = KillAuraModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(KillAuraModule.ConfigSupport_OI0.player.method_33571(), param1, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)KillAuraModule.ConfigSupport_OI0.player));
        if (v2.getType() != HitResult.Type.MISS) return false;
        return true;
    }

    public KillAuraModule() {
        super("KillAura", "Automatically attacks valid targets around you.", ModuleCategory.i0I);
        this.oOoi = this.OOi0i("Priority", EnumType_oiii_3.OO0i);
        this.oOIO = this.OOi0i("RotationMode", EnumType_oioo_6.NetworkSupport_OO00);
        this.oOI0 = this.OOi0i("Critical", EnumType_0ooo_4.EnumType_O0II);
        this.oOIo = this.OOi0o("RotationRange", 5.0, 2.0, 8.0);
        this.iii = this.OOi0o("RotationSpeed", 90, 5, 180);
        this.ioO = this.OOi0o("Range", 3.0, 2.0, 6.0);
        this.oOII = this.OOi0o("FOV", 180, 1, 180);
        this.oOIi = this.OOi00("OnlyWeapon", false);
        this.oOiO = this.OOi00("Swing", true);
        this.oOi0 = this.OOi00("FakeBlock", false);
        this.oOio = this.OOi00("Players", true);
        this.oOiI = this.OOi00("Mobs", false);
        this.oOii = this.OOi00("Animals", false);
        this.o0OO = this.OOi00("Invisibles", false);
        this.KbDelayModule = this.OOi00("IgnoreTeam", true);
        this.o0O0 = this.OOi00("IgnoreFriends", true);
        this.o0Oo = this.OOi00("TargetESP", false);
        this.o0OI = this.OOi0o("TargetESPRadius", Float.valueOf(0.75f), Float.valueOf(0.1f), Float.valueOf(2.0f));
        this.o0Oi = this.OOi0o("TargetESPAlpha", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(2.0f));
        this.o00O = this.OOioo("TargetESPSideColor", 255, 255, 255, 255);
        this.o000 = this.OOioo("TargetESPLineColor", 255, 255, 255, 233);
        this.iii.00i(param1 -> {
            if (this.oOIO.HelpCommand() != EnumType_oioo_6.OO0o) return false;
            return true;
        });
        this.o0OI.00i(param1 -> (Boolean)this.o0Oo.HelpCommand());
        this.o0Oi.00i(param1 -> (Boolean)this.o0Oo.HelpCommand());
        this.o00O.00i(param1 -> (Boolean)this.o0Oo.HelpCommand());
        this.o000.00i(param1 -> (Boolean)this.o0Oo.HelpCommand());
    }

    private void II0i() {
        this.o00o = null;
        this.o00I = null;
        this.o0o0 = false;
        this.o0oo = false;
        this.o0oI = false;
        this.o0oi = 0L;
        this.o0IO = 0L;
        this.o0I0 = 0L;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean IIoI(Item param0) {
        if (param0 == Items.WOODEN_SWORD) return true;
        if (param0 == Items.COPPER_SWORD) return true;
        if (param0 == Items.STONE_SWORD) return true;
        if (param0 == Items.GOLDEN_SWORD) return true;
        if (param0 == Items.IRON_SWORD) return true;
        if (param0 == Items.DIAMOND_SWORD) return true;
        if (param0 != Items.NETHERITE_SWORD) return false;
        return true;
    }

    private boolean Ii00(LivingEntity param1, EntityHitResult param2) {
        double v13;
        Vec3d v10;
        if (param1 == null) {
            return false;
        }
        double v3 = (Double)this.ioO.HelpCommand();
        double v5 = this.Ii0o(v3);
        if (param2 != null && param2.getEntity() == param1) {
            double v7 = KillAuraModule.ConfigSupport_OI0.player.method_33571().squaredDistanceTo(param2.method_17784());
            return v7 <= v5 * v5 || v7 <= v3 * v3;
        }
        if (v5 <= 0.0) {
            return false;
        }
        Vec3d v9 = KillAuraModule.ConfigSupport_OI0.player.method_33571();
        double v11 = v9.squaredDistanceTo(v10 = this.oOO(v9, param1.method_5829().expand((double)param1.method_5871() + 0.2)));
        if (v11 > (v13 = Math.max(v3, v5)) * v13) {
            return false;
        }
        return v11 <= v5 * v5 || v11 <= v3 * v3 && this.Ii0I(v10);
    }

    private double IiOo(LivingEntity param1) {
        float[] v2 = this.IiOI(param1);
        float v3 = 0ooo.OOi0() != null ? 0ooo.OOio().OiO(KillAuraModule.ConfigSupport_OI0.player.method_36454()) : KillAuraModule.ConfigSupport_OI0.player.method_36454();
        float v4 = KillAuraModule.ConfigSupport_OI0.player.method_36455();
        float v5 = MathHelper.wrapDegrees((float)(v2[0] - v3));
        float v6 = MathHelper.wrapDegrees((float)(v2[1] - v4));
        return v5 * v5 + v6 * v6;
    }

    private Vec3d Ii0i(float param1, float param2) {
        float v3 = param1 * ((float)Math.PI / 180);
        float v4 = param2 * ((float)Math.PI / 180);
        float v5 = MathHelper.cos((double)(-v3 - (float)Math.PI));
        float v6 = MathHelper.sin((double)(-v3 - (float)Math.PI));
        float v7 = -MathHelper.cos((double)(-v4));
        float v8 = MathHelper.sin((double)(-v4));
        return new Vec3d((double)(v6 * v7), (double)v8, (double)(v5 * v7));
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIIO() {
        if (this.o00o == null) {
            return false;
        }
        switch (((EnumType_0ooo_4)((Object)this.oOI0.HelpCommand())).ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 1: {
                boolean bl = this.IIII();
                return bl;
            }
            case 2: {
                if (!this.IIiO(this.o00o)) return true;
                return false;
            }
            case 0: 
        }
        return true;
    }

    private EntityHitResult Ii0O(LivingEntity param12, double param2) {
        Box v13;
        Vec3d v4 = KillAuraModule.ConfigSupport_OI0.player.method_5836(1.0f);
        float v5 = 0ooo.MoveFixModule() != null && 0ooo.OOii().Oii() ? 0ooo.EnumType_O0OO().ConfigSupport_OI0() : KillAuraModule.ConfigSupport_OI0.player.method_36454();
        float v6 = 0ooo.SprintResetModule() != null && 0ooo.O0Oo().Oii() ? 0ooo.GuiComponent().OIo() : KillAuraModule.ConfigSupport_OI0.player.method_36455();
        Vec3d v7 = this.Ii0i(v5, v6);
        double v8 = Math.max(param2, this.Ii0o(param2));
        Vec3d v10 = v4.add(v7.multiply(v8));
        double v11 = v8 * v8;
        if (this.Ii0o(param2) <= 0.0 && (v13 = KillAuraModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(v4, v10, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, (Entity)KillAuraModule.ConfigSupport_OI0.player))).getType() == HitResult.Type.BLOCK) {
            v11 = Math.min(v11, v4.squaredDistanceTo(v13.getPos()));
        }
        v13 = KillAuraModule.ConfigSupport_OI0.player.method_5829().stretch(v7.multiply(v8)).expand(1.0, 1.0, 1.0);
        return ProjectileUtil.raycast((Entity)KillAuraModule.ConfigSupport_OI0.player, (Vec3d)v4, (Vec3d)v10, (Box)v13, param1 -> !param1.isSpectator() && param1.canHit() && param1 == param12, (double)v11);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIii(LivingEntity param1, double param2) {
        PlayerEntity v9;
        if (param1 == KillAuraModule.ConfigSupport_OI0.player) return false;
        if (!param1.method_5805()) return false;
        if (param1.method_31481()) {
            return false;
        }
        if (!((Boolean)this.o0OO.HelpCommand()).booleanValue() && param1.method_5767()) {
            return false;
        }
        Vec3d v4 = KillAuraModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v5 = this.oOO(v4, param1.method_5829().expand((double)param1.method_5871()));
        boolean v6 = KillAuraModule.ConfigSupport_OI0.player.method_6057((Entity)param1);
        double v7 = v6 ? param2 : this.Ii0o(param2);
        if (v7 <= 0.0) return false;
        if (v4.distanceTo(v5) > v7) {
            return false;
        }
        if (!this.IioO((Entity)param1, ((Integer)this.oOII.HelpCommand()).intValue())) {
            return false;
        }
        if (param1 instanceof PlayerEntity) {
            v9 = (PlayerEntity)param1;
            if (!((Boolean)this.oOio.HelpCommand()).booleanValue()) {
                return false;
            }
            if (0ooo.O0Oi() != null && 0ooo.AntiBotModule().iIoO(v9)) {
                return false;
            }
            if (((Boolean)this.KbDelayModule.HelpCommand()).booleanValue() && RenderSupport_0I0.OIOi(v9)) {
                return false;
            }
        } else {
            if (param1 instanceof AnimalEntity) {
                return (Boolean)this.oOii.HelpCommand();
            }
            if (param1 instanceof HostileEntity) return (Boolean)this.oOiI.HelpCommand();
            if (!(param1 instanceof MobEntity)) return (Boolean)this.oOiI.HelpCommand();
            return (Boolean)this.oOiI.HelpCommand();
        }
        if (((Boolean)this.o0O0.HelpCommand()).booleanValue() && 0ooo.GuiSupport_O000() != null && 0ooo.O00o().CameraClipModule(v9)) {
            return false;
        }
        AntiBotModule v10 = AntiBotModule.iOoo();
        if (v10 == null) return true;
        if (!v10.iOoI((Entity)v9)) return true;
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void IIi0() {
        boolean v1 = KillAuraModule.ConfigSupport_OI0.player.method_24828();
        if (this.o0oO && !v1) {
            long v2;
            this.o0IO = v2 = System.currentTimeMillis();
            this.o0oo = v2 - this.o0oi <= 350L && KillAuraModule.ConfigSupport_OI0.player.method_18798().y > 0.08;
            this.o0oI = this.o0oo && this.III0(true);
            this.o0I0 = 0L;
        }
        if (!v1 && this.o0oo) {
            if (KillAuraModule.ConfigSupport_OI0.player.method_18798().y < -0.01 && this.o0I0 == 0L) {
                this.o0I0 = System.currentTimeMillis();
            }
        } else {
            this.o0I0 = 0L;
        }
        this.o0oO = v1;
        if (!v1) return;
        this.o0o0 = false;
        this.o0oo = false;
        this.o0oI = false;
        this.o0oi = 0L;
        this.o0IO = 0L;
        this.o0I0 = 0L;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIIi(boolean param1) {
        if (!this.IIIo(false, param1)) return false;
        if (!(KillAuraModule.ConfigSupport_OI0.player.field_6017 > 0.0)) return false;
        return true;
    }

    private Vec3d oOO(Vec3d param1, Box param2) {
        return new Vec3d(MathHelper.clamp((double)param1.x, (double)param2.minX, (double)param2.maxX), MathHelper.clamp((double)param1.y, (double)param2.minY, (double)param2.maxY), MathHelper.clamp((double)param1.z, (double)param2.minZ, (double)param2.maxZ));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIo0() {
        if (!this.IoOo()) return false;
        if ((Boolean)this.oOi0.HelpCommand() == false) return false;
        if (KillAuraModule.iooI()) return false;
        if (KillAuraModule.ConfigSupport_OI0.player == null) return false;
        if (this.o00o == null) return false;
        if (!this.IIii(this.o00o, (Double)this.ioO.HelpCommand())) return false;
        if (!KillAuraModule.IIoo(KillAuraModule.ConfigSupport_OI0.player.method_6047())) return false;
        return true;
    }

    private boolean IioO(Entity param1, float param2) {
        float[] v3 = this.IiOI((LivingEntity)param1);
        float v4 = 0ooo.EnumType_O00I() != null ? 0ooo.O00i().OiO(KillAuraModule.ConfigSupport_OI0.player.method_36454()) : KillAuraModule.ConfigSupport_OI0.player.method_36454();
        float v5 = Math.abs(MathHelper.wrapDegrees((float)(v3[0] - v4)));
        return v5 <= param2;
    }

    @EventHandler
    public void 0oi(ConfigSupport_O0IO param1) {
        Object v3;
        if (param1.0Oi() != EnumType_iii_0.OiO) {
            return;
        }
        if (KillAuraModule.iooI() || KillAuraModule.ConfigSupport_OI0.currentScreen != null || !this.IIoO()) {
            this.II0i();
            0ooo.RenderSupport_o0oo_1().0Oo(this);
            return;
        }
        if (KillAuraModule.ConfigSupport_OI0.options.jumpKey.wasPressed()) {
            this.o0oi = System.currentTimeMillis();
        }
        this.IIi0();
        List v2 = this.IIiI((Double)this.ioO.HelpCommand());
        this.o00o = this.IiOO(v2, false, this.o00o);
        if (this.o00o != null) {
            this.o00I = this.o00o;
        } else {
            v3 = this.IIiI((Double)this.oOIo.HelpCommand());
            this.o00I = this.IiOO((List)v3, true, this.o00I);
        }
        if (this.o00I != null) {
            v3 = this.IiOI(this.o00I);
            float v4 = this.oOIO.HelpCommand() == EnumType_oioo_6.NetworkSupport_OO00 ? 180.0f : (float)((Integer)this.iii.HelpCommand()).intValue();
            0ooo.EnumType_o0o0_0().HelpCommand(this, (float)v3[0], (float)v3[1], v4);
        } else {
            0ooo.O0oo().0Oo(this);
        }
        Object object = v3 = this.o00o != null ? this.Ii0O(this.o00o, (Double)this.ioO.HelpCommand()) : null;
        if (!(this.o00o != null && this.IIii(this.o00o, (Double)this.ioO.HelpCommand()) && this.IIoi(this.o00o) && this.IIIO())) {
            return;
        }
        if (!this.Ii00(this.o00o, (EntityHitResult)v3)) {
            return;
        }
        if (KillAuraModule.ConfigSupport_OI0.interactionManager != null) {
            KillAuraModule.ConfigSupport_OI0.interactionManager.attackEntity((PlayerEntity)KillAuraModule.ConfigSupport_OI0.player, (Entity)this.o00o);
            if (((Boolean)this.oOiO.HelpCommand()).booleanValue()) {
                KillAuraModule.ConfigSupport_OI0.player.method_6104(Hand.MAIN_HAND);
            }
            if (!KillAuraModule.ConfigSupport_OI0.player.method_24828()) {
                this.o0o0 = true;
                this.o0oI = false;
            }
            if (this.BindCommand.HelpCommand() == EnumType_O0OO.oOi && v2.size() > 1) {
                this.o00i = (this.o00i + 1) % v2.size();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIiO(LivingEntity param1) {
        float v5;
        if (param1 == null) {
            return false;
        }
        if (!this.III0(false)) return false;
        if (KillAuraModule.ConfigSupport_OI0.player.method_18798().y < -0.08) {
            return false;
        }
        float v2 = KillAuraModule.ConfigSupport_OI0.player.method_7279();
        if (v2 <= 0.0f) {
            return false;
        }
        float v3 = KillAuraModule.ConfigSupport_OI0.player.method_7261(0.5f);
        float v4 = Math.max(0.0f, v2 * 0.9f - v3 * v2);
        float v6 = Math.max(v4, v5 = (float)(KillAuraModule.ConfigSupport_OI0.player.method_18798().y / 0.08));
        float v8 = this.IIio(v6, v2);
        if (!(0.375f > v8)) return false;
        if (this.IIII()) return false;
        return true;
    }

    private Vec3d IiOi(LivingEntity param1, Vec3d param2) {
        Box v3 = param1.method_5829().expand((double)param1.method_5871());
        Vec3d v4 = this.oOO(param2, v3);
        double v5 = this.Ii0o((Double)this.oOIo.HelpCommand());
        if (param2.distanceTo(v4) <= v5 || this.Ii0I(v4)) {
            return v4;
        }
        Vec3d v7 = v3.getCenter();
        Vec3d[] v8 = new Vec3d[]{v7, new Vec3d(v7.x, v3.maxY - 0.1, v7.z), param1.method_33571(), new Vec3d(v7.x, (v3.minY + v3.maxY) * 0.5, v7.z), new Vec3d(v7.x, v3.minY + 0.2, v7.z)};
        Vec3d v9 = v4;
        double v10 = Double.MAX_VALUE;
        for (int v14 = 0; v14 < 5; ++v14) {
            Vec3d v15 = v8[v14];
            double v16 = param2.distanceTo(v15);
            if (v16 >= v10 || !(v16 <= v5) && !this.Ii0I(v15)) continue;
            v10 = v16;
            v9 = v15;
        }
        return v9;
    }

    private float[] IiOI(LivingEntity param1) {
        Vec3d v2 = KillAuraModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v3 = this.IiOi(param1, v2);
        double v4 = v3.x - v2.x;
        double v6 = v3.y - v2.y;
        double v8 = v3.z - v2.z;
        double v10 = Math.sqrt(v4 * v4 + v8 * v8);
        float v12 = (float)(Math.toDegrees(Math.atan2(v8, v4)) - 90.0);
        float v13 = (float)(-Math.toDegrees(Math.atan2(v6, v10)));
        float v14 = 0ooo.NetworkSupport_o0oi_2() != null && 0ooo.O0oi().Oii() ? 0ooo.ConfigSupport_O0IO().ConfigSupport_OI0() : KillAuraModule.ConfigSupport_OI0.player.method_36454();
        float v15 = 0ooo.RenderSupport_O0I0() != null && 0ooo.O0Io().Oii() ? 0ooo.EnumType_O0II().OIo() : KillAuraModule.ConfigSupport_OI0.player.method_36455();
        return new float[]{v14 + MathHelper.wrapDegrees((float)(v12 - v14)), MathHelper.clamp((float)(v15 + MathHelper.wrapDegrees((float)(v13 - v15))), (float)-90.0f, (float)90.0f)};
    }

    static {
        __k__gH4it = KillAuraModule.__k__gH4it(-6006096290851590639L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\ucf03\u9de0\u4238\u1750\u902d\ufcbd\u6e70\u41b8\ucc6e\u9e83\u4150\u1474\u93c1\uff1c\u6d28\u422a\ucdd9\u9f29\u40b1\u156f\u92f0\ufed5\u6c2c\u4389\uca7b\u9805\u4708\u123b\u95c4\uf966\u6b47\u4455\ucb84\u99e3\u464c\u13af\u94db\uf8a7\u6a97\u45ee\ucbed\u9ac7\u4544\u1059\u9730\ufba4\u69d2\u4699\uc82f\u9b3b\u4426\u1148\u9692\ufa01\u68c8\u47b3\uc9a7\u94a4\u4b0e\u1e7b\u99a7\uf525\u6740\u48b7\uc63d\u9542\u4a68\u1f39\u989f\uf403\u66ef\u49c5\uc70a\u9517\u49d6\u1c3f\u9b9f\uf719\u6588\u4ab8\uc4f4\u963a\u4842\u1dcd\u9af3\uf6fd\u64a9\u4b3a\uc54b\u97f4\u4f30\u1af9\u9d99\uf165\u6322\u4cc9\uc2a0\u90b3\u4f03\u1b1b\u9c93\uf0b6\u6230\u4d60\uc3e8\u91d8\u4e8a\u18b7\u9f2a\uf30e\u61fc\u4e6a\uc05e\u929e\u4d6c\u19b0\u9eba\uf2c5\u6048\u4ffa\uc1a6\u93ec\u4c3c\u06fa\u81a5\ued54\u7f5b\u50d6\ude41\u8c87\u5328\u0659\u80fc\uec90\u7e9d\u5187\udf59\u8d87\u5253\u0723\u8343\uef2d\u7dad\u52be\udc3b\u8e46\u51b2\u044e\u825d\ueec2\u7c67\u53d5\uddfe\u8fd3\u50a6\u05c2\u8533\ue9f0\u7b7b\u545c\uda39\u883b\u57c3\u02bf\u8523\ue861\u7a74\u55ac\udb37\u89e9\u56e0\u0345\u842b\uebc1\u7940\u56df\ud811\u8a86\u55354\u87f7\uea1f\u788e\u5722\ud935\u8bab\u544d\u0126\u866b\ue5cc\u77e0\u58c0\ud6db\u84e5\u5ba1\u0efa\u89e2\ue5b1\u76ee\u59b6\ud7ec\u8547\u5ad4\u0f30\u8811\ue423\u75f1\u5aa3\ud4e5\u86db\u59cf\u0c5a\u8b52\ue7a3\u74e4\u5bb6\ud533\u8754\u586a\u0d27\u8ac4\ue6f4\u7304\u5cec\ud2d7\u80aa\u5fd6\u0a71\u8d4b\ue108\u739c\u5dae\ud35b\u816d\u5e52\u0b89\u8c5c\ue02a\u725e\u5ef5\ud0b9\u8212\u5df2\u08b0\u8ff8\ue3b4\u7143\u5fe4\ud145\u833d\u5c88\u099a\u8e7e\ue219\u700d\u6077\ueefa\ubc6c\u63a6\u36cb\ub1ec\udd99\u4f96\u6031\uef73\ubd4f\u6216\u3711\ub0d6\udc8e\u4efc\u611c\ueca4\ubede\u6152\u3470\ub337\udf76\u4db1\u6282\ued4b\ubf7d\u6017\u35f4\ub2f0\ude09\u4ce0\u6387\uea01\ub8d5\u675a\u32fb\ub52a\ud98f\u4b88\u646e\uea5f\ub995\u6688\u33d0\ub4a6\ud84d\u4a2b\u658e\ueb9e\ubaa0\u650f\u30d2\ub796\udbcd\u4934\u66d2\ue8ad\ubb3b\u6459\u3129\ub68b\uda88\u48be\u6757\ue904\ub421\u6b04\u3e99\ub93b\ud54d\u47a3\u6828\ue674\ub4a3\u6a3a\u3f3d\ub8fa\ud4c8\u46b5\u690e\ue790\ub5fd\u6979\u3c5f\ubbe3\ud7f1\u45ae\u6ac2\ue423\ub64d\u68bf\u3db3\ubabe\ud6f5\u441d\u6b4e", "\uce12\u9c6f\u43ea\u1629\u9167\ufd74\u6e18\u41a8", "\uce7b\u9cb8\u431b\u168e\u91d1"};
        __rP__gH4it2 = new String[]{"\uce6e\u9cb4\u431b\u16fb\u91a8\ufd0c\u6e8c\u4135\ucf70\u9dde", "\uce78\u9cbb\u4300\u1682\u91d8\ufd7f\u6ef5\u412a\ucf74\u9dad\u4218\u17f6\u90a6\ufc65\u6ddf\u4269\ucc48\u9e87\u41cd\u14fa"};
        __rP__gH4it3 = new String[]{"\uce6c\u9cba\u4315\u16f9\u91aa\ufd0a\u6e8a\u4137\ucf72\u9de0", "\uce6e\u9cad\u430a", "\uce7e\u9c99\u43e3\u16b3\u91d8\ufd3f\u6f71"};
        __p__gH4it = new String[]{"\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e", "\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3", "\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435", "\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513", "\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5", "\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912", "\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112", "\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767\uf78c", "\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020", "\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b", "\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19", "\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f", "\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db", "\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d", "\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083", "\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586", "\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a", "\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7", "\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219", "\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263", "\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849", "\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b", "\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f", "\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc", "\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501", "\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc", "\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1", "\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43", "\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b", "\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a", "\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0", "\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a", "\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7", "\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc", "\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201", "\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b", "\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05", "\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94", "\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328", "\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569", "\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a", "\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4", "\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21", "\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff", "\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27", "\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93", "\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d", "\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f", "\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158", "\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd", "\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751", "\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb", "\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd", "\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", "\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102", "\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d", "\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97", "\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595", "\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731", "\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0\uf3c5\uf3ea\uf40f", "\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537", "\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330", "\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e", "\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7", "\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639", "\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de", "\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609", "\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7", "\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479", "\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a", "\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77", "\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35", "\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc", "\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636", "\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8\uebed", "\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3", "\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b", "\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5", "\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8", "\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb", "\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482", "\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656", "\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231", "\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037", "\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189", "\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f", "\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840", "\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519", "\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5", "\uea14\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f", "\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36", "\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef", "\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab", "\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32", "\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d", "\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460"};
        __c__J7Um6 = new Object[][]{{"\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d", -253747677279149864L, "\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4", -229944880, "\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f", true, "\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7", true, "\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807", true, "\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00", true}, {"\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc", -253747677279084327L, "\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3", -1137928329, "\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385", false, "\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8", false, "\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977", false, "\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7", false}, {"\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8", -253747677279018790L, "\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43", 1854200990, "\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab", true, "\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb", true, "\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4", true, "\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093", true}, {"\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7", -253747677278953253L, "\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69", 427557413, "\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac", false, "\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b", false, "\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b", false, "\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d", false}, {"\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827", -253747677278887716L, "\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f", -875279540, "\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf", true, "\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8", true, "\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77", true, "\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd", true}, {"\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d", -253747677278822179L, "\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090", 2051911827, "\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f", false, "\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f", false, "\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31", false, "\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3", false}, {"\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73", -253747677278756642L, "\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3", 606467642, "\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac", true, "\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b", true, "\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1", true, "\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609", true}, {"\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74", -253747677278691105L, "\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223", -694337727, "\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063", false, "\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815", false, "\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7", false, "\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573\uf598", false}, {"\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97", -253747677278625568L, "\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290", -2123012888, "\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f", true, "\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985", true, "\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed", true, "\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f\uf674", true}, {"\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07", -253747677278560031L, "\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347", 871279119, "\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9", false, "\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab", false, "\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c", false, "\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053", false}, {"\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74", -253747677278494494L, "\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423", -498691242, "\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469", true, "\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1", true, "\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158", true, "\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3", true}, {"\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b", -253747677278428957L, "\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8\uf5dd", -1405167363, "\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f", false, "\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60", false, "\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337", false, "\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9", false}, {"\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07", -253747677278363420L, "\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d", 1586896388, "\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5", true, "\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c", true, "\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7", true, "\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f", true}, {"\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1", -253747677278297883L, "\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073", 151930795, "\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644", false, "\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b", false, "\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd", false, "\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510", false}, {"\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231", -253747677278232346L, "\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199", -1142453006, "\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720", true, "\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b", true, "\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3", true, "\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533", true}, {"\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357", -253747677278166809L, "\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128", 1784672793, "\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff", false, "\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1", false, "\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4", false, "\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3", false}, {"\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d", -253747677278101272L, "\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204", 339164064, "\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f", true, "\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7", true, "\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017", true, "\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710", true}, {"\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c", -253747677278035735L, "\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3", -961584953, "\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95", false, "\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8", false, "\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187", false, "\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7", false}, {"\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8", -253747677277970198L, "\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553", 1895868014, "\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb", true, "\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb", true, "\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4", true, "\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3", true}, {"\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7", -253747677277904661L, "\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679", 603516853, "\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc", false, "\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b", false, "\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab", false, "\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d", false}, {"\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037", -253747677277839124L, "\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f", -766454564, "\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf", true, "\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8", true, "\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387", true, "\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd", true}, {"\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d", -253747677277773587L, "\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0", -1664607645, "\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f", false, "\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f", false, "\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541", false, "\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3", false}, {"\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283", -253747677277708050L, "\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3", 1319125898, "\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc", true, "\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b", true, "\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1", true, "\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19", true}, {"\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384", -253747677277642513L, "\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33", -115767087, "\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073", false, "\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025", false, "\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7", false, "\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83\ueda8", false}, {"\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7", -253747677277576976L, "\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0", -1410216328, "\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f", true, "\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195", true, "\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd", true, "\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84", true}, {"\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517", -253747677277511439L, "\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57", 1516844959, "\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309", false, "\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb", false, "\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c", false, "\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063", false}, {"\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584", -253747677277445902L, "\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33", 79789350, "\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479", true, "\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1", true, "\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968", true, "\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3", true}, {"\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b", -253747677277380365L, "\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded", -1229282739, "\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f", false, "\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370", false, "\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47", false, "\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9", false}, {"\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717", -253747677277314828L, "\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d", 1628629908, "\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5", true, "\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c", true, "\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7", true, "\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f", true}, {"\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac\ue8d1", -253747677277249291L, "\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083", 327864635, "\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654", false, "\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b", false, "\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd", false, "\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520", false}, {"\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41", -253747677277183754L, "\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9", -1033759166, "\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730", true, "\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b", true, "\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03", true, "\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543", true}, {"\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67", -253747677277118217L, "\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138", -1931845655, "\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f", false, "\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1", false, "\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004", false, "\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3", false}, {"\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43\uec68\uec8d", -253747677277052680L, "\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214", 1051952432, "\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f", true, "\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7", true, "\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027", true, "\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720", true}, {"\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c", -253747677276987143L, "\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3", -383006121, "\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5", false, "\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8", false, "\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172\uf197", false, "\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7", false}, {"\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8", -253747677276921606L, "\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563", -1685900290, "\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb", true, "\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b", true, "\uf06d\uf092\uf0b7\uf0dc\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df\uf204", true, "\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3", true}, {"\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7", -253747677276856069L, "\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689", 1249605893, "\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc", false, "\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b", false, "\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb", false, "\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d", false}, {"\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047", -253747677276790532L, "\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af", -186859860, "\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef", true, "\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8", true, "\uf26f\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397", true, "\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd", true}, {"\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d", -253747677276724995L, "\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0", -1498093581, "\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f", false, "\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f", false, "\uf370\uf395\uf3ba\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507\uf52c\uf551", false, "\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503", false}, {"\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293", -253747677276659458L, "\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3", 1361849626, "\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc", true, "\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b", true, "\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1", true, "\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629", true}, {"\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394", -253747677276593921L, "\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243", 58987169, "\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883", false, "\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010\uf035", false, "\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7", false, "\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8", false}, {"\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7", -253747677276528384L, "\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0", -1300472888, "\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f", true, "\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5", true, "\uf673\uf698\uf6bd\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d", true, "\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694", true}, {"\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527", -253747677276462847L, "\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367", 2094367087, "\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4\ueb19", false, "\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb", false, "\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c", false, "\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e\ue873", false}, {"\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594", -253747677276397310L, "\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443", 793626294, "\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89", true, "\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1", true, "\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178", true, "\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3", true}, {"\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b", -253747677276331773L, "\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8\ue5fd", -651882531, "\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf", false, "\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380", false, "\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d\ue332\ue357", false, "\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09", false}, {"\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727", -253747677276266236L, "\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d", -1952615068, "\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5", true, "\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c", true, "\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7", true, "\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f", true}, {"\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc\ue0e1", -253747677276200699L, "\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893", 980859531, "\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64", false, "\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b", false, "\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed", false, "\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30", false}, {"\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251", -253747677276135162L, "\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9", -454106158, "\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40", true, "\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab", true, "\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713", true, "\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53", true}, {"\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377", -253747677276069625L, "\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948", -1757009543, "\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f", false, "\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1", false, "\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814", false, "\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3", false}, {"\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d", -253747677276004088L, "\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24", 1094610560, "\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f", true, "\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7", true, "\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837", true, "\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30", true}, {"\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c", -253747677275938551L, "\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03", -208251865, "\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5", false, "\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8", false, "\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7", false, "\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7", false}, {"\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508", -253747677275873014L, "\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73", -1576034994, "\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db", true, "\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b", true, "\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14", true, "\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3", true}, {"\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7", -253747677275807477L, "\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99", 1827127957, "\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc", false, "\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b", false, "\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb", false, "\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d", false}, {"\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857", -253747677275741940L, "\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf", 526321724, "\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff", true, "\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8", true, "\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7", true, "\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed", true}, {"\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d", -253747677275676403L, "\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0", -919113405, "\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f", false, "\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af", false, "\ueb80\ueba5\uebca\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c\ued61", false, "\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513", false}, {"\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3", -253747677275610866L, "\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3", 2074654442, "\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc", true, "\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b", true, "\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1", true, "\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639", true}, {"\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4", -253747677275545329L, "\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253", 704707633, "\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093", false, "\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845", false, "\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7", false, "\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8", false}, {"\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7", -253747677275479792L, "\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0", -721935016, "\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f", true, "\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5", true, "\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d", true, "\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f\uf6a4", true}, {"\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37", -253747677275414255L, "\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377", -2024772865, "\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304\ue329", false, "\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb", false, "\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac", false, "\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083", false}, {"\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4", -253747677275348718L, "\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453", 835211270, "\ue249\ue26e\ue293\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499", true, "\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01", true, "\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188", true, "\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3", true}, {"\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b", -253747677275283181L, "\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d", -475948627, "\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf", false, "\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90", false, "\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367", false, "\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319", false}, {"\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37", -253747677275217644L, "\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d", -1843798284, "\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5", true, "\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c", true, "\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7", true, "\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f", true}, {"\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc\uf0f1", -253747677275152107L, "\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3", 1559299099, "\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674", false, "\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b", false, "\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd", false, "\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540", false}, {"\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261", -253747677275086570L, "\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9", 258559394, "\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750", true, "\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb", true, "\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723", true, "\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563", true}, {"\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387", -253747677275021033L, "\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158", -1178422583, "\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f", false, "\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1", false, "\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024", false, "\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3", false}, {"\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463\uf488\uf4ad", -253747677274955496L, "\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234", 1807415312, "\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f", true, "\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207", true, "\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047", true, "\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740", true}, {"\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c", -253747677274889959L, "\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413", 437395895, "\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5", false, "\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308", false, "\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7", false, "\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7", false}, {"\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518", -253747677274824422L, "\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583", -997562658, "\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb", true, "\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b", true, "\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224", true, "\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3", true}, {"\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7", -253747677274758885L, "\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9", 2003020901, "\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec", false, "\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b", false, "\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db", false, "\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d", false}, {"\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067", -253747677274693348L, "\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf", 568038796, "\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f", true, "\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508", true, "\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7", true, "\ue9ad\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd", true}, {"\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d", -253747677274627811L, "\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0", -743187757, "\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f", false, "\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf", false, "\ue390\ue3b5\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571", false, "\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23", false}, {"\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3", -253747677274562274L, "\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3", -2111111046, "\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec", true, "\uf573\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b", true, "\ue491\ue4b6\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1", true, "\uebaf\uebd4\uebf9\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49", true}, {"\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4", -253747677274496737L, "\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63", 1283672449, "\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3", false, "\uf674\uf699\uf6be\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055", false, "\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807", false, "\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8", false}, {"\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7", -253747677274431200L, "\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0", -10186968, "\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f", true, "\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5", true, "\ue693\ue6b8\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d", true, "\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4", true}, {"\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547", -253747677274365663L, "\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87", -1445137329, "\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339", false, "\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb", false, "\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc", false, "\ueeb2\ueed7\ueefc\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093", false}, {"\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4", -253747677274300126L, "\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63", 1538538902, "\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9", true, "\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411", true, "\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998", true, "\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203", true}, {"\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", -253747677274234589L, "\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d", 170681149, "\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf", false, "\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0", false, "\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77", false, "\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329", false}, {"\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747", -253747677274169052L, "\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d", -1266309052, "\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5", true, "\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c", true, "\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7", true, "\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f", true}, {"\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901", -253747677274103515L, "\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3", 1736282603, "\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684", false, "\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b", false, "\ueb98\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d", false, "\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550", false}, {"\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71", -253747677274037978L, "\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9", 299226930, "\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760", true, "\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb", true, "\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33", true, "\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573", true}, {"\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97", -253747677273972441L, "\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168", -1068688295, "\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f", false, "\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1", false, "\ued9a\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034", false, "\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f\uf674\uf699\uf6be\uf6e3", false}, {"\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd", -253747677273906904L, "\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244", 1915045344, "\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af", true, "\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17", true, "\uee9b\ueec0\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057", true, "\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750", true}, {"\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c", -253747677273841367L, "\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423", 1017023239, "\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5", false, "\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18", false, "\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7", false, "\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007", false}, {"\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28", -253747677273775830L, "\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593", -277417810, "\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb", true, "\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b", true, "\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234", true, "\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3", true}, {"\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07", -253747677273710293L, "\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9", -1712440843, "\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc", false, "\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab", false, "\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb", false, "\ue0bc\ue0e1\ue106\ue12b\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d", false}, {"\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077", -253747677273644756L, "\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df", 1212579612, "\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f", true, "\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18", true, "\uf29f\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7", true, "\ue1bd\ue1e2\ue207\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d", true}, {"\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d", -253747677273579219L, "\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0", -96492381, "\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f", false, "\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf", false, "\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581", false, "\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533", false}, {"\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3", -253747677273513682L, "\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103", -1533547062, "\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc", true, "\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab", true, "\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1", true, "\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659", true}, {"\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4", -253747677273448145L, "\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273", 1460654865, "\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3", false, "\uee84\ueea9\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065", false, "\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017", false, "\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8", false}, {"\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7", -253747677273382608L, "\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0", 31922360, "\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f", true, "\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5", true, "\uf6a3\uf6c8\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d", true, "\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4", true}, {"\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557", -253747677273317071L, "\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397", -1335934497, "\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49", false, "\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb", false, "\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc", false, "\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3", false}, {"\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4", -253747677273251534L, "\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473", 1647347558, "\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9", true, "\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421", true, "\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8", true, "\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13", true}, {"\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", -253747677273185997L, "\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d", 749259917, "\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf", false, "\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0", false, "\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387", false, "\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39", false}, {"\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757", -253747677273120460L, "\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d", -553634348, "\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05", true, "\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c", true, "\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7", true, "\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f", true}, {"\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111", -253747677273054923L, "\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3", -1980204165, "\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94", false, "\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b", false, "\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d", false, "\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60", false}, {"\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281", -253747677272989386L, "\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9", 944873602, "\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70", true, "\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db", true, "\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743", true, "\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83", true}, {"\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7", -253747677272923849L, "\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978", -355867095, "\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f", false, "\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101", false, "\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844", false, "\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3", false}};
        byte[] v0 = "O.\u00bb-\u00e6\u00d0\u0016m\u001a5\u00db\u0001\u0002yF\u00f7\u00a5\u0097\"\u0002+\u00a8ZL\u001f\u00a3\u0093^\u0017\u00139\u0098\u00e8M\u00af\u00f2\u00f0\u00ea\u0091\u001byQ\u00af\f\u0013\u00e1\u00dcd\u00b3\u00a5\u00d5\u0005\u00a9\\\u00deV#\"\u00f5>\u0094p^Z\u00b1\u00cc\u00ab\u0004\u0094\u00ae\u00c9P\u00bea\u001d\n\u009c\u00bc\u00a6%HD\u0091\u00e0\u00e8@\u009f\u00bf\u00ef\u0092\u00eb\u00dc\u008a\u00d0\u001cD\f\u00dd \u0006\u00f8;\u00f6\u00d5<\u008e\u00a1\u00a2I\u008b2\u00d7\u0082\u00c0_\u00bd\u00c1X\u009e_b\u00aa\u0007\u00ff\u00d6\u00c1\u0085{\u008d\u00c9+\u00a4\u00b7}{\u00d2\u00ad\u00b1X\u00d6\u0000\u00c8C\u00e3\u00c7x\u00a1\u00a3\u0006?\u0091\u0090\u001a\u00f5\u00bd'`\u0005\u0085\u0011\u00d5\u0015\u00a0b\u0088\u00ac\u00f2\u00d9#\u00ff\u008b\u0090\u0088\u0004\u00ce\u00a2\r\u0098F\u00f9L\u00c2\u0018G1\u00ad6\u00e3\u00d8\u0019~\u00ad\u00d7\u00eb\u00e2Gi\u009cH\u00a3\u00d8\u00b1\u009f\u0085\u0092\u0006_\u00be\u00d9%\u009c\u00f7\u00c9\u009eR\u00b3\u0017\u00b21\u0082W\u00c1\u00ba\u00e1\u00fbDu\u00ec\u00a0\u0005\u00da\u009b\u000f\u00bb\u00f9\u001c\u00bf/\u0010\u00c8\u00e5\u00ccA=\u0003\u00a9\u0015\u00c1\u0001\u00fb3\u001f\u008d\fSZ\u00b6\u00a2%\u00b6'\u00f4\u00f0\u00e4\u0007\u00f9\u009dd\u0015\u00eb\u0092\u00c1\u00d8`\u00c1\u001d\u00ec\u000b\u00c7G/\u00db\u008c\u0091#|\u009eJm{\u00b9\u00a6\u0001\u00c2\u008e\u009b\u00cb\u0003c\u0085\u0085\b%s\u0002>\u00fc\u009f\u00ad\u0090\"7)\u00bd\u00a2l\u00b8\u00dd\u00a0\u00ba\u0088\u00af\u00c7\u00a40\u00e0\u0085\u00bd\u00c0\u00d5\u00f1\b\u00f9m\u009b\u0093,\u0083\u00aar\u00f8L\u0098G\u0087+d\u0096\u00ad@#\u00c3".getBytes("ISO_8859_1");
        Object[] v1 = "4\u008b\u00bf\u0082\u00f6C\u00a0\u00a3".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1639756550;
                case 1 -> 1051864017;
                case 2 -> -2106796695;
                case 3 -> -828115852;
                case 4 -> 1902922213;
                case 5 -> -1526021033;
                case 6 -> 1034550963;
                case 7 -> 1031683707;
                case 8 -> -364799025;
                case 9 -> -606937673;
                case 10 -> 117340549;
                case 11 -> -313249641;
                case 12 -> -1771024026;
                case 13 -> -407245561;
                case 14 -> -141048541;
                case 15 -> 1538737438;
                case 16 -> 0x7BB7FBF;
                case 17 -> 835742554;
                case 18 -> 432109202;
                case 19 -> -818894331;
                case 20 -> 555480265;
                case 21 -> 263314853;
                case 22 -> 381263026;
                case 23 -> -795757044;
                case 24 -> -1005239604;
                case 25 -> -778250997;
                case 26 -> 1918972415;
                case 27 -> 375235022;
                case 28 -> 503628885;
                case 29 -> -1851989919;
                case 30 -> -1068530758;
                case 31 -> 194222902;
                case 32 -> 1957044462;
                case 33 -> -122321605;
                case 34 -> 886682917;
                case 35 -> 2147323278;
                case 36 -> 180162897;
                case 37 -> 842849850;
                case 38 -> 705544010;
                case 39 -> -577168448;
                case 40 -> -292784470;
                case 41 -> -175675121;
                case 42 -> -1498246661;
                case 43 -> -369771574;
                case 44 -> -1480657467;
                case 45 -> -2115102421;
                case 46 -> -1839907659;
                case 47 -> 750516348;
                case 48 -> -1176133123;
                case 49 -> 1817366466;
                case 50 -> 260393140;
                case 51 -> 1799302935;
                case 52 -> 2146796103;
                case 53 -> 1859564316;
                case 54 -> -488599877;
                case 55 -> -1254334742;
                case 56 -> -1133188387;
                case 57 -> -21422823;
                case 58 -> -323922729;
                case 59 -> -2046960727;
                case 60 -> 1435889711;
                case 61 -> 680332431;
                case 62 -> -2115538429;
                case 63 -> -666566638;
                case 64 -> -1802796133;
                case 65 -> 861819350;
                case 66 -> -94390690;
                case 67 -> 1742219114;
                case 68 -> 674948396;
                case 69 -> 1597959652;
                case 70 -> -1812272874;
                case 71 -> -89880574;
                case 72 -> 1698927316;
                case 73 -> -28814379;
                case 74 -> -164097219;
                case 75 -> -2109159395;
                case 76 -> 1416874033;
                case 77 -> 1604550626;
                case 78 -> 924574484;
                case 79 -> 1591105033;
                case 80 -> 627068902;
                case 81 -> -169469951;
                case 82 -> 1785293134;
                case 83 -> -2115706016;
                case 84 -> 1631200649;
                case 85 -> -1404954751;
                case 86 -> 231633988;
                case 87 -> -1225486869;
                case 88 -> -1704644189;
                case 89 -> 334009973;
                case 90 -> 1105743244;
                case 91 -> -791639566;
                case 92 -> 1811883240;
                case 93 -> 2077742029;
                case 94 -> -953442782;
                case 95 -> -462589570;
                case 96 -> 162932633;
                case 97 -> -598244111;
                case 98 -> 1627700275;
                case 99 -> 1574663851;
                case 100 -> -935130882;
                case 101 -> -203030222;
                case 102 -> 791915094;
                case 103 -> 2090211546;
                case 104 -> 1372777405;
                case 105 -> -393482910;
                case 106 -> -4620823;
                case 107 -> 1459630099;
                case 108 -> 1407765617;
                case 109 -> 229858251;
                case 110 -> -1193078874;
                case 111 -> -1300994304;
                case 112 -> -1912645984;
                case 113 -> 519738932;
                case 114 -> 223809319;
                case 115 -> -482384096;
                case 116 -> 901235101;
                case 117 -> -750120199;
                case 118 -> 1640754311;
                case 119 -> 928669933;
                case 120 -> -1628777409;
                case 121 -> 1408773084;
                case 122 -> 2003577432;
                case 123 -> -1391349880;
                case 124 -> 935150160;
                case 125 -> 154970182;
                case 126 -> 1161171362;
                case 127 -> 2100085228;
                case 128 -> -215425545;
                case 129 -> -1428077104;
                case 130 -> -938618175;
                case 131 -> 1005159411;
                case 132 -> -1283425016;
                case 133 -> 1765514084;
                case 134 -> 856134499;
                case 135 -> -2039549332;
                case 136 -> -1299414486;
                case 137 -> -766493564;
                case 138 -> 836826033;
                case 139 -> -1333812919;
                case 140 -> 305809015;
                case 141 -> 1220926568;
                case 142 -> 620231535;
                case 143 -> 426657629;
                case 144 -> -4650948;
                case 145 -> 558549368;
                case 146 -> -897083480;
                case 147 -> 1961078012;
                case 148 -> 931330669;
                case 149 -> -427941386;
                case 150 -> 2060450627;
                case 151 -> -1121548078;
                case 152 -> 1534695573;
                case 153 -> -1366197746;
                case 154 -> 1716756740;
                case 155 -> -695524391;
                case 156 -> -920096210;
                case 157 -> -1611729040;
                case 158 -> 2092414539;
                case 159 -> 1606014263;
                case 160 -> 1437726758;
                case 161 -> -1233456774;
                case 162 -> 1113662315;
                case 163 -> 1306045005;
                case 164 -> 723389848;
                case 165 -> 13087463;
                case 166 -> -1059743341;
                case 167 -> -409611638;
                case 168 -> -1610982458;
                case 169 -> 117766531;
                case 170 -> 1819949552;
                case 171 -> 1809161499;
                case 172 -> 850968798;
                case 173 -> -203675688;
                case 174 -> -1212168659;
                case 175 -> 966796921;
                case 176 -> 1178090050;
                case 177 -> -1257936157;
                case 178 -> -1570341261;
                case 179 -> 68680019;
                case 180 -> 145308541;
                case 181 -> 1567700109;
                case 182 -> -780007224;
                case 183 -> 1879329383;
                case 184 -> 1237729977;
                case 185 -> 279238421;
                case 186 -> 881330770;
                case 187 -> 772707167;
                case 188 -> 1835409280;
                case 189 -> 228596753;
                case 190 -> 1664770015;
                case 191 -> 377268234;
                case 192 -> 469586202;
                case 193 -> -1433593962;
                case 194 -> 1374159176;
                case 195 -> 640523300;
                case 196 -> -1745337584;
                case 197 -> 1222292047;
                case 198 -> -1282533584;
                case 199 -> 1110508824;
                case 200 -> 2100330971;
                case 201 -> 1047892255;
                case 202 -> 102022027;
                case 203 -> -323651544;
                case 204 -> 861603156;
                case 205 -> 467293110;
                case 206 -> 1517908653;
                case 207 -> 0x44844840;
                case 208 -> 359548856;
                case 209 -> -2097717147;
                case 210 -> 460548482;
                case 211 -> -1123161924;
                case 212 -> -1830636857;
                case 213 -> 1334030531;
                case 214 -> 1866194523;
                case 215 -> -1989443681;
                case 216 -> -1265066434;
                case 217 -> 835930788;
                case 218 -> 115826445;
                case 219 -> 502234323;
                case 220 -> 307952220;
                case 221 -> 411658641;
                case 222 -> -714948620;
                case 223 -> -349682062;
                case 224 -> -2019147068;
                case 225 -> 387153310;
                case 226 -> -68099336;
                case 227 -> 1473600668;
                case 228 -> -1160810001;
                case 229 -> -1915258506;
                case 230 -> 1479854512;
                case 231 -> 1719693089;
                case 232 -> -1189150726;
                case 233 -> -1733089991;
                case 234 -> 1252361525;
                case 235 -> -1804509963;
                case 236 -> -1322243666;
                case 237 -> -2012124272;
                case 238 -> 704636287;
                case 239 -> -1546844994;
                case 240 -> -484111185;
                case 241 -> -206189748;
                case 242 -> 858004903;
                case 243 -> -954439508;
                case 244 -> -1471917243;
                case 245 -> -877826336;
                case 246 -> -888427223;
                case 247 -> 981111942;
                case 248 -> 1906145857;
                case 249 -> 1591250337;
                case 250 -> 1818641121;
                case 251 -> -1015204966;
                case 252 -> -1952648082;
                case 253 -> 1182147988;
                case 254 -> 1379037240;
                case 255 -> -304819367;
                default -> -1823888425;
            });
        } while (v2 != 352);
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
            Object[] objectArray = new Object[24];
            v1 = objectArray;
            o0Io = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private LivingEntity IiOO(List param1, boolean param22, LivingEntity param3) {
        if (param1.isEmpty()) {
            return null;
        }
        param1.sort(Comparator.comparingDouble(param2 -> this.IiO0((LivingEntity)param2, param22)));
        if (param3 != null && param1.contains(param3)) {
            if (param22) return param3;
            if (this.BindCommand.HelpCommand() == EnumType_O0OO.RenderSupport_ooi_1) {
                return param3;
            }
        }
        if (param22) return (LivingEntity)param1.getFirst();
        if (this.BindCommand.HelpCommand() != EnumType_O0OO.oOi) return (LivingEntity)param1.getFirst();
        if (param1.size() <= 1) return (LivingEntity)param1.getFirst();
        this.o00i %= param1.size();
        return (LivingEntity)param1.get(this.o00i);
    }

    private boolean IIII() {
        return this.IIIi(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        if ((Boolean)this.o0Oo.HelpCommand() == false) return;
        if (this.o00o == null) return;
        RenderSupport_oio_2.NetworkSupport_i0i_2(param1.0ii(), this.o00o, param1.O0i(), ((Float)this.o0OI.HelpCommand()).floatValue(), (Color)this.o00O.HelpCommand(), (Color)this.o000.HelpCommand(), ((Float)this.o0Oi.HelpCommand()).floatValue());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIoi(LivingEntity param1) {
        if (KillAuraModule.ConfigSupport_OI0.player == null) return false;
        if (param1 == null) return false;
        if (!(KillAuraModule.ConfigSupport_OI0.player.method_7261(0.5f) > 0.9f)) return false;
        return true;
    }

    private boolean o0O0() {
        Item v1 = KillAuraModule.ConfigSupport_OI0.player.method_6047().getItem();
        return KillAuraModule.IIoI(v1) || v1 instanceof AxeItem || v1 instanceof MaceItem || v1 instanceof TridentItem;
    }

    @Override
    public void 0oI() {
        this.o00o = null;
        this.o00I = null;
        this.o0oO = false;
        this.o0o0 = false;
        this.o0oo = false;
        this.o0oI = false;
        this.o0oi = 0L;
        this.o0IO = 0L;
        this.o0I0 = 0L;
        0ooo.O0Ii().0Oo(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean III0(boolean param1) {
        if (KillAuraModule.ConfigSupport_OI0.player.method_5799()) return false;
        if (KillAuraModule.ConfigSupport_OI0.player.method_5771()) return false;
        if (KillAuraModule.ConfigSupport_OI0.player.method_6101()) return false;
        if (KillAuraModule.ConfigSupport_OI0.player.method_6059(StatusEffects.BLINDNESS)) return false;
        if (KillAuraModule.ConfigSupport_OI0.player.method_5765()) return false;
        if (param1) return true;
        if (KillAuraModule.ConfigSupport_OI0.player.method_24828()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIIo(boolean param1, boolean param2) {
        if (!this.III0(param1)) return false;
        if (!(KillAuraModule.ConfigSupport_OI0.player.method_7261(0.5f) > 0.9f)) return false;
        if (!KillAuraModule.ConfigSupport_OI0.player.method_5624()) return true;
        if (!param2) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private double IiO0(LivingEntity param1, boolean param2) {
        double v7;
        Vec3d v3 = KillAuraModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v4 = this.oOO(v3, param1.method_5829().expand((double)param1.method_5871()));
        double v5 = v3.squaredDistanceTo(v4);
        if (param2) {
            v7 = v5;
        } else {
            v7 = switch (((EnumType_oiii_3)((Object)this.oOoi.HelpCommand())).ordinal()) {
                case 0 -> param1.getHealth();
                case 2 -> this.IiOo(param1);
                default -> throw new MatchException(null, null);
                case 1 -> v5;
            };
        }
        if (param1 instanceof PlayerEntity) return v7;
        return v7 *= 2.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIoO() {
        if ((Boolean)this.oOIi.HelpCommand() == false) return true;
        if (!this.o0O0()) return false;
        return true;
    }

    private List IIiI(double param1) {
        ArrayList<LivingEntity> v3 = new ArrayList<LivingEntity>();
        Box v4 = KillAuraModule.ConfigSupport_OI0.player.method_5829().expand(Math.max(param1, this.Ii0o(param1)) + 1.0);
        Iterator v5 = KillAuraModule.ConfigSupport_OI0.world.method_8335((Entity)KillAuraModule.ConfigSupport_OI0.player, v4).iterator();
        while (v5.hasNext()) {
            LivingEntity v7;
            Entity v6 = (Entity)v5.next();
            if (!(v6 instanceof LivingEntity) || !this.IIii(v7 = (LivingEntity)v6, param1)) continue;
            v3.add(v7);
        }
        return v3;
    }

    @Override
    public String OIIi() {
        return ((EnumType_O0OO)((Object)this.BindCommand.HelpCommand())).name();
    }

    public static boolean II0I() {
        KillAuraModule v0 = 0ooo.O0i0() == null ? null : (KillAuraModule)0ooo.O0iO().oo0i(KillAuraModule.class);
        return v0 != null && v0.IIo0();
    }

    private double Ii0o(double param1) {
        return 0.0;
    }
}

