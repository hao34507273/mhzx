/*     */ package mzm.gsp.role.moneywatchdog;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.role.event.MoneyGainTouchLine;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.SingleMoneyDayData;
/*     */ 
/*     */ abstract class MoneyDayGain
/*     */ {
/*     */   private final long roleId;
/*     */   private final int currencyType;
/*     */   private final long addValue;
/*     */   private final TLogArg arg;
/*     */   
/*     */   public MoneyDayGain(long roleId, int currencyType, long addValue, TLogArg arg)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.currencyType = currencyType;
/*  23 */     this.addValue = addValue;
/*  24 */     this.arg = arg;
/*     */   }
/*     */   
/*     */ 
/*     */   void addDayMoneyGainValue()
/*     */   {
/*  30 */     SingleMoneyDayData xSingleMoneyDayData = MoneyWatchDogManager.getLastXSingleMoneyDayData(this.roleId, this.currencyType);
/*     */     
/*  32 */     long orgTotalValue = xSingleMoneyDayData.getTotalvalue();
/*  33 */     xSingleMoneyDayData.setTotalvalue(orgTotalValue + getAddValue());
/*     */     
/*  35 */     addSubTypeValue(xSingleMoneyDayData);
/*     */     
/*  37 */     checkTouchLine(xSingleMoneyDayData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkTouchLine(SingleMoneyDayData xSingleMoneyDayData)
/*     */   {
/*  47 */     if (!touchLine(xSingleMoneyDayData))
/*     */     {
/*  49 */       return;
/*     */     }
/*  51 */     Role role = mzm.gsp.role.main.RoleInterface.getRole(this.roleId, false);
/*  52 */     MoneyGainTouchLineArg arg = new MoneyGainTouchLineArg(this.roleId, role.getOccupationId(), role.getLevel(), this.currencyType, xSingleMoneyDayData.getTotalvalue(), null);
/*     */     
/*  54 */     TriggerEventsManger.getInstance().triggerEvent(new MoneyGainTouchLine(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract boolean touchLine(SingleMoneyDayData paramSingleMoneyDayData);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract boolean isWatchDogWorking();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addSubTypeValue(SingleMoneyDayData xSingleMoneyDayData)
/*     */   {
/*  79 */     int dbType = MoneyLogreasonManager.getInstance().getDBType(getLogreason());
/*  80 */     if (dbType < 0)
/*     */     {
/*  82 */       return;
/*     */     }
/*  84 */     Map<Integer, Long> xSubMoneyData = xSingleMoneyDayData.getGaintype2value();
/*  85 */     Long orgValue = (Long)xSubMoneyData.get(Integer.valueOf(dbType));
/*  86 */     if (orgValue == null)
/*     */     {
/*  88 */       orgValue = new Long(0L);
/*     */     }
/*  90 */     xSubMoneyData.put(Integer.valueOf(dbType), Long.valueOf(orgValue.longValue() + this.addValue));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Pair<Integer, Integer> getLogreason()
/*     */   {
/* 100 */     Pair<Integer, Integer> reasons = new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
/* 101 */     if (this.arg == null)
/*     */     {
/* 103 */       return reasons;
/*     */     }
/* 105 */     reasons.first = new Integer(this.arg.getLogReason().value);
/* 106 */     reasons.second = new Integer(this.arg.subReason);
/* 107 */     return reasons;
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/* 112 */     return this.roleId;
/*     */   }
/*     */   
/*     */   int getCurrencyType()
/*     */   {
/* 117 */     return this.currencyType;
/*     */   }
/*     */   
/*     */   long getAddValue()
/*     */   {
/* 122 */     return this.addValue;
/*     */   }
/*     */   
/*     */   TLogArg getArg()
/*     */   {
/* 127 */     return this.arg;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\MoneyDayGain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */