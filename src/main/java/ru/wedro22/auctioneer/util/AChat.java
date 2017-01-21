package ru.wedro22.auctioneer.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Work with chat
 */
public class AChat {

    @SideOnly(Side.CLIENT)
    public static void chatClient(String message)
    {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
                new TextComponentString(message));
    }
    @SideOnly(Side.CLIENT)
    public static void chatClient(String message, Style style)
    {
        TextComponentString tcs = new TextComponentString(message);
        tcs.setStyle(style);
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(tcs);
    }


    public static void chatServToPlayer(EntityPlayer player, String message)
    {
        EntityPlayerMP pl = (EntityPlayerMP) player;
        pl.addChatMessage(new TextComponentString(message));

    }
}





    /*@SubscribeEvent
        public void p_t(TickEvent.PlayerTickEvent tick)
        {
            //System.out.println("Place, wow!");
            //FMLLog.info("Place, blin, wow!");
            //FMLLog.getLogger().log(org.apache.logging.log4j.Level.INFO, "asd");
        }
    @SubscribeEvent
    public void b_p(BlockEvent.BreakEvent br)
    {
        FMLLog.info("break. wow!");
        //EntityPlayerSP player = (EntityPlayerSP) br.getPlayer();
        br.getPlayer().addExperience(50);
        //ITextComponent txt = new TextComponentString()
        br.getPlayer().addChatMessage(new TextComponentString("wow!"));
    }


        Style style = new Style();
        style.setColor(TextFormatting.RED);
        style.setBold(true);
        style.setInsertion("was ist diese 'Insertion'?");
        style.setItalic(true);
        style.setStrikethrough(true);
        style.setUnderlined(true);*/

