/*    */ package mzm.gsp.ocpequip.main;
/*    */ 
/*    */ import mzm.gsp.genderconvert.main.GenderConvertHandler;
/*    */ 
/*    */ public class GenderEquipSwitchHandler
/*    */   implements GenderConvertHandler
/*    */ {
/*    */   public boolean onActivateGenderConvert(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 10 */     return OcpEquipInterface.genderConvert(paramLong, paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\GenderEquipSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */