/*     */ package mzm.gsp.market;
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
/*     */ public class SSearchEquipRes
/*     */   extends __SSearchEquipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601411;
/*     */   public EquipCondition condition;
/*     */   public int puborsell;
/*     */   public int pricesort;
/*     */   public PageItemInfo pageresult;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601411;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSearchEquipRes()
/*     */   {
/*  34 */     this.condition = new EquipCondition();
/*  35 */     this.pageresult = new PageItemInfo();
/*     */   }
/*     */   
/*     */   public SSearchEquipRes(EquipCondition _condition_, int _puborsell_, int _pricesort_, PageItemInfo _pageresult_) {
/*  39 */     this.condition = _condition_;
/*  40 */     this.puborsell = _puborsell_;
/*  41 */     this.pricesort = _pricesort_;
/*  42 */     this.pageresult = _pageresult_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.condition._validator_()) return false;
/*  47 */     if (!this.pageresult._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.condition);
/*  53 */     _os_.marshal(this.puborsell);
/*  54 */     _os_.marshal(this.pricesort);
/*  55 */     _os_.marshal(this.pageresult);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.condition.unmarshal(_os_);
/*  61 */     this.puborsell = _os_.unmarshal_int();
/*  62 */     this.pricesort = _os_.unmarshal_int();
/*  63 */     this.pageresult.unmarshal(_os_);
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SSearchEquipRes)) {
/*  73 */       SSearchEquipRes _o_ = (SSearchEquipRes)_o1_;
/*  74 */       if (!this.condition.equals(_o_.condition)) return false;
/*  75 */       if (this.puborsell != _o_.puborsell) return false;
/*  76 */       if (this.pricesort != _o_.pricesort) return false;
/*  77 */       if (!this.pageresult.equals(_o_.pageresult)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.condition.hashCode();
/*  86 */     _h_ += this.puborsell;
/*  87 */     _h_ += this.pricesort;
/*  88 */     _h_ += this.pageresult.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.condition).append(",");
/*  96 */     _sb_.append(this.puborsell).append(",");
/*  97 */     _sb_.append(this.pricesort).append(",");
/*  98 */     _sb_.append(this.pageresult).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSearchEquipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */