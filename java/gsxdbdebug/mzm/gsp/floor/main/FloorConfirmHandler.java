/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.floor.SFloorConfirmDesc;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class FloorConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/* 11 */   private static final FloorConfirmHandler instance = new FloorConfirmHandler();
/*    */   
/*    */   static FloorConfirmHandler getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 21 */     if (!(context instanceof FloorConfirmContext))
/*    */     {
/* 23 */       return null;
/*    */     }
/* 25 */     FloorConfirmContext floorContext = (FloorConfirmContext)context;
/* 26 */     return new SFloorConfirmDesc(floorContext.getActivityId(), floorContext.getFloor());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 32 */     if (!(context instanceof FloorConfirmContext))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     FloorConfirmContext floorContext = (FloorConfirmContext)context;
/* 37 */     new PCChallengeFloorReq(floorContext.getRoleId(), floorContext.getActivityId(), floorContext.getFloor()).execute();
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */