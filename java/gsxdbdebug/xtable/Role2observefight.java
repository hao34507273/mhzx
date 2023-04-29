/*    */ package xtable;
/*    */ 
/*    */ import xbean.ObserveFight;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2observefight
/*    */ {
/*    */   public static ObserveFight get(Long key)
/*    */   {
/* 12 */     return (ObserveFight)_Tables_.getInstance().role2observefight.get(key);
/*    */   }
/*    */   
/*    */   public static ObserveFight get(Long key, ObserveFight value)
/*    */   {
/* 17 */     return (ObserveFight)_Tables_.getInstance().role2observefight.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ObserveFight value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2observefight.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2observefight.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ObserveFight value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2observefight.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2observefight.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ObserveFight> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2observefight.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ObserveFight> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2observefight;
/*    */   }
/*    */   
/*    */   public static ObserveFight select(Long key)
/*    */   {
/* 52 */     (ObserveFight)getTable().select(key, new TField()
/*    */     {
/*    */       public ObserveFight get(ObserveFight v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectFightid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ObserveFight v)
/*    */       {
/* 67 */         return Long.valueOf(v.getFightid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectObservetype(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ObserveFight v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getObservetype());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectObservevalue(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ObserveFight v)
/*    */       {
/* 89 */         return Long.valueOf(v.getObservevalue());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectObserveteamtype(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ObserveFight v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getObserveteamtype());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2observefight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */