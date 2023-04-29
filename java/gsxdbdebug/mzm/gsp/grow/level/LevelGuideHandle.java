/*    */ package mzm.gsp.grow.level;
/*    */ 
/*    */ import mzm.gsp.grow.LevelGuide.LevelGuideManager;
/*    */ import mzm.gsp.grow.LevelGuide.PFinishLevelGoal;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ public class LevelGuideHandle implements mzm.gsp.grow.hand.TargetHandle
/*    */ {
/*    */   static volatile LevelGuideHandle instance;
/*    */   
/*    */   public static LevelGuideHandle getInstance()
/*    */   {
/* 16 */     if (instance == null)
/*    */     {
/* 18 */       synchronized (LevelGuideHandle.class)
/*    */       {
/* 20 */         if (instance == null)
/*    */         {
/* 22 */           instance = new LevelGuideHandle();
/*    */         }
/*    */       }
/*    */     }
/* 26 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isGoalValid(long roleId, int goalId)
/*    */   {
/* 32 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(roleId));
/* 33 */     if (xGuidesInfo == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     LevelGuideInfo xInfo = LevelGuideManager.getXInfo(goalId, xGuidesInfo);
/* 38 */     if (xInfo.getTargetstate() != 1)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setParam(long roleId, int goalId, int param)
/*    */   {
/* 48 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(roleId));
/* 49 */     if (xGuidesInfo == null)
/*    */     {
/* 51 */       return;
/*    */     }
/* 53 */     LevelGuideInfo xInfo = LevelGuideManager.getXInfo(goalId, xGuidesInfo);
/* 54 */     if (xInfo.getTargetstate() != 1)
/*    */     {
/* 56 */       return;
/*    */     }
/* 58 */     xInfo.setTargetparam(param);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getParam(long roleId, int goalId)
/*    */   {
/* 64 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(roleId));
/* 65 */     if (xGuidesInfo == null)
/*    */     {
/* 67 */       return -1;
/*    */     }
/* 69 */     LevelGuideInfo xInfo = LevelGuideManager.getXInfo(goalId, xGuidesInfo);
/* 70 */     if (xInfo.getTargetstate() != 1)
/*    */     {
/* 72 */       return -1;
/*    */     }
/* 74 */     return xInfo.getTargetparam();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCanFinishTarget(long roleId, int goalId)
/*    */   {
/* 80 */     LogicProcedure p = new PFinishLevelGoal(roleId, goalId);
/* 81 */     if (!p.call())
/*    */     {
/* 83 */       return false;
/*    */     }
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\level\LevelGuideHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */