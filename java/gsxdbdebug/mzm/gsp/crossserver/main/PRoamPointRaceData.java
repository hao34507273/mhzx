/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PointRaceCorpsCurInfo;
/*    */ import mzm.gsp.crossbattle.point.PointRaceCorpsManager;
/*    */ import mzm.gsp.crossbattle.point.PointRaceCorpsPreInfo;
/*    */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*    */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User2roamedinfo;
/*    */ 
/*    */ public class PRoamPointRaceData extends LogicProcedure
/*    */ {
/*    */   private final long worldid;
/*    */   private final long corpsid;
/*    */   private final List<RoamedRolePointRaceMarkingInfo> roamedInfos;
/*    */   private final PointRaceCorpsCurInfo curInfo;
/*    */   
/*    */   public PRoamPointRaceData(long worldid, long corpsid, List<RoamedRolePointRaceMarkingInfo> roamedInfos, PointRaceCorpsCurInfo curInfo)
/*    */   {
/* 26 */     this.worldid = worldid;
/* 27 */     this.roamedInfos = roamedInfos;
/* 28 */     this.corpsid = corpsid;
/* 29 */     this.curInfo = curInfo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     Set<String> userids = new HashSet();
/* 36 */     List<Long> roleids = new ArrayList();
/* 37 */     for (RoamedRolePointRaceMarkingInfo roamedInfo : this.roamedInfos)
/*    */     {
/* 39 */       userids.add(roamedInfo.getUserid());
/* 40 */       roleids.add(Long.valueOf(roamedInfo.getRoleid()));
/*    */     }
/* 42 */     lock(User2roamedinfo.getTable(), userids);
/*    */     
/* 44 */     for (String userid : userids)
/*    */     {
/* 46 */       CrossServerManager.setUserRoamedInfo(userid, RoamType.CROSS_BATTLE_POINT, this.worldid);
/*    */     }
/*    */     
/* 49 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/* 50 */     if (zoneManager == null)
/*    */     {
/* 52 */       GameServer.logger().error(String.format("[crossbattlepoint]PRoamPointRaceData.processImp@zone manager is null|worldid=%d|corpsid=%d|roleids=%s", new Object[] { Long.valueOf(this.worldid), Long.valueOf(this.corpsid), roleids.toString() }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 60 */     PointRaceCorpsPreInfo corpsPreInfo = corpsManager.getCorpsPreInfo(this.corpsid);
/* 61 */     if (corpsPreInfo == null)
/*    */     {
/* 63 */       GameServer.logger().error(String.format("[crossbattlepoint]PRoamPointRaceData.processImp@corps pre info is null|worldid=%d|corpsid=%d|roleids=%s", new Object[] { Long.valueOf(this.worldid), Long.valueOf(this.corpsid), roleids.toString() }));
/*    */       
/*    */ 
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     RoamedPointRaceContext context = zoneManager.addRoamedContext(this.corpsid, this.roamedInfos, this.curInfo);
/* 71 */     if (context == null)
/*    */     {
/* 73 */       GameServer.logger().error(String.format("[crossbattlepoint]PRoamPointRaceData.processImp@roamed context is null|worldid=%d|corpsid=%d|roleids=%s", new Object[] { Long.valueOf(this.worldid), Long.valueOf(this.corpsid), roleids.toString() }));
/*    */       
/*    */ 
/*    */ 
/* 77 */       return false;
/*    */     }
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PRoamPointRaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */