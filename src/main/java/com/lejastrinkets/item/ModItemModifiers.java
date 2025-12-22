package com.lejastrinkets.item;

// 1. Add these imports at the top of your file
import com.lejastrinkets.LejasTrinketsMod;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.Identifier;
import net.puffish.attributesmod.api.PuffishAttributes; // See note below if this is still red

public class ModItemModifiers {

    // Now 'public static' so other classes can use it
    public static AttributeModifiersComponent createResistanceModifier(Double value) {
        return AttributeModifiersComponent.builder()
                .add(
                        PuffishAttributes.RESISTANCE,
                        new EntityAttributeModifier(
                                Identifier.of(LejasTrinketsMod.MOD_ID, "ring_resistance"),
                                value,
                                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        ),
                        AttributeModifierSlot.ANY
                )
                .build();
    }

    public static AttributeModifiersComponent createDamageModifier(Double value) {
        return AttributeModifiersComponent.builder()
                .add(
                        PuffishAttributes.MELEE_DAMAGE,
                        new EntityAttributeModifier(
                                Identifier.of(LejasTrinketsMod.MOD_ID, "ring_melee_damage"),
                                value,
                                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        ),
                        AttributeModifierSlot.ANY
                )
                .build();
    }

    public static AttributeModifiersComponent createSpeedModifier(Double value) {
        return AttributeModifiersComponent.builder()
                .add(
                        PuffishAttributes.SPRINTING_SPEED,
                        new EntityAttributeModifier(
                                Identifier.of(LejasTrinketsMod.MOD_ID, "necklace_sprinting_speed"),
                                value,
                                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        ),
                        AttributeModifierSlot.ANY
                )
                .build();
    }
}