/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.chat.event.ChatInChannelArg;
/*     */ import mzm.gsp.chat.event.ChatInChannelProcedure;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
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
/*     */ public class POnChatInChannel
/*     */   extends ChatInChannelProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     if (((ChatInChannelArg)this.arg).getChannel() != 2)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     int goalType = 1200;
/*  33 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  34 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  36 */       return false;
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
/*  75 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  77 */       new PChatGang(((ChatInChannelArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   class PChatGang
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PChatGang(long roleId, int goalId)
/*     */     {
/*  91 */       this.roleId = roleId;
/*  92 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  99 */       String userId = RoleInterface.getUserId(this.roleId);
/* 100 */       lock(Lockeys.get(User.getTable(), userId));
/* 101 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 102 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 103 */       if (cfg == null)
/*     */       {
/* 105 */         return false;
/*     */       }
/* 107 */       int moduleType = cfg.moduleType;
/* 108 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 109 */       if (handler == null)
/*     */       {
/* 111 */         return false;
/*     */       }
/* 113 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 115 */         return false;
/*     */       }
/* 117 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 118 */       if (xNum < 0)
/*     */       {
/* 120 */         return false;
/*     */       }
/* 122 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 123 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 124 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 125 */       if (count < 0)
/*     */       {
/* 127 */         return false;
/*     */       }
/* 129 */       if (xNum + 1 >= count)
/*     */       {
/* 131 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 133 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 137 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnChatInChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */