/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity3.confbean.FloorCfg;
/*    */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*    */ import xbean.GlobalFloorInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTryChallengeFloor
/*    */   extends PCChallengeFloorReq
/*    */ {
/*    */   public PTryChallengeFloor(long roleId, int activityId, int floor)
/*    */   {
/* 17 */     super(roleId, activityId, floor);
/*    */   }
/*    */   
/*    */ 
/*    */   void doAction(FloorCfg floorCfg, GlobalFloorInfo xGlobalFloorInfo)
/*    */   {
/* 23 */     if (this.lockMembers.size() == 1)
/*    */     {
/* 25 */       super.doAction(floorCfg, xGlobalFloorInfo);
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     TeamConfirmInterface.startTeamConfirm(this.teamId, floorCfg.confirmType, new FloorConfirmContext(this.roleId, this.activityId, this.floor));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PTryChallengeFloor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */