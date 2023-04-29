/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforePoisonHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.RoundEndHandle;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class Plague
/*     */   extends FighterEffect implements RoundEndHandle
/*     */ {
/*     */   private int reducehprate;
/*     */   private int max;
/*     */   private boolean canInfected;
/*     */   
/*     */   public Plague(int paramInt1, int paramInt2)
/*     */   {
/*  32 */     this.reducehprate = paramInt1;
/*  33 */     this.max = paramInt2;
/*  34 */     if (paramInt1 > paramInt2) {
/*  35 */       this.reducehprate = paramInt2;
/*     */     }
/*  37 */     this.canInfected = false;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter paramFighter)
/*     */   {
/*  42 */     paramFighter.addBuffState(1003);
/*  43 */     paramFighter.addRoundEndHandle(this);
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter paramFighter)
/*     */   {
/*  49 */     paramFighter.remBuffState(1003);
/*  50 */     paramFighter.remRoundEndHandle(this);
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public void onRoundEnd(Fighter paramFighter)
/*     */   {
/*  56 */     if (!paramFighter.isAlive()) {
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     Fighter localFighter = getGroup().getReleaser(paramFighter);
/*  61 */     if ((!this.canInfected) && (isFriend(paramFighter, localFighter)))
/*     */     {
/*  63 */       this.canInfected = true;
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     int i = (int)(paramFighter.getHp() * (this.reducehprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  68 */     if (getGroup() != null)
/*     */     {
/*  70 */       if (getGroup().getEffectGroupType() == 16)
/*     */       {
/*  72 */         localObject1 = new BeforePoisonHandle.InputObj(localFighter, paramFighter, getGroup().getSkill());
/*     */         
/*  74 */         localObject2 = paramFighter.handleonBeforePoison((BeforePoisonHandle.InputObj)localObject1);
/*  75 */         i = (int)(i * (1.0D + ((BeforePoisonHandle.OutputObj)localObject2).expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/*  77 */       localObject1 = getGroup().getReleaser(paramFighter);
/*  78 */       if ((localObject1 != null) && (i > 0)) {
/*  79 */         ((Fighter)localObject1).addDamageToFighter(paramFighter, i);
/*     */       }
/*     */     }
/*  82 */     paramFighter.addHp(-i);
/*  83 */     Object localObject1 = paramFighter.getAndAddRoundStatus();
/*  84 */     localObject1.hpchange -= i;
/*  85 */     if ((paramFighter.isGhost()) && (paramFighter.isDead()))
/*     */     {
/*  87 */       paramFighter.setFakeDead();
/*     */     }
/*  89 */     paramFighter.fillFighterStatus((FighterStatus)localObject1);
/*  90 */     if ((paramFighter.isDead()) || (paramFighter.isFakeDead()))
/*     */     {
/*  92 */       localObject2 = paramFighter.handleBeKilled(new BeKilledHandle.InputObj(null, paramFighter, null, i));
/*  93 */       if (paramFighter.isAlive())
/*     */       {
/*  95 */         ((FighterStatus)localObject1).status_set.remove(Integer.valueOf(1));
/*  96 */         ((FighterStatus)localObject1).status_set.add(Integer.valueOf(3));
/*  97 */         FighterStatus localFighterStatus = paramFighter.getAndAddRoundStatus();
/*  98 */         paramFighter.fillBuffStatus(localFighterStatus);
/*  99 */         localFighterStatus.hpchange += paramFighter.getHp();
/* 100 */         localFighterStatus.status_set.add(Integer.valueOf(23));
/* 101 */         localFighterStatus.triggerpassiveskills.addAll(((BeKilledHandle.OutPutObj)localObject2).targetPassiveSkillids);
/*     */       }
/*     */     }
/*     */     
/* 105 */     Object localObject2 = randomNormalFriend(paramFighter);
/* 106 */     if (localObject2 != null) {
/* 107 */       int j = getLeftRound();
/* 108 */       if (j > 0)
/*     */       {
/* 110 */         FighterEffectGroup localFighterEffectGroup = getGroup().getFighterEffectGroup();
/* 111 */         if (localFighterEffectGroup != null) {
/* 112 */           FighterBuff localFighterBuff = localFighterEffectGroup.run(super.getSkillLevel(), paramFighter, (Fighter)localObject2, ((Fighter)localObject2).getid());
/* 113 */           localFighterBuff.setLeftRound(j);
/*     */         } else {
/* 115 */           GameServer.logger().error("不存在的效果");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean isFriend(Fighter paramFighter1, Fighter paramFighter2)
/*     */   {
/* 123 */     Set localSet = paramFighter1.getFriendFighters();
/* 124 */     if (localSet.size() == 0) {
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     for (Fighter localFighter : localSet) {
/* 129 */       if (localFighter.getid() == paramFighter2.getid()) {
/* 130 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   protected Fighter randomNormalFriend(Fighter paramFighter)
/*     */   {
/* 139 */     Set localSet = paramFighter.getFriendLiveFighters();
/* 140 */     if (localSet.size() == 0) {
/* 141 */       return null;
/*     */     }
/* 143 */     ArrayList localArrayList = new ArrayList();
/* 144 */     for (Fighter localFighter : localSet) {
/* 145 */       if (((paramFighter.isVisible()) || (!localFighter.isInvisible())) && (!localFighter.isPlague())) {
/* 146 */         localArrayList.add(localFighter);
/*     */       }
/*     */     }
/* 149 */     if (localArrayList.size() == 0) {
/* 150 */       return null;
/*     */     }
/* 152 */     int i = Xdb.random().nextInt(localArrayList.size());
/* 153 */     return (Fighter)localArrayList.get(i);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Plague.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */