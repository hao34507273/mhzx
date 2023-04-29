/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import xdb.Executor;
/*     */ 
/*     */ public class DiscountAnnounce extends __DiscountAnnounce__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 8064;
/*     */   public ArrayList<MerchantDiscount> discount;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     Executor.getInstance().execute(new Runnable()
/*     */     {
/*     */       public void run() {}
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 8064;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DiscountAnnounce()
/*     */   {
/*  38 */     this.discount = new ArrayList();
/*  39 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public DiscountAnnounce(ArrayList<MerchantDiscount> _discount_, int _reserved1_, Octets _reserved2_) {
/*  43 */     this.discount = _discount_;
/*  44 */     this.reserved1 = _reserved1_;
/*  45 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (MerchantDiscount _v_ : this.discount)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.discount.size());
/*  56 */     for (MerchantDiscount _v_ : this.discount) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.reserved1);
/*  60 */     _os_.marshal(this.reserved2);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       MerchantDiscount _v_ = new MerchantDiscount();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.discount.add(_v_);
/*     */     }
/*  70 */     this.reserved1 = _os_.unmarshal_int();
/*  71 */     this.reserved2 = _os_.unmarshal_Octets();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof DiscountAnnounce)) {
/*  81 */       DiscountAnnounce _o_ = (DiscountAnnounce)_o1_;
/*  82 */       if (!this.discount.equals(_o_.discount)) return false;
/*  83 */       if (this.reserved1 != _o_.reserved1) return false;
/*  84 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.discount.hashCode();
/*  93 */     _h_ += this.reserved1;
/*  94 */     _h_ += this.reserved2.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.discount).append(",");
/* 102 */     _sb_.append(this.reserved1).append(",");
/* 103 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\DiscountAnnounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */