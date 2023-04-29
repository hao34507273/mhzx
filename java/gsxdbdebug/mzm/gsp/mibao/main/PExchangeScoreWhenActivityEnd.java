/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2MiBaoInfo;
/*    */ 
/*    */ class PExchangeScoreWhenActivityEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long nowActivityLimitBeginTime;
/*    */   private final long nowActivityLimitEndTime;
/*    */   
/*    */   public PExchangeScoreWhenActivityEnd(long roleId, long nowActivityBeginTime, long nowActivityEndTime)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.nowActivityLimitEndTime = nowActivityEndTime;
/* 19 */     this.nowActivityLimitBeginTime = nowActivityBeginTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 26 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 28 */     Role2MiBaoInfo xRole2MiBaoInfo = xtable.Role2mibao.get(Long.valueOf(this.roleId));
/* 29 */     if (xRole2MiBaoInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (xRole2MiBaoInfo.getIs_exchange_score())
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 70 */     long xShouldExchangeScoreLimitBeginTime = xRole2MiBaoInfo.getShould_exchange_score_limit_begin_time();
/* 71 */     long xShouldExchangeScoreLimitEndTime = xRole2MiBaoInfo.getShould_exchange_score_limit_end_time();
/* 72 */     if ((xShouldExchangeScoreLimitBeginTime != this.nowActivityLimitBeginTime) || (xShouldExchangeScoreLimitEndTime != this.nowActivityLimitEndTime))
/*    */     {
/*    */ 
/* 75 */       xRole2MiBaoInfo.setIs_exchange_score(false);
/* 76 */       xRole2MiBaoInfo.setShould_exchange_score_limit_begin_time(this.nowActivityLimitBeginTime);
/* 77 */       xRole2MiBaoInfo.setShould_exchange_score_limit_end_time(this.nowActivityLimitEndTime);
/*    */     }
/*    */     else
/*    */     {
/* 81 */       xRole2MiBaoInfo.setIs_exchange_score(true);
/*    */     }
/* 83 */     xRole2MiBaoInfo.setCurrent_index_id(1);
/*    */     
/* 85 */     xRole2MiBaoInfo.setBuy_times_today(0);
/* 86 */     xRole2MiBaoInfo.setCurrent_lucky_value(0);
/* 87 */     xRole2MiBaoInfo.getLimit_item_draw_times_map().clear();
/*    */     
/* 89 */     GameServer.logger().info(String.format("[mibao]PExchangeScoreWhenActivityEnd.processImp@exchange gold success|role_id=%d|mail_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(BaoKuConsts.getInstance().exchangeMailId) }));
/*    */     
/*    */ 
/*    */ 
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\PExchangeScoreWhenActivityEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */