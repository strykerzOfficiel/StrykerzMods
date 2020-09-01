package net.forge.mods.strykerzmods.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class VendreDiamondProcedure extends StrykerzmodsModElements.ModElement {
	public VendreDiamondProcedure(StrykerzmodsModElements instance) {
		super(instance, 72);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VendreDiamond!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VendreDiamond!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VendreDiamond!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VendreDiamond!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VendreDiamond!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.DIAMOND, (int) (1))) : false)) {
			{
				double _setval = (double) (((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StrykerzmodsModVariables.PlayerVariables())).money) + 75);
				entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				String _setval = (String) "\u00A7a+75$ \u00A7bDiamond \u00A7esur \u00A76MinerShop";
				entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Dernier_Achat = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("strykerzmods:cash_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.5);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("strykerzmods:cash_sound")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.5, false);
			}
		}
	}
}
