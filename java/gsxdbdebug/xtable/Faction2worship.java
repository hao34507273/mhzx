/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import xbean.FactionWorshipInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Faction2worship
/*    */ {
/*    */   public static FactionWorshipInfo get(Long key)
/*    */   {
/* 12 */     return (FactionWorshipInfo)_Tables_.getInstance().faction2worship.get(key);
/*    */   }
/*    */   
/*    */   public static FactionWorshipInfo get(Long key, FactionWorshipInfo value)
/*    */   {
/* 17 */     return (FactionWorshipInfo)_Tables_.getInstance().faction2worship.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FactionWorshipInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().faction2worship.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().faction2worship.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FactionWorshipInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().faction2worship.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().faction2worship.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FactionWorshipInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().faction2worship.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FactionWorshipInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().faction2worship;
/*    */   }
/*    */   
/*    */   public static FactionWorshipInfo select(Long key)
/*    */   {
/* 52 */     (FactionWorshipInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FactionWorshipInfo get(FactionWorshipInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectWorshipdata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(FactionWorshipInfo v)
/*    */       {
/* 67 */         return v.getWorshipdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<xbean.SingleWorshipInfo> selectWorshiprecord(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<xbean.SingleWorshipInfo> get(FactionWorshipInfo v)
/*    */       {
/* 78 */         return v.getWorshiprecordAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Faction2worship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */