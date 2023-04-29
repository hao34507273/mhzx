/*    */ package xtable;
/*    */ 
/*    */ import xbean.LonngBoatRaceAwardRecord;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2lonngboatraceaward
/*    */ {
/*    */   public static LonngBoatRaceAwardRecord get(Long key)
/*    */   {
/* 12 */     return (LonngBoatRaceAwardRecord)_Tables_.getInstance().role2lonngboatraceaward.get(key);
/*    */   }
/*    */   
/*    */   public static LonngBoatRaceAwardRecord get(Long key, LonngBoatRaceAwardRecord value)
/*    */   {
/* 17 */     return (LonngBoatRaceAwardRecord)_Tables_.getInstance().role2lonngboatraceaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LonngBoatRaceAwardRecord value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2lonngboatraceaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2lonngboatraceaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LonngBoatRaceAwardRecord value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2lonngboatraceaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2lonngboatraceaward.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, LonngBoatRaceAwardRecord> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2lonngboatraceaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LonngBoatRaceAwardRecord> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2lonngboatraceaward;
/*    */   }
/*    */   
/*    */   public static LonngBoatRaceAwardRecord select(Long key)
/*    */   {
/* 52 */     (LonngBoatRaceAwardRecord)getTable().select(key, new TField()
/*    */     {
/*    */       public LonngBoatRaceAwardRecord get(LonngBoatRaceAwardRecord v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectAwardcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LonngBoatRaceAwardRecord v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getAwardcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LonngBoatRaceAwardRecord v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2lonngboatraceaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */