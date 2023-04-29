/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossbattle.event.PointRacePVPFightEndArg;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ 
/*    */ public class POnPointRacePVPFightEnd extends mzm.gsp.crossbattle.event.PointRacePVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(((PointRacePVPFightEndArg)this.arg).worldid);
/* 11 */     if (zoneManager == null)
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 17 */     int activityCfgid = zoneManager.activityCfgid;
/* 18 */     int timePointCfgid = zoneManager.timePointCfgid;
/*    */     
/*    */ 
/* 21 */     long activeCorpsid = ((PointRacePVPFightEndArg)this.arg).activeCorpsid;
/* 22 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(activeCorpsid);
/* 23 */     if (curInfo != null)
/*    */     {
/* 25 */       CrossServerInterface.updatePointRaceCorps(curInfo.zoneid, activityCfgid, timePointCfgid, activeCorpsid, curInfo.win, curInfo.lose, curInfo.point, curInfo.updateTime);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 31 */     long passiveCorpsid = ((PointRacePVPFightEndArg)this.arg).passiveCorpsid;
/* 32 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(passiveCorpsid);
/* 33 */     if (curInfo != null)
/*    */     {
/* 35 */       CrossServerInterface.updatePointRaceCorps(curInfo.zoneid, activityCfgid, timePointCfgid, passiveCorpsid, curInfo.win, curInfo.lose, curInfo.point, curInfo.updateTime);
/*    */     }
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnPointRacePVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */