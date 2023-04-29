/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.PetArenaInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2petarenainfo
/*     */ {
/*     */   public static PetArenaInfo get(Long key)
/*     */   {
/*  12 */     return (PetArenaInfo)_Tables_.getInstance().role2petarenainfo.get(key);
/*     */   }
/*     */   
/*     */   public static PetArenaInfo get(Long key, PetArenaInfo value)
/*     */   {
/*  17 */     return (PetArenaInfo)_Tables_.getInstance().role2petarenainfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, PetArenaInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2petarenainfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2petarenainfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, PetArenaInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2petarenainfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2petarenainfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, PetArenaInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2petarenainfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, PetArenaInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2petarenainfo;
/*     */   }
/*     */   
/*     */   public static PetArenaInfo select(Long key)
/*     */   {
/*  52 */     (PetArenaInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public PetArenaInfo get(PetArenaInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_point(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getToday_point());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChallenge_count(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getChallenge_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBuy_count(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getBuy_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRefresh_time(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PetArenaInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getRefresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.PetArenaRankInfo> selectOpponent_ranks(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.PetArenaRankInfo> get(PetArenaInfo v)
/*     */       {
/* 111 */         return v.getOpponent_ranksAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMax_rank(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getMax_rank());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_num(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getWin_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLose_num(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getLose_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDefend_win_num(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getDefend_win_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDefend_lose_num(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getDefend_lose_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.PetArenaFightRecordInfo> selectRecords(Long key)
/*     */   {
/* 173 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.PetArenaFightRecordInfo> get(PetArenaInfo v)
/*     */       {
/* 177 */         return v.getRecordsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInit_time(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PetArenaInfo v)
/*     */       {
/* 188 */         return Long.valueOf(v.getInit_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.PetArenaFightAward selectAward(Long key)
/*     */   {
/* 195 */     (xbean.PetArenaFightAward)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.PetArenaFightAward get(PetArenaInfo v)
/*     */       {
/* 199 */         return v.getAward().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOpponent_serial(Long key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PetArenaInfo v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getOpponent_serial());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petarenainfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */