/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class KillGetMp extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.KillOtherHandle
/*    */ {
/*    */   private int getmp;
/*    */   private int getmprate;
/*    */   
/*    */   public KillGetMp(int getmp, int getmprate)
/*    */   {
/* 14 */     this.getmp = getmp;
/* 15 */     this.getmprate = getmprate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addKillOtherHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remKillOtherHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void killOther(KillOtherHandle.InputObj inputObj, KillOtherHandle.OutputObj outputObj)
/*    */   {
/* 32 */     if (inputObj.attacker == null) {
/* 33 */       return;
/*    */     }
/* 35 */     double maxMp = inputObj.attacker.getMaxMp();
/* 36 */     int addmp = (int)(this.getmprate * 1.0D / mzm.gsp.fight.main.FightArgs.getInstance().getDefaultRate() * maxMp + this.getmp);
/* 37 */     inputObj.attacker.addMp(addmp);
/* 38 */     outputObj.addMp += addmp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\KillGetMp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */