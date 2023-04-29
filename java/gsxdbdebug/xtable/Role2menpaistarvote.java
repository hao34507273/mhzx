/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.MenPaiStarVoteInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2menpaistarvote
/*     */ {
/*     */   public static MenPaiStarVoteInfo get(Long key)
/*     */   {
/*  12 */     return (MenPaiStarVoteInfo)_Tables_.getInstance().role2menpaistarvote.get(key);
/*     */   }
/*     */   
/*     */   public static MenPaiStarVoteInfo get(Long key, MenPaiStarVoteInfo value)
/*     */   {
/*  17 */     return (MenPaiStarVoteInfo)_Tables_.getInstance().role2menpaistarvote.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MenPaiStarVoteInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2menpaistarvote.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2menpaistarvote.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MenPaiStarVoteInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2menpaistarvote.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2menpaistarvote.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MenPaiStarVoteInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2menpaistarvote.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MenPaiStarVoteInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2menpaistarvote;
/*     */   }
/*     */   
/*     */   public static MenPaiStarVoteInfo select(Long key)
/*     */   {
/*  52 */     (MenPaiStarVoteInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public MenPaiStarVoteInfo get(MenPaiStarVoteInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVote(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenPaiStarVoteInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getVote());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_vote_num(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenPaiStarVoteInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getToday_vote_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_vote_time(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MenPaiStarVoteInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getLast_vote_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVote_num(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(MenPaiStarVoteInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getVote_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Long> selectWorld_canvass(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Long> get(MenPaiStarVoteInfo v)
/*     */       {
/* 111 */         return v.getWorld_canvassAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Long> selectGang_canvass(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Long> get(MenPaiStarVoteInfo v)
/*     */       {
/* 122 */         return v.getGang_canvassAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2menpaistarvote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */