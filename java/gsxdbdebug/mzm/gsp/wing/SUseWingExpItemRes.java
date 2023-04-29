/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SUseWingExpItemRes
/*     */   extends __SUseWingExpItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596492;
/*     */   public int index;
/*     */   public ArrayList<WingProperty> propertylist;
/*     */   public int exp;
/*     */   public int oldlevel;
/*     */   public int newlevel;
/*     */   public int addexp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596492;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseWingExpItemRes()
/*     */   {
/*  36 */     this.propertylist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SUseWingExpItemRes(int _index_, ArrayList<WingProperty> _propertylist_, int _exp_, int _oldlevel_, int _newlevel_, int _addexp_) {
/*  40 */     this.index = _index_;
/*  41 */     this.propertylist = _propertylist_;
/*  42 */     this.exp = _exp_;
/*  43 */     this.oldlevel = _oldlevel_;
/*  44 */     this.newlevel = _newlevel_;
/*  45 */     this.addexp = _addexp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (WingProperty _v_ : this.propertylist)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.index);
/*  56 */     _os_.compact_uint32(this.propertylist.size());
/*  57 */     for (WingProperty _v_ : this.propertylist) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     _os_.marshal(this.exp);
/*  61 */     _os_.marshal(this.oldlevel);
/*  62 */     _os_.marshal(this.newlevel);
/*  63 */     _os_.marshal(this.addexp);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.index = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       WingProperty _v_ = new WingProperty();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.propertylist.add(_v_);
/*     */     }
/*  74 */     this.exp = _os_.unmarshal_int();
/*  75 */     this.oldlevel = _os_.unmarshal_int();
/*  76 */     this.newlevel = _os_.unmarshal_int();
/*  77 */     this.addexp = _os_.unmarshal_int();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SUseWingExpItemRes)) {
/*  87 */       SUseWingExpItemRes _o_ = (SUseWingExpItemRes)_o1_;
/*  88 */       if (this.index != _o_.index) return false;
/*  89 */       if (!this.propertylist.equals(_o_.propertylist)) return false;
/*  90 */       if (this.exp != _o_.exp) return false;
/*  91 */       if (this.oldlevel != _o_.oldlevel) return false;
/*  92 */       if (this.newlevel != _o_.newlevel) return false;
/*  93 */       if (this.addexp != _o_.addexp) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.index;
/* 102 */     _h_ += this.propertylist.hashCode();
/* 103 */     _h_ += this.exp;
/* 104 */     _h_ += this.oldlevel;
/* 105 */     _h_ += this.newlevel;
/* 106 */     _h_ += this.addexp;
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.index).append(",");
/* 114 */     _sb_.append(this.propertylist).append(",");
/* 115 */     _sb_.append(this.exp).append(",");
/* 116 */     _sb_.append(this.oldlevel).append(",");
/* 117 */     _sb_.append(this.newlevel).append(",");
/* 118 */     _sb_.append(this.addexp).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SUseWingExpItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */