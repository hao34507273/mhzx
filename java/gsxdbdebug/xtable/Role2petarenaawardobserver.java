/*    */ package xtable;
/*    */ 
/*    */ import xbean.PetArenaAwardObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2petarenaawardobserver
/*    */ {
/*    */   public static PetArenaAwardObserver get(Long key)
/*    */   {
/* 12 */     return (PetArenaAwardObserver)_Tables_.getInstance().role2petarenaawardobserver.get(key);
/*    */   }
/*    */   
/*    */   public static PetArenaAwardObserver get(Long key, PetArenaAwardObserver value)
/*    */   {
/* 17 */     return (PetArenaAwardObserver)_Tables_.getInstance().role2petarenaawardobserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetArenaAwardObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petarenaawardobserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petarenaawardobserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetArenaAwardObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petarenaawardobserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petarenaawardobserver.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, PetArenaAwardObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petarenaawardobserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetArenaAwardObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petarenaawardobserver;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petarenaawardobserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */