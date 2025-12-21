package com.lejastrinkets.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class IronEmeraldRingItem extends TrinketItem {
    public IronEmeraldRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.getEntityWorld().isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SPEED,
                    20 * 2,
                    0,
                    false,
                    false
            ));
        }
    }

}
