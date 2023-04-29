/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Chatgifttable;
/*    */ import xtable.Gang2chatgiftlist;
/*    */ import xtable.Role2chatgiftinfolist;
/*    */ import xtable.Role2getchatgiftinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatGiftMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/* 22 */     tables.add(Chatgifttable.getTable());
/* 23 */     tables.add(Role2chatgiftinfolist.getTable());
/* 24 */     tables.add(Gang2chatgiftlist.getTable());
/* 25 */     tables.add(Role2getchatgiftinfo.getTable());
/* 26 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ChatGiftMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */