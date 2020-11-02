package supercoder79.databreaker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Databreaker implements ModInitializer {
	Logger logger = LogManager.getLogger("DataBreaker");
	
	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			logger.info("I am become Databreaker, destroyer of loading times");
		} else {
			// Congrats on making it this far, use -Ddatabreaker.i_accept_responsibility_for_my_actions=true to have a chance of screwing up your world.
			if (System.getProperty("databreaker.i_accept_responsibility_for_my_actions", "false").equals("true")) {
				logger.warn("SUPERCODER79 IS NOT RESPONSIBLE FOR ANY DAMAGE CAUSED BY USING DATABREAKER IN A PRODUCTION ENVIRONMENT.");
				logger.warn("THERE IS A GOOD CHANCE THAT YOUR GAME WILL BE COMPLETELY SCREWED UP IF YOU LOAD UP A WORLD WITHOUT OPTIMIZING.");
				logger.warn("DO NOT USE DATABREAKER IN A NON-DEVELOPMENT ENVIRONMENT.");
			} else {
				// Please don't do it.
				throw new CrashException(new CrashReport("Do not use DataBreaker in a production environment.", new RuntimeException()));
			}
		}
	}
}
