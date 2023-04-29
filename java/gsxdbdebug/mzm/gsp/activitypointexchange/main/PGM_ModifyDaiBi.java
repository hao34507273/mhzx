/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.STokenType;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_ModifyDaiBi extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int tokenType;
/*    */   final int count;
/*    */   
/*    */   public PGM_ModifyDaiBi(long targetRoleId, long gmRoleId, int tokenType, int count)
/*    */   {
/* 20 */     this.targetRoleId = targetRoleId;
/* 21 */     this.gmRoleId = gmRoleId;
/* 22 */     this.tokenType = tokenType;
/* 23 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.count == 0)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改数量为0");
/* 32 */       return false;
/*    */     }
/* 34 */     STokenType tokenType = STokenType.get(this.tokenType);
/* 35 */     if (tokenType == null)
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "积分类型错误");
/* 38 */       return false;
/*    */     }
/*    */     JifenOperateResult jifenOperateResult;
/*    */     JifenOperateResult jifenOperateResult;
/* 42 */     if (this.count > 0)
/*    */     {
/* 44 */       jifenOperateResult = MallInterface.addJifen(this.targetRoleId, this.count, this.tokenType, true, new TLogArg(LogReason.GM_ADD));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 49 */       jifenOperateResult = MallInterface.cutJifen(this.targetRoleId, Math.abs(this.count), this.tokenType, new TLogArg(LogReason.GM_REM));
/*    */     }
/*    */     
/*    */ 
/* 53 */     if (jifenOperateResult.typeInvalid())
/*    */     {
/* 55 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "积分类型错误");
/* 56 */       return false;
/*    */     }
/* 58 */     if (!jifenOperateResult.isSuccess())
/*    */     {
/* 60 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 61 */       return false;
/*    */     }
/* 63 */     long currentJiFen = MallInterface.getJifen(this.targetRoleId, this.tokenType);
/*    */     
/* 65 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%s 修改成功，数量为：%d", new Object[] { tokenType.name, Long.valueOf(currentJiFen) }));
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PGM_ModifyDaiBi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */