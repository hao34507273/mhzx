/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BandstandInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2bandstandinfo
/*    */ {
/*    */   public static BandstandInfo get(Long key)
/*    */   {
/* 12 */     return (BandstandInfo)_Tables_.getInstance().role2bandstandinfo.get(key);
/*    */   }
/*    */   
/*    */   public static BandstandInfo get(Long key, BandstandInfo value)
/*    */   {
/* 17 */     return (BandstandInfo)_Tables_.getInstance().role2bandstandinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BandstandInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2bandstandinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2bandstandinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BandstandInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2bandstandinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2bandstandinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BandstandInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2bandstandinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BandstandInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2bandstandinfo;
/*    */   }
/*    */   
/*    */   public static BandstandInfo select(Long key)
/*    */   {
/* 52 */     (BandstandInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public BandstandInfo get(BandstandInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectActivityid2todayawardcount(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(BandstandInfo v)
/*    */       {
/* 67 */         return v.getActivityid2todayawardcountAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2bandstandinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */