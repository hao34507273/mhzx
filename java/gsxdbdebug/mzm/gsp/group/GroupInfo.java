/*     */ package mzm.gsp.group;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class GroupInfo implements Marshal
/*     */ {
/*     */   public static final int TYPE_FRIEND = 1;
/*     */   public static final int TYPE_JIEYI = 2;
/*     */   public long groupid;
/*     */   public byte group_type;
/*     */   public long masterid;
/*     */   public int create_time;
/*     */   public Octets group_name;
/*     */   public Octets announcement;
/*     */   public ArrayList<GroupMemberBasicInfo> image_member_list;
/*     */   public ArrayList<GroupMemberInfo> member_list;
/*     */   public int member_num;
/*     */   public long info_version;
/*     */   
/*     */   public GroupInfo()
/*     */   {
/*  26 */     this.group_name = new Octets();
/*  27 */     this.announcement = new Octets();
/*  28 */     this.image_member_list = new ArrayList();
/*  29 */     this.member_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public GroupInfo(long _groupid_, byte _group_type_, long _masterid_, int _create_time_, Octets _group_name_, Octets _announcement_, ArrayList<GroupMemberBasicInfo> _image_member_list_, ArrayList<GroupMemberInfo> _member_list_, int _member_num_, long _info_version_) {
/*  33 */     this.groupid = _groupid_;
/*  34 */     this.group_type = _group_type_;
/*  35 */     this.masterid = _masterid_;
/*  36 */     this.create_time = _create_time_;
/*  37 */     this.group_name = _group_name_;
/*  38 */     this.announcement = _announcement_;
/*  39 */     this.image_member_list = _image_member_list_;
/*  40 */     this.member_list = _member_list_;
/*  41 */     this.member_num = _member_num_;
/*  42 */     this.info_version = _info_version_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (GroupMemberBasicInfo _v_ : this.image_member_list)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     for (GroupMemberInfo _v_ : this.member_list)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.groupid);
/*  55 */     _os_.marshal(this.group_type);
/*  56 */     _os_.marshal(this.masterid);
/*  57 */     _os_.marshal(this.create_time);
/*  58 */     _os_.marshal(this.group_name);
/*  59 */     _os_.marshal(this.announcement);
/*  60 */     _os_.compact_uint32(this.image_member_list.size());
/*  61 */     for (GroupMemberBasicInfo _v_ : this.image_member_list) {
/*  62 */       _os_.marshal(_v_);
/*     */     }
/*  64 */     _os_.compact_uint32(this.member_list.size());
/*  65 */     for (GroupMemberInfo _v_ : this.member_list) {
/*  66 */       _os_.marshal(_v_);
/*     */     }
/*  68 */     _os_.marshal(this.member_num);
/*  69 */     _os_.marshal(this.info_version);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.groupid = _os_.unmarshal_long();
/*  75 */     this.group_type = _os_.unmarshal_byte();
/*  76 */     this.masterid = _os_.unmarshal_long();
/*  77 */     this.create_time = _os_.unmarshal_int();
/*  78 */     this.group_name = _os_.unmarshal_Octets();
/*  79 */     this.announcement = _os_.unmarshal_Octets();
/*  80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  81 */       GroupMemberBasicInfo _v_ = new GroupMemberBasicInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.image_member_list.add(_v_);
/*     */     }
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  86 */       GroupMemberInfo _v_ = new GroupMemberInfo();
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.member_list.add(_v_);
/*     */     }
/*  90 */     this.member_num = _os_.unmarshal_int();
/*  91 */     this.info_version = _os_.unmarshal_long();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  96 */     if (_o1_ == this) return true;
/*  97 */     if ((_o1_ instanceof GroupInfo)) {
/*  98 */       GroupInfo _o_ = (GroupInfo)_o1_;
/*  99 */       if (this.groupid != _o_.groupid) return false;
/* 100 */       if (this.group_type != _o_.group_type) return false;
/* 101 */       if (this.masterid != _o_.masterid) return false;
/* 102 */       if (this.create_time != _o_.create_time) return false;
/* 103 */       if (!this.group_name.equals(_o_.group_name)) return false;
/* 104 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 105 */       if (!this.image_member_list.equals(_o_.image_member_list)) return false;
/* 106 */       if (!this.member_list.equals(_o_.member_list)) return false;
/* 107 */       if (this.member_num != _o_.member_num) return false;
/* 108 */       if (this.info_version != _o_.info_version) return false;
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 115 */     int _h_ = 0;
/* 116 */     _h_ += (int)this.groupid;
/* 117 */     _h_ += this.group_type;
/* 118 */     _h_ += (int)this.masterid;
/* 119 */     _h_ += this.create_time;
/* 120 */     _h_ += this.group_name.hashCode();
/* 121 */     _h_ += this.announcement.hashCode();
/* 122 */     _h_ += this.image_member_list.hashCode();
/* 123 */     _h_ += this.member_list.hashCode();
/* 124 */     _h_ += this.member_num;
/* 125 */     _h_ += (int)this.info_version;
/* 126 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder _sb_ = new StringBuilder();
/* 131 */     _sb_.append("(");
/* 132 */     _sb_.append(this.groupid).append(",");
/* 133 */     _sb_.append(this.group_type).append(",");
/* 134 */     _sb_.append(this.masterid).append(",");
/* 135 */     _sb_.append(this.create_time).append(",");
/* 136 */     _sb_.append("B").append(this.group_name.size()).append(",");
/* 137 */     _sb_.append("B").append(this.announcement.size()).append(",");
/* 138 */     _sb_.append(this.image_member_list).append(",");
/* 139 */     _sb_.append(this.member_list).append(",");
/* 140 */     _sb_.append(this.member_num).append(",");
/* 141 */     _sb_.append(this.info_version).append(",");
/* 142 */     _sb_.append(")");
/* 143 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */