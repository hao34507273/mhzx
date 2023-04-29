/*     */ package mzm.gsp.map;
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
/*     */ public class SMapTeamTransferPos
/*     */   extends __SMapTeamTransferPos__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590902;
/*     */   public long teamid;
/*     */   public Location pos;
/*     */   public Location targetpos;
/*     */   public int direction;
/*     */   public int mapid;
/*     */   public int mapinstanceid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590902;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapTeamTransferPos()
/*     */   {
/*  38 */     this.pos = new Location();
/*  39 */     this.targetpos = new Location();
/*     */   }
/*     */   
/*     */   public SMapTeamTransferPos(long _teamid_, Location _pos_, Location _targetpos_, int _direction_, int _mapid_, int _mapinstanceid_) {
/*  43 */     this.teamid = _teamid_;
/*  44 */     this.pos = _pos_;
/*  45 */     this.targetpos = _targetpos_;
/*  46 */     this.direction = _direction_;
/*  47 */     this.mapid = _mapid_;
/*  48 */     this.mapinstanceid = _mapinstanceid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     if (!this.pos._validator_()) return false;
/*  53 */     if (!this.targetpos._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.teamid);
/*  59 */     _os_.marshal(this.pos);
/*  60 */     _os_.marshal(this.targetpos);
/*  61 */     _os_.marshal(this.direction);
/*  62 */     _os_.marshal(this.mapid);
/*  63 */     _os_.marshal(this.mapinstanceid);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.teamid = _os_.unmarshal_long();
/*  69 */     this.pos.unmarshal(_os_);
/*  70 */     this.targetpos.unmarshal(_os_);
/*  71 */     this.direction = _os_.unmarshal_int();
/*  72 */     this.mapid = _os_.unmarshal_int();
/*  73 */     this.mapinstanceid = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SMapTeamTransferPos)) {
/*  83 */       SMapTeamTransferPos _o_ = (SMapTeamTransferPos)_o1_;
/*  84 */       if (this.teamid != _o_.teamid) return false;
/*  85 */       if (!this.pos.equals(_o_.pos)) return false;
/*  86 */       if (!this.targetpos.equals(_o_.targetpos)) return false;
/*  87 */       if (this.direction != _o_.direction) return false;
/*  88 */       if (this.mapid != _o_.mapid) return false;
/*  89 */       if (this.mapinstanceid != _o_.mapinstanceid) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += (int)this.teamid;
/*  98 */     _h_ += this.pos.hashCode();
/*  99 */     _h_ += this.targetpos.hashCode();
/* 100 */     _h_ += this.direction;
/* 101 */     _h_ += this.mapid;
/* 102 */     _h_ += this.mapinstanceid;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.teamid).append(",");
/* 110 */     _sb_.append(this.pos).append(",");
/* 111 */     _sb_.append(this.targetpos).append(",");
/* 112 */     _sb_.append(this.direction).append(",");
/* 113 */     _sb_.append(this.mapid).append(",");
/* 114 */     _sb_.append(this.mapinstanceid).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapTeamTransferPos _o_) {
/* 120 */     if (_o_ == this) return 0;
/* 121 */     int _c_ = 0;
/* 122 */     _c_ = Long.signum(this.teamid - _o_.teamid);
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.pos.compareTo(_o_.pos);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.targetpos.compareTo(_o_.targetpos);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.direction - _o_.direction;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.mapid - _o_.mapid;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     _c_ = this.mapinstanceid - _o_.mapinstanceid;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapTeamTransferPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */