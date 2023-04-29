/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.TreasureBoxAwardInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Treasureboxaward
/*    */ {
/*    */   public static TreasureBoxAwardInfo get(Long key)
/*    */   {
/* 12 */     return (TreasureBoxAwardInfo)_Tables_.getInstance().treasureboxaward.get(key);
/*    */   }
/*    */   
/*    */   public static TreasureBoxAwardInfo get(Long key, TreasureBoxAwardInfo value)
/*    */   {
/* 17 */     return (TreasureBoxAwardInfo)_Tables_.getInstance().treasureboxaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TreasureBoxAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().treasureboxaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().treasureboxaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TreasureBoxAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().treasureboxaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().treasureboxaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TreasureBoxAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().treasureboxaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TreasureBoxAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().treasureboxaward;
/*    */   }
/*    */   
/*    */   public static TreasureBoxAwardInfo select(Long key)
/*    */   {
/* 52 */     (TreasureBoxAwardInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public TreasureBoxAwardInfo get(TreasureBoxAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRoleidset(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(TreasureBoxAwardInfo v)
/*    */       {
/* 67 */         return v.getRoleidsetAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Treasureboxaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */