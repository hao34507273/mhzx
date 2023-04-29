/*     */ package mzm.gsp.lifeskill;
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
/*     */ public class SCookRes
/*     */   extends __SCookRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589066;
/*     */   public int costvigor;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589066;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SCookRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SCookRes(int _costvigor_, int _itemid_, int _itemnum_)
/*     */   {
/*  38 */     this.costvigor = _costvigor_;
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.costvigor);
/*  49 */     _os_.marshal(this.itemid);
/*  50 */     _os_.marshal(this.itemnum);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.costvigor = _os_.unmarshal_int();
/*  56 */     this.itemid = _os_.unmarshal_int();
/*  57 */     this.itemnum = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SCookRes)) {
/*  67 */       SCookRes _o_ = (SCookRes)_o1_;
/*  68 */       if (this.costvigor != _o_.costvigor) return false;
/*  69 */       if (this.itemid != _o_.itemid) return false;
/*  70 */       if (this.itemnum != _o_.itemnum) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.costvigor;
/*  79 */     _h_ += this.itemid;
/*  80 */     _h_ += this.itemnum;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.costvigor).append(",");
/*  88 */     _sb_.append(this.itemid).append(",");
/*  89 */     _sb_.append(this.itemnum).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SCookRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.costvigor - _o_.costvigor;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.itemid - _o_.itemid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.itemnum - _o_.itemnum;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\SCookRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */