/*    */ package mzm.gsp.role.moneywatchdog;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.yuanbao.main.CurrencyType;
/*    */ import xbean.SingleMoneyDayData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GetGoldGainInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetGoldGainInfo(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     SingleMoneyDayData xSingleMoneyDayData = MoneyWatchDogManager.getLastXSingleMoneyDayData(this.roleId, CurrencyType.CURRENCY_GOLD.value);
/*    */     
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, getSingleMoneyGainInfo(xSingleMoneyDayData));
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   String getSingleMoneyGainInfo(SingleMoneyDayData xSingleMoneyDayData)
/*    */   {
/* 34 */     StringBuffer sb = new StringBuffer();
/*    */     
/* 36 */     sb.append("\r\n");
/* 37 */     sb.append("金币获取总量：");
/* 38 */     sb.append(xSingleMoneyDayData.getTotalvalue());
/*    */     
/* 40 */     sb.append("\r\n");
/* 41 */     sb.append("已触发预警：");
/* 42 */     sb.append(String.valueOf(xSingleMoneyDayData.getTouchedline()));
/*    */     
/* 44 */     sb.append("\r\n");
/* 45 */     sb.append("金币获取细节：");
/* 46 */     sb.append(xSingleMoneyDayData.getGaintype2value().toString());
/*    */     
/* 48 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\PGM_GetGoldGainInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */