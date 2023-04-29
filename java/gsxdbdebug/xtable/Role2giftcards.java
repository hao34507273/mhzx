/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleGiftCardInfo;
/*    */ import xbean.RoleGiftCards;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2giftcards
/*    */ {
/*    */   public static RoleGiftCards get(Long key)
/*    */   {
/* 12 */     return (RoleGiftCards)_Tables_.getInstance().role2giftcards.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGiftCards get(Long key, RoleGiftCards value)
/*    */   {
/* 17 */     return (RoleGiftCards)_Tables_.getInstance().role2giftcards.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGiftCards value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2giftcards.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2giftcards.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGiftCards value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2giftcards.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2giftcards.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGiftCards> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2giftcards.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGiftCards> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2giftcards;
/*    */   }
/*    */   
/*    */   public static RoleGiftCards select(Long key)
/*    */   {
/* 52 */     (RoleGiftCards)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleGiftCards get(RoleGiftCards v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<String, RoleGiftCardInfo> selectCards(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<String, RoleGiftCardInfo> get(RoleGiftCards v)
/*    */       {
/* 67 */         return v.getCardsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2giftcards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */