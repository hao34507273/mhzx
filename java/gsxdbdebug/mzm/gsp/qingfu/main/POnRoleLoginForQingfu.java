/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncCashInfo;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import openau.DataBetweenAuanyAndOthersReq;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import xbean.AuAnyCheckOrderInfo;
/*     */ import xbean.CheckOrderInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Checkorders;
/*     */ import xtable.Qingfu;
/*     */ import xtable.User2auanycheckorders;
/*     */ 
/*     */ public class POnRoleLoginForQingfu extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   
/*     */   public POnRoleLoginForQingfu(String userid, long roleid)
/*     */   {
/*  29 */     this.userid = userid;
/*  30 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     lock(Lockeys.get(xtable.User.getTable(), this.userid));
/*  38 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*  41 */     SSyncCashInfo core = new SSyncCashInfo();
/*     */     
/*  43 */     xbean.QingfuInfo xQingfuInfo = Qingfu.get(this.userid);
/*  44 */     if (xQingfuInfo == null)
/*     */     {
/*  46 */       xQingfuInfo = Pod.newQingfuInfo();
/*  47 */       Qingfu.add(this.userid, xQingfuInfo);
/*     */     }
/*     */     else
/*     */     {
/*  51 */       QingfuManager.boxSSyncCashInfo(xQingfuInfo, core);
/*     */     }
/*     */     
/*  54 */     OnlineManager.getInstance().send(this.roleid, core);
/*     */     
/*  56 */     if (!QingfuManager.isMidasMode)
/*     */     {
/*  58 */       return true;
/*     */     }
/*     */     
/*  61 */     UserAuAnyCheckOrders xUserAuAnyCheckOrders = User2auanycheckorders.get(this.userid);
/*  62 */     if (xUserAuAnyCheckOrders == null)
/*     */     {
/*  64 */       xUserAuAnyCheckOrders = Pod.newUserAuAnyCheckOrders();
/*  65 */       QingfuManager.initUserAuanyCheckOrdersBean(xUserAuAnyCheckOrders);
/*  66 */       User2auanycheckorders.add(this.userid, xUserAuAnyCheckOrders);
/*     */     }
/*     */     else
/*     */     {
/*  70 */       long magicNum = QingfuManager.magicNum;
/*  71 */       if (xUserAuAnyCheckOrders.getMagic_num() != magicNum)
/*     */       {
/*  73 */         xUserAuAnyCheckOrders.setMagic_num(magicNum);
/*     */         
/*  75 */         int sn = xUserAuAnyCheckOrders.getSn();
/*  76 */         List<AuAnyCheckOrderInfo> xAuAnyCheckOrderInfos = xUserAuAnyCheckOrders.getOrders();
/*  77 */         int size = xAuAnyCheckOrderInfos.size();
/*  78 */         if (size > 0)
/*     */         {
/*  80 */           int index = sn == size ? sn - 1 : sn;
/*  81 */           String billno = ((AuAnyCheckOrderInfo)xAuAnyCheckOrderInfos.get(index)).getOrderid();
/*  82 */           CheckOrderInfo xCheckOrderInfo = Checkorders.get(billno);
/*  83 */           if (xCheckOrderInfo == null)
/*     */           {
/*  85 */             GameServer.logger().error(String.format("[qingfu]POnRoleLoginForQingfu.processImp@check order info is null|roleid=%d|userid=%s|billno=%s|sn=%d", new Object[] { Long.valueOf(this.roleid), this.userid, billno, Integer.valueOf(sn) }));
/*     */             
/*     */ 
/*     */ 
/*  89 */             return false;
/*     */           }
/*     */           
/*  92 */           int confirmStatus = xCheckOrderInfo.getStatus();
/*  93 */           if (confirmStatus == 4)
/*     */           {
/*  95 */             xCheckOrderInfo.setStatus(1);
/*     */           }
/*     */           
/*  98 */           GameServer.logger().info(String.format("[qingfu]POnRoleLoginForQingfu.processImp@confirm order info|roleid=%d|userid=%s|billno=%s|sn=%d|check_status=%d|confirm_status=%d|order_flags=%d", new Object[] { Long.valueOf(this.roleid), this.userid, billno, Integer.valueOf(sn), Integer.valueOf(xUserAuAnyCheckOrders.getCheck_status()), Integer.valueOf(confirmStatus), Integer.valueOf(xCheckOrderInfo.getFlags()) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */     DataBetweenAuanyAndOthersReq req = new DataBetweenAuanyAndOthersReq();
/* 108 */     req.direction = 3;
/* 109 */     req.account = Octets.wrap(this.userid, "utf-8");
/* 110 */     req.zoneid = CommonUtils.getZoneId(this.userid);
/* 111 */     req.roleid = this.roleid;
/* 112 */     req.reqtype = 512;
/*     */     
/* 114 */     JSONObject jsonObj = new JSONObject();
/* 115 */     jsonObj.put("appid", QingfuManager.getAuanyAppId(this.userid));
/* 116 */     int gsgsn = xUserAuAnyCheckOrders.getOffset() + xUserAuAnyCheckOrders.getSn();
/*     */     
/* 118 */     jsonObj.put("gs_gsn", gsgsn);
/* 119 */     jsonObj.put("fake_plat", Onlines.getInstance().findFakePlat(this.userid));
/*     */     
/*     */ 
/* 122 */     jsonObj.put("device_plat_id", Onlines.getInstance().findPlatid(this.userid));
/* 123 */     jsonObj.put("role_name", mzm.gsp.role.main.RoleInterface.getName(this.roleid));
/* 124 */     req.reqdata = Octets.wrap(jsonObj.toString(), "utf-8");
/*     */     
/* 126 */     QingfuManager.notifyAuany(this.userid, req);
/*     */     
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLoginForQingfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */