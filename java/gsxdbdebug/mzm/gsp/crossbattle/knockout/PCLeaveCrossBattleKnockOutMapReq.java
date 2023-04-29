/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCLeaveCrossBattleKnockOutMapReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   
/*    */   public PCLeaveCrossBattleKnockOutMapReq(long roleId, int activityCfgId, int knockOutType)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.activityCfgId = activityCfgId;
/* 25 */     this.knockOutType = knockOutType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1552, true))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 36 */     if (sCrossBattleKnockOutCfg == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 42 */     if (knockOutCfg == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     long worldInstanceId = MapInterface.getRoleWorldInstanceId(this.roleId);
/* 48 */     if (worldInstanceId != CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId().longValue())
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     Set<Long> roleIdSet = new HashSet();
/*    */     
/* 55 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 56 */     if (teamId != null)
/*    */     {
/* 58 */       List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 59 */       roleIdSet.addAll(teamRoleIdList);
/*    */     }
/* 61 */     roleIdSet.add(Long.valueOf(this.roleId));
/*    */     
/* 63 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/* 64 */     for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 66 */       RoleStatusInterface.unsetStatus(teamRoleId, 1551);
/*    */     }
/*    */     
/* 69 */     MapInterface.forceTransferToScene(this.roleId, MapInterface.getCenterWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y);
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCLeaveCrossBattleKnockOutMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */