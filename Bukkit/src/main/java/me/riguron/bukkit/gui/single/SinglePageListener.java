package me.riguron.bukkit.gui.single;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.riguron.bukkit.gui.Executable;
import me.riguron.bukkit.gui.item.NoOpExecutable;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class SinglePageListener  {

    private Map<Integer, Executable> slotActions = new HashMap<>();

    public void inventoryClicked(InventoryClickEvent event) {
        slotActions
                .getOrDefault(event.getSlot(), NoOpExecutable.INSTANCE)
                .execute(event.getWhoClicked().getUniqueId());
        event.setCancelled(true);
    }

    public void addHandler(Integer slot, Executable executable) {
        slotActions.put(slot, executable);
    }
}
