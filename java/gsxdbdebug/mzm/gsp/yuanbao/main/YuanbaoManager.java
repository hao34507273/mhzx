/*    */ package mzm.gsp.yuanbao.main;
/*    */ 
/*    */ import mzm.gsp.util.confbean.MoneyExchangeCfgConsts;
/*    */ 
/*    */ public class YuanbaoManager
/*    */ {
/*    */   static void checkYuanBaoExchangeRate()
/*    */   {
/*  9 */     if (MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_GOLD_NUM * MoneyExchangeCfgConsts.getInstance().GOLD_TO_SILVER_NUM != MoneyExchangeCfgConsts.getInstance().YUANBAO_TO_SILVER_NUM)
/*    */     {
/* 11 */       throw new RuntimeException("元宝、金币、银两兑换不一致");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\YuanbaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */