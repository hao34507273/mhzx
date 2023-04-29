/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import xbean.RoleApplyGang;
/*    */ 
/*    */ class PRemoveApplyGang extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   
/*    */   PRemoveApplyGang(long roleid, long gangid) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     RoleApplyGang xApplyGang = GangManager.getXRoleApplyGang(this.roleid, true);
/* 18 */     GangManager.removeApplyGang(this.roleid, xApplyGang, this.gangid);
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRemoveApplyGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */