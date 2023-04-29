/*     */ package mzm.gsp.award;
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
/*     */ public class STakeSelectAwardRes
/*     */   extends __STakeSelectAwardRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12583434;
/*     */   public long awarduuid;
/*     */   public int index;
/*     */   public long roleid;
/*     */   public MultiRoleAwardBean awardbean;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12583434;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STakeSelectAwardRes()
/*     */   {
/*  36 */     this.awardbean = new MultiRoleAwardBean();
/*     */   }
/*     */   
/*     */   public STakeSelectAwardRes(long _awarduuid_, int _index_, long _roleid_, MultiRoleAwardBean _awardbean_) {
/*  40 */     this.awarduuid = _awarduuid_;
/*  41 */     this.index = _index_;
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.awardbean = _awardbean_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.awardbean._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.awarduuid);
/*  53 */     _os_.marshal(this.index);
/*  54 */     _os_.marshal(this.roleid);
/*  55 */     _os_.marshal(this.awardbean);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.awarduuid = _os_.unmarshal_long();
/*  61 */     this.index = _os_.unmarshal_int();
/*  62 */     this.roleid = _os_.unmarshal_long();
/*  63 */     this.awardbean.unmarshal(_os_);
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof STakeSelectAwardRes)) {
/*  73 */       STakeSelectAwardRes _o_ = (STakeSelectAwardRes)_o1_;
/*  74 */       if (this.awarduuid != _o_.awarduuid) return false;
/*  75 */       if (this.index != _o_.index) return false;
/*  76 */       if (this.roleid != _o_.roleid) return false;
/*  77 */       if (!this.awardbean.equals(_o_.awardbean)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.awarduuid;
/*  86 */     _h_ += this.index;
/*  87 */     _h_ += (int)this.roleid;
/*  88 */     _h_ += this.awardbean.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.awarduuid).append(",");
/*  96 */     _sb_.append(this.index).append(",");
/*  97 */     _sb_.append(this.roleid).append(",");
/*  98 */     _sb_.append(this.awardbean).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STakeSelectAwardRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = Long.signum(this.awarduuid - _o_.awarduuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.index - _o_.index;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.awardbean.compareTo(_o_.awardbean);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\STakeSelectAwardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */