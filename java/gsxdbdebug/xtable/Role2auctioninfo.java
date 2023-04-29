/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import xbean.RoleAuctionInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2auctioninfo
/*    */ {
/*    */   public static RoleAuctionInfo get(Long key)
/*    */   {
/* 12 */     return (RoleAuctionInfo)_Tables_.getInstance().role2auctioninfo.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAuctionInfo get(Long key, RoleAuctionInfo value)
/*    */   {
/* 17 */     return (RoleAuctionInfo)_Tables_.getInstance().role2auctioninfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAuctionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2auctioninfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2auctioninfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAuctionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2auctioninfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2auctioninfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAuctionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2auctioninfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAuctionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2auctioninfo;
/*    */   }
/*    */   
/*    */   public static RoleAuctionInfo select(Long key)
/*    */   {
/* 52 */     (RoleAuctionInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleAuctionInfo get(RoleAuctionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAuction_item_ids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<Long> get(RoleAuctionInfo v)
/*    */       {
/* 67 */         return v.getAuction_item_idsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAuction_pet_ids(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<Long> get(RoleAuctionInfo v)
/*    */       {
/* 78 */         return v.getAuction_pet_idsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.Item> selectMarketid2auctionitem(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.Item> get(RoleAuctionInfo v)
/*    */       {
/* 89 */         return v.getMarketid2auctionitemAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.Pet> selectMarketid2auctionpet(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.Pet> get(RoleAuctionInfo v)
/*    */       {
/* :0 */         return v.getMarketid2auctionpetAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2auctioninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */