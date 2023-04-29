/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class NotifyPointRaceResultReq
/*     */   implements Marshal, Comparable<NotifyPointRaceResultReq>
/*     */ {
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_FAIL = 1;
/*     */   public byte result;
/*     */   public long matcher_server_contextid;
/*     */   public long game_server_contextid;
/*     */   public int roam_zoneid;
/*     */   public long roam_room_instanceid;
/*     */   
/*     */   public NotifyPointRaceResultReq()
/*     */   {
/*  21 */     this.result = 1;
/*  22 */     this.matcher_server_contextid = 0L;
/*  23 */     this.game_server_contextid = 0L;
/*  24 */     this.roam_zoneid = 0;
/*  25 */     this.roam_room_instanceid = 0L;
/*     */   }
/*     */   
/*     */   public NotifyPointRaceResultReq(byte _result_, long _matcher_server_contextid_, long _game_server_contextid_, int _roam_zoneid_, long _roam_room_instanceid_) {
/*  29 */     this.result = _result_;
/*  30 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  31 */     this.game_server_contextid = _game_server_contextid_;
/*  32 */     this.roam_zoneid = _roam_zoneid_;
/*  33 */     this.roam_room_instanceid = _roam_room_instanceid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.result);
/*  42 */     _os_.marshal(this.matcher_server_contextid);
/*  43 */     _os_.marshal(this.game_server_contextid);
/*  44 */     _os_.marshal(this.roam_zoneid);
/*  45 */     _os_.marshal(this.roam_room_instanceid);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  50 */     this.result = _os_.unmarshal_byte();
/*  51 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  52 */     this.game_server_contextid = _os_.unmarshal_long();
/*  53 */     this.roam_zoneid = _os_.unmarshal_int();
/*  54 */     this.roam_room_instanceid = _os_.unmarshal_long();
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  59 */     if (_o1_ == this) return true;
/*  60 */     if ((_o1_ instanceof NotifyPointRaceResultReq)) {
/*  61 */       NotifyPointRaceResultReq _o_ = (NotifyPointRaceResultReq)_o1_;
/*  62 */       if (this.result != _o_.result) return false;
/*  63 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  64 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  65 */       if (this.roam_zoneid != _o_.roam_zoneid) return false;
/*  66 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/*  67 */       return true;
/*     */     }
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  73 */     int _h_ = 0;
/*  74 */     _h_ += this.result;
/*  75 */     _h_ += (int)this.matcher_server_contextid;
/*  76 */     _h_ += (int)this.game_server_contextid;
/*  77 */     _h_ += this.roam_zoneid;
/*  78 */     _h_ += (int)this.roam_room_instanceid;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.result).append(",");
/*  86 */     _sb_.append(this.matcher_server_contextid).append(",");
/*  87 */     _sb_.append(this.game_server_contextid).append(",");
/*  88 */     _sb_.append(this.roam_zoneid).append(",");
/*  89 */     _sb_.append(this.roam_room_instanceid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(NotifyPointRaceResultReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.result - _o_.result;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.roam_zoneid - _o_.roam_zoneid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.roam_room_instanceid - _o_.roam_room_instanceid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyPointRaceResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */