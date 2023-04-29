/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SMapGroupEnterView extends __SMapGroupEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590938;
/*     */   public int group_type;
/*     */   public long groupid;
/*     */   public int group_velocity;
/*     */   public MapGroupMemberInfo leader_info;
/*     */   public LinkedList<MapGroupMemberInfo> other_member_infos;
/*     */   public ArrayList<Location> key_point_path;
/*     */   public int direction;
/*     */   public Location cur_pos;
/*     */   public HashMap<Integer, Integer> extra_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590938;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapGroupEnterView()
/*     */   {
/*  41 */     this.group_type = 2;
/*  42 */     this.leader_info = new MapGroupMemberInfo();
/*  43 */     this.other_member_infos = new LinkedList();
/*  44 */     this.key_point_path = new ArrayList();
/*  45 */     this.cur_pos = new Location();
/*  46 */     this.extra_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public SMapGroupEnterView(int _group_type_, long _groupid_, int _group_velocity_, MapGroupMemberInfo _leader_info_, LinkedList<MapGroupMemberInfo> _other_member_infos_, ArrayList<Location> _key_point_path_, int _direction_, Location _cur_pos_, HashMap<Integer, Integer> _extra_infos_) {
/*  50 */     this.group_type = _group_type_;
/*  51 */     this.groupid = _groupid_;
/*  52 */     this.group_velocity = _group_velocity_;
/*  53 */     this.leader_info = _leader_info_;
/*  54 */     this.other_member_infos = _other_member_infos_;
/*  55 */     this.key_point_path = _key_point_path_;
/*  56 */     this.direction = _direction_;
/*  57 */     this.cur_pos = _cur_pos_;
/*  58 */     this.extra_infos = _extra_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     if (!this.leader_info._validator_()) return false;
/*  63 */     for (MapGroupMemberInfo _v_ : this.other_member_infos)
/*  64 */       if (!_v_._validator_()) return false;
/*  65 */     for (Location _v_ : this.key_point_path)
/*  66 */       if (!_v_._validator_()) return false;
/*  67 */     if (!this.cur_pos._validator_()) return false;
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  72 */     _os_.marshal(this.group_type);
/*  73 */     _os_.marshal(this.groupid);
/*  74 */     _os_.marshal(this.group_velocity);
/*  75 */     _os_.marshal(this.leader_info);
/*  76 */     _os_.compact_uint32(this.other_member_infos.size());
/*  77 */     for (MapGroupMemberInfo _v_ : this.other_member_infos) {
/*  78 */       _os_.marshal(_v_);
/*     */     }
/*  80 */     _os_.compact_uint32(this.key_point_path.size());
/*  81 */     for (Location _v_ : this.key_point_path) {
/*  82 */       _os_.marshal(_v_);
/*     */     }
/*  84 */     _os_.marshal(this.direction);
/*  85 */     _os_.marshal(this.cur_pos);
/*  86 */     _os_.compact_uint32(this.extra_infos.size());
/*  87 */     for (Map.Entry<Integer, Integer> _e_ : this.extra_infos.entrySet()) {
/*  88 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  89 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  95 */     this.group_type = _os_.unmarshal_int();
/*  96 */     this.groupid = _os_.unmarshal_long();
/*  97 */     this.group_velocity = _os_.unmarshal_int();
/*  98 */     this.leader_info.unmarshal(_os_);
/*  99 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 100 */       MapGroupMemberInfo _v_ = new MapGroupMemberInfo();
/* 101 */       _v_.unmarshal(_os_);
/* 102 */       this.other_member_infos.add(_v_);
/*     */     }
/* 104 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 105 */       Location _v_ = new Location();
/* 106 */       _v_.unmarshal(_os_);
/* 107 */       this.key_point_path.add(_v_);
/*     */     }
/* 109 */     this.direction = _os_.unmarshal_int();
/* 110 */     this.cur_pos.unmarshal(_os_);
/* 111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 113 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 115 */       int _v_ = _os_.unmarshal_int();
/* 116 */       this.extra_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 118 */     if (!_validator_()) {
/* 119 */       throw new VerifyError("validator failed");
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 125 */     if (_o1_ == this) return true;
/* 126 */     if ((_o1_ instanceof SMapGroupEnterView)) {
/* 127 */       SMapGroupEnterView _o_ = (SMapGroupEnterView)_o1_;
/* 128 */       if (this.group_type != _o_.group_type) return false;
/* 129 */       if (this.groupid != _o_.groupid) return false;
/* 130 */       if (this.group_velocity != _o_.group_velocity) return false;
/* 131 */       if (!this.leader_info.equals(_o_.leader_info)) return false;
/* 132 */       if (!this.other_member_infos.equals(_o_.other_member_infos)) return false;
/* 133 */       if (!this.key_point_path.equals(_o_.key_point_path)) return false;
/* 134 */       if (this.direction != _o_.direction) return false;
/* 135 */       if (!this.cur_pos.equals(_o_.cur_pos)) return false;
/* 136 */       if (!this.extra_infos.equals(_o_.extra_infos)) return false;
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 143 */     int _h_ = 0;
/* 144 */     _h_ += this.group_type;
/* 145 */     _h_ += (int)this.groupid;
/* 146 */     _h_ += this.group_velocity;
/* 147 */     _h_ += this.leader_info.hashCode();
/* 148 */     _h_ += this.other_member_infos.hashCode();
/* 149 */     _h_ += this.key_point_path.hashCode();
/* 150 */     _h_ += this.direction;
/* 151 */     _h_ += this.cur_pos.hashCode();
/* 152 */     _h_ += this.extra_infos.hashCode();
/* 153 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 157 */     StringBuilder _sb_ = new StringBuilder();
/* 158 */     _sb_.append("(");
/* 159 */     _sb_.append(this.group_type).append(",");
/* 160 */     _sb_.append(this.groupid).append(",");
/* 161 */     _sb_.append(this.group_velocity).append(",");
/* 162 */     _sb_.append(this.leader_info).append(",");
/* 163 */     _sb_.append(this.other_member_infos).append(",");
/* 164 */     _sb_.append(this.key_point_path).append(",");
/* 165 */     _sb_.append(this.direction).append(",");
/* 166 */     _sb_.append(this.cur_pos).append(",");
/* 167 */     _sb_.append(this.extra_infos).append(",");
/* 168 */     _sb_.append(")");
/* 169 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapGroupEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */