/*     */ package mzm.gsp.activity;
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
/*     */ 
/*     */ public class SQuestionIsOver
/*     */   extends __SQuestionIsOver__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587581;
/*     */   public ArrayList<RoleAwardData> nbawardinfo;
/*     */   public ArrayList<RoleAwardData> normalawardinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587581;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SQuestionIsOver()
/*     */   {
/*  34 */     this.nbawardinfo = new ArrayList();
/*  35 */     this.normalawardinfo = new ArrayList();
/*     */   }
/*     */   
/*     */   public SQuestionIsOver(ArrayList<RoleAwardData> _nbawardinfo_, ArrayList<RoleAwardData> _normalawardinfo_) {
/*  39 */     this.nbawardinfo = _nbawardinfo_;
/*  40 */     this.normalawardinfo = _normalawardinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (RoleAwardData _v_ : this.nbawardinfo)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     for (RoleAwardData _v_ : this.normalawardinfo)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.nbawardinfo.size());
/*  53 */     for (RoleAwardData _v_ : this.nbawardinfo) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.compact_uint32(this.normalawardinfo.size());
/*  57 */     for (RoleAwardData _v_ : this.normalawardinfo) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       RoleAwardData _v_ = new RoleAwardData();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.nbawardinfo.add(_v_);
/*     */     }
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       RoleAwardData _v_ = new RoleAwardData();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.normalawardinfo.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SQuestionIsOver)) {
/*  83 */       SQuestionIsOver _o_ = (SQuestionIsOver)_o1_;
/*  84 */       if (!this.nbawardinfo.equals(_o_.nbawardinfo)) return false;
/*  85 */       if (!this.normalawardinfo.equals(_o_.normalawardinfo)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.nbawardinfo.hashCode();
/*  94 */     _h_ += this.normalawardinfo.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.nbawardinfo).append(",");
/* 102 */     _sb_.append(this.normalawardinfo).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SQuestionIsOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */