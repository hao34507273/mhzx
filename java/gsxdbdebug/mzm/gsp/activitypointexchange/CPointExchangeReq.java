/*     */ package mzm.gsp.activitypointexchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.activitypointexchange.main.PCPointExchangeReq;
/*     */ 
/*     */ 
/*     */ public class CPointExchangeReq
/*     */   extends __CPointExchangeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12624907;
/*     */   public int activityid;
/*     */   public int goodscfgid;
/*     */   public int count;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCPointExchangeReq(roleId, this.activityid, this.goodscfgid, this.count));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12624907;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CPointExchangeReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CPointExchangeReq(int _activityid_, int _goodscfgid_, int _count_)
/*     */   {
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.goodscfgid = _goodscfgid_;
/*  47 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.marshal(this.goodscfgid);
/*  57 */     _os_.marshal(this.count);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activityid = _os_.unmarshal_int();
/*  63 */     this.goodscfgid = _os_.unmarshal_int();
/*  64 */     this.count = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CPointExchangeReq)) {
/*  74 */       CPointExchangeReq _o_ = (CPointExchangeReq)_o1_;
/*  75 */       if (this.activityid != _o_.activityid) return false;
/*  76 */       if (this.goodscfgid != _o_.goodscfgid) return false;
/*  77 */       if (this.count != _o_.count) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.goodscfgid;
/*  87 */     _h_ += this.count;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.activityid).append(",");
/*  95 */     _sb_.append(this.goodscfgid).append(",");
/*  96 */     _sb_.append(this.count).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPointExchangeReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activityid - _o_.activityid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.goodscfgid - _o_.goodscfgid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.count - _o_.count;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\CPointExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */