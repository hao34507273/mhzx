/*    */ package mzm.gsp.genderconvert.event;
/*    */ 
/*    */ public class ActivateGenderConvertArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int newGender;
/*    */   public final int oldGender;
/*    */   
/*    */   public ActivateGenderConvertArg(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 11 */     this.roleid = paramLong;
/* 12 */     this.newGender = paramInt1;
/* 13 */     this.oldGender = paramInt2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\event\ActivateGenderConvertArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */