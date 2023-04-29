/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
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
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.DateObserver;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightRewardModify;
/*     */ import mzm.gsp.visiblemonsterfight.event.ShengXiaoMonsterArg;
/*     */ import mzm.gsp.visiblemonsterfight.event.ShengXiaoMonsterEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShengXiaoActivity
/*     */   extends MonsterFightActivity
/*     */ {
/*     */   private VisibleMonsterFightHandler handler;
/*     */   private DateObserver observer;
/*     */   
/*     */   public ShengXiaoActivity()
/*     */   {
/*  37 */     this.reason = new AwardReason(LogReason.SHENGXIAO_ACTIVITY_ADD);
/*  38 */     this.activityType = 0;
/*  39 */     ActivityInterface.registerActivityByLogicType(11, this);
/*  40 */     ActivityCompensateInterface.registerCompensateHandler(11, new ShengXiaoActivityCompensateHandler());
/*     */     
/*  42 */     ItemAccessManager.registerActivityReward(SShengXiaoFightConsts.getInstance().ACTIVITYID, SShengXiaoFightConsts.getInstance().AWARD_ID1);
/*     */     
/*  44 */     ItemAccessManager.registerActivityReward(SShengXiaoFightConsts.getInstance().ACTIVITYID, SShengXiaoFightConsts.getInstance().AWARD_ID2);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getModifyId(Collection<Long> roleIdSet, long roleId)
/*     */   {
/*  50 */     int level = RoleInterface.getLevel(roleId);
/*  51 */     int averageLv = level - getTeamAverageLevel(roleIdSet);
/*  52 */     for (SShengXiaoFightRewardModify modify : SShengXiaoFightRewardModify.getAll().values()) {
/*  53 */       if ((modify.lowTeamAverageLevel <= averageLv) && (modify.highTeamAverageLevel >= averageLv))
/*     */       {
/*     */ 
/*  56 */         return modify.modifyValueTableId; }
/*     */     }
/*  58 */     return -1;
/*     */   }
/*     */   
/*     */   public int getRewardLimit()
/*     */   {
/*  63 */     return SShengXiaoFightConsts.getInstance().REWARD_LIMIT;
/*     */   }
/*     */   
/*     */   public int getActivity()
/*     */   {
/*  68 */     return SShengXiaoFightConsts.getInstance().ACTIVITYID;
/*     */   }
/*     */   
/*     */   public int getAwardId1(VisibleMonsterFightContext context)
/*     */   {
/*  73 */     int awardId = VisibleMonsterFightManager.getAwardId(getActivity(), context.enterFightLowLevel);
/*  74 */     if (awardId > 0)
/*  75 */       return awardId;
/*  76 */     return SShengXiaoFightConsts.getInstance().AWARD_ID1;
/*     */   }
/*     */   
/*     */   public int getAwardId2(VisibleMonsterFightContext context)
/*     */   {
/*  81 */     int awardId = VisibleMonsterFightManager.getAwardId2(getActivity(), context.enterFightLowLevel);
/*  82 */     if (awardId > 0)
/*  83 */       return awardId;
/*  84 */     return SShengXiaoFightConsts.getInstance().AWARD_ID2;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  89 */     this.handler = new VisibleMonsterFightHandler(FightReason.SHENGXIAO_FIGHT, 60, activityid)
/*     */     {
/*     */       public int startFight(long roleId, int fightId, MapFightContext context)
/*     */       {
/*  93 */         if (!RoleStatusInterface.checkCanSetStatus(roleId, 92, true)) {
/*  94 */           return 5;
/*     */         }
/*  96 */         return super.startFight(roleId, fightId, context);
/*     */       }
/*  98 */     };
/*  99 */     this.handler.addGroupId(getVisibleMonsterId1());
/* 100 */     this.handler.addGroupId(getVisibleMonsterId2());
/* 101 */     long worldId = MapInterface.getCenterWorldid();
/* 102 */     MapInterface.registerMonsterFightHandler(worldId, this.handler);
/* 103 */     ControllerInterface.triggerOrReSpawn(worldId, SShengXiaoFightConsts.getInstance().CONTROLLERID, 1);
/* 104 */     ControllerInterface.setControllerMaxCount(worldId, SShengXiaoFightConsts.getInstance().CONTROLLERID, 1);
/* 105 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 106 */     sBulletinInfo.bulletintype = 11;
/* 107 */     BulletinInterface.sendBulletin(sBulletinInfo);
/* 108 */     this.observer = new ShengXiaoMonsterReliveObserver(SShengXiaoFightConsts.getInstance().REFRESH_TIME_CFG, SShengXiaoFightConsts.getInstance().CONTROLLERID);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 114 */     if (this.observer != null) {
/* 115 */       this.observer.stopTimer();
/* 116 */       this.observer = null;
/*     */     }
/* 118 */     ControllerInterface.collectController(SShengXiaoFightConsts.getInstance().CONTROLLERID);
/* 119 */     MapInterface.unregisterMonsterFightHandler(MapInterface.getCenterWorldid(), this.handler);
/* 120 */     this.handler = null;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/* 125 */     boolean ret = super.handleMonsterDead(context);
/* 126 */     if (ret) {
/* 127 */       ShengXiaoMonsterArg shengXiaoMonsterArg = new ShengXiaoMonsterArg(context.roleList, context.monsterCfgId, true);
/*     */       
/* 129 */       TriggerEventsManger.getInstance().triggerEvent(new ShengXiaoMonsterEvent(), shengXiaoMonsterArg);
/*     */     }
/* 131 */     return ret;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterWin(VisibleMonsterFightContext context)
/*     */   {
/* 136 */     boolean ret = super.handleMonsterWin(context);
/* 137 */     if (ret) {
/* 138 */       ShengXiaoMonsterArg shengXiaoMonsterArg = new ShengXiaoMonsterArg(context.roleList, context.monsterCfgId, false);
/*     */       
/* 140 */       TriggerEventsManger.getInstance().triggerEvent(new ShengXiaoMonsterEvent(), shengXiaoMonsterArg);
/*     */     }
/* 142 */     return ret;
/*     */   }
/*     */   
/*     */   public int getVisibleMonsterId2()
/*     */   {
/* 147 */     return SShengXiaoFightConsts.getInstance().VISIBLE_MONSTER_ID2;
/*     */   }
/*     */   
/*     */   public int getVisibleMonsterId1()
/*     */   {
/* 152 */     return SShengXiaoFightConsts.getInstance().VISIBLE_MONSTER_ID1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init()
/*     */   {
/* 173 */     ControllerInterface.triggerOrReSpawn(MapInterface.getCenterWorldid(), SShengXiaoFightConsts.getInstance().CONTROLLERID, 1);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\ShengXiaoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */