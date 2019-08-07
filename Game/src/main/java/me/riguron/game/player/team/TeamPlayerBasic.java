package me.riguron.game.player.team;

import org.bukkit.entity.Player;
import me.riguron.game.player.BasicGamePlayer;
import me.riguron.game.team.NullTeam;
import me.riguron.game.team.Team;

public class TeamPlayerBasic extends BasicGamePlayer implements TeamPlayer {

    private Team team = NullTeam.INSTANCE;

    public TeamPlayerBasic(Player player) {
        super(player);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isInTeam() {
        return this.team != NullTeam.INSTANCE;
    }

    public boolean isTeamMate(TeamPlayer other) {
        return other.getTeam().equals(this.team);
    }
}
