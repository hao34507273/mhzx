/*     */ package mzm.gsp.group;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GroupMemberInfo
/*     */   implements Marshal
/*     */ {
/*     */   public static final int ONLINE_STATE_ONLINE = 1;
/*     */   public static final int ONLINE_STATE_OFFLINE = 2;
/*     */   public static final int MSG_STATE_ACCEPT = 1;
/*     */   public static final int MSG_STATE_REFUSE = 2;
/*     */   public long roleid;
/*     */   public Octets name;
/*     */   public int level;
/*     */   public int menpai;
/*     */   public byte gender;
/*     */   public int avatarid;
/*     */   public int avatar_frame_id;
/*     */   public byte online_state;
/*     */   public int join_time;
/*     */   
/*     */   public GroupMemberInfo()
/*     */   {
/*  27 */     this.name = new Octets();
/*     */   }
/*     */   
/*     */   public GroupMemberInfo(long _roleid_, Octets _name_, int _level_, int _menpai_, byte _gender_, int _avatarid_, int _avatar_frame_id_, byte _online_state_, int _join_time_) {
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.name = _name_;
/*  33 */     this.level = _level_;
/*  34 */     this.menpai = _menpai_;
/*  35 */     this.gender = _gender_;
/*  36 */     this.avatarid = _avatarid_;
/*  37 */     this.avatar_frame_id = _avatar_frame_id_;
/*  38 */     this.online_state = _online_state_;
/*  39 */     this.join_time = _join_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  47 */     _os_.marshal(this.roleid);
/*  48 */     _os_.marshal(this.name);
/*  49 */     _os_.marshal(this.level);
/*  50 */     _os_.marshal(this.menpai);
/*  51 */     _os_.marshal(this.gender);
/*  52 */     _os_.marshal(this.avatarid);
/*  53 */     _os_.marshal(this.avatar_frame_id);
/*  54 */     _os_.marshal(this.online_state);
/*  55 */     _os_.marshal(this.join_time);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.name = _os_.unmarshal_Octets();
/*  62 */     this.level = _os_.unmarshal_int();
/*  63 */     this.menpai = _os_.unmarshal_int();
/*  64 */     this.gender = _os_.unmarshal_byte();
/*  65 */     this.avatarid = _os_.unmarshal_int();
/*  66 */     this.avatar_frame_id = _os_.unmarshal_int();
/*  67 */     this.online_state = _os_.unmarshal_byte();
/*  68 */     this.join_time = _os_.unmarshal_int();
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof GroupMemberInfo)) {
/*  75 */       GroupMemberInfo _o_ = (GroupMemberInfo)_o1_;
/*  76 */       if (this.roleid != _o_.roleid) return false;
/*  77 */       if (!this.name.equals(_o_.name)) return false;
/*  78 */       if (this.level != _o_.level) return false;
/*  79 */       if (this.menpai != _o_.menpai) return false;
/*  80 */       if (this.gender != _o_.gender) return false;
/*  81 */       if (this.avatarid != _o_.avatarid) return false;
/*  82 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/*  83 */       if (this.online_state != _o_.online_state) return false;
/*  84 */       if (this.join_time != _o_.join_time) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.roleid;
/*  93 */     _h_ += this.name.hashCode();
/*  94 */     _h_ += this.level;
/*  95 */     _h_ += this.menpai;
/*  96 */     _h_ += this.gender;
/*  97 */     _h_ += this.avatarid;
/*  98 */     _h_ += this.avatar_frame_id;
/*  99 */     _h_ += this.online_state;
/* 100 */     _h_ += this.join_time;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.roleid).append(",");
/* 108 */     _sb_.append("B").append(this.name.size()).append(",");
/* 109 */     _sb_.append(this.level).append(",");
/* 110 */     _sb_.append(this.menpai).append(",");
/* 111 */     _sb_.append(this.gender).append(",");
/* 112 */     _sb_.append(this.avatarid).append(",");
/* 113 */     _sb_.append(this.avatar_frame_id).append(",");
/* 114 */     _sb_.append(this.online_state).append(",");
/* 115 */     _sb_.append(this.join_time).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\GroupMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */