/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.PlantTreeInfo;
/*    */ import xbean.RolePlantTreeInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role_plant_tree_infos;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((Long)this.arg).longValue();
/* 20 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 22 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 24 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 26 */     OnlineRewardPointObserverManager.getInstance().stopAllObserver(roleid);
/*    */     
/* 28 */     for (SPlantTreeCfg cfg : SPlantTreeCfg.getAll().values())
/*    */     {
/* 30 */       int activityCfgid = cfg.activity_cfg_id;
/* 31 */       RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(roleid));
/* 32 */       if (xRolePlantTreeInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 36 */         PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(activityCfgid));
/* 37 */         if (xPlantTreeInfo != null)
/*    */         {
/*    */ 
/*    */ 
/* 41 */           if ((xPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*    */           {
/*    */ 
/*    */ 
/* 45 */             Session.removeSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid(), roleid);
/*    */           }
/* 47 */           xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/*    */         } } }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */