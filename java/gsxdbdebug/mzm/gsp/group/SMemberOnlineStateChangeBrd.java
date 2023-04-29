/*     */ package mzm.gsp.group;
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
/*     */ public class SMemberOnlineStateChangeBrd
/*     */   extends __SMemberOnlineStateChangeBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605219;
/*     */   public long groupid;
/*     */   public long memberid;
/*     */   public byte online_state;
/*     */   public long info_version;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605219;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMemberOnlineStateChangeBrd() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMemberOnlineStateChangeBrd(long _groupid_, long _memberid_, byte _online_state_, long _info_version_)
/*     */   {
/*  39 */     this.groupid = _groupid_;
/*  40 */     this.memberid = _memberid_;
/*  41 */     this.online_state = _online_state_;
/*  42 */     this.info_version = _info_version_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.groupid);
/*  51 */     _os_.marshal(this.memberid);
/*  52 */     _os_.marshal(this.online_state);
/*  53 */     _os_.marshal(this.info_version);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.groupid = _os_.unmarshal_long();
/*  59 */     this.memberid = _os_.unmarshal_long();
/*  60 */     this.online_state = _os_.unmarshal_byte();
/*  61 */     this.info_version = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SMemberOnlineStateChangeBrd)) {
/*  71 */       SMemberOnlineStateChangeBrd _o_ = (SMemberOnlineStateChangeBrd)_o1_;
/*  72 */       if (this.groupid != _o_.groupid) return false;
/*  73 */       if (this.memberid != _o_.memberid) return false;
/*  74 */       if (this.online_state != _o_.online_state) return false;
/*  75 */       if (this.info_version != _o_.info_version) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.groupid;
/*  84 */     _h_ += (int)this.memberid;
/*  85 */     _h_ += this.online_state;
/*  86 */     _h_ += (int)this.info_version;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.groupid).append(",");
/*  94 */     _sb_.append(this.memberid).append(",");
/*  95 */     _sb_.append(this.online_state).append(",");
/*  96 */     _sb_.append(this.info_version).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMemberOnlineStateChangeBrd _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.memberid - _o_.memberid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.online_state - _o_.online_state;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.info_version - _o_.info_version);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SMemberOnlineStateChangeBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */