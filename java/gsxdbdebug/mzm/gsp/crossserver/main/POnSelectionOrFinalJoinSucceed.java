/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalJoinSucceedArg;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalJoinSucceedProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSelectionOrFinalJoinSucceed
/*    */   extends SelectionOrFinalJoinSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     StringBuilder sb = new StringBuilder();
/* 17 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(((SelectionOrFinalJoinSucceedArg)this.arg).getContextid());
/* 18 */     if (context != null)
/*    */     {
/* 20 */       context.startTimeoutWatchDog();
/*    */       
/* 22 */       CrossServerManager.confirmJoinSelectionFinalMatch(context);
/*    */       
/* 24 */       sb.append("[crossserver_selectionfinal]POnSelectionOrFinalJoinSucceed.processImp@selection final join succeed");
/* 25 */       sb.append("|context_id=").append(((SelectionOrFinalJoinSucceedArg)this.arg).getContextid());
/* 26 */       sb.append("|leader_role_id=").append(((SelectionOrFinalJoinSucceedArg)this.arg).getLeaderid());
/* 27 */       sb.append("|corps_info=").append(((SelectionOrFinalJoinSucceedArg)this.arg).getOwnCrossBattleTeamInfo().toString());
/*    */       
/* 29 */       GameServer.logger().error(sb.toString());
/*    */     }
/*    */     else
/*    */     {
/* 33 */       sb.append("[crossserver_selectionfinal]POnSelectionOrFinalJoinSucceed.processImp@selection final match context not found");
/* 34 */       sb.append("|context_id=").append(((SelectionOrFinalJoinSucceedArg)this.arg).getContextid());
/* 35 */       sb.append("|leader_role_id=").append(((SelectionOrFinalJoinSucceedArg)this.arg).getLeaderid());
/* 36 */       sb.append("|corps_info=%d").append(((SelectionOrFinalJoinSucceedArg)this.arg).getOwnCrossBattleTeamInfo().toString());
/*    */       
/* 38 */       GameServer.logger().error(sb.toString());
/*    */     }
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnSelectionOrFinalJoinSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */