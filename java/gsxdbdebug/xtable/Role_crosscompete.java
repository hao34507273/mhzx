/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleCrossCompete;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role_crosscompete
/*    */ {
/*    */   public static RoleCrossCompete get(Long key)
/*    */   {
/* 12 */     return (RoleCrossCompete)_Tables_.getInstance().role_crosscompete.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCrossCompete get(Long key, RoleCrossCompete value)
/*    */   {
/* 17 */     return (RoleCrossCompete)_Tables_.getInstance().role_crosscompete.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCrossCompete value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_crosscompete.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_crosscompete.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCrossCompete value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_crosscompete.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_crosscompete.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleCrossCompete> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_crosscompete.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCrossCompete> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_crosscompete;
/*    */   }
/*    */   
/*    */   public static RoleCrossCompete select(Long key)
/*    */   {
/* 52 */     (RoleCrossCompete)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleCrossCompete get(RoleCrossCompete v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectParticipated(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(RoleCrossCompete v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getParticipated());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_crosscompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */