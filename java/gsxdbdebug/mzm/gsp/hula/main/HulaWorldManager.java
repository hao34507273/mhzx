/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Hulaworld;
/*     */ import xtable.User;
/*     */ 
/*     */ public class HulaWorldManager
/*     */ {
/*  29 */   private static final HulaWorldManager instance = new HulaWorldManager();
/*  30 */   private long prepareWorldId = 0L;
/*     */   
/*     */   public static HulaWorldManager getInstance()
/*     */   {
/*  34 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */   private final Set<Long> worldids = new HashSet();
/*     */   
/*  44 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*     */   
/*     */   void setPrepareWorldId(long worldId)
/*     */   {
/*     */     try
/*     */     {
/*  50 */       this.locker.writeLock().lock();
/*  51 */       this.prepareWorldId = worldId;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  56 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   long getPrepareWorldId()
/*     */   {
/*     */     try
/*     */     {
/*  64 */       this.locker.readLock().lock();
/*  65 */       return this.prepareWorldId;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  70 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean addWorldId(long worldId)
/*     */   {
/*     */     try
/*     */     {
/*  78 */       this.locker.writeLock().lock();
/*  79 */       return this.worldids.add(Long.valueOf(worldId));
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*  84 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean removeWorldId(long worldId)
/*     */   {
/*     */     try
/*     */     {
/*  92 */       this.locker.writeLock().lock();
/*  93 */       return this.worldids.remove(Long.valueOf(worldId));
/*     */     }
/*     */     finally
/*     */     {
/*  97 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void destroyWorld()
/*     */   {
/*     */     try
/*     */     {
/* 105 */       this.locker.writeLock().lock();
/* 106 */       if (this.prepareWorldId != 0L)
/*     */       {
/* 108 */         destroyPrepareWorld();
/*     */       }
/*     */       
/* 111 */       for (Iterator i$ = this.worldids.iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*     */         
/* 113 */         MapInterface.destroyWorld(worldid);
/* 114 */         new RemoveHulaWorldPro(worldid).execute();
/* 115 */         TeamInterface.unRegisterJoinTeam(worldid);
/*     */       }
/* 117 */       this.worldids.clear();
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 122 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void destroyPrepareWorld()
/*     */   {
/*     */     try
/*     */     {
/* 130 */       this.locker.writeLock().lock();
/* 131 */       MapInterface.destroyWorld(this.prepareWorldId);
/* 132 */       TeamInterface.unRegisterJoinTeam(this.prepareWorldId);
/* 133 */       TeamInterface.unRegisterActivityTeam(this.prepareWorldId);
/* 134 */       this.prepareWorldId = 0L;
/*     */     }
/*     */     finally
/*     */     {
/* 138 */       this.locker.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RemoveHulaWorldPro extends LogicProcedure
/*     */   {
/*     */     private final long worldid;
/*     */     
/*     */     public RemoveHulaWorldPro(long worldid)
/*     */     {
/* 148 */       this.worldid = worldid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 154 */       long key = GameServerInfoManager.toGlobalId(this.worldid);
/* 155 */       Set<Long> roles = Hulaworld.selectRoleids(Long.valueOf(key));
/* 156 */       if ((roles != null) && (!roles.isEmpty()))
/*     */       {
/* 158 */         Lockeys.lock(xtable.Role2properties.getTable(), roles);
/* 159 */         mzm.gsp.status.main.RoleStatusInterface.unsetStatus(new ArrayList(roles), 450);
/*     */       }
/* 161 */       Hulaworld.remove(Long.valueOf(key));
/* 162 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void awardExpToAllWorldRoles(int stage)
/*     */   {
/*     */     try
/*     */     {
/* 170 */       this.locker.readLock().lock();
/*     */       Iterator i$;
/* 172 */       if (HulaManager.isThisStage(stage, 0))
/*     */       {
/* 174 */         List<Long> roleList = MapInterface.getRoleList(this.prepareWorldId);
/* 175 */         for (i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 177 */           NoneRealTimeTaskManager.getInstance().addTask(new AwardToRole(roleid));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 182 */         for (i$ = this.worldids.iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*     */           
/* 184 */           List<Long> roleList = MapInterface.getRoleList(worldid);
/* 185 */           for (i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/* 187 */             NoneRealTimeTaskManager.getInstance().addTask(new AwardToRole(roleid));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       Iterator i$;
/*     */       Iterator i$;
/* 196 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class AwardToRole extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     public AwardToRole(long roleid)
/*     */     {
/* 206 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 212 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/* 214 */         String logStr = String.format("[hula]AwardToRole.processImp@roam server can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 215 */         HulaManager.logger.info(logStr);
/* 216 */         return false;
/*     */       }
/* 218 */       int rewardid = SHulaCfgConsts.getInstance().EXP_RAIN_AWARD_ID;
/*     */       
/* 220 */       String userId = RoleInterface.getUserId(this.roleid);
/* 221 */       lock(Lockeys.get(User.getTable(), userId));
/*     */       
/* 223 */       AwardModel awardModel = AwardInterface.award(rewardid, userId, this.roleid, false, true, new AwardReason(LogReason.HULA_ACTIVITY_EXP_AWARD, rewardid));
/*     */       
/* 225 */       if (awardModel == null)
/*     */       {
/* 227 */         String logstr = String.format("[hula]AwardToRole.processImp@hula offer award error,null|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(rewardid) });
/*     */         
/*     */ 
/* 230 */         HulaManager.logger.error(logstr);
/*     */       }
/*     */       else
/*     */       {
/* 234 */         String logstr = String.format("[hula]AwardToRole.processImp@hula offer award to role success|roleid=%d|rewardid=%d|exp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(rewardid), Integer.valueOf(awardModel.getRoleExp()) });
/*     */         
/*     */ 
/* 237 */         HulaManager.logger.info(logstr);
/*     */       }
/* 239 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void generateDoudou(int turn)
/*     */   {
/*     */     try
/*     */     {
/* 248 */       this.locker.readLock().lock();
/*     */       
/* 250 */       for (i$ = this.worldids.iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*     */         
/* 252 */         new PGenerateDoudouSeq(worldid, turn).execute();
/*     */       }
/*     */     }
/*     */     finally {
/*     */       Iterator i$;
/* 257 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void deleteDoudou(int turn)
/*     */   {
/*     */     try
/*     */     {
/* 265 */       this.locker.readLock().lock();
/*     */       
/* 267 */       for (i$ = this.worldids.iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*     */         
/* 269 */         new PDeleteDoudou(worldid, turn).execute();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       Iterator i$;
/* 275 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isHulaFubenWorld(long worldid)
/*     */   {
/*     */     try
/*     */     {
/* 283 */       this.locker.readLock().lock();
/*     */       
/* 285 */       for (Iterator i$ = this.worldids.iterator(); i$.hasNext();) { long w = ((Long)i$.next()).longValue();
/*     */         
/* 287 */         if (w == worldid)
/*     */         {
/* 289 */           return true;
/*     */         }
/*     */       }
/* 292 */       return 0;
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 297 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isHulaPrepareWorld(long worldid)
/*     */   {
/*     */     try
/*     */     {
/* 305 */       this.locker.readLock().lock();
/* 306 */       return this.prepareWorldId == worldid;
/*     */     }
/*     */     finally
/*     */     {
/* 310 */       this.locker.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */