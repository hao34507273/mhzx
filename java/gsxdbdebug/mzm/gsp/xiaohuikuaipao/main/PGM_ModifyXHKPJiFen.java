/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_ModifyXHKPJiFen
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int pointCount;
/*    */   
/*    */   public PGM_ModifyXHKPJiFen(long targetRoleId, long gmRoleId, int pointCount)
/*    */   {
/* 19 */     this.targetRoleId = targetRoleId;
/* 20 */     this.gmRoleId = gmRoleId;
/* 21 */     this.pointCount = pointCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (this.pointCount == 0)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "积分值为0");
/* 30 */       return false;
/*    */     }
/*    */     JifenOperateResult jifenOperateResult;
/*    */     JifenOperateResult jifenOperateResult;
/* 34 */     if (this.pointCount > 0)
/*    */     {
/* 36 */       jifenOperateResult = MallInterface.addJifen(this.targetRoleId, this.pointCount, 8, false, new TLogArg(LogReason.GM_ADD));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 41 */       jifenOperateResult = MallInterface.cutJifen(this.targetRoleId, Math.abs(this.pointCount), 8, new TLogArg(LogReason.GM_ADD));
/*    */     }
/*    */     
/*    */ 
/* 45 */     if (jifenOperateResult.isSuccess())
/*    */     {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改小灰快跑积分成功");
/*    */     }
/*    */     else
/*    */     {
/* 51 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改小灰快跑积分失败");
/*    */     }
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PGM_ModifyXHKPJiFen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */