/*    */ package xtable;
/*    */ 
/*    */ import xbean.HomeOwners;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Homeworld2roles
/*    */ {
/*    */   public static HomeOwners get(Long key)
/*    */   {
/* 12 */     return (HomeOwners)_Tables_.getInstance().homeworld2roles.get(key);
/*    */   }
/*    */   
/*    */   public static HomeOwners get(Long key, HomeOwners value)
/*    */   {
/* 17 */     return (HomeOwners)_Tables_.getInstance().homeworld2roles.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HomeOwners value)
/*    */   {
/* 22 */     _Tables_.getInstance().homeworld2roles.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().homeworld2roles.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HomeOwners value)
/*    */   {
/* 32 */     return _Tables_.getInstance().homeworld2roles.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().homeworld2roles.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, HomeOwners> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().homeworld2roles.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HomeOwners> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().homeworld2roles;
/*    */   }
/*    */   
/*    */   public static HomeOwners select(Long key)
/*    */   {
/* 52 */     (HomeOwners)getTable().select(key, new TField()
/*    */     {
/*    */       public HomeOwners get(HomeOwners v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCreatorroleid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(HomeOwners v)
/*    */       {
/* 67 */         return Long.valueOf(v.getCreatorroleid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPartnerroleid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(HomeOwners v)
/*    */       {
/* 78 */         return Long.valueOf(v.getPartnerroleid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Homeworld2roles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */