/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FactionMakeUpInfo;
/*    */ import xbean.FactionMakeUpRecord;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangmakeup
/*    */ {
/*    */   public static FactionMakeUpInfo get(Long key)
/*    */   {
/* 12 */     return (FactionMakeUpInfo)_Tables_.getInstance().gangmakeup.get(key);
/*    */   }
/*    */   
/*    */   public static FactionMakeUpInfo get(Long key, FactionMakeUpInfo value)
/*    */   {
/* 17 */     return (FactionMakeUpInfo)_Tables_.getInstance().gangmakeup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FactionMakeUpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangmakeup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangmakeup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FactionMakeUpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangmakeup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangmakeup.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FactionMakeUpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangmakeup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FactionMakeUpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangmakeup;
/*    */   }
/*    */   
/*    */   public static FactionMakeUpInfo select(Long key)
/*    */   {
/* 52 */     (FactionMakeUpInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FactionMakeUpInfo get(FactionMakeUpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FactionMakeUpRecord> selectActivityid2record(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FactionMakeUpRecord> get(FactionMakeUpInfo v)
/*    */       {
/* 67 */         return v.getActivityid2recordAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangmakeup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */