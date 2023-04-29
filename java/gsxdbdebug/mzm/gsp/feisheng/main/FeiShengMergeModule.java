/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.MergeModule;
/*    */ import xdb.Table;
/*    */ import xtable.Role_fei_sheng_develop_item_infos;
/*    */ import xtable.Role_fei_sheng_fight_infos;
/*    */ import xtable.Role_fei_sheng_infos;
/*    */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeiShengMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 19 */     return Arrays.asList(new Table[] { Role_fei_sheng_fight_infos.getTable(), Role_fei_sheng_develop_item_infos.getTable(), Role_fei_sheng_zhu_xian_jian_zhen_infos.getTable(), Role_fei_sheng_infos.getTable() });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */