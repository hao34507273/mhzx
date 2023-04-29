/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PBuildingLevelUpDonateReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuildingLevelUpDonateReq
/*    */   extends __CBuildingLevelUpDonateReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589910;
/*    */   public int buildingtype;
/*    */   public int donatelv;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PBuildingLevelUpDonateReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589910;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuildingLevelUpDonateReq() {}
/*    */   
/*    */ 
/*    */   public CBuildingLevelUpDonateReq(int _buildingtype_, int _donatelv_)
/*    */   {
/* 37 */     this.buildingtype = _buildingtype_;
/* 38 */     this.donatelv = _donatelv_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.buildingtype);
/* 47 */     _os_.marshal(this.donatelv);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.buildingtype = _os_.unmarshal_int();
/* 53 */     this.donatelv = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CBuildingLevelUpDonateReq)) {
/* 63 */       CBuildingLevelUpDonateReq _o_ = (CBuildingLevelUpDonateReq)_o1_;
/* 64 */       if (this.buildingtype != _o_.buildingtype) return false;
/* 65 */       if (this.donatelv != _o_.donatelv) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.buildingtype;
/* 74 */     _h_ += this.donatelv;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.buildingtype).append(",");
/* 82 */     _sb_.append(this.donatelv).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuildingLevelUpDonateReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.buildingtype - _o_.buildingtype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.donatelv - _o_.donatelv;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CBuildingLevelUpDonateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */