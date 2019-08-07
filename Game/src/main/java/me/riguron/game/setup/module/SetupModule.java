package me.riguron.game.setup.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import me.riguron.config.client.ConfigurationSaver;
import me.riguron.game.setup.MapSetup;
import me.riguron.game.setup.command.SaveCommand;
import me.riguron.game.setup.command.TeleportCommand;
import org.bukkit.Server;

public class SetupModule extends AbstractModule {

    @Provides
    @Singleton
    public SaveCommand saveCommand(MapSetup mapSetup, ConfigurationSaver configurationSaver) {
        return new SaveCommand(mapSetup, configurationSaver);
    }

    @Provides
    @Singleton
    public TeleportCommand teleportCommand(Server server) {
        return new TeleportCommand(server);
    }
}
