/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ItemBuyCount;
/*    */ import xbean.RoleLimitShop;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2limitshops
/*    */ {
/*    */   public static RoleLimitShop get(Long key)
/*    */   {
/* 12 */     return (RoleLimitShop)_Tables_.getInstance().role2limitshops.get(key);
/*    */   }
/*    */   
/*    */   public static RoleLimitShop get(Long key, RoleLimitShop value)
/*    */   {
/* 17 */     return (RoleLimitShop)_Tables_.getInstance().role2limitshops.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleLimitShop value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2limitshops.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2limitshops.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleLimitShop value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2limitshops.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2limitshops.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleLimitShop> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2limitshops.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleLimitShop> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2limitshops;
/*    */   }
/*    */   
/*    */   public static RoleLimitShop select(Long key)
/*    */   {
/* 52 */     (RoleLimitShop)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleLimitShop get(RoleLimitShop v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ItemBuyCount> selectType2itembuycount(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ItemBuyCount> get(RoleLimitShop v)
/*    */       {
/* 67 */         return v.getType2itembuycountAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2limitshops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */