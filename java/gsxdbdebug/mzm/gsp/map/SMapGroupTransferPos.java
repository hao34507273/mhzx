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
/*     */ public class SMapGroupTransferPos
/*     */   extends __SMapGroupTransferPos__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590937;
/*     */   public int group_type;
/*     */   public long groupid;
/*     */   public Location pos;
/*     */   public Location target_pos;
/*     */   public int map_cfgid;
/*     */   public int map_instance_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590937;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapGroupTransferPos()
/*     */   {
/*  38 */     this.group_type = 2;
/*  39 */     this.pos = new Location();
/*  40 */     this.target_pos = new Location();
/*     */   }
/*     */   
/*     */   public SMapGroupTransferPos(int _group_type_, long _groupid_, Location _pos_, Location _target_pos_, int _map_cfgid_, int _map_instance_id_) {
/*  44 */     this.group_type = _group_type_;
/*  45 */     this.groupid = _groupid_;
/*  46 */     this.pos = _pos_;
/*  47 */     this.target_pos = _target_pos_;
/*  48 */     this.map_cfgid = _map_cfgid_;
/*  49 */     this.map_instance_id = _map_instance_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     if (!this.pos._validator_()) return false;
/*  54 */     if (!this.target_pos._validator_()) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.group_type);
/*  60 */     _os_.marshal(this.groupid);
/*  61 */     _os_.marshal(this.pos);
/*  62 */     _os_.marshal(this.target_pos);
/*  63 */     _os_.marshal(this.map_cfgid);
/*  64 */     _os_.marshal(this.map_instance_id);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.group_type = _os_.unmarshal_int();
/*  70 */     this.groupid = _os_.unmarshal_long();
/*  71 */     this.pos.unmarshal(_os_);
/*  72 */     this.target_pos.unmarshal(_os_);
/*  73 */     this.map_cfgid = _os_.unmarshal_int();
/*  74 */     this.map_instance_id = _os_.unmarshal_int();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SMapGroupTransferPos)) {
/*  84 */       SMapGroupTransferPos _o_ = (SMapGroupTransferPos)_o1_;
/*  85 */       if (this.group_type != _o_.group_type) return false;
/*  86 */       if (this.groupid != _o_.groupid) return false;
/*  87 */       if (!this.pos.equals(_o_.pos)) return false;
/*  88 */       if (!this.target_pos.equals(_o_.target_pos)) return false;
/*  89 */       if (this.map_cfgid != _o_.map_cfgid) return false;
/*  90 */       if (this.map_instance_id != _o_.map_instance_id) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.group_type;
/*  99 */     _h_ += (int)this.groupid;
/* 100 */     _h_ += this.pos.hashCode();
/* 101 */     _h_ += this.target_pos.hashCode();
/* 102 */     _h_ += this.map_cfgid;
/* 103 */     _h_ += this.map_instance_id;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.group_type).append(",");
/* 111 */     _sb_.append(this.groupid).append(",");
/* 112 */     _sb_.append(this.pos).append(",");
/* 113 */     _sb_.append(this.target_pos).append(",");
/* 114 */     _sb_.append(this.map_cfgid).append(",");
/* 115 */     _sb_.append(this.map_instance_id).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapGroupTransferPos _o_) {
/* 121 */     if (_o_ == this) return 0;
/* 122 */     int _c_ = 0;
/* 123 */     _c_ = this.group_type - _o_.group_type;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.pos.compareTo(_o_.pos);
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.target_pos.compareTo(_o_.target_pos);
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.map_cfgid - _o_.map_cfgid;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.map_instance_id - _o_.map_instance_id;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapGroupTransferPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */