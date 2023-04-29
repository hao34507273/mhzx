/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.partner.event.LineUpPartnerEventArg;
/*     */ import mzm.gsp.partner.event.LineUpPartnerProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnLineUpPartner extends LineUpPartnerProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     int goalType = 601;
/*  22 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  23 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  25 */       return false;
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
/*  60 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  62 */       new PLineUpPartner(((LineUpPartnerEventArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*     */     
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   class PLineUpPartner
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PLineUpPartner(long roleId, int goalId)
/*     */     {
/*  76 */       this.roleId = roleId;
/*  77 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  84 */       String userId = RoleInterface.getUserId(this.roleId);
/*  85 */       lock(Lockeys.get(User.getTable(), userId));
/*  86 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  87 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  88 */       if (cfg == null)
/*     */       {
/*  90 */         return false;
/*     */       }
/*  92 */       int moduleType = cfg.moduleType;
/*  93 */       TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/*  94 */       if (handler == null)
/*     */       {
/*  96 */         return false;
/*     */       }
/*  98 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 100 */         return false;
/*     */       }
/* 102 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 103 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 104 */       if (count < 0)
/*     */       {
/* 106 */         return false;
/*     */       }
/* 108 */       if (((LineUpPartnerEventArg)POnLineUpPartner.this.arg).getLineUpMembersNum() >= count)
/*     */       {
/* 110 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 112 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 116 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnLineUpPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */