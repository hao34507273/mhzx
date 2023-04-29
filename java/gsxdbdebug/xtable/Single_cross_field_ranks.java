/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.SingleCrossFieldRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Single_cross_field_ranks
/*    */ {
/*    */   public static SingleCrossFieldRank get(Long key)
/*    */   {
/* 12 */     return (SingleCrossFieldRank)_Tables_.getInstance().single_cross_field_ranks.get(key);
/*    */   }
/*    */   
/*    */   public static SingleCrossFieldRank get(Long key, SingleCrossFieldRank value)
/*    */   {
/* 17 */     return (SingleCrossFieldRank)_Tables_.getInstance().single_cross_field_ranks.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SingleCrossFieldRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().single_cross_field_ranks.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().single_cross_field_ranks.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SingleCrossFieldRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().single_cross_field_ranks.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().single_cross_field_ranks.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SingleCrossFieldRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().single_cross_field_ranks.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SingleCrossFieldRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().single_cross_field_ranks;
/*    */   }
/*    */   
/*    */   public static SingleCrossFieldRank select(Long key)
/*    */   {
/* 52 */     (SingleCrossFieldRank)getTable().select(key, new TField()
/*    */     {
/*    */       public SingleCrossFieldRank get(SingleCrossFieldRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSeason(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(SingleCrossFieldRank v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getSeason());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRank_list(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(SingleCrossFieldRank v)
/*    */       {
/* 78 */         return v.getRank_listAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Single_cross_field_ranks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */