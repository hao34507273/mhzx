/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.IdCounter;
/*    */ import xbean.ItemSubid2Count;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2itemsubid
/*    */ {
/*    */   public static ItemSubid2Count get(Long key)
/*    */   {
/* 12 */     return (ItemSubid2Count)_Tables_.getInstance().role2itemsubid.get(key);
/*    */   }
/*    */   
/*    */   public static ItemSubid2Count get(Long key, ItemSubid2Count value)
/*    */   {
/* 17 */     return (ItemSubid2Count)_Tables_.getInstance().role2itemsubid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ItemSubid2Count value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2itemsubid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2itemsubid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ItemSubid2Count value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2itemsubid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2itemsubid.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ItemSubid2Count> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2itemsubid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ItemSubid2Count> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2itemsubid;
/*    */   }
/*    */   
/*    */   public static ItemSubid2Count select(Long key)
/*    */   {
/* 52 */     (ItemSubid2Count)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ItemSubid2Count get(ItemSubid2Count v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, IdCounter> selectItemsubid2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, IdCounter> get(ItemSubid2Count v)
/*    */       {
/* 67 */         return v.getItemsubid2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2itemsubid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */