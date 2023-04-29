/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.RoamItemRecord;
/*    */ import xbean.TreasureBagRoamOperator;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2treasurebagroamoperator
/*    */ {
/*    */   public static TreasureBagRoamOperator get(Long key)
/*    */   {
/* 12 */     return (TreasureBagRoamOperator)_Tables_.getInstance().role2treasurebagroamoperator.get(key);
/*    */   }
/*    */   
/*    */   public static TreasureBagRoamOperator get(Long key, TreasureBagRoamOperator value)
/*    */   {
/* 17 */     return (TreasureBagRoamOperator)_Tables_.getInstance().role2treasurebagroamoperator.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TreasureBagRoamOperator value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2treasurebagroamoperator.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2treasurebagroamoperator.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TreasureBagRoamOperator value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2treasurebagroamoperator.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2treasurebagroamoperator.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TreasureBagRoamOperator> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2treasurebagroamoperator.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TreasureBagRoamOperator> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2treasurebagroamoperator;
/*    */   }
/*    */   
/*    */   public static TreasureBagRoamOperator select(Long key)
/*    */   {
/* 52 */     (TreasureBagRoamOperator)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public TreasureBagRoamOperator get(TreasureBagRoamOperator v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoamItemRecord> selectRecordlist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoamItemRecord> get(TreasureBagRoamOperator v)
/*    */       {
/* 67 */         return v.getRecordlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2treasurebagroamoperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */