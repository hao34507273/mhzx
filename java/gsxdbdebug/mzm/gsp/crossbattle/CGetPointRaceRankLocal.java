/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.point.PCGetPointRaceRankLocal;
/*     */ 
/*     */ public class CGetPointRaceRankLocal extends __CGetPointRaceRankLocal__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617067;
/*     */   public int time_point_cfgid;
/*     */   public int activity_cfgid;
/*     */   public int zone;
/*     */   public int from;
/*     */   public int to;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCGetPointRaceRankLocal(roleId, this.activity_cfgid, this.zone, this.time_point_cfgid, this.from, this.to));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12617067;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetPointRaceRankLocal() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetPointRaceRankLocal(int _time_point_cfgid_, int _activity_cfgid_, int _zone_, int _from_, int _to_)
/*     */   {
/*  45 */     this.time_point_cfgid = _time_point_cfgid_;
/*  46 */     this.activity_cfgid = _activity_cfgid_;
/*  47 */     this.zone = _zone_;
/*  48 */     this.from = _from_;
/*  49 */     this.to = _to_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.time_point_cfgid);
/*  58 */     _os_.marshal(this.activity_cfgid);
/*  59 */     _os_.marshal(this.zone);
/*  60 */     _os_.marshal(this.from);
/*  61 */     _os_.marshal(this.to);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.time_point_cfgid = _os_.unmarshal_int();
/*  67 */     this.activity_cfgid = _os_.unmarshal_int();
/*  68 */     this.zone = _os_.unmarshal_int();
/*  69 */     this.from = _os_.unmarshal_int();
/*  70 */     this.to = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CGetPointRaceRankLocal)) {
/*  80 */       CGetPointRaceRankLocal _o_ = (CGetPointRaceRankLocal)_o1_;
/*  81 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  82 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  83 */       if (this.zone != _o_.zone) return false;
/*  84 */       if (this.from != _o_.from) return false;
/*  85 */       if (this.to != _o_.to) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.time_point_cfgid;
/*  94 */     _h_ += this.activity_cfgid;
/*  95 */     _h_ += this.zone;
/*  96 */     _h_ += this.from;
/*  97 */     _h_ += this.to;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.time_point_cfgid).append(",");
/* 105 */     _sb_.append(this.activity_cfgid).append(",");
/* 106 */     _sb_.append(this.zone).append(",");
/* 107 */     _sb_.append(this.from).append(",");
/* 108 */     _sb_.append(this.to).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetPointRaceRankLocal _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.time_point_cfgid - _o_.time_point_cfgid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.zone - _o_.zone;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.from - _o_.from;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.to - _o_.to;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetPointRaceRankLocal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */