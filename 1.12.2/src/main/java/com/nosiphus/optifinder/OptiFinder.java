package com.nosiphus.optifinder;

import com.nosiphus.optifinder.init.ScanModsFolder;
import com.nosiphus.optifinder.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class OptiFinder {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	
    	ScanModsFolder.main(Reference.VERSION);
    	
    }

}