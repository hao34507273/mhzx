/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleCrossFieldNotifyMatchResultReq
/*     */   implements Marshal, Comparable<SingleCrossFieldNotifyMatchResultReq>
/*     */ {
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_FAIL = 1;
/*     */   public byte result;
/*     */   public long game_server_contextid;
/*     */   public long matcher_server_contextid;
/*     */   public int roam_zoneid;
/*     */   public long roam_room_instanceid;
/*     */   
/*     */   public SingleCrossFieldNotifyMatchResultReq() {}
/*     */   
/*     */   public SingleCrossFieldNotifyMatchResultReq(byte _result_, long _game_server_contextid_, long _matcher_server_contextid_, int _roam_zoneid_, long _roam_room_instanceid_)
/*     */   {
/*  24 */     this.result = _result_;
/*  25 */     this.game_server_contextid = _game_server_contextid_;
/*  26 */     this.matcher_server_contextid = _matcher_server_contextid_;
/*  27 */     this.roam_zoneid = _roam_zoneid_;
/*  28 */     this.roam_room_instanceid = _roam_room_instanceid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  36 */     _os_.marshal(this.result);
/*  37 */     _os_.marshal(this.game_server_contextid);
/*  38 */     _os_.marshal(this.matcher_server_contextid);
/*  39 */     _os_.marshal(this.roam_zoneid);
/*  40 */     _os_.marshal(this.roam_room_instanceid);
/*  41 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  45 */     this.result = _os_.unmarshal_byte();
/*  46 */     this.game_server_contextid = _os_.unmarshal_long();
/*  47 */     this.matcher_server_contextid = _os_.unmarshal_long();
/*  48 */     this.roam_zoneid = _os_.unmarshal_int();
/*  49 */     this.roam_room_instanceid = _os_.unmarshal_long();
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  54 */     if (_o1_ == this) return true;
/*  55 */     if ((_o1_ instanceof SingleCrossFieldNotifyMatchResultReq)) {
/*  56 */       SingleCrossFieldNotifyMatchResultReq _o_ = (SingleCrossFieldNotifyMatchResultReq)_o1_;
/*  57 */       if (this.result != _o_.result) return false;
/*  58 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/*  59 */       if (this.matcher_server_contextid != _o_.matcher_server_contextid) return false;
/*  60 */       if (this.roam_zoneid != _o_.roam_zoneid) return false;
/*  61 */       if (this.roam_room_instanceid != _o_.roam_room_instanceid) return false;
/*  62 */       return true;
/*     */     }
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  68 */     int _h_ = 0;
/*  69 */     _h_ += this.result;
/*  70 */     _h_ += (int)this.game_server_contextid;
/*  71 */     _h_ += (int)this.matcher_server_contextid;
/*  72 */     _h_ += this.roam_zoneid;
/*  73 */     _h_ += (int)this.roam_room_instanceid;
/*  74 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  78 */     StringBuilder _sb_ = new StringBuilder();
/*  79 */     _sb_.append("(");
/*  80 */     _sb_.append(this.result).append(",");
/*  81 */     _sb_.append(this.game_server_contextid).append(",");
/*  82 */     _sb_.append(this.matcher_server_contextid).append(",");
/*  83 */     _sb_.append(this.roam_zoneid).append(",");
/*  84 */     _sb_.append(this.roam_room_instanceid).append(",");
/*  85 */     _sb_.append(")");
/*  86 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SingleCrossFieldNotifyMatchResultReq _o_) {
/*  90 */     if (_o_ == this) return 0;
/*  91 */     int _c_ = 0;
/*  92 */     _c_ = this.result - _o_.result;
/*  93 */     if (0 != _c_) return _c_;
/*  94 */     _c_ = Long.signum(this.game_server_contextid - _o_.game_server_contextid);
/*  95 */     if (0 != _c_) return _c_;
/*  96 */     _c_ = Long.signum(this.matcher_server_contextid - _o_.matcher_server_contextid);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.roam_zoneid - _o_.roam_zoneid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = Long.signum(this.roam_room_instanceid - _o_.roam_room_instanceid);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SingleCrossFieldNotifyMatchResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */