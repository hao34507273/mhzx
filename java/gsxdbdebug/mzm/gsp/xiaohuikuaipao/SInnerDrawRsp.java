/*     */ package mzm.gsp.xiaohuikuaipao;
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
/*     */ public class SInnerDrawRsp
/*     */   extends __SInnerDrawRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12622853;
/*     */   public int activityid;
/*     */   public InnerInfo innerinfo;
/*     */   public AwardInfo awardinfo;
/*     */   public int hitindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12622853;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SInnerDrawRsp()
/*     */   {
/*  34 */     this.innerinfo = new InnerInfo();
/*  35 */     this.awardinfo = new AwardInfo();
/*     */   }
/*     */   
/*     */   public SInnerDrawRsp(int _activityid_, InnerInfo _innerinfo_, AwardInfo _awardinfo_, int _hitindex_) {
/*  39 */     this.activityid = _activityid_;
/*  40 */     this.innerinfo = _innerinfo_;
/*  41 */     this.awardinfo = _awardinfo_;
/*  42 */     this.hitindex = _hitindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.innerinfo._validator_()) return false;
/*  47 */     if (!this.awardinfo._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.innerinfo);
/*  54 */     _os_.marshal(this.awardinfo);
/*  55 */     _os_.marshal(this.hitindex);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activityid = _os_.unmarshal_int();
/*  61 */     this.innerinfo.unmarshal(_os_);
/*  62 */     this.awardinfo.unmarshal(_os_);
/*  63 */     this.hitindex = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SInnerDrawRsp)) {
/*  73 */       SInnerDrawRsp _o_ = (SInnerDrawRsp)_o1_;
/*  74 */       if (this.activityid != _o_.activityid) return false;
/*  75 */       if (!this.innerinfo.equals(_o_.innerinfo)) return false;
/*  76 */       if (!this.awardinfo.equals(_o_.awardinfo)) return false;
/*  77 */       if (this.hitindex != _o_.hitindex) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activityid;
/*  86 */     _h_ += this.innerinfo.hashCode();
/*  87 */     _h_ += this.awardinfo.hashCode();
/*  88 */     _h_ += this.hitindex;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activityid).append(",");
/*  96 */     _sb_.append(this.innerinfo).append(",");
/*  97 */     _sb_.append(this.awardinfo).append(",");
/*  98 */     _sb_.append(this.hitindex).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SInnerDrawRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */