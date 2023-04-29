/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.worldgoal.SSyncRoleWorldGoalInfo;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import mzm.gsp.worldgoal.confbean.SectionInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 26 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 27 */     lock(Lockeys.get(User.getTable(), userid));
/* 28 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 30 */     SSyncRoleWorldGoalInfo protocol = new SSyncRoleWorldGoalInfo();
/* 31 */     for (Iterator i$ = SWorldGoalCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 34 */       int count = ActivityInterface.getActivityCount(userid, roleid, activityCfgid, true);
/* 35 */       if (count >= 0)
/*    */       {
/* 37 */         protocol.role_world_goal_info.put(Integer.valueOf(activityCfgid), Integer.valueOf(count));
/*    */       }
/*    */       
/* 40 */       WorldGoalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSendAwardMailOnRoleLogin(roleid, activityCfgid));
/*    */       
/*    */ 
/* 43 */       cfg = SWorldGoalCfg.get(activityCfgid);
/* 44 */       if (cfg.transfer_map_cfg_id > 0)
/*    */       {
/* 46 */         if ((!WorldGoalManager.isWorldGoalSwitchOpenForRole(roleid, activityCfgid)) || (ActivityInterface.getActivityLimitTimeStage(activityCfgid, DateTimeUtils.getCurrTimeInMillis()) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW))
/*    */         {
/*    */ 
/*    */ 
/* 50 */           for (SectionInfo sectionInfo : cfg.section_infos.values())
/*    */           {
/* 52 */             if (MapInterface.getRoleMapId(roleid) == sectionInfo.map_cfg_id)
/*    */             {
/* 54 */               MapInterface.forceTransferToScene(roleid, MapInterface.getBigWorldid(), cfg.transfer_map_cfg_id, cfg.transfer_x, cfg.transfer_y);
/*    */               
/* 56 */               break;
/*    */             } }
/*    */         }
/*    */       }
/*    */     }
/*    */     SWorldGoalCfg cfg;
/* 62 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */