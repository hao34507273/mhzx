/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class PCheckCakeHistory extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final long factionId;
/*    */   private final long checkRoleId;
/*    */   
/*    */   public PCheckCakeHistory(long roleId, int activityId, long factionId, long checkRoleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.factionId = factionId;
/* 18 */     this.checkRoleId = checkRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     NoneRealTimeTaskManager.getInstance().addTask(new PCCheckCakeHistoryReq(this.roleId, this.activityId, this.factionId, this.checkRoleId));
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCheckCakeHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */