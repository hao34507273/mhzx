/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2fightcmd;
/*    */ import xtable.Role2fightstorage;
/*    */ 
/*    */ public class FightMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 13 */     List<Table> tables = new java.util.ArrayList();
/*    */     
/* 15 */     tables.add(Role2fightcmd.getTable());
/*    */     
/* 17 */     tables.add(Role2fightstorage.getTable());
/* 18 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */