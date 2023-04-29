/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.pet.event.PetFanShengEventArg;
/*     */ import mzm.gsp.pet.event.PetFanShengProcedure;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPetFanSheng extends PetFanShengProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     int goalType = 3;
/*  23 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  24 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  31 */       new PPetFanSheng(((PetFanShengEventArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   class PPetFanSheng
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PPetFanSheng(long roleId, int goalId)
/*     */     {
/*  45 */       this.roleId = roleId;
/*  46 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  53 */       String userId = RoleInterface.getUserId(this.roleId);
/*  54 */       lock(Lockeys.get(User.getTable(), userId));
/*  55 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  56 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  57 */       if (cfg == null)
/*     */       {
/*  59 */         return false;
/*     */       }
/*  61 */       int moduleType = cfg.moduleType;
/*  62 */       TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/*  63 */       if (handler == null)
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  69 */         return false;
/*     */       }
/*  71 */       int xNum = handler.getParam(this.roleId, this.goalId);
/*  72 */       if (xNum < 0)
/*     */       {
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  78 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/*  79 */       if (count < 0)
/*     */       {
/*  81 */         return false;
/*     */       }
/*  83 */       if (isSkillNumOk(goalParameters))
/*     */       {
/*  85 */         handler.setParam(this.roleId, this.goalId, xNum + 1);
/*  86 */         if (xNum + 1 >= count)
/*     */         {
/*  88 */           if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */           {
/*  90 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  95 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getPetSkillsNum(long petId)
/*     */     {
/* 106 */       List<Integer> skills = PetInterface.getPetSkillList(this.roleId, petId);
/* 107 */       return skills.size();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getCfgSkillNum(List<GoalParameter> goalParameters)
/*     */     {
/* 118 */       if (goalParameters.size() < 2)
/*     */       {
/* 120 */         return -1;
/*     */       }
/* 122 */       int skillNum = ((GoalParameter)goalParameters.get(1)).parameter;
/* 123 */       if (skillNum < 0)
/*     */       {
/* 125 */         return -1;
/*     */       }
/* 127 */       return skillNum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     boolean isSkillNumOk(List<GoalParameter> goalParameters)
/*     */     {
/* 139 */       int petSkillNum = ((PetFanShengEventArg)POnPetFanSheng.this.arg).newPetSkillIdList.size();
/* 140 */       int needNum = getCfgSkillNum(goalParameters);
/* 141 */       return petSkillNum >= needNum;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnPetFanSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */