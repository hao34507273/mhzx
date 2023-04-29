/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.YuanBaoInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2yuanbaoinfo
/*     */ {
/*     */   public static YuanBaoInfo get(Long key)
/*     */   {
/*  12 */     return (YuanBaoInfo)_Tables_.getInstance().role2yuanbaoinfo.get(key);
/*     */   }
/*     */   
/*     */   public static YuanBaoInfo get(Long key, YuanBaoInfo value)
/*     */   {
/*  17 */     return (YuanBaoInfo)_Tables_.getInstance().role2yuanbaoinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, YuanBaoInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2yuanbaoinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2yuanbaoinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, YuanBaoInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2yuanbaoinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2yuanbaoinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, YuanBaoInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2yuanbaoinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, YuanBaoInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2yuanbaoinfo;
/*     */   }
/*     */   
/*     */   public static YuanBaoInfo select(Long key)
/*     */   {
/*  52 */     (YuanBaoInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public YuanBaoInfo get(YuanBaoInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAwardyuanbao(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(YuanBaoInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getAwardyuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBuyyuanbao(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(YuanBaoInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getBuyyuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMoney(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(YuanBaoInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getMoney());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotalbuyyuanbao(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(YuanBaoInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getTotalbuyyuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotalawardyuanbao(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(YuanBaoInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getTotalawardyuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectBuyorderid(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(YuanBaoInfo v)
/*     */       {
/* 122 */         return v.getBuyorderidAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2yuanbaoinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */