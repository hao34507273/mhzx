/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CustommizedCons;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2customized
/*    */ {
/*    */   public static CustommizedCons get(Long key)
/*    */   {
/* 12 */     return (CustommizedCons)_Tables_.getInstance().role2customized.get(key);
/*    */   }
/*    */   
/*    */   public static CustommizedCons get(Long key, CustommizedCons value)
/*    */   {
/* 17 */     return (CustommizedCons)_Tables_.getInstance().role2customized.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CustommizedCons value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2customized.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2customized.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CustommizedCons value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2customized.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2customized.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CustommizedCons> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2customized.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CustommizedCons> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2customized;
/*    */   }
/*    */   
/*    */   public static CustommizedCons select(Long key)
/*    */   {
/* 52 */     (CustommizedCons)getTable().select(key, new TField()
/*    */     {
/*    */       public CustommizedCons get(CustommizedCons v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastsearchtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CustommizedCons v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastsearchtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.MarketEquipConSet> selectSubid2equipcons(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.MarketEquipConSet> get(CustommizedCons v)
/*    */       {
/* 78 */         return v.getSubid2equipconsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.MarketPetConSet> selectSubid2petcons(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.MarketPetConSet> get(CustommizedCons v)
/*    */       {
/* 89 */         return v.getSubid2petconsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.MarketPetEquipConSet> selectSubid2petequipcons(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.MarketPetEquipConSet> get(CustommizedCons v)
/*    */       {
/* :0 */         return v.getSubid2petequipconsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2customized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */