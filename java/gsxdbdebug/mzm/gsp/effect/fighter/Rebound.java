/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Rebound extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.ReboundHandle
/*    */ {
/*    */   private int mask;
/*    */   private int damagerate;
/*    */   
/*    */   public Rebound(int mask, int damagerate)
/*    */   {
/* 14 */     this.mask = mask;
/* 15 */     this.damagerate = damagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addReboundHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remReboundHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void onRebound(Fighter fighter, int damageType, int damage, ReboundHandle.OutPutObj outPutObj)
/*    */   {
/* 32 */     if ((this.mask & damageType) > 0) {
/* 33 */       int reboundDamage = (int)(damage * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 34 */       outPutObj.reboundDamage += reboundDamage;
/* 35 */       int passiveSkillid = getPassiveSkillid();
/* 36 */       if (passiveSkillid > 0) {
/* 37 */         outPutObj.targetPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Rebound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */