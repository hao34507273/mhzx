/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.JiuXiaoCacheBean;
/*    */ import xbean.JiuXiaoFloorCacheBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2jiuxiaocache
/*    */ {
/*    */   public static JiuXiaoCacheBean get(Long key)
/*    */   {
/* 12 */     return (JiuXiaoCacheBean)_Tables_.getInstance().role2jiuxiaocache.get(key);
/*    */   }
/*    */   
/*    */   public static JiuXiaoCacheBean get(Long key, JiuXiaoCacheBean value)
/*    */   {
/* 17 */     return (JiuXiaoCacheBean)_Tables_.getInstance().role2jiuxiaocache.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JiuXiaoCacheBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jiuxiaocache.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jiuxiaocache.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JiuXiaoCacheBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jiuxiaocache.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jiuxiaocache.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, JiuXiaoCacheBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jiuxiaocache.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JiuXiaoCacheBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jiuxiaocache;
/*    */   }
/*    */   
/*    */   public static JiuXiaoCacheBean select(Long key)
/*    */   {
/* 52 */     (JiuXiaoCacheBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public JiuXiaoCacheBean get(JiuXiaoCacheBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, JiuXiaoFloorCacheBean> selectFloorcachemap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, JiuXiaoFloorCacheBean> get(JiuXiaoCacheBean v)
/*    */       {
/* 67 */         return v.getFloorcachemapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectJiuxiaoactivityid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(JiuXiaoCacheBean v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getJiuxiaoactivityid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jiuxiaocache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */