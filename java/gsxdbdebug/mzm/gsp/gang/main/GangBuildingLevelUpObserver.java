/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class GangBuildingLevelUpObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private long endTime;
/*    */   private int buildingType;
/*    */   private long gangId;
/*    */   
/*    */   public GangBuildingLevelUpObserver(long endTime, long gangId, int buildingType)
/*    */   {
/* 17 */     super(Math.max(0L, endTime - DateTimeUtils.getCurrTimeInMillis()));
/* 18 */     this.endTime = endTime;
/* 19 */     this.buildingType = buildingType;
/* 20 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 25 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 29 */         xbean.Gang xGang = xtable.Gang.get(Long.valueOf(GangBuildingLevelUpObserver.this.gangId));
/* 30 */         if (xGang == null) {
/* 31 */           return false;
/*    */         }
/* 33 */         AbsGangBuilding gangBuilding = BuildingFactory.createGangBuilding(GangBuildingLevelUpObserver.this.gangId, xGang, GangBuildingLevelUpObserver.this.buildingType);
/* 34 */         if (gangBuilding.getLevelUpEndTime() != GangBuildingLevelUpObserver.this.endTime) {
/* 35 */           return false;
/*    */         }
/* 37 */         return gangBuilding.levelUpAction();
/*    */       }
/* 39 */     }.execute();
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangBuildingLevelUpObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */