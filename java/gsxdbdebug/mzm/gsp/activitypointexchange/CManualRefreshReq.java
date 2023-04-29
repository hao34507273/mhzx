/*     */ package mzm.gsp.activitypointexchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.activitypointexchange.main.PCManualRefreshReq;
/*     */ 
/*     */ 
/*     */ public class CManualRefreshReq
/*     */   extends __CManualRefreshReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624897;
/*     */   public int activityid;
/*     */   public int refreshcount;
/*     */   public long clientyuanbaocount;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCManualRefreshReq(roleId, this.activityid, this.refreshcount, this.clientyuanbaocount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12624897;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CManualRefreshReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CManualRefreshReq(int _activityid_, int _refreshcount_, long _clientyuanbaocount_)
/*     */   {
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.refreshcount = _refreshcount_;
/*  47 */     this.clientyuanbaocount = _clientyuanbaocount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.marshal(this.refreshcount);
/*  57 */     _os_.marshal(this.clientyuanbaocount);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activityid = _os_.unmarshal_int();
/*  63 */     this.refreshcount = _os_.unmarshal_int();
/*  64 */     this.clientyuanbaocount = _os_.unmarshal_long();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CManualRefreshReq)) {
/*  74 */       CManualRefreshReq _o_ = (CManualRefreshReq)_o1_;
/*  75 */       if (this.activityid != _o_.activityid) return false;
/*  76 */       if (this.refreshcount != _o_.refreshcount) return false;
/*  77 */       if (this.clientyuanbaocount != _o_.clientyuanbaocount) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.refreshcount;
/*  87 */     _h_ += (int)this.clientyuanbaocount;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.activityid).append(",");
/*  95 */     _sb_.append(this.refreshcount).append(",");
/*  96 */     _sb_.append(this.clientyuanbaocount).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CManualRefreshReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activityid - _o_.activityid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.refreshcount - _o_.refreshcount;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.clientyuanbaocount - _o_.clientyuanbaocount);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\CManualRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */