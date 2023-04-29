/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TeamBackContext
/*    */ {
/* 13 */   private List<ReturnBackRole> roles = new ArrayList();
/*    */   private long sessionid;
/*    */   
/*    */   TeamBackContext(List<Long> roleList) {
/* 17 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 18 */       this.roles.add(new ReturnBackRole(r));
/*    */     }
/*    */   }
/*    */   
/*    */   List<Long> getRoleidList() {
/* 23 */     List<Long> roleList = new ArrayList();
/* 24 */     for (ReturnBackRole role : this.roles) {
/* 25 */       roleList.add(Long.valueOf(role.roleid));
/*    */     }
/* 27 */     return roleList;
/*    */   }
/*    */   
/*    */   long getSessionid() {
/* 31 */     return this.sessionid;
/*    */   }
/*    */   
/*    */   void setSessionid(long sessionid) {
/* 35 */     this.sessionid = sessionid;
/*    */   }
/*    */   
/*    */   boolean setRoleLogin(long roleid) {
/* 39 */     for (ReturnBackRole role : this.roles) {
/* 40 */       if (role.roleid == roleid) {
/* 41 */         return role.setLogin();
/*    */       }
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   boolean isAllLogin() {
/* 48 */     for (ReturnBackRole role : this.roles) {
/* 49 */       if (!role.isLogin()) {
/* 50 */         return false;
/*    */       }
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public void setRoleTeamRestore(long roleid) {
/* 57 */     for (ReturnBackRole role : this.roles) {
/* 58 */       if (role.roleid == roleid) {
/* 59 */         role.setTeamRestore();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTeamRestore() {
/* 65 */     for (ReturnBackRole role : this.roles) {
/* 66 */       if (!role.isTeamRestore()) {
/* 67 */         return false;
/*    */       }
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\TeamBackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */