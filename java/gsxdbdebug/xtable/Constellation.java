/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ConstellationCards;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Constellation
/*    */ {
/*    */   public static xbean.Constellation get(Long key)
/*    */   {
/* 12 */     return (xbean.Constellation)_Tables_.getInstance().constellation.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Constellation get(Long key, xbean.Constellation value)
/*    */   {
/* 17 */     return (xbean.Constellation)_Tables_.getInstance().constellation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Constellation value)
/*    */   {
/* 22 */     _Tables_.getInstance().constellation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().constellation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Constellation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().constellation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().constellation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, xbean.Constellation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().constellation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Constellation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().constellation;
/*    */   }
/*    */   
/*    */   public static xbean.Constellation select(Long key)
/*    */   {
/* 52 */     (xbean.Constellation)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Constellation get(xbean.Constellation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<ConstellationCards> selectCards(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<ConstellationCards> get(xbean.Constellation v)
/*    */       {
/* 67 */         return v.getCardsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectIndex(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(xbean.Constellation v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getIndex());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Constellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */