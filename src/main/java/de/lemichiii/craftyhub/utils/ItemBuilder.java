package de.lemichiii.craftyhub.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    private List<String> lore = new ArrayList<>();
    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setLore(String lore) {
        itemMeta.setLore(this.lore);
        return this;
    }

    public ItemBuilder setName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}
