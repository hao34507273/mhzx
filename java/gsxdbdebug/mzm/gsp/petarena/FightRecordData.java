/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class FightRecordData
/*     */   implements Marshal
/*     */ {
/*     */   public static final int ATTACK = 0;
/*     */   public static final int DEFEND = 1;
/*     */   public long recordid;
/*     */   public int record_type;
/*     */   public int is_win;
/*     */   public int old_rank;
/*     */   public int new_rank;
/*     */   public int fight_time;
/*     */   public long roleid;
/*     */   public int avatar;
/*     */   public int avatar_frame;
/*     */   public Octets name;
/*     */   public int occupation;
/*     */   public byte gender;
/*     */   
/*     */   public FightRecordData()
/*     */   {
/*  28 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public FightRecordData(long _recordid_, int _record_type_, int _is_win_, int _old_rank_, int _new_rank_, int _fight_time_, long _roleid_, int _avatar_, int _avatar_frame_, Octets _name_, int _occupation_, byte _gender_) {
/*  32 */     this.recordid = _recordid_;
/*  33 */     this.record_type = _record_type_;
/*  34 */     this.is_win = _is_win_;
/*  35 */     this.old_rank = _old_rank_;
/*  36 */     this.new_rank = _new_rank_;
/*  37 */     this.fight_time = _fight_time_;
/*  38 */     this.roleid = _roleid_;
/*  39 */     this.avatar = _avatar_;
/*  40 */     this.avatar_frame = _avatar_frame_;
/*  41 */     this.name = _name_;
/*  42 */     this.occupation = _occupation_;
/*  43 */     this.gender = _gender_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.recordid);
/*  52 */     _os_.marshal(this.record_type);
/*  53 */     _os_.marshal(this.is_win);
/*  54 */     _os_.marshal(this.old_rank);
/*  55 */     _os_.marshal(this.new_rank);
/*  56 */     _os_.marshal(this.fight_time);
/*  57 */     _os_.marshal(this.roleid);
/*  58 */     _os_.marshal(this.avatar);
/*  59 */     _os_.marshal(this.avatar_frame);
/*  60 */     _os_.marshal(this.name);
/*  61 */     _os_.marshal(this.occupation);
/*  62 */     _os_.marshal(this.gender);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.recordid = _os_.unmarshal_long();
/*  68 */     this.record_type = _os_.unmarshal_int();
/*  69 */     this.is_win = _os_.unmarshal_int();
/*  70 */     this.old_rank = _os_.unmarshal_int();
/*  71 */     this.new_rank = _os_.unmarshal_int();
/*  72 */     this.fight_time = _os_.unmarshal_int();
/*  73 */     this.roleid = _os_.unmarshal_long();
/*  74 */     this.avatar = _os_.unmarshal_int();
/*  75 */     this.avatar_frame = _os_.unmarshal_int();
/*  76 */     this.name = _os_.unmarshal_Octets();
/*  77 */     this.occupation = _os_.unmarshal_int();
/*  78 */     this.gender = _os_.unmarshal_byte();
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof FightRecordData)) {
/*  85 */       FightRecordData _o_ = (FightRecordData)_o1_;
/*  86 */       if (this.recordid != _o_.recordid) return false;
/*  87 */       if (this.record_type != _o_.record_type) return false;
/*  88 */       if (this.is_win != _o_.is_win) return false;
/*  89 */       if (this.old_rank != _o_.old_rank) return false;
/*  90 */       if (this.new_rank != _o_.new_rank) return false;
/*  91 */       if (this.fight_time != _o_.fight_time) return false;
/*  92 */       if (this.roleid != _o_.roleid) return false;
/*  93 */       if (this.avatar != _o_.avatar) return false;
/*  94 */       if (this.avatar_frame != _o_.avatar_frame) return false;
/*  95 */       if (!this.name.equals(_o_.name)) return false;
/*  96 */       if (this.occupation != _o_.occupation) return false;
/*  97 */       if (this.gender != _o_.gender) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += (int)this.recordid;
/* 106 */     _h_ += this.record_type;
/* 107 */     _h_ += this.is_win;
/* 108 */     _h_ += this.old_rank;
/* 109 */     _h_ += this.new_rank;
/* 110 */     _h_ += this.fight_time;
/* 111 */     _h_ += (int)this.roleid;
/* 112 */     _h_ += this.avatar;
/* 113 */     _h_ += this.avatar_frame;
/* 114 */     _h_ += this.name.hashCode();
/* 115 */     _h_ += this.occupation;
/* 116 */     _h_ += this.gender;
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.recordid).append(",");
/* 124 */     _sb_.append(this.record_type).append(",");
/* 125 */     _sb_.append(this.is_win).append(",");
/* 126 */     _sb_.append(this.old_rank).append(",");
/* 127 */     _sb_.append(this.new_rank).append(",");
/* 128 */     _sb_.append(this.fight_time).append(",");
/* 129 */     _sb_.append(this.roleid).append(",");
/* 130 */     _sb_.append(this.avatar).append(",");
/* 131 */     _sb_.append(this.avatar_frame).append(",");
/* 132 */     _sb_.append("B").append(this.name.size()).append(",");
/* 133 */     _sb_.append(this.occupation).append(",");
/* 134 */     _sb_.append(this.gender).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\FightRecordData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */