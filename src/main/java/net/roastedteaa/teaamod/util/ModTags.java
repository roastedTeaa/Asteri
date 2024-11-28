package net.roastedteaa.teaamod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.roastedteaa.teaamod.TeaaMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ASTERI_TOOL = createTag("needs_asteri_tool");
        public static final TagKey<Block> INCORRECT_FOR_ASTERI_TOOL = createTag("incorrect_for_asteri_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TeaaMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TeaaMod.MOD_ID, name));
        }
    }
}
