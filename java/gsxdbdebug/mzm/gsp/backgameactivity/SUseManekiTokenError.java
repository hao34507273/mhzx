/*     */ package mzm.gsp.backgameactivity;
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
/*     */ public class SUseManekiTokenError
/*     */   extends __SUseManekiTokenError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620566;
/*     */   public static final int PRESENT_YUAN_BAO_FAIL = 1;
/*     */   public int errorcode;
/*     */   public int activityid;
/*     */   public int manekitokencfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12620566;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseManekiTokenError() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseManekiTokenError(int _errorcode_, int _activityid_, int _manekitokencfgid_)
/*     */   {
/*  38 */     this.errorcode = _errorcode_;
/*  39 */     this.activityid = _activityid_;
/*  40 */     this.manekitokencfgid = _manekitokencfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.errorcode);
/*  49 */     _os_.marshal(this.activityid);
/*  50 */     _os_.marshal(this.manekitokencfgid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.errorcode = _os_.unmarshal_int();
/*  56 */     this.activityid = _os_.unmarshal_int();
/*  57 */     this.manekitokencfgid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUseManekiTokenError)) {
/*  67 */       SUseManekiTokenError _o_ = (SUseManekiTokenError)_o1_;
/*  68 */       if (this.errorcode != _o_.errorcode) return false;
/*  69 */       if (this.activityid != _o_.activityid) return false;
/*  70 */       if (this.manekitokencfgid != _o_.manekitokencfgid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.errorcode;
/*  79 */     _h_ += this.activityid;
/*  80 */     _h_ += this.manekitokencfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.errorcode).append(",");
/*  88 */     _sb_.append(this.activityid).append(",");
/*  89 */     _sb_.append(this.manekitokencfgid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseManekiTokenError _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.errorcode - _o_.errorcode;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.activityid - _o_.activityid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.manekitokencfgid - _o_.manekitokencfgid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SUseManekiTokenError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */