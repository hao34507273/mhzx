/*     */ package mzm.gsp.wing;
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
/*     */ public class SSyncAllWing
/*     */   extends __SSyncAllWing__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596487;
/*     */   public ArrayList<WingInfo> winglist;
/*     */   public int curindex;
/*     */   public int isshowwing;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596487;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncAllWing()
/*     */   {
/*  35 */     this.winglist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncAllWing(ArrayList<WingInfo> _winglist_, int _curindex_, int _isshowwing_) {
/*  39 */     this.winglist = _winglist_;
/*  40 */     this.curindex = _curindex_;
/*  41 */     this.isshowwing = _isshowwing_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (WingInfo _v_ : this.winglist)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.compact_uint32(this.winglist.size());
/*  52 */     for (WingInfo _v_ : this.winglist) {
/*  53 */       _os_.marshal(_v_);
/*     */     }
/*  55 */     _os_.marshal(this.curindex);
/*  56 */     _os_.marshal(this.isshowwing);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       WingInfo _v_ = new WingInfo();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.winglist.add(_v_);
/*     */     }
/*  66 */     this.curindex = _os_.unmarshal_int();
/*  67 */     this.isshowwing = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSyncAllWing)) {
/*  77 */       SSyncAllWing _o_ = (SSyncAllWing)_o1_;
/*  78 */       if (!this.winglist.equals(_o_.winglist)) return false;
/*  79 */       if (this.curindex != _o_.curindex) return false;
/*  80 */       if (this.isshowwing != _o_.isshowwing) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.winglist.hashCode();
/*  89 */     _h_ += this.curindex;
/*  90 */     _h_ += this.isshowwing;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.winglist).append(",");
/*  98 */     _sb_.append(this.curindex).append(",");
/*  99 */     _sb_.append(this.isshowwing).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SSyncAllWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */