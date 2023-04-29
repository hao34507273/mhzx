/*     */ package mzm.gsp.exchange.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.exchange.confbean.ExchangeAwardInfo;
/*     */ import mzm.gsp.exchange.confbean.SExchangeCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ExchangeInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2exchangeinfo;
/*     */ 
/*     */ public class PCExchangeAwardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int sortid;
/*     */   private final int exchangeTimes;
/*     */   
/*     */   public PCExchangeAwardReq(long roleid, int activityCfgid, int sortid, int exchangeTimes)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.activityCfgid = activityCfgid;
/*  23 */     this.sortid = sortid;
/*  24 */     this.exchangeTimes = exchangeTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (this.exchangeTimes <= 0)
/*     */     {
/*     */ 
/*  33 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@param error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  36 */       return false;
/*     */     }
/*  38 */     SExchangeCfg cfg = SExchangeCfg.get(this.activityCfgid);
/*  39 */     if (cfg == null)
/*     */     {
/*     */ 
/*  42 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@param error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*  47 */     ExchangeAwardInfo exchangeAwardInfo = (ExchangeAwardInfo)cfg.exchange_award_info_map.get(Integer.valueOf(this.sortid));
/*  48 */     if (exchangeAwardInfo == null)
/*     */     {
/*     */ 
/*  51 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@param error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  54 */       return false;
/*     */     }
/*  56 */     if (!exchangeAwardInfo.is_open)
/*     */     {
/*     */ 
/*  59 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@param error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!ExchangeManager.isExchangeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  68 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@module close or role forbidden|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!ExchangeManager.checkRoleStatus(this.roleid))
/*     */     {
/*     */ 
/*  77 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@role status error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  85 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  86 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*  87 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  89 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  92 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@join activity fail|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     ExchangeInfo xExchangeInfo = Role2exchangeinfo.get(Long.valueOf(this.roleid));
/*  99 */     if (xExchangeInfo == null)
/*     */     {
/* 101 */       xExchangeInfo = xbean.Pod.newExchangeInfo();
/* 102 */       Role2exchangeinfo.insert(Long.valueOf(this.roleid), xExchangeInfo);
/*     */     }
/*     */     
/* 105 */     int roleExchangeTimes = ExchangeManager.getRoleExchangeTimes(this.activityCfgid, this.sortid, xExchangeInfo);
/* 106 */     if (roleExchangeTimes < 0)
/*     */     {
/*     */ 
/* 109 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@role exchange time error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int maxExchangeNum = ExchangeManager.getMaxExchangeNum(this.activityCfgid, this.sortid);
/* 116 */     if (maxExchangeNum < 0)
/*     */     {
/*     */ 
/* 119 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@max exchange num cfg error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     if ((maxExchangeNum != 0) && (roleExchangeTimes + this.exchangeTimes > maxExchangeNum))
/*     */     {
/*     */ 
/* 128 */       ExchangeManager.sendExchangeAwardFail(this.roleid, this.activityCfgid, this.sortid, this.exchangeTimes, 0);
/*     */       
/* 130 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@max exchange num cfg error|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d|max_exchange_num=%d|role_exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes), Integer.valueOf(maxExchangeNum), Integer.valueOf(roleExchangeTimes) }));
/*     */       
/*     */ 
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     if (!ExchangeManager.cutAllNeedItem(this.roleid, this.activityCfgid, this.sortid, this.exchangeTimes))
/*     */     {
/*     */ 
/* 139 */       ExchangeManager.sendExchangeAwardFail(this.roleid, this.activityCfgid, this.sortid, this.exchangeTimes, 1);
/*     */       
/* 141 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@cut item fail|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     if (!ExchangeManager.sendAwardAndExchangeAwardSuccess(userid, this.roleid, this.activityCfgid, this.sortid, this.exchangeTimes, xExchangeInfo))
/*     */     {
/*     */ 
/*     */ 
/* 151 */       ExchangeManager.sendExchangeAwardFail(this.roleid, this.activityCfgid, this.sortid, this.exchangeTimes, 2);
/*     */       
/* 153 */       ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@send award fail|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes) }));
/*     */       
/*     */ 
/* 156 */       return false;
/*     */     }
/* 158 */     ExchangeManager.logger.info(String.format("[exchange]PCExchangeAwardReq.processImp@exchange award success|roleid=%d|activity_cfg_id=%d|sortid=%d|exchange_times=%d|already_exchange_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(this.exchangeTimes), Integer.valueOf(roleExchangeTimes + this.exchangeTimes) }));
/*     */     
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\PCExchangeAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */