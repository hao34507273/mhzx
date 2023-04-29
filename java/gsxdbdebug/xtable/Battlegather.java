/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BattleGatherData;
/*    */ import xbean.GatherItemData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Battlegather
/*    */ {
/*    */   public static BattleGatherData get(Long key)
/*    */   {
/* 12 */     return (BattleGatherData)_Tables_.getInstance().battlegather.get(key);
/*    */   }
/*    */   
/*    */   public static BattleGatherData get(Long key, BattleGatherData value)
/*    */   {
/* 17 */     return (BattleGatherData)_Tables_.getInstance().battlegather.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BattleGatherData value)
/*    */   {
/* 22 */     _Tables_.getInstance().battlegather.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().battlegather.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BattleGatherData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().battlegather.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().battlegather.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BattleGatherData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().battlegather.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BattleGatherData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().battlegather;
/*    */   }
/*    */   
/*    */   public static BattleGatherData select(Long key)
/*    */   {
/* 52 */     (BattleGatherData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public BattleGatherData get(BattleGatherData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, GatherItemData> selectGatheritemdatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, GatherItemData> get(BattleGatherData v)
/*    */       {
/* 67 */         return v.getGatheritemdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Battlegather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */