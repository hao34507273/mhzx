/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.config.event.ConfigReloadedProcedure;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnConfigReloaded
/*    */   extends ConfigReloadedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     for (SShangHuiItemToolsCfg oldShangHuiItemToolsCfg : SShangHuiItemToolsCfg.getOldAll().values()) {
/* 22 */       SShangHuiItemToolsCfg newShangHuiItemToolsCfg = SShangHuiItemToolsCfg.get(oldShangHuiItemToolsCfg.id);
/* 23 */       if (newShangHuiItemToolsCfg == null) {
/* 24 */         deleteShanghuiItem(oldShangHuiItemToolsCfg.SubTypeId, oldShangHuiItemToolsCfg.id);
/*    */       }
/*    */     }
/*    */     
/* 28 */     for (SShangHuiItemToolsCfg newShangHuiItemToolsCfg : SShangHuiItemToolsCfg.getAll().values()) {
/* 29 */       SShangHuiItemToolsCfg oldShangHuiItemToolsCfg = SShangHuiItemToolsCfg.getOld(newShangHuiItemToolsCfg.id);
/* 30 */       if (oldShangHuiItemToolsCfg == null) {
/* 31 */         addShanghuiItem(newShangHuiItemToolsCfg.id);
/*    */       }
/*    */     }
/*    */     
/* 35 */     for (SShangHuiItemToolsCfg newShangHuiItemToolsCfg : SShangHuiItemToolsCfg.getAll().values()) {
/* 36 */       SShangHuiItemToolsCfg oldShangHuiItemToolsCfg = SShangHuiItemToolsCfg.getOld(newShangHuiItemToolsCfg.id);
/* 37 */       if ((oldShangHuiItemToolsCfg != null) && 
/* 38 */         (oldShangHuiItemToolsCfg.orginialPrice != newShangHuiItemToolsCfg.orginialPrice)) {
/* 39 */         changeShanghuiItemPrice(newShangHuiItemToolsCfg.id);
/*    */       }
/*    */     }
/*    */     
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   private void deleteShanghuiItem(int subTypeId, int itemId) {
/* 47 */     new POnDeleteShanghuiItem(subTypeId, itemId).execute();
/*    */   }
/*    */   
/*    */   private void addShanghuiItem(int itemId) {
/* 51 */     new POnAddShanghuiItem(itemId).execute();
/*    */   }
/*    */   
/*    */   private void changeShanghuiItemPrice(int itemId) {
/* 55 */     new POnChangeShanghuiItemPrice(itemId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */