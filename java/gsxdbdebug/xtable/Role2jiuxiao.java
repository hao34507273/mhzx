/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.JiuXiaoBean;
/*    */ import xbean.JiuXiaoFloorBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2jiuxiao
/*    */ {
/*    */   public static JiuXiaoBean get(Long key)
/*    */   {
/* 12 */     return (JiuXiaoBean)_Tables_.getInstance().role2jiuxiao.get(key);
/*    */   }
/*    */   
/*    */   public static JiuXiaoBean get(Long key, JiuXiaoBean value)
/*    */   {
/* 17 */     return (JiuXiaoBean)_Tables_.getInstance().role2jiuxiao.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JiuXiaoBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jiuxiao.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jiuxiao.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JiuXiaoBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jiuxiao.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jiuxiao.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, JiuXiaoBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jiuxiao.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JiuXiaoBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jiuxiao;
/*    */   }
/*    */   
/*    */   public static JiuXiaoBean select(Long key)
/*    */   {
/* 52 */     (JiuXiaoBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public JiuXiaoBean get(JiuXiaoBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, JiuXiaoFloorBean> selectFloormap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, JiuXiaoFloorBean> get(JiuXiaoBean v)
/*    */       {
/* 67 */         return v.getFloormapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jiuxiao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */