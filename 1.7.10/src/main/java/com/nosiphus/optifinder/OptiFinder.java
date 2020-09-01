package com.nosiphus.optifinder;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.nosiphus.optifinder.init.ScanModsFolder;
import com.nosiphus.optifinder.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class OptiFinder {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	ScanModsFolder.main(Reference.VERSION);
    	
    }

}