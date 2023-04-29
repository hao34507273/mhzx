/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.PCGetRealtimeRecordReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRealtimeRecordReq
/*    */   extends __CGetRealtimeRecordReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594221;
/*    */   public long recordid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCGetRealtimeRecordReq(roleid, this.recordid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12594221;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRealtimeRecordReq() {}
/*    */   
/*    */ 
/*    */   public CGetRealtimeRecordReq(long _recordid_)
/*    */   {
/* 41 */     this.recordid = _recordid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.recordid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.recordid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGetRealtimeRecordReq)) {
/* 64 */       CGetRealtimeRecordReq _o_ = (CGetRealtimeRecordReq)_o1_;
/* 65 */       if (this.recordid != _o_.recordid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.recordid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.recordid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRealtimeRecordReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.recordid - _o_.recordid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CGetRealtimeRecordReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */