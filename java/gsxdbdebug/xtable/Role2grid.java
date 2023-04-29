/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleGrid;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2grid
/*    */ {
/*    */   public static RoleGrid get(Long key)
/*    */   {
/* 12 */     return (RoleGrid)_Tables_.getInstance().role2grid.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGrid get(Long key, RoleGrid value)
/*    */   {
/* 17 */     return (RoleGrid)_Tables_.getInstance().role2grid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGrid value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2grid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2grid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGrid value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2grid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2grid.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGrid> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2grid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGrid> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2grid;
/*    */   }
/*    */   
/*    */   public static RoleGrid select(Long key)
/*    */   {
/* 52 */     (RoleGrid)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleGrid get(RoleGrid v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMaxgridnum(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleGrid v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMaxgridnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastrefreshtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleGrid v)
/*    */       {
/* 78 */         return Long.valueOf(v.getLastrefreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectShoppingid2channelid(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(RoleGrid v)
/*    */       {
/* 89 */         return v.getShoppingid2channelidAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.Set<Long> selectNeedrecycleshoppingids(Long key)
/*    */   {
/* 96 */     (java.util.Set)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.Set<Long> get(RoleGrid v)
/*    */       {
/* :0 */         return v.getNeedrecycleshoppingidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2grid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */