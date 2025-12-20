package com.lejastrinkets.item;

import java.util.ArrayList;
import java.util.List;

import com.lejastrinkets.LejasTrinketsMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
        public static final List<Item> ALL_ITEMS = new ArrayList<>();
    public static final Item EMERALD_RING = registerItem("emerald_ring", new Item(
            new Item.Settings().registryKey(
                    RegistryKey.of(
                            RegistryKeys.ITEM, Identifier.of(LejasTrinketsMod.MOD_ID,"emerald_ring"))
            )
    ));

    public static final Item DIAMOND_RING = registerItem("diamond_ring", new Item(
            new Item.Settings().registryKey(
                    RegistryKey.of(
                            RegistryKeys.ITEM, Identifier.of(LejasTrinketsMod.MOD_ID, "diamond_ring")
                    )
            )
    ));

    public static final Item RUBY_NECKLACE = registerItem("ruby_necklace", new Item(
            new Item.Settings().registryKey(
                    RegistryKey.of(
                            RegistryKeys.ITEM, Identifier.of(LejasTrinketsMod.MOD_ID,"ruby_necklace"))
            )
    ));

    private static Item registerItem(String name, Item item) {
        ALL_ITEMS.add(item);
        return Registry.register(Registries.ITEM, Identifier.of(LejasTrinketsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LejasTrinketsMod.LOGGER.info("Registering Mod Items for" + LejasTrinketsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(EMERALD_RING);
            entries.add(DIAMOND_RING);
            entries.add(RUBY_NECKLACE);
        });
    }
}
