/*    */ package mzm.gsp.axe.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.axe.SSynAxeActivityInfo;
/*    */ import mzm.gsp.axe.confbean.SAxeAvtivityCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.AxeActivityInfo;
/*    */ import xbean.UserAxeActivityInfo;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 19 */     int oldLevel = ((RoleLevelUpArg)this.arg).oldLevel;
/* 20 */     int newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/*    */     
/* 22 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/* 24 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 26 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 28 */     SSynAxeActivityInfo protocol = new SSynAxeActivityInfo();
/* 29 */     for (SAxeAvtivityCfg cfg : SAxeAvtivityCfg.getAll().values())
/*    */     {
/* 31 */       if ((oldLevel < ActivityInterface.getActivityLevelMin(cfg.activity_cfg_id)) && (newLevel >= ActivityInterface.getActivityLevelMin(cfg.activity_cfg_id)) && (newLevel <= ActivityInterface.getActivityLevelMax(cfg.activity_cfg_id)))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 38 */         mzm.gsp.activity.main.ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, cfg.activity_cfg_id);
/*    */         
/* 40 */         if (activityJoinResult.isCanJoin())
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 45 */           AxeManager.initData(userid, cfg.activity_cfg_id);
/*    */           
/* 47 */           UserAxeActivityInfo xUserAxeActivityInfo = xtable.User_axe_activity_infos.get(userid);
/* 48 */           if (xUserAxeActivityInfo == null)
/*    */           {
/*    */ 
/* 51 */             return false;
/*    */           }
/* 53 */           AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/* 54 */           if (xAxeActivityInfo == null)
/*    */           {
/*    */ 
/* 57 */             return false;
/*    */           }
/* 59 */           protocol.activity_infos.put(Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf((int)(xAxeActivityInfo.getStart_timestamp() / 1000L)));
/*    */         } } }
/* 61 */     if (!protocol.activity_infos.isEmpty())
/*    */     {
/* 63 */       OnlineManager.getInstance().send(roleid, protocol);
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */