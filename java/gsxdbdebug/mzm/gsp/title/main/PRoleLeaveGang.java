/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleLeaveGang
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long gangId;
/*    */   
/*    */   public PRoleLeaveGang(long roleId, long gangId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (GangInterface.isGangMember(this.roleId, this.gangId)) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     int gangAppId = TitleManager.getGangAppId();
/*    */     
/* 30 */     return new PRemoveAppellation(this.roleId, gangAppId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PRoleLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */