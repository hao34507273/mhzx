/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GraphTaskFinishBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2graphtaskfinish
/*    */ {
/*    */   public static GraphTaskFinishBean get(Long key)
/*    */   {
/* 12 */     return (GraphTaskFinishBean)_Tables_.getInstance().role2graphtaskfinish.get(key);
/*    */   }
/*    */   
/*    */   public static GraphTaskFinishBean get(Long key, GraphTaskFinishBean value)
/*    */   {
/* 17 */     return (GraphTaskFinishBean)_Tables_.getInstance().role2graphtaskfinish.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GraphTaskFinishBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2graphtaskfinish.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2graphtaskfinish.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GraphTaskFinishBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2graphtaskfinish.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2graphtaskfinish.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GraphTaskFinishBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2graphtaskfinish.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GraphTaskFinishBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2graphtaskfinish;
/*    */   }
/*    */   
/*    */   public static GraphTaskFinishBean select(Long key)
/*    */   {
/* 52 */     (GraphTaskFinishBean)getTable().select(key, new TField()
/*    */     {
/*    */       public GraphTaskFinishBean get(GraphTaskFinishBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGraphidtotaskid(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(GraphTaskFinishBean v)
/*    */       {
/* 67 */         return v.getGraphidtotaskidAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2graphtaskfinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */