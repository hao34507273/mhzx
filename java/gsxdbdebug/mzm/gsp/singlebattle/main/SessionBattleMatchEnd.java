/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SessionBattleMatchEnd
/*    */   extends Session
/*    */ {
/*    */   private final long _battleId;
/*    */   
/*    */   SessionBattleMatchEnd(long battleId, int second)
/*    */   {
/* 19 */     super(second, battleId);
/* 20 */     this._battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(this._battleId), new PBattleWaitClean(this._battleId, 1));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionBattleMatchEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */