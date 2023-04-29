/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.WantedRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Wantedrank
/*    */ {
/*    */   public static WantedRank get(Long key)
/*    */   {
/* 12 */     return (WantedRank)_Tables_.getInstance().wantedrank.get(key);
/*    */   }
/*    */   
/*    */   public static WantedRank get(Long key, WantedRank value)
/*    */   {
/* 17 */     return (WantedRank)_Tables_.getInstance().wantedrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WantedRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().wantedrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().wantedrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WantedRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().wantedrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().wantedrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WantedRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().wantedrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WantedRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().wantedrank;
/*    */   }
/*    */   
/*    */   public static WantedRank select(Long key)
/*    */   {
/* 52 */     (WantedRank)getTable().select(key, new TField()
/*    */     {
/*    */       public WantedRank get(WantedRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectRoleids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(WantedRank v)
/*    */       {
/* 67 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Wantedrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */