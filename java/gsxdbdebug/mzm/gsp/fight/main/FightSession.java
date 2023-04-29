/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class FightSession
/*    */   extends MilliSession
/*    */ {
/*    */   FightSession(long fightid, int interval)
/*    */   {
/* 13 */     super(interval, fightid);
/*    */   }
/*    */   
/*    */   protected long getFightid() {
/* 17 */     return getOwerId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */