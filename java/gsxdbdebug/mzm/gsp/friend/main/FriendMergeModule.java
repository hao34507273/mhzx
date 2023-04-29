/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2apply;
/*    */ 
/*    */ public class FriendMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 13 */     List<Table> tables = new ArrayList();
/*    */     
/* 15 */     tables.add(xtable.Rolefriendforbid.getTable());
/*    */     
/* 17 */     tables.add(xtable.Role2friend.getTable());
/*    */     
/* 19 */     tables.add(Role2apply.getTable());
/*    */     
/* 21 */     tables.add(xtable.Userfriendforbid.getTable());
/* 22 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */