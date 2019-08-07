package me.riguron.system.shop;

import io.ebean.EbeanServer;
import me.riguron.system.player.CachingPlayerRepository;
import me.riguron.system.player.PlayerAssociation;
import me.riguron.system.player.PlayerProfile;
import me.riguron.system.player.PlayerProfileRepository;
import me.riguron.system.player.specification.UUIDSpecification;
import me.riguron.system.test.EbeanTesting;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class
PlayerPurchaseServiceTest {

    @Test
    public void purchase() {

        final EbeanServer ebeanServer = new EbeanTesting().getEbeanServer();

        PlayerProfileRepository playerProfileRepository = new CachingPlayerRepository(ebeanServer);

        PlayerPurchaseService service = new PlayerPurchaseService(playerProfileRepository);

        UUID uuid = UUID.randomUUID();
        PlayerProfile playerProfile = new PlayerProfile(uuid, "Name");
        playerProfile.deposit(100);
        playerProfileRepository.save(playerProfile);
        playerProfileRepository.put(uuid, playerProfile);

        service.purchase(uuid, new Purchasable() {
            @Override
            public int getId() {
                return 1;
            }

            @Override
            public long getPrice() {
                return 5;
            }

            @Override
            public String getDescription() {
                return "desc";
            }
        });

        Optional<PlayerProfile> optionalResult = playerProfileRepository.find(new UUIDSpecification(uuid), PlayerAssociation.PURCHASES);
        assertTrue(optionalResult.isPresent());
         PlayerProfile profile = optionalResult.get();
        assertTrue(profile.getPurchases().hasPurchase(1));

    }

}