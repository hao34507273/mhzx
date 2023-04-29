/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.MultiRoleMounts;
/*    */ 
/*    */ 
/*    */ public class POnTeamCreate
/*    */   extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 17 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(((TeamCreateArg)this.arg).getLeader(), true);
/*    */     
/* 19 */     if (!TeamInterface.isTeamExit(((TeamCreateArg)this.arg).teamid, true))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     MultiRoleMounts xMultiRoleMounts = MultiRoleMountsManager.newMultiRoleMounts(((TeamCreateArg)this.arg).teamid);
/*    */     
/* 26 */     int mountsCfgId = rideMountsObj.getMountsCfgId();
/* 27 */     if (mountsCfgId != 0)
/*    */     {
/* 29 */       xMultiRoleMounts.getRole_ids().add(Long.valueOf(((TeamCreateArg)this.arg).getLeader()));
/*    */     }
/* 31 */     xMultiRoleMounts.setMounts_cfg_id(mountsCfgId);
/*    */     
/*    */ 
/* 34 */     if (!OpenInterface.getOpenStatus(409))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     MultiRoleMountsManager.triggerMultiRoleMountsChangeViaTeam(((TeamCreateArg)this.arg).teamid, mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.TEAM_INFO_CHANGE);
/*    */     
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */