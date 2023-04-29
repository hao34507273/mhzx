/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GraphBean;
/*    */ import xbean.TaskDataBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2task
/*    */ {
/*    */   public static TaskDataBean get(Long key)
/*    */   {
/* 12 */     return (TaskDataBean)_Tables_.getInstance().role2task.get(key);
/*    */   }
/*    */   
/*    */   public static TaskDataBean get(Long key, TaskDataBean value)
/*    */   {
/* 17 */     return (TaskDataBean)_Tables_.getInstance().role2task.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TaskDataBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2task.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2task.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TaskDataBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2task.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2task.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TaskDataBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2task.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TaskDataBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2task;
/*    */   }
/*    */   
/*    */   public static TaskDataBean select(Long key)
/*    */   {
/* 52 */     (TaskDataBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public TaskDataBean get(TaskDataBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, GraphBean> selectGraphbeans(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, GraphBean> get(TaskDataBean v)
/*    */       {
/* 67 */         return v.getGraphbeansAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */