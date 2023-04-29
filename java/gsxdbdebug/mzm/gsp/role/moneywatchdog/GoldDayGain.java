/*    */ package mzm.gsp.role.moneywatchdog;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.SingleMoneyDayData;
/*    */ 
/*    */ class GoldDayGain extends MoneyDayGain
/*    */ {
/*    */   public GoldDayGain(long roleId, int currencyType, long addValue, TLogArg arg)
/*    */   {
/* 13 */     super(roleId, currencyType, addValue, arg);
/*    */   }
/*    */   
/*    */ 
/*    */   boolean touchLine(SingleMoneyDayData xSingleMoneyDayData)
/*    */   {
/* 19 */     if (xSingleMoneyDayData.getTouchedline())
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     if (getCompareValue(xSingleMoneyDayData) <= MoneyWatchDogManager.getCanGainGoldMax(RoleInterface.getLevel(getRoleId())))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     xSingleMoneyDayData.setTouchedline(true);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   private long getCompareValue(SingleMoneyDayData xSingleMoneyDayData)
/*    */   {
/* 33 */     long totalValue = xSingleMoneyDayData.getTotalvalue();
/* 34 */     Long tradeSoldGain = (Long)xSingleMoneyDayData.getGaintype2value().get(Integer.valueOf(1));
/* 35 */     if (tradeSoldGain == null)
/*    */     {
/* 37 */       tradeSoldGain = new Long(0L);
/*    */     }
/* 39 */     Long yuanbaoBuy = (Long)xSingleMoneyDayData.getGaintype2value().get(Integer.valueOf(0));
/* 40 */     if (yuanbaoBuy == null)
/*    */     {
/* 42 */       yuanbaoBuy = new Long(0L);
/*    */     }
/* 44 */     return totalValue - yuanbaoBuy.longValue() - tradeSoldGain.longValue();
/*    */   }
/*    */   
/*    */ 
/*    */   boolean isWatchDogWorking()
/*    */   {
/* 50 */     if (!OpenInterface.getOpenStatus(208)) {
/* 51 */       return false;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\GoldDayGain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */