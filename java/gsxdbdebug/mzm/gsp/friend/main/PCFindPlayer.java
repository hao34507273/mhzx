/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ public class PCFindPlayer
/*    */   extends LogicProcedure
/*    */ {
/*    */   private String content;
/*    */   private long roleId;
/*    */   
/*    */   public PCFindPlayer(long roleId, String content)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleId, 184, true);
/* 24 */     if (!ret) {
/* 25 */       return false;
/*    */     }
/* 27 */     if ((this.content == null) || (this.content.equals(""))) {
/* 28 */       RoleFriendManager.sendError(this.roleId, 1, new String[0]);
/* 29 */       return false;
/*    */     }
/* 31 */     Long findPlayerId = Name2roleid.select(this.content);
/* 32 */     if (findPlayerId == null) {
/*    */       try {
/* 34 */         for (int i = 0; i < this.content.length(); i++) {
/* 35 */           char tempChar = this.content.charAt(i);
/* 36 */           if ((!Character.isDigit(tempChar)) && (tempChar != '-')) {
/* 37 */             RoleFriendManager.sendError(this.roleId, 1, new String[0]);
/* 38 */             return false;
/*    */           }
/*    */         }
/* 41 */         findPlayerId = Long.valueOf(Long.parseLong(this.content));
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/* 45 */     if (findPlayerId == null) {
/* 46 */       RoleFriendManager.sendError(this.roleId, 1, new String[0]);
/* 47 */       return false;
/*    */     }
/* 49 */     String roleName = RoleInterface.getName(findPlayerId.longValue());
/* 50 */     if (roleName == null) {
/* 51 */       RoleFriendManager.sendError(this.roleId, 1, new String[0]);
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     int status = RoleInterface.getDeleteState(findPlayerId.longValue(), false);
/*    */     
/* 57 */     if (status == 2) {
/* 58 */       RoleFriendManager.sendError(this.roleId, 1, new String[0]);
/* 59 */       return false;
/*    */     }
/* 61 */     Role role = RoleInterface.getRole(findPlayerId.longValue(), false);
/* 62 */     RoleFriendManager.sendFindPlayerRes(this.roleId, role);
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCFindPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */