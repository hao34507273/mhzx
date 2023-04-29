/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class DeathSkill
/*     */   extends FighterEffect implements BeKilledHandle, Validate
/*     */ {
/*     */   private int skillid;
/*     */   private int skillrate;
/*     */   private int round;
/*  21 */   private int effectRound = -1;
/*     */   
/*     */   public DeathSkill(int skillid, int skillrate, int round) {
/*  24 */     this.skillid = skillid;
/*  25 */     this.skillrate = skillrate;
/*  26 */     this.round = Math.max(round, 1);
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  31 */     fighter.addBuffState(130);
/*  32 */     fighter.addBeKilledHandle(this);
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  38 */     fighter.remBuffState(130);
/*  39 */     fighter.remBeKilledHandle(this);
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*     */   {
/*  45 */     if ((inputObj.target == null) || (inputObj.releser == null) || (inputObj.skill == null)) {
/*  46 */       return;
/*     */     }
/*  48 */     Fighter target = inputObj.target;
/*  49 */     Fighter releser = inputObj.releser;
/*  50 */     Skill skill = inputObj.skill;
/*  51 */     boolean roundOk = this.effectRound < 0;
/*  52 */     int curRound = releser.getRound();
/*  53 */     if ((!roundOk) && 
/*  54 */       (curRound - this.effectRound >= this.round)) {
/*  55 */       roundOk = true;
/*     */     }
/*     */     
/*  58 */     if (!roundOk) {
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  63 */     if (random >= this.skillrate) {
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     DeathSkillInputObj deathSkillInputObj = new DeathSkillInputObj(this.skillid, releser.getid());
/*  68 */     skill.putDeathSkill(target.getid(), deathSkillInputObj);
/*  69 */     this.effectRound = curRound;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void resetEffect()
/*     */   {
/*  77 */     this.effectRound = -1;
/*     */   }
/*     */   
/*     */   public class DeathSkillInputObj {
/*     */     private int skill;
/*     */     private int mainTargetid;
/*     */     
/*     */     public DeathSkillInputObj(int skill, int mainTargetid) {
/*  85 */       this.skill = skill;
/*  86 */       this.mainTargetid = mainTargetid;
/*     */     }
/*     */     
/*     */     public int getSkill() {
/*  90 */       return this.skill;
/*     */     }
/*     */     
/*     */     public int getMainTargetid() {
/*  94 */       return this.mainTargetid;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 100 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 101 */     if (skillCfg == null) {
/* 102 */       throw new RuntimeException("DeathSkill中配置的技能不存在!!skillid:" + this.skillid);
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DeathSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */