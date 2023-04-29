/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Level2time;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Pgm_ClearLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Level2time.remove(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\Pgm_ClearLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */