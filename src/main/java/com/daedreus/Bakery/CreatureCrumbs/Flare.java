package com.daedreus.Bakery.CreatureCrumbs;

import eu.pb4.polymer.virtualentity.api.attachment.EntityAttachment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.provim.nylon.api.AjEntity;
import org.provim.nylon.data.AjLoader;
import org.provim.nylon.data.model.nylon.NylonModel;
import org.provim.nylon.holders.entity.EntityHolder;
import org.provim.nylon.holders.entity.living.LivingEntityHolder;
import net.minecraft.entity.LivingEntity;



public class Flare extends LivingEntity implements AjEntity {
    public static final Identifier ID = Identifier.of("creaturecrumbs", "flare");
    public static final NylonModel MODEL = AjLoader.require(ID);
    private final EntityHolder<Flare> holder;

    public Flare(EntityType<? extends LivingEntity> type, World level) {
        super(type, level);

        // Creates model holder with out of the box support for most LivingEntity features.
        // Note that it is always possible to write your own or override some of their methods.
        this.holder = new LivingEntityHolder<>(this, MODEL);

        // Attaches the holder to this entity in Polymer.
        // Make sure that ticking is enabled, as it is required for model updates.
        EntityAttachment.ofTicking(this.holder, this);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.stuckStingerTimer % 2 == 0) {
            AnimationHelper.updateWalkAnimation(this, this.holder);
            AnimationHelper.updateHurtColor(this, this.holder);
        }
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }


    @Override
    public EntityHolder<Flare> getHolder() {
        return this.holder;
    }
}