/*     */ package mzm.gsp.fashiondress;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
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
/*     */ public class SSyncThemeFashionDressUpdateInfo
/*     */   extends __SSyncThemeFashionDressUpdateInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603158;
/*     */   public HashSet<Integer> add_set;
/*     */   public HashSet<Integer> delete_set;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603158;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncThemeFashionDressUpdateInfo()
/*     */   {
/*  34 */     this.add_set = new HashSet();
/*  35 */     this.delete_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SSyncThemeFashionDressUpdateInfo(HashSet<Integer> _add_set_, HashSet<Integer> _delete_set_) {
/*  39 */     this.add_set = _add_set_;
/*  40 */     this.delete_set = _delete_set_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.add_set.size());
/*  49 */     for (Integer _v_ : this.add_set) {
/*  50 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  52 */     _os_.compact_uint32(this.delete_set.size());
/*  53 */     for (Integer _v_ : this.delete_set) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  62 */       int _v_ = _os_.unmarshal_int();
/*  63 */       this.add_set.add(Integer.valueOf(_v_));
/*     */     }
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.delete_set.add(Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SSyncThemeFashionDressUpdateInfo)) {
/*  79 */       SSyncThemeFashionDressUpdateInfo _o_ = (SSyncThemeFashionDressUpdateInfo)_o1_;
/*  80 */       if (!this.add_set.equals(_o_.add_set)) return false;
/*  81 */       if (!this.delete_set.equals(_o_.delete_set)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.add_set.hashCode();
/*  90 */     _h_ += this.delete_set.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.add_set).append(",");
/*  98 */     _sb_.append(this.delete_set).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\SSyncThemeFashionDressUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */