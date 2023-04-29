/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GlobalVisibleMonsterInfo;
/*    */ import xbean.VisibleMonsterInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Visiblemonster
/*    */ {
/*    */   public static GlobalVisibleMonsterInfo get(Long key)
/*    */   {
/* 12 */     return (GlobalVisibleMonsterInfo)_Tables_.getInstance().visiblemonster.get(key);
/*    */   }
/*    */   
/*    */   public static GlobalVisibleMonsterInfo get(Long key, GlobalVisibleMonsterInfo value)
/*    */   {
/* 17 */     return (GlobalVisibleMonsterInfo)_Tables_.getInstance().visiblemonster.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobalVisibleMonsterInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().visiblemonster.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().visiblemonster.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobalVisibleMonsterInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().visiblemonster.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().visiblemonster.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GlobalVisibleMonsterInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().visiblemonster.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobalVisibleMonsterInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().visiblemonster;
/*    */   }
/*    */   
/*    */   public static GlobalVisibleMonsterInfo select(Long key)
/*    */   {
/* 52 */     (GlobalVisibleMonsterInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GlobalVisibleMonsterInfo get(GlobalVisibleMonsterInfo v)
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
/*    */       public Map<Integer, VisibleMonsterInfo> get(GlobalVisibleMonsterInfo v)
/*    */       {
/* 67 */         return v.getActivity_visible_monster_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Visiblemonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */