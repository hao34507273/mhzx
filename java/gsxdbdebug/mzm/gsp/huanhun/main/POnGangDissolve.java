/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangDissolve
/*    */   extends GangDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     HuanhunManager.rmGangAllHelp(((GangArg)this.arg).gangId, ((GangArg)this.arg).extraMemberList);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnGangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */