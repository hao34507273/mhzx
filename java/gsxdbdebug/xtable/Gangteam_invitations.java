/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GangTeamInvitation;
/*    */ import xbean.GangTeamInvitations;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangteam_invitations
/*    */ {
/*    */   public static GangTeamInvitations get(Long key)
/*    */   {
/* 12 */     return (GangTeamInvitations)_Tables_.getInstance().gangteam_invitations.get(key);
/*    */   }
/*    */   
/*    */   public static GangTeamInvitations get(Long key, GangTeamInvitations value)
/*    */   {
/* 17 */     return (GangTeamInvitations)_Tables_.getInstance().gangteam_invitations.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangTeamInvitations value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangteam_invitations.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangteam_invitations.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangTeamInvitations value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangteam_invitations.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangteam_invitations.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangTeamInvitations> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangteam_invitations.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangTeamInvitations> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangteam_invitations;
/*    */   }
/*    */   
/*    */   public static GangTeamInvitations select(Long key)
/*    */   {
/* 52 */     (GangTeamInvitations)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GangTeamInvitations get(GangTeamInvitations v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, GangTeamInvitation> selectInvitations(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, GangTeamInvitation> get(GangTeamInvitations v)
/*    */       {
/* 67 */         return v.getInvitationsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangteam_invitations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */