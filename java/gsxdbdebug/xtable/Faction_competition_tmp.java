/*    */ package xtable;
/*    */ 
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Faction_competition_tmp
/*    */ {
/*    */   public static FactionCompetitionTmp get(Long key)
/*    */   {
/* 12 */     return (FactionCompetitionTmp)_Tables_.getInstance().faction_competition_tmp.get(key);
/*    */   }
/*    */   
/*    */   public static FactionCompetitionTmp get(Long key, FactionCompetitionTmp value)
/*    */   {
/* 17 */     return (FactionCompetitionTmp)_Tables_.getInstance().faction_competition_tmp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FactionCompetitionTmp value)
/*    */   {
/* 22 */     _Tables_.getInstance().faction_competition_tmp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().faction_competition_tmp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FactionCompetitionTmp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().faction_competition_tmp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().faction_competition_tmp.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FactionCompetitionTmp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().faction_competition_tmp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FactionCompetitionTmp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().faction_competition_tmp;
/*    */   }
/*    */   
/*    */   public static FactionCompetitionTmp select(Long key)
/*    */   {
/* 52 */     (FactionCompetitionTmp)getTable().select(key, new TField()
/*    */     {
/*    */       public FactionCompetitionTmp get(FactionCompetitionTmp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectWorld(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FactionCompetitionTmp v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorld());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPlayer_num(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FactionCompetitionTmp v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getPlayer_num());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Faction_competition_tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */