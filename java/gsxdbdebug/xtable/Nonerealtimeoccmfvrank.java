/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimeMultiFightValueRank;
/*    */ import xbean.NoneRealTimeOccMFVRankData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimeoccmfvrank
/*    */ {
/*    */   public static NoneRealTimeOccMFVRankData get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeOccMFVRankData)_Tables_.getInstance().nonerealtimeoccmfvrank.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeOccMFVRankData get(Long key, NoneRealTimeOccMFVRankData value)
/*    */   {
/* 17 */     return (NoneRealTimeOccMFVRankData)_Tables_.getInstance().nonerealtimeoccmfvrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeOccMFVRankData value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimeoccmfvrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimeoccmfvrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeOccMFVRankData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimeoccmfvrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimeoccmfvrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeOccMFVRankData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimeoccmfvrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeOccMFVRankData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimeoccmfvrank;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeOccMFVRankData select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeOccMFVRankData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NoneRealTimeOccMFVRankData get(NoneRealTimeOccMFVRankData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, NoneRealTimeMultiFightValueRank> selectOcc2rankdata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, NoneRealTimeMultiFightValueRank> get(NoneRealTimeOccMFVRankData v)
/*    */       {
/* 67 */         return v.getOcc2rankdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimeoccmfvrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */