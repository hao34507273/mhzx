/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class BaotuSwitchClosedPro
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public BaotuSwitchClosedPro(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     boolean ret = false;
/* 24 */     if (TaskInterface.isHaveGraphId(this.roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID))
/*    */     {
/* 26 */       ret = true;
/* 27 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID);
/*    */     }
/* 29 */     if (TaskInterface.isHaveGraphId(this.roleId, BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID))
/*    */     {
/* 31 */       ret = true;
/* 32 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleId, BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID);
/*    */     }
/* 34 */     if (ret)
/*    */     {
/* 36 */       OpenInterface.sendCloseProtocol(this.roleId, 2, null);
/*    */     }
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaotuSwitchClosedPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */