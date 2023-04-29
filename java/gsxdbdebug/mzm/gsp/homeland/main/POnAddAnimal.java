/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalCreateArg;
/*    */ 
/*    */ public class POnAddAnimal extends mzm.gsp.zoo.event.AnimalCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.addAnimal(((AnimalCreateArg)this.arg).roleid, ((AnimalCreateArg)this.arg).animalid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAddAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */