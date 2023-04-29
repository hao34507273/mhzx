/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PShengChanGoal
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int goalId;
/*     */   private final LifeSkillArg arg;
/*     */   private final int type;
/*     */   public static final int LIAN_YAO = 1;
/*     */   public static final int PENG_REN = 2;
/*     */   public static final int FU_MO_FU = 3;
/*     */   
/*     */   public PShengChanGoal(long roleId, int goalId, LifeSkillArg arg, int type)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.goalId = goalId;
/*  32 */     this.arg = arg;
/*  33 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     String userId = RoleInterface.getUserId(this.roleId);
/*  41 */     lock(Lockeys.get(User.getTable(), userId));
/*  42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  43 */     SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  44 */     if (cfg == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     int moduleType = cfg.moduleType;
/*  49 */     TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  50 */     if (handler == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     int xNum = handler.getParam(this.roleId, this.goalId);
/*  59 */     if (xNum < 0)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     List<GoalParameter> goalParameters = cfg.goalParameters;
/*  65 */     int count = ((GoalParameter)goalParameters.get(0)).parameter;
/*  66 */     if (count < 0)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     int realStar = ItemInterface.getItemPro(this.arg.itemId);
/*  71 */     if (!canAddParam(goalParameters, realStar))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     handler.setParam(this.roleId, this.goalId, xNum + 1);
/*     */     
/*  77 */     if (xNum + 1 >= count)
/*     */     {
/*  79 */       if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */       {
/*  81 */         return false;
/*     */       }
/*     */     }
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canAddParam(List<GoalParameter> goalParameters, int realStar)
/*     */   {
/*  89 */     int level = ((GoalParameter)goalParameters.get(1)).parameter;
/*  90 */     if (level < 0)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!LevelGuideManager.checkLevel(level, realStar))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (goalParameters.size() > 3)
/*     */     {
/* 102 */       int itemType = ((GoalParameter)goalParameters.get(2)).parameter;
/* 103 */       if ((itemType > 0) && (itemType != this.type))
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PShengChanGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */