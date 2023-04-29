/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Catbestpartner;
/*    */ 
/*    */ public class PCatMerge extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long viceKey = MergeMain.getViceZoneid();
/* 13 */     Catbestpartner.remove(Long.valueOf(viceKey));
/*    */     
/* 15 */     GameServer.logger().info(String.format("[cat]PCatMerge.processImp@remove vice_key success|vice_key=%d", new Object[] { Long.valueOf(viceKey) }));
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCatMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */