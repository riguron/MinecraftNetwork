package me.riguron.game.config.map;

import lombok.Data;
import org.bukkit.Location;
import me.riguron.config.Configuration;

@Data
public class MapConfig implements Configuration {

    private String name;
    private Location spectator;
}
