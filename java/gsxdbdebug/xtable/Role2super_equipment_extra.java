/*    */ package xtable;
/*    */ 
/*    */ import xbean.SuperEquipmentExtraInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2super_equipment_extra
/*    */ {
/*    */   public static SuperEquipmentExtraInfo get(Long key)
/*    */   {
/* 12 */     return (SuperEquipmentExtraInfo)_Tables_.getInstance().role2super_equipment_extra.get(key);
/*    */   }
/*    */   
/*    */   public static SuperEquipmentExtraInfo get(Long key, SuperEquipmentExtraInfo value)
/*    */   {
/* 17 */     return (SuperEquipmentExtraInfo)_Tables_.getInstance().role2super_equipment_extra.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SuperEquipmentExtraInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2super_equipment_extra.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2super_equipment_extra.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SuperEquipmentExtraInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2super_equipment_extra.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2super_equipment_extra.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, SuperEquipmentExtraInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2super_equipment_extra.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SuperEquipmentExtraInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2super_equipment_extra;
/*    */   }
/*    */   
/*    */   public static SuperEquipmentExtraInfo select(Long key)
/*    */   {
/* 52 */     (SuperEquipmentExtraInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public SuperEquipmentExtraInfo get(SuperEquipmentExtraInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIs_jewel_fixed(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(SuperEquipmentExtraInfo v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getIs_jewel_fixed());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2super_equipment_extra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */