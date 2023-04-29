/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 14 */     if ((((OpenChangeComplexArg)this.arg).getType() == 578) && (!((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 16 */       BallBattleActivityManager.addTask(new LogicRunnable()
/*    */       {
/*    */ 
/*    */         public void process()
/*    */           throws Exception
/*    */         {}
/*    */ 
/*    */ 
/* 24 */       });
/* 25 */       BallBattleGameInstance.forceStopAllGameInstances();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */