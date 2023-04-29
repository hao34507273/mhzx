/*     */ package mzm.gsp.item;
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
/*     */ public class SEquipMakeYunanbaoPriceRes
/*     */   extends __SEquipMakeYunanbaoPriceRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584775;
/*     */   public int eqpid;
/*     */   public int clientneedyuanbao;
/*     */   public int serverneedyuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584775;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SEquipMakeYunanbaoPriceRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SEquipMakeYunanbaoPriceRes(int _eqpid_, int _clientneedyuanbao_, int _serverneedyuanbao_)
/*     */   {
/*  36 */     this.eqpid = _eqpid_;
/*  37 */     this.clientneedyuanbao = _clientneedyuanbao_;
/*  38 */     this.serverneedyuanbao = _serverneedyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.eqpid);
/*  47 */     _os_.marshal(this.clientneedyuanbao);
/*  48 */     _os_.marshal(this.serverneedyuanbao);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.eqpid = _os_.unmarshal_int();
/*  54 */     this.clientneedyuanbao = _os_.unmarshal_int();
/*  55 */     this.serverneedyuanbao = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SEquipMakeYunanbaoPriceRes)) {
/*  65 */       SEquipMakeYunanbaoPriceRes _o_ = (SEquipMakeYunanbaoPriceRes)_o1_;
/*  66 */       if (this.eqpid != _o_.eqpid) return false;
/*  67 */       if (this.clientneedyuanbao != _o_.clientneedyuanbao) return false;
/*  68 */       if (this.serverneedyuanbao != _o_.serverneedyuanbao) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.eqpid;
/*  77 */     _h_ += this.clientneedyuanbao;
/*  78 */     _h_ += this.serverneedyuanbao;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.eqpid).append(",");
/*  86 */     _sb_.append(this.clientneedyuanbao).append(",");
/*  87 */     _sb_.append(this.serverneedyuanbao).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SEquipMakeYunanbaoPriceRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.eqpid - _o_.eqpid;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.clientneedyuanbao - _o_.clientneedyuanbao;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.serverneedyuanbao - _o_.serverneedyuanbao;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipMakeYunanbaoPriceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */