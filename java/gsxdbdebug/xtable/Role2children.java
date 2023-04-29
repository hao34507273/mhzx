/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2children
/*     */ {
/*     */   public static Role2ChildrenInfo get(Long key)
/*     */   {
/*  12 */     return (Role2ChildrenInfo)_Tables_.getInstance().role2children.get(key);
/*     */   }
/*     */   
/*     */   public static Role2ChildrenInfo get(Long key, Role2ChildrenInfo value)
/*     */   {
/*  17 */     return (Role2ChildrenInfo)_Tables_.getInstance().role2children.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2ChildrenInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2children.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2children.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2ChildrenInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2children.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2children.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2ChildrenInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2children.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2ChildrenInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2children;
/*     */   }
/*     */   
/*     */   public static Role2ChildrenInfo select(Long key)
/*     */   {
/*  52 */     (Role2ChildrenInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2ChildrenInfo get(Role2ChildrenInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectChild_id_list(Long key)
/*     */   {
/*  63 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(Role2ChildrenInfo v)
/*     */       {
/*  67 */         return v.getChild_id_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectChild_bag_id_list(Long key)
/*     */   {
/*  74 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(Role2ChildrenInfo v)
/*     */       {
/*  78 */         return v.getChild_bag_id_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectShow_child_id(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2ChildrenInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getShow_child_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSignal_way_child_score(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChildrenInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getSignal_way_child_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectShow_child_period(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChildrenInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getShow_child_period());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.ChildFashionInfo selectFashion_info(Long key)
/*     */   {
/* 118 */     (xbean.ChildFashionInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.ChildFashionInfo get(Role2ChildrenInfo v)
/*     */       {
/* 122 */         return v.getFashion_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_rating(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChildrenInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getTotal_rating());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_discard_child_num(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChildrenInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getTotal_discard_child_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPeriod_recall_times(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChildrenInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getPeriod_recall_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRecall_period_refresh_time(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2ChildrenInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getRecall_period_refresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2children.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */