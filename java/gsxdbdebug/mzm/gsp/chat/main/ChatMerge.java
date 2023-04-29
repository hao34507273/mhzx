/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2report;
/*    */ import xtable.Role2reported;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/*    */     
/* 23 */     tables.add(Role2report.getTable());
/* 24 */     tables.add(Role2reported.getTable());
/*    */     
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */