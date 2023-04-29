/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ 
/*    */ public class RegisterZoneCallBack implements MapCallback<Integer> {
/*    */   private MassWeddingZoneForm massWeddingZoneForm;
/*    */   
/*    */   public RegisterZoneCallBack(MassWeddingZoneForm massWeddingZoneForm) {
/*  9 */     this.massWeddingZoneForm = massWeddingZoneForm;
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public boolean onResult(Integer result)
/*    */   {
/* 19 */     this.massWeddingZoneForm.setEventid(result.intValue());
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\RegisterZoneCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */