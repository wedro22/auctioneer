package ru.wedro22.auctioneer.util;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * new commands (chat)
 */
public class ACommands extends CommandBase{

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
}



        /*ненужное
        MinecraftServer server=
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = new ServerCommandManager((MinecraftServer) command);
        manager.registerCommand(new ACommands());*/