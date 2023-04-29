/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EquipmentLogStatus
/*    */ {
/* 10 */   EQUIP_MAKE(1), 
/* 11 */   EQUIP_CHUANGCHENG(2), 
/* 12 */   EQUIP_QILIN(3), 
/* 13 */   EQUIP_FUHUN(4);
/*    */   
/*    */ 
/*    */   public final int value;
/*    */   
/*    */   private EquipmentLogStatus(int value)
/*    */   {
/* 20 */     this.value = value;
/*    */   }
/*    */   
/*    */   public static void checkEquipmengLogStatus() {
/* 24 */     Set<Integer> values = new HashSet();
/* 25 */     for (EquipmentLogStatus type : values())
/*    */     {
/*    */ 
/* 28 */       if (!values.add(Integer.valueOf(type.value))) {
/* 29 */         throw new RuntimeException(String.format("EquipmentLogStatus中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\EquipmentLogStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */