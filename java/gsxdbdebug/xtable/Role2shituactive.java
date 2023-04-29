/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AwardIndexIds;
/*    */ import xbean.ShiTuActive;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2shituactive
/*    */ {
/*    */   public static ShiTuActive get(Long key)
/*    */   {
/* 12 */     return (ShiTuActive)_Tables_.getInstance().role2shituactive.get(key);
/*    */   }
/*    */   
/*    */   public static ShiTuActive get(Long key, ShiTuActive value)
/*    */   {
/* 17 */     return (ShiTuActive)_Tables_.getInstance().role2shituactive.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ShiTuActive value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2shituactive.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2shituactive.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ShiTuActive value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2shituactive.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2shituactive.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ShiTuActive> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2shituactive.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ShiTuActive> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2shituactive;
/*    */   }
/*    */   
/*    */   public static ShiTuActive select(Long key)
/*    */   {
/* 52 */     (ShiTuActive)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ShiTuActive get(ShiTuActive v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectReset_time(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(ShiTuActive v)
/*    */       {
/* 67 */         return Long.valueOf(v.getReset_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, AwardIndexIds> selectAward_map(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, AwardIndexIds> get(ShiTuActive v)
/*    */       {
/* 78 */         return v.getAward_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2shituactive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */