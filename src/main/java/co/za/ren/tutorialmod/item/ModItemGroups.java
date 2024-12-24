package co.za.ren.tutorialmod.item;

import co.za.ren.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static co.za.ren.tutorialmod.block.ModBlocks.PINK_GARNET_BLOCK;
import static co.za.ren.tutorialmod.block.ModBlocks.RAW_PINK_GARNET_BLOCK;
import static co.za.ren.tutorialmod.item.ModItems.PINK_GARNET;
import static co.za.ren.tutorialmod.item.ModItems.RAW_PINK_GARNET;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(PINK_GARNET);
                        entries.add(RAW_PINK_GARNET);
                    }).build());
    public static final ItemGroup PINK_GARNET_BlOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(PINK_GARNET_BLOCK);
                        entries.add(RAW_PINK_GARNET_BLOCK);
                    }).build());

    public static void registerModItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for {}", TutorialMod.MOD_ID);
    }
}
