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
/*    */ public class PAddAuraBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int subBuffCfgId;
/*    */   
/*    */   public PAddAuraBuff(long roleId, int auraBuffCfgId, int subBuffCfgId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.subBuffCfgId = subBuffCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 26 */     if (teamInfo == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     lock(Basic.getTable(), teamInfo.getTeamMemberList());
/*    */     
/*    */ 
/* 33 */     BuffManager.uninstallBuff(this.roleId, this.subBuffCfgId);
/*    */     
/* 35 */     Map<Long, List<RoleBuffList>> roleBuffListMap = BuffManager.getRoleBuffListMap(teamInfo.getTeamMemberList());
/* 36 */     if ((roleBuffListMap == null) || (roleBuffListMap.size() == 0)) {
/* 37 */       return false;
/*    */     }
/* 39 */     BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, null);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PAddAuraBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */