/*     */ package xtable;
/*     */ 
/*     */ import xbean.IdipNoticeInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Idipnotice
/*     */ {
/*     */   public static IdipNoticeInfo get(Long key)
/*     */   {
/*  12 */     return (IdipNoticeInfo)_Tables_.getInstance().idipnotice.get(key);
/*     */   }
/*     */   
/*     */   public static IdipNoticeInfo get(Long key, IdipNoticeInfo value)
/*     */   {
/*  17 */     return (IdipNoticeInfo)_Tables_.getInstance().idipnotice.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, IdipNoticeInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().idipnotice.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().idipnotice.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, IdipNoticeInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().idipnotice.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().idipnotice.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, IdipNoticeInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().idipnotice.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, IdipNoticeInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().idipnotice;
/*     */   }
/*     */   
/*     */   public static IdipNoticeInfo select(Long key)
/*     */   {
/*  52 */     (IdipNoticeInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public IdipNoticeInfo get(IdipNoticeInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNoticetype(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getNoticetype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDisplaytype(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getDisplaytype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHreftype(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getHreftype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectHreftext(Long key)
/*     */   {
/*  96 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipNoticeInfo v)
/*     */       {
/* 100 */         return v.getHreftext();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectHrefurl(Long key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipNoticeInfo v)
/*     */       {
/* 111 */         return v.getHrefurl();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSendtype(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getSendtype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectNoticetitle(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipNoticeInfo v)
/*     */       {
/* 133 */         return v.getNoticetitle();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectNoticecontent(Long key)
/*     */   {
/* 140 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipNoticeInfo v)
/*     */       {
/* 144 */         return v.getNoticecontent();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectPictureurl(Long key)
/*     */   {
/* 151 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(IdipNoticeInfo v)
/*     */       {
/* 155 */         return v.getPictureurl();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipNoticeInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectEndtime(Long key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipNoticeInfo v)
/*     */       {
/* 177 */         return Long.valueOf(v.getEndtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMinopenserverdays(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getMinopenserverdays());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMaxopenserverdays(Long key)
/*     */   {
/* 195 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 199 */         return Integer.valueOf(v.getMaxopenserverdays());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMincreatroledays(Long key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getMincreatroledays());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMaxcreatroledays(Long key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getMaxcreatroledays());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMinrolelevel(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getMinrolelevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMaxrolelevel(Long key)
/*     */   {
/* 239 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 243 */         return Integer.valueOf(v.getMaxrolelevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMinsaveamt(Long key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipNoticeInfo v)
/*     */       {
/* 254 */         return Long.valueOf(v.getMinsaveamt());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMaxsaveamt(Long key)
/*     */   {
/* 261 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(IdipNoticeInfo v)
/*     */       {
/* 265 */         return Long.valueOf(v.getMaxsaveamt());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNoticetag(Long key)
/*     */   {
/* 272 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 276 */         return Integer.valueOf(v.getNoticetag());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectBadge(Long key)
/*     */   {
/* 283 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(IdipNoticeInfo v)
/*     */       {
/* 287 */         return Boolean.valueOf(v.getBadge());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNoticesortid(Long key)
/*     */   {
/* 294 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(IdipNoticeInfo v)
/*     */       {
/* 298 */         return Integer.valueOf(v.getNoticesortid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipnotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */