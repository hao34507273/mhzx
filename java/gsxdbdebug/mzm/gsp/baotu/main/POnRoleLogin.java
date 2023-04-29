/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (!BaotuManager.isBaotuSwitchOpenForRole(((Long)this.arg).longValue(), false))
/*    */     {
/*    */ 
/* 15 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), BaoTuActivityCfgConsts.getInstance().GRAPH_ID))
/*    */       {
/* 17 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), BaoTuActivityCfgConsts.getInstance().GRAPH_ID);
/*    */       }
/* 19 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID))
/*    */       {
/* 21 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID);
/*    */       }
/* 23 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */