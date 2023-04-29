/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PRecordGangDismissTlog
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   private final long roleId;
/*    */   private final int gangMemberNum;
/*    */   private final long gangDisplayId;
/*    */   
/*    */   public PRecordGangDismissTlog(long gangId, long roleId, int gangMemberNum, long gangDisplayId)
/*    */   {
/* 17 */     this.gangId = gangId;
/* 18 */     this.roleId = roleId;
/* 19 */     this.gangMemberNum = gangMemberNum;
/* 20 */     this.gangDisplayId = gangDisplayId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userId = RoleInterface.getUserId(this.roleId);
/* 27 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 28 */     GangManager.addGangDismissTlog(this.gangId, this.roleId, userId, roleLevel, this.gangMemberNum, GangDismissActionLogEnum.MAINTAIN_DISMISS, this.gangDisplayId);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRecordGangDismissTlog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */