/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MultiGender;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Multigender
/*    */ {
/*    */   public static MultiGender get(Long paramLong)
/*    */   {
/* 13 */     return (MultiGender)_Tables_.getInstance().multigender.get(paramLong);
/*    */   }
/*    */   
/*    */   public static MultiGender get(Long paramLong, MultiGender paramMultiGender)
/*    */   {
/* 18 */     return (MultiGender)_Tables_.getInstance().multigender.get(paramLong, paramMultiGender);
/*    */   }
/*    */   
/*    */   public static void insert(Long paramLong, MultiGender paramMultiGender)
/*    */   {
/* 23 */     _Tables_.getInstance().multigender.insert(paramLong, paramMultiGender);
/*    */   }
/*    */   
/*    */   public static void delete(Long paramLong)
/*    */   {
/* 28 */     _Tables_.getInstance().multigender.delete(paramLong);
/*    */   }
/*    */   
/*    */   public static boolean add(Long paramLong, MultiGender paramMultiGender)
/*    */   {
/* 33 */     return _Tables_.getInstance().multigender.add(paramLong, paramMultiGender);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long paramLong)
/*    */   {
/* 38 */     return _Tables_.getInstance().multigender.remove(paramLong);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MultiGender> getCache()
/*    */   {
/* 43 */     return _Tables_.getInstance().multigender.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiGender> getTable()
/*    */   {
/* 48 */     return _Tables_.getInstance().multigender;
/*    */   }
/*    */   
/*    */   public static MultiGender select(Long paramLong)
/*    */   {
/* 53 */     (MultiGender)getTable().select(paramLong, new TField()
/*    */     {
/*    */       public MultiGender get(MultiGender paramAnonymousMultiGender)
/*    */       {
/* 57 */         return paramAnonymousMultiGender.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectGenders(Long paramLong)
/*    */   {
/* 64 */     (List)getTable().select(paramLong, new TField()
/*    */     {
/*    */       public List<Integer> get(MultiGender paramAnonymousMultiGender)
/*    */       {
/* 68 */         return paramAnonymousMultiGender.getGendersAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSwitch_time(Long paramLong)
/*    */   {
/* 75 */     (Long)getTable().select(paramLong, new TField()
/*    */     {
/*    */       public Long get(MultiGender paramAnonymousMultiGender)
/*    */       {
/* 79 */         return Long.valueOf(paramAnonymousMultiGender.getSwitch_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Multigender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */