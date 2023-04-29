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
/*     */ public class SSyncBuildingStartLevelUp
/*     */   extends __SSyncBuildingStartLevelUp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589908;
/*     */   public int buildingtype;
/*     */   public int endtime;
/*     */   public long roleid;
/*     */   public int gangmoney;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589908;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncBuildingStartLevelUp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncBuildingStartLevelUp(int _buildingtype_, int _endtime_, long _roleid_, int _gangmoney_)
/*     */   {
/*  39 */     this.buildingtype = _buildingtype_;
/*  40 */     this.endtime = _endtime_;
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.gangmoney = _gangmoney_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.buildingtype);
/*  51 */     _os_.marshal(this.endtime);
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.gangmoney);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.buildingtype = _os_.unmarshal_int();
/*  59 */     this.endtime = _os_.unmarshal_int();
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.gangmoney = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncBuildingStartLevelUp)) {
/*  71 */       SSyncBuildingStartLevelUp _o_ = (SSyncBuildingStartLevelUp)_o1_;
/*  72 */       if (this.buildingtype != _o_.buildingtype) return false;
/*  73 */       if (this.endtime != _o_.endtime) return false;
/*  74 */       if (this.roleid != _o_.roleid) return false;
/*  75 */       if (this.gangmoney != _o_.gangmoney) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.buildingtype;
/*  84 */     _h_ += this.endtime;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.gangmoney;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.buildingtype).append(",");
/*  94 */     _sb_.append(this.endtime).append(",");
/*  95 */     _sb_.append(this.roleid).append(",");
/*  96 */     _sb_.append(this.gangmoney).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBuildingStartLevelUp _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.buildingtype - _o_.buildingtype;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.endtime - _o_.endtime;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.gangmoney - _o_.gangmoney;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncBuildingStartLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */