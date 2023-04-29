/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.CrossTokenCheckObserver;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetCrossStatus extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final long chechStatus;
/*    */   
/*    */   public PGM_SetCrossStatus(long gmRoleid, long roleid, int chechStatus)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.chechStatus = chechStatus;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     boolean ret = RoleStatusInterface.setStatus(this.roleid, 41, true);
/* 24 */     if (ret) {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置跨服状态成功");
/*    */     } else {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置跨服状态失败");
/*    */     }
/* 29 */     if ((ret) && 
/* 30 */       (this.chechStatus > 0L)) {
/* 31 */       CrossTokenCheckObserver.createCrossTokenCheckObserver(this.roleid);
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_SetCrossStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */