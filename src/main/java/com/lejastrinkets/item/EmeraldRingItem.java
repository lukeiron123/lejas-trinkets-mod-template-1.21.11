package com.lejastrinkets.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class EmeraldRingItem extends TrinketItem {
    public EmeraldRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.getEntityWorld().isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.HERO_OF_THE_VILLAGE,
                    20 * 15,
                    0,
                    false,
                    false
            ));
        }
    }

}
