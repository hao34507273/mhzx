/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.BattleTaskOneByOne;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefreshBuffSession
/*    */   extends Session
/*    */ {
/*    */   public RefreshBuffSession(long interval, long battleid)
/*    */   {
/* 16 */     super(interval, battleid);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(getOwerId()), new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 27 */         BuffManager.refreshBuff(RefreshBuffSession.this.getOwerId(), false);
/* 28 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\RefreshBuffSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */