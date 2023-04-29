/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.SingleBattleBuff;
/*    */ import xbean.ZoneInfo;
/*    */ 
/*    */ public class POnRoleLeaveBuffZone extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long battleid;
/*    */   private final int sortid;
/*    */   
/*    */   public POnRoleLeaveBuffZone(long roleid, long battleid, int sortid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.battleid = battleid;
/* 20 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     SingleBattleBuff xSingleBattleBuff = xtable.Single_battle_buffs.get(Long.valueOf(this.battleid));
/* 28 */     if (xSingleBattleBuff == null)
/*    */     {
/* 30 */       GameServer.logger().info(String.format("[singlebattle]POnRoleLeaveBuffZone.processImp@no single battle buff info|battle_id=%d|sort_id=%d|roleid=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     ZoneInfo xZoneInfo = (ZoneInfo)xSingleBattleBuff.getZone_infos().get(Integer.valueOf(this.sortid));
/* 38 */     if (xZoneInfo == null)
/*    */     {
/*    */ 
/* 41 */       return false;
/*    */     }
/* 43 */     xZoneInfo.getRole_set().remove(Long.valueOf(this.roleid));
/*    */     
/* 45 */     GameServer.logger().info(String.format("[singlebattle]POnRoleLeaveBuffZone.processImp@role leave buff zone|battle_id=%d|sort_id=%d|roleid=%d", new Object[] { Long.valueOf(this.battleid), Integer.valueOf(this.sortid), Long.valueOf(this.roleid) }));
/*    */     
/*    */ 
/*    */ 
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\POnRoleLeaveBuffZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */