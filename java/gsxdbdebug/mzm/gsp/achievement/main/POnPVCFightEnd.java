/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractFightResult.Context;
/*    */ import mzm.gsp.fight.event.PVCFightEndArg;
/*    */ import mzm.gsp.fight.event.PVCFightEndProcedure;
/*    */ 
/*    */ public class POnPVCFightEnd extends PVCFightEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 15 */     AchievementManager.collectLocks(((PVCFightEndArg)this.arg).activeRoleList);
/*    */     
/* 17 */     AbstractFightResult.Context context = new AbstractFightResult.Context(2, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(1)));
/* 18 */     int fightResultGoalType = ((PVCFightEndArg)this.arg).isActiveWin ? 5101 : 5102;
/*    */     
/* 20 */     for (Iterator i$ = ((PVCFightEndArg)this.arg).activeAlivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 23 */       AchievementManager.updateGoalTypeState(roleId, fightResultGoalType, context, "POnPVCFightEnd.processImp@handle fight result for alived success");
/*    */       
/*    */ 
/* 26 */       updateAchievements(roleId);
/*    */     }
/* 28 */     for (Iterator i$ = ((PVCFightEndArg)this.arg).activeDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 31 */       AchievementManager.updateGoalTypeState(roleId, fightResultGoalType, context, "POnPVCFightEnd.processImp@handle fight result for dead success");
/*    */       
/*    */ 
/* 34 */       updateAchievements(roleId);
/*    */     }
/*    */     
/* 37 */     for (Iterator i$ = ((PVCFightEndArg)this.arg).activeEscapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 40 */       AchievementManager.updateGoalTypeState(roleId, 5103, context, "POnPVCFightEnd.processImp@handle FIGHT_ESCAPE success");
/*    */       
/*    */ 
/* 43 */       updateAchievements(roleId);
/*    */     }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void updateAchievements(long roleId)
/*    */   {
/* 58 */     int roleDieCount = ((Integer)((PVCFightEndArg)this.arg).roleDeadCountMap.get(Long.valueOf(roleId))).intValue();
/* 59 */     AbstractFightResult.Context dieContext = new AbstractFightResult.Context(2, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleDieCount)));
/* 60 */     AchievementManager.updateGoalTypeState(roleId, 5106, dieContext, "POnPVCFightEnd.processImp@handle FIGHT_DIE success");
/*    */     
/*    */ 
/*    */ 
/* 64 */     int roleProtectCount = ((Integer)((PVCFightEndArg)this.arg).roleUseProtectionCountMap.get(Long.valueOf(roleId))).intValue();
/* 65 */     AbstractFightResult.Context protectContext = new AbstractFightResult.Context(2, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleProtectCount)));
/* 66 */     AchievementManager.updateGoalTypeState(roleId, 5107, protectContext, "POnPVCFightEnd.processImp@handle FIGHT_PROTECT success");
/*    */     
/*    */ 
/*    */ 
/* 70 */     int roleUseSkillCount = ((Integer)((PVCFightEndArg)this.arg).roleUseSkillCountMap.get(Long.valueOf(roleId))).intValue();
/* 71 */     AbstractFightResult.Context skillContext = new AbstractFightResult.Context(2, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseSkillCount)));
/* 72 */     AchievementManager.updateGoalTypeState(roleId, 5105, skillContext, "POnPVCFightEnd.processImp@handle FIGHT_USE_SKILL success");
/*    */     
/*    */ 
/*    */ 
/* 76 */     int roleUseItemCount = ((Integer)((PVCFightEndArg)this.arg).roleUseItemCountMap.get(Long.valueOf(roleId))).intValue();
/* 77 */     AbstractFightResult.Context itemContext = new AbstractFightResult.Context(2, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseItemCount)));
/* 78 */     AchievementManager.updateGoalTypeState(roleId, 5108, itemContext, "POnPVCFightEnd.processImp@handle FIGHT_USE_ITEM success");
/*    */     
/*    */ 
/*    */ 
/* 82 */     FightAchievementUtils.updateSkillAchievement(roleId, (xbean.SkillResult)((PVCFightEndArg)this.arg).roleSkillResult.get(Long.valueOf(roleId)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */