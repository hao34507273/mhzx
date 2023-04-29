/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class POnlineTreasureBuffChange
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private boolean isInstall;
/*    */   
/*    */   POnlineTreasureBuffChange(long roleid, boolean isInstall)
/*    */   {
/* 50 */     this.roleId = roleid;
/* 51 */     this.isInstall = isInstall;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 56 */     if (this.isInstall) {
/* 57 */       BuffInterface.installBuff(this.roleId, OnlineTreasureBoxActivityConst.getInstance().activityAwardBuffId);
/*    */     } else {
/* 59 */       BuffInterface.uninstallBuf(this.roleId, OnlineTreasureBoxActivityConst.getInstance().activityAwardBuffId);
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnlineTreasureBuffChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */