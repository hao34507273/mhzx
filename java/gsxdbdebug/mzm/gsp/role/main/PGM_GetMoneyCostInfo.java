/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.EachMoneyDayCostData;
/*    */ import xbean.MoneyCostDayData;
/*    */ 
/*    */ public class PGM_GetMoneyCostInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetMoneyCostInfo(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     StringBuffer sb = new StringBuffer();
/* 22 */     MoneyCostDayData xMoneyCostDayData = RoleModuleManager.getAndInitXMoneyCostDayData(this.roleId, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */     
/* 24 */     for (Map.Entry<Integer, EachMoneyDayCostData> entry : xMoneyCostDayData.getMoneyinfo().entrySet())
/*    */     {
/* 26 */       int currencyType = ((Integer)entry.getKey()).intValue();
/* 27 */       long totalValue = ((EachMoneyDayCostData)entry.getValue()).getTotalcost();
/*    */       
/* 29 */       sb.append("@").append(currencyType).append("=").append(totalValue);
/*    */     }
/* 31 */     String msg = sb.toString();
/* 32 */     if (msg.equalsIgnoreCase(""))
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, "今天没有消耗货币！");
/*    */     }
/*    */     else
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.roleId, msg);
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_GetMoneyCostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */