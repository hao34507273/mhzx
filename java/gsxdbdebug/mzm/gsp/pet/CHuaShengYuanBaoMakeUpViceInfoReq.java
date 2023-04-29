/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PCHuaShengYuanBaoMakeUpViceInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CHuaShengYuanBaoMakeUpViceInfoReq
/*    */   extends __CHuaShengYuanBaoMakeUpViceInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590680;
/*    */   public long mainpetid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCHuaShengYuanBaoMakeUpViceInfoReq(roleId, this.mainpetid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12590680;
/*    */   }
/*    */   
/*    */ 
/*    */   public CHuaShengYuanBaoMakeUpViceInfoReq() {}
/*    */   
/*    */ 
/*    */   public CHuaShengYuanBaoMakeUpViceInfoReq(long _mainpetid_)
/*    */   {
/* 41 */     this.mainpetid = _mainpetid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.mainpetid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mainpetid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CHuaShengYuanBaoMakeUpViceInfoReq)) {
/* 64 */       CHuaShengYuanBaoMakeUpViceInfoReq _o_ = (CHuaShengYuanBaoMakeUpViceInfoReq)_o1_;
/* 65 */       if (this.mainpetid != _o_.mainpetid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.mainpetid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.mainpetid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CHuaShengYuanBaoMakeUpViceInfoReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.mainpetid - _o_.mainpetid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CHuaShengYuanBaoMakeUpViceInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */