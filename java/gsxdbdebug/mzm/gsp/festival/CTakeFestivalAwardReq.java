/*    */ package mzm.gsp.festival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.festival.main.PCTakeFestivalAwardReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CTakeFestivalAwardReq
/*    */   extends __CTakeFestivalAwardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600065;
/*    */   public int festivalawardid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PCTakeFestivalAwardReq(roleid, this.festivalawardid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12600065;
/*    */   }
/*    */   
/*    */ 
/*    */   public CTakeFestivalAwardReq() {}
/*    */   
/*    */ 
/*    */   public CTakeFestivalAwardReq(int _festivalawardid_)
/*    */   {
/* 38 */     this.festivalawardid = _festivalawardid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.festivalawardid);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.festivalawardid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CTakeFestivalAwardReq)) {
/* 61 */       CTakeFestivalAwardReq _o_ = (CTakeFestivalAwardReq)_o1_;
/* 62 */       if (this.festivalawardid != _o_.festivalawardid) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.festivalawardid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.festivalawardid).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CTakeFestivalAwardReq _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.festivalawardid - _o_.festivalawardid;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\CTakeFestivalAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */