/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalStageChangeArg;
/*    */ 
/*    */ public class POnAnimalStageChange extends mzm.gsp.zoo.event.AnimalStageChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.changeAnimalState(((AnimalStageChangeArg)this.arg).roleid, ((AnimalStageChangeArg)this.arg).animalid, ((AnimalStageChangeArg)this.arg).oldStage, ((AnimalStageChangeArg)this.arg).newStage);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAnimalStageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */