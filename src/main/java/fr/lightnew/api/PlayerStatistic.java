package fr.lightnew.api;

import org.bukkit.entity.Player;

public class PlayerStatistic {

    private Integer kill;
    private Integer death;
    private Integer point;

    public PlayerStatistic() {
        kill = 0;
        death = 0;
        point = 0;
    }

    public Integer getDeath() {
        return death;
    }

    public Integer getKill() {
        return kill;
    }

    public Integer getPoint() {
        return point;
    }

    public void addDeath(Integer death) {
        this.death = this.death+death;
    }

    public void addKill(Integer kill) {
        this.kill = this.kill+kill;
    }

    public void addPoint(Integer point) {
        this.point = this.point+point;
    }
}
