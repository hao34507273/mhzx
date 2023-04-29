/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class CombineGang implements Marshal
/*     */ {
/*     */   public long gangid;
/*     */   public String name;
/*     */   public int level;
/*     */   public int normal_num;
/*     */   public int normal_capacity;
/*     */   public int vitality;
/*     */   public String purpose;
/*     */   public long leader_id;
/*     */   public String leader_name;
/*     */   public int leader_level;
/*     */   public int leader_menpai;
/*     */   public int leader_gender;
/*     */   public int leader_avatarid;
/*     */   public int leader_avatar_frame;
/*     */   public long displayid;
/*     */   
/*     */   public CombineGang()
/*     */   {
/*  26 */     this.gangid = -1L;
/*  27 */     this.name = "";
/*  28 */     this.purpose = "";
/*  29 */     this.leader_name = "";
/*     */   }
/*     */   
/*     */   public CombineGang(long _gangid_, String _name_, int _level_, int _normal_num_, int _normal_capacity_, int _vitality_, String _purpose_, long _leader_id_, String _leader_name_, int _leader_level_, int _leader_menpai_, int _leader_gender_, int _leader_avatarid_, int _leader_avatar_frame_, long _displayid_) {
/*  33 */     this.gangid = _gangid_;
/*  34 */     this.name = _name_;
/*  35 */     this.level = _level_;
/*  36 */     this.normal_num = _normal_num_;
/*  37 */     this.normal_capacity = _normal_capacity_;
/*  38 */     this.vitality = _vitality_;
/*  39 */     this.purpose = _purpose_;
/*  40 */     this.leader_id = _leader_id_;
/*  41 */     this.leader_name = _leader_name_;
/*  42 */     this.leader_level = _leader_level_;
/*  43 */     this.leader_menpai = _leader_menpai_;
/*  44 */     this.leader_gender = _leader_gender_;
/*  45 */     this.leader_avatarid = _leader_avatarid_;
/*  46 */     this.leader_avatar_frame = _leader_avatar_frame_;
/*  47 */     this.displayid = _displayid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.gangid);
/*  56 */     _os_.marshal(this.name, "UTF-16LE");
/*  57 */     _os_.marshal(this.level);
/*  58 */     _os_.marshal(this.normal_num);
/*  59 */     _os_.marshal(this.normal_capacity);
/*  60 */     _os_.marshal(this.vitality);
/*  61 */     _os_.marshal(this.purpose, "UTF-16LE");
/*  62 */     _os_.marshal(this.leader_id);
/*  63 */     _os_.marshal(this.leader_name, "UTF-16LE");
/*  64 */     _os_.marshal(this.leader_level);
/*  65 */     _os_.marshal(this.leader_menpai);
/*  66 */     _os_.marshal(this.leader_gender);
/*  67 */     _os_.marshal(this.leader_avatarid);
/*  68 */     _os_.marshal(this.leader_avatar_frame);
/*  69 */     _os_.marshal(this.displayid);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  74 */     this.gangid = _os_.unmarshal_long();
/*  75 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  76 */     this.level = _os_.unmarshal_int();
/*  77 */     this.normal_num = _os_.unmarshal_int();
/*  78 */     this.normal_capacity = _os_.unmarshal_int();
/*  79 */     this.vitality = _os_.unmarshal_int();
/*  80 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/*  81 */     this.leader_id = _os_.unmarshal_long();
/*  82 */     this.leader_name = _os_.unmarshal_String("UTF-16LE");
/*  83 */     this.leader_level = _os_.unmarshal_int();
/*  84 */     this.leader_menpai = _os_.unmarshal_int();
/*  85 */     this.leader_gender = _os_.unmarshal_int();
/*  86 */     this.leader_avatarid = _os_.unmarshal_int();
/*  87 */     this.leader_avatar_frame = _os_.unmarshal_int();
/*  88 */     this.displayid = _os_.unmarshal_long();
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof CombineGang)) {
/*  95 */       CombineGang _o_ = (CombineGang)_o1_;
/*  96 */       if (this.gangid != _o_.gangid) return false;
/*  97 */       if (!this.name.equals(_o_.name)) return false;
/*  98 */       if (this.level != _o_.level) return false;
/*  99 */       if (this.normal_num != _o_.normal_num) return false;
/* 100 */       if (this.normal_capacity != _o_.normal_capacity) return false;
/* 101 */       if (this.vitality != _o_.vitality) return false;
/* 102 */       if (!this.purpose.equals(_o_.purpose)) return false;
/* 103 */       if (this.leader_id != _o_.leader_id) return false;
/* 104 */       if (!this.leader_name.equals(_o_.leader_name)) return false;
/* 105 */       if (this.leader_level != _o_.leader_level) return false;
/* 106 */       if (this.leader_menpai != _o_.leader_menpai) return false;
/* 107 */       if (this.leader_gender != _o_.leader_gender) return false;
/* 108 */       if (this.leader_avatarid != _o_.leader_avatarid) return false;
/* 109 */       if (this.leader_avatar_frame != _o_.leader_avatar_frame) return false;
/* 110 */       if (this.displayid != _o_.displayid) return false;
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 117 */     int _h_ = 0;
/* 118 */     _h_ += (int)this.gangid;
/* 119 */     _h_ += this.name.hashCode();
/* 120 */     _h_ += this.level;
/* 121 */     _h_ += this.normal_num;
/* 122 */     _h_ += this.normal_capacity;
/* 123 */     _h_ += this.vitality;
/* 124 */     _h_ += this.purpose.hashCode();
/* 125 */     _h_ += (int)this.leader_id;
/* 126 */     _h_ += this.leader_name.hashCode();
/* 127 */     _h_ += this.leader_level;
/* 128 */     _h_ += this.leader_menpai;
/* 129 */     _h_ += this.leader_gender;
/* 130 */     _h_ += this.leader_avatarid;
/* 131 */     _h_ += this.leader_avatar_frame;
/* 132 */     _h_ += (int)this.displayid;
/* 133 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 137 */     StringBuilder _sb_ = new StringBuilder();
/* 138 */     _sb_.append("(");
/* 139 */     _sb_.append(this.gangid).append(",");
/* 140 */     _sb_.append("T").append(this.name.length()).append(",");
/* 141 */     _sb_.append(this.level).append(",");
/* 142 */     _sb_.append(this.normal_num).append(",");
/* 143 */     _sb_.append(this.normal_capacity).append(",");
/* 144 */     _sb_.append(this.vitality).append(",");
/* 145 */     _sb_.append("T").append(this.purpose.length()).append(",");
/* 146 */     _sb_.append(this.leader_id).append(",");
/* 147 */     _sb_.append("T").append(this.leader_name.length()).append(",");
/* 148 */     _sb_.append(this.leader_level).append(",");
/* 149 */     _sb_.append(this.leader_menpai).append(",");
/* 150 */     _sb_.append(this.leader_gender).append(",");
/* 151 */     _sb_.append(this.leader_avatarid).append(",");
/* 152 */     _sb_.append(this.leader_avatar_frame).append(",");
/* 153 */     _sb_.append(this.displayid).append(",");
/* 154 */     _sb_.append(")");
/* 155 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CombineGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */