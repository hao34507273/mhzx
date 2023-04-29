/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Table;
/*    */ import xtable.Qmhw;
/*    */ import xtable.Qmhwrank;
/*    */ import xtable.Role2qmhw;
/*    */ 
/*    */ public class QMHWMergeModule implements MergeModule
/*    */ {
/* 16 */   private static final Logger logger = Logger.getLogger(QMHWMergeModule.class);
/*    */   
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 20 */     List<Table> tables = new java.util.ArrayList();
/*    */     
/* 22 */     tables.add(Role2qmhw.getTable());
/*    */     
/* 24 */     tables.add(Qmhw.getTable());
/*    */     
/* 26 */     tables.add(Qmhwrank.getTable());
/* 27 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     final long viceZoneid = MergeMain.getViceZoneid();
/* 33 */     long mainZoneid = MergeMain.getMainZoneid();
/*    */     
/*    */ 
/* 36 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 40 */         lock(Qmhw.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/*    */         
/* 42 */         Qmhw.remove(Long.valueOf(viceZoneid));
/* 43 */         QMHWMergeModule.logger.info(String.format("[Merge]QMHWMergeModule.handleMerge@Qmhw remove vice server data", new Object[0]));
/* 44 */         return true;
/*    */ 
/*    */ 
/*    */ 
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 54 */     }.call();
/* 55 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 59 */         lock(Qmhwrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(viceZoneid), Long.valueOf(this.val$mainZoneid) }));
/* 60 */         Qmhwrank.remove(Long.valueOf(viceZoneid));
/* 61 */         Qmhwrank.remove(Long.valueOf(this.val$mainZoneid));
/* 62 */         QMHWMergeModule.logger.info(String.format("[Merge]QMHWMergeModule.handleMerge@Qmhwrank remove vice and main server data", new Object[0]));
/*    */         
/* 64 */         return true;
/*    */       }
/* 66 */     }.call();
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */