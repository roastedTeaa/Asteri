package net.roastedteaa.teaamod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.roastedteaa.teaamod.block.ModBlocks;
import net.roastedteaa.teaamod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ASTERI_SMELTABLES = List.of(Items.IRON_INGOT);

        offerSmelting(exporter, ASTERI_SMELTABLES, RecipeCategory.MISC, ModItems.ASTERI_INGOT, 0.25f, 200, "asteri_ingot");
        offerBlasting(exporter, ASTERI_SMELTABLES, RecipeCategory.MISC, ModItems.ASTERI_INGOT, 0.25f, 100, "asteri_ingot");


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASTERI_BLOCK)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.ASTERI_INGOT)
                .criterion(hasItem(ModItems.ASTERI_INGOT), conditionsFromItem(ModItems.ASTERI_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ASTERI_INGOT, 9)
                .input(ModBlocks.ASTERI_BLOCK)
                .criterion(hasItem(ModBlocks.ASTERI_BLOCK), conditionsFromItem(ModBlocks.ASTERI_BLOCK))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SHIV)
                .pattern("   ")
                .pattern(" I ")
                .pattern("S  ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK);

    }
}
