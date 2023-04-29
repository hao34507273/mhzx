/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FireworkInfo;
/*    */ import xbean.FireworkRecord;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Globalfirework
/*    */ {
/*    */   public static FireworkInfo get(Long key)
/*    */   {
/* 12 */     return (FireworkInfo)_Tables_.getInstance().globalfirework.get(key);
/*    */   }
/*    */   
/*    */   public static FireworkInfo get(Long key, FireworkInfo value)
/*    */   {
/* 17 */     return (FireworkInfo)_Tables_.getInstance().globalfirework.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FireworkInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().globalfirework.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().globalfirework.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FireworkInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().globalfirework.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().globalfirework.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FireworkInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().globalfirework.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FireworkInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().globalfirework;
/*    */   }
/*    */   
/*    */   public static FireworkInfo select(Long key)
/*    */   {
/* 52 */     (FireworkInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FireworkInfo get(FireworkInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FireworkRecord> selectActivityid2record(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FireworkRecord> get(FireworkInfo v)
/*    */       {
/* 67 */         return v.getActivityid2recordAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Globalfirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */