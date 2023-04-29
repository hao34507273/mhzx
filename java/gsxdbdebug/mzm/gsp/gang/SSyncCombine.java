/*     */ package mzm.gsp.gang;
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
/*     */ public class SSyncCombine
/*     */   extends __SSyncCombine__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589980;
/*     */   public CombineGang target_gang;
/*     */   public long timestamp;
/*     */   public ArrayList<Long> applicants;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589980;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncCombine()
/*     */   {
/*  35 */     this.target_gang = new CombineGang();
/*  36 */     this.timestamp = -1L;
/*  37 */     this.applicants = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncCombine(CombineGang _target_gang_, long _timestamp_, ArrayList<Long> _applicants_) {
/*  41 */     this.target_gang = _target_gang_;
/*  42 */     this.timestamp = _timestamp_;
/*  43 */     this.applicants = _applicants_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.target_gang._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.target_gang);
/*  53 */     _os_.marshal(this.timestamp);
/*  54 */     _os_.compact_uint32(this.applicants.size());
/*  55 */     for (Long _v_ : this.applicants) {
/*  56 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.target_gang.unmarshal(_os_);
/*  63 */     this.timestamp = _os_.unmarshal_long();
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  66 */       long _v_ = _os_.unmarshal_long();
/*  67 */       this.applicants.add(Long.valueOf(_v_));
/*     */     }
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSyncCombine)) {
/*  78 */       SSyncCombine _o_ = (SSyncCombine)_o1_;
/*  79 */       if (!this.target_gang.equals(_o_.target_gang)) return false;
/*  80 */       if (this.timestamp != _o_.timestamp) return false;
/*  81 */       if (!this.applicants.equals(_o_.applicants)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.target_gang.hashCode();
/*  90 */     _h_ += (int)this.timestamp;
/*  91 */     _h_ += this.applicants.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.target_gang).append(",");
/*  99 */     _sb_.append(this.timestamp).append(",");
/* 100 */     _sb_.append(this.applicants).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */