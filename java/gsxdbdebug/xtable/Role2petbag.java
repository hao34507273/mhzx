/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetBag;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2petbag
/*    */ {
/*    */   public static PetBag get(Long key)
/*    */   {
/* 12 */     return (PetBag)_Tables_.getInstance().role2petbag.get(key);
/*    */   }
/*    */   
/*    */   public static PetBag get(Long key, PetBag value)
/*    */   {
/* 17 */     return (PetBag)_Tables_.getInstance().role2petbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetBag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetBag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PetBag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetBag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petbag;
/*    */   }
/*    */   
/*    */   public static PetBag select(Long key)
/*    */   {
/* 52 */     (PetBag)getTable().select(key, new TField()
/*    */     {
/*    */       public PetBag get(PetBag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectFightpet(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PetBag v)
/*    */       {
/* 67 */         return Long.valueOf(v.getFightpet());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectShowpet(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PetBag v)
/*    */       {
/* 78 */         return Long.valueOf(v.getShowpet());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectBagsize(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PetBag v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getBagsize());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.Pet> selectPetmap(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.Pet> get(PetBag v)
/*    */       {
/* :0 */         return v.getPetmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */