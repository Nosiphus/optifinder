package com.nosiphus.optifinder;

import com.nosiphus.optifinder.init.ScanModsFolder;
import com.nosiphus.optifinder.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Reference.MODID)
public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public Main() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event) {
    	
        ScanModsFolder.main(Reference.VERSION);
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	
        
        
    }

}