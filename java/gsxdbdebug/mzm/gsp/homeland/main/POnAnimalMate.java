/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalMateArg;
/*    */ 
/*    */ public class POnAnimalMate extends mzm.gsp.zoo.event.AnimalMateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.onAnimalMate(((AnimalMateArg)this.arg).roleid, ((AnimalMateArg)this.arg).animalid, ((AnimalMateArg)this.arg).lastMateTime, ((AnimalMateArg)this.arg).awardCfgid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAnimalMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */