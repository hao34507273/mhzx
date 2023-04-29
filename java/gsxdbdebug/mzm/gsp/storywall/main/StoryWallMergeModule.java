/*    */ package mzm.gsp.storywall.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2storyinfo;
/*    */ 
/*    */ public class StoryWallMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 13 */     List<Table> tables = new ArrayList();
/* 14 */     tables.add(xtable.Storywall.getTable());
/* 15 */     tables.add(Role2storyinfo.getTable());
/* 16 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\main\StoryWallMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */