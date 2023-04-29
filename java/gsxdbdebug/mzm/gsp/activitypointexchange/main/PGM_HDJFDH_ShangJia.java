/*    */ package mzm.gsp.activitypointexchange.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_HDJFDH_ShangJia extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int mallId;
/*    */   final int goodsId;
/*    */   
/*    */   public PGM_HDJFDH_ShangJia(long gmRoleId, int activityId, int mallId, int goodsId)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.mallId = mallId;
/* 18 */     this.goodsId = goodsId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     boolean ret = ActivityPointExchangeInterface.shangJia(this.activityId, this.mallId, this.goodsId);
/* 25 */     if (!ret)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 28 */       return false;
/*    */     }
/* 30 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "商品上架成功");
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\PGM_HDJFDH_ShangJia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */