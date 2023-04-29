/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PStartBuildingLevelUpReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CStartBuildingLevelUpReq
/*    */   extends __CStartBuildingLevelUpReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589905;
/*    */   public int buildingtype;
/*    */   public long roleid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PStartBuildingLevelUpReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589905;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CStartBuildingLevelUpReq() {}
/*    */   
/*    */ 
/*    */   public CStartBuildingLevelUpReq(int _buildingtype_, long _roleid_)
/*    */   {
/* 37 */     this.buildingtype = _buildingtype_;
/* 38 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.buildingtype);
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.buildingtype = _os_.unmarshal_int();
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CStartBuildingLevelUpReq)) {
/* 63 */       CStartBuildingLevelUpReq _o_ = (CStartBuildingLevelUpReq)_o1_;
/* 64 */       if (this.buildingtype != _o_.buildingtype) return false;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.buildingtype;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.buildingtype).append(",");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CStartBuildingLevelUpReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.buildingtype - _o_.buildingtype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CStartBuildingLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */