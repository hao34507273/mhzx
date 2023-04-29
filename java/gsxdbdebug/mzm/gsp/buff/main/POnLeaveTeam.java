/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     TeamInfo teamInfo = mzm.gsp.team.main.TeamInterface.getTeamInfo(((LeaveTeamArg)this.arg).teamid, false);
/* 18 */     if (teamInfo == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     List<Long> roleSet = new ArrayList();
/* 22 */     roleSet.add(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 23 */     roleSet.addAll(teamInfo.getTeamMemberList());
/*    */     
/* 25 */     lock(Basic.getTable(), roleSet);
/* 26 */     Map<Long, List<xbean.RoleBuffList>> roleBuffListMap = BuffManager.getRoleBuffListMap(roleSet);
/* 27 */     if ((roleBuffListMap == null) || (roleBuffListMap.size() == 0)) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     Map<Integer, Integer> selfAuraMap = BuffManager.getAuraBuffMap((List)roleBuffListMap.get(Long.valueOf(((LeaveTeamArg)this.arg).roleid)));
/*    */     
/* 33 */     if (selfAuraMap.size() > 0) {
/* 34 */       for (Map.Entry<Integer, Integer> entry : selfAuraMap.entrySet()) {
/* 35 */         BuffManager.removeStateBuffWhenTeamAuraChange(teamInfo, ((LeaveTeamArg)this.arg).roleid, (Integer)entry.getValue(), (Integer)entry.getKey());
/*    */       }
/* 37 */       BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/*    */     }
/*    */     
/*    */ 
/* 41 */     Set<Integer> auraBuffSet = new java.util.HashSet();
/* 42 */     Map<Long, Map<Integer, Integer>> auraBuffMap = BuffManager.getTeamAuraBuffMap(roleBuffListMap, teamInfo);
/* 43 */     for (Map.Entry<Long, Map<Integer, Integer>> auraMapEntry : auraBuffMap.entrySet()) {
/* 44 */       for (Map.Entry<Integer, Integer> entry : ((Map)auraMapEntry.getValue()).entrySet()) {
/* 45 */         auraBuffSet.add(entry.getKey());
/*    */       }
/*    */     }
/* 48 */     if (auraBuffSet.size() > 0) {
/* 49 */       for (Integer removeBuffid : auraBuffSet) {
/* 50 */         BuffInterface.uninstallBufAsyc(((LeaveTeamArg)this.arg).roleid, removeBuffid.intValue());
/*    */       }
/*    */     }
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */