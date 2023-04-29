/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ public class SMapGroupInfo
/*     */   extends __SMapGroupInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590939;
/*     */   public int group_type;
/*     */   public long groupid;
/*     */   public int group_velocity;
/*     */   public long leader;
/*     */   public LinkedList<Long> other_members;
/*     */   public ArrayList<Location> key_point_path;
/*     */   public HashMap<Integer, Integer> extra_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590939;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapGroupInfo()
/*     */   {
/*  39 */     this.group_type = 2;
/*  40 */     this.other_members = new LinkedList();
/*  41 */     this.key_point_path = new ArrayList();
/*  42 */     this.extra_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public SMapGroupInfo(int _group_type_, long _groupid_, int _group_velocity_, long _leader_, LinkedList<Long> _other_members_, ArrayList<Location> _key_point_path_, HashMap<Integer, Integer> _extra_infos_) {
/*  46 */     this.group_type = _group_type_;
/*  47 */     this.groupid = _groupid_;
/*  48 */     this.group_velocity = _group_velocity_;
/*  49 */     this.leader = _leader_;
/*  50 */     this.other_members = _other_members_;
/*  51 */     this.key_point_path = _key_point_path_;
/*  52 */     this.extra_infos = _extra_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     for (Location _v_ : this.key_point_path)
/*  57 */       if (!_v_._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.group_type);
/*  63 */     _os_.marshal(this.groupid);
/*  64 */     _os_.marshal(this.group_velocity);
/*  65 */     _os_.marshal(this.leader);
/*  66 */     _os_.compact_uint32(this.other_members.size());
/*  67 */     for (Long _v_ : this.other_members) {
/*  68 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  70 */     _os_.compact_uint32(this.key_point_path.size());
/*  71 */     for (Location _v_ : this.key_point_path) {
/*  72 */       _os_.marshal(_v_);
/*     */     }
/*  74 */     _os_.compact_uint32(this.extra_infos.size());
/*  75 */     for (Map.Entry<Integer, Integer> _e_ : this.extra_infos.entrySet()) {
/*  76 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  77 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  83 */     this.group_type = _os_.unmarshal_int();
/*  84 */     this.groupid = _os_.unmarshal_long();
/*  85 */     this.group_velocity = _os_.unmarshal_int();
/*  86 */     this.leader = _os_.unmarshal_long();
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  89 */       long _v_ = _os_.unmarshal_long();
/*  90 */       this.other_members.add(Long.valueOf(_v_));
/*     */     }
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  93 */       Location _v_ = new Location();
/*  94 */       _v_.unmarshal(_os_);
/*  95 */       this.key_point_path.add(_v_);
/*     */     }
/*  97 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  99 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 101 */       int _v_ = _os_.unmarshal_int();
/* 102 */       this.extra_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 104 */     if (!_validator_()) {
/* 105 */       throw new VerifyError("validator failed");
/*     */     }
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 111 */     if (_o1_ == this) return true;
/* 112 */     if ((_o1_ instanceof SMapGroupInfo)) {
/* 113 */       SMapGroupInfo _o_ = (SMapGroupInfo)_o1_;
/* 114 */       if (this.group_type != _o_.group_type) return false;
/* 115 */       if (this.groupid != _o_.groupid) return false;
/* 116 */       if (this.group_velocity != _o_.group_velocity) return false;
/* 117 */       if (this.leader != _o_.leader) return false;
/* 118 */       if (!this.other_members.equals(_o_.other_members)) return false;
/* 119 */       if (!this.key_point_path.equals(_o_.key_point_path)) return false;
/* 120 */       if (!this.extra_infos.equals(_o_.extra_infos)) return false;
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 127 */     int _h_ = 0;
/* 128 */     _h_ += this.group_type;
/* 129 */     _h_ += (int)this.groupid;
/* 130 */     _h_ += this.group_velocity;
/* 131 */     _h_ += (int)this.leader;
/* 132 */     _h_ += this.other_members.hashCode();
/* 133 */     _h_ += this.key_point_path.hashCode();
/* 134 */     _h_ += this.extra_infos.hashCode();
/* 135 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder _sb_ = new StringBuilder();
/* 140 */     _sb_.append("(");
/* 141 */     _sb_.append(this.group_type).append(",");
/* 142 */     _sb_.append(this.groupid).append(",");
/* 143 */     _sb_.append(this.group_velocity).append(",");
/* 144 */     _sb_.append(this.leader).append(",");
/* 145 */     _sb_.append(this.other_members).append(",");
/* 146 */     _sb_.append(this.key_point_path).append(",");
/* 147 */     _sb_.append(this.extra_infos).append(",");
/* 148 */     _sb_.append(")");
/* 149 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */