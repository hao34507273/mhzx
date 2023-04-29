/*     */ package mzm.gsp.watchmoon.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.group.MapGroupType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.watchmoon.SWatchmoonSuccessRes;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonRewardCfg;
/*     */ import mzm.gsp.watchmoon.event.WatchMoonFinishArg;
/*     */ import mzm.gsp.watchmoon.event.WatchMoonFinishEvent;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Watchmoon;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2watchmoon;
/*     */ import xtable.User;
/*     */ 
/*     */ public class WatchMoonSession extends Session
/*     */ {
/*  39 */   final List<Long> roleids = new ArrayList();
/*     */   
/*     */   private final int mapId;
/*     */   private final long endTime;
/*     */   
/*     */   public WatchMoonSession(long interval, int mapId, List<Long> roleids)
/*     */   {
/*  46 */     super(interval, ((Long)roleids.get(0)).longValue());
/*  47 */     this.roleids.addAll(roleids);
/*  48 */     this.mapId = mapId;
/*     */     
/*  50 */     this.endTime = (DateTimeUtils.getCurrTimeInMillis() + TimeUnit.SECONDS.toMillis(interval));
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  56 */     new WatchMoonFinishPro(this.mapId, this.roleids).execute();
/*     */   }
/*     */   
/*     */   private static class WatchMoonFinishPro
/*     */     extends mzm.gsp.util.LogicProcedure implements MapCallback<Boolean>
/*     */   {
/*     */     private final int mapId;
/*     */     private final List<Long> roleids;
/*     */     
/*     */     public WatchMoonFinishPro(int mapId, List<Long> roleids)
/*     */     {
/*  67 */       this.mapId = mapId;
/*  68 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  75 */       MapInterface.isNearByPos(this.roleids, this.mapId, SWatchmoonMapCfg.get(this.mapId).endposX, SWatchmoonMapCfg.get(this.mapId).endposY, SWatchmoonMapCfg.get(this.mapId).distance, this);
/*     */       
/*  77 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/*  85 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onResult(Boolean result)
/*     */     {
/*  91 */       Map<Long, String> roleid2useridMap = new HashMap();
/*  92 */       for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  94 */         String userid = RoleInterface.getUserId(roleid);
/*  95 */         roleid2useridMap.put(Long.valueOf(roleid), userid);
/*     */       }
/*  97 */       Lockeys.lock(Lockeys.get(User.getTable(), roleid2useridMap.values()));
/*     */       
/*  99 */       Lockeys.lock(Role2watchmoon.getTable(), roleid2useridMap.keySet());
/*     */       
/* 101 */       if ((result == null) || (!result.booleanValue()))
/*     */       {
/* 103 */         String logstr = String.format("[watchmoon]WatchMoonFinishPro.onResult@watch moon failed,not at the position|roleids=%s", new Object[] { this.roleids.toString() });
/*     */         
/*     */ 
/* 106 */         WatchmoonManager.logger.info(logstr);
/*     */         
/* 108 */         WatchmoonManager.doWatchMoonFailed(this.roleids);
/* 109 */         return true;
/*     */       }
/*     */       
/* 112 */       AwardReason reason = new AwardReason(LogReason.WATCH_MOON_ACTIVITY_AWARD);
/*     */       
/* 114 */       boolean isFailed = false;
/* 115 */       long groupid = 0L;
/* 116 */       boolean iscouple = false;
/* 117 */       Set<Long> partenerRoleIds = new HashSet();
/* 118 */       for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 120 */         Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 121 */         if (xWatchmoon == null)
/*     */         {
/* 123 */           String logstr = String.format("[watchmoon]WatchMoonFinishPro.onResult@watch moon failed,xbean.Watchmoon null|roleids=%s", new Object[] { this.roleids.toString() });
/*     */           
/*     */ 
/* 126 */           WatchmoonManager.logger.error(logstr);
/*     */           
/* 128 */           isFailed = true;
/* 129 */           break;
/*     */         }
/* 131 */         partenerRoleIds.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/* 132 */         groupid = xWatchmoon.getGroupid();
/* 133 */         iscouple = xWatchmoon.getIscouple();
/*     */       }
/* 135 */       if ((isFailed) || (partenerRoleIds.size() != this.roleids.size()) || (!partenerRoleIds.containsAll(this.roleids)))
/*     */       {
/*     */ 
/* 138 */         WatchmoonManager.doWatchMoonFailed(this.roleids);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 143 */         doSuccess(roleid2useridMap, reason, groupid, iscouple);
/* 144 */         TriggerEventsManger.getInstance().triggerEvent(new WatchMoonFinishEvent(), new WatchMoonFinishArg(this.roleids));
/*     */       }
/*     */       
/* 147 */       return true;
/*     */     }
/*     */     
/*     */     private void doSuccess(Map<Long, String> roleid2useridMap, AwardReason reason, long groupid, boolean iscouple)
/*     */     {
/* 152 */       boolean isRemovedGroup = false;
/*     */       Iterator i$;
/*     */       try {
/* 155 */         ActivityInterface.canJoinAndCheckInitActivityData(roleid2useridMap, this.roleids, SWatchmoonConsts.getInstance().ACTIVITY_ID);
/*     */         
/*     */ 
/* 158 */         for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 161 */           Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 162 */           int activityCount = ActivityInterface.getActivityCount((String)roleid2useridMap.get(Long.valueOf(roleid)), roleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true);
/*     */           
/*     */ 
/* 165 */           if (activityCount >= SWatchmoonConsts.getInstance().MAX_AWARD_COUNT)
/*     */           {
/* 167 */             ActivityInterface.addActivityCount((String)roleid2useridMap.get(Long.valueOf(roleid)), roleid, SWatchmoonConsts.getInstance().ACTIVITY_ID);
/*     */             
/* 169 */             String logstr = String.format("[watchmoon]WatchMoonFinishPro.doSuccess@watch moon award count to max|roleid=%d|level=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(RoleInterface.getLevel(roleid)), Integer.valueOf(activityCount + 1) });
/*     */             
/*     */ 
/* 172 */             WatchmoonManager.logger.info(logstr);
/*     */           }
/*     */           else
/*     */           {
/* 176 */             SWatchmoonRewardCfg watchmoonRewardCfg = SWatchmoonRewardCfg.get(activityCount + 1);
/*     */             
/* 178 */             if (watchmoonRewardCfg != null)
/*     */             {
/* 180 */               int rewardId = watchmoonRewardCfg.rewardId;
/*     */               
/* 182 */               mzm.gsp.award.main.AwardModel model = AwardInterface.award(rewardId, (String)roleid2useridMap.get(Long.valueOf(roleid)), roleid, false, true, reason);
/*     */               
/* 184 */               if (model != null)
/*     */               {
/* 186 */                 ActivityInterface.addActivityCount((String)roleid2useridMap.get(Long.valueOf(roleid)), roleid, SWatchmoonConsts.getInstance().ACTIVITY_ID);
/*     */                 
/* 188 */                 String logstr = String.format("[watchmoon]WatchMoonFinishPro.doSuccess@award watch moon success|roleid=%d|level=%d|rewardid=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(RoleInterface.getLevel(roleid)), Integer.valueOf(rewardId), Integer.valueOf(activityCount + 1) });
/*     */                 
/*     */ 
/* 191 */                 WatchmoonManager.logger.info(logstr);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 196 */                 String logstr = String.format("[watchmoon]WatchMoonFinishPro.doSuccess@award watch moon failed,awardmodel null|roleid=%d|level=%d|rewardid=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(RoleInterface.getLevel(roleid)), Integer.valueOf(rewardId), Integer.valueOf(activityCount) });
/*     */                 
/*     */ 
/* 199 */                 WatchmoonManager.logger.error(logstr);
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 204 */               String logstr = String.format("[watchmoon]WatchMoonFinishPro.doSuccess@award watch moon failed,reward id error null|roleid=%d|level=%d|count=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(RoleInterface.getLevel(roleid)), Integer.valueOf(activityCount + 1) });
/*     */               
/*     */ 
/* 207 */               WatchmoonManager.logger.info(logstr);
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 212 */           SWatchmoonSuccessRes watchSuccess = new SWatchmoonSuccessRes();
/* 213 */           watchSuccess.activitycount = (activityCount + 1);
/* 214 */           watchSuccess.partnername = RoleInterface.getName(xWatchmoon.getPartenerroleid());
/* 215 */           watchSuccess.partnerroleid = xWatchmoon.getPartenerroleid();
/* 216 */           OnlineManager.getInstance().send(roleid, watchSuccess);
/* 217 */           ActivityInterface.tlogActivity(roleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */           
/* 219 */           Role2watchmoon.remove(Long.valueOf(roleid));
/* 220 */           RoleStatusInterface.unsetStatus(roleid, 28);
/*     */         }
/*     */         
/* 223 */         if (iscouple)
/*     */         {
/*     */ 
/* 226 */           MapInterface.removeMapGroup(MapGroupType.MGT_WATCH_MOON_XYXW_FLY, groupid, this.roleids);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 231 */           MapInterface.removeMapGroup(MapGroupType.MGT_WATCH_MOON_SIDE_BY_SIDE_FLY, groupid, this.roleids);
/*     */         }
/*     */         
/* 234 */         WatchmoonManager.tlogWatchMoon(((Long)this.roleids.get(0)).longValue(), ActivityInterface.getActivityCount((String)roleid2useridMap.get(this.roleids.get(0)), ((Long)this.roleids.get(0)).longValue(), SWatchmoonConsts.getInstance().ACTIVITY_ID, true), ((Long)this.roleids.get(1)).longValue(), RoleInterface.getLevel(((Long)this.roleids.get(1)).longValue()), ActivityInterface.getActivityCount((String)roleid2useridMap.get(this.roleids.get(1)), ((Long)this.roleids.get(1)).longValue(), SWatchmoonConsts.getInstance().ACTIVITY_ID, true), WatchmoonOperateEnum.SUCCESS.value);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 240 */         isRemovedGroup = true;
/*     */       } finally {
/*     */         Iterator i$;
/*     */         long roleid;
/* 244 */         if (!isRemovedGroup)
/*     */         {
/* 246 */           RoleStatusInterface.unsetStatus(this.roleids, 28);
/* 247 */           for (i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/* 249 */             MapInterface.removeMapGroupByRoleid(roleid);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getWatchMoonEndtime()
/*     */   {
/* 263 */     return this.endTime;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\WatchMoonSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */