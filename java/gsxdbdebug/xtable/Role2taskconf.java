/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.TaskConfBean;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2taskconf
/*     */ {
/*     */   public static TaskConfBean get(Long key)
/*     */   {
/*  12 */     return (TaskConfBean)_Tables_.getInstance().role2taskconf.get(key);
/*     */   }
/*     */   
/*     */   public static TaskConfBean get(Long key, TaskConfBean value)
/*     */   {
/*  17 */     return (TaskConfBean)_Tables_.getInstance().role2taskconf.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, TaskConfBean value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2taskconf.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2taskconf.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, TaskConfBean value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2taskconf.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2taskconf.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, TaskConfBean> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2taskconf.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, TaskConfBean> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2taskconf;
/*     */   }
/*     */   
/*     */   public static TaskConfBean select(Long key)
/*     */   {
/*  52 */     (TaskConfBean)getTable().select(key, new TField()
/*     */     {
/*     */       public TaskConfBean get(TaskConfBean v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGraphid(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TaskConfBean v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getGraphid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTaskid(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TaskConfBean v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getTaskid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLeaderid(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(TaskConfBean v)
/*     */       {
/*  89 */         return Long.valueOf(v.getLeaderid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBattleid(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(TaskConfBean v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getBattleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAllroles(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(TaskConfBean v)
/*     */       {
/* 111 */         return v.getAllrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAcceptroles(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(TaskConfBean v)
/*     */       {
/* 122 */         return v.getAcceptrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2taskconf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */