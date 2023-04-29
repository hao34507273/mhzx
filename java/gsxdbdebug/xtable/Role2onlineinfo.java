/*     */ package xtable;
/*     */ 
/*     */ import xbean.OnlineInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2onlineinfo
/*     */ {
/*     */   public static OnlineInfo get(Long key)
/*     */   {
/*  12 */     return (OnlineInfo)_Tables_.getInstance().role2onlineinfo.get(key);
/*     */   }
/*     */   
/*     */   public static OnlineInfo get(Long key, OnlineInfo value)
/*     */   {
/*  17 */     return (OnlineInfo)_Tables_.getInstance().role2onlineinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, OnlineInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2onlineinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2onlineinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, OnlineInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2onlineinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2onlineinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, OnlineInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2onlineinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, OnlineInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2onlineinfo;
/*     */   }
/*     */   
/*     */   public static OnlineInfo select(Long key)
/*     */   {
/*  52 */     (OnlineInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public OnlineInfo get(OnlineInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastcalcuatetime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(OnlineInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getLastcalcuatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSingle_online(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getSingle_online());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectIs_adult(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getIs_adult());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAccumu_time(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getAccumu_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAge(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getAge());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReport_count(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getReport_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPeriod_time(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getPeriod_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectKickout_type(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getKickout_type());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRest_time(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getRest_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2onlineinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */