/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleLessCold1;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2lesscold1
/*    */ {
/*    */   public static RoleLessCold1 get(Long key)
/*    */   {
/* 12 */     return (RoleLessCold1)_Tables_.getInstance().role2lesscold1.get(key);
/*    */   }
/*    */   
/*    */   public static RoleLessCold1 get(Long key, RoleLessCold1 value)
/*    */   {
/* 17 */     return (RoleLessCold1)_Tables_.getInstance().role2lesscold1.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleLessCold1 value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2lesscold1.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2lesscold1.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleLessCold1 value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2lesscold1.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2lesscold1.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleLessCold1> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2lesscold1.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleLessCold1> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2lesscold1;
/*    */   }
/*    */   
/*    */   public static RoleLessCold1 select(Long key)
/*    */   {
/* 52 */     (RoleLessCold1)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleLessCold1 get(RoleLessCold1 v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRobparadecount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleLessCold1 v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getRobparadecount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRobprotectcount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleLessCold1 v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getRobprotectcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectRobparadetime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleLessCold1 v)
/*    */       {
/* 89 */         return Long.valueOf(v.getRobparadetime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectRobprotecttime(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleLessCold1 v)
/*    */       {
/* :0 */         return Long.valueOf(v.getRobprotecttime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2lesscold1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */