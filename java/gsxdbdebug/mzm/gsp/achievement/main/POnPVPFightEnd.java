/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.achievement.main.goaltype.AbstractFightResult.Context;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.pk.main.PKFightContext;
/*     */ import xbean.SkillResult;
/*     */ 
/*     */ public class POnPVPFightEnd extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */   {
/*  18 */     List<Long> roleIds = new java.util.LinkedList();
/*  19 */     roleIds.addAll(((PVPFightEndArg)this.arg).activeRoleList);
/*  20 */     roleIds.addAll(((PVPFightEndArg)this.arg).passiveRoleList);
/*  21 */     AchievementManager.collectLocks(roleIds);
/*  22 */     AbstractFightResult.Context publicContext = new AbstractFightResult.Context(1, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(1)));
/*  23 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).getWinnerNotEscapeList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  26 */       AchievementManager.updateGoalTypeState(roleId, 5101, publicContext, "POnPVPFightEnd.processImp@handle FIGHT_WIN success");
/*     */       
/*     */ 
/*  29 */       updateAchievements(roleId);
/*     */     }
/*     */     
/*  32 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).getLoserNotEscapeList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  35 */       AchievementManager.updateGoalTypeState(roleId, 5102, publicContext, "POnPVPFightEnd.processImp@handle FIGHT_LOSE success");
/*     */       
/*     */ 
/*  38 */       updateAchievements(roleId);
/*     */     }
/*     */     
/*  41 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeEscapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  44 */       AchievementManager.updateGoalTypeState(roleId, 5103, publicContext, "POnPVPFightEnd.processImp@handle FIGHT_ESCAPE for active success");
/*     */       
/*     */ 
/*  47 */       updateAchievements(roleId);
/*     */     }
/*  49 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveEscapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  52 */       AchievementManager.updateGoalTypeState(roleId, 5103, publicContext, "POnPVPFightEnd.processImp@handle FIGHT_ESCAPE for passive success");
/*     */       
/*     */ 
/*  55 */       updateAchievements(roleId);
/*     */     }
/*     */     
/*     */     Iterator i$;
/*  59 */     if ((((PVPFightEndArg)this.arg).context instanceof PKFightContext))
/*     */     {
/*  61 */       for (Iterator i$ = ((PVPFightEndArg)this.arg).getWinnerList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  63 */         AchievementManager.updateGoalTypeState(roleId, 5703, Integer.valueOf(1), "POnPVPFightEnd.processImp@handle PK_COUNT for passive success");
/*     */         
/*  65 */         AchievementManager.updateGoalTypeState(roleId, 5701, Integer.valueOf(1), "POnPVPFightEnd.processImp@handle PK_SUCCESS_COUNT for passive success");
/*     */       }
/*     */       
/*  68 */       for (i$ = ((PVPFightEndArg)this.arg).getLoserList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  70 */         AchievementManager.updateGoalTypeState(roleId, 5703, Integer.valueOf(1), "POnPVPFightEnd.processImp@handle PK_COUNT for passive success");
/*     */         
/*  72 */         AchievementManager.updateGoalTypeState(roleId, 5702, Integer.valueOf(1), "POnPVPFightEnd.processImp@handle PK_FAIL_COUNT for passive success");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateAchievements(long roleId)
/*     */   {
/*  89 */     int roleDieCount = ((Integer)((PVPFightEndArg)this.arg).roleDeadCountMap.get(Long.valueOf(roleId))).intValue();
/*  90 */     AbstractFightResult.Context dieContext = new AbstractFightResult.Context(1, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleDieCount)));
/*  91 */     AchievementManager.updateGoalTypeState(roleId, 5106, dieContext, "POnPVPFightEnd.processImp@handle FIGHT_DIE success");
/*     */     
/*     */ 
/*     */ 
/*  95 */     int roleProtectCount = ((Integer)((PVPFightEndArg)this.arg).roleUseProtectionCountMap.get(Long.valueOf(roleId))).intValue();
/*  96 */     AbstractFightResult.Context protectContext = new AbstractFightResult.Context(1, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleProtectCount)));
/*  97 */     AchievementManager.updateGoalTypeState(roleId, 5107, protectContext, "POnPVPFightEnd.processImp@handle FIGHT_PROTECT success");
/*     */     
/*     */ 
/*     */ 
/* 101 */     int roleUseSkillCount = ((Integer)((PVPFightEndArg)this.arg).roleUseSkillCountMap.get(Long.valueOf(roleId))).intValue();
/* 102 */     AbstractFightResult.Context skillContext = new AbstractFightResult.Context(1, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseSkillCount)));
/* 103 */     AchievementManager.updateGoalTypeState(roleId, 5105, skillContext, "POnPVPFightEnd.processImp@handle FIGHT_USE_SKILL success");
/*     */     
/*     */ 
/*     */ 
/* 107 */     int roleUseItemCount = ((Integer)((PVPFightEndArg)this.arg).roleUseItemCountMap.get(Long.valueOf(roleId))).intValue();
/* 108 */     AbstractFightResult.Context itemContext = new AbstractFightResult.Context(1, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseItemCount)));
/* 109 */     AchievementManager.updateGoalTypeState(roleId, 5108, itemContext, "POnPVPFightEnd.processImp@handle FIGHT_USE_ITEM success");
/*     */     
/*     */ 
/*     */ 
/* 113 */     FightAchievementUtils.updateSkillAchievement(roleId, (SkillResult)((PVPFightEndArg)this.arg).roleSkillResult.get(Long.valueOf(roleId)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */