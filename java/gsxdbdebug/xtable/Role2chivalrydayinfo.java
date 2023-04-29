/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ChivalryDayInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2chivalrydayinfo
/*    */ {
/*    */   public static ChivalryDayInfo get(Long key)
/*    */   {
/* 12 */     return (ChivalryDayInfo)_Tables_.getInstance().role2chivalrydayinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ChivalryDayInfo get(Long key, ChivalryDayInfo value)
/*    */   {
/* 17 */     return (ChivalryDayInfo)_Tables_.getInstance().role2chivalrydayinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChivalryDayInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chivalrydayinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chivalrydayinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChivalryDayInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chivalrydayinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chivalrydayinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ChivalryDayInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chivalrydayinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChivalryDayInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chivalrydayinfo;
/*    */   }
/*    */   
/*    */   public static ChivalryDayInfo select(Long key)
/*    */   {
/* 52 */     (ChivalryDayInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ChivalryDayInfo get(ChivalryDayInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastflushtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ChivalryDayInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastflushtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectChivalrydaysum(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ChivalryDayInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getChivalrydaysum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectActivitydaysum(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(ChivalryDayInfo v)
/*    */       {
/* 89 */         return v.getActivitydaysumAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chivalrydayinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */