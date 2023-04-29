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
/*    */ class SessionBattleWaitCleanEnd
/*    */   extends Session
/*    */ {
/*    */   private final long _battleId;
/*    */   
/*    */   SessionBattleWaitCleanEnd(long battleId, int second)
/*    */   {
/* 18 */     super(second, battleId);
/* 19 */     this._battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(this._battleId), new PBattlePlayEnd(this._battleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionBattleWaitCleanEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */