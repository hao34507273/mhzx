/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertArg;
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertProcedure;
/*    */ 
/*    */ public class POnRoleActivateGenderConvert
/*    */   extends ActivateGenderConvertProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     CorpsManager.synCorpsMemberBaseChange(((ActivateGenderConvertArg)this.arg).roleid);
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleActivateGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */