/*     */ package xtable;
/*     */ 
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornNewName;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Sworn
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().sworn.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().sworn.getAutoKey(localid);
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
/*     */   public static Long insert(xbean.Sworn value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Sworn value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Sworn get(Long key)
/*     */   {
/*  46 */     return (xbean.Sworn)_Tables_.getInstance().sworn.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Sworn get(Long key, xbean.Sworn value)
/*     */   {
/*  51 */     return (xbean.Sworn)_Tables_.getInstance().sworn.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Sworn value)
/*     */   {
/*  56 */     _Tables_.getInstance().sworn.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Sworn value)
/*     */   {
/*  61 */     _Tables_.getInstance().sworn.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().sworn.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Sworn value)
/*     */   {
/*  71 */     return _Tables_.getInstance().sworn.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Sworn value)
/*     */   {
/*  76 */     return _Tables_.getInstance().sworn.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().sworn.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Sworn> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().sworn.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Sworn> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().sworn;
/*     */   }
/*     */   
/*     */   public static xbean.Sworn select(Long key)
/*     */   {
/*  96 */     (xbean.Sworn)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Sworn get(xbean.Sworn v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName1(Long key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Sworn v)
/*     */       {
/* 111 */         return v.getName1();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName2(Long key)
/*     */   {
/* 118 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Sworn v)
/*     */       {
/* 122 */         return v.getName2();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreaterid(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Sworn v)
/*     */       {
/* 133 */         return Long.valueOf(v.getCreaterid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectMembers(Long key)
/*     */   {
/* 140 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(xbean.Sworn v)
/*     */       {
/* 144 */         return v.getMembersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, xbean.SwornNewMember> selectNewmember(Long key)
/*     */   {
/* 151 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, xbean.SwornNewMember> get(xbean.Sworn v)
/*     */       {
/* 155 */         return v.getNewmemberAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static SwornNewName selectNewname(Long key)
/*     */   {
/* 162 */     (SwornNewName)getTable().select(key, new TField()
/*     */     {
/*     */       public SwornNewName get(xbean.Sworn v)
/*     */       {
/* 166 */         return v.getNewname().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static SwornKickOut selectKickoutmember(Long key)
/*     */   {
/* 173 */     (SwornKickOut)getTable().select(key, new TField()
/*     */     {
/*     */       public SwornKickOut get(xbean.Sworn v)
/*     */       {
/* 177 */         return v.getKickoutmember().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Sworn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */