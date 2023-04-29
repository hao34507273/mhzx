/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossbattlePoint;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Crossbattlepoint
/*    */ {
/*    */   public static CrossbattlePoint get(Long key)
/*    */   {
/* 12 */     return (CrossbattlePoint)_Tables_.getInstance().crossbattlepoint.get(key);
/*    */   }
/*    */   
/*    */   public static CrossbattlePoint get(Long key, CrossbattlePoint value)
/*    */   {
/* 17 */     return (CrossbattlePoint)_Tables_.getInstance().crossbattlepoint.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossbattlePoint value)
/*    */   {
/* 22 */     _Tables_.getInstance().crossbattlepoint.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().crossbattlepoint.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossbattlePoint value)
/*    */   {
/* 32 */     return _Tables_.getInstance().crossbattlepoint.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().crossbattlepoint.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossbattlePoint> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().crossbattlepoint.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossbattlePoint> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().crossbattlepoint;
/*    */   }
/*    */   
/*    */   public static CrossbattlePoint select(Long key)
/*    */   {
/* 52 */     (CrossbattlePoint)getTable().select(key, new TField()
/*    */     {
/*    */       public CrossbattlePoint get(CrossbattlePoint v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.CrossbattlePointRaceInfo> selectPoint_races(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.CrossbattlePointRaceInfo> get(CrossbattlePoint v)
/*    */       {
/* 67 */         return v.getPoint_racesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTime_point_cfgid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(CrossbattlePoint v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getTime_point_cfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectCorps_result(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(CrossbattlePoint v)
/*    */       {
/* 89 */         return v.getCorps_resultAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Crossbattlepoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */