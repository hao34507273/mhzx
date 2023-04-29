/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnQQVipLost extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int vipFlag;
/*    */   
/*    */   public POnQQVipLost(long roleid, int vipFlag)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.vipFlag = vipFlag;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String userid = RoleInterface.getUserId(this.roleid);
/* 21 */     if (userid == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     GrcManager.onQQVipLost(userid, this.roleid, this.vipFlag);
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnQQVipLost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */