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
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Items
 *  net.minecraft.item.MaceItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
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
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import clap.render.RenderSupport_0I0;
import clap.module.combat.AntiBotModule;
import clap.config.ConfigSupport_O0IO;
import clap.core.module.Module;
import clap.render.RenderSupport_0ooi_1;
import clap.model.EnumType_iii_0;
import clap.setting.Setting;
import clap.config.ConfigSupport_oii0_1;
import clap.render.RenderSupport_oio_2;
import clap.core.module.ModuleCategory;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.model.DataRecord_0O0i
 */
public class LegitAuraModule
extends Module {
    private long Ii0O;
    private static final int II0o;
    private int III0;
    private float IIIo;
    private final Setting KbDelayModule;
    private final Setting o0Oo;
    private static final Color IIO0;
    private long o0oi;
    private boolean IIIi;
    private int IIi0;
    private final Setting oOIi;
    private static final int IIOi;
    private Vec3d IIoI;
    private boolean o0o0;
    private int IIiI;
    private int IiO0;
    private LivingEntity o00I;
    private final Setting oOii;
    private final Setting o0OO;
    private float IiOi;
    private double IIIO;
    private float IIiO;
    private static final long IIOo;
    private static final int II0O;
    private int IIo0;
    private static final Color IIOO;
    private static final float Ioii;
    private final Setting oOIo;
    private final Setting oOII;
    private final Setting oOiI;
    private boolean o0oO;
    private Vec3d IIoi;
    private static final int IIOI;
    private float IiOI;
    private long o0I0;
    private final Setting o0O0;
    private boolean o0oo;
    private boolean o0oI;
    private long II0i;
    private long o0IO;
    private int IiOo;
    private static final int II0I;
    private final Setting ConfigSupport_0O0O = this.OOi00("SmartCrit", false);
    private final Setting oiiI;
    private static final float IoiI;
    private long IIoO;
    private float IiOO;
    private float IIii;
    private static final int II00;
    private boolean IIII;
    private int IIoo;
    private final Setting oOio;
    private LivingEntity o00o;
    private int IIio;
    static Object Ii00;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private void O0ooi(boolean param1, long param2) {
        if (param1) {
            this.II0i = param2;
        } else {
            this.IIoO = param2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private double O0oI0(LivingEntity param1) {
        float[] cfr_ignored_0 = new float[0];
        float[] v2 = this.IiOI(param1);
        float v3 = 0ooo.0oOo() != null && 0ooo.0oOI().Oii() ? 0ooo.ConfigSupport_0o0o_1().ConfigSupport_OI0() : LegitAuraModule.ConfigSupport_OI0.player.method_36454();
        float v4 = 0ooo.NameTagsModule() != null && 0ooo.0o0o().Oii() ? 0ooo.0oOi().OIo() : LegitAuraModule.ConfigSupport_OI0.player.method_36455();
        float v5 = MathHelper.wrapDegrees((float)(v2[0] - v3));
        float v6 = v2[1] - v4;
        return Math.sqrt(v5 * v5 + v6 * v6);
    }

    /*
     * Enabled aggressive block sorting
     */
    private LivingEntity O0ooo(List param1, boolean param22, LivingEntity param3, boolean param4) {
        long v7;
        if (param1.isEmpty()) {
            return null;
        }
        if (param3 != null && param1.contains(param3)) {
            this.O0oIO(param4);
            return param3;
        }
        long v5 = System.currentTimeMillis();
        if (v5 < (v7 = this.O0ooI(param4))) {
            return null;
        }
        if (param3 != null && (Integer)this.oiiI.HelpCommand() > 0) {
            this.O0ooi(param4, v5 + (long)((Integer)this.oiiI.HelpCommand()).intValue());
            return null;
        }
        param1.sort(Comparator.comparingDouble(param2 -> {
            Vec3d v3 = LegitAuraModule.ConfigSupport_OI0.player.method_33571();
            Vec3d v4 = this.oOO(v3, param2.method_5829().expand((double)param2.method_5871()));
            double v5 = v3.squaredDistanceTo(v4);
            double v7 = this.O0oI0((LivingEntity)param2);
            double v9 = param22 ? v5 + v7 * v7 * 0.015 : (double)param2.getHealth() + v5 * 0.35 + v7 * 0.12;
            if (param2 instanceof PlayerEntity) return v9;
            return v9 *= 2.0;
        }));
        return (LivingEntity)param1.getFirst();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIIO() {
        if (this.o00o == null) {
            return false;
        }
        if ((Boolean)this.ConfigSupport_0O0O.HelpCommand() == false) return true;
        if (this.IIiO(this.o00o)) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean O0oiI(LivingEntity param1) {
        if (!this.O0IOi(param1)) {
            return false;
        }
        Vec3d v2 = this.O0IoO(param1, 3.0);
        if (v2 == null) {
            return true;
        }
        Box v3 = param1.method_5829();
        double v4 = v3.maxY - v3.minY;
        double v6 = v3.minY + v4 * 0.64;
        if (!(v2.y < v6)) return false;
        return true;
    }

    @Override
    public void 0oI() {
        this.o00o = null;
        this.o00I = null;
        this.II0i = 0L;
        this.IIoO = 0L;
        this.IIo0 = Integer.MIN_VALUE;
        this.IIoo = 0;
        this.IIoI = Vec3d.ZERO;
        this.IIoi = null;
        this.IIIO = Double.NaN;
        this.III0 = Integer.MIN_VALUE;
        this.IIIo = 0.0f;
        this.IIII = false;
        this.IIIi = false;
        this.IIiO = 0.0f;
        this.IIi0 = Integer.MIN_VALUE;
        this.IIio = 0;
        this.IIiI = 0;
        this.IIii = 0.0f;
        this.IiOO = 0.0f;
        this.IiO0 = Integer.MIN_VALUE;
        this.IiOo = 0;
        this.IiOI = 0.0f;
        this.IiOi = 0.0f;
        this.o0oO = false;
        this.o0o0 = false;
        this.o0oo = false;
        this.o0oI = false;
        this.o0oi = 0L;
        this.o0IO = 0L;
        this.o0I0 = 0L;
        this.Ii0O = 0L;
        0ooo.StreamproofLogger().0Oo(this);
    }

    private float O0I0o(float param1, float param2) {
        return param1 + 0.1801133f * (param2 - param1);
    }

    private float O0I0O(float param1) {
        float v2 = Math.min(param1, 80.0f);
        float v3 = 1.2f + v2 / 7.5f;
        return Math.min(1.7440714f + v3, 18.0f);
    }

    private double O0oi0(Vec3d param1) {
        return param1.x * param1.x + param1.z * param1.z;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Vec3d O0IoO(LivingEntity param1, double param2) {
        if (param1 == null) {
            return null;
        }
        float v4 = 0ooo.0o0i() != null && 0ooo.RenderSupport_0ooo_1().Oii() ? 0ooo.ConfigSupport_0oo0_1().ConfigSupport_OI0() : LegitAuraModule.ConfigSupport_OI0.player.method_36454();
        float v5 = 0ooo.0ooo() != null && 0ooo.0ooI().Oii() ? 0ooo.0ooi().OIo() : LegitAuraModule.ConfigSupport_OI0.player.method_36455();
        Vec3d v6 = LegitAuraModule.ConfigSupport_OI0.player.method_5836(1.0f);
        Vec3d v7 = this.Ii0i(v4, v5);
        return param1.method_5829().raycast(v6, v6.add(v7.multiply(param2))).orElse(null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean O0Io0(LivingEntity param1, float param2, float param3, double param4, double param6) {
        if (this.O0Ioo(param1, param2, param3, param4, param6) == null) return false;
        return true;
    }

    private float[] IiOI(LivingEntity param1) {
        Vec3d v2 = LegitAuraModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v3 = this.oOO(v2, param1.method_5829().expand((double)param1.method_5871()));
        double v4 = v3.x - v2.x;
        double v6 = v3.y - v2.y;
        double v8 = v3.z - v2.z;
        double v10 = Math.sqrt(v4 * v4 + v8 * v8);
        float v12 = (float)(Math.toDegrees(Math.atan2(v8, v4)) - 90.0);
        float v13 = (float)(-Math.toDegrees(Math.atan2(v6, v10)));
        return new float[]{LegitAuraModule.ConfigSupport_OI0.player.method_36454() + MathHelper.wrapDegrees((float)(v12 - LegitAuraModule.ConfigSupport_OI0.player.method_36454())), MathHelper.clamp((float)(LegitAuraModule.ConfigSupport_OI0.player.method_36455() + MathHelper.wrapDegrees((float)(v13 - LegitAuraModule.ConfigSupport_OI0.player.method_36455()))), (float)-90.0f, (float)90.0f)};
    }

    private void O0IoI(LivingEntity param1) {
        float[] cfr_ignored_0 = new float[0];
        this.IIiO = 0.0f;
        float[] v2 = this.O0oIo(param1);
        0ooo.0oIO().HelpCommand(this, v2[0], v2[1], 90.0f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long O0ooI(boolean param1) {
        long l;
        if (param1) {
            l = this.II0i;
            return l;
        }
        l = this.IIoO;
        return l;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void O0Ioi() {
        this.III0 = Integer.MIN_VALUE;
        this.IIIo = 0.0f;
        this.IIII = false;
        this.IIi0 = Integer.MIN_VALUE;
        this.IIio = 0;
        this.IIiI = 0;
        this.IIii = 0.0f;
        this.IiOO = 0.0f;
        this.IiO0 = Integer.MIN_VALUE;
        this.IiOo = 0;
        this.IiOI = 0.0f;
        this.IiOi = 0.0f;
        if (0ooo.0oio() == null || !0ooo.0oiI().Oii()) {
            this.IIIi = false;
            this.IIiO = 0.0f;
            if (0ooo.0IOO() == null) return;
            0ooo.0oIo().0Oo(this);
            return;
        }
        float v1 = 0ooo.0oi0().OiO(LegitAuraModule.ConfigSupport_OI0.player.method_36454());
        float v2 = 0ooo.0oiO().Oi0(LegitAuraModule.ConfigSupport_OI0.player.method_36455());
        float v3 = 0ooo.0oIi().ConfigSupport_OI0();
        float v4 = 0ooo.0oii().OIo();
        float v5 = Math.abs(MathHelper.wrapDegrees((float)(v1 - v3)));
        float v6 = Math.abs(v2 - v4);
        if (v5 <= 0.35f && v6 <= 0.25f) {
            this.IIIi = false;
            this.IIiO = 0.0f;
            0ooo.0oI0().0Oo(this);
            return;
        }
        if (!this.IIIi) {
            this.IIiO = 0.0f;
        }
        this.IIIi = true;
        this.IIiO = Math.min(1.0f, this.IIiO + 0.12f);
        float v7 = this.IIiO * this.IIiO * (3.0f - 2.0f * this.IIiO);
        float v8 = 4.5f + v7 * 37.5f;
        float v9 = v3 + MathHelper.clamp((float)MathHelper.wrapDegrees((float)(v1 - v3)), (float)(-v8), (float)v8);
        float v10 = v4 + MathHelper.clamp((float)(v2 - v4), (float)(-v8), (float)v8);
        0ooo.0oII().HelpCommand(this, v9, MathHelper.clamp((float)v10, (float)-90.0f, (float)90.0f), 180.0f);
    }

    public LegitAuraModule() {
        super("LegitAura", "Automatically attacks valid targets around you.", ModuleCategory.i0I);
        this.oOIo = this.OOi0o("RotationRange", 5.0, 2.0, 8.0);
        this.oiiI = this.OOi0o("SwitchDelay", 350, 0, 1200).ConfigSupport_00o_0("ms");
        this.oOII = this.OOi0o("FOV", 30, 1, 90);
        this.oOIi = this.OOi00("OnlyWeapon", false);
        this.oOio = this.OOi00("Players", true);
        this.oOiI = this.OOi00("Mobs", false);
        this.oOii = this.OOi00("Animals", false);
        this.o0OO = this.OOi00("Invisibles", false);
        this.KbDelayModule = this.OOi00("IgnoreTeam", true);
        this.o0O0 = this.OOi00("IgnoreFriends", true);
        this.o0Oo = this.OOi00("TargetESP", false);
        this.IIo0 = Integer.MIN_VALUE;
        this.IIoI = Vec3d.ZERO;
        this.IIIO = Double.NaN;
        this.III0 = Integer.MIN_VALUE;
        this.IIi0 = Integer.MIN_VALUE;
        this.IiO0 = Integer.MIN_VALUE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean III0(boolean param1) {
        if (LegitAuraModule.ConfigSupport_OI0.player.method_5799()) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_5771()) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_6101()) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_6059(StatusEffects.BLINDNESS)) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_5765()) return false;
        if (param1) return true;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_24828()) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Vec3d O0IOO(LivingEntity param1) {
        double v5;
        double v3;
        Box v2;
        if (LegitAuraModule.ConfigSupport_OI0.player == null) {
            return param1.method_73189();
        }
        if (this.IIo0 != param1.method_5628()) {
            this.IIo0 = param1.method_5628();
            this.IIoo = 0;
            this.IIoI = Vec3d.ZERO;
            this.IIoi = null;
            this.IIIO = Double.NaN;
        }
        if (LegitAuraModule.ConfigSupport_OI0.player.field_6012 >= this.IIoo) {
            v2 = param1.method_5829();
            v3 = Math.max(0.05, (v2.maxX - v2.minX) * 0.18);
            v5 = Math.max(0.05, (v2.maxZ - v2.minZ) * 0.18);
            double v7 = Math.max(0.05, (v2.maxY - v2.minY) * 0.28);
            this.IIoI = new Vec3d((double)this.O0I0o((float)(-v3), (float)v3), (double)this.O0I0o((float)(-v7 * 0.35), (float)v7), (double)this.O0I0o((float)(-v5), (float)v5));
            this.IIoo = LegitAuraModule.ConfigSupport_OI0.player.field_6012 + 3 + 3;
        }
        v2 = param1.method_5829();
        v3 = v2.maxY - v2.minY;
        v5 = v2.minY + v3 * 0.72;
        boolean v9 = this.O0IOi(param1);
        Vec3d v10 = new Vec3d((v2.minX + v2.maxX) * 0.5, v2.minY + v3 * 0.74, (v2.minZ + v2.maxZ) * 0.5);
        Vec3d v11 = v10.add(this.IIoI);
        boolean v12 = this.O0I0i(param1, 3.0, 0.0);
        double v13 = v9 ? v5 - v3 * 0.08 : v2.minY + 0.05;
        double v15 = v9 ? v5 + v3 * 0.12 : v2.maxY - 0.05;
        double v17 = MathHelper.clamp((double)v11.y, (double)v13, (double)v15);
        if (Double.isNaN(this.IIIO)) {
            this.IIIO = v17;
        } else {
            double v19 = v9 && this.IIIO < v13 ? 0.22 : (v12 ? 0.045 : 0.16);
            this.IIIO += MathHelper.clamp((double)(v17 - this.IIIO), (double)(-v19), (double)v19);
            this.IIIO = MathHelper.clamp((double)this.IIIO, (double)v13, (double)v15);
        }
        Vec3d v21 = new Vec3d(MathHelper.clamp((double)v11.x, (double)(v2.minX + 0.02), (double)(v2.maxX - 0.02)), this.IIIO, MathHelper.clamp((double)v11.z, (double)(v2.minZ + 0.02), (double)(v2.maxZ - 0.02)));
        if (this.IIoi != null) {
            double v22 = this.O0IO0(param1, v12, v9);
            this.IIoi = this.O0IOo(this.IIoi, v21, v22);
            this.IIoi = new Vec3d(MathHelper.clamp((double)this.IIoi.x, (double)(v2.minX + 0.02), (double)(v2.maxX - 0.02)), MathHelper.clamp((double)this.IIoi.y, (double)v13, (double)v15), MathHelper.clamp((double)this.IIoi.z, (double)(v2.minZ + 0.02), (double)(v2.maxZ - 0.02)));
            return this.IIoi;
        }
        this.IIoi = v21;
        return this.IIoi;
    }

    private boolean O0IOi(LivingEntity param1) {
        return Math.abs(LegitAuraModule.ConfigSupport_OI0.player.method_23318() - param1.method_23318()) <= 0.45;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean O0oiO(LivingEntity param1) {
        if (!LegitAuraModule.ConfigSupport_OI0.player.method_24828()) return false;
        if (!param1.method_24828()) {
            return false;
        }
        if (LegitAuraModule.ConfigSupport_OI0.player.method_5624()) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.field_6017 > 0.0) {
            return false;
        }
        Vec3d v2 = LegitAuraModule.ConfigSupport_OI0.player.method_18798();
        Vec3d v3 = param1.method_18798();
        double v4 = this.O0oi0(v2);
        double v6 = this.O0oi0(v3);
        boolean v8 = LegitAuraModule.ConfigSupport_OI0.player.input != null && LegitAuraModule.ConfigSupport_OI0.player.input.getMovementInput().lengthSquared() > 0.85f;
        if (!(Math.abs(v2.y) < 0.035)) return false;
        if (!(Math.abs(v3.y) < 0.06)) return false;
        if (!(v4 <= 0.005625)) return false;
        if (!(v6 <= 0.016900000000000002)) return false;
        if (!v8) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean O0IOI() {
        if (this.Ii0O <= 0L) return false;
        if (System.currentTimeMillis() - this.Ii0O > 180L) return false;
        return true;
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
    private float[] O0oIi(LivingEntity param1, float param2, float param3, Vec3d param4) {
        if (param4 != null && this.o00o == param1 && this.O0oio(param1, param4) && this.IIoi(param1) && this.IIIO()) {
            Vec3d v8;
            float v7;
            float v6;
            boolean v5;
            boolean bl = v5 = !this.O0oiO(param1);
            if (!v5 && LegitAuraModule.ConfigSupport_OI0.player.field_6012 < this.IIio) {
                return null;
            }
            if (this.IiO0 != param1.method_5628() || LegitAuraModule.ConfigSupport_OI0.player.field_6012 >= this.IiOo) {
                this.IiO0 = param1.method_5628();
                this.IiOo = LegitAuraModule.ConfigSupport_OI0.player.field_6012 + 2 + 3;
                v6 = v5 ? 0.32f : 0.18f;
                v7 = v5 ? 0.12f : 0.07f;
                this.IiOI = this.O0I0o(-v6, v6);
                this.IiOi = this.O0I0o(-v7, v7);
            }
            if ((v8 = this.O0Ioo(param1, v6 = param2 + this.IiOI, v7 = MathHelper.clamp((float)(param3 + this.IiOi), (float)-90.0f, (float)90.0f), 3.0, 0.0)) != null && this.O0oio(param1, v8)) {
                return new float[]{param2 + MathHelper.wrapDegrees((float)(v6 - param2)), MathHelper.clamp((float)v7, (float)-90.0f, (float)90.0f)};
            }
            this.IiOI = 0.0f;
            this.IiOi = 0.0f;
            return null;
        }
        this.IiO0 = Integer.MIN_VALUE;
        this.IiOo = 0;
        this.IiOI = 0.0f;
        this.IiOi = 0.0f;
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    @EventHandler
    public void 0oi(ConfigSupport_O0IO param1) {
        block9: {
            block8: {
                block7: {
                    if (param1.0Oi() != EnumType_iii_0.OiO) {
                        return;
                    }
                    if (LegitAuraModule.iooI() || LegitAuraModule.ConfigSupport_OI0.currentScreen != null || !this.IIoO()) break block7;
                    if (LegitAuraModule.ConfigSupport_OI0.options.jumpKey.wasPressed()) {
                        this.o0oi = System.currentTimeMillis();
                    }
                    this.IIi0();
                    List v2 = this.IIiI(3.0);
                    this.o00o = this.O0ooo(v2, false, this.o00o, true);
                    if (this.o00o == null) break block8;
                    this.o00I = this.o00o;
                    this.IIIi = false;
                    break block9;
                }
                this.II0i();
                0ooo.0IO0().0Oo(this);
                return;
            }
            List v3 = this.IIiI((Double)this.oOIo.HelpCommand());
            this.o00I = this.O0ooo(v3, true, this.o00I, false);
        }
        if (this.o00I != null) {
            this.O0IoI(this.o00I);
        } else {
            this.O0Ioi();
        }
        if (this.o00o == null) return;
        if (!this.IIii(this.o00o, 3.0)) return;
        if (!this.IIoi(this.o00o)) return;
        if (!this.IIIO()) {
            return;
        }
        if (!this.O0I0I(this.o00o)) {
            return;
        }
        if (LegitAuraModule.ConfigSupport_OI0.interactionManager == null) return;
        LegitAuraModule.ConfigSupport_OI0.interactionManager.attackEntity((PlayerEntity)LegitAuraModule.ConfigSupport_OI0.player, (Entity)this.o00o);
        LegitAuraModule.ConfigSupport_OI0.player.method_6104(Hand.MAIN_HAND);
        if (!LegitAuraModule.ConfigSupport_OI0.player.method_24828()) {
            this.o0o0 = true;
            this.o0oI = false;
        }
        this.Ii0O = System.currentTimeMillis();
    }

    private Vec3d oOO(Vec3d param1, Box param2) {
        return new Vec3d(MathHelper.clamp((double)param1.x, (double)param2.minX, (double)param2.maxX), MathHelper.clamp((double)param1.y, (double)param2.minY, (double)param2.maxY), MathHelper.clamp((double)param1.z, (double)param2.minZ, (double)param2.maxZ));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean O0I0I(LivingEntity param1) {
        if (param1 == null) {
            return false;
        }
        Vec3d v2 = this.O0IoO(param1, 3.0);
        if (v2 == null) {
            return false;
        }
        if (!(LegitAuraModule.ConfigSupport_OI0.player.method_33571().squaredDistanceTo(v2) <= 9.0)) return false;
        if (!this.Ii0I(v2)) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private float[] O0oII(LivingEntity param1, float param2, float param3, Vec3d param4, boolean param5) {
        float v7;
        float v6;
        Vec3d v8;
        if (!(param4 != null && !param5 && LegitAuraModule.ConfigSupport_OI0.player != null && this.o00o == param1 && this.IIoi(param1) && this.IIIO() && this.O0oiO(param1) && this.O0oio(param1, param4))) {
            this.IIi0 = Integer.MIN_VALUE;
            this.IIio = 0;
            this.IIiI = 0;
            this.IIii = 0.0f;
            this.IiOO = 0.0f;
            return null;
        }
        if (this.IIi0 != param1.method_5628() || LegitAuraModule.ConfigSupport_OI0.player.field_6012 >= this.IIio) {
            this.IIi0 = param1.method_5628();
            this.IIio = LegitAuraModule.ConfigSupport_OI0.player.field_6012 + 4 + 5;
        }
        if (LegitAuraModule.ConfigSupport_OI0.player.field_6012 >= this.IIiI) {
            this.IIii = this.O0I0o(-0.18f, 0.18f);
            this.IiOO = this.O0I0o(-0.08f, 0.08f);
            this.IIiI = LegitAuraModule.ConfigSupport_OI0.player.field_6012 + 5 + 5;
        }
        if ((v8 = this.O0Ioo(param1, v6 = param2 + this.IIii, v7 = MathHelper.clamp((float)(param3 + this.IiOO), (float)-90.0f, (float)90.0f), 3.0, 0.0)) == null || !this.O0oio(param1, v8)) {
            this.IIii = 0.0f;
            this.IiOO = 0.0f;
            v6 = param2;
            v7 = param3;
        }
        return new float[]{param2 + MathHelper.wrapDegrees((float)(v6 - param2)), MathHelper.clamp((float)v7, (float)-90.0f, (float)90.0f)};
    }

    @Override
    public String I0io() {
        return "Beta";
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IioO(Entity param1, float param2) {
        float[] cfr_ignored_0 = new float[0];
        float[] v3 = this.IiOI((LivingEntity)param1);
        float f = 0ooo.0IOI() != null ? 0ooo.0IOo().OiO(LegitAuraModule.ConfigSupport_OI0.player.method_36454()) : LegitAuraModule.ConfigSupport_OI0.player.method_36454();
        float v4 = f;
        float v5 = Math.abs(MathHelper.wrapDegrees((float)(v3[0] - v4)));
        if (!(v5 <= param2)) return false;
        return true;
    }

    static {
        __k__gH4it = LegitAuraModule.__k__gH4it(-6065023070354018799L);
        __rP__gH4it0 = new String[]{"\u2aa3\u7652\ua933\ufce3\u7bb0\u2714\uf1a4\uab58\u2b8d\u77c8", "\u2ab6\u765e\ua933\ufce6\u7b89"};
        __rP__gH4it1 = new String[]{"\u2aa1\u761b\ua9de\ufc2b\u7a00\u2688\uf101\uab25\u2b44\u7778\ua82d\ufd06\u7ddd\u21fa\uf644\uac0a\u2cc4\u7044\uaf8c\ufa6a\u7c58\u205b\uf737\uad8f\u2da8\u7137\uae09\ufbc9\u7c31\u232d\uf420\uae8e\u2e4d\u726c\uadf6\uf853\u7f06\u2257\uf5e1\uaf4c\u2fc7\u73f1\uacc6\uf9bf\u7ebe\u3d3f\uea99\ub07c\u307e\u6cbf\ub3f8\ue63c\u61c1\u3c4e\ueb24\ub1e0\u31c2\u6d8f\ub233\ue792\u6072\u3ca5\ue8db\ub26a\u3297\u6e92\ub1aa\ue46f\u6394\u3fac\ue9d9\ub3ab\u3320\u6fa7\ub09e\ue5dd\u6242\u3e21\ueea5\ub4e7\u34fd\u6829\ub7de\ue206\u653f\u39b9\uefba\ub5a2\u3548\u69ed\ub659\ue345\u64d4\u38ca\uef69\ub6d2\u36b6\u6a5f\ub529\ue0ed\u67c1\u3bc1\uece6\ub7e1\u37a6\u6b25\ub4e6\ue168\u669b\u3ad5\uedd8\ub895\u3850\u642d\ubb90\ueece\u6973\u354a\ue275\ub9c9\u396b\u65d9\uba7c\uefc3\u68ee\u34ee\ue30b\ub920\u3aef\u6668\ub91e\uec60\u6b04\u37a1\ue0d7\uba8a\u3b15\u6771\ub8db\ued70\u6ae5\u3617\ue1b6\ubb70\u3c0a\u6016\ubf2d\uea8d\u6ddf\u31df\ue6a5\ubce3\u3d8c\u61eb\ube6b\uebb9\u6cc7\u3012\ue762\ubdb3\u3db4\u62f7\ubd64\ue846\u6f8c\u33b5\ue4fc\ube47\u3e9c\u6325\ubcc1\ue9f6\u6e9e\u3282\ue504\ubfeb\u3f31\u1c95\uc359\u967b\u1199\u4df1\u9a09\uc070\u400e\u1d1f\uc24c\u9782\u1050\u4c6e\u9b98\uc17e\u41ac\u1d48\uc129\u941a\u13fc\u4fda\u9815\uc270\u42c5\u1e7a\uc02e\u9524\u1263\u4e57\u9983\uc318\u4337\u1f33\uc7cb\u92ef\u15b9\u4900\u9ea6\uc4b0\u4433\u1820\uc77e\u9379\u14a8\u4813\u9ff3\uc579\u45ec\u1988\uc6f0\u906f\u179f\u4b1e\u9cc4\uc6bb\u46e4\u1a28\uc5a0\u91b7\u16da\u4a95\u9dbc\uc789", "\u2ab5\u765d\ua938\ufcfa\u7be0\u2687\uf1fd\uab27\u2ba9\u775b\ua830\ufd9e\u7a8e\u218d\uf6c7\uac74\u2c85\u7061\uaf15\ufaa2"};
        __rP__gH4it2 = new String[]{"\u2ad7\u7629\ua99f\ufce7\u7b54\u27f2\uf196\uab81", "\u2aa3\u764b\ua922", "\u2ab3\u764f\ua93b\ufceb\u7b80\u26e7\uf199"};
        __rP__gH4it3 = new String[]{"\u2aa1\u76ac\ua90d\ufce1\u7bb2\u2712\uf1a2\uab5a\u2b8f\u77c6"};
        __p__gH4it = new String[]{"\ue4ff\ue524\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0", "\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26", "\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286\uf2ab", "\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab", "\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3", "\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1", "\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640", "\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca", "\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca", "\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6", "\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f", "\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287", "\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009", "\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be", "\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d", "\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc", "\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624", "\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e", "\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db", "\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503", "\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3", "\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748", "\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370\uf395", "\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa", "\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3", "\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1", "\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f", "\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3", "\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425", "\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d", "\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816", "\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98", "\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951", "\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5", "\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3", "\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33", "\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b", "\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7", "\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e", "\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b", "\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88", "\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd", "\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3", "\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567", "\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9", "\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4", "\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b", "\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5", "\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612", "\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00", "\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13", "\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf", "\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3", "\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172", "\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4", "\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7", "\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71", "\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654", "\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03", "\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b", "\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad", "\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473", "\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c", "\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5", "\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb", "\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7", "\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb", "\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f", "\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b", "\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5", "\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5", "\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f", "\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a", "\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587", "\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f", "\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b", "\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5", "\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392", "\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792", "\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5", "\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264", "\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb", "\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587", "\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af", "\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b", "\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488", "\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa", "\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637", "\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3", "\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326", "\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c", "\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b", "\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d", "\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d", "\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f", "\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322"};
        __c__J7Um6 = new Object[][]{{"\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b\uedc0\uede5", -199464341049964304L, "\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a", -180753592, "\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e", true, "\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd", true, "\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135", true, "\uf6e1\uf706\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2", true}, {"\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74", -199464341049898767L, "\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba", -1151455761, "\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5", false, "\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87", false, "\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec", false, "\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232", false}, {"\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e", -199464341049833230L, "\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8\uf5dd\uf602", 1777755654, "\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1", true, "\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19", true, "\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6", true, "\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358", true}, {"\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e", -199464341049767693L, "\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9", 504281277, "\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", false, "\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0", false, "\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516", false, "\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e", false}, {"\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6", -199464341049702156L, "\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795", -861474348, "\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd", true, "\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a", true, "\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c", true, "\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f", true}, {"\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d", -199464341049636619L, "\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", 2101283339, "\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4", false, "\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa", false, "\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762", false, "\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680", false}, {"\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279", -199464341049571082L, "\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1", 592923810, "\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e", true, "\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120", true, "\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063", true, "\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781", true}, {"\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", -199464341049505545L, "\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298", -772831783, "\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade", false, "\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246", false, "\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164", false, "\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710", false}, {"\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5", -199464341049440008L, "\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452", -2046304656, "\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04", true, "\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347", true, "\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265", true, "\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca", true}, {"\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c", -199464341049374471L, "\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2", 882643095, "\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a", false, "\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448", false, "\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4", false, "\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a", false}, {"\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736", -199464341049308934L, "\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8", -449566258, "\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b", true, "\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549", true, "\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae", true, "\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82", true}, {"\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6", -199464341049243397L, "\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e", -1421057435, "\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c", false, "\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8", false, "\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e", false, "\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39", false}, {"\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc", -199464341049177860L, "\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f", 1508156572, "\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d", true, "\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692", true, "\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566", true, "\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15", true}, {"\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2", -199464341049112323L, "\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10", 243072307, "\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc", false, "\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002", false, "\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d", false, "\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf", false}, {"\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3", -199464341049046786L, "\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11", -1131071894, "\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176", true, "\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a", true, "\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9", true, "\uecef\ued14\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61", true}, {"\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4", -199464341048981249L, "\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0", 1831684225, "\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6", false, "\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101", false, "\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3", false, "\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3\uef18", false}, {"\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5", -199464341048915712L, "\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a", 323322168, "\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e", true, "\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd", true, "\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945", true, "\ueef1\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2", true}, {"\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584", -199464341048850175L, "\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca", -1042425249, "\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5", false, "\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397", false, "\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc", false, "\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242", false}, {"\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e", -199464341048784638L, "\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12", 1987190006, "\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1", true, "\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429", true, "\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6", true, "\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368", true}, {"\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae", -199464341048719101L, "\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9", 613045549, "\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", false, "\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0", false, "\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26", false, "\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e", false}, {"\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6", -199464341048653564L, "\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5", -719163836, "\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d", true, "\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a", true, "\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c", true, "\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f", true}, {"\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad", -199464341048588027L, "\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f", -1682267909, "\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4", false, "\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a", false, "\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72", false, "\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690", false}, {"\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89", -199464341048522490L, "\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1", 1238563090, "\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e", true, "\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930", true, "\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073", true, "\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791", true}, {"\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43", -199464341048456953L, "\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8", -26529207, "\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee", false, "\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56", false, "\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174", false, "\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720", false}, {"\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b\uecb0\uecd5", -199464341048391416L, "\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462", -1400671008, "\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414", true, "\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57", true, "\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275", true, "\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da", true}, {"\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c", -199464341048325879L, "\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2", 1562086663, "\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a", false, "\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58", false, "\uf0dc\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df\uf204", false, "\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a", false}, {"\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46", -199464341048260342L, "\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8", 62113726, "\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b", true, "\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59", true, "\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be", true, "\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292", true}, {"\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6", -199464341048194805L, "\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e", -1312286507, "\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c", false, "\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8", false, "\uf2de\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e", false, "\ue1fc\ue221\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349", false}, {"\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc", -199464341048129268L, "\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f", 1717588236, "\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d", true, "\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2", true, "\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507\uf52c\uf551\uf576", true, "\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425", true}, {"\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302", -199464341048063731L, "\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220", 351824803, "\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc", false, "\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012", false, "\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d", false, "\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df", false}, {"\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403", -199464341047998194L, "\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321", -988762918, "\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986", true, "\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010\uf035\uf05a", true, "\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709", true, "\ue4ff\ue524\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671", true}, {"\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504", -199464341047932657L, "\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0", -1951865487, "\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6", false, "\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111", false, "\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3", false, "\ue600\ue625\ue64a\ue66f\ue694\ue6b9\ue6de\ue703\ue728", false}, {"\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb\uf5e0\uf605", -199464341047867120L, "\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb\ue420\ue445\ue46a", 968966056, "\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4\ueb19\ueb3e", true, "\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed", true, "\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b\ue130\ue155", true, "\ue701\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2", true}, {"\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594", -199464341047801583L, "\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b\ue590\ue5b5\ue5da", -296128305, "\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5", false, "\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7", false, "\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c", false, "\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52", false}, {"\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e", -199464341047736046L, "\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8\ue5fd\ue622", -1661892250, "\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1", true, "\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef\uf414\uf439", true, "\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6", true, "\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78", true}, {"\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be", -199464341047670509L, "\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9", 1292485533, "\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b", false, "\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0", false, "\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536", false, "\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e", false}, {"\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc\ue0e1\ue106", -199464341047604972L, "\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5", -206699468, "\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d", true, "\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa", true, "\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c", true, "\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f", true}, {"\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd", -199464341047539435L, "\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f", -1580835477, "\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4", false, "\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a", false, "\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782", false, "\uec06\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0", false}, {"\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299", -199464341047473898L, "\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc\uea01", 1449039746, "\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e", true, "\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140", true, "\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883", true, "\ued07\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1", true}, {"\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453", -199464341047408361L, "\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8", 83273785, "\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe", false, "\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266", false, "\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984", false, "\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30", false}, {"\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0\ue4e5", -199464341047342824L, "\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72", -1257316016, "\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424", true, "\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367", true, "\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85", true, "\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea", true}, {"\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c", -199464341047277287L, "\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2", 2074557431, "\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a", false, "\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468", false, "\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14", false, "\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a", false}, {"\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756", -199464341047211750L, "\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08", 675249198, "\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b", true, "\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569", true, "\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce", true, "\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2", true}, {"\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6", -199464341047146213L, "\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e", -564677307, "\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c", false, "\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8", false, "\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e", false, "\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359", false}, {"\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec", -199464341047080676L, "\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f", -1930440708, "\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d", true, "\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2", true, "\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c\ued61\ued86", true, "\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435", true}, {"\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12", -199464341047015139L, "\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230", 1023672339, "\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc", false, "\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822", false, "\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d", false, "\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef", false}, {"\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13", -199464341046949602L, "\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331", -476292790, "\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196", true, "\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a", true, "\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19", true, "\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637\uf65c\uf681", true}, {"\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14", -199464341046884065L, "\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0", -1875602463, "\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306", false, "\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921", false, "\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3", false, "\uf610\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738", false}, {"\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15", -199464341046818528L, "\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a", 1179440152, "\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304\ue329\ue34e", true, "\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd", true, "\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165", true, "\uf711\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2", true}, {"\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4", -199464341046752991L, "\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea", -186323265, "\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405", false, "\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7", false, "\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c", false, "\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262", false}, {"\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e", -199464341046687454L, "\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632", -1518524458, "\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1", true, "\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49", true, "\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6", true, "\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388", true}, {"\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce", -199464341046621917L, "\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9", 1804957709, "\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b", false, "\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00", false, "\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546", false, "\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae", false}, {"\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc\uf0f1\uf116", -199464341046556380L, "\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5", 405648036, "\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d", true, "\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba", true, "\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c", true, "\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af", true}, {"\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd", -199464341046490843L, "\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f", -834286629, "\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4", false, "\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a", false, "\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792", false, "\ue416\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0", false}, {"\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9", -199464341046425306L, "\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211", 2094664818, "\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e", true, "\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150", true, "\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093", true, "\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1", true}, {"\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463", -199464341046359769L, "\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8", 762463913, "\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e", false, "\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276", false, "\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194", false, "\ue618\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740", false}, {"\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5", -199464341046294232L, "\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482", -745889856, "\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34", true, "\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377", true, "\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295", true, "\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa", true}, {"\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac", -199464341046228695L, "\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2", -2145202073, "\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a", false, "\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478", false, "\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224", false, "\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a", false}, {"\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766", -199464341046163158L, "\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718", 918219422, "\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b", true, "\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579", true, "\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de", true, "\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2", true}, {"\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6", -199464341046097621L, "\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e", -455924939, "\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c", false, "\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508", false, "\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e", false, "\uea1c\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69", false}, {"\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc", -199464341046032084L, "\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f", -1788124052, "\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d", true, "\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2", true, "\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596", true, "\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45", true}, {"\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322", -199464341045966547L, "\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40", 1535360643, "\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec", false, "\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032", false, "\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d", false, "\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff", false}, {"\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423", -199464341045901010L, "\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41", 136050490, "\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6", true, "\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a", true, "\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729", true, "\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91", true}, {"\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524", -199464341045835473L, "\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0", -1095759791, "\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316", false, "\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131", false, "\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3", false, "\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48", false}, {"\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600\ue625", -199464341045769936L, "\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a", 1825063560, "\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e", true, "\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d", true, "\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975", true, "\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102", true}, {"\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4", -199464341045704399L, "\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa", 492870447, "\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415", false, "\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7", false, "\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c", false, "\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272", false}, {"\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e", -199464341045638862L, "\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42", -1007100858, "\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1", true, "\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459", true, "\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6", true, "\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398", true}, {"\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de", -199464341045573325L, "\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9", 1880168189, "\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab", false, "\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510", false, "\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56", false, "\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be", false}, {"\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926", -199464341045507788L, "\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5", 648621844, "\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d", true, "\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca", true, "\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c", true, "\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf", true}, {"\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd", -199464341045442251L, "\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f", -725524405, "\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4", false, "\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a", false, "\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2", false, "\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0", false}, {"\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9", -199464341045376714L, "\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221", -2057717022, "\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae", true, "\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960", true, "\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3", true, "\uf527\uf54c\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f\uf674\uf699\uf6be\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1", true}, {"\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73", -199464341045311177L, "\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8", 1274147609, "\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e", false, "\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86", false, "\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4", false, "\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750", false}, {"\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05", -199464341045245640L, "\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492", -132762192, "\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444", true, "\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87", true, "\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5", true, "\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a", true}, {"\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc", -199464341045180103L, "\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8\uf5dd\uf602", -1364308265, "\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a", false, "\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88", false, "\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234", false, "\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a", false}, {"\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76", -199464341045114566L, "\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728", 1556514574, "\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", true, "\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89", true, "\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee", true, "\ue12b\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2", true}, {"\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6", -199464341045049029L, "\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e", 224319909, "\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c", false, "\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18", false, "\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e", false, "\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379", false}, {"\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c", -199464341044983492L, "\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", -1275653412, "\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d", true, "\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2", true, "\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6", true, "\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455", true}, {"\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332", -199464341044917955L, "\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250", 1611606899, "\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc", false, "\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042", false, "\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d", false, "\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f", false}, {"\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", -199464341044852418L, "\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351", 380071338, "\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6", true, "\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a", true, "\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739", true, "\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1", true}, {"\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534", -199464341044786881L, "\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0", -952129855, "\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26", false, "\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141", false, "\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3", false, "\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758", false}, {"\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635", -199464341044721344L, "\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a", 1968701304, "\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e", true, "\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d", true, "\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185", true, "\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912", true}, {"\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4", -199464341044655807L, "\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a", 1005334943, "\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25", false, "\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7", false, "\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c", false, "\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82", false}, {"\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e", -199464341044590270L, "\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652", -402372042, "\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01", true, "\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469", true, "\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6", true, "\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8", true}, {"\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee", -199464341044524733L, "\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709", -1633909907, "\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb", false, "\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520", false, "\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566", false, "\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce", false}, {"\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136", -199464341044459196L, "\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5", 1328858500, "\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d", true, "\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da", true, "\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c", true, "\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf", true}, {"\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed", -199464341044393659L, "\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f", -45277637, "\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004", false, "\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a", false, "\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2", false, "\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0", false}, {"\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9", -199464341044328122L, "\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31", -1545250990, "\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be", true, "\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170", true, "\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3", true, "\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1", true}, {"\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483", -199464341044262585L, "\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8", 1350396297, "\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e", false, "\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296", false, "\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4", false, "\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60", false}, {"\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515", -199464341044197048L, "\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2", 110469664, "\uf1df\uf204\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454", true, "\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397", true, "\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5", true, "\uef39\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a", true}, {"\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc", -199464341044131511L, "\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12", -1221723321, "\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a", false, "\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498", false, "\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44", false, "\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a", false}, {"\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786", -199464341044065974L, "\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38", 1698840062, "\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", true, "\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599", true, "\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe", true, "\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2", true}, {"\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6", -199464341044000437L, "\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e", 735737365, "\uf4e2\uf507\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c", false, "\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528", false, "\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e", false, "\uf23c\uf261\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389", false}, {"\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c", -199464341043934900L, "\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f", -663580852, "\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d", true, "\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2", true, "\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6", true, "\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465", true}, {"\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42", -199464341043869363L, "\uefc6\uefeb\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260", -1903509021, "\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c", false, "\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852", false, "\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d", false, "\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f", false}, {"\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43", -199464341043803826L, "\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361", 1059265050, "\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6", true, "\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a", true, "\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49", true, "\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1", true}, {"\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44", -199464341043738289L, "\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0", -306488143, "\ue0e6\ue10b\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336", false, "\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951", false, "\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103", false, "\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768", false}};
        byte[] v0 = "\u00b0#\u00d5\u00deCm\u00df\r]H>\u00eb\u0086\u0007\u0082:\u00c5l\u0097\u008f\u000b\u00ae\u00f9\u00b7\u00a1\u0017j\u0014\u009a\u00e0\u0096\u008e\u00bct\u009d\u0086\u00a5\u0092_D>\u00e1\u00b5r\u0005\u00e2?l\u009f\u00b7\u0083\u00f9r\u009b\u008a\u00f8+\u008fp/\u00f9\u0088M\nFj\u00e1\u00da\u0017\u0089G\u00c3\u00f9W\u00cdp\u00d9\u001c#\u0097<\u00c1\u0085\u00a3\u00ac\u008c4\u00da\u0081\r\u00fa\u00d8?\u00c7\u001f\u0092\u0007\u0087\u0082x\"\u00c4\u0098\u00a9\u001f\u00f5U\u00e5`\u00c8\u00be\u00c5\u00f1\u00e5+K\u0080_\u001b\u0091\u00c2\u0019\u00ff\u00be%\u0083]\u0080~\u00d0\u0095\u0015\u00c7\u00c4\u0089\"\u008c\u00c1H\u001d>j\u00f0\u00c0\u008b\u00be\u00b6\u00e8\f\u00aa\u00eb[\u0005K\u0088\u00e4\u00ec_T3\u00c5o\u008f\u0013\u00af\u00f0\u00c2\u00cf\u00e5\u00b52\u00bb\u00a5\u00df\"{P\u001d\u00a2>\u00aa\u00a4'\u00e8g\u009f\u008f\u00bf[\u00c3\u008e\u009e\u00fd0\u00e2/\u00ff\u007f\u000b\u0098\u009c\n\u00fd\tx\u00ea\u0085\u00e8v[\u0010\u00ca\u00aa\u00b5\u00a8Hz@]d\u00c3\u009e\u0005\u00b9\u00dd\u00d0\u00dbz\u00fc\u009b:s\u00ddx\u0093\u00ba\u00a1\bZY".getBytes("ISO_8859_1");
        Object[] v1 = "<+\u00e2$\u00dd\u00dd\u0006\u00e7".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -906670849;
                case 1 -> -849347354;
                case 2 -> -847202634;
                case 3 -> -37172704;
                case 4 -> 1582656379;
                case 5 -> 1581909013;
                case 6 -> -531901071;
                case 7 -> -29901958;
                case 8 -> 1390250714;
                case 9 -> -164436017;
                case 10 -> -1914333248;
                case 11 -> -551592696;
                case 12 -> 104552695;
                case 13 -> 1127967241;
                case 14 -> 1556945118;
                case 15 -> 297925955;
                case 16 -> 1946545345;
                case 17 -> 406319167;
                case 18 -> -1324533744;
                case 19 -> -559281851;
                case 20 -> 37045123;
                case 21 -> -956463417;
                case 22 -> 1084422015;
                case 23 -> 1862887038;
                case 24 -> 779607142;
                case 25 -> -1420446972;
                case 26 -> -1086901833;
                case 27 -> -1500388971;
                case 28 -> -1511970161;
                case 29 -> 177194218;
                case 30 -> -662212167;
                case 31 -> -1336412741;
                case 32 -> 1910687068;
                case 33 -> 1642883548;
                case 34 -> -1975318669;
                case 35 -> -492734835;
                case 36 -> 1311614599;
                case 37 -> -1433744434;
                case 38 -> -1931566463;
                case 39 -> 999679174;
                case 40 -> -1153974704;
                case 41 -> -1169389977;
                case 42 -> 1077024631;
                case 43 -> -1143054763;
                case 44 -> 2079703645;
                case 45 -> 546840037;
                case 46 -> -774303133;
                case 47 -> 413108132;
                case 48 -> 1512047478;
                case 49 -> -231219988;
                case 50 -> 2039011577;
                case 51 -> -199763541;
                case 52 -> -162227999;
                case 53 -> 1393378469;
                case 54 -> 1880777520;
                case 55 -> 399584155;
                case 56 -> 802701857;
                case 57 -> -47228397;
                case 58 -> 36268852;
                case 59 -> 620524844;
                case 60 -> 635094922;
                case 61 -> -41117620;
                case 62 -> -199343791;
                case 63 -> 863701037;
                case 64 -> -1053117588;
                case 65 -> -1265676932;
                case 66 -> -1803455274;
                case 67 -> -964112346;
                case 68 -> 353350405;
                case 69 -> 1473089311;
                case 70 -> -539644410;
                case 71 -> -80785896;
                case 72 -> 620888605;
                case 73 -> -1766048028;
                case 74 -> 539315336;
                case 75 -> -1998494278;
                case 76 -> -437741335;
                case 77 -> 569284861;
                case 78 -> 1865847710;
                case 79 -> 68955914;
                case 80 -> -1366356306;
                case 81 -> 283269958;
                case 82 -> 2117239185;
                case 83 -> 1038705426;
                case 84 -> 387936688;
                case 85 -> 133337519;
                case 86 -> 1572318026;
                case 87 -> -840692248;
                case 88 -> 884698931;
                case 89 -> 2097769195;
                case 90 -> -1491885936;
                case 91 -> 120103131;
                case 92 -> -1483497126;
                case 93 -> 541836814;
                case 94 -> 536000549;
                case 95 -> 1202038593;
                case 96 -> 2072170831;
                case 97 -> -1266722978;
                case 98 -> -1770039086;
                case 99 -> -1127050880;
                case 100 -> 18776560;
                case 101 -> 597065579;
                case 102 -> 1910966575;
                case 103 -> 623273114;
                case 104 -> -1769135822;
                case 105 -> 1423657653;
                case 106 -> 197978058;
                case 107 -> -1962911405;
                case 108 -> -1752847874;
                case 109 -> -572184843;
                case 110 -> -275361751;
                case 111 -> -2142199480;
                case 112 -> 300123560;
                case 113 -> -1675932096;
                case 114 -> 1039652197;
                case 115 -> -1838161308;
                case 116 -> 1400182312;
                case 117 -> 1145041304;
                case 118 -> -1426732349;
                case 119 -> -679994485;
                case 120 -> 1297754282;
                case 121 -> 245272578;
                case 122 -> 1810696639;
                case 123 -> -228978914;
                case 124 -> 883630151;
                case 125 -> -1959122839;
                case 126 -> 1466807886;
                case 127 -> 1427530121;
                case 128 -> -1099377753;
                case 129 -> -268559043;
                case 130 -> -352640335;
                case 131 -> 20051236;
                case 132 -> 297809264;
                case 133 -> -1782648467;
                case 134 -> -1335814239;
                case 135 -> 1911641996;
                case 136 -> -1142138273;
                case 137 -> -167361166;
                case 138 -> -159372862;
                case 139 -> -1570822603;
                case 140 -> -13339406;
                case 141 -> 360166813;
                case 142 -> 897045335;
                case 143 -> 1860030447;
                case 144 -> 214618919;
                case 145 -> -2091745993;
                case 146 -> 221154547;
                case 147 -> -1757080635;
                case 148 -> -1297283266;
                case 149 -> -1066529734;
                case 150 -> 883232762;
                case 151 -> -678418373;
                case 152 -> -1254841031;
                case 153 -> 625859178;
                case 154 -> 428044956;
                case 155 -> 1646882927;
                case 156 -> 713776440;
                case 157 -> 298533080;
                case 158 -> 1596190034;
                case 159 -> 1009584162;
                case 160 -> 1629248834;
                case 161 -> 127539347;
                case 162 -> -62369205;
                case 163 -> -775177321;
                case 164 -> -45602975;
                case 165 -> 634871459;
                case 166 -> -739994884;
                case 167 -> -1819534579;
                case 168 -> 1564433969;
                case 169 -> -1927334920;
                case 170 -> 1362749782;
                case 171 -> -1799372968;
                case 172 -> -147050730;
                case 173 -> 1671026427;
                case 174 -> -1625065015;
                case 175 -> 1147071934;
                case 176 -> 1167677508;
                case 177 -> 1162187412;
                case 178 -> 1865315272;
                case 179 -> 1138571254;
                case 180 -> 415299156;
                case 181 -> -792876448;
                case 182 -> 740629453;
                case 183 -> -1481782546;
                case 184 -> 1876726649;
                case 185 -> 35437741;
                case 186 -> -1235927884;
                case 187 -> 727086617;
                case 188 -> -1714214656;
                case 189 -> 513487127;
                case 190 -> 189785762;
                case 191 -> -212028373;
                case 192 -> -1615263155;
                case 193 -> -361716783;
                case 194 -> 946438030;
                case 195 -> -1169676543;
                case 196 -> 1403053091;
                case 197 -> -1182178356;
                case 198 -> -1138850087;
                case 199 -> -542480117;
                case 200 -> -1040427297;
                case 201 -> 17791036;
                case 202 -> -1477274672;
                case 203 -> -388753195;
                case 204 -> -743586699;
                case 205 -> 1708704104;
                case 206 -> -542870356;
                case 207 -> 115046129;
                case 208 -> 1121216402;
                case 209 -> -1061020503;
                case 210 -> 1156278717;
                case 211 -> 353965515;
                case 212 -> 1735837812;
                case 213 -> 1075428628;
                case 214 -> 1436476714;
                case 215 -> -226272402;
                case 216 -> 314512103;
                case 217 -> 448335750;
                case 218 -> 778788255;
                case 219 -> -812001273;
                case 220 -> -1564473696;
                case 221 -> 1217446776;
                case 222 -> 1263271078;
                case 223 -> 102613213;
                case 224 -> -1796184426;
                case 225 -> 1534066610;
                case 226 -> 438981402;
                case 227 -> -807075495;
                case 228 -> 1039543057;
                case 229 -> -67518135;
                case 230 -> 813847172;
                case 231 -> -85345277;
                case 232 -> -2126914686;
                case 233 -> 944365244;
                case 234 -> -201710140;
                case 235 -> -762304241;
                case 236 -> -1387409449;
                case 237 -> -570601760;
                case 238 -> -591214290;
                case 239 -> 1832462036;
                case 240 -> 985418011;
                case 241 -> -1905816349;
                case 242 -> 1351574149;
                case 243 -> 1909978850;
                case 244 -> 2089457789;
                case 245 -> 1140414262;
                case 246 -> -348210956;
                case 247 -> 262535603;
                case 248 -> 1005500507;
                case 249 -> 695929954;
                case 250 -> -265069075;
                case 251 -> 578244563;
                case 252 -> 1318595356;
                case 253 -> 553607692;
                case 254 -> 2047631257;
                case 255 -> 1960823992;
                default -> -3935067;
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
            Ii00 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        II0I = 5;
        II0o = 2;
        II00 = 12;
        II0O = 5;
        IIOi = 9;
        IIOI = 4;
        IIOo = 180L;
        Ioii = 1.0f;
        IoiI = 0.65f;
        IIOO = new Color(255, 255, 255, 255);
        IIO0 = new Color(255, 255, 255, 255);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIii(LivingEntity param1, double param2) {
        PlayerEntity v6;
        if (param1 == LegitAuraModule.ConfigSupport_OI0.player) return false;
        if (!param1.method_5805()) return false;
        if (param1.method_31481()) {
            return false;
        }
        if (!((Boolean)this.o0OO.HelpCommand()).booleanValue() && param1.method_5767()) {
            return false;
        }
        Vec3d v4 = LegitAuraModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v5 = this.oOO(v4, param1.method_5829().expand((double)param1.method_5871()));
        if (!LegitAuraModule.ConfigSupport_OI0.player.method_6057((Entity)param1)) return false;
        if (v4.distanceTo(v5) > param2) {
            return false;
        }
        if (!this.IioO((Entity)param1, ((Integer)this.oOII.HelpCommand()).intValue())) {
            return false;
        }
        if (param1 instanceof PlayerEntity) {
            v6 = (PlayerEntity)param1;
            if (!((Boolean)this.oOio.HelpCommand()).booleanValue()) {
                return false;
            }
            if (0ooo.0I00() != null && 0ooo.0I0o().iIoO(v6)) {
                return false;
            }
            if (((Boolean)this.KbDelayModule.HelpCommand()).booleanValue() && RenderSupport_0I0.OIOi(v6)) {
                return false;
            }
            if (((Boolean)this.o0O0.HelpCommand()).booleanValue() && 0ooo.0IOi() != null && 0ooo.0I0O().CameraClipModule(v6)) {
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
        AntiBotModule v7 = AntiBotModule.iOoo();
        if (v7 == null) return true;
        if (!v7.iOoI((Entity)v6)) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIiO(LivingEntity param1) {
        float v5;
        if (param1 == null) {
            return false;
        }
        if (!this.III0(false)) return false;
        if (LegitAuraModule.ConfigSupport_OI0.player.method_18798().y < -0.08) {
            return false;
        }
        float v2 = LegitAuraModule.ConfigSupport_OI0.player.method_7279();
        if (v2 <= 0.0f) {
            return false;
        }
        float v3 = LegitAuraModule.ConfigSupport_OI0.player.method_7261(0.5f);
        float v4 = Math.max(0.0f, v2 * 0.9f - v3 * v2);
        float v6 = Math.max(v4, v5 = (float)(LegitAuraModule.ConfigSupport_OI0.player.method_18798().y / 0.08));
        float v8 = this.IIio(v6, v2);
        if (!(0.375f > v8)) return false;
        if (this.IIII()) return false;
        return true;
    }

    private float O0I00(float param1) {
        float v2 = Math.min(param1, 80.0f);
        float v3 = 0.55f + v2 / 28.0f;
        return Math.min(0.78467965f + v3, 11.5f);
    }

    @Override
    public boolean I0i0() {
        return ConfigSupport_oii0_1.OoO();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        LivingEntity v2 = this.o00o != null ? this.o00o : this.o00I;
        if ((Boolean)this.o0Oo.HelpCommand() == false) return;
        if (v2 == null) return;
        RenderSupport_oio_2.NetworkSupport_i0i_2(param1.0ii(), v2, param1.O0i(), 0.65f, IIOO, IIO0, 1.0f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean Ii0I(Vec3d param1) {
        BlockHitResult v2 = LegitAuraModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(LegitAuraModule.ConfigSupport_OI0.player.method_33571(), param1, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)LegitAuraModule.ConfigSupport_OI0.player));
        if (v2.getType() != HitResult.Type.MISS) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private float O0oii(LivingEntity param1) {
        if (this.III0 != param1.method_5628()) {
            this.IIII = this.III0 != Integer.MIN_VALUE;
            this.III0 = param1.method_5628();
            this.IIIo = 0.0f;
        }
        if (!this.IIII) {
            return 1.0f;
        }
        this.IIIo = Math.min(1.0f, this.IIIo + 0.75f);
        if (!(this.IIIo >= 1.0f)) {
            float v2 = this.IIIo * this.IIIo * (3.0f - 2.0f * this.IIIo);
            return 0.7f + v2 * 0.3f;
        }
        this.IIII = false;
        return 1.0f;
    }

    private boolean IIIi(boolean param1) {
        return this.IIIo(false, param1) && LegitAuraModule.ConfigSupport_OI0.player.field_6017 > 0.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIIo(boolean param1, boolean param2) {
        if (!this.III0(param1)) return false;
        if (!(LegitAuraModule.ConfigSupport_OI0.player.method_7261(0.5f) > 0.9f)) return false;
        if (!LegitAuraModule.ConfigSupport_OI0.player.method_5624()) return true;
        if (!param2) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IIoO() {
        if (!ConfigSupport_oii0_1.OoO()) return false;
        if ((Boolean)this.oOIi.HelpCommand() == false) return true;
        if (!this.o0O0()) return false;
        return true;
    }

    private Vec3d O0Ioo(LivingEntity param1, float param2, float param3, double param4, double param6) {
        Vec3d v8 = LegitAuraModule.ConfigSupport_OI0.player.method_5836(1.0f);
        Vec3d v9 = this.Ii0i(param2, param3);
        Vec3d v10 = v8.add(v9.multiply(param4));
        Box v11 = param1.method_5829().expand(param6);
        return v11.raycast(v8, v10).orElse(null);
    }

    private float IIio(float param1, float param2) {
        float v3 = (param1 + 0.5f) / param2;
        return Math.min(1.0f, 0.2f + v3 * v3 * 0.8f);
    }

    private boolean IIoi(LivingEntity param1) {
        return LegitAuraModule.ConfigSupport_OI0.player != null && param1 != null && LegitAuraModule.ConfigSupport_OI0.player.method_7261(0.5f) > 0.9f;
    }

    private boolean o0O0() {
        Item v1 = LegitAuraModule.ConfigSupport_OI0.player.method_6047().getItem();
        return v1 == Items.WOODEN_SWORD || v1 == Items.COPPER_SWORD || v1 == Items.STONE_SWORD || v1 == Items.GOLDEN_SWORD || v1 == Items.IRON_SWORD || v1 == Items.DIAMOND_SWORD || v1 == Items.NETHERITE_SWORD || v1 instanceof AxeItem || v1 instanceof MaceItem || v1 instanceof TridentItem;
    }

    /*
     * Enabled aggressive block sorting
     */
    private float[] O0oIo(LivingEntity param1) {
        float f;
        float v28;
        boolean v25;
        boolean v20;
        float v17;
        float v16;
        float v15;
        float v14;
        block10: {
            float v27;
            block9: {
                float v26;
                boolean v21;
                block8: {
                    block7: {
                        float[] cfr_ignored_0 = new float[0];
                        float[] cfr_ignored_1 = new float[0];
                        Vec3d v2 = LegitAuraModule.ConfigSupport_OI0.player.method_33571();
                        Vec3d v3 = this.O0IOO(param1);
                        double v4 = v3.x - v2.x;
                        double v6 = v3.y - v2.y;
                        double v8 = v3.z - v2.z;
                        double v10 = Math.sqrt(v4 * v4 + v8 * v8);
                        float v12 = (float)(Math.toDegrees(Math.atan2(v8, v4)) - 90.0);
                        float v13 = (float)(-Math.toDegrees(Math.atan2(v6, v10)));
                        v14 = 0ooo.0I0i() != null && 0ooo.0IoO().Oii() ? 0ooo.0I0I().ConfigSupport_OI0() : LegitAuraModule.ConfigSupport_OI0.player.method_36454();
                        v15 = 0ooo.0Io0() != null && 0ooo.0Ioo().Oii() ? 0ooo.0IoI().OIo() : LegitAuraModule.ConfigSupport_OI0.player.method_36455();
                        v16 = MathHelper.wrapDegrees((float)(v12 - v14));
                        v17 = v13 - v15;
                        float v18 = (float)Math.sqrt(v16 * v16 + v17 * v17);
                        Vec3d v19 = this.O0Ioo(param1, v14, v15, 3.0, 0.0);
                        boolean bl = v20 = v19 != null;
                        v21 = this.O0oiI(param1);
                        float[] v22 = this.O0oII(param1, v14, v15, v19, v21);
                        if (v22 != null) {
                            return v22;
                        }
                        float[] v23 = this.O0oIi(param1, v14, v15, v19);
                        if (v23 != null) {
                            return v23;
                        }
                        float v24 = this.O0oii(param1);
                        v25 = this.O0IOI();
                        v26 = this.O0I0O(v18) * v24;
                        v27 = this.O0I00(v18) * v24;
                        if (!v20) break block7;
                    }
                    if (v25) {
                        v26 *= 0.58f;
                    }
                    break block8;
                    v26 *= v25 ? 0.14f : 0.3f;
                    if (Math.abs(v16) < 8.0f) {
                        v26 = Math.min(v26, v25 ? 0.55f : 1.25f);
                    }
                }
                if (v25) {
                    v27 *= v20 && !v21 ? 0.12f : 0.45f;
                }
                v28 = Math.min(Math.abs(v16), v26);
                if (!v20 || v21) break block9;
            }
            f = Math.min(Math.abs(v17), v27);
            break block10;
            f = Math.min(Math.abs(v17), v25 ? 0.08f : 0.18f);
        }
        float v29 = f;
        float v30 = v14 + Math.copySign(v28, v16);
        float v31 = v15 + Math.copySign(v29, v17);
        if (!v25 && Math.abs(v16) > 1.5f) {
            v30 += this.O0I0o(-0.18f, 0.18f);
        }
        if (!v25 && !v20 && Math.abs(v17) > 1.0f) {
            v31 += this.O0I0o(-0.14f, 0.14f);
        }
        return new float[]{v14 + MathHelper.wrapDegrees((float)(v30 - v14)), MathHelper.clamp((float)v31, (float)-90.0f, (float)90.0f)};
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean O0oio(LivingEntity param1, Vec3d param2) {
        if (!this.O0IOi(param1)) return true;
        if (!LegitAuraModule.ConfigSupport_OI0.player.method_24828()) return true;
        if (!param1.method_24828()) return true;
        Box v3 = param1.method_5829();
        double v4 = v3.maxY - v3.minY;
        double v6 = v3.minY + v4 * 0.68;
        if (!(param2.y >= v6)) return false;
        return true;
    }

    private void II0i() {
        this.o00o = null;
        this.o00I = null;
        this.II0i = 0L;
        this.IIoO = 0L;
        this.IIo0 = Integer.MIN_VALUE;
        this.IIoI = Vec3d.ZERO;
        this.IIoi = null;
        this.IIIO = Double.NaN;
        this.III0 = Integer.MIN_VALUE;
        this.IIIo = 0.0f;
        this.IIII = false;
        this.IIIi = false;
        this.IIiO = 0.0f;
        this.IIi0 = Integer.MIN_VALUE;
        this.IIio = 0;
        this.IIiI = 0;
        this.IIii = 0.0f;
        this.IiOO = 0.0f;
        this.IiO0 = Integer.MIN_VALUE;
        this.IiOo = 0;
        this.IiOI = 0.0f;
        this.IiOi = 0.0f;
        this.o0o0 = false;
        this.o0oo = false;
        this.o0oI = false;
        this.o0oi = 0L;
        this.o0IO = 0L;
        this.o0I0 = 0L;
        this.Ii0O = 0L;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean O0I0i(LivingEntity param1, double param2, double param4) {
        if (param1 == null || 0ooo.0II0() == null) {
            return false;
        }
        float v6 = 0ooo.0Ioi().Oii() ? 0ooo.0IIO().ConfigSupport_OI0() : LegitAuraModule.ConfigSupport_OI0.player.method_36454();
        float v7 = 0ooo.0IIo().Oii() ? 0ooo.0III().OIo() : LegitAuraModule.ConfigSupport_OI0.player.method_36455();
        return this.O0Io0(param1, v6, v7, param2, param4);
    }

    private boolean IIII() {
        return this.IIIi(false);
    }

    private Vec3d O0IOo(Vec3d param1, Vec3d param2, double param3) {
        double v5 = param2.x - param1.x;
        double v7 = param2.y - param1.y;
        double v9 = param2.z - param1.z;
        double v11 = Math.sqrt(v5 * v5 + v7 * v7 + v9 * v9);
        if (!(v11 <= param3) && !(v11 <= 1.0E-4)) {
            double v13 = param3 / v11;
            return new Vec3d(param1.x + v5 * v13, param1.y + v7 * v13, param1.z + v9 * v13);
        }
        return param2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private double O0IO0(LivingEntity param1, boolean param2, boolean param3) {
        double v5;
        boolean v4 = !LegitAuraModule.ConfigSupport_OI0.player.method_24828() || !param1.method_24828();
        double d = v5 = param2 ? 0.045 : 0.16;
        if (!param3) {
            v5 += 0.05;
        }
        if (v4) {
            v5 *= param2 ? 0.55 : 0.75;
        }
        if (!this.O0IOI()) return Math.max(0.015, v5);
        return Math.max(0.015, v5 *= param2 ? 0.45 : 0.7);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void IIi0() {
        boolean v1 = LegitAuraModule.ConfigSupport_OI0.player.method_24828();
        if (this.o0oO && !v1) {
            long v2;
            this.o0IO = v2 = System.currentTimeMillis();
            this.o0oo = v2 - this.o0oi <= 350L && LegitAuraModule.ConfigSupport_OI0.player.method_18798().y > 0.08;
            this.o0oI = this.o0oo && this.III0(true);
            this.o0I0 = 0L;
        }
        if (!v1 && this.o0oo) {
            if (LegitAuraModule.ConfigSupport_OI0.player.method_18798().y < -0.01 && this.o0I0 == 0L) {
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

    private List IIiI(double param1) {
        ArrayList<LivingEntity> v3 = new ArrayList<LivingEntity>();
        Box v4 = LegitAuraModule.ConfigSupport_OI0.player.method_5829().expand(param1 + 1.0);
        for (Entity v6 : LegitAuraModule.ConfigSupport_OI0.world.method_8335((Entity)LegitAuraModule.ConfigSupport_OI0.player, v4)) {
            LivingEntity v7;
            if (!(v6 instanceof LivingEntity) || !this.IIii(v7 = (LivingEntity)v6, param1)) continue;
            v3.add(v7);
        }
        return v3;
    }

    private void O0oIO(boolean param1) {
        this.O0ooi(param1, 0L);
    }
}

