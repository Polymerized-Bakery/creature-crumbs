package com.daedreus.Bakery.CreatureCrumbs;

import net.minecraft.entity.LivingEntity;
import org.provim.nylon.api.AjHolder;
import org.provim.nylon.api.Animator;
import org.provim.nylon.api.VariantController;
import org.provim.nylon.util.NylonConstants;
import net.minecraft.entity.LimbAnimator;

public class AnimationHelper {

    public static void updateWalkAnimation(LivingEntity entity, AjHolder holder) {
        updateWalkAnimation(entity, holder, 0);
    }

    public static void updateWalkAnimation(LivingEntity entity, AjHolder holder, int priority) {
        Animator animator = holder.getAnimator();
        if (entity.limbAnimator.isLimbMoving() && entity.limbAnimator.getSpeed() > 0.02) {
            animator.playAnimation("walk", priority);
            animator.pauseAnimation("idle");
        } else {
            animator.pauseAnimation("walk");
            animator.playAnimation("idle", priority, true);
        }
    }

    public static void updateHurtColor(LivingEntity entity, AjHolder holder) {
        if (entity.hurtTime > 0 || entity.deathTime > 0) {
            holder.setColor(NylonConstants.DAMAGE_TINT_COLOR);
        } else {
            holder.clearColor();
        }
    }
}