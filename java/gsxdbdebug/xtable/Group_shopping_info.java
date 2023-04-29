/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.GroupShoppingInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Group_shopping_info
/*    */ {
/*    */   public static GroupShoppingInfo get(Long key)
/*    */   {
/* 12 */     return (GroupShoppingInfo)_Tables_.getInstance().group_shopping_info.get(key);
/*    */   }
/*    */   
/*    */   public static GroupShoppingInfo get(Long key, GroupShoppingInfo value)
/*    */   {
/* 17 */     return (GroupShoppingInfo)_Tables_.getInstance().group_shopping_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GroupShoppingInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().group_shopping_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().group_shopping_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GroupShoppingInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().group_shopping_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().group_shopping_info.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GroupShoppingInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().group_shopping_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GroupShoppingInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().group_shopping_info;
/*    */   }
/*    */   
/*    */   public static GroupShoppingInfo select(Long key)
/*    */   {
/* 52 */     (GroupShoppingInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GroupShoppingInfo get(GroupShoppingInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.BigGroupShoppingItemInfo> selectBig_group_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.BigGroupShoppingItemInfo> get(GroupShoppingInfo v)
/*    */       {
/* 67 */         return v.getBig_group_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.SmallGroupShoppingItemInfo> selectSmall_group_infos(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.SmallGroupShoppingItemInfo> get(GroupShoppingInfo v)
/*    */       {
/* 78 */         return v.getSmall_group_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectIncompleted_small_groups(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(GroupShoppingInfo v)
/*    */       {
/* 89 */         return v.getIncompleted_small_groupsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Group_shopping_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */