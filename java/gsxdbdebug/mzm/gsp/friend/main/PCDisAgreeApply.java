/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2apply;
/*    */ 
/*    */ public class PCDisAgreeApply extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long strangerId;
/*    */   
/*    */   public PCDisAgreeApply(long roleId, long strangerId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.strangerId = strangerId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleId, 183, true);
/* 22 */     if (!ret) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     lock(Role2apply.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.strangerId) }));
/* 27 */     RoleApply roleApply = RoleFriendManager.getRoleApply(this.roleId, true);
/* 28 */     return RoleFriendManager.disAgreeApply(roleApply, this.strangerId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCDisAgreeApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */