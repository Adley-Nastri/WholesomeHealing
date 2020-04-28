package me.thatjavaboi.wholesomehealing;

import cc.acquized.itembuilder.api.ItemBuilder;
import me.thatjavaboi.wholesomehealing.commands.GiveBandage;
import me.thatjavaboi.wholesomehealing.commands.MyHp;
import me.thatjavaboi.wholesomehealing.commands.WholesomeCommand;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.glow.GlowAPI;

import java.util.*;
import java.util.logging.Logger;

public final class Wholesome extends JavaPlugin implements Listener {

    public static final ItemStack ITEM_BANDAGE = (new ItemBuilder(Material.PAPER))
            .displayname(ChatColor.RED + "Bandage")
            .lore(Arrays.asList(ChatColor.BLUE + "Right click to heal")).build();
    private int ID = 77004;
    private Set<UUID> cooldown = new HashSet<>();
    private HashMap<UUID, Long> ent_cooldown = new HashMap<UUID, Long>();
    private HashMap<UUID, Boolean> playerPetGlow = new HashMap<UUID, Boolean>();
    private boolean bandageDropped;

    public void Update() {


        Updater updater = new Updater(this, ID, getFile(), Updater.UpdateType.DOWNLOAD, true);

    }


    public void runnable() {

        new BukkitRunnable() {
            @Override
            public void run() {


                bandageDropped = false;
                for (World w : getServer().getWorlds()) {
                    for (Player player : Bukkit.getOnlinePlayers()) {


                        for (LivingEntity le : w.getLivingEntities()) {
                            if (le instanceof Wolf) {
                                try {
                                    if ((((Wolf) le).isTamed() && ((Wolf) le).getOwner().getName().equals(player.getName()))) {

                                        GlowAPI.setGlowingAsync(le, !playerPetGlow.get(player.getUniqueId()), player);
                                    }

                                } catch (Exception ex) {

                                }


                            } else if (le instanceof Cat) {
                                try {
                                    if ((((Cat) le).isTamed() && ((Cat) le).getOwner().getName().equals(player.getName()))) {

                                        GlowAPI.setGlowingAsync(le, !playerPetGlow.get(player.getUniqueId()), player);
                                    }

                                } catch (Exception ex) {

                                }


                            } else if (le instanceof Parrot) {
                                try {
                                    if ((((Parrot) le).isTamed() && ((Parrot) le).getOwner().getName().equals(player.getName()))) {

                                        GlowAPI.setGlowingAsync(le, !playerPetGlow.get(player.getUniqueId()), player);
                                    }

                                } catch (Exception ex) {

                                }


                            }
                        }

                        if (!player.getInventory().containsAtLeast(ITEM_BANDAGE, 1)) {
                            playerPetGlow.put(player.getUniqueId(), true);
                        }
                        break;

                    }


                }
            }
        }.runTaskTimerAsynchronously(this, 0, 1);


    }


    public boolean UpdateCheck() {
        Updater updater = new Updater(this, ID, getFile(), Updater.UpdateType.VERSION_CHECK, true);
        return updater.getResult() == Updater.Result.UPDATE_FOUND;

    }

    public void onEnable() {
        getLogger().info(ChatColor.AQUA + "[WholesomeHealing] has been enabled!");

        Objects.requireNonNull(getCommand("wholesomehealing")).setTabCompleter(new WholesomeCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        ShapedRecipe bRecipe_1 = new ShapedRecipe(new NamespacedKey(this, "Bandage"), ITEM_BANDAGE);
        bRecipe_1.shape(
                "###",
                "SWS",
                "###");
        bRecipe_1.setIngredient('W', Material.WHITE_WOOL);
        bRecipe_1.setIngredient('S', Material.STRING);
        bRecipe_1.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_1);

        ShapedRecipe bRecipe_2 = new ShapedRecipe(new NamespacedKey(this, "Bandage2"), ITEM_BANDAGE);
        bRecipe_2.shape(
                "###",
                "SWS",
                "###");
        bRecipe_2.setIngredient('W', Material.BLACK_WOOL);
        bRecipe_2.setIngredient('S', Material.STRING);
        bRecipe_2.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_2);


        ShapedRecipe bRecipe_3 = new ShapedRecipe(new NamespacedKey(this, "Bandage3"), ITEM_BANDAGE);
        bRecipe_3.shape(
                "###",
                "SWS",
                "###");
        bRecipe_3.setIngredient('W', Material.BLUE_WOOL);
        bRecipe_3.setIngredient('S', Material.STRING);
        bRecipe_3.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_3);


        ShapedRecipe bRecipe_4 = new ShapedRecipe(new NamespacedKey(this, "Bandage4"), ITEM_BANDAGE);
        bRecipe_4.shape(
                "###",
                "SWS",
                "###");
        bRecipe_4.setIngredient('W', Material.BROWN_WOOL);
        bRecipe_4.setIngredient('S', Material.STRING);
        bRecipe_4.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_4);

        ShapedRecipe bRecipe_5 = new ShapedRecipe(new NamespacedKey(this, "Bandage5"), ITEM_BANDAGE);
        bRecipe_5.shape(
                "###",
                "SWS",
                "###");
        bRecipe_5.setIngredient('W', Material.CYAN_WOOL);
        bRecipe_5.setIngredient('S', Material.STRING);
        bRecipe_5.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_5);


        ShapedRecipe bRecipe_6 = new ShapedRecipe(new NamespacedKey(this, "Bandage6"), ITEM_BANDAGE);
        bRecipe_6.shape(
                "###",
                "SWS",
                "###");
        bRecipe_6.setIngredient('W', Material.GRAY_WOOL);
        bRecipe_6.setIngredient('S', Material.STRING);
        bRecipe_6.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_6);


        ShapedRecipe bRecipe_7 = new ShapedRecipe(new NamespacedKey(this, "Bandage7"), ITEM_BANDAGE);
        bRecipe_7.shape(
                "###",
                "SWS",
                "###");
        bRecipe_7.setIngredient('W', Material.GREEN_WOOL);
        bRecipe_7.setIngredient('S', Material.STRING);
        bRecipe_7.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_7);


        ShapedRecipe bRecipe_8 = new ShapedRecipe(new NamespacedKey(this, "Bandage8"), ITEM_BANDAGE);
        bRecipe_8.shape(
                "###",
                "SWS",
                "###");
        bRecipe_8.setIngredient('W', Material.LIGHT_BLUE_WOOL);
        bRecipe_8.setIngredient('S', Material.STRING);
        bRecipe_8.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_8);


        ShapedRecipe bRecipe_9 = new ShapedRecipe(new NamespacedKey(this, "Bandage9"), ITEM_BANDAGE);
        bRecipe_9.shape(
                "###",
                "SWS",
                "###");
        bRecipe_9.setIngredient('W', Material.LIGHT_GRAY_WOOL);
        bRecipe_9.setIngredient('S', Material.STRING);
        bRecipe_9.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_9);


        ShapedRecipe bRecipe_10 = new ShapedRecipe(new NamespacedKey(this, "Bandage10"), ITEM_BANDAGE);
        bRecipe_10.shape(
                "###",
                "SWS",
                "###");
        bRecipe_10.setIngredient('W', Material.LIME_WOOL);
        bRecipe_10.setIngredient('S', Material.STRING);
        bRecipe_10.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_10);


        ShapedRecipe bRecipe_11 = new ShapedRecipe(new NamespacedKey(this, "Bandage11"), ITEM_BANDAGE);
        bRecipe_11.shape(
                "###",
                "SWS",
                "###");
        bRecipe_11.setIngredient('W', Material.MAGENTA_WOOL);
        bRecipe_11.setIngredient('S', Material.STRING);
        bRecipe_11.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_11);


        ShapedRecipe bRecipe_12 = new ShapedRecipe(new NamespacedKey(this, "Bandage12"), ITEM_BANDAGE);
        bRecipe_12.shape(
                "###",
                "SWS",
                "###");
        bRecipe_12.setIngredient('W', Material.ORANGE_WOOL);
        bRecipe_12.setIngredient('S', Material.STRING);
        bRecipe_12.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_12);


        ShapedRecipe bRecipe_13 = new ShapedRecipe(new NamespacedKey(this, "Bandage13"), ITEM_BANDAGE);
        bRecipe_13.shape(
                "###",
                "SWS",
                "###");
        bRecipe_13.setIngredient('W', Material.PINK_WOOL);
        bRecipe_13.setIngredient('S', Material.STRING);
        bRecipe_13.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_13);


        ShapedRecipe bRecipe_14 = new ShapedRecipe(new NamespacedKey(this, "Bandage14"), ITEM_BANDAGE);
        bRecipe_14.shape(
                "###",
                "SWS",
                "###");
        bRecipe_14.setIngredient('W', Material.PURPLE_WOOL);
        bRecipe_14.setIngredient('S', Material.STRING);
        bRecipe_14.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_14);


        ShapedRecipe bRecipe_15 = new ShapedRecipe(new NamespacedKey(this, "Bandage15"), ITEM_BANDAGE);
        bRecipe_15.shape(
                "###",
                "SWS",
                "###");
        bRecipe_15.setIngredient('W', Material.RED_WOOL);
        bRecipe_15.setIngredient('S', Material.STRING);
        bRecipe_15.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_15);


        ShapedRecipe bRecipe_16 = new ShapedRecipe(new NamespacedKey(this, "Bandage16"), ITEM_BANDAGE);
        bRecipe_16.shape(
                "###",
                "SWS",
                "###");
        bRecipe_16.setIngredient('W', Material.YELLOW_WOOL);
        bRecipe_16.setIngredient('S', Material.STRING);
        bRecipe_16.setIngredient('#', Material.AIR);
        getServer().addRecipe(bRecipe_16);


        Objects.requireNonNull(getCommand("givebandage")).setExecutor(new GiveBandage(this));
        Objects.requireNonNull(getCommand("myhp")).setExecutor(new MyHp(this));
        Objects.requireNonNull(getCommand("wholesomehealing")).setExecutor(new WholesomeCommand(this));
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        Logger logger = getLogger();
        (new UpdateChecker(this, ID)).getVersion(version -> {
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("There is not a new update available.");
            } else {
                logger.info("There is a new update available.");
                getServer().broadcastMessage(ChatColor.AQUA + "[WholesomeHealing] New Update Available! (" + version + ")");

            }
        });
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerPetGlow.put(player.getUniqueId(), true);
            playerPetGlow.put(player.getUniqueId(), true);
        }
        runnable();
    }

    public void onDisable() {
    }


    @EventHandler
    public void bandage(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();


        if (e.getItem() == null || e.getItem().getType() == Material.AIR)
            return;
        if (!e.getItem().hasItemMeta())
            return;


        if (Objects.equals(e.getItem().getItemMeta(), ITEM_BANDAGE.getItemMeta())) {


            if (e.getAction() == Action.RIGHT_CLICK_AIR) {


                if (this.cooldown.contains(uuid) &&
                        p.getHealth() != p.getMaxHealth()) {


                    boolean CoolDownMsgActive = getConfig().getBoolean("CoolDownMessageEnable");
                    String CoolDownMsg = getConfig().getString("CoolDownMessage");

                    if (CoolDownMsgActive) {
                        assert CoolDownMsg != null;
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', CoolDownMsg)));
                    }


                    return;
                }
                if (p.getGameMode() == GameMode.SURVIVAL && p.getHealth() < p.getMaxHealth()) {
                    ItemStack newAmt = e.getItem();
                    if (newAmt.getAmount() <= 1) {
                        newAmt = new ItemStack(Material.AIR);

                    } else if (newAmt.getAmount() >= 1) {
                        newAmt.setAmount(newAmt.getAmount() - 1);
                    }

                    if (e.getHand() == EquipmentSlot.HAND) {
                        p.getInventory().setItemInMainHand(newAmt);
                    } else if (e.getHand() == EquipmentSlot.OFF_HAND) {
                        p.getInventory().setItemInOffHand(newAmt);
                    }

                    double HealFactor = getConfig().getDouble("HealFactor");
                    if (Math.round(p.getHealth()) + HealFactor >= p.getMaxHealth()) {
                        p.setHealth(20.0);
                    } else if (p.getHealth() + HealFactor < p.getMaxHealth()) {
                        p.setHealth(Math.round(p.getHealth()) + HealFactor);
                    }

                    int CoolDown = getConfig().getInt("Cooldown");

                    boolean HealMsgActive = getConfig().getBoolean("HealMessageEnable");
                    String HealMsg = getConfig().getString("HealMessage");

                    if (HealMsgActive) {
                        assert HealMsg != null;
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', HealMsg)));
                    }


                    for (Player pls : Bukkit.getOnlinePlayers()) {
                        pls.spawnParticle(Particle.HEART, p.getEyeLocation(), 1000);
                        pls.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);


                    }

                    this.cooldown.add(uuid);
                    (new RemoveCooldown(uuid)).runTaskLater(this, CoolDown);
                }

            }
            if (e.getAction() == Action.LEFT_CLICK_AIR && !bandageDropped) {


                if (e.isCancelled()) {

                    playerPetGlow.put(p.getUniqueId(), !this.playerPetGlow.get(p.getUniqueId()));


                    String status;

                    status = !playerPetGlow.get(p.getUniqueId()) ? "aENABLED" : "4DISABLED";
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "Pet Locator &" + status)));


                }
            }


        }


    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (isbandage(e.getItemDrop())) {
            this.bandageDropped = true;
        }
    }




    public boolean isbandage(Item item) {
        if (item.getItemStack().getItemMeta().equals(ITEM_BANDAGE.getItemMeta()))
            return true;
        else
            return false;
    }


    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();


        if (Objects.equals(player.getInventory().getItemInMainHand().getItemMeta(), ITEM_BANDAGE.getItemMeta())) {


            if (entity instanceof Wolf || entity instanceof Cat || entity instanceof Parrot) {


                if (((Tameable) entity).isTamed() && ((Tameable) entity).getOwner().getName().equals(player.getName())) {


                    if (ent_cooldown.containsKey(player.getUniqueId()) && ent_cooldown.get(player.getUniqueId()) > System.currentTimeMillis()) {


                        boolean PetCoolDownMsgActive = getConfig().getBoolean("PetCoolDownMessageEnable");
                        String PetCoolDownMsg = getConfig().getString("PetCoolDownMessage");

                        if (PetCoolDownMsgActive) {
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', PetCoolDownMsg)));
                        }


                    } else {
                        int PetCool = getConfig().getInt("PetCooldown");
                        ent_cooldown.put(player.getUniqueId(), System.currentTimeMillis() + (PetCool * 1000));
                        double pet_maxHp = ((Animals) entity).getMaxHealth();
                        double ent_hp = ((Animals) entity).getHealth();


                        if (ent_hp < pet_maxHp) {


                            ItemStack newAmt = player.getInventory().getItemInMainHand();
                            if (newAmt.getAmount() <= 1) {
                                newAmt = new ItemStack(Material.AIR);

                            } else if (newAmt.getAmount() >= 1) {
                                newAmt.setAmount(newAmt.getAmount() - 1);
                            }

                            if (event.getHand() == EquipmentSlot.HAND) {
                                player.getInventory().setItemInMainHand(newAmt);
                            } else if (event.getHand() == EquipmentSlot.OFF_HAND) {
                                player.getInventory().setItemInOffHand(newAmt);
                            }


                            double PetHealFactor = getConfig().getDouble("PetHealFactor");
                            if (Math.round(ent_hp) + PetHealFactor >= pet_maxHp) {
                                ((Animals) entity).setHealth(pet_maxHp);
                            } else if (ent_hp + PetHealFactor < pet_maxHp) {
                                ((Animals) entity).setHealth(Math.round(ent_hp) + PetHealFactor);
                            }


                            boolean PetHealMsgActive = getConfig().getBoolean("HealMessageEnable");
                            String PetHealMsg = getConfig().getString("PetHealMessage");
                            if (PetHealMsgActive) {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', PetHealMsg)));
                            }


                            for (Player pls : Bukkit.getOnlinePlayers()) {
                                pls.spawnParticle(Particle.HEART, ((Animals) entity).getEyeLocation(), 1000);
                                pls.playSound(entity.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);


                            }

                        }
                    }
                }
                if (((Tameable) entity).isTamed() && !((Tameable) entity).getOwner().getName().equals(player.getName())) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "That isn't your pet")));
                }

                event.setCancelled(true);
            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        playerPetGlow.put(p.getUniqueId(), true);


        (new UpdateChecker(this, ID)).getVersion(version -> {
            if (!getDescription().getVersion().equalsIgnoreCase(version))
                p.sendMessage(ChatColor.AQUA + "[WholesomeHealing] New Update Available! (Version : " + version + ")");

        });

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        playerPetGlow.remove(p.getUniqueId());

    }


    public class RemoveCooldown extends BukkitRunnable {
        private UUID uuid;

        private RemoveCooldown(UUID uuid) {
            this.uuid = uuid;
        }

        public void run() {
            Wholesome.this.cooldown.remove(this.uuid);
        }
    }
}
