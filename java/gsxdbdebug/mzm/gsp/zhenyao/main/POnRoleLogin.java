/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!ZhenyaoManager.isZhenyaoSwitchOpenForRole(((Long)this.arg).longValue(), false))
/*    */     {
/* 13 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID))
/*    */       {
/* 15 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/*    */       }
/* 17 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), ZhenYaoActivityCfgConsts.getInstance().GUIDE_GRAPH_ID))
/*    */       {
/* 19 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), ZhenYaoActivityCfgConsts.getInstance().GUIDE_GRAPH_ID);
/*    */       }
/* 21 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 26 */     xbean.ZhenyaoCount xCount = xtable.Role2zhenyaocount.get((Long)this.arg);
/* 27 */     if (xCount != null)
/*    */     {
/* 29 */       ZhenyaoManager.synXYaoData2Client(((Long)this.arg).longValue(), xCount);
/*    */     }
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */