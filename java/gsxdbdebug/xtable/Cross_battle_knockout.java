/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleKnockoutActivityInfo;
/*    */ import xbean.CrossBattleKnockoutInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_knockout
/*    */ {
/*    */   public static CrossBattleKnockoutActivityInfo get(Long key)
/*    */   {
/* 12 */     return (CrossBattleKnockoutActivityInfo)_Tables_.getInstance().cross_battle_knockout.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutActivityInfo get(Long key, CrossBattleKnockoutActivityInfo value)
/*    */   {
/* 17 */     return (CrossBattleKnockoutActivityInfo)_Tables_.getInstance().cross_battle_knockout.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleKnockoutActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_knockout.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_knockout.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleKnockoutActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_knockout.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_knockout.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleKnockoutActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_knockout.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleKnockoutActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_knockout;
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutActivityInfo select(Long key)
/*    */   {
/* 52 */     (CrossBattleKnockoutActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleKnockoutActivityInfo get(CrossBattleKnockoutActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleKnockoutInfo> selectKnockout_info_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleKnockoutInfo> get(CrossBattleKnockoutActivityInfo v)
/*    */       {
/* 67 */         return v.getKnockout_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_knockout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */