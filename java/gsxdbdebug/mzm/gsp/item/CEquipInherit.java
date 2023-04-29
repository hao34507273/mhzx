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
/*     */ public class CEquipInherit
/*     */   extends __CEquipInherit__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584760;
/*     */   public int srceequipkey;
/*     */   public int desequipbagid;
/*     */   public int desequipkey;
/*     */   public int isinherithun;
/*     */   public long clientsilvernum;
/*     */   public int clistrengthlevel;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  26 */     return 12584760;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipInherit() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipInherit(int _srceequipkey_, int _desequipbagid_, int _desequipkey_, int _isinherithun_, long _clientsilvernum_, int _clistrengthlevel_)
/*     */   {
/*  40 */     this.srceequipkey = _srceequipkey_;
/*  41 */     this.desequipbagid = _desequipbagid_;
/*  42 */     this.desequipkey = _desequipkey_;
/*  43 */     this.isinherithun = _isinherithun_;
/*  44 */     this.clientsilvernum = _clientsilvernum_;
/*  45 */     this.clistrengthlevel = _clistrengthlevel_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.srceequipkey);
/*  54 */     _os_.marshal(this.desequipbagid);
/*  55 */     _os_.marshal(this.desequipkey);
/*  56 */     _os_.marshal(this.isinherithun);
/*  57 */     _os_.marshal(this.clientsilvernum);
/*  58 */     _os_.marshal(this.clistrengthlevel);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.srceequipkey = _os_.unmarshal_int();
/*  64 */     this.desequipbagid = _os_.unmarshal_int();
/*  65 */     this.desequipkey = _os_.unmarshal_int();
/*  66 */     this.isinherithun = _os_.unmarshal_int();
/*  67 */     this.clientsilvernum = _os_.unmarshal_long();
/*  68 */     this.clistrengthlevel = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CEquipInherit)) {
/*  78 */       CEquipInherit _o_ = (CEquipInherit)_o1_;
/*  79 */       if (this.srceequipkey != _o_.srceequipkey) return false;
/*  80 */       if (this.desequipbagid != _o_.desequipbagid) return false;
/*  81 */       if (this.desequipkey != _o_.desequipkey) return false;
/*  82 */       if (this.isinherithun != _o_.isinherithun) return false;
/*  83 */       if (this.clientsilvernum != _o_.clientsilvernum) return false;
/*  84 */       if (this.clistrengthlevel != _o_.clistrengthlevel) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.srceequipkey;
/*  93 */     _h_ += this.desequipbagid;
/*  94 */     _h_ += this.desequipkey;
/*  95 */     _h_ += this.isinherithun;
/*  96 */     _h_ += (int)this.clientsilvernum;
/*  97 */     _h_ += this.clistrengthlevel;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.srceequipkey).append(",");
/* 105 */     _sb_.append(this.desequipbagid).append(",");
/* 106 */     _sb_.append(this.desequipkey).append(",");
/* 107 */     _sb_.append(this.isinherithun).append(",");
/* 108 */     _sb_.append(this.clientsilvernum).append(",");
/* 109 */     _sb_.append(this.clistrengthlevel).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipInherit _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = this.srceequipkey - _o_.srceequipkey;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.desequipbagid - _o_.desequipbagid;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.desequipkey - _o_.desequipkey;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.isinherithun - _o_.isinherithun;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = Long.signum(this.clientsilvernum - _o_.clientsilvernum);
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.clistrengthlevel - _o_.clistrengthlevel;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipInherit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */