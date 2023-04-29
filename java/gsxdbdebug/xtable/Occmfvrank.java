/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MultiFightValueRank;
/*    */ import xbean.OccMFVRankData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Occmfvrank
/*    */ {
/*    */   public static OccMFVRankData get(Long key)
/*    */   {
/* 12 */     return (OccMFVRankData)_Tables_.getInstance().occmfvrank.get(key);
/*    */   }
/*    */   
/*    */   public static OccMFVRankData get(Long key, OccMFVRankData value)
/*    */   {
/* 17 */     return (OccMFVRankData)_Tables_.getInstance().occmfvrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OccMFVRankData value)
/*    */   {
/* 22 */     _Tables_.getInstance().occmfvrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().occmfvrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OccMFVRankData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().occmfvrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().occmfvrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, OccMFVRankData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().occmfvrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OccMFVRankData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().occmfvrank;
/*    */   }
/*    */   
/*    */   public static OccMFVRankData select(Long key)
/*    */   {
/* 52 */     (OccMFVRankData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public OccMFVRankData get(OccMFVRankData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MultiFightValueRank> selectOcc2rankdata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MultiFightValueRank> get(OccMFVRankData v)
/*    */       {
/* 67 */         return v.getOcc2rankdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Occmfvrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */