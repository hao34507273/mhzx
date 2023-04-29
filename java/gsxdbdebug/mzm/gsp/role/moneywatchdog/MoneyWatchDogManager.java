/*     */ package mzm.gsp.role.moneywatchdog;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.resourcecheck.confbean.SGoldExpectePerDayCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.MoneyDayData;
/*     */ import xbean.Pod;
/*     */ import xbean.SingleMoneyDayData;
/*     */ import xtable.Role2daymoneyinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MoneyWatchDogManager
/*     */ {
/*     */   public static void addDayGainMoney(long roleId, int currencyType, long addValue, TLogArg arg)
/*     */   {
/*  28 */     MoneyDayGain moneyDayGain = getMoneyDayGain(roleId, currencyType, addValue, arg);
/*  29 */     if (moneyDayGain == null)
/*     */     {
/*  31 */       return;
/*     */     }
/*  33 */     if (!moneyDayGain.isWatchDogWorking())
/*     */     {
/*  35 */       return;
/*     */     }
/*  37 */     moneyDayGain.addDayMoneyGainValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerLogreason()
/*     */   {
/*  46 */     MoneyLogreasonManager.getInstance().registerLogReason2DBType(LogReason.YUANBAO_BUY.value, 2, 0);
/*     */     
/*     */ 
/*  49 */     MoneyLogreasonManager.getInstance().registerLogReason2DBType(LogReason.MARKET_SELL.value, -1, 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static MoneyDayData getLastXMoneyDayData(long roleId)
/*     */   {
/*  64 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  65 */     MoneyDayData xMoneyDayData = Role2daymoneyinfo.get(Long.valueOf(roleId));
/*  66 */     if (xMoneyDayData == null)
/*     */     {
/*  68 */       xMoneyDayData = Pod.newMoneyDayData();
/*  69 */       xMoneyDayData.setStarttime(curTime);
/*  70 */       Role2daymoneyinfo.insert(Long.valueOf(roleId), xMoneyDayData);
/*     */     }
/*  72 */     if (DateTimeUtils.needDailyReset(xMoneyDayData.getStarttime(), curTime, 0))
/*     */     {
/*  74 */       xMoneyDayData.setStarttime(curTime);
/*  75 */       xMoneyDayData.getMoneyinfo().clear();
/*     */     }
/*  77 */     return xMoneyDayData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SingleMoneyDayData getLastXSingleMoneyDayData(long roleId, int currencyType)
/*     */   {
/*  93 */     MoneyDayData xMoneyDayData = getLastXMoneyDayData(roleId);
/*  94 */     SingleMoneyDayData xSingleMoneyDayData = (SingleMoneyDayData)xMoneyDayData.getMoneyinfo().get(Integer.valueOf(currencyType));
/*  95 */     if (xSingleMoneyDayData == null)
/*     */     {
/*  97 */       xSingleMoneyDayData = Pod.newSingleMoneyDayData();
/*  98 */       xMoneyDayData.getMoneyinfo().put(Integer.valueOf(currencyType), xSingleMoneyDayData);
/*     */     }
/* 100 */     return xSingleMoneyDayData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static MoneyDayGain getMoneyDayGain(long roleId, int currencyType, long addValue, TLogArg arg)
/*     */   {
/* 114 */     switch (currencyType)
/*     */     {
/*     */     case 2: 
/* 117 */       return new GoldDayGain(roleId, currencyType, addValue, arg);
/*     */     }
/* 119 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCanGainGoldMax(int level)
/*     */   {
/* 134 */     SGoldExpectePerDayCfg cfg = SGoldExpectePerDayCfg.get(level);
/* 135 */     if (cfg == null)
/*     */     {
/* 137 */       return -1;
/*     */     }
/* 139 */     return cfg.gainMax;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\MoneyWatchDogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */