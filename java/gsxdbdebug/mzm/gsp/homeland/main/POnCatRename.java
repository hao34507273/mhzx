/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.cat.event.CatRenameArg;
/*    */ 
/*    */ public class POnCatRename extends mzm.gsp.cat.event.CatRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     HomelandManager.catRename(((CatRenameArg)this.arg).roleid, ((CatRenameArg)this.arg).catid, ((CatRenameArg)this.arg).newName);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnCatRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */