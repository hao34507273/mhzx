/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import mzm.gsp.genderconvert.main.GenderConvertHandler;
/*    */ 
/*    */ public class AvatarGenderConvertHandler
/*    */   implements GenderConvertHandler
/*    */ {
/*    */   public boolean onActivateGenderConvert(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 10 */     return new PSyncAvatarInfoWhenSwitchGender(paramLong, paramInt1).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\AvatarGenderConvertHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */