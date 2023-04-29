/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SLuanShiYaoMoControll;
/*     */ import mzm.gsp.activity.confbean.SMonsterLevelAwardCfg;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapFightContext;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SDeamonFightRewardModify;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*     */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMo;
/*     */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LuanShiYaoMoActivity
/*     */   extends MonsterFightActivity
/*     */ {
/*  41 */   private static Map<Integer, MonsterReliveObserver> controller2ObserverMap = null;
/*     */   private VisibleMonsterFightHandler handler;
/*     */   private MonsterReliveObserver observer;
/*     */   
/*  45 */   public LuanShiYaoMoActivity() throws Exception { this.reason = new AwardReason(LogReason.LUANSHIYAOMO_ACTIVITY_ADD);
/*  46 */     ActivityInterface.registerActivityByLogicType(10, this);
/*  47 */     ActivityCompensateInterface.registerCompensateHandler(10, new LuanShiYaoMoActivityCompensateHandler());
/*     */     
/*  49 */     ItemAccessManager.registerActivityReward(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, SLuanShiYaoMoConsts.getInstance().AWARD_ID1);
/*     */     
/*  51 */     ItemAccessManager.registerActivityReward(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, SLuanShiYaoMoConsts.getInstance().AWARD_ID2);
/*     */     
/*  53 */     for (SMonsterLevelAwardCfg cfg : SMonsterLevelAwardCfg.getAll().values()) {
/*  54 */       if (cfg.activityId == SLuanShiYaoMoConsts.getInstance().ACTIVITYID) {
/*  55 */         ItemAccessManager.registerActivityReward(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, cfg.awardTypeId1);
/*     */         
/*  57 */         ItemAccessManager.registerActivityReward(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, cfg.awardTypeId2);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getModifyId(Collection<Long> roleIdSet, long roleId)
/*     */   {
/*  65 */     int level = RoleInterface.getLevel(roleId);
/*  66 */     int averageLv = level - getTeamAverageLevel(roleIdSet);
/*     */     
/*  68 */     for (SDeamonFightRewardModify modify : SDeamonFightRewardModify.getAll().values()) {
/*  69 */       if ((modify.lowTeamAverageLevel <= averageLv) && (modify.highTeamAverageLevel >= averageLv))
/*     */       {
/*     */ 
/*  72 */         return modify.modifyValueTableId; }
/*     */     }
/*  74 */     return -1;
/*     */   }
/*     */   
/*     */   public int getRewardLimit()
/*     */   {
/*  79 */     return SLuanShiYaoMoConsts.getInstance().REWARD_LIMIT;
/*     */   }
/*     */   
/*     */   public int getActivity()
/*     */   {
/*  84 */     return SLuanShiYaoMoConsts.getInstance().ACTIVITYID;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  89 */     if (!OpenInterface.getOpenStatus(59)) {
/*  90 */       return;
/*     */     }
/*  92 */     this.handler = new VisibleMonsterFightHandler(FightReason.LUANSHIYAOMO_FIGHT, 61, activityid)
/*     */     {
/*     */       public int startFight(long roleId, int fightId, MapFightContext context)
/*     */       {
/*  96 */         if (!RoleStatusInterface.checkCanSetStatus(roleId, 93, true)) {
/*  97 */           return 5;
/*     */         }
/*  99 */         return super.startFight(roleId, fightId, context);
/*     */       }
/* 101 */     };
/* 102 */     this.handler.addGroupId(getVisibleMonsterId1());
/* 103 */     this.handler.addGroupId(getVisibleMonsterId2());
/* 104 */     MapInterface.registerMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/*     */     
/* 106 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 107 */     controller2ObserverMap = new HashMap();
/*     */     
/* 109 */     long worldId = MapInterface.getCenterWorldid();
/* 110 */     for (SLuanShiYaoMoControll sLuanShiYaoMoControll : SLuanShiYaoMoControll.getAll().values()) {
/* 111 */       if (serverLevel >= sLuanShiYaoMoControll.serverLevel) {
/* 112 */         ControllerInterface.triggerController(sLuanShiYaoMoControll.controllerId);
/* 113 */         ControllerInterface.setControllerMaxCount(worldId, sLuanShiYaoMoControll.controllerId, 1);
/* 114 */         this.observer = new MonsterReliveObserver(TimeUnit.SECONDS.toMillis(SLuanShiYaoMoConsts.getInstance().REFRESH_INTERVAL_SEC), sLuanShiYaoMoControll.controllerId);
/*     */         
/*     */ 
/* 117 */         controller2ObserverMap.put(Integer.valueOf(sLuanShiYaoMoControll.controllerId), this.observer);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 125 */     MapInterface.unregisterMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/* 126 */     this.handler = null;
/*     */     
/* 128 */     if (controller2ObserverMap != null) {
/* 129 */       for (Map.Entry<Integer, MonsterReliveObserver> entry : controller2ObserverMap.entrySet()) {
/* 130 */         if (entry.getValue() != null) {
/* 131 */           ((MonsterReliveObserver)entry.getValue()).stopTimer();
/* 132 */           ControllerInterface.collectController(((Integer)entry.getKey()).intValue());
/*     */         }
/*     */       }
/* 135 */       controller2ObserverMap.clear();
/* 136 */       controller2ObserverMap = null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/* 144 */     boolean ret = super.handleMonsterDead(context);
/* 145 */     if (ret)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 150 */       KillLuanShiYaoMoArg arg = new KillLuanShiYaoMoArg();
/* 151 */       arg.monsterCfgId = context.monsterCfgId;
/* 152 */       arg.roleIds.addAll(context.roleList);
/* 153 */       for (Iterator i$ = context.roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 154 */         int activityCount = ActivityInterface.getActivityCount((String)context.allUsers.get(Long.valueOf(roleid)), roleid, SLuanShiYaoMoConsts.getInstance().ACTIVITYID, false);
/*     */         
/* 156 */         arg.role2FinishCountMap.put(Long.valueOf(roleid), Integer.valueOf(activityCount));
/*     */       }
/* 158 */       TriggerEventsManger.getInstance().triggerEvent(new KillLuanShiYaoMo(), arg);
/*     */     }
/* 160 */     return ret;
/*     */   }
/*     */   
/*     */   public int getAwardId1(VisibleMonsterFightContext context)
/*     */   {
/* 165 */     int awardId = VisibleMonsterFightManager.getAwardId(getActivity(), context.enterFightLowLevel);
/* 166 */     if (awardId > 0)
/* 167 */       return awardId;
/* 168 */     return SLuanShiYaoMoConsts.getInstance().AWARD_ID1;
/*     */   }
/*     */   
/*     */   public int getAwardId2(VisibleMonsterFightContext context)
/*     */   {
/* 173 */     int awardId = VisibleMonsterFightManager.getAwardId2(getActivity(), context.enterFightLowLevel);
/* 174 */     if (awardId > 0)
/* 175 */       return awardId;
/* 176 */     return SLuanShiYaoMoConsts.getInstance().AWARD_ID2;
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
/*     */   public int getVisibleMonsterId1()
/*     */   {
/* 200 */     return SLuanShiYaoMoConsts.getInstance().VISIBLE_MONSTER_ID1;
/*     */   }
/*     */   
/*     */   public int getVisibleMonsterId2()
/*     */   {
/* 205 */     return SLuanShiYaoMoConsts.getInstance().VISIBLE_MONSTER_ID2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getStoreExp(long roleid, int finishCount)
/*     */   {
/* 217 */     if (finishCount > SLuanShiYaoMoConsts.getInstance().REWARD_LIMIT) {
/* 218 */       return 0;
/*     */     }
/* 220 */     return getStoreExp(roleid);
/*     */   }
/*     */   
/*     */   static int getStoreExp(long roleid) {
/* 224 */     int level = RoleInterface.getLevel(roleid);
/* 225 */     int awardLevel = level - level % 10;
/* 226 */     int awardid = VisibleMonsterFightManager.getAwardId(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, awardLevel);
/* 227 */     if (awardid < 0) {
/* 228 */       awardid = SLuanShiYaoMoConsts.getInstance().AWARD_ID1;
/*     */     }
/* 230 */     AwardReason reason = new AwardReason(LogReason.LUANSHIYAOMO_ACTIVITY_ADD);
/* 231 */     reason.setJustQuery(true);
/* 232 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(awardid, roleid, -1, reason);
/* 233 */     if (awardModel == null) {
/* 234 */       return 0;
/*     */     }
/* 236 */     double exp = awardModel.getRoleExp() * SLuanShiYaoMoConsts.getInstance().STORE_EXP_TRANSFOR_RATE;
/* 237 */     if (exp >= 2.147483647E9D) {
/* 238 */       GameServer.logger().error(String.format("[LuanShiYaoMo]LuanShiYaoMoActivity.getStoreExp@cal store exp error|exp=%f", new Object[] { Double.valueOf(exp) }));
/*     */       
/* 240 */       return Integer.MAX_VALUE;
/*     */     }
/* 242 */     return (int)exp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getStoreExpOneTurn(long roleid, int turnNum)
/*     */   {
/* 253 */     long totalExp = getStoreExp(roleid) * 1L * SLuanShiYaoMoConsts.getInstance().REWARD_LIMIT;
/* 254 */     if (totalExp >= 2147483647L) {
/* 255 */       GameServer.logger().error(String.format("[LuanShiYaoMo]LuanShiYaoMoActivity.getStoreExp@cal store exp error|exp=%d", new Object[] { Long.valueOf(totalExp) }));
/*     */       
/*     */ 
/* 258 */       return Integer.MAX_VALUE;
/*     */     }
/* 260 */     return (int)totalExp;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\LuanShiYaoMoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */