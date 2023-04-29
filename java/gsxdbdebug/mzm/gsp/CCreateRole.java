/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import gnet.link.Dispatch;
/*     */ import gnet.link.Onlines;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.online.main.PCreateRole;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CCreateRole extends __CCreateRole__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590087;
/*     */   public CreateRoleArg roleinfo;
/*     */   
/*     */   private boolean sendRes(int result)
/*     */   {
/*  17 */     SCreateRole crr = new SCreateRole();
/*  18 */     crr.result = result;
/*  19 */     return Onlines.getInstance().sendResponse(this, crr);
/*     */   }
/*     */   
/*     */   protected void process()
/*     */   {
/*  24 */     if ((getContext() instanceof Dispatch)) {
/*  25 */       final String userid = ((Dispatch)getContext()).userid.getString("UTF-8");
/*  26 */       if (!GameServerInfoManager.canLoginSourceServer(userid)) {
/*  27 */         return;
/*     */       }
/*  29 */       LoginManager.getInstance().addLogicRunnable(userid, new mzm.gsp.util.LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/*  33 */           SCreateRole crr = null;
/*  34 */           GameServer.logger().info("create role process, userid=" + userid);
/*  35 */           PCreateRole p = new PCreateRole(userid, CCreateRole.this.roleinfo, CCreateRole.this);
/*     */           try
/*     */           {
/*  38 */             p.call();
/*  39 */             crr = p.getRes();
/*     */           }
/*     */           catch (Exception ex) {
/*  42 */             GameServer.logger().error("create role fail", ex);
/*  43 */             CCreateRole.this.sendRes(7);
/*  44 */             return;
/*     */           }
/*     */           
/*  47 */           if (crr == null) {
/*  48 */             CCreateRole.this.sendRes(7);
/*     */           }
/*  50 */           Onlines.getInstance().sendResponse(CCreateRole.this, crr);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  61 */     return 12590087;
/*     */   }
/*     */   
/*     */ 
/*     */   public CCreateRole()
/*     */   {
/*  67 */     this.roleinfo = new CreateRoleArg();
/*     */   }
/*     */   
/*     */   public CCreateRole(CreateRoleArg _roleinfo_) {
/*  71 */     this.roleinfo = _roleinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  75 */     if (!this.roleinfo._validator_()) return false;
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  80 */     _os_.marshal(this.roleinfo);
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  85 */     this.roleinfo.unmarshal(_os_);
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof CCreateRole)) {
/*  95 */       CCreateRole _o_ = (CCreateRole)_o1_;
/*  96 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.roleinfo.hashCode();
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.roleinfo).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\CCreateRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */