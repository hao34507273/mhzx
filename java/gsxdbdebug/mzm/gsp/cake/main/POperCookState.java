/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POperCookState
/*     */ {
/*     */   static void addCookState(int activityId)
/*     */   {
/*  28 */     for (Iterator i$ = GangInterface.getAllGangIdSet().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */       
/*  30 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  36 */           long factionWorldId = GangInterface.getGangWorldId(this.val$factionId);
/*  37 */           if (factionWorldId == -1L)
/*     */           {
/*  39 */             return false;
/*     */           }
/*  41 */           for (Iterator i$ = MapInterface.getRoleList(factionWorldId, GangInterface.getGangCfgId()).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */             
/*  43 */             NoneRealTimeTaskManager.getInstance().addTask(new POperCookState.AddCookState(roleId, this.val$activityId));
/*     */           }
/*  45 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeCookState(int activityId)
/*     */   {
/*  58 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/*  59 */     if (activityCfg == null)
/*     */     {
/*  61 */       return;
/*     */     }
/*  63 */     int state = activityCfg.stateId;
/*  64 */     for (Iterator i$ = GangInterface.getAllGangIdSet().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */       
/*  66 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  72 */           long factionWorldId = GangInterface.getGangWorldId(this.val$factionId);
/*  73 */           if (factionWorldId == -1L)
/*     */           {
/*  75 */             return false;
/*     */           }
/*  77 */           for (Iterator i$ = MapInterface.getRoleList(factionWorldId, GangInterface.getGangCfgId()).iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */             
/*  79 */             NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */             {
/*     */ 
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/*     */ 
/*  86 */                 RoleStatusInterface.unsetStatus(roleId, POperCookState.2.this.val$state);
/*  87 */                 return true;
/*     */               }
/*     */             });
/*     */           }
/*  91 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndAddCookState(long roleId, Set<Integer> activityIds)
/*     */   {
/* 105 */     if ((activityIds == null) || (activityIds.size() == 0))
/*     */     {
/* 107 */       return;
/*     */     }
/* 109 */     if (!inOwnFactionWorld(roleId))
/*     */     {
/*     */ 
/* 112 */       return;
/*     */     }
/*     */     
/* 115 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 116 */     for (Iterator i$ = activityIds.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/* 118 */       SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/* 119 */       if ((isActivityValid(activityCfg)) && 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */         (!RoleStatusInterface.containsStatus(roleId, activityCfg.stateId)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 130 */         RoleStatusInterface.setStatus(roleId, activityCfg.stateId, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void operRoleStatusOnLogin(long roleId, Set<Integer> activityIds)
/*     */   {
/* 144 */     if ((activityIds == null) || (activityIds.size() == 0))
/*     */     {
/* 146 */       return;
/*     */     }
/*     */     
/* 149 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/* 151 */     boolean isInOwnFactionWorld = inOwnFactionWorld(roleId);
/*     */     
/* 153 */     for (Iterator i$ = activityIds.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*     */       
/* 155 */       SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/* 156 */       if ((!isInOwnFactionWorld) || (!isActivityValid(activityCfg)))
/*     */       {
/*     */ 
/* 159 */         RoleStatusInterface.unsetStatus(roleId, activityCfg.stateId);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 164 */       else if (!RoleStatusInterface.containsStatus(roleId, activityCfg.stateId))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 169 */         RoleStatusInterface.setStatus(roleId, activityCfg.stateId, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class AddCookState extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int activityId;
/*     */     
/*     */     public AddCookState(long roleId, int activityId)
/*     */     {
/* 181 */       this.roleId = roleId;
/* 182 */       this.activityId = activityId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 188 */       Set<Integer> activityIds = new HashSet();
/* 189 */       activityIds.add(Integer.valueOf(this.activityId));
/* 190 */       POperCookState.checkAndAddCookState(this.roleId, activityIds);
/* 191 */       return true;
/*     */     }
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
/*     */   static boolean inOwnFactionWorld(long roleId)
/*     */   {
/* 206 */     long factionId = GangInterface.getGangId(roleId);
/* 207 */     if (factionId < 0L)
/*     */     {
/*     */ 
/* 210 */       return false;
/*     */     }
/* 212 */     if (MapInterface.getRoleWorldInstanceId(roleId) != GangInterface.getGangWorldId(factionId))
/*     */     {
/*     */ 
/* 215 */       return false;
/*     */     }
/* 217 */     return true;
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
/*     */   static boolean isActivityValid(SCakeActivityCfg activityCfg)
/*     */   {
/* 230 */     if (activityCfg == null)
/*     */     {
/* 232 */       return false;
/*     */     }
/* 234 */     if (!ActivityInterface.isActivityOpen(activityCfg.activityId))
/*     */     {
/* 236 */       return false;
/*     */     }
/* 238 */     if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/*     */     {
/* 240 */       return false;
/*     */     }
/* 242 */     if (CakeManager.getCookStage(activityCfg, DateTimeUtils.getCurrTimeInMillis()) == -1)
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POperCookState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */