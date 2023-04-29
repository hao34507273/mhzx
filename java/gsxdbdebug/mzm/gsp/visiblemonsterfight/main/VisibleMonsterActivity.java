/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.SSyncCommonVisibleMonsterFightTip;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity2.confbean.ControllerId2Time;
/*     */ import mzm.gsp.activity2.confbean.ControllerIdBean;
/*     */ import mzm.gsp.activity2.confbean.MonsterTypeBean;
/*     */ import mzm.gsp.activity2.confbean.SVisibleMonsterInitTriggerCfg;
/*     */ import mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapFightContext;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.monster.confbean.SBrightMonster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.DelayTimeObserver;
/*     */ import xbean.GlobalVisibleMonsterInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2VisibleMonsterInfo;
/*     */ import xbean.VisibleMonsterInfo;
/*     */ import xtable.Role2visiblemonster;
/*     */ import xtable.Visiblemonster;
/*     */ 
/*     */ public class VisibleMonsterActivity
/*     */   implements IMonsterDeadHandle
/*     */ {
/*     */   private final SVisibleMonsterKillMonsterTriggerCfg triggerCfg;
/*     */   private final SVisibleMonsterInitTriggerCfg initTriggerCfg;
/*     */   private final int activityCfgId;
/*     */   private VisibleMonsterFightHandler handler;
/*  52 */   private List<DelayTimeObserver> monsterReliveObserverList = new ArrayList();
/*  53 */   private List<Integer> controllerIdList = new ArrayList();
/*     */   
/*     */   public VisibleMonsterActivity(SVisibleMonsterKillMonsterTriggerCfg triggerCfg, SVisibleMonsterInitTriggerCfg initTriggerCfg) {
/*  56 */     this.triggerCfg = triggerCfg;
/*  57 */     this.activityCfgId = triggerCfg.activity_cfg_id;
/*  58 */     this.initTriggerCfg = initTriggerCfg;
/*  59 */     for (MonsterTypeBean monsterTypeBean : triggerCfg.monsters_type_map.values()) {
/*  60 */       ItemAccessManager.registerActivityReward(this.activityCfgId, monsterTypeBean.monster_kill_award_id);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/*  68 */     int monsterCategoryId = getMonsterCategoryId(context.monsterIdList);
/*  69 */     Integer monsterType; MonsterTypeBean monsterTypeBean; if ((monsterCategoryId < 0) || ((monsterType = (Integer)this.triggerCfg.monsters_category_id2type_map.get(Integer.valueOf(monsterCategoryId))) == null) || ((monsterTypeBean = (MonsterTypeBean)this.triggerCfg.monsters_type_map.get(monsterType)) == null))
/*  70 */       return false;
/*     */     MonsterTypeBean monsterTypeBean;
/*  72 */     Integer monsterType; int nowGlobalKillTimes = addAndGetGlobalMonsterKillTimes(monsterType.intValue(), this.activityCfgId);
/*  73 */     List<Long> roleIdList = context.roleList;
/*  74 */     Map<Long, String> role2user = new HashMap();
/*  75 */     for (Long l : roleIdList) {
/*  76 */       long roleid = l.longValue();
/*  77 */       role2user.put(Long.valueOf(roleid), context.allUsers.get(Long.valueOf(roleid)));
/*     */     }
/*  79 */     String monsterName = SBrightMonster.get(context.monsterCfgId).name;
/*  80 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(role2user, roleIdList, this.activityCfgId);
/*  81 */     if (!result.isCanJoin()) {
/*  82 */       return false;
/*     */     }
/*  84 */     Iterator<Long> iterator = roleIdList.iterator();
/*  85 */     while (iterator.hasNext()) {
/*  86 */       long roleId = ((Long)iterator.next()).longValue();
/*  87 */       String userId = RoleInterface.getUserId(roleId);
/*  88 */       int nowKillTimes = addAndGetRoleMonsterKillTimes(roleId, monsterType.intValue());
/*  89 */       if (nowKillTimes > monsterTypeBean.monster_kill_award_num) {
/*  90 */         iterator.remove();
/*     */       } else {
/*  92 */         ActivityInterface.addActivityCount(userId, roleId, this.activityCfgId);
/*     */       }
/*  94 */       SSyncCommonVisibleMonsterFightTip sSyncCommonVisibleMonsterFightTip = new SSyncCommonVisibleMonsterFightTip();
/*  95 */       sSyncCommonVisibleMonsterFightTip.activity_cfg_id = this.activityCfgId;
/*  96 */       sSyncCommonVisibleMonsterFightTip.monster_category_id = monsterCategoryId;
/*  97 */       sSyncCommonVisibleMonsterFightTip.today_kill_times = nowKillTimes;
/*  98 */       sSyncCommonVisibleMonsterFightTip.today_max_kill_times = monsterTypeBean.monster_kill_award_num;
/*  99 */       OnlineManager.getInstance().sendAtOnce(roleId, sSyncCommonVisibleMonsterFightTip);
/* 100 */       tlogFightVisibleMonsterWin((String)role2user.get(Long.valueOf(roleId)), roleId, RoleInterface.getLevel(roleId), nowKillTimes, this.activityCfgId);
/*     */     }
/* 102 */     for (Long l2 : roleIdList) {
/* 103 */       long roleId2 = l2.longValue();
/* 104 */       AwardInterface.award(monsterTypeBean.monster_kill_award_id, (String)context.allUsers.get(Long.valueOf(roleId2)), roleId2, -1, context.roleList, context.allRoles, false, true, new AwardReason(LogReason.VISIBLE_MONSTER_AWARD));
/*     */     }
/* 106 */     if ((nowGlobalKillTimes <= 0) || (monsterTypeBean.next_controller_need_kill_num <= 0) || (nowGlobalKillTimes % monsterTypeBean.next_controller_need_kill_num != 0)) {
/* 107 */       SendDeadNotice(monsterTypeBean.deadNotice, monsterName);
/* 108 */       return true;
/*     */     }
/* 110 */     long worldId = MapInterface.getCenterWorldid();
/* 111 */     Iterator<ControllerIdBean> i$ = monsterTypeBean.controller_id_list.iterator();
/* 112 */     while (i$.hasNext()) {
/* 113 */       ControllerIdBean controllerIdBean = (ControllerIdBean)i$.next();
/* 114 */       int controllerId = controllerIdBean.controllerId;
/* 115 */       this.controllerIdList.add(Integer.valueOf(controllerId));
/* 116 */       ControllerInterface.triggerController(controllerId);
/* 117 */       SendNotice(monsterTypeBean.bornNotice);
/* 118 */       ControllerInterface.setControllerMaxCount(worldId, controllerId, 1);
/* 119 */       int refreshSeconds = controllerIdBean.refreshSeconds;
/* 120 */       if (refreshSeconds > 0) {
/* 121 */         addReliveObserver(controllerId, refreshSeconds, monsterTypeBean.bornNotice);
/*     */       }
/* 123 */       worldBroadcast(monsterCategoryId, controllerIdBean.triggerMonsterId);
/*     */     }
/* 125 */     SendDeadNotice(monsterTypeBean.deadNotice, monsterName);
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   private void SendDeadNotice(String notice, String name) {
/* 130 */     if (notice != "")
/*     */     {
/* 132 */       String deadNotice = notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>");
/* 133 */       BulletinInterface.sendNotice(deadNotice);
/*     */     }
/*     */   }
/*     */   
/*     */   private void SendNotice(String notice) {
/* 138 */     if (notice != "")
/*     */     {
/* 140 */       String deadNotice = notice.replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>");
/* 141 */       BulletinInterface.sendNotice(deadNotice);
/*     */     }
/*     */   }
/*     */   
/*     */   private void worldBroadcast(int killMonsterId, int triggerMonsterId) {
/* 146 */     SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 147 */     bulletinInfo.bulletintype = 52;
/* 148 */     bulletinInfo.params.put(Integer.valueOf(36), String.valueOf(killMonsterId));
/* 149 */     bulletinInfo.params.put(Integer.valueOf(37), String.valueOf(triggerMonsterId));
/* 150 */     BulletinInterface.sendBulletin(bulletinInfo);
/*     */   }
/*     */   
/*     */   private void addReliveObserver(int controllerId, int refreshSeconds, String notice) {
/* 154 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 155 */     long refreshMillSeconds = refreshSeconds * 1000;
/* 156 */     long currentPassMillSeconds = currentTimeMillis - DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis);
/* 157 */     long deltaPeriod = (currentPassMillSeconds - 1L) / refreshMillSeconds + 1L;
/* 158 */     long delayMillSeconds = deltaPeriod * refreshMillSeconds - currentPassMillSeconds;
/* 159 */     DelayTimeObserver DelayTimeObserver = new VisibleMonsterDelayObserver(controllerId, refreshMillSeconds, true, notice);
/* 160 */     DelayTimeObserver.start(delayMillSeconds);
/* 161 */     this.monsterReliveObserverList.add(DelayTimeObserver);
/*     */   }
/*     */   
/*     */   private int addAndGetRoleMonsterKillTimes(long roleId, int monsterType)
/*     */   {
/* 166 */     Role2VisibleMonsterInfo xRole2VisibleMonsterInfo = Role2visiblemonster.get(Long.valueOf(roleId));
/* 167 */     if (xRole2VisibleMonsterInfo == null) {
/* 168 */       xRole2VisibleMonsterInfo = Pod.newRole2VisibleMonsterInfo();
/* 169 */       Role2visiblemonster.add(Long.valueOf(roleId), xRole2VisibleMonsterInfo);
/*     */     }
/* 171 */     Map<Integer, VisibleMonsterInfo> xActivityCfgId2VisibleMonsterMap = xRole2VisibleMonsterInfo.getActivity_visible_monster_map();
/* 172 */     VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xActivityCfgId2VisibleMonsterMap.get(Integer.valueOf(this.activityCfgId));
/* 173 */     if (xVisibleMonsterInfo == null) {
/* 174 */       xVisibleMonsterInfo = Pod.newVisibleMonsterInfo();
/* 175 */       xActivityCfgId2VisibleMonsterMap.put(Integer.valueOf(this.activityCfgId), xVisibleMonsterInfo);
/*     */     }
/* 177 */     Map<Integer, Integer> xMontser2TypeMap = xVisibleMonsterInfo.getMonster_type_times_map();
/* 178 */     Integer nowKillTimes2 = (Integer)xMontser2TypeMap.get(Integer.valueOf(monsterType));
/* 179 */     Integer nowKillTimes; if (nowKillTimes2 == null) {
/* 180 */       Integer nowKillTimes = new Integer(1);
/* 181 */       xMontser2TypeMap.put(Integer.valueOf(monsterType), nowKillTimes);
/*     */     } else {
/* 183 */       nowKillTimes = Integer.valueOf(nowKillTimes2.intValue() + 1);
/* 184 */       xMontser2TypeMap.put(Integer.valueOf(monsterType), nowKillTimes);
/*     */     }
/* 186 */     return nowKillTimes.intValue();
/*     */   }
/*     */   
/*     */   public boolean handleMonsterWin(VisibleMonsterFightContext context)
/*     */   {
/* 191 */     for (Long l : context.allRoles) {
/* 192 */       long roleId = l.longValue();
/* 193 */       tlogFightVisibleMonsterFail((String)context.allUsers.get(Long.valueOf(roleId)), roleId, RoleInterface.getLevel(roleId), this.activityCfgId);
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   private int getMonsterCategoryId(List<Integer> monsterCfgIdList) {
/* 199 */     for (Integer num : monsterCfgIdList) {
/* 200 */       int monsterCfgId = num.intValue();
/* 201 */       int monsterCategoryId = MonsterInterface.getMonsterCategoryId(monsterCfgId);
/* 202 */       if (this.triggerCfg.monsters_category_id2type_map.containsKey(Integer.valueOf(monsterCategoryId))) {
/* 203 */         return monsterCategoryId;
/*     */       }
/*     */     }
/* 206 */     return -1;
/*     */   }
/*     */   
/*     */   public void stopVisibleMonsterActivity() {
/* 210 */     for (Integer controllerId : this.controllerIdList) {
/* 211 */       ControllerInterface.collectController(controllerId.intValue());
/*     */     }
/* 213 */     MapInterface.unregisterMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/* 214 */     this.handler = null;
/* 215 */     for (DelayTimeObserver delayTimeObserver : this.monsterReliveObserverList) {
/* 216 */       delayTimeObserver.stop();
/*     */     }
/* 218 */     this.controllerIdList.clear();
/* 219 */     this.monsterReliveObserverList.clear();
/*     */   }
/*     */   
/*     */   public void startVisibleMonsterActivity() {
/* 223 */     int idipModuleSwitchId = this.initTriggerCfg.idip_module_switch_id;
/* 224 */     if (OpenInterface.getOpenStatus(idipModuleSwitchId)) {
/* 225 */       long worldId = MapInterface.getCenterWorldid();
/* 226 */       Iterator<ControllerId2Time> i$ = this.initTriggerCfg.controller_id_list.iterator();
/* 227 */       while (i$.hasNext()) {
/* 228 */         ControllerId2Time controllerId2Time = (ControllerId2Time)i$.next();
/* 229 */         int controllerId = controllerId2Time.controllerId;
/* 230 */         ControllerInterface.triggerController(controllerId);
/* 231 */         ControllerInterface.setControllerMaxCount(worldId, controllerId, 1);
/* 232 */         SendNotice(controllerId2Time.bornNotice);
/* 233 */         this.controllerIdList.add(Integer.valueOf(controllerId));
/* 234 */         int refreshSeconds = controllerId2Time.refreshSeconds;
/* 235 */         if (refreshSeconds > 0) {
/* 236 */           addReliveObserver(controllerId, refreshSeconds, controllerId2Time.bornNotice);
/*     */         }
/*     */       }
/* 239 */       this.handler = new VisibleMonsterFightHandler(FightReason.VISIBLE_MONSTER_PVE, 203, this.activityCfgId)
/*     */       {
/*     */         public int startFight(long roleId, int fightId, MapFightContext context) {
/* 242 */           if (!RoleStatusInterface.checkCanSetStatus(roleId, 521, true)) {
/* 243 */             return 5;
/*     */           }
/* 245 */           return super.startFight(roleId, fightId, context);
/*     */         }
/* 247 */       };
/* 248 */       MapInterface.registerMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/* 249 */       for (Integer num : this.triggerCfg.monsters_category_id2type_map.keySet()) {
/* 250 */         int monsterCategoryId = num.intValue();
/* 251 */         this.handler.addGroupId(monsterCategoryId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void clearGlobalMonsterKillTimes(int activityCfgId) {
/* 257 */     GlobalVisibleMonsterInfo xGlobalVisibleMonsterInfo = Visiblemonster.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 258 */     if (xGlobalVisibleMonsterInfo != null) {
/* 259 */       Map<Integer, VisibleMonsterInfo> xVisibleMonsterInfoMap = xGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 260 */       VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xVisibleMonsterInfoMap.get(Integer.valueOf(activityCfgId));
/* 261 */       if (xVisibleMonsterInfo != null) {
/* 262 */         xVisibleMonsterInfo.getMonster_type_times_map().clear();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static int addAndGetGlobalMonsterKillTimes(int monsterType, int activityCfgId)
/*     */   {
/* 269 */     GlobalVisibleMonsterInfo xGlobalVisibleMonsterInfo = Visiblemonster.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 270 */     if (xGlobalVisibleMonsterInfo == null) {
/* 271 */       xGlobalVisibleMonsterInfo = Pod.newGlobalVisibleMonsterInfo();
/* 272 */       Visiblemonster.add(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalVisibleMonsterInfo);
/*     */     }
/* 274 */     Map<Integer, VisibleMonsterInfo> xVisibleMonsterInfoMap = xGlobalVisibleMonsterInfo.getActivity_visible_monster_map();
/* 275 */     VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xVisibleMonsterInfoMap.get(Integer.valueOf(activityCfgId));
/* 276 */     if (xVisibleMonsterInfo == null) {
/* 277 */       xVisibleMonsterInfo = Pod.newVisibleMonsterInfo();
/* 278 */       xVisibleMonsterInfoMap.put(Integer.valueOf(activityCfgId), xVisibleMonsterInfo);
/*     */     }
/* 280 */     Map<Integer, Integer> xType2TimesMap = xVisibleMonsterInfo.getMonster_type_times_map();
/* 281 */     Integer globalKillTimes2 = (Integer)xType2TimesMap.get(Integer.valueOf(monsterType));
/* 282 */     Integer globalKillTimes; if (globalKillTimes2 == null) {
/* 283 */       Integer globalKillTimes = new Integer(1);
/* 284 */       xType2TimesMap.put(Integer.valueOf(monsterType), globalKillTimes);
/*     */     } else {
/* 286 */       globalKillTimes = Integer.valueOf(globalKillTimes2.intValue() + 1);
/* 287 */       xType2TimesMap.put(Integer.valueOf(monsterType), globalKillTimes);
/*     */     }
/* 289 */     return globalKillTimes.intValue();
/*     */   }
/*     */   
/*     */   static void tlogFightVisibleMonsterWin(String userId, long roleId, int roleLevel, int times, int activityCfgId) {
/* 293 */     StringBuilder sbLog = new StringBuilder();
/* 294 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 295 */     sbLog.append(userId).append('|');
/* 296 */     sbLog.append(roleId).append('|');
/* 297 */     sbLog.append(roleLevel).append('|');
/* 298 */     sbLog.append(times).append('|');
/* 299 */     sbLog.append(activityCfgId);
/* 300 */     TLogManager.getInstance().addLog(roleId, "VisibleMonsterWinStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */   static void tlogFightVisibleMonsterFail(String userId, long roleId, int roleLevel, int activityCfgId) {
/* 304 */     StringBuilder sbLog = new StringBuilder();
/* 305 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 306 */     sbLog.append(userId).append('|');
/* 307 */     sbLog.append(roleId).append('|');
/* 308 */     sbLog.append(roleLevel).append('|');
/* 309 */     sbLog.append(activityCfgId);
/* 310 */     TLogManager.getInstance().addLog(roleId, "VisibleMonsterFailStatis", sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void init() {}
/*     */   
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 335 */     return null;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/* 340 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */