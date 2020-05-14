package net.thenova.factions.placeholder;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.FactionsPlugin;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright 2019 ipr0james
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public final class FactionsPlaceholder extends PlaceholderExpansion {

    public boolean register() {
        final JavaPlugin pl = (FactionsPlugin) Bukkit.getPluginManager().getPlugin("Factions");
        if (pl == null) {
            return false;
        }
        return super.register();
    }

    @Override
    public String getIdentifier() {
        return "novafactions";
    }

    @Override
    public String getAuthor() {
        return "ipr0james";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return "";
        }

        switch (identifier) {
            case "chat":
                return FPlayers.getInstance().getByPlayer(player).hasFaction() ? ("{rel_factions_relation_color}" +
                        FPlayers.getInstance().getByPlayer(player).getFaction().getTag() + " ") : "";
            case "name":
                return FPlayers.getInstance().getByPlayer(player).hasFaction() ? FPlayers.getInstance().getByPlayer(player).getFaction().getTag() : "No Faction";
        }

        return "";
    }
}
