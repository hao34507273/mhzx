/*     */ package mzm.gsp.gang;
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
/*     */ public class SSyncBuildingLevelUpDonate
/*     */   extends __SSyncBuildingLevelUpDonate__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589906;
/*     */   public int buildingtype;
/*     */   public long roleid;
/*     */   public int donatelv;
/*     */   public int endtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589906;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBuildingLevelUpDonate() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncBuildingLevelUpDonate(int _buildingtype_, long _roleid_, int _donatelv_, int _endtime_)
/*     */   {
/*  39 */     this.buildingtype = _buildingtype_;
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.donatelv = _donatelv_;
/*  42 */     this.endtime = _endtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.buildingtype);
/*  51 */     _os_.marshal(this.roleid);
/*  52 */     _os_.marshal(this.donatelv);
/*  53 */     _os_.marshal(this.endtime);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.buildingtype = _os_.unmarshal_int();
/*  59 */     this.roleid = _os_.unmarshal_long();
/*  60 */     this.donatelv = _os_.unmarshal_int();
/*  61 */     this.endtime = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncBuildingLevelUpDonate)) {
/*  71 */       SSyncBuildingLevelUpDonate _o_ = (SSyncBuildingLevelUpDonate)_o1_;
/*  72 */       if (this.buildingtype != _o_.buildingtype) return false;
/*  73 */       if (this.roleid != _o_.roleid) return false;
/*  74 */       if (this.donatelv != _o_.donatelv) return false;
/*  75 */       if (this.endtime != _o_.endtime) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.buildingtype;
/*  84 */     _h_ += (int)this.roleid;
/*  85 */     _h_ += this.donatelv;
/*  86 */     _h_ += this.endtime;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.buildingtype).append(",");
/*  94 */     _sb_.append(this.roleid).append(",");
/*  95 */     _sb_.append(this.donatelv).append(",");
/*  96 */     _sb_.append(this.endtime).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBuildingLevelUpDonate _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.buildingtype - _o_.buildingtype;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.donatelv - _o_.donatelv;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.endtime - _o_.endtime;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncBuildingLevelUpDonate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */