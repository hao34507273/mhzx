/*     */ package mzm.gsp.marriage;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFriendSendGift
/*     */   extends __SFriendSendGift__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599833;
/*     */   public long roleid;
/*     */   public int giftid;
/*     */   public int timesec;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599833;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFriendSendGift() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFriendSendGift(long _roleid_, int _giftid_, int _timesec_)
/*     */   {
/*  38 */     this.roleid = _roleid_;
/*  39 */     this.giftid = _giftid_;
/*  40 */     this.timesec = _timesec_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.giftid);
/*  50 */     _os_.marshal(this.timesec);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.giftid = _os_.unmarshal_int();
/*  57 */     this.timesec = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFriendSendGift)) {
/*  67 */       SFriendSendGift _o_ = (SFriendSendGift)_o1_;
/*  68 */       if (this.roleid != _o_.roleid) return false;
/*  69 */       if (this.giftid != _o_.giftid) return false;
/*  70 */       if (this.timesec != _o_.timesec) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.roleid;
/*  79 */     _h_ += this.giftid;
/*  80 */     _h_ += this.timesec;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.roleid).append(",");
/*  88 */     _sb_.append(this.giftid).append(",");
/*  89 */     _sb_.append(this.timesec).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFriendSendGift _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.giftid - _o_.giftid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.timesec - _o_.timesec;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SFriendSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */