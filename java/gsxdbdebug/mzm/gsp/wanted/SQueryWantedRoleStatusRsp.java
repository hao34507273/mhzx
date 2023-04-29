/*     */ package mzm.gsp.wanted;
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
/*     */ public class SQueryWantedRoleStatusRsp
/*     */   extends __SQueryWantedRoleStatusRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620302;
/*     */   public long roleid;
/*     */   public int power;
/*     */   public int mapid;
/*     */   public int teammembercount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12620302;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryWantedRoleStatusRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SQueryWantedRoleStatusRsp(long _roleid_, int _power_, int _mapid_, int _teammembercount_)
/*     */   {
/*  37 */     this.roleid = _roleid_;
/*  38 */     this.power = _power_;
/*  39 */     this.mapid = _mapid_;
/*  40 */     this.teammembercount = _teammembercount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.power);
/*  50 */     _os_.marshal(this.mapid);
/*  51 */     _os_.marshal(this.teammembercount);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.roleid = _os_.unmarshal_long();
/*  57 */     this.power = _os_.unmarshal_int();
/*  58 */     this.mapid = _os_.unmarshal_int();
/*  59 */     this.teammembercount = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SQueryWantedRoleStatusRsp)) {
/*  69 */       SQueryWantedRoleStatusRsp _o_ = (SQueryWantedRoleStatusRsp)_o1_;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (this.power != _o_.power) return false;
/*  72 */       if (this.mapid != _o_.mapid) return false;
/*  73 */       if (this.teammembercount != _o_.teammembercount) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.roleid;
/*  82 */     _h_ += this.power;
/*  83 */     _h_ += this.mapid;
/*  84 */     _h_ += this.teammembercount;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.roleid).append(",");
/*  92 */     _sb_.append(this.power).append(",");
/*  93 */     _sb_.append(this.mapid).append(",");
/*  94 */     _sb_.append(this.teammembercount).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SQueryWantedRoleStatusRsp _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.power - _o_.power;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.mapid - _o_.mapid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.teammembercount - _o_.teammembercount;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SQueryWantedRoleStatusRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */