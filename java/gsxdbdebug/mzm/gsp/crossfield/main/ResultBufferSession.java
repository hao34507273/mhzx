/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role_single_cross_field_results;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResultBufferSession
/*    */   extends Session
/*    */ {
/*    */   public ResultBufferSession(long interval, long roleId)
/*    */   {
/* 15 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 27 */         Role_single_cross_field_results.remove(Long.valueOf(ResultBufferSession.this.getOwerId()));
/* 28 */         return true;
/*    */       }
/*    */     };
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\ResultBufferSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */