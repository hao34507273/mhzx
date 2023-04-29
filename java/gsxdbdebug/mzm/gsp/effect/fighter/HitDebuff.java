/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class HitDebuff extends FighterEffect implements mzm.gsp.fight.handle.AfterAttackHandle, mzm.gsp.effect.fighter.Interface.Validate
/*     */ {
/*     */   private int mask;
/*     */   private int hitdebuffrate;
/*     */   private int debuffid;
/*     */   private int main;
/*     */   private static final int MAX_TIMES = 10;
/*  22 */   private int times = 0;
/*  23 */   private int curRound = 0;
/*     */   private static final int ALL = 0;
/*     */   private static final int MAIN = 1;
/*     */   private static final int SUB = 2;
/*     */   
/*     */   public HitDebuff(int mask, int hitdebuffrate, int debuffid, int main)
/*     */   {
/*  30 */     this.mask = mask;
/*  31 */     this.hitdebuffrate = hitdebuffrate;
/*  32 */     this.debuffid = debuffid;
/*  33 */     this.main = main;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  38 */     fighter.addAfterAttackHandle(this);
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  44 */     fighter.remAfterAttackHandle(this);
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public void afterAttack(AfterAttackHandle.InputObj inputObj, AfterAttackHandle.OutPutObj outPutObj)
/*     */   {
/*  50 */     if ((inputObj.skill == null) || (inputObj.releser == null) || (inputObj.target == null)) {
/*  51 */       return;
/*     */     }
/*  53 */     Skill skill = inputObj.skill;
/*  54 */     Fighter releser = inputObj.releser;
/*  55 */     Fighter target = inputObj.target;
/*  56 */     if ((skill.getType() & this.mask) > 0) {
/*  57 */       if (releser == null) {
/*  58 */         return;
/*     */       }
/*  60 */       if (target == null) {
/*  61 */         return;
/*     */       }
/*  63 */       switch (this.main) {
/*     */       case 0: 
/*     */         break;
/*     */       case 1: 
/*  67 */         if (skill.getMainTargetId() != target.getid()) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */       case 2: 
/*  72 */         if (skill.getMainTargetId() == target.getid()) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */       default: 
/*  77 */         return;
/*     */       }
/*     */       
/*  80 */       int round = releser.getRound();
/*  81 */       if (round > this.curRound) {
/*  82 */         this.times = 0;
/*  83 */         this.curRound = round;
/*     */       }
/*  85 */       if (this.times >= 10) {
/*  86 */         return;
/*     */       }
/*     */       
/*  89 */       int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  90 */       if (random < this.hitdebuffrate) {
/*  91 */         this.times += 1;
/*  92 */         FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.debuffid);
/*  93 */         if (effectGroup != null) {
/*  94 */           int level = super.getSkillLevel();
/*  95 */           effectGroup.run(level, releser, target, target.getid());
/*  96 */           int passiveSkillid = getPassiveSkillid();
/*  97 */           if (passiveSkillid > 0) {
/*  98 */             outPutObj.releaserPassiveSkills.add(Integer.valueOf(passiveSkillid));
/*     */           }
/*     */         } else {
/* 101 */           GameServer.logger().error("不存在的效果组id" + this.debuffid);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean validate()
/*     */   {
/* 111 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 112 */     if (effectGroup == null) {
/* 113 */       throw new RuntimeException("HitDebuff中配置的效果组id不存在:效果组id" + this.debuffid);
/*     */     }
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HitDebuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */