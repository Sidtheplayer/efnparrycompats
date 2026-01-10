package sid.efnparrycompats;

import com.mojang.logging.LogUtils;
import net.corruptdog.cdm.main.CDmoveset;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import sid.efnparrycompats.compats.EfnXOtherModsParryCompat;
import yesman.epicfight.compat.ICompatModule;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(EfnparrycompatsMod.MODID)
public class EfnparrycompatsMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "efnparrycompats";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EfnparrycompatsMod(FMLJavaModLoadingContext eventBus) {
        IEventBus bus = eventBus.getModEventBus();

        // Register the commonSetup method for mod-loading
        bus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

       if(ModList.get().isLoaded(CDmoveset.MOD_ID)){
           ICompatModule.loadCompatModule(eventBus, EfnXOtherModsParryCompat.class);
     }

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }

    }
}
