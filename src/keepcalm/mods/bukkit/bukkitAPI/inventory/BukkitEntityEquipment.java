package keepcalm.mods.bukkit.bukkitAPI.inventory;

import keepcalm.mods.bukkit.bukkitAPI.BukkitServer;
import keepcalm.mods.bukkit.bukkitAPI.entity.BukkitEntity;
import keepcalm.mods.bukkit.bukkitAPI.item.BukkitItemStack;
import net.minecraft.entity.EntityLiving;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class BukkitEntityEquipment implements EntityEquipment {

	private EntityLiving owner;
	
	public BukkitEntityEquipment(EntityLiving entity) {
		owner = entity;
	}
	
	@Override
	public ItemStack getItemInHand() {
		return owner.getHeldItem()== null ? null : new BukkitItemStack(owner.getHeldItem()) ;
	}

	@Override
	public void setItemInHand(ItemStack stack) {
		if (stack == null)  {
			owner.setCurrentItemOrArmor(0, null);
			return;
		}
		owner.setCurrentItemOrArmor(0, BukkitItemStack.createNMSItemStack(stack));
	}

	@Override
	public ItemStack getHelmet() {
		return owner.getCurrentItemOrArmor(1) == null ? null : new BukkitItemStack(owner.getCurrentItemOrArmor(1));
	}

	@Override
	public void setHelmet(ItemStack helmet) {
		if (helmet != null)
			owner.setCurrentItemOrArmor(1, BukkitItemStack.createNMSItemStack(helmet));
		else
			owner.setCurrentItemOrArmor(1, null);
	}

	@Override
	public ItemStack getChestplate() {
		return owner.getCurrentItemOrArmor(2) == null ? null : new BukkitItemStack(owner.getCurrentItemOrArmor(2));
	}

	@Override
	public void setChestplate(ItemStack chestplate) {
		if (chestplate != null) owner.setCurrentItemOrArmor(2, BukkitItemStack.createNMSItemStack(chestplate));
		else owner.setCurrentItemOrArmor(2, null);
	}

	@Override
	public ItemStack getLeggings() {
		return owner.getCurrentItemOrArmor(3) == null ? null : new BukkitItemStack(owner.getCurrentItemOrArmor(3));
	}

	@Override
	public void setLeggings(ItemStack leggings) {
		if (leggings != null) owner.setCurrentItemOrArmor(3, BukkitItemStack.createNMSItemStack(leggings));
		else owner.setCurrentItemOrArmor(3, null);
	}

	@Override
	public ItemStack getBoots() {
		return owner.getCurrentItemOrArmor(4) == null ? null : new BukkitItemStack(owner.getCurrentItemOrArmor(4));
	}

	@Override
	public void setBoots(ItemStack boots) {
		if (boots != null) owner.setCurrentItemOrArmor(4, BukkitItemStack.createNMSItemStack(boots));
		else owner.setCurrentItemOrArmor(4, null);
	}

	@Override
	public ItemStack[] getArmorContents() {
		return new ItemStack[] { getHelmet(), getChestplate(), getLeggings(), getBoots() };
	}

	@Override
	public void setArmorContents(ItemStack[] items) {
		setHelmet(items[0]);
		setChestplate(items[1]);
		setLeggings(items[2]);
		setBoots(items[3]);
	}

	@Override
	public void clear() {
		setItemInHand(null);
		setHelmet(null);
		setChestplate(null);
		setLeggings(null);
		setBoots(null);
	}

	@Override
	public float getItemInHandDropChance() {
		// TODO Auto-generated method stub
		return 0.1F;
	}

	@Override
	public void setItemInHandDropChance(float chance) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getHelmetDropChance() {
		// TODO Auto-generated method stub
		return 0.1F;
	}

	@Override
	public void setHelmetDropChance(float chance) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getChestplateDropChance() {
		// TODO Auto-generated method stub
		return 0.1F;
	}

	@Override
	public void setChestplateDropChance(float chance) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getLeggingsDropChance() {
		// TODO Auto-generated method stub
		return 0.1F;
	}

	@Override
	public void setLeggingsDropChance(float chance) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getBootsDropChance() {
		// TODO Auto-generated method stub
		return 0.1F;
	}

	@Override
	public void setBootsDropChance(float chance) {
		// TODO Auto-generated method stub

	}

	@Override
	public Entity getHolder() {
		return BukkitEntity.getEntity(BukkitServer.instance(), owner);
	}

}
