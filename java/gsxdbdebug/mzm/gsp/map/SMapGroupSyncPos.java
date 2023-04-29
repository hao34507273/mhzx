/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMapGroupSyncPos
/*     */   extends __SMapGroupSyncPos__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590941;
/*     */   public int group_type;
/*     */   public long groupid;
/*     */   public ArrayList<Location> key_point_path;
/*     */   public int map_cfgid;
/*     */   public int map_instance_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590941;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapGroupSyncPos()
/*     */   {
/*  37 */     this.group_type = 2;
/*  38 */     this.key_point_path = new ArrayList();
/*     */   }
/*     */   
/*     */   public SMapGroupSyncPos(int _group_type_, long _groupid_, ArrayList<Location> _key_point_path_, int _map_cfgid_, int _map_instance_id_) {
/*  42 */     this.group_type = _group_type_;
/*  43 */     this.groupid = _groupid_;
/*  44 */     this.key_point_path = _key_point_path_;
/*  45 */     this.map_cfgid = _map_cfgid_;
/*  46 */     this.map_instance_id = _map_instance_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     for (Location _v_ : this.key_point_path)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.group_type);
/*  57 */     _os_.marshal(this.groupid);
/*  58 */     _os_.compact_uint32(this.key_point_path.size());
/*  59 */     for (Location _v_ : this.key_point_path) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     _os_.marshal(this.map_cfgid);
/*  63 */     _os_.marshal(this.map_instance_id);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.group_type = _os_.unmarshal_int();
/*  69 */     this.groupid = _os_.unmarshal_long();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  71 */       Location _v_ = new Location();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.key_point_path.add(_v_);
/*     */     }
/*  75 */     this.map_cfgid = _os_.unmarshal_int();
/*  76 */     this.map_instance_id = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SMapGroupSyncPos)) {
/*  86 */       SMapGroupSyncPos _o_ = (SMapGroupSyncPos)_o1_;
/*  87 */       if (this.group_type != _o_.group_type) return false;
/*  88 */       if (this.groupid != _o_.groupid) return false;
/*  89 */       if (!this.key_point_path.equals(_o_.key_point_path)) return false;
/*  90 */       if (this.map_cfgid != _o_.map_cfgid) return false;
/*  91 */       if (this.map_instance_id != _o_.map_instance_id) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.group_type;
/* 100 */     _h_ += (int)this.groupid;
/* 101 */     _h_ += this.key_point_path.hashCode();
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
/* 112 */     _sb_.append(this.key_point_path).append(",");
/* 113 */     _sb_.append(this.map_cfgid).append(",");
/* 114 */     _sb_.append(this.map_instance_id).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapGroupSyncPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */