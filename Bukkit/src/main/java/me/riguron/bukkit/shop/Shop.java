package me.riguron.bukkit.shop;

import lombok.RequiredArgsConstructor;
import org.bukkit.Server;
import me.riguron.system.shop.ActivePurchases;
import me.riguron.system.shop.Purchasable;

import java.util.UUID;

@RequiredArgsConstructor
public class Shop {

    private final ShopViews shopViews;
    private final ActivePurchases activePurchases;
    private final Server server;

    public void purchase(UUID player, Purchasable purchasable, Runnable onSuccess) {
        shopViews.openShopView(player, purchasable).displayTo(server.getPlayer(player));
        activePurchases.addPurchase(player, purchasable, onSuccess);
    }
}
