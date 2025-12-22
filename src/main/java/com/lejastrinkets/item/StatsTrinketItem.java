package com.lejastrinkets.item;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class StatsTrinketItem extends TrinketItem {

    public StatsTrinketItem(Settings settings) {
        super(settings);
    }

    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier id) {
        Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers = ArrayListMultimap.create();
        modifiers.putAll(super.getModifiers(stack, slot, entity, id));

        // Get the component
        AttributeModifiersComponent component = stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS);

        if (component != null) {

            component.modifiers().forEach(entry -> {
                EntityAttributeModifier original = entry.modifier();

                // Create a UNIQUE ID for this slot.
                // Using slot.index() is often safer/simpler than slot names.
                Identifier uniqueId = Identifier.of(
                        original.id().getNamespace(),
                        original.id().getPath() + "_trinket_" + slot.index()
                );

                EntityAttributeModifier uniqueModifier = new EntityAttributeModifier(
                        uniqueId,
                        original.value(),
                        original.operation()
                );

                modifiers.put(entry.attribute(), uniqueModifier);
            });
        }

        return modifiers;
    }
}