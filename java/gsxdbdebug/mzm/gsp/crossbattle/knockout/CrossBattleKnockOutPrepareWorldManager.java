/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ public class CrossBattleKnockOutPrepareWorldManager
/*     */ {
/*  18 */   private static final CrossBattleKnockOutPrepareWorldManager instance = new CrossBattleKnockOutPrepareWorldManager();
/*  19 */   private Long prepareWorldId = null;
/*  20 */   private Long prepareWorldLastEnterTime = null;
/*     */   
/*     */   private Integer knockOutType;
/*     */   
/*  24 */   private MilliObserver worldDestoryObserver = null;
/*     */   
/*  26 */   private Boolean isRestart = null;
/*     */   
/*     */   public static CrossBattleKnockOutPrepareWorldManager getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   void setPrepareWorldId(long worldId, long prepareWorldLastEnterTime, int knockOutType, boolean isRestart)
/*     */   {
/*     */     try
/*     */     {
/*  45 */       this.locker.writeLock().lock();
/*  46 */       this.prepareWorldId = Long.valueOf(worldId);
/*  47 */       this.prepareWorldLastEnterTime = Long.valueOf(prepareWorldLastEnterTime);
/*  48 */       this.knockOutType = Integer.valueOf(knockOutType);
/*  49 */       this.isRestart = Boolean.valueOf(isRestart);
/*     */       
/*     */ 
/*  52 */       long leftMillTimes = prepareWorldLastEnterTime + 300000L - DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  54 */       this.worldDestoryObserver = new DestroyPrepareWorldObserver(leftMillTimes < 0L ? 0L : leftMillTimes, this);
/*     */     }
/*     */     finally
/*     */     {
/*  58 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Boolean isRestart()
/*     */   {
/*     */     try
/*     */     {
/*  66 */       this.locker.readLock().lock();
/*  67 */       return this.isRestart;
/*     */     }
/*     */     finally
/*     */     {
/*  71 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Integer getKnockOutType()
/*     */   {
/*     */     try
/*     */     {
/*  79 */       this.locker.readLock().lock();
/*  80 */       return this.knockOutType;
/*     */     }
/*     */     finally
/*     */     {
/*  84 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Long getPrepareWorldId()
/*     */   {
/*     */     try
/*     */     {
/*  92 */       this.locker.readLock().lock();
/*  93 */       return this.prepareWorldId;
/*     */     }
/*     */     finally
/*     */     {
/*  97 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   Long getPrepareWorldLastEnterTime()
/*     */   {
/*     */     try
/*     */     {
/* 105 */       this.locker.readLock().lock();
/* 106 */       return this.prepareWorldLastEnterTime;
/*     */     }
/*     */     finally
/*     */     {
/* 110 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void destroyWorld()
/*     */   {
/*     */     try
/*     */     {
/* 118 */       this.locker.writeLock().lock();
/* 119 */       if (this.prepareWorldId != null)
/*     */       {
/* 121 */         destroyPrepareWorld();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void destroyPrepareWorld()
/*     */   {
/*     */     try
/*     */     {
/* 134 */       this.locker.writeLock().lock();
/* 135 */       TeamInterface.unRegisterJoinTeam(this.prepareWorldId.longValue());
/* 136 */       TeamInterface.unRegisterActivityTeam(this.prepareWorldId.longValue());
/* 137 */       MapInterface.destroyWorld(this.prepareWorldId.longValue());
/* 138 */       this.prepareWorldId = null;
/* 139 */       this.worldDestoryObserver = null;
/* 140 */       this.prepareWorldLastEnterTime = null;
/* 141 */       if (this.isRestart.booleanValue())
/*     */       {
/* 143 */         CrossBattleKnockoutManager.clearRoleKnockOutRestartInfo();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 148 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private class DestroyPrepareWorldObserver
/*     */     extends MilliObserver
/*     */   {
/*     */     final CrossBattleKnockOutPrepareWorldManager prepareWorldManager;
/*     */     
/*     */     public DestroyPrepareWorldObserver(long intervalMilliSeconds, CrossBattleKnockOutPrepareWorldManager prepareWorldManager)
/*     */     {
/* 159 */       super();
/* 160 */       this.prepareWorldManager = prepareWorldManager;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 166 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new CrossBattleKnockOutPrepareWorldManager.PDestroyPrepareWorld(CrossBattleKnockOutPrepareWorldManager.this.prepareWorldId.longValue(), this.prepareWorldManager));
/*     */       
/*     */ 
/* 169 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PDestroyPrepareWorld extends LogicProcedure
/*     */   {
/*     */     private final long worldId;
/*     */     private final CrossBattleKnockOutPrepareWorldManager prepareWorldManager;
/*     */     
/*     */     public PDestroyPrepareWorld(long worldId, CrossBattleKnockOutPrepareWorldManager prepareWorldManager)
/*     */     {
/* 180 */       this.worldId = worldId;
/* 181 */       this.prepareWorldManager = prepareWorldManager;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 187 */       List<Long> roleList = MapInterface.getRoleList(this.worldId);
/* 188 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 190 */         new CrossBattleKnockOutPrepareWorldManager.PUnSetKnockOutWorldStatus(roleid).execute();
/*     */       }
/* 192 */       this.prepareWorldManager.destroyPrepareWorld();
/* 193 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PUnSetKnockOutWorldStatus
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PUnSetKnockOutWorldStatus(long roleId)
/*     */     {
/* 204 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 210 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.roleId, 1551);
/* 211 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CrossBattleKnockOutPrepareWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */