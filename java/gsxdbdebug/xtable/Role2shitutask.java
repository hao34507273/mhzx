/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.ShiTuTaskInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2shitutask
/*     */ {
/*     */   public static ShiTuTaskInfo get(Long key)
/*     */   {
/*  12 */     return (ShiTuTaskInfo)_Tables_.getInstance().role2shitutask.get(key);
/*     */   }
/*     */   
/*     */   public static ShiTuTaskInfo get(Long key, ShiTuTaskInfo value)
/*     */   {
/*  17 */     return (ShiTuTaskInfo)_Tables_.getInstance().role2shitutask.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ShiTuTaskInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2shitutask.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2shitutask.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ShiTuTaskInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2shitutask.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2shitutask.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ShiTuTaskInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2shitutask.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ShiTuTaskInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2shitutask;
/*     */   }
/*     */   
/*     */   public static ShiTuTaskInfo select(Long key)
/*     */   {
/*  52 */     (ShiTuTaskInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ShiTuTaskInfo get(ShiTuTaskInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectReset_time(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ShiTuTaskInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getReset_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPublish_state(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShiTuTaskInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getPublish_state());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRefresh_times(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShiTuTaskInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getRefresh_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectShitu_task_count(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShiTuTaskInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getShitu_task_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ShiTuTask> selectTask_infos(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.ShiTuTask> get(ShiTuTaskInfo v)
/*     */       {
/* 111 */         return v.getTask_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2shitutask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */