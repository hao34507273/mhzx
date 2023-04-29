/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.cake.RoleCakeBaseInfo;
/*    */ import mzm.gsp.cake.SGetFactionCakeInfoRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CakeDetailData;
/*    */ import xbean.FactionCakeData;
/*    */ 
/*    */ 
/*    */ public class PCGetFactionCakeInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final long factionId;
/*    */   
/*    */   public PCGetFactionCakeInfoReq(long roleId, int activityId, long factionId)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.activityId = activityId;
/* 31 */     this.factionId = factionId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/* 38 */     if (activityCfg == null)
/*    */     {
/* 40 */       CakeManager.loggerError("PCGetFactionCakeInfoReq.processImp@ SCakeActivityCfg is null!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(this.factionId) });
/*    */       
/*    */ 
/* 43 */       return false;
/*    */     }
/* 45 */     if ((!ActivityInterface.isActivityOpen(this.activityId)) || (!OpenInterface.getOpenStatus(activityCfg.switchId)))
/*    */     {
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     FactionCakeData xFactionCakeData = CakeManager.getXFactionCakeData(this.factionId, this.activityId, false);
/* 52 */     if (xFactionCakeData == null)
/*    */     {
/* 54 */       CakeManager.loggerError("PCGetFactionCakeInfoReq.processImp@ xFactionCakeData is null!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(this.factionId) });
/*    */       
/*    */ 
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     SGetFactionCakeInfoRep p = new SGetFactionCakeInfoRep();
/* 61 */     p.activityid = this.activityId;
/* 62 */     p.factionid = this.factionId;
/* 63 */     for (Map.Entry<Long, CakeDetailData> entry : xFactionCakeData.getRolecakes().entrySet())
/*    */     {
/* 65 */       p.factioncakeinfo.put(entry.getKey(), getRoleCakeBaseInfo(xFactionCakeData, ((Long)entry.getKey()).longValue(), (CakeDetailData)entry.getValue()));
/*    */     }
/* 67 */     OnlineManager.getInstance().send(this.roleId, p);
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private RoleCakeBaseInfo getRoleCakeBaseInfo(FactionCakeData xFactionCakeData, long roleId, CakeDetailData xCakeDetailData)
/*    */   {
/* 74 */     RoleCakeBaseInfo roleCakeBaseInfo = new RoleCakeBaseInfo();
/* 75 */     CakeManager.fillPCakeDetailInfo(roleCakeBaseInfo.cakeinfo, xCakeDetailData, xFactionCakeData.getCurturn());
/*    */     
/*    */     try
/*    */     {
/* 79 */       roleCakeBaseInfo.rolename.setString(RoleInterface.getName(roleId), "UTF-8");
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */     
/*    */ 
/*    */ 
/* 85 */     return roleCakeBaseInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCGetFactionCakeInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */