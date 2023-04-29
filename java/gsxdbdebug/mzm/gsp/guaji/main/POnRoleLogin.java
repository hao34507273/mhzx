/*     */ package mzm.gsp.guaji.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.guaji.SSyncDoublePoint;
/*     */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*     */ import mzm.gsp.item.confbean.SDoublePointItem;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DoublePoint;
/*     */ import xbean.DoubleTime;
/*     */ import xtable.Role2doublepoint;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     DoubleTime doubleTime = xtable.Doubletime.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*     */     
/*  24 */     long roleId = ((Long)this.arg).longValue();
/*  25 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.RE_OFFER_DOUBLE_POINT);
/*  26 */     DoublePoint doublePoint = Role2doublepoint.get(Long.valueOf(roleId));
/*  27 */     if (doublePoint == null)
/*     */     {
/*  29 */       doublePoint = xbean.Pod.newDoublePoint();
/*  30 */       doublePoint.setFrozenpoolpointnum(0);
/*  31 */       doublePoint.setGettingpoolpointnum(DoublePointOfferCfgConsts.getInstance().OFFER_NUM);
/*  32 */       doublePoint.setOffertimestamp(doubleTime.getPointoffertime());
/*  33 */       doublePoint.setResetitemusetimestamp(doubleTime.getItemcountcleartime());
/*     */       
/*  35 */       Role2doublepoint.add(Long.valueOf(roleId), doublePoint);
/*  36 */       GuajiManager.tlogDoublepoint(roleId, doublePoint.getFrozenpoolpointnum(), doublePoint.getGettingpoolpointnum(), 0, 0, doublePoint.getFrozenpoolpointnum(), doublePoint.getGettingpoolpointnum(), logArg);
/*     */       
/*  38 */       CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, doublePoint.getGettingpoolpointnum(), doublePoint.getGettingpoolpointnum(), logArg);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  44 */       if (doublePoint.getOffertimestamp() < doubleTime.getPointoffertime())
/*     */       {
/*     */ 
/*  47 */         int gettingPoolPointNum = doublePoint.getGettingpoolpointnum();
/*  48 */         long lastRoleOfferTime = doublePoint.getOffertimestamp();
/*  49 */         long observerOfferTime = doubleTime.getPointoffertime();
/*     */         
/*     */ 
/*  52 */         int newGettingPoolPointNum = compensateDoublePoint(gettingPoolPointNum, lastRoleOfferTime, observerOfferTime);
/*     */         
/*     */ 
/*  55 */         doublePoint.setGettingpoolpointnum(newGettingPoolPointNum);
/*  56 */         doublePoint.setOffertimestamp(doubleTime.getPointoffertime());
/*     */         
/*  58 */         GuajiManager.tlogDoublepoint(roleId, doublePoint.getFrozenpoolpointnum(), doublePoint.getGettingpoolpointnum(), doublePoint.getFrozenpoolpointnum(), gettingPoolPointNum, 0, newGettingPoolPointNum - gettingPoolPointNum, logArg);
/*     */         
/*     */ 
/*     */ 
/*  62 */         CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, doublePoint.getGettingpoolpointnum() - gettingPoolPointNum, doublePoint.getGettingpoolpointnum(), logArg);
/*     */         
/*     */ 
/*     */ 
/*  66 */         String logstr = String.format("[guaji]POnRoleLogin.processImp@get double point success|roleid=%d|newGettingPoolPointNum=%d|oldgettingpoint=%d|timestamp=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(newGettingPoolPointNum), Integer.valueOf(gettingPoolPointNum), Long.valueOf(doublePoint.getOffertimestamp()) });
/*     */         
/*     */ 
/*     */ 
/*  70 */         GuajiManager.logger.info(logstr);
/*     */       }
/*     */       
/*     */ 
/*  74 */       if (doublePoint.getResetitemusetimestamp() < doubleTime.getItemcountcleartime())
/*     */       {
/*  76 */         int oldusecount = doublePoint.getItemusecount();
/*  77 */         doublePoint.setItemusecount(0);
/*  78 */         doublePoint.setResetitemusetimestamp(doubleTime.getItemcountcleartime());
/*     */         
/*  80 */         String logstr = String.format("[guaji]POnRoleLogin.processImp@clear double item use count success|roleid=%d|oldusecount=%d|newusecount=%d|timestamp=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldusecount), Integer.valueOf(doublePoint.getItemusecount()), Long.valueOf(doublePoint.getResetitemusetimestamp()) });
/*     */         
/*     */ 
/*  83 */         GuajiManager.logger.info(logstr);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  88 */     initDoublePointSwitch(roleId, doublePoint);
/*     */     
/*  90 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/*  91 */     GuajiManager.fillDoublePointInfo(sSyncDoublePoint, doublePoint);
/*  92 */     OnlineManager.getInstance().send(roleId, sSyncDoublePoint);
/*     */     
/*  94 */     int weekCanUseCount = DoublePointOfferCfgConsts.getInstance().ITEM_MAX_USE_COUNT - doublePoint.getItemusecount();
/*  95 */     SDoublePointItem doublePointItem = SDoublePointItem.get(DoublePointOfferCfgConsts.getInstance().DOUBLE_POINT_ITEM_ID);
/*  96 */     int dayCanUseCount = 0;
/*  97 */     if (doublePointItem != null)
/*     */     {
/*  99 */       dayCanUseCount = doublePointItem.maxUseCount - mzm.gsp.item.main.ItemInterface.getItemUseCount(roleId, DoublePointOfferCfgConsts.getInstance().DOUBLE_POINT_ITEM_ID);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 105 */       dayCanUseCount = 0;
/*     */     }
/* 107 */     GuajiManager.sendSSyncDoubleItemuseCount(roleId, dayCanUseCount, weekCanUseCount);
/* 108 */     return true;
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
/*     */   private int compensateDoublePoint(int nowGettingPoolPoint, long lastRoleOfferTime, long observerOfferTime)
/*     */   {
/* 124 */     int timeConfigId = DoublePointOfferCfgConsts.getInstance().OFFER_TIME;
/* 125 */     STimeCommonCfg timeCommonCfg = STimeCommonCfg.get(timeConfigId);
/*     */     
/* 127 */     long intervalMillSecnonds = timeCommonCfg.activeWeekDay > 0 ? 604800000L : 86400000L;
/*     */     
/*     */ 
/*     */ 
/* 131 */     int missTimes = (int)((observerOfferTime - lastRoleOfferTime - 1L) / intervalMillSecnonds + 1L);
/*     */     
/* 133 */     int compensateTimes = 0;
/* 134 */     int tempPoint = nowGettingPoolPoint;
/* 135 */     while (compensateTimes < missTimes)
/*     */     {
/* 137 */       tempPoint = GuajiManager.discountOnTimeOut(tempPoint);
/* 138 */       if (tempPoint >= DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM)
/*     */       {
/* 140 */         tempPoint = DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM;
/* 141 */         break;
/*     */       }
/* 143 */       compensateTimes++;
/*     */     }
/* 145 */     return tempPoint;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initDoublePointSwitch(long roleId, DoublePoint xDoublePoint)
/*     */   {
/* 156 */     if (!xDoublePoint.getSwitch_inits().contains(Integer.valueOf(SwitchType.GuaJi.id)))
/*     */     {
/* 158 */       xDoublePoint.getSwitches().add(Integer.valueOf(SwitchType.GuaJi.id));
/* 159 */       xDoublePoint.getSwitch_inits().add(Integer.valueOf(SwitchType.GuaJi.id));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */