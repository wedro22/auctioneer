package ru.wedro22.auctioneer.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

/**
 * new commands (chat)
 */
public class ACommands{
    public static ArrayList<CommandBase> getCommands(){
        ArrayList<CommandBase> commands = new ArrayList<CommandBase>();

        commands.add(new Test1());
        commands.add(new Test2());
        commands.add(new Test3());

        return commands;
    }

    private static class Test1 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test1";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test1";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            AChat.chatServToPlayer(entityplayer, "TESTCOMMAND 1");
        }
    }

    private static class Test2 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test2";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test2";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            Style style = new Style();
            style.setColor(TextFormatting.RED);
            AChat.chatServToPlayer(entityplayer, "TESTCOMMAND 2", style);
        }
    }

    private static class Test3 extends CommandBase{

        @Override
        public String getCommandName() {
            return "test3";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "test3 <string>";
        }

        @Override
        public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
            Style style = new Style();
            style.setColor(TextFormatting.RED);

            String message = "test3";
            if (args.length!=0){
                for (String str:args) {
                    message=message+" "+str;
                }
            }

            AChat.chatServToPlayer(entityplayer, message, style);
        }
    }
}


/*public class ACommands extends CommandBase{

    @Override
    public String getCommandName() {
        return "acommands";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "draw text acommands";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
        AChat.chatServToPlayer(entityplayer, "TESTCOMMAND!");
    }
}*/


        /*ненужное
        MinecraftServer server=
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = new ServerCommandManager((MinecraftServer) command);
        manager.registerCommand(new ACommands());*/