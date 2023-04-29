/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PetDepot;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2petdepot
/*    */ {
/*    */   public static PetDepot get(Long key)
/*    */   {
/* 12 */     return (PetDepot)_Tables_.getInstance().role2petdepot.get(key);
/*    */   }
/*    */   
/*    */   public static PetDepot get(Long key, PetDepot value)
/*    */   {
/* 17 */     return (PetDepot)_Tables_.getInstance().role2petdepot.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetDepot value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petdepot.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petdepot.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetDepot value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petdepot.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petdepot.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PetDepot> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petdepot.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetDepot> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petdepot;
/*    */   }
/*    */   
/*    */   public static PetDepot select(Long key)
/*    */   {
/* 52 */     (PetDepot)getTable().select(key, new TField()
/*    */     {
/*    */       public PetDepot get(PetDepot v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDepotsize(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PetDepot v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDepotsize());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.Pet> selectPetmap(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.Pet> get(PetDepot v)
/*    */       {
/* 78 */         return v.getPetmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petdepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */