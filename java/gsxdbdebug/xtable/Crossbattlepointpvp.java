/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.PointPVPInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Crossbattlepointpvp
/*     */ {
/*     */   public static PointPVPInfo get(Long key)
/*     */   {
/*  12 */     return (PointPVPInfo)_Tables_.getInstance().crossbattlepointpvp.get(key);
/*     */   }
/*     */   
/*     */   public static PointPVPInfo get(Long key, PointPVPInfo value)
/*     */   {
/*  17 */     return (PointPVPInfo)_Tables_.getInstance().crossbattlepointpvp.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, PointPVPInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().crossbattlepointpvp.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().crossbattlepointpvp.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, PointPVPInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().crossbattlepointpvp.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().crossbattlepointpvp.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, PointPVPInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().crossbattlepointpvp.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, PointPVPInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().crossbattlepointpvp;
/*     */   }
/*     */   
/*     */   public static PointPVPInfo select(Long key)
/*     */   {
/*  52 */     (PointPVPInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public PointPVPInfo get(PointPVPInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivity_cfgid(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PointPVPInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getActivity_cfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectZone(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PointPVPInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getZone());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTime_point_cfgid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PointPVPInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getTime_point_cfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStart_time(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PointPVPInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getStart_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectFights(Long key)
/*     */   {
/* 107 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(PointPVPInfo v)
/*     */       {
/* 111 */         return v.getFightsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectFinish(Long key)
/*     */   {
/* 118 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(PointPVPInfo v)
/*     */       {
/* 122 */         return Boolean.valueOf(v.getFinish());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Crossbattlepointpvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */