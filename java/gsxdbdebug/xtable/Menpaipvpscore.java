/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.MenpaiPVPScore;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Menpaipvpscore
/*     */ {
/*     */   public static MenpaiPVPScore get(Long key)
/*     */   {
/*  12 */     return (MenpaiPVPScore)_Tables_.getInstance().menpaipvpscore.get(key);
/*     */   }
/*     */   
/*     */   public static MenpaiPVPScore get(Long key, MenpaiPVPScore value)
/*     */   {
/*  17 */     return (MenpaiPVPScore)_Tables_.getInstance().menpaipvpscore.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MenpaiPVPScore value)
/*     */   {
/*  22 */     _Tables_.getInstance().menpaipvpscore.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().menpaipvpscore.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MenpaiPVPScore value)
/*     */   {
/*  32 */     return _Tables_.getInstance().menpaipvpscore.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().menpaipvpscore.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MenpaiPVPScore> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().menpaipvpscore.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MenpaiPVPScore> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().menpaipvpscore;
/*     */   }
/*     */   
/*     */   public static MenpaiPVPScore select(Long key)
/*     */   {
/*  52 */     (MenpaiPVPScore)getTable().select(key, new TField()
/*     */     {
/*     */       public MenpaiPVPScore get(MenpaiPVPScore v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectScore(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenpaiPVPScore v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getScore());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_times(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenpaiPVPScore v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLose_times(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenpaiPVPScore v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getLose_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectMatchroles(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(MenpaiPVPScore v)
/*     */       {
/* 100 */         return v.getMatchrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectParticipated(Long key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(MenpaiPVPScore v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getParticipated());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Menpaipvpscore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */