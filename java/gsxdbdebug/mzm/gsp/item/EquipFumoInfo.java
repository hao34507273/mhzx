/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class EquipFumoInfo implements Marshal, Comparable<EquipFumoInfo>
/*     */ {
/*     */   public int bagid;
/*     */   public int itemid;
/*     */   public long uuid;
/*     */   public long expirationtime;
/*     */   public int propertytype;
/*     */   public int addvalue;
/*     */   
/*     */   public EquipFumoInfo() {}
/*     */   
/*     */   public EquipFumoInfo(int _bagid_, int _itemid_, long _uuid_, long _expirationtime_, int _propertytype_, int _addvalue_)
/*     */   {
/*  20 */     this.bagid = _bagid_;
/*  21 */     this.itemid = _itemid_;
/*  22 */     this.uuid = _uuid_;
/*  23 */     this.expirationtime = _expirationtime_;
/*  24 */     this.propertytype = _propertytype_;
/*  25 */     this.addvalue = _addvalue_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  29 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  33 */     _os_.marshal(this.bagid);
/*  34 */     _os_.marshal(this.itemid);
/*  35 */     _os_.marshal(this.uuid);
/*  36 */     _os_.marshal(this.expirationtime);
/*  37 */     _os_.marshal(this.propertytype);
/*  38 */     _os_.marshal(this.addvalue);
/*  39 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  43 */     this.bagid = _os_.unmarshal_int();
/*  44 */     this.itemid = _os_.unmarshal_int();
/*  45 */     this.uuid = _os_.unmarshal_long();
/*  46 */     this.expirationtime = _os_.unmarshal_long();
/*  47 */     this.propertytype = _os_.unmarshal_int();
/*  48 */     this.addvalue = _os_.unmarshal_int();
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  53 */     if (_o1_ == this) return true;
/*  54 */     if ((_o1_ instanceof EquipFumoInfo)) {
/*  55 */       EquipFumoInfo _o_ = (EquipFumoInfo)_o1_;
/*  56 */       if (this.bagid != _o_.bagid) return false;
/*  57 */       if (this.itemid != _o_.itemid) return false;
/*  58 */       if (this.uuid != _o_.uuid) return false;
/*  59 */       if (this.expirationtime != _o_.expirationtime) return false;
/*  60 */       if (this.propertytype != _o_.propertytype) return false;
/*  61 */       if (this.addvalue != _o_.addvalue) return false;
/*  62 */       return true;
/*     */     }
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  68 */     int _h_ = 0;
/*  69 */     _h_ += this.bagid;
/*  70 */     _h_ += this.itemid;
/*  71 */     _h_ += (int)this.uuid;
/*  72 */     _h_ += (int)this.expirationtime;
/*  73 */     _h_ += this.propertytype;
/*  74 */     _h_ += this.addvalue;
/*  75 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuilder _sb_ = new StringBuilder();
/*  80 */     _sb_.append("(");
/*  81 */     _sb_.append(this.bagid).append(",");
/*  82 */     _sb_.append(this.itemid).append(",");
/*  83 */     _sb_.append(this.uuid).append(",");
/*  84 */     _sb_.append(this.expirationtime).append(",");
/*  85 */     _sb_.append(this.propertytype).append(",");
/*  86 */     _sb_.append(this.addvalue).append(",");
/*  87 */     _sb_.append(")");
/*  88 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(EquipFumoInfo _o_) {
/*  92 */     if (_o_ == this) return 0;
/*  93 */     int _c_ = 0;
/*  94 */     _c_ = this.bagid - _o_.bagid;
/*  95 */     if (0 != _c_) return _c_;
/*  96 */     _c_ = this.itemid - _o_.itemid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = Long.signum(this.expirationtime - _o_.expirationtime);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.propertytype - _o_.propertytype;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.addvalue - _o_.addvalue;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\EquipFumoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */