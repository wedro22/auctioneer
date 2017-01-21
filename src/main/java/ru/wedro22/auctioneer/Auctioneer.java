package ru.wedro22.auctioneer;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.wedro22.auctioneer.util.AChat;
import ru.wedro22.auctioneer.util.ACommands;


@Mod(modid = Auctioneer.MODID, version = Auctioneer.VERSION)
public class Auctioneer
{
    public static final String MODID = "auctioneer";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void test(BlockEvent.BreakEvent br)
    {
        AChat.chatClient("wow!");
        AChat.chatServToPlayer(br.getPlayer(),"wow! (serv)");

        Style style = new Style();
        style.setColor(TextFormatting.RED);
        style.setBold(true);
        style.setUnderlined(true);
        style.setStrikethrough(true);

        AChat.chatClient("wow, colored!", style);
    }

    @EventHandler
    public void servStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new ACommands());
    }

}
