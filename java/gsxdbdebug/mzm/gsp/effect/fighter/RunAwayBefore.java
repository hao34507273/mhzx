/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.ExcuteCmdResult;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RunAwayBefore extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*    */ {
/*    */   private int runrate;
/*    */   
/*    */   public RunAwayBefore(int runrate)
/*    */   {
/* 14 */     this.runrate = runrate;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 19 */     int rate = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 20 */     if (this.runrate > rate) {
/* 21 */       ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 22 */       fighter.escape(excuteCmdResult);
/* 23 */       fighter.addCmdResult(excuteCmdResult);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 29 */     fighter.addRoundStartHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remRoundStartHandle(this);
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RunAwayBefore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */