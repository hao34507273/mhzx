/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertArg;
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertProcedure;
/*    */ 
/*    */ public class POnRoleActivateGenderConvert
/*    */   extends ActivateGenderConvertProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     long l = ((ActivateGenderConvertArg)this.arg).roleid;
/* 13 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(l)) {
/* 14 */       return false;
/*    */     }
/* 16 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(l, 451, false)) {
/* 17 */       return false;
/*    */     }
/* 19 */     FriendsCircleManager.reportRoleGenderInfo(l, ((ActivateGenderConvertArg)this.arg).newGender);
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnRoleActivateGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */