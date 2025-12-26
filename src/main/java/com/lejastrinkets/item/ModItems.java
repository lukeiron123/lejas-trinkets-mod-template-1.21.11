package com.lejastrinkets.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.lejastrinkets.LejasTrinketsMod;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
        public static final List<Item> ALL_ITEMS = new ArrayList<>();

    public static final Item EMERALD_RING_IRON = register(
            "emerald_ring_iron",
            180,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createResistanceModifier(0.20)
                            )
            )
    );

    public static final Item DIAMOND_RING_IRON = register(
            "diamond_ring_iron",
            180,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createDamageModifier(0.20)
                            )
            )
    );

    public static final Item RUBY_NECKLACE_IRON = register(
            "ruby_necklace_iron",
            180,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createResistanceModifier(0.20)
                            )
            )
    );

    public static final Item RUBY_NECKLACE_GOLD = register(
            "ruby_necklace_gold",
            100,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createResistanceModifier(0.20)
                            )
            )
    );

    public static final Item DIAMOND_NECKLACE_IRON = register(
            "diamond_necklace_iron",
            180,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createResistanceModifier(0.20)
                            )
            )
    );
    public static final Item DIAMOND_NECKLACE_GOLD = register(
            "diamond_necklace_gold",
            100,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createResistanceModifier(0.20)
                            )
            )
    );

    public static final Item RABBITS_FOOT_NECKLACE = register(
            "rabbits_foot_necklace",
            70,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createSpeedModifier(2.00)
                            )
            )
    );

    public static final Item GOAT_HORN_NECKLACE = register(
            "goat_horn_necklace",
            70,
            settings -> new StatsTrinketItem(
                    settings
                            .component(
                                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                                    ModItemModifiers.createTamedDamageModifier(0.3)
                            )
            )
    );


    public static void registerModItems() {
        LejasTrinketsMod.LOGGER.info("Registering Mod Items for" + LejasTrinketsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(EMERALD_RING_IRON);
            entries.add(DIAMOND_RING_IRON);
            entries.add(RUBY_NECKLACE_IRON);
            entries.add(RUBY_NECKLACE_GOLD);
            entries.add(DIAMOND_NECKLACE_IRON);
            entries.add(DIAMOND_NECKLACE_GOLD);
            entries.add(RABBITS_FOOT_NECKLACE);
            entries.add(GOAT_HORN_NECKLACE);
        });
    }

    private static Item register(String name, Integer durability, Function<Item.Settings, Item> itemFactory) {

        // 1. Create the Identifier and RegistryKey automatically
        Identifier id = Identifier.of(LejasTrinketsMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);


        // 2. Create the Settings and apply the key
        Item.Settings settings = new Item.Settings()
                .registryKey(key)
                .maxCount(1)
                .maxDamage(durability); // Default durability for your rings

        // 3. Create the Item using the factory
        Item item = itemFactory.apply(settings);

        // 3.5 Add Item to Item List
        ALL_ITEMS.add(item);

        // 4. Register it
        return Registry.register(Registries.ITEM, id, item);
    }
}
