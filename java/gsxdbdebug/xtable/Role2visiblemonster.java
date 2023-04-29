/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Role2VisibleMonsterInfo;
/*    */ import xbean.VisibleMonsterInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2visiblemonster
/*    */ {
/*    */   public static Role2VisibleMonsterInfo get(Long key)
/*    */   {
/* 12 */     return (Role2VisibleMonsterInfo)_Tables_.getInstance().role2visiblemonster.get(key);
/*    */   }
/*    */   
/*    */   public static Role2VisibleMonsterInfo get(Long key, Role2VisibleMonsterInfo value)
/*    */   {
/* 17 */     return (Role2VisibleMonsterInfo)_Tables_.getInstance().role2visiblemonster.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2VisibleMonsterInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2visiblemonster.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2visiblemonster.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2VisibleMonsterInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2visiblemonster.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2visiblemonster.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2VisibleMonsterInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2visiblemonster.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2VisibleMonsterInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2visiblemonster;
/*    */   }
/*    */   
/*    */   public static Role2VisibleMonsterInfo select(Long key)
/*    */   {
/* 52 */     (Role2VisibleMonsterInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2VisibleMonsterInfo get(Role2VisibleMonsterInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, VisibleMonsterInfo> selectActivity_visible_monster_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, VisibleMonsterInfo> get(Role2VisibleMonsterInfo v)
/*    */       {
/* 67 */         return v.getActivity_visible_monster_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2visiblemonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */