
package net.forge.mods.strykerzmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.forge.mods.strykerzmods.itemgroup.BilletTabItemGroup;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

@StrykerzmodsModElements.ModElement.Tag
public class Billet20Item extends StrykerzmodsModElements.ModElement {
	@ObjectHolder("strykerzmods:billet_20")
	public static final Item block = null;
	public Billet20Item(StrykerzmodsModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BilletTabItemGroup.tab).maxStackSize(64));
			setRegistryName("billet_20");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
