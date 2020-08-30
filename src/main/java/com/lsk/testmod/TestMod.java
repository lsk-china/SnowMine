package com.lsk.testmod;

import com.lsk.testmod.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "testmod", name = "testmod", version = "1.0.0", acceptedMinecraftVersions ="[1.12.2]")
public class TestMod {
	@SidedProxy(clientSide = "com.lsk.testmod.client.ClientProxy", serverSide = "com.lsk.testmod.common.CommonProxy")
	public static CommonProxy commonProxy;
	@Mod.Instance
	private static TestMod testMod;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		commonProxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		commonProxy.init(event);
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		commonProxy.postInit(event);
	}
}
