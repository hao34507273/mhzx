/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Active;
/*    */ 
/*    */ public class PGM_AddActive extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int activityid;
/*    */   
/*    */   public PGM_AddActive(long roleid, int activityid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Active xActive = ActiveManager.checkAndInitActive(this.roleid, DateTimeUtils.getCurrTimeInMillis());
/* 22 */     if (ActiveManager.addActivityCount(this.roleid, xActive, this.activityid))
/*    */     {
/* 24 */       ActiveManager.sendUpdateActiveMsg(this.roleid, this.activityid, ActiveManager.getActivityCount(xActive, this.activityid));
/* 25 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\PGM_AddActive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */