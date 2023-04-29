/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_UnsetCrossStatus extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_UnsetCrossStatus(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     RoleStatusInterface.unsetStatus(this.roleid, 41);
/* 21 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "取消跨服状态成功!");
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_UnsetCrossStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */