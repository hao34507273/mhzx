/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.handle.FighterDeadHandle;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterFellow;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class DeathLove
/*     */   extends FighterEffect
/*     */   implements FighterDeadHandle, Validate
/*     */ {
/*     */   private int type;
/*     */   private int death;
/*     */   private int influence;
/*     */   private int effectid;
/*     */   private int partnerid1;
/*  24 */   private boolean effect = false;
/*     */   
/*     */   private static final int TYPE_FRIEND = 1;
/*     */   private static final int TYPE_ENERMY = 2;
/*     */   private static final int SELF = 1;
/*     */   private static final int OTHER = 2;
/*     */   
/*     */   public DeathLove(int type, int death, int influence, int effectid, int partnerid1)
/*     */   {
/*  33 */     this.type = type;
/*  34 */     this.death = death;
/*  35 */     this.influence = influence;
/*  36 */     this.effectid = effectid;
/*  37 */     this.partnerid1 = partnerid1;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  42 */     fighter.addFighterDeadHandle(this);
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  48 */     fighter.remFighterDeadHandle(this);
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public void onFighterDead(Fighter ownFighter, Fighter deadFighter)
/*     */   {
/*  54 */     if (this.effect) {
/*  55 */       return;
/*     */     }
/*  57 */     boolean canEffect = false;
/*  58 */     if ((this.death == 1) && 
/*  59 */       (ownFighter.getid() == deadFighter.getid())) {
/*  60 */       canEffect = true;
/*     */     }
/*     */     
/*  63 */     boolean isSameTeam = ownFighter.isInSameTeam(deadFighter);
/*  64 */     if ((this.death == 2) && 
/*  65 */       (ownFighter.getid() != deadFighter.getid())) {
/*  66 */       if (!deadFighter.isFellow()) {
/*  67 */         return;
/*     */       }
/*  69 */       int partnerid = ((FighterFellow)deadFighter).getPartnerid();
/*  70 */       if (partnerid != this.partnerid1) {
/*  71 */         return;
/*     */       }
/*  73 */       if ((this.type == 1) && 
/*  74 */         (isSameTeam)) {
/*  75 */         canEffect = true;
/*     */       }
/*     */       
/*  78 */       if ((this.type == 2) && 
/*  79 */         (!isSameTeam)) {
/*  80 */         canEffect = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  86 */     if (canEffect) {
/*  87 */       this.effect = true;
/*  88 */       if ((this.influence & 0x1) > 0) {
/*  89 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/*  90 */         if (addGroup != null) {
/*  91 */           int level = super.getSkillLevel();
/*  92 */           addGroup.run(level, ownFighter, ownFighter, ownFighter.getid());
/*     */         } else {
/*  94 */           GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */         }
/*     */       }
/*  97 */       if ((this.influence & 0x2) > 0) {
/*  98 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/*  99 */         if (addGroup != null) {
/* 100 */           int level = super.getSkillLevel();
/* 101 */           addGroup.run(level, ownFighter, deadFighter, deadFighter.getid());
/*     */         } else {
/* 103 */           GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean validate()
/*     */   {
/* 112 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 113 */     if (effectGroup == null) {
/* 114 */       throw new RuntimeException("DeathLove中配置的效果组id不存在:效果组id" + this.effectid);
/*     */     }
/* 116 */     if ((this.death == 2) && (PartnerInterface.getSPartnerCfgById(this.partnerid1) == null)) {
/* 117 */       throw new RuntimeException("DeathLove伙伴的配置的id不存在partnerid:" + this.partnerid1);
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DeathLove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */