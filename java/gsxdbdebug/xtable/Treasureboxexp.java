/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.TreasureBoxExpInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Treasureboxexp
/*    */ {
/*    */   public static TreasureBoxExpInfo get(Long key)
/*    */   {
/* 12 */     return (TreasureBoxExpInfo)_Tables_.getInstance().treasureboxexp.get(key);
/*    */   }
/*    */   
/*    */   public static TreasureBoxExpInfo get(Long key, TreasureBoxExpInfo value)
/*    */   {
/* 17 */     return (TreasureBoxExpInfo)_Tables_.getInstance().treasureboxexp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TreasureBoxExpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().treasureboxexp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().treasureboxexp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TreasureBoxExpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().treasureboxexp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().treasureboxexp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TreasureBoxExpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().treasureboxexp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TreasureBoxExpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().treasureboxexp;
/*    */   }
/*    */   
/*    */   public static TreasureBoxExpInfo select(Long key)
/*    */   {
/* 52 */     (TreasureBoxExpInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public TreasureBoxExpInfo get(TreasureBoxExpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectRoleid2getexptime(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(TreasureBoxExpInfo v)
/*    */       {
/* 67 */         return v.getRoleid2getexptimeAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Treasureboxexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */