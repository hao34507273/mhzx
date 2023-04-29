/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.GlobalSurpriseScheduleInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Globalsurpriseschedule
/*    */ {
/*    */   public static GlobalSurpriseScheduleInfo get(Long key)
/*    */   {
/* 12 */     return (GlobalSurpriseScheduleInfo)_Tables_.getInstance().globalsurpriseschedule.get(key);
/*    */   }
/*    */   
/*    */   public static GlobalSurpriseScheduleInfo get(Long key, GlobalSurpriseScheduleInfo value)
/*    */   {
/* 17 */     return (GlobalSurpriseScheduleInfo)_Tables_.getInstance().globalsurpriseschedule.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobalSurpriseScheduleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().globalsurpriseschedule.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().globalsurpriseschedule.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobalSurpriseScheduleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().globalsurpriseschedule.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().globalsurpriseschedule.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GlobalSurpriseScheduleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().globalsurpriseschedule.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobalSurpriseScheduleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().globalsurpriseschedule;
/*    */   }
/*    */   
/*    */   public static GlobalSurpriseScheduleInfo select(Long key)
/*    */   {
/* 52 */     (GlobalSurpriseScheduleInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GlobalSurpriseScheduleInfo get(GlobalSurpriseScheduleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.DaySessionInfo> selectSessioninfos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.DaySessionInfo> get(GlobalSurpriseScheduleInfo v)
/*    */       {
/* 67 */         return v.getSessioninfosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectOpenedgraphids(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Integer> get(GlobalSurpriseScheduleInfo v)
/*    */       {
/* 78 */         return v.getOpenedgraphidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectEffectserverlevel(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(GlobalSurpriseScheduleInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getEffectserverlevel());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Globalsurpriseschedule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */