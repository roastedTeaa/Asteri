package net.roastedteaa.teaamod.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.roastedteaa.teaamod.TeaaMod;

import java.util.List;


public class ModItems {

    public static final Item ASTERI_INGOT = registerItem("asteri_ingot", new Item(new Item.Settings()));
    public static final Item RAW_ASTERI = registerItem("raw_asteri", new Item(new Item.Settings()));

    public static final Item SHIV = registerItem("shiv", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.teaamod.shiv.shift_down"));
            } else {
                tooltip.add(Text.translatable("tooltip.teaamod.shiv"));
            }

            super.appendTooltip(stack, context, tooltip, type);

            new SwordItem(ModToolMaterials.ASTERI_INGOT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ASTERI_INGOT, 3, -2.4f)));
        }
    });


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TeaaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TeaaMod.LOGGER.info("Registering Mod Items for " + TeaaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SHIV);
        });
    }
}
