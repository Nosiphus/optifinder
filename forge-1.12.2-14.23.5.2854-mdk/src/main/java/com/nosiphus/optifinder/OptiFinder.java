package com.nosiphus.optifinder;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.nosiphus.optifinder.init.ScanModsFolder;

@Mod(modid = OptiFinder.MODID, name = OptiFinder.NAME, version = OptiFinder.VERSION)
public class OptiFinder {
	
    public static final String MODID = "optifinder";
    public static final String NAME = "OptiFinder";
    public static final String VERSION = "1.12.2_HD_U_F6_pre1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ScanModsFolder.main(VERSION);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}