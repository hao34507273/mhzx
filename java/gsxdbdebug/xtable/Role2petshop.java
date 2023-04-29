/*    */ package xtable;
/*    */ 
/*    */ import xbean.PetShopBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2petshop
/*    */ {
/*    */   public static PetShopBean get(Long key)
/*    */   {
/* 12 */     return (PetShopBean)_Tables_.getInstance().role2petshop.get(key);
/*    */   }
/*    */   
/*    */   public static PetShopBean get(Long key, PetShopBean value)
/*    */   {
/* 17 */     return (PetShopBean)_Tables_.getInstance().role2petshop.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PetShopBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2petshop.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2petshop.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PetShopBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2petshop.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2petshop.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, PetShopBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2petshop.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PetShopBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2petshop;
/*    */   }
/*    */   
/*    */   public static PetShopBean select(Long key)
/*    */   {
/* 52 */     (PetShopBean)getTable().select(key, new TField()
/*    */     {
/*    */       public PetShopBean get(PetShopBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSellcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PetShopBean v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getSellcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PetShopBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2petshop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */