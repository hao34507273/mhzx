/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.event.RoleSkillArg;
/*     */ import mzm.gsp.skill.event.RoleSkillLevelUpProcedure;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleSkillLevelUp
/*     */   extends RoleSkillLevelUpProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     int goalType = 1800;
/*  29 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  30 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  32 */       return false;
/*     */     }
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
/*  82 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  84 */       new PRedeemBangGong(((RoleSkillArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  87 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkSkillLevel(int level, int oldLevel, int newLevel)
/*     */   {
/*  97 */     if (newLevel < level)
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     if (oldLevel >= level)
/*     */     {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     return true;
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
/*     */   private boolean checkSkillNum(int num, long roleId)
/*     */   {
/* 119 */     int menpai = RoleInterface.getOccupationId(roleId);
/* 120 */     List<Integer> skills = SkillInterface.getAllRoleSkillConfig(menpai);
/* 121 */     if (num >= skills.size())
/*     */     {
/* 123 */       return true;
/*     */     }
/*     */     
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   class PRedeemBangGong
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PRedeemBangGong(long roleId, int goalId)
/*     */     {
/* 137 */       this.roleId = roleId;
/* 138 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 145 */       String userId = RoleInterface.getUserId(this.roleId);
/* 146 */       lock(Lockeys.get(User.getTable(), userId));
/* 147 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 148 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 149 */       if (cfg == null)
/*     */       {
/* 151 */         return false;
/*     */       }
/* 153 */       int moduleType = cfg.moduleType;
/* 154 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 155 */       if (handler == null)
/*     */       {
/* 157 */         return false;
/*     */       }
/* 159 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 161 */         return false;
/*     */       }
/* 163 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 164 */       int level = ((GoalParameter)goalParameters.get(0)).parameter;
/* 165 */       if (level < 0)
/*     */       {
/* 167 */         return false;
/*     */       }
/* 169 */       for (Iterator i$ = ((RoleSkillArg)POnRoleSkillLevelUp.this.arg).skillBagList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */         
/* 171 */         int oldLevel = ((Integer)((RoleSkillArg)POnRoleSkillLevelUp.this.arg).oldLevelMap.get(Integer.valueOf(skillId))).intValue();
/* 172 */         int newlevel = ((Integer)((RoleSkillArg)POnRoleSkillLevelUp.this.arg).newLevelMap.get(Integer.valueOf(skillId))).intValue();
/* 173 */         if (POnRoleSkillLevelUp.this.checkSkillLevel(level, oldLevel, newlevel))
/*     */         {
/*     */ 
/*     */ 
/* 177 */           int xNum = handler.getParam(this.roleId, this.goalId);
/* 178 */           handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 179 */           if (POnRoleSkillLevelUp.this.checkSkillNum(xNum + 1, ((RoleSkillArg)POnRoleSkillLevelUp.this.arg).roleId))
/*     */           {
/* 181 */             if (handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */               break;
/* 183 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 188 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */