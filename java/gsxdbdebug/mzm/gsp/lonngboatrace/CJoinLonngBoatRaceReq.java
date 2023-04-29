/*    */ package mzm.gsp.lonngboatrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.lonngboatrace.main.PCJoinLonngBoatRaceActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJoinLonngBoatRaceReq
/*    */   extends __CJoinLonngBoatRaceReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619269;
/*    */   public int activityid;
/*    */   public int raceid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PCJoinLonngBoatRaceActivity(roleId, this.activityid, this.raceid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12619269;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CJoinLonngBoatRaceReq() {}
/*    */   
/*    */ 
/*    */   public CJoinLonngBoatRaceReq(int _activityid_, int _raceid_)
/*    */   {
/* 38 */     this.activityid = _activityid_;
/* 39 */     this.raceid = _raceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     _os_.marshal(this.raceid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.activityid = _os_.unmarshal_int();
/* 54 */     this.raceid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CJoinLonngBoatRaceReq)) {
/* 64 */       CJoinLonngBoatRaceReq _o_ = (CJoinLonngBoatRaceReq)_o1_;
/* 65 */       if (this.activityid != _o_.activityid) return false;
/* 66 */       if (this.raceid != _o_.raceid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.activityid;
/* 75 */     _h_ += this.raceid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.activityid).append(",");
/* 83 */     _sb_.append(this.raceid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinLonngBoatRaceReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.activityid - _o_.activityid;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.raceid - _o_.raceid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\CJoinLonngBoatRaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */