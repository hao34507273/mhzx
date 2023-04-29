/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import hub.PointRaceCorpsBaseInfo;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointConst;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattlePointInterface
/*    */ {
/*    */   public static int getCorpsZone(int activityCfgid, long corpsid)
/*    */   {
/* 21 */     return CrossBattlePointManager.getCorpsZone(activityCfgid, corpsid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getZoneNum()
/*    */   {
/* 31 */     return SCrossBattlePointConst.getInstance().ZONE_NUM;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long startPointRace(PointRaceInfo pointRaceInfo, List<PointRaceCorpsBaseInfo> corpsBaseInfos)
/*    */   {
/* 45 */     return CrossBattlePointManager.startPointRace(pointRaceInfo, corpsBaseInfos);
/*    */   }
/*    */   
/*    */ 
/*    */   public static void setPointRaceTitle(long roleid, long corpsid, String corpsName, int corpsDuty, int badgeid)
/*    */   {
/* 51 */     CrossBattlePointManager.setPointRaceTitle(roleid, corpsid, corpsName, corpsDuty, badgeid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BackupResult pointRaceBackup(int activityCfgid, int zone, int index)
/*    */   {
/* 64 */     return CrossBattlePointManager.pointRaceBackup(activityCfgid, zone, index);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean returnSourceServer(long worldid, String userid, long roleid)
/*    */   {
/* 78 */     return new PPointRaceReturnSourceServer(worldid, userid, roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CrossBattlePointInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */