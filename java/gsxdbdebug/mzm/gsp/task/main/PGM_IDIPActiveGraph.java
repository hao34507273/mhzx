/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_IDIPActiveGraph extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final int graphId;
/*    */   
/*    */   public PGM_IDIPActiveGraph(long gmRoleId, long targetRoleId, int graphId)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     IDIP_ActivieGraphRes res = TaskInterface.idipActiveGraph(this.targetRoleId, this.graphId);
/* 23 */     if (res.isActiveSuc())
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("激活成功，tip=%s", new Object[] { res.getTipStr() }));
/* 26 */       return true;
/*    */     }
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("激活失败，reason=%s|tip=%s", new Object[] { res.getReason(), res.getTipStr() }));
/*    */     
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_IDIPActiveGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */