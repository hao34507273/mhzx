/*     */ package xtable;
/*     */ 
/*     */ import xbean.UuidInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Uuid
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().uuid.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().uuid.getAutoKey(localid);
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
/*     */   public static Long insert(UuidInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, UuidInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static UuidInfo get(Long key)
/*     */   {
/*  46 */     return (UuidInfo)_Tables_.getInstance().uuid.get(key);
/*     */   }
/*     */   
/*     */   public static UuidInfo get(Long key, UuidInfo value)
/*     */   {
/*  51 */     return (UuidInfo)_Tables_.getInstance().uuid.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, UuidInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().uuid.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, UuidInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().uuid.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().uuid.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, UuidInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().uuid.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, UuidInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().uuid.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().uuid.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, UuidInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().uuid.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, UuidInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().uuid;
/*     */   }
/*     */   
/*     */   public static UuidInfo select(Long key)
/*     */   {
/*  96 */     (UuidInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public UuidInfo get(UuidInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectId_type(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(UuidInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getId_type());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTimestamp(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(UuidInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getTimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Uuid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */