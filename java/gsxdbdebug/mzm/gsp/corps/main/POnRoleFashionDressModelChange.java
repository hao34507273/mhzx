/*   */ package mzm.gsp.corps.main;
/*   */ 
/*   */ import mzm.gsp.fashiondress.event.FashionDressModelArg;
/*   */ 
/*   */ public class POnRoleFashionDressModelChange extends mzm.gsp.fashiondress.event.FashionDressModelChangeProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     CorpsManager.synCorpsMemberModelChange(((FashionDressModelArg)this.arg).roleId);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleFashionDressModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */