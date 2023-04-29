/*     */ package mzm.gsp.csprovider.ssp;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.POnSSPSetFriendsCircleValueRsp;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSP_UpdateRoleImportantValue
/*     */   implements SSPHandler
/*     */ {
/*     */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*     */   
/*     */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/*  26 */     if (res.retcode != 0)
/*     */     {
/*  28 */       String jsonStr = arg.data.getString("UTF-8");
/*     */       
/*  30 */       JSONObject jsonObject = new JSONObject(jsonStr);
/*     */       
/*  32 */       StringBuilder sBuilder = new StringBuilder();
/*  33 */       sBuilder.append("[friendscircle]SSP_UpdateRoleImportantValue.onClient@report role base info error");
/*  34 */       sBuilder.append("|ret_code=").append(res.retcode);
/*  35 */       sBuilder.append("|result=").append(res.result.getString("UTF-8"));
/*  36 */       sBuilder.append("|arg_data=").append(jsonStr);
/*     */       
/*  38 */       GameServer.logger().error(sBuilder.toString());
/*     */       
/*  40 */       long roleId = jsonObject.getLong("roleId");
/*     */       
/*  42 */       new PUnSetRepairTreadStatus(roleId).execute();
/*     */     }
/*     */     else
/*     */     {
/*  46 */       String jsonStr = arg.data.getString("UTF-8");
/*  47 */       JSONObject jsonObject = new JSONObject(jsonStr);
/*     */       
/*  49 */       long roleId = jsonObject.getLong("roleId");
/*     */       
/*  51 */       int thisWeekPopularityValue = -1;
/*  52 */       int allPopularity = -1;
/*  53 */       int giftCount = -1;
/*  54 */       int gainGiftCount = -1;
/*  55 */       if (jsonObject.has("thisWeekPopularity"))
/*     */       {
/*  57 */         thisWeekPopularityValue = jsonObject.getInt("thisWeekPopularity");
/*     */       }
/*     */       
/*  60 */       if (jsonObject.has("allPopularity"))
/*     */       {
/*  62 */         allPopularity = jsonObject.getInt("allPopularity");
/*     */       }
/*     */       
/*  65 */       if (jsonObject.has("giftCount"))
/*     */       {
/*  67 */         giftCount = jsonObject.getInt("giftCount");
/*     */       }
/*     */       
/*  70 */       if (jsonObject.has("gainGiftCount"))
/*     */       {
/*  72 */         gainGiftCount = jsonObject.getInt("gainGiftCount");
/*     */       }
/*     */       
/*  75 */       int modifyType = -1;
/*  76 */       int modifyValue = -1;
/*  77 */       if (giftCount != -1)
/*     */       {
/*  79 */         modifyType = 1;
/*  80 */         modifyValue = giftCount;
/*     */       }
/*     */       
/*  83 */       if (allPopularity != -1)
/*     */       {
/*  85 */         modifyType = 2;
/*  86 */         modifyValue = allPopularity;
/*     */       }
/*     */       
/*  89 */       if (thisWeekPopularityValue != -1)
/*     */       {
/*  91 */         modifyType = 3;
/*  92 */         modifyValue = thisWeekPopularityValue;
/*     */       }
/*     */       
/*  95 */       if (gainGiftCount != -1)
/*     */       {
/*  97 */         modifyType = 4;
/*  98 */         modifyValue = gainGiftCount;
/*     */       }
/*     */       
/* 101 */       new POnSSPSetFriendsCircleValueRsp(roleId, modifyType, modifyValue, context).execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/* 109 */     String jsonStr = arg.data.getString("UTF-8");
/*     */     
/* 111 */     JSONObject jsonObject = new JSONObject(jsonStr);
/*     */     
/* 113 */     StringBuilder sBuilder = new StringBuilder();
/* 114 */     sBuilder.append("[friendscircle]SSP_UpdateRoleImportantValue.onTimeout@update role important value time out");
/* 115 */     sBuilder.append("|ret_code=").append(res.retcode);
/* 116 */     sBuilder.append("|result=").append(res.result.getString("UTF-8"));
/* 117 */     sBuilder.append("|arg=").append(jsonStr);
/*     */     
/* 119 */     GameServer.logger().error(sBuilder.toString());
/*     */     
/* 121 */     long roleId = jsonObject.getLong("roleId");
/*     */     
/* 123 */     new PUnSetRepairTreadStatus(roleId).execute();
/*     */   }
/*     */   
/*     */   private static class PUnSetRepairTreadStatus extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PUnSetRepairTreadStatus(long roleId)
/*     */     {
/* 132 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 138 */       RoleStatusInterface.unsetStatus(this.roleId, 1830);
/* 139 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_UpdateRoleImportantValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */