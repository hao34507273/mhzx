/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.pk.event.MoralValueChangeArg;
/*    */ import mzm.gsp.pk.event.MoralValueChangedProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ public class POnMoralValueChanged
/*    */   extends MoralValueChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     int wantedMoralValue = SPKConsts.getInstance().WANTED_MORAL_VALUE;
/* 16 */     if ((((MoralValueChangeArg)this.arg).oldValue > wantedMoralValue) && (((MoralValueChangeArg)this.arg).newValue <= wantedMoralValue))
/*    */     {
/*    */ 
/* 19 */       String userId = RoleInterface.getUserId(((MoralValueChangeArg)this.arg).roleId);
/* 20 */       if (userId == null)
/* 21 */         return false;
/* 22 */       if (TaskInterface.closeActivityGraphWithoutEvent(((MoralValueChangeArg)this.arg).roleId, SPKConsts.getInstance().MORAL_TASK_GRAPH_ID))
/* 23 */         PKLogManager.info(String.format("POnMoralValueChanged.processImp()@cancel moral value task|roleid=%d", new Object[] { Long.valueOf(((MoralValueChangeArg)this.arg).roleId) }));
/* 24 */       return true;
/*    */     }
/*    */     
/* 27 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\POnMoralValueChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */