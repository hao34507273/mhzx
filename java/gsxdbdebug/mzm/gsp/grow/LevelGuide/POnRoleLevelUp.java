/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*    */ import mzm.gsp.grow.daytarget.POnRoleLvUp;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 18 */     int goalType = 4500;
/* 19 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(4500);
/* 20 */     if ((goals == null) || (goals.size() == 0))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     RoleLevelGuidesInfo xRoleLevelGuidesInfo = xtable.Role2levelguide.get(Long.valueOf(roleId));
/* 26 */     if (xRoleLevelGuidesInfo == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*    */       
/* 33 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(goalId);
/* 34 */       if (cfg == null)
/*    */       {
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       if (cfg.moduleType == 4)
/*    */       {
/* 41 */         new POnRoleLvUp(roleId, ((RoleLevelUpArg)this.arg).oldLevel, ((RoleLevelUpArg)this.arg).newLevel, goalId).execute();
/*    */       }
/*    */       
/* 44 */       LevelGuideInfo xLevelGuideInfo = (LevelGuideInfo)xRoleLevelGuidesInfo.getTargets().get(Integer.valueOf(goalId));
/* 45 */       if ((xLevelGuideInfo != null) && 
/*    */       
/*    */ 
/*    */ 
/* 49 */         (xLevelGuideInfo.getTargetstate() == 1))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 54 */         if (cfg.openLevel <= ((RoleLevelUpArg)this.arg).newLevel)
/*    */         {
/* 56 */           if (cfg.moduleType == 2)
/*    */           {
/* 58 */             LogicProcedure p = new PFinishFunctionOpenForecast(roleId, goalId);
/* 59 */             if (!p.call())
/*    */             {
/* 61 */               return false;
/*    */             }
/*    */           }
/* 64 */           else if (cfg.moduleType == 1)
/*    */           {
/* 66 */             LogicProcedure p = new PFinishLevelGoal(roleId, goalId);
/* 67 */             if (!p.call())
/*    */             {
/* 69 */               return false;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */