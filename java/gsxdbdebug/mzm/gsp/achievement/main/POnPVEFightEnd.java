/*     */ package mzm.gsp.achievement.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalValueChange.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.AbstractFightResult.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FightAccumulateKillMonster.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FightKillMonsterInRound.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FightMonsterDeadRoundContext;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorKillMonsterInSameRound.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorPassWithLessDeath.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorPassWithLessMonsterRelive.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorPassWithLessSurvive.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorPassWithMoreDeath.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.FloorPassWithMoreMonsterRelive.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.QingYunZhiPass.Context;
/*     */ import mzm.gsp.achievement.main.goaltype.QingYunZhiPassAlone.Context;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.floor.main.FloorFightContext;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.prison.main.JailBreakPVEFightContext;
/*     */ import mzm.gsp.prison.main.JailDeliveryPVEFightContext;
/*     */ import mzm.gsp.qingyunzhi.main.QingFightContext;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */   {
/*  35 */     AchievementManager.collectLocks(((PVEFightEndArg)this.arg).roleList);
/*     */     
/*  37 */     AbstractFightResult.Context publicContext = new AbstractFightResult.Context(0, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(1)));
/*     */     
/*  39 */     int fightResultGoalType = ((PVEFightEndArg)this.arg).isPlayerWin ? 5101 : 5102;
/*  40 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).alivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  42 */       AchievementManager.updateGoalTypeState(roleId, fightResultGoalType, publicContext, "POnPVEFightEnd.processImp@handle fight result for alived success");
/*     */     }
/*     */     
/*  45 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).diedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  47 */       AchievementManager.updateGoalTypeState(roleId, fightResultGoalType, publicContext, "POnPVEFightEnd.processImp@handle fight result for dead success");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  52 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).escapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  54 */       AchievementManager.updateGoalTypeState(roleId, 5103, publicContext, "POnPVEFightEnd.processImp@handle FIGHT_ESCAPE success");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  59 */     boolean isJailBreak = (((PVEFightEndArg)this.arg).fightReason == FightReason.JAIL_BREAK_FIGHT_PVE.value) && ((((PVEFightEndArg)this.arg).context instanceof JailBreakPVEFightContext));
/*  60 */     boolean isJailDelivery = (((PVEFightEndArg)this.arg).fightReason == FightReason.JAIL_DELIVERY_FIGHT_PVE.value) && ((((PVEFightEndArg)this.arg).context instanceof JailDeliveryPVEFightContext));
/*     */     
/*     */ 
/*  63 */     boolean isGangRobberFight = false;
/*  64 */     int robberVisibleMonsterId; Iterator i$; if ((((PVEFightEndArg)this.arg).context instanceof mzm.gsp.map.main.MapVisibleMonsterFightContext))
/*     */     {
/*     */ 
/*  67 */       robberVisibleMonsterId = SGangRobberConst.getInstance().VISIBLE_MONSTER_ID;
/*  68 */       for (i$ = ((PVEFightEndArg)this.arg).monsteridToLevel.keySet().iterator(); i$.hasNext();) { int monsterId = ((Integer)i$.next()).intValue();
/*     */         
/*  70 */         if (MonsterInterface.getMonsterCategoryId(monsterId) == robberVisibleMonsterId)
/*     */         {
/*  72 */           isGangRobberFight = true;
/*  73 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  78 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  81 */       FightAccumulateKillMonster.Context context1 = new FightAccumulateKillMonster.Context(((PVEFightEndArg)this.arg).diedMonsters);
/*  82 */       AchievementManager.updateGoalTypeState(roleId, 5104, context1, "POnPVEFightEnd.processImp@handle FIGHT_ACCUMULATE_KILL_MONSTER success");
/*     */       
/*     */ 
/*     */ 
/*  86 */       int roleDieCount = ((Integer)((PVEFightEndArg)this.arg).roleDeadCountMap.get(Long.valueOf(roleId))).intValue();
/*  87 */       AbstractFightResult.Context dieContext = new AbstractFightResult.Context(0, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleDieCount)));
/*  88 */       AchievementManager.updateGoalTypeState(roleId, 5106, dieContext, "POnPVEFightEnd.processImp@handle FIGHT_DIE success");
/*     */       
/*     */ 
/*     */ 
/*  92 */       int roleProtectCount = ((Integer)((PVEFightEndArg)this.arg).roleUseProtectionCountMap.get(Long.valueOf(roleId))).intValue();
/*  93 */       AbstractFightResult.Context protectContext = new AbstractFightResult.Context(0, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleProtectCount)));
/*  94 */       AchievementManager.updateGoalTypeState(roleId, 5107, protectContext, "POnPVEFightEnd.processImp@handle FIGHT_PROTECT success");
/*     */       
/*     */ 
/*     */ 
/*  98 */       int roleUseSkillCount = ((Integer)((PVEFightEndArg)this.arg).roleUseSkillCountMap.get(Long.valueOf(roleId))).intValue();
/*  99 */       AbstractFightResult.Context skillContext = new AbstractFightResult.Context(0, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseSkillCount)));
/* 100 */       AchievementManager.updateGoalTypeState(roleId, 5105, skillContext, "POnPVEFightEnd.processImp@handle FIGHT_USE_SKILL success");
/*     */       
/*     */ 
/*     */ 
/* 104 */       int roleUseItemCount = ((Integer)((PVEFightEndArg)this.arg).roleUseItemCountMap.get(Long.valueOf(roleId))).intValue();
/* 105 */       AbstractFightResult.Context itemContext = new AbstractFightResult.Context(0, Collections.singletonMap(Integer.valueOf(0), Integer.valueOf(roleUseItemCount)));
/* 106 */       AchievementManager.updateGoalTypeState(roleId, 5108, itemContext, "POnPVEFightEnd.processImp@handle FIGHT_USE_ITEM success");
/*     */       
/*     */ 
/*     */ 
/* 110 */       if (isJailBreak)
/*     */       {
/* 112 */         AchievementManager.updateGoalTypeState(roleId, 5706, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_COUNT success");
/*     */         
/* 114 */         if (((PVEFightEndArg)this.arg).isPlayerWin)
/*     */         {
/* 116 */           AchievementManager.updateGoalTypeState(roleId, 5704, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_SUCCESS_COUNT success");
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 121 */           AchievementManager.updateGoalTypeState(roleId, 5705, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_FAIL_COUNT success");
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 127 */       if (isJailDelivery)
/*     */       {
/* 129 */         AchievementManager.updateGoalTypeState(roleId, 5709, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_COUNT success");
/*     */         
/* 131 */         if (((PVEFightEndArg)this.arg).isPlayerWin)
/*     */         {
/* 133 */           AchievementManager.updateGoalTypeState(roleId, 5707, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_SUCCESS_COUNT success");
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 138 */           AchievementManager.updateGoalTypeState(roleId, 5708, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle JAIL_BREAK_FAIL_COUNT success");
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 144 */       if (isGangRobberFight)
/*     */       {
/*     */ 
/* 147 */         AchievementManager.updateGoalTypeState(roleId, 5113, Integer.valueOf(roleDieCount), "POnPVEFightEnd.processImp@handle ROBBER_DIE success");
/*     */         
/*     */ 
/*     */ 
/* 151 */         AchievementManager.updateGoalTypeState(roleId, 5112, Integer.valueOf(((PVEFightEndArg)this.arg).diedMonsters.size()), "POnPVEFightEnd.processImp@handle ROBBER_KILL success");
/*     */       }
/*     */       
/*     */ 
/* 155 */       if (((PVEFightEndArg)this.arg).isPlayerWin)
/*     */       {
/*     */ 
/* 158 */         FightKillMonsterInRound.Context context2 = new FightKillMonsterInRound.Context(((PVEFightEndArg)this.arg).round, ((PVEFightEndArg)this.arg).diedMonsters);
/*     */         
/* 160 */         AchievementManager.updateGoalTypeState(roleId, 5114, context2, "POnPVEFightEnd.processImp@handle FIGHT_KILL_MONSTER_IN_ROUND success");
/*     */         
/*     */ 
/*     */ 
/* 164 */         if (((PVEFightEndArg)this.arg).fightReason == FightReason.FACTION_PVE.value)
/*     */         {
/* 166 */           AchievementManager.updateGoalTypeState(roleId, 5133, Integer.valueOf(1), "POnPVEFightEnd.processImp@handle FACTION_PVE_WIN success");
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 172 */       FightAchievementUtils.updateSkillAchievement(roleId, (xbean.SkillResult)((PVEFightEndArg)this.arg).roleSkillResult.get(Long.valueOf(roleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     if ((((PVEFightEndArg)this.arg).isPlayerWin) && ((((PVEFightEndArg)this.arg).context instanceof QingFightContext)))
/*     */     {
/* 179 */       QingFightContext qingFightContext = (QingFightContext)((PVEFightEndArg)this.arg).context;
/* 180 */       QingYunZhiPass.Context context1 = new QingYunZhiPass.Context(qingFightContext.getOutPostType(), qingFightContext.getChapter(), qingFightContext.getSection());
/*     */       
/*     */ 
/* 183 */       for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 185 */         AchievementManager.updateGoalTypeState(roleId, 5132, context1, "POnPVEFightEnd.processImp@handle QINGYUNZHI_PASS success");
/*     */       }
/*     */       
/*     */ 
/* 189 */       if (((PVEFightEndArg)this.arg).roleList.size() == 1)
/*     */       {
/* 191 */         QingYunZhiPassAlone.Context context2 = new QingYunZhiPassAlone.Context(qingFightContext.getOutPostType(), qingFightContext.getChapter(), qingFightContext.getSection());
/*     */         
/*     */ 
/* 194 */         AchievementManager.updateGoalTypeState(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), 5110, context2, "POnPVEFightEnd.processImp@handle QINGYUNZHI_PASS_ALONE success");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 201 */     updateFloorAchievements();
/*     */     
/*     */ 
/* 204 */     updateInstanceAchievements();
/*     */     
/* 206 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateInstanceAchievements()
/*     */   {
/* 215 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/* 217 */       return;
/*     */     }
/*     */     
/*     */ 
/* 221 */     FightMonsterDeadRoundContext deadRoundContext = new FightMonsterDeadRoundContext(((PVEFightEndArg)this.arg).fightCfgID, ((PVEFightEndArg)this.arg).monsterDeadInRound);
/*     */     
/*     */ 
/* 224 */     AbstractConditionalValueChange.Context context = new AbstractConditionalValueChange.Context(((PVEFightEndArg)this.arg).fightCfgID, ((PVEFightEndArg)this.arg).round);
/*     */     
/*     */ 
/* 227 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 230 */       AchievementManager.updateGoalTypeState(roleId, 5138, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_KILL_SPECIFIC_MONSTER_FIRST success");
/*     */       
/*     */ 
/* 233 */       AchievementManager.updateGoalTypeState(roleId, 5139, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_KILL_SPECIFIC_MONSTER_LAST success");
/*     */       
/*     */ 
/* 236 */       AchievementManager.updateGoalTypeState(roleId, 5140, context, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_WIN_ABOVE_ROUND success");
/*     */       
/*     */ 
/* 239 */       AchievementManager.updateGoalTypeState(roleId, 5137, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_ONE_FIGHT_KILL_SPECIFIC_MONSTER success");
/*     */       
/*     */ 
/* 242 */       AchievementManager.updateGoalTypeState(roleId, 5136, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_KILL_SPECIFIC_MONSTER_IN_SAME_ROUND success");
/*     */       
/*     */ 
/* 245 */       AchievementManager.updateGoalTypeState(roleId, 5141, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_KILL_SPECIFIC_MONSTER_AT_ROUND success");
/*     */       
/*     */ 
/* 248 */       AchievementManager.updateGoalTypeState(roleId, 5142, deadRoundContext, "POnPVEFightEnd.updateInstanceAchievements@handle FIGHT_KILL_SPECIFIC_MONSTER_AT_MOD_ROUND success");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateFloorAchievements()
/*     */   {
/* 259 */     if ((!(((PVEFightEndArg)this.arg).context instanceof FloorFightContext)) || (!((PVEFightEndArg)this.arg).isPlayerWin))
/*     */     {
/* 261 */       return;
/*     */     }
/* 263 */     FloorFightContext floorFightContext = (FloorFightContext)((PVEFightEndArg)this.arg).context;
/* 264 */     int activityId = floorFightContext.getActivityId();
/* 265 */     int floor = floorFightContext.getFloor();
/*     */     
/*     */ 
/* 268 */     FloorKillMonsterInSameRound.Context context1 = new FloorKillMonsterInSameRound.Context(activityId, floor, ((PVEFightEndArg)this.arg).monsterDeadInRound);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 273 */     FloorPassWithLessSurvive.Context context2 = new FloorPassWithLessSurvive.Context(activityId, floor, ((PVEFightEndArg)this.arg).alivedRoles.size());
/*     */     
/*     */ 
/* 276 */     FloorPassWithLessDeath.Context context3 = new FloorPassWithLessDeath.Context(activityId, floor, ((PVEFightEndArg)this.arg).passiveMonsterKillCount);
/*     */     
/*     */ 
/* 279 */     FloorPassWithMoreDeath.Context context4 = new FloorPassWithMoreDeath.Context(activityId, floor, ((PVEFightEndArg)this.arg).passiveMonsterKillCount);
/*     */     
/*     */ 
/* 282 */     FloorPassWithLessMonsterRelive.Context context5 = new FloorPassWithLessMonsterRelive.Context(activityId, floor, ((PVEFightEndArg)this.arg).passiveMonsterReliveCount);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 287 */     FloorPassWithMoreMonsterRelive.Context context6 = new FloorPassWithMoreMonsterRelive.Context(activityId, floor, ((PVEFightEndArg)this.arg).passiveMonsterReliveCount);
/*     */     
/*     */ 
/*     */ 
/* 291 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 294 */       AchievementManager.updateGoalTypeState(roleId, 5117, context1, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_KILL_MONSTER_IN_SAME_ROUND success");
/*     */       
/*     */ 
/*     */ 
/* 298 */       AchievementManager.updateGoalTypeState(roleId, 5120, context2, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_PASS_WITH_LESS_SURVIVE success");
/*     */       
/*     */ 
/*     */ 
/* 302 */       AchievementManager.updateGoalTypeState(roleId, 5115, context3, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_PASS_WITH_LESS_DEATH success");
/*     */       
/*     */ 
/*     */ 
/* 306 */       AchievementManager.updateGoalTypeState(roleId, 5116, context4, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_PASS_WITH_MORE_DEATH success");
/*     */       
/*     */ 
/*     */ 
/* 310 */       AchievementManager.updateGoalTypeState(roleId, 5118, context5, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_PASS_WITH_LESS_MONSTER_RELIVE success");
/*     */       
/*     */ 
/*     */ 
/* 314 */       AchievementManager.updateGoalTypeState(roleId, 5119, context6, "POnPVEFightEnd.updateFloorAchievement@handle FLOOR_PASS_WITH_MORE_MONSTER_RELIVE success");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */