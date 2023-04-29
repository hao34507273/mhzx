/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LonngBoatRaceTLogManager
/*    */ {
/*    */   static final String TLOG_LONNGBOATRACE = "LonngBoatRaceLog";
/*    */   
/*    */   public static void tlogLonngBoatRace(List<Long> memberList, long matchTime)
/*    */   {
/* 20 */     long leaderId = ((Long)memberList.get(0)).longValue();
/* 21 */     List<Object> list = new ArrayList();
/* 22 */     list.add(GameServerInfoManager.getHostIP());
/* 23 */     String userid = RoleInterface.getUserId(leaderId);
/* 24 */     list.add(userid);
/* 25 */     list.add(Long.valueOf(leaderId));
/* 26 */     list.add(Integer.valueOf(RoleInterface.getLevel(leaderId)));
/* 27 */     list.add(memberList);
/* 28 */     list.add(Long.valueOf(matchTime));
/* 29 */     TLogManager.getInstance().addLog(userid, "LonngBoatRaceLog", list.toArray());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\LonngBoatRaceTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */