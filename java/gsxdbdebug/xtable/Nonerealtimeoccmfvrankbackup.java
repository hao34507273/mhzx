/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimeOccMFVRankDataBackUp;
/*    */ import xbean.NoneRealTimeOccMFVRoleRankBackUp;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimeoccmfvrankbackup
/*    */ {
/*    */   public static NoneRealTimeOccMFVRankDataBackUp get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeOccMFVRankDataBackUp)_Tables_.getInstance().nonerealtimeoccmfvrankbackup.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeOccMFVRankDataBackUp get(Long key, NoneRealTimeOccMFVRankDataBackUp value)
/*    */   {
/* 17 */     return (NoneRealTimeOccMFVRankDataBackUp)_Tables_.getInstance().nonerealtimeoccmfvrankbackup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeOccMFVRankDataBackUp value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimeoccmfvrankbackup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimeoccmfvrankbackup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeOccMFVRankDataBackUp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimeoccmfvrankbackup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimeoccmfvrankbackup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeOccMFVRankDataBackUp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimeoccmfvrankbackup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeOccMFVRankDataBackUp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimeoccmfvrankbackup;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeOccMFVRankDataBackUp select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeOccMFVRankDataBackUp)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NoneRealTimeOccMFVRankDataBackUp get(NoneRealTimeOccMFVRankDataBackUp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, NoneRealTimeOccMFVRoleRankBackUp> selectRank_datas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, NoneRealTimeOccMFVRoleRankBackUp> get(NoneRealTimeOccMFVRankDataBackUp v)
/*    */       {
/* 67 */         return v.getRank_datasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimeoccmfvrankbackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */