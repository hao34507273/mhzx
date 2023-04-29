/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import mzm.gsp.map.event.PlayerUpdateKeyPathProcedure;
/*    */ 
/*    */ public class POnPlayerUpdateKeyPath
/*    */   extends PlayerUpdateKeyPathProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     new PStopGrab(((Long)this.arg).longValue(), 2).execute();
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\POnPlayerUpdateKeyPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */