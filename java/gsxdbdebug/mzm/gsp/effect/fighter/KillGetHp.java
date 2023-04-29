/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class KillGetHp extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.KillOtherHandle
/*    */ {
/*    */   private int gethp;
/*    */   private int gethprate;
/*    */   
/*    */   public KillGetHp(int gethp, int gethprate)
/*    */   {
/* 14 */     this.gethp = gethp;
/* 15 */     this.gethprate = gethprate;
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
/* 35 */     double maxHp = inputObj.attacker.getMaxHp();
/* 36 */     int addHp = (int)(maxHp * (this.gethprate * 1.0D / mzm.gsp.fight.main.FightArgs.getInstance().getDefaultRate()) + this.gethp);
/* 37 */     inputObj.attacker.addHp(addHp);
/* 38 */     outputObj.addHp += addHp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\KillGetHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */