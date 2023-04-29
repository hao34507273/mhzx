/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RRankRoleMFV extends LogicRunnable
/*    */ {
/*    */   private final long roleId;
/*    */   private final boolean isOccRankOpen;
/*    */   
/*    */   public RRankRoleMFV(long roleId, boolean isOccRankOpen)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.isOccRankOpen = isOccRankOpen;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     int mfv = MultiRankManager.getRoleMFValue(this.roleId);
/* 21 */     int occId = RoleInterface.getOccupationId(this.roleId);
/*    */     
/* 23 */     new PRankRoleMFV(this.roleId, mfv).execute();
/* 24 */     if (this.isOccRankOpen)
/*    */     {
/* 26 */       new PRankOccMFV(this.roleId, mfv, occId).execute();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\RRankRoleMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */