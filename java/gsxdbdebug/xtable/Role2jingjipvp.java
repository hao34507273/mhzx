/*     */ package xtable;
/*     */ 
/*     */ import xbean.JingjiPvp;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2jingjipvp
/*     */ {
/*     */   public static JingjiPvp get(Long key)
/*     */   {
/*  12 */     return (JingjiPvp)_Tables_.getInstance().role2jingjipvp.get(key);
/*     */   }
/*     */   
/*     */   public static JingjiPvp get(Long key, JingjiPvp value)
/*     */   {
/*  17 */     return (JingjiPvp)_Tables_.getInstance().role2jingjipvp.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, JingjiPvp value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2jingjipvp.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2jingjipvp.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, JingjiPvp value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2jingjipvp.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2jingjipvp.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, JingjiPvp> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2jingjipvp.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, JingjiPvp> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2jingjipvp;
/*     */   }
/*     */   
/*     */   public static JingjiPvp select(Long key)
/*     */   {
/*  52 */     (JingjiPvp)getTable().select(key, new TField()
/*     */     {
/*     */       public JingjiPvp get(JingjiPvp v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectJifen(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getJifen());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBuycount(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getBuycount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBuychallengecount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getBuychallengecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChallengecount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getChallengecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWinpoint(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getWinpoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFirstvictoryrewardid(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getFirstvictoryrewardid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFivefightrewardid(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getFivefightrewardid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFightcount(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getFightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVictorycount(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getVictorycount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIssendbulletin(Long key)
/*     */   {
/* 162 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(JingjiPvp v)
/*     */       {
/* 166 */         return Boolean.valueOf(v.getIssendbulletin());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLastseasonphase(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getLastseasonphase());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLastseasonrank(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getLastseasonrank());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastseasonendtime(Long key)
/*     */   {
/* 195 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(JingjiPvp v)
/*     */       {
/* 199 */         return Long.valueOf(v.getLastseasonendtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReservedexp(Long key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getReservedexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInittime(Long key)
/*     */   {
/* 217 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(JingjiPvp v)
/*     */       {
/* 221 */         return Long.valueOf(v.getInittime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMerge_cleared(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JingjiPvp v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getMerge_cleared());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jingjipvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */