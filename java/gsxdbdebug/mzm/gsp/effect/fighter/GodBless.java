/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class GodBless extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeKilledHandle
/*    */ {
/*    */   private int resurrectionrate;
/*    */   private int addhp;
/*    */   private int addhprate;
/*    */   
/*    */   public GodBless(int resurrectionrate, int addhp, int addhprate)
/*    */   {
/* 15 */     this.resurrectionrate = resurrectionrate;
/* 16 */     this.addhp = addhp;
/* 17 */     this.addhprate = addhprate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeKilledHandle(this);
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 28 */     fighter.remBeKilledHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, mzm.gsp.fight.handle.BeKilledHandle.OutPutObj outPutObj)
/*    */   {
/* 34 */     if (inputObj.target == null) {
/* 35 */       return;
/*    */     }
/* 37 */     Fighter target = inputObj.target;
/* 38 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 39 */     if (this.resurrectionrate > random) {
/* 40 */       int hpchange = (int)(target.getMaxHp() * (this.addhprate * 1.0D / FightArgs.getInstance().getDefaultRate()) + this.addhp);
/* 41 */       target.addHp(hpchange);
/* 42 */       if (target.getHp() > 0) {
/* 43 */         target.setAlive();
/* 44 */         target.onRelive();
/* 45 */         target.addActionCount();
/* 46 */         int passiveskillid = getPassiveSkillid();
/* 47 */         if (passiveskillid > 0) {
/* 48 */           outPutObj.targetPassiveSkillids.add(Integer.valueOf(passiveskillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\GodBless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */