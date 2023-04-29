/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Marriageparade
/*    */ {
/*    */   public static MarriageParades get(Long key)
/*    */   {
/* 12 */     return (MarriageParades)_Tables_.getInstance().marriageparade.get(key);
/*    */   }
/*    */   
/*    */   public static MarriageParades get(Long key, MarriageParades value)
/*    */   {
/* 17 */     return (MarriageParades)_Tables_.getInstance().marriageparade.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MarriageParades value)
/*    */   {
/* 22 */     _Tables_.getInstance().marriageparade.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().marriageparade.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MarriageParades value)
/*    */   {
/* 32 */     return _Tables_.getInstance().marriageparade.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().marriageparade.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MarriageParades> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().marriageparade.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MarriageParades> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().marriageparade;
/*    */   }
/*    */   
/*    */   public static MarriageParades select(Long key)
/*    */   {
/* 52 */     (MarriageParades)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MarriageParades get(MarriageParades v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<MarriageParade> selectMarriageparades(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<MarriageParade> get(MarriageParades v)
/*    */       {
/* 67 */         return v.getMarriageparadesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marriageparade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */