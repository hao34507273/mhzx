/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.BanTradeItems;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Tradetype2banitems
/*    */ {
/*    */   public static BanTradeItems get(Long key)
/*    */   {
/* 12 */     return (BanTradeItems)_Tables_.getInstance().tradetype2banitems.get(key);
/*    */   }
/*    */   
/*    */   public static BanTradeItems get(Long key, BanTradeItems value)
/*    */   {
/* 17 */     return (BanTradeItems)_Tables_.getInstance().tradetype2banitems.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BanTradeItems value)
/*    */   {
/* 22 */     _Tables_.getInstance().tradetype2banitems.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().tradetype2banitems.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BanTradeItems value)
/*    */   {
/* 32 */     return _Tables_.getInstance().tradetype2banitems.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().tradetype2banitems.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BanTradeItems> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().tradetype2banitems.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BanTradeItems> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().tradetype2banitems;
/*    */   }
/*    */   
/*    */   public static BanTradeItems select(Long key)
/*    */   {
/* 52 */     (BanTradeItems)getTable().select(key, new TField()
/*    */     {
/*    */       public BanTradeItems get(BanTradeItems v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectItemids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(BanTradeItems v)
/*    */       {
/* 67 */         return v.getItemidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Tradetype2banitems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */