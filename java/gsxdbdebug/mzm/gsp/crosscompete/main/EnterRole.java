/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnterRole
/*    */   implements RoamRoleInfo
/*    */ {
/*    */   public final String userid;
/*    */   public final long roleid;
/* 17 */   private Octets token = null;
/* 18 */   private boolean bRoamed = false;
/*    */   
/*    */   public EnterRole(String userid, long roleid)
/*    */   {
/* 22 */     this.userid = userid;
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 28 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public Octets getToken()
/*    */   {
/* 33 */     return this.token;
/*    */   }
/*    */   
/*    */   public String getUserid()
/*    */   {
/* 38 */     return this.userid;
/*    */   }
/*    */   
/*    */   public void setToken(Octets token) {
/* 42 */     this.token = token;
/*    */   }
/*    */   
/*    */   public void setRoamed() {
/* 46 */     this.bRoamed = true;
/*    */   }
/*    */   
/*    */   public boolean isRoamed() {
/* 50 */     return this.bRoamed;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\EnterRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */