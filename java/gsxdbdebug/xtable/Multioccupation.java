/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MultiOccupation;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Multioccupation
/*    */ {
/*    */   public static MultiOccupation get(Long key)
/*    */   {
/* 12 */     return (MultiOccupation)_Tables_.getInstance().multioccupation.get(key);
/*    */   }
/*    */   
/*    */   public static MultiOccupation get(Long key, MultiOccupation value)
/*    */   {
/* 17 */     return (MultiOccupation)_Tables_.getInstance().multioccupation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MultiOccupation value)
/*    */   {
/* 22 */     _Tables_.getInstance().multioccupation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().multioccupation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MultiOccupation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().multioccupation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().multioccupation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MultiOccupation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().multioccupation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiOccupation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().multioccupation;
/*    */   }
/*    */   
/*    */   public static MultiOccupation select(Long key)
/*    */   {
/* 52 */     (MultiOccupation)getTable().select(key, new TField()
/*    */     {
/*    */       public MultiOccupation get(MultiOccupation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectOccupations(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(MultiOccupation v)
/*    */       {
/* 67 */         return v.getOccupationsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectActivate_time(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MultiOccupation v)
/*    */       {
/* 78 */         return Long.valueOf(v.getActivate_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSwitch_time(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MultiOccupation v)
/*    */       {
/* 89 */         return Long.valueOf(v.getSwitch_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Multioccupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */