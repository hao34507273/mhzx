/*     */ package xtable;
/*     */ 
/*     */ import xbean.IdipMarqueeInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Idipmarquee
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().idipmarquee.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().idipmarquee.getAutoKey(localid);
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
/*     */   public static Long insert(IdipMarqueeInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, IdipMarqueeInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static IdipMarqueeInfo get(Long key)
/*     */   {
/*  46 */     return (IdipMarqueeInfo)_Tables_.getInstance().idipmarquee.get(key);
/*     */   }
/*     */   
/*     */   public static IdipMarqueeInfo get(Long key, IdipMarqueeInfo value)
/*     */   {
/*  51 */     return (IdipMarqueeInfo)_Tables_.getInstance().idipmarquee.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, IdipMarqueeInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().idipmarquee.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, IdipMarqueeInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().idipmarquee.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().idipmarquee.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, IdipMarqueeInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().idipmarquee.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, IdipMarqueeInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().idipmarquee.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().idipmarquee.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, IdipMarqueeInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().idipmarquee.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, IdipMarqueeInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().idipmarquee;
/*     */   }
/*     */   
/*     */   public static IdipMarqueeInfo select(Long key)
/*     */   {
/*  96 */     (IdipMarqueeInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public IdipMarqueeInfo get(IdipMarqueeInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBegin_time(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipMarqueeInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getBegin_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectEnd_time(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipMarqueeInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getEnd_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectMail_title(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipMarqueeInfo v)
/*     */       {
/* 133 */         return v.getMail_title();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectMail_content(Long key)
/*     */   {
/* 140 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipMarqueeInfo v)
/*     */       {
/* 144 */         return v.getMail_content();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRollfre(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipMarqueeInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getRollfre());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRollnum(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipMarqueeInfo v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getRollnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReal_num(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipMarqueeInfo v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getReal_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVersion(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipMarqueeInfo v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getVersion());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectIndexid(Long key)
/*     */   {
/* 195 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipMarqueeInfo v)
/*     */       {
/* 199 */         return Long.valueOf(v.getIndexid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipmarquee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */