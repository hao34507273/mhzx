/*    */ package mzm.gsp.exchange.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.exchange.SSyncExchangeInfo;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ExchangeInfo;
/*    */ 
/*    */ public class PGM_ClearExchangeTimes extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long targetRoleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_ClearExchangeTimes(long roleid, long targetRoleid, int activityCfgid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.targetRoleid = targetRoleid;
/* 19 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!mzm.gsp.exchange.confbean.SExchangeCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("无效的活动id %d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     ExchangeInfo xExchangeInfo = xtable.Role2exchangeinfo.get(Long.valueOf(this.targetRoleid));
/* 32 */     if (xExchangeInfo != null)
/*    */     {
/* 34 */       xbean.ExchangeActivityInfo xExchangeActivityInfo = (xbean.ExchangeActivityInfo)xExchangeInfo.getExchange_activity_infos().get(Integer.valueOf(this.activityCfgid));
/* 35 */       if (xExchangeActivityInfo != null)
/*    */       {
/* 37 */         xExchangeActivityInfo.getExchange_award_infos().clear();
/*    */       }
/*    */     }
/*    */     
/* 41 */     SSyncExchangeInfo protocol = new SSyncExchangeInfo();
/* 42 */     protocol.exchange_activity_infos.put(Integer.valueOf(this.activityCfgid), new mzm.gsp.exchange.ExchangeActivityInfo());
/* 43 */     OnlineManager.getInstance().send(this.targetRoleid, protocol);
/*    */     
/* 45 */     GmManager.getInstance().sendResultToGM(this.roleid, String.format("清楚兑换次数成功targerRoleid=%d,活动id=%d", new Object[] { Long.valueOf(this.targetRoleid), Integer.valueOf(this.activityCfgid) }));
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\PGM_ClearExchangeTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */