/*     */ package xtable;
/*     */ 
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Children
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().children.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().children.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(ChildInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ChildInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ChildInfo get(Long key)
/*     */   {
/*  46 */     return (ChildInfo)_Tables_.getInstance().children.get(key);
/*     */   }
/*     */   
/*     */   public static ChildInfo get(Long key, ChildInfo value)
/*     */   {
/*  51 */     return (ChildInfo)_Tables_.getInstance().children.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ChildInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().children.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ChildInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().children.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().children.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ChildInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().children.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ChildInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().children.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().children.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ChildInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().children.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ChildInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().children;
/*     */   }
/*     */   
/*     */   public static ChildInfo select(Long key)
/*     */   {
/*  96 */     (ChildInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ChildInfo get(ChildInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOwn_role_id(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getOwn_role_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChild_period(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChildInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getChild_period());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectChild_name(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(ChildInfo v)
/*     */       {
/* 133 */         return v.getChild_name();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChild_gender(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChildInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getChild_gender());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAnother_parent_role_id(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getAnother_parent_role_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.BabyPeriodInfo selectBaby_period_info(Long key)
/*     */   {
/* 162 */     (xbean.BabyPeriodInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.BabyPeriodInfo get(ChildInfo v)
/*     */       {
/* 166 */         return v.getBaby_period_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static ChildhoodInfo selectChildhood_info(Long key)
/*     */   {
/* 173 */     (ChildhoodInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ChildhoodInfo get(ChildInfo v)
/*     */       {
/* 177 */         return v.getChildhood_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHome_state(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChildInfo v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getHome_state());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, xbean.DressedInfo> selectDressed(Long key)
/*     */   {
/* 195 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, xbean.DressedInfo> get(ChildInfo v)
/*     */       {
/* 199 */         return v.getDressedAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCarry_role_id(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildInfo v)
/*     */       {
/* 210 */         return Long.valueOf(v.getCarry_role_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.AdulthoodInfo> selectAdulthood_info(Long key)
/*     */   {
/* 217 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.AdulthoodInfo> get(ChildInfo v)
/*     */       {
/* 221 */         return v.getAdulthood_infoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPosition_x(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChildInfo v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getPosition_x());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPosition_y(Long key)
/*     */   {
/* 239 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChildInfo v)
/*     */       {
/* 243 */         return Integer.valueOf(v.getPosition_y());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIs_discard(Long key)
/*     */   {
/* 250 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(ChildInfo v)
/*     */       {
/* 254 */         return Boolean.valueOf(v.getIs_discard());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectDiscard_time(Long key)
/*     */   {
/* 261 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChildInfo v)
/*     */       {
/* 265 */         return Long.valueOf(v.getDiscard_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Children.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */