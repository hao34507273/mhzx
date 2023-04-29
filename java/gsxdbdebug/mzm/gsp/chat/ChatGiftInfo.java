/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class ChatGiftInfo implements Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public int rolelevel;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int avatarid;
/*     */   public int avatar_frame_id;
/*     */   public long chatgiftid;
/*     */   public String rolename;
/*     */   public String chatgiftstr;
/*     */   public LinkedList<GetChatGiftInfo> getchatgiftinfo;
/*     */   public int chatgiftnum;
/*     */   public int chatgifttype;
/*     */   
/*     */   public ChatGiftInfo()
/*     */   {
/*  25 */     this.rolename = "";
/*  26 */     this.chatgiftstr = "";
/*  27 */     this.getchatgiftinfo = new LinkedList();
/*     */   }
/*     */   
/*     */   public ChatGiftInfo(long _roleid_, int _rolelevel_, int _menpai_, int _gender_, int _avatarid_, int _avatar_frame_id_, long _chatgiftid_, String _rolename_, String _chatgiftstr_, LinkedList<GetChatGiftInfo> _getchatgiftinfo_, int _chatgiftnum_, int _chatgifttype_) {
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.rolelevel = _rolelevel_;
/*  33 */     this.menpai = _menpai_;
/*  34 */     this.gender = _gender_;
/*  35 */     this.avatarid = _avatarid_;
/*  36 */     this.avatar_frame_id = _avatar_frame_id_;
/*  37 */     this.chatgiftid = _chatgiftid_;
/*  38 */     this.rolename = _rolename_;
/*  39 */     this.chatgiftstr = _chatgiftstr_;
/*  40 */     this.getchatgiftinfo = _getchatgiftinfo_;
/*  41 */     this.chatgiftnum = _chatgiftnum_;
/*  42 */     this.chatgifttype = _chatgifttype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (GetChatGiftInfo _v_ : this.getchatgiftinfo)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.rolelevel);
/*  54 */     _os_.marshal(this.menpai);
/*  55 */     _os_.marshal(this.gender);
/*  56 */     _os_.marshal(this.avatarid);
/*  57 */     _os_.marshal(this.avatar_frame_id);
/*  58 */     _os_.marshal(this.chatgiftid);
/*  59 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  60 */     _os_.marshal(this.chatgiftstr, "UTF-16LE");
/*  61 */     _os_.compact_uint32(this.getchatgiftinfo.size());
/*  62 */     for (GetChatGiftInfo _v_ : this.getchatgiftinfo) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     _os_.marshal(this.chatgiftnum);
/*  66 */     _os_.marshal(this.chatgifttype);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.roleid = _os_.unmarshal_long();
/*  72 */     this.rolelevel = _os_.unmarshal_int();
/*  73 */     this.menpai = _os_.unmarshal_int();
/*  74 */     this.gender = _os_.unmarshal_int();
/*  75 */     this.avatarid = _os_.unmarshal_int();
/*  76 */     this.avatar_frame_id = _os_.unmarshal_int();
/*  77 */     this.chatgiftid = _os_.unmarshal_long();
/*  78 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  79 */     this.chatgiftstr = _os_.unmarshal_String("UTF-16LE");
/*  80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  81 */       GetChatGiftInfo _v_ = new GetChatGiftInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.getchatgiftinfo.add(_v_);
/*     */     }
/*  85 */     this.chatgiftnum = _os_.unmarshal_int();
/*  86 */     this.chatgifttype = _os_.unmarshal_int();
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof ChatGiftInfo)) {
/*  93 */       ChatGiftInfo _o_ = (ChatGiftInfo)_o1_;
/*  94 */       if (this.roleid != _o_.roleid) return false;
/*  95 */       if (this.rolelevel != _o_.rolelevel) return false;
/*  96 */       if (this.menpai != _o_.menpai) return false;
/*  97 */       if (this.gender != _o_.gender) return false;
/*  98 */       if (this.avatarid != _o_.avatarid) return false;
/*  99 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 100 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/* 101 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 102 */       if (!this.chatgiftstr.equals(_o_.chatgiftstr)) return false;
/* 103 */       if (!this.getchatgiftinfo.equals(_o_.getchatgiftinfo)) return false;
/* 104 */       if (this.chatgiftnum != _o_.chatgiftnum) return false;
/* 105 */       if (this.chatgifttype != _o_.chatgifttype) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += (int)this.roleid;
/* 114 */     _h_ += this.rolelevel;
/* 115 */     _h_ += this.menpai;
/* 116 */     _h_ += this.gender;
/* 117 */     _h_ += this.avatarid;
/* 118 */     _h_ += this.avatar_frame_id;
/* 119 */     _h_ += (int)this.chatgiftid;
/* 120 */     _h_ += this.rolename.hashCode();
/* 121 */     _h_ += this.chatgiftstr.hashCode();
/* 122 */     _h_ += this.getchatgiftinfo.hashCode();
/* 123 */     _h_ += this.chatgiftnum;
/* 124 */     _h_ += this.chatgifttype;
/* 125 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 129 */     StringBuilder _sb_ = new StringBuilder();
/* 130 */     _sb_.append("(");
/* 131 */     _sb_.append(this.roleid).append(",");
/* 132 */     _sb_.append(this.rolelevel).append(",");
/* 133 */     _sb_.append(this.menpai).append(",");
/* 134 */     _sb_.append(this.gender).append(",");
/* 135 */     _sb_.append(this.avatarid).append(",");
/* 136 */     _sb_.append(this.avatar_frame_id).append(",");
/* 137 */     _sb_.append(this.chatgiftid).append(",");
/* 138 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 139 */     _sb_.append("T").append(this.chatgiftstr.length()).append(",");
/* 140 */     _sb_.append(this.getchatgiftinfo).append(",");
/* 141 */     _sb_.append(this.chatgiftnum).append(",");
/* 142 */     _sb_.append(this.chatgifttype).append(",");
/* 143 */     _sb_.append(")");
/* 144 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\ChatGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */