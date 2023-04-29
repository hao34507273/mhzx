/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_UnsetMatchStatus extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_UnsetMatchStatus(long gmRoleid, long roleid)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     RoleStatusInterface.unsetStatus(this.roleid, 42);
/* 21 */     RoleStatusInterface.unsetStatus(this.roleid, 40);
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "取消跨服匹配状态成功");
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_UnsetMatchStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */