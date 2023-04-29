/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ 
/*    */ class PPromoteXueTu
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   private final long roleid;
/*    */   
/*    */   PPromoteXueTu(long gangid, long roleid)
/*    */   {
/* 18 */     this.gangid = gangid;
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     GangMember xMember = GangManager.getXGangMember(this.roleid, true);
/* 26 */     if (xMember == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (xMember.getGangid() != this.gangid) {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     Gang xGang = GangManager.getXGang(this.gangid, true);
/* 36 */     if (xGang == null) {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     Role role = RoleInterface.getRole(this.roleid, true);
/*    */     
/* 43 */     GangManager.promoteXueTu(role, xMember, this.gangid, xGang);
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PPromoteXueTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */