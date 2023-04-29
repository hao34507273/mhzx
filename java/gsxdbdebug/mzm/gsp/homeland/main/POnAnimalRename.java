/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.zoo.event.AnimalRenameArg;
/*    */ 
/*    */ public class POnAnimalRename extends mzm.gsp.zoo.event.AnimalRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.onAnimalRename(((AnimalRenameArg)this.arg).roleid, ((AnimalRenameArg)this.arg).animalid, ((AnimalRenameArg)this.arg).oldName, ((AnimalRenameArg)this.arg).name);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnAnimalRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */