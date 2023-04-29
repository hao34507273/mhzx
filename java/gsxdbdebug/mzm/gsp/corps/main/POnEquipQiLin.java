/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.item.event.EquipQiLinProcedure;
/*    */ import mzm.gsp.item.main.EquipQiLinArg;
/*    */ 
/*    */ public class POnEquipQiLin
/*    */   extends EquipQiLinProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     if (((EquipQiLinArg)this.arg).bagid != 340600001)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     CorpsManager.synCorpsMemberModelChange(((EquipQiLinArg)this.arg).roleid);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */