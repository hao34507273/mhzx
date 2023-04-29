/*     */ package xtable;
/*     */ 
/*     */ import xbean.Watchmoon;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2watchmoon
/*     */ {
/*     */   public static Watchmoon get(Long key)
/*     */   {
/*  12 */     return (Watchmoon)_Tables_.getInstance().role2watchmoon.get(key);
/*     */   }
/*     */   
/*     */   public static Watchmoon get(Long key, Watchmoon value)
/*     */   {
/*  17 */     return (Watchmoon)_Tables_.getInstance().role2watchmoon.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Watchmoon value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2watchmoon.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2watchmoon.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Watchmoon value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2watchmoon.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2watchmoon.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, Watchmoon> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2watchmoon.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Watchmoon> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2watchmoon;
/*     */   }
/*     */   
/*     */   public static Watchmoon select(Long key)
/*     */   {
/*  52 */     (Watchmoon)getTable().select(key, new TField()
/*     */     {
/*     */       public Watchmoon get(Watchmoon v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitetime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Watchmoon v)
/*     */       {
/*  67 */         return Long.valueOf(v.getInvitetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMapid(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Watchmoon v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getMapid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIscouple(Long key)
/*     */   {
/*  85 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Watchmoon v)
/*     */       {
/*  89 */         return Boolean.valueOf(v.getIscouple());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectPartenerroleid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Watchmoon v)
/*     */       {
/* 100 */         return Long.valueOf(v.getPartenerroleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGroupid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Watchmoon v)
/*     */       {
/* 111 */         return Long.valueOf(v.getGroupid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Watchmoon v)
/*     */       {
/* 122 */         return Long.valueOf(v.getSessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2watchmoon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */