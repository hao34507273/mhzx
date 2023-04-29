/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 22 */     long newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/* 23 */     if (!OnlineManager.getInstance().isOnline(roleid))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     for (SPlantTreeCfg cfg : SPlantTreeCfg.getAll().values())
/*    */     {
/* 29 */       int activityCfgid = cfg.activity_cfg_id;
/* 30 */       if ((PlantTreeManager.isPlantTreeSwitchOpen(activityCfgid)) && 
/*    */       
/*    */ 
/*    */ 
/* 34 */         (ActivityInterface.isActivityOpen(activityCfgid)))
/*    */       {
/*    */ 
/*    */ 
/* 38 */         if (newLevel == ActivityInterface.getActivityLevelMin(activityCfgid))
/*    */         {
/* 40 */           PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PInitActivity(roleid, activityCfgid));
/*    */ 
/*    */         }
/* 43 */         else if (newLevel == ActivityInterface.getActivityLevelMax(activityCfgid) + 1)
/*    */         {
/* 45 */           PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PStopActivity(roleid, activityCfgid));
/*    */         }
/*    */       }
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */