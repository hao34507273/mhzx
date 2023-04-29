/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import hub.PointRaceCorpsBaseInfo;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartPointRace
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final PointRaceInfo pointRaceInfo;
/*    */   private final List<PointRaceCorpsBaseInfo> corpsBaseInfos;
/*    */   private long roomInstanceid;
/*    */   
/*    */   public PStartPointRace(PointRaceInfo pointRaceInfo, List<PointRaceCorpsBaseInfo> corpsBaseInfos)
/*    */   {
/* 18 */     this.pointRaceInfo = pointRaceInfo;
/* 19 */     this.corpsBaseInfos = corpsBaseInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     this.roomInstanceid = CrossBattlePointManager.startPointRace(this.pointRaceInfo, this.corpsBaseInfos);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public Long getRoomInstanceid()
/*    */   {
/* 31 */     return Long.valueOf(this.roomInstanceid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PStartPointRace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */