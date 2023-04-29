/*     */ package mzm.gsp.floor;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CSweepFloorReq extends __CSweepFloorReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617751;
/*     */   public int activityid;
/*     */   public int startfloor;
/*     */   public int endfloor;
/*     */   public byte useyuanbao;
/*     */   public long curyuanbao;
/*     */   public long needyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.floor.main.PCSweepFloor(roleId, this.activityid, this.startfloor, this.endfloor, this.curyuanbao, this.useyuanbao > 0, this.needyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12617751;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSweepFloorReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSweepFloorReq(int _activityid_, int _startfloor_, int _endfloor_, byte _useyuanbao_, long _curyuanbao_, long _needyuanbao_)
/*     */   {
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.startfloor = _startfloor_;
/*  47 */     this.endfloor = _endfloor_;
/*  48 */     this.useyuanbao = _useyuanbao_;
/*  49 */     this.curyuanbao = _curyuanbao_;
/*  50 */     this.needyuanbao = _needyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.activityid);
/*  59 */     _os_.marshal(this.startfloor);
/*  60 */     _os_.marshal(this.endfloor);
/*  61 */     _os_.marshal(this.useyuanbao);
/*  62 */     _os_.marshal(this.curyuanbao);
/*  63 */     _os_.marshal(this.needyuanbao);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.activityid = _os_.unmarshal_int();
/*  69 */     this.startfloor = _os_.unmarshal_int();
/*  70 */     this.endfloor = _os_.unmarshal_int();
/*  71 */     this.useyuanbao = _os_.unmarshal_byte();
/*  72 */     this.curyuanbao = _os_.unmarshal_long();
/*  73 */     this.needyuanbao = _os_.unmarshal_long();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof CSweepFloorReq)) {
/*  83 */       CSweepFloorReq _o_ = (CSweepFloorReq)_o1_;
/*  84 */       if (this.activityid != _o_.activityid) return false;
/*  85 */       if (this.startfloor != _o_.startfloor) return false;
/*  86 */       if (this.endfloor != _o_.endfloor) return false;
/*  87 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  88 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  89 */       if (this.needyuanbao != _o_.needyuanbao) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.activityid;
/*  98 */     _h_ += this.startfloor;
/*  99 */     _h_ += this.endfloor;
/* 100 */     _h_ += this.useyuanbao;
/* 101 */     _h_ += (int)this.curyuanbao;
/* 102 */     _h_ += (int)this.needyuanbao;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.activityid).append(",");
/* 110 */     _sb_.append(this.startfloor).append(",");
/* 111 */     _sb_.append(this.endfloor).append(",");
/* 112 */     _sb_.append(this.useyuanbao).append(",");
/* 113 */     _sb_.append(this.curyuanbao).append(",");
/* 114 */     _sb_.append(this.needyuanbao).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSweepFloorReq _o_) {
/* 120 */     if (_o_ == this) return 0;
/* 121 */     int _c_ = 0;
/* 122 */     _c_ = this.activityid - _o_.activityid;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.startfloor - _o_.startfloor;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.endfloor - _o_.endfloor;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = Long.signum(this.needyuanbao - _o_.needyuanbao);
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\CSweepFloorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */