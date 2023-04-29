/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.RoleInfo;
/*     */ import mzm.gsp.activity.SSynPlayerLoseFightRes;
/*     */ import mzm.gsp.activity.SSynPlayerWinFightRes;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapFightContext;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.StarLevelWrapper;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.MonsterStarLevelBean;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SBeastFightRewardModify;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.YaoShouTuXiStartLevelCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class YaoShouTuXIActivity
/*     */   extends MonsterFightActivity
/*     */ {
/*  45 */   private Map<Integer, Map<Integer, Integer>> monsterId2startLv2awardMap = new HashMap();
/*     */   private VisibleMonsterFightHandler handler;
/*     */   
/*     */   public YaoShouTuXIActivity() {
/*  49 */     this.reason = new AwardReason(LogReason.YAOSHOUTUXI_ACTIVITY_ADD);
/*  50 */     this.activityType = 1;
/*  51 */     for (YaoShouTuXiStartLevelCfg cfg : YaoShouTuXiStartLevelCfg.getAll().values()) {
/*  52 */       List<StarLevelWrapper> wrappers = new ArrayList();
/*  53 */       Map<Integer, Integer> lv2aw = new HashMap();
/*  54 */       Map<Integer, String> lv2name = new HashMap();
/*  55 */       for (MonsterStarLevelBean bean : cfg.starLevelList) {
/*  56 */         wrappers.add(new StarLevelWrapper(bean.monsterName, bean.fightId, bean.startLevel));
/*  57 */         lv2aw.put(Integer.valueOf(bean.startLevel), Integer.valueOf(bean.awardTypeId));
/*  58 */         lv2name.put(Integer.valueOf(bean.startLevel), bean.monsterName);
/*     */       }
/*  60 */       this.monsterId2startLv2awardMap.put(Integer.valueOf(cfg.visibleMonsterId), lv2aw);
/*  61 */       MapInterface.setMonsterStarLevel(cfg.visibleMonsterId, wrappers);
/*     */     }
/*  63 */     ActivityInterface.registerActivityByLogicType(12, this);
/*  64 */     ActivityCompensateInterface.registerCompensateHandler(12, new YaoShouTuXiActivityCompensateHandler());
/*     */     
/*  66 */     ItemAccessManager.registerActivityReward(SYaoShouTuXiConsts.getInstance().ACTIVITYID, SYaoShouTuXiConsts.getInstance().AWARD_ID1);
/*     */     
/*  68 */     ItemAccessManager.registerActivityReward(SYaoShouTuXiConsts.getInstance().ACTIVITYID, SYaoShouTuXiConsts.getInstance().AWARD_ID2);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getModifyId(Collection<Long> roleIdSet, long roleId)
/*     */   {
/*  74 */     int level = RoleInterface.getLevel(roleId);
/*  75 */     int averageLv = level - getTeamAverageLevel(roleIdSet);
/*  76 */     for (SBeastFightRewardModify modify : SBeastFightRewardModify.getAll().values()) {
/*  77 */       if ((modify.lowTeamAverageLevel <= averageLv) && (modify.highTeamAverageLevel >= averageLv))
/*     */       {
/*     */ 
/*  80 */         return modify.modifyValueTableId; }
/*     */     }
/*  82 */     return -1;
/*     */   }
/*     */   
/*     */   public int getRewardLimit()
/*     */   {
/*  87 */     return SYaoShouTuXiConsts.getInstance().REWARD_LIMIT;
/*     */   }
/*     */   
/*     */   public int getActivity()
/*     */   {
/*  92 */     return SYaoShouTuXiConsts.getInstance().ACTIVITYID;
/*     */   }
/*     */   
/*     */   private boolean isMax(int monsterId, int startLevel) {
/*  96 */     Map<Integer, Integer> monster = (Map)this.monsterId2startLv2awardMap.get(Integer.valueOf(monsterId));
/*  97 */     if (monster == null)
/*  98 */       return true;
/*  99 */     if (!monster.containsKey(Integer.valueOf(startLevel + 1))) {
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterWin(VisibleMonsterFightContext context)
/*     */   {
/* 107 */     if (super.handleMonsterWin(context)) {
/* 108 */       if (context.monsterCfgId <= 0) {
/* 109 */         return true;
/*     */       }
/* 111 */       if (!this.monsterId2startLv2awardMap.containsKey(Integer.valueOf(context.monsterCfgId))) {
/* 112 */         return true;
/*     */       }
/*     */       
/* 115 */       SSynPlayerLoseFightRes synPlayerLoseFightRes = new SSynPlayerLoseFightRes();
/* 116 */       synPlayerLoseFightRes.mapcfgid = context.sceneId;
/* 117 */       synPlayerLoseFightRes.monsterid = context.monsterCfgId;
/* 118 */       if (context.starLevel != null) {
/* 119 */         synPlayerLoseFightRes.start = context.starLevel.intValue();
/* 120 */         if (!isMax(context.monsterCfgId, context.starLevel.intValue())) {
/* 121 */           synPlayerLoseFightRes.nextstart = (context.starLevel.intValue() + 1);
/*     */         } else {
/* 123 */           synPlayerLoseFightRes.nextstart = context.starLevel.intValue();
/*     */         }
/*     */       }
/*     */       
/* 127 */       for (Iterator i$ = context.allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 128 */         RoleInfo roleInfo = new RoleInfo();
/* 129 */         roleInfo.rolename = RoleInterface.getName(roleid);
/* 130 */         synPlayerLoseFightRes.roleinfos.add(roleInfo);
/*     */       }
/* 132 */       OnlineManager.getInstance().sendAll(synPlayerLoseFightRes);
/*     */       
/* 134 */       return true;
/*     */     }
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/* 141 */     if (super.handleMonsterDead(context)) {
/* 142 */       if (context.monsterCfgId <= 0) {
/* 143 */         return true;
/*     */       }
/* 145 */       if (!this.monsterId2startLv2awardMap.containsKey(Integer.valueOf(context.monsterCfgId))) {
/* 146 */         return true;
/*     */       }
/* 148 */       SSynPlayerWinFightRes synPlayerWinFightRes = new SSynPlayerWinFightRes();
/* 149 */       synPlayerWinFightRes.mapcfgid = context.sceneId;
/* 150 */       synPlayerWinFightRes.monsterid = context.monsterCfgId;
/* 151 */       if (context.starLevel != null) {
/* 152 */         synPlayerWinFightRes.start = context.starLevel.intValue();
/*     */       } else {
/* 154 */         GameServer.logger().error(String.format("[YaoShouTuXIActivity]YaoShouTuXIActivity.handleMonsterDead@妖兽星级为null|monstercfgid=%d|fightid=%d", new Object[] { Integer.valueOf(context.monsterCfgId), Integer.valueOf(context.fightId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 160 */       for (Iterator i$ = context.allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 161 */         RoleInfo roleInfo = new RoleInfo();
/* 162 */         roleInfo.rolename = RoleInterface.getName(roleid);
/* 163 */         synPlayerWinFightRes.roleinfos.add(roleInfo);
/*     */       }
/* 165 */       OnlineManager.getInstance().sendAll(synPlayerWinFightRes);
/* 166 */       return true;
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/* 173 */     this.handler = new VisibleMonsterFightHandler(FightReason.YAOSHOUTUXI_FIGHT, 96, activityid)
/*     */     {
/*     */       public int startFight(long roleId, int fightId, MapFightContext context)
/*     */       {
/* 177 */         if (!RoleStatusInterface.checkCanSetStatus(roleId, 94, true)) {
/* 178 */           return 5;
/*     */         }
/* 180 */         return super.startFight(roleId, fightId, context);
/*     */       }
/* 182 */     };
/* 183 */     this.handler.addGroupId(getVisibleMonsterId1());
/* 184 */     this.handler.addGroupId(getVisibleMonsterId2());
/* 185 */     long worldId = MapInterface.getCenterWorldid();
/* 186 */     MapInterface.registerMonsterFightHandler(worldId, this.handler);
/* 187 */     ControllerInterface.triggerController(SYaoShouTuXiConsts.getInstance().CONTROLLERID1);
/* 188 */     ControllerInterface.setControllerMaxCount(worldId, SYaoShouTuXiConsts.getInstance().CONTROLLERID1, 1);
/* 189 */     ControllerInterface.triggerController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 190 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 191 */     sBulletinInfo.bulletintype = 10;
/* 192 */     BulletinInterface.sendBulletin(sBulletinInfo);
/* 193 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 194 */     long interval = DateTimeUtils.getBeginTimeOfNextHour(now) - now;
/* 195 */     if (interval > 0L)
/*     */     {
/* 197 */       new MilliSession(interval, 0L)
/*     */       {
/*     */ 
/*     */         protected void onTimeOut()
/*     */         {
/*     */ 
/* 203 */           if (GameServer.logger().isDebugEnabled())
/*     */           {
/* 205 */             GameServer.logger().debug("怪物复活");
/*     */           }
/* 207 */           ControllerInterface.triggerOrReSpawn(MapInterface.getCenterWorldid(), SYaoShouTuXiConsts.getInstance().CONTROLLERID1, 1);
/*     */           
/* 209 */           YaoShouTuXIActivity.this.observer = new MonsterReliveObserver(TimeUnit.SECONDS.toMillis(SYaoShouTuXiConsts.getInstance().REFRESH_INTERVAL1_SEC), SYaoShouTuXiConsts.getInstance().CONTROLLERID1);
/*     */         }
/*     */         
/*     */ 
/* 213 */       };
/* 214 */       new MilliSession(interval, 0L)
/*     */       {
/*     */ 
/*     */         protected void onTimeOut()
/*     */         {
/*     */ 
/* 220 */           if (GameServer.logger().isDebugEnabled())
/*     */           {
/* 222 */             GameServer.logger().debug("怪物复活");
/*     */           }
/* 224 */           ControllerInterface.collectController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 225 */           ControllerInterface.triggerController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 226 */           YaoShouTuXIActivity.this.starObserver = new MilliObserver(TimeUnit.SECONDS.toMillis(SYaoShouTuXiConsts.getInstance().REFRESH_INTERVAL2_SEC))
/*     */           {
/*     */ 
/*     */             public boolean update()
/*     */             {
/*     */ 
/* 232 */               if (GameServer.logger().isDebugEnabled())
/*     */               {
/* 234 */                 GameServer.logger().debug("怪物复活");
/*     */               }
/* 236 */               ControllerInterface.collectController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 237 */               ControllerInterface.triggerController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 238 */               return true;
/*     */             }
/*     */           };
/*     */         }
/*     */       };
/*     */     }
/*     */     else
/*     */     {
/* 246 */       this.observer = new MonsterReliveObserver(TimeUnit.SECONDS.toMillis(SYaoShouTuXiConsts.getInstance().REFRESH_INTERVAL1_SEC), SYaoShouTuXiConsts.getInstance().CONTROLLERID1);
/*     */       
/*     */ 
/* 249 */       this.starObserver = new MilliObserver(TimeUnit.SECONDS.toMillis(SYaoShouTuXiConsts.getInstance().REFRESH_INTERVAL2_SEC))
/*     */       {
/*     */ 
/*     */         public boolean update()
/*     */         {
/* 254 */           ControllerInterface.collectController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 255 */           ControllerInterface.triggerController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 256 */           return true;
/*     */         }
/*     */       };
/*     */     }
/*     */   }
/*     */   
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 264 */     if (this.observer != null) {
/* 265 */       this.observer.stopTimer();
/* 266 */       this.observer = null;
/*     */     }
/* 268 */     if (this.starObserver != null) {
/* 269 */       this.starObserver.stopTimer();
/* 270 */       this.starObserver = null;
/*     */     }
/* 272 */     ControllerInterface.collectController(SYaoShouTuXiConsts.getInstance().CONTROLLERID1);
/* 273 */     ControllerInterface.collectController(SYaoShouTuXiConsts.getInstance().CONTROLLERID2);
/* 274 */     MapInterface.unregisterMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/* 275 */     this.handler = null;
/*     */   }
/*     */   
/*     */   public int getAwardId1(VisibleMonsterFightContext context)
/*     */   {
/* 280 */     if (context.starLevel != null) {
/* 281 */       Map<Integer, Integer> lv2aw = (Map)this.monsterId2startLv2awardMap.get(Integer.valueOf(context.monsterCfgId));
/* 282 */       if (lv2aw != null) {
/* 283 */         return ((Integer)lv2aw.get(context.starLevel)).intValue();
/*     */       }
/*     */     }
/* 286 */     return SYaoShouTuXiConsts.getInstance().AWARD_ID1;
/*     */   }
/*     */   
/*     */   public int getAwardId2(VisibleMonsterFightContext context)
/*     */   {
/* 291 */     if (context.starLevel != null) {
/* 292 */       return -1;
/*     */     }
/* 294 */     return SYaoShouTuXiConsts.getInstance().AWARD_ID2;
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
/*     */   private MonsterReliveObserver observer;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private MilliObserver starObserver;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getVisibleMonsterId2()
/*     */   {
/* 335 */     return SYaoShouTuXiConsts.getInstance().VISIBLE_MONSTER_ID2;
/*     */   }
/*     */   
/*     */   public int getVisibleMonsterId1()
/*     */   {
/* 340 */     return SYaoShouTuXiConsts.getInstance().VISIBLE_MONSTER_ID1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\YaoShouTuXIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */