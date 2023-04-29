/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FactionCakeData;
/*    */ import xbean.FactionCakeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Factioncake
/*    */ {
/*    */   public static FactionCakeInfo get(Long key)
/*    */   {
/* 12 */     return (FactionCakeInfo)_Tables_.getInstance().factioncake.get(key);
/*    */   }
/*    */   
/*    */   public static FactionCakeInfo get(Long key, FactionCakeInfo value)
/*    */   {
/* 17 */     return (FactionCakeInfo)_Tables_.getInstance().factioncake.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FactionCakeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().factioncake.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().factioncake.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FactionCakeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().factioncake.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().factioncake.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FactionCakeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().factioncake.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FactionCakeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().factioncake;
/*    */   }
/*    */   
/*    */   public static FactionCakeInfo select(Long key)
/*    */   {
/* 52 */     (FactionCakeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FactionCakeInfo get(FactionCakeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FactionCakeData> selectFactioncakedatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FactionCakeData> get(FactionCakeInfo v)
/*    */       {
/* 67 */         return v.getFactioncakedatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Factioncake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */