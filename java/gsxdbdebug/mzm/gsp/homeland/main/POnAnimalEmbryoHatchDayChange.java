/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.EmbryoHatchDayChangeArg;
/*    */ 
/*    */ public class POnAnimalEmbryoHatchDayChange extends mzm.gsp.zoo.event.EmbryoHatchDayChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.changeAnimalEmbryoHatchDayChange(((EmbryoHatchDayChangeArg)this.arg).roleid, ((EmbryoHatchDayChangeArg)this.arg).animalid, ((EmbryoHatchDayChangeArg)this.arg).days);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAnimalEmbryoHatchDayChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */