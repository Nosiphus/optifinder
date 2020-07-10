package com.nosiphus.optifinder.init;

import java.awt.Desktop;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ScanModsFolder {
	
	String location = (new File("mods")).getAbsolutePath();
	String[] mods;
	boolean isPresent;
	
	public ScanModsFolder(final String version) {
		
		File folder = new File(location);
		
		FilenameFilter optifineFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				if(name.contentEquals("OptiFine_" + version + "_MOD.jar")) {
					
					isPresent = true;
					return true;
					
				} else {
					
					return false;
					
				}
				
			}
			
		};
		
		File[] files = folder.listFiles(optifineFilter);
		
		for (File file : files) {
			
			System.out.println(file.getName());
			
		}
		
		if (isPresent) {
			
			System.out.println("OptiFine is installed, proceeding.");
			return;
			
		} else {
			
			System.out.println("OptiFine is not installed, exiting.");
			
			//The current problem with the code rests right here. Further information on the new event system is needed.
			
			//For now, we shall set the game to terminate right here.
			
			System.exit(0);
			
			
			//downloader(version);
			//Window.main(version);
			
		}
		
	}

	public void downloader(String version) {
		
		try {
			
			String page = "https://www.nosiphus.com/minecraft/optifinder/" + version;
			
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				
				Desktop.getDesktop().browse(new URI(page));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (URISyntaxException f) {
			
			f.printStackTrace();
			
		}
		
	}
	
	public static void main(String version) {
		
		new ScanModsFolder(version);
		
	}
	
}