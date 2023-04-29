/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GangTeamMember
/*    */   implements Marshal, Comparable<GangTeamMember>
/*    */ {
/*    */   public long roleid;
/*    */   public long join_time;
/*    */   
/*    */   public GangTeamMember() {}
/*    */   
/*    */   public GangTeamMember(long _roleid_, long _join_time_)
/*    */   {
/* 18 */     this.roleid = _roleid_;
/* 19 */     this.join_time = _join_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.roleid);
/* 28 */     _os_.marshal(this.join_time);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.roleid = _os_.unmarshal_long();
/* 34 */     this.join_time = _os_.unmarshal_long();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof GangTeamMember)) {
/* 41 */       GangTeamMember _o_ = (GangTeamMember)_o1_;
/* 42 */       if (this.roleid != _o_.roleid) return false;
/* 43 */       if (this.join_time != _o_.join_time) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += (int)this.roleid;
/* 52 */     _h_ += (int)this.join_time;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.roleid).append(",");
/* 60 */     _sb_.append(this.join_time).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GangTeamMember _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = Long.signum(this.join_time - _o_.join_time);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\GangTeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */