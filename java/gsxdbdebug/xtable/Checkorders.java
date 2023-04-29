/*     */ package xtable;
/*     */ 
/*     */ import xbean.CheckOrderInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Checkorders
/*     */ {
/*     */   public static CheckOrderInfo get(String key)
/*     */   {
/*  12 */     return (CheckOrderInfo)_Tables_.getInstance().checkorders.get(key);
/*     */   }
/*     */   
/*     */   public static CheckOrderInfo get(String key, CheckOrderInfo value)
/*     */   {
/*  17 */     return (CheckOrderInfo)_Tables_.getInstance().checkorders.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, CheckOrderInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().checkorders.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().checkorders.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, CheckOrderInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().checkorders.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().checkorders.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<String, CheckOrderInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().checkorders.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, CheckOrderInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().checkorders;
/*     */   }
/*     */   
/*     */   public static CheckOrderInfo select(String key)
/*     */   {
/*  52 */     (CheckOrderInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public CheckOrderInfo get(CheckOrderInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStatus(String key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getStatus());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFlags(String key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getFlags());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectUserid(String key)
/*     */   {
/*  85 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(CheckOrderInfo v)
/*     */       {
/*  89 */         return v.getUserid();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCost(String key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getCost());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCost_bind(String key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCost_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPresent(String key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getPresent());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPresent_bind(String key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CheckOrderInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getPresent_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreate_time(String key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CheckOrderInfo v)
/*     */       {
/* 144 */         return Long.valueOf(v.getCreate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectConfirm_success_time(String key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CheckOrderInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getConfirm_success_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Checkorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */