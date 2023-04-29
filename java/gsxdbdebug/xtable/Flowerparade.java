/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.FlowerParade;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Flowerparade
/*     */ {
/*     */   public static FlowerParade get(Long key)
/*     */   {
/*  12 */     return (FlowerParade)_Tables_.getInstance().flowerparade.get(key);
/*     */   }
/*     */   
/*     */   public static FlowerParade get(Long key, FlowerParade value)
/*     */   {
/*  17 */     return (FlowerParade)_Tables_.getInstance().flowerparade.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FlowerParade value)
/*     */   {
/*  22 */     _Tables_.getInstance().flowerparade.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().flowerparade.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FlowerParade value)
/*     */   {
/*  32 */     return _Tables_.getInstance().flowerparade.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().flowerparade.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, FlowerParade> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().flowerparade.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FlowerParade> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().flowerparade;
/*     */   }
/*     */   
/*     */   public static FlowerParade select(Long key)
/*     */   {
/*  52 */     (FlowerParade)getTable().select(key, new TField()
/*     */     {
/*     */       public FlowerParade get(FlowerParade v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectRoles(Long key)
/*     */   {
/*  63 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(FlowerParade v)
/*     */       {
/*  67 */         return v.getRolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOcpid(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerParade v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getOcpid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMapid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerParade v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getMapid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDanceindex(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerParade v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getDanceindex());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToposindex(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerParade v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getToposindex());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, Long> selectFollowtimestart(Long key)
/*     */   {
/* 118 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, Long> get(FlowerParade v)
/*     */       {
/* 122 */         return v.getFollowtimestartAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FlowerParade v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionidrest(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 144 */         return Long.valueOf(v.getSessionidrest());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionidcountdown(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 155 */         return Long.valueOf(v.getSessionidcountdown());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFlowerinstanceid(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 166 */         return Long.valueOf(v.getFlowerinstanceid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectFlowerroleiddoneset(Long key)
/*     */   {
/* 173 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(FlowerParade v)
/*     */       {
/* 177 */         return v.getFlowerroleiddonesetAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttimeinsec(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 188 */         return Long.valueOf(v.getStarttimeinsec());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionidstopcountdown(Long key)
/*     */   {
/* 195 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 199 */         return Long.valueOf(v.getSessionidstopcountdown());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectParadeindex(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FlowerParade v)
/*     */       {
/* 210 */         return Long.valueOf(v.getParadeindex());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Flowerparade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */