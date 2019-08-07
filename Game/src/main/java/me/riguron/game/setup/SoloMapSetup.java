package me.riguron.game.setup;

import lombok.Getter;
import org.bukkit.Location;
import me.riguron.game.config.map.MapConfig;
import me.riguron.game.config.map.solo.SoloMapConfig;

import java.util.ArrayList;

@Getter
public class SoloMapSetup implements MapSetup {

    private SoloMapConfig soloMapConfig;

    public SoloMapSetup() {
        this.reset();
    }

    @Override
    public void reset() {
        this.soloMapConfig = new SoloMapConfig();
        this.soloMapConfig.setSpawnLocations(new ArrayList<>());
    }

    @Override
    public MapConfig getConfig() {
        return soloMapConfig;
    }

    @Override
    public void setSpectator(Location location) {
        soloMapConfig.setSpectator(location);
    }

    @Override
    public void setName(String name) {
        this.soloMapConfig.setName(name);
    }

    public void addLocation(Location location) {
        this.soloMapConfig.getSpawnLocations().add(location);
    }

}
