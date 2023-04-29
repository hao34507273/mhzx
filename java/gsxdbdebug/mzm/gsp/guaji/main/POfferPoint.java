/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.guaji.SSyncDoublePoint;
/*    */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*    */ import mzm.gsp.yuanbao.main.CurrencyType;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DoublePoint;
/*    */ import xtable.Role2doublepoint;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class POfferPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long curtime;
/*    */   
/*    */   public POfferPoint(long roleId, long curtime)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.curtime = curtime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 37 */       String logstr = String.format("[guaji]POfferPoint.processImp@roam server state can not operate double point|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 39 */       GuajiManager.logger.info(logstr);
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     TLogArg logArg = new TLogArg(LogReason.OFFER_DOUBLE_POINT);
/* 44 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(this.roleId));
/*    */     
/* 46 */     if (xDoublePoint.getOffertimestamp() >= this.curtime)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     int oldgetingnum = xDoublePoint.getGettingpoolpointnum();
/*    */     
/* 53 */     int afterdiscount = GuajiManager.discountOnTimeOut(oldgetingnum);
/* 54 */     int totalGettingPoint = Math.min(afterdiscount, DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM);
/*    */     
/* 56 */     xDoublePoint.setGettingpoolpointnum(totalGettingPoint);
/* 57 */     xDoublePoint.setOffertimestamp(this.curtime);
/*    */     
/* 59 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 60 */     GuajiManager.fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 61 */     OnlineManager.getInstance().send(this.roleId, sSyncDoublePoint);
/* 62 */     String logstr = String.format("[guaji]POfferPoint.processImp@offer double point to role|roleid=%d|oldnum=%d|aftergetingnum=%d|finalnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(oldgetingnum), Integer.valueOf(afterdiscount), Integer.valueOf(totalGettingPoint) });
/*    */     
/*    */ 
/* 65 */     GuajiManager.logger.info(logstr);
/* 66 */     GuajiManager.tlogDoublepoint(this.roleId, xDoublePoint.getFrozenpoolpointnum(), xDoublePoint.getGettingpoolpointnum(), xDoublePoint.getFrozenpoolpointnum(), oldgetingnum, 0, xDoublePoint.getGettingpoolpointnum() - oldgetingnum, logArg);
/*    */     
/*    */ 
/*    */ 
/* 70 */     CurrencyLogUtil.logCurrency(this.roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, xDoublePoint.getGettingpoolpointnum() - oldgetingnum, xDoublePoint.getGettingpoolpointnum(), logArg);
/*    */     
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\POfferPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */