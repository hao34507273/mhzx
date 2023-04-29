/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.HomeOperate;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2homeoperate
/*     */ {
/*     */   public static HomeOperate get(Long key)
/*     */   {
/*  12 */     return (HomeOperate)_Tables_.getInstance().role2homeoperate.get(key);
/*     */   }
/*     */   
/*     */   public static HomeOperate get(Long key, HomeOperate value)
/*     */   {
/*  17 */     return (HomeOperate)_Tables_.getInstance().role2homeoperate.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, HomeOperate value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2homeoperate.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2homeoperate.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, HomeOperate value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2homeoperate.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2homeoperate.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, HomeOperate> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2homeoperate.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, HomeOperate> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2homeoperate;
/*     */   }
/*     */   
/*     */   public static HomeOperate select(Long key)
/*     */   {
/*  52 */     (HomeOperate)getTable().select(key, new TField()
/*     */     {
/*     */       public HomeOperate get(HomeOperate v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.FurnitureUuIds> selectOwnfurnitures(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.FurnitureUuIds> get(HomeOperate v)
/*     */       {
/*  67 */         return v.getOwnfurnituresAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Integer> selectCanbuyitems(Long key)
/*     */   {
/*  74 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Integer> get(HomeOperate v)
/*     */       {
/*  78 */         return v.getCanbuyitemsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectItem2buynum(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(HomeOperate v)
/*     */       {
/*  89 */         return v.getItem2buynumAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDayrefreshcount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeOperate v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getDayrefreshcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDayrestorevigorcount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeOperate v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getDayrestorevigorcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDayrestoresatiationcount(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeOperate v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getDayrestoresatiationcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDayttrainpetcount(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeOperate v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getDayttrainpetcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectUpdatetime(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeOperate v)
/*     */       {
/* 144 */         return Long.valueOf(v.getUpdatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHomestate(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeOperate v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getHomestate());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectCanbuyitem2num(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(HomeOperate v)
/*     */       {
/* 166 */         return v.getCanbuyitem2numAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2homeoperate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */