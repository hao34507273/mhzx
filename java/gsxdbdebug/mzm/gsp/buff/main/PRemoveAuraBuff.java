/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleBuffList;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PRemoveAuraBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int auraBuffCfgId;
/*    */   private final int subBuffCfgId;
/*    */   
/*    */   public PRemoveAuraBuff(long roleId, int auraBuffCfgId, int subBuffCfgId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.auraBuffCfgId = auraBuffCfgId;
/* 22 */     this.subBuffCfgId = subBuffCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 28 */     if (teamInfo == null) {
/* 29 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 33 */     lock(Basic.getTable(), teamInfo.getTeamMemberList());
/* 34 */     Map<Long, List<RoleBuffList>> roleBuffListMap = BuffManager.getRoleBuffListMap(teamInfo.getTeamMemberList());
/* 35 */     if ((roleBuffListMap == null) || (roleBuffListMap.size() == 0)) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     BuffManager.removeStateBuffWhenTeamAuraChange(teamInfo, this.roleId, Integer.valueOf(this.auraBuffCfgId), Integer.valueOf(this.subBuffCfgId));
/* 40 */     BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, null);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PRemoveAuraBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */