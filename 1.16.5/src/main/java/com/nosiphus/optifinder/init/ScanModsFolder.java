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
				
				if(name.contentEquals("OptiFine_" + version + ".jar")) {
					
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
			downloader(version);
			Window.main(version);
			
		}
		
	}

	public static void downloader(String version) {
		
		try {
			
			String page = "https://www.nosiphus.com/minecraft/mods/optifinder/" + version;
			
			System.setProperty("java.awt.headless", "false");
			
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