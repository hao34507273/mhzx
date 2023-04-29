/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role2pet_fight_formation;
/*    */ import xtable.Role2pet_fight_skill;
/*    */ 
/*    */ public class PetFightMergeModule implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 14 */     List<Table> tables = new ArrayList();
/* 15 */     tables.add(xtable.Role2pet_fight_team.getTable());
/* 16 */     tables.add(Role2pet_fight_formation.getTable());
/* 17 */     tables.add(Role2pet_fight_skill.getTable());
/* 18 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetFightMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */