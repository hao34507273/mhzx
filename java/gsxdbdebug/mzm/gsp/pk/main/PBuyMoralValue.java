/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SBuyMoralValueFail;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import mzm.gsp.util.confbean.MoralValuePriceCfg;
/*     */ import xbean.RolePKInformation;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PBuyMoralValue
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int quantity;
/*     */   private final int currentMoneyNum;
/*     */   
/*     */   public PBuyMoralValue(long roleId, int quantity, long moneyNum)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.quantity = quantity;
/*  35 */     this.currentMoneyNum = ((int)moneyNum);
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     if (PKManager.isNotEnable()) {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1626, true))
/*     */     {
/*  46 */       PKLogManager.error(String.format("PBuyMoralValue.processImp()@status conflict|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     String userId = RoleInterface.getUserId(this.roleId);
/*  52 */     if (userId == null)
/*  53 */       return false;
/*  54 */     Lockeys.lock(User.getTable(), Collections.singleton(userId));
/*     */     
/*     */ 
/*  57 */     TLogArg tLogArg = new TLogArg(LogReason.BUY_MORAL_VALUE);
/*  58 */     JifenOperateResult result = MallInterface.addJifen(this.roleId, this.quantity, 7, true, tLogArg);
/*  59 */     int changeNum = (int)result.getChangenum();
/*  60 */     if (result.getChangenum() == 0L)
/*     */     {
/*  62 */       notifyFail(1);
/*  63 */       PKLogManager.error(String.format("PBuyMoralValue.processImp()@moral value already full|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     RolePKInformation xRolePKInformation = PKManager.getOrCreateRolePKInformation(this.roleId);
/*  69 */     int oldBoughtNum = xRolePKInformation.getBought_moral_value();
/*  70 */     int newBoughtNum = oldBoughtNum + changeNum;
/*  71 */     int requiredMoney = 0;
/*  72 */     int i = oldBoughtNum;
/*  73 */     for (MoralValuePriceCfg priceCfg : MoralValuePriceCfg.getAll().values())
/*     */     {
/*  75 */       if (newBoughtNum <= priceCfg.threshold)
/*     */       {
/*  77 */         requiredMoney += priceCfg.yuanbao * (newBoughtNum - i);
/*  78 */         break;
/*     */       }
/*  80 */       if (i < priceCfg.threshold)
/*     */       {
/*  82 */         requiredMoney += priceCfg.yuanbao * (priceCfg.threshold - i);
/*  83 */         i = priceCfg.threshold;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  88 */     Pair<Boolean, Boolean> chargeResult = PKManager.chargeMoney(this.roleId, SPKConsts.getInstance().MORAL_VALUE_MONEY_TYPE, this.currentMoneyNum, requiredMoney, CostType.COST_BIND_FIRST_BUY_MORAL_VALUE, tLogArg);
/*     */     
/*     */ 
/*  91 */     if (!((Boolean)chargeResult.first).booleanValue())
/*     */     {
/*  93 */       notifyFail(3);
/*  94 */       PKLogManager.info(String.format("PBuyMoralValue.processImp()@money not matched|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  95 */       return false;
/*     */     }
/*  97 */     if (!((Boolean)chargeResult.second).booleanValue())
/*     */     {
/*  99 */       notifyFail(2);
/* 100 */       PKLogManager.info(String.format("PBuyMoralValue.processImp()@insufficient money|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     xRolePKInformation.setBought_moral_value(newBoughtNum);
/* 106 */     int moralValue = (int)MallInterface.getJifen(this.roleId, 7);
/* 107 */     PKManager.triggerMoralValueChangeEvent(this.roleId, moralValue - changeNum, moralValue);
/* 108 */     PKLogManager.info(String.format("PBuyMoralValue.processImp()@done|roleid=%d|moral_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(moralValue) }));
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 114 */     SBuyMoralValueFail sBuyMoralValueFail = new SBuyMoralValueFail();
/* 115 */     sBuyMoralValueFail.retcode = retcode;
/* 116 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sBuyMoralValueFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PBuyMoralValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */