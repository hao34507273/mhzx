/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.ExcuteCmdResult;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RunAwayAfter extends FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle
/*    */ {
/*    */   private int runrate;
/*    */   
/*    */   public RunAwayAfter(int runrate)
/*    */   {
/* 14 */     this.runrate = runrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 19 */     fighter.addRoundEndHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remRoundEndHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter fighter)
/*    */   {
/* 31 */     int rate = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 32 */     if (this.runrate > rate) {
/* 33 */       ExcuteCmdResult excuteCmdResult = new ExcuteCmdResult();
/* 34 */       fighter.escape(excuteCmdResult);
/* 35 */       fighter.addCmdResult(excuteCmdResult);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RunAwayAfter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */