/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.WorldCounterReward;
/*    */ import xbean.WorldCounterRewardInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2worldcounterreward
/*    */ {
/*    */   public static WorldCounterReward get(Long key)
/*    */   {
/* 12 */     return (WorldCounterReward)_Tables_.getInstance().role2worldcounterreward.get(key);
/*    */   }
/*    */   
/*    */   public static WorldCounterReward get(Long key, WorldCounterReward value)
/*    */   {
/* 17 */     return (WorldCounterReward)_Tables_.getInstance().role2worldcounterreward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WorldCounterReward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2worldcounterreward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2worldcounterreward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WorldCounterReward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2worldcounterreward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2worldcounterreward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WorldCounterReward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2worldcounterreward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WorldCounterReward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2worldcounterreward;
/*    */   }
/*    */   
/*    */   public static WorldCounterReward select(Long key)
/*    */   {
/* 52 */     (WorldCounterReward)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WorldCounterReward get(WorldCounterReward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, WorldCounterRewardInfo> selectReward_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, WorldCounterRewardInfo> get(WorldCounterReward v)
/*    */       {
/* 67 */         return v.getReward_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2worldcounterreward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */