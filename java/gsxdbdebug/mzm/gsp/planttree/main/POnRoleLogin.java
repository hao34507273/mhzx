/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PlantTreeInfo;
/*    */ import xbean.RolePlantTreeInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role_plant_tree_infos;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     long roleid = ((Long)this.arg).longValue();
/* 28 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/* 30 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 32 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 34 */     for (SPlantTreeCfg cfg : SPlantTreeCfg.getAll().values())
/*    */     {
/* 36 */       int activityCfgid = cfg.activity_cfg_id;
/* 37 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid);
/*    */       
/* 39 */       if (activityJoinResult.isCanJoin())
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 44 */         RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(roleid));
/* 45 */         if (xRolePlantTreeInfo != null)
/*    */         {
/*    */ 
/*    */ 
/* 49 */           PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(activityCfgid));
/* 50 */           if (xPlantTreeInfo != null)
/*    */           {
/*    */ 
/*    */ 
/* 54 */             OnlineManager.getInstance().send(roleid, PlantTreeManager.fillPlantTreeDetailInfo(roleid, activityCfgid, xPlantTreeInfo));
/*    */             
/* 56 */             OnlineManager.getInstance().send(roleid, PlantTreeManager.fillRolePlantTreeInfo(roleid, activityCfgid, xPlantTreeInfo));
/*    */             
/*    */ 
/* 59 */             if (PlantTreeManager.isPlantTreeSwitchOpenForRole(roleid, activityCfgid))
/*    */             {
/*    */ 
/*    */ 
/* 63 */               if ((xPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*    */               {
/*    */ 
/*    */ 
/* 67 */                 Session.removeSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid(), roleid);
/*    */               }
/* 69 */               xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/* 70 */               if (xPlantTreeInfo.getSpecial_state_index() <= 0)
/*    */               {
/* 72 */                 xPlantTreeInfo.setSpecial_state_refresh_sessionid(new SpecialStateRefreshSession(cfg.special_state_refresh_interval * 60L, roleid, activityCfgid).getSessionId());
/*    */               }
/*    */               
/*    */ 
/* 76 */               if ((xPlantTreeInfo.getSpecial_state_index() <= 0) && (PlantTreeManager.getActivityNeedPoint(activityCfgid, xPlantTreeInfo) > 0))
/*    */               {
/*    */ 
/* 79 */                 OnlineRewardPointObserverManager.getInstance().startObserver(roleid, activityCfgid);
/*    */               }
/*    */               
/* 82 */               StringBuilder sb = new StringBuilder();
/* 83 */               sb.append(String.format("[planttree]POnRoleLogin.processImp@init activity success on role login|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*    */               
/*    */ 
/* 86 */               PlantTreeManager.logger.info(sb.toString());
/*    */             } } } } }
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */