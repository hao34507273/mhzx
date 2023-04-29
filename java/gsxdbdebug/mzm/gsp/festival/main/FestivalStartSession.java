/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class FestivalStartSession extends Session
/*    */ {
/*    */   public FestivalStartSession(long interval, int index)
/*    */   {
/* 10 */     super(interval, index);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 15 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 19 */         FestivalManager.onFestivalIndexStart((int)FestivalStartSession.this.getOwerId());
/* 20 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\FestivalStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */