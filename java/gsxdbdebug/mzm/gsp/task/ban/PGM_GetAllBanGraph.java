/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetAllBanGraph extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetAllBanGraph(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("已被禁止任务图：%s", new Object[] { GraphBanManager.getBanGraphInfo() }));
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\PGM_GetAllBanGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */