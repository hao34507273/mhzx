/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossbattleDrawLots;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Crossbattledrawlots
/*    */ {
/*    */   public static CrossbattleDrawLots get(Long key)
/*    */   {
/* 12 */     return (CrossbattleDrawLots)_Tables_.getInstance().crossbattledrawlots.get(key);
/*    */   }
/*    */   
/*    */   public static CrossbattleDrawLots get(Long key, CrossbattleDrawLots value)
/*    */   {
/* 17 */     return (CrossbattleDrawLots)_Tables_.getInstance().crossbattledrawlots.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossbattleDrawLots value)
/*    */   {
/* 22 */     _Tables_.getInstance().crossbattledrawlots.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().crossbattledrawlots.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossbattleDrawLots value)
/*    */   {
/* 32 */     return _Tables_.getInstance().crossbattledrawlots.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().crossbattledrawlots.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossbattleDrawLots> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().crossbattledrawlots.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossbattleDrawLots> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().crossbattledrawlots;
/*    */   }
/*    */   
/*    */   public static CrossbattleDrawLots select(Long key)
/*    */   {
/* 52 */     (CrossbattleDrawLots)getTable().select(key, new TField()
/*    */     {
/*    */       public CrossbattleDrawLots get(CrossbattleDrawLots v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectReported(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(CrossbattleDrawLots v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getReported());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.DrawLotsZoneInfo> selectCorps(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.DrawLotsZoneInfo> get(CrossbattleDrawLots v)
/*    */       {
/* 78 */         return v.getCorpsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Crossbattledrawlots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */