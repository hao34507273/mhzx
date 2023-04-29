/*    */ package mzm.gsp.superequipment.jewel.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.EquipmentItem;
/*    */ import mzm.gsp.item.main.RoleEquipBag;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*    */ import xbean.JewelInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentJewelInterface
/*    */ {
/*    */   public static Map<Integer, Integer> getProperties(RoleEquipBag equipBag)
/*    */   {
/* 20 */     Map<Integer, Integer> proMap = new HashMap();
/* 21 */     if (!OpenInterface.getOpenStatus(385)) {
/* 22 */       return proMap;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 27 */     for (BasicItem basicItem : equipBag.getAllItems(false).values())
/*    */     {
/* 29 */       if ((basicItem instanceof EquipmentItem))
/*    */       {
/*    */ 
/* 32 */         EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 33 */         if (equipmentItem.getSuperEquipmentStage() != 0)
/*    */         {
/*    */ 
/* 36 */           Map<Integer, JewelInfo> jewelMap = basicItem.getJewelMap();
/*    */           
/* 38 */           for (Map.Entry<Integer, JewelInfo> entry : jewelMap.entrySet())
/*    */           {
/* 40 */             SSuperEquipmentJewelItem superEquipmentJewelItem = SSuperEquipmentJewelItem.get(((JewelInfo)entry.getValue()).getJewelcfgid());
/*    */             
/* 42 */             if (superEquipmentJewelItem != null)
/*    */             {
/*    */ 
/*    */ 
/* 46 */               for (int i = 0; i < superEquipmentJewelItem.properTypes.size(); i++)
/*    */               {
/* 48 */                 int proType = ((Integer)superEquipmentJewelItem.properTypes.get(i)).intValue();
/* 49 */                 int proValue; int proValue; if (proMap.containsKey(Integer.valueOf(proType)))
/*    */                 {
/* 51 */                   proValue = ((Integer)proMap.get(Integer.valueOf(proType))).intValue();
/*    */                 }
/*    */                 else
/*    */                 {
/* 55 */                   proValue = 0;
/*    */                 }
/* 57 */                 proValue += ((Integer)superEquipmentJewelItem.propertyValues.get(i)).intValue();
/* 58 */                 proMap.put(Integer.valueOf(proType), Integer.valueOf(proValue));
/*    */               } }
/*    */           }
/*    */         }
/*    */       } }
/* 63 */     return proMap;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\SuperEquipmentJewelInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */