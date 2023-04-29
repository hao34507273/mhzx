/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.SendInvitation;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2sendinvitation
/*    */ {
/*    */   public static SendInvitation get(Long key)
/*    */   {
/* 12 */     return (SendInvitation)_Tables_.getInstance().role2sendinvitation.get(key);
/*    */   }
/*    */   
/*    */   public static SendInvitation get(Long key, SendInvitation value)
/*    */   {
/* 17 */     return (SendInvitation)_Tables_.getInstance().role2sendinvitation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SendInvitation value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2sendinvitation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2sendinvitation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SendInvitation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2sendinvitation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2sendinvitation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SendInvitation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2sendinvitation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SendInvitation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2sendinvitation;
/*    */   }
/*    */   
/*    */   public static SendInvitation select(Long key)
/*    */   {
/* 52 */     (SendInvitation)getTable().select(key, new TField()
/*    */     {
/*    */       public SendInvitation get(SendInvitation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectInvitations(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(SendInvitation v)
/*    */       {
/* 67 */         return v.getInvitationsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2sendinvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */