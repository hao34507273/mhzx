/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.HulaRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Hularank
/*    */ {
/*    */   public static HulaRank get(Long key)
/*    */   {
/* 12 */     return (HulaRank)_Tables_.getInstance().hularank.get(key);
/*    */   }
/*    */   
/*    */   public static HulaRank get(Long key, HulaRank value)
/*    */   {
/* 17 */     return (HulaRank)_Tables_.getInstance().hularank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HulaRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().hularank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().hularank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HulaRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().hularank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().hularank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, HulaRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().hularank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HulaRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().hularank;
/*    */   }
/*    */   
/*    */   public static HulaRank select(Long key)
/*    */   {
/* 52 */     (HulaRank)getTable().select(key, new TField()
/*    */     {
/*    */       public HulaRank get(HulaRank v)
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
/*    */       public List<Long> get(HulaRank v)
/*    */       {
/* 67 */         return v.getRanklistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Hularank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */