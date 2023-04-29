/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ActivityCompensates;
/*    */ 
/*    */ class PSyncCompensates extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PSyncCompensates(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!OpenInterface.getOpenStatus(544)) {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 2061, false))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     ActivityCompensates xCompensates = ActivityCompensateManager.createXActivityCompensatesIfNotExist(this.roleid);
/* 33 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 34 */     ActivityCompensateManager.syncActivityCompensates(this.roleid, xCompensates, nowMillis);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\PSyncCompensates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */