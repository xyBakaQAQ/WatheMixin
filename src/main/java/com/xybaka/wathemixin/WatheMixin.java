package com.xybaka.wathemixin;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WatheMixin implements ModInitializer {
	public static final String MOD_ID = "wathemixin";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("WatheMixin loaded: OP players can access supporter-only commands.");
	}
}