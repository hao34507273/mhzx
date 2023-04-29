/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.apollo.main.PCApolloEnterGlobalLargeRoomReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CApolloEnterGlobalLargeRoomReq
/*    */   extends __CApolloEnterGlobalLargeRoomReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602631;
/*    */   public int room_type;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid == -1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCApolloEnterGlobalLargeRoomReq(roleid, this.room_type));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12602631;
/*    */   }
/*    */   
/*    */ 
/*    */   public CApolloEnterGlobalLargeRoomReq()
/*    */   {
/* 38 */     this.room_type = 1;
/*    */   }
/*    */   
/*    */   public CApolloEnterGlobalLargeRoomReq(int _room_type_) {
/* 42 */     this.room_type = _room_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.room_type);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.room_type = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CApolloEnterGlobalLargeRoomReq)) {
/* 65 */       CApolloEnterGlobalLargeRoomReq _o_ = (CApolloEnterGlobalLargeRoomReq)_o1_;
/* 66 */       if (this.room_type != _o_.room_type) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.room_type;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.room_type).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CApolloEnterGlobalLargeRoomReq _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = this.room_type - _o_.room_type;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\CApolloEnterGlobalLargeRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */