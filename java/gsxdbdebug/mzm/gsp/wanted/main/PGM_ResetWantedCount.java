/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WantedInfo;
/*    */ import xtable.Role2wantedinfo;
/*    */ 
/*    */ public class PGM_ResetWantedCount extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_ResetWantedCount(long targetRoleId, long gmRoleId)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     WantedInfo xWantedInfo = Role2wantedinfo.get(Long.valueOf(this.targetRoleId));
/* 25 */     if (xWantedInfo == null)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "对应角色没有被通缉");
/* 28 */       return false;
/*    */     }
/* 30 */     xWantedInfo.getRoleid2count().clear();
/* 31 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "通缉次数重置成功");
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PGM_ResetWantedCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */