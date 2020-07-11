package com.nosiphus.optifinder;

import com.nosiphus.optifinder.init.ScanModsFolder;
import com.nosiphus.optifinder.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(Reference.MODID)
public class Main {

    public Main() {

    	ScanModsFolder.main(Reference.VERSION);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }

}