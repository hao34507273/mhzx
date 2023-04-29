/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class JoinPointRaceReq
/*    */   implements Marshal
/*    */ {
/*    */   public int zoneid;
/*    */   public long game_server_contextid;
/*    */   public PointRaceInfo point_race_info;
/*    */   
/*    */   public JoinPointRaceReq()
/*    */   {
/* 16 */     this.zoneid = 0;
/* 17 */     this.game_server_contextid = 0L;
/* 18 */     this.point_race_info = new PointRaceInfo();
/*    */   }
/*    */   
/*    */   public JoinPointRaceReq(int _zoneid_, long _game_server_contextid_, PointRaceInfo _point_race_info_) {
/* 22 */     this.zoneid = _zoneid_;
/* 23 */     this.game_server_contextid = _game_server_contextid_;
/* 24 */     this.point_race_info = _point_race_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     if (!this.point_race_info._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.zoneid);
/* 34 */     _os_.marshal(this.game_server_contextid);
/* 35 */     _os_.marshal(this.point_race_info);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.zoneid = _os_.unmarshal_int();
/* 41 */     this.game_server_contextid = _os_.unmarshal_long();
/* 42 */     this.point_race_info.unmarshal(_os_);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof JoinPointRaceReq)) {
/* 49 */       JoinPointRaceReq _o_ = (JoinPointRaceReq)_o1_;
/* 50 */       if (this.zoneid != _o_.zoneid) return false;
/* 51 */       if (this.game_server_contextid != _o_.game_server_contextid) return false;
/* 52 */       if (!this.point_race_info.equals(_o_.point_race_info)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.zoneid;
/* 61 */     _h_ += (int)this.game_server_contextid;
/* 62 */     _h_ += this.point_race_info.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.zoneid).append(",");
/* 70 */     _sb_.append(this.game_server_contextid).append(",");
/* 71 */     _sb_.append(this.point_race_info).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\JoinPointRaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */