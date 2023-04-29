/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.STokenType;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetDaiBi extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int tokenType;
/*    */   
/*    */   public PGM_GetDaiBi(long targetRoleId, long gmRoleId, int tokenType)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.tokenType = tokenType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     STokenType tokenType = STokenType.get(this.tokenType);
/* 25 */     if (tokenType == null)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "积分类型错误");
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     long count = MallInterface.getJifen(this.targetRoleId, this.tokenType);
/* 32 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%s 数量是：%d", new Object[] { tokenType.name, Long.valueOf(count) }));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PGM_GetDaiBi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */