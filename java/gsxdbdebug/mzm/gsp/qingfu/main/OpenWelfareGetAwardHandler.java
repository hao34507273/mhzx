/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.qingfu.confbean.SOpenWelfareConst;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class OpenWelfareGetAwardHandler
/*     */   implements WeeklyTimeLimitGetAwardHandler
/*     */ {
/*     */   public boolean doAward(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  21 */     return dealGetWeeklyLimit(userid, roleId, sTimeLimitGiftBagCfg);
/*     */   }
/*     */   
/*     */   private boolean dealGetWeeklyLimit(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  26 */     if (!TimeLimitGiftActivityManager.isOpenWelfareSwitchOpenForRole(roleId))
/*     */     {
/*  28 */       GameServer.logger().error(String.format("[qingfu]OpenWelfareGetAwardHandler.dealGetWeeklyLimit@open welfare activity switch closed for role |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId) }));
/*     */       
/*     */ 
/*     */ 
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (sTimeLimitGiftBagCfg.minActiveValue > 0)
/*     */     {
/*  37 */       int activeValue = ActiveInterface.getTotalActiveValue(roleId);
/*     */       
/*  39 */       if (activeValue < sTimeLimitGiftBagCfg.minActiveValue)
/*     */       {
/*  41 */         GameServer.logger().info(String.format("[qingfu]OpenWelfareGetAwardHandler.dealGetWeeklyLimit@active value not enough|roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|activeValue=%d|needActiveValue=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(activeValue), Integer.valueOf(sTimeLimitGiftBagCfg.minActiveValue) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */         return false;
/*     */       }
/*     */     }
/*  50 */     boolean ret = doAward(userid, roleId, LogReason.OPEN_WELFARE_ACTIVITY, sTimeLimitGiftBagCfg);
/*  51 */     if (ret)
/*     */     {
/*  53 */       tlogOpenWelfare(userid, roleId, sTimeLimitGiftBagCfg);
/*     */     }
/*     */     
/*  56 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean doAward(String userid, long roleId, LogReason logReason, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  63 */     AwardModel awardModel = AwardInterface.awardFixAward(sTimeLimitGiftBagCfg.rewardId, userid, roleId, true, true, new AwardReason(logReason, sTimeLimitGiftBagCfg.id));
/*     */     
/*  65 */     if (awardModel == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[qingfu]OpenWelfareGetAwardHandler.doAward@awardModel error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     GameServer.logger().info(String.format("[qingfu]OpenWelfareGetAwardHandler.doAward@ buy time limit gift success |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), userid, Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  82 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogOpenWelfare(String userid, long roleId, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg)
/*     */   {
/*  89 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/*  91 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  93 */     Object[] columns = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(sTimeLimitGiftBagCfg.activityId), Integer.valueOf(sTimeLimitGiftBagCfg.id), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) };
/*     */     
/*  95 */     TLogManager.getInstance().addLog(userid, roleId, "OpenWelfare", columns);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getActivityId()
/*     */   {
/* 101 */     return SOpenWelfareConst.getInstance().activity_cfg_id;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\OpenWelfareGetAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */