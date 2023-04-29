/*     */ package mzm.gsp.menpaistar;
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
/*     */ public class SVoteSuccess
/*     */   extends __SVoteSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612370;
/*     */   public long target_roleid;
/*     */   public int vote_num;
/*     */   public int gold;
/*     */   public int point;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612370;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SVoteSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SVoteSuccess(long _target_roleid_, int _vote_num_, int _gold_, int _point_)
/*     */   {
/*  39 */     this.target_roleid = _target_roleid_;
/*  40 */     this.vote_num = _vote_num_;
/*  41 */     this.gold = _gold_;
/*  42 */     this.point = _point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.target_roleid);
/*  51 */     _os_.marshal(this.vote_num);
/*  52 */     _os_.marshal(this.gold);
/*  53 */     _os_.marshal(this.point);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.target_roleid = _os_.unmarshal_long();
/*  59 */     this.vote_num = _os_.unmarshal_int();
/*  60 */     this.gold = _os_.unmarshal_int();
/*  61 */     this.point = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SVoteSuccess)) {
/*  71 */       SVoteSuccess _o_ = (SVoteSuccess)_o1_;
/*  72 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  73 */       if (this.vote_num != _o_.vote_num) return false;
/*  74 */       if (this.gold != _o_.gold) return false;
/*  75 */       if (this.point != _o_.point) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.target_roleid;
/*  84 */     _h_ += this.vote_num;
/*  85 */     _h_ += this.gold;
/*  86 */     _h_ += this.point;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.target_roleid).append(",");
/*  94 */     _sb_.append(this.vote_num).append(",");
/*  95 */     _sb_.append(this.gold).append(",");
/*  96 */     _sb_.append(this.point).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SVoteSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.vote_num - _o_.vote_num;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.gold - _o_.gold;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.point - _o_.point;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SVoteSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */