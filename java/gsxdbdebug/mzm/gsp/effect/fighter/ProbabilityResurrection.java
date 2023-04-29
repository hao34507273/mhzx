/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ProbabilityResurrection extends FighterEffect implements mzm.gsp.fight.handle.BeKilledHandle
/*    */ {
/*    */   private int resurrectionrate;
/*    */   private int addhp;
/*    */   private int addhprate;
/*    */   private int mask;
/*    */   private static final int MASK_TRIAL = 1;
/*    */   
/*    */   public ProbabilityResurrection(int resurrectionrate, int addhp, int addhprate, int mask)
/*    */   {
/* 20 */     this.resurrectionrate = resurrectionrate;
/* 21 */     this.addhp = addhp;
/* 22 */     this.addhprate = addhprate;
/* 23 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 28 */     fighter.addBuffState(125);
/* 29 */     fighter.addBeKilledHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remBuffState(125);
/* 36 */     fighter.remBeKilledHandle(this);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*    */   {
/* 42 */     if (inputObj.target == null) {
/* 43 */       return;
/*    */     }
/* 45 */     Fighter target = inputObj.target;
/* 46 */     Fighter releser = inputObj.releser;
/* 47 */     if ((releser != null) && 
/* 48 */       (releser.isTrial()) && 
/* 49 */       ((this.mask & 0x1) > 0)) {
/* 50 */       return;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 55 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 56 */     if (this.resurrectionrate > random) {
/* 57 */       int hpchange = (int)(target.getMaxHp() * (this.addhprate * 1.0D / FightArgs.getInstance().getDefaultRate()) + this.addhp);
/* 58 */       target.addHp(hpchange);
/* 59 */       if (target.getHp() > 0) {
/* 60 */         target.setAlive();
/* 61 */         target.onRelive();
/* 62 */         target.addActionCount();
/* 63 */         int passiveskillid = getPassiveSkillid();
/* 64 */         if (passiveskillid > 0) {
/* 65 */           outPutObj.targetPassiveSkillids.add(Integer.valueOf(passiveskillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ProbabilityResurrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */