/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import mzm.event.BasicEvent;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.role.event.MoneyChangeArg;
/*     */ import mzm.gsp.role.moneywatchdog.MoneyWatchDogManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import xbean.Properties;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoleOperMoney
/*     */ {
/*     */   private long roleId;
/*     */   private long changeValue;
/*     */   private TLogArg arg;
/*     */   private boolean withinMax;
/*     */   
/*     */   public RoleOperMoney(long roleId, long changeValue, TLogArg arg, boolean withinMax)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.changeValue = changeValue;
/*  30 */     this.arg = arg;
/*  31 */     this.withinMax = withinMax;
/*     */   }
/*     */   
/*     */   public RoleOperMoney(long roleId, long changeValue, TLogArg arg)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.changeValue = changeValue;
/*  38 */     this.arg = arg;
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  43 */     return this.roleId;
/*     */   }
/*     */   
/*     */   public ModMoneyResult addMoneyInAll()
/*     */   {
/*  48 */     if (this.changeValue < 0L)
/*     */     {
/*  50 */       return setMoneyModErrRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_SIGN);
/*     */     }
/*  52 */     if (this.changeValue == 0L)
/*     */     {
/*  54 */       return setMoneyModSucRes(0L);
/*     */     }
/*  56 */     long canGetMoneyMax = getRoleCanOwnMoneyMax();
/*  57 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/*  58 */     long oldValue = getRoleOwnMoney(xProperties);
/*  59 */     if ((this.changeValue >= Long.MAX_VALUE) || (this.changeValue > canGetMoneyMax))
/*     */     {
/*  61 */       return setMoneyModErrRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */     }
/*  63 */     if ((oldValue > 0L) && (Long.MAX_VALUE - oldValue < this.changeValue))
/*     */     {
/*  65 */       return setMoneyModErrRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */     }
/*     */     
/*  68 */     boolean canReachMax = oldValue + this.changeValue > canGetMoneyMax;
/*  69 */     if (this.withinMax)
/*     */     {
/*  71 */       if (canReachMax)
/*     */       {
/*  73 */         return setMoneyModErrRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  78 */       if (oldValue >= canGetMoneyMax)
/*     */       {
/*  80 */         RoleModuleManager.sendSCommonResultRes(this.roleId, reachMaxErrCode(), false);
/*  81 */         return setMoneyModSucRes(0L);
/*     */       }
/*  83 */       if (canReachMax)
/*     */       {
/*  85 */         this.changeValue = (canGetMoneyMax - oldValue);
/*     */       }
/*     */     }
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
/* 111 */     changeXMoney(xProperties, oldValue + this.changeValue, this.changeValue);
/* 112 */     MoneyWatchDogManager.addDayGainMoney(this.roleId, getCurrencyType().value, this.changeValue, this.arg);
/* 113 */     return setMoneyModSucRes(this.changeValue);
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
/*     */   public boolean cutMoney()
/*     */   {
/* 127 */     if (this.changeValue < 0L)
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     if (this.changeValue == 0L)
/*     */     {
/* 133 */       return true;
/*     */     }
/* 135 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 136 */     long remainMoney = getRoleOwnMoney(xProperties) - this.changeValue;
/* 137 */     if (remainMoney < 0L)
/*     */     {
/* 139 */       return false;
/*     */     }
/* 141 */     cutMoney(xProperties, remainMoney, this.changeValue);
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MoneyOperResult addMoneyByIDIP()
/*     */   {
/* 154 */     if (this.changeValue <= 0L)
/*     */     {
/* 156 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 158 */     long canGetMaxValue = getRoleCanOwnMoneyMax();
/* 159 */     if (this.changeValue > canGetMaxValue)
/*     */     {
/* 161 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 163 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 164 */     long oldValue = getRoleOwnMoney(xProperties);
/* 165 */     if (oldValue + this.changeValue > getRoleCanOwnMoneyMax())
/*     */     {
/* 167 */       return MoneyOperResult.MONEY_NUM_ADD_MAX;
/*     */     }
/*     */     
/* 170 */     changeXMoney(xProperties, oldValue + this.changeValue, this.changeValue);
/* 171 */     return MoneyOperResult.SUCCESS;
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
/*     */   public MoneyOperResult addMoneyByAqIDIP()
/*     */   {
/* 186 */     if (this.changeValue <= 0L)
/*     */     {
/* 188 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 190 */     long canGetMaxValue = getRoleCanOwnMoneyMax();
/* 191 */     if (this.changeValue > canGetMaxValue)
/*     */     {
/* 193 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 195 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 196 */     long oldValue = getRoleOwnMoney(xProperties);
/* 197 */     if (oldValue + this.changeValue > canGetMaxValue)
/*     */     {
/* 199 */       changeXMoney(xProperties, canGetMaxValue, canGetMaxValue - oldValue);
/* 200 */       return MoneyOperResult.MONEY_NUM_REACH_MAX_FOR_AQIDIP;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 210 */     changeXMoney(xProperties, oldValue + this.changeValue, this.changeValue);
/* 211 */     return MoneyOperResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void changeXMoney(Properties xProperties, long xValue, long changeValue)
/*     */   {
/* 218 */     long lastValue = setXMoneyValue(xProperties, xValue);
/*     */     
/* 220 */     RoleInterface.addCurrencyLog(this.roleId, getCurrencyType(), changeValue, lastValue, this.arg);
/*     */     
/* 222 */     triggerEvent(changeValue, lastValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MoneyOperResult cutMoneyByIDIP()
/*     */   {
/* 234 */     if (this.changeValue <= 0L)
/*     */     {
/* 236 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 238 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 239 */     long remainValue = getRoleOwnMoney(xProperties) - this.changeValue;
/* 240 */     if (remainValue < 0L)
/*     */     {
/* 242 */       if (!canCutToNegative())
/*     */       {
/* 244 */         return MoneyOperResult.MONEY_NUM_RM_NOT_ENOUGH;
/*     */       }
/*     */       
/*     */ 
/* 248 */       if (Math.abs(remainValue) >= getRoleCanOwnMoneyMax())
/*     */       {
/* 250 */         remainValue = -getRoleCanOwnMoneyMax();
/*     */       }
/*     */     }
/*     */     
/* 254 */     cutMoney(xProperties, remainValue, this.changeValue);
/* 255 */     return MoneyOperResult.SUCCESS;
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
/*     */   public MoneyOperResult cutMoneyByAqIDIP()
/*     */   {
/* 270 */     if (this.changeValue <= 0L)
/*     */     {
/* 272 */       return MoneyOperResult.MONEY_NUM_ERROR;
/*     */     }
/* 274 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 275 */     long beginValue = getRoleOwnMoney(xProperties);
/* 276 */     long remainValue = beginValue - this.changeValue;
/* 277 */     if (remainValue < 0L)
/*     */     {
/* 279 */       if (!canCutToNegative())
/*     */       {
/* 281 */         cutMoney(xProperties, 0L, beginValue);
/* 282 */         return MoneyOperResult.MONEY_NUM_CLEAR_FOR_AQIDIP;
/*     */       }
/*     */       
/*     */ 
/* 286 */       if (Math.abs(remainValue) >= getRoleCanOwnMoneyMax())
/*     */       {
/* 288 */         remainValue = -getRoleCanOwnMoneyMax();
/*     */       }
/*     */     }
/*     */     
/* 292 */     cutMoney(xProperties, remainValue, this.changeValue);
/* 293 */     return MoneyOperResult.SUCCESS;
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
/*     */   private void cutMoney(Properties xProperties, long xValue, long cutValue)
/*     */   {
/* 309 */     changeXMoney(xProperties, xValue, -cutValue);
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
/*     */   private ModMoneyResult setMoneyModSucRes(long addValue)
/*     */   {
/* 323 */     ModMoneyResult result = new ModMoneyResult();
/* 324 */     result.setbSucceed(true);
/* 325 */     result.setModValue(addValue);
/* 326 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ModMoneyResult setMoneyModErrRes(ModMoneyResult.ErrorResult res)
/*     */   {
/* 338 */     ModMoneyResult result = new ModMoneyResult();
/* 339 */     result.setbSucceed(false);
/* 340 */     result.setRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/* 341 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canCutToNegative()
/*     */   {
/* 351 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract long getRoleOwnMoney(Properties paramProperties);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract long getRoleCanOwnMoneyMax();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract int reachMaxErrCode();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract long setXMoneyValue(Properties paramProperties, long paramLong);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void triggerEvent(long realChangeValue, long lastValue)
/*     */   {
/* 394 */     BasicEvent<MoneyChangeArg> e = getEvent();
/* 395 */     if (e == null)
/*     */     {
/* 397 */       return;
/*     */     }
/* 399 */     TriggerEventsManger.getInstance().triggerEvent(e, getMoneyChangeArg(realChangeValue, lastValue));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract BasicEvent<MoneyChangeArg> getEvent();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   MoneyChangeArg getMoneyChangeArg(long realChangeValue, long lastValue)
/*     */   {
/* 418 */     return new MoneyChangeArg(getRoleId(), lastValue - realChangeValue, lastValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCurrencyTypeValue()
/*     */   {
/* 428 */     return getCurrencyType().value;
/*     */   }
/*     */   
/*     */   public abstract CurrencyType getCurrencyType();
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOperMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */