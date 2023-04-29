/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.PushAwardConst;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PushAwardHandler
/*     */   implements WeeklyTimeLimitGetAwardHandler
/*     */ {
/*     */   static volatile PushAwardHandler instance;
/*     */   
/*     */   static PushAwardHandler getInstance()
/*     */   {
/*  28 */     if (instance == null)
/*     */     {
/*  30 */       synchronized (PushAwardHandler.class)
/*     */       {
/*  32 */         if (instance == null)
/*     */         {
/*  34 */           instance = new PushAwardHandler();
/*     */         }
/*     */       }
/*     */     }
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean doAward(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  44 */     return dealGetWeeklyLimit(userid, roleId, sTimeLimitGiftBagCfg);
/*     */   }
/*     */   
/*     */   private boolean dealGetWeeklyLimit(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  49 */     if (!isPushAwardOpenForRole(roleId))
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[qingfu]PushAwardHandler.dealGetWeeklyLimit@ push award activity switch closed for role |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     boolean ret = doAward(userid, roleId, LogReason.PUSH_AWARD, sTimeLimitGiftBagCfg);
/*  59 */     if (ret)
/*     */     {
/*  61 */       tlogPushAward(userid, roleId, sTimeLimitGiftBagCfg);
/*     */     }
/*     */     
/*  64 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean doAward(String userid, long roleId, LogReason logReason, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  71 */     AwardModel awardModel = AwardInterface.awardFixAward(sTimeLimitGiftBagCfg.rewardId, userid, roleId, true, true, new AwardReason(logReason, sTimeLimitGiftBagCfg.id));
/*     */     
/*  73 */     if (awardModel == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[qingfu]PushAwardHandler.doAward@awardModel error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     GameServer.logger().info(String.format("[qingfu]PushAwardHandler.doAward@ get push award success |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogPushAward(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  97 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/*  99 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 101 */     Object[] columns = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) };
/*     */     
/* 103 */     TLogManager.getInstance().addLog(userid, roleId, "PushAward", columns);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getActivityId()
/*     */   {
/* 109 */     return PushAwardConst.getInstance().activityid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPushAwardOpenForRole(long roleid)
/*     */   {
/* 120 */     if (!OpenInterface.getOpenStatus(192))
/*     */     {
/* 122 */       OpenInterface.sendCloseProtocol(roleid, 192, null);
/* 123 */       return false;
/*     */     }
/* 125 */     if (OpenInterface.isBanPlay(roleid, 192))
/*     */     {
/* 127 */       OpenInterface.sendBanPlayMsg(roleid, 192);
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PushAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */