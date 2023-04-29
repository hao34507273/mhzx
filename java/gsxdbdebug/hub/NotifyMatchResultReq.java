/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class NotifyMatchResultReq
/*     */   implements Marshal
/*     */ {
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_FAIL = 1;
/*     */   public byte result;
/*     */   public long matcher_server_contextid;
/*     */   public long game_server_contextid;
/*     */   public int activity_context_typeid;
/*     */   public int roam_zoneid;
/*     */   public long roam_room_instanceid;
/*     */   public ArrayList<RoleMatchMarkingInfo> opponent_role_infos;
/*     */   
/*     */   public NotifyMatchResultReq()
/*     */   {
/*  23 */     this.result = 1;
/*  24 */     this.matcher_server_contextid = 0L;
/*  25 */     this.game_server_contextid = 0L;
/*  26 */     this.roam_zoneid = 0;
/*  27 */     this.roam_room_instanceid = 0L;
/*  28 */     this.opponent_role_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public NotifyMatchResultReq(byte _result_, long _matcher_server_contextid_, long _game_server_contextid_, int _activity_context_typeid_, int _roam_zoneid_, long _roam_room_instanceid_, ArrayList<RoleMatchMarkingInfo> _opponent_role_infos_) {
/*  32 */     this.result = _result_;
/*  33 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  34 */     this.game_server_contextid = _game_server_contextid_;
/*  35 */     this.activity_context_typeid = _activity_context_typeid_;
/*  36 */     this.roam_zoneid = _roam_zoneid_;
/*  37 */     this.roam_room_instanceid = _roam_room_instanceid_;
/*  38 */     this.opponent_role_infos = _opponent_role_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     for (RoleMatchMarkingInfo _v_ : this.opponent_role_infos)
/*  43 */       if (!_v_._validator_()) return false;
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.result);
/*  49 */     _os_.marshal(this.matcher_server_contextid);
/*  50 */     _os_.marshal(this.game_server_contextid);
/*  51 */     _os_.marshal(this.activity_context_typeid);
/*  52 */     _os_.marshal(this.roam_zoneid);
/*  53 */     _os_.marshal(this.roam_room_instanceid);
/*  54 */     _os_.compact_uint32(this.opponent_role_infos.size());
/*  55 */     for (RoleMatchMarkingInfo _v_ : this.opponent_role_infos) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.result = _os_.unmarshal_byte();
/*  63 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  64 */     this.game_server_contextid = _os_.unmarshal_long();
/*  65 */     this.activity_context_typeid = _os_.unmarshal_int();
/*  66 */     this.roam_zoneid = _os_.unmarshal_int();
/*  67 */     this.roam_room_instanceid = _os_.unmarshal_long();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       RoleMatchMarkingInfo _v_ = new RoleMatchMarkingInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.opponent_role_infos.add(_v_);
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof NotifyMatchResultReq)) {
/*  79 */       NotifyMatchResultReq _o_ = (NotifyMatchResultReq)_o1_;
/*  80 */       if (this.result != _o_.result) return false;
/*  81 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  82 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  83 */       if (this.activity_context_typeid != _o_.activity_context_typeid) return false;
/*  84 */       if (this.roam_zoneid != _o_.roam_zoneid) return false;
/*  85 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/*  86 */       if (!this.opponent_role_infos.equals(_o_.opponent_role_infos)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.result;
/*  95 */     _h_ += (int)this.matcher_server_contextid;
/*  96 */     _h_ += (int)this.game_server_contextid;
/*  97 */     _h_ += this.activity_context_typeid;
/*  98 */     _h_ += this.roam_zoneid;
/*  99 */     _h_ += (int)this.roam_room_instanceid;
/* 100 */     _h_ += this.opponent_role_infos.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.result).append(",");
/* 108 */     _sb_.append(this.matcher_server_contextid).append(",");
/* 109 */     _sb_.append(this.game_server_contextid).append(",");
/* 110 */     _sb_.append(this.activity_context_typeid).append(",");
/* 111 */     _sb_.append(this.roam_zoneid).append(",");
/* 112 */     _sb_.append(this.roam_room_instanceid).append(",");
/* 113 */     _sb_.append(this.opponent_role_infos).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyMatchResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */