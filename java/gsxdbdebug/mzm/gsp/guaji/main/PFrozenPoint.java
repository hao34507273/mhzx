/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.gsp.guaji.SFrozenPointRes;
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
/*    */ public class PFrozenPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PFrozenPoint(long roleid)
/*    */   {
/* 25 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!GuajiManager.isRoleStateCanOperateDoublePoint(this.roleid))
/*    */     {
/* 33 */       String logstr = String.format("[guaji]PFrozenPoint.processImp@role state can not operate double point|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 35 */       GuajiManager.logger.info(logstr);
/* 36 */       return false;
/*    */     }
/* 38 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(this.roleid));
/* 39 */     if (xDoublePoint.getFrozenpoolpointnum() <= DoublePointOfferCfgConsts.getInstance().FROZEN_DEC_NUM)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     TLogArg logArg = new TLogArg(LogReason.FROZEN_DOUBLE_POINT);
/* 44 */     int oldfrozennum = xDoublePoint.getFrozenpoolpointnum();
/* 45 */     int oldgettingnum = xDoublePoint.getGettingpoolpointnum();
/*    */     
/* 47 */     int totalPointNum = xDoublePoint.getFrozenpoolpointnum() + xDoublePoint.getGettingpoolpointnum() - DoublePointOfferCfgConsts.getInstance().FROZEN_DEC_NUM;
/*    */     
/* 49 */     xDoublePoint.setFrozenpoolpointnum(0);
/* 50 */     xDoublePoint.setGettingpoolpointnum(totalPointNum);
/* 51 */     SFrozenPointRes res = new SFrozenPointRes();
/* 52 */     res.getingpoolpointnum = totalPointNum;
/* 53 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 55 */     String logstr = String.format("[guaji]PFrozenPoint.processImp@frozen double point success|roleid=%d|beforeforzennum=%d|afterfrozennum=%d|beforegettingnum=%d|aftergettingnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(oldfrozennum), Integer.valueOf(xDoublePoint.getFrozenpoolpointnum()), Integer.valueOf(oldgettingnum), Integer.valueOf(xDoublePoint.getGettingpoolpointnum()) });
/*    */     
/*    */ 
/*    */ 
/* 59 */     GuajiManager.logger.info(logstr);
/* 60 */     GuajiManager.tlogDoublepoint(this.roleid, xDoublePoint.getFrozenpoolpointnum(), xDoublePoint.getGettingpoolpointnum(), oldfrozennum, oldgettingnum, xDoublePoint.getFrozenpoolpointnum() - oldfrozennum, xDoublePoint.getGettingpoolpointnum() - oldgettingnum, logArg);
/*    */     
/*    */ 
/*    */ 
/* 64 */     CurrencyLogUtil.logCurrency(this.roleid, CurrencyType.CURRENCY_FROZEN_POOL_NUM, -oldfrozennum, xDoublePoint.getFrozenpoolpointnum(), logArg);
/*    */     
/* 66 */     CurrencyLogUtil.logCurrency(this.roleid, CurrencyType.CURRENCY_GETTING_POOL_NUM, xDoublePoint.getGettingpoolpointnum() - oldgettingnum, xDoublePoint.getGettingpoolpointnum(), logArg);
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\PFrozenPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */