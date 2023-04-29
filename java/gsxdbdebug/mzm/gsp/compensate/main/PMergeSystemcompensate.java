/*    */ package mzm.gsp.compensate.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Systemcompensate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PMergeSystemcompensate
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 66 */     long mainZoneid = MergeMain.getMainZoneid();
/* 67 */     long viceZoneid = MergeMain.getViceZoneid();
/* 68 */     lock(Systemcompensate.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*    */     
/* 70 */     Systemcompensate.remove(Long.valueOf(mainZoneid));
/* 71 */     Systemcompensate.remove(Long.valueOf(viceZoneid));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\PMergeSystemcompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */