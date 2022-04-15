package dev.eggonomicon.bodyguards.entities;

import dev.eggonomicon.bodyguards.api.interfaces.Summonable;
import dev.eggonomicon.bodyguards.goals.FollowGolemSummonerGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class GolemKitGolemEntity extends IronGolemEntity implements Summonable {

    protected static final TrackedData<Optional<UUID>> SUMMONER_UUID;


    public GolemKitGolemEntity(EntityType<? extends GolemKitGolemEntity> type, World world) {
        super(EntityType.IRON_GOLEM, world);
        //this.setTamed(true);
    }

    //public static DefaultAttributeContainer.Builder createTastyBoneWolfAttributes(){
    //    return MobEntity.createMobAttributes()
    //            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D)
    //            .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
    //            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
    //}

    protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(SUMMONER_UUID, Optional.empty());
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(6, new FollowGolemSummonerGoal(this, this.getSummoner(), this.world, 1.0,
                this.getNavigation(), 90.0F, 3.0F, true));
        this.initCustomGoals();
    }

    protected void initCustomGoals(){
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    @Override
    public void setSummonerUuid(@Nullable UUID uuid) {
        this.dataTracker.set(SUMMONER_UUID, Optional.ofNullable(uuid));
    }

    public Optional<UUID> getSummonerUuid(){
        return this.dataTracker.get(SUMMONER_UUID);
    }

    @Override
    public void setSummoner(Entity player) {
        this.setSummonerUuid(player.getUuid());
    }

    public void writeCustomDateToTag(NbtCompound tag){
        super.writeCustomDataToNbt(tag);
        tag.putUuid("SummonerUUID",getSummonerUuid().get());
    }

    public void readCustomDataFromTag(NbtCompound tag){
        super.readCustomDataFromNbt(tag);
        UUID id;
        if (tag.contains("SummonerUUID")){
            id = tag.getUuid("SummonerUUID");
        } else {
            id = tag.getUuid("SummonerUUID");
        }
        if (id != null){
            this.setSummonerUuid(tag.getUuid("SummonerUUID"));
        }
    }

    @Override
    public void setAttacker(LivingEntity attacker){
        if (attacker == getSummoner()) {

        } else {
            super.setAttacker(attacker);
        }
    }

    @Override
    public void tickMovement() {
        if (this.isAlive() && getSummoner() != null) {
            if (getSummoner().getAttacker() != null) {
                this.setTarget(getSummoner().getAttacker());
            } else if (getSummoner().getAttacking() != null && getSummoner().getAttacking() != this) {
                this.setTarget(getSummoner().getAttacking());
            }
        }
        super.tickMovement();
    }

    public LivingEntity getSummoner(){
        try {
            return this.getSummonerUuid().map(value -> this.world.getPlayerByUuid(value)).orElse(null);
        } catch (IllegalArgumentException var2){
            return null;
        }
    }

    static {
        SUMMONER_UUID = DataTracker.registerData(GolemKitGolemEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }
}
