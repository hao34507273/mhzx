/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.CorpsMember;
/*    */ 
/*    */ public class PGM_ClearHistory extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearHistory(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     CorpsMember xCorpsLeader = xtable.Role2corps.select(Long.valueOf(this.roleId));
/* 19 */     if (xCorpsLeader == null)
/*    */     {
/* 21 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队，不能清除战队历史~");
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(xCorpsLeader.getCorpsid()));
/* 26 */     if (xCorps == null)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队，不能清除战队历史~");
/* 29 */       return false;
/*    */     }
/* 31 */     xCorps.getHistorylist().clear();
/* 32 */     GmManager.getInstance().sendResultToGM(this.roleId, "添加成功~");
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_ClearHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */