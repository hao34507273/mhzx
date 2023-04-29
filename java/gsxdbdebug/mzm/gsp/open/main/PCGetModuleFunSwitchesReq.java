/*    */ package mzm.gsp.open.main;
/*    */ 
/*    */ import mzm.gsp.open.CGetModuleFunSwitchesReq;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetModuleFunSwitchesReq extends LogicProcedure
/*    */ {
/*    */   private final CGetModuleFunSwitchesReq core;
/*    */   
/*    */   public PCGetModuleFunSwitchesReq(CGetModuleFunSwitchesReq core)
/*    */   {
/* 12 */     this.core = core;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     OpenManager.getModuleFunSwitches(this.core);
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\main\PCGetModuleFunSwitchesReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */