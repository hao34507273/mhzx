/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LonngBoatRaceMatch;
/*    */ import xbean.LonngBoatRaceTeamStat;
/*    */ import xtable.Lonngboatrace;
/*    */ import xtable.Role2lonngboatrace;
/*    */ 
/*    */ public class PCSendCommand extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int raceId;
/*    */   final int phaseNo;
/*    */   final int round;
/*    */   final int times;
/*    */   final ArrayList<Integer> receivedCommandList;
/*    */   final long roleId;
/*    */   
/*    */   public PCSendCommand(int raceId, int phaseNo, int round, int times, ArrayList<Integer> commandList, long roleId)
/*    */   {
/* 25 */     this.raceId = raceId;
/* 26 */     this.phaseNo = phaseNo;
/* 27 */     this.round = round;
/* 28 */     this.times = times;
/* 29 */     this.receivedCommandList = commandList;
/* 30 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     Long lonngboatraceId = Role2lonngboatrace.get(Long.valueOf(this.roleId));
/* 38 */     if (lonngboatraceId == null) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true).longValue();
/*    */     
/*    */ 
/* 45 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(lonngboatraceId);
/* 46 */     if (xLonngBoatRaceMatch == null) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     boolean checkMatchInfoRes = checkMatchInfo(xLonngBoatRaceMatch);
/* 51 */     if (!checkMatchInfoRes) {
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     if (xLonngBoatRaceMatch.getState() != 1) {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     boolean isCorrect = LonngBoatRaceManager.checkCommand(xLonngBoatRaceMatch.getCommandlist(), this.receivedCommandList);
/*    */     
/* 61 */     GameServer.logger().info(String.format("[lonngboatrace]PCSendCommand.processImp@lonngboatrace get role command response|raceid=%d|phaseno==%d|roundno=%d|timesno=%d|lonngboatraceid=%d|roleid=%d|rolecommand=%s|syscommand=%s|iscorrect=%b|state=%d", new Object[] { Integer.valueOf(this.raceId), Integer.valueOf(this.phaseNo), Integer.valueOf(this.round), Integer.valueOf(this.times), lonngboatraceId, Long.valueOf(this.roleId), Arrays.toString(this.receivedCommandList.toArray()), Arrays.toString(xLonngBoatRaceMatch.getCommandlist().toArray()), Boolean.valueOf(isCorrect), Integer.valueOf(xLonngBoatRaceMatch.getState()) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */     LonngBoatRaceManager.updateRoleStat((LonngBoatRaceTeamStat)xLonngBoatRaceMatch.getTeamid2teamstat().get(Long.valueOf(teamId)), isCorrect, this.roleId);
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private boolean checkMatchInfo(LonngBoatRaceMatch xLonngBoatRaceMatch)
/*    */   {
/* 73 */     if (xLonngBoatRaceMatch.getRaceid() != this.raceId)
/* 74 */       return false;
/* 75 */     if (xLonngBoatRaceMatch.getPhaseno() != this.phaseNo)
/* 76 */       return false;
/* 77 */     if (xLonngBoatRaceMatch.getRoundno() != this.round)
/* 78 */       return false;
/* 79 */     if (xLonngBoatRaceMatch.getTimesno() != this.times)
/* 80 */       return false;
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\PCSendCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */