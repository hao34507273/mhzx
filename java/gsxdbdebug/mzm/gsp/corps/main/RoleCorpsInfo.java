/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import xbean.CorpsMember;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleCorpsInfo
/*    */ {
/*    */   private final long roleId;
/*    */   private final CorpsMember xCorpsMember;
/*    */   
/*    */   RoleCorpsInfo(long roleId, CorpsMember xCorpsMember)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.xCorpsMember = xCorpsMember;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 29 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsId()
/*    */   {
/* 39 */     return this.xCorpsMember.getCorpsid();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getJoinTime()
/*    */   {
/* 49 */     return this.xCorpsMember.getJointime();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getDuty()
/*    */   {
/* 60 */     return this.xCorpsMember.getDuty();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isCaptain()
/*    */   {
/* 70 */     return getDuty() == 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isNormalMember()
/*    */   {
/* 80 */     return getDuty() == 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\RoleCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */