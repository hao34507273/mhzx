/*    */ package xtable;
/*    */ 
/*    */ import xbean.EquipMode;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2equipmode
/*    */ {
/*    */   public static EquipMode get(Long key)
/*    */   {
/* 12 */     return (EquipMode)_Tables_.getInstance().role2equipmode.get(key);
/*    */   }
/*    */   
/*    */   public static EquipMode get(Long key, EquipMode value)
/*    */   {
/* 17 */     return (EquipMode)_Tables_.getInstance().role2equipmode.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, EquipMode value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2equipmode.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2equipmode.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, EquipMode value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2equipmode.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2equipmode.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, EquipMode> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2equipmode.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, EquipMode> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2equipmode;
/*    */   }
/*    */   
/*    */   public static EquipMode select(Long key)
/*    */   {
/* 52 */     (EquipMode)getTable().select(key, new TField()
/*    */     {
/*    */       public EquipMode get(EquipMode v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMode(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(EquipMode v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMode());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsset(Long key)
/*    */   {
/* 74 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(EquipMode v)
/*    */       {
/* 78 */         return Boolean.valueOf(v.getIsset());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2equipmode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */