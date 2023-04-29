/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.GroupShoppingBanInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Group_shopping_ban_info
/*    */ {
/*    */   public static GroupShoppingBanInfo get(Long key)
/*    */   {
/* 12 */     return (GroupShoppingBanInfo)_Tables_.getInstance().group_shopping_ban_info.get(key);
/*    */   }
/*    */   
/*    */   public static GroupShoppingBanInfo get(Long key, GroupShoppingBanInfo value)
/*    */   {
/* 17 */     return (GroupShoppingBanInfo)_Tables_.getInstance().group_shopping_ban_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GroupShoppingBanInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().group_shopping_ban_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().group_shopping_ban_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GroupShoppingBanInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().group_shopping_ban_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().group_shopping_ban_info.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GroupShoppingBanInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().group_shopping_ban_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GroupShoppingBanInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().group_shopping_ban_info;
/*    */   }
/*    */   
/*    */   public static GroupShoppingBanInfo select(Long key)
/*    */   {
/* 52 */     (GroupShoppingBanInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GroupShoppingBanInfo get(GroupShoppingBanInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectBanned_group_shopping_items(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(GroupShoppingBanInfo v)
/*    */       {
/* 67 */         return v.getBanned_group_shopping_itemsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Group_shopping_ban_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */