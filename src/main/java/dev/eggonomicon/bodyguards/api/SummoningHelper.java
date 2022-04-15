package dev.eggonomicon.bodyguards.api;

import dev.eggonomicon.bodyguards.api.interfaces.Summonable;
import dev.eggonomicon.bodyguards.entities.*;
import dev.eggonomicon.bodyguards.init.SummonedEntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class SummoningHelper {
/*
    public static final EntityType<SheepEntity>[] SHEEP = new EntityType[]{
            SummonedEntityRegistry.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY,
            SummonedEntityRegistry.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY,
            SummonedEntityRegistry.ENCHANTED_GRASS_RED_SHEEP_ENTITY
    };

    public static void summonBuzzyNestBee (LivingEntity entity, BlockPos blockPos){
        EntityType<BuzzyNestBeeEntity> bn_bee = SummonedEntityRegistry.BUZZY_NEST_BEE_ENTITY;

        World world = entity.getEntityWorld();

        BuzzyNestBeeEntity buzzyNestBeeEntity = bn_bee.create(world);
        assert buzzyNestBeeEntity != null;
        buzzyNestBeeEntity.setSummoner(entity);
        buzzyNestBeeEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        world.spawnEntity(buzzyNestBeeEntity);
    }

    public static void summonEnchantedGrassSheep (LivingEntity entity, BlockPos blockPos){
        Random random = new Random();
        int upperLimit = 3;
        int nameLimit = 99;
        int effectInt = random.nextInt(upperLimit);
        int nameRandom = random.nextInt(nameLimit);
        World world = entity.getEntityWorld();
        SheepEntity sheep = SHEEP[effectInt].create(world);
        if (sheep != null){
            ((Summonable)sheep).setSummoner(entity);
            sheep.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0,0);
        } else {
            return;
        }

        if (effectInt == 0){ // GREEN POISON SHEEP
            List<MobEntity> nearbyEntities = world.getEntitiesByClass(MobEntity.class,
                    new Box(sheep.getBlockPos()).expand(5),
                    (nearbyEntity) -> nearbyEntity != sheep && nearbyEntity.isAlive());
                for (MobEntity nearbyEntity : nearbyEntities){
                    StatusEffectInstance poison = new StatusEffectInstance(StatusEffects.POISON, 100, 4);
                    nearbyEntity.addStatusEffect(poison);
            }
        }
        world.spawnEntity(sheep);
        if (nameRandom <= 0){
            sheep.setCustomName(new LiteralText("Lilly"));
        }
        if (effectInt == 1) { // BLUE SPEED SHEEP
            List<PlayerEntity> nearbyEntities = world.getEntitiesByClass(PlayerEntity.class,
                        new Box(sheep.getBlockPos()).expand(10),
                        PlayerEntity::isAlive);
                for (PlayerEntity nearbyEntity : nearbyEntities){
                    StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 600, 2);
                    nearbyEntity.addStatusEffect(speed);
                }
            }
            world.spawnEntity(sheep);

        if (effectInt == 2) { // RED BURNING SHEEP
            List<MobEntity> nearbyEntities = world.getEntitiesByClass(MobEntity.class,
                        new Box(sheep.getBlockPos()).expand(5),
                        (nearbyEntity) -> nearbyEntity != sheep && nearbyEntity.isAlive());
                for (MobEntity nearbyEntity : nearbyEntities){
                    nearbyEntity.setOnFireFor(100);
                }
            }
            world.spawnEntity(sheep);

    }
*/
    public static void summonGolemKitGolem (LivingEntity entity, BlockPos blockPos){
        World world = entity.getEntityWorld();

        GolemKitGolemEntity golemKitGolemEntity = SummonedEntityRegistry.GOLEM_KIT_GOLEM_ENTITY.create(world);
        assert golemKitGolemEntity != null;
        golemKitGolemEntity.setSummoner(entity);
        golemKitGolemEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        world.spawnEntity(golemKitGolemEntity);
    }
/*
    public static void summonTastyBoneWolf (LivingEntity entity, BlockPos blockPos){
        World world = entity.getEntityWorld();

        TastyBoneWolfEntity tastyBoneWolfEntity = SummonedEntityRegistry.TASTY_BONE_WOLF_ENTITY.create(world);
        assert tastyBoneWolfEntity != null;
        tastyBoneWolfEntity.setSummoner(entity);
        tastyBoneWolfEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        world.spawnEntity(tastyBoneWolfEntity);
    }

    public static void summonWonderfulWheatLlama (LivingEntity entity, BlockPos blockPos){
        World world = entity.getEntityWorld();

        WonderfulWheatLlamaEntity wonderfulWheatLlamaEntity = SummonedEntityRegistry.WONDERFUL_WHEAT_LLAMA_ENTITY.create(world);
        assert wonderfulWheatLlamaEntity != null;
        wonderfulWheatLlamaEntity.setSummoner(entity);
        wonderfulWheatLlamaEntity.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
        world.spawnEntity(wonderfulWheatLlamaEntity);
    }
*/
    public static boolean isEntitySummonable(Entity target){
        return target instanceof GolemKitGolemEntity;
        /*
        return target instanceof BuzzyNestBeeEntity
                || target instanceof EnchantedGrassBlueSheepEntity
                || target instanceof EnchantedGrassGreenSheepEntity
                || target instanceof EnchantedGrassRedSheepEntity
                || target instanceof GolemKitGolemEntity
                || target instanceof TastyBoneWolfEntity
                || target instanceof WonderfulWheatLlamaEntity;
         */
    }
}
