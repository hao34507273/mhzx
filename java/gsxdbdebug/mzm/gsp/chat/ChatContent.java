/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class ChatContent implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int gender;
/*     */   public int occupationid;
/*     */   public int avatarid;
/*     */   public int avatar_frame_id;
/*     */   public int level;
/*     */   public byte viplevel;
/*     */   public int modelid;
/*     */   public ArrayList<Integer> badge;
/*     */   public int contenttype;
/*     */   public com.goldhuman.Common.Octets content;
/*     */   public int chatbubblecfgid;
/*     */   public long timestamp;
/*     */   
/*     */   public ChatContent()
/*     */   {
/*  25 */     this.rolename = "";
/*  26 */     this.badge = new ArrayList();
/*  27 */     this.content = new com.goldhuman.Common.Octets();
/*     */   }
/*     */   
/*     */   public ChatContent(long _roleid_, String _rolename_, int _gender_, int _occupationid_, int _avatarid_, int _avatar_frame_id_, int _level_, byte _viplevel_, int _modelid_, ArrayList<Integer> _badge_, int _contenttype_, com.goldhuman.Common.Octets _content_, int _chatbubblecfgid_, long _timestamp_) {
/*  31 */     this.roleid = _roleid_;
/*  32 */     this.rolename = _rolename_;
/*  33 */     this.gender = _gender_;
/*  34 */     this.occupationid = _occupationid_;
/*  35 */     this.avatarid = _avatarid_;
/*  36 */     this.avatar_frame_id = _avatar_frame_id_;
/*  37 */     this.level = _level_;
/*  38 */     this.viplevel = _viplevel_;
/*  39 */     this.modelid = _modelid_;
/*  40 */     this.badge = _badge_;
/*  41 */     this.contenttype = _contenttype_;
/*  42 */     this.content = _content_;
/*  43 */     this.chatbubblecfgid = _chatbubblecfgid_;
/*  44 */     this.timestamp = _timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  54 */     _os_.marshal(this.gender);
/*  55 */     _os_.marshal(this.occupationid);
/*  56 */     _os_.marshal(this.avatarid);
/*  57 */     _os_.marshal(this.avatar_frame_id);
/*  58 */     _os_.marshal(this.level);
/*  59 */     _os_.marshal(this.viplevel);
/*  60 */     _os_.marshal(this.modelid);
/*  61 */     _os_.compact_uint32(this.badge.size());
/*  62 */     for (Integer _v_ : this.badge) {
/*  63 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  65 */     _os_.marshal(this.contenttype);
/*  66 */     _os_.marshal(this.content);
/*  67 */     _os_.marshal(this.chatbubblecfgid);
/*  68 */     _os_.marshal(this.timestamp);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  73 */     this.roleid = _os_.unmarshal_long();
/*  74 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  75 */     this.gender = _os_.unmarshal_int();
/*  76 */     this.occupationid = _os_.unmarshal_int();
/*  77 */     this.avatarid = _os_.unmarshal_int();
/*  78 */     this.avatar_frame_id = _os_.unmarshal_int();
/*  79 */     this.level = _os_.unmarshal_int();
/*  80 */     this.viplevel = _os_.unmarshal_byte();
/*  81 */     this.modelid = _os_.unmarshal_int();
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  84 */       int _v_ = _os_.unmarshal_int();
/*  85 */       this.badge.add(Integer.valueOf(_v_));
/*     */     }
/*  87 */     this.contenttype = _os_.unmarshal_int();
/*  88 */     this.content = _os_.unmarshal_Octets();
/*  89 */     this.chatbubblecfgid = _os_.unmarshal_int();
/*  90 */     this.timestamp = _os_.unmarshal_long();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof ChatContent)) {
/*  97 */       ChatContent _o_ = (ChatContent)_o1_;
/*  98 */       if (this.roleid != _o_.roleid) return false;
/*  99 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 100 */       if (this.gender != _o_.gender) return false;
/* 101 */       if (this.occupationid != _o_.occupationid) return false;
/* 102 */       if (this.avatarid != _o_.avatarid) return false;
/* 103 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 104 */       if (this.level != _o_.level) return false;
/* 105 */       if (this.viplevel != _o_.viplevel) return false;
/* 106 */       if (this.modelid != _o_.modelid) return false;
/* 107 */       if (!this.badge.equals(_o_.badge)) return false;
/* 108 */       if (this.contenttype != _o_.contenttype) return false;
/* 109 */       if (!this.content.equals(_o_.content)) return false;
/* 110 */       if (this.chatbubblecfgid != _o_.chatbubblecfgid) return false;
/* 111 */       if (this.timestamp != _o_.timestamp) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += (int)this.roleid;
/* 120 */     _h_ += this.rolename.hashCode();
/* 121 */     _h_ += this.gender;
/* 122 */     _h_ += this.occupationid;
/* 123 */     _h_ += this.avatarid;
/* 124 */     _h_ += this.avatar_frame_id;
/* 125 */     _h_ += this.level;
/* 126 */     _h_ += this.viplevel;
/* 127 */     _h_ += this.modelid;
/* 128 */     _h_ += this.badge.hashCode();
/* 129 */     _h_ += this.contenttype;
/* 130 */     _h_ += this.content.hashCode();
/* 131 */     _h_ += this.chatbubblecfgid;
/* 132 */     _h_ += (int)this.timestamp;
/* 133 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 137 */     StringBuilder _sb_ = new StringBuilder();
/* 138 */     _sb_.append("(");
/* 139 */     _sb_.append(this.roleid).append(",");
/* 140 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 141 */     _sb_.append(this.gender).append(",");
/* 142 */     _sb_.append(this.occupationid).append(",");
/* 143 */     _sb_.append(this.avatarid).append(",");
/* 144 */     _sb_.append(this.avatar_frame_id).append(",");
/* 145 */     _sb_.append(this.level).append(",");
/* 146 */     _sb_.append(this.viplevel).append(",");
/* 147 */     _sb_.append(this.modelid).append(",");
/* 148 */     _sb_.append(this.badge).append(",");
/* 149 */     _sb_.append(this.contenttype).append(",");
/* 150 */     _sb_.append("B").append(this.content.size()).append(",");
/* 151 */     _sb_.append(this.chatbubblecfgid).append(",");
/* 152 */     _sb_.append(this.timestamp).append(",");
/* 153 */     _sb_.append(")");
/* 154 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\ChatContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */