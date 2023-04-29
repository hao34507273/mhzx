/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MysteryShopInfo;
/*    */ import xbean.RoleMysteryShops;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2mystery_shops
/*    */ {
/*    */   public static RoleMysteryShops get(Long key)
/*    */   {
/* 12 */     return (RoleMysteryShops)_Tables_.getInstance().role2mystery_shops.get(key);
/*    */   }
/*    */   
/*    */   public static RoleMysteryShops get(Long key, RoleMysteryShops value)
/*    */   {
/* 17 */     return (RoleMysteryShops)_Tables_.getInstance().role2mystery_shops.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleMysteryShops value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2mystery_shops.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2mystery_shops.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleMysteryShops value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2mystery_shops.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2mystery_shops.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleMysteryShops> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2mystery_shops.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleMysteryShops> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2mystery_shops;
/*    */   }
/*    */   
/*    */   public static RoleMysteryShops select(Long key)
/*    */   {
/* 52 */     (RoleMysteryShops)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleMysteryShops get(RoleMysteryShops v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MysteryShopInfo> selectType2shop_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MysteryShopInfo> get(RoleMysteryShops v)
/*    */       {
/* 67 */         return v.getType2shop_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mystery_shops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */