/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.mibao.SGetMiBaoInfo;
/*    */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*    */ import mzm.gsp.mibao.confbean.SBaoKuDrawLotteryCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2MiBaoInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleId = ((Long)this.arg).longValue();
/* 20 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 21 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 23 */     Role2MiBaoInfo xRole2MiBaoInfo = xtable.Role2mibao.get(Long.valueOf(roleId));
/* 24 */     if (xRole2MiBaoInfo == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     long nowActivityLimitBeginTime = ActivityInterface.getActivityLimitTimeBegin(BaoKuConsts.getInstance().miBaoActivityId);
/* 30 */     long nowActivityLimitEndTime = ActivityInterface.getActivityLimitTimeEnd(BaoKuConsts.getInstance().miBaoActivityId);
/*    */     
/* 32 */     long xExchangeActivityLimitBeginTime = xRole2MiBaoInfo.getShould_exchange_score_limit_begin_time();
/* 33 */     long xExchangeActivityLimitEndTime = xRole2MiBaoInfo.getShould_exchange_score_limit_end_time();
/* 34 */     boolean xIsExchangeScore = xRole2MiBaoInfo.getIs_exchange_score();
/*    */     
/*    */ 
/* 37 */     if ((xIsExchangeScore) && ((xExchangeActivityLimitBeginTime != nowActivityLimitBeginTime) || (xExchangeActivityLimitEndTime != nowActivityLimitEndTime)))
/*    */     {
/*    */ 
/* 40 */       GameServer.logger().warn(String.format("[mibao]POnRoleLogin.processImp@is exchange score is  true,mi bao activity end time or begin time changes|role_id=%d|xdb_current_index_id=%d|index_size=%d|now_activity_begin_time=%d|now_activity_end_time=%d|xdb_activity_begin_time=%d|xdb_activity_end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRole2MiBaoInfo.getCurrent_index_id()), Integer.valueOf(SBaoKuDrawLotteryCfg.getAll().size()), Long.valueOf(nowActivityLimitBeginTime), Long.valueOf(nowActivityLimitEndTime), Long.valueOf(xExchangeActivityLimitBeginTime), Long.valueOf(xExchangeActivityLimitEndTime) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */       xRole2MiBaoInfo.setIs_exchange_score(false);
/* 48 */       xRole2MiBaoInfo.setShould_exchange_score_limit_begin_time(nowActivityLimitBeginTime);
/* 49 */       xRole2MiBaoInfo.setShould_exchange_score_limit_end_time(nowActivityLimitEndTime);
/* 50 */       xRole2MiBaoInfo.getLimit_item_draw_times_map().clear();
/*    */     }
/*    */     
/*    */ 
/* 54 */     if ((!xRole2MiBaoInfo.getIs_exchange_score()) && (xExchangeActivityLimitBeginTime == nowActivityLimitBeginTime) && (xExchangeActivityLimitEndTime != nowActivityLimitEndTime))
/*    */     {
/*    */ 
/* 57 */       GameServer.logger().warn(String.format("[mibao]POnRoleLogin.processImp@is exchange score is false,mi bao activity end time changes|role_id=%d|xdb_current_index_id=%d|index_size=%d|now_activity_begin_time=%d|now_activity_end_time=%d|xdb_activity_begin_time=%d|xdb_activity_end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRole2MiBaoInfo.getCurrent_index_id()), Integer.valueOf(SBaoKuDrawLotteryCfg.getAll().size()), Long.valueOf(nowActivityLimitBeginTime), Long.valueOf(nowActivityLimitEndTime), Long.valueOf(xExchangeActivityLimitBeginTime), Long.valueOf(xExchangeActivityLimitEndTime) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 63 */       xRole2MiBaoInfo.setShould_exchange_score_limit_end_time(nowActivityLimitEndTime);
/*    */     }
/*    */     
/* 66 */     if ((!xRole2MiBaoInfo.getIs_exchange_score()) && (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() > xRole2MiBaoInfo.getShould_exchange_score_limit_end_time()))
/*    */     {
/*    */ 
/*    */ 
/* 70 */       new PExchangeScoreWhenActivityEnd(roleId, nowActivityLimitBeginTime, nowActivityLimitEndTime).call();
/*    */     }
/*    */     
/*    */ 
/* 74 */     if (xRole2MiBaoInfo.getCurrent_index_id() > SBaoKuDrawLotteryCfg.getAll().size())
/*    */     {
/* 76 */       GameServer.logger().warn(String.format("[mibao]POnRoleLogin.processImp@index id not match with cfg|role_id=%d|xdb_current_index_id=%d|index_size=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xRole2MiBaoInfo.getCurrent_index_id()), Integer.valueOf(SBaoKuDrawLotteryCfg.getAll().size()) }));
/*    */       
/*    */ 
/*    */ 
/* 80 */       xRole2MiBaoInfo.setCurrent_index_id(SBaoKuDrawLotteryCfg.getAll().size());
/*    */     }
/*    */     
/* 83 */     SGetMiBaoInfo sGetMiBaoInfo = new SGetMiBaoInfo();
/* 84 */     sGetMiBaoInfo.current_lucky_value = xRole2MiBaoInfo.getCurrent_lucky_value();
/* 85 */     sGetMiBaoInfo.current_mibao_index_id = xRole2MiBaoInfo.getCurrent_index_id();
/* 86 */     sGetMiBaoInfo.current_score = xRole2MiBaoInfo.getCurrent_score();
/*    */     
/* 88 */     OnlineManager.getInstance().send(roleId, sGetMiBaoInfo);
/*    */     
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */