/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     new PSynGangHelpInfo(((Long)this.arg).longValue()).execute();
/*    */     
/* 15 */     HanhunInfo xHunInfo = Role2huanhun.get((Long)this.arg);
/* 16 */     if (xHunInfo == null)
/*    */     {
/* 18 */       xHunInfo = HuanhunManager.createHunXTable(((Long)this.arg).longValue());
/*    */     }
/* 20 */     if (xHunInfo.getIteminfosnext().size() == 0)
/*    */     {
/* 22 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID))
/*    */       {
/* 24 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID);
/*    */       }
/* 26 */       return true;
/*    */     }
/* 28 */     if (!TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID))
/*    */     {
/* 30 */       HuanhunManager.sendNextNeedInfo(((Long)this.arg).longValue(), xHunInfo);
/*    */     }
/* 32 */     if (HuanhunManager.isAllBoxFull(xHunInfo))
/*    */     {
/* 34 */       HuanhunManager.setHunTaskFinish(((Long)this.arg).longValue());
/*    */     }
/*    */     
/* 37 */     new PSynHunInfo(((Long)this.arg).longValue(), false).execute();
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */