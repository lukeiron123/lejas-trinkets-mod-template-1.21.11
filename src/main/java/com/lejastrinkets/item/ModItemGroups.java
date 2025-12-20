package com.lejastrinkets.item;

import com.lejastrinkets.LejasTrinketsMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ALL_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LejasTrinketsMod.MOD_ID, "all_item_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY_NECKLACE))
                    .displayName(Text.translatable("itemgroup.lejastrinkets.all_item_group"))
                    .entries((displayContext, entries) -> {
                        for (Item item : ModItems.ALL_ITEMS) {
                            entries.add(item);
                        }
                    })
                    .build());

    public static void registerItemGroups() {
        LejasTrinketsMod.LOGGER.info("Register Item Groups for " + LejasTrinketsMod.MOD_ID);

    }

}
