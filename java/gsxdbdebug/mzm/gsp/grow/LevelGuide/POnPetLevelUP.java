/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.pet.event.PlayerPetLevelUpProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
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
/*     */ public class POnPetLevelUP
/*     */   extends PlayerPetLevelUpProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   class PPetLvUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     private final int petType;
/*     */     private final int petLv;
/*     */     
/*     */     public PPetLvUp(long roleId, int goalId, int petType, int petLv)
/*     */     {
/*  54 */       this.roleId = roleId;
/*  55 */       this.goalId = goalId;
/*  56 */       this.petType = petType;
/*  57 */       this.petLv = petLv;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  64 */       String userId = RoleInterface.getUserId(this.roleId);
/*  65 */       lock(Lockeys.get(User.getTable(), userId));
/*  66 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  67 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  68 */       if (cfg == null)
/*     */       {
/*  70 */         return false;
/*     */       }
/*  72 */       int moduleType = cfg.moduleType;
/*  73 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  74 */       if (handler == null)
/*     */       {
/*  76 */         return false;
/*     */       }
/*  78 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       int xNum = handler.getParam(this.roleId, this.goalId);
/*  84 */       if (xNum < 0)
/*     */       {
/*  86 */         return false;
/*     */       }
/*     */       
/*  89 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  90 */       int count = ((GoalParameter)goalParameters.get(1)).parameter;
/*  91 */       if (count < 0)
/*     */       {
/*  93 */         return false;
/*     */       }
/*  95 */       int needLevel = ((GoalParameter)goalParameters.get(2)).parameter;
/*  96 */       if (needLevel < 0)
/*     */       {
/*  98 */         return false;
/*     */       }
/* 100 */       if (this.petLv != needLevel)
/*     */       {
/* 102 */         return false;
/*     */       }
/* 104 */       List<Integer> petTypes = LevelGuideManager.getPetTypes(cfg);
/* 105 */       if ((petTypes == null) || (petTypes.size() == 0))
/*     */       {
/* 107 */         return false;
/*     */       }
/* 109 */       if (petTypes.contains(Integer.valueOf(this.petType)))
/*     */       {
/* 111 */         handler.setParam(this.roleId, this.goalId, xNum + 1);
/*     */       }
/*     */       else
/*     */       {
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       if (xNum + 1 >= count)
/*     */       {
/* 120 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 122 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnPetLevelUP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */