/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ReportedInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2reported
/*    */ {
/*    */   public static ReportedInfo get(Long key)
/*    */   {
/* 12 */     return (ReportedInfo)_Tables_.getInstance().role2reported.get(key);
/*    */   }
/*    */   
/*    */   public static ReportedInfo get(Long key, ReportedInfo value)
/*    */   {
/* 17 */     return (ReportedInfo)_Tables_.getInstance().role2reported.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ReportedInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2reported.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2reported.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ReportedInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2reported.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2reported.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ReportedInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2reported.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ReportedInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2reported;
/*    */   }
/*    */   
/*    */   public static ReportedInfo select(Long key)
/*    */   {
/* 52 */     (ReportedInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ReportedInfo get(ReportedInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectReport_time_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(ReportedInfo v)
/*    */       {
/* 67 */         return v.getReport_time_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2reported.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */