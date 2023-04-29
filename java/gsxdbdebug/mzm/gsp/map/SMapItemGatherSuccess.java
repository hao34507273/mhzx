/*     */ package mzm.gsp.map;
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
/*     */ public class SMapItemGatherSuccess
/*     */   extends __SMapItemGatherSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590874;
/*     */   public int instanceid;
/*     */   public int itemid;
/*     */   public int num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590874;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMapItemGatherSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMapItemGatherSuccess(int _instanceid_, int _itemid_, int _num_)
/*     */   {
/*  38 */     this.instanceid = _instanceid_;
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.instanceid);
/*  49 */     _os_.marshal(this.itemid);
/*  50 */     _os_.marshal(this.num);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.instanceid = _os_.unmarshal_int();
/*  56 */     this.itemid = _os_.unmarshal_int();
/*  57 */     this.num = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMapItemGatherSuccess)) {
/*  67 */       SMapItemGatherSuccess _o_ = (SMapItemGatherSuccess)_o1_;
/*  68 */       if (this.instanceid != _o_.instanceid) return false;
/*  69 */       if (this.itemid != _o_.itemid) return false;
/*  70 */       if (this.num != _o_.num) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.instanceid;
/*  79 */     _h_ += this.itemid;
/*  80 */     _h_ += this.num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.instanceid).append(",");
/*  88 */     _sb_.append(this.itemid).append(",");
/*  89 */     _sb_.append(this.num).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapItemGatherSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.instanceid - _o_.instanceid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.itemid - _o_.itemid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.num - _o_.num;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapItemGatherSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */