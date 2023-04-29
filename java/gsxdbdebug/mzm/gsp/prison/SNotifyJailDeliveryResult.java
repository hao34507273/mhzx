/*     */ package mzm.gsp.prison;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SNotifyJailDeliveryResult
/*     */   extends __SNotifyJailDeliveryResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620044;
/*     */   public static final int SUCCESS = 1;
/*     */   public static final int FAIL = 2;
/*     */   public int result;
/*     */   public ArrayList<Octets> namelist;
/*     */   public Octets name;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620044;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyJailDeliveryResult()
/*     */   {
/*  38 */     this.namelist = new ArrayList();
/*  39 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public SNotifyJailDeliveryResult(int _result_, ArrayList<Octets> _namelist_, Octets _name_) {
/*  43 */     this.result = _result_;
/*  44 */     this.namelist = _namelist_;
/*  45 */     this.name = _name_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.result);
/*  54 */     _os_.compact_uint32(this.namelist.size());
/*  55 */     for (Octets _v_ : this.namelist) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.marshal(this.name);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.result = _os_.unmarshal_int();
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  66 */       Octets _v_ = _os_.unmarshal_Octets();
/*  67 */       this.namelist.add(_v_);
/*     */     }
/*  69 */     this.name = _os_.unmarshal_Octets();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SNotifyJailDeliveryResult)) {
/*  79 */       SNotifyJailDeliveryResult _o_ = (SNotifyJailDeliveryResult)_o1_;
/*  80 */       if (this.result != _o_.result) return false;
/*  81 */       if (!this.namelist.equals(_o_.namelist)) return false;
/*  82 */       if (!this.name.equals(_o_.name)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.result;
/*  91 */     _h_ += this.namelist.hashCode();
/*  92 */     _h_ += this.name.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.result).append(",");
/* 100 */     _sb_.append(this.namelist).append(",");
/* 101 */     _sb_.append("B").append(this.name.size()).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SNotifyJailDeliveryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */