/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GlobalCakeData;
/*    */ import xbean.GlobalCakeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Globalcake
/*    */ {
/*    */   public static GlobalCakeInfo get(Long key)
/*    */   {
/* 12 */     return (GlobalCakeInfo)_Tables_.getInstance().globalcake.get(key);
/*    */   }
/*    */   
/*    */   public static GlobalCakeInfo get(Long key, GlobalCakeInfo value)
/*    */   {
/* 17 */     return (GlobalCakeInfo)_Tables_.getInstance().globalcake.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobalCakeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().globalcake.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().globalcake.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobalCakeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().globalcake.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().globalcake.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GlobalCakeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().globalcake.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobalCakeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().globalcake;
/*    */   }
/*    */   
/*    */   public static GlobalCakeInfo select(Long key)
/*    */   {
/* 52 */     (GlobalCakeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GlobalCakeInfo get(GlobalCakeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, GlobalCakeData> selectFactioncakedatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, GlobalCakeData> get(GlobalCakeInfo v)
/*    */       {
/* 67 */         return v.getFactioncakedatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Globalcake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */