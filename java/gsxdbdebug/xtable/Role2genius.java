/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GeniusInfo;
/*    */ import xbean.GeniusSeries;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2genius
/*    */ {
/*    */   public static GeniusInfo get(Long key)
/*    */   {
/* 12 */     return (GeniusInfo)_Tables_.getInstance().role2genius.get(key);
/*    */   }
/*    */   
/*    */   public static GeniusInfo get(Long key, GeniusInfo value)
/*    */   {
/* 17 */     return (GeniusInfo)_Tables_.getInstance().role2genius.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GeniusInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2genius.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2genius.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GeniusInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2genius.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2genius.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GeniusInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2genius.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GeniusInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2genius;
/*    */   }
/*    */   
/*    */   public static GeniusInfo select(Long key)
/*    */   {
/* 52 */     (GeniusInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GeniusInfo get(GeniusInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, GeniusSeries> selectGenius_series(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, GeniusSeries> get(GeniusInfo v)
/*    */       {
/* 67 */         return v.getGenius_seriesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectExtra_point(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(GeniusInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getExtra_point());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2genius.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */