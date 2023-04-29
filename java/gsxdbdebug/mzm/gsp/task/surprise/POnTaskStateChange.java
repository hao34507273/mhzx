/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.SActiveSurpriseGraphNotice;
/*    */ import mzm.gsp.task.SSurpriseGraphFinishNotice;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChange
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!SurpriseTaskManager.isSurpriseGraph(((TaskEventArg)this.arg).graphId))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     if (((TaskEventArg)this.arg).taskState == 2)
/*    */     {
/*    */ 
/* 27 */       if (((TaskEventArg)this.arg).taskNo == 1)
/*    */       {
/* 29 */         OnlineManager.getInstance().send(((TaskEventArg)this.arg).roleId, new SActiveSurpriseGraphNotice(((TaskEventArg)this.arg).graphId));
/*    */       }
/* 31 */       return true;
/*    */     }
/* 33 */     if (!((TaskEventArg)this.arg).isAllHandUped())
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 44 */     OnlineManager.getInstance().send(((TaskEventArg)this.arg).roleId, new SSurpriseGraphFinishNotice(((TaskEventArg)this.arg).graphId));
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */