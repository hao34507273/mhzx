/*     */ package mzm.gsp.masswedding;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMassWeddingSignUpInfo
/*     */   extends __SMassWeddingSignUpInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604934;
/*     */   public ArrayList<SignUpInfo> signupinfos;
/*     */   public int myprice;
/*     */   public int rank;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604934;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMassWeddingSignUpInfo()
/*     */   {
/*  35 */     this.signupinfos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SMassWeddingSignUpInfo(ArrayList<SignUpInfo> _signupinfos_, int _myprice_, int _rank_) {
/*  39 */     this.signupinfos = _signupinfos_;
/*  40 */     this.myprice = _myprice_;
/*  41 */     this.rank = _rank_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (SignUpInfo _v_ : this.signupinfos)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.signupinfos.size());
/*  52 */     for (SignUpInfo _v_ : this.signupinfos) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.myprice);
/*  56 */     _os_.marshal(this.rank);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       SignUpInfo _v_ = new SignUpInfo();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.signupinfos.add(_v_);
/*     */     }
/*  66 */     this.myprice = _os_.unmarshal_int();
/*  67 */     this.rank = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SMassWeddingSignUpInfo)) {
/*  77 */       SMassWeddingSignUpInfo _o_ = (SMassWeddingSignUpInfo)_o1_;
/*  78 */       if (!this.signupinfos.equals(_o_.signupinfos)) return false;
/*  79 */       if (this.myprice != _o_.myprice) return false;
/*  80 */       if (this.rank != _o_.rank) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.signupinfos.hashCode();
/*  89 */     _h_ += this.myprice;
/*  90 */     _h_ += this.rank;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.signupinfos).append(",");
/*  98 */     _sb_.append(this.myprice).append(",");
/*  99 */     _sb_.append(this.rank).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SMassWeddingSignUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */