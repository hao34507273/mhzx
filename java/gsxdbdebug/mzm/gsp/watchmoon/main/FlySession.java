/*     */ package mzm.gsp.watchmoon.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Watchmoon;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2watchmoon;
/*     */ 
/*     */ public class FlySession extends Session
/*     */ {
/*  18 */   private final List<Long> roleids = new ArrayList();
/*     */   
/*     */   private final int mapId;
/*  21 */   private final AtomicInteger phaseAtomic = new AtomicInteger(0);
/*     */   
/*     */   public FlySession(long interval, int mapId, List<Long> roleids)
/*     */   {
/*  25 */     super(interval, ((Long)roleids.get(0)).longValue());
/*  26 */     this.mapId = mapId;
/*  27 */     this.roleids.addAll(roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  33 */     new FlytimeOut(this.mapId, this.roleids).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   int addAndGet()
/*     */   {
/*  39 */     return this.phaseAtomic.addAndGet(1);
/*     */   }
/*     */   
/*     */   private static class FlytimeOut
/*     */     extends mzm.gsp.util.LogicProcedure implements mzm.gsp.map.main.MapCallback<Boolean>
/*     */   {
/*     */     private final List<Long> roleids;
/*     */     private final int mapId;
/*     */     
/*     */     public FlytimeOut(int mapId, List<Long> roleids)
/*     */     {
/*  50 */       this.mapId = mapId;
/*  51 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  58 */       MapInterface.isNearByPos(this.roleids, this.mapId, SWatchmoonMapCfg.get(this.mapId).endposX, SWatchmoonMapCfg.get(this.mapId).endposY, SWatchmoonMapCfg.get(this.mapId).distance, this);
/*     */       
/*  60 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/*  68 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onResult(Boolean result)
/*     */     {
/*  74 */       boolean isFailed = false;
/*     */       try
/*     */       {
/*  77 */         Lockeys.lock(Role2watchmoon.getTable(), this.roleids);
/*  78 */         Set<Long> partenerRoleIds; if ((result == null) || (!result.booleanValue()))
/*     */         {
/*  80 */           String logstr = String.format("[watchmoon]FlytimeOut.onResult@watch moon failed,not at the position|roleids=%s", new Object[] { this.roleids.toString() });
/*     */           
/*     */ 
/*  83 */           WatchmoonManager.logger.info(logstr);
/*  84 */           isFailed = true;
/*     */         }
/*     */         else
/*     */         {
/*  88 */           partenerRoleIds = new java.util.HashSet();
/*  89 */           for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/*  91 */             Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/*  92 */             if (xWatchmoon == null)
/*     */             {
/*     */ 
/*  95 */               String logstr = String.format("[watchmoon]FlytimeOut.onResult@watch moon failed,xbean.Watchmoon null|roleids=%s", new Object[] { this.roleids.toString() });
/*     */               
/*     */ 
/*  98 */               WatchmoonManager.logger.error(logstr);
/*  99 */               isFailed = true;
/* 100 */               break;
/*     */             }
/* 102 */             if (!WatchmoonManager.isWatchMoonSessionStart(xWatchmoon.getSessionid()))
/*     */             {
/* 104 */               isFailed = true;
/* 105 */               break;
/*     */             }
/* 107 */             partenerRoleIds.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/*     */           }
/*     */           
/* 110 */           if ((partenerRoleIds.size() != this.roleids.size()) || (!partenerRoleIds.containsAll(this.roleids)))
/*     */           {
/* 112 */             isFailed = true;
/*     */           }
/*     */         }
/*     */         
/* 116 */         return 1;
/*     */       }
/*     */       finally
/*     */       {
/* 120 */         if (isFailed)
/*     */         {
/* 122 */           WatchmoonManager.doWatchMoonFailed(this.roleids);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\FlySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */