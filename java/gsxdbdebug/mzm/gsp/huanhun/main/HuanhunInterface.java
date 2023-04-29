/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*    */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*    */ import mzm.gsp.item.main.sift.SiftInterface;
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
/*    */ public class HuanhunInterface
/*    */ {
/*    */   public static List<Integer> getHuanHunAwardItems(int selectItemCfgId)
/*    */   {
/* 22 */     SItemSiftCfg itemSiftCfg = SItemSiftCfg.get(selectItemCfgId);
/* 23 */     if (itemSiftCfg == null)
/*    */     {
/* 25 */       return null;
/*    */     }
/*    */     
/*    */ 
/* 29 */     List<Integer> itemCfgIdList = HuanhunModule.getHuanHunAwardId(selectItemCfgId);
/* 30 */     if (null != itemCfgIdList)
/*    */     {
/* 32 */       return itemCfgIdList;
/*    */     }
/*    */     
/* 35 */     List<Integer> huanHunAwardItems = new ArrayList();
/* 36 */     for (IdTypeValueBean idTypeValueBean : itemSiftCfg.idTypeValueBeans)
/*    */     {
/* 38 */       if (idTypeValueBean.idtype == 1)
/*    */       {
/* 40 */         huanHunAwardItems.add(Integer.valueOf(idTypeValueBean.idvalue));
/*    */       }
/* 42 */       else if (idTypeValueBean.idtype == 2)
/*    */       {
/* 44 */         huanHunAwardItems.addAll(SiftInterface.siftItems(idTypeValueBean.idvalue));
/*    */       }
/*    */     }
/*    */     
/* 48 */     if (huanHunAwardItems.isEmpty())
/*    */     {
/* 50 */       return null;
/*    */     }
/*    */     
/* 53 */     return huanHunAwardItems;
/*    */   }
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
/*    */   public static HunNeedItemData getRoleHunNeedItemData(long roleId)
/*    */   {
/* 67 */     return HuanhunManager.getHunNeedItemData(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanhunInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */