/*     */ package mzm.gsp.baotu.main;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.confbean.AwardCfgConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.baotu.SNoBaoTuRes;
/*     */ import mzm.gsp.baotu.event.BaoTuActivityArg;
/*     */ import mzm.gsp.baotu.event.BaoTuActivityFinished;
/*     */ import mzm.gsp.item.confbean.SBaotuController;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaotuManager
/*     */ {
/*     */   static boolean isBaotuSwitchOpenForRole(long roleid)
/*     */   {
/*  37 */     return isBaotuSwitchOpenForRole(roleid, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBaotuSwitchOpenForRole(long roleid, boolean isSendTip)
/*     */   {
/*  49 */     if (!OpenInterface.getOpenStatus(2))
/*     */     {
/*  51 */       if (isSendTip)
/*     */       {
/*  53 */         OpenInterface.sendCloseProtocol(roleid, 2, null);
/*     */       }
/*  55 */       return false;
/*     */     }
/*  57 */     if (OpenInterface.isBanPlay(roleid, 2))
/*     */     {
/*  59 */       if (isSendTip)
/*     */       {
/*  61 */         OpenInterface.sendBanPlayMsg(roleid, 2);
/*     */       }
/*  63 */       return false;
/*     */     }
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isBaoBaoController(int controllerId)
/*     */   {
/*  71 */     SBaotuController sBaotuController = SBaotuController.get(controllerId);
/*  72 */     if (sBaotuController == null)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     return sBaotuController.controllerType != 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanJoinBaotuActivity(long roleid)
/*     */   {
/*  90 */     return RoleStatusInterface.checkCanSetStatus(roleid, 143, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBaotuCountToMax(long roleId, int activityCount)
/*     */   {
/* 100 */     if (activityCount >= BaoTuActivityCfgConsts.getInstance().MAX_AWARD_COUNT)
/*     */     {
/* 102 */       if (TaskInterface.isHaveGraphId(roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID))
/*     */       {
/*     */ 
/* 105 */         boolean ret = TaskInterface.closeActivityGraphWithoutEvent(roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID);
/*     */         
/* 107 */         if (!ret)
/*     */         {
/* 109 */           String logStr = String.format("[baotu]BaotuManager.isBaotuCountToMax@close baotu activity graph error|roleid=%d|count=%d|maxcount=%d|graphid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityCount), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().MAX_AWARD_COUNT), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().GRAPH_ID) });
/*     */           
/*     */ 
/*     */ 
/* 113 */           BaoTuItemModule.logger.error(logStr);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */       String logStr = String.format("[baotu]BaotuManager.isBaotuCountToMax@baotu activity to max count|roleid=%d|count=%d|maxcount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityCount), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().MAX_AWARD_COUNT) });
/*     */       
/*     */ 
/* 124 */       BaoTuItemModule.logger.info(logStr);
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
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
/*     */   static boolean awardBaotuToRole(String userId, long roleId, int awardRate, int rewardId, int activitycount)
/*     */   {
/* 141 */     int ran = Xdb.random().nextInt(AwardCfgConsts.getInstance().AWARD_SEED);
/* 142 */     if (ran < awardRate)
/*     */     {
/* 144 */       boolean ret = ActivityInterface.addActivityCount(userId, roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID);
/* 145 */       if (!ret)
/*     */       {
/* 147 */         String logStr = String.format("[baotu]BaotuManager.awardBaotuToRole@add baotu activity count error|roleid=%d|count=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activitycount) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 152 */         BaoTuItemModule.logger.error(logStr);
/*     */         
/* 154 */         return false;
/*     */       }
/* 156 */       AwardModel awardModel = AwardInterface.award(rewardId, userId, roleId, false, true, new AwardReason(LogReason.BAOTU_ACTIVITY_ADD, rewardId));
/*     */       
/* 158 */       if (awardModel != null)
/*     */       {
/* 160 */         String logStr = String.format("[baotu]BaotuManager.awardBaotuToRole@award baotu suc|roleid=%d|count=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activitycount + 1), Integer.valueOf(rewardId) });
/*     */         
/*     */ 
/* 163 */         BaoTuItemModule.logger.info(logStr);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 168 */         String logStr = String.format("[baotu]BaotuManager.awardBaotuToRole@award baotu fail,null awardmodel|roleid=%d|count=%d|rewardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activitycount + 1), Integer.valueOf(rewardId) });
/*     */         
/*     */ 
/* 171 */         BaoTuItemModule.logger.error(logStr);
/*     */       }
/* 173 */       return true;
/*     */     }
/*     */     
/* 176 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean autoFinishBaoTu(String userId, long roleId)
/*     */   {
/* 188 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/* 191 */     int grahpId = BaoTuActivityCfgConsts.getInstance().GRAPH_ID;
/*     */     
/* 193 */     if (!res.isCanJoin())
/*     */     {
/* 195 */       BaoTuItemModule.logger.error(String.format("[baotu]BaotuManager.autoFinishBaoTu@can join boatu error|roleid=%d|graphid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(grahpId) }));
/*     */       
/*     */ 
/* 198 */       return false;
/*     */     }
/* 200 */     if (!isRoleStateCanJoinBaotuActivity(roleId))
/*     */     {
/* 202 */       BaoTuItemModule.logger.error(String.format("[baotu]BaotuManager.autoFinishBaoTu@role state can not join baotu activity|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     int oldCount = ActivityInterface.getActivityCount(userId, roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*     */ 
/* 211 */     SActivityCfg activityCfg = SActivityCfg.get(BaoTuActivityCfgConsts.getInstance().ACTIVITYID);
/* 212 */     if (activityCfg == null)
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     int needMoreCount = activityCfg.recommendCount - oldCount;
/* 217 */     if (needMoreCount <= 0)
/*     */     {
/* 219 */       return true;
/*     */     }
/*     */     
/* 222 */     if (oldCount == 0)
/*     */     {
/* 224 */       TaskInterface.finishSingleTask(roleId, BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID, -1);
/*     */     }
/*     */     
/* 227 */     int activityCount = oldCount;
/* 228 */     for (int i = 0; i < needMoreCount; i++)
/*     */     {
/* 230 */       ActivityInterface.logActivity(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 231 */       ActivityInterface.tlogActivity(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 232 */       if (onFinishBaoTu(userId, roleId, activityCount) == -1)
/*     */       {
/* 234 */         return true;
/*     */       }
/* 236 */       activityCount++;
/*     */     }
/* 238 */     return true;
/*     */   }
/*     */   
/*     */   static int onFinishBaoTu(String userId, long roleId, int activityCount)
/*     */   {
/* 243 */     ActivityInterface.logActivity(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 244 */     ActivityInterface.tlogActivity(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */     
/* 246 */     boolean istomax = isBaotuCountToMax(roleId, activityCount);
/* 247 */     if (istomax)
/*     */     {
/* 249 */       return -1;
/*     */     }
/*     */     
/* 252 */     GameServer.logger().info(String.format("[baotu]BaotuManager.onFinishBaoTu@finishi bao tu|roleId=%d|count=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityCount + 1) }));
/*     */     
/*     */ 
/* 255 */     boolean r1 = awardBaotuToRole(userId, roleId, BaoTuActivityCfgConsts.getInstance().AWARDRATE1, BaoTuActivityCfgConsts.getInstance().REWARDID1, activityCount);
/*     */     
/* 257 */     if (r1)
/*     */     {
/* 259 */       activityCount++;
/* 260 */       istomax = isBaotuCountToMax(roleId, activityCount);
/* 261 */       if (istomax)
/*     */       {
/* 263 */         TriggerEventsManger.getInstance().triggerEvent(new BaoTuActivityFinished(), new BaoTuActivityArg(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, activityCount - 1, activityCount));
/*     */         
/*     */ 
/*     */ 
/* 267 */         return -1;
/*     */       }
/*     */     }
/*     */     
/* 271 */     boolean r2 = awardBaotuToRole(userId, roleId, BaoTuActivityCfgConsts.getInstance().AWARDRATE2, BaoTuActivityCfgConsts.getInstance().REWARDID2, activityCount);
/*     */     
/* 273 */     if (r2)
/*     */     {
/* 275 */       activityCount++;
/* 276 */       istomax = isBaotuCountToMax(roleId, activityCount);
/* 277 */       if (istomax)
/*     */       {
/*     */ 
/* 280 */         TriggerEventsManger.getInstance().triggerEvent(new BaoTuActivityFinished(), new BaoTuActivityArg(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, activityCount - 1, activityCount));
/*     */         
/*     */ 
/*     */ 
/* 284 */         return -1;
/*     */       }
/*     */     }
/*     */     
/* 288 */     if ((!r1) && (!r2))
/*     */     {
/* 290 */       SNoBaoTuRes noBaoTuRes = new SNoBaoTuRes();
/* 291 */       OnlineManager.getInstance().send(roleId, noBaoTuRes);
/*     */     }
/*     */     
/* 294 */     TriggerEventsManger.getInstance().triggerEvent(new BaoTuActivityFinished(), new BaoTuActivityArg(roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, activityCount - 1, activityCount));
/*     */     
/*     */ 
/* 297 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaotuManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */