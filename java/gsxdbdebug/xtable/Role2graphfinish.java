/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GraphFinishBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2graphfinish
/*    */ {
/*    */   public static GraphFinishBean get(Long key)
/*    */   {
/* 12 */     return (GraphFinishBean)_Tables_.getInstance().role2graphfinish.get(key);
/*    */   }
/*    */   
/*    */   public static GraphFinishBean get(Long key, GraphFinishBean value)
/*    */   {
/* 17 */     return (GraphFinishBean)_Tables_.getInstance().role2graphfinish.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GraphFinishBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2graphfinish.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2graphfinish.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GraphFinishBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2graphfinish.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2graphfinish.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GraphFinishBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2graphfinish.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GraphFinishBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2graphfinish;
/*    */   }
/*    */   
/*    */   public static GraphFinishBean select(Long key)
/*    */   {
/* 52 */     (GraphFinishBean)getTable().select(key, new TField()
/*    */     {
/*    */       public GraphFinishBean get(GraphFinishBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGraphidtofinish(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(GraphFinishBean v)
/*    */       {
/* 67 */         return v.getGraphidtofinishAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2graphfinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */