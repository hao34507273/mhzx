/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Lottery;
/*    */ import xbean.LotteryResult;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2lottery
/*    */ {
/*    */   public static Lottery get(Long key)
/*    */   {
/* 12 */     return (Lottery)_Tables_.getInstance().role2lottery.get(key);
/*    */   }
/*    */   
/*    */   public static Lottery get(Long key, Lottery value)
/*    */   {
/* 17 */     return (Lottery)_Tables_.getInstance().role2lottery.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Lottery value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2lottery.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2lottery.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Lottery value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2lottery.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2lottery.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Lottery> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2lottery.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Lottery> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2lottery;
/*    */   }
/*    */   
/*    */   public static Lottery select(Long key)
/*    */   {
/* 52 */     (Lottery)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Lottery get(Lottery v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LotteryResult> selectLottery(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LotteryResult> get(Lottery v)
/*    */       {
/* 67 */         return v.getLotteryAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2lottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */