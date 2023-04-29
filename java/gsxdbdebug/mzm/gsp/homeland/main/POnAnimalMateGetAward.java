/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalGetAwardArg;
/*    */ 
/*    */ public class POnAnimalMateGetAward extends mzm.gsp.zoo.event.AnimalGetAwardProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.onAnimalGetAward(((AnimalGetAwardArg)this.arg).roleid, ((AnimalGetAwardArg)this.arg).animalid, ((AnimalGetAwardArg)this.arg).awardCfgid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAnimalMateGetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */