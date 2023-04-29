/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.LadderRankBackUp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Ladderrankbackup
/*    */ {
/*    */   public static LadderRankBackUp get(Long key)
/*    */   {
/* 12 */     return (LadderRankBackUp)_Tables_.getInstance().ladderrankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static LadderRankBackUp get(Long key, LadderRankBackUp value)
/*    */   {
/* 17 */     return (LadderRankBackUp)_Tables_.getInstance().ladderrankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LadderRankBackUp value)
/*    */   {
/* 22 */     _Tables_.getInstance().ladderrankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().ladderrankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LadderRankBackUp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().ladderrankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().ladderrankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LadderRankBackUp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().ladderrankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LadderRankBackUp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().ladderrankbackup;
/*    */   }
/*    */   
/*    */   public static LadderRankBackUp select(Long key)
/*    */   {
/* 52 */     (LadderRankBackUp)getTable().select(key, new TField()
/*    */     {
/*    */       public LadderRankBackUp get(LadderRankBackUp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.LadderRankRole> selectRanklist(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.LadderRankRole> get(LadderRankBackUp v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectBackuptime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LadderRankBackUp v)
/*    */       {
/* 78 */         return Long.valueOf(v.getBackuptime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRemoteawardroles(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(LadderRankBackUp v)
/*    */       {
/* 89 */         return v.getRemoteawardrolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Ladderrankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */