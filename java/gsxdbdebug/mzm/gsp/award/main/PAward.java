/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAward
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final List<String> userList;
/*    */   private final List<Long> roleList;
/*    */   private final int awardId;
/*    */   private final Collection<Long> allRoleList;
/*    */   private final int modifyId;
/*    */   private final boolean activeGet;
/*    */   private final boolean isSend;
/*    */   private final AwardReason awardReason;
/*    */   
/*    */   public PAward(int awardId, List<String> userList, List<Long> roleList, Collection<Long> allRoleList, int modifyId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*    */   {
/* 29 */     this.userList = userList;
/* 30 */     this.roleList = roleList;
/* 31 */     this.awardId = awardId;
/* 32 */     this.allRoleList = allRoleList;
/* 33 */     this.modifyId = modifyId;
/* 34 */     this.activeGet = activeGet;
/* 35 */     this.isSend = isSend;
/* 36 */     this.awardReason = awardReason;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 43 */     lock(User.getTable(), this.userList);
/*    */     
/* 45 */     RoleAwardManager.award(this.userList, this.roleList, this.allRoleList, this.awardId, this.modifyId, this.activeGet, this.isSend, this.awardReason);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */