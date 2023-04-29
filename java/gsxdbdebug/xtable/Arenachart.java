/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ArenaChart;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Arenachart
/*    */ {
/*    */   public static ArenaChart get(Long key)
/*    */   {
/* 12 */     return (ArenaChart)_Tables_.getInstance().arenachart.get(key);
/*    */   }
/*    */   
/*    */   public static ArenaChart get(Long key, ArenaChart value)
/*    */   {
/* 17 */     return (ArenaChart)_Tables_.getInstance().arenachart.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ArenaChart value)
/*    */   {
/* 22 */     _Tables_.getInstance().arenachart.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().arenachart.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ArenaChart value)
/*    */   {
/* 32 */     return _Tables_.getInstance().arenachart.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().arenachart.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ArenaChart> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().arenachart.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ArenaChart> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().arenachart;
/*    */   }
/*    */   
/*    */   public static ArenaChart select(Long key)
/*    */   {
/* 52 */     (ArenaChart)getTable().select(key, new TField()
/*    */     {
/*    */       public ArenaChart get(ArenaChart v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRanklist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(ArenaChart v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Arenachart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */