/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ 
/*    */ public class POnPlayerEquipChange extends mzm.gsp.item.event.PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((EquipChangeArg)this.arg).roleId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */