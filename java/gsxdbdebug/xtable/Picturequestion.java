/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.PictureInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Picturequestion
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().picturequestion.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().picturequestion.getAutoKey(localid);
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
/*     */   public static Long insert(PictureInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, PictureInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static PictureInfo get(Long key)
/*     */   {
/*  46 */     return (PictureInfo)_Tables_.getInstance().picturequestion.get(key);
/*     */   }
/*     */   
/*     */   public static PictureInfo get(Long key, PictureInfo value)
/*     */   {
/*  51 */     return (PictureInfo)_Tables_.getInstance().picturequestion.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, PictureInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().picturequestion.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, PictureInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().picturequestion.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().picturequestion.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, PictureInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().picturequestion.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, PictureInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().picturequestion.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().picturequestion.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, PictureInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().picturequestion.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, PictureInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().picturequestion;
/*     */   }
/*     */   
/*     */   public static Integer selectState(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PictureInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getState());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PictureInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getSessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRoleidlist(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(PictureInfo v)
/*     */       {
/* 122 */         return v.getRoleidlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectQuestionlevelcfgid(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PictureInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getQuestionlevelcfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectQuestionidx(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PictureInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getQuestionidx());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.PictureQuestionInfo> selectQuestionlist(Long key)
/*     */   {
/* 151 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.PictureQuestionInfo> get(PictureInfo v)
/*     */       {
/* 155 */         return v.getQuestionlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRightanswercount(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PictureInfo v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getRightanswercount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Picturequestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */