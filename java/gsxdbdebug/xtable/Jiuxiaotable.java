/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.JiuXiaoActivityBean;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Jiuxiaotable
/*    */ {
/*    */   public static JiuXiaoActivityBean get(Long key)
/*    */   {
/* 12 */     return (JiuXiaoActivityBean)_Tables_.getInstance().jiuxiaotable.get(key);
/*    */   }
/*    */   
/*    */   public static JiuXiaoActivityBean get(Long key, JiuXiaoActivityBean value)
/*    */   {
/* 17 */     return (JiuXiaoActivityBean)_Tables_.getInstance().jiuxiaotable.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JiuXiaoActivityBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().jiuxiaotable.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().jiuxiaotable.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JiuXiaoActivityBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().jiuxiaotable.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().jiuxiaotable.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, JiuXiaoActivityBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().jiuxiaotable.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JiuXiaoActivityBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().jiuxiaotable;
/*    */   }
/*    */   
/*    */   public static JiuXiaoActivityBean select(Long key)
/*    */   {
/* 52 */     (JiuXiaoActivityBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public JiuXiaoActivityBean get(JiuXiaoActivityBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, JiuXiaoActivityInfo> selectActivityinfomap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, JiuXiaoActivityInfo> get(JiuXiaoActivityBean v)
/*    */       {
/* 67 */         return v.getActivityinfomapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Jiuxiaotable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */