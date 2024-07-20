package com.daedreus.Bakery.CreatureCrumbs;

import net.minecraft.resources.ResourceLocation;
import org.provim.nylon.data.AjLoader;


public class AjModel{
    public static final AjModel MODEL_FROM_ID = AjLoader.require(new ResourceLocation("namespace", "path"));
    public static final AjModel MODEL_FROM_FILEPATH = AjLoader.require("config/models/example.json");

}

