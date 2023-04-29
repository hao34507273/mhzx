/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.lonngboatrace.SRejectJoin;
/*     */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceStat;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2lonngboatrace;
/*     */ 
/*     */ public class PCEntryLonngBoatRaceActivity extends PCJoinLonngBoatRaceActivity
/*     */ {
/*     */   public PCEntryLonngBoatRaceActivity(long roleId, int activityId, int raceid)
/*     */   {
/*  29 */     super(roleId, activityId, raceid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean doAction(long teamId, List<Long> memberList)
/*     */   {
/*  41 */     Map<Integer, Phase> phaseNo2phase = LonngBoatRaceManager.getPhaseNo2phase(this.raceId);
/*  42 */     ArrayList<String> params = new ArrayList();
/*  43 */     if (phaseNo2phase == null)
/*     */     {
/*  45 */       GameServer.logger().error(String.format("[lonngboatrace]PCEntryLonngBoatRaceActivity.doAction@lonngboatrace phaseNo2phase is null|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) }));
/*     */       
/*     */ 
/*  48 */       params.add(String.valueOf(this.raceId));
/*  49 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(2, params));
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     mzm.gsp.status.main.RoleStatusInterface.setStatus(memberList, 1361, true);
/*     */     
/*  56 */     for (Long roleid : memberList) {
/*  57 */       ActivityInterface.logActivity(roleid.longValue(), this.activityId, ActivityLogStatus.ATTEND);
/*     */     }
/*  59 */     long beginTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  62 */     Long lonngboatraceId = initLonngBoatRaceMatch(Arrays.asList(new Long[] { Long.valueOf(teamId) }), this.raceId, this.activityId, beginTimeStamp);
/*  63 */     if (lonngboatraceId == null)
/*     */     {
/*  65 */       GameServer.logger().error(String.format("[lonngboatrace]PCEntryLonngBoatRaceActivity.doAction@lonngboatrace initLonngBoatRaceMatch fail|roleid=%d|activityid=%d|raceid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.raceId) }));
/*     */       
/*     */ 
/*  68 */       params.add(String.valueOf(this.raceId));
/*  69 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRejectJoin(2, params));
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     OnlineManager.getInstance().sendMulti(new mzm.gsp.lonngboatrace.SEntry(this.raceId, beginTimeStamp), memberList);
/*     */     
/*     */ 
/*  77 */     new PhaseAction(phaseNo2phase, lonngboatraceId.longValue()).prepare();
/*     */     
/*  79 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Long initLonngBoatRaceMatch(List<Long> teamIds, int raceId, int activityId, long beginTimeStamp)
/*     */   {
/*  92 */     LonngBoatRaceCfg raceCfg = LonngBoatRaceCfg.get(raceId);
/*  93 */     if (raceCfg == null)
/*  94 */       return null;
/*  95 */     if (raceCfg.teamCount != teamIds.size()) {
/*  96 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 100 */     List<Long> roleIdList = getRoleIdsFromTeamIdList(teamIds);
/* 101 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 103 */       Long lonngboatraceId = Role2lonngboatrace.get(Long.valueOf(roleId));
/*     */       
/* 105 */       if (lonngboatraceId != null) {
/* 106 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 110 */     int AIBoatCount = raceCfg.trackCount - raceCfg.teamCount;
/* 111 */     List<Long> allTeamId = new LinkedList();
/* 112 */     genAITeamId(AIBoatCount, allTeamId);
/*     */     
/*     */ 
/* 115 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Pod.newLonngBoatRaceMatch();
/* 116 */     xLonngBoatRaceMatch.setActivityid(activityId);
/* 117 */     xLonngBoatRaceMatch.setRaceid(raceId);
/* 118 */     xLonngBoatRaceMatch.setPhaseno(1);
/* 119 */     xLonngBoatRaceMatch.setRoundno(1);
/* 120 */     xLonngBoatRaceMatch.setTimesno(0);
/* 121 */     xLonngBoatRaceMatch.setMatchbegintimestamp(beginTimeStamp);
/* 122 */     Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/* 123 */     allTeamId.addAll(teamIds);
/* 124 */     initLonngBoatRaceTeamStat(allTeamId, teamId2TeamStat);
/* 125 */     Long lonngboatraceId = xtable.Lonngboatrace.insert(xLonngBoatRaceMatch);
/*     */     
/*     */ 
/* 128 */     for (Long roleId : roleIdList) {
/* 129 */       Role2lonngboatrace.insert(roleId, lonngboatraceId);
/*     */     }
/* 131 */     return lonngboatraceId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void initLonngBoatRaceTeamStat(List<Long> teamIds, Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat)
/*     */   {
/* 147 */     for (Iterator i$ = teamIds.iterator(); i$.hasNext();) { long teamId = ((Long)i$.next()).longValue();
/*     */       
/* 149 */       LonngBoatRaceTeamStat xTeamStat = Pod.newLonngBoatRaceTeamStat();
/* 150 */       teamId2TeamStat.put(Long.valueOf(teamId), xTeamStat);
/*     */       
/* 152 */       if (teamId > 0L)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 157 */         List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId, true);
/* 158 */         if ((teamMemberList != null) && (teamMemberList.size() != 0))
/*     */         {
/*     */ 
/* 161 */           role2stat = xTeamStat.getRole2stat();
/* 162 */           role2stat_phase = xTeamStat.getRole2stat_phase();
/* 163 */           for (i$ = teamMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */             
/* 165 */             role2stat.put(Long.valueOf(roleId), Pod.newLonngBoatRaceStat());
/* 166 */             role2stat_phase.put(Long.valueOf(roleId), Pod.newLonngBoatRaceStat());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     Map<Long, LonngBoatRaceStat> role2stat;
/*     */     Map<Long, LonngBoatRaceStat> role2stat_phase;
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */   private static void genAITeamId(int AIBoatCount, List<Long> allTeamId)
/*     */   {
/* 179 */     long AITeamIdInit = -1L;
/* 180 */     for (int i = 0; i < AIBoatCount; i++)
/*     */     {
/* 182 */       allTeamId.add(Long.valueOf(-1L - i));
/*     */     }
/*     */   }
/*     */   
/*     */   static List<Long> getRoleIdsFromTeamIdList(List<Long> teamIdList)
/*     */   {
/* 188 */     List<Long> result = new LinkedList();
/*     */     
/* 190 */     for (Long teamId : teamIdList)
/*     */     {
/*     */ 
/* 193 */       if (teamId.longValue() >= 0L)
/*     */       {
/*     */ 
/*     */ 
/* 197 */         List<Long> memberList = TeamInterface.getTeamMemberList(teamId.longValue(), true);
/* 198 */         if (memberList != null)
/*     */         {
/* 200 */           result.addAll(memberList); }
/*     */       } }
/* 202 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\PCEntryLonngBoatRaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */