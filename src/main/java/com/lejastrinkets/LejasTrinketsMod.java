package com.lejastrinkets;

import com.lejastrinkets.item.ModItemGroups;
import com.lejastrinkets.item.ModItems;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LejasTrinketsMod implements ModInitializer {
	public static final String MOD_ID = "lejas-trinkets-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamage, damageTaken, blocked) -> {
			// 1. Ensure it's a Player and on the Server
			if (entity instanceof ServerPlayerEntity player) {

				// 2. Access the player's Trinket inventory
				TrinketsApi.getTrinketComponent(player).ifPresent(component -> {

                        // 3. Iterate over EVERY equipped trinket slot
					component.forEach((slot, stack) -> {

						// 4. FILTER: Only affect items that actually have durability logic
						// This automatically includes your Rings/Necklaces if you set .maxDamage() on them
						if (!stack.isEmpty() && stack.isDamageable()) {

							int amount = (int) Math.ceil(damageTaken);

							if (amount > 0) {
								// 5. Apply damage using the 1.21 signature
								stack.damage(amount, (ServerWorld) player.getEntityWorld(), player, (item) -> {
									// Optional: Play a sound when the item breaks
									// player.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
								});
							}

						}
					});
				});
			}
		});

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                TrinketsApi.getTrinketComponent(player).ifPresent(component -> {
                    boolean hasNecklace = component.isEquipped(ModItems.RABBITS_FOOT_NECKLACE);
                    boolean hasRing = component.isEquipped(ModItems.IRON_DIAMOND_RING);

                    if(hasNecklace && hasRing) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 40, 2, true, true));
                    } else { player.removeStatusEffect(StatusEffects.JUMP_BOOST); }
                });
            }
        });
	}
}