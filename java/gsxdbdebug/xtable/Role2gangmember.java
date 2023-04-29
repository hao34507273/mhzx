/*     */ package xtable;
/*     */ 
/*     */ import xbean.GangMember;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2gangmember
/*     */ {
/*     */   public static GangMember get(Long key)
/*     */   {
/*  12 */     return (GangMember)_Tables_.getInstance().role2gangmember.get(key);
/*     */   }
/*     */   
/*     */   public static GangMember get(Long key, GangMember value)
/*     */   {
/*  17 */     return (GangMember)_Tables_.getInstance().role2gangmember.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, GangMember value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2gangmember.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2gangmember.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, GangMember value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2gangmember.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2gangmember.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, GangMember> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2gangmember.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, GangMember> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2gangmember;
/*     */   }
/*     */   
/*     */   public static GangMember select(Long key)
/*     */   {
/*  52 */     (GangMember)getTable().select(key, new TField()
/*     */     {
/*     */       public GangMember get(GangMember v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDuty(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getDuty());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBanggong(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/*  78 */         return Long.valueOf(v.getBanggong());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectHistorybanggong(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/*  89 */         return Long.valueOf(v.getHistorybanggong());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGangid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 100 */         return Long.valueOf(v.getGangid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectJointime(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 111 */         return Long.valueOf(v.getJointime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectForbiddentalkend(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 122 */         return Long.valueOf(v.getForbiddentalkend());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastreadannouncementtimestamp(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 133 */         return Long.valueOf(v.getLastreadannouncementtimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRedeembanggong(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 144 */         return Long.valueOf(v.getRedeembanggong());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNextupdateredeemtimestamp(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 155 */         return Long.valueOf(v.getNextupdateredeemtimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMakemifangcount(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getMakemifangcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotalmakemifangcount(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getTotalmakemifangcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLasthavemifangtime(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 188 */         return Long.valueOf(v.getLasthavemifangtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastgetfulitime(Long key)
/*     */   {
/* 195 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 199 */         return Long.valueOf(v.getLastgetfulitime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastgetlihetime(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 210 */         return Long.valueOf(v.getLastgetlihetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGongxun(Long key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getGongxun());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGongxun_timestamp(Long key)
/*     */   {
/* 228 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 232 */         return Long.valueOf(v.getGongxun_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectIssign(Long key)
/*     */   {
/* 239 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 243 */         return Integer.valueOf(v.getIssign());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSigntime(Long key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 254 */         return Long.valueOf(v.getSigntime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectSignstr(Long key)
/*     */   {
/* 261 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(GangMember v)
/*     */       {
/* 265 */         return v.getSignstr();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIspassiveleaved(Long key)
/*     */   {
/* 272 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(GangMember v)
/*     */       {
/* 276 */         return Boolean.valueOf(v.getIspassiveleaved());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWeekbanggong(Long key)
/*     */   {
/* 283 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 287 */         return Integer.valueOf(v.getWeekbanggong());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAddbanggong_time(Long key)
/*     */   {
/* 294 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 298 */         return Long.valueOf(v.getAddbanggong_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWeekitem_banggong_count(Long key)
/*     */   {
/* 305 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 309 */         return Integer.valueOf(v.getWeekitem_banggong_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectItem_banggong_time(Long key)
/*     */   {
/* 316 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 320 */         return Long.valueOf(v.getItem_banggong_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectYuanbao_redeem_bang_gong(Long key)
/*     */   {
/* 327 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GangMember v)
/*     */       {
/* 331 */         return Integer.valueOf(v.getYuanbao_redeem_bang_gong());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreate_gang_team_time(Long key)
/*     */   {
/* 338 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GangMember v)
/*     */       {
/* 342 */         return Long.valueOf(v.getCreate_gang_team_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIs_in_gang(Long key)
/*     */   {
/* 349 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(GangMember v)
/*     */       {
/* 353 */         return Boolean.valueOf(v.getIs_in_gang());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2gangmember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */