/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalDisappearArg;
/*    */ import mzm.gsp.zoo.event.AnimalDisappearProcedure;
/*    */ import mzm.gsp.zoo.main.ZooInterface;
/*    */ 
/*    */ public class POnRemoveAnimal extends AnimalDisappearProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     ZooInterface.onAnimalDisappear(((AnimalDisappearArg)this.arg).roleid, ((AnimalDisappearArg)this.arg).animalid);
/* 12 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnRemoveAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */