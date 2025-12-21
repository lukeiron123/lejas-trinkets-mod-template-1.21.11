package com.lejastrinkets.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public class EffectRingItem extends TrinketItem {

    // Variables to store which effect this specific ring has
    private final RegistryEntry<StatusEffect> effect;
    private final int amplifier;

    // Constructor: We ask for the Effect and Level when we create the item
    public EffectRingItem(Settings settings, RegistryEntry<StatusEffect> effect, int amplifier) {
        super(settings);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    // Default constructor if you just want Level 1 effect (Amplifier 0)
    public EffectRingItem(Settings settings, RegistryEntry<StatusEffect> effect) {
        this(settings, effect, 0);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.getEntityWorld().isClient()) {
            // Use the variables we stored!
            entity.addStatusEffect(new StatusEffectInstance(
                    this.effect,
                    40,  // Duration (2 seconds to ensure it stays on)
                    this.amplifier,
                    false,
                    false
            ));
        }
        super.tick(stack, slot, entity);
    }
}