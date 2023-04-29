/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PlayerAddPetProcedure;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnPlayerAddPet
/*     */   extends PlayerAddPetProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     int goalType = 2;
/*  29 */     Pet pet = PetInterface.getPetByPetId(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId, false);
/*  30 */     if (pet == null)
/*     */     {
/*  32 */       return false;
/*     */     }
/*  34 */     int petType = pet.getPetType();
/*  35 */     int petLevel = pet.getLevel();
/*  36 */     int ownLv = pet.getCarrayLevel();
/*  37 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  38 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  45 */       new PPetOwn(((PetEventArg)this.arg).roleId, goalId, petType, petLevel, ownLv).execute();
/*     */     }
/*     */     
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   class PPetOwn
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     private final int petType;
/*     */     private final int petLv;
/*     */     private final int ownLv;
/*     */     
/*     */     public PPetOwn(long roleId, int goalId, int petType, int petLv, int ownLv)
/*     */     {
/*  62 */       this.roleId = roleId;
/*  63 */       this.goalId = goalId;
/*  64 */       this.petType = petType;
/*  65 */       this.petLv = petLv;
/*  66 */       this.ownLv = ownLv;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  73 */       String userId = RoleInterface.getUserId(this.roleId);
/*  74 */       lock(Lockeys.get(User.getTable(), userId));
/*  75 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  76 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  77 */       if (cfg == null)
/*     */       {
/*  79 */         return false;
/*     */       }
/*  81 */       int moduleType = cfg.moduleType;
/*  82 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  83 */       if (handler == null)
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       int xNum = handler.getParam(this.roleId, this.goalId);
/*  93 */       if (xNum < 0)
/*     */       {
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  99 */       int count = ((GoalParameter)goalParameters.get(1)).parameter;
/* 100 */       if (count < 0)
/*     */       {
/* 102 */         return false;
/*     */       }
/* 104 */       int needLevel = ((GoalParameter)goalParameters.get(2)).parameter;
/* 105 */       if (needLevel < 0)
/*     */       {
/* 107 */         return false;
/*     */       }
/* 109 */       if (!isLvOk(needLevel, this.petLv, this.ownLv))
/*     */       {
/* 111 */         return false;
/*     */       }
/* 113 */       List<Integer> petTypes = LevelGuideManager.getPetTypes(cfg);
/* 114 */       if ((petTypes == null) || (petTypes.size() == 0))
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       if (petTypes.contains(Integer.valueOf(this.petType)))
/*     */       {
/* 120 */         handler.setParam(this.roleId, this.goalId, xNum + 1);
/*     */       }
/*     */       else
/*     */       {
/* 124 */         return false;
/*     */       }
/*     */       
/* 127 */       if (xNum + 1 >= count)
/*     */       {
/* 129 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 131 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 135 */       return true;
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
/*     */     private boolean isLvOk(int needLevel, int petLv, int ownLv)
/*     */     {
/* 150 */       if (needLevel == 0)
/*     */       {
/* 152 */         return true;
/*     */       }
/* 154 */       if (ownLv != needLevel)
/*     */       {
/* 156 */         return false;
/*     */       }
/* 158 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnPlayerAddPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */