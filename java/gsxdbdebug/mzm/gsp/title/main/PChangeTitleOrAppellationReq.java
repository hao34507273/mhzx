/*     */ package mzm.gsp.title.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.title.SChangeTitleOrAppellationReq;
/*     */ import mzm.gsp.title.SNewPropertyReplaceReq;
/*     */ import mzm.gsp.title.event.AppOrTitleChange;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AppellationInfo;
/*     */ import xbean.TitleAppellation;
/*     */ import xbean.TitleInfo;
/*     */ import xtable.Role2titleappellation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PChangeTitleOrAppellationReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int id;
/*     */   private final int changeType;
/*     */   
/*     */   public PChangeTitleOrAppellationReq(long roleId, int id, int changeType)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.id = id;
/*  34 */     this.changeType = changeType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 230, true))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(this.roleId));
/*  45 */     if (xTitleAppellation == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int oldId = 0;
/*  51 */     String appName = "";
/*  52 */     switch (this.changeType)
/*     */     {
/*     */     case 0: 
/*  55 */       if ((this.id > 0) && (!TitleManager.checkAppellationOccupation("PChangeTitleOrAppellationReq.processImp", this.roleId, this.id)))
/*     */       {
/*     */ 
/*     */ 
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       oldId = xTitleAppellation.getActiveappellation();
/*  63 */       if (!changeActiveAppellation(xTitleAppellation))
/*     */       {
/*  65 */         GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.processImp@change appellation err!|role_id=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */         
/*     */ 
/*     */ 
/*  69 */         return false;
/*     */       }
/*  71 */       if (this.id > 0)
/*     */       {
/*  73 */         appName = TitleManager.getAppString(this.id, xTitleAppellation);
/*     */       }
/*     */       
/*     */       break;
/*     */     case 1: 
/*  78 */       oldId = xTitleAppellation.getActivetitle();
/*  79 */       if (!changeActiveTitle(xTitleAppellation))
/*     */       {
/*  81 */         GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.processImp@ change title err!|roleId=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */         
/*     */ 
/*     */ 
/*  85 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/*  90 */       GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.processImp@ illegal change type!|roleId=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     noticeClientChange();
/*     */     
/*  99 */     noticeSOtherChange(appName, oldId);
/*     */     
/* 101 */     GameServer.logger().info(String.format("[title]PChangeTitleOrAppellationReq.processImp@ role put on title,appellation!|roleId=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */     
/*     */ 
/*     */ 
/* 105 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void noticeSOtherChange(String appName, int oldId)
/*     */   {
/* 116 */     AppOrTitleChangeArg arg = new AppOrTitleChangeArg(this.roleId, this.id, this.changeType, oldId);
/* 117 */     if ((appName != null) && (!appName.equals("")))
/*     */     {
/* 119 */       arg.appString = appName;
/*     */     }
/*     */     
/* 122 */     TriggerEventsManger.getInstance().triggerEvent(new AppOrTitleChange(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void noticeClientChange()
/*     */   {
/* 130 */     SChangeTitleOrAppellationReq sChangeTitleOrAppellationReq = new SChangeTitleOrAppellationReq();
/* 131 */     sChangeTitleOrAppellationReq.changetype = this.changeType;
/* 132 */     sChangeTitleOrAppellationReq.changeid = this.id;
/*     */     
/* 134 */     OnlineManager.getInstance().send(this.roleId, sChangeTitleOrAppellationReq);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean changeActiveTitle(TitleAppellation xTitleAppellation)
/*     */   {
/* 142 */     if (xTitleAppellation.getActivetitle() == this.id)
/*     */     {
/* 144 */       GameServer.logger().info(String.format("[title]PChangeTitleOrAppellationReq.changeActiveTitle@ already actived!|roleId=%d|id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id) }));
/*     */       
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     long timeOut = 0L;
/* 152 */     boolean findTitle = false;
/* 153 */     for (TitleInfo xTitleInfo : xTitleAppellation.getOwntitle())
/*     */     {
/* 155 */       if (xTitleInfo.getTitleid() == this.id)
/*     */       {
/* 157 */         findTitle = true;
/* 158 */         timeOut = xTitleInfo.getTimeout();
/* 159 */         break;
/*     */       }
/*     */     }
/* 162 */     if (this.id != 0)
/*     */     {
/* 164 */       if (!findTitle)
/*     */       {
/* 166 */         GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.changeActiveTitle@ not own this id!|roleId=%d|id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id) }));
/*     */         
/*     */ 
/*     */ 
/* 170 */         return false;
/*     */       }
/* 172 */       if (timeOut != 0L)
/*     */       {
/* 174 */         if (timeOut < DateTimeUtils.getCurrTimeInMillis())
/*     */         {
/* 176 */           GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.changeActiveTitle@ id time out!|roleId=%d|id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id) }));
/*     */           
/*     */ 
/*     */ 
/* 180 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 184 */     xTitleAppellation.setActivetitle(this.id);
/* 185 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean changeActiveAppellation(TitleAppellation xTitleAppellation)
/*     */   {
/* 193 */     int oldAppellationId = xTitleAppellation.getActiveappellation();
/*     */     
/* 195 */     if (!checkAppellation(xTitleAppellation))
/*     */     {
/* 197 */       return false;
/*     */     }
/* 199 */     xTitleAppellation.setActiveappellation(this.id);
/*     */     
/*     */ 
/* 202 */     checkProChange(oldAppellationId);
/* 203 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkProChange(int oldAppellationId)
/*     */   {
/* 214 */     if (this.id == oldAppellationId)
/*     */     {
/* 216 */       return;
/*     */     }
/*     */     
/* 219 */     Map<Integer, Integer> propertyMapNew = TitleManager.getPropertyMap(this.id);
/* 220 */     Map<Integer, Integer> propertyMapOld = TitleManager.getPropertyMap(oldAppellationId);
/*     */     
/* 222 */     if ((propertyMapOld.size() > 0) && (propertyMapNew.size() > 0))
/*     */     {
/* 224 */       SNewPropertyReplaceReq sNewPropertyReplaceReq = new SNewPropertyReplaceReq();
/* 225 */       sNewPropertyReplaceReq.appellationidnew = this.id;
/* 226 */       sNewPropertyReplaceReq.appellationidold = oldAppellationId;
/*     */       
/* 228 */       OnlineManager.getInstance().send(this.roleId, sNewPropertyReplaceReq);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkAppellation(TitleAppellation xTitleAppellation)
/*     */   {
/* 239 */     if (this.id == 0)
/*     */     {
/* 241 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 245 */     AppellationInfo xAppellationInfo = (AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(this.id));
/* 246 */     if (xAppellationInfo == null)
/*     */     {
/* 248 */       GameServer.logger().error(String.format("[title]PChangeTitleOrAppellationReq.checkAppellation@ not own this id!|roleId=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */       
/*     */ 
/*     */ 
/* 252 */       return false;
/*     */     }
/* 254 */     long timeOut = 0L;
/* 255 */     timeOut = xAppellationInfo.getTimeout();
/*     */     
/* 257 */     if (timeOut != 0L)
/*     */     {
/* 259 */       if (timeOut < DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/* 261 */         GameServer.logger().info(String.format("[title]PChangeTitleOrAppellationReq.checkAppellation@ id out time!|roleId=%d|id=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.id), Integer.valueOf(this.changeType) }));
/*     */         
/*     */ 
/*     */ 
/* 265 */         return false;
/*     */       }
/*     */     }
/* 268 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PChangeTitleOrAppellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */