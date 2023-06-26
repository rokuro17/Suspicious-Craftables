package rokuro.craftable_sus;


import com.sun.tools.javac.jvm.Items;
import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.iface.ReadWriteNBT;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.level.levelgen.material.MaterialRuleList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.event.Event;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import static org.bukkit.WorldCreator.name;

public final class Craftable_Sus extends JavaPlugin implements Listener {

    public void registerItems(){
        //Make a list with all the Material items
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Suspiciously crafting enabled!");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        List<Material> sus_items = Arrays.asList(Material.values());

        List<ItemStack> stacks = new ArrayList<ItemStack>();
        for (Material item : sus_items) {
            ItemStack gravel_item = new ItemStack(Material.SUSPICIOUS_GRAVEL);
            ItemMeta gravel_meta = gravel_item.getItemMeta();
            ArrayList<String> gravel_lore = new ArrayList<String>();
            gravel_lore.add("WARNING! All items will lose their enchantments and custom properties.");
            gravel_meta.setLore(gravel_lore);
            gravel_item.setItemMeta(gravel_meta);

            String i = item.name().toLowerCase();
            String material = "minecraft:" + i;

            NBTItem gravel_nbti = new NBTItem(gravel_item);
            NBTCompound gravelnbti = gravel_nbti.addCompound("BlockEntityTag");
            NBTCompound nbt = gravelnbti.addCompound("item");
            nbt.setString("id", material);
            nbt.setByte("Count", (byte) 1);
            gravel_item.setItemMeta(gravel_nbti.getItem().getItemMeta());

            NamespacedKey sus_gravel = new NamespacedKey(this, "sus_gravel");
            ShapelessRecipe sus_gravel_recipe = new ShapelessRecipe(gravel_item);
            sus_gravel_recipe.addIngredient(Material.GRAVEL);
            sus_gravel_recipe.addIngredient(item);
            Bukkit.addRecipe(sus_gravel_recipe);

            //-------------------------------------------------------------------------------

            ItemStack sand_item = new ItemStack(Material.SUSPICIOUS_SAND);
            ItemMeta sand_meta = sand_item.getItemMeta();
            ArrayList<String> sand_lore = new ArrayList<String>();
            sand_lore.add("WARNING! All items will lose their enchantments and custom properties.");
            sand_meta.setLore(sand_lore);
            sand_item.setItemMeta(sand_meta);

            String t = item.name().toLowerCase();
            String material_ = "minecraft:" + t;

            NBTItem sand_nbti = new NBTItem(sand_item);
            NBTCompound sandnbti = sand_nbti.addCompound("BlockEntityTag");
            NBTCompound nbt_ = sandnbti.addCompound("item");
            nbt_.setString("id", material_);
            nbt_.setByte("Count", (byte) 1);
            sand_item.setItemMeta(sand_nbti.getItem().getItemMeta());

            NamespacedKey sus_sand = new NamespacedKey(this, "sus_sand");
            ShapelessRecipe sus_sand_recipe = new ShapelessRecipe(sand_item);
            sus_sand_recipe.addIngredient(Material.SAND);
            sus_sand_recipe.addIngredient(item);
            Bukkit.addRecipe(sus_sand_recipe);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}