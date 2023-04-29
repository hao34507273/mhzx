/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ProbabilityDamagereduction extends FighterEffect implements mzm.gsp.fight.handle.Damagereduction
/*    */ {
/*    */   private int mask;
/*    */   private int reductionrate;
/*    */   private int damagereductionrate;
/* 15 */   private static int PHY_TYPE = 1;
/* 16 */   private static int MGC_TYPE = 2;
/*    */   
/*    */   public ProbabilityDamagereduction(int mask, int reductionrate, int damagereductionrate) {
/* 19 */     this.mask = mask;
/* 20 */     this.reductionrate = reductionrate;
/* 21 */     this.damagereductionrate = damagereductionrate;
/*    */   }
/*    */   
/*    */   private int effect(int damage) {
/* 25 */     if (this.damagereductionrate >= FightArgs.getInstance().getDefaultRate()) {
/* 26 */       return 1;
/*    */     }
/* 28 */     damage = (int)(damage * (1.0D - this.damagereductionrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 29 */     damage = Math.max(1, damage);
/* 30 */     return damage;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 35 */     fighter.addBeDamageHandle(this);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 41 */     fighter.remBeDamageHandle(this);
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 47 */     int damageType = inputObj.getDamageType();
/* 48 */     if ((((this.mask & PHY_TYPE) > 0) && (damageType == 1)) || (((this.mask & MGC_TYPE) > 0) && (damageType == 2)))
/*    */     {
/* 50 */       int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 51 */       if (this.reductionrate > random) {
/* 52 */         outputObj.nowDamage = effect(outputObj.nowDamage);
/* 53 */         int triggerSkillid = getPassiveSkillid();
/* 54 */         if (triggerSkillid > 0) {
/* 55 */           outputObj.targetPassiveSkillids.add(Integer.valueOf(triggerSkillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ProbabilityDamagereduction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */