/*    */ package mzm.gsp.floor;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.floor.main.PCPlayFastKillReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPlayFastKillReq
/*    */   extends __CPlayFastKillReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617733;
/*    */   public int activityid;
/*    */   public int floor;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCPlayFastKillReq(roleId, this.activityid, this.floor));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12617733;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPlayFastKillReq() {}
/*    */   
/*    */ 
/*    */   public CPlayFastKillReq(int _activityid_, int _floor_)
/*    */   {
/* 41 */     this.activityid = _activityid_;
/* 42 */     this.floor = _floor_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activityid);
/* 51 */     _os_.marshal(this.floor);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     this.floor = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CPlayFastKillReq)) {
/* 67 */       CPlayFastKillReq _o_ = (CPlayFastKillReq)_o1_;
/* 68 */       if (this.activityid != _o_.activityid) return false;
/* 69 */       if (this.floor != _o_.floor) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.activityid;
/* 78 */     _h_ += this.floor;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activityid).append(",");
/* 86 */     _sb_.append(this.floor).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPlayFastKillReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.activityid - _o_.activityid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.floor - _o_.floor;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\CPlayFastKillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */