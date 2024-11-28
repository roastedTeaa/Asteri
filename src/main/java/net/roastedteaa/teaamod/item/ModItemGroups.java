package net.roastedteaa.teaamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.roastedteaa.teaamod.TeaaMod;
import net.roastedteaa.teaamod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ASTERI_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TeaaMod.MOD_ID, "asteri_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SHIV))
                    .displayName(Text.translatable("Asteri Items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SHIV);
                        entries.add(ModItems.ASTERI_INGOT);
                        entries.add(ModBlocks.ASTERI_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        TeaaMod.LOGGER.info("Registering Item Groups for " + TeaaMod.MOD_ID);
    }
}