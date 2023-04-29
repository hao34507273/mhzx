/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_JoinCorps extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long corpsId;
/*    */   
/*    */   public PGM_JoinCorps(long roleId, long corpsId)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.corpsId = corpsId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     PJoinCorps res = CorpsInterface.joinCorpsByIdip(this.roleId, this.corpsId);
/* 21 */     if (res.isJoinSuc())
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "加入成功！");
/* 24 */       return true;
/*    */     }
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("加入失败！res=%s", new Object[] { res.getErrReason() }));
/* 27 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_JoinCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */