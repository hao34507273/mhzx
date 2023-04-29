/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.CountDown;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Countdowns
/*    */ {
/*    */   public static CountDown get(Long key)
/*    */   {
/* 12 */     return (CountDown)_Tables_.getInstance().countdowns.get(key);
/*    */   }
/*    */   
/*    */   public static CountDown get(Long key, CountDown value)
/*    */   {
/* 17 */     return (CountDown)_Tables_.getInstance().countdowns.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CountDown value)
/*    */   {
/* 22 */     _Tables_.getInstance().countdowns.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().countdowns.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CountDown value)
/*    */   {
/* 32 */     return _Tables_.getInstance().countdowns.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().countdowns.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CountDown> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().countdowns.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CountDown> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().countdowns;
/*    */   }
/*    */   
/*    */   public static CountDown select(Long key)
/*    */   {
/* 52 */     (CountDown)getTable().select(key, new TField()
/*    */     {
/*    */       public CountDown get(CountDown v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectCan_get_red_packet_roleids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(CountDown v)
/*    */       {
/* 67 */         return v.getCan_get_red_packet_roleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Countdowns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */