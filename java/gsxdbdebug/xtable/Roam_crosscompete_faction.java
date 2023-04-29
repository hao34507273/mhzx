/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Roam_crosscompete_faction
/*     */ {
/*     */   public static RoamCrossCompeteFaction get(Long key)
/*     */   {
/*  12 */     return (RoamCrossCompeteFaction)_Tables_.getInstance().roam_crosscompete_faction.get(key);
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteFaction get(Long key, RoamCrossCompeteFaction value)
/*     */   {
/*  17 */     return (RoamCrossCompeteFaction)_Tables_.getInstance().roam_crosscompete_faction.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoamCrossCompeteFaction value)
/*     */   {
/*  22 */     _Tables_.getInstance().roam_crosscompete_faction.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().roam_crosscompete_faction.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoamCrossCompeteFaction value)
/*     */   {
/*  32 */     return _Tables_.getInstance().roam_crosscompete_faction.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().roam_crosscompete_faction.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoamCrossCompeteFaction> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().roam_crosscompete_faction.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoamCrossCompeteFaction> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().roam_crosscompete_faction;
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteFaction select(Long key)
/*     */   {
/*  52 */     (RoamCrossCompeteFaction)getTable().select(key, new TField()
/*     */     {
/*     */       public RoamCrossCompeteFaction get(RoamCrossCompeteFaction v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName(Long key)
/*     */   {
/*  63 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(RoamCrossCompeteFaction v)
/*     */       {
/*  67 */         return v.getName();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.GangDutyMembers> selectDuty2members(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.GangDutyMembers> get(RoamCrossCompeteFaction v)
/*     */       {
/*  78 */         return v.getDuty2membersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDesigned_titleid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteFaction v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getDesigned_titleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOpponent(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoamCrossCompeteFaction v)
/*     */       {
/* 100 */         return Long.valueOf(v.getOpponent());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPk_score(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteFaction v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getPk_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPlayer_score(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteFaction v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getPlayer_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_times(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteFaction v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMax_member_count(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteFaction v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getMax_member_count());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roam_crosscompete_faction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */