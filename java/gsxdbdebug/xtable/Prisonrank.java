/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.PrisonRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Prisonrank
/*    */ {
/*    */   public static PrisonRank get(Long key)
/*    */   {
/* 12 */     return (PrisonRank)_Tables_.getInstance().prisonrank.get(key);
/*    */   }
/*    */   
/*    */   public static PrisonRank get(Long key, PrisonRank value)
/*    */   {
/* 17 */     return (PrisonRank)_Tables_.getInstance().prisonrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PrisonRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().prisonrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().prisonrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PrisonRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().prisonrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().prisonrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PrisonRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().prisonrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PrisonRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().prisonrank;
/*    */   }
/*    */   
/*    */   public static PrisonRank select(Long key)
/*    */   {
/* 52 */     (PrisonRank)getTable().select(key, new TField()
/*    */     {
/*    */       public PrisonRank get(PrisonRank v)
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
/*    */       public List<Long> get(PrisonRank v)
/*    */       {
/* 67 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Prisonrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */