/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MenPaiStar;
/*    */ import xbean.MenPaiStarInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Menpaistar
/*    */ {
/*    */   public static MenPaiStar get(Long key)
/*    */   {
/* 12 */     return (MenPaiStar)_Tables_.getInstance().menpaistar.get(key);
/*    */   }
/*    */   
/*    */   public static MenPaiStar get(Long key, MenPaiStar value)
/*    */   {
/* 17 */     return (MenPaiStar)_Tables_.getInstance().menpaistar.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MenPaiStar value)
/*    */   {
/* 22 */     _Tables_.getInstance().menpaistar.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().menpaistar.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MenPaiStar value)
/*    */   {
/* 32 */     return _Tables_.getInstance().menpaistar.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().menpaistar.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MenPaiStar> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().menpaistar.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MenPaiStar> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().menpaistar;
/*    */   }
/*    */   
/*    */   public static MenPaiStar select(Long key)
/*    */   {
/* 52 */     (MenPaiStar)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MenPaiStar get(MenPaiStar v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MenPaiStarInfo> selectCharts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MenPaiStarInfo> get(MenPaiStar v)
/*    */       {
/* 67 */         return v.getChartsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Menpaistar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */