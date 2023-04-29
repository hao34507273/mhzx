/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*    */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.RoleBuffList;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(((TeamMemberStatusChangedArg)this.arg).teamid, false);
/* 19 */     if (teamInfo == null) {
/* 20 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 24 */     lock(Basic.getTable(), teamInfo.getTeamMemberList());
/* 25 */     Map<Long, List<RoleBuffList>> roleBuffListMap = BuffManager.getRoleBuffListMap(teamInfo.getTeamMemberList());
/* 26 */     if ((roleBuffListMap == null) || (roleBuffListMap.size() == 0)) {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     if ((((TeamMemberStatusChangedArg)this.arg).oldStatus == 0) && ((((TeamMemberStatusChangedArg)this.arg).status == 1) || (((TeamMemberStatusChangedArg)this.arg).status == 2))) {
/* 32 */       Map<Integer, Integer> selfAuraMap = BuffManager.getAuraBuffMap((List)roleBuffListMap.get(Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid)));
/*    */       
/* 34 */       if (selfAuraMap.size() > 0) {
/* 35 */         for (Map.Entry<Integer, Integer> entry : selfAuraMap.entrySet()) {
/* 36 */           BuffManager.removeStateBuffWhenTeamAuraChange(teamInfo, ((TeamMemberStatusChangedArg)this.arg).roleid, (Integer)entry.getValue(), (Integer)entry.getKey());
/*    */         }
/* 38 */         BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid));
/*    */       }
/*    */       
/*    */ 
/* 42 */       Set<Integer> auraBuffSet = new java.util.HashSet();
/* 43 */       Map<Long, Map<Integer, Integer>> auraBuffMap = BuffManager.getTeamAuraBuffMap(roleBuffListMap, teamInfo);
/* 44 */       for (Map.Entry<Long, Map<Integer, Integer>> auraMapEntry : auraBuffMap.entrySet()) {
/* 45 */         for (Map.Entry<Integer, Integer> entry : ((Map)auraMapEntry.getValue()).entrySet()) {
/* 46 */           auraBuffSet.add(entry.getKey());
/*    */         }
/*    */       }
/* 49 */       if (auraBuffSet.size() > 0) {
/* 50 */         for (Integer removeBuffid : auraBuffSet) {
/* 51 */           BuffInterface.uninstallBufAsyc(((TeamMemberStatusChangedArg)this.arg).roleid, removeBuffid.intValue());
/*    */         }
/*    */       }
/*    */       
/* 55 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 59 */     if ((((TeamMemberStatusChangedArg)this.arg).status == 0) && ((((TeamMemberStatusChangedArg)this.arg).oldStatus == 1) || (((TeamMemberStatusChangedArg)this.arg).oldStatus == 2))) {
/* 60 */       BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, null);
/*    */     }
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */