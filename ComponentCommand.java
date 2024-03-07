package dev.zozi.lynx.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.ItemUtil;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleComponent;
import org.mineacademy.fo.remain.Remain;

@AutoRegister
public final class ComponentCommand extends SimpleCommand {

	public ComponentCommand() {
		super("component");

		setUsage("<githubnative | githubfoundation>");
		setMinArguments(1);
	}

	@Override
	protected void onCommand() {
		checkConsole();

		String type = args[0].toLowerCase();

		//Native approach
		if ("githubnative".equals(type)) {
			TextComponent first = new TextComponent(TextComponent.fromLegacyText(Common.colorize("&cHello there! &7You are holding ")));

			first.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/CoderJaco"));
			first.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(Common.colorize("&8Click this to check how I made this. &7(&5Github Link&7)"))));

			ItemStack item = getPlayer().getItemInHand();
			boolean air = item.getType() == Material.AIR;

			TextComponent second = new TextComponent(TextComponent.fromLegacyText(Common.colorize(air ? "Air" : ItemUtil.bountifyCapitalized(item.getType()))));
			second.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new BaseComponent[]{new TextComponent(Remain.toJson(item))})); //If you're using the native approach, you need to use the toJson method (Check buttom code).
			second.setColor(ChatColor.GRAY);

			TextComponent main = new TextComponent("");

			main.addExtra(first);
			main.addExtra(second);

			getPlayer().spigot().sendMessage(main);
		} 
		//Foundation approach (Note: When you are using foundation you don't have to copy the toJson method!)
		else if ("githubfoundation".equals(type)) {

			ItemStack item = getPlayer().getItemInHand();
			boolean air = item.getType() == Material.AIR;

			SimpleComponent
					.of("&cHello there! &7You are holding ")
					.onClickRunCmd("/me is the best")
					.onHover("&6Click this text to run a cool command!")

					.append(air ? "Air" : ItemUtil.bountifyCapitalized(item.getType()))
					.onHover(item)

					.send(getPlayer());
		}
	}

	/*public static String toJson(ItemStack item) {
		if (MinecraftVersion.atLeast(MinecraftVersion.V.v1_4)) {
			// ItemStack methods to get a net.minecraft.server.ItemStack object for serialization
			final Class<?> craftItemstack = ReflectionUtil.getOBCClass("inventory.CraftItemStack");
			final Method asNMSCopyMethod = ReflectionUtil.getMethod(craftItemstack, "asNMSCopy", ItemStack.class);

			// NMS Method to serialize a net.minecraft.server.ItemStack to a valid Json string
			final Class<?> nmsItemStack = ReflectionUtil.getNMSClass("ItemStack", "net.minecraft.world.item.ItemStack");
			final Class<?> nbtTagCompound = ReflectionUtil.getNMSClass("NBTTagCompound", "net.minecraft.nbt.NBTTagCompound");
			final Method saveItemstackMethod = ReflectionUtil.getMethod(nmsItemStack, MinecraftVersion.atLeast(MinecraftVersion.V.v1_18) ? "b" : "save", nbtTagCompound);

			final Object nmsNbtTagCompoundObj = ReflectionUtil.instantiate(nbtTagCompound);
			final Object nmsItemStackObj = ReflectionUtil.invoke(asNMSCopyMethod, null, item);
			final Object itemAsJsonObject = ReflectionUtil.invoke(saveItemstackMethod, nmsItemStackObj, nmsNbtTagCompoundObj);

			// Return a string representation of the serialized object
			return itemAsJsonObject.toString();
		}

		return item.getType().toString();
	}*/
}
