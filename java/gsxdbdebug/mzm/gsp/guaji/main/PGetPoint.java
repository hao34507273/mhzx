/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.guaji.SGetPointRes;
/*    */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*    */ import mzm.gsp.guaji.event.GetDoublePointEvent;
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
/*    */ public class PGetPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PGetPoint(long roleId)
/*    */   {
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!GuajiManager.isDoublePointSwitchOpenForRole(this.roleId))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!GuajiManager.isRoleStateCanOperateDoublePoint(this.roleId))
/*    */     {
/* 39 */       String logstr = String.format("[guaji]PGetPoint.processImp@role state can not operate double point|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 41 */       GuajiManager.logger.info(logstr);
/* 42 */       return false;
/*    */     }
/* 44 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(this.roleId));
/* 45 */     int oldgettingnum = xDoublePoint.getGettingpoolpointnum();
/* 46 */     if (xDoublePoint.getGettingpoolpointnum() <= 0)
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     int frozenRemainSpace = DoublePointOfferCfgConsts.getInstance().ROLE_CARRY_MAX_NUM - xDoublePoint.getFrozenpoolpointnum();
/*    */     
/* 52 */     if (frozenRemainSpace <= 0)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     TLogArg logArg = new TLogArg(LogReason.GET_DOUBLE_POINT);
/* 57 */     int frozenNum = Math.min(frozenRemainSpace, DoublePointOfferCfgConsts.getInstance().ONCE_GET_MAX_NUM);
/* 58 */     frozenNum = Math.min(frozenNum, xDoublePoint.getGettingpoolpointnum());
/* 59 */     xDoublePoint.setGettingpoolpointnum(xDoublePoint.getGettingpoolpointnum() - frozenNum);
/* 60 */     int oldfrozennum = xDoublePoint.getFrozenpoolpointnum();
/* 61 */     xDoublePoint.setFrozenpoolpointnum(oldfrozennum + frozenNum);
/*    */     
/* 63 */     SGetPointRes res = new SGetPointRes();
/* 64 */     res.addfrozenpoolnum = frozenNum;
/* 65 */     res.frozenpoolpointnum = xDoublePoint.getFrozenpoolpointnum();
/* 66 */     res.getingpoolpointnum = xDoublePoint.getGettingpoolpointnum();
/* 67 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 69 */     TriggerEventsManger.getInstance().triggerEvent(new GetDoublePointEvent(), Long.valueOf(this.roleId));
/*    */     
/* 71 */     String logstr = String.format("[guaji]PGetPoint.processImp@get double point success|roleid=%d|oldfrozennum=%d|newforzennum=%d|oldgettingpoolnum=%d|newgettingpoolnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(oldfrozennum), Integer.valueOf(res.frozenpoolpointnum), Integer.valueOf(oldgettingnum), Integer.valueOf(res.getingpoolpointnum) });
/*    */     
/*    */ 
/* 74 */     GuajiManager.logger.info(logstr);
/*    */     
/* 76 */     GuajiManager.tlogDoublepoint(this.roleId, xDoublePoint.getFrozenpoolpointnum(), xDoublePoint.getGettingpoolpointnum(), oldfrozennum, oldgettingnum, xDoublePoint.getFrozenpoolpointnum() - oldfrozennum, xDoublePoint.getGettingpoolpointnum() - oldgettingnum, logArg);
/*    */     
/*    */ 
/*    */ 
/* 80 */     CurrencyLogUtil.logCurrency(this.roleId, CurrencyType.CURRENCY_FROZEN_POOL_NUM, frozenNum, xDoublePoint.getFrozenpoolpointnum(), logArg);
/*    */     
/* 82 */     CurrencyLogUtil.logCurrency(this.roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, xDoublePoint.getGettingpoolpointnum() - oldgettingnum, xDoublePoint.getGettingpoolpointnum(), logArg);
/*    */     
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\PGetPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */