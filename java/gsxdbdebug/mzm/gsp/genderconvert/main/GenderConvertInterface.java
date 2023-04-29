/*    */ package mzm.gsp.genderconvert.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.MultiGender;
/*    */ 
/*    */ public class GenderConvertInterface
/*    */ {
/*    */   public static boolean hasGender(long paramLong, int paramInt, boolean paramBoolean)
/*    */   {
/* 12 */     MultiGender localMultiGender = GenderConvertManager.getXMultiGender(paramLong, paramBoolean);
/* 13 */     if (localMultiGender != null) {
/* 14 */       return GenderConvertManager.hasGender(localMultiGender, paramInt);
/*    */     }
/* 16 */     int i = RoleInterface.getGender(paramLong);
/* 17 */     return paramInt == i;
/*    */   }
/*    */   
/*    */   public static boolean sendMultiOcpGender(long paramLong, boolean paramBoolean)
/*    */   {
/* 22 */     int i = RoleInterface.getGender(paramLong);
/* 23 */     MultiGender localMultiGender = GenderConvertManager.getAndCreateXMultiGender(paramLong, i);
/* 24 */     if (localMultiGender == null) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     GenderConvertManager.sendMultiOcpGender(paramLong, localMultiGender);
/*    */     
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public static List<Integer> getGenderList(long paramLong, boolean paramBoolean)
/*    */   {
/* 35 */     ArrayList localArrayList = new ArrayList();
/*    */     
/* 37 */     MultiGender localMultiGender = GenderConvertManager.getXMultiGender(paramLong, paramBoolean);
/* 38 */     if (localMultiGender != null)
/*    */     {
/* 40 */       localArrayList.addAll(localMultiGender.getGenders());
/*    */     }
/*    */     else
/*    */     {
/* 44 */       int i = RoleInterface.getGender(paramLong);
/* 45 */       localArrayList.add(Integer.valueOf(i));
/*    */     }
/* 47 */     return localArrayList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\main\GenderConvertInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */