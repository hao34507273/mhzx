/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LuckyStarInfo;
/*    */ import xbean.Role2LuckyStarInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2luckystar
/*    */ {
/*    */   public static Role2LuckyStarInfo get(Long key)
/*    */   {
/* 12 */     return (Role2LuckyStarInfo)_Tables_.getInstance().role2luckystar.get(key);
/*    */   }
/*    */   
/*    */   public static Role2LuckyStarInfo get(Long key, Role2LuckyStarInfo value)
/*    */   {
/* 17 */     return (Role2LuckyStarInfo)_Tables_.getInstance().role2luckystar.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2LuckyStarInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2luckystar.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2luckystar.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2LuckyStarInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2luckystar.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2luckystar.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2LuckyStarInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2luckystar.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2LuckyStarInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2luckystar;
/*    */   }
/*    */   
/*    */   public static Role2LuckyStarInfo select(Long key)
/*    */   {
/* 52 */     (Role2LuckyStarInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2LuckyStarInfo get(Role2LuckyStarInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LuckyStarInfo> selectLucky_star_info_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LuckyStarInfo> get(Role2LuckyStarInfo v)
/*    */       {
/* 67 */         return v.getLucky_star_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2luckystar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */