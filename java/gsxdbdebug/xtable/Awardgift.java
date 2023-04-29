/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AwarGiftInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Awardgift
/*    */ {
/*    */   public static AwarGiftInfo get(Long key)
/*    */   {
/* 12 */     return (AwarGiftInfo)_Tables_.getInstance().awardgift.get(key);
/*    */   }
/*    */   
/*    */   public static AwarGiftInfo get(Long key, AwarGiftInfo value)
/*    */   {
/* 17 */     return (AwarGiftInfo)_Tables_.getInstance().awardgift.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AwarGiftInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().awardgift.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().awardgift.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AwarGiftInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().awardgift.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().awardgift.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AwarGiftInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().awardgift.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AwarGiftInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().awardgift;
/*    */   }
/*    */   
/*    */   public static AwarGiftInfo select(Long key)
/*    */   {
/* 52 */     (AwarGiftInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public AwarGiftInfo get(AwarGiftInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectType2global(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(AwarGiftInfo v)
/*    */       {
/* 67 */         return v.getType2globalAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Awardgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */