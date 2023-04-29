/*    */ package mzm.gsp.lonngboatrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.lonngboatrace.main.PCEntryLonngBoatRaceActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEntry
/*    */   extends __CEntry__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619272;
/*    */   public int activityid;
/*    */   public int raceid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PCEntryLonngBoatRaceActivity(roleId, this.activityid, this.raceid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12619272;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CEntry() {}
/*    */   
/*    */ 
/*    */   public CEntry(int _activityid_, int _raceid_)
/*    */   {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.raceid = _raceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.raceid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activityid = _os_.unmarshal_int();
/* 55 */     this.raceid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CEntry)) {
/* 65 */       CEntry _o_ = (CEntry)_o1_;
/* 66 */       if (this.activityid != _o_.activityid) return false;
/* 67 */       if (this.raceid != _o_.raceid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activityid;
/* 76 */     _h_ += this.raceid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activityid).append(",");
/* 84 */     _sb_.append(this.raceid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEntry _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.raceid - _o_.raceid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\CEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */