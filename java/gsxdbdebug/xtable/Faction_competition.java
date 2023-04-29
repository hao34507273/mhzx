/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.FactionCompetition;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Faction_competition
/*     */ {
/*     */   public static FactionCompetition get(Long key)
/*     */   {
/*  12 */     return (FactionCompetition)_Tables_.getInstance().faction_competition.get(key);
/*     */   }
/*     */   
/*     */   public static FactionCompetition get(Long key, FactionCompetition value)
/*     */   {
/*  17 */     return (FactionCompetition)_Tables_.getInstance().faction_competition.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FactionCompetition value)
/*     */   {
/*  22 */     _Tables_.getInstance().faction_competition.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().faction_competition.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FactionCompetition value)
/*     */   {
/*  32 */     return _Tables_.getInstance().faction_competition.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().faction_competition.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, FactionCompetition> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().faction_competition.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FactionCompetition> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().faction_competition;
/*     */   }
/*     */   
/*     */   public static FactionCompetition select(Long key)
/*     */   {
/*  52 */     (FactionCompetition)getTable().select(key, new TField()
/*     */     {
/*     */       public FactionCompetition get(FactionCompetition v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectElo_rank(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getElo_rank());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPk_score(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getPk_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPlayer_score(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getPlayer_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectParticipated(Long key)
/*     */   {
/*  96 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(FactionCompetition v)
/*     */       {
/* 100 */         return Boolean.valueOf(v.getParticipated());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOpponent(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionCompetition v)
/*     */       {
/* 111 */         return Long.valueOf(v.getOpponent());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_times(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLose_times(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getLose_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActive_number(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getActive_number());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLast_active_number(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getLast_active_number());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectActive_timestamp(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionCompetition v)
/*     */       {
/* 166 */         return Long.valueOf(v.getActive_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMercenary_score(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getMercenary_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPaticipate_count(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getPaticipate_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLast_partcipate_count(Long key)
/*     */   {
/* 195 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCompetition v)
/*     */       {
/* 199 */         return Integer.valueOf(v.getLast_partcipate_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectParticipate_roles(Long key)
/*     */   {
/* 206 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(FactionCompetition v)
/*     */       {
/* 210 */         return v.getParticipate_rolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Faction_competition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */