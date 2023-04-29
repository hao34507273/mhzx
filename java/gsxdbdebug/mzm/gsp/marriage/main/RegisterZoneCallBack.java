/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ 
/*    */ class RegisterZoneCallBack implements MapCallback<Integer>
/*    */ {
/*    */   private MarriageParadeZoneForm marriageParadeZoneForm;
/*    */   
/*    */   public RegisterZoneCallBack(MarriageParadeZoneForm marriageParadeZoneForm) {
/* 10 */     this.marriageParadeZoneForm = marriageParadeZoneForm;
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 15 */     return false;
/*    */   }
/*    */   
/*    */   public boolean onResult(Integer result)
/*    */   {
/* 20 */     this.marriageParadeZoneForm.setEventid(result.intValue());
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\RegisterZoneCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */