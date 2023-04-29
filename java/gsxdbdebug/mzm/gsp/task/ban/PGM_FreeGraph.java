/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_FreeGraph extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int banType;
/*    */   
/*    */   public PGM_FreeGraph(long roleId, int graphId, int banType)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.graphId = graphId;
/* 16 */     this.banType = banType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     BanTaskRes res = GraphBanManager.freeGraph(this.graphId, this.banType);
/* 23 */     if (res.isSuc())
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.roleId, "操作成功");
/* 26 */       return true;
/*    */     }
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("操作失败！|reason=%s", new Object[] { Integer.valueOf(res.getReasonValue()) }));
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\PGM_FreeGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */