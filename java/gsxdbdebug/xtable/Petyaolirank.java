/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.PetYaoliBean;
/*    */ import xbean.PetYaoliRank;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Petyaolirank
/*    */ {
/*    */   public static PetYaoliRank get(Long key)
/*    */   {
/* 12 */     return (PetYaoliRank)_Tables_.getInstance().petyaolirank.get(key);
/*    */   }
/*    */   
/*    */   public static PetYaoliRank get(Long key, PetYaoliRank value)
/*    */   {
/* 17 */     return (PetYaoliRank)_Tables_.getInstance().petyaolirank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetYaoliRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().petyaolirank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().petyaolirank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetYaoliRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().petyaolirank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().petyaolirank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PetYaoliRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().petyaolirank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetYaoliRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().petyaolirank;
/*    */   }
/*    */   
/*    */   public static PetYaoliRank select(Long key)
/*    */   {
/* 52 */     (PetYaoliRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public PetYaoliRank get(PetYaoliRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<PetYaoliBean> selectRolerankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<PetYaoliBean> get(PetYaoliRank v)
/*    */       {
/* 67 */         return v.getRolerankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Petyaolirank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */