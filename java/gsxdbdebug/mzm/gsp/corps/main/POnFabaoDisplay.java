/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.fabao.event.FabaoDisplayArg;
/*    */ 
/*    */ public class POnFabaoDisplay extends mzm.gsp.fabao.event.FabaoDisplayProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     CorpsManager.synCorpsMemberModelChange(((FabaoDisplayArg)this.arg).roleid);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnFabaoDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */